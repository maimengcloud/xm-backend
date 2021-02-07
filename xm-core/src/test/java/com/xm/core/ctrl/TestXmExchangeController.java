package com.xm.core.ctrl;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmExchange;
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
 * 表 XM.xm_exchange 功能表<br>
 * 实体 XmExchange<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	taskId,taskName,projectId,remark,id,pid,cuserid,cusername,ctime,cbranchId,adopt,adoptUserid,adoptUsername,adoptTime,closed,puserid,pusername,premark,notifyUserids,notifyChannels,notifyUsernames,cuserHeadImg,replyType;<br>
 * 当前表的所有字段名:<br>
 *	task_id,task_name,project_id,remark,id,pid,cuserid,cusername,ctime,cbranch_id,adopt,adopt_userid,adopt_username,adopt_time,closed,puserid,pusername,premark,notify_userids,notify_channels,notify_usernames,cuser_head_img,reply_type;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmExchangeController {

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
		Map<String,Object> p=BaseUtils.map("taskId","2bgZ","taskName","0iKN","projectId","fQuY","remark","6479","id","93aP","pid","2duW","cuserid","XtBe","cusername","5joK","ctime",parse("2020-11-04 3:27:11"),"cbranchId","l9yY","adopt","h","adoptUserid","EEtj","adoptUsername","DLi9","adoptTime",parse("2020-11-04 3:27:11"),"closed","7","puserid","l74e","pusername","9bo3","premark","3FSH","notifyUserids","6Jgx","notifyChannels","18GL","notifyUsernames","OFrR","cuserHeadImg","vZyQ","replyType","O");
		XmExchange xmExchange=BaseUtils.fromMap(p,XmExchange.class);
		String jsonXmExchange=om.writeValueAsString(xmExchange);
		mockMvc.perform( post("/**/xm/xmExchange/add").content(jsonXmExchange).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/xm/xmExchange/list")
		.param("id","93aP").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("taskId","2bgZ","taskName","0iKN","projectId","fQuY","remark","6479","id","93aP","pid","2duW","cuserid","XtBe","cusername","5joK","ctime",parse("2020-11-04 3:27:11"),"cbranchId","l9yY","adopt","h","adoptUserid","EEtj","adoptUsername","DLi9","adoptTime",parse("2020-11-04 3:27:11"),"closed","7","puserid","l74e","pusername","9bo3","premark","3FSH","notifyUserids","6Jgx","notifyChannels","18GL","notifyUsernames","OFrR","cuserHeadImg","vZyQ","replyType","O");
		XmExchange xmExchange=BaseUtils.fromMap(p,XmExchange.class);
		String jsonXmExchange=om.writeValueAsString(xmExchange);
		mockMvc.perform( post("/**/xm/xmExchange/edit").content(jsonXmExchange).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/xm/xmExchange/del").content("93aP").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("taskId","2bgZ","taskName","0iKN","projectId","fQuY","remark","6479","id","93aP","pid","2duW","cuserid","XtBe","cusername","5joK","ctime",parse("2020-11-04 3:27:11"),"cbranchId","l9yY","adopt","h","adoptUserid","EEtj","adoptUsername","DLi9","adoptTime",parse("2020-11-04 3:27:11"),"closed","7","puserid","l74e","pusername","9bo3","premark","3FSH","notifyUserids","6Jgx","notifyChannels","18GL","notifyUsernames","OFrR","cuserHeadImg","vZyQ","replyType","O");
		XmExchange xmExchange=BaseUtils.fromMap(p,XmExchange.class);
		List<XmExchange>  xmExchanges=new ArrayList<>();
		xmExchanges.add(xmExchange);
		String jsonXmExchange=om.writeValueAsString(xmExchanges);
		mockMvc.perform( post("/**/xm/xmExchange/batchDel").content(jsonXmExchange).contentType(MediaType.APPLICATION_JSON))
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
