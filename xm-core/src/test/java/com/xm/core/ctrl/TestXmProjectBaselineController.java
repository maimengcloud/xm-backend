package com.xm.core.ctrl;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmProjectBaseline;
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
 * 表 XM.xm_project_baseline xm_project_baseline<br>
 * 实体 XmProjectBaseline<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,code,name,xmType,startTime,endTime,urgent,priority,description,createUserid,createUsername,createTime,assess,assessRemarks,status,branchId,planTotalCost,bizProcInstId,bizFlowState,planNouserAt,planInnerUserAt,planOutUserAt,locked,baseTime,baseRemark,baselineId,planWorkload,totalReceivables,budgetMarginRate,contractAmt,planInnerUserPrice,planOutUserPrice,planOutUserCnt,planInnerUserCnt,planWorkingHours,taxRate,planInnerUserWorkload,planOutUserWorkload,projectId,ctime;<br>
 * 当前表的所有字段名:<br>
 *	id,code,name,xm_type,start_time,end_time,urgent,priority,description,create_userid,create_username,create_time,assess,assess_remarks,status,branch_id,plan_total_cost,biz_proc_inst_id,biz_flow_state,plan_nouser_at,plan_inner_user_at,plan_out_user_at,locked,base_time,base_remark,baseline_id,plan_workload,total_receivables,budget_margin_rate,contract_amt,plan_inner_user_price,plan_out_user_price,plan_out_user_cnt,plan_inner_user_cnt,plan_working_hours,tax_rate,plan_inner_user_workload,plan_out_user_workload,project_id,ctime;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectBaselineController {

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
		Map<String,Object> p=BaseUtils.map("id","kHCU","code","8Foq","name","2K8N","xmType","814x","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","YhSu","priority","v1l0","description","WHYq","createUserid","DRRD","createUsername","rBL3","createTime",parse("2020-10-19 23:44:56"),"assess","K4x2","assessRemarks","yx1Z","status","ezeD","branchId","XyHf","planTotalCost",2963.44,"bizProcInstId","uk6h","bizFlowState","6","planNouserAt",1015.07,"planInnerUserAt",5329.31,"planOutUserAt",116.42,"locked","k","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","WsjM","baselineId","8E29","planWorkload",7137.78,"totalReceivables",1274.3,"budgetMarginRate",3150.2501,"contractAmt",9040.85,"planInnerUserPrice",7957.85,"planOutUserPrice",8023.57,"planOutUserCnt",6727,"planInnerUserCnt",479,"planWorkingHours",3703,"taxRate",9747.29,"planInnerUserWorkload",7170.65,"planOutUserWorkload",1348.6,"projectId","sURl","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline=BaseUtils.fromMap(p,XmProjectBaseline.class);
		String jsonXmProjectBaseline=om.writeValueAsString(xmProjectBaseline);
		mockMvc.perform( post("/**/xm/xmProjectBaseline/add").content(jsonXmProjectBaseline).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/xm/xmProjectBaseline/list")
		.param("id","kHCU").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("pageInfo.total").exists());
	}
	
	@Test
	public void listKey() throws Exception  {
		mockMvc.perform( get("/**/xm/xmProjectBaseline/listKey")
		.param("id","kHCU").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("pageInfo.total").exists());
	}

	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("id","kHCU","code","8Foq","name","2K8N","xmType","814x","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","YhSu","priority","v1l0","description","WHYq","createUserid","DRRD","createUsername","rBL3","createTime",parse("2020-10-19 23:44:56"),"assess","K4x2","assessRemarks","yx1Z","status","ezeD","branchId","XyHf","planTotalCost",2963.44,"bizProcInstId","uk6h","bizFlowState","6","planNouserAt",1015.07,"planInnerUserAt",5329.31,"planOutUserAt",116.42,"locked","k","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","WsjM","baselineId","8E29","planWorkload",7137.78,"totalReceivables",1274.3,"budgetMarginRate",3150.2501,"contractAmt",9040.85,"planInnerUserPrice",7957.85,"planOutUserPrice",8023.57,"planOutUserCnt",6727,"planInnerUserCnt",479,"planWorkingHours",3703,"taxRate",9747.29,"planInnerUserWorkload",7170.65,"planOutUserWorkload",1348.6,"projectId","sURl","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline=BaseUtils.fromMap(p,XmProjectBaseline.class);
		String jsonXmProjectBaseline=om.writeValueAsString(xmProjectBaseline);
		mockMvc.perform( post("/**/xm/xmProjectBaseline/edit").content(jsonXmProjectBaseline).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/xm/xmProjectBaseline/del").content("kHCU").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("id","kHCU","code","8Foq","name","2K8N","xmType","814x","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","YhSu","priority","v1l0","description","WHYq","createUserid","DRRD","createUsername","rBL3","createTime",parse("2020-10-19 23:44:56"),"assess","K4x2","assessRemarks","yx1Z","status","ezeD","branchId","XyHf","planTotalCost",2963.44,"bizProcInstId","uk6h","bizFlowState","6","planNouserAt",1015.07,"planInnerUserAt",5329.31,"planOutUserAt",116.42,"locked","k","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","WsjM","baselineId","8E29","planWorkload",7137.78,"totalReceivables",1274.3,"budgetMarginRate",3150.2501,"contractAmt",9040.85,"planInnerUserPrice",7957.85,"planOutUserPrice",8023.57,"planOutUserCnt",6727,"planInnerUserCnt",479,"planWorkingHours",3703,"taxRate",9747.29,"planInnerUserWorkload",7170.65,"planOutUserWorkload",1348.6,"projectId","sURl","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline=BaseUtils.fromMap(p,XmProjectBaseline.class);
		List<XmProjectBaseline>  xmProjectBaselines=new ArrayList<>();
		xmProjectBaselines.add(xmProjectBaseline);
		String jsonXmProjectBaseline=om.writeValueAsString(xmProjectBaselines);
		mockMvc.perform( post("/**/xm/xmProjectBaseline/batchDel").content(jsonXmProjectBaseline).contentType(MediaType.APPLICATION_JSON))
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
