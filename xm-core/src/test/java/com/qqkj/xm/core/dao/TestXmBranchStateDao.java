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
import com.qqkj.xm.core.entity.XmBranchState;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmBranchStateDao的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_branch_state 机构内所有项目指标汇总<br>
 * 实体 XmBranchState<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	bizDate,totalFileCnt,totalBugCnt,totalTaskCnt,totalBudgetNouserAmount,id,totalStaffCnt,calcTime,calcStatus,totalCostNouserAmount,totalClosedBugCnt,totalResolvedBugCnt,totalCompleteTaskCnt,totalPhaseCnt,totalCompletePhaseCnt,totalNeedPayAmount,totalFinishPayAmount,totalNeedColAmount,totalFinishColAmount,totalCostUserAmount,totalBudgetInnerUserAmount,totalPlanWorkload,totalRiskCnt,totalCompleteRiskCnt,branchId,branchName,totalBudgetOutUserAmount,totalCompleteWorkload,totalCostInnerUserAmount,totalCostOutUserAmount,totalProgress,totalActiveBugCnt,totalConfirmedBugCnt,projectStatus,totalActWorkload,totalActOutWorkload,totalActInnerWorkload,totalTaskBudgetCostAt,totalTaskOutCnt,totalNeedPayCnt,totalFinishPayCnt,totalFinishPayUserCnt,totalNeedPayUserCnt,totalPlanInnerUserWorkload,totalPlanOutUserWorkload,testCases,execCases,designCases,finishCases,iterationCnt,productCnt,menuCnt;<br>
 * 当前表的所有字段名:<br>
 *	biz_date,total_file_cnt,total_bug_cnt,total_task_cnt,total_budget_nouser_amount,id,total_staff_cnt,calc_time,calc_status,total_cost_nouser_amount,total_closed_bug_cnt,total_resolved_bug_cnt,total_complete_task_cnt,total_phase_cnt,total_complete_phase_cnt,total_need_pay_amount,total_finish_pay_amount,total_need_col_amount,total_finish_col_amount,total_cost_user_amount,total_budget_inner_user_amount,total_plan_workload,total_risk_cnt,total_complete_risk_cnt,branch_id,branch_name,total_budget_out_user_amount,total_complete_workload,total_cost_inner_user_amount,total_cost_out_user_amount,total_progress,total_active_bug_cnt,total_confirmed_bug_cnt,project_status,total_act_workload,total_act_out_workload,total_act_inner_workload,total_task_budget_cost_at,total_task_out_cnt,total_need_pay_cnt,total_finish_pay_cnt,total_finish_pay_user_cnt,total_need_pay_user_cnt,total_plan_inner_user_workload,total_plan_out_user_workload,test_cases,exec_cases,design_cases,finish_cases,iteration_cnt,product_cnt,menu_cnt;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/
 @RunWith(SpringJUnit4ClassRunner.class)
 @SpringBootTest
public class TestXmBranchStateDao  {

