package com.xm.core.ctrl;

import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmProduct;
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
 * 表 XM.xm_product 产品表<br>
 * 实体 XmProduct<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,productName,branchId,remark,version,pmUserid,pmUsername,ctime;<br>
 * 当前表的所有字段名:<br>
 *	id,product_name,branch_id,remark,version,pm_userid,pm_username,ctime;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProductController {

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
		Map<String,Object> p=BaseUtils.map("id","bDL6","productName","fXAx","branchId","2kXz","remark","tge3","version","rlh3","pmUserid","Ar1H","pmUsername","2NBT","ctime",new Date("2020-11-24 21:26:13"));
		XmProduct xmProduct=BaseUtils.fromMap(p,XmProduct.class);
		String jsonXmProduct=om.writeValueAsString(xmProduct);
		mockMvc.perform( post("/**/core/xmProduct/add").content(jsonXmProduct).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/core/xmProduct/list")
		.param("id","bDL6").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("id","bDL6","productName","fXAx","branchId","2kXz","remark","tge3","version","rlh3","pmUserid","Ar1H","pmUsername","2NBT","ctime",new Date("2020-11-24 21:26:13"));
		XmProduct xmProduct=BaseUtils.fromMap(p,XmProduct.class);
		String jsonXmProduct=om.writeValueAsString(xmProduct);
		mockMvc.perform( post("/**/core/xmProduct/edit").content(jsonXmProduct).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/core/xmProduct/del").content("bDL6").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("id","bDL6","productName","fXAx","branchId","2kXz","remark","tge3","version","rlh3","pmUserid","Ar1H","pmUsername","2NBT","ctime",new Date("2020-11-24 21:26:13"));
		XmProduct xmProduct=BaseUtils.fromMap(p,XmProduct.class);
		List<XmProduct>  xmProducts=new ArrayList<>();
		xmProducts.add(xmProduct);
		String jsonXmProduct=om.writeValueAsString(xmProducts);
		mockMvc.perform( post("/**/core/xmProduct/batchDel").content(jsonXmProduct).contentType(MediaType.APPLICATION_JSON))
		   .andDo(print())
		   .andExpect(status().isOk())  
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	 
}
