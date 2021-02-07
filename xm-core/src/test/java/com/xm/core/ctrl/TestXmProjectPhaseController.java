package com.xm.core.ctrl;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmProjectPhase;
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
 * 表 XM.xm_project_phase 项目阶段模板<br>
 * 实体 XmProjectPhase<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,phaseName,remark,parentPhaseId,branchId,projectId,beginDate,endDate,phaseBudgetHours,phaseBudgetStaffNu,ctime,phaseBudgetNouserAt,phaseBudgetInnerUserAt,phaseBudgetOutUserAt,projectBaselineId,bizProcInstId,bizFlowState,phaseBudgetWorkload,phaseActWorkload,phaseActInnerUserWorkload,phaseActOutUserWorkload,taskType,planType,seqNo,phaseBudgetInnerUserWorkload,phaseBudgetOutUserWorkload,actNouserAt,actInnerUserAt,phaseBudgetInnerUserPrice,phaseBudgetOutUserPrice,phaseBudgetOutUserCnt,phaseBudgetInnerUserCnt,actRate,phaseStatus,actOutUserAt,taskCnt,finishTaskCnt,iterationCnt,calcTime,taskBudgetWorkload,taskBudgetAt;<br>
 * 当前表的所有字段名:<br>
 *	id,phase_name,remark,parent_phase_id,branch_id,project_id,begin_date,end_date,phase_budget_hours,phase_budget_staff_nu,ctime,phase_budget_nouser_at,phase_budget_inner_user_at,phase_budget_out_user_at,project_baseline_id,biz_proc_inst_id,biz_flow_state,phase_budget_workload,phase_act_workload,phase_act_inner_user_workload,phase_act_out_user_workload,task_type,plan_type,seq_no,phase_budget_inner_user_workload,phase_budget_out_user_workload,act_nouser_at,act_inner_user_at,phase_budget_inner_user_price,phase_budget_out_user_price,phase_budget_out_user_cnt,phase_budget_inner_user_cnt,act_rate,phase_status,act_out_user_at,task_cnt,finish_task_cnt,iteration_cnt,calc_time,task_budget_workload,task_budget_at;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectPhaseController {

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
		Map<String,Object> p=BaseUtils.map("id","W3Cl","phaseName","oC8h","remark","6qnJ","parentPhaseId","iAvB","branchId","X21N","projectId","JM48","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",6480.9,"phaseBudgetStaffNu",9252,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",2941.61,"phaseBudgetInnerUserAt",5005.56,"phaseBudgetOutUserAt",4509.56,"projectBaselineId","9ha7","bizProcInstId","nteE","bizFlowState","g","phaseBudgetWorkload",6773.34,"phaseActWorkload",1844.77,"phaseActInnerUserWorkload",1973.77,"phaseActOutUserWorkload",3328.2,"taskType","Hain","planType","Fp16","seqNo","rSK2","phaseBudgetInnerUserWorkload",3782.43,"phaseBudgetOutUserWorkload",5948.69,"actNouserAt",5275.47,"actInnerUserAt",9374.98,"phaseBudgetInnerUserPrice",531.05,"phaseBudgetOutUserPrice",3718.12,"phaseBudgetOutUserCnt",342,"phaseBudgetInnerUserCnt",7108,"actRate",4924.7,"phaseStatus","K","actOutUserAt",8346.62,"taskCnt",8397,"finishTaskCnt",5822,"iterationCnt",9512,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",9739.52,"taskBudgetAt",213.68);
		XmProjectPhase xmProjectPhase=BaseUtils.fromMap(p,XmProjectPhase.class);
		String jsonXmProjectPhase=om.writeValueAsString(xmProjectPhase);
		mockMvc.perform( post("/**/core/xmProjectPhase/add").content(jsonXmProjectPhase).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/core/xmProjectPhase/list")
		.param("id","W3Cl").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("id","W3Cl","phaseName","oC8h","remark","6qnJ","parentPhaseId","iAvB","branchId","X21N","projectId","JM48","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",6480.9,"phaseBudgetStaffNu",9252,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",2941.61,"phaseBudgetInnerUserAt",5005.56,"phaseBudgetOutUserAt",4509.56,"projectBaselineId","9ha7","bizProcInstId","nteE","bizFlowState","g","phaseBudgetWorkload",6773.34,"phaseActWorkload",1844.77,"phaseActInnerUserWorkload",1973.77,"phaseActOutUserWorkload",3328.2,"taskType","Hain","planType","Fp16","seqNo","rSK2","phaseBudgetInnerUserWorkload",3782.43,"phaseBudgetOutUserWorkload",5948.69,"actNouserAt",5275.47,"actInnerUserAt",9374.98,"phaseBudgetInnerUserPrice",531.05,"phaseBudgetOutUserPrice",3718.12,"phaseBudgetOutUserCnt",342,"phaseBudgetInnerUserCnt",7108,"actRate",4924.7,"phaseStatus","K","actOutUserAt",8346.62,"taskCnt",8397,"finishTaskCnt",5822,"iterationCnt",9512,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",9739.52,"taskBudgetAt",213.68);
		XmProjectPhase xmProjectPhase=BaseUtils.fromMap(p,XmProjectPhase.class);
		String jsonXmProjectPhase=om.writeValueAsString(xmProjectPhase);
		mockMvc.perform( post("/**/core/xmProjectPhase/edit").content(jsonXmProjectPhase).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/core/xmProjectPhase/del").content("W3Cl").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("id","W3Cl","phaseName","oC8h","remark","6qnJ","parentPhaseId","iAvB","branchId","X21N","projectId","JM48","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",6480.9,"phaseBudgetStaffNu",9252,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",2941.61,"phaseBudgetInnerUserAt",5005.56,"phaseBudgetOutUserAt",4509.56,"projectBaselineId","9ha7","bizProcInstId","nteE","bizFlowState","g","phaseBudgetWorkload",6773.34,"phaseActWorkload",1844.77,"phaseActInnerUserWorkload",1973.77,"phaseActOutUserWorkload",3328.2,"taskType","Hain","planType","Fp16","seqNo","rSK2","phaseBudgetInnerUserWorkload",3782.43,"phaseBudgetOutUserWorkload",5948.69,"actNouserAt",5275.47,"actInnerUserAt",9374.98,"phaseBudgetInnerUserPrice",531.05,"phaseBudgetOutUserPrice",3718.12,"phaseBudgetOutUserCnt",342,"phaseBudgetInnerUserCnt",7108,"actRate",4924.7,"phaseStatus","K","actOutUserAt",8346.62,"taskCnt",8397,"finishTaskCnt",5822,"iterationCnt",9512,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",9739.52,"taskBudgetAt",213.68);
		XmProjectPhase xmProjectPhase=BaseUtils.fromMap(p,XmProjectPhase.class);
		List<XmProjectPhase>  xmProjectPhases=new ArrayList<>();
		xmProjectPhases.add(xmProjectPhase);
		String jsonXmProjectPhase=om.writeValueAsString(xmProjectPhases);
		mockMvc.perform( post("/**/core/xmProjectPhase/batchDel").content(jsonXmProjectPhase).contentType(MediaType.APPLICATION_JSON))
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
