package com.xm.core.ctrl;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmProjectPhaseTemplate;
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
 * 表 XM.xm_project_phase_template 项目阶段模板<br>
 * 实体 XmProjectPhaseTemplate<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,phaseName,remark,parentPhaseId,branchId,projectId,beginDate,endDate,phaseBudgetHours,phaseBudgetStaffNu,ctime,phaseBudgetNouserAt,phaseBudgetInnerUserAt,phaseBudgetOutUserAt,phaseBudgetWorkload,taskType,planType,seqNo,phaseBudgetInnerUserWorkload,phaseBudgetOutUserWorkload,phaseBudgetInnerUserPrice,phaseBudgetOutUserPrice,phaseBudgetOutUserCnt,phaseBudgetInnerUserCnt;<br>
 * 当前表的所有字段名:<br>
 *	id,phase_name,remark,parent_phase_id,branch_id,project_id,begin_date,end_date,phase_budget_hours,phase_budget_staff_nu,ctime,phase_budget_nouser_at,phase_budget_inner_user_at,phase_budget_out_user_at,phase_budget_workload,task_type,plan_type,seq_no,phase_budget_inner_user_workload,phase_budget_out_user_workload,phase_budget_inner_user_price,phase_budget_out_user_price,phase_budget_out_user_cnt,phase_budget_inner_user_cnt;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectPhaseTemplateController {

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
		Map<String,Object> p=BaseUtils.map("id","px91","phaseName","XHk9","remark","PE8H","parentPhaseId","B52t","branchId","v3td","projectId","j95e","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",3548.39,"phaseBudgetStaffNu",6024.62,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",2868.15,"phaseBudgetInnerUserAt",9081.54,"phaseBudgetOutUserAt",947.44,"phaseBudgetWorkload",7776.59,"taskType","MnCB","planType","dyuS","seqNo","qPqj","phaseBudgetInnerUserWorkload",9748.55,"phaseBudgetOutUserWorkload",4165.76,"phaseBudgetInnerUserPrice",5218.25,"phaseBudgetOutUserPrice",653.52,"phaseBudgetOutUserCnt",9752.9,"phaseBudgetInnerUserCnt",5358.33);
		XmProjectPhaseTemplate xmProjectPhaseTemplate=BaseUtils.fromMap(p,XmProjectPhaseTemplate.class);
		String jsonXmProjectPhaseTemplate=om.writeValueAsString(xmProjectPhaseTemplate);
		mockMvc.perform( post("/**/xm/xmProjectPhaseTemplate/add").content(jsonXmProjectPhaseTemplate).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/xm/xmProjectPhaseTemplate/list")
		.param("id","px91").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("id","px91","phaseName","XHk9","remark","PE8H","parentPhaseId","B52t","branchId","v3td","projectId","j95e","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",3548.39,"phaseBudgetStaffNu",6024.62,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",2868.15,"phaseBudgetInnerUserAt",9081.54,"phaseBudgetOutUserAt",947.44,"phaseBudgetWorkload",7776.59,"taskType","MnCB","planType","dyuS","seqNo","qPqj","phaseBudgetInnerUserWorkload",9748.55,"phaseBudgetOutUserWorkload",4165.76,"phaseBudgetInnerUserPrice",5218.25,"phaseBudgetOutUserPrice",653.52,"phaseBudgetOutUserCnt",9752.9,"phaseBudgetInnerUserCnt",5358.33);
		XmProjectPhaseTemplate xmProjectPhaseTemplate=BaseUtils.fromMap(p,XmProjectPhaseTemplate.class);
		String jsonXmProjectPhaseTemplate=om.writeValueAsString(xmProjectPhaseTemplate);
		mockMvc.perform( post("/**/xm/xmProjectPhaseTemplate/edit").content(jsonXmProjectPhaseTemplate).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/xm/xmProjectPhaseTemplate/del").content("px91").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("id","px91","phaseName","XHk9","remark","PE8H","parentPhaseId","B52t","branchId","v3td","projectId","j95e","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",3548.39,"phaseBudgetStaffNu",6024.62,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",2868.15,"phaseBudgetInnerUserAt",9081.54,"phaseBudgetOutUserAt",947.44,"phaseBudgetWorkload",7776.59,"taskType","MnCB","planType","dyuS","seqNo","qPqj","phaseBudgetInnerUserWorkload",9748.55,"phaseBudgetOutUserWorkload",4165.76,"phaseBudgetInnerUserPrice",5218.25,"phaseBudgetOutUserPrice",653.52,"phaseBudgetOutUserCnt",9752.9,"phaseBudgetInnerUserCnt",5358.33);
		XmProjectPhaseTemplate xmProjectPhaseTemplate=BaseUtils.fromMap(p,XmProjectPhaseTemplate.class);
		List<XmProjectPhaseTemplate>  xmProjectPhaseTemplates=new ArrayList<>();
		xmProjectPhaseTemplates.add(xmProjectPhaseTemplate);
		String jsonXmProjectPhaseTemplate=om.writeValueAsString(xmProjectPhaseTemplates);
		mockMvc.perform( post("/**/xm/xmProjectPhaseTemplate/batchDel").content(jsonXmProjectPhaseTemplate).contentType(MediaType.APPLICATION_JSON))
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
