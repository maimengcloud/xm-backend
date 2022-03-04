package com.xm.core.service;

import com.mdp.core.entity.Tips;
import com.mdp.core.service.BaseService;
import com.xm.core.entity.XmMenu;
import com.xm.core.entity.XmTask;
import com.xm.core.vo.XmIterationMenuVo;
import com.xm.core.vo.XmMenuVo;
import com.xm.core.vo.XmPhaseMenusVo;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	XmMenuStateService xmMenuStateService;

	/**
	 * 连同功能关联的项目需求计划数据一起带出
	 * @param xmMenu
	 * @return
	 */
	public List<Map<String, Object>> selectListMapByWhereWithPlan(Map<String, Object> xmMenu) {
		return this.selectList("selectListMapByWhereWithPlan", xmMenu);
	}
	/**
	 * 连同功能关联的状态数据一起带出
	 * @param xmMenu
	 * @return
	 */
	public List<Map<String, Object>> selectListMapByWhereWithState(Map<String, Object> xmMenu) {

		return this.selectList("selectListMapByWhereWithState", xmMenu);
	}

	/**
	 * 连同功能关联的产品计划一并带出
	 * @param xmMenu
	 * @return
	 */
	public List<Map<String, Object>> selectListMapByWhereWithPhase(Map<String, Object> xmMenu) {

		return this.selectList("selectListMapByWhereWithPhase", xmMenu);
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
		List<XmMenu> xmMenusDb=this.selectListByIds(xmMenus.stream().map(i->i.getMenuId()).collect(Collectors.toList()));
		editList=xmMenus.stream().filter(i->xmMenusDb.stream().filter(k->k.getMenuId().equals(i.getMenuId())).findAny().isPresent()).collect(Collectors.toList());
		addList=xmMenus.stream().filter(i->!xmMenusDb.stream().filter(k->k.getMenuId().equals(i.getMenuId())).findAny().isPresent()).collect(Collectors.toList());

		List<XmMenu> xmMenuList=new ArrayList<>();
		if(addList.size()>0) {
			xmMenuList.addAll(addList.stream().map(i->(XmMenu)i).collect(Collectors.toList()));
			this.batchInsert(addList);
 			this.xmMenuStateService.batchLoadXmMenuToState(xmMenus.get(0).getProductId());
		}
		if(editList.size()>0) {
			xmMenuList.addAll(editList.stream().map(i->(XmMenu)i).collect(Collectors.toList()));
			this.batchUpdate(editList);
		}
		if(xmMenuList.size()>0){
			this.xmMenuStateService.batchSumParents(xmMenuList);
		}
	}
	public List< Map<String, Object>> queryTaskUsersByMenuId(String menuId) {
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
				node.setPidPaths("0,"+node.getMenuId()+",");
				continue;
			}
			if(hadCalcMap.containsKey(node.getPmenuId())){
				String idPaths=hadCalcMap.get(node.getPmenuId());
				node.setPidPaths(idPaths+node.getMenuId()+",");
			}else{
				List<XmMenu> pnodeList=this.getParentList(node,nodes);
				if(pnodeList==null ||pnodeList.size()==0){
					node.setPidPaths("0,"+node.getMenuId()+",");
					node.setPmenuId(null);
					continue;
				}
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
		for (XmMenu node : nodes) {
			String idPaths=node.getPidPaths();
			String[] idpss=idPaths.split(",");
			node.setLvl(idpss.length-1);
		}
		return nodes;
	}

	public Tips parentIdPathsCalcBeforeSave(XmMenu currNode) {
		Tips tips = new Tips("成功");
		if (!StringUtils.hasText(currNode.getPmenuId()) || "0".equals(currNode.getPmenuId())) {
			currNode.setPidPaths("0," + currNode.getMenuId() + ",");
			currNode.setLvl(1);
			return tips;
		} else {
			List<XmMenu> parentList=this.getParentList(currNode);
			if(parentList==null || parentList.size()==0){
				currNode.setPidPaths("0,"+currNode.getMenuId()+",");
				currNode.setPmenuId(null);
				currNode.setLvl(1);
				return tips;
			}
			String idPath="0,";
			for (int i = parentList.size() - 1; i >= 0; i--) {
				idPath=idPath+parentList.get(i).getMenuId()+",";
			}
			currNode.setPidPaths(idPath+currNode.getMenuId()+",");

			String idPaths=currNode.getPidPaths();
			String[] idpss=idPaths.split(",");
			currNode.setLvl(idpss.length-1);
		}
		return tips;
	}

	private List<XmMenu> getParentList(XmMenu currNode){
		List<XmMenu> parentList=new ArrayList<>();
		XmMenu current=currNode;
		while (true){
			if(!StringUtils.hasText(current.getPmenuId()) || "0".equals(current.getPmenuId())||current.getMenuId().equals(current.getPmenuId())){
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
			if(!StringUtils.hasText(current.getPmenuId()) || "0".equals(current.getPmenuId())||current.getMenuId().equals(current.getPmenuId())){
				return parentList;
			}
			XmMenu query=new XmMenu();
			query.setMenuId(current.getPmenuId());
			Optional<XmMenu> optional=nodes.stream().filter(i->i.getMenuId().equals(query.getMenuId())).findFirst();
			if(optional.isPresent()){
				current=optional.get();
				parentList.add(current);
			}else{
				return parentList;
			}
		}
	}

    @Transactional
	public   int insert(XmMenu xmMenu) {
		int i= super.insert(xmMenu);
		xmMenuStateService.batchLoadXmMenuToState(xmMenu.getProductId());
		xmMenuStateService.sumParents(xmMenu);
		return i;
	}

	@Transactional
	public   int updateByPk(XmMenu xmMenu) {
		int i= super.updateByPk(xmMenu);
		return i;
	}

	@Transactional
	public void doBatchInsert(List<XmMenu> xmMenus) {
		super.batchInsert(xmMenus);
		this.xmMenuStateService.batchLoadXmMenuToState(xmMenus.get(0).getProductId());
		this.xmMenuStateService.batchSumParents(xmMenus);

	}

	@Transactional
	public void doBatchDelete(List<XmMenu> canDelList) {
		super.batchDelete(canDelList);
		this.xmMenuStateService.batchSumParents(canDelList);
	}
	@Transactional
	public void doBatchDeleteByProductIds(List<String> productIds) {
		super.delete("doBatchDeleteByProductIds",productIds);
	}


	/**
	 * 检查是否能删除干净所有儿子孙子节点。
	 * @param delNode 当前删除节点
	 * @param delNodes 本批量需要删除的全部节点
	 * @return
	 */
	public boolean checkCanDelAllChild(XmMenu delNode, List<XmMenu> delNodes) {
		if(delNode==null){
			return true;
		}
		if(delNode.getChildrenCnt()==null||delNode.getChildrenCnt()<=0){
			return true;
		}
		List<XmMenu> childList=delNodes.stream().filter(i->delNode.getMenuId().equals(i.getPmenuId())).collect(Collectors.toList());
		if(childList==null||childList.size()<delNode.getChildrenCnt()){
			return false;
		}
		for (XmMenu n : childList) {
			if (!this.checkCanDelAllChild(n, delNodes)) {
				return false;
			}
		}
		return true;

	}

	public List<XmMenu> selectListByIds(List<String> ids) {
		return super.selectList("selectListByIds",ids);
	}

    public void batchUnIteration(XmIterationMenuVo xmIterationMenus) {
		super.update("batchUnIteration",xmIterationMenus);
    }

	public void batchIteration(XmIterationMenuVo xmIterationMenus) {
		super.update("batchIteration",xmIterationMenus);
	}


	public void batchUnProductPhase(XmPhaseMenusVo xmPhaseMenusVo) {
		super.update("batchUnProductPhase",xmPhaseMenusVo);
	}

	public void batchProductPhase(XmPhaseMenusVo xmPhaseMenusVo) {
		super.update("batchProductPhase",xmPhaseMenusVo);
	}
}

