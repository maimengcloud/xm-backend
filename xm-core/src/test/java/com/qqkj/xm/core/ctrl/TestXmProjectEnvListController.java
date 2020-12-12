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
import com.qqkj.xm.core.entity.XmProjectEnvList;
import com.qqkj.mdp.core.utils.BaseUtils;
/**
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_project_env_list xm_project_env_list<br>
 * 实体 XmProjectEnvList<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,remark,ipAddress,port,projectId,projectName,accessUserid,accessPassword,effect,accessUrl,webIpAddress,webPort,otherRemark,createUserid,createUsername,createTime,bizProcInstId,bizFlowState;<br>
 * 当前表的所有字段名:<br>
 *	id,remark,ip_address,port,project_id,project_name,access_userid,access_password,effect,access_url,web_ip_address,web_port,other_remark,create_userid,create_username,create_time,biz_proc_inst_id,biz_flow_state;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectEnvListController {

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
		Map<String,Object> p=BaseUtils.map("id","0GKJ","remark","zT72","ipAddress","U1FK","port","1GZF","projectId","EWTf","projectName","c1OS","accessUserid","PJ71","accessPassword","7dpv","effect","2s0r","accessUrl","56Ws","webIpAddress","XCSX","webPort","i9DZ","otherRemark","DLSY","createUserid","rp8l","createUsername","EeBz","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","MJeo","bizFlowState","9");
		XmProjectEnvList xmProjectEnvList=BaseUtils.fromMap(p,XmProjectEnvList.class);
		String jsonXmProjectEnvList=om.writeValueAsString(xmProjectEnvList);
		mockMvc.perform( post("/**/xm/xmProjectEnvList/add").content(jsonXmProjectEnvList).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/xm/xmProjectEnvList/list")
		.param("id","0GKJ").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("pageInfo.total").exists());
	}
	
	@Test
	public void listKey() throws Exception  {
		mockMvc.perform( get("/**/xm/xmProjectEnvList/listKey")
		.param("id","0GKJ").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("pageInfo.total").exists());
	}

	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("id","0GKJ","remark","zT72","ipAddress","U1FK","port","1GZF","projectId","EWTf","projectName","c1OS","accessUserid","PJ71","accessPassword","7dpv","effect","2s0r","accessUrl","56Ws","webIpAddress","XCSX","webPort","i9DZ","otherRemark","DLSY","createUserid","rp8l","createUsername","EeBz","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","MJeo","bizFlowState","9");
		XmProjectEnvList xmProjectEnvList=BaseUtils.fromMap(p,XmProjectEnvList.class);
		String jsonXmProjectEnvList=om.writeValueAsString(xmProjectEnvList);
		mockMvc.perform( post("/**/xm/xmProjectEnvList/edit").content(jsonXmProjectEnvList).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/xm/xmProjectEnvList/del").content("0GKJ").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("id","0GKJ","remark","zT72","ipAddress","U1FK","port","1GZF","projectId","EWTf","projectName","c1OS","accessUserid","PJ71","accessPassword","7dpv","effect","2s0r","accessUrl","56Ws","webIpAddress","XCSX","webPort","i9DZ","otherRemark","DLSY","createUserid","rp8l","createUsername","EeBz","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","MJeo","bizFlowState","9");
		XmProjectEnvList xmProjectEnvList=BaseUtils.fromMap(p,XmProjectEnvList.class);
		List<XmProjectEnvList>  xmProjectEnvLists=new ArrayList<>();
		xmProjectEnvLists.add(xmProjectEnvList);
		String jsonXmProjectEnvList=om.writeValueAsString(xmProjectEnvLists);
		mockMvc.perform( post("/**/xm/xmProjectEnvList/batchDel").content(jsonXmProjectEnvList).contentType(MediaType.APPLICATION_JSON))
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
