package com.xm.core.ctrl;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmTaskExecuser;
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
 * 表 XM.xm_task_execuser xm_task_execuser<br>
 * 实体 XmTaskExecuser<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	createTime,id,taskId,userid,startTime,endTime,status,remarks,settleAmount,settleWorkload,settleStatus,settleTime,createUserid,createUsername,username,matchScore,quoteWeekday,quoteAmount,quoteTime,bizProcInstId,bizFlowState,projectId,projectPhaseId,skillRemark,quoteWorkload,quoteStartTime,quoteEndTime,branchId,projectPhaseName,taskName,isLeader;<br>
 * 当前表的所有字段名:<br>
 *	create_time,id,task_id,userid,start_time,end_time,status,remarks,settle_amount,settle_workload,settle_status,settle_time,create_userid,create_username,username,match_score,quote_weekday,quote_amount,quote_time,biz_proc_inst_id,biz_flow_state,project_id,project_phase_id,skill_remark,quote_workload,quote_start_time,quote_end_time,branch_id,project_phase_name,task_name,is_leader;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmTaskExecuserController {

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
		Map<String,Object> p=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","ng3t","taskId","itQ9","userid","Cn46","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","0YtP","remarks","bcE4","settleAmount",157.39,"settleWorkload",5112.74,"settleStatus","A1S1","settleTime",parse("2020-11-16 16:51:34"),"createUserid","CSZ1","createUsername","xlM7","username","vwUD","matchScore",8067.21,"quoteWeekday",8706,"quoteAmount",1332.62,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","2r9y","bizFlowState","m","projectId","fJsF","projectPhaseId","4e53","skillRemark","Op1J","quoteWorkload",3013.62,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","K9s0","projectPhaseName","8tQV","taskName","0z9g","isLeader","S");
		XmTaskExecuser xmTaskExecuser=BaseUtils.fromMap(p,XmTaskExecuser.class);
		String jsonXmTaskExecuser=om.writeValueAsString(xmTaskExecuser);
		mockMvc.perform( post("/**/core/xmTaskExecuser/add").content(jsonXmTaskExecuser).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/core/xmTaskExecuser/list")
		.param("id","ng3t").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","ng3t","taskId","itQ9","userid","Cn46","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","0YtP","remarks","bcE4","settleAmount",157.39,"settleWorkload",5112.74,"settleStatus","A1S1","settleTime",parse("2020-11-16 16:51:34"),"createUserid","CSZ1","createUsername","xlM7","username","vwUD","matchScore",8067.21,"quoteWeekday",8706,"quoteAmount",1332.62,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","2r9y","bizFlowState","m","projectId","fJsF","projectPhaseId","4e53","skillRemark","Op1J","quoteWorkload",3013.62,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","K9s0","projectPhaseName","8tQV","taskName","0z9g","isLeader","S");
		XmTaskExecuser xmTaskExecuser=BaseUtils.fromMap(p,XmTaskExecuser.class);
		String jsonXmTaskExecuser=om.writeValueAsString(xmTaskExecuser);
		mockMvc.perform( post("/**/core/xmTaskExecuser/edit").content(jsonXmTaskExecuser).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/core/xmTaskExecuser/del").content("ng3t").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","ng3t","taskId","itQ9","userid","Cn46","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","0YtP","remarks","bcE4","settleAmount",157.39,"settleWorkload",5112.74,"settleStatus","A1S1","settleTime",parse("2020-11-16 16:51:34"),"createUserid","CSZ1","createUsername","xlM7","username","vwUD","matchScore",8067.21,"quoteWeekday",8706,"quoteAmount",1332.62,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","2r9y","bizFlowState","m","projectId","fJsF","projectPhaseId","4e53","skillRemark","Op1J","quoteWorkload",3013.62,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","K9s0","projectPhaseName","8tQV","taskName","0z9g","isLeader","S");
		XmTaskExecuser xmTaskExecuser=BaseUtils.fromMap(p,XmTaskExecuser.class);
		List<XmTaskExecuser>  xmTaskExecusers=new ArrayList<>();
		xmTaskExecusers.add(xmTaskExecuser);
		String jsonXmTaskExecuser=om.writeValueAsString(xmTaskExecusers);
		mockMvc.perform( post("/**/core/xmTaskExecuser/batchDel").content(jsonXmTaskExecuser).contentType(MediaType.APPLICATION_JSON))
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
