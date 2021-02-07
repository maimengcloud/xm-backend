package com.xm.core.ctrl;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmBranchTaskTypeState;
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
 * 表 XM.xm_branch_task_type_state 按机构编号任务类型汇总<br>
 * 实体 XmBranchTaskTypeState<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	taskType,planWorkload,planAmount,actWorkload,actAmount,branchId,bizDate,calcTime,planOutUserAt,planInnerUserAt,actOutUserAt,actInnerUserAt,planOutUserWorkload,planInnerUserWorkload,actOutUserWorkload,actInnerUserWorkload,planNouserAt,actNouserAt,id,branchName;<br>
 * 当前表的所有字段名:<br>
 *	task_type,plan_workload,plan_amount,act_workload,act_amount,branch_id,biz_date,calc_time,plan_out_user_at,plan_inner_user_at,act_out_user_at,act_inner_user_at,plan_out_user_workload,plan_inner_user_workload,act_out_user_workload,act_inner_user_workload,plan_nouser_at,act_nouser_at,id,branch_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmBranchTaskTypeStateController {

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
		Map<String,Object> p=BaseUtils.map("taskType","E09l","planWorkload",1192.81,"planAmount",6555.18,"actWorkload",4241.27,"actAmount",3880.71,"branchId","2mgw","bizDate","o1Ey","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",139.59,"planInnerUserAt",9731.77,"actOutUserAt",4480.89,"actInnerUserAt",495.38,"planOutUserWorkload",8957.68,"planInnerUserWorkload",5976.21,"actOutUserWorkload",8269.72,"actInnerUserWorkload",3691.71,"planNouserAt",7317.09,"actNouserAt",6360.64,"id","V5oK","branchName","C92i");
		XmBranchTaskTypeState xmBranchTaskTypeState=BaseUtils.fromMap(p,XmBranchTaskTypeState.class);
		String jsonXmBranchTaskTypeState=om.writeValueAsString(xmBranchTaskTypeState);
		mockMvc.perform( post("/**/core/xmBranchTaskTypeState/add").content(jsonXmBranchTaskTypeState).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/core/xmBranchTaskTypeState/list")
		.param("id","V5oK").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("taskType","E09l","planWorkload",1192.81,"planAmount",6555.18,"actWorkload",4241.27,"actAmount",3880.71,"branchId","2mgw","bizDate","o1Ey","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",139.59,"planInnerUserAt",9731.77,"actOutUserAt",4480.89,"actInnerUserAt",495.38,"planOutUserWorkload",8957.68,"planInnerUserWorkload",5976.21,"actOutUserWorkload",8269.72,"actInnerUserWorkload",3691.71,"planNouserAt",7317.09,"actNouserAt",6360.64,"id","V5oK","branchName","C92i");
		XmBranchTaskTypeState xmBranchTaskTypeState=BaseUtils.fromMap(p,XmBranchTaskTypeState.class);
		String jsonXmBranchTaskTypeState=om.writeValueAsString(xmBranchTaskTypeState);
		mockMvc.perform( post("/**/core/xmBranchTaskTypeState/edit").content(jsonXmBranchTaskTypeState).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/core/xmBranchTaskTypeState/del").content("V5oK").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("taskType","E09l","planWorkload",1192.81,"planAmount",6555.18,"actWorkload",4241.27,"actAmount",3880.71,"branchId","2mgw","bizDate","o1Ey","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",139.59,"planInnerUserAt",9731.77,"actOutUserAt",4480.89,"actInnerUserAt",495.38,"planOutUserWorkload",8957.68,"planInnerUserWorkload",5976.21,"actOutUserWorkload",8269.72,"actInnerUserWorkload",3691.71,"planNouserAt",7317.09,"actNouserAt",6360.64,"id","V5oK","branchName","C92i");
		XmBranchTaskTypeState xmBranchTaskTypeState=BaseUtils.fromMap(p,XmBranchTaskTypeState.class);
		List<XmBranchTaskTypeState>  xmBranchTaskTypeStates=new ArrayList<>();
		xmBranchTaskTypeStates.add(xmBranchTaskTypeState);
		String jsonXmBranchTaskTypeState=om.writeValueAsString(xmBranchTaskTypeStates);
		mockMvc.perform( post("/**/core/xmBranchTaskTypeState/batchDel").content(jsonXmBranchTaskTypeState).contentType(MediaType.APPLICATION_JSON))
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
