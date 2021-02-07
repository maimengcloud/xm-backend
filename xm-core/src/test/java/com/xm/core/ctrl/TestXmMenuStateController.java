package com.xm.core.ctrl;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmMenuState;
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
 * 表 XM.xm_menu_state 功能状态表,无需前端维护，所有数据由汇总统计得出<br>
 * 实体 XmMenuState<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,menuId,planStartTime,planEndTime,actStartTime,actEndTime,planWorkload,actWorkload,planCostAmount,actCostAmount,finishRate,demandRate,designRate,devRate,uatRate,sitRate,onlineStatus,onlineTime,planStatus,chargeUserid,chargeUsername,menuStatus,ctime,ltime,cuserid,cusername,calcTime,menuName,planWorkhours,planWorkerCnt,closedBugs,activeBugs,confirmedBugs,resolvedBugs,productId,productName,testCases,execCases,designCases,finishCases,projectCnt,iterationCnt,taskCnt,finishTaskCnt,bizDate,bugCnt;<br>
 * 当前表的所有字段名:<br>
 *	id,menu_id,plan_start_time,plan_end_time,act_start_time,act_end_time,plan_workload,act_workload,plan_cost_amount,act_cost_amount,finish_rate,demand_rate,design_rate,dev_rate,uat_rate,sit_rate,online_status,online_time,plan_status,charge_userid,charge_username,menu_status,ctime,ltime,cuserid,cusername,calc_time,menu_name,plan_workhours,plan_worker_cnt,closed_bugs,active_bugs,confirmed_bugs,resolved_bugs,product_id,product_name,test_cases,exec_cases,design_cases,finish_cases,project_cnt,iteration_cnt,task_cnt,finish_task_cnt,biz_date,bug_cnt;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmMenuStateController {

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
		Map<String,Object> p=BaseUtils.map("id","IlfF","menuId","eg9z","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",5365.06,"actWorkload",8408.04,"planCostAmount",4918.87,"actCostAmount",6936.21,"finishRate",5995.51,"demandRate",8902.8,"designRate",856.81,"devRate",5333.85,"uatRate",9071.12,"sitRate",2411.15,"onlineStatus","F","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","t","chargeUserid","9ej6","chargeUsername","cm38","menuStatus","b","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","OVG5","cusername","3ui8","calcTime",parse("2020-11-11 18:53:25"),"menuName","pt5r","planWorkhours",6637.37,"planWorkerCnt",2089,"closedBugs",7900,"activeBugs",3204,"confirmedBugs",668,"resolvedBugs",6956,"productId","AQqj","productName","g8C9","testCases",3815,"execCases",8026,"designCases",4758,"finishCases",4081,"projectCnt",3067,"iterationCnt",4235,"taskCnt",3309,"finishTaskCnt",7563,"bizDate","ecC1","bugCnt",3457);
		XmMenuState xmMenuState=BaseUtils.fromMap(p,XmMenuState.class);
		String jsonXmMenuState=om.writeValueAsString(xmMenuState);
		mockMvc.perform( post("/**/core/xmMenuState/add").content(jsonXmMenuState).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/core/xmMenuState/list")
		.param("id","IlfF").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("id","IlfF","menuId","eg9z","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",5365.06,"actWorkload",8408.04,"planCostAmount",4918.87,"actCostAmount",6936.21,"finishRate",5995.51,"demandRate",8902.8,"designRate",856.81,"devRate",5333.85,"uatRate",9071.12,"sitRate",2411.15,"onlineStatus","F","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","t","chargeUserid","9ej6","chargeUsername","cm38","menuStatus","b","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","OVG5","cusername","3ui8","calcTime",parse("2020-11-11 18:53:25"),"menuName","pt5r","planWorkhours",6637.37,"planWorkerCnt",2089,"closedBugs",7900,"activeBugs",3204,"confirmedBugs",668,"resolvedBugs",6956,"productId","AQqj","productName","g8C9","testCases",3815,"execCases",8026,"designCases",4758,"finishCases",4081,"projectCnt",3067,"iterationCnt",4235,"taskCnt",3309,"finishTaskCnt",7563,"bizDate","ecC1","bugCnt",3457);
		XmMenuState xmMenuState=BaseUtils.fromMap(p,XmMenuState.class);
		String jsonXmMenuState=om.writeValueAsString(xmMenuState);
		mockMvc.perform( post("/**/core/xmMenuState/edit").content(jsonXmMenuState).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/core/xmMenuState/del").content("IlfF").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("id","IlfF","menuId","eg9z","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",5365.06,"actWorkload",8408.04,"planCostAmount",4918.87,"actCostAmount",6936.21,"finishRate",5995.51,"demandRate",8902.8,"designRate",856.81,"devRate",5333.85,"uatRate",9071.12,"sitRate",2411.15,"onlineStatus","F","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","t","chargeUserid","9ej6","chargeUsername","cm38","menuStatus","b","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","OVG5","cusername","3ui8","calcTime",parse("2020-11-11 18:53:25"),"menuName","pt5r","planWorkhours",6637.37,"planWorkerCnt",2089,"closedBugs",7900,"activeBugs",3204,"confirmedBugs",668,"resolvedBugs",6956,"productId","AQqj","productName","g8C9","testCases",3815,"execCases",8026,"designCases",4758,"finishCases",4081,"projectCnt",3067,"iterationCnt",4235,"taskCnt",3309,"finishTaskCnt",7563,"bizDate","ecC1","bugCnt",3457);
		XmMenuState xmMenuState=BaseUtils.fromMap(p,XmMenuState.class);
		List<XmMenuState>  xmMenuStates=new ArrayList<>();
		xmMenuStates.add(xmMenuState);
		String jsonXmMenuState=om.writeValueAsString(xmMenuStates);
		mockMvc.perform( post("/**/core/xmMenuState/batchDel").content(jsonXmMenuState).contentType(MediaType.APPLICATION_JSON))
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
