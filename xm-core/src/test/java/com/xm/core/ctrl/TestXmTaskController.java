package com.xm.core.ctrl;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmTask;
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
 * 表 XM.xm_task xm_task<br>
 * 实体 XmTask<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,name,parentTaskid,parentTaskname,projectId,projectName,level,sortLevel,executorUserid,executorUsername,preTaskid,preTaskname,startTime,endTime,milestone,description,remarks,createUserid,createUsername,createTime,rate,budgetCost,budgetWorkload,actCost,actWorkload,taskState,taskType,taskClass,toTaskCenter,actStartTime,actEndTime,bizProcInstId,bizFlowState,projectPhaseId,projectPhaseName,taskSkillNames,exeUsernames,taskSkillIds,exeUserids,taskOut,planType,settleSchemel,menuId,menuName,iterationId,iterationName,productId,productName;<br>
 * 当前表的所有字段名:<br>
 *	id,name,parent_taskid,parent_taskname,project_id,project_name,level,sort_level,executor_userid,executor_username,pre_taskid,pre_taskname,start_time,end_time,milestone,description,remarks,create_userid,create_username,create_time,rate,budget_cost,budget_workload,act_cost,act_workload,task_state,task_type,task_class,to_task_center,act_start_time,act_end_time,biz_proc_inst_id,biz_flow_state,project_phase_id,project_phase_name,task_skill_names,exe_usernames,task_skill_ids,exe_userids,task_out,plan_type,settle_schemel,menu_id,menu_name,iteration_id,iteration_name,product_id,product_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmTaskController {

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
		Map<String,Object> p=BaseUtils.map("id","Gq2X","name","9dPl","parentTaskid","H22g","parentTaskname","oNQT","projectId","Yo4Z","projectName","gnsR","level","yVKJ","sortLevel","F9Rs","executorUserid","4oK4","executorUsername","Q7Mt","preTaskid","cOkY","preTaskname","3xOF","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","XVI5","description","ShzP","remarks","Li2V","createUserid","Hz05","createUsername","iEli","createTime",parse("2020-11-12 2:0:58"),"rate",5135,"budgetCost",8627.51,"budgetWorkload",6380.18,"actCost",8910.73,"actWorkload",5205.25,"taskState","2","taskType","12lB","taskClass","2","toTaskCenter","a","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","qcvj","bizFlowState","G","projectPhaseId","2Okh","projectPhaseName","j07G","taskSkillNames","41tr","exeUsernames","wG42","taskSkillIds","oBbs","exeUserids","e8xQ","taskOut","s","planType","Bbm8","settleSchemel","bJpz","menuId","q672","menuName","6kCz","iterationId","hO01","iterationName","AHJZ","productId","J6Vk","productName","X8qk");
		XmTask xmTask=BaseUtils.fromMap(p,XmTask.class);
		String jsonXmTask=om.writeValueAsString(xmTask);
		mockMvc.perform( post("/**/core/xmTask/add").content(jsonXmTask).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}
	@Test
	public void getOutTask() throws Exception  {
		mockMvc.perform( get("/**/xm/core/xmTask/getOutTask")
				.param("pageNum", "1").param("pageSize", "10").param("isDefault","1"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("tips.isOk").value(true))
				.andExpect(jsonPath("data").isArray())
				.andExpect(jsonPath("total").exists());
	}
	@Test
	public void getOutTask2() throws Exception  {
		mockMvc.perform( get("/**/xm/core/xmTask/getOutTask")
				.param("pageNum", "2").param("pageSize", "10").param("isDefault","1"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("tips.isOk").value(true))
				.andExpect(jsonPath("data").isArray())
				.andExpect(jsonPath("total").exists());
	}
	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/core/xmTask/list")
		.param("id","Gq2X").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("id","Gq2X","name","9dPl","parentTaskid","H22g","parentTaskname","oNQT","projectId","Yo4Z","projectName","gnsR","level","yVKJ","sortLevel","F9Rs","executorUserid","4oK4","executorUsername","Q7Mt","preTaskid","cOkY","preTaskname","3xOF","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","XVI5","description","ShzP","remarks","Li2V","createUserid","Hz05","createUsername","iEli","createTime",parse("2020-11-12 2:0:58"),"rate",5135,"budgetCost",8627.51,"budgetWorkload",6380.18,"actCost",8910.73,"actWorkload",5205.25,"taskState","2","taskType","12lB","taskClass","2","toTaskCenter","a","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","qcvj","bizFlowState","G","projectPhaseId","2Okh","projectPhaseName","j07G","taskSkillNames","41tr","exeUsernames","wG42","taskSkillIds","oBbs","exeUserids","e8xQ","taskOut","s","planType","Bbm8","settleSchemel","bJpz","menuId","q672","menuName","6kCz","iterationId","hO01","iterationName","AHJZ","productId","J6Vk","productName","X8qk");
		XmTask xmTask=BaseUtils.fromMap(p,XmTask.class);
		String jsonXmTask=om.writeValueAsString(xmTask);
		mockMvc.perform( post("/**/core/xmTask/edit").content(jsonXmTask).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/core/xmTask/del").content("Gq2X").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("id","Gq2X","name","9dPl","parentTaskid","H22g","parentTaskname","oNQT","projectId","Yo4Z","projectName","gnsR","level","yVKJ","sortLevel","F9Rs","executorUserid","4oK4","executorUsername","Q7Mt","preTaskid","cOkY","preTaskname","3xOF","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","XVI5","description","ShzP","remarks","Li2V","createUserid","Hz05","createUsername","iEli","createTime",parse("2020-11-12 2:0:58"),"rate",5135,"budgetCost",8627.51,"budgetWorkload",6380.18,"actCost",8910.73,"actWorkload",5205.25,"taskState","2","taskType","12lB","taskClass","2","toTaskCenter","a","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","qcvj","bizFlowState","G","projectPhaseId","2Okh","projectPhaseName","j07G","taskSkillNames","41tr","exeUsernames","wG42","taskSkillIds","oBbs","exeUserids","e8xQ","taskOut","s","planType","Bbm8","settleSchemel","bJpz","menuId","q672","menuName","6kCz","iterationId","hO01","iterationName","AHJZ","productId","J6Vk","productName","X8qk");
		XmTask xmTask=BaseUtils.fromMap(p,XmTask.class);
		List<XmTask>  xmTasks=new ArrayList<>();
		xmTasks.add(xmTask);
		String jsonXmTask=om.writeValueAsString(xmTasks);
		mockMvc.perform( post("/**/core/xmTask/batchDel").content(jsonXmTask).contentType(MediaType.APPLICATION_JSON))
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
