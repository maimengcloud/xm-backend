package com.xm.core.ctrl;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmIteration;
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
 * 表 XM.xm_iteration 迭代定义<br>
 * 实体 XmIteration<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,branchId,iterationName,startTime,endTime,onlineTime,pid,adminUserid,adminUsername,ctime,budgetCost,budgetWorkload,distBudgetCost,distBudgetWorkload,actCost,actWorkload,actStaffNum,seqNo,finishRate,istatus,cuserid,cusername,remark;<br>
 * 当前表的所有字段名:<br>
 *	id,branch_id,iteration_name,start_time,end_time,online_time,pid,admin_userid,admin_username,ctime,budget_cost,budget_workload,dist_budget_cost,dist_budget_workload,act_cost,act_workload,act_staff_num,seq_no,finish_rate,istatus,cuserid,cusername,remark;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmIterationController {

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
		Map<String,Object> p=BaseUtils.map("id","R3rw","branchId","49GI","iterationName","N8lX","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","CB9e","adminUserid","r0R0","adminUsername","CZk9","ctime",parse("2020-11-07 22:55:27"),"budgetCost",7464.74,"budgetWorkload",1895.55,"distBudgetCost",7673.16,"distBudgetWorkload",8525.11,"actCost",2694.35,"actWorkload",5708.21,"actStaffNum",1741,"seqNo","dIEl","finishRate",8162.92,"istatus","W","cuserid","1FNB","cusername","0Jr5","remark","Hxwd");
		XmIteration xmIteration=BaseUtils.fromMap(p,XmIteration.class);
		String jsonXmIteration=om.writeValueAsString(xmIteration);
		mockMvc.perform( post("/**/xm/xmIteration/add").content(jsonXmIteration).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/xm/xmIteration/list")
		.param("id","R3rw").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("id","R3rw","branchId","49GI","iterationName","N8lX","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","CB9e","adminUserid","r0R0","adminUsername","CZk9","ctime",parse("2020-11-07 22:55:27"),"budgetCost",7464.74,"budgetWorkload",1895.55,"distBudgetCost",7673.16,"distBudgetWorkload",8525.11,"actCost",2694.35,"actWorkload",5708.21,"actStaffNum",1741,"seqNo","dIEl","finishRate",8162.92,"istatus","W","cuserid","1FNB","cusername","0Jr5","remark","Hxwd");
		XmIteration xmIteration=BaseUtils.fromMap(p,XmIteration.class);
		String jsonXmIteration=om.writeValueAsString(xmIteration);
		mockMvc.perform( post("/**/xm/xmIteration/edit").content(jsonXmIteration).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/xm/xmIteration/del").content("R3rw").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("id","R3rw","branchId","49GI","iterationName","N8lX","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","CB9e","adminUserid","r0R0","adminUsername","CZk9","ctime",parse("2020-11-07 22:55:27"),"budgetCost",7464.74,"budgetWorkload",1895.55,"distBudgetCost",7673.16,"distBudgetWorkload",8525.11,"actCost",2694.35,"actWorkload",5708.21,"actStaffNum",1741,"seqNo","dIEl","finishRate",8162.92,"istatus","W","cuserid","1FNB","cusername","0Jr5","remark","Hxwd");
		XmIteration xmIteration=BaseUtils.fromMap(p,XmIteration.class);
		List<XmIteration>  xmIterations=new ArrayList<>();
		xmIterations.add(xmIteration);
		String jsonXmIteration=om.writeValueAsString(xmIterations);
		mockMvc.perform( post("/**/xm/xmIteration/batchDel").content(jsonXmIteration).contentType(MediaType.APPLICATION_JSON))
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
