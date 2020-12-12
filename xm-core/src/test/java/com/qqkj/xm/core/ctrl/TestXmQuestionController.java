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
import com.qqkj.xm.core.entity.XmQuestion;
import com.qqkj.mdp.core.utils.BaseUtils;
/**
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_question xm_question<br>
 * 实体 XmQuestion<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,name,projectId,projectName,caseId,caseName,endTime,askUserid,askUsername,handlerUserid,handlerUsername,priority,solution,description,createUserid,createUsername,createTime,bugStatus,bizProcInstId,bizFlowState,menuId,menuName,planWorkload,planCostAmount,totalActWorkload,totalActCostAmount,expectResult,opStep,currResult,refRequire,bugSeverity,bugType,tagIds,tagNames,urls,ltime,qtype,taskId,taskName,iterationId,iterationName,caseExecId;<br>
 * 当前表的所有字段名:<br>
 *	id,name,project_id,project_name,case_id,case_name,end_time,ask_userid,ask_username,handler_userid,handler_username,priority,solution,description,create_userid,create_username,create_time,bug_status,biz_proc_inst_id,biz_flow_state,menu_id,menu_name,plan_workload,plan_cost_amount,total_act_workload,total_act_cost_amount,expect_result,op_step,curr_result,ref_require,bug_severity,bug_type,tag_ids,tag_names,urls,ltime,qtype,task_id,task_name,iteration_id,iteration_name,case_exec_id;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmQuestionController {

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
		Map<String,Object> p=BaseUtils.map("id","sXoS","name","wWfb","projectId","dxOl","projectName","O9Be","caseId","X3C9","caseName","afZN","endTime",parse("2020-11-11 18:53:26"),"askUserid","GnKv","askUsername","GkhN","handlerUserid","QEll","handlerUsername","KBvz","priority","d33J","solution","WIv5","description","kVLA","createUserid","6z8B","createUsername","ZqWq","createTime",parse("2020-11-11 18:53:26"),"bugStatus","m540","bizProcInstId","Sk4o","bizFlowState","l","menuId","fO72","menuName","6en0","planWorkload",1481.06,"planCostAmount",990.82,"totalActWorkload",7620.18,"totalActCostAmount",946.55,"expectResult","rWD8","opStep","q96s","currResult","bmNR","refRequire","wGWE","bugSeverity","v7x9","bugType","VX22","tagIds","kgJR","tagNames","JWLK","urls","LIjV","ltime",parse("2020-11-11 18:53:26"),"qtype","80wt","taskId","TG0X","taskName","raGt","iterationId","ZfNn","iterationName","QgRg","caseExecId","Aq9i");
		XmQuestion xmQuestion=BaseUtils.fromMap(p,XmQuestion.class);
		String jsonXmQuestion=om.writeValueAsString(xmQuestion);
		mockMvc.perform( post("/**/core/xmQuestion/add").content(jsonXmQuestion).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/core/xmQuestion/list")
		.param("id","sXoS").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("id","sXoS","name","wWfb","projectId","dxOl","projectName","O9Be","caseId","X3C9","caseName","afZN","endTime",parse("2020-11-11 18:53:26"),"askUserid","GnKv","askUsername","GkhN","handlerUserid","QEll","handlerUsername","KBvz","priority","d33J","solution","WIv5","description","kVLA","createUserid","6z8B","createUsername","ZqWq","createTime",parse("2020-11-11 18:53:26"),"bugStatus","m540","bizProcInstId","Sk4o","bizFlowState","l","menuId","fO72","menuName","6en0","planWorkload",1481.06,"planCostAmount",990.82,"totalActWorkload",7620.18,"totalActCostAmount",946.55,"expectResult","rWD8","opStep","q96s","currResult","bmNR","refRequire","wGWE","bugSeverity","v7x9","bugType","VX22","tagIds","kgJR","tagNames","JWLK","urls","LIjV","ltime",parse("2020-11-11 18:53:26"),"qtype","80wt","taskId","TG0X","taskName","raGt","iterationId","ZfNn","iterationName","QgRg","caseExecId","Aq9i");
		XmQuestion xmQuestion=BaseUtils.fromMap(p,XmQuestion.class);
		String jsonXmQuestion=om.writeValueAsString(xmQuestion);
		mockMvc.perform( post("/**/core/xmQuestion/edit").content(jsonXmQuestion).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/core/xmQuestion/del").content("sXoS").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("id","sXoS","name","wWfb","projectId","dxOl","projectName","O9Be","caseId","X3C9","caseName","afZN","endTime",parse("2020-11-11 18:53:26"),"askUserid","GnKv","askUsername","GkhN","handlerUserid","QEll","handlerUsername","KBvz","priority","d33J","solution","WIv5","description","kVLA","createUserid","6z8B","createUsername","ZqWq","createTime",parse("2020-11-11 18:53:26"),"bugStatus","m540","bizProcInstId","Sk4o","bizFlowState","l","menuId","fO72","menuName","6en0","planWorkload",1481.06,"planCostAmount",990.82,"totalActWorkload",7620.18,"totalActCostAmount",946.55,"expectResult","rWD8","opStep","q96s","currResult","bmNR","refRequire","wGWE","bugSeverity","v7x9","bugType","VX22","tagIds","kgJR","tagNames","JWLK","urls","LIjV","ltime",parse("2020-11-11 18:53:26"),"qtype","80wt","taskId","TG0X","taskName","raGt","iterationId","ZfNn","iterationName","QgRg","caseExecId","Aq9i");
		XmQuestion xmQuestion=BaseUtils.fromMap(p,XmQuestion.class);
		List<XmQuestion>  xmQuestions=new ArrayList<>();
		xmQuestions.add(xmQuestion);
		String jsonXmQuestion=om.writeValueAsString(xmQuestions);
		mockMvc.perform( post("/**/core/xmQuestion/batchDel").content(jsonXmQuestion).contentType(MediaType.APPLICATION_JSON))
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
