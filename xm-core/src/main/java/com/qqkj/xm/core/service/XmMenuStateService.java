package com.qqkj.xm.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.qqkj.mdp.core.entity.Tips;
import com.qqkj.mdp.core.service.BaseService;
import com.qqkj.mdp.safe.common.entity.User;
import com.qqkj.mdp.safe.common.utils.LoginUtils;
import com.qqkj.xm.core.entity.XmMenu;
import com.qqkj.xm.core.entity.XmMenuState;
import com.qqkj.xm.core.entity.XmMenuState;
/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmMenuState 表 XM.xm_menu_state 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmMenuStateService")
public class XmMenuStateService extends BaseService {
	
	/** 请在此类添加自定义函数 */
	
	/**
	 * 根据前端手动选择的功能列表及项目，批量插入到功能计划表中，如果有重复则忽略
	 * @param productId
	 * @param productName
	 * @param menus
	 * @return
	 */
	public Tips batchAddStateByProductIdAndMenuList(String productId,String productName,List<XmMenu> menus){
		
		Tips tips =new Tips("批量新增成功");
		if(menus==null || menus.size()==0) {
			tips.setFailureMsg("功能列表不能为空");
			return tips;
		}
		if(StringUtils.isEmpty(productId)) {
			tips.setFailureMsg("项目编号不能为空");
			return tips;
		}
		User user=LoginUtils.getCurrentUserInfo();
		XmMenuState queryState=new XmMenuState();
		queryState.setProductId(productId);
		Map<String,XmMenu> menusMap=new HashMap<>();
		
		
		Map<String,XmMenuState> statesMap=new HashMap<>();
		List<XmMenuState> dbMenuStates=this.selectListByWhere(queryState);
		List<XmMenuState> addStates=new ArrayList<>();
		for (XmMenuState xmMenuState : dbMenuStates) {
			statesMap.put(xmMenuState.getMenuId(), xmMenuState);
		}
		
		for (XmMenu xmMenu : menus) {
			menusMap.put(xmMenu.getMenuId(), xmMenu);
			XmMenuState state=statesMap.get(xmMenu.getMenuId());
			if(state==null) {
				state=new XmMenuState();
				state.setProductId(productId);
				state.setMenuId(xmMenu.getMenuId());
				state.setMenuName(xmMenu.getMenuName());
				state.setId(this.createKey("id"));
				state.setPlanStartTime(new Date());
				state.setCtime(new Date());
				state.setLtime(new Date());
				state.setCuserid(user.getUserid());
				state.setCusername(user.getUsername()); 
				state.setProductName(productName);
				addStates.add(state);
			}
		}
		this.batchInsert(addStates);
		return tips;
		
	} 
	/**
	 * 计算bug、task、测试案例、等数据
	 * @param productId
	 * @return
	 */
	public int loadTasksToXmMenuState(String productId) {
		 
		return this.update("loadTasksToXmMenuState", productId);
	}
}

