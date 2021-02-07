package com.xm.core.ctrl;

import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmMenu;
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
 * 表 XM.xm_menu 功能表<br>
 * 实体 XmMenu<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	menuId,menuName,pmenuId,productId,remark,status,online,demandUrl,codeUrl,designUrl,docUrl,helpUrl,operDocUrl,seqNo,mmUserid,mmUsername;<br>
 * 当前表的所有字段名:<br>
 *	menu_id,menu_name,pmenu_id,product_id,remark,status,online,demand_url,code_url,design_url,doc_url,help_url,oper_doc_url,seq_no,mm_userid,mm_username;<br>
 * 当前主键(包括多主键):<br>
 *	menu_id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmMenuController {

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
		Map<String,Object> p=BaseUtils.map("menuId","iZQc","menuName","Hf16","pmenuId","Unx4","productId","Fmb2","remark","JAz3","status","Y","online","W","demandUrl","144e","codeUrl","u3UN","designUrl","FWSi","docUrl","KAXq","helpUrl","qWGk","operDocUrl","MQYM","seqNo","Utj5","mmUserid","vWDr","mmUsername","mUdd");
		XmMenu xmMenu=BaseUtils.fromMap(p,XmMenu.class);
		String jsonXmMenu=om.writeValueAsString(xmMenu);
		mockMvc.perform( post("/**/core/xmMenu/add").content(jsonXmMenu).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/core/xmMenu/list")
		.param("menuId","iZQc").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("menuId","iZQc","menuName","Hf16","pmenuId","Unx4","productId","Fmb2","remark","JAz3","status","Y","online","W","demandUrl","144e","codeUrl","u3UN","designUrl","FWSi","docUrl","KAXq","helpUrl","qWGk","operDocUrl","MQYM","seqNo","Utj5","mmUserid","vWDr","mmUsername","mUdd");
		XmMenu xmMenu=BaseUtils.fromMap(p,XmMenu.class);
		String jsonXmMenu=om.writeValueAsString(xmMenu);
		mockMvc.perform( post("/**/core/xmMenu/edit").content(jsonXmMenu).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/core/xmMenu/del").content("iZQc").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("menuId","iZQc","menuName","Hf16","pmenuId","Unx4","productId","Fmb2","remark","JAz3","status","Y","online","W","demandUrl","144e","codeUrl","u3UN","designUrl","FWSi","docUrl","KAXq","helpUrl","qWGk","operDocUrl","MQYM","seqNo","Utj5","mmUserid","vWDr","mmUsername","mUdd");
		XmMenu xmMenu=BaseUtils.fromMap(p,XmMenu.class);
		List<XmMenu>  xmMenus=new ArrayList<>();
		xmMenus.add(xmMenu);
		String jsonXmMenu=om.writeValueAsString(xmMenus);
		mockMvc.perform( post("/**/core/xmMenu/batchDel").content(jsonXmMenu).contentType(MediaType.APPLICATION_JSON))
		   .andDo(print())
		   .andExpect(status().isOk())  
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	 
}
