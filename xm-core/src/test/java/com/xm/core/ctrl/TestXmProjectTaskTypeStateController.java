package com.xm.core.ctrl;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmProjectTaskTypeState;
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
 * 表 XM.xm_project_task_type_state 按任务类型汇总<br>
 * 实体 XmProjectTaskTypeState<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	projectId,projectName,taskType,planWorkload,planAmount,actWorkload,actAmount,branchId,bizDate,calcTime,planOutUserAt,planInnerUserAt,actOutUserAt,actInnerUserAt,planOutUserWorkload,planInnerUserWorkload,actOutUserWorkload,actInnerUserWorkload,planNouserAt,actNouserAt,id;<br>
 * 当前表的所有字段名:<br>
 *	project_id,project_name,task_type,plan_workload,plan_amount,act_workload,act_amount,branch_id,biz_date,calc_time,plan_out_user_at,plan_inner_user_at,act_out_user_at,act_inner_user_at,plan_out_user_workload,plan_inner_user_workload,act_out_user_workload,act_inner_user_workload,plan_nouser_at,act_nouser_at,id;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectTaskTypeStateController {

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
		Map<String,Object> p=BaseUtils.map("projectId","2026","projectName","s04L","taskType","21dl","planWorkload",5018.64,"planAmount",5303.27,"actWorkload",3877.43,"actAmount",6905.88,"branchId","5kDo","bizDate","Vh9r","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",4913.84,"planInnerUserAt",7569.39,"actOutUserAt",8610.81,"actInnerUserAt",7444.48,"planOutUserWorkload",4087.88,"planInnerUserWorkload",9368.57,"actOutUserWorkload",9103.11,"actInnerUserWorkload",5913.89,"planNouserAt",4466.72,"actNouserAt",655.77,"id","5miH");
		XmProjectTaskTypeState xmProjectTaskTypeState=BaseUtils.fromMap(p,XmProjectTaskTypeState.class);
		String jsonXmProjectTaskTypeState=om.writeValueAsString(xmProjectTaskTypeState);
		mockMvc.perform( post("/**/core/xmProjectTaskTypeState/add").content(jsonXmProjectTaskTypeState).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/core/xmProjectTaskTypeState/list")
		.param("id","5miH").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("projectId","2026","projectName","s04L","taskType","21dl","planWorkload",5018.64,"planAmount",5303.27,"actWorkload",3877.43,"actAmount",6905.88,"branchId","5kDo","bizDate","Vh9r","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",4913.84,"planInnerUserAt",7569.39,"actOutUserAt",8610.81,"actInnerUserAt",7444.48,"planOutUserWorkload",4087.88,"planInnerUserWorkload",9368.57,"actOutUserWorkload",9103.11,"actInnerUserWorkload",5913.89,"planNouserAt",4466.72,"actNouserAt",655.77,"id","5miH");
		XmProjectTaskTypeState xmProjectTaskTypeState=BaseUtils.fromMap(p,XmProjectTaskTypeState.class);
		String jsonXmProjectTaskTypeState=om.writeValueAsString(xmProjectTaskTypeState);
		mockMvc.perform( post("/**/core/xmProjectTaskTypeState/edit").content(jsonXmProjectTaskTypeState).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/core/xmProjectTaskTypeState/del").content("5miH").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("projectId","2026","projectName","s04L","taskType","21dl","planWorkload",5018.64,"planAmount",5303.27,"actWorkload",3877.43,"actAmount",6905.88,"branchId","5kDo","bizDate","Vh9r","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",4913.84,"planInnerUserAt",7569.39,"actOutUserAt",8610.81,"actInnerUserAt",7444.48,"planOutUserWorkload",4087.88,"planInnerUserWorkload",9368.57,"actOutUserWorkload",9103.11,"actInnerUserWorkload",5913.89,"planNouserAt",4466.72,"actNouserAt",655.77,"id","5miH");
		XmProjectTaskTypeState xmProjectTaskTypeState=BaseUtils.fromMap(p,XmProjectTaskTypeState.class);
		List<XmProjectTaskTypeState>  xmProjectTaskTypeStates=new ArrayList<>();
		xmProjectTaskTypeStates.add(xmProjectTaskTypeState);
		String jsonXmProjectTaskTypeState=om.writeValueAsString(xmProjectTaskTypeStates);
		mockMvc.perform( post("/**/core/xmProjectTaskTypeState/batchDel").content(jsonXmProjectTaskTypeState).contentType(MediaType.APPLICATION_JSON))
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
