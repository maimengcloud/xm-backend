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
import com.qqkj.xm.core.entity.XmProjectTemplate;
import com.qqkj.mdp.core.utils.BaseUtils;
/**
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_project_template xm_project_template<br>
 * 实体 XmProjectTemplate<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,code,name,xmType,startTime,endTime,urgent,priority,description,createUserid,createUsername,createTime,assess,assessRemarks,status,branchId,planTotalCost,bizProcInstId,bizFlowState,planNouserAt,planInnerUserAt,planOutUserAt,locked,baseTime,baseRemark,baselineId,planWorkload,totalReceivables,budgetMarginRate,contractAmt,planInnerUserPrice,planOutUserPrice,planOutUserCnt,planInnerUserCnt,planWorkingHours,taxRate,planInnerUserWorkload,planOutUserWorkload,productId,productName,templateId,tcuserid,tcusername,tremark,tctime,tcbranchId,shareScope;<br>
 * 当前表的所有字段名:<br>
 *	id,code,name,xm_type,start_time,end_time,urgent,priority,description,create_userid,create_username,create_time,assess,assess_remarks,status,branch_id,plan_total_cost,biz_proc_inst_id,biz_flow_state,plan_nouser_at,plan_inner_user_at,plan_out_user_at,locked,base_time,base_remark,baseline_id,plan_workload,total_receivables,budget_margin_rate,contract_amt,plan_inner_user_price,plan_out_user_price,plan_out_user_cnt,plan_inner_user_cnt,plan_working_hours,tax_rate,plan_inner_user_workload,plan_out_user_workload,product_id,product_name,template_id,tcuserid,tcusername,tremark,tctime,tcbranch_id,share_scope;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectTemplateController {

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
		Map<String,Object> p=BaseUtils.map("id","nKcH","code","9h2e","name","2LSI","xmType","0odU","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","djav","priority","K97L","description","VrxN","createUserid","Sb8X","createUsername","T8mf","createTime",parse("2020-11-02 21:15:1"),"assess","qDwX","assessRemarks","Y1HH","status","Z34x","branchId","24m0","planTotalCost",6555.25,"bizProcInstId","VeW9","bizFlowState","9","planNouserAt",2140.46,"planInnerUserAt",934.12,"planOutUserAt",8488.98,"locked","3","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","jsLa","baselineId","IlU8","planWorkload",2853.96,"totalReceivables",2358.89,"budgetMarginRate",2168.6643,"contractAmt",9010.66,"planInnerUserPrice",2912.83,"planOutUserPrice",9664.67,"planOutUserCnt",7257,"planInnerUserCnt",8108,"planWorkingHours",5108,"taxRate",3658.61,"planInnerUserWorkload",5254.45,"planOutUserWorkload",760.81,"productId","U5Nm","productName","27si","templateId","Sn7a","tcuserid","nEn0","tcusername","x092","tremark","U0fg","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","EsLo","shareScope","kbGz");
		XmProjectTemplate xmProjectTemplate=BaseUtils.fromMap(p,XmProjectTemplate.class);
		String jsonXmProjectTemplate=om.writeValueAsString(xmProjectTemplate);
		mockMvc.perform( post("/**/xm/xmProjectTemplate/add").content(jsonXmProjectTemplate).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/xm/xmProjectTemplate/list")
		.param("id","nKcH").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("id","nKcH","code","9h2e","name","2LSI","xmType","0odU","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","djav","priority","K97L","description","VrxN","createUserid","Sb8X","createUsername","T8mf","createTime",parse("2020-11-02 21:15:1"),"assess","qDwX","assessRemarks","Y1HH","status","Z34x","branchId","24m0","planTotalCost",6555.25,"bizProcInstId","VeW9","bizFlowState","9","planNouserAt",2140.46,"planInnerUserAt",934.12,"planOutUserAt",8488.98,"locked","3","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","jsLa","baselineId","IlU8","planWorkload",2853.96,"totalReceivables",2358.89,"budgetMarginRate",2168.6643,"contractAmt",9010.66,"planInnerUserPrice",2912.83,"planOutUserPrice",9664.67,"planOutUserCnt",7257,"planInnerUserCnt",8108,"planWorkingHours",5108,"taxRate",3658.61,"planInnerUserWorkload",5254.45,"planOutUserWorkload",760.81,"productId","U5Nm","productName","27si","templateId","Sn7a","tcuserid","nEn0","tcusername","x092","tremark","U0fg","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","EsLo","shareScope","kbGz");
		XmProjectTemplate xmProjectTemplate=BaseUtils.fromMap(p,XmProjectTemplate.class);
		String jsonXmProjectTemplate=om.writeValueAsString(xmProjectTemplate);
		mockMvc.perform( post("/**/xm/xmProjectTemplate/edit").content(jsonXmProjectTemplate).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/xm/xmProjectTemplate/del").content("nKcH").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("id","nKcH","code","9h2e","name","2LSI","xmType","0odU","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","djav","priority","K97L","description","VrxN","createUserid","Sb8X","createUsername","T8mf","createTime",parse("2020-11-02 21:15:1"),"assess","qDwX","assessRemarks","Y1HH","status","Z34x","branchId","24m0","planTotalCost",6555.25,"bizProcInstId","VeW9","bizFlowState","9","planNouserAt",2140.46,"planInnerUserAt",934.12,"planOutUserAt",8488.98,"locked","3","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","jsLa","baselineId","IlU8","planWorkload",2853.96,"totalReceivables",2358.89,"budgetMarginRate",2168.6643,"contractAmt",9010.66,"planInnerUserPrice",2912.83,"planOutUserPrice",9664.67,"planOutUserCnt",7257,"planInnerUserCnt",8108,"planWorkingHours",5108,"taxRate",3658.61,"planInnerUserWorkload",5254.45,"planOutUserWorkload",760.81,"productId","U5Nm","productName","27si","templateId","Sn7a","tcuserid","nEn0","tcusername","x092","tremark","U0fg","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","EsLo","shareScope","kbGz");
		XmProjectTemplate xmProjectTemplate=BaseUtils.fromMap(p,XmProjectTemplate.class);
		List<XmProjectTemplate>  xmProjectTemplates=new ArrayList<>();
		xmProjectTemplates.add(xmProjectTemplate);
		String jsonXmProjectTemplate=om.writeValueAsString(xmProjectTemplates);
		mockMvc.perform( post("/**/xm/xmProjectTemplate/batchDel").content(jsonXmProjectTemplate).contentType(MediaType.APPLICATION_JSON))
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
