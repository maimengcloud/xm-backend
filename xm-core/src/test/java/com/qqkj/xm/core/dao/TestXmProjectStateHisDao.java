package com.qqkj.xm.core.dao;

import java.util.*;
import java.text.SimpleDateFormat;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.qqkj.mdp.core.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired; 
import com.qqkj.mdp.core.dao.BaseDao;
import com.qqkj.mdp.core.context.ContextHolder;
import com.qqkj.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import com.qqkj.xm.core.entity.XmProjectStateHis;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmProjectStateHisDao的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_project_state_his 项目指标日统计表<br>
 * 实体 XmProjectStateHis<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	projectId,bizDate,totalFileCnt,totalBugCnt,totalTaskCnt,totalBudgetNouserAmount,projectName,id,totalStaffCnt,calcTime,calcStatus,totalCostNouserAmount,totalClosedBugCnt,totalResolvedBugCnt,totalCompleteTaskCnt,totalPhaseCnt,totalCompletePhaseCnt,totalNeedPayAmount,totalFinishPayAmount,totalNeedColAmount,totalFinishColAmount,totalCostUserAmount,totalBudgetInnerUserAmount,totalPlanWorkload,totalRiskCnt,totalCompleteRiskCnt,branchId,branchName,totalBudgetOutUserAmount,totalCompleteWorkload,totalCostInnerUserAmount,totalCostOutUserAmount,totalProgress,totalActiveBugCnt,totalConfirmedBugCnt,projectStatus,totalActWorkload,totalActOutWorkload,totalActInnerWorkload,totalTaskBudgetCostAt,totalTaskOutCnt,totalNeedPayCnt,totalFinishPayCnt,totalFinishPayUserCnt,totalNeedPayUserCnt,totalPlanInnerUserWorkload,totalPlanOutUserWorkload,testCases,execCases,designCases,finishCases,iterationCnt,productCnt,menuCnt;<br>
 * 当前表的所有字段名:<br>
 *	project_id,biz_date,total_file_cnt,total_bug_cnt,total_task_cnt,total_budget_nouser_amount,project_name,id,total_staff_cnt,calc_time,calc_status,total_cost_nouser_amount,total_closed_bug_cnt,total_resolved_bug_cnt,total_complete_task_cnt,total_phase_cnt,total_complete_phase_cnt,total_need_pay_amount,total_finish_pay_amount,total_need_col_amount,total_finish_col_amount,total_cost_user_amount,total_budget_inner_user_amount,total_plan_workload,total_risk_cnt,total_complete_risk_cnt,branch_id,branch_name,total_budget_out_user_amount,total_complete_workload,total_cost_inner_user_amount,total_cost_out_user_amount,total_progress,total_active_bug_cnt,total_confirmed_bug_cnt,project_status,total_act_workload,total_act_out_workload,total_act_inner_workload,total_task_budget_cost_at,total_task_out_cnt,total_need_pay_cnt,total_finish_pay_cnt,total_finish_pay_user_cnt,total_need_pay_user_cnt,total_plan_inner_user_workload,total_plan_out_user_workload,test_cases,exec_cases,design_cases,finish_cases,iteration_cnt,product_cnt,menu_cnt;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/
 @RunWith(SpringJUnit4ClassRunner.class)
 @SpringBootTest
public class TestXmProjectStateHisDao  {

