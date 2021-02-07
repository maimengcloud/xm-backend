package com.xm.core.ctrl;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmProjectMCostUser;
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
 * 表 XM.xm_project_m_cost_user 项目实际人工成本费用<br>
 * 实体 XmProjectMCostUser<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	subjectId,projectId,userid,createTime,sendCostTime,username,projectName,remark,id,taskId,taskName,actWorkload,bizzStartDate,bizzEndDate,bizProcInstId,bizFlowState,projectPhaseId,actCostAmount,costType,bizMonth,bizDate,subjectName,projectPhaseName,execuserProcInstId,execuserStatus,payStatus,payOpUserid,payOpUsername;<br>
 * 当前表的所有字段名:<br>
 *	subject_id,project_id,userid,create_time,send_cost_time,username,project_name,remark,id,task_id,task_name,act_workload,bizz_start_date,bizz_end_date,biz_proc_inst_id,biz_flow_state,project_phase_id,act_cost_amount,cost_type,biz_month,biz_date,subject_name,project_phase_name,execuser_proc_inst_id,execuser_status,pay_status,pay_op_userid,pay_op_username;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectMCostUserController {

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
		Map<String,Object> p=BaseUtils.map("subjectId","Q02E","projectId","PO73","userid","2GI5","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","r8Fh","projectName","NC4L","remark","4Al6","id","7SwH","taskId","j9na","taskName","urKG","actWorkload",9880.61,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","DmlP","bizFlowState","k","projectPhaseId","mL83","actCostAmount",3132.8,"costType","a","bizMonth","f8SN","bizDate","eehe","subjectName","I80q","projectPhaseName","F12G","execuserProcInstId","V7S7","execuserStatus","O","payStatus","w","payOpUserid","UiKn","payOpUsername","b6c0");
		XmProjectMCostUser xmProjectMCostUser=BaseUtils.fromMap(p,XmProjectMCostUser.class);
		String jsonXmProjectMCostUser=om.writeValueAsString(xmProjectMCostUser);
		mockMvc.perform( post("/**/xm/xmProjectMCostUser/add").content(jsonXmProjectMCostUser).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/xm/xmProjectMCostUser/list")
		.param("id","7SwH").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("pageInfo.total").exists());
	}
	
	@Test
	public void listKey() throws Exception  {
		mockMvc.perform( get("/**/xm/xmProjectMCostUser/listKey")
		.param("id","7SwH").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("pageInfo.total").exists());
	}

	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("subjectId","Q02E","projectId","PO73","userid","2GI5","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","r8Fh","projectName","NC4L","remark","4Al6","id","7SwH","taskId","j9na","taskName","urKG","actWorkload",9880.61,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","DmlP","bizFlowState","k","projectPhaseId","mL83","actCostAmount",3132.8,"costType","a","bizMonth","f8SN","bizDate","eehe","subjectName","I80q","projectPhaseName","F12G","execuserProcInstId","V7S7","execuserStatus","O","payStatus","w","payOpUserid","UiKn","payOpUsername","b6c0");
		XmProjectMCostUser xmProjectMCostUser=BaseUtils.fromMap(p,XmProjectMCostUser.class);
		String jsonXmProjectMCostUser=om.writeValueAsString(xmProjectMCostUser);
		mockMvc.perform( post("/**/xm/xmProjectMCostUser/edit").content(jsonXmProjectMCostUser).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/xm/xmProjectMCostUser/del").content("7SwH").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("subjectId","Q02E","projectId","PO73","userid","2GI5","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","r8Fh","projectName","NC4L","remark","4Al6","id","7SwH","taskId","j9na","taskName","urKG","actWorkload",9880.61,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","DmlP","bizFlowState","k","projectPhaseId","mL83","actCostAmount",3132.8,"costType","a","bizMonth","f8SN","bizDate","eehe","subjectName","I80q","projectPhaseName","F12G","execuserProcInstId","V7S7","execuserStatus","O","payStatus","w","payOpUserid","UiKn","payOpUsername","b6c0");
		XmProjectMCostUser xmProjectMCostUser=BaseUtils.fromMap(p,XmProjectMCostUser.class);
		List<XmProjectMCostUser>  xmProjectMCostUsers=new ArrayList<>();
		xmProjectMCostUsers.add(xmProjectMCostUser);
		String jsonXmProjectMCostUser=om.writeValueAsString(xmProjectMCostUsers);
		mockMvc.perform( post("/**/xm/xmProjectMCostUser/batchDel").content(jsonXmProjectMCostUser).contentType(MediaType.APPLICATION_JSON))
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
