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
import com.qqkj.xm.core.entity.XmProjectGroupUser;
import com.qqkj.mdp.core.utils.BaseUtils;
/**
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_project_group_user xm_project_group_user<br>
 * 实体 XmProjectGroupUser<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	joinTime,id,groupId,userid,username,isHead,outTime,status,bizProcInstId,bizFlowState,projectId;<br>
 * 当前表的所有字段名:<br>
 *	join_time,id,group_id,userid,username,is_head,out_time,status,biz_proc_inst_id,biz_flow_state,project_id;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectGroupUserController {

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
		Map<String,Object> p=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","CHFR","groupId","UAmB","userid","ZiPZ","username","IxVu","isHead","G","outTime",parse("2020-11-11 18:53:27"),"status","y","bizProcInstId","5AiW","bizFlowState","R","projectId","H6Ue");
		XmProjectGroupUser xmProjectGroupUser=BaseUtils.fromMap(p,XmProjectGroupUser.class);
		String jsonXmProjectGroupUser=om.writeValueAsString(xmProjectGroupUser);
		mockMvc.perform( post("/**/core/xmProjectGroupUser/add").content(jsonXmProjectGroupUser).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/core/xmProjectGroupUser/list")
		.param("id","CHFR").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","CHFR","groupId","UAmB","userid","ZiPZ","username","IxVu","isHead","G","outTime",parse("2020-11-11 18:53:27"),"status","y","bizProcInstId","5AiW","bizFlowState","R","projectId","H6Ue");
		XmProjectGroupUser xmProjectGroupUser=BaseUtils.fromMap(p,XmProjectGroupUser.class);
		String jsonXmProjectGroupUser=om.writeValueAsString(xmProjectGroupUser);
		mockMvc.perform( post("/**/core/xmProjectGroupUser/edit").content(jsonXmProjectGroupUser).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/core/xmProjectGroupUser/del").content("CHFR").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","CHFR","groupId","UAmB","userid","ZiPZ","username","IxVu","isHead","G","outTime",parse("2020-11-11 18:53:27"),"status","y","bizProcInstId","5AiW","bizFlowState","R","projectId","H6Ue");
		XmProjectGroupUser xmProjectGroupUser=BaseUtils.fromMap(p,XmProjectGroupUser.class);
		List<XmProjectGroupUser>  xmProjectGroupUsers=new ArrayList<>();
		xmProjectGroupUsers.add(xmProjectGroupUser);
		String jsonXmProjectGroupUser=om.writeValueAsString(xmProjectGroupUsers);
		mockMvc.perform( post("/**/core/xmProjectGroupUser/batchDel").content(jsonXmProjectGroupUser).contentType(MediaType.APPLICATION_JSON))
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
