package com.xm.core.ctrl;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmQuestionHandle;
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
 * 表 XM.xm_question_handle xm_question_handle<br>
 * 实体 XmQuestionHandle<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,handlerUserid,handlerUsername,handleSolution,receiptMessage,receiptTime,handleStatus,bizProcInstId,bizFlowState,questionId,lastUpdateTime,createTime,actWorkload,actCostAmount,urls,targetUserid,targetUsername;<br>
 * 当前表的所有字段名:<br>
 *	id,handler_userid,handler_username,handle_solution,receipt_message,receipt_time,handle_status,biz_proc_inst_id,biz_flow_state,question_id,last_update_time,create_time,act_workload,act_cost_amount,urls,target_userid,target_username;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmQuestionHandleController {

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
		Map<String,Object> p=BaseUtils.map("id","X8g8","handlerUserid","f2dJ","handlerUsername","c1U9","handleSolution","Cxxv","receiptMessage","9D10","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","jU8B","bizProcInstId","p8CH","bizFlowState","4","questionId","G3DH","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",8652.78,"actCostAmount",629.49,"urls","ps8t","targetUserid","BJD4","targetUsername","r8Kl");
		XmQuestionHandle xmQuestionHandle=BaseUtils.fromMap(p,XmQuestionHandle.class);
		String jsonXmQuestionHandle=om.writeValueAsString(xmQuestionHandle);
		mockMvc.perform( post("/**/xm/xmQuestionHandle/add").content(jsonXmQuestionHandle).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/xm/xmQuestionHandle/list")
		.param("id","X8g8").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("pageInfo.total").exists());
	}
	
	@Test
	public void listKey() throws Exception  {
		mockMvc.perform( get("/**/xm/xmQuestionHandle/listKey")
		.param("id","X8g8").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("pageInfo.total").exists());
	}

	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("id","X8g8","handlerUserid","f2dJ","handlerUsername","c1U9","handleSolution","Cxxv","receiptMessage","9D10","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","jU8B","bizProcInstId","p8CH","bizFlowState","4","questionId","G3DH","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",8652.78,"actCostAmount",629.49,"urls","ps8t","targetUserid","BJD4","targetUsername","r8Kl");
		XmQuestionHandle xmQuestionHandle=BaseUtils.fromMap(p,XmQuestionHandle.class);
		String jsonXmQuestionHandle=om.writeValueAsString(xmQuestionHandle);
		mockMvc.perform( post("/**/xm/xmQuestionHandle/edit").content(jsonXmQuestionHandle).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/xm/xmQuestionHandle/del").content("X8g8").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("id","X8g8","handlerUserid","f2dJ","handlerUsername","c1U9","handleSolution","Cxxv","receiptMessage","9D10","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","jU8B","bizProcInstId","p8CH","bizFlowState","4","questionId","G3DH","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",8652.78,"actCostAmount",629.49,"urls","ps8t","targetUserid","BJD4","targetUsername","r8Kl");
		XmQuestionHandle xmQuestionHandle=BaseUtils.fromMap(p,XmQuestionHandle.class);
		List<XmQuestionHandle>  xmQuestionHandles=new ArrayList<>();
		xmQuestionHandles.add(xmQuestionHandle);
		String jsonXmQuestionHandle=om.writeValueAsString(xmQuestionHandles);
		mockMvc.perform( post("/**/xm/xmQuestionHandle/batchDel").content(jsonXmQuestionHandle).contentType(MediaType.APPLICATION_JSON))
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
