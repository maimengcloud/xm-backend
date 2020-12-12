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
import com.qqkj.xm.core.entity.XmProjectKpiHis;
import com.qqkj.mdp.core.utils.BaseUtils;
/**
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_project_kpi_his xm_project_kpi_his<br>
 * 实体 XmProjectKpiHis<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	projectId,branchId,kpiIndex,kpiName,maxValue,minValue,kpiId,score,scoreDate,bizFlowState,bizProcInstId,kpiValue,cdate,id,remark,calcType,nextCalcDate;<br>
 * 当前表的所有字段名:<br>
 *	project_id,branch_id,kpi_index,kpi_name,max_value,min_value,kpi_id,score,score_date,biz_flow_state,biz_proc_inst_id,kpi_value,cdate,id,remark,calc_type,next_calc_date;<br>
 * 当前主键(包括多主键):<br>
 *	kpi_id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectKpiHisController {

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
		Map<String,Object> p=BaseUtils.map("projectId","ynG6","branchId","w49f","kpiIndex","Wamp","kpiName","scfM","maxValue","dhi0","minValue","ak6C","kpiId","dB26","score",4140,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","H90W","bizProcInstId","1lol","kpiValue","MkoY","cdate",parse("2020-10-01 0:41:53"),"id","I6CN","remark","LvSY","calcType","hR8y","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis=BaseUtils.fromMap(p,XmProjectKpiHis.class);
		String jsonXmProjectKpiHis=om.writeValueAsString(xmProjectKpiHis);
		mockMvc.perform( post("/**/xm/xmProjectKpiHis/add").content(jsonXmProjectKpiHis).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/xm/xmProjectKpiHis/list")
		.param("kpiId","dB26").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("pageInfo.total").exists());
	}
	
	@Test
	public void listKey() throws Exception  {
		mockMvc.perform( get("/**/xm/xmProjectKpiHis/listKey")
		.param("kpiId","dB26").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("pageInfo.total").exists());
	}

	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("projectId","ynG6","branchId","w49f","kpiIndex","Wamp","kpiName","scfM","maxValue","dhi0","minValue","ak6C","kpiId","dB26","score",4140,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","H90W","bizProcInstId","1lol","kpiValue","MkoY","cdate",parse("2020-10-01 0:41:53"),"id","I6CN","remark","LvSY","calcType","hR8y","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis=BaseUtils.fromMap(p,XmProjectKpiHis.class);
		String jsonXmProjectKpiHis=om.writeValueAsString(xmProjectKpiHis);
		mockMvc.perform( post("/**/xm/xmProjectKpiHis/edit").content(jsonXmProjectKpiHis).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/xm/xmProjectKpiHis/del").content("dB26").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("projectId","ynG6","branchId","w49f","kpiIndex","Wamp","kpiName","scfM","maxValue","dhi0","minValue","ak6C","kpiId","dB26","score",4140,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","H90W","bizProcInstId","1lol","kpiValue","MkoY","cdate",parse("2020-10-01 0:41:53"),"id","I6CN","remark","LvSY","calcType","hR8y","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis=BaseUtils.fromMap(p,XmProjectKpiHis.class);
		List<XmProjectKpiHis>  xmProjectKpiHiss=new ArrayList<>();
		xmProjectKpiHiss.add(xmProjectKpiHis);
		String jsonXmProjectKpiHis=om.writeValueAsString(xmProjectKpiHiss);
		mockMvc.perform( post("/**/xm/xmProjectKpiHis/batchDel").content(jsonXmProjectKpiHis).contentType(MediaType.APPLICATION_JSON))
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
