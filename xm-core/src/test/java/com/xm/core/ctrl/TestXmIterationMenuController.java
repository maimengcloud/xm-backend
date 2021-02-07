package com.xm.core.ctrl;

import java.text.SimpleDateFormat;
import java.util.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;  
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.xm.core.entity.XmIterationMenu;
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
 * 表 XM.xm_iteration_menu 迭代定义<br>
 * 实体 XmIterationMenu<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,iterationId,menuId,productId,ctime,relStatus,hasTask,cuserid,cusername;<br>
 * 当前表的所有字段名:<br>
 *	id,iteration_id,menu_id,product_id,ctime,rel_status,has_task,cuserid,cusername;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmIterationMenuController {

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
		Map<String,Object> p=BaseUtils.map("id","8b59","iterationId","5b38","menuId","Se4e","productId","oIgA","ctime",parse("2020-11-07 22:55:27"),"relStatus","x","hasTask","9","cuserid","itag","cusername","cxXF");
		XmIterationMenu xmIterationMenu=BaseUtils.fromMap(p,XmIterationMenu.class);
		String jsonXmIterationMenu=om.writeValueAsString(xmIterationMenu);
		mockMvc.perform( post("/**/xm/xmIterationMenu/add").content(jsonXmIterationMenu).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
		   	.andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void list() throws Exception  {
		mockMvc.perform( get("/**/xm/xmIterationMenu/list")
		.param("id","8b59").param("currentPage", "1").param("pageSize", "10"))
		   .andDo(print())
		   .andExpect(status().isOk()) 
		   .andExpect(jsonPath("tips.isOk").value(true))
		   .andExpect(jsonPath("data").isArray())
		   .andExpect(jsonPath("total").exists());
	}
	 
	@Test
	public void edit() throws Exception {
		Map<String,Object> p=BaseUtils.map("id","8b59","iterationId","5b38","menuId","Se4e","productId","oIgA","ctime",parse("2020-11-07 22:55:27"),"relStatus","x","hasTask","9","cuserid","itag","cusername","cxXF");
		XmIterationMenu xmIterationMenu=BaseUtils.fromMap(p,XmIterationMenu.class);
		String jsonXmIterationMenu=om.writeValueAsString(xmIterationMenu);
		mockMvc.perform( post("/**/xm/xmIterationMenu/edit").content(jsonXmIterationMenu).contentType(MediaType.APPLICATION_JSON))
			.andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}

	@Test
	public void del() throws Exception {
		mockMvc.perform( post("/**/xm/xmIterationMenu/del").content("8b59").contentType(MediaType.APPLICATION_JSON))		 
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(jsonPath("tips.isOk").value(true));
	}
	
	@Test
	public void batchDel() throws Exception { 
		Map<String,Object> p=BaseUtils.map("id","8b59","iterationId","5b38","menuId","Se4e","productId","oIgA","ctime",parse("2020-11-07 22:55:27"),"relStatus","x","hasTask","9","cuserid","itag","cusername","cxXF");
		XmIterationMenu xmIterationMenu=BaseUtils.fromMap(p,XmIterationMenu.class);
		List<XmIterationMenu>  xmIterationMenus=new ArrayList<>();
		xmIterationMenus.add(xmIterationMenu);
		String jsonXmIterationMenu=om.writeValueAsString(xmIterationMenus);
		mockMvc.perform( post("/**/xm/xmIterationMenu/batchDel").content(jsonXmIterationMenu).contentType(MediaType.APPLICATION_JSON))
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
