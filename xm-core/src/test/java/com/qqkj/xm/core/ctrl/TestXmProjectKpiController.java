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
import com.qqkj.xm.core.entity.XmProjectKpi;
import com.qqkj.mdp.core.utils.BaseUtils;
/**
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_project_kpi xm_project_kpi<br>
 * 实体 XmProjectKpi<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	projectId,branchId,kpiIndex,kpiName,maxValue,minValue,id,score,scoreDate,bizFlowState,bizProcInstId,kpiValue,remark,calcType,nextCalcDate;<br>
 * 当前表的所有字段名:<br>
 *	project_id,branch_id,kpi_index,kpi_name,max_value,min_value,id,score,score_date,biz_flow_state,biz_proc_inst_id,kpi_value,remark,calc_type,next_calc_date;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectKpiController {

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
		Map<String,Object> p=BaseUtils.map("projectId","TuVY","branchId","4C86","kpiIndex","gO3m","kpiName","8NTh","maxValue","MIT8","minValue","0hiC","id","kFbZ","score",3540,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","omD2","bizProcInstId","376R","kpiValue","8qu0","remark","j1vX","calcType","BCxu","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi=BaseUtils.fromMap(p,XmProjectKpi.class);
		String jsonXmProjectKpi=om.writeValueAsString(xmProjectKpi);
		mockMvc.perform( post("/**/xm/xmProjectKpi/add").content(jsonXmProjectKpi).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/xm/xmProjectKpi/list")
		.param("id","kFbZ").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("pageInfo.total").exists());
	}
	
	@Test
	public void listKey() throws Exception  {
		mockMvc.perform( get("/**/xm/xmProjectKpi/listKey")
		.param("id","kFbZ").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("pageInfo.total").exists());
	}

	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("projectId","TuVY","branchId","4C86","kpiIndex","gO3m","kpiName","8NTh","maxValue","MIT8","minValue","0hiC","id","kFbZ","score",3540,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","omD2","bizProcInstId","376R","kpiValue","8qu0","remark","j1vX","calcType","BCxu","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi=BaseUtils.fromMap(p,XmProjectKpi.class);
		String jsonXmProjectKpi=om.writeValueAsString(xmProjectKpi);
		mockMvc.perform( post("/**/xm/xmProjectKpi/edit").content(jsonXmProjectKpi).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/xm/xmProjectKpi/del").content("kFbZ").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("projectId","TuVY","branchId","4C86","kpiIndex","gO3m","kpiName","8NTh","maxValue","MIT8","minValue","0hiC","id","kFbZ","score",3540,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","omD2","bizProcInstId","376R","kpiValue","8qu0","remark","j1vX","calcType","BCxu","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi=BaseUtils.fromMap(p,XmProjectKpi.class);
		List<XmProjectKpi>  xmProjectKpis=new ArrayList<>();
		xmProjectKpis.add(xmProjectKpi);
		String jsonXmProjectKpi=om.writeValueAsString(xmProjectKpis);
		mockMvc.perform( post("/**/xm/xmProjectKpi/batchDel").content(jsonXmProjectKpi).contentType(MediaType.APPLICATION_JSON))
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