	@Autowired
	BaseDao baseDao;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("bizDate","Utbh","totalFileCnt",3509,"totalBugCnt",3490,"totalTaskCnt",1414,"totalBudgetNouserAmount",3656.61,"id","3lPB","totalStaffCnt",4834,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","h","totalCostNouserAmount",2604.99,"totalClosedBugCnt",7336,"totalResolvedBugCnt",4857,"totalCompleteTaskCnt",4319,"totalPhaseCnt",2620,"totalCompletePhaseCnt",2855,"totalNeedPayAmount",460.84,"totalFinishPayAmount",2248.84,"totalNeedColAmount",7036.19,"totalFinishColAmount",1977.48,"totalCostUserAmount",7584.56,"totalBudgetInnerUserAmount",731.82,"totalPlanWorkload",478.56,"totalRiskCnt",815,"totalCompleteRiskCnt",8669,"branchId","l2y1","branchName","mHQa","totalBudgetOutUserAmount",3404.44,"totalCompleteWorkload",6809.51,"totalCostInnerUserAmount",9219.78,"totalCostOutUserAmount",3531.81,"totalProgress",9024.33,"totalActiveBugCnt",2499,"totalConfirmedBugCnt",318,"projectStatus","Ty46","totalActWorkload",2296.84,"totalActOutWorkload",8928,"totalActInnerWorkload",7763,"totalTaskBudgetCostAt",8054,"totalTaskOutCnt",5624,"totalNeedPayCnt",2162,"totalFinishPayCnt",5737,"totalFinishPayUserCnt",1775,"totalNeedPayUserCnt",8626,"totalPlanInnerUserWorkload",8899.79,"totalPlanOutUserWorkload",4520.12,"testCases",3850,"execCases",4446,"designCases",3370,"finishCases",1885,"iterationCnt",9064,"productCnt",5781,"menuCnt",477);
		XmBranchState xmBranchState=BaseUtils.fromMap(p,XmBranchState.class);
		baseDao.insert(xmBranchState);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("bizDate","Utbh","totalFileCnt",3509,"totalBugCnt",3490,"totalTaskCnt",1414,"totalBudgetNouserAmount",3656.61,"totalStaffCnt",4834,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","h","totalCostNouserAmount",2604.99,"totalClosedBugCnt",7336,"totalResolvedBugCnt",4857,"totalCompleteTaskCnt",4319,"totalPhaseCnt",2620,"totalCompletePhaseCnt",2855,"totalNeedPayAmount",460.84,"totalFinishPayAmount",2248.84,"totalNeedColAmount",7036.19,"totalFinishColAmount",1977.48,"totalCostUserAmount",7584.56,"totalBudgetInnerUserAmount",731.82,"totalPlanWorkload",478.56,"totalRiskCnt",815,"totalCompleteRiskCnt",8669,"branchId","l2y1","branchName","mHQa","totalBudgetOutUserAmount",3404.44,"totalCompleteWorkload",6809.51,"totalCostInnerUserAmount",9219.78,"totalCostOutUserAmount",3531.81,"totalProgress",9024.33,"totalActiveBugCnt",2499,"totalConfirmedBugCnt",318,"projectStatus","Ty46","totalActWorkload",2296.84,"totalActOutWorkload",8928,"totalActInnerWorkload",7763,"totalTaskBudgetCostAt",8054,"totalTaskOutCnt",5624,"totalNeedPayCnt",2162,"totalFinishPayCnt",5737,"totalFinishPayUserCnt",1775,"totalNeedPayUserCnt",8626,"totalPlanInnerUserWorkload",8899.79,"totalPlanOutUserWorkload",4520.12,"testCases",3850,"execCases",4446,"designCases",3370,"finishCases",1885,"iterationCnt",9064,"productCnt",5781,"menuCnt",477);
		XmBranchState xmBranchState=BaseUtils.fromMap(p,XmBranchState.class);
		baseDao.deleteByWhere(xmBranchState);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","3lPB");
		XmBranchState xmBranchState=BaseUtils.fromMap(p,XmBranchState.class);
		baseDao.deleteByPk(xmBranchState);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("bizDate","Utbh","totalFileCnt",3509,"totalBugCnt",3490,"totalTaskCnt",1414,"totalBudgetNouserAmount",3656.61,"totalStaffCnt",4834,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","h","totalCostNouserAmount",2604.99,"totalClosedBugCnt",7336,"totalResolvedBugCnt",4857,"totalCompleteTaskCnt",4319,"totalPhaseCnt",2620,"totalCompletePhaseCnt",2855,"totalNeedPayAmount",460.84,"totalFinishPayAmount",2248.84,"totalNeedColAmount",7036.19,"totalFinishColAmount",1977.48,"totalCostUserAmount",7584.56,"totalBudgetInnerUserAmount",731.82,"totalPlanWorkload",478.56,"totalRiskCnt",815,"totalCompleteRiskCnt",8669,"branchId","l2y1","branchName","mHQa","totalBudgetOutUserAmount",3404.44,"totalCompleteWorkload",6809.51,"totalCostInnerUserAmount",9219.78,"totalCostOutUserAmount",3531.81,"totalProgress",9024.33,"totalActiveBugCnt",2499,"totalConfirmedBugCnt",318,"projectStatus","Ty46","totalActWorkload",2296.84,"totalActOutWorkload",8928,"totalActInnerWorkload",7763,"totalTaskBudgetCostAt",8054,"totalTaskOutCnt",5624,"totalNeedPayCnt",2162,"totalFinishPayCnt",5737,"totalFinishPayUserCnt",1775,"totalNeedPayUserCnt",8626,"totalPlanInnerUserWorkload",8899.79,"totalPlanOutUserWorkload",4520.12,"testCases",3850,"execCases",4446,"designCases",3370,"finishCases",1885,"iterationCnt",9064,"productCnt",5781,"menuCnt",477);
		XmBranchState xmBranchState=BaseUtils.fromMap(where,XmBranchState.class);
		baseDao.updateSomeFieldByPk(xmBranchState);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","3lPB");
		XmBranchState xmBranchState=BaseUtils.fromMap(p,XmBranchState.class);
		baseDao.updateByPk(xmBranchState);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("bizDate","Utbh","totalFileCnt",3509,"totalBugCnt",3490,"totalTaskCnt",1414,"totalBudgetNouserAmount",3656.61,"id","3lPB","totalStaffCnt",4834,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","h","totalCostNouserAmount",2604.99,"totalClosedBugCnt",7336,"totalResolvedBugCnt",4857,"totalCompleteTaskCnt",4319,"totalPhaseCnt",2620,"totalCompletePhaseCnt",2855,"totalNeedPayAmount",460.84,"totalFinishPayAmount",2248.84,"totalNeedColAmount",7036.19,"totalFinishColAmount",1977.48,"totalCostUserAmount",7584.56,"totalBudgetInnerUserAmount",731.82,"totalPlanWorkload",478.56,"totalRiskCnt",815,"totalCompleteRiskCnt",8669,"branchId","l2y1","branchName","mHQa","totalBudgetOutUserAmount",3404.44,"totalCompleteWorkload",6809.51,"totalCostInnerUserAmount",9219.78,"totalCostOutUserAmount",3531.81,"totalProgress",9024.33,"totalActiveBugCnt",2499,"totalConfirmedBugCnt",318,"projectStatus","Ty46","totalActWorkload",2296.84,"totalActOutWorkload",8928,"totalActInnerWorkload",7763,"totalTaskBudgetCostAt",8054,"totalTaskOutCnt",5624,"totalNeedPayCnt",2162,"totalFinishPayCnt",5737,"totalFinishPayUserCnt",1775,"totalNeedPayUserCnt",8626,"totalPlanInnerUserWorkload",8899.79,"totalPlanOutUserWorkload",4520.12,"testCases",3850,"execCases",4446,"designCases",3370,"finishCases",1885,"iterationCnt",9064,"productCnt",5781,"menuCnt",477);
		XmBranchState xmBranchState=BaseUtils.fromMap(p,XmBranchState.class);
		baseDao.insertOrUpdate(xmBranchState);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmBranchState> batchValues=new ArrayList<XmBranchState>();
		Map p0=BaseUtils.map("bizDate","Utbh","totalFileCnt",3509,"totalBugCnt",3490,"totalTaskCnt",1414,"totalBudgetNouserAmount",3656.61,"id","3lPB","totalStaffCnt",4834,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","h","totalCostNouserAmount",2604.99,"totalClosedBugCnt",7336,"totalResolvedBugCnt",4857,"totalCompleteTaskCnt",4319,"totalPhaseCnt",2620,"totalCompletePhaseCnt",2855,"totalNeedPayAmount",460.84,"totalFinishPayAmount",2248.84,"totalNeedColAmount",7036.19,"totalFinishColAmount",1977.48,"totalCostUserAmount",7584.56,"totalBudgetInnerUserAmount",731.82,"totalPlanWorkload",478.56,"totalRiskCnt",815,"totalCompleteRiskCnt",8669,"branchId","l2y1","branchName","mHQa","totalBudgetOutUserAmount",3404.44,"totalCompleteWorkload",6809.51,"totalCostInnerUserAmount",9219.78,"totalCostOutUserAmount",3531.81,"totalProgress",9024.33,"totalActiveBugCnt",2499,"totalConfirmedBugCnt",318,"projectStatus","Ty46","totalActWorkload",2296.84,"totalActOutWorkload",8928,"totalActInnerWorkload",7763,"totalTaskBudgetCostAt",8054,"totalTaskOutCnt",5624,"totalNeedPayCnt",2162,"totalFinishPayCnt",5737,"totalFinishPayUserCnt",1775,"totalNeedPayUserCnt",8626,"totalPlanInnerUserWorkload",8899.79,"totalPlanOutUserWorkload",4520.12,"testCases",3850,"execCases",4446,"designCases",3370,"finishCases",1885,"iterationCnt",9064,"productCnt",5781,"menuCnt",477);
		XmBranchState xmBranchState0=BaseUtils.fromMap(p0,XmBranchState.class);
		batchValues.add(xmBranchState0);
		Map p1=BaseUtils.map("bizDate","jX0R","totalFileCnt",2299,"totalBugCnt",1962,"totalTaskCnt",7824,"totalBudgetNouserAmount",6362.93,"id","PqC5","totalStaffCnt",2503,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","f","totalCostNouserAmount",9331.83,"totalClosedBugCnt",3737,"totalResolvedBugCnt",4055,"totalCompleteTaskCnt",8638,"totalPhaseCnt",5029,"totalCompletePhaseCnt",9127,"totalNeedPayAmount",495.3,"totalFinishPayAmount",743.36,"totalNeedColAmount",9654.39,"totalFinishColAmount",2625.81,"totalCostUserAmount",8390.31,"totalBudgetInnerUserAmount",9739.71,"totalPlanWorkload",2423.84,"totalRiskCnt",4875,"totalCompleteRiskCnt",9572,"branchId","t7Kz","branchName","hFd1","totalBudgetOutUserAmount",6915.34,"totalCompleteWorkload",1593.52,"totalCostInnerUserAmount",2529.02,"totalCostOutUserAmount",8792.35,"totalProgress",3829.05,"totalActiveBugCnt",3835,"totalConfirmedBugCnt",4019,"projectStatus","0cKj","totalActWorkload",3457.59,"totalActOutWorkload",9155,"totalActInnerWorkload",4410,"totalTaskBudgetCostAt",5094.5,"totalTaskOutCnt",7647,"totalNeedPayCnt",630,"totalFinishPayCnt",3753,"totalFinishPayUserCnt",7433,"totalNeedPayUserCnt",8253,"totalPlanInnerUserWorkload",4908.24,"totalPlanOutUserWorkload",6754.16,"testCases",2063,"execCases",1914,"designCases",3069,"finishCases",4227,"iterationCnt",8740,"productCnt",8113,"menuCnt",8542);
		XmBranchState xmBranchState1=BaseUtils.fromMap(p1,XmBranchState.class);
		batchValues.add(xmBranchState1);
		Map p2=BaseUtils.map("bizDate","X1xS","totalFileCnt",6831,"totalBugCnt",1956,"totalTaskCnt",3530,"totalBudgetNouserAmount",3462.74,"id","Vxk4","totalStaffCnt",2564,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","y","totalCostNouserAmount",108.01,"totalClosedBugCnt",2331,"totalResolvedBugCnt",3865,"totalCompleteTaskCnt",5521,"totalPhaseCnt",4363,"totalCompletePhaseCnt",5892,"totalNeedPayAmount",6013.07,"totalFinishPayAmount",4100.04,"totalNeedColAmount",1727.53,"totalFinishColAmount",5948.85,"totalCostUserAmount",6694.83,"totalBudgetInnerUserAmount",1375.5,"totalPlanWorkload",8539.04,"totalRiskCnt",5732,"totalCompleteRiskCnt",9602,"branchId","w4tu","branchName","DNpd","totalBudgetOutUserAmount",8418.35,"totalCompleteWorkload",8194.61,"totalCostInnerUserAmount",7982.59,"totalCostOutUserAmount",5354.18,"totalProgress",7146.76,"totalActiveBugCnt",3059,"totalConfirmedBugCnt",5609,"projectStatus","z84o","totalActWorkload",6106.39,"totalActOutWorkload",1867,"totalActInnerWorkload",8637,"totalTaskBudgetCostAt",1912.21,"totalTaskOutCnt",4574,"totalNeedPayCnt",8180,"totalFinishPayCnt",8582,"totalFinishPayUserCnt",4743,"totalNeedPayUserCnt",900,"totalPlanInnerUserWorkload",5566.73,"totalPlanOutUserWorkload",5912.09,"testCases",3826,"execCases",7979,"designCases",7192,"finishCases",5683,"iterationCnt",6250,"productCnt",8695,"menuCnt",7223);
		XmBranchState xmBranchState2=BaseUtils.fromMap(p2,XmBranchState.class);
		batchValues.add(xmBranchState2);
		Map p3=BaseUtils.map("bizDate","0r7A","totalFileCnt",6472,"totalBugCnt",2805,"totalTaskCnt",1446,"totalBudgetNouserAmount",3067.37,"id","t8y3","totalStaffCnt",4323,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","c","totalCostNouserAmount",2987.78,"totalClosedBugCnt",2926,"totalResolvedBugCnt",9862,"totalCompleteTaskCnt",3701,"totalPhaseCnt",1150,"totalCompletePhaseCnt",1846,"totalNeedPayAmount",8156.61,"totalFinishPayAmount",6895.58,"totalNeedColAmount",1213.76,"totalFinishColAmount",5685.92,"totalCostUserAmount",9362.89,"totalBudgetInnerUserAmount",9082.41,"totalPlanWorkload",2148.47,"totalRiskCnt",195,"totalCompleteRiskCnt",3275,"branchId","3t79","branchName","RoBp","totalBudgetOutUserAmount",9797.26,"totalCompleteWorkload",4923.03,"totalCostInnerUserAmount",5958.76,"totalCostOutUserAmount",4382.82,"totalProgress",5717.48,"totalActiveBugCnt",1588,"totalConfirmedBugCnt",2102,"projectStatus","N7Rz","totalActWorkload",4670.36,"totalActOutWorkload",7969,"totalActInnerWorkload",7825,"totalTaskBudgetCostAt",6711.87,"totalTaskOutCnt",3954,"totalNeedPayCnt",6215,"totalFinishPayCnt",336,"totalFinishPayUserCnt",743,"totalNeedPayUserCnt",954,"totalPlanInnerUserWorkload",9327.62,"totalPlanOutUserWorkload",2999.26,"testCases",6926,"execCases",2570,"designCases",9829,"finishCases",4695,"iterationCnt",7487,"productCnt",1137,"menuCnt",4779);
		XmBranchState xmBranchState3=BaseUtils.fromMap(p3,XmBranchState.class);
		batchValues.add(xmBranchState3);
		Map p4=BaseUtils.map("bizDate","SNKD","totalFileCnt",7066,"totalBugCnt",8400,"totalTaskCnt",2617,"totalBudgetNouserAmount",1337.9,"id","018g","totalStaffCnt",8639,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","O","totalCostNouserAmount",4611.01,"totalClosedBugCnt",8262,"totalResolvedBugCnt",8665,"totalCompleteTaskCnt",9404,"totalPhaseCnt",5313,"totalCompletePhaseCnt",3292,"totalNeedPayAmount",6942.09,"totalFinishPayAmount",3246.13,"totalNeedColAmount",8491.72,"totalFinishColAmount",6746.95,"totalCostUserAmount",7021.74,"totalBudgetInnerUserAmount",9902.6,"totalPlanWorkload",9211.2,"totalRiskCnt",3977,"totalCompleteRiskCnt",4480,"branchId","WyHL","branchName","m3TW","totalBudgetOutUserAmount",553.58,"totalCompleteWorkload",1193.08,"totalCostInnerUserAmount",6141.63,"totalCostOutUserAmount",9644.01,"totalProgress",8338.07,"totalActiveBugCnt",1126,"totalConfirmedBugCnt",4,"projectStatus","JpTZ","totalActWorkload",8262.5,"totalActOutWorkload",52,"totalActInnerWorkload",9830,"totalTaskBudgetCostAt",8044.9,"totalTaskOutCnt",3329,"totalNeedPayCnt",6317,"totalFinishPayCnt",5637,"totalFinishPayUserCnt",8841,"totalNeedPayUserCnt",6812,"totalPlanInnerUserWorkload",1314.64,"totalPlanOutUserWorkload",5276.41,"testCases",4131,"execCases",6853,"designCases",5663,"finishCases",8323,"iterationCnt",3448,"productCnt",5168,"menuCnt",5474);
		XmBranchState xmBranchState4=BaseUtils.fromMap(p4,XmBranchState.class);
		batchValues.add(xmBranchState4);
		Map p5=BaseUtils.map("bizDate","fmBM","totalFileCnt",9024,"totalBugCnt",36,"totalTaskCnt",8323,"totalBudgetNouserAmount",492.25,"id","MmOr","totalStaffCnt",100,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","n","totalCostNouserAmount",7408.83,"totalClosedBugCnt",2909,"totalResolvedBugCnt",9209,"totalCompleteTaskCnt",805,"totalPhaseCnt",4306,"totalCompletePhaseCnt",3617,"totalNeedPayAmount",4257.02,"totalFinishPayAmount",3919.3,"totalNeedColAmount",8122.96,"totalFinishColAmount",3005.15,"totalCostUserAmount",7870.65,"totalBudgetInnerUserAmount",9499.16,"totalPlanWorkload",8509.03,"totalRiskCnt",8284,"totalCompleteRiskCnt",3200,"branchId","PAyA","branchName","xR6X","totalBudgetOutUserAmount",5767.06,"totalCompleteWorkload",5026.75,"totalCostInnerUserAmount",3908.83,"totalCostOutUserAmount",3791.59,"totalProgress",9665.26,"totalActiveBugCnt",9772,"totalConfirmedBugCnt",7728,"projectStatus","D6lx","totalActWorkload",484.12,"totalActOutWorkload",7429,"totalActInnerWorkload",9982,"totalTaskBudgetCostAt",1189.02,"totalTaskOutCnt",5961,"totalNeedPayCnt",9939,"totalFinishPayCnt",2331,"totalFinishPayUserCnt",9680,"totalNeedPayUserCnt",9464,"totalPlanInnerUserWorkload",6911.4,"totalPlanOutUserWorkload",7593.65,"testCases",5078,"execCases",3950,"designCases",8464,"finishCases",5395,"iterationCnt",4455,"productCnt",9787,"menuCnt",565);
		XmBranchState xmBranchState5=BaseUtils.fromMap(p5,XmBranchState.class);
		batchValues.add(xmBranchState5);
		Map p6=BaseUtils.map("bizDate","5w0b","totalFileCnt",5502,"totalBugCnt",8318,"totalTaskCnt",1565,"totalBudgetNouserAmount",9994.15,"id","SqXV","totalStaffCnt",1596,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","n","totalCostNouserAmount",4289.72,"totalClosedBugCnt",8032,"totalResolvedBugCnt",2712,"totalCompleteTaskCnt",3745,"totalPhaseCnt",4619,"totalCompletePhaseCnt",7546,"totalNeedPayAmount",927.7,"totalFinishPayAmount",4254.39,"totalNeedColAmount",7455.86,"totalFinishColAmount",767.43,"totalCostUserAmount",1940.53,"totalBudgetInnerUserAmount",1916.97,"totalPlanWorkload",4734.3,"totalRiskCnt",6852,"totalCompleteRiskCnt",5113,"branchId","ktm9","branchName","hR9Q","totalBudgetOutUserAmount",7337.38,"totalCompleteWorkload",9324.27,"totalCostInnerUserAmount",3323.02,"totalCostOutUserAmount",514.87,"totalProgress",232.24,"totalActiveBugCnt",5351,"totalConfirmedBugCnt",2798,"projectStatus","h8QG","totalActWorkload",5147.34,"totalActOutWorkload",8649,"totalActInnerWorkload",7705,"totalTaskBudgetCostAt",2796.98,"totalTaskOutCnt",8776,"totalNeedPayCnt",4116,"totalFinishPayCnt",6151,"totalFinishPayUserCnt",8403,"totalNeedPayUserCnt",7646,"totalPlanInnerUserWorkload",6594.32,"totalPlanOutUserWorkload",1777.59,"testCases",7554,"execCases",7118,"designCases",8152,"finishCases",9229,"iterationCnt",9033,"productCnt",4253,"menuCnt",7953);
		XmBranchState xmBranchState6=BaseUtils.fromMap(p6,XmBranchState.class);
		batchValues.add(xmBranchState6);
		Map p7=BaseUtils.map("bizDate","enRX","totalFileCnt",6354,"totalBugCnt",4035,"totalTaskCnt",9178,"totalBudgetNouserAmount",7529.79,"id","oux7","totalStaffCnt",7065,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","0","totalCostNouserAmount",8653.57,"totalClosedBugCnt",108,"totalResolvedBugCnt",1427,"totalCompleteTaskCnt",3758,"totalPhaseCnt",5303,"totalCompletePhaseCnt",6021,"totalNeedPayAmount",4348.06,"totalFinishPayAmount",8617.88,"totalNeedColAmount",1012.2,"totalFinishColAmount",5430.37,"totalCostUserAmount",4252.56,"totalBudgetInnerUserAmount",4270.5,"totalPlanWorkload",4730.32,"totalRiskCnt",6823,"totalCompleteRiskCnt",611,"branchId","Zc4d","branchName","Iy2q","totalBudgetOutUserAmount",8549.51,"totalCompleteWorkload",7304.19,"totalCostInnerUserAmount",4020.11,"totalCostOutUserAmount",3391.5,"totalProgress",5817.48,"totalActiveBugCnt",8053,"totalConfirmedBugCnt",7060,"projectStatus","ZFjU","totalActWorkload",5269.32,"totalActOutWorkload",6835,"totalActInnerWorkload",2145,"totalTaskBudgetCostAt",9775.07,"totalTaskOutCnt",3231,"totalNeedPayCnt",172,"totalFinishPayCnt",3497,"totalFinishPayUserCnt",6562,"totalNeedPayUserCnt",9021,"totalPlanInnerUserWorkload",4339.51,"totalPlanOutUserWorkload",4501.23,"testCases",5419,"execCases",3519,"designCases",3832,"finishCases",8706,"iterationCnt",4367,"productCnt",2033,"menuCnt",7637);
		XmBranchState xmBranchState7=BaseUtils.fromMap(p7,XmBranchState.class);
		batchValues.add(xmBranchState7);
		baseDao.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmBranchState> batchValues=new ArrayList<XmBranchState>();
		Map p0=BaseUtils.map("bizDate","Utbh","totalFileCnt",3509,"totalBugCnt",3490,"totalTaskCnt",1414,"totalBudgetNouserAmount",3656.61,"id","3lPB","totalStaffCnt",4834,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","h","totalCostNouserAmount",2604.99,"totalClosedBugCnt",7336,"totalResolvedBugCnt",4857,"totalCompleteTaskCnt",4319,"totalPhaseCnt",2620,"totalCompletePhaseCnt",2855,"totalNeedPayAmount",460.84,"totalFinishPayAmount",2248.84,"totalNeedColAmount",7036.19,"totalFinishColAmount",1977.48,"totalCostUserAmount",7584.56,"totalBudgetInnerUserAmount",731.82,"totalPlanWorkload",478.56,"totalRiskCnt",815,"totalCompleteRiskCnt",8669,"branchId","l2y1","branchName","mHQa","totalBudgetOutUserAmount",3404.44,"totalCompleteWorkload",6809.51,"totalCostInnerUserAmount",9219.78,"totalCostOutUserAmount",3531.81,"totalProgress",9024.33,"totalActiveBugCnt",2499,"totalConfirmedBugCnt",318,"projectStatus","Ty46","totalActWorkload",2296.84,"totalActOutWorkload",8928,"totalActInnerWorkload",7763,"totalTaskBudgetCostAt",8054,"totalTaskOutCnt",5624,"totalNeedPayCnt",2162,"totalFinishPayCnt",5737,"totalFinishPayUserCnt",1775,"totalNeedPayUserCnt",8626,"totalPlanInnerUserWorkload",8899.79,"totalPlanOutUserWorkload",4520.12,"testCases",3850,"execCases",4446,"designCases",3370,"finishCases",1885,"iterationCnt",9064,"productCnt",5781,"menuCnt",477);
		XmBranchState xmBranchState0=BaseUtils.fromMap(p0,XmBranchState.class);
		batchValues.add(xmBranchState0);
		Map p1=BaseUtils.map("bizDate","jX0R","totalFileCnt",2299,"totalBugCnt",1962,"totalTaskCnt",7824,"totalBudgetNouserAmount",6362.93,"id","PqC5","totalStaffCnt",2503,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","f","totalCostNouserAmount",9331.83,"totalClosedBugCnt",3737,"totalResolvedBugCnt",4055,"totalCompleteTaskCnt",8638,"totalPhaseCnt",5029,"totalCompletePhaseCnt",9127,"totalNeedPayAmount",495.3,"totalFinishPayAmount",743.36,"totalNeedColAmount",9654.39,"totalFinishColAmount",2625.81,"totalCostUserAmount",8390.31,"totalBudgetInnerUserAmount",9739.71,"totalPlanWorkload",2423.84,"totalRiskCnt",4875,"totalCompleteRiskCnt",9572,"branchId","t7Kz","branchName","hFd1","totalBudgetOutUserAmount",6915.34,"totalCompleteWorkload",1593.52,"totalCostInnerUserAmount",2529.02,"totalCostOutUserAmount",8792.35,"totalProgress",3829.05,"totalActiveBugCnt",3835,"totalConfirmedBugCnt",4019,"projectStatus","0cKj","totalActWorkload",3457.59,"totalActOutWorkload",9155,"totalActInnerWorkload",4410,"totalTaskBudgetCostAt",5094.5,"totalTaskOutCnt",7647,"totalNeedPayCnt",630,"totalFinishPayCnt",3753,"totalFinishPayUserCnt",7433,"totalNeedPayUserCnt",8253,"totalPlanInnerUserWorkload",4908.24,"totalPlanOutUserWorkload",6754.16,"testCases",2063,"execCases",1914,"designCases",3069,"finishCases",4227,"iterationCnt",8740,"productCnt",8113,"menuCnt",8542);
		XmBranchState xmBranchState1=BaseUtils.fromMap(p1,XmBranchState.class);
		batchValues.add(xmBranchState1);
		Map p2=BaseUtils.map("bizDate","X1xS","totalFileCnt",6831,"totalBugCnt",1956,"totalTaskCnt",3530,"totalBudgetNouserAmount",3462.74,"id","Vxk4","totalStaffCnt",2564,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","y","totalCostNouserAmount",108.01,"totalClosedBugCnt",2331,"totalResolvedBugCnt",3865,"totalCompleteTaskCnt",5521,"totalPhaseCnt",4363,"totalCompletePhaseCnt",5892,"totalNeedPayAmount",6013.07,"totalFinishPayAmount",4100.04,"totalNeedColAmount",1727.53,"totalFinishColAmount",5948.85,"totalCostUserAmount",6694.83,"totalBudgetInnerUserAmount",1375.5,"totalPlanWorkload",8539.04,"totalRiskCnt",5732,"totalCompleteRiskCnt",9602,"branchId","w4tu","branchName","DNpd","totalBudgetOutUserAmount",8418.35,"totalCompleteWorkload",8194.61,"totalCostInnerUserAmount",7982.59,"totalCostOutUserAmount",5354.18,"totalProgress",7146.76,"totalActiveBugCnt",3059,"totalConfirmedBugCnt",5609,"projectStatus","z84o","totalActWorkload",6106.39,"totalActOutWorkload",1867,"totalActInnerWorkload",8637,"totalTaskBudgetCostAt",1912.21,"totalTaskOutCnt",4574,"totalNeedPayCnt",8180,"totalFinishPayCnt",8582,"totalFinishPayUserCnt",4743,"totalNeedPayUserCnt",900,"totalPlanInnerUserWorkload",5566.73,"totalPlanOutUserWorkload",5912.09,"testCases",3826,"execCases",7979,"designCases",7192,"finishCases",5683,"iterationCnt",6250,"productCnt",8695,"menuCnt",7223);
		XmBranchState xmBranchState2=BaseUtils.fromMap(p2,XmBranchState.class);
		batchValues.add(xmBranchState2);
		Map p3=BaseUtils.map("bizDate","0r7A","totalFileCnt",6472,"totalBugCnt",2805,"totalTaskCnt",1446,"totalBudgetNouserAmount",3067.37,"id","t8y3","totalStaffCnt",4323,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","c","totalCostNouserAmount",2987.78,"totalClosedBugCnt",2926,"totalResolvedBugCnt",9862,"totalCompleteTaskCnt",3701,"totalPhaseCnt",1150,"totalCompletePhaseCnt",1846,"totalNeedPayAmount",8156.61,"totalFinishPayAmount",6895.58,"totalNeedColAmount",1213.76,"totalFinishColAmount",5685.92,"totalCostUserAmount",9362.89,"totalBudgetInnerUserAmount",9082.41,"totalPlanWorkload",2148.47,"totalRiskCnt",195,"totalCompleteRiskCnt",3275,"branchId","3t79","branchName","RoBp","totalBudgetOutUserAmount",9797.26,"totalCompleteWorkload",4923.03,"totalCostInnerUserAmount",5958.76,"totalCostOutUserAmount",4382.82,"totalProgress",5717.48,"totalActiveBugCnt",1588,"totalConfirmedBugCnt",2102,"projectStatus","N7Rz","totalActWorkload",4670.36,"totalActOutWorkload",7969,"totalActInnerWorkload",7825,"totalTaskBudgetCostAt",6711.87,"totalTaskOutCnt",3954,"totalNeedPayCnt",6215,"totalFinishPayCnt",336,"totalFinishPayUserCnt",743,"totalNeedPayUserCnt",954,"totalPlanInnerUserWorkload",9327.62,"totalPlanOutUserWorkload",2999.26,"testCases",6926,"execCases",2570,"designCases",9829,"finishCases",4695,"iterationCnt",7487,"productCnt",1137,"menuCnt",4779);
		XmBranchState xmBranchState3=BaseUtils.fromMap(p3,XmBranchState.class);
		batchValues.add(xmBranchState3);
		Map p4=BaseUtils.map("bizDate","SNKD","totalFileCnt",7066,"totalBugCnt",8400,"totalTaskCnt",2617,"totalBudgetNouserAmount",1337.9,"id","018g","totalStaffCnt",8639,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","O","totalCostNouserAmount",4611.01,"totalClosedBugCnt",8262,"totalResolvedBugCnt",8665,"totalCompleteTaskCnt",9404,"totalPhaseCnt",5313,"totalCompletePhaseCnt",3292,"totalNeedPayAmount",6942.09,"totalFinishPayAmount",3246.13,"totalNeedColAmount",8491.72,"totalFinishColAmount",6746.95,"totalCostUserAmount",7021.74,"totalBudgetInnerUserAmount",9902.6,"totalPlanWorkload",9211.2,"totalRiskCnt",3977,"totalCompleteRiskCnt",4480,"branchId","WyHL","branchName","m3TW","totalBudgetOutUserAmount",553.58,"totalCompleteWorkload",1193.08,"totalCostInnerUserAmount",6141.63,"totalCostOutUserAmount",9644.01,"totalProgress",8338.07,"totalActiveBugCnt",1126,"totalConfirmedBugCnt",4,"projectStatus","JpTZ","totalActWorkload",8262.5,"totalActOutWorkload",52,"totalActInnerWorkload",9830,"totalTaskBudgetCostAt",8044.9,"totalTaskOutCnt",3329,"totalNeedPayCnt",6317,"totalFinishPayCnt",5637,"totalFinishPayUserCnt",8841,"totalNeedPayUserCnt",6812,"totalPlanInnerUserWorkload",1314.64,"totalPlanOutUserWorkload",5276.41,"testCases",4131,"execCases",6853,"designCases",5663,"finishCases",8323,"iterationCnt",3448,"productCnt",5168,"menuCnt",5474);
		XmBranchState xmBranchState4=BaseUtils.fromMap(p4,XmBranchState.class);
		batchValues.add(xmBranchState4);
		Map p5=BaseUtils.map("bizDate","fmBM","totalFileCnt",9024,"totalBugCnt",36,"totalTaskCnt",8323,"totalBudgetNouserAmount",492.25,"id","MmOr","totalStaffCnt",100,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","n","totalCostNouserAmount",7408.83,"totalClosedBugCnt",2909,"totalResolvedBugCnt",9209,"totalCompleteTaskCnt",805,"totalPhaseCnt",4306,"totalCompletePhaseCnt",3617,"totalNeedPayAmount",4257.02,"totalFinishPayAmount",3919.3,"totalNeedColAmount",8122.96,"totalFinishColAmount",3005.15,"totalCostUserAmount",7870.65,"totalBudgetInnerUserAmount",9499.16,"totalPlanWorkload",8509.03,"totalRiskCnt",8284,"totalCompleteRiskCnt",3200,"branchId","PAyA","branchName","xR6X","totalBudgetOutUserAmount",5767.06,"totalCompleteWorkload",5026.75,"totalCostInnerUserAmount",3908.83,"totalCostOutUserAmount",3791.59,"totalProgress",9665.26,"totalActiveBugCnt",9772,"totalConfirmedBugCnt",7728,"projectStatus","D6lx","totalActWorkload",484.12,"totalActOutWorkload",7429,"totalActInnerWorkload",9982,"totalTaskBudgetCostAt",1189.02,"totalTaskOutCnt",5961,"totalNeedPayCnt",9939,"totalFinishPayCnt",2331,"totalFinishPayUserCnt",9680,"totalNeedPayUserCnt",9464,"totalPlanInnerUserWorkload",6911.4,"totalPlanOutUserWorkload",7593.65,"testCases",5078,"execCases",3950,"designCases",8464,"finishCases",5395,"iterationCnt",4455,"productCnt",9787,"menuCnt",565);
		XmBranchState xmBranchState5=BaseUtils.fromMap(p5,XmBranchState.class);
		batchValues.add(xmBranchState5);
		Map p6=BaseUtils.map("bizDate","5w0b","totalFileCnt",5502,"totalBugCnt",8318,"totalTaskCnt",1565,"totalBudgetNouserAmount",9994.15,"id","SqXV","totalStaffCnt",1596,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","n","totalCostNouserAmount",4289.72,"totalClosedBugCnt",8032,"totalResolvedBugCnt",2712,"totalCompleteTaskCnt",3745,"totalPhaseCnt",4619,"totalCompletePhaseCnt",7546,"totalNeedPayAmount",927.7,"totalFinishPayAmount",4254.39,"totalNeedColAmount",7455.86,"totalFinishColAmount",767.43,"totalCostUserAmount",1940.53,"totalBudgetInnerUserAmount",1916.97,"totalPlanWorkload",4734.3,"totalRiskCnt",6852,"totalCompleteRiskCnt",5113,"branchId","ktm9","branchName","hR9Q","totalBudgetOutUserAmount",7337.38,"totalCompleteWorkload",9324.27,"totalCostInnerUserAmount",3323.02,"totalCostOutUserAmount",514.87,"totalProgress",232.24,"totalActiveBugCnt",5351,"totalConfirmedBugCnt",2798,"projectStatus","h8QG","totalActWorkload",5147.34,"totalActOutWorkload",8649,"totalActInnerWorkload",7705,"totalTaskBudgetCostAt",2796.98,"totalTaskOutCnt",8776,"totalNeedPayCnt",4116,"totalFinishPayCnt",6151,"totalFinishPayUserCnt",8403,"totalNeedPayUserCnt",7646,"totalPlanInnerUserWorkload",6594.32,"totalPlanOutUserWorkload",1777.59,"testCases",7554,"execCases",7118,"designCases",8152,"finishCases",9229,"iterationCnt",9033,"productCnt",4253,"menuCnt",7953);
		XmBranchState xmBranchState6=BaseUtils.fromMap(p6,XmBranchState.class);
		batchValues.add(xmBranchState6);
		Map p7=BaseUtils.map("bizDate","enRX","totalFileCnt",6354,"totalBugCnt",4035,"totalTaskCnt",9178,"totalBudgetNouserAmount",7529.79,"id","oux7","totalStaffCnt",7065,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","0","totalCostNouserAmount",8653.57,"totalClosedBugCnt",108,"totalResolvedBugCnt",1427,"totalCompleteTaskCnt",3758,"totalPhaseCnt",5303,"totalCompletePhaseCnt",6021,"totalNeedPayAmount",4348.06,"totalFinishPayAmount",8617.88,"totalNeedColAmount",1012.2,"totalFinishColAmount",5430.37,"totalCostUserAmount",4252.56,"totalBudgetInnerUserAmount",4270.5,"totalPlanWorkload",4730.32,"totalRiskCnt",6823,"totalCompleteRiskCnt",611,"branchId","Zc4d","branchName","Iy2q","totalBudgetOutUserAmount",8549.51,"totalCompleteWorkload",7304.19,"totalCostInnerUserAmount",4020.11,"totalCostOutUserAmount",3391.5,"totalProgress",5817.48,"totalActiveBugCnt",8053,"totalConfirmedBugCnt",7060,"projectStatus","ZFjU","totalActWorkload",5269.32,"totalActOutWorkload",6835,"totalActInnerWorkload",2145,"totalTaskBudgetCostAt",9775.07,"totalTaskOutCnt",3231,"totalNeedPayCnt",172,"totalFinishPayCnt",3497,"totalFinishPayUserCnt",6562,"totalNeedPayUserCnt",9021,"totalPlanInnerUserWorkload",4339.51,"totalPlanOutUserWorkload",4501.23,"testCases",5419,"execCases",3519,"designCases",3832,"finishCases",8706,"iterationCnt",4367,"productCnt",2033,"menuCnt",7637);
		XmBranchState xmBranchState7=BaseUtils.fromMap(p7,XmBranchState.class);
		batchValues.add(xmBranchState7);
		baseDao.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmBranchState> batchValues=new ArrayList<XmBranchState>();
		Map p0=BaseUtils.map("bizDate","Utbh","totalFileCnt",3509,"totalBugCnt",3490,"totalTaskCnt",1414,"totalBudgetNouserAmount",3656.61,"id","3lPB","totalStaffCnt",4834,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","h","totalCostNouserAmount",2604.99,"totalClosedBugCnt",7336,"totalResolvedBugCnt",4857,"totalCompleteTaskCnt",4319,"totalPhaseCnt",2620,"totalCompletePhaseCnt",2855,"totalNeedPayAmount",460.84,"totalFinishPayAmount",2248.84,"totalNeedColAmount",7036.19,"totalFinishColAmount",1977.48,"totalCostUserAmount",7584.56,"totalBudgetInnerUserAmount",731.82,"totalPlanWorkload",478.56,"totalRiskCnt",815,"totalCompleteRiskCnt",8669,"branchId","l2y1","branchName","mHQa","totalBudgetOutUserAmount",3404.44,"totalCompleteWorkload",6809.51,"totalCostInnerUserAmount",9219.78,"totalCostOutUserAmount",3531.81,"totalProgress",9024.33,"totalActiveBugCnt",2499,"totalConfirmedBugCnt",318,"projectStatus","Ty46","totalActWorkload",2296.84,"totalActOutWorkload",8928,"totalActInnerWorkload",7763,"totalTaskBudgetCostAt",8054,"totalTaskOutCnt",5624,"totalNeedPayCnt",2162,"totalFinishPayCnt",5737,"totalFinishPayUserCnt",1775,"totalNeedPayUserCnt",8626,"totalPlanInnerUserWorkload",8899.79,"totalPlanOutUserWorkload",4520.12,"testCases",3850,"execCases",4446,"designCases",3370,"finishCases",1885,"iterationCnt",9064,"productCnt",5781,"menuCnt",477);
		XmBranchState xmBranchState0=BaseUtils.fromMap(p0,XmBranchState.class);
		batchValues.add(xmBranchState0);
		Map p1=BaseUtils.map("bizDate","jX0R","totalFileCnt",2299,"totalBugCnt",1962,"totalTaskCnt",7824,"totalBudgetNouserAmount",6362.93,"id","PqC5","totalStaffCnt",2503,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","f","totalCostNouserAmount",9331.83,"totalClosedBugCnt",3737,"totalResolvedBugCnt",4055,"totalCompleteTaskCnt",8638,"totalPhaseCnt",5029,"totalCompletePhaseCnt",9127,"totalNeedPayAmount",495.3,"totalFinishPayAmount",743.36,"totalNeedColAmount",9654.39,"totalFinishColAmount",2625.81,"totalCostUserAmount",8390.31,"totalBudgetInnerUserAmount",9739.71,"totalPlanWorkload",2423.84,"totalRiskCnt",4875,"totalCompleteRiskCnt",9572,"branchId","t7Kz","branchName","hFd1","totalBudgetOutUserAmount",6915.34,"totalCompleteWorkload",1593.52,"totalCostInnerUserAmount",2529.02,"totalCostOutUserAmount",8792.35,"totalProgress",3829.05,"totalActiveBugCnt",3835,"totalConfirmedBugCnt",4019,"projectStatus","0cKj","totalActWorkload",3457.59,"totalActOutWorkload",9155,"totalActInnerWorkload",4410,"totalTaskBudgetCostAt",5094.5,"totalTaskOutCnt",7647,"totalNeedPayCnt",630,"totalFinishPayCnt",3753,"totalFinishPayUserCnt",7433,"totalNeedPayUserCnt",8253,"totalPlanInnerUserWorkload",4908.24,"totalPlanOutUserWorkload",6754.16,"testCases",2063,"execCases",1914,"designCases",3069,"finishCases",4227,"iterationCnt",8740,"productCnt",8113,"menuCnt",8542);
		XmBranchState xmBranchState1=BaseUtils.fromMap(p1,XmBranchState.class);
		batchValues.add(xmBranchState1);
		Map p2=BaseUtils.map("bizDate","X1xS","totalFileCnt",6831,"totalBugCnt",1956,"totalTaskCnt",3530,"totalBudgetNouserAmount",3462.74,"id","Vxk4","totalStaffCnt",2564,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","y","totalCostNouserAmount",108.01,"totalClosedBugCnt",2331,"totalResolvedBugCnt",3865,"totalCompleteTaskCnt",5521,"totalPhaseCnt",4363,"totalCompletePhaseCnt",5892,"totalNeedPayAmount",6013.07,"totalFinishPayAmount",4100.04,"totalNeedColAmount",1727.53,"totalFinishColAmount",5948.85,"totalCostUserAmount",6694.83,"totalBudgetInnerUserAmount",1375.5,"totalPlanWorkload",8539.04,"totalRiskCnt",5732,"totalCompleteRiskCnt",9602,"branchId","w4tu","branchName","DNpd","totalBudgetOutUserAmount",8418.35,"totalCompleteWorkload",8194.61,"totalCostInnerUserAmount",7982.59,"totalCostOutUserAmount",5354.18,"totalProgress",7146.76,"totalActiveBugCnt",3059,"totalConfirmedBugCnt",5609,"projectStatus","z84o","totalActWorkload",6106.39,"totalActOutWorkload",1867,"totalActInnerWorkload",8637,"totalTaskBudgetCostAt",1912.21,"totalTaskOutCnt",4574,"totalNeedPayCnt",8180,"totalFinishPayCnt",8582,"totalFinishPayUserCnt",4743,"totalNeedPayUserCnt",900,"totalPlanInnerUserWorkload",5566.73,"totalPlanOutUserWorkload",5912.09,"testCases",3826,"execCases",7979,"designCases",7192,"finishCases",5683,"iterationCnt",6250,"productCnt",8695,"menuCnt",7223);
		XmBranchState xmBranchState2=BaseUtils.fromMap(p2,XmBranchState.class);
		batchValues.add(xmBranchState2);
		Map p3=BaseUtils.map("bizDate","0r7A","totalFileCnt",6472,"totalBugCnt",2805,"totalTaskCnt",1446,"totalBudgetNouserAmount",3067.37,"id","t8y3","totalStaffCnt",4323,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","c","totalCostNouserAmount",2987.78,"totalClosedBugCnt",2926,"totalResolvedBugCnt",9862,"totalCompleteTaskCnt",3701,"totalPhaseCnt",1150,"totalCompletePhaseCnt",1846,"totalNeedPayAmount",8156.61,"totalFinishPayAmount",6895.58,"totalNeedColAmount",1213.76,"totalFinishColAmount",5685.92,"totalCostUserAmount",9362.89,"totalBudgetInnerUserAmount",9082.41,"totalPlanWorkload",2148.47,"totalRiskCnt",195,"totalCompleteRiskCnt",3275,"branchId","3t79","branchName","RoBp","totalBudgetOutUserAmount",9797.26,"totalCompleteWorkload",4923.03,"totalCostInnerUserAmount",5958.76,"totalCostOutUserAmount",4382.82,"totalProgress",5717.48,"totalActiveBugCnt",1588,"totalConfirmedBugCnt",2102,"projectStatus","N7Rz","totalActWorkload",4670.36,"totalActOutWorkload",7969,"totalActInnerWorkload",7825,"totalTaskBudgetCostAt",6711.87,"totalTaskOutCnt",3954,"totalNeedPayCnt",6215,"totalFinishPayCnt",336,"totalFinishPayUserCnt",743,"totalNeedPayUserCnt",954,"totalPlanInnerUserWorkload",9327.62,"totalPlanOutUserWorkload",2999.26,"testCases",6926,"execCases",2570,"designCases",9829,"finishCases",4695,"iterationCnt",7487,"productCnt",1137,"menuCnt",4779);
		XmBranchState xmBranchState3=BaseUtils.fromMap(p3,XmBranchState.class);
		batchValues.add(xmBranchState3);
		Map p4=BaseUtils.map("bizDate","SNKD","totalFileCnt",7066,"totalBugCnt",8400,"totalTaskCnt",2617,"totalBudgetNouserAmount",1337.9,"id","018g","totalStaffCnt",8639,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","O","totalCostNouserAmount",4611.01,"totalClosedBugCnt",8262,"totalResolvedBugCnt",8665,"totalCompleteTaskCnt",9404,"totalPhaseCnt",5313,"totalCompletePhaseCnt",3292,"totalNeedPayAmount",6942.09,"totalFinishPayAmount",3246.13,"totalNeedColAmount",8491.72,"totalFinishColAmount",6746.95,"totalCostUserAmount",7021.74,"totalBudgetInnerUserAmount",9902.6,"totalPlanWorkload",9211.2,"totalRiskCnt",3977,"totalCompleteRiskCnt",4480,"branchId","WyHL","branchName","m3TW","totalBudgetOutUserAmount",553.58,"totalCompleteWorkload",1193.08,"totalCostInnerUserAmount",6141.63,"totalCostOutUserAmount",9644.01,"totalProgress",8338.07,"totalActiveBugCnt",1126,"totalConfirmedBugCnt",4,"projectStatus","JpTZ","totalActWorkload",8262.5,"totalActOutWorkload",52,"totalActInnerWorkload",9830,"totalTaskBudgetCostAt",8044.9,"totalTaskOutCnt",3329,"totalNeedPayCnt",6317,"totalFinishPayCnt",5637,"totalFinishPayUserCnt",8841,"totalNeedPayUserCnt",6812,"totalPlanInnerUserWorkload",1314.64,"totalPlanOutUserWorkload",5276.41,"testCases",4131,"execCases",6853,"designCases",5663,"finishCases",8323,"iterationCnt",3448,"productCnt",5168,"menuCnt",5474);
		XmBranchState xmBranchState4=BaseUtils.fromMap(p4,XmBranchState.class);
		batchValues.add(xmBranchState4);
		Map p5=BaseUtils.map("bizDate","fmBM","totalFileCnt",9024,"totalBugCnt",36,"totalTaskCnt",8323,"totalBudgetNouserAmount",492.25,"id","MmOr","totalStaffCnt",100,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","n","totalCostNouserAmount",7408.83,"totalClosedBugCnt",2909,"totalResolvedBugCnt",9209,"totalCompleteTaskCnt",805,"totalPhaseCnt",4306,"totalCompletePhaseCnt",3617,"totalNeedPayAmount",4257.02,"totalFinishPayAmount",3919.3,"totalNeedColAmount",8122.96,"totalFinishColAmount",3005.15,"totalCostUserAmount",7870.65,"totalBudgetInnerUserAmount",9499.16,"totalPlanWorkload",8509.03,"totalRiskCnt",8284,"totalCompleteRiskCnt",3200,"branchId","PAyA","branchName","xR6X","totalBudgetOutUserAmount",5767.06,"totalCompleteWorkload",5026.75,"totalCostInnerUserAmount",3908.83,"totalCostOutUserAmount",3791.59,"totalProgress",9665.26,"totalActiveBugCnt",9772,"totalConfirmedBugCnt",7728,"projectStatus","D6lx","totalActWorkload",484.12,"totalActOutWorkload",7429,"totalActInnerWorkload",9982,"totalTaskBudgetCostAt",1189.02,"totalTaskOutCnt",5961,"totalNeedPayCnt",9939,"totalFinishPayCnt",2331,"totalFinishPayUserCnt",9680,"totalNeedPayUserCnt",9464,"totalPlanInnerUserWorkload",6911.4,"totalPlanOutUserWorkload",7593.65,"testCases",5078,"execCases",3950,"designCases",8464,"finishCases",5395,"iterationCnt",4455,"productCnt",9787,"menuCnt",565);
		XmBranchState xmBranchState5=BaseUtils.fromMap(p5,XmBranchState.class);
		batchValues.add(xmBranchState5);
		Map p6=BaseUtils.map("bizDate","5w0b","totalFileCnt",5502,"totalBugCnt",8318,"totalTaskCnt",1565,"totalBudgetNouserAmount",9994.15,"id","SqXV","totalStaffCnt",1596,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","n","totalCostNouserAmount",4289.72,"totalClosedBugCnt",8032,"totalResolvedBugCnt",2712,"totalCompleteTaskCnt",3745,"totalPhaseCnt",4619,"totalCompletePhaseCnt",7546,"totalNeedPayAmount",927.7,"totalFinishPayAmount",4254.39,"totalNeedColAmount",7455.86,"totalFinishColAmount",767.43,"totalCostUserAmount",1940.53,"totalBudgetInnerUserAmount",1916.97,"totalPlanWorkload",4734.3,"totalRiskCnt",6852,"totalCompleteRiskCnt",5113,"branchId","ktm9","branchName","hR9Q","totalBudgetOutUserAmount",7337.38,"totalCompleteWorkload",9324.27,"totalCostInnerUserAmount",3323.02,"totalCostOutUserAmount",514.87,"totalProgress",232.24,"totalActiveBugCnt",5351,"totalConfirmedBugCnt",2798,"projectStatus","h8QG","totalActWorkload",5147.34,"totalActOutWorkload",8649,"totalActInnerWorkload",7705,"totalTaskBudgetCostAt",2796.98,"totalTaskOutCnt",8776,"totalNeedPayCnt",4116,"totalFinishPayCnt",6151,"totalFinishPayUserCnt",8403,"totalNeedPayUserCnt",7646,"totalPlanInnerUserWorkload",6594.32,"totalPlanOutUserWorkload",1777.59,"testCases",7554,"execCases",7118,"designCases",8152,"finishCases",9229,"iterationCnt",9033,"productCnt",4253,"menuCnt",7953);
		XmBranchState xmBranchState6=BaseUtils.fromMap(p6,XmBranchState.class);
		batchValues.add(xmBranchState6);
		Map p7=BaseUtils.map("bizDate","enRX","totalFileCnt",6354,"totalBugCnt",4035,"totalTaskCnt",9178,"totalBudgetNouserAmount",7529.79,"id","oux7","totalStaffCnt",7065,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","0","totalCostNouserAmount",8653.57,"totalClosedBugCnt",108,"totalResolvedBugCnt",1427,"totalCompleteTaskCnt",3758,"totalPhaseCnt",5303,"totalCompletePhaseCnt",6021,"totalNeedPayAmount",4348.06,"totalFinishPayAmount",8617.88,"totalNeedColAmount",1012.2,"totalFinishColAmount",5430.37,"totalCostUserAmount",4252.56,"totalBudgetInnerUserAmount",4270.5,"totalPlanWorkload",4730.32,"totalRiskCnt",6823,"totalCompleteRiskCnt",611,"branchId","Zc4d","branchName","Iy2q","totalBudgetOutUserAmount",8549.51,"totalCompleteWorkload",7304.19,"totalCostInnerUserAmount",4020.11,"totalCostOutUserAmount",3391.5,"totalProgress",5817.48,"totalActiveBugCnt",8053,"totalConfirmedBugCnt",7060,"projectStatus","ZFjU","totalActWorkload",5269.32,"totalActOutWorkload",6835,"totalActInnerWorkload",2145,"totalTaskBudgetCostAt",9775.07,"totalTaskOutCnt",3231,"totalNeedPayCnt",172,"totalFinishPayCnt",3497,"totalFinishPayUserCnt",6562,"totalNeedPayUserCnt",9021,"totalPlanInnerUserWorkload",4339.51,"totalPlanOutUserWorkload",4501.23,"testCases",5419,"execCases",3519,"designCases",3832,"finishCases",8706,"iterationCnt",4367,"productCnt",2033,"menuCnt",7637);
		XmBranchState xmBranchState7=BaseUtils.fromMap(p7,XmBranchState.class);
		batchValues.add(xmBranchState7);
		baseDao.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","3lPB");
		Map<String,Object> result=this.baseDao.selectOne(XmBranchState.class.getName()+".selectOneMap",p);
		Assert.assertEquals("3lPB", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("bizDate","Utbh","totalFileCnt",3509,"totalBugCnt",3490,"totalTaskCnt",1414,"totalBudgetNouserAmount",3656.61,"totalStaffCnt",4834,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","h","totalCostNouserAmount",2604.99,"totalClosedBugCnt",7336,"totalResolvedBugCnt",4857,"totalCompleteTaskCnt",4319,"totalPhaseCnt",2620,"totalCompletePhaseCnt",2855,"totalNeedPayAmount",460.84,"totalFinishPayAmount",2248.84,"totalNeedColAmount",7036.19,"totalFinishColAmount",1977.48,"totalCostUserAmount",7584.56,"totalBudgetInnerUserAmount",731.82,"totalPlanWorkload",478.56,"totalRiskCnt",815,"totalCompleteRiskCnt",8669,"branchId","l2y1","branchName","mHQa","totalBudgetOutUserAmount",3404.44,"totalCompleteWorkload",6809.51,"totalCostInnerUserAmount",9219.78,"totalCostOutUserAmount",3531.81,"totalProgress",9024.33,"totalActiveBugCnt",2499,"totalConfirmedBugCnt",318,"projectStatus","Ty46","totalActWorkload",2296.84,"totalActOutWorkload",8928,"totalActInnerWorkload",7763,"totalTaskBudgetCostAt",8054,"totalTaskOutCnt",5624,"totalNeedPayCnt",2162,"totalFinishPayCnt",5737,"totalFinishPayUserCnt",1775,"totalNeedPayUserCnt",8626,"totalPlanInnerUserWorkload",8899.79,"totalPlanOutUserWorkload",4520.12,"testCases",3850,"execCases",4446,"designCases",3370,"finishCases",1885,"iterationCnt",9064,"productCnt",5781,"menuCnt",477);
		XmBranchState xmBranchState=BaseUtils.fromMap(p,XmBranchState.class);
		long result=baseDao.countByWhere(xmBranchState);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
 		
		
		Map<String,Object> p=BaseUtils.map("bizDate","Utbh","totalFileCnt",3509,"totalBugCnt",3490,"totalTaskCnt",1414,"totalBudgetNouserAmount",3656.61,"totalStaffCnt",4834,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","h","totalCostNouserAmount",2604.99,"totalClosedBugCnt",7336,"totalResolvedBugCnt",4857,"totalCompleteTaskCnt",4319,"totalPhaseCnt",2620,"totalCompletePhaseCnt",2855,"totalNeedPayAmount",460.84,"totalFinishPayAmount",2248.84,"totalNeedColAmount",7036.19,"totalFinishColAmount",1977.48,"totalCostUserAmount",7584.56,"totalBudgetInnerUserAmount",731.82,"totalPlanWorkload",478.56,"totalRiskCnt",815,"totalCompleteRiskCnt",8669,"branchId","l2y1","branchName","mHQa","totalBudgetOutUserAmount",3404.44,"totalCompleteWorkload",6809.51,"totalCostInnerUserAmount",9219.78,"totalCostOutUserAmount",3531.81,"totalProgress",9024.33,"totalActiveBugCnt",2499,"totalConfirmedBugCnt",318,"projectStatus","Ty46","totalActWorkload",2296.84,"totalActOutWorkload",8928,"totalActInnerWorkload",7763,"totalTaskBudgetCostAt",8054,"totalTaskOutCnt",5624,"totalNeedPayCnt",2162,"totalFinishPayCnt",5737,"totalFinishPayUserCnt",1775,"totalNeedPayUserCnt",8626,"totalPlanInnerUserWorkload",8899.79,"totalPlanOutUserWorkload",4520.12,"testCases",3850,"execCases",4446,"designCases",3370,"finishCases",1885,"iterationCnt",9064,"productCnt",5781,"menuCnt",477);
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmBranchState xmBranchState=BaseUtils.fromMap(p,XmBranchState.class);
		List<XmBranchState> result=baseDao.selectListByWhere(xmBranchState); 
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
	
		
		Map<String,Object> p=BaseUtils.map("bizDate","Utbh","totalFileCnt",3509,"totalBugCnt",3490,"totalTaskCnt",1414,"totalBudgetNouserAmount",3656.61,"totalStaffCnt",4834,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","h","totalCostNouserAmount",2604.99,"totalClosedBugCnt",7336,"totalResolvedBugCnt",4857,"totalCompleteTaskCnt",4319,"totalPhaseCnt",2620,"totalCompletePhaseCnt",2855,"totalNeedPayAmount",460.84,"totalFinishPayAmount",2248.84,"totalNeedColAmount",7036.19,"totalFinishColAmount",1977.48,"totalCostUserAmount",7584.56,"totalBudgetInnerUserAmount",731.82,"totalPlanWorkload",478.56,"totalRiskCnt",815,"totalCompleteRiskCnt",8669,"branchId","l2y1","branchName","mHQa","totalBudgetOutUserAmount",3404.44,"totalCompleteWorkload",6809.51,"totalCostInnerUserAmount",9219.78,"totalCostOutUserAmount",3531.81,"totalProgress",9024.33,"totalActiveBugCnt",2499,"totalConfirmedBugCnt",318,"projectStatus","Ty46","totalActWorkload",2296.84,"totalActOutWorkload",8928,"totalActInnerWorkload",7763,"totalTaskBudgetCostAt",8054,"totalTaskOutCnt",5624,"totalNeedPayCnt",2162,"totalFinishPayCnt",5737,"totalFinishPayUserCnt",1775,"totalNeedPayUserCnt",8626,"totalPlanInnerUserWorkload",8899.79,"totalPlanOutUserWorkload",4520.12,"testCases",3850,"execCases",4446,"designCases",3370,"finishCases",1885,"iterationCnt",9064,"productCnt",5781,"menuCnt",477);
		XmBranchState xmBranchState=BaseUtils.fromMap(p,XmBranchState.class);
		List<XmBranchState> result=baseDao.selectListByWhere(xmBranchState);
		Assert.assertEquals(true, result.size()>=1);
	}

	
	/**
	 * 查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("bizDate","Utbh","totalFileCnt",3509,"totalBugCnt",3490,"totalTaskCnt",1414,"totalBudgetNouserAmount",3656.61,"totalStaffCnt",4834,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","h","totalCostNouserAmount",2604.99,"totalClosedBugCnt",7336,"totalResolvedBugCnt",4857,"totalCompleteTaskCnt",4319,"totalPhaseCnt",2620,"totalCompletePhaseCnt",2855,"totalNeedPayAmount",460.84,"totalFinishPayAmount",2248.84,"totalNeedColAmount",7036.19,"totalFinishColAmount",1977.48,"totalCostUserAmount",7584.56,"totalBudgetInnerUserAmount",731.82,"totalPlanWorkload",478.56,"totalRiskCnt",815,"totalCompleteRiskCnt",8669,"branchId","l2y1","branchName","mHQa","totalBudgetOutUserAmount",3404.44,"totalCompleteWorkload",6809.51,"totalCostInnerUserAmount",9219.78,"totalCostOutUserAmount",3531.81,"totalProgress",9024.33,"totalActiveBugCnt",2499,"totalConfirmedBugCnt",318,"projectStatus","Ty46","totalActWorkload",2296.84,"totalActOutWorkload",8928,"totalActInnerWorkload",7763,"totalTaskBudgetCostAt",8054,"totalTaskOutCnt",5624,"totalNeedPayCnt",2162,"totalFinishPayCnt",5737,"totalFinishPayUserCnt",1775,"totalNeedPayUserCnt",8626,"totalPlanInnerUserWorkload",8899.79,"totalPlanOutUserWorkload",4520.12,"testCases",3850,"execCases",4446,"designCases",3370,"finishCases",1885,"iterationCnt",9064,"productCnt",5781,"menuCnt",477);
		List<Map<String,Object>> result=baseDao.selectList(XmBranchState.class.getName()+".selectListMapByWhere",p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("bizDate","Utbh","totalFileCnt",3509,"totalBugCnt",3490,"totalTaskCnt",1414,"totalBudgetNouserAmount",3656.61,"totalStaffCnt",4834,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","h","totalCostNouserAmount",2604.99,"totalClosedBugCnt",7336,"totalResolvedBugCnt",4857,"totalCompleteTaskCnt",4319,"totalPhaseCnt",2620,"totalCompletePhaseCnt",2855,"totalNeedPayAmount",460.84,"totalFinishPayAmount",2248.84,"totalNeedColAmount",7036.19,"totalFinishColAmount",1977.48,"totalCostUserAmount",7584.56,"totalBudgetInnerUserAmount",731.82,"totalPlanWorkload",478.56,"totalRiskCnt",815,"totalCompleteRiskCnt",8669,"branchId","l2y1","branchName","mHQa","totalBudgetOutUserAmount",3404.44,"totalCompleteWorkload",6809.51,"totalCostInnerUserAmount",9219.78,"totalCostOutUserAmount",3531.81,"totalProgress",9024.33,"totalActiveBugCnt",2499,"totalConfirmedBugCnt",318,"projectStatus","Ty46","totalActWorkload",2296.84,"totalActOutWorkload",8928,"totalActInnerWorkload",7763,"totalTaskBudgetCostAt",8054,"totalTaskOutCnt",5624,"totalNeedPayCnt",2162,"totalFinishPayCnt",5737,"totalFinishPayUserCnt",1775,"totalNeedPayUserCnt",8626,"totalPlanInnerUserWorkload",8899.79,"totalPlanOutUserWorkload",4520.12,"testCases",3850,"execCases",4446,"designCases",3370,"finishCases",1885,"iterationCnt",9064,"productCnt",5781,"menuCnt",477);
		List<Map<String,Object>> result=baseDao.selectList(XmBranchState.class.getName()+".selectListMapByKey",p);
		Assert.assertEquals(true, result.size()>=0);
	}
 
	/**
	 * 查询一个对象 XmBranchState
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","3lPB");
		
		XmBranchState xmBranchState1=BaseUtils.fromMap(p,XmBranchState.class);
		XmBranchState xmBranchState=baseDao.selectOneObject(xmBranchState1);
		Assert.assertEquals("3lPB", xmBranchState.getId());
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
