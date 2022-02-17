package com.xm.core.service;

import com.mdp.core.entity.Tips;
import com.mdp.core.service.BaseService;
import com.xm.core.entity.XmMenu;
import com.xm.core.vo.XmMenuVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmMenu 表 XM.xm_menu 当前主键(包括多主键): menu_id; 
 ***/
@Service("xm.core.xmMenuService")
public class XmMenuService extends BaseService {

	/**
	 * 连同功能关联的计划数据一起带出
	 * @param xmMenu
	 * @return
	 */
	public List<Map<String, Object>> selectListMapByWhereWithPlan(Map<String, Object> xmMenu) {
		// TODO Auto-generated method stub
		return this.selectList("selectListMapByWhereWithPlan", xmMenu);
	}
	/**
	 * 连同功能关联的状态数据一起带出
	 * @param xmMenu
	 * @return
	 */
	public List<Map<String, Object>> selectListMapByWhereWithState(Map<String, Object> xmMenu) {
		// TODO Auto-generated method stub
		return this.selectList("selectListMapByWhereWithState", xmMenu);
	}


	public void updateMenuChildrenCntByMenuId(String menuId){
		super.update("updateMenuChildrenCntByMenuId",menuId);
	}
	public void updateChildrenCntByIds(List<String> ids) {
		super.update("updateChildrenCntByIds",ids);
	}
	@Transactional
	public void batchInsertOrUpdate(List<XmMenuVo> xmMenus) {
		List<XmMenuVo> addList=new ArrayList<>();
		List<XmMenuVo> editList=new ArrayList<>();
		for (XmMenuVo vo : xmMenus) {
			if("addSub".equals(vo.getOpType())||"add".equals(vo.getOpType())) {
				addList.add(vo);
			}else {
				editList.add(vo);
			}
		}
		if(addList.size()>0) {
			List<XmMenu> adds=this.parentIdPathsCalcBeforeSave(addList.stream().map(i->(XmMenu)i).collect(Collectors.toList()));
			this.batchInsert(adds);

			List<XmMenu> list= adds.stream().filter(i->!adds.stream().filter(k->k.getMenuId().equals(i.getPmenuId())).findAny().isPresent()).collect(Collectors.toList());
			list=list.stream().filter(i-> StringUtils.hasText(i.getPmenuId())).collect(Collectors.toList());
			if(list.size()>0){
				this.updateChildrenCntByIds(list.stream().map(i->i.getPmenuId()).collect(Collectors.toSet()).stream().collect(Collectors.toList()));
			}
		}
		if(editList.size()>0) {
			this.batchUpdate(editList);
		}
	}
	public List< Map<String, Object>> queryTaskUsersByMenuId(String menuId) {
		// TODO Auto-generated method stub
		return this.selectList("queryTaskUsersByMenuId", menuId);
	}

    public List<XmMenu> selectExistIterationMenus(List<String> menuIds) {

		return this.selectList("selectExistIterationMenus",map("menuIds",menuIds));
    }

	public List<XmMenu> parentIdPathsCalcBeforeSave(List<XmMenu> nodes) {
 		List<XmMenu> noExistsList=nodes.stream().filter(i->!nodes.stream().filter(k->k.getMenuId().equals(i.getPmenuId())).findAny().isPresent()).collect(Collectors.toList());
		noExistsList=noExistsList.stream().filter(i->StringUtils.hasText(i.getPmenuId())).collect(Collectors.toList());
 		Map<String,String> hadCalcMap=new HashMap<>();
		for (XmMenu node : noExistsList) {
			if(hadCalcMap.containsKey(node.getPmenuId())){
				String idPaths=hadCalcMap.get(node.getPmenuId());
				node.setPidPaths(idPaths+node.getMenuId()+",");
			}else{
				this.parentIdPathsCalcBeforeSave(node);
				String idPaths=node.getPidPaths();
				idPaths=idPaths.substring(0,idPaths.length()-node.getMenuId().length()-1);
				hadCalcMap.put(node.getPmenuId(),idPaths);
			}
		}
		for (XmMenu node : nodes) {
			if(!StringUtils.hasText(node.getPmenuId())){
				node.setPidPaths("0,");
				continue;
			}
			if(hadCalcMap.containsKey(node.getPmenuId())){
				String idPaths=hadCalcMap.get(node.getPmenuId());
				node.setPidPaths(idPaths+node.getMenuId()+",");
			}else{
				List<XmMenu> pnodeList=this.getParentList(node,nodes);
				XmMenu topParent=pnodeList.get(pnodeList.size()-1);
				String idPath="0,";
				if(hadCalcMap.containsKey(topParent.getPmenuId())){
					idPath=hadCalcMap.get(topParent.getPmenuId());
				}
				for (int i = pnodeList.size() - 1; i >= 0; i--) {
					idPath=idPath+pnodeList.get(i).getMenuId()+",";
				}
				node.setPidPaths(idPath+node.getMenuId()+",");
			}
		}
		return nodes;
	}

