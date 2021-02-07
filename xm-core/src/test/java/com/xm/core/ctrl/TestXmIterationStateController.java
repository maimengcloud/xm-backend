package com.xm.core.ctrl;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmIterationState;
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
 * 表 XM.xm_iteration_state 迭代定义<br>
 * 实体 XmIterationState<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,distBudgetCost,distBudgetWorkload,actCost,actWorkload,actStaffNum,finishRate,testCases,execCases,designCases,finishCases,projectCnt,productCnt,menuCnt,taskCnt,finishTaskCnt,calcTime,iterationName,budgetCost,budgetWorkload,iterationId,bizDate,closedBugCnt,resolvedBugCnt,activeBugCnt,confirmedBugCnt,bugCnt;<br>
 * 当前表的所有字段名:<br>
 *	id,dist_budget_cost,dist_budget_workload,act_cost,act_workload,act_staff_num,finish_rate,test_cases,exec_cases,design_cases,finish_cases,project_cnt,product_cnt,menu_cnt,task_cnt,finish_task_cnt,calc_time,iteration_name,budget_cost,budget_workload,iteration_id,biz_date,closed_bug_cnt,resolved_bug_cnt,active_bug_cnt,confirmed_bug_cnt,bug_cnt;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmIterationStateController {

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
		Map<String,Object> p=BaseUtils.map("id","1g8O","distBudgetCost",2580.66,"distBudgetWorkload",5963.69,"actCost",6187.77,"actWorkload",7364.31,"actStaffNum",7393,"finishRate",7196.84,"testCases",6244,"execCases",6389,"designCases",6823,"finishCases",5397,"projectCnt",4062,"productCnt",5338,"menuCnt",4450,"taskCnt",1630,"finishTaskCnt",4194,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","Md56","budgetCost",2647.08,"budgetWorkload",908.36,"iterationId","2yyX","bizDate","4Wb0","closedBugCnt",7878,"resolvedBugCnt",99,"activeBugCnt",9616,"confirmedBugCnt",8834,"bugCnt",6075);
		XmIterationState xmIterationState=BaseUtils.fromMap(p,XmIterationState.class);
		String jsonXmIterationState=om.writeValueAsString(xmIterationState);
		mockMvc.perform( post("/**/core/xmIterationState/add").content(jsonXmIterationState).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/core/xmIterationState/list")
		.param("id","1g8O").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("id","1g8O","distBudgetCost",2580.66,"distBudgetWorkload",5963.69,"actCost",6187.77,"actWorkload",7364.31,"actStaffNum",7393,"finishRate",7196.84,"testCases",6244,"execCases",6389,"designCases",6823,"finishCases",5397,"projectCnt",4062,"productCnt",5338,"menuCnt",4450,"taskCnt",1630,"finishTaskCnt",4194,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","Md56","budgetCost",2647.08,"budgetWorkload",908.36,"iterationId","2yyX","bizDate","4Wb0","closedBugCnt",7878,"resolvedBugCnt",99,"activeBugCnt",9616,"confirmedBugCnt",8834,"bugCnt",6075);
		XmIterationState xmIterationState=BaseUtils.fromMap(p,XmIterationState.class);
		String jsonXmIterationState=om.writeValueAsString(xmIterationState);
		mockMvc.perform( post("/**/core/xmIterationState/edit").content(jsonXmIterationState).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/core/xmIterationState/del").content("1g8O").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("id","1g8O","distBudgetCost",2580.66,"distBudgetWorkload",5963.69,"actCost",6187.77,"actWorkload",7364.31,"actStaffNum",7393,"finishRate",7196.84,"testCases",6244,"execCases",6389,"designCases",6823,"finishCases",5397,"projectCnt",4062,"productCnt",5338,"menuCnt",4450,"taskCnt",1630,"finishTaskCnt",4194,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","Md56","budgetCost",2647.08,"budgetWorkload",908.36,"iterationId","2yyX","bizDate","4Wb0","closedBugCnt",7878,"resolvedBugCnt",99,"activeBugCnt",9616,"confirmedBugCnt",8834,"bugCnt",6075);
		XmIterationState xmIterationState=BaseUtils.fromMap(p,XmIterationState.class);
		List<XmIterationState>  xmIterationStates=new ArrayList<>();
		xmIterationStates.add(xmIterationState);
		String jsonXmIterationState=om.writeValueAsString(xmIterationStates);
		mockMvc.perform( post("/**/core/xmIterationState/batchDel").content(jsonXmIterationState).contentType(MediaType.APPLICATION_JSON))
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
