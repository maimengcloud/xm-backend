package com.xm.core.ctrl;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmBranchState;
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
import com.mdp.core.utils.BaseUtils;
/**
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
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmBranchStateController {

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
		Map<String,Object> p=BaseUtils.map("bizDate","Utbh","totalFileCnt",3509,"totalBugCnt",3490,"totalTaskCnt",1414,"totalBudgetNouserAmount",3656.61,"id","3lPB","totalStaffCnt",4834,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","h","totalCostNouserAmount",2604.99,"totalClosedBugCnt",7336,"totalResolvedBugCnt",4857,"totalCompleteTaskCnt",4319,"totalPhaseCnt",2620,"totalCompletePhaseCnt",2855,"totalNeedPayAmount",460.84,"totalFinishPayAmount",2248.84,"totalNeedColAmount",7036.19,"totalFinishColAmount",1977.48,"totalCostUserAmount",7584.56,"totalBudgetInnerUserAmount",731.82,"totalPlanWorkload",478.56,"totalRiskCnt",815,"totalCompleteRiskCnt",8669,"branchId","l2y1","branchName","mHQa","totalBudgetOutUserAmount",3404.44,"totalCompleteWorkload",6809.51,"totalCostInnerUserAmount",9219.78,"totalCostOutUserAmount",3531.81,"totalProgress",9024.33,"totalActiveBugCnt",2499,"totalConfirmedBugCnt",318,"projectStatus","Ty46","totalActWorkload",2296.84,"totalActOutWorkload",8928,"totalActInnerWorkload",7763,"totalTaskBudgetCostAt",8054,"totalTaskOutCnt",5624,"totalNeedPayCnt",2162,"totalFinishPayCnt",5737,"totalFinishPayUserCnt",1775,"totalNeedPayUserCnt",8626,"totalPlanInnerUserWorkload",8899.79,"totalPlanOutUserWorkload",4520.12,"testCases",3850,"execCases",4446,"designCases",3370,"finishCases",1885,"iterationCnt",9064,"productCnt",5781,"menuCnt",477);
		XmBranchState xmBranchState=BaseUtils.fromMap(p,XmBranchState.class);
		String jsonXmBranchState=om.writeValueAsString(xmBranchState);
		mockMvc.perform( post("/**/core/xmBranchState/add").content(jsonXmBranchState).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/core/xmBranchState/list")
		.param("id","3lPB").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("bizDate","Utbh","totalFileCnt",3509,"totalBugCnt",3490,"totalTaskCnt",1414,"totalBudgetNouserAmount",3656.61,"id","3lPB","totalStaffCnt",4834,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","h","totalCostNouserAmount",2604.99,"totalClosedBugCnt",7336,"totalResolvedBugCnt",4857,"totalCompleteTaskCnt",4319,"totalPhaseCnt",2620,"totalCompletePhaseCnt",2855,"totalNeedPayAmount",460.84,"totalFinishPayAmount",2248.84,"totalNeedColAmount",7036.19,"totalFinishColAmount",1977.48,"totalCostUserAmount",7584.56,"totalBudgetInnerUserAmount",731.82,"totalPlanWorkload",478.56,"totalRiskCnt",815,"totalCompleteRiskCnt",8669,"branchId","l2y1","branchName","mHQa","totalBudgetOutUserAmount",3404.44,"totalCompleteWorkload",6809.51,"totalCostInnerUserAmount",9219.78,"totalCostOutUserAmount",3531.81,"totalProgress",9024.33,"totalActiveBugCnt",2499,"totalConfirmedBugCnt",318,"projectStatus","Ty46","totalActWorkload",2296.84,"totalActOutWorkload",8928,"totalActInnerWorkload",7763,"totalTaskBudgetCostAt",8054,"totalTaskOutCnt",5624,"totalNeedPayCnt",2162,"totalFinishPayCnt",5737,"totalFinishPayUserCnt",1775,"totalNeedPayUserCnt",8626,"totalPlanInnerUserWorkload",8899.79,"totalPlanOutUserWorkload",4520.12,"testCases",3850,"execCases",4446,"designCases",3370,"finishCases",1885,"iterationCnt",9064,"productCnt",5781,"menuCnt",477);
		XmBranchState xmBranchState=BaseUtils.fromMap(p,XmBranchState.class);
		String jsonXmBranchState=om.writeValueAsString(xmBranchState);
		mockMvc.perform( post("/**/core/xmBranchState/edit").content(jsonXmBranchState).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/core/xmBranchState/del").content("3lPB").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("bizDate","Utbh","totalFileCnt",3509,"totalBugCnt",3490,"totalTaskCnt",1414,"totalBudgetNouserAmount",3656.61,"id","3lPB","totalStaffCnt",4834,"calcTime",parse("2020-11-14 17:0:1"),"calcStatus","h","totalCostNouserAmount",2604.99,"totalClosedBugCnt",7336,"totalResolvedBugCnt",4857,"totalCompleteTaskCnt",4319,"totalPhaseCnt",2620,"totalCompletePhaseCnt",2855,"totalNeedPayAmount",460.84,"totalFinishPayAmount",2248.84,"totalNeedColAmount",7036.19,"totalFinishColAmount",1977.48,"totalCostUserAmount",7584.56,"totalBudgetInnerUserAmount",731.82,"totalPlanWorkload",478.56,"totalRiskCnt",815,"totalCompleteRiskCnt",8669,"branchId","l2y1","branchName","mHQa","totalBudgetOutUserAmount",3404.44,"totalCompleteWorkload",6809.51,"totalCostInnerUserAmount",9219.78,"totalCostOutUserAmount",3531.81,"totalProgress",9024.33,"totalActiveBugCnt",2499,"totalConfirmedBugCnt",318,"projectStatus","Ty46","totalActWorkload",2296.84,"totalActOutWorkload",8928,"totalActInnerWorkload",7763,"totalTaskBudgetCostAt",8054,"totalTaskOutCnt",5624,"totalNeedPayCnt",2162,"totalFinishPayCnt",5737,"totalFinishPayUserCnt",1775,"totalNeedPayUserCnt",8626,"totalPlanInnerUserWorkload",8899.79,"totalPlanOutUserWorkload",4520.12,"testCases",3850,"execCases",4446,"designCases",3370,"finishCases",1885,"iterationCnt",9064,"productCnt",5781,"menuCnt",477);
		XmBranchState xmBranchState=BaseUtils.fromMap(p,XmBranchState.class);
		List<XmBranchState>  xmBranchStates=new ArrayList<>();
		xmBranchStates.add(xmBranchState);
		String jsonXmBranchState=om.writeValueAsString(xmBranchStates);
		mockMvc.perform( post("/**/core/xmBranchState/batchDel").content(jsonXmBranchState).contentType(MediaType.APPLICATION_JSON))
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
