package com.xm.core.ctrl;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmMenuPlan;
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
 * 表 XM.xm_menu_plan 功能计划表,无需前端维护，所有数据由汇总统计得出<br>
 * 实体 XmMenuPlan<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	projectId,id,projectName,menuId,planStartTime,planEndTime,actStartTime,actEndTime,planWorkload,actWorkload,planCostAmount,actCostAmount,finishRate,demandRate,designRate,devRate,uatRate,sitRate,onlineStatus,onlineTime,planStatus,chargeUserid,chargeUsername,menuStatus,ctime,ltime,cuserid,cusername,calcTime,menuName,planWorkhours,planWorkerCnt,closedBugs,activeBugs,confirmedBugs,resolvedBugs,testCases,execCases,designCases,finishCases,iterationCnt,taskCnt,finishTaskCnt,productId,productName,bugCnt;<br>
 * 当前表的所有字段名:<br>
 *	project_id,id,project_name,menu_id,plan_start_time,plan_end_time,act_start_time,act_end_time,plan_workload,act_workload,plan_cost_amount,act_cost_amount,finish_rate,demand_rate,design_rate,dev_rate,uat_rate,sit_rate,online_status,online_time,plan_status,charge_userid,charge_username,menu_status,ctime,ltime,cuserid,cusername,calc_time,menu_name,plan_workhours,plan_worker_cnt,closed_bugs,active_bugs,confirmed_bugs,resolved_bugs,test_cases,exec_cases,design_cases,finish_cases,iteration_cnt,task_cnt,finish_task_cnt,product_id,product_name,bug_cnt;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmMenuPlanController {

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
		Map<String,Object> p=BaseUtils.map("projectId","92L2","id","K4UV","projectName","7C8K","menuId","ZoCy","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",3083.41,"actWorkload",5102.45,"planCostAmount",2900.54,"actCostAmount",2403.45,"finishRate",227.31,"demandRate",2263.22,"designRate",9674.08,"devRate",2436.28,"uatRate",3131.71,"sitRate",3942.87,"onlineStatus","f","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","T","chargeUserid","ITyh","chargeUsername","5THs","menuStatus","z","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","uIf9","cusername","eKFy","calcTime",parse("2020-11-11 18:53:27"),"menuName","qnt3","planWorkhours",8871.29,"planWorkerCnt",5464,"closedBugs",7713,"activeBugs",1030,"confirmedBugs",9548,"resolvedBugs",3104,"testCases",9131,"execCases",4126,"designCases",1588,"finishCases",8318,"iterationCnt",9685,"taskCnt",7721,"finishTaskCnt",9967,"productId","tKNQ","productName","2a5f","bugCnt",977);
		XmMenuPlan xmMenuPlan=BaseUtils.fromMap(p,XmMenuPlan.class);
		String jsonXmMenuPlan=om.writeValueAsString(xmMenuPlan);
		mockMvc.perform( post("/**/core/xmMenuPlan/add").content(jsonXmMenuPlan).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/core/xmMenuPlan/list")
		.param("id","K4UV").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("projectId","92L2","id","K4UV","projectName","7C8K","menuId","ZoCy","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",3083.41,"actWorkload",5102.45,"planCostAmount",2900.54,"actCostAmount",2403.45,"finishRate",227.31,"demandRate",2263.22,"designRate",9674.08,"devRate",2436.28,"uatRate",3131.71,"sitRate",3942.87,"onlineStatus","f","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","T","chargeUserid","ITyh","chargeUsername","5THs","menuStatus","z","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","uIf9","cusername","eKFy","calcTime",parse("2020-11-11 18:53:27"),"menuName","qnt3","planWorkhours",8871.29,"planWorkerCnt",5464,"closedBugs",7713,"activeBugs",1030,"confirmedBugs",9548,"resolvedBugs",3104,"testCases",9131,"execCases",4126,"designCases",1588,"finishCases",8318,"iterationCnt",9685,"taskCnt",7721,"finishTaskCnt",9967,"productId","tKNQ","productName","2a5f","bugCnt",977);
		XmMenuPlan xmMenuPlan=BaseUtils.fromMap(p,XmMenuPlan.class);
		String jsonXmMenuPlan=om.writeValueAsString(xmMenuPlan);
		mockMvc.perform( post("/**/core/xmMenuPlan/edit").content(jsonXmMenuPlan).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/core/xmMenuPlan/del").content("K4UV").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("projectId","92L2","id","K4UV","projectName","7C8K","menuId","ZoCy","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",3083.41,"actWorkload",5102.45,"planCostAmount",2900.54,"actCostAmount",2403.45,"finishRate",227.31,"demandRate",2263.22,"designRate",9674.08,"devRate",2436.28,"uatRate",3131.71,"sitRate",3942.87,"onlineStatus","f","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","T","chargeUserid","ITyh","chargeUsername","5THs","menuStatus","z","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","uIf9","cusername","eKFy","calcTime",parse("2020-11-11 18:53:27"),"menuName","qnt3","planWorkhours",8871.29,"planWorkerCnt",5464,"closedBugs",7713,"activeBugs",1030,"confirmedBugs",9548,"resolvedBugs",3104,"testCases",9131,"execCases",4126,"designCases",1588,"finishCases",8318,"iterationCnt",9685,"taskCnt",7721,"finishTaskCnt",9967,"productId","tKNQ","productName","2a5f","bugCnt",977);
		XmMenuPlan xmMenuPlan=BaseUtils.fromMap(p,XmMenuPlan.class);
		List<XmMenuPlan>  xmMenuPlans=new ArrayList<>();
		xmMenuPlans.add(xmMenuPlan);
		String jsonXmMenuPlan=om.writeValueAsString(xmMenuPlans);
		mockMvc.perform( post("/**/core/xmMenuPlan/batchDel").content(jsonXmMenuPlan).contentType(MediaType.APPLICATION_JSON))
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
