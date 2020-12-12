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
import com.qqkj.xm.core.entity.XmTestCase;
import com.qqkj.mdp.core.utils.BaseUtils;
/**
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_test_case 测试用例<br>
 * 实体 XmTestCase<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,caseName,caseRemark,testStep,expectResult,menuId,menuName,ctime,ltime,luserid,lusername,cbranchId,moduleId,moduleName,caseStatus;<br>
 * 当前表的所有字段名:<br>
 *	id,case_name,case_remark,test_step,expect_result,menu_id,menu_name,ctime,ltime,luserid,lusername,cbranch_id,module_id,module_name,case_status;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmTestCaseController {

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
		Map<String,Object> p=BaseUtils.map("id","0xhr","caseName","1R0K","caseRemark","qp2c","testStep","6t2c","expectResult","2xaC","menuId","dJL4","menuName","T342","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","9oSC","lusername","Vhw2","cbranchId","5oeq","moduleId","Z33D","moduleName","X90K","caseStatus","e");
		XmTestCase xmTestCase=BaseUtils.fromMap(p,XmTestCase.class);
		String jsonXmTestCase=om.writeValueAsString(xmTestCase);
		mockMvc.perform( post("/**/core/xmTestCase/add").content(jsonXmTestCase).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/core/xmTestCase/list")
		.param("id","0xhr").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("id","0xhr","caseName","1R0K","caseRemark","qp2c","testStep","6t2c","expectResult","2xaC","menuId","dJL4","menuName","T342","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","9oSC","lusername","Vhw2","cbranchId","5oeq","moduleId","Z33D","moduleName","X90K","caseStatus","e");
		XmTestCase xmTestCase=BaseUtils.fromMap(p,XmTestCase.class);
		String jsonXmTestCase=om.writeValueAsString(xmTestCase);
		mockMvc.perform( post("/**/core/xmTestCase/edit").content(jsonXmTestCase).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/core/xmTestCase/del").content("0xhr").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("id","0xhr","caseName","1R0K","caseRemark","qp2c","testStep","6t2c","expectResult","2xaC","menuId","dJL4","menuName","T342","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","9oSC","lusername","Vhw2","cbranchId","5oeq","moduleId","Z33D","moduleName","X90K","caseStatus","e");
		XmTestCase xmTestCase=BaseUtils.fromMap(p,XmTestCase.class);
		List<XmTestCase>  xmTestCases=new ArrayList<>();
		xmTestCases.add(xmTestCase);
		String jsonXmTestCase=om.writeValueAsString(xmTestCases);
		mockMvc.perform( post("/**/core/xmTestCase/batchDel").content(jsonXmTestCase).contentType(MediaType.APPLICATION_JSON))
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
