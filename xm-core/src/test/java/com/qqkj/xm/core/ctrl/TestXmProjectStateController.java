package com.qqkj.xm.core.ctrl;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;  

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext; 
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import com.qqkj.xm.core.entity.XmProjectState;
import com.qqkj.mdp.core.utils.BaseUtils;
/**
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
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectStateController {

	@Autowired
	public WebApplicationContext wac; // cached
	@Autowired
	public MockServletContext servletContext; // cached
	@Autowired
	public MockHttpSession session;
	@Autowired
	public MockHttpServletRequest request;
	@Autowired
	public MockHttpServletResponse response;
	@Autowired
	public ServletWebRequest webRequest;

	public MockMvc mockMvc;
	
	public MockHttpServletRequestBuilder msrb;
	 
	ObjectMapper om = new ObjectMapper();
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void add() throws Exception  {
		Map<String,Object> p=BaseUtils.map("projectId","ih6M","bizDate","mvvJ","totalFileCnt",214,"totalBugCnt",3369,"totalTaskCnt",8248,"totalBudgetNouserAmount",4559.02,"projectName","mOeY","id","83WG","totalStaffCnt",9159,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","I","totalCostNouserAmount",2149.4,"totalClosedBugCnt",6426,"totalResolvedBugCnt",1869,"totalCompleteTaskCnt",457,"totalPhaseCnt",3558,"totalCompletePhaseCnt",6023,"totalNeedPayAmount",3802.24,"totalFinishPayAmount",5085.07,"totalNeedColAmount",5618.84,"totalFinishColAmount",2004.43,"totalCostUserAmount",8543.72,"totalBudgetInnerUserAmount",9334.07,"totalPlanWorkload",9155.77,"totalRiskCnt",7067,"totalCompleteRiskCnt",5877,"branchId","3ZKc","branchName","4gAp","totalBudgetOutUserAmount",4284.88,"totalCompleteWorkload",7116.47,"totalCostInnerUserAmount",384.59,"totalCostOutUserAmount",196.85,"totalProgress",378.32,"totalActiveBugCnt",2511,"totalConfirmedBugCnt",9085,"projectStatus","tm55","totalActWorkload",2512.47,"totalActOutWorkload",6974,"totalActInnerWorkload",5361,"totalTaskBudgetCostAt",8388.04,"totalTaskOutCnt",3046,"totalNeedPayCnt",5796,"totalFinishPayCnt",2461,"totalFinishPayUserCnt",6835,"totalNeedPayUserCnt",531,"totalPlanInnerUserWorkload",1784.03,"totalPlanOutUserWorkload",9505.94,"testCases",8986,"execCases",4983,"designCases",9950,"finishCases",749,"iterationCnt",3638,"productCnt",3424,"menuCnt",1745);
		XmProjectState xmProjectState=BaseUtils.fromMap(p,XmProjectState.class);
		String jsonXmProjectState=om.writeValueAsString(xmProjectState);
		mockMvc.perform( post("/**/core/xmProjectState/add").content(jsonXmProjectState).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/core/xmProjectState/list")
		.param("id","83WG").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("projectId","ih6M","bizDate","mvvJ","totalFileCnt",214,"totalBugCnt",3369,"totalTaskCnt",8248,"totalBudgetNouserAmount",4559.02,"projectName","mOeY","id","83WG","totalStaffCnt",9159,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","I","totalCostNouserAmount",2149.4,"totalClosedBugCnt",6426,"totalResolvedBugCnt",1869,"totalCompleteTaskCnt",457,"totalPhaseCnt",3558,"totalCompletePhaseCnt",6023,"totalNeedPayAmount",3802.24,"totalFinishPayAmount",5085.07,"totalNeedColAmount",5618.84,"totalFinishColAmount",2004.43,"totalCostUserAmount",8543.72,"totalBudgetInnerUserAmount",9334.07,"totalPlanWorkload",9155.77,"totalRiskCnt",7067,"totalCompleteRiskCnt",5877,"branchId","3ZKc","branchName","4gAp","totalBudgetOutUserAmount",4284.88,"totalCompleteWorkload",7116.47,"totalCostInnerUserAmount",384.59,"totalCostOutUserAmount",196.85,"totalProgress",378.32,"totalActiveBugCnt",2511,"totalConfirmedBugCnt",9085,"projectStatus","tm55","totalActWorkload",2512.47,"totalActOutWorkload",6974,"totalActInnerWorkload",5361,"totalTaskBudgetCostAt",8388.04,"totalTaskOutCnt",3046,"totalNeedPayCnt",5796,"totalFinishPayCnt",2461,"totalFinishPayUserCnt",6835,"totalNeedPayUserCnt",531,"totalPlanInnerUserWorkload",1784.03,"totalPlanOutUserWorkload",9505.94,"testCases",8986,"execCases",4983,"designCases",9950,"finishCases",749,"iterationCnt",3638,"productCnt",3424,"menuCnt",1745);
		XmProjectState xmProjectState=BaseUtils.fromMap(p,XmProjectState.class);
		String jsonXmProjectState=om.writeValueAsString(xmProjectState);
		mockMvc.perform( post("/**/core/xmProjectState/edit").content(jsonXmProjectState).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/core/xmProjectState/del").content("83WG").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("projectId","ih6M","bizDate","mvvJ","totalFileCnt",214,"totalBugCnt",3369,"totalTaskCnt",8248,"totalBudgetNouserAmount",4559.02,"projectName","mOeY","id","83WG","totalStaffCnt",9159,"calcTime",parse("2020-11-14 17:0:0"),"calcStatus","I","totalCostNouserAmount",2149.4,"totalClosedBugCnt",6426,"totalResolvedBugCnt",1869,"totalCompleteTaskCnt",457,"totalPhaseCnt",3558,"totalCompletePhaseCnt",6023,"totalNeedPayAmount",3802.24,"totalFinishPayAmount",5085.07,"totalNeedColAmount",5618.84,"totalFinishColAmount",2004.43,"totalCostUserAmount",8543.72,"totalBudgetInnerUserAmount",9334.07,"totalPlanWorkload",9155.77,"totalRiskCnt",7067,"totalCompleteRiskCnt",5877,"branchId","3ZKc","branchName","4gAp","totalBudgetOutUserAmount",4284.88,"totalCompleteWorkload",7116.47,"totalCostInnerUserAmount",384.59,"totalCostOutUserAmount",196.85,"totalProgress",378.32,"totalActiveBugCnt",2511,"totalConfirmedBugCnt",9085,"projectStatus","tm55","totalActWorkload",2512.47,"totalActOutWorkload",6974,"totalActInnerWorkload",5361,"totalTaskBudgetCostAt",8388.04,"totalTaskOutCnt",3046,"totalNeedPayCnt",5796,"totalFinishPayCnt",2461,"totalFinishPayUserCnt",6835,"totalNeedPayUserCnt",531,"totalPlanInnerUserWorkload",1784.03,"totalPlanOutUserWorkload",9505.94,"testCases",8986,"execCases",4983,"designCases",9950,"finishCases",749,"iterationCnt",3638,"productCnt",3424,"menuCnt",1745);
		XmProjectState xmProjectState=BaseUtils.fromMap(p,XmProjectState.class);
		List<XmProjectState>  xmProjectStates=new ArrayList<>();
		xmProjectStates.add(xmProjectState);
		String jsonXmProjectState=om.writeValueAsString(xmProjectStates);
		mockMvc.perform( post("/**/core/xmProjectState/batchDel").content(jsonXmProjectState).contentType(MediaType.APPLICATION_JSON))
		   .andDo(print())
		   .andExpect(status().isOk())  
		   .andExpect(jsonPath("tips.isOk").value(true));
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