	public Tips parentIdPathsCalcBeforeSave(XmMenu currNode) {
		Tips tips = new Tips("成功");
		if (!StringUtils.hasText(currNode.getPmenuId()) || "0".equals(currNode.getPmenuId())) {
			currNode.setPidPaths("0," + currNode.getMenuId() + ",");
			return tips;
		} else {
			List<XmMenu> parentList=this.getParentList(currNode);
			String idPath="0,";
			for (int i = parentList.size() - 1; i >= 0; i--) {
				idPath=idPath+parentList.get(i).getMenuId()+",";
			}
			currNode.setPidPaths(idPath+currNode.getMenuId()+",");
		}
		return tips;
	}

	private List<XmMenu> getParentList(XmMenu currNode){
		List<XmMenu> parentList=new ArrayList<>();
		XmMenu current=currNode;
		while (true){
			if(!StringUtils.hasText(currNode.getPmenuId()) || "0".equals(currNode.getPmenuId())){
				return parentList;
			}
			XmMenu query=new XmMenu();
			query.setMenuId(current.getPmenuId());
			current=this.selectOneObject(query);
			if(current==null){
				return parentList;
			}
			parentList.add(current);
		}
	}

	private List<XmMenu> getParentList(XmMenu currNode,List<XmMenu> nodes){
		List<XmMenu> parentList=new ArrayList<>();
		XmMenu current=currNode;
		while (true){
			if(!StringUtils.hasText(currNode.getPmenuId()) || "0".equals(currNode.getPmenuId())){
				return parentList;
			}
			XmMenu query=new XmMenu();
			query.setMenuId(current.getPmenuId());
			current=nodes.stream().filter(i->i.getMenuId().equals(query.getMenuId())).findFirst().get();
			if(current==null){
				return parentList;
			}
			parentList.add(current);
		}
	}

    @Transactional
	public   int insert(XmMenu xmMenu) {
		int i= super.insert(xmMenu);
		if(StringUtils.hasText(xmMenu.getPmenuId())){
			this.updateMenuChildrenCntByMenuId(xmMenu.getPmenuId());
		}
		return i;
	}

	@Transactional
	public   int updateByPk(XmMenu xmMenu) {
		int i= super.updateByPk(xmMenu);

		if(StringUtils.hasText(xmMenu.getPmenuId())){
			this.updateMenuChildrenCntByMenuId(xmMenu.getPmenuId());
		}
		return i;
	}

	@Transactional
	public void doBatchInsert(List<XmMenu> xmMenus) {
		super.batchInsert(xmMenus);
		List<XmMenu> list= xmMenus.stream().filter(i->!xmMenus.stream().filter(k->k.getMenuId().equals(i.getPmenuId())).findAny().isPresent()).collect(Collectors.toList());
		list=list.stream().filter(i->StringUtils.hasText(i.getPmenuId())).collect(Collectors.toList());
		if(list.size()>0){
			this.updateChildrenCntByIds(list.stream().map(i->i.getPmenuId()).collect(Collectors.toSet()).stream().collect(Collectors.toList()));
		}
	}

	@Transactional
	public void doBatchDelete(List<XmMenu> canDelList) {
		super.batchDelete(canDelList);

		List<XmMenu> list= canDelList.stream().filter(i->!canDelList.stream().filter(k->k.getMenuId().equals(i.getPmenuId())).findAny().isPresent()).collect(Collectors.toList());
		list=list.stream().filter(i->StringUtils.hasText(i.getPmenuId())).collect(Collectors.toList());
		if(list.size()>0){
			this.updateChildrenCntByIds(list.stream().map(i->i.getPmenuId()).collect(Collectors.toSet()).stream().collect(Collectors.toList()));
		}
	}
}

