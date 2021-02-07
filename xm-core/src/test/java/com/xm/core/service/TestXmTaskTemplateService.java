package com.xm.core.service;

import java.util.*;
import java.text.SimpleDateFormat;

import com.xm.core.entity.XmTaskTemplate;
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
 * XmTaskTemplateService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_task_template xm_task_template<br>
 * 实体 XmTaskTemplate<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,name,parentTaskid,parentTaskname,projectId,projectName,level,sortLevel,preTaskid,preTaskname,startTime,endTime,milestone,description,remarks,createUserid,createUsername,createTime,rate,budgetCost,budgetWorkload,taskState,taskType,taskClass,toTaskCenter,projectPhaseId,projectPhaseName,taskSkillNames,taskSkillIds,taskOut,planType,settleSchemel,menuId,menuName;<br>
 * 当前表的所有字段名:<br>
 *	id,name,parent_taskid,parent_taskname,project_id,project_name,level,sort_level,pre_taskid,pre_taskname,start_time,end_time,milestone,description,remarks,create_userid,create_username,create_time,rate,budget_cost,budget_workload,task_state,task_type,task_class,to_task_center,project_phase_id,project_phase_name,task_skill_names,task_skill_ids,task_out,plan_type,settle_schemel,menu_id,menu_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmTaskTemplateService  {

	@Autowired
	XmTaskTemplateService xmTaskTemplateService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","oagr","name","k1vI","parentTaskid","D3aq","parentTaskname","80Td","projectId","UwcC","projectName","r25z","level","65Y5","sortLevel","02uJ","preTaskid","9oH9","preTaskname","dmP0","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","8vSo","description","8l8A","remarks","V6x7","createUserid","W52i","createUsername","GHZ7","createTime",parse("2020-11-05 12:30:38"),"rate",379,"budgetCost",6905.42,"budgetWorkload",7042.38,"taskState","V","taskType","oZ2f","taskClass","d","toTaskCenter","o","projectPhaseId","PV2b","projectPhaseName","hXO6","taskSkillNames","13Gs","taskSkillIds","jKAC","taskOut","d","planType","8Ga5","settleSchemel","3un2","menuId","leIE","menuName","3m63");
		XmTaskTemplate xmTaskTemplate=BaseUtils.fromMap(p,XmTaskTemplate.class);
		xmTaskTemplateService.insert(xmTaskTemplate);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("name","k1vI","parentTaskid","D3aq","parentTaskname","80Td","projectId","UwcC","projectName","r25z","level","65Y5","sortLevel","02uJ","preTaskid","9oH9","preTaskname","dmP0","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","8vSo","description","8l8A","remarks","V6x7","createUserid","W52i","createUsername","GHZ7","createTime",parse("2020-11-05 12:30:38"),"rate",379,"budgetCost",6905.42,"budgetWorkload",7042.38,"taskState","V","taskType","oZ2f","taskClass","d","toTaskCenter","o","projectPhaseId","PV2b","projectPhaseName","hXO6","taskSkillNames","13Gs","taskSkillIds","jKAC","taskOut","d","planType","8Ga5","settleSchemel","3un2","menuId","leIE","menuName","3m63");
		XmTaskTemplate xmTaskTemplate=BaseUtils.fromMap(p,XmTaskTemplate.class);
		xmTaskTemplateService.deleteByWhere(xmTaskTemplate);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","oagr");
		XmTaskTemplate xmTaskTemplate=BaseUtils.fromMap(p,XmTaskTemplate.class);
		xmTaskTemplateService.deleteByPk(xmTaskTemplate);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("name","k1vI","parentTaskid","D3aq","parentTaskname","80Td","projectId","UwcC","projectName","r25z","level","65Y5","sortLevel","02uJ","preTaskid","9oH9","preTaskname","dmP0","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","8vSo","description","8l8A","remarks","V6x7","createUserid","W52i","createUsername","GHZ7","createTime",parse("2020-11-05 12:30:38"),"rate",379,"budgetCost",6905.42,"budgetWorkload",7042.38,"taskState","V","taskType","oZ2f","taskClass","d","toTaskCenter","o","projectPhaseId","PV2b","projectPhaseName","hXO6","taskSkillNames","13Gs","taskSkillIds","jKAC","taskOut","d","planType","8Ga5","settleSchemel","3un2","menuId","leIE","menuName","3m63");
		XmTaskTemplate xmTaskTemplate=BaseUtils.fromMap(where,XmTaskTemplate.class);
		xmTaskTemplateService.updateSomeFieldByPk(xmTaskTemplate);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","oagr");
		XmTaskTemplate xmTaskTemplate=BaseUtils.fromMap(p,XmTaskTemplate.class);
		xmTaskTemplateService.updateByPk(xmTaskTemplate);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("id","oagr","name","k1vI","parentTaskid","D3aq","parentTaskname","80Td","projectId","UwcC","projectName","r25z","level","65Y5","sortLevel","02uJ","preTaskid","9oH9","preTaskname","dmP0","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","8vSo","description","8l8A","remarks","V6x7","createUserid","W52i","createUsername","GHZ7","createTime",parse("2020-11-05 12:30:38"),"rate",379,"budgetCost",6905.42,"budgetWorkload",7042.38,"taskState","V","taskType","oZ2f","taskClass","d","toTaskCenter","o","projectPhaseId","PV2b","projectPhaseName","hXO6","taskSkillNames","13Gs","taskSkillIds","jKAC","taskOut","d","planType","8Ga5","settleSchemel","3un2","menuId","leIE","menuName","3m63");
		XmTaskTemplate xmTaskTemplate=BaseUtils.fromMap(p,XmTaskTemplate.class);
		xmTaskTemplateService.insertOrUpdate(xmTaskTemplate);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmTaskTemplate> batchValues=new ArrayList<XmTaskTemplate>();
		Map p0=BaseUtils.map("id","oagr","name","k1vI","parentTaskid","D3aq","parentTaskname","80Td","projectId","UwcC","projectName","r25z","level","65Y5","sortLevel","02uJ","preTaskid","9oH9","preTaskname","dmP0","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","8vSo","description","8l8A","remarks","V6x7","createUserid","W52i","createUsername","GHZ7","createTime",parse("2020-11-05 12:30:38"),"rate",379,"budgetCost",6905.42,"budgetWorkload",7042.38,"taskState","V","taskType","oZ2f","taskClass","d","toTaskCenter","o","projectPhaseId","PV2b","projectPhaseName","hXO6","taskSkillNames","13Gs","taskSkillIds","jKAC","taskOut","d","planType","8Ga5","settleSchemel","3un2","menuId","leIE","menuName","3m63");
		XmTaskTemplate xmTaskTemplate0=BaseUtils.fromMap(p0,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate0);
		Map p1=BaseUtils.map("id","DpCY","name","ONg0","parentTaskid","B9oa","parentTaskname","dJji","projectId","j33p","projectName","zR2o","level","oMxh","sortLevel","Ri05","preTaskid","FmFt","preTaskname","V8iD","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","WHr4","description","vuBi","remarks","P50R","createUserid","CD1v","createUsername","enN7","createTime",parse("2020-11-05 12:30:38"),"rate",8635,"budgetCost",6789.57,"budgetWorkload",7243.24,"taskState","9","taskType","ydY1","taskClass","5","toTaskCenter","0","projectPhaseId","9zSF","projectPhaseName","J6NT","taskSkillNames","PzOd","taskSkillIds","s8LE","taskOut","S","planType","ac8y","settleSchemel","mlmI","menuId","6d9l","menuName","C794");
		XmTaskTemplate xmTaskTemplate1=BaseUtils.fromMap(p1,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate1);
		Map p2=BaseUtils.map("id","y585","name","8Tp4","parentTaskid","Q5GR","parentTaskname","7h8T","projectId","kFQu","projectName","9yTw","level","oPYy","sortLevel","XgGv","preTaskid","X2pp","preTaskname","8skh","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","O4Ul","description","4nL6","remarks","8IyB","createUserid","C675","createUsername","aa58","createTime",parse("2020-11-05 12:30:38"),"rate",7655,"budgetCost",1043.16,"budgetWorkload",2191.55,"taskState","O","taskType","fL0i","taskClass","n","toTaskCenter","O","projectPhaseId","4gp9","projectPhaseName","mb36","taskSkillNames","8YTc","taskSkillIds","2QYL","taskOut","k","planType","LgVc","settleSchemel","mn9J","menuId","nqeO","menuName","IcYA");
		XmTaskTemplate xmTaskTemplate2=BaseUtils.fromMap(p2,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate2);
		Map p3=BaseUtils.map("id","zFGJ","name","8Otp","parentTaskid","8kwR","parentTaskname","zKYy","projectId","yWdV","projectName","a01i","level","15ai","sortLevel","QzCb","preTaskid","Opki","preTaskname","7oJ0","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","w32f","description","R89n","remarks","c7uv","createUserid","Dxt7","createUsername","Lj8X","createTime",parse("2020-11-05 12:30:38"),"rate",233,"budgetCost",3700.72,"budgetWorkload",3366.72,"taskState","I","taskType","NQa3","taskClass","8","toTaskCenter","R","projectPhaseId","XdiT","projectPhaseName","tSVG","taskSkillNames","5w2G","taskSkillIds","5Fyg","taskOut","w","planType","w6Vm","settleSchemel","GZRF","menuId","IlGJ","menuName","FgB1");
		XmTaskTemplate xmTaskTemplate3=BaseUtils.fromMap(p3,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate3);
		Map p4=BaseUtils.map("id","YB37","name","H4Xw","parentTaskid","80S6","parentTaskname","CW7p","projectId","82Do","projectName","SVc4","level","ucwj","sortLevel","l4hm","preTaskid","l0Sl","preTaskname","c2pT","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","h6YI","description","ZoR8","remarks","pk1q","createUserid","05ix","createUsername","vphm","createTime",parse("2020-11-05 12:30:38"),"rate",584,"budgetCost",4570.78,"budgetWorkload",1867.79,"taskState","2","taskType","AhV9","taskClass","K","toTaskCenter","W","projectPhaseId","6Ubc","projectPhaseName","V1f5","taskSkillNames","UK4L","taskSkillIds","J4G1","taskOut","O","planType","86F8","settleSchemel","5W31","menuId","71HO","menuName","Rfb4");
		XmTaskTemplate xmTaskTemplate4=BaseUtils.fromMap(p4,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate4);
		Map p5=BaseUtils.map("id","nkUh","name","oyIO","parentTaskid","m1g3","parentTaskname","4740","projectId","4br2","projectName","vTIW","level","jZ6E","sortLevel","y2Le","preTaskid","FYew","preTaskname","YQGO","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","AP33","description","BOPa","remarks","4Nae","createUserid","Cd84","createUsername","kvR2","createTime",parse("2020-11-05 12:30:38"),"rate",4556,"budgetCost",779.97,"budgetWorkload",1934,"taskState","V","taskType","F4nZ","taskClass","u","toTaskCenter","6","projectPhaseId","AL33","projectPhaseName","6kwn","taskSkillNames","1jeC","taskSkillIds","3T30","taskOut","Y","planType","kbW8","settleSchemel","8DEO","menuId","4ZFb","menuName","37IL");
		XmTaskTemplate xmTaskTemplate5=BaseUtils.fromMap(p5,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate5);
		Map p6=BaseUtils.map("id","cfay","name","zdq1","parentTaskid","7v4c","parentTaskname","mwuX","projectId","21yx","projectName","0vdE","level","pMqk","sortLevel","bQik","preTaskid","2GuX","preTaskname","S08J","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","EFnr","description","FaeS","remarks","Efg8","createUserid","udpH","createUsername","TeFh","createTime",parse("2020-11-05 12:30:38"),"rate",2131,"budgetCost",9413.11,"budgetWorkload",9172.5,"taskState","c","taskType","WX99","taskClass","1","toTaskCenter","D","projectPhaseId","Zz5T","projectPhaseName","pz33","taskSkillNames","FVIF","taskSkillIds","Cvf0","taskOut","P","planType","atiM","settleSchemel","51XS","menuId","Vplp","menuName","n6Ih");
		XmTaskTemplate xmTaskTemplate6=BaseUtils.fromMap(p6,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate6);
		Map p7=BaseUtils.map("id","3k83","name","4Mo9","parentTaskid","ppRd","parentTaskname","2t7R","projectId","z353","projectName","W2L0","level","dUB4","sortLevel","5Hsi","preTaskid","A1nk","preTaskname","VLR5","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","jidz","description","Wqh5","remarks","05g9","createUserid","r2ke","createUsername","S18t","createTime",parse("2020-11-05 12:30:38"),"rate",8925,"budgetCost",5804.87,"budgetWorkload",8125.48,"taskState","0","taskType","pR0l","taskClass","F","toTaskCenter","P","projectPhaseId","ahEk","projectPhaseName","UfuG","taskSkillNames","uO7s","taskSkillIds","98FW","taskOut","v","planType","m1ao","settleSchemel","Eijb","menuId","nQyc","menuName","nB86");
		XmTaskTemplate xmTaskTemplate7=BaseUtils.fromMap(p7,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate7);
		xmTaskTemplateService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmTaskTemplate> batchValues=new ArrayList<XmTaskTemplate>();
		Map p0=BaseUtils.map("id","oagr","name","k1vI","parentTaskid","D3aq","parentTaskname","80Td","projectId","UwcC","projectName","r25z","level","65Y5","sortLevel","02uJ","preTaskid","9oH9","preTaskname","dmP0","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","8vSo","description","8l8A","remarks","V6x7","createUserid","W52i","createUsername","GHZ7","createTime",parse("2020-11-05 12:30:38"),"rate",379,"budgetCost",6905.42,"budgetWorkload",7042.38,"taskState","V","taskType","oZ2f","taskClass","d","toTaskCenter","o","projectPhaseId","PV2b","projectPhaseName","hXO6","taskSkillNames","13Gs","taskSkillIds","jKAC","taskOut","d","planType","8Ga5","settleSchemel","3un2","menuId","leIE","menuName","3m63");
		XmTaskTemplate xmTaskTemplate0=BaseUtils.fromMap(p0,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate0);
		Map p1=BaseUtils.map("id","DpCY","name","ONg0","parentTaskid","B9oa","parentTaskname","dJji","projectId","j33p","projectName","zR2o","level","oMxh","sortLevel","Ri05","preTaskid","FmFt","preTaskname","V8iD","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","WHr4","description","vuBi","remarks","P50R","createUserid","CD1v","createUsername","enN7","createTime",parse("2020-11-05 12:30:38"),"rate",8635,"budgetCost",6789.57,"budgetWorkload",7243.24,"taskState","9","taskType","ydY1","taskClass","5","toTaskCenter","0","projectPhaseId","9zSF","projectPhaseName","J6NT","taskSkillNames","PzOd","taskSkillIds","s8LE","taskOut","S","planType","ac8y","settleSchemel","mlmI","menuId","6d9l","menuName","C794");
		XmTaskTemplate xmTaskTemplate1=BaseUtils.fromMap(p1,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate1);
		Map p2=BaseUtils.map("id","y585","name","8Tp4","parentTaskid","Q5GR","parentTaskname","7h8T","projectId","kFQu","projectName","9yTw","level","oPYy","sortLevel","XgGv","preTaskid","X2pp","preTaskname","8skh","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","O4Ul","description","4nL6","remarks","8IyB","createUserid","C675","createUsername","aa58","createTime",parse("2020-11-05 12:30:38"),"rate",7655,"budgetCost",1043.16,"budgetWorkload",2191.55,"taskState","O","taskType","fL0i","taskClass","n","toTaskCenter","O","projectPhaseId","4gp9","projectPhaseName","mb36","taskSkillNames","8YTc","taskSkillIds","2QYL","taskOut","k","planType","LgVc","settleSchemel","mn9J","menuId","nqeO","menuName","IcYA");
		XmTaskTemplate xmTaskTemplate2=BaseUtils.fromMap(p2,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate2);
		Map p3=BaseUtils.map("id","zFGJ","name","8Otp","parentTaskid","8kwR","parentTaskname","zKYy","projectId","yWdV","projectName","a01i","level","15ai","sortLevel","QzCb","preTaskid","Opki","preTaskname","7oJ0","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","w32f","description","R89n","remarks","c7uv","createUserid","Dxt7","createUsername","Lj8X","createTime",parse("2020-11-05 12:30:38"),"rate",233,"budgetCost",3700.72,"budgetWorkload",3366.72,"taskState","I","taskType","NQa3","taskClass","8","toTaskCenter","R","projectPhaseId","XdiT","projectPhaseName","tSVG","taskSkillNames","5w2G","taskSkillIds","5Fyg","taskOut","w","planType","w6Vm","settleSchemel","GZRF","menuId","IlGJ","menuName","FgB1");
		XmTaskTemplate xmTaskTemplate3=BaseUtils.fromMap(p3,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate3);
		Map p4=BaseUtils.map("id","YB37","name","H4Xw","parentTaskid","80S6","parentTaskname","CW7p","projectId","82Do","projectName","SVc4","level","ucwj","sortLevel","l4hm","preTaskid","l0Sl","preTaskname","c2pT","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","h6YI","description","ZoR8","remarks","pk1q","createUserid","05ix","createUsername","vphm","createTime",parse("2020-11-05 12:30:38"),"rate",584,"budgetCost",4570.78,"budgetWorkload",1867.79,"taskState","2","taskType","AhV9","taskClass","K","toTaskCenter","W","projectPhaseId","6Ubc","projectPhaseName","V1f5","taskSkillNames","UK4L","taskSkillIds","J4G1","taskOut","O","planType","86F8","settleSchemel","5W31","menuId","71HO","menuName","Rfb4");
		XmTaskTemplate xmTaskTemplate4=BaseUtils.fromMap(p4,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate4);
		Map p5=BaseUtils.map("id","nkUh","name","oyIO","parentTaskid","m1g3","parentTaskname","4740","projectId","4br2","projectName","vTIW","level","jZ6E","sortLevel","y2Le","preTaskid","FYew","preTaskname","YQGO","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","AP33","description","BOPa","remarks","4Nae","createUserid","Cd84","createUsername","kvR2","createTime",parse("2020-11-05 12:30:38"),"rate",4556,"budgetCost",779.97,"budgetWorkload",1934,"taskState","V","taskType","F4nZ","taskClass","u","toTaskCenter","6","projectPhaseId","AL33","projectPhaseName","6kwn","taskSkillNames","1jeC","taskSkillIds","3T30","taskOut","Y","planType","kbW8","settleSchemel","8DEO","menuId","4ZFb","menuName","37IL");
		XmTaskTemplate xmTaskTemplate5=BaseUtils.fromMap(p5,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate5);
		Map p6=BaseUtils.map("id","cfay","name","zdq1","parentTaskid","7v4c","parentTaskname","mwuX","projectId","21yx","projectName","0vdE","level","pMqk","sortLevel","bQik","preTaskid","2GuX","preTaskname","S08J","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","EFnr","description","FaeS","remarks","Efg8","createUserid","udpH","createUsername","TeFh","createTime",parse("2020-11-05 12:30:38"),"rate",2131,"budgetCost",9413.11,"budgetWorkload",9172.5,"taskState","c","taskType","WX99","taskClass","1","toTaskCenter","D","projectPhaseId","Zz5T","projectPhaseName","pz33","taskSkillNames","FVIF","taskSkillIds","Cvf0","taskOut","P","planType","atiM","settleSchemel","51XS","menuId","Vplp","menuName","n6Ih");
		XmTaskTemplate xmTaskTemplate6=BaseUtils.fromMap(p6,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate6);
		Map p7=BaseUtils.map("id","3k83","name","4Mo9","parentTaskid","ppRd","parentTaskname","2t7R","projectId","z353","projectName","W2L0","level","dUB4","sortLevel","5Hsi","preTaskid","A1nk","preTaskname","VLR5","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","jidz","description","Wqh5","remarks","05g9","createUserid","r2ke","createUsername","S18t","createTime",parse("2020-11-05 12:30:38"),"rate",8925,"budgetCost",5804.87,"budgetWorkload",8125.48,"taskState","0","taskType","pR0l","taskClass","F","toTaskCenter","P","projectPhaseId","ahEk","projectPhaseName","UfuG","taskSkillNames","uO7s","taskSkillIds","98FW","taskOut","v","planType","m1ao","settleSchemel","Eijb","menuId","nQyc","menuName","nB86");
		XmTaskTemplate xmTaskTemplate7=BaseUtils.fromMap(p7,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate7);
		xmTaskTemplateService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmTaskTemplate> batchValues=new ArrayList<XmTaskTemplate>();
		Map p0=BaseUtils.map("id","oagr","name","k1vI","parentTaskid","D3aq","parentTaskname","80Td","projectId","UwcC","projectName","r25z","level","65Y5","sortLevel","02uJ","preTaskid","9oH9","preTaskname","dmP0","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","8vSo","description","8l8A","remarks","V6x7","createUserid","W52i","createUsername","GHZ7","createTime",parse("2020-11-05 12:30:38"),"rate",379,"budgetCost",6905.42,"budgetWorkload",7042.38,"taskState","V","taskType","oZ2f","taskClass","d","toTaskCenter","o","projectPhaseId","PV2b","projectPhaseName","hXO6","taskSkillNames","13Gs","taskSkillIds","jKAC","taskOut","d","planType","8Ga5","settleSchemel","3un2","menuId","leIE","menuName","3m63");
		XmTaskTemplate xmTaskTemplate0=BaseUtils.fromMap(p0,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate0);
		Map p1=BaseUtils.map("id","DpCY","name","ONg0","parentTaskid","B9oa","parentTaskname","dJji","projectId","j33p","projectName","zR2o","level","oMxh","sortLevel","Ri05","preTaskid","FmFt","preTaskname","V8iD","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","WHr4","description","vuBi","remarks","P50R","createUserid","CD1v","createUsername","enN7","createTime",parse("2020-11-05 12:30:38"),"rate",8635,"budgetCost",6789.57,"budgetWorkload",7243.24,"taskState","9","taskType","ydY1","taskClass","5","toTaskCenter","0","projectPhaseId","9zSF","projectPhaseName","J6NT","taskSkillNames","PzOd","taskSkillIds","s8LE","taskOut","S","planType","ac8y","settleSchemel","mlmI","menuId","6d9l","menuName","C794");
		XmTaskTemplate xmTaskTemplate1=BaseUtils.fromMap(p1,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate1);
		Map p2=BaseUtils.map("id","y585","name","8Tp4","parentTaskid","Q5GR","parentTaskname","7h8T","projectId","kFQu","projectName","9yTw","level","oPYy","sortLevel","XgGv","preTaskid","X2pp","preTaskname","8skh","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","O4Ul","description","4nL6","remarks","8IyB","createUserid","C675","createUsername","aa58","createTime",parse("2020-11-05 12:30:38"),"rate",7655,"budgetCost",1043.16,"budgetWorkload",2191.55,"taskState","O","taskType","fL0i","taskClass","n","toTaskCenter","O","projectPhaseId","4gp9","projectPhaseName","mb36","taskSkillNames","8YTc","taskSkillIds","2QYL","taskOut","k","planType","LgVc","settleSchemel","mn9J","menuId","nqeO","menuName","IcYA");
		XmTaskTemplate xmTaskTemplate2=BaseUtils.fromMap(p2,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate2);
		Map p3=BaseUtils.map("id","zFGJ","name","8Otp","parentTaskid","8kwR","parentTaskname","zKYy","projectId","yWdV","projectName","a01i","level","15ai","sortLevel","QzCb","preTaskid","Opki","preTaskname","7oJ0","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","w32f","description","R89n","remarks","c7uv","createUserid","Dxt7","createUsername","Lj8X","createTime",parse("2020-11-05 12:30:38"),"rate",233,"budgetCost",3700.72,"budgetWorkload",3366.72,"taskState","I","taskType","NQa3","taskClass","8","toTaskCenter","R","projectPhaseId","XdiT","projectPhaseName","tSVG","taskSkillNames","5w2G","taskSkillIds","5Fyg","taskOut","w","planType","w6Vm","settleSchemel","GZRF","menuId","IlGJ","menuName","FgB1");
		XmTaskTemplate xmTaskTemplate3=BaseUtils.fromMap(p3,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate3);
		Map p4=BaseUtils.map("id","YB37","name","H4Xw","parentTaskid","80S6","parentTaskname","CW7p","projectId","82Do","projectName","SVc4","level","ucwj","sortLevel","l4hm","preTaskid","l0Sl","preTaskname","c2pT","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","h6YI","description","ZoR8","remarks","pk1q","createUserid","05ix","createUsername","vphm","createTime",parse("2020-11-05 12:30:38"),"rate",584,"budgetCost",4570.78,"budgetWorkload",1867.79,"taskState","2","taskType","AhV9","taskClass","K","toTaskCenter","W","projectPhaseId","6Ubc","projectPhaseName","V1f5","taskSkillNames","UK4L","taskSkillIds","J4G1","taskOut","O","planType","86F8","settleSchemel","5W31","menuId","71HO","menuName","Rfb4");
		XmTaskTemplate xmTaskTemplate4=BaseUtils.fromMap(p4,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate4);
		Map p5=BaseUtils.map("id","nkUh","name","oyIO","parentTaskid","m1g3","parentTaskname","4740","projectId","4br2","projectName","vTIW","level","jZ6E","sortLevel","y2Le","preTaskid","FYew","preTaskname","YQGO","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","AP33","description","BOPa","remarks","4Nae","createUserid","Cd84","createUsername","kvR2","createTime",parse("2020-11-05 12:30:38"),"rate",4556,"budgetCost",779.97,"budgetWorkload",1934,"taskState","V","taskType","F4nZ","taskClass","u","toTaskCenter","6","projectPhaseId","AL33","projectPhaseName","6kwn","taskSkillNames","1jeC","taskSkillIds","3T30","taskOut","Y","planType","kbW8","settleSchemel","8DEO","menuId","4ZFb","menuName","37IL");
		XmTaskTemplate xmTaskTemplate5=BaseUtils.fromMap(p5,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate5);
		Map p6=BaseUtils.map("id","cfay","name","zdq1","parentTaskid","7v4c","parentTaskname","mwuX","projectId","21yx","projectName","0vdE","level","pMqk","sortLevel","bQik","preTaskid","2GuX","preTaskname","S08J","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","EFnr","description","FaeS","remarks","Efg8","createUserid","udpH","createUsername","TeFh","createTime",parse("2020-11-05 12:30:38"),"rate",2131,"budgetCost",9413.11,"budgetWorkload",9172.5,"taskState","c","taskType","WX99","taskClass","1","toTaskCenter","D","projectPhaseId","Zz5T","projectPhaseName","pz33","taskSkillNames","FVIF","taskSkillIds","Cvf0","taskOut","P","planType","atiM","settleSchemel","51XS","menuId","Vplp","menuName","n6Ih");
		XmTaskTemplate xmTaskTemplate6=BaseUtils.fromMap(p6,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate6);
		Map p7=BaseUtils.map("id","3k83","name","4Mo9","parentTaskid","ppRd","parentTaskname","2t7R","projectId","z353","projectName","W2L0","level","dUB4","sortLevel","5Hsi","preTaskid","A1nk","preTaskname","VLR5","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","jidz","description","Wqh5","remarks","05g9","createUserid","r2ke","createUsername","S18t","createTime",parse("2020-11-05 12:30:38"),"rate",8925,"budgetCost",5804.87,"budgetWorkload",8125.48,"taskState","0","taskType","pR0l","taskClass","F","toTaskCenter","P","projectPhaseId","ahEk","projectPhaseName","UfuG","taskSkillNames","uO7s","taskSkillIds","98FW","taskOut","v","planType","m1ao","settleSchemel","Eijb","menuId","nQyc","menuName","nB86");
		XmTaskTemplate xmTaskTemplate7=BaseUtils.fromMap(p7,XmTaskTemplate.class);
		batchValues.add(xmTaskTemplate7);
		xmTaskTemplateService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","oagr");
		Map<String,Object> result=this.xmTaskTemplateService.selectOne(XmTaskTemplate.class.getName()+".selectOneMap",p);
		Assert.assertEquals("oagr", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("name","k1vI","parentTaskid","D3aq","parentTaskname","80Td","projectId","UwcC","projectName","r25z","level","65Y5","sortLevel","02uJ","preTaskid","9oH9","preTaskname","dmP0","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","8vSo","description","8l8A","remarks","V6x7","createUserid","W52i","createUsername","GHZ7","createTime",parse("2020-11-05 12:30:38"),"rate",379,"budgetCost",6905.42,"budgetWorkload",7042.38,"taskState","V","taskType","oZ2f","taskClass","d","toTaskCenter","o","projectPhaseId","PV2b","projectPhaseName","hXO6","taskSkillNames","13Gs","taskSkillIds","jKAC","taskOut","d","planType","8Ga5","settleSchemel","3un2","menuId","leIE","menuName","3m63");
		XmTaskTemplate xmTaskTemplate=BaseUtils.fromMap(p,XmTaskTemplate.class);
		long result=xmTaskTemplateService.countByWhere(xmTaskTemplate);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("name","k1vI","parentTaskid","D3aq","parentTaskname","80Td","projectId","UwcC","projectName","r25z","level","65Y5","sortLevel","02uJ","preTaskid","9oH9","preTaskname","dmP0","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","8vSo","description","8l8A","remarks","V6x7","createUserid","W52i","createUsername","GHZ7","createTime",parse("2020-11-05 12:30:38"),"rate",379,"budgetCost",6905.42,"budgetWorkload",7042.38,"taskState","V","taskType","oZ2f","taskClass","d","toTaskCenter","o","projectPhaseId","PV2b","projectPhaseName","hXO6","taskSkillNames","13Gs","taskSkillIds","jKAC","taskOut","d","planType","8Ga5","settleSchemel","3un2","menuId","leIE","menuName","3m63");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmTaskTemplate xmTaskTemplate=BaseUtils.fromMap(p,XmTaskTemplate.class);
		List<XmTaskTemplate> result=xmTaskTemplateService.selectListByWhere(xmTaskTemplate); 
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
	
		
		Map<String,Object> p=BaseUtils.map("name","k1vI","parentTaskid","D3aq","parentTaskname","80Td","projectId","UwcC","projectName","r25z","level","65Y5","sortLevel","02uJ","preTaskid","9oH9","preTaskname","dmP0","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","8vSo","description","8l8A","remarks","V6x7","createUserid","W52i","createUsername","GHZ7","createTime",parse("2020-11-05 12:30:38"),"rate",379,"budgetCost",6905.42,"budgetWorkload",7042.38,"taskState","V","taskType","oZ2f","taskClass","d","toTaskCenter","o","projectPhaseId","PV2b","projectPhaseName","hXO6","taskSkillNames","13Gs","taskSkillIds","jKAC","taskOut","d","planType","8Ga5","settleSchemel","3un2","menuId","leIE","menuName","3m63");
		XmTaskTemplate xmTaskTemplate=BaseUtils.fromMap(p,XmTaskTemplate.class);
		List<XmTaskTemplate> result=xmTaskTemplateService.selectListByWhere(xmTaskTemplate);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("name","k1vI","parentTaskid","D3aq","parentTaskname","80Td","projectId","UwcC","projectName","r25z","level","65Y5","sortLevel","02uJ","preTaskid","9oH9","preTaskname","dmP0","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","8vSo","description","8l8A","remarks","V6x7","createUserid","W52i","createUsername","GHZ7","createTime",parse("2020-11-05 12:30:38"),"rate",379,"budgetCost",6905.42,"budgetWorkload",7042.38,"taskState","V","taskType","oZ2f","taskClass","d","toTaskCenter","o","projectPhaseId","PV2b","projectPhaseName","hXO6","taskSkillNames","13Gs","taskSkillIds","jKAC","taskOut","d","planType","8Ga5","settleSchemel","3un2","menuId","leIE","menuName","3m63");
		List<Map<String,Object>> result=xmTaskTemplateService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("name","k1vI","parentTaskid","D3aq","parentTaskname","80Td","projectId","UwcC","projectName","r25z","level","65Y5","sortLevel","02uJ","preTaskid","9oH9","preTaskname","dmP0","startTime",parse("2020-11-05 12:30:38"),"endTime",parse("2020-11-05 12:30:38"),"milestone","8vSo","description","8l8A","remarks","V6x7","createUserid","W52i","createUsername","GHZ7","createTime",parse("2020-11-05 12:30:38"),"rate",379,"budgetCost",6905.42,"budgetWorkload",7042.38,"taskState","V","taskType","oZ2f","taskClass","d","toTaskCenter","o","projectPhaseId","PV2b","projectPhaseName","hXO6","taskSkillNames","13Gs","taskSkillIds","jKAC","taskOut","d","planType","8Ga5","settleSchemel","3un2","menuId","leIE","menuName","3m63");
		List<Map<String,Object>> result=xmTaskTemplateService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmTaskTemplate
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","oagr");
		
		XmTaskTemplate xmTaskTemplate1=BaseUtils.fromMap(p,XmTaskTemplate.class);
		XmTaskTemplate xmTaskTemplate=xmTaskTemplateService.selectOneObject(xmTaskTemplate1);
		Assert.assertEquals("oagr", xmTaskTemplate.getId());
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
