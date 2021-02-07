package com.xm.core.ctrl;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmProjectMBudgetCostUser;
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
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_project_m_budget_cost_user xm_project_m_budget_cost_user<br>
 * 实体 XmProjectMBudgetCostUser<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	projectId,userid,budgetCost,id,remark,username,subjectId,bizzStartDate,bizzEndDate,bizzMonth,bizProcInstId,bizFlowState,projectPhaseId,costType;<br>
 * 当前表的所有字段名:<br>
 *	project_id,userid,budget_cost,id,remark,username,subject_id,bizz_start_date,bizz_end_date,bizz_month,biz_proc_inst_id,biz_flow_state,project_phase_id,cost_type;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectMBudgetCostUserController {

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
		Map<String,Object> p=BaseUtils.map("projectId","aH71","userid","5R6l","budgetCost",2842.17,"id","zARB","remark","FVK0","username","Sp7K","subjectId","8ONu","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","KG3H","bizProcInstId","sUMB","bizFlowState","0","projectPhaseId","mg6S","costType","E");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser=BaseUtils.fromMap(p,XmProjectMBudgetCostUser.class);
		String jsonXmProjectMBudgetCostUser=om.writeValueAsString(xmProjectMBudgetCostUser);
		mockMvc.perform( post("/**/xm/xmProjectMBudgetCostUser/add").content(jsonXmProjectMBudgetCostUser).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/xm/xmProjectMBudgetCostUser/list")
		.param("id","zARB").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("pageInfo.total").exists());
	}
	
	@Test
	public void listKey() throws Exception  {
		mockMvc.perform( get("/**/xm/xmProjectMBudgetCostUser/listKey")
		.param("id","zARB").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("pageInfo.total").exists());
	}

	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("projectId","aH71","userid","5R6l","budgetCost",2842.17,"id","zARB","remark","FVK0","username","Sp7K","subjectId","8ONu","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","KG3H","bizProcInstId","sUMB","bizFlowState","0","projectPhaseId","mg6S","costType","E");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser=BaseUtils.fromMap(p,XmProjectMBudgetCostUser.class);
		String jsonXmProjectMBudgetCostUser=om.writeValueAsString(xmProjectMBudgetCostUser);
		mockMvc.perform( post("/**/xm/xmProjectMBudgetCostUser/edit").content(jsonXmProjectMBudgetCostUser).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/xm/xmProjectMBudgetCostUser/del").content("zARB").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("projectId","aH71","userid","5R6l","budgetCost",2842.17,"id","zARB","remark","FVK0","username","Sp7K","subjectId","8ONu","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","KG3H","bizProcInstId","sUMB","bizFlowState","0","projectPhaseId","mg6S","costType","E");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser=BaseUtils.fromMap(p,XmProjectMBudgetCostUser.class);
		List<XmProjectMBudgetCostUser>  xmProjectMBudgetCostUsers=new ArrayList<>();
		xmProjectMBudgetCostUsers.add(xmProjectMBudgetCostUser);
		String jsonXmProjectMBudgetCostUser=om.writeValueAsString(xmProjectMBudgetCostUsers);
		mockMvc.perform( post("/**/xm/xmProjectMBudgetCostUser/batchDel").content(jsonXmProjectMBudgetCostUser).contentType(MediaType.APPLICATION_JSON))
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
