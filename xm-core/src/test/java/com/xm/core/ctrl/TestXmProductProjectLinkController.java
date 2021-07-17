package com.xm.core.ctrl;

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
import com.xm.core.entity.XmProductProjectLink;
import com.mdp.core.utils.BaseUtils;
/**
 * 组织 com<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_product_project_link 产品与项目的关联关系表，一般由产品经理挂接项目到产品上<br>
 * 实体 XmProductProjectLink<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	projectId,productId,ctime,cuserid,cusername,linkStatus;<br>
 * 当前表的所有字段名:<br>
 *	project_id,product_id,ctime,cuserid,cusername,link_status;<br>
 * 当前主键(包括多主键):<br>
 *	project_id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProductProjectLinkController {

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
		Map<String,Object> p=BaseUtils.map("projectId","b1g5","productId","V9Uu","ctime",new Date("2021-07-17 20:28:11"),"cuserid","uw3F","cusername","sPev","linkStatus","1");
		XmProductProjectLink xmProductProjectLink=BaseUtils.fromMap(p,XmProductProjectLink.class);
		String jsonXmProductProjectLink=om.writeValueAsString(xmProductProjectLink);
		mockMvc.perform( post("/**/core/xmProductProjectLink/add").content(jsonXmProductProjectLink).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/core/xmProductProjectLink/list")
		.param("projectId","b1g5").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("projectId","b1g5","productId","V9Uu","ctime",new Date("2021-07-17 20:28:11"),"cuserid","uw3F","cusername","sPev","linkStatus","1");
		XmProductProjectLink xmProductProjectLink=BaseUtils.fromMap(p,XmProductProjectLink.class);
		String jsonXmProductProjectLink=om.writeValueAsString(xmProductProjectLink);
		mockMvc.perform( post("/**/core/xmProductProjectLink/edit").content(jsonXmProductProjectLink).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/core/xmProductProjectLink/del").content("b1g5").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("projectId","b1g5","productId","V9Uu","ctime",new Date("2021-07-17 20:28:11"),"cuserid","uw3F","cusername","sPev","linkStatus","1");
		XmProductProjectLink xmProductProjectLink=BaseUtils.fromMap(p,XmProductProjectLink.class);
		List<XmProductProjectLink>  xmProductProjectLinks=new ArrayList<>();
		xmProductProjectLinks.add(xmProductProjectLink);
		String jsonXmProductProjectLink=om.writeValueAsString(xmProductProjectLinks);
		mockMvc.perform( post("/**/core/xmProductProjectLink/batchDel").content(jsonXmProductProjectLink).contentType(MediaType.APPLICATION_JSON))
		   .andDo(print())
		   .andExpect(status().isOk())  
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	 
}
