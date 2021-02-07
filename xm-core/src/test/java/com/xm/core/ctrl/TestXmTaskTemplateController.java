package com.xm.core.ctrl;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmTaskTemplate;
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
 * 表 XM.xm_task_template xm_task_template<br>
 * 实体 XmTaskTemplate<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,name,parentTaskid,parentTaskname,projectId,projectName,level,sortLevel,preTaskid,preTaskname,startTime,endTime,milestone,description,remarks,createUserid,createUsername,createTime,rate,budgetCost,budgetWorkload,taskState,taskType,taskClass,toTaskCenter,projectPhaseId,projectPhaseName,taskSkillNames,taskSkillIds,taskOut,planType,settleSchemel,menuId,menuName;<br>
 * 当前表的所有字段名:<br>
 *	id,name,parent_taskid,parent_taskname,project_id,project_name,level,sort_level,pre_taskid,pre_taskname,start_time,end_time,milestone,description,remarks,create_userid,create_username,create_time,rate,budget_cost,budget_workload,task_state,task_type,task_class,to_task_center,project_phase_id,project_phase_name,task_skill_names,task_skill_ids,task_out,plan_type,settle_schemel,menu_id,menu_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmTaskTemplateController {

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
		Map<String,Object> p=BaseUtils.map("id","oagr","name","k1vI","parentTaskid","D3aq","parentTaskname","80Td","projectId","UwcC","projectName","r25z","level","65Y5","sortLevel","02uJ","preTaskid","9oH9","preTaskname","dmP0","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","8vSo","description","8l8A","remarks","V6x7","createUserid","W52i","createUsername","GHZ7","createTime",parse("2020-11-05 12:30:38"),"rate",379,"budgetCost",6905.42,"budgetWorkload",7042.38,"taskState","V","taskType","oZ2f","taskClass","d","toTaskCenter","o","projectPhaseId","PV2b","projectPhaseName","hXO6","taskSkillNames","13Gs","taskSkillIds","jKAC","taskOut","d","planType","8Ga5","settleSchemel","3un2","menuId","leIE","menuName","3m63");
		XmTaskTemplate xmTaskTemplate=BaseUtils.fromMap(p,XmTaskTemplate.class);
		String jsonXmTaskTemplate=om.writeValueAsString(xmTaskTemplate);
		mockMvc.perform( post("/**/xm/xmTaskTemplate/add").content(jsonXmTaskTemplate).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/xm/xmTaskTemplate/list")
		.param("id","oagr").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("id","oagr","name","k1vI","parentTaskid","D3aq","parentTaskname","80Td","projectId","UwcC","projectName","r25z","level","65Y5","sortLevel","02uJ","preTaskid","9oH9","preTaskname","dmP0","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","8vSo","description","8l8A","remarks","V6x7","createUserid","W52i","createUsername","GHZ7","createTime",parse("2020-11-05 12:30:38"),"rate",379,"budgetCost",6905.42,"budgetWorkload",7042.38,"taskState","V","taskType","oZ2f","taskClass","d","toTaskCenter","o","projectPhaseId","PV2b","projectPhaseName","hXO6","taskSkillNames","13Gs","taskSkillIds","jKAC","taskOut","d","planType","8Ga5","settleSchemel","3un2","menuId","leIE","menuName","3m63");
		XmTaskTemplate xmTaskTemplate=BaseUtils.fromMap(p,XmTaskTemplate.class);
		String jsonXmTaskTemplate=om.writeValueAsString(xmTaskTemplate);
		mockMvc.perform( post("/**/xm/xmTaskTemplate/edit").content(jsonXmTaskTemplate).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/xm/xmTaskTemplate/del").content("oagr").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("id","oagr","name","k1vI","parentTaskid","D3aq","parentTaskname","80Td","projectId","UwcC","projectName","r25z","level","65Y5","sortLevel","02uJ","preTaskid","9oH9","preTaskname","dmP0","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","8vSo","description","8l8A","remarks","V6x7","createUserid","W52i","createUsername","GHZ7","createTime",parse("2020-11-05 12:30:38"),"rate",379,"budgetCost",6905.42,"budgetWorkload",7042.38,"taskState","V","taskType","oZ2f","taskClass","d","toTaskCenter","o","projectPhaseId","PV2b","projectPhaseName","hXO6","taskSkillNames","13Gs","taskSkillIds","jKAC","taskOut","d","planType","8Ga5","settleSchemel","3un2","menuId","leIE","menuName","3m63");
		XmTaskTemplate xmTaskTemplate=BaseUtils.fromMap(p,XmTaskTemplate.class);
		List<XmTaskTemplate>  xmTaskTemplates=new ArrayList<>();
		xmTaskTemplates.add(xmTaskTemplate);
		String jsonXmTaskTemplate=om.writeValueAsString(xmTaskTemplates);
		mockMvc.perform( post("/**/xm/xmTaskTemplate/batchDel").content(jsonXmTaskTemplate).contentType(MediaType.APPLICATION_JSON))
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
