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
import com.qqkj.xm.core.entity.XmProjectMCostNouser;
import com.qqkj.mdp.core.utils.BaseUtils;
/**
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_project_m_cost_nouser xm_project_m_cost_nouser<br>
 * 实体 XmProjectMCostNouser<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	projectId,userid,createTime,sendCostTime,username,projectName,remark,id,taskId,taskName,subjectId,bizzStartDate,bizzEndDate,bizProcInstId,bizFlowState,projectPhaseId,actCostAmount,costType,bizMonth,bizDate;<br>
 * 当前表的所有字段名:<br>
 *	project_id,userid,create_time,send_cost_time,username,project_name,remark,id,task_id,task_name,subject_id,bizz_start_date,bizz_end_date,biz_proc_inst_id,biz_flow_state,project_phase_id,act_cost_amount,cost_type,biz_month,biz_date;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectMCostNouserController {

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
		Map<String,Object> p=BaseUtils.map("projectId","Uz5H","userid","7BPs","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","YNs1","projectName","UHq4","remark","kS6Q","id","a3XR","taskId","aKjk","taskName","3ylX","subjectId","pqSA","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","f3rC","bizFlowState","u","projectPhaseId","lVKX","actCostAmount",5921.4,"costType","e","bizMonth","Q3G6","bizDate","2Yqo");
		XmProjectMCostNouser xmProjectMCostNouser=BaseUtils.fromMap(p,XmProjectMCostNouser.class);
		String jsonXmProjectMCostNouser=om.writeValueAsString(xmProjectMCostNouser);
		mockMvc.perform( post("/**/xm/xmProjectMCostNouser/add").content(jsonXmProjectMCostNouser).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/xm/xmProjectMCostNouser/list")
		.param("id","a3XR").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("pageInfo.total").exists());
	}
	
	@Test
	public void listKey() throws Exception  {
		mockMvc.perform( get("/**/xm/xmProjectMCostNouser/listKey")
		.param("id","a3XR").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("pageInfo.total").exists());
	}

	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("projectId","Uz5H","userid","7BPs","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","YNs1","projectName","UHq4","remark","kS6Q","id","a3XR","taskId","aKjk","taskName","3ylX","subjectId","pqSA","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","f3rC","bizFlowState","u","projectPhaseId","lVKX","actCostAmount",5921.4,"costType","e","bizMonth","Q3G6","bizDate","2Yqo");
		XmProjectMCostNouser xmProjectMCostNouser=BaseUtils.fromMap(p,XmProjectMCostNouser.class);
		String jsonXmProjectMCostNouser=om.writeValueAsString(xmProjectMCostNouser);
		mockMvc.perform( post("/**/xm/xmProjectMCostNouser/edit").content(jsonXmProjectMCostNouser).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/xm/xmProjectMCostNouser/del").content("a3XR").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("projectId","Uz5H","userid","7BPs","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","YNs1","projectName","UHq4","remark","kS6Q","id","a3XR","taskId","aKjk","taskName","3ylX","subjectId","pqSA","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","f3rC","bizFlowState","u","projectPhaseId","lVKX","actCostAmount",5921.4,"costType","e","bizMonth","Q3G6","bizDate","2Yqo");
		XmProjectMCostNouser xmProjectMCostNouser=BaseUtils.fromMap(p,XmProjectMCostNouser.class);
		List<XmProjectMCostNouser>  xmProjectMCostNousers=new ArrayList<>();
		xmProjectMCostNousers.add(xmProjectMCostNouser);
		String jsonXmProjectMCostNouser=om.writeValueAsString(xmProjectMCostNousers);
		mockMvc.perform( post("/**/xm/xmProjectMCostNouser/batchDel").content(jsonXmProjectMCostNouser).contentType(MediaType.APPLICATION_JSON))
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
