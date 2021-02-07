package com.xm.core.ctrl;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmProjectGroupState;
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
 * 表 XM.xm_project_group_state 功能状态表,无需前端维护，所有数据由汇总统计得出<br>
 * 实体 XmProjectGroupState<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,planStartTime,planEndTime,actStartTime,actEndTime,planWorkload,actWorkload,planCostAmount,actCostAmount,finishRate,demandRate,designRate,devRate,uatRate,sitRate,ctime,calcTime,planWorkhours,planWorkerCnt,closedBugs,activeBugs,confirmedBugs,resolvedBugs,testCases,execCases,designCases,finishCases,iterationCnt,taskCnt,finishTaskCnt,bizDate,bugCnt,groupId,projectId,projectName,groupName;<br>
 * 当前表的所有字段名:<br>
 *	id,plan_start_time,plan_end_time,act_start_time,act_end_time,plan_workload,act_workload,plan_cost_amount,act_cost_amount,finish_rate,demand_rate,design_rate,dev_rate,uat_rate,sit_rate,ctime,calc_time,plan_workhours,plan_worker_cnt,closed_bugs,active_bugs,confirmed_bugs,resolved_bugs,test_cases,exec_cases,design_cases,finish_cases,iteration_cnt,task_cnt,finish_task_cnt,biz_date,bug_cnt,group_id,project_id,project_name,group_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectGroupStateController {

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
		Map<String,Object> p=BaseUtils.map("id","DOvX","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5488.29,"actWorkload",825.29,"planCostAmount",8827.71,"actCostAmount",3822.04,"finishRate",1922.27,"demandRate",406.64,"designRate",7908.15,"devRate",7840.41,"uatRate",2388.7,"sitRate",1579.68,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",5541.15,"planWorkerCnt",4294.3,"closedBugs",7483,"activeBugs",7367,"confirmedBugs",2008,"resolvedBugs",9839,"testCases",9608,"execCases",8125,"designCases",833,"finishCases",7535,"iterationCnt",39,"taskCnt",9196,"finishTaskCnt",8478,"bizDate","L2PF","bugCnt",6252,"groupId","83u4","projectId","yYyx","projectName","j2vJ","groupName","rYC6");
		XmProjectGroupState xmProjectGroupState=BaseUtils.fromMap(p,XmProjectGroupState.class);
		String jsonXmProjectGroupState=om.writeValueAsString(xmProjectGroupState);
		mockMvc.perform( post("/**/core/xmProjectGroupState/add").content(jsonXmProjectGroupState).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/core/xmProjectGroupState/list")
		.param("id","DOvX").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("id","DOvX","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5488.29,"actWorkload",825.29,"planCostAmount",8827.71,"actCostAmount",3822.04,"finishRate",1922.27,"demandRate",406.64,"designRate",7908.15,"devRate",7840.41,"uatRate",2388.7,"sitRate",1579.68,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",5541.15,"planWorkerCnt",4294.3,"closedBugs",7483,"activeBugs",7367,"confirmedBugs",2008,"resolvedBugs",9839,"testCases",9608,"execCases",8125,"designCases",833,"finishCases",7535,"iterationCnt",39,"taskCnt",9196,"finishTaskCnt",8478,"bizDate","L2PF","bugCnt",6252,"groupId","83u4","projectId","yYyx","projectName","j2vJ","groupName","rYC6");
		XmProjectGroupState xmProjectGroupState=BaseUtils.fromMap(p,XmProjectGroupState.class);
		String jsonXmProjectGroupState=om.writeValueAsString(xmProjectGroupState);
		mockMvc.perform( post("/**/core/xmProjectGroupState/edit").content(jsonXmProjectGroupState).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/core/xmProjectGroupState/del").content("DOvX").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("id","DOvX","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5488.29,"actWorkload",825.29,"planCostAmount",8827.71,"actCostAmount",3822.04,"finishRate",1922.27,"demandRate",406.64,"designRate",7908.15,"devRate",7840.41,"uatRate",2388.7,"sitRate",1579.68,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",5541.15,"planWorkerCnt",4294.3,"closedBugs",7483,"activeBugs",7367,"confirmedBugs",2008,"resolvedBugs",9839,"testCases",9608,"execCases",8125,"designCases",833,"finishCases",7535,"iterationCnt",39,"taskCnt",9196,"finishTaskCnt",8478,"bizDate","L2PF","bugCnt",6252,"groupId","83u4","projectId","yYyx","projectName","j2vJ","groupName","rYC6");
		XmProjectGroupState xmProjectGroupState=BaseUtils.fromMap(p,XmProjectGroupState.class);
		List<XmProjectGroupState>  xmProjectGroupStates=new ArrayList<>();
		xmProjectGroupStates.add(xmProjectGroupState);
		String jsonXmProjectGroupState=om.writeValueAsString(xmProjectGroupStates);
		mockMvc.perform( post("/**/core/xmProjectGroupState/batchDel").content(jsonXmProjectGroupState).contentType(MediaType.APPLICATION_JSON))
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
