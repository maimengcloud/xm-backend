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
import com.xm.share.entity.ShareBizInfo;
import com.mdp.core.utils.BaseUtils;
/**
 * 组织 com<br>
 * 顶级模块 xm<br>
 * 大模块 share<br>
 * 小模块 <br>
 * 表 XM.xm_share_biz_info 分享行为记录表<br>
 * 实体 ShareBizInfo<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	shareKey,shareUserid,shareUsername,pageUrl,pageType,shareTime,bizPkId,bizBranchId,shareBranchId,bizSubPkId,params,shareType,pshareKey,pshareUserid,pshareUsername,bizType,bizCategoryId;<br>
 * 当前表的所有字段名:<br>
 *	share_key,share_userid,share_username,page_url,page_type,share_time,biz_pk_id,biz_branch_id,share_branch_id,biz_sub_pk_id,params,share_type,pshare_key,pshare_userid,pshare_username,biz_type,biz_category_id;<br>
 * 当前主键(包括多主键):<br>
 *	share_key;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestShareBizInfoController {

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
		Map<String,Object> p=BaseUtils.map("shareKey","9303","shareUserid","zZoc","shareUsername","V9tr","pageUrl","wBF3","pageType","ylHj","shareTime",new Date("2021-04-22 17:12:53"),"bizPkId","c6DC","bizBranchId","5HjB","shareBranchId","0aSc","bizSubPkId","5ps3","params","b175","shareType","q0Jh","pshareKey","it9W","pshareUserid","IaYJ","pshareUsername","GGIz","bizType","9Uqr","bizCategoryId","FL8C");
		ShareBizInfo shareBizInfo=BaseUtils.fromMap(p,ShareBizInfo.class);
		String jsonShareBizInfo=om.writeValueAsString(shareBizInfo);
		mockMvc.perform( post("/**/share/shareBizInfo/add").content(jsonShareBizInfo).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/share/shareBizInfo/list")
		.param("shareKey","9303").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("shareKey","9303","shareUserid","zZoc","shareUsername","V9tr","pageUrl","wBF3","pageType","ylHj","shareTime",new Date("2021-04-22 17:12:53"),"bizPkId","c6DC","bizBranchId","5HjB","shareBranchId","0aSc","bizSubPkId","5ps3","params","b175","shareType","q0Jh","pshareKey","it9W","pshareUserid","IaYJ","pshareUsername","GGIz","bizType","9Uqr","bizCategoryId","FL8C");
		ShareBizInfo shareBizInfo=BaseUtils.fromMap(p,ShareBizInfo.class);
		String jsonShareBizInfo=om.writeValueAsString(shareBizInfo);
		mockMvc.perform( post("/**/share/shareBizInfo/edit").content(jsonShareBizInfo).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/share/shareBizInfo/del").content("9303").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("shareKey","9303","shareUserid","zZoc","shareUsername","V9tr","pageUrl","wBF3","pageType","ylHj","shareTime",new Date("2021-04-22 17:12:53"),"bizPkId","c6DC","bizBranchId","5HjB","shareBranchId","0aSc","bizSubPkId","5ps3","params","b175","shareType","q0Jh","pshareKey","it9W","pshareUserid","IaYJ","pshareUsername","GGIz","bizType","9Uqr","bizCategoryId","FL8C");
		ShareBizInfo shareBizInfo=BaseUtils.fromMap(p,ShareBizInfo.class);
		List<ShareBizInfo>  shareBizInfos=new ArrayList<>();
		shareBizInfos.add(shareBizInfo);
		String jsonShareBizInfo=om.writeValueAsString(shareBizInfos);
		mockMvc.perform( post("/**/share/shareBizInfo/batchDel").content(jsonShareBizInfo).contentType(MediaType.APPLICATION_JSON))
		   .andDo(print())
		   .andExpect(status().isOk())  
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	 
}
