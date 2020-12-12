package  com.qqkj.xm.core.service;

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
import  com.qqkj.xm.core.service.XmProjectStateService; 
import com.qqkj.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import  com.qqkj.xm.core.entity.XmProjectState;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmProjectStateService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_project_state 项目指标日统计表<br>
 * 实体 XmProjectState<br>
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
public class TestXmProjectStateService  {

	@Autowired
	XmProjectStateService xmProjectStateService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("projectId","ih6M","bizDate","mvvJ","totalFileCnt",214,"totalBugCnt",3369,"totalTaskCnt",8248,"totalBudgetNouserAmount",4559.02,"projectName","mOeY","id","83WG","totalStaffCnt",9159,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","I","totalCostNouserAmount",2149.4,"totalClosedBugCnt",6426,"totalResolvedBugCnt",1869,"totalCompleteTaskCnt",457,"totalPhaseCnt",3558,"totalCompletePhaseCnt",6023,"totalNeedPayAmount",3802.24,"totalFinishPayAmount",5085.07,"totalNeedColAmount",5618.84,"totalFinishColAmount",2004.43,"totalCostUserAmount",8543.72,"totalBudgetInnerUserAmount",9334.07,"totalPlanWorkload",9155.77,"totalRiskCnt",7067,"totalCompleteRiskCnt",5877,"branchId","3ZKc","branchName","4gAp","totalBudgetOutUserAmount",4284.88,"totalCompleteWorkload",7116.47,"totalCostInnerUserAmount",384.59,"totalCostOutUserAmount",196.85,"totalProgress",378.32,"totalActiveBugCnt",2511,"totalConfirmedBugCnt",9085,"projectStatus","tm55","totalActWorkload",2512.47,"totalActOutWorkload",6974,"totalActInnerWorkload",5361,"totalTaskBudgetCostAt",8388.04,"totalTaskOutCnt",3046,"totalNeedPayCnt",5796,"totalFinishPayCnt",2461,"totalFinishPayUserCnt",6835,"totalNeedPayUserCnt",531,"totalPlanInnerUserWorkload",1784.03,"totalPlanOutUserWorkload",9505.94,"testCases",8986,"execCases",4983,"designCases",9950,"finishCases",749,"iterationCnt",3638,"productCnt",3424,"menuCnt",1745);
		XmProjectState xmProjectState=BaseUtils.fromMap(p,XmProjectState.class);
		xmProjectStateService.insert(xmProjectState);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","ih6M","bizDate","mvvJ","totalFileCnt",214,"totalBugCnt",3369,"totalTaskCnt",8248,"totalBudgetNouserAmount",4559.02,"projectName","mOeY","totalStaffCnt",9159,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","I","totalCostNouserAmount",2149.4,"totalClosedBugCnt",6426,"totalResolvedBugCnt",1869,"totalCompleteTaskCnt",457,"totalPhaseCnt",3558,"totalCompletePhaseCnt",6023,"totalNeedPayAmount",3802.24,"totalFinishPayAmount",5085.07,"totalNeedColAmount",5618.84,"totalFinishColAmount",2004.43,"totalCostUserAmount",8543.72,"totalBudgetInnerUserAmount",9334.07,"totalPlanWorkload",9155.77,"totalRiskCnt",7067,"totalCompleteRiskCnt",5877,"branchId","3ZKc","branchName","4gAp","totalBudgetOutUserAmount",4284.88,"totalCompleteWorkload",7116.47,"totalCostInnerUserAmount",384.59,"totalCostOutUserAmount",196.85,"totalProgress",378.32,"totalActiveBugCnt",2511,"totalConfirmedBugCnt",9085,"projectStatus","tm55","totalActWorkload",2512.47,"totalActOutWorkload",6974,"totalActInnerWorkload",5361,"totalTaskBudgetCostAt",8388.04,"totalTaskOutCnt",3046,"totalNeedPayCnt",5796,"totalFinishPayCnt",2461,"totalFinishPayUserCnt",6835,"totalNeedPayUserCnt",531,"totalPlanInnerUserWorkload",1784.03,"totalPlanOutUserWorkload",9505.94,"testCases",8986,"execCases",4983,"designCases",9950,"finishCases",749,"iterationCnt",3638,"productCnt",3424,"menuCnt",1745);
		XmProjectState xmProjectState=BaseUtils.fromMap(p,XmProjectState.class);
		xmProjectStateService.deleteByWhere(xmProjectState);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","83WG");
		XmProjectState xmProjectState=BaseUtils.fromMap(p,XmProjectState.class);
		xmProjectStateService.deleteByPk(xmProjectState);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("projectId","ih6M","bizDate","mvvJ","totalFileCnt",214,"totalBugCnt",3369,"totalTaskCnt",8248,"totalBudgetNouserAmount",4559.02,"projectName","mOeY","totalStaffCnt",9159,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","I","totalCostNouserAmount",2149.4,"totalClosedBugCnt",6426,"totalResolvedBugCnt",1869,"totalCompleteTaskCnt",457,"totalPhaseCnt",3558,"totalCompletePhaseCnt",6023,"totalNeedPayAmount",3802.24,"totalFinishPayAmount",5085.07,"totalNeedColAmount",5618.84,"totalFinishColAmount",2004.43,"totalCostUserAmount",8543.72,"totalBudgetInnerUserAmount",9334.07,"totalPlanWorkload",9155.77,"totalRiskCnt",7067,"totalCompleteRiskCnt",5877,"branchId","3ZKc","branchName","4gAp","totalBudgetOutUserAmount",4284.88,"totalCompleteWorkload",7116.47,"totalCostInnerUserAmount",384.59,"totalCostOutUserAmount",196.85,"totalProgress",378.32,"totalActiveBugCnt",2511,"totalConfirmedBugCnt",9085,"projectStatus","tm55","totalActWorkload",2512.47,"totalActOutWorkload",6974,"totalActInnerWorkload",5361,"totalTaskBudgetCostAt",8388.04,"totalTaskOutCnt",3046,"totalNeedPayCnt",5796,"totalFinishPayCnt",2461,"totalFinishPayUserCnt",6835,"totalNeedPayUserCnt",531,"totalPlanInnerUserWorkload",1784.03,"totalPlanOutUserWorkload",9505.94,"testCases",8986,"execCases",4983,"designCases",9950,"finishCases",749,"iterationCnt",3638,"productCnt",3424,"menuCnt",1745);
		XmProjectState xmProjectState=BaseUtils.fromMap(where,XmProjectState.class);
		xmProjectStateService.updateSomeFieldByPk(xmProjectState);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","83WG");
		XmProjectState xmProjectState=BaseUtils.fromMap(p,XmProjectState.class);
		xmProjectStateService.updateByPk(xmProjectState);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("projectId","ih6M","bizDate","mvvJ","totalFileCnt",214,"totalBugCnt",3369,"totalTaskCnt",8248,"totalBudgetNouserAmount",4559.02,"projectName","mOeY","id","83WG","totalStaffCnt",9159,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","I","totalCostNouserAmount",2149.4,"totalClosedBugCnt",6426,"totalResolvedBugCnt",1869,"totalCompleteTaskCnt",457,"totalPhaseCnt",3558,"totalCompletePhaseCnt",6023,"totalNeedPayAmount",3802.24,"totalFinishPayAmount",5085.07,"totalNeedColAmount",5618.84,"totalFinishColAmount",2004.43,"totalCostUserAmount",8543.72,"totalBudgetInnerUserAmount",9334.07,"totalPlanWorkload",9155.77,"totalRiskCnt",7067,"totalCompleteRiskCnt",5877,"branchId","3ZKc","branchName","4gAp","totalBudgetOutUserAmount",4284.88,"totalCompleteWorkload",7116.47,"totalCostInnerUserAmount",384.59,"totalCostOutUserAmount",196.85,"totalProgress",378.32,"totalActiveBugCnt",2511,"totalConfirmedBugCnt",9085,"projectStatus","tm55","totalActWorkload",2512.47,"totalActOutWorkload",6974,"totalActInnerWorkload",5361,"totalTaskBudgetCostAt",8388.04,"totalTaskOutCnt",3046,"totalNeedPayCnt",5796,"totalFinishPayCnt",2461,"totalFinishPayUserCnt",6835,"totalNeedPayUserCnt",531,"totalPlanInnerUserWorkload",1784.03,"totalPlanOutUserWorkload",9505.94,"testCases",8986,"execCases",4983,"designCases",9950,"finishCases",749,"iterationCnt",3638,"productCnt",3424,"menuCnt",1745);
		XmProjectState xmProjectState=BaseUtils.fromMap(p,XmProjectState.class);
		xmProjectStateService.insertOrUpdate(xmProjectState);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmProjectState> batchValues=new ArrayList<XmProjectState>();
		Map p0=BaseUtils.map("projectId","ih6M","bizDate","mvvJ","totalFileCnt",214,"totalBugCnt",3369,"totalTaskCnt",8248,"totalBudgetNouserAmount",4559.02,"projectName","mOeY","id","83WG","totalStaffCnt",9159,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","I","totalCostNouserAmount",2149.4,"totalClosedBugCnt",6426,"totalResolvedBugCnt",1869,"totalCompleteTaskCnt",457,"totalPhaseCnt",3558,"totalCompletePhaseCnt",6023,"totalNeedPayAmount",3802.24,"totalFinishPayAmount",5085.07,"totalNeedColAmount",5618.84,"totalFinishColAmount",2004.43,"totalCostUserAmount",8543.72,"totalBudgetInnerUserAmount",9334.07,"totalPlanWorkload",9155.77,"totalRiskCnt",7067,"totalCompleteRiskCnt",5877,"branchId","3ZKc","branchName","4gAp","totalBudgetOutUserAmount",4284.88,"totalCompleteWorkload",7116.47,"totalCostInnerUserAmount",384.59,"totalCostOutUserAmount",196.85,"totalProgress",378.32,"totalActiveBugCnt",2511,"totalConfirmedBugCnt",9085,"projectStatus","tm55","totalActWorkload",2512.47,"totalActOutWorkload",6974,"totalActInnerWorkload",5361,"totalTaskBudgetCostAt",8388.04,"totalTaskOutCnt",3046,"totalNeedPayCnt",5796,"totalFinishPayCnt",2461,"totalFinishPayUserCnt",6835,"totalNeedPayUserCnt",531,"totalPlanInnerUserWorkload",1784.03,"totalPlanOutUserWorkload",9505.94,"testCases",8986,"execCases",4983,"designCases",9950,"finishCases",749,"iterationCnt",3638,"productCnt",3424,"menuCnt",1745);
		XmProjectState xmProjectState0=BaseUtils.fromMap(p0,XmProjectState.class);
		batchValues.add(xmProjectState0);
		Map p1=BaseUtils.map("projectId","PW9R","bizDate","kqj4","totalFileCnt",4887,"totalBugCnt",1078,"totalTaskCnt",978,"totalBudgetNouserAmount",7553.12,"projectName","y02e","id","1pvE","totalStaffCnt",5039,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","4","totalCostNouserAmount",5966.95,"totalClosedBugCnt",6949,"totalResolvedBugCnt",8622,"totalCompleteTaskCnt",5162,"totalPhaseCnt",593,"totalCompletePhaseCnt",894,"totalNeedPayAmount",9580.55,"totalFinishPayAmount",2820.5,"totalNeedColAmount",2403.4,"totalFinishColAmount",7167.49,"totalCostUserAmount",6964.35,"totalBudgetInnerUserAmount",3581.8,"totalPlanWorkload",3119.09,"totalRiskCnt",4423,"totalCompleteRiskCnt",1943,"branchId","3nTP","branchName","vMCE","totalBudgetOutUserAmount",789.77,"totalCompleteWorkload",9569.32,"totalCostInnerUserAmount",3511.49,"totalCostOutUserAmount",3100.51,"totalProgress",736.67,"totalActiveBugCnt",1903,"totalConfirmedBugCnt",8325,"projectStatus","27K5","totalActWorkload",747.11,"totalActOutWorkload",8137,"totalActInnerWorkload",8559,"totalTaskBudgetCostAt",9844.35,"totalTaskOutCnt",1310,"totalNeedPayCnt",7199,"totalFinishPayCnt",8142,"totalFinishPayUserCnt",2402,"totalNeedPayUserCnt",5861,"totalPlanInnerUserWorkload",7904.79,"totalPlanOutUserWorkload",4895.88,"testCases",6257,"execCases",8577,"designCases",4253,"finishCases",3640,"iterationCnt",9889,"productCnt",545,"menuCnt",2911);
		XmProjectState xmProjectState1=BaseUtils.fromMap(p1,XmProjectState.class);
		batchValues.add(xmProjectState1);
		Map p2=BaseUtils.map("projectId","6T54","bizDate","mLP8","totalFileCnt",3328,"totalBugCnt",3222,"totalTaskCnt",6972,"totalBudgetNouserAmount",33.02,"projectName","KKhr","id","4Q0m","totalStaffCnt",6823,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","P","totalCostNouserAmount",6832.55,"totalClosedBugCnt",7766,"totalResolvedBugCnt",2777,"totalCompleteTaskCnt",7289,"totalPhaseCnt",5838,"totalCompletePhaseCnt",5915,"totalNeedPayAmount",5894.52,"totalFinishPayAmount",250.45,"totalNeedColAmount",7981.39,"totalFinishColAmount",925.41,"totalCostUserAmount",4368.75,"totalBudgetInnerUserAmount",383.68,"totalPlanWorkload",6703.83,"totalRiskCnt",5898,"totalCompleteRiskCnt",6461,"branchId","1n0U","branchName","UnDU","totalBudgetOutUserAmount",5794.81,"totalCompleteWorkload",9139.98,"totalCostInnerUserAmount",7253.32,"totalCostOutUserAmount",5676.49,"totalProgress",3084.74,"totalActiveBugCnt",3434,"totalConfirmedBugCnt",6071,"projectStatus","mZX2","totalActWorkload",2618.75,"totalActOutWorkload",1377,"totalActInnerWorkload",5167,"totalTaskBudgetCostAt",4024.34,"totalTaskOutCnt",4797,"totalNeedPayCnt",1184,"totalFinishPayCnt",8407,"totalFinishPayUserCnt",4946,"totalNeedPayUserCnt",7491,"totalPlanInnerUserWorkload",9106.42,"totalPlanOutUserWorkload",209.63,"testCases",6112,"execCases",7254,"designCases",560,"finishCases",1662,"iterationCnt",8201,"productCnt",6033,"menuCnt",7351);
		XmProjectState xmProjectState2=BaseUtils.fromMap(p2,XmProjectState.class);
		batchValues.add(xmProjectState2);
		Map p3=BaseUtils.map("projectId","63n3","bizDate","092K","totalFileCnt",5698,"totalBugCnt",6658,"totalTaskCnt",9395,"totalBudgetNouserAmount",8761.03,"projectName","slZb","id","uHNq","totalStaffCnt",3614,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","a","totalCostNouserAmount",9888.34,"totalClosedBugCnt",7014,"totalResolvedBugCnt",4188,"totalCompleteTaskCnt",2623,"totalPhaseCnt",1621,"totalCompletePhaseCnt",1446,"totalNeedPayAmount",912.03,"totalFinishPayAmount",5937.52,"totalNeedColAmount",9920.8,"totalFinishColAmount",1648.2,"totalCostUserAmount",8740.53,"totalBudgetInnerUserAmount",3367.73,"totalPlanWorkload",5880.65,"totalRiskCnt",7707,"totalCompleteRiskCnt",9207,"branchId","fRWO","branchName","105n","totalBudgetOutUserAmount",5820.43,"totalCompleteWorkload",1265.54,"totalCostInnerUserAmount",3537.87,"totalCostOutUserAmount",3280.22,"totalProgress",9285.93,"totalActiveBugCnt",1366,"totalConfirmedBugCnt",7804,"projectStatus","Eiuo","totalActWorkload",880,"totalActOutWorkload",7631,"totalActInnerWorkload",8059,"totalTaskBudgetCostAt",3575.52,"totalTaskOutCnt",2242,"totalNeedPayCnt",4105,"totalFinishPayCnt",8515,"totalFinishPayUserCnt",6112,"totalNeedPayUserCnt",3976,"totalPlanInnerUserWorkload",6092.62,"totalPlanOutUserWorkload",7838.95,"testCases",3063,"execCases",3487,"designCases",2735,"finishCases",8374,"iterationCnt",5699,"productCnt",4028,"menuCnt",4593);
		XmProjectState xmProjectState3=BaseUtils.fromMap(p3,XmProjectState.class);
		batchValues.add(xmProjectState3);
		Map p4=BaseUtils.map("projectId","9i9D","bizDate","8JW6","totalFileCnt",7234,"totalBugCnt",1644,"totalTaskCnt",3202,"totalBudgetNouserAmount",2987.21,"projectName","Mg9j","id","60na","totalStaffCnt",5423,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","z","totalCostNouserAmount",1072.35,"totalClosedBugCnt",8986,"totalResolvedBugCnt",968,"totalCompleteTaskCnt",2785,"totalPhaseCnt",7931,"totalCompletePhaseCnt",1566,"totalNeedPayAmount",8103.27,"totalFinishPayAmount",2063.02,"totalNeedColAmount",2528.78,"totalFinishColAmount",6429.16,"totalCostUserAmount",8089.01,"totalBudgetInnerUserAmount",3723.49,"totalPlanWorkload",8424.13,"totalRiskCnt",9759,"totalCompleteRiskCnt",134,"branchId","Ie8G","branchName","UbAp","totalBudgetOutUserAmount",8774.96,"totalCompleteWorkload",1769.41,"totalCostInnerUserAmount",4482.64,"totalCostOutUserAmount",8685.25,"totalProgress",8997.23,"totalActiveBugCnt",3845,"totalConfirmedBugCnt",5914,"projectStatus","U62B","totalActWorkload",8565.02,"totalActOutWorkload",6114,"totalActInnerWorkload",718,"totalTaskBudgetCostAt",474.36,"totalTaskOutCnt",570,"totalNeedPayCnt",1804,"totalFinishPayCnt",3287,"totalFinishPayUserCnt",2179,"totalNeedPayUserCnt",1344,"totalPlanInnerUserWorkload",3929.48,"totalPlanOutUserWorkload",6297.24,"testCases",1862,"execCases",7674,"designCases",2283,"finishCases",7390,"iterationCnt",7880,"productCnt",4410,"menuCnt",3106);
		XmProjectState xmProjectState4=BaseUtils.fromMap(p4,XmProjectState.class);
		batchValues.add(xmProjectState4);
		Map p5=BaseUtils.map("projectId","s371","bizDate","TRQC","totalFileCnt",6847,"totalBugCnt",8502,"totalTaskCnt",4875,"totalBudgetNouserAmount",9321.37,"projectName","8135","id","c9xK","totalStaffCnt",5643,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","E","totalCostNouserAmount",8957.7,"totalClosedBugCnt",5707,"totalResolvedBugCnt",9944,"totalCompleteTaskCnt",6677,"totalPhaseCnt",8824,"totalCompletePhaseCnt",499,"totalNeedPayAmount",8916.58,"totalFinishPayAmount",6422.54,"totalNeedColAmount",6714.62,"totalFinishColAmount",6969,"totalCostUserAmount",949.45,"totalBudgetInnerUserAmount",6057.66,"totalPlanWorkload",9174.11,"totalRiskCnt",7226,"totalCompleteRiskCnt",4065,"branchId","az46","branchName","5c85","totalBudgetOutUserAmount",7258.17,"totalCompleteWorkload",9148.77,"totalCostInnerUserAmount",1557.35,"totalCostOutUserAmount",3562.12,"totalProgress",777.12,"totalActiveBugCnt",8359,"totalConfirmedBugCnt",703,"projectStatus","2CoC","totalActWorkload",4286.47,"totalActOutWorkload",3805,"totalActInnerWorkload",1212,"totalTaskBudgetCostAt",5327.85,"totalTaskOutCnt",6431,"totalNeedPayCnt",235,"totalFinishPayCnt",5113,"totalFinishPayUserCnt",9798,"totalNeedPayUserCnt",2287,"totalPlanInnerUserWorkload",9097.11,"totalPlanOutUserWorkload",5153.8,"testCases",1929,"execCases",4747,"designCases",2446,"finishCases",410,"iterationCnt",7339,"productCnt",4845,"menuCnt",3864);
		XmProjectState xmProjectState5=BaseUtils.fromMap(p5,XmProjectState.class);
		batchValues.add(xmProjectState5);
		Map p6=BaseUtils.map("projectId","sEPg","bizDate","mYFQ","totalFileCnt",4101,"totalBugCnt",828,"totalTaskCnt",3606,"totalBudgetNouserAmount",8408.68,"projectName","3bAM","id","u662","totalStaffCnt",463,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","7","totalCostNouserAmount",9876.47,"totalClosedBugCnt",9214,"totalResolvedBugCnt",7473,"totalCompleteTaskCnt",4463,"totalPhaseCnt",3674,"totalCompletePhaseCnt",6424,"totalNeedPayAmount",3312.84,"totalFinishPayAmount",1650.99,"totalNeedColAmount",7220.53,"totalFinishColAmount",8816.04,"totalCostUserAmount",2688.84,"totalBudgetInnerUserAmount",8665.97,"totalPlanWorkload",3169.76,"totalRiskCnt",3427,"totalCompleteRiskCnt",3052,"branchId","jnrP","branchName","29Ch","totalBudgetOutUserAmount",1149.89,"totalCompleteWorkload",6313.74,"totalCostInnerUserAmount",8803.27,"totalCostOutUserAmount",6855.87,"totalProgress",7088.34,"totalActiveBugCnt",8975,"totalConfirmedBugCnt",7075,"projectStatus","7ZUF","totalActWorkload",1231.06,"totalActOutWorkload",7972,"totalActInnerWorkload",1954,"totalTaskBudgetCostAt",492.57,"totalTaskOutCnt",3576,"totalNeedPayCnt",5830,"totalFinishPayCnt",307,"totalFinishPayUserCnt",4848,"totalNeedPayUserCnt",5401,"totalPlanInnerUserWorkload",1184.48,"totalPlanOutUserWorkload",4989.17,"testCases",9464,"execCases",4670,"designCases",4869,"finishCases",5174,"iterationCnt",3421,"productCnt",6726,"menuCnt",5729);
		XmProjectState xmProjectState6=BaseUtils.fromMap(p6,XmProjectState.class);
		batchValues.add(xmProjectState6);
		Map p7=BaseUtils.map("projectId","SJ5P","bizDate","YmA7","totalFileCnt",1941,"totalBugCnt",3054,"totalTaskCnt",9790,"totalBudgetNouserAmount",229.7,"projectName","H0la","id","l1K5","totalStaffCnt",6453,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","X","totalCostNouserAmount",2419.82,"totalClosedBugCnt",7620,"totalResolvedBugCnt",5241,"totalCompleteTaskCnt",8949,"totalPhaseCnt",7582,"totalCompletePhaseCnt",4716,"totalNeedPayAmount",2513.68,"totalFinishPayAmount",2937.84,"totalNeedColAmount",7767.99,"totalFinishColAmount",1232.07,"totalCostUserAmount",2393.83,"totalBudgetInnerUserAmount",1972.73,"totalPlanWorkload",3353.86,"totalRiskCnt",4111,"totalCompleteRiskCnt",2039,"branchId","Sp04","branchName","fTZ2","totalBudgetOutUserAmount",2012.06,"totalCompleteWorkload",9500.73,"totalCostInnerUserAmount",2598.65,"totalCostOutUserAmount",344.76,"totalProgress",2114.8,"totalActiveBugCnt",9246,"totalConfirmedBugCnt",2086,"projectStatus","NdUL","totalActWorkload",892.53,"totalActOutWorkload",7730,"totalActInnerWorkload",8038,"totalTaskBudgetCostAt",5456.73,"totalTaskOutCnt",5665,"totalNeedPayCnt",5579,"totalFinishPayCnt",4215,"totalFinishPayUserCnt",8378,"totalNeedPayUserCnt",3017,"totalPlanInnerUserWorkload",2822.93,"totalPlanOutUserWorkload",4486.35,"testCases",985,"execCases",4688,"designCases",5008,"finishCases",1973,"iterationCnt",8190,"productCnt",4821,"menuCnt",8593);
		XmProjectState xmProjectState7=BaseUtils.fromMap(p7,XmProjectState.class);
		batchValues.add(xmProjectState7);
		xmProjectStateService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmProjectState> batchValues=new ArrayList<XmProjectState>();
		Map p0=BaseUtils.map("projectId","ih6M","bizDate","mvvJ","totalFileCnt",214,"totalBugCnt",3369,"totalTaskCnt",8248,"totalBudgetNouserAmount",4559.02,"projectName","mOeY","id","83WG","totalStaffCnt",9159,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","I","totalCostNouserAmount",2149.4,"totalClosedBugCnt",6426,"totalResolvedBugCnt",1869,"totalCompleteTaskCnt",457,"totalPhaseCnt",3558,"totalCompletePhaseCnt",6023,"totalNeedPayAmount",3802.24,"totalFinishPayAmount",5085.07,"totalNeedColAmount",5618.84,"totalFinishColAmount",2004.43,"totalCostUserAmount",8543.72,"totalBudgetInnerUserAmount",9334.07,"totalPlanWorkload",9155.77,"totalRiskCnt",7067,"totalCompleteRiskCnt",5877,"branchId","3ZKc","branchName","4gAp","totalBudgetOutUserAmount",4284.88,"totalCompleteWorkload",7116.47,"totalCostInnerUserAmount",384.59,"totalCostOutUserAmount",196.85,"totalProgress",378.32,"totalActiveBugCnt",2511,"totalConfirmedBugCnt",9085,"projectStatus","tm55","totalActWorkload",2512.47,"totalActOutWorkload",6974,"totalActInnerWorkload",5361,"totalTaskBudgetCostAt",8388.04,"totalTaskOutCnt",3046,"totalNeedPayCnt",5796,"totalFinishPayCnt",2461,"totalFinishPayUserCnt",6835,"totalNeedPayUserCnt",531,"totalPlanInnerUserWorkload",1784.03,"totalPlanOutUserWorkload",9505.94,"testCases",8986,"execCases",4983,"designCases",9950,"finishCases",749,"iterationCnt",3638,"productCnt",3424,"menuCnt",1745);
		XmProjectState xmProjectState0=BaseUtils.fromMap(p0,XmProjectState.class);
		batchValues.add(xmProjectState0);
		Map p1=BaseUtils.map("projectId","PW9R","bizDate","kqj4","totalFileCnt",4887,"totalBugCnt",1078,"totalTaskCnt",978,"totalBudgetNouserAmount",7553.12,"projectName","y02e","id","1pvE","totalStaffCnt",5039,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","4","totalCostNouserAmount",5966.95,"totalClosedBugCnt",6949,"totalResolvedBugCnt",8622,"totalCompleteTaskCnt",5162,"totalPhaseCnt",593,"totalCompletePhaseCnt",894,"totalNeedPayAmount",9580.55,"totalFinishPayAmount",2820.5,"totalNeedColAmount",2403.4,"totalFinishColAmount",7167.49,"totalCostUserAmount",6964.35,"totalBudgetInnerUserAmount",3581.8,"totalPlanWorkload",3119.09,"totalRiskCnt",4423,"totalCompleteRiskCnt",1943,"branchId","3nTP","branchName","vMCE","totalBudgetOutUserAmount",789.77,"totalCompleteWorkload",9569.32,"totalCostInnerUserAmount",3511.49,"totalCostOutUserAmount",3100.51,"totalProgress",736.67,"totalActiveBugCnt",1903,"totalConfirmedBugCnt",8325,"projectStatus","27K5","totalActWorkload",747.11,"totalActOutWorkload",8137,"totalActInnerWorkload",8559,"totalTaskBudgetCostAt",9844.35,"totalTaskOutCnt",1310,"totalNeedPayCnt",7199,"totalFinishPayCnt",8142,"totalFinishPayUserCnt",2402,"totalNeedPayUserCnt",5861,"totalPlanInnerUserWorkload",7904.79,"totalPlanOutUserWorkload",4895.88,"testCases",6257,"execCases",8577,"designCases",4253,"finishCases",3640,"iterationCnt",9889,"productCnt",545,"menuCnt",2911);
		XmProjectState xmProjectState1=BaseUtils.fromMap(p1,XmProjectState.class);
		batchValues.add(xmProjectState1);
		Map p2=BaseUtils.map("projectId","6T54","bizDate","mLP8","totalFileCnt",3328,"totalBugCnt",3222,"totalTaskCnt",6972,"totalBudgetNouserAmount",33.02,"projectName","KKhr","id","4Q0m","totalStaffCnt",6823,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","P","totalCostNouserAmount",6832.55,"totalClosedBugCnt",7766,"totalResolvedBugCnt",2777,"totalCompleteTaskCnt",7289,"totalPhaseCnt",5838,"totalCompletePhaseCnt",5915,"totalNeedPayAmount",5894.52,"totalFinishPayAmount",250.45,"totalNeedColAmount",7981.39,"totalFinishColAmount",925.41,"totalCostUserAmount",4368.75,"totalBudgetInnerUserAmount",383.68,"totalPlanWorkload",6703.83,"totalRiskCnt",5898,"totalCompleteRiskCnt",6461,"branchId","1n0U","branchName","UnDU","totalBudgetOutUserAmount",5794.81,"totalCompleteWorkload",9139.98,"totalCostInnerUserAmount",7253.32,"totalCostOutUserAmount",5676.49,"totalProgress",3084.74,"totalActiveBugCnt",3434,"totalConfirmedBugCnt",6071,"projectStatus","mZX2","totalActWorkload",2618.75,"totalActOutWorkload",1377,"totalActInnerWorkload",5167,"totalTaskBudgetCostAt",4024.34,"totalTaskOutCnt",4797,"totalNeedPayCnt",1184,"totalFinishPayCnt",8407,"totalFinishPayUserCnt",4946,"totalNeedPayUserCnt",7491,"totalPlanInnerUserWorkload",9106.42,"totalPlanOutUserWorkload",209.63,"testCases",6112,"execCases",7254,"designCases",560,"finishCases",1662,"iterationCnt",8201,"productCnt",6033,"menuCnt",7351);
		XmProjectState xmProjectState2=BaseUtils.fromMap(p2,XmProjectState.class);
		batchValues.add(xmProjectState2);
		Map p3=BaseUtils.map("projectId","63n3","bizDate","092K","totalFileCnt",5698,"totalBugCnt",6658,"totalTaskCnt",9395,"totalBudgetNouserAmount",8761.03,"projectName","slZb","id","uHNq","totalStaffCnt",3614,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","a","totalCostNouserAmount",9888.34,"totalClosedBugCnt",7014,"totalResolvedBugCnt",4188,"totalCompleteTaskCnt",2623,"totalPhaseCnt",1621,"totalCompletePhaseCnt",1446,"totalNeedPayAmount",912.03,"totalFinishPayAmount",5937.52,"totalNeedColAmount",9920.8,"totalFinishColAmount",1648.2,"totalCostUserAmount",8740.53,"totalBudgetInnerUserAmount",3367.73,"totalPlanWorkload",5880.65,"totalRiskCnt",7707,"totalCompleteRiskCnt",9207,"branchId","fRWO","branchName","105n","totalBudgetOutUserAmount",5820.43,"totalCompleteWorkload",1265.54,"totalCostInnerUserAmount",3537.87,"totalCostOutUserAmount",3280.22,"totalProgress",9285.93,"totalActiveBugCnt",1366,"totalConfirmedBugCnt",7804,"projectStatus","Eiuo","totalActWorkload",880,"totalActOutWorkload",7631,"totalActInnerWorkload",8059,"totalTaskBudgetCostAt",3575.52,"totalTaskOutCnt",2242,"totalNeedPayCnt",4105,"totalFinishPayCnt",8515,"totalFinishPayUserCnt",6112,"totalNeedPayUserCnt",3976,"totalPlanInnerUserWorkload",6092.62,"totalPlanOutUserWorkload",7838.95,"testCases",3063,"execCases",3487,"designCases",2735,"finishCases",8374,"iterationCnt",5699,"productCnt",4028,"menuCnt",4593);
		XmProjectState xmProjectState3=BaseUtils.fromMap(p3,XmProjectState.class);
		batchValues.add(xmProjectState3);
		Map p4=BaseUtils.map("projectId","9i9D","bizDate","8JW6","totalFileCnt",7234,"totalBugCnt",1644,"totalTaskCnt",3202,"totalBudgetNouserAmount",2987.21,"projectName","Mg9j","id","60na","totalStaffCnt",5423,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","z","totalCostNouserAmount",1072.35,"totalClosedBugCnt",8986,"totalResolvedBugCnt",968,"totalCompleteTaskCnt",2785,"totalPhaseCnt",7931,"totalCompletePhaseCnt",1566,"totalNeedPayAmount",8103.27,"totalFinishPayAmount",2063.02,"totalNeedColAmount",2528.78,"totalFinishColAmount",6429.16,"totalCostUserAmount",8089.01,"totalBudgetInnerUserAmount",3723.49,"totalPlanWorkload",8424.13,"totalRiskCnt",9759,"totalCompleteRiskCnt",134,"branchId","Ie8G","branchName","UbAp","totalBudgetOutUserAmount",8774.96,"totalCompleteWorkload",1769.41,"totalCostInnerUserAmount",4482.64,"totalCostOutUserAmount",8685.25,"totalProgress",8997.23,"totalActiveBugCnt",3845,"totalConfirmedBugCnt",5914,"projectStatus","U62B","totalActWorkload",8565.02,"totalActOutWorkload",6114,"totalActInnerWorkload",718,"totalTaskBudgetCostAt",474.36,"totalTaskOutCnt",570,"totalNeedPayCnt",1804,"totalFinishPayCnt",3287,"totalFinishPayUserCnt",2179,"totalNeedPayUserCnt",1344,"totalPlanInnerUserWorkload",3929.48,"totalPlanOutUserWorkload",6297.24,"testCases",1862,"execCases",7674,"designCases",2283,"finishCases",7390,"iterationCnt",7880,"productCnt",4410,"menuCnt",3106);
		XmProjectState xmProjectState4=BaseUtils.fromMap(p4,XmProjectState.class);
		batchValues.add(xmProjectState4);
		Map p5=BaseUtils.map("projectId","s371","bizDate","TRQC","totalFileCnt",6847,"totalBugCnt",8502,"totalTaskCnt",4875,"totalBudgetNouserAmount",9321.37,"projectName","8135","id","c9xK","totalStaffCnt",5643,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","E","totalCostNouserAmount",8957.7,"totalClosedBugCnt",5707,"totalResolvedBugCnt",9944,"totalCompleteTaskCnt",6677,"totalPhaseCnt",8824,"totalCompletePhaseCnt",499,"totalNeedPayAmount",8916.58,"totalFinishPayAmount",6422.54,"totalNeedColAmount",6714.62,"totalFinishColAmount",6969,"totalCostUserAmount",949.45,"totalBudgetInnerUserAmount",6057.66,"totalPlanWorkload",9174.11,"totalRiskCnt",7226,"totalCompleteRiskCnt",4065,"branchId","az46","branchName","5c85","totalBudgetOutUserAmount",7258.17,"totalCompleteWorkload",9148.77,"totalCostInnerUserAmount",1557.35,"totalCostOutUserAmount",3562.12,"totalProgress",777.12,"totalActiveBugCnt",8359,"totalConfirmedBugCnt",703,"projectStatus","2CoC","totalActWorkload",4286.47,"totalActOutWorkload",3805,"totalActInnerWorkload",1212,"totalTaskBudgetCostAt",5327.85,"totalTaskOutCnt",6431,"totalNeedPayCnt",235,"totalFinishPayCnt",5113,"totalFinishPayUserCnt",9798,"totalNeedPayUserCnt",2287,"totalPlanInnerUserWorkload",9097.11,"totalPlanOutUserWorkload",5153.8,"testCases",1929,"execCases",4747,"designCases",2446,"finishCases",410,"iterationCnt",7339,"productCnt",4845,"menuCnt",3864);
		XmProjectState xmProjectState5=BaseUtils.fromMap(p5,XmProjectState.class);
		batchValues.add(xmProjectState5);
		Map p6=BaseUtils.map("projectId","sEPg","bizDate","mYFQ","totalFileCnt",4101,"totalBugCnt",828,"totalTaskCnt",3606,"totalBudgetNouserAmount",8408.68,"projectName","3bAM","id","u662","totalStaffCnt",463,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","7","totalCostNouserAmount",9876.47,"totalClosedBugCnt",9214,"totalResolvedBugCnt",7473,"totalCompleteTaskCnt",4463,"totalPhaseCnt",3674,"totalCompletePhaseCnt",6424,"totalNeedPayAmount",3312.84,"totalFinishPayAmount",1650.99,"totalNeedColAmount",7220.53,"totalFinishColAmount",8816.04,"totalCostUserAmount",2688.84,"totalBudgetInnerUserAmount",8665.97,"totalPlanWorkload",3169.76,"totalRiskCnt",3427,"totalCompleteRiskCnt",3052,"branchId","jnrP","branchName","29Ch","totalBudgetOutUserAmount",1149.89,"totalCompleteWorkload",6313.74,"totalCostInnerUserAmount",8803.27,"totalCostOutUserAmount",6855.87,"totalProgress",7088.34,"totalActiveBugCnt",8975,"totalConfirmedBugCnt",7075,"projectStatus","7ZUF","totalActWorkload",1231.06,"totalActOutWorkload",7972,"totalActInnerWorkload",1954,"totalTaskBudgetCostAt",492.57,"totalTaskOutCnt",3576,"totalNeedPayCnt",5830,"totalFinishPayCnt",307,"totalFinishPayUserCnt",4848,"totalNeedPayUserCnt",5401,"totalPlanInnerUserWorkload",1184.48,"totalPlanOutUserWorkload",4989.17,"testCases",9464,"execCases",4670,"designCases",4869,"finishCases",5174,"iterationCnt",3421,"productCnt",6726,"menuCnt",5729);
		XmProjectState xmProjectState6=BaseUtils.fromMap(p6,XmProjectState.class);
		batchValues.add(xmProjectState6);
		Map p7=BaseUtils.map("projectId","SJ5P","bizDate","YmA7","totalFileCnt",1941,"totalBugCnt",3054,"totalTaskCnt",9790,"totalBudgetNouserAmount",229.7,"projectName","H0la","id","l1K5","totalStaffCnt",6453,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","X","totalCostNouserAmount",2419.82,"totalClosedBugCnt",7620,"totalResolvedBugCnt",5241,"totalCompleteTaskCnt",8949,"totalPhaseCnt",7582,"totalCompletePhaseCnt",4716,"totalNeedPayAmount",2513.68,"totalFinishPayAmount",2937.84,"totalNeedColAmount",7767.99,"totalFinishColAmount",1232.07,"totalCostUserAmount",2393.83,"totalBudgetInnerUserAmount",1972.73,"totalPlanWorkload",3353.86,"totalRiskCnt",4111,"totalCompleteRiskCnt",2039,"branchId","Sp04","branchName","fTZ2","totalBudgetOutUserAmount",2012.06,"totalCompleteWorkload",9500.73,"totalCostInnerUserAmount",2598.65,"totalCostOutUserAmount",344.76,"totalProgress",2114.8,"totalActiveBugCnt",9246,"totalConfirmedBugCnt",2086,"projectStatus","NdUL","totalActWorkload",892.53,"totalActOutWorkload",7730,"totalActInnerWorkload",8038,"totalTaskBudgetCostAt",5456.73,"totalTaskOutCnt",5665,"totalNeedPayCnt",5579,"totalFinishPayCnt",4215,"totalFinishPayUserCnt",8378,"totalNeedPayUserCnt",3017,"totalPlanInnerUserWorkload",2822.93,"totalPlanOutUserWorkload",4486.35,"testCases",985,"execCases",4688,"designCases",5008,"finishCases",1973,"iterationCnt",8190,"productCnt",4821,"menuCnt",8593);
		XmProjectState xmProjectState7=BaseUtils.fromMap(p7,XmProjectState.class);
		batchValues.add(xmProjectState7);
		xmProjectStateService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmProjectState> batchValues=new ArrayList<XmProjectState>();
		Map p0=BaseUtils.map("projectId","ih6M","bizDate","mvvJ","totalFileCnt",214,"totalBugCnt",3369,"totalTaskCnt",8248,"totalBudgetNouserAmount",4559.02,"projectName","mOeY","id","83WG","totalStaffCnt",9159,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","I","totalCostNouserAmount",2149.4,"totalClosedBugCnt",6426,"totalResolvedBugCnt",1869,"totalCompleteTaskCnt",457,"totalPhaseCnt",3558,"totalCompletePhaseCnt",6023,"totalNeedPayAmount",3802.24,"totalFinishPayAmount",5085.07,"totalNeedColAmount",5618.84,"totalFinishColAmount",2004.43,"totalCostUserAmount",8543.72,"totalBudgetInnerUserAmount",9334.07,"totalPlanWorkload",9155.77,"totalRiskCnt",7067,"totalCompleteRiskCnt",5877,"branchId","3ZKc","branchName","4gAp","totalBudgetOutUserAmount",4284.88,"totalCompleteWorkload",7116.47,"totalCostInnerUserAmount",384.59,"totalCostOutUserAmount",196.85,"totalProgress",378.32,"totalActiveBugCnt",2511,"totalConfirmedBugCnt",9085,"projectStatus","tm55","totalActWorkload",2512.47,"totalActOutWorkload",6974,"totalActInnerWorkload",5361,"totalTaskBudgetCostAt",8388.04,"totalTaskOutCnt",3046,"totalNeedPayCnt",5796,"totalFinishPayCnt",2461,"totalFinishPayUserCnt",6835,"totalNeedPayUserCnt",531,"totalPlanInnerUserWorkload",1784.03,"totalPlanOutUserWorkload",9505.94,"testCases",8986,"execCases",4983,"designCases",9950,"finishCases",749,"iterationCnt",3638,"productCnt",3424,"menuCnt",1745);
		XmProjectState xmProjectState0=BaseUtils.fromMap(p0,XmProjectState.class);
		batchValues.add(xmProjectState0);
		Map p1=BaseUtils.map("projectId","PW9R","bizDate","kqj4","totalFileCnt",4887,"totalBugCnt",1078,"totalTaskCnt",978,"totalBudgetNouserAmount",7553.12,"projectName","y02e","id","1pvE","totalStaffCnt",5039,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","4","totalCostNouserAmount",5966.95,"totalClosedBugCnt",6949,"totalResolvedBugCnt",8622,"totalCompleteTaskCnt",5162,"totalPhaseCnt",593,"totalCompletePhaseCnt",894,"totalNeedPayAmount",9580.55,"totalFinishPayAmount",2820.5,"totalNeedColAmount",2403.4,"totalFinishColAmount",7167.49,"totalCostUserAmount",6964.35,"totalBudgetInnerUserAmount",3581.8,"totalPlanWorkload",3119.09,"totalRiskCnt",4423,"totalCompleteRiskCnt",1943,"branchId","3nTP","branchName","vMCE","totalBudgetOutUserAmount",789.77,"totalCompleteWorkload",9569.32,"totalCostInnerUserAmount",3511.49,"totalCostOutUserAmount",3100.51,"totalProgress",736.67,"totalActiveBugCnt",1903,"totalConfirmedBugCnt",8325,"projectStatus","27K5","totalActWorkload",747.11,"totalActOutWorkload",8137,"totalActInnerWorkload",8559,"totalTaskBudgetCostAt",9844.35,"totalTaskOutCnt",1310,"totalNeedPayCnt",7199,"totalFinishPayCnt",8142,"totalFinishPayUserCnt",2402,"totalNeedPayUserCnt",5861,"totalPlanInnerUserWorkload",7904.79,"totalPlanOutUserWorkload",4895.88,"testCases",6257,"execCases",8577,"designCases",4253,"finishCases",3640,"iterationCnt",9889,"productCnt",545,"menuCnt",2911);
		XmProjectState xmProjectState1=BaseUtils.fromMap(p1,XmProjectState.class);
		batchValues.add(xmProjectState1);
		Map p2=BaseUtils.map("projectId","6T54","bizDate","mLP8","totalFileCnt",3328,"totalBugCnt",3222,"totalTaskCnt",6972,"totalBudgetNouserAmount",33.02,"projectName","KKhr","id","4Q0m","totalStaffCnt",6823,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","P","totalCostNouserAmount",6832.55,"totalClosedBugCnt",7766,"totalResolvedBugCnt",2777,"totalCompleteTaskCnt",7289,"totalPhaseCnt",5838,"totalCompletePhaseCnt",5915,"totalNeedPayAmount",5894.52,"totalFinishPayAmount",250.45,"totalNeedColAmount",7981.39,"totalFinishColAmount",925.41,"totalCostUserAmount",4368.75,"totalBudgetInnerUserAmount",383.68,"totalPlanWorkload",6703.83,"totalRiskCnt",5898,"totalCompleteRiskCnt",6461,"branchId","1n0U","branchName","UnDU","totalBudgetOutUserAmount",5794.81,"totalCompleteWorkload",9139.98,"totalCostInnerUserAmount",7253.32,"totalCostOutUserAmount",5676.49,"totalProgress",3084.74,"totalActiveBugCnt",3434,"totalConfirmedBugCnt",6071,"projectStatus","mZX2","totalActWorkload",2618.75,"totalActOutWorkload",1377,"totalActInnerWorkload",5167,"totalTaskBudgetCostAt",4024.34,"totalTaskOutCnt",4797,"totalNeedPayCnt",1184,"totalFinishPayCnt",8407,"totalFinishPayUserCnt",4946,"totalNeedPayUserCnt",7491,"totalPlanInnerUserWorkload",9106.42,"totalPlanOutUserWorkload",209.63,"testCases",6112,"execCases",7254,"designCases",560,"finishCases",1662,"iterationCnt",8201,"productCnt",6033,"menuCnt",7351);
		XmProjectState xmProjectState2=BaseUtils.fromMap(p2,XmProjectState.class);
		batchValues.add(xmProjectState2);
		Map p3=BaseUtils.map("projectId","63n3","bizDate","092K","totalFileCnt",5698,"totalBugCnt",6658,"totalTaskCnt",9395,"totalBudgetNouserAmount",8761.03,"projectName","slZb","id","uHNq","totalStaffCnt",3614,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","a","totalCostNouserAmount",9888.34,"totalClosedBugCnt",7014,"totalResolvedBugCnt",4188,"totalCompleteTaskCnt",2623,"totalPhaseCnt",1621,"totalCompletePhaseCnt",1446,"totalNeedPayAmount",912.03,"totalFinishPayAmount",5937.52,"totalNeedColAmount",9920.8,"totalFinishColAmount",1648.2,"totalCostUserAmount",8740.53,"totalBudgetInnerUserAmount",3367.73,"totalPlanWorkload",5880.65,"totalRiskCnt",7707,"totalCompleteRiskCnt",9207,"branchId","fRWO","branchName","105n","totalBudgetOutUserAmount",5820.43,"totalCompleteWorkload",1265.54,"totalCostInnerUserAmount",3537.87,"totalCostOutUserAmount",3280.22,"totalProgress",9285.93,"totalActiveBugCnt",1366,"totalConfirmedBugCnt",7804,"projectStatus","Eiuo","totalActWorkload",880,"totalActOutWorkload",7631,"totalActInnerWorkload",8059,"totalTaskBudgetCostAt",3575.52,"totalTaskOutCnt",2242,"totalNeedPayCnt",4105,"totalFinishPayCnt",8515,"totalFinishPayUserCnt",6112,"totalNeedPayUserCnt",3976,"totalPlanInnerUserWorkload",6092.62,"totalPlanOutUserWorkload",7838.95,"testCases",3063,"execCases",3487,"designCases",2735,"finishCases",8374,"iterationCnt",5699,"productCnt",4028,"menuCnt",4593);
		XmProjectState xmProjectState3=BaseUtils.fromMap(p3,XmProjectState.class);
		batchValues.add(xmProjectState3);
		Map p4=BaseUtils.map("projectId","9i9D","bizDate","8JW6","totalFileCnt",7234,"totalBugCnt",1644,"totalTaskCnt",3202,"totalBudgetNouserAmount",2987.21,"projectName","Mg9j","id","60na","totalStaffCnt",5423,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","z","totalCostNouserAmount",1072.35,"totalClosedBugCnt",8986,"totalResolvedBugCnt",968,"totalCompleteTaskCnt",2785,"totalPhaseCnt",7931,"totalCompletePhaseCnt",1566,"totalNeedPayAmount",8103.27,"totalFinishPayAmount",2063.02,"totalNeedColAmount",2528.78,"totalFinishColAmount",6429.16,"totalCostUserAmount",8089.01,"totalBudgetInnerUserAmount",3723.49,"totalPlanWorkload",8424.13,"totalRiskCnt",9759,"totalCompleteRiskCnt",134,"branchId","Ie8G","branchName","UbAp","totalBudgetOutUserAmount",8774.96,"totalCompleteWorkload",1769.41,"totalCostInnerUserAmount",4482.64,"totalCostOutUserAmount",8685.25,"totalProgress",8997.23,"totalActiveBugCnt",3845,"totalConfirmedBugCnt",5914,"projectStatus","U62B","totalActWorkload",8565.02,"totalActOutWorkload",6114,"totalActInnerWorkload",718,"totalTaskBudgetCostAt",474.36,"totalTaskOutCnt",570,"totalNeedPayCnt",1804,"totalFinishPayCnt",3287,"totalFinishPayUserCnt",2179,"totalNeedPayUserCnt",1344,"totalPlanInnerUserWorkload",3929.48,"totalPlanOutUserWorkload",6297.24,"testCases",1862,"execCases",7674,"designCases",2283,"finishCases",7390,"iterationCnt",7880,"productCnt",4410,"menuCnt",3106);
		XmProjectState xmProjectState4=BaseUtils.fromMap(p4,XmProjectState.class);
		batchValues.add(xmProjectState4);
		Map p5=BaseUtils.map("projectId","s371","bizDate","TRQC","totalFileCnt",6847,"totalBugCnt",8502,"totalTaskCnt",4875,"totalBudgetNouserAmount",9321.37,"projectName","8135","id","c9xK","totalStaffCnt",5643,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","E","totalCostNouserAmount",8957.7,"totalClosedBugCnt",5707,"totalResolvedBugCnt",9944,"totalCompleteTaskCnt",6677,"totalPhaseCnt",8824,"totalCompletePhaseCnt",499,"totalNeedPayAmount",8916.58,"totalFinishPayAmount",6422.54,"totalNeedColAmount",6714.62,"totalFinishColAmount",6969,"totalCostUserAmount",949.45,"totalBudgetInnerUserAmount",6057.66,"totalPlanWorkload",9174.11,"totalRiskCnt",7226,"totalCompleteRiskCnt",4065,"branchId","az46","branchName","5c85","totalBudgetOutUserAmount",7258.17,"totalCompleteWorkload",9148.77,"totalCostInnerUserAmount",1557.35,"totalCostOutUserAmount",3562.12,"totalProgress",777.12,"totalActiveBugCnt",8359,"totalConfirmedBugCnt",703,"projectStatus","2CoC","totalActWorkload",4286.47,"totalActOutWorkload",3805,"totalActInnerWorkload",1212,"totalTaskBudgetCostAt",5327.85,"totalTaskOutCnt",6431,"totalNeedPayCnt",235,"totalFinishPayCnt",5113,"totalFinishPayUserCnt",9798,"totalNeedPayUserCnt",2287,"totalPlanInnerUserWorkload",9097.11,"totalPlanOutUserWorkload",5153.8,"testCases",1929,"execCases",4747,"designCases",2446,"finishCases",410,"iterationCnt",7339,"productCnt",4845,"menuCnt",3864);
		XmProjectState xmProjectState5=BaseUtils.fromMap(p5,XmProjectState.class);
		batchValues.add(xmProjectState5);
		Map p6=BaseUtils.map("projectId","sEPg","bizDate","mYFQ","totalFileCnt",4101,"totalBugCnt",828,"totalTaskCnt",3606,"totalBudgetNouserAmount",8408.68,"projectName","3bAM","id","u662","totalStaffCnt",463,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","7","totalCostNouserAmount",9876.47,"totalClosedBugCnt",9214,"totalResolvedBugCnt",7473,"totalCompleteTaskCnt",4463,"totalPhaseCnt",3674,"totalCompletePhaseCnt",6424,"totalNeedPayAmount",3312.84,"totalFinishPayAmount",1650.99,"totalNeedColAmount",7220.53,"totalFinishColAmount",8816.04,"totalCostUserAmount",2688.84,"totalBudgetInnerUserAmount",8665.97,"totalPlanWorkload",3169.76,"totalRiskCnt",3427,"totalCompleteRiskCnt",3052,"branchId","jnrP","branchName","29Ch","totalBudgetOutUserAmount",1149.89,"totalCompleteWorkload",6313.74,"totalCostInnerUserAmount",8803.27,"totalCostOutUserAmount",6855.87,"totalProgress",7088.34,"totalActiveBugCnt",8975,"totalConfirmedBugCnt",7075,"projectStatus","7ZUF","totalActWorkload",1231.06,"totalActOutWorkload",7972,"totalActInnerWorkload",1954,"totalTaskBudgetCostAt",492.57,"totalTaskOutCnt",3576,"totalNeedPayCnt",5830,"totalFinishPayCnt",307,"totalFinishPayUserCnt",4848,"totalNeedPayUserCnt",5401,"totalPlanInnerUserWorkload",1184.48,"totalPlanOutUserWorkload",4989.17,"testCases",9464,"execCases",4670,"designCases",4869,"finishCases",5174,"iterationCnt",3421,"productCnt",6726,"menuCnt",5729);
		XmProjectState xmProjectState6=BaseUtils.fromMap(p6,XmProjectState.class);
		batchValues.add(xmProjectState6);
		Map p7=BaseUtils.map("projectId","SJ5P","bizDate","YmA7","totalFileCnt",1941,"totalBugCnt",3054,"totalTaskCnt",9790,"totalBudgetNouserAmount",229.7,"projectName","H0la","id","l1K5","totalStaffCnt",6453,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","X","totalCostNouserAmount",2419.82,"totalClosedBugCnt",7620,"totalResolvedBugCnt",5241,"totalCompleteTaskCnt",8949,"totalPhaseCnt",7582,"totalCompletePhaseCnt",4716,"totalNeedPayAmount",2513.68,"totalFinishPayAmount",2937.84,"totalNeedColAmount",7767.99,"totalFinishColAmount",1232.07,"totalCostUserAmount",2393.83,"totalBudgetInnerUserAmount",1972.73,"totalPlanWorkload",3353.86,"totalRiskCnt",4111,"totalCompleteRiskCnt",2039,"branchId","Sp04","branchName","fTZ2","totalBudgetOutUserAmount",2012.06,"totalCompleteWorkload",9500.73,"totalCostInnerUserAmount",2598.65,"totalCostOutUserAmount",344.76,"totalProgress",2114.8,"totalActiveBugCnt",9246,"totalConfirmedBugCnt",2086,"projectStatus","NdUL","totalActWorkload",892.53,"totalActOutWorkload",7730,"totalActInnerWorkload",8038,"totalTaskBudgetCostAt",5456.73,"totalTaskOutCnt",5665,"totalNeedPayCnt",5579,"totalFinishPayCnt",4215,"totalFinishPayUserCnt",8378,"totalNeedPayUserCnt",3017,"totalPlanInnerUserWorkload",2822.93,"totalPlanOutUserWorkload",4486.35,"testCases",985,"execCases",4688,"designCases",5008,"finishCases",1973,"iterationCnt",8190,"productCnt",4821,"menuCnt",8593);
		XmProjectState xmProjectState7=BaseUtils.fromMap(p7,XmProjectState.class);
		batchValues.add(xmProjectState7);
		xmProjectStateService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","83WG");
		Map<String,Object> result=this.xmProjectStateService.selectOne(XmProjectState.class.getName()+".selectOneMap",p);
		Assert.assertEquals("83WG", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","ih6M","bizDate","mvvJ","totalFileCnt",214,"totalBugCnt",3369,"totalTaskCnt",8248,"totalBudgetNouserAmount",4559.02,"projectName","mOeY","totalStaffCnt",9159,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","I","totalCostNouserAmount",2149.4,"totalClosedBugCnt",6426,"totalResolvedBugCnt",1869,"totalCompleteTaskCnt",457,"totalPhaseCnt",3558,"totalCompletePhaseCnt",6023,"totalNeedPayAmount",3802.24,"totalFinishPayAmount",5085.07,"totalNeedColAmount",5618.84,"totalFinishColAmount",2004.43,"totalCostUserAmount",8543.72,"totalBudgetInnerUserAmount",9334.07,"totalPlanWorkload",9155.77,"totalRiskCnt",7067,"totalCompleteRiskCnt",5877,"branchId","3ZKc","branchName","4gAp","totalBudgetOutUserAmount",4284.88,"totalCompleteWorkload",7116.47,"totalCostInnerUserAmount",384.59,"totalCostOutUserAmount",196.85,"totalProgress",378.32,"totalActiveBugCnt",2511,"totalConfirmedBugCnt",9085,"projectStatus","tm55","totalActWorkload",2512.47,"totalActOutWorkload",6974,"totalActInnerWorkload",5361,"totalTaskBudgetCostAt",8388.04,"totalTaskOutCnt",3046,"totalNeedPayCnt",5796,"totalFinishPayCnt",2461,"totalFinishPayUserCnt",6835,"totalNeedPayUserCnt",531,"totalPlanInnerUserWorkload",1784.03,"totalPlanOutUserWorkload",9505.94,"testCases",8986,"execCases",4983,"designCases",9950,"finishCases",749,"iterationCnt",3638,"productCnt",3424,"menuCnt",1745);
		XmProjectState xmProjectState=BaseUtils.fromMap(p,XmProjectState.class);
		long result=xmProjectStateService.countByWhere(xmProjectState);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("projectId","ih6M","bizDate","mvvJ","totalFileCnt",214,"totalBugCnt",3369,"totalTaskCnt",8248,"totalBudgetNouserAmount",4559.02,"projectName","mOeY","totalStaffCnt",9159,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","I","totalCostNouserAmount",2149.4,"totalClosedBugCnt",6426,"totalResolvedBugCnt",1869,"totalCompleteTaskCnt",457,"totalPhaseCnt",3558,"totalCompletePhaseCnt",6023,"totalNeedPayAmount",3802.24,"totalFinishPayAmount",5085.07,"totalNeedColAmount",5618.84,"totalFinishColAmount",2004.43,"totalCostUserAmount",8543.72,"totalBudgetInnerUserAmount",9334.07,"totalPlanWorkload",9155.77,"totalRiskCnt",7067,"totalCompleteRiskCnt",5877,"branchId","3ZKc","branchName","4gAp","totalBudgetOutUserAmount",4284.88,"totalCompleteWorkload",7116.47,"totalCostInnerUserAmount",384.59,"totalCostOutUserAmount",196.85,"totalProgress",378.32,"totalActiveBugCnt",2511,"totalConfirmedBugCnt",9085,"projectStatus","tm55","totalActWorkload",2512.47,"totalActOutWorkload",6974,"totalActInnerWorkload",5361,"totalTaskBudgetCostAt",8388.04,"totalTaskOutCnt",3046,"totalNeedPayCnt",5796,"totalFinishPayCnt",2461,"totalFinishPayUserCnt",6835,"totalNeedPayUserCnt",531,"totalPlanInnerUserWorkload",1784.03,"totalPlanOutUserWorkload",9505.94,"testCases",8986,"execCases",4983,"designCases",9950,"finishCases",749,"iterationCnt",3638,"productCnt",3424,"menuCnt",1745);
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmProjectState xmProjectState=BaseUtils.fromMap(p,XmProjectState.class);
		List<XmProjectState> result=xmProjectStateService.selectListByWhere(xmProjectState); 
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
	
		
		Map<String,Object> p=BaseUtils.map("projectId","ih6M","bizDate","mvvJ","totalFileCnt",214,"totalBugCnt",3369,"totalTaskCnt",8248,"totalBudgetNouserAmount",4559.02,"projectName","mOeY","totalStaffCnt",9159,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","I","totalCostNouserAmount",2149.4,"totalClosedBugCnt",6426,"totalResolvedBugCnt",1869,"totalCompleteTaskCnt",457,"totalPhaseCnt",3558,"totalCompletePhaseCnt",6023,"totalNeedPayAmount",3802.24,"totalFinishPayAmount",5085.07,"totalNeedColAmount",5618.84,"totalFinishColAmount",2004.43,"totalCostUserAmount",8543.72,"totalBudgetInnerUserAmount",9334.07,"totalPlanWorkload",9155.77,"totalRiskCnt",7067,"totalCompleteRiskCnt",5877,"branchId","3ZKc","branchName","4gAp","totalBudgetOutUserAmount",4284.88,"totalCompleteWorkload",7116.47,"totalCostInnerUserAmount",384.59,"totalCostOutUserAmount",196.85,"totalProgress",378.32,"totalActiveBugCnt",2511,"totalConfirmedBugCnt",9085,"projectStatus","tm55","totalActWorkload",2512.47,"totalActOutWorkload",6974,"totalActInnerWorkload",5361,"totalTaskBudgetCostAt",8388.04,"totalTaskOutCnt",3046,"totalNeedPayCnt",5796,"totalFinishPayCnt",2461,"totalFinishPayUserCnt",6835,"totalNeedPayUserCnt",531,"totalPlanInnerUserWorkload",1784.03,"totalPlanOutUserWorkload",9505.94,"testCases",8986,"execCases",4983,"designCases",9950,"finishCases",749,"iterationCnt",3638,"productCnt",3424,"menuCnt",1745);
		XmProjectState xmProjectState=BaseUtils.fromMap(p,XmProjectState.class);
		List<XmProjectState> result=xmProjectStateService.selectListByWhere(xmProjectState);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("projectId","ih6M","bizDate","mvvJ","totalFileCnt",214,"totalBugCnt",3369,"totalTaskCnt",8248,"totalBudgetNouserAmount",4559.02,"projectName","mOeY","totalStaffCnt",9159,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","I","totalCostNouserAmount",2149.4,"totalClosedBugCnt",6426,"totalResolvedBugCnt",1869,"totalCompleteTaskCnt",457,"totalPhaseCnt",3558,"totalCompletePhaseCnt",6023,"totalNeedPayAmount",3802.24,"totalFinishPayAmount",5085.07,"totalNeedColAmount",5618.84,"totalFinishColAmount",2004.43,"totalCostUserAmount",8543.72,"totalBudgetInnerUserAmount",9334.07,"totalPlanWorkload",9155.77,"totalRiskCnt",7067,"totalCompleteRiskCnt",5877,"branchId","3ZKc","branchName","4gAp","totalBudgetOutUserAmount",4284.88,"totalCompleteWorkload",7116.47,"totalCostInnerUserAmount",384.59,"totalCostOutUserAmount",196.85,"totalProgress",378.32,"totalActiveBugCnt",2511,"totalConfirmedBugCnt",9085,"projectStatus","tm55","totalActWorkload",2512.47,"totalActOutWorkload",6974,"totalActInnerWorkload",5361,"totalTaskBudgetCostAt",8388.04,"totalTaskOutCnt",3046,"totalNeedPayCnt",5796,"totalFinishPayCnt",2461,"totalFinishPayUserCnt",6835,"totalNeedPayUserCnt",531,"totalPlanInnerUserWorkload",1784.03,"totalPlanOutUserWorkload",9505.94,"testCases",8986,"execCases",4983,"designCases",9950,"finishCases",749,"iterationCnt",3638,"productCnt",3424,"menuCnt",1745);
		List<Map<String,Object>> result=xmProjectStateService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","ih6M","bizDate","mvvJ","totalFileCnt",214,"totalBugCnt",3369,"totalTaskCnt",8248,"totalBudgetNouserAmount",4559.02,"projectName","mOeY","totalStaffCnt",9159,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","I","totalCostNouserAmount",2149.4,"totalClosedBugCnt",6426,"totalResolvedBugCnt",1869,"totalCompleteTaskCnt",457,"totalPhaseCnt",3558,"totalCompletePhaseCnt",6023,"totalNeedPayAmount",3802.24,"totalFinishPayAmount",5085.07,"totalNeedColAmount",5618.84,"totalFinishColAmount",2004.43,"totalCostUserAmount",8543.72,"totalBudgetInnerUserAmount",9334.07,"totalPlanWorkload",9155.77,"totalRiskCnt",7067,"totalCompleteRiskCnt",5877,"branchId","3ZKc","branchName","4gAp","totalBudgetOutUserAmount",4284.88,"totalCompleteWorkload",7116.47,"totalCostInnerUserAmount",384.59,"totalCostOutUserAmount",196.85,"totalProgress",378.32,"totalActiveBugCnt",2511,"totalConfirmedBugCnt",9085,"projectStatus","tm55","totalActWorkload",2512.47,"totalActOutWorkload",6974,"totalActInnerWorkload",5361,"totalTaskBudgetCostAt",8388.04,"totalTaskOutCnt",3046,"totalNeedPayCnt",5796,"totalFinishPayCnt",2461,"totalFinishPayUserCnt",6835,"totalNeedPayUserCnt",531,"totalPlanInnerUserWorkload",1784.03,"totalPlanOutUserWorkload",9505.94,"testCases",8986,"execCases",4983,"designCases",9950,"finishCases",749,"iterationCnt",3638,"productCnt",3424,"menuCnt",1745);
		List<Map<String,Object>> result=xmProjectStateService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmProjectState
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","83WG");
		
		XmProjectState xmProjectState1=BaseUtils.fromMap(p,XmProjectState.class);
		XmProjectState xmProjectState=xmProjectStateService.selectOneObject(xmProjectState1);
		Assert.assertEquals("83WG", xmProjectState.getId());
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
