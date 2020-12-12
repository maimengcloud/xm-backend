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
import com.qqkj.xm.core.entity.XmProject;
import com.qqkj.mdp.core.utils.BaseUtils;
/**
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_project xm_project<br>
 * 实体 XmProject<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,code,name,xmType,startTime,endTime,urgent,priority,description,createUserid,createUsername,createTime,assess,assessRemarks,status,branchId,planTotalCost,bizProcInstId,bizFlowState,planNouserAt,planInnerUserAt,planOutUserAt,locked,baseTime,baseRemark,baselineId,planWorkload,totalReceivables,budgetMarginRate,contractAmt,planInnerUserPrice,planOutUserPrice,planOutUserCnt,planInnerUserCnt,planWorkingHours,taxRate,planInnerUserWorkload,planOutUserWorkload,fromTplId,budgetCtrl;<br>
 * 当前表的所有字段名:<br>
 *	id,code,name,xm_type,start_time,end_time,urgent,priority,description,create_userid,create_username,create_time,assess,assess_remarks,status,branch_id,plan_total_cost,biz_proc_inst_id,biz_flow_state,plan_nouser_at,plan_inner_user_at,plan_out_user_at,locked,base_time,base_remark,baseline_id,plan_workload,total_receivables,budget_margin_rate,contract_amt,plan_inner_user_price,plan_out_user_price,plan_out_user_cnt,plan_inner_user_cnt,plan_working_hours,tax_rate,plan_inner_user_workload,plan_out_user_workload,from_tpl_id,budget_ctrl;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectController {

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
		Map<String,Object> p=BaseUtils.map("id","2HW9","code","a893","name","SV0h","xmType","GAee","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","V7wc","priority","w8zx","description","GJO1","createUserid","M171","createUsername","Zzq2","createTime",parse("2020-11-07 22:55:26"),"assess","y7bZ","assessRemarks","T7nC","status","cniI","branchId","z7mF","planTotalCost",3054.34,"bizProcInstId","12fk","bizFlowState","m","planNouserAt",2007,"planInnerUserAt",5068.15,"planOutUserAt",3456.37,"locked","P","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","0LRN","baselineId","7ko4","planWorkload",5663.95,"totalReceivables",3440.08,"budgetMarginRate",7898.8322,"contractAmt",7716.36,"planInnerUserPrice",2520.13,"planOutUserPrice",3947.2,"planOutUserCnt",2129,"planInnerUserCnt",1476,"planWorkingHours",7676,"taxRate",5235.52,"planInnerUserWorkload",4485.83,"planOutUserWorkload",9041.45,"fromTplId","bz0b","budgetCtrl","X");
		XmProject xmProject=BaseUtils.fromMap(p,XmProject.class);
		String jsonXmProject=om.writeValueAsString(xmProject);
		mockMvc.perform( post("/**/xm/xmProject/add").content(jsonXmProject).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/xm/xmProject/list")
		.param("id","2HW9").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("id","2HW9","code","a893","name","SV0h","xmType","GAee","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","V7wc","priority","w8zx","description","GJO1","createUserid","M171","createUsername","Zzq2","createTime",parse("2020-11-07 22:55:26"),"assess","y7bZ","assessRemarks","T7nC","status","cniI","branchId","z7mF","planTotalCost",3054.34,"bizProcInstId","12fk","bizFlowState","m","planNouserAt",2007,"planInnerUserAt",5068.15,"planOutUserAt",3456.37,"locked","P","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","0LRN","baselineId","7ko4","planWorkload",5663.95,"totalReceivables",3440.08,"budgetMarginRate",7898.8322,"contractAmt",7716.36,"planInnerUserPrice",2520.13,"planOutUserPrice",3947.2,"planOutUserCnt",2129,"planInnerUserCnt",1476,"planWorkingHours",7676,"taxRate",5235.52,"planInnerUserWorkload",4485.83,"planOutUserWorkload",9041.45,"fromTplId","bz0b","budgetCtrl","X");
		XmProject xmProject=BaseUtils.fromMap(p,XmProject.class);
		String jsonXmProject=om.writeValueAsString(xmProject);
		mockMvc.perform( post("/**/xm/xmProject/edit").content(jsonXmProject).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/xm/xmProject/del").content("2HW9").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("id","2HW9","code","a893","name","SV0h","xmType","GAee","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","V7wc","priority","w8zx","description","GJO1","createUserid","M171","createUsername","Zzq2","createTime",parse("2020-11-07 22:55:26"),"assess","y7bZ","assessRemarks","T7nC","status","cniI","branchId","z7mF","planTotalCost",3054.34,"bizProcInstId","12fk","bizFlowState","m","planNouserAt",2007,"planInnerUserAt",5068.15,"planOutUserAt",3456.37,"locked","P","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","0LRN","baselineId","7ko4","planWorkload",5663.95,"totalReceivables",3440.08,"budgetMarginRate",7898.8322,"contractAmt",7716.36,"planInnerUserPrice",2520.13,"planOutUserPrice",3947.2,"planOutUserCnt",2129,"planInnerUserCnt",1476,"planWorkingHours",7676,"taxRate",5235.52,"planInnerUserWorkload",4485.83,"planOutUserWorkload",9041.45,"fromTplId","bz0b","budgetCtrl","X");
		XmProject xmProject=BaseUtils.fromMap(p,XmProject.class);
		List<XmProject>  xmProjects=new ArrayList<>();
		xmProjects.add(xmProject);
		String jsonXmProject=om.writeValueAsString(xmProjects);
		mockMvc.perform( post("/**/xm/xmProject/batchDel").content(jsonXmProject).contentType(MediaType.APPLICATION_JSON))
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
