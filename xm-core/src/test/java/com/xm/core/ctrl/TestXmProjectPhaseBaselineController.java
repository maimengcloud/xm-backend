package com.xm.core.ctrl;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmProjectPhaseBaseline;
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
 * 表 XM.xm_project_phase_baseline xm_project_phase_baseline<br>
 * 实体 XmProjectPhaseBaseline<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	baseCtime,projectPhaseId,phaseName,remark,parentPhaseId,branchId,projectId,beginDate,endDate,planWorkingHours,planWorkingStaffNu,ctime,totalBudgetNouser,totalBudgetInnerUser,totalBudgetOutUser,id,baseRemark,projectBaselineId,bizProcInstId,bizFlowState,totalBudgetWorkload,totalActWorkload;<br>
 * 当前表的所有字段名:<br>
 *	base_ctime,project_phase_id,phase_name,remark,parent_phase_id,branch_id,project_id,begin_date,end_date,plan_working_hours,plan_working_staff_nu,ctime,total_budget_nouser,total_budget_inner_user,total_budget_out_user,id,base_remark,project_baseline_id,biz_proc_inst_id,biz_flow_state,total_budget_workload,total_act_workload;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectPhaseBaselineController {

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
		Map<String,Object> p=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","pd7P","phaseName","pVg2","remark","BFeD","parentPhaseId","HLs3","branchId","Do6b","projectId","xH3I","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",4634.93,"planWorkingStaffNu",6990.98,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",4075.36,"totalBudgetInnerUser",2003.36,"totalBudgetOutUser",4365.6,"id","FqYc","baseRemark","7Ixb","projectBaselineId","WeKC","bizProcInstId","PBqj","bizFlowState","9","totalBudgetWorkload",8434.8,"totalActWorkload",4439.97);
		XmProjectPhaseBaseline xmProjectPhaseBaseline=BaseUtils.fromMap(p,XmProjectPhaseBaseline.class);
		String jsonXmProjectPhaseBaseline=om.writeValueAsString(xmProjectPhaseBaseline);
		mockMvc.perform( post("/**/xm/xmProjectPhaseBaseline/add").content(jsonXmProjectPhaseBaseline).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/xm/xmProjectPhaseBaseline/list")
		.param("id","FqYc").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("pageInfo.total").exists());
	}
	
	@Test
	public void listKey() throws Exception  {
		mockMvc.perform( get("/**/xm/xmProjectPhaseBaseline/listKey")
		.param("id","FqYc").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("pageInfo.total").exists());
	}

	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","pd7P","phaseName","pVg2","remark","BFeD","parentPhaseId","HLs3","branchId","Do6b","projectId","xH3I","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",4634.93,"planWorkingStaffNu",6990.98,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",4075.36,"totalBudgetInnerUser",2003.36,"totalBudgetOutUser",4365.6,"id","FqYc","baseRemark","7Ixb","projectBaselineId","WeKC","bizProcInstId","PBqj","bizFlowState","9","totalBudgetWorkload",8434.8,"totalActWorkload",4439.97);
		XmProjectPhaseBaseline xmProjectPhaseBaseline=BaseUtils.fromMap(p,XmProjectPhaseBaseline.class);
		String jsonXmProjectPhaseBaseline=om.writeValueAsString(xmProjectPhaseBaseline);
		mockMvc.perform( post("/**/xm/xmProjectPhaseBaseline/edit").content(jsonXmProjectPhaseBaseline).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/xm/xmProjectPhaseBaseline/del").content("FqYc").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","pd7P","phaseName","pVg2","remark","BFeD","parentPhaseId","HLs3","branchId","Do6b","projectId","xH3I","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",4634.93,"planWorkingStaffNu",6990.98,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",4075.36,"totalBudgetInnerUser",2003.36,"totalBudgetOutUser",4365.6,"id","FqYc","baseRemark","7Ixb","projectBaselineId","WeKC","bizProcInstId","PBqj","bizFlowState","9","totalBudgetWorkload",8434.8,"totalActWorkload",4439.97);
		XmProjectPhaseBaseline xmProjectPhaseBaseline=BaseUtils.fromMap(p,XmProjectPhaseBaseline.class);
		List<XmProjectPhaseBaseline>  xmProjectPhaseBaselines=new ArrayList<>();
		xmProjectPhaseBaselines.add(xmProjectPhaseBaseline);
		String jsonXmProjectPhaseBaseline=om.writeValueAsString(xmProjectPhaseBaselines);
		mockMvc.perform( post("/**/xm/xmProjectPhaseBaseline/batchDel").content(jsonXmProjectPhaseBaseline).contentType(MediaType.APPLICATION_JSON))
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