	@Autowired
	BaseDao baseDao;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("projectId","yAe9","bizDate","vuIS","totalFileCnt",9821,"totalBugCnt",2939,"totalTaskCnt",8980,"totalBudgetNouserAmount",584.68,"projectName","nPT9","id","nZ84","totalStaffCnt",328,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","9","totalCostNouserAmount",4312.01,"totalClosedBugCnt",9724,"totalResolvedBugCnt",3695,"totalCompleteTaskCnt",3233,"totalPhaseCnt",219,"totalCompletePhaseCnt",6324,"totalNeedPayAmount",7409.83,"totalFinishPayAmount",2545.75,"totalNeedColAmount",1648.86,"totalFinishColAmount",5071.08,"totalCostUserAmount",2106.46,"totalBudgetInnerUserAmount",8479.47,"totalPlanWorkload",9943.39,"totalRiskCnt",5166,"totalCompleteRiskCnt",1618,"branchId","ICi1","branchName","xgh9","totalBudgetOutUserAmount",2679.32,"totalCompleteWorkload",1822.99,"totalCostInnerUserAmount",224.99,"totalCostOutUserAmount",3096.75,"totalProgress",7686.98,"totalActiveBugCnt",3341,"totalConfirmedBugCnt",9164,"projectStatus","pufi","totalActWorkload",1679.91,"totalActOutWorkload",2104,"totalActInnerWorkload",8027,"totalTaskBudgetCostAt",8868.89,"totalTaskOutCnt",5735,"totalNeedPayCnt",3369,"totalFinishPayCnt",8041,"totalFinishPayUserCnt",8182,"totalNeedPayUserCnt",5729,"totalPlanInnerUserWorkload",2366.25,"totalPlanOutUserWorkload",7677.67,"testCases",481,"execCases",527,"designCases",3173,"finishCases",2772,"iterationCnt",3180,"productCnt",6626,"menuCnt",7102);
		XmProjectStateHis xmProjectStateHis=BaseUtils.fromMap(p,XmProjectStateHis.class);
		baseDao.insert(xmProjectStateHis);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","yAe9","bizDate","vuIS","totalFileCnt",9821,"totalBugCnt",2939,"totalTaskCnt",8980,"totalBudgetNouserAmount",584.68,"projectName","nPT9","totalStaffCnt",328,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","9","totalCostNouserAmount",4312.01,"totalClosedBugCnt",9724,"totalResolvedBugCnt",3695,"totalCompleteTaskCnt",3233,"totalPhaseCnt",219,"totalCompletePhaseCnt",6324,"totalNeedPayAmount",7409.83,"totalFinishPayAmount",2545.75,"totalNeedColAmount",1648.86,"totalFinishColAmount",5071.08,"totalCostUserAmount",2106.46,"totalBudgetInnerUserAmount",8479.47,"totalPlanWorkload",9943.39,"totalRiskCnt",5166,"totalCompleteRiskCnt",1618,"branchId","ICi1","branchName","xgh9","totalBudgetOutUserAmount",2679.32,"totalCompleteWorkload",1822.99,"totalCostInnerUserAmount",224.99,"totalCostOutUserAmount",3096.75,"totalProgress",7686.98,"totalActiveBugCnt",3341,"totalConfirmedBugCnt",9164,"projectStatus","pufi","totalActWorkload",1679.91,"totalActOutWorkload",2104,"totalActInnerWorkload",8027,"totalTaskBudgetCostAt",8868.89,"totalTaskOutCnt",5735,"totalNeedPayCnt",3369,"totalFinishPayCnt",8041,"totalFinishPayUserCnt",8182,"totalNeedPayUserCnt",5729,"totalPlanInnerUserWorkload",2366.25,"totalPlanOutUserWorkload",7677.67,"testCases",481,"execCases",527,"designCases",3173,"finishCases",2772,"iterationCnt",3180,"productCnt",6626,"menuCnt",7102);
		XmProjectStateHis xmProjectStateHis=BaseUtils.fromMap(p,XmProjectStateHis.class);
		baseDao.deleteByWhere(xmProjectStateHis);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","nZ84");
		XmProjectStateHis xmProjectStateHis=BaseUtils.fromMap(p,XmProjectStateHis.class);
		baseDao.deleteByPk(xmProjectStateHis);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("projectId","yAe9","bizDate","vuIS","totalFileCnt",9821,"totalBugCnt",2939,"totalTaskCnt",8980,"totalBudgetNouserAmount",584.68,"projectName","nPT9","totalStaffCnt",328,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","9","totalCostNouserAmount",4312.01,"totalClosedBugCnt",9724,"totalResolvedBugCnt",3695,"totalCompleteTaskCnt",3233,"totalPhaseCnt",219,"totalCompletePhaseCnt",6324,"totalNeedPayAmount",7409.83,"totalFinishPayAmount",2545.75,"totalNeedColAmount",1648.86,"totalFinishColAmount",5071.08,"totalCostUserAmount",2106.46,"totalBudgetInnerUserAmount",8479.47,"totalPlanWorkload",9943.39,"totalRiskCnt",5166,"totalCompleteRiskCnt",1618,"branchId","ICi1","branchName","xgh9","totalBudgetOutUserAmount",2679.32,"totalCompleteWorkload",1822.99,"totalCostInnerUserAmount",224.99,"totalCostOutUserAmount",3096.75,"totalProgress",7686.98,"totalActiveBugCnt",3341,"totalConfirmedBugCnt",9164,"projectStatus","pufi","totalActWorkload",1679.91,"totalActOutWorkload",2104,"totalActInnerWorkload",8027,"totalTaskBudgetCostAt",8868.89,"totalTaskOutCnt",5735,"totalNeedPayCnt",3369,"totalFinishPayCnt",8041,"totalFinishPayUserCnt",8182,"totalNeedPayUserCnt",5729,"totalPlanInnerUserWorkload",2366.25,"totalPlanOutUserWorkload",7677.67,"testCases",481,"execCases",527,"designCases",3173,"finishCases",2772,"iterationCnt",3180,"productCnt",6626,"menuCnt",7102);
		XmProjectStateHis xmProjectStateHis=BaseUtils.fromMap(where,XmProjectStateHis.class);
		baseDao.updateSomeFieldByPk(xmProjectStateHis);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","nZ84");
		XmProjectStateHis xmProjectStateHis=BaseUtils.fromMap(p,XmProjectStateHis.class);
		baseDao.updateByPk(xmProjectStateHis);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("projectId","yAe9","bizDate","vuIS","totalFileCnt",9821,"totalBugCnt",2939,"totalTaskCnt",8980,"totalBudgetNouserAmount",584.68,"projectName","nPT9","id","nZ84","totalStaffCnt",328,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","9","totalCostNouserAmount",4312.01,"totalClosedBugCnt",9724,"totalResolvedBugCnt",3695,"totalCompleteTaskCnt",3233,"totalPhaseCnt",219,"totalCompletePhaseCnt",6324,"totalNeedPayAmount",7409.83,"totalFinishPayAmount",2545.75,"totalNeedColAmount",1648.86,"totalFinishColAmount",5071.08,"totalCostUserAmount",2106.46,"totalBudgetInnerUserAmount",8479.47,"totalPlanWorkload",9943.39,"totalRiskCnt",5166,"totalCompleteRiskCnt",1618,"branchId","ICi1","branchName","xgh9","totalBudgetOutUserAmount",2679.32,"totalCompleteWorkload",1822.99,"totalCostInnerUserAmount",224.99,"totalCostOutUserAmount",3096.75,"totalProgress",7686.98,"totalActiveBugCnt",3341,"totalConfirmedBugCnt",9164,"projectStatus","pufi","totalActWorkload",1679.91,"totalActOutWorkload",2104,"totalActInnerWorkload",8027,"totalTaskBudgetCostAt",8868.89,"totalTaskOutCnt",5735,"totalNeedPayCnt",3369,"totalFinishPayCnt",8041,"totalFinishPayUserCnt",8182,"totalNeedPayUserCnt",5729,"totalPlanInnerUserWorkload",2366.25,"totalPlanOutUserWorkload",7677.67,"testCases",481,"execCases",527,"designCases",3173,"finishCases",2772,"iterationCnt",3180,"productCnt",6626,"menuCnt",7102);
		XmProjectStateHis xmProjectStateHis=BaseUtils.fromMap(p,XmProjectStateHis.class);
		baseDao.insertOrUpdate(xmProjectStateHis);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmProjectStateHis> batchValues=new ArrayList<XmProjectStateHis>();
		Map p0=BaseUtils.map("projectId","yAe9","bizDate","vuIS","totalFileCnt",9821,"totalBugCnt",2939,"totalTaskCnt",8980,"totalBudgetNouserAmount",584.68,"projectName","nPT9","id","nZ84","totalStaffCnt",328,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","9","totalCostNouserAmount",4312.01,"totalClosedBugCnt",9724,"totalResolvedBugCnt",3695,"totalCompleteTaskCnt",3233,"totalPhaseCnt",219,"totalCompletePhaseCnt",6324,"totalNeedPayAmount",7409.83,"totalFinishPayAmount",2545.75,"totalNeedColAmount",1648.86,"totalFinishColAmount",5071.08,"totalCostUserAmount",2106.46,"totalBudgetInnerUserAmount",8479.47,"totalPlanWorkload",9943.39,"totalRiskCnt",5166,"totalCompleteRiskCnt",1618,"branchId","ICi1","branchName","xgh9","totalBudgetOutUserAmount",2679.32,"totalCompleteWorkload",1822.99,"totalCostInnerUserAmount",224.99,"totalCostOutUserAmount",3096.75,"totalProgress",7686.98,"totalActiveBugCnt",3341,"totalConfirmedBugCnt",9164,"projectStatus","pufi","totalActWorkload",1679.91,"totalActOutWorkload",2104,"totalActInnerWorkload",8027,"totalTaskBudgetCostAt",8868.89,"totalTaskOutCnt",5735,"totalNeedPayCnt",3369,"totalFinishPayCnt",8041,"totalFinishPayUserCnt",8182,"totalNeedPayUserCnt",5729,"totalPlanInnerUserWorkload",2366.25,"totalPlanOutUserWorkload",7677.67,"testCases",481,"execCases",527,"designCases",3173,"finishCases",2772,"iterationCnt",3180,"productCnt",6626,"menuCnt",7102);
		XmProjectStateHis xmProjectStateHis0=BaseUtils.fromMap(p0,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis0);
		Map p1=BaseUtils.map("projectId","K7e4","bizDate","4cm9","totalFileCnt",4483,"totalBugCnt",1881,"totalTaskCnt",5451,"totalBudgetNouserAmount",6578.01,"projectName","f4Y5","id","Wxzk","totalStaffCnt",9893,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","2","totalCostNouserAmount",4685.01,"totalClosedBugCnt",4826,"totalResolvedBugCnt",1943,"totalCompleteTaskCnt",2620,"totalPhaseCnt",3286,"totalCompletePhaseCnt",4869,"totalNeedPayAmount",7059.71,"totalFinishPayAmount",8617.08,"totalNeedColAmount",8146.94,"totalFinishColAmount",107.29,"totalCostUserAmount",2248.81,"totalBudgetInnerUserAmount",8328.71,"totalPlanWorkload",5845.96,"totalRiskCnt",4874,"totalCompleteRiskCnt",7253,"branchId","QcwR","branchName","tKUe","totalBudgetOutUserAmount",8922.6,"totalCompleteWorkload",6694.04,"totalCostInnerUserAmount",109.61,"totalCostOutUserAmount",8719.27,"totalProgress",7816.05,"totalActiveBugCnt",7792,"totalConfirmedBugCnt",5950,"projectStatus","j9t6","totalActWorkload",5557.76,"totalActOutWorkload",6164,"totalActInnerWorkload",2427,"totalTaskBudgetCostAt",7463.47,"totalTaskOutCnt",2316,"totalNeedPayCnt",5772,"totalFinishPayCnt",3868,"totalFinishPayUserCnt",4142,"totalNeedPayUserCnt",9716,"totalPlanInnerUserWorkload",2046.68,"totalPlanOutUserWorkload",4654.84,"testCases",1209,"execCases",9233,"designCases",5297,"finishCases",6581,"iterationCnt",4108,"productCnt",5396,"menuCnt",8764);
		XmProjectStateHis xmProjectStateHis1=BaseUtils.fromMap(p1,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis1);
		Map p2=BaseUtils.map("projectId","liyW","bizDate","TDGV","totalFileCnt",4048,"totalBugCnt",2092,"totalTaskCnt",7688,"totalBudgetNouserAmount",2585.94,"projectName","eb4X","id","RB4u","totalStaffCnt",686,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","s","totalCostNouserAmount",4462.82,"totalClosedBugCnt",6504,"totalResolvedBugCnt",8579,"totalCompleteTaskCnt",7135,"totalPhaseCnt",4455,"totalCompletePhaseCnt",161,"totalNeedPayAmount",8523.86,"totalFinishPayAmount",5122,"totalNeedColAmount",7586.67,"totalFinishColAmount",9834.52,"totalCostUserAmount",2113.92,"totalBudgetInnerUserAmount",9592.95,"totalPlanWorkload",8375.33,"totalRiskCnt",5269,"totalCompleteRiskCnt",8735,"branchId","irN2","branchName","nkVo","totalBudgetOutUserAmount",9405.69,"totalCompleteWorkload",4914.77,"totalCostInnerUserAmount",199.87,"totalCostOutUserAmount",9680.96,"totalProgress",4727.75,"totalActiveBugCnt",6953,"totalConfirmedBugCnt",2484,"projectStatus","U35y","totalActWorkload",3160.19,"totalActOutWorkload",4356,"totalActInnerWorkload",5518,"totalTaskBudgetCostAt",6080.48,"totalTaskOutCnt",8768,"totalNeedPayCnt",2302,"totalFinishPayCnt",6961,"totalFinishPayUserCnt",8121,"totalNeedPayUserCnt",6040,"totalPlanInnerUserWorkload",7932.94,"totalPlanOutUserWorkload",3604.02,"testCases",2162,"execCases",7666,"designCases",1283,"finishCases",7501,"iterationCnt",4628,"productCnt",9223,"menuCnt",1325);
		XmProjectStateHis xmProjectStateHis2=BaseUtils.fromMap(p2,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis2);
		Map p3=BaseUtils.map("projectId","CWvE","bizDate","wn8a","totalFileCnt",4295,"totalBugCnt",983,"totalTaskCnt",128,"totalBudgetNouserAmount",1399.91,"projectName","gU47","id","R7vb","totalStaffCnt",9553,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","x","totalCostNouserAmount",8496.62,"totalClosedBugCnt",2084,"totalResolvedBugCnt",7703,"totalCompleteTaskCnt",7978,"totalPhaseCnt",7853,"totalCompletePhaseCnt",4067,"totalNeedPayAmount",1512.49,"totalFinishPayAmount",1980.77,"totalNeedColAmount",4010.32,"totalFinishColAmount",3258.43,"totalCostUserAmount",8093.47,"totalBudgetInnerUserAmount",8299.92,"totalPlanWorkload",9185.93,"totalRiskCnt",7072,"totalCompleteRiskCnt",9339,"branchId","4RX0","branchName","XbTT","totalBudgetOutUserAmount",2158.77,"totalCompleteWorkload",4757.42,"totalCostInnerUserAmount",2769.07,"totalCostOutUserAmount",6316.77,"totalProgress",8395.71,"totalActiveBugCnt",5929,"totalConfirmedBugCnt",6982,"projectStatus","Jj98","totalActWorkload",5953.06,"totalActOutWorkload",4834,"totalActInnerWorkload",3800,"totalTaskBudgetCostAt",3465.36,"totalTaskOutCnt",7854,"totalNeedPayCnt",4996,"totalFinishPayCnt",9312,"totalFinishPayUserCnt",3590,"totalNeedPayUserCnt",6128,"totalPlanInnerUserWorkload",5696.88,"totalPlanOutUserWorkload",1819.96,"testCases",1948,"execCases",85,"designCases",9088,"finishCases",8034,"iterationCnt",9583,"productCnt",8585,"menuCnt",9119);
		XmProjectStateHis xmProjectStateHis3=BaseUtils.fromMap(p3,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis3);
		Map p4=BaseUtils.map("projectId","Mmq5","bizDate","sBVe","totalFileCnt",9952,"totalBugCnt",686,"totalTaskCnt",4043,"totalBudgetNouserAmount",3776.98,"projectName","HSis","id","33Ku","totalStaffCnt",615,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","t","totalCostNouserAmount",8754.64,"totalClosedBugCnt",8557,"totalResolvedBugCnt",6462,"totalCompleteTaskCnt",1766,"totalPhaseCnt",9114,"totalCompletePhaseCnt",4142,"totalNeedPayAmount",4886.33,"totalFinishPayAmount",379.02,"totalNeedColAmount",7293.99,"totalFinishColAmount",8536.53,"totalCostUserAmount",7748.52,"totalBudgetInnerUserAmount",2977.66,"totalPlanWorkload",872.1,"totalRiskCnt",1036,"totalCompleteRiskCnt",9828,"branchId","dC3Y","branchName","fC4n","totalBudgetOutUserAmount",6977.4,"totalCompleteWorkload",7656.81,"totalCostInnerUserAmount",8362.23,"totalCostOutUserAmount",7620.36,"totalProgress",6002.46,"totalActiveBugCnt",2577,"totalConfirmedBugCnt",3972,"projectStatus","hH72","totalActWorkload",6628.47,"totalActOutWorkload",8878,"totalActInnerWorkload",7329,"totalTaskBudgetCostAt",5721.69,"totalTaskOutCnt",8224,"totalNeedPayCnt",9597,"totalFinishPayCnt",4775,"totalFinishPayUserCnt",8693,"totalNeedPayUserCnt",4565,"totalPlanInnerUserWorkload",2671.48,"totalPlanOutUserWorkload",4150.9,"testCases",5356,"execCases",1777,"designCases",927,"finishCases",8384,"iterationCnt",2462,"productCnt",7629,"menuCnt",7439);
		XmProjectStateHis xmProjectStateHis4=BaseUtils.fromMap(p4,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis4);
		Map p5=BaseUtils.map("projectId","7hRu","bizDate","a1bs","totalFileCnt",9219,"totalBugCnt",7019,"totalTaskCnt",1740,"totalBudgetNouserAmount",9137.2,"projectName","7IEa","id","KeYg","totalStaffCnt",8755,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","V","totalCostNouserAmount",3124.13,"totalClosedBugCnt",6935,"totalResolvedBugCnt",6549,"totalCompleteTaskCnt",7501,"totalPhaseCnt",2563,"totalCompletePhaseCnt",4992,"totalNeedPayAmount",4730.38,"totalFinishPayAmount",2309.42,"totalNeedColAmount",8714.05,"totalFinishColAmount",6669.66,"totalCostUserAmount",3671.51,"totalBudgetInnerUserAmount",6558.68,"totalPlanWorkload",1262.8,"totalRiskCnt",40,"totalCompleteRiskCnt",2860,"branchId","aTGH","branchName","5c4Q","totalBudgetOutUserAmount",9938.47,"totalCompleteWorkload",2698.16,"totalCostInnerUserAmount",4342.54,"totalCostOutUserAmount",1359.02,"totalProgress",3973.35,"totalActiveBugCnt",7530,"totalConfirmedBugCnt",4610,"projectStatus","cem6","totalActWorkload",2672.38,"totalActOutWorkload",4016,"totalActInnerWorkload",9420,"totalTaskBudgetCostAt",7558.18,"totalTaskOutCnt",6110,"totalNeedPayCnt",8317,"totalFinishPayCnt",5613,"totalFinishPayUserCnt",9922,"totalNeedPayUserCnt",9810,"totalPlanInnerUserWorkload",5854.38,"totalPlanOutUserWorkload",240.34,"testCases",4820,"execCases",2789,"designCases",5879,"finishCases",1766,"iterationCnt",2240,"productCnt",7024,"menuCnt",194);
		XmProjectStateHis xmProjectStateHis5=BaseUtils.fromMap(p5,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis5);
		Map p6=BaseUtils.map("projectId","CIJj","bizDate","SFnw","totalFileCnt",7720,"totalBugCnt",9430,"totalTaskCnt",1952,"totalBudgetNouserAmount",7473.74,"projectName","37v6","id","g3SL","totalStaffCnt",9535,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","S","totalCostNouserAmount",5239.51,"totalClosedBugCnt",7467,"totalResolvedBugCnt",774,"totalCompleteTaskCnt",1977,"totalPhaseCnt",1651,"totalCompletePhaseCnt",5432,"totalNeedPayAmount",7406.01,"totalFinishPayAmount",6451.74,"totalNeedColAmount",2333.95,"totalFinishColAmount",3755.2,"totalCostUserAmount",4988.8,"totalBudgetInnerUserAmount",6004.86,"totalPlanWorkload",6494.94,"totalRiskCnt",6084,"totalCompleteRiskCnt",9977,"branchId","N2ae","branchName","GyTv","totalBudgetOutUserAmount",2992.9,"totalCompleteWorkload",7999.23,"totalCostInnerUserAmount",2250.91,"totalCostOutUserAmount",8675.69,"totalProgress",1504.47,"totalActiveBugCnt",7400,"totalConfirmedBugCnt",8344,"projectStatus","Mvkn","totalActWorkload",316.44,"totalActOutWorkload",2361,"totalActInnerWorkload",5090,"totalTaskBudgetCostAt",9566.14,"totalTaskOutCnt",4544,"totalNeedPayCnt",2335,"totalFinishPayCnt",9939,"totalFinishPayUserCnt",9417,"totalNeedPayUserCnt",6823,"totalPlanInnerUserWorkload",3255.32,"totalPlanOutUserWorkload",2371.8,"testCases",7251,"execCases",9400,"designCases",1736,"finishCases",2465,"iterationCnt",5938,"productCnt",4576,"menuCnt",4751);
		XmProjectStateHis xmProjectStateHis6=BaseUtils.fromMap(p6,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis6);
		Map p7=BaseUtils.map("projectId","184d","bizDate","bvES","totalFileCnt",1694,"totalBugCnt",9492,"totalTaskCnt",5883,"totalBudgetNouserAmount",8547.6,"projectName","a3FK","id","j9ea","totalStaffCnt",8688,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","y","totalCostNouserAmount",7496.84,"totalClosedBugCnt",2321,"totalResolvedBugCnt",9922,"totalCompleteTaskCnt",324,"totalPhaseCnt",976,"totalCompletePhaseCnt",9755,"totalNeedPayAmount",5135.98,"totalFinishPayAmount",6188.82,"totalNeedColAmount",4499.1,"totalFinishColAmount",9292.22,"totalCostUserAmount",4207.92,"totalBudgetInnerUserAmount",5004.83,"totalPlanWorkload",7231.94,"totalRiskCnt",5677,"totalCompleteRiskCnt",8469,"branchId","wY2J","branchName","T8sg","totalBudgetOutUserAmount",33.29,"totalCompleteWorkload",821.38,"totalCostInnerUserAmount",7691.32,"totalCostOutUserAmount",9393.69,"totalProgress",2466.28,"totalActiveBugCnt",5978,"totalConfirmedBugCnt",4147,"projectStatus","38Dq","totalActWorkload",9840.12,"totalActOutWorkload",6100,"totalActInnerWorkload",5437,"totalTaskBudgetCostAt",2852.44,"totalTaskOutCnt",9891,"totalNeedPayCnt",3858,"totalFinishPayCnt",8253,"totalFinishPayUserCnt",1355,"totalNeedPayUserCnt",4026,"totalPlanInnerUserWorkload",5481.1,"totalPlanOutUserWorkload",1.62,"testCases",5504,"execCases",7897,"designCases",5650,"finishCases",2534,"iterationCnt",3879,"productCnt",6119,"menuCnt",3659);
		XmProjectStateHis xmProjectStateHis7=BaseUtils.fromMap(p7,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis7);
		baseDao.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmProjectStateHis> batchValues=new ArrayList<XmProjectStateHis>();
		Map p0=BaseUtils.map("projectId","yAe9","bizDate","vuIS","totalFileCnt",9821,"totalBugCnt",2939,"totalTaskCnt",8980,"totalBudgetNouserAmount",584.68,"projectName","nPT9","id","nZ84","totalStaffCnt",328,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","9","totalCostNouserAmount",4312.01,"totalClosedBugCnt",9724,"totalResolvedBugCnt",3695,"totalCompleteTaskCnt",3233,"totalPhaseCnt",219,"totalCompletePhaseCnt",6324,"totalNeedPayAmount",7409.83,"totalFinishPayAmount",2545.75,"totalNeedColAmount",1648.86,"totalFinishColAmount",5071.08,"totalCostUserAmount",2106.46,"totalBudgetInnerUserAmount",8479.47,"totalPlanWorkload",9943.39,"totalRiskCnt",5166,"totalCompleteRiskCnt",1618,"branchId","ICi1","branchName","xgh9","totalBudgetOutUserAmount",2679.32,"totalCompleteWorkload",1822.99,"totalCostInnerUserAmount",224.99,"totalCostOutUserAmount",3096.75,"totalProgress",7686.98,"totalActiveBugCnt",3341,"totalConfirmedBugCnt",9164,"projectStatus","pufi","totalActWorkload",1679.91,"totalActOutWorkload",2104,"totalActInnerWorkload",8027,"totalTaskBudgetCostAt",8868.89,"totalTaskOutCnt",5735,"totalNeedPayCnt",3369,"totalFinishPayCnt",8041,"totalFinishPayUserCnt",8182,"totalNeedPayUserCnt",5729,"totalPlanInnerUserWorkload",2366.25,"totalPlanOutUserWorkload",7677.67,"testCases",481,"execCases",527,"designCases",3173,"finishCases",2772,"iterationCnt",3180,"productCnt",6626,"menuCnt",7102);
		XmProjectStateHis xmProjectStateHis0=BaseUtils.fromMap(p0,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis0);
		Map p1=BaseUtils.map("projectId","K7e4","bizDate","4cm9","totalFileCnt",4483,"totalBugCnt",1881,"totalTaskCnt",5451,"totalBudgetNouserAmount",6578.01,"projectName","f4Y5","id","Wxzk","totalStaffCnt",9893,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","2","totalCostNouserAmount",4685.01,"totalClosedBugCnt",4826,"totalResolvedBugCnt",1943,"totalCompleteTaskCnt",2620,"totalPhaseCnt",3286,"totalCompletePhaseCnt",4869,"totalNeedPayAmount",7059.71,"totalFinishPayAmount",8617.08,"totalNeedColAmount",8146.94,"totalFinishColAmount",107.29,"totalCostUserAmount",2248.81,"totalBudgetInnerUserAmount",8328.71,"totalPlanWorkload",5845.96,"totalRiskCnt",4874,"totalCompleteRiskCnt",7253,"branchId","QcwR","branchName","tKUe","totalBudgetOutUserAmount",8922.6,"totalCompleteWorkload",6694.04,"totalCostInnerUserAmount",109.61,"totalCostOutUserAmount",8719.27,"totalProgress",7816.05,"totalActiveBugCnt",7792,"totalConfirmedBugCnt",5950,"projectStatus","j9t6","totalActWorkload",5557.76,"totalActOutWorkload",6164,"totalActInnerWorkload",2427,"totalTaskBudgetCostAt",7463.47,"totalTaskOutCnt",2316,"totalNeedPayCnt",5772,"totalFinishPayCnt",3868,"totalFinishPayUserCnt",4142,"totalNeedPayUserCnt",9716,"totalPlanInnerUserWorkload",2046.68,"totalPlanOutUserWorkload",4654.84,"testCases",1209,"execCases",9233,"designCases",5297,"finishCases",6581,"iterationCnt",4108,"productCnt",5396,"menuCnt",8764);
		XmProjectStateHis xmProjectStateHis1=BaseUtils.fromMap(p1,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis1);
		Map p2=BaseUtils.map("projectId","liyW","bizDate","TDGV","totalFileCnt",4048,"totalBugCnt",2092,"totalTaskCnt",7688,"totalBudgetNouserAmount",2585.94,"projectName","eb4X","id","RB4u","totalStaffCnt",686,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","s","totalCostNouserAmount",4462.82,"totalClosedBugCnt",6504,"totalResolvedBugCnt",8579,"totalCompleteTaskCnt",7135,"totalPhaseCnt",4455,"totalCompletePhaseCnt",161,"totalNeedPayAmount",8523.86,"totalFinishPayAmount",5122,"totalNeedColAmount",7586.67,"totalFinishColAmount",9834.52,"totalCostUserAmount",2113.92,"totalBudgetInnerUserAmount",9592.95,"totalPlanWorkload",8375.33,"totalRiskCnt",5269,"totalCompleteRiskCnt",8735,"branchId","irN2","branchName","nkVo","totalBudgetOutUserAmount",9405.69,"totalCompleteWorkload",4914.77,"totalCostInnerUserAmount",199.87,"totalCostOutUserAmount",9680.96,"totalProgress",4727.75,"totalActiveBugCnt",6953,"totalConfirmedBugCnt",2484,"projectStatus","U35y","totalActWorkload",3160.19,"totalActOutWorkload",4356,"totalActInnerWorkload",5518,"totalTaskBudgetCostAt",6080.48,"totalTaskOutCnt",8768,"totalNeedPayCnt",2302,"totalFinishPayCnt",6961,"totalFinishPayUserCnt",8121,"totalNeedPayUserCnt",6040,"totalPlanInnerUserWorkload",7932.94,"totalPlanOutUserWorkload",3604.02,"testCases",2162,"execCases",7666,"designCases",1283,"finishCases",7501,"iterationCnt",4628,"productCnt",9223,"menuCnt",1325);
		XmProjectStateHis xmProjectStateHis2=BaseUtils.fromMap(p2,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis2);
		Map p3=BaseUtils.map("projectId","CWvE","bizDate","wn8a","totalFileCnt",4295,"totalBugCnt",983,"totalTaskCnt",128,"totalBudgetNouserAmount",1399.91,"projectName","gU47","id","R7vb","totalStaffCnt",9553,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","x","totalCostNouserAmount",8496.62,"totalClosedBugCnt",2084,"totalResolvedBugCnt",7703,"totalCompleteTaskCnt",7978,"totalPhaseCnt",7853,"totalCompletePhaseCnt",4067,"totalNeedPayAmount",1512.49,"totalFinishPayAmount",1980.77,"totalNeedColAmount",4010.32,"totalFinishColAmount",3258.43,"totalCostUserAmount",8093.47,"totalBudgetInnerUserAmount",8299.92,"totalPlanWorkload",9185.93,"totalRiskCnt",7072,"totalCompleteRiskCnt",9339,"branchId","4RX0","branchName","XbTT","totalBudgetOutUserAmount",2158.77,"totalCompleteWorkload",4757.42,"totalCostInnerUserAmount",2769.07,"totalCostOutUserAmount",6316.77,"totalProgress",8395.71,"totalActiveBugCnt",5929,"totalConfirmedBugCnt",6982,"projectStatus","Jj98","totalActWorkload",5953.06,"totalActOutWorkload",4834,"totalActInnerWorkload",3800,"totalTaskBudgetCostAt",3465.36,"totalTaskOutCnt",7854,"totalNeedPayCnt",4996,"totalFinishPayCnt",9312,"totalFinishPayUserCnt",3590,"totalNeedPayUserCnt",6128,"totalPlanInnerUserWorkload",5696.88,"totalPlanOutUserWorkload",1819.96,"testCases",1948,"execCases",85,"designCases",9088,"finishCases",8034,"iterationCnt",9583,"productCnt",8585,"menuCnt",9119);
		XmProjectStateHis xmProjectStateHis3=BaseUtils.fromMap(p3,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis3);
		Map p4=BaseUtils.map("projectId","Mmq5","bizDate","sBVe","totalFileCnt",9952,"totalBugCnt",686,"totalTaskCnt",4043,"totalBudgetNouserAmount",3776.98,"projectName","HSis","id","33Ku","totalStaffCnt",615,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","t","totalCostNouserAmount",8754.64,"totalClosedBugCnt",8557,"totalResolvedBugCnt",6462,"totalCompleteTaskCnt",1766,"totalPhaseCnt",9114,"totalCompletePhaseCnt",4142,"totalNeedPayAmount",4886.33,"totalFinishPayAmount",379.02,"totalNeedColAmount",7293.99,"totalFinishColAmount",8536.53,"totalCostUserAmount",7748.52,"totalBudgetInnerUserAmount",2977.66,"totalPlanWorkload",872.1,"totalRiskCnt",1036,"totalCompleteRiskCnt",9828,"branchId","dC3Y","branchName","fC4n","totalBudgetOutUserAmount",6977.4,"totalCompleteWorkload",7656.81,"totalCostInnerUserAmount",8362.23,"totalCostOutUserAmount",7620.36,"totalProgress",6002.46,"totalActiveBugCnt",2577,"totalConfirmedBugCnt",3972,"projectStatus","hH72","totalActWorkload",6628.47,"totalActOutWorkload",8878,"totalActInnerWorkload",7329,"totalTaskBudgetCostAt",5721.69,"totalTaskOutCnt",8224,"totalNeedPayCnt",9597,"totalFinishPayCnt",4775,"totalFinishPayUserCnt",8693,"totalNeedPayUserCnt",4565,"totalPlanInnerUserWorkload",2671.48,"totalPlanOutUserWorkload",4150.9,"testCases",5356,"execCases",1777,"designCases",927,"finishCases",8384,"iterationCnt",2462,"productCnt",7629,"menuCnt",7439);
		XmProjectStateHis xmProjectStateHis4=BaseUtils.fromMap(p4,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis4);
		Map p5=BaseUtils.map("projectId","7hRu","bizDate","a1bs","totalFileCnt",9219,"totalBugCnt",7019,"totalTaskCnt",1740,"totalBudgetNouserAmount",9137.2,"projectName","7IEa","id","KeYg","totalStaffCnt",8755,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","V","totalCostNouserAmount",3124.13,"totalClosedBugCnt",6935,"totalResolvedBugCnt",6549,"totalCompleteTaskCnt",7501,"totalPhaseCnt",2563,"totalCompletePhaseCnt",4992,"totalNeedPayAmount",4730.38,"totalFinishPayAmount",2309.42,"totalNeedColAmount",8714.05,"totalFinishColAmount",6669.66,"totalCostUserAmount",3671.51,"totalBudgetInnerUserAmount",6558.68,"totalPlanWorkload",1262.8,"totalRiskCnt",40,"totalCompleteRiskCnt",2860,"branchId","aTGH","branchName","5c4Q","totalBudgetOutUserAmount",9938.47,"totalCompleteWorkload",2698.16,"totalCostInnerUserAmount",4342.54,"totalCostOutUserAmount",1359.02,"totalProgress",3973.35,"totalActiveBugCnt",7530,"totalConfirmedBugCnt",4610,"projectStatus","cem6","totalActWorkload",2672.38,"totalActOutWorkload",4016,"totalActInnerWorkload",9420,"totalTaskBudgetCostAt",7558.18,"totalTaskOutCnt",6110,"totalNeedPayCnt",8317,"totalFinishPayCnt",5613,"totalFinishPayUserCnt",9922,"totalNeedPayUserCnt",9810,"totalPlanInnerUserWorkload",5854.38,"totalPlanOutUserWorkload",240.34,"testCases",4820,"execCases",2789,"designCases",5879,"finishCases",1766,"iterationCnt",2240,"productCnt",7024,"menuCnt",194);
		XmProjectStateHis xmProjectStateHis5=BaseUtils.fromMap(p5,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis5);
		Map p6=BaseUtils.map("projectId","CIJj","bizDate","SFnw","totalFileCnt",7720,"totalBugCnt",9430,"totalTaskCnt",1952,"totalBudgetNouserAmount",7473.74,"projectName","37v6","id","g3SL","totalStaffCnt",9535,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","S","totalCostNouserAmount",5239.51,"totalClosedBugCnt",7467,"totalResolvedBugCnt",774,"totalCompleteTaskCnt",1977,"totalPhaseCnt",1651,"totalCompletePhaseCnt",5432,"totalNeedPayAmount",7406.01,"totalFinishPayAmount",6451.74,"totalNeedColAmount",2333.95,"totalFinishColAmount",3755.2,"totalCostUserAmount",4988.8,"totalBudgetInnerUserAmount",6004.86,"totalPlanWorkload",6494.94,"totalRiskCnt",6084,"totalCompleteRiskCnt",9977,"branchId","N2ae","branchName","GyTv","totalBudgetOutUserAmount",2992.9,"totalCompleteWorkload",7999.23,"totalCostInnerUserAmount",2250.91,"totalCostOutUserAmount",8675.69,"totalProgress",1504.47,"totalActiveBugCnt",7400,"totalConfirmedBugCnt",8344,"projectStatus","Mvkn","totalActWorkload",316.44,"totalActOutWorkload",2361,"totalActInnerWorkload",5090,"totalTaskBudgetCostAt",9566.14,"totalTaskOutCnt",4544,"totalNeedPayCnt",2335,"totalFinishPayCnt",9939,"totalFinishPayUserCnt",9417,"totalNeedPayUserCnt",6823,"totalPlanInnerUserWorkload",3255.32,"totalPlanOutUserWorkload",2371.8,"testCases",7251,"execCases",9400,"designCases",1736,"finishCases",2465,"iterationCnt",5938,"productCnt",4576,"menuCnt",4751);
		XmProjectStateHis xmProjectStateHis6=BaseUtils.fromMap(p6,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis6);
		Map p7=BaseUtils.map("projectId","184d","bizDate","bvES","totalFileCnt",1694,"totalBugCnt",9492,"totalTaskCnt",5883,"totalBudgetNouserAmount",8547.6,"projectName","a3FK","id","j9ea","totalStaffCnt",8688,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","y","totalCostNouserAmount",7496.84,"totalClosedBugCnt",2321,"totalResolvedBugCnt",9922,"totalCompleteTaskCnt",324,"totalPhaseCnt",976,"totalCompletePhaseCnt",9755,"totalNeedPayAmount",5135.98,"totalFinishPayAmount",6188.82,"totalNeedColAmount",4499.1,"totalFinishColAmount",9292.22,"totalCostUserAmount",4207.92,"totalBudgetInnerUserAmount",5004.83,"totalPlanWorkload",7231.94,"totalRiskCnt",5677,"totalCompleteRiskCnt",8469,"branchId","wY2J","branchName","T8sg","totalBudgetOutUserAmount",33.29,"totalCompleteWorkload",821.38,"totalCostInnerUserAmount",7691.32,"totalCostOutUserAmount",9393.69,"totalProgress",2466.28,"totalActiveBugCnt",5978,"totalConfirmedBugCnt",4147,"projectStatus","38Dq","totalActWorkload",9840.12,"totalActOutWorkload",6100,"totalActInnerWorkload",5437,"totalTaskBudgetCostAt",2852.44,"totalTaskOutCnt",9891,"totalNeedPayCnt",3858,"totalFinishPayCnt",8253,"totalFinishPayUserCnt",1355,"totalNeedPayUserCnt",4026,"totalPlanInnerUserWorkload",5481.1,"totalPlanOutUserWorkload",1.62,"testCases",5504,"execCases",7897,"designCases",5650,"finishCases",2534,"iterationCnt",3879,"productCnt",6119,"menuCnt",3659);
		XmProjectStateHis xmProjectStateHis7=BaseUtils.fromMap(p7,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis7);
		baseDao.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmProjectStateHis> batchValues=new ArrayList<XmProjectStateHis>();
		Map p0=BaseUtils.map("projectId","yAe9","bizDate","vuIS","totalFileCnt",9821,"totalBugCnt",2939,"totalTaskCnt",8980,"totalBudgetNouserAmount",584.68,"projectName","nPT9","id","nZ84","totalStaffCnt",328,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","9","totalCostNouserAmount",4312.01,"totalClosedBugCnt",9724,"totalResolvedBugCnt",3695,"totalCompleteTaskCnt",3233,"totalPhaseCnt",219,"totalCompletePhaseCnt",6324,"totalNeedPayAmount",7409.83,"totalFinishPayAmount",2545.75,"totalNeedColAmount",1648.86,"totalFinishColAmount",5071.08,"totalCostUserAmount",2106.46,"totalBudgetInnerUserAmount",8479.47,"totalPlanWorkload",9943.39,"totalRiskCnt",5166,"totalCompleteRiskCnt",1618,"branchId","ICi1","branchName","xgh9","totalBudgetOutUserAmount",2679.32,"totalCompleteWorkload",1822.99,"totalCostInnerUserAmount",224.99,"totalCostOutUserAmount",3096.75,"totalProgress",7686.98,"totalActiveBugCnt",3341,"totalConfirmedBugCnt",9164,"projectStatus","pufi","totalActWorkload",1679.91,"totalActOutWorkload",2104,"totalActInnerWorkload",8027,"totalTaskBudgetCostAt",8868.89,"totalTaskOutCnt",5735,"totalNeedPayCnt",3369,"totalFinishPayCnt",8041,"totalFinishPayUserCnt",8182,"totalNeedPayUserCnt",5729,"totalPlanInnerUserWorkload",2366.25,"totalPlanOutUserWorkload",7677.67,"testCases",481,"execCases",527,"designCases",3173,"finishCases",2772,"iterationCnt",3180,"productCnt",6626,"menuCnt",7102);
		XmProjectStateHis xmProjectStateHis0=BaseUtils.fromMap(p0,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis0);
		Map p1=BaseUtils.map("projectId","K7e4","bizDate","4cm9","totalFileCnt",4483,"totalBugCnt",1881,"totalTaskCnt",5451,"totalBudgetNouserAmount",6578.01,"projectName","f4Y5","id","Wxzk","totalStaffCnt",9893,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","2","totalCostNouserAmount",4685.01,"totalClosedBugCnt",4826,"totalResolvedBugCnt",1943,"totalCompleteTaskCnt",2620,"totalPhaseCnt",3286,"totalCompletePhaseCnt",4869,"totalNeedPayAmount",7059.71,"totalFinishPayAmount",8617.08,"totalNeedColAmount",8146.94,"totalFinishColAmount",107.29,"totalCostUserAmount",2248.81,"totalBudgetInnerUserAmount",8328.71,"totalPlanWorkload",5845.96,"totalRiskCnt",4874,"totalCompleteRiskCnt",7253,"branchId","QcwR","branchName","tKUe","totalBudgetOutUserAmount",8922.6,"totalCompleteWorkload",6694.04,"totalCostInnerUserAmount",109.61,"totalCostOutUserAmount",8719.27,"totalProgress",7816.05,"totalActiveBugCnt",7792,"totalConfirmedBugCnt",5950,"projectStatus","j9t6","totalActWorkload",5557.76,"totalActOutWorkload",6164,"totalActInnerWorkload",2427,"totalTaskBudgetCostAt",7463.47,"totalTaskOutCnt",2316,"totalNeedPayCnt",5772,"totalFinishPayCnt",3868,"totalFinishPayUserCnt",4142,"totalNeedPayUserCnt",9716,"totalPlanInnerUserWorkload",2046.68,"totalPlanOutUserWorkload",4654.84,"testCases",1209,"execCases",9233,"designCases",5297,"finishCases",6581,"iterationCnt",4108,"productCnt",5396,"menuCnt",8764);
		XmProjectStateHis xmProjectStateHis1=BaseUtils.fromMap(p1,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis1);
		Map p2=BaseUtils.map("projectId","liyW","bizDate","TDGV","totalFileCnt",4048,"totalBugCnt",2092,"totalTaskCnt",7688,"totalBudgetNouserAmount",2585.94,"projectName","eb4X","id","RB4u","totalStaffCnt",686,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","s","totalCostNouserAmount",4462.82,"totalClosedBugCnt",6504,"totalResolvedBugCnt",8579,"totalCompleteTaskCnt",7135,"totalPhaseCnt",4455,"totalCompletePhaseCnt",161,"totalNeedPayAmount",8523.86,"totalFinishPayAmount",5122,"totalNeedColAmount",7586.67,"totalFinishColAmount",9834.52,"totalCostUserAmount",2113.92,"totalBudgetInnerUserAmount",9592.95,"totalPlanWorkload",8375.33,"totalRiskCnt",5269,"totalCompleteRiskCnt",8735,"branchId","irN2","branchName","nkVo","totalBudgetOutUserAmount",9405.69,"totalCompleteWorkload",4914.77,"totalCostInnerUserAmount",199.87,"totalCostOutUserAmount",9680.96,"totalProgress",4727.75,"totalActiveBugCnt",6953,"totalConfirmedBugCnt",2484,"projectStatus","U35y","totalActWorkload",3160.19,"totalActOutWorkload",4356,"totalActInnerWorkload",5518,"totalTaskBudgetCostAt",6080.48,"totalTaskOutCnt",8768,"totalNeedPayCnt",2302,"totalFinishPayCnt",6961,"totalFinishPayUserCnt",8121,"totalNeedPayUserCnt",6040,"totalPlanInnerUserWorkload",7932.94,"totalPlanOutUserWorkload",3604.02,"testCases",2162,"execCases",7666,"designCases",1283,"finishCases",7501,"iterationCnt",4628,"productCnt",9223,"menuCnt",1325);
		XmProjectStateHis xmProjectStateHis2=BaseUtils.fromMap(p2,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis2);
		Map p3=BaseUtils.map("projectId","CWvE","bizDate","wn8a","totalFileCnt",4295,"totalBugCnt",983,"totalTaskCnt",128,"totalBudgetNouserAmount",1399.91,"projectName","gU47","id","R7vb","totalStaffCnt",9553,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","x","totalCostNouserAmount",8496.62,"totalClosedBugCnt",2084,"totalResolvedBugCnt",7703,"totalCompleteTaskCnt",7978,"totalPhaseCnt",7853,"totalCompletePhaseCnt",4067,"totalNeedPayAmount",1512.49,"totalFinishPayAmount",1980.77,"totalNeedColAmount",4010.32,"totalFinishColAmount",3258.43,"totalCostUserAmount",8093.47,"totalBudgetInnerUserAmount",8299.92,"totalPlanWorkload",9185.93,"totalRiskCnt",7072,"totalCompleteRiskCnt",9339,"branchId","4RX0","branchName","XbTT","totalBudgetOutUserAmount",2158.77,"totalCompleteWorkload",4757.42,"totalCostInnerUserAmount",2769.07,"totalCostOutUserAmount",6316.77,"totalProgress",8395.71,"totalActiveBugCnt",5929,"totalConfirmedBugCnt",6982,"projectStatus","Jj98","totalActWorkload",5953.06,"totalActOutWorkload",4834,"totalActInnerWorkload",3800,"totalTaskBudgetCostAt",3465.36,"totalTaskOutCnt",7854,"totalNeedPayCnt",4996,"totalFinishPayCnt",9312,"totalFinishPayUserCnt",3590,"totalNeedPayUserCnt",6128,"totalPlanInnerUserWorkload",5696.88,"totalPlanOutUserWorkload",1819.96,"testCases",1948,"execCases",85,"designCases",9088,"finishCases",8034,"iterationCnt",9583,"productCnt",8585,"menuCnt",9119);
		XmProjectStateHis xmProjectStateHis3=BaseUtils.fromMap(p3,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis3);
		Map p4=BaseUtils.map("projectId","Mmq5","bizDate","sBVe","totalFileCnt",9952,"totalBugCnt",686,"totalTaskCnt",4043,"totalBudgetNouserAmount",3776.98,"projectName","HSis","id","33Ku","totalStaffCnt",615,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","t","totalCostNouserAmount",8754.64,"totalClosedBugCnt",8557,"totalResolvedBugCnt",6462,"totalCompleteTaskCnt",1766,"totalPhaseCnt",9114,"totalCompletePhaseCnt",4142,"totalNeedPayAmount",4886.33,"totalFinishPayAmount",379.02,"totalNeedColAmount",7293.99,"totalFinishColAmount",8536.53,"totalCostUserAmount",7748.52,"totalBudgetInnerUserAmount",2977.66,"totalPlanWorkload",872.1,"totalRiskCnt",1036,"totalCompleteRiskCnt",9828,"branchId","dC3Y","branchName","fC4n","totalBudgetOutUserAmount",6977.4,"totalCompleteWorkload",7656.81,"totalCostInnerUserAmount",8362.23,"totalCostOutUserAmount",7620.36,"totalProgress",6002.46,"totalActiveBugCnt",2577,"totalConfirmedBugCnt",3972,"projectStatus","hH72","totalActWorkload",6628.47,"totalActOutWorkload",8878,"totalActInnerWorkload",7329,"totalTaskBudgetCostAt",5721.69,"totalTaskOutCnt",8224,"totalNeedPayCnt",9597,"totalFinishPayCnt",4775,"totalFinishPayUserCnt",8693,"totalNeedPayUserCnt",4565,"totalPlanInnerUserWorkload",2671.48,"totalPlanOutUserWorkload",4150.9,"testCases",5356,"execCases",1777,"designCases",927,"finishCases",8384,"iterationCnt",2462,"productCnt",7629,"menuCnt",7439);
		XmProjectStateHis xmProjectStateHis4=BaseUtils.fromMap(p4,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis4);
		Map p5=BaseUtils.map("projectId","7hRu","bizDate","a1bs","totalFileCnt",9219,"totalBugCnt",7019,"totalTaskCnt",1740,"totalBudgetNouserAmount",9137.2,"projectName","7IEa","id","KeYg","totalStaffCnt",8755,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","V","totalCostNouserAmount",3124.13,"totalClosedBugCnt",6935,"totalResolvedBugCnt",6549,"totalCompleteTaskCnt",7501,"totalPhaseCnt",2563,"totalCompletePhaseCnt",4992,"totalNeedPayAmount",4730.38,"totalFinishPayAmount",2309.42,"totalNeedColAmount",8714.05,"totalFinishColAmount",6669.66,"totalCostUserAmount",3671.51,"totalBudgetInnerUserAmount",6558.68,"totalPlanWorkload",1262.8,"totalRiskCnt",40,"totalCompleteRiskCnt",2860,"branchId","aTGH","branchName","5c4Q","totalBudgetOutUserAmount",9938.47,"totalCompleteWorkload",2698.16,"totalCostInnerUserAmount",4342.54,"totalCostOutUserAmount",1359.02,"totalProgress",3973.35,"totalActiveBugCnt",7530,"totalConfirmedBugCnt",4610,"projectStatus","cem6","totalActWorkload",2672.38,"totalActOutWorkload",4016,"totalActInnerWorkload",9420,"totalTaskBudgetCostAt",7558.18,"totalTaskOutCnt",6110,"totalNeedPayCnt",8317,"totalFinishPayCnt",5613,"totalFinishPayUserCnt",9922,"totalNeedPayUserCnt",9810,"totalPlanInnerUserWorkload",5854.38,"totalPlanOutUserWorkload",240.34,"testCases",4820,"execCases",2789,"designCases",5879,"finishCases",1766,"iterationCnt",2240,"productCnt",7024,"menuCnt",194);
		XmProjectStateHis xmProjectStateHis5=BaseUtils.fromMap(p5,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis5);
		Map p6=BaseUtils.map("projectId","CIJj","bizDate","SFnw","totalFileCnt",7720,"totalBugCnt",9430,"totalTaskCnt",1952,"totalBudgetNouserAmount",7473.74,"projectName","37v6","id","g3SL","totalStaffCnt",9535,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","S","totalCostNouserAmount",5239.51,"totalClosedBugCnt",7467,"totalResolvedBugCnt",774,"totalCompleteTaskCnt",1977,"totalPhaseCnt",1651,"totalCompletePhaseCnt",5432,"totalNeedPayAmount",7406.01,"totalFinishPayAmount",6451.74,"totalNeedColAmount",2333.95,"totalFinishColAmount",3755.2,"totalCostUserAmount",4988.8,"totalBudgetInnerUserAmount",6004.86,"totalPlanWorkload",6494.94,"totalRiskCnt",6084,"totalCompleteRiskCnt",9977,"branchId","N2ae","branchName","GyTv","totalBudgetOutUserAmount",2992.9,"totalCompleteWorkload",7999.23,"totalCostInnerUserAmount",2250.91,"totalCostOutUserAmount",8675.69,"totalProgress",1504.47,"totalActiveBugCnt",7400,"totalConfirmedBugCnt",8344,"projectStatus","Mvkn","totalActWorkload",316.44,"totalActOutWorkload",2361,"totalActInnerWorkload",5090,"totalTaskBudgetCostAt",9566.14,"totalTaskOutCnt",4544,"totalNeedPayCnt",2335,"totalFinishPayCnt",9939,"totalFinishPayUserCnt",9417,"totalNeedPayUserCnt",6823,"totalPlanInnerUserWorkload",3255.32,"totalPlanOutUserWorkload",2371.8,"testCases",7251,"execCases",9400,"designCases",1736,"finishCases",2465,"iterationCnt",5938,"productCnt",4576,"menuCnt",4751);
		XmProjectStateHis xmProjectStateHis6=BaseUtils.fromMap(p6,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis6);
		Map p7=BaseUtils.map("projectId","184d","bizDate","bvES","totalFileCnt",1694,"totalBugCnt",9492,"totalTaskCnt",5883,"totalBudgetNouserAmount",8547.6,"projectName","a3FK","id","j9ea","totalStaffCnt",8688,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","y","totalCostNouserAmount",7496.84,"totalClosedBugCnt",2321,"totalResolvedBugCnt",9922,"totalCompleteTaskCnt",324,"totalPhaseCnt",976,"totalCompletePhaseCnt",9755,"totalNeedPayAmount",5135.98,"totalFinishPayAmount",6188.82,"totalNeedColAmount",4499.1,"totalFinishColAmount",9292.22,"totalCostUserAmount",4207.92,"totalBudgetInnerUserAmount",5004.83,"totalPlanWorkload",7231.94,"totalRiskCnt",5677,"totalCompleteRiskCnt",8469,"branchId","wY2J","branchName","T8sg","totalBudgetOutUserAmount",33.29,"totalCompleteWorkload",821.38,"totalCostInnerUserAmount",7691.32,"totalCostOutUserAmount",9393.69,"totalProgress",2466.28,"totalActiveBugCnt",5978,"totalConfirmedBugCnt",4147,"projectStatus","38Dq","totalActWorkload",9840.12,"totalActOutWorkload",6100,"totalActInnerWorkload",5437,"totalTaskBudgetCostAt",2852.44,"totalTaskOutCnt",9891,"totalNeedPayCnt",3858,"totalFinishPayCnt",8253,"totalFinishPayUserCnt",1355,"totalNeedPayUserCnt",4026,"totalPlanInnerUserWorkload",5481.1,"totalPlanOutUserWorkload",1.62,"testCases",5504,"execCases",7897,"designCases",5650,"finishCases",2534,"iterationCnt",3879,"productCnt",6119,"menuCnt",3659);
		XmProjectStateHis xmProjectStateHis7=BaseUtils.fromMap(p7,XmProjectStateHis.class);
		batchValues.add(xmProjectStateHis7);
		baseDao.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","nZ84");
		Map<String,Object> result=this.baseDao.selectOne(XmProjectStateHis.class.getName()+".selectOneMap",p);
		Assert.assertEquals("nZ84", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","yAe9","bizDate","vuIS","totalFileCnt",9821,"totalBugCnt",2939,"totalTaskCnt",8980,"totalBudgetNouserAmount",584.68,"projectName","nPT9","totalStaffCnt",328,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","9","totalCostNouserAmount",4312.01,"totalClosedBugCnt",9724,"totalResolvedBugCnt",3695,"totalCompleteTaskCnt",3233,"totalPhaseCnt",219,"totalCompletePhaseCnt",6324,"totalNeedPayAmount",7409.83,"totalFinishPayAmount",2545.75,"totalNeedColAmount",1648.86,"totalFinishColAmount",5071.08,"totalCostUserAmount",2106.46,"totalBudgetInnerUserAmount",8479.47,"totalPlanWorkload",9943.39,"totalRiskCnt",5166,"totalCompleteRiskCnt",1618,"branchId","ICi1","branchName","xgh9","totalBudgetOutUserAmount",2679.32,"totalCompleteWorkload",1822.99,"totalCostInnerUserAmount",224.99,"totalCostOutUserAmount",3096.75,"totalProgress",7686.98,"totalActiveBugCnt",3341,"totalConfirmedBugCnt",9164,"projectStatus","pufi","totalActWorkload",1679.91,"totalActOutWorkload",2104,"totalActInnerWorkload",8027,"totalTaskBudgetCostAt",8868.89,"totalTaskOutCnt",5735,"totalNeedPayCnt",3369,"totalFinishPayCnt",8041,"totalFinishPayUserCnt",8182,"totalNeedPayUserCnt",5729,"totalPlanInnerUserWorkload",2366.25,"totalPlanOutUserWorkload",7677.67,"testCases",481,"execCases",527,"designCases",3173,"finishCases",2772,"iterationCnt",3180,"productCnt",6626,"menuCnt",7102);
		XmProjectStateHis xmProjectStateHis=BaseUtils.fromMap(p,XmProjectStateHis.class);
		long result=baseDao.countByWhere(xmProjectStateHis);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
 		
		
		Map<String,Object> p=BaseUtils.map("projectId","yAe9","bizDate","vuIS","totalFileCnt",9821,"totalBugCnt",2939,"totalTaskCnt",8980,"totalBudgetNouserAmount",584.68,"projectName","nPT9","totalStaffCnt",328,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","9","totalCostNouserAmount",4312.01,"totalClosedBugCnt",9724,"totalResolvedBugCnt",3695,"totalCompleteTaskCnt",3233,"totalPhaseCnt",219,"totalCompletePhaseCnt",6324,"totalNeedPayAmount",7409.83,"totalFinishPayAmount",2545.75,"totalNeedColAmount",1648.86,"totalFinishColAmount",5071.08,"totalCostUserAmount",2106.46,"totalBudgetInnerUserAmount",8479.47,"totalPlanWorkload",9943.39,"totalRiskCnt",5166,"totalCompleteRiskCnt",1618,"branchId","ICi1","branchName","xgh9","totalBudgetOutUserAmount",2679.32,"totalCompleteWorkload",1822.99,"totalCostInnerUserAmount",224.99,"totalCostOutUserAmount",3096.75,"totalProgress",7686.98,"totalActiveBugCnt",3341,"totalConfirmedBugCnt",9164,"projectStatus","pufi","totalActWorkload",1679.91,"totalActOutWorkload",2104,"totalActInnerWorkload",8027,"totalTaskBudgetCostAt",8868.89,"totalTaskOutCnt",5735,"totalNeedPayCnt",3369,"totalFinishPayCnt",8041,"totalFinishPayUserCnt",8182,"totalNeedPayUserCnt",5729,"totalPlanInnerUserWorkload",2366.25,"totalPlanOutUserWorkload",7677.67,"testCases",481,"execCases",527,"designCases",3173,"finishCases",2772,"iterationCnt",3180,"productCnt",6626,"menuCnt",7102);
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmProjectStateHis xmProjectStateHis=BaseUtils.fromMap(p,XmProjectStateHis.class);
		List<XmProjectStateHis> result=baseDao.selectListByWhere(xmProjectStateHis); 
		if(result instanceof Page) {
			Page page=(Page)result;   
			Assert.assertEquals(true, page.getTotal()>=0);
		}
		
	}
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByWhere() {
	
		
		Map<String,Object> p=BaseUtils.map("projectId","yAe9","bizDate","vuIS","totalFileCnt",9821,"totalBugCnt",2939,"totalTaskCnt",8980,"totalBudgetNouserAmount",584.68,"projectName","nPT9","totalStaffCnt",328,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","9","totalCostNouserAmount",4312.01,"totalClosedBugCnt",9724,"totalResolvedBugCnt",3695,"totalCompleteTaskCnt",3233,"totalPhaseCnt",219,"totalCompletePhaseCnt",6324,"totalNeedPayAmount",7409.83,"totalFinishPayAmount",2545.75,"totalNeedColAmount",1648.86,"totalFinishColAmount",5071.08,"totalCostUserAmount",2106.46,"totalBudgetInnerUserAmount",8479.47,"totalPlanWorkload",9943.39,"totalRiskCnt",5166,"totalCompleteRiskCnt",1618,"branchId","ICi1","branchName","xgh9","totalBudgetOutUserAmount",2679.32,"totalCompleteWorkload",1822.99,"totalCostInnerUserAmount",224.99,"totalCostOutUserAmount",3096.75,"totalProgress",7686.98,"totalActiveBugCnt",3341,"totalConfirmedBugCnt",9164,"projectStatus","pufi","totalActWorkload",1679.91,"totalActOutWorkload",2104,"totalActInnerWorkload",8027,"totalTaskBudgetCostAt",8868.89,"totalTaskOutCnt",5735,"totalNeedPayCnt",3369,"totalFinishPayCnt",8041,"totalFinishPayUserCnt",8182,"totalNeedPayUserCnt",5729,"totalPlanInnerUserWorkload",2366.25,"totalPlanOutUserWorkload",7677.67,"testCases",481,"execCases",527,"designCases",3173,"finishCases",2772,"iterationCnt",3180,"productCnt",6626,"menuCnt",7102);
		XmProjectStateHis xmProjectStateHis=BaseUtils.fromMap(p,XmProjectStateHis.class);
		List<XmProjectStateHis> result=baseDao.selectListByWhere(xmProjectStateHis);
		Assert.assertEquals(true, result.size()>=1);
	}

	
	/**
	 * 查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","yAe9","bizDate","vuIS","totalFileCnt",9821,"totalBugCnt",2939,"totalTaskCnt",8980,"totalBudgetNouserAmount",584.68,"projectName","nPT9","totalStaffCnt",328,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","9","totalCostNouserAmount",4312.01,"totalClosedBugCnt",9724,"totalResolvedBugCnt",3695,"totalCompleteTaskCnt",3233,"totalPhaseCnt",219,"totalCompletePhaseCnt",6324,"totalNeedPayAmount",7409.83,"totalFinishPayAmount",2545.75,"totalNeedColAmount",1648.86,"totalFinishColAmount",5071.08,"totalCostUserAmount",2106.46,"totalBudgetInnerUserAmount",8479.47,"totalPlanWorkload",9943.39,"totalRiskCnt",5166,"totalCompleteRiskCnt",1618,"branchId","ICi1","branchName","xgh9","totalBudgetOutUserAmount",2679.32,"totalCompleteWorkload",1822.99,"totalCostInnerUserAmount",224.99,"totalCostOutUserAmount",3096.75,"totalProgress",7686.98,"totalActiveBugCnt",3341,"totalConfirmedBugCnt",9164,"projectStatus","pufi","totalActWorkload",1679.91,"totalActOutWorkload",2104,"totalActInnerWorkload",8027,"totalTaskBudgetCostAt",8868.89,"totalTaskOutCnt",5735,"totalNeedPayCnt",3369,"totalFinishPayCnt",8041,"totalFinishPayUserCnt",8182,"totalNeedPayUserCnt",5729,"totalPlanInnerUserWorkload",2366.25,"totalPlanOutUserWorkload",7677.67,"testCases",481,"execCases",527,"designCases",3173,"finishCases",2772,"iterationCnt",3180,"productCnt",6626,"menuCnt",7102);
		List<Map<String,Object>> result=baseDao.selectList(XmProjectStateHis.class.getName()+".selectListMapByWhere",p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("projectId","yAe9","bizDate","vuIS","totalFileCnt",9821,"totalBugCnt",2939,"totalTaskCnt",8980,"totalBudgetNouserAmount",584.68,"projectName","nPT9","totalStaffCnt",328,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","9","totalCostNouserAmount",4312.01,"totalClosedBugCnt",9724,"totalResolvedBugCnt",3695,"totalCompleteTaskCnt",3233,"totalPhaseCnt",219,"totalCompletePhaseCnt",6324,"totalNeedPayAmount",7409.83,"totalFinishPayAmount",2545.75,"totalNeedColAmount",1648.86,"totalFinishColAmount",5071.08,"totalCostUserAmount",2106.46,"totalBudgetInnerUserAmount",8479.47,"totalPlanWorkload",9943.39,"totalRiskCnt",5166,"totalCompleteRiskCnt",1618,"branchId","ICi1","branchName","xgh9","totalBudgetOutUserAmount",2679.32,"totalCompleteWorkload",1822.99,"totalCostInnerUserAmount",224.99,"totalCostOutUserAmount",3096.75,"totalProgress",7686.98,"totalActiveBugCnt",3341,"totalConfirmedBugCnt",9164,"projectStatus","pufi","totalActWorkload",1679.91,"totalActOutWorkload",2104,"totalActInnerWorkload",8027,"totalTaskBudgetCostAt",8868.89,"totalTaskOutCnt",5735,"totalNeedPayCnt",3369,"totalFinishPayCnt",8041,"totalFinishPayUserCnt",8182,"totalNeedPayUserCnt",5729,"totalPlanInnerUserWorkload",2366.25,"totalPlanOutUserWorkload",7677.67,"testCases",481,"execCases",527,"designCases",3173,"finishCases",2772,"iterationCnt",3180,"productCnt",6626,"menuCnt",7102);
		List<Map<String,Object>> result=baseDao.selectList(XmProjectStateHis.class.getName()+".selectListMapByKey",p);
		Assert.assertEquals(true, result.size()>=0);
	}
 
	/**
	 * 查询一个对象 XmProjectStateHis
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","nZ84");
		
		XmProjectStateHis xmProjectStateHis1=BaseUtils.fromMap(p,XmProjectStateHis.class);
		XmProjectStateHis xmProjectStateHis=baseDao.selectOneObject(xmProjectStateHis1);
		Assert.assertEquals("nZ84", xmProjectStateHis.getId());
	}

	/**
	 * 将字符串类型的日期转成Date对象
	 * @param source 如2015-10-23或者 2015-10-23 15:30:25等
	 * @param pattern 格式必须与 source的格式一致，如 2015-10-23对应的 pattern为 yyyy-MM-dd, <br>
	 *        2015-10-23 15:30:25 对应的pattern 为 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date parse(String source){
		 
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			try {
				return sdf.parse(source);
			} catch (Exception e) {
			}   
		
		return null;
	}
}
