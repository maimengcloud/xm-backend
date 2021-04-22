package com.xm.share.ctrl;

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
import com.xm.share.entity.ShareReceInfo;
import com.mdp.core.utils.BaseUtils;
/**
 * 组织 com<br>
 * 顶级模块 xm<br>
 * 大模块 share<br>
 * 小模块 <br>
 * 表 XM.xm_share_rece_info 分享后接收人行为记录表<br>
 * 实体 ShareReceInfo<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,shareKey,receiverId,receiverName,receTime;<br>
 * 当前表的所有字段名:<br>
 *	id,share_key,receiver_id,receiver_name,rece_time;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestShareReceInfoController {

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
		Map<String,Object> p=BaseUtils.map("id","1zr2","shareKey","dp61","receiverId","9s6n","receiverName","83i7","receTime",new Date("2021-04-22 17:12:53"));
		ShareReceInfo shareReceInfo=BaseUtils.fromMap(p,ShareReceInfo.class);
		String jsonShareReceInfo=om.writeValueAsString(shareReceInfo);
		mockMvc.perform( post("/**/share/shareReceInfo/add").content(jsonShareReceInfo).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/share/shareReceInfo/list")
		.param("id","1zr2").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("id","1zr2","shareKey","dp61","receiverId","9s6n","receiverName","83i7","receTime",new Date("2021-04-22 17:12:53"));
		ShareReceInfo shareReceInfo=BaseUtils.fromMap(p,ShareReceInfo.class);
		String jsonShareReceInfo=om.writeValueAsString(shareReceInfo);
		mockMvc.perform( post("/**/share/shareReceInfo/edit").content(jsonShareReceInfo).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/share/shareReceInfo/del").content("1zr2").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("id","1zr2","shareKey","dp61","receiverId","9s6n","receiverName","83i7","receTime",new Date("2021-04-22 17:12:53"));
		ShareReceInfo shareReceInfo=BaseUtils.fromMap(p,ShareReceInfo.class);
		List<ShareReceInfo>  shareReceInfos=new ArrayList<>();
		shareReceInfos.add(shareReceInfo);
		String jsonShareReceInfo=om.writeValueAsString(shareReceInfos);
		mockMvc.perform( post("/**/share/shareReceInfo/batchDel").content(jsonShareReceInfo).contentType(MediaType.APPLICATION_JSON))
		   .andDo(print())
		   .andExpect(status().isOk())  
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	 
}
