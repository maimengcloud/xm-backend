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
import com.qqkj.xm.core.entity.XmProductState;
import com.qqkj.mdp.core.utils.BaseUtils;
/**
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_product_state 功能状态表,无需前端维护，所有数据由汇总统计得出<br>
 * 实体 XmProductState<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,planStartTime,planEndTime,actStartTime,actEndTime,planWorkload,actWorkload,planCostAmount,actCostAmount,finishRate,demandRate,designRate,devRate,uatRate,sitRate,ctime,ltime,cuserid,cusername,calcTime,planWorkhours,planWorkerCnt,closedBugs,activeBugs,confirmedBugs,resolvedBugs,productId,productName,testCases,execCases,designCases,finishCases,projectCnt,iterationCnt,taskCnt,finishTaskCnt,bizDate,branchId,bugCnt;<br>
 * 当前表的所有字段名:<br>
 *	id,plan_start_time,plan_end_time,act_start_time,act_end_time,plan_workload,act_workload,plan_cost_amount,act_cost_amount,finish_rate,demand_rate,design_rate,dev_rate,uat_rate,sit_rate,ctime,ltime,cuserid,cusername,calc_time,plan_workhours,plan_worker_cnt,closed_bugs,active_bugs,confirmed_bugs,resolved_bugs,product_id,product_name,test_cases,exec_cases,design_cases,finish_cases,project_cnt,iteration_cnt,task_cnt,finish_task_cnt,biz_date,branch_id,bug_cnt;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProductStateController {

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
		Map<String,Object> p=BaseUtils.map("id","16A9","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",6759.81,"actWorkload",7481.08,"planCostAmount",7711.91,"actCostAmount",6571.38,"finishRate",958.62,"demandRate",5923.61,"designRate",1050.6,"devRate",7740.03,"uatRate",2278.37,"sitRate",2987.53,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","aUHt","cusername","6H1M","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",3065.83,"planWorkerCnt",3604,"closedBugs",7249,"activeBugs",5944,"confirmedBugs",2349,"resolvedBugs",4427,"productId","tQLs","productName","wFpv","testCases",2957,"execCases",417,"designCases",1798,"finishCases",1228,"projectCnt",2462,"iterationCnt",8541,"taskCnt",1352,"finishTaskCnt",6859,"bizDate","jWmR","branchId","NfPV","bugCnt",3688);
		XmProductState xmProductState=BaseUtils.fromMap(p,XmProductState.class);
		String jsonXmProductState=om.writeValueAsString(xmProductState);
		mockMvc.perform( post("/**/core/xmProductState/add").content(jsonXmProductState).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/core/xmProductState/list")
		.param("id","16A9").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("id","16A9","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",6759.81,"actWorkload",7481.08,"planCostAmount",7711.91,"actCostAmount",6571.38,"finishRate",958.62,"demandRate",5923.61,"designRate",1050.6,"devRate",7740.03,"uatRate",2278.37,"sitRate",2987.53,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","aUHt","cusername","6H1M","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",3065.83,"planWorkerCnt",3604,"closedBugs",7249,"activeBugs",5944,"confirmedBugs",2349,"resolvedBugs",4427,"productId","tQLs","productName","wFpv","testCases",2957,"execCases",417,"designCases",1798,"finishCases",1228,"projectCnt",2462,"iterationCnt",8541,"taskCnt",1352,"finishTaskCnt",6859,"bizDate","jWmR","branchId","NfPV","bugCnt",3688);
		XmProductState xmProductState=BaseUtils.fromMap(p,XmProductState.class);
		String jsonXmProductState=om.writeValueAsString(xmProductState);
		mockMvc.perform( post("/**/core/xmProductState/edit").content(jsonXmProductState).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/core/xmProductState/del").content("16A9").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("id","16A9","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",6759.81,"actWorkload",7481.08,"planCostAmount",7711.91,"actCostAmount",6571.38,"finishRate",958.62,"demandRate",5923.61,"designRate",1050.6,"devRate",7740.03,"uatRate",2278.37,"sitRate",2987.53,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","aUHt","cusername","6H1M","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",3065.83,"planWorkerCnt",3604,"closedBugs",7249,"activeBugs",5944,"confirmedBugs",2349,"resolvedBugs",4427,"productId","tQLs","productName","wFpv","testCases",2957,"execCases",417,"designCases",1798,"finishCases",1228,"projectCnt",2462,"iterationCnt",8541,"taskCnt",1352,"finishTaskCnt",6859,"bizDate","jWmR","branchId","NfPV","bugCnt",3688);
		XmProductState xmProductState=BaseUtils.fromMap(p,XmProductState.class);
		List<XmProductState>  xmProductStates=new ArrayList<>();
		xmProductStates.add(xmProductState);
		String jsonXmProductState=om.writeValueAsString(xmProductStates);
		mockMvc.perform( post("/**/core/xmProductState/batchDel").content(jsonXmProductState).contentType(MediaType.APPLICATION_JSON))
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
