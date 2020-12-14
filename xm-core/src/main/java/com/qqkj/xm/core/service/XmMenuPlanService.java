package com.qqkj.xm.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;
import org.springframework.stereotype.Service;

import com.qqkj.mdp.core.entity.Tips;
import com.qqkj.mdp.core.service.BaseService;
import com.qqkj.mdp.safe.common.entity.User;
import com.qqkj.mdp.safe.common.utils.LoginUtils;
import com.qqkj.xm.core.entity.XmMenu;
import com.qqkj.xm.core.entity.XmMenuPlan;
/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmMenuPlan 表 XM.xm_menu_plan 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmMenuPlanService")
public class XmMenuPlanService extends BaseService {
	
	/** 请在此类添加自定义函数 */
	
	/**
	 * 根据前端手动选择的功能列表及项目，批量插入到功能计划表中，如果有重复则忽略
	 * @param projectId
	 * @param projectName
	 * @param menus
	 * @return
	 */
	public Tips batchAddPlanByProjectIdAndMenuList(String projectId,String projectName,List<XmMenu> menus){
		
		Tips tips =new Tips("批量新增成功");
		if(menus==null || menus.size()==0) {
			tips.setFailureMsg("功能列表不能为空");
			return tips;
		}
		if(StringUtils.isEmpty(projectId)) {
			tips.setFailureMsg("项目编号不能为空");
			return tips;
		}
		User user=LoginUtils.getCurrentUserInfo();
		XmMenuPlan queryPlan=new XmMenuPlan();
		queryPlan.setProjectId(projectId);
		Map<String,XmMenu> menusMap=new HashMap<>();
		
		
		Map<String,XmMenuPlan> plansMap=new HashMap<>();
		List<XmMenuPlan> dbMenuPlans=this.selectListByWhere(queryPlan);
		List<XmMenuPlan> addPlans=new ArrayList<>();
		for (XmMenuPlan xmMenuPlan : dbMenuPlans) {
			plansMap.put(xmMenuPlan.getMenuId(), xmMenuPlan);
		}
		
		for (XmMenu xmMenu : menus) {
			menusMap.put(xmMenu.getMenuId(), xmMenu);
			XmMenuPlan plan=plansMap.get(xmMenu.getMenuId());
			if(plan==null) {
				plan=new XmMenuPlan();
				plan.setProjectId(projectId);
				plan.setMenuId(xmMenu.getMenuId());
				plan.setMenuName(xmMenu.getMenuName());
				plan.setId(this.createKey("id"));
				plan.setPlanStartTime(new Date());
				plan.setCtime(new Date());
				plan.setLtime(new Date());
				plan.setCuserid(user.getUserid());
				plan.setCusername(user.getUsername()); 
				plan.setProjectName(projectName);
				addPlans.add(plan);
			}
		}
		this.batchInsert(addPlans);
		return tips;
		
	} 
	
	/**
	 * 计算bug、task、测试案例、等数据
	 * @param productId
	 * @return
	 */
	public int loadTasksToXmMenuPlan(String projectId) {
		 
		return this.update("loadTasksToXmMenuPlan", projectId);
	}
}

