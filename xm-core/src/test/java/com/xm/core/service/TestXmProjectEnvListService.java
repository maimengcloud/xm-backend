package com.xm.core.service;

import java.util.*;
import java.text.SimpleDateFormat;

import com.xm.core.entity.XmProjectEnvList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.mdp.core.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmProjectEnvListService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_project_env_list xm_project_env_list<br>
 * 实体 XmProjectEnvList<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,remark,ipAddress,port,projectId,projectName,accessUserid,accessPassword,effect,accessUrl,webIpAddress,webPort,otherRemark,createUserid,createUsername,createTime,bizProcInstId,bizFlowState;<br>
 * 当前表的所有字段名:<br>
 *	id,remark,ip_address,port,project_id,project_name,access_userid,access_password,effect,access_url,web_ip_address,web_port,other_remark,create_userid,create_username,create_time,biz_proc_inst_id,biz_flow_state;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectEnvListService  {

	@Autowired
	XmProjectEnvListService xmProjectEnvListService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","0GKJ","remark","zT72","ipAddress","U1FK","port","1GZF","projectId","EWTf","projectName","c1OS","accessUserid","PJ71","accessPassword","7dpv","effect","2s0r","accessUrl","56Ws","webIpAddress","XCSX","webPort","i9DZ","otherRemark","DLSY","createUserid","rp8l","createUsername","EeBz","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","MJeo","bizFlowState","9");
		XmProjectEnvList xmProjectEnvList=BaseUtils.fromMap(p,XmProjectEnvList.class);
		xmProjectEnvListService.insert(xmProjectEnvList);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("remark","zT72","ipAddress","U1FK","port","1GZF","projectId","EWTf","projectName","c1OS","accessUserid","PJ71","accessPassword","7dpv","effect","2s0r","accessUrl","56Ws","webIpAddress","XCSX","webPort","i9DZ","otherRemark","DLSY","createUserid","rp8l","createUsername","EeBz","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","MJeo","bizFlowState","9");
		XmProjectEnvList xmProjectEnvList=BaseUtils.fromMap(p,XmProjectEnvList.class);
		xmProjectEnvListService.deleteByWhere(xmProjectEnvList);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","0GKJ");
		XmProjectEnvList xmProjectEnvList=BaseUtils.fromMap(p,XmProjectEnvList.class);
		xmProjectEnvListService.deleteByPk(xmProjectEnvList);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("remark","zT72","ipAddress","U1FK","port","1GZF","projectId","EWTf","projectName","c1OS","accessUserid","PJ71","accessPassword","7dpv","effect","2s0r","accessUrl","56Ws","webIpAddress","XCSX","webPort","i9DZ","otherRemark","DLSY","createUserid","rp8l","createUsername","EeBz","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","MJeo","bizFlowState","9");
		XmProjectEnvList xmProjectEnvList=BaseUtils.fromMap(where,XmProjectEnvList.class);
		xmProjectEnvListService.updateSomeFieldByPk(xmProjectEnvList);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","0GKJ");
		XmProjectEnvList xmProjectEnvList=BaseUtils.fromMap(p,XmProjectEnvList.class);
		xmProjectEnvListService.updateByPk(xmProjectEnvList);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("id","0GKJ","remark","zT72","ipAddress","U1FK","port","1GZF","projectId","EWTf","projectName","c1OS","accessUserid","PJ71","accessPassword","7dpv","effect","2s0r","accessUrl","56Ws","webIpAddress","XCSX","webPort","i9DZ","otherRemark","DLSY","createUserid","rp8l","createUsername","EeBz","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","MJeo","bizFlowState","9");
		XmProjectEnvList xmProjectEnvList=BaseUtils.fromMap(p,XmProjectEnvList.class);
		xmProjectEnvListService.insertOrUpdate(xmProjectEnvList);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmProjectEnvList> batchValues=new ArrayList<XmProjectEnvList>();
		Map p0=BaseUtils.map("id","0GKJ","remark","zT72","ipAddress","U1FK","port","1GZF","projectId","EWTf","projectName","c1OS","accessUserid","PJ71","accessPassword","7dpv","effect","2s0r","accessUrl","56Ws","webIpAddress","XCSX","webPort","i9DZ","otherRemark","DLSY","createUserid","rp8l","createUsername","EeBz","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","MJeo","bizFlowState","9");
		XmProjectEnvList xmProjectEnvList0=BaseUtils.fromMap(p0,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList0);
		Map p1=BaseUtils.map("id","7crK","remark","xB7r","ipAddress","84xC","port","HnYb","projectId","g342","projectName","6lT3","accessUserid","9mfA","accessPassword","o1m7","effect","H9Q8","accessUrl","EvNV","webIpAddress","xHAI","webPort","0G9z","otherRemark","wf2d","createUserid","FC79","createUsername","Qo2L","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","Gqwn","bizFlowState","m");
		XmProjectEnvList xmProjectEnvList1=BaseUtils.fromMap(p1,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList1);
		Map p2=BaseUtils.map("id","wGWa","remark","hPV2","ipAddress","542g","port","ucPI","projectId","72KP","projectName","qs4K","accessUserid","5cH0","accessPassword","UfTE","effect","m8T3","accessUrl","QsMZ","webIpAddress","w3RO","webPort","WT4J","otherRemark","ZsD2","createUserid","6xoY","createUsername","UPnz","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","0P5s","bizFlowState","9");
		XmProjectEnvList xmProjectEnvList2=BaseUtils.fromMap(p2,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList2);
		Map p3=BaseUtils.map("id","1EYY","remark","tBEr","ipAddress","WPz6","port","k860","projectId","9YOy","projectName","4U9t","accessUserid","oyaf","accessPassword","MWQ9","effect","5yp8","accessUrl","ceNK","webIpAddress","3emq","webPort","F5at","otherRemark","7YdW","createUserid","g8q5","createUsername","cOz7","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","y740","bizFlowState","5");
		XmProjectEnvList xmProjectEnvList3=BaseUtils.fromMap(p3,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList3);
		Map p4=BaseUtils.map("id","on93","remark","8g86","ipAddress","oCYO","port","V27Y","projectId","cwVP","projectName","82o1","accessUserid","CRFX","accessPassword","8Wm4","effect","h9e1","accessUrl","8mwp","webIpAddress","kiYT","webPort","4gyC","otherRemark","FAKT","createUserid","6r89","createUsername","83b4","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","USp7","bizFlowState","3");
		XmProjectEnvList xmProjectEnvList4=BaseUtils.fromMap(p4,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList4);
		Map p5=BaseUtils.map("id","s1xc","remark","z8Bb","ipAddress","5jZ6","port","13Aw","projectId","bgy3","projectName","trOR","accessUserid","5241","accessPassword","nlWo","effect","LS1s","accessUrl","dADc","webIpAddress","c284","webPort","I27L","otherRemark","bSRQ","createUserid","oihD","createUsername","4rDH","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","b0It","bizFlowState","R");
		XmProjectEnvList xmProjectEnvList5=BaseUtils.fromMap(p5,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList5);
		Map p6=BaseUtils.map("id","ZB1w","remark","11Km","ipAddress","akVS","port","07Hq","projectId","38J0","projectName","AoBM","accessUserid","qLoF","accessPassword","c4i4","effect","x1aM","accessUrl","1w88","webIpAddress","0qg1","webPort","F7y1","otherRemark","i9O0","createUserid","CV91","createUsername","nr6o","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","wic3","bizFlowState","K");
		XmProjectEnvList xmProjectEnvList6=BaseUtils.fromMap(p6,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList6);
		Map p7=BaseUtils.map("id","4Q89","remark","gkii","ipAddress","M1Rn","port","fMV7","projectId","7X4Y","projectName","92PF","accessUserid","5pM6","accessPassword","lRHX","effect","t6iI","accessUrl","Ju7Z","webIpAddress","IG5l","webPort","8fd0","otherRemark","7spL","createUserid","X981","createUsername","jL7A","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","AV8V","bizFlowState","9");
		XmProjectEnvList xmProjectEnvList7=BaseUtils.fromMap(p7,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList7);
		xmProjectEnvListService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmProjectEnvList> batchValues=new ArrayList<XmProjectEnvList>();
		Map p0=BaseUtils.map("id","0GKJ","remark","zT72","ipAddress","U1FK","port","1GZF","projectId","EWTf","projectName","c1OS","accessUserid","PJ71","accessPassword","7dpv","effect","2s0r","accessUrl","56Ws","webIpAddress","XCSX","webPort","i9DZ","otherRemark","DLSY","createUserid","rp8l","createUsername","EeBz","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","MJeo","bizFlowState","9");
		XmProjectEnvList xmProjectEnvList0=BaseUtils.fromMap(p0,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList0);
		Map p1=BaseUtils.map("id","7crK","remark","xB7r","ipAddress","84xC","port","HnYb","projectId","g342","projectName","6lT3","accessUserid","9mfA","accessPassword","o1m7","effect","H9Q8","accessUrl","EvNV","webIpAddress","xHAI","webPort","0G9z","otherRemark","wf2d","createUserid","FC79","createUsername","Qo2L","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","Gqwn","bizFlowState","m");
		XmProjectEnvList xmProjectEnvList1=BaseUtils.fromMap(p1,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList1);
		Map p2=BaseUtils.map("id","wGWa","remark","hPV2","ipAddress","542g","port","ucPI","projectId","72KP","projectName","qs4K","accessUserid","5cH0","accessPassword","UfTE","effect","m8T3","accessUrl","QsMZ","webIpAddress","w3RO","webPort","WT4J","otherRemark","ZsD2","createUserid","6xoY","createUsername","UPnz","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","0P5s","bizFlowState","9");
		XmProjectEnvList xmProjectEnvList2=BaseUtils.fromMap(p2,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList2);
		Map p3=BaseUtils.map("id","1EYY","remark","tBEr","ipAddress","WPz6","port","k860","projectId","9YOy","projectName","4U9t","accessUserid","oyaf","accessPassword","MWQ9","effect","5yp8","accessUrl","ceNK","webIpAddress","3emq","webPort","F5at","otherRemark","7YdW","createUserid","g8q5","createUsername","cOz7","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","y740","bizFlowState","5");
		XmProjectEnvList xmProjectEnvList3=BaseUtils.fromMap(p3,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList3);
		Map p4=BaseUtils.map("id","on93","remark","8g86","ipAddress","oCYO","port","V27Y","projectId","cwVP","projectName","82o1","accessUserid","CRFX","accessPassword","8Wm4","effect","h9e1","accessUrl","8mwp","webIpAddress","kiYT","webPort","4gyC","otherRemark","FAKT","createUserid","6r89","createUsername","83b4","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","USp7","bizFlowState","3");
		XmProjectEnvList xmProjectEnvList4=BaseUtils.fromMap(p4,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList4);
		Map p5=BaseUtils.map("id","s1xc","remark","z8Bb","ipAddress","5jZ6","port","13Aw","projectId","bgy3","projectName","trOR","accessUserid","5241","accessPassword","nlWo","effect","LS1s","accessUrl","dADc","webIpAddress","c284","webPort","I27L","otherRemark","bSRQ","createUserid","oihD","createUsername","4rDH","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","b0It","bizFlowState","R");
		XmProjectEnvList xmProjectEnvList5=BaseUtils.fromMap(p5,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList5);
		Map p6=BaseUtils.map("id","ZB1w","remark","11Km","ipAddress","akVS","port","07Hq","projectId","38J0","projectName","AoBM","accessUserid","qLoF","accessPassword","c4i4","effect","x1aM","accessUrl","1w88","webIpAddress","0qg1","webPort","F7y1","otherRemark","i9O0","createUserid","CV91","createUsername","nr6o","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","wic3","bizFlowState","K");
		XmProjectEnvList xmProjectEnvList6=BaseUtils.fromMap(p6,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList6);
		Map p7=BaseUtils.map("id","4Q89","remark","gkii","ipAddress","M1Rn","port","fMV7","projectId","7X4Y","projectName","92PF","accessUserid","5pM6","accessPassword","lRHX","effect","t6iI","accessUrl","Ju7Z","webIpAddress","IG5l","webPort","8fd0","otherRemark","7spL","createUserid","X981","createUsername","jL7A","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","AV8V","bizFlowState","9");
		XmProjectEnvList xmProjectEnvList7=BaseUtils.fromMap(p7,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList7);
		xmProjectEnvListService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmProjectEnvList> batchValues=new ArrayList<XmProjectEnvList>();
		Map p0=BaseUtils.map("id","0GKJ","remark","zT72","ipAddress","U1FK","port","1GZF","projectId","EWTf","projectName","c1OS","accessUserid","PJ71","accessPassword","7dpv","effect","2s0r","accessUrl","56Ws","webIpAddress","XCSX","webPort","i9DZ","otherRemark","DLSY","createUserid","rp8l","createUsername","EeBz","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","MJeo","bizFlowState","9");
		XmProjectEnvList xmProjectEnvList0=BaseUtils.fromMap(p0,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList0);
		Map p1=BaseUtils.map("id","7crK","remark","xB7r","ipAddress","84xC","port","HnYb","projectId","g342","projectName","6lT3","accessUserid","9mfA","accessPassword","o1m7","effect","H9Q8","accessUrl","EvNV","webIpAddress","xHAI","webPort","0G9z","otherRemark","wf2d","createUserid","FC79","createUsername","Qo2L","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","Gqwn","bizFlowState","m");
		XmProjectEnvList xmProjectEnvList1=BaseUtils.fromMap(p1,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList1);
		Map p2=BaseUtils.map("id","wGWa","remark","hPV2","ipAddress","542g","port","ucPI","projectId","72KP","projectName","qs4K","accessUserid","5cH0","accessPassword","UfTE","effect","m8T3","accessUrl","QsMZ","webIpAddress","w3RO","webPort","WT4J","otherRemark","ZsD2","createUserid","6xoY","createUsername","UPnz","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","0P5s","bizFlowState","9");
		XmProjectEnvList xmProjectEnvList2=BaseUtils.fromMap(p2,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList2);
		Map p3=BaseUtils.map("id","1EYY","remark","tBEr","ipAddress","WPz6","port","k860","projectId","9YOy","projectName","4U9t","accessUserid","oyaf","accessPassword","MWQ9","effect","5yp8","accessUrl","ceNK","webIpAddress","3emq","webPort","F5at","otherRemark","7YdW","createUserid","g8q5","createUsername","cOz7","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","y740","bizFlowState","5");
		XmProjectEnvList xmProjectEnvList3=BaseUtils.fromMap(p3,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList3);
		Map p4=BaseUtils.map("id","on93","remark","8g86","ipAddress","oCYO","port","V27Y","projectId","cwVP","projectName","82o1","accessUserid","CRFX","accessPassword","8Wm4","effect","h9e1","accessUrl","8mwp","webIpAddress","kiYT","webPort","4gyC","otherRemark","FAKT","createUserid","6r89","createUsername","83b4","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","USp7","bizFlowState","3");
		XmProjectEnvList xmProjectEnvList4=BaseUtils.fromMap(p4,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList4);
		Map p5=BaseUtils.map("id","s1xc","remark","z8Bb","ipAddress","5jZ6","port","13Aw","projectId","bgy3","projectName","trOR","accessUserid","5241","accessPassword","nlWo","effect","LS1s","accessUrl","dADc","webIpAddress","c284","webPort","I27L","otherRemark","bSRQ","createUserid","oihD","createUsername","4rDH","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","b0It","bizFlowState","R");
		XmProjectEnvList xmProjectEnvList5=BaseUtils.fromMap(p5,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList5);
		Map p6=BaseUtils.map("id","ZB1w","remark","11Km","ipAddress","akVS","port","07Hq","projectId","38J0","projectName","AoBM","accessUserid","qLoF","accessPassword","c4i4","effect","x1aM","accessUrl","1w88","webIpAddress","0qg1","webPort","F7y1","otherRemark","i9O0","createUserid","CV91","createUsername","nr6o","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","wic3","bizFlowState","K");
		XmProjectEnvList xmProjectEnvList6=BaseUtils.fromMap(p6,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList6);
		Map p7=BaseUtils.map("id","4Q89","remark","gkii","ipAddress","M1Rn","port","fMV7","projectId","7X4Y","projectName","92PF","accessUserid","5pM6","accessPassword","lRHX","effect","t6iI","accessUrl","Ju7Z","webIpAddress","IG5l","webPort","8fd0","otherRemark","7spL","createUserid","X981","createUsername","jL7A","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","AV8V","bizFlowState","9");
		XmProjectEnvList xmProjectEnvList7=BaseUtils.fromMap(p7,XmProjectEnvList.class);
		batchValues.add(xmProjectEnvList7);
		xmProjectEnvListService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","0GKJ");
		Map<String,Object> result=this.xmProjectEnvListService.selectOne(XmProjectEnvList.class.getName()+".selectOneMap",p);
		Assert.assertEquals("0GKJ", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("remark","zT72","ipAddress","U1FK","port","1GZF","projectId","EWTf","projectName","c1OS","accessUserid","PJ71","accessPassword","7dpv","effect","2s0r","accessUrl","56Ws","webIpAddress","XCSX","webPort","i9DZ","otherRemark","DLSY","createUserid","rp8l","createUsername","EeBz","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","MJeo","bizFlowState","9");
		XmProjectEnvList xmProjectEnvList=BaseUtils.fromMap(p,XmProjectEnvList.class);
		long result=xmProjectEnvListService.countByWhere(xmProjectEnvList);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("remark","zT72","ipAddress","U1FK","port","1GZF","projectId","EWTf","projectName","c1OS","accessUserid","PJ71","accessPassword","7dpv","effect","2s0r","accessUrl","56Ws","webIpAddress","XCSX","webPort","i9DZ","otherRemark","DLSY","createUserid","rp8l","createUsername","EeBz","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","MJeo","bizFlowState","9");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmProjectEnvList xmProjectEnvList=BaseUtils.fromMap(p,XmProjectEnvList.class);
		List<XmProjectEnvList> result=xmProjectEnvListService.selectListByWhere(xmProjectEnvList); 
		if(result instanceof Page) {
			Page page=(Page)result;   
			Assert.assertEquals(true, page.getTotal()>=0);
		}
	}
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByWhere() {
	
		
		Map<String,Object> p=BaseUtils.map("remark","zT72","ipAddress","U1FK","port","1GZF","projectId","EWTf","projectName","c1OS","accessUserid","PJ71","accessPassword","7dpv","effect","2s0r","accessUrl","56Ws","webIpAddress","XCSX","webPort","i9DZ","otherRemark","DLSY","createUserid","rp8l","createUsername","EeBz","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","MJeo","bizFlowState","9");
		XmProjectEnvList xmProjectEnvList=BaseUtils.fromMap(p,XmProjectEnvList.class);
		List<XmProjectEnvList> result=xmProjectEnvListService.selectListByWhere(xmProjectEnvList);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("remark","zT72","ipAddress","U1FK","port","1GZF","projectId","EWTf","projectName","c1OS","accessUserid","PJ71","accessPassword","7dpv","effect","2s0r","accessUrl","56Ws","webIpAddress","XCSX","webPort","i9DZ","otherRemark","DLSY","createUserid","rp8l","createUsername","EeBz","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","MJeo","bizFlowState","9");
		List<Map<String,Object>> result=xmProjectEnvListService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("remark","zT72","ipAddress","U1FK","port","1GZF","projectId","EWTf","projectName","c1OS","accessUserid","PJ71","accessPassword","7dpv","effect","2s0r","accessUrl","56Ws","webIpAddress","XCSX","webPort","i9DZ","otherRemark","DLSY","createUserid","rp8l","createUsername","EeBz","createTime",parse("2020-09-28 15:48:45"),"bizProcInstId","MJeo","bizFlowState","9");
		List<Map<String,Object>> result=xmProjectEnvListService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmProjectEnvList
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","0GKJ");
		
		XmProjectEnvList xmProjectEnvList1=BaseUtils.fromMap(p,XmProjectEnvList.class);
		XmProjectEnvList xmProjectEnvList=xmProjectEnvListService.selectOneObject(xmProjectEnvList1);
		Assert.assertEquals("0GKJ", xmProjectEnvList.getId());
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
