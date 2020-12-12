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
import com.qqkj.xm.core.entity.XmProjectStateHis;
import com.qqkj.mdp.core.utils.BaseUtils;
/**
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
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectStateHisController {

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
		Map<String,Object> p=BaseUtils.map("projectId","yAe9","bizDate","vuIS","totalFileCnt",9821,"totalBugCnt",2939,"totalTaskCnt",8980,"totalBudgetNouserAmount",584.68,"projectName","nPT9","id","nZ84","totalStaffCnt",328,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","9","totalCostNouserAmount",4312.01,"totalClosedBugCnt",9724,"totalResolvedBugCnt",3695,"totalCompleteTaskCnt",3233,"totalPhaseCnt",219,"totalCompletePhaseCnt",6324,"totalNeedPayAmount",7409.83,"totalFinishPayAmount",2545.75,"totalNeedColAmount",1648.86,"totalFinishColAmount",5071.08,"totalCostUserAmount",2106.46,"totalBudgetInnerUserAmount",8479.47,"totalPlanWorkload",9943.39,"totalRiskCnt",5166,"totalCompleteRiskCnt",1618,"branchId","ICi1","branchName","xgh9","totalBudgetOutUserAmount",2679.32,"totalCompleteWorkload",1822.99,"totalCostInnerUserAmount",224.99,"totalCostOutUserAmount",3096.75,"totalProgress",7686.98,"totalActiveBugCnt",3341,"totalConfirmedBugCnt",9164,"projectStatus","pufi","totalActWorkload",1679.91,"totalActOutWorkload",2104,"totalActInnerWorkload",8027,"totalTaskBudgetCostAt",8868.89,"totalTaskOutCnt",5735,"totalNeedPayCnt",3369,"totalFinishPayCnt",8041,"totalFinishPayUserCnt",8182,"totalNeedPayUserCnt",5729,"totalPlanInnerUserWorkload",2366.25,"totalPlanOutUserWorkload",7677.67,"testCases",481,"execCases",527,"designCases",3173,"finishCases",2772,"iterationCnt",3180,"productCnt",6626,"menuCnt",7102);
		XmProjectStateHis xmProjectStateHis=BaseUtils.fromMap(p,XmProjectStateHis.class);
		String jsonXmProjectStateHis=om.writeValueAsString(xmProjectStateHis);
		mockMvc.perform( post("/**/core/xmProjectStateHis/add").content(jsonXmProjectStateHis).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/core/xmProjectStateHis/list")
		.param("id","nZ84").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("projectId","yAe9","bizDate","vuIS","totalFileCnt",9821,"totalBugCnt",2939,"totalTaskCnt",8980,"totalBudgetNouserAmount",584.68,"projectName","nPT9","id","nZ84","totalStaffCnt",328,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","9","totalCostNouserAmount",4312.01,"totalClosedBugCnt",9724,"totalResolvedBugCnt",3695,"totalCompleteTaskCnt",3233,"totalPhaseCnt",219,"totalCompletePhaseCnt",6324,"totalNeedPayAmount",7409.83,"totalFinishPayAmount",2545.75,"totalNeedColAmount",1648.86,"totalFinishColAmount",5071.08,"totalCostUserAmount",2106.46,"totalBudgetInnerUserAmount",8479.47,"totalPlanWorkload",9943.39,"totalRiskCnt",5166,"totalCompleteRiskCnt",1618,"branchId","ICi1","branchName","xgh9","totalBudgetOutUserAmount",2679.32,"totalCompleteWorkload",1822.99,"totalCostInnerUserAmount",224.99,"totalCostOutUserAmount",3096.75,"totalProgress",7686.98,"totalActiveBugCnt",3341,"totalConfirmedBugCnt",9164,"projectStatus","pufi","totalActWorkload",1679.91,"totalActOutWorkload",2104,"totalActInnerWorkload",8027,"totalTaskBudgetCostAt",8868.89,"totalTaskOutCnt",5735,"totalNeedPayCnt",3369,"totalFinishPayCnt",8041,"totalFinishPayUserCnt",8182,"totalNeedPayUserCnt",5729,"totalPlanInnerUserWorkload",2366.25,"totalPlanOutUserWorkload",7677.67,"testCases",481,"execCases",527,"designCases",3173,"finishCases",2772,"iterationCnt",3180,"productCnt",6626,"menuCnt",7102);
		XmProjectStateHis xmProjectStateHis=BaseUtils.fromMap(p,XmProjectStateHis.class);
		String jsonXmProjectStateHis=om.writeValueAsString(xmProjectStateHis);
		mockMvc.perform( post("/**/core/xmProjectStateHis/edit").content(jsonXmProjectStateHis).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/core/xmProjectStateHis/del").content("nZ84").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("projectId","yAe9","bizDate","vuIS","totalFileCnt",9821,"totalBugCnt",2939,"totalTaskCnt",8980,"totalBudgetNouserAmount",584.68,"projectName","nPT9","id","nZ84","totalStaffCnt",328,"calcTime",parse("2020-11-11 18:53:27"),"calcStatus","9","totalCostNouserAmount",4312.01,"totalClosedBugCnt",9724,"totalResolvedBugCnt",3695,"totalCompleteTaskCnt",3233,"totalPhaseCnt",219,"totalCompletePhaseCnt",6324,"totalNeedPayAmount",7409.83,"totalFinishPayAmount",2545.75,"totalNeedColAmount",1648.86,"totalFinishColAmount",5071.08,"totalCostUserAmount",2106.46,"totalBudgetInnerUserAmount",8479.47,"totalPlanWorkload",9943.39,"totalRiskCnt",5166,"totalCompleteRiskCnt",1618,"branchId","ICi1","branchName","xgh9","totalBudgetOutUserAmount",2679.32,"totalCompleteWorkload",1822.99,"totalCostInnerUserAmount",224.99,"totalCostOutUserAmount",3096.75,"totalProgress",7686.98,"totalActiveBugCnt",3341,"totalConfirmedBugCnt",9164,"projectStatus","pufi","totalActWorkload",1679.91,"totalActOutWorkload",2104,"totalActInnerWorkload",8027,"totalTaskBudgetCostAt",8868.89,"totalTaskOutCnt",5735,"totalNeedPayCnt",3369,"totalFinishPayCnt",8041,"totalFinishPayUserCnt",8182,"totalNeedPayUserCnt",5729,"totalPlanInnerUserWorkload",2366.25,"totalPlanOutUserWorkload",7677.67,"testCases",481,"execCases",527,"designCases",3173,"finishCases",2772,"iterationCnt",3180,"productCnt",6626,"menuCnt",7102);
		XmProjectStateHis xmProjectStateHis=BaseUtils.fromMap(p,XmProjectStateHis.class);
		List<XmProjectStateHis>  xmProjectStateHiss=new ArrayList<>();
		xmProjectStateHiss.add(xmProjectStateHis);
		String jsonXmProjectStateHis=om.writeValueAsString(xmProjectStateHiss);
		mockMvc.perform( post("/**/core/xmProjectStateHis/batchDel").content(jsonXmProjectStateHis).contentType(MediaType.APPLICATION_JSON))
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
