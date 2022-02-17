package com.xm.core.service;

import com.mdp.core.service.BaseService;
import com.xm.core.entity.XmMenu;
import com.xm.core.vo.XmMenuVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
			this.batchInsert(addList);

			List<XmMenu> list= addList.stream().filter(i->!addList.stream().filter(k->k.getMenuId().equals(i.getPmenuId())).findAny().isPresent()).collect(Collectors.toList());
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

