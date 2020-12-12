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
import com.qqkj.xm.core.entity.XmTestCaseExec;
import com.qqkj.mdp.core.utils.BaseUtils;
/**
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_test_case_exec xm_test_case_exec<br>
 * 实体 XmTestCaseExec<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	execUserid,startTime,id,projectId,projectName,caseId,caseName,endTime,remark,createUserid,createUsername,createTime,execStatus,iterationId,iterationName,execUsername,taskId,taskName,menuId,menuName;<br>
 * 当前表的所有字段名:<br>
 *	exec_userid,start_time,id,project_id,project_name,case_id,case_name,end_time,remark,create_userid,create_username,create_time,exec_status,iteration_id,iteration_name,exec_username,task_id,task_name,menu_id,menu_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmTestCaseExecController {

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
		Map<String,Object> p=BaseUtils.map("execUserid","vQXx","startTime",parse("2020-11-13 2:28:31"),"id","IMeb","projectId","eyLs","projectName","omUL","caseId","Pmaa","caseName","b9qi","endTime",parse("2020-11-13 2:28:31"),"remark","Ns5O","createUserid","YHU7","createUsername","hueb","createTime",parse("2020-11-13 2:28:31"),"execStatus","D","iterationId","Z0mT","iterationName","Pn9M","execUsername","f1ob","taskId","aJhV","taskName","KgQF","menuId","2o3l","menuName","yFwY");
		XmTestCaseExec xmTestCaseExec=BaseUtils.fromMap(p,XmTestCaseExec.class);
		String jsonXmTestCaseExec=om.writeValueAsString(xmTestCaseExec);
		mockMvc.perform( post("/**/core/xmTestCaseExec/add").content(jsonXmTestCaseExec).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/core/xmTestCaseExec/list")
		.param("id","IMeb").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("execUserid","vQXx","startTime",parse("2020-11-13 2:28:31"),"id","IMeb","projectId","eyLs","projectName","omUL","caseId","Pmaa","caseName","b9qi","endTime",parse("2020-11-13 2:28:31"),"remark","Ns5O","createUserid","YHU7","createUsername","hueb","createTime",parse("2020-11-13 2:28:31"),"execStatus","D","iterationId","Z0mT","iterationName","Pn9M","execUsername","f1ob","taskId","aJhV","taskName","KgQF","menuId","2o3l","menuName","yFwY");
		XmTestCaseExec xmTestCaseExec=BaseUtils.fromMap(p,XmTestCaseExec.class);
		String jsonXmTestCaseExec=om.writeValueAsString(xmTestCaseExec);
		mockMvc.perform( post("/**/core/xmTestCaseExec/edit").content(jsonXmTestCaseExec).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/core/xmTestCaseExec/del").content("IMeb").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("execUserid","vQXx","startTime",parse("2020-11-13 2:28:31"),"id","IMeb","projectId","eyLs","projectName","omUL","caseId","Pmaa","caseName","b9qi","endTime",parse("2020-11-13 2:28:31"),"remark","Ns5O","createUserid","YHU7","createUsername","hueb","createTime",parse("2020-11-13 2:28:31"),"execStatus","D","iterationId","Z0mT","iterationName","Pn9M","execUsername","f1ob","taskId","aJhV","taskName","KgQF","menuId","2o3l","menuName","yFwY");
		XmTestCaseExec xmTestCaseExec=BaseUtils.fromMap(p,XmTestCaseExec.class);
		List<XmTestCaseExec>  xmTestCaseExecs=new ArrayList<>();
		xmTestCaseExecs.add(xmTestCaseExec);
		String jsonXmTestCaseExec=om.writeValueAsString(xmTestCaseExecs);
		mockMvc.perform( post("/**/core/xmTestCaseExec/batchDel").content(jsonXmTestCaseExec).contentType(MediaType.APPLICATION_JSON))
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
