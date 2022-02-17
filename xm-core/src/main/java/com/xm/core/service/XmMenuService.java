package com.xm.core.service;

import com.mdp.core.service.BaseService;
import com.xm.core.entity.XmMenu;
import com.xm.core.vo.XmMenuVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
}

