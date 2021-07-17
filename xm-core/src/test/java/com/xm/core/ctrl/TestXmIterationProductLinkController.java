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
import com.xm.core.entity.XmIterationProductLink;
import com.mdp.core.utils.BaseUtils;
/**
 * 组织 com<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_iteration_product_link 迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表<br>
 * 实体 XmIterationProductLink<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	iterationId,productId,ctime,cuserid,cusername,linkStatus;<br>
 * 当前表的所有字段名:<br>
 *	iteration_id,product_id,ctime,cuserid,cusername,link_status;<br>
 * 当前主键(包括多主键):<br>
 *	iteration_id,product_id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmIterationProductLinkController {

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
		Map<String,Object> p=BaseUtils.map("iterationId","BcN5","productId","7rUG","ctime",new Date("2021-07-17 20:28:11"),"cuserid","UpT2","cusername","y2y7","linkStatus","p");
		XmIterationProductLink xmIterationProductLink=BaseUtils.fromMap(p,XmIterationProductLink.class);
		String jsonXmIterationProductLink=om.writeValueAsString(xmIterationProductLink);
		mockMvc.perform( post("/**/core/xmIterationProductLink/add").content(jsonXmIterationProductLink).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/core/xmIterationProductLink/list")
		.param("iterationId","BcN5").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("iterationId","BcN5","productId","7rUG","ctime",new Date("2021-07-17 20:28:11"),"cuserid","UpT2","cusername","y2y7","linkStatus","p");
		XmIterationProductLink xmIterationProductLink=BaseUtils.fromMap(p,XmIterationProductLink.class);
		String jsonXmIterationProductLink=om.writeValueAsString(xmIterationProductLink);
		mockMvc.perform( post("/**/core/xmIterationProductLink/edit").content(jsonXmIterationProductLink).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/core/xmIterationProductLink/del").content("BcN5").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("iterationId","BcN5","productId","7rUG","ctime",new Date("2021-07-17 20:28:11"),"cuserid","UpT2","cusername","y2y7","linkStatus","p");
		XmIterationProductLink xmIterationProductLink=BaseUtils.fromMap(p,XmIterationProductLink.class);
		List<XmIterationProductLink>  xmIterationProductLinks=new ArrayList<>();
		xmIterationProductLinks.add(xmIterationProductLink);
		String jsonXmIterationProductLink=om.writeValueAsString(xmIterationProductLinks);
		mockMvc.perform( post("/**/core/xmIterationProductLink/batchDel").content(jsonXmIterationProductLink).contentType(MediaType.APPLICATION_JSON))
		   .andDo(print())
		   .andExpect(status().isOk())  
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	 
}
