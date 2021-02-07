package com.xm.core.service;

import java.util.*;
import java.text.SimpleDateFormat;

import com.xm.core.entity.XmTask;
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
 * XmTaskService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_task xm_task<br>
 * 实体 XmTask<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,name,parentTaskid,parentTaskname,projectId,projectName,level,sortLevel,executorUserid,executorUsername,preTaskid,preTaskname,startTime,endTime,milestone,description,remarks,createUserid,createUsername,createTime,rate,budgetCost,budgetWorkload,actCost,actWorkload,taskState,taskType,taskClass,toTaskCenter,actStartTime,actEndTime,bizProcInstId,bizFlowState,projectPhaseId,projectPhaseName,taskSkillNames,exeUsernames,taskSkillIds,exeUserids,taskOut,planType,settleSchemel,menuId,menuName,iterationId,iterationName,productId,productName;<br>
 * 当前表的所有字段名:<br>
 *	id,name,parent_taskid,parent_taskname,project_id,project_name,level,sort_level,executor_userid,executor_username,pre_taskid,pre_taskname,start_time,end_time,milestone,description,remarks,create_userid,create_username,create_time,rate,budget_cost,budget_workload,act_cost,act_workload,task_state,task_type,task_class,to_task_center,act_start_time,act_end_time,biz_proc_inst_id,biz_flow_state,project_phase_id,project_phase_name,task_skill_names,exe_usernames,task_skill_ids,exe_userids,task_out,plan_type,settle_schemel,menu_id,menu_name,iteration_id,iteration_name,product_id,product_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmTaskService  {

	@Autowired
	XmTaskService xmTaskService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","Gq2X","name","9dPl","parentTaskid","H22g","parentTaskname","oNQT","projectId","Yo4Z","projectName","gnsR","level","yVKJ","sortLevel","F9Rs","executorUserid","4oK4","executorUsername","Q7Mt","preTaskid","cOkY","preTaskname","3xOF","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","XVI5","description","ShzP","remarks","Li2V","createUserid","Hz05","createUsername","iEli","createTime",parse("2020-11-12 2:0:58"),"rate",5135,"budgetCost",8627.51,"budgetWorkload",6380.18,"actCost",8910.73,"actWorkload",5205.25,"taskState","2","taskType","12lB","taskClass","2","toTaskCenter","a","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","qcvj","bizFlowState","G","projectPhaseId","2Okh","projectPhaseName","j07G","taskSkillNames","41tr","exeUsernames","wG42","taskSkillIds","oBbs","exeUserids","e8xQ","taskOut","s","planType","Bbm8","settleSchemel","bJpz","menuId","q672","menuName","6kCz","iterationId","hO01","iterationName","AHJZ","productId","J6Vk","productName","X8qk");
		XmTask xmTask=BaseUtils.fromMap(p,XmTask.class);
		xmTaskService.insert(xmTask);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("name","9dPl","parentTaskid","H22g","parentTaskname","oNQT","projectId","Yo4Z","projectName","gnsR","level","yVKJ","sortLevel","F9Rs","executorUserid","4oK4","executorUsername","Q7Mt","preTaskid","cOkY","preTaskname","3xOF","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","XVI5","description","ShzP","remarks","Li2V","createUserid","Hz05","createUsername","iEli","createTime",parse("2020-11-12 2:0:58"),"rate",5135,"budgetCost",8627.51,"budgetWorkload",6380.18,"actCost",8910.73,"actWorkload",5205.25,"taskState","2","taskType","12lB","taskClass","2","toTaskCenter","a","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","qcvj","bizFlowState","G","projectPhaseId","2Okh","projectPhaseName","j07G","taskSkillNames","41tr","exeUsernames","wG42","taskSkillIds","oBbs","exeUserids","e8xQ","taskOut","s","planType","Bbm8","settleSchemel","bJpz","menuId","q672","menuName","6kCz","iterationId","hO01","iterationName","AHJZ","productId","J6Vk","productName","X8qk");
		XmTask xmTask=BaseUtils.fromMap(p,XmTask.class);
		xmTaskService.deleteByWhere(xmTask);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","Gq2X");
		XmTask xmTask=BaseUtils.fromMap(p,XmTask.class);
		xmTaskService.deleteByPk(xmTask);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("name","9dPl","parentTaskid","H22g","parentTaskname","oNQT","projectId","Yo4Z","projectName","gnsR","level","yVKJ","sortLevel","F9Rs","executorUserid","4oK4","executorUsername","Q7Mt","preTaskid","cOkY","preTaskname","3xOF","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","XVI5","description","ShzP","remarks","Li2V","createUserid","Hz05","createUsername","iEli","createTime",parse("2020-11-12 2:0:58"),"rate",5135,"budgetCost",8627.51,"budgetWorkload",6380.18,"actCost",8910.73,"actWorkload",5205.25,"taskState","2","taskType","12lB","taskClass","2","toTaskCenter","a","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","qcvj","bizFlowState","G","projectPhaseId","2Okh","projectPhaseName","j07G","taskSkillNames","41tr","exeUsernames","wG42","taskSkillIds","oBbs","exeUserids","e8xQ","taskOut","s","planType","Bbm8","settleSchemel","bJpz","menuId","q672","menuName","6kCz","iterationId","hO01","iterationName","AHJZ","productId","J6Vk","productName","X8qk");
		XmTask xmTask=BaseUtils.fromMap(where,XmTask.class);
		xmTaskService.updateSomeFieldByPk(xmTask);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","Gq2X");
		XmTask xmTask=BaseUtils.fromMap(p,XmTask.class);
		xmTaskService.updateByPk(xmTask);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("id","Gq2X","name","9dPl","parentTaskid","H22g","parentTaskname","oNQT","projectId","Yo4Z","projectName","gnsR","level","yVKJ","sortLevel","F9Rs","executorUserid","4oK4","executorUsername","Q7Mt","preTaskid","cOkY","preTaskname","3xOF","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","XVI5","description","ShzP","remarks","Li2V","createUserid","Hz05","createUsername","iEli","createTime",parse("2020-11-12 2:0:58"),"rate",5135,"budgetCost",8627.51,"budgetWorkload",6380.18,"actCost",8910.73,"actWorkload",5205.25,"taskState","2","taskType","12lB","taskClass","2","toTaskCenter","a","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","qcvj","bizFlowState","G","projectPhaseId","2Okh","projectPhaseName","j07G","taskSkillNames","41tr","exeUsernames","wG42","taskSkillIds","oBbs","exeUserids","e8xQ","taskOut","s","planType","Bbm8","settleSchemel","bJpz","menuId","q672","menuName","6kCz","iterationId","hO01","iterationName","AHJZ","productId","J6Vk","productName","X8qk");
		XmTask xmTask=BaseUtils.fromMap(p,XmTask.class);
		xmTaskService.insertOrUpdate(xmTask);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmTask> batchValues=new ArrayList<XmTask>();
		Map p0=BaseUtils.map("id","Gq2X","name","9dPl","parentTaskid","H22g","parentTaskname","oNQT","projectId","Yo4Z","projectName","gnsR","level","yVKJ","sortLevel","F9Rs","executorUserid","4oK4","executorUsername","Q7Mt","preTaskid","cOkY","preTaskname","3xOF","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","XVI5","description","ShzP","remarks","Li2V","createUserid","Hz05","createUsername","iEli","createTime",parse("2020-11-12 2:0:58"),"rate",5135,"budgetCost",8627.51,"budgetWorkload",6380.18,"actCost",8910.73,"actWorkload",5205.25,"taskState","2","taskType","12lB","taskClass","2","toTaskCenter","a","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","qcvj","bizFlowState","G","projectPhaseId","2Okh","projectPhaseName","j07G","taskSkillNames","41tr","exeUsernames","wG42","taskSkillIds","oBbs","exeUserids","e8xQ","taskOut","s","planType","Bbm8","settleSchemel","bJpz","menuId","q672","menuName","6kCz","iterationId","hO01","iterationName","AHJZ","productId","J6Vk","productName","X8qk");
		XmTask xmTask0=BaseUtils.fromMap(p0,XmTask.class);
		batchValues.add(xmTask0);
		Map p1=BaseUtils.map("id","Zyf6","name","vmZc","parentTaskid","ejjh","parentTaskname","8MqT","projectId","Vv32","projectName","g46h","level","w3uF","sortLevel","jIJn","executorUserid","n9wZ","executorUsername","4MA6","preTaskid","0HFR","preTaskname","tTk0","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","9KUx","description","s2a4","remarks","1yxt","createUserid","0FIj","createUsername","mgW3","createTime",parse("2020-11-12 2:0:58"),"rate",8600,"budgetCost",2290.09,"budgetWorkload",9213.63,"actCost",2792.78,"actWorkload",3049.21,"taskState","d","taskType","0qDa","taskClass","Z","toTaskCenter","z","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","E9Sh","bizFlowState","8","projectPhaseId","DX6B","projectPhaseName","46C4","taskSkillNames","UsST","exeUsernames","LVMZ","taskSkillIds","3cTI","exeUserids","0NP7","taskOut","b","planType","370k","settleSchemel","fUoY","menuId","Fx4Z","menuName","MQ7R","iterationId","wk8T","iterationName","ht7r","productId","0a49","productName","rIBB");
		XmTask xmTask1=BaseUtils.fromMap(p1,XmTask.class);
		batchValues.add(xmTask1);
		Map p2=BaseUtils.map("id","16q2","name","O658","parentTaskid","Cg9T","parentTaskname","hmSb","projectId","96C6","projectName","x514","level","DRgI","sortLevel","f3PH","executorUserid","cYtZ","executorUsername","RL2L","preTaskid","t1z2","preTaskname","277V","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","Oe53","description","I4Ve","remarks","le7w","createUserid","E42W","createUsername","SdWj","createTime",parse("2020-11-12 2:0:58"),"rate",4112,"budgetCost",9385.99,"budgetWorkload",8401.01,"actCost",4936.98,"actWorkload",5101.8,"taskState","h","taskType","vaMr","taskClass","h","toTaskCenter","s","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","TBX9","bizFlowState","e","projectPhaseId","Q4G9","projectPhaseName","3w4j","taskSkillNames","i3G4","exeUsernames","zsa6","taskSkillIds","5bmS","exeUserids","6aka","taskOut","7","planType","399Q","settleSchemel","0jGY","menuId","AW73","menuName","t5VU","iterationId","e0CP","iterationName","jZs5","productId","3FEb","productName","QiiZ");
		XmTask xmTask2=BaseUtils.fromMap(p2,XmTask.class);
		batchValues.add(xmTask2);
		Map p3=BaseUtils.map("id","GVVT","name","t0K7","parentTaskid","f6AE","parentTaskname","3t7k","projectId","GVrp","projectName","aAkf","level","sZjI","sortLevel","zc1E","executorUserid","MpY5","executorUsername","90QW","preTaskid","iP9F","preTaskname","dy59","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","ChUv","description","U5er","remarks","B4hj","createUserid","k1Ih","createUsername","Qq9n","createTime",parse("2020-11-12 2:0:58"),"rate",6507,"budgetCost",5984.61,"budgetWorkload",3056.6,"actCost",8592.85,"actWorkload",2197.38,"taskState","s","taskType","7Xzv","taskClass","G","toTaskCenter","0","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","4Fia","bizFlowState","4","projectPhaseId","gN11","projectPhaseName","NKc1","taskSkillNames","9oNa","exeUsernames","h6ww","taskSkillIds","zIqI","exeUserids","UfL5","taskOut","i","planType","hq0U","settleSchemel","9dcn","menuId","fYsB","menuName","Znhe","iterationId","4tpi","iterationName","bAIl","productId","mJVo","productName","5Y6h");
		XmTask xmTask3=BaseUtils.fromMap(p3,XmTask.class);
		batchValues.add(xmTask3);
		Map p4=BaseUtils.map("id","Owes","name","fICh","parentTaskid","d4YY","parentTaskname","MfLw","projectId","Xnl5","projectName","wLxb","level","4Nq4","sortLevel","j0lD","executorUserid","drPT","executorUsername","ga57","preTaskid","Ev3y","preTaskname","8dRN","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","k75i","description","bECa","remarks","iRmK","createUserid","Z7RH","createUsername","2Rq4","createTime",parse("2020-11-12 2:0:58"),"rate",2597,"budgetCost",4856,"budgetWorkload",3316.88,"actCost",5729.09,"actWorkload",6175.15,"taskState","z","taskType","1HuO","taskClass","Q","toTaskCenter","4","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","hvJ6","bizFlowState","7","projectPhaseId","Jesx","projectPhaseName","dNz7","taskSkillNames","0CF5","exeUsernames","z4F3","taskSkillIds","q2R6","exeUserids","1B49","taskOut","F","planType","WZjv","settleSchemel","Qtw7","menuId","Ig9t","menuName","I286","iterationId","yg87","iterationName","UvEr","productId","4crM","productName","80ql");
		XmTask xmTask4=BaseUtils.fromMap(p4,XmTask.class);
		batchValues.add(xmTask4);
		Map p5=BaseUtils.map("id","x492","name","7eG8","parentTaskid","Xaal","parentTaskname","6Q6w","projectId","xV5S","projectName","IY1b","level","QK2a","sortLevel","25zo","executorUserid","s93Z","executorUsername","1iu7","preTaskid","Gp36","preTaskname","bn9p","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","KmdC","description","AO6S","remarks","CU5Y","createUserid","rsFz","createUsername","24sm","createTime",parse("2020-11-12 2:0:58"),"rate",1274,"budgetCost",9915.34,"budgetWorkload",586.24,"actCost",840.74,"actWorkload",5280.35,"taskState","m","taskType","5Jws","taskClass","Y","toTaskCenter","1","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","uA1M","bizFlowState","S","projectPhaseId","6kUd","projectPhaseName","85RZ","taskSkillNames","MZ8J","exeUsernames","XRX6","taskSkillIds","Vbnr","exeUserids","zMJV","taskOut","O","planType","q4aa","settleSchemel","395f","menuId","7mXa","menuName","yfVm","iterationId","4DuF","iterationName","05Uo","productId","5H0B","productName","2snK");
		XmTask xmTask5=BaseUtils.fromMap(p5,XmTask.class);
		batchValues.add(xmTask5);
		Map p6=BaseUtils.map("id","nZXd","name","QG1W","parentTaskid","0Fqr","parentTaskname","Q9jl","projectId","Rd75","projectName","nV76","level","VJqE","sortLevel","jfcD","executorUserid","0CsV","executorUsername","r9QE","preTaskid","Whqt","preTaskname","TN78","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","9hQy","description","I5aw","remarks","q9U5","createUserid","J626","createUsername","Ngg9","createTime",parse("2020-11-12 2:0:58"),"rate",7783,"budgetCost",6274.91,"budgetWorkload",4535.09,"actCost",5237.71,"actWorkload",2353.95,"taskState","t","taskType","f9pg","taskClass","C","toTaskCenter","x","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","mU0D","bizFlowState","9","projectPhaseId","c0hP","projectPhaseName","YzIh","taskSkillNames","i99B","exeUsernames","u95O","taskSkillIds","yxfD","exeUserids","oIEW","taskOut","v","planType","2vad","settleSchemel","Xpn8","menuId","Gm6H","menuName","SAX3","iterationId","1T84","iterationName","wQ47","productId","pk9a","productName","9FPS");
		XmTask xmTask6=BaseUtils.fromMap(p6,XmTask.class);
		batchValues.add(xmTask6);
		Map p7=BaseUtils.map("id","6yLg","name","X44b","parentTaskid","Iy00","parentTaskname","HlQV","projectId","c5AG","projectName","N5yX","level","ZWPO","sortLevel","v40K","executorUserid","q1GS","executorUsername","IP4A","preTaskid","t50z","preTaskname","Ace9","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","URPv","description","33JF","remarks","SB6c","createUserid","CPYZ","createUsername","W2uK","createTime",parse("2020-11-12 2:0:58"),"rate",2229,"budgetCost",1851.07,"budgetWorkload",5713.42,"actCost",1396.93,"actWorkload",2730.87,"taskState","c","taskType","Znx8","taskClass","9","toTaskCenter","x","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","vkS3","bizFlowState","7","projectPhaseId","SMSO","projectPhaseName","4oI1","taskSkillNames","74k5","exeUsernames","s3OF","taskSkillIds","iH18","exeUserids","gI2t","taskOut","J","planType","bhSC","settleSchemel","t83j","menuId","4o7F","menuName","eh3h","iterationId","oG54","iterationName","VRWT","productId","m1l6","productName","5i2B");
		XmTask xmTask7=BaseUtils.fromMap(p7,XmTask.class);
		batchValues.add(xmTask7);
		xmTaskService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmTask> batchValues=new ArrayList<XmTask>();
		Map p0=BaseUtils.map("id","Gq2X","name","9dPl","parentTaskid","H22g","parentTaskname","oNQT","projectId","Yo4Z","projectName","gnsR","level","yVKJ","sortLevel","F9Rs","executorUserid","4oK4","executorUsername","Q7Mt","preTaskid","cOkY","preTaskname","3xOF","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","XVI5","description","ShzP","remarks","Li2V","createUserid","Hz05","createUsername","iEli","createTime",parse("2020-11-12 2:0:58"),"rate",5135,"budgetCost",8627.51,"budgetWorkload",6380.18,"actCost",8910.73,"actWorkload",5205.25,"taskState","2","taskType","12lB","taskClass","2","toTaskCenter","a","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","qcvj","bizFlowState","G","projectPhaseId","2Okh","projectPhaseName","j07G","taskSkillNames","41tr","exeUsernames","wG42","taskSkillIds","oBbs","exeUserids","e8xQ","taskOut","s","planType","Bbm8","settleSchemel","bJpz","menuId","q672","menuName","6kCz","iterationId","hO01","iterationName","AHJZ","productId","J6Vk","productName","X8qk");
		XmTask xmTask0=BaseUtils.fromMap(p0,XmTask.class);
		batchValues.add(xmTask0);
		Map p1=BaseUtils.map("id","Zyf6","name","vmZc","parentTaskid","ejjh","parentTaskname","8MqT","projectId","Vv32","projectName","g46h","level","w3uF","sortLevel","jIJn","executorUserid","n9wZ","executorUsername","4MA6","preTaskid","0HFR","preTaskname","tTk0","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","9KUx","description","s2a4","remarks","1yxt","createUserid","0FIj","createUsername","mgW3","createTime",parse("2020-11-12 2:0:58"),"rate",8600,"budgetCost",2290.09,"budgetWorkload",9213.63,"actCost",2792.78,"actWorkload",3049.21,"taskState","d","taskType","0qDa","taskClass","Z","toTaskCenter","z","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","E9Sh","bizFlowState","8","projectPhaseId","DX6B","projectPhaseName","46C4","taskSkillNames","UsST","exeUsernames","LVMZ","taskSkillIds","3cTI","exeUserids","0NP7","taskOut","b","planType","370k","settleSchemel","fUoY","menuId","Fx4Z","menuName","MQ7R","iterationId","wk8T","iterationName","ht7r","productId","0a49","productName","rIBB");
		XmTask xmTask1=BaseUtils.fromMap(p1,XmTask.class);
		batchValues.add(xmTask1);
		Map p2=BaseUtils.map("id","16q2","name","O658","parentTaskid","Cg9T","parentTaskname","hmSb","projectId","96C6","projectName","x514","level","DRgI","sortLevel","f3PH","executorUserid","cYtZ","executorUsername","RL2L","preTaskid","t1z2","preTaskname","277V","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","Oe53","description","I4Ve","remarks","le7w","createUserid","E42W","createUsername","SdWj","createTime",parse("2020-11-12 2:0:58"),"rate",4112,"budgetCost",9385.99,"budgetWorkload",8401.01,"actCost",4936.98,"actWorkload",5101.8,"taskState","h","taskType","vaMr","taskClass","h","toTaskCenter","s","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","TBX9","bizFlowState","e","projectPhaseId","Q4G9","projectPhaseName","3w4j","taskSkillNames","i3G4","exeUsernames","zsa6","taskSkillIds","5bmS","exeUserids","6aka","taskOut","7","planType","399Q","settleSchemel","0jGY","menuId","AW73","menuName","t5VU","iterationId","e0CP","iterationName","jZs5","productId","3FEb","productName","QiiZ");
		XmTask xmTask2=BaseUtils.fromMap(p2,XmTask.class);
		batchValues.add(xmTask2);
		Map p3=BaseUtils.map("id","GVVT","name","t0K7","parentTaskid","f6AE","parentTaskname","3t7k","projectId","GVrp","projectName","aAkf","level","sZjI","sortLevel","zc1E","executorUserid","MpY5","executorUsername","90QW","preTaskid","iP9F","preTaskname","dy59","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","ChUv","description","U5er","remarks","B4hj","createUserid","k1Ih","createUsername","Qq9n","createTime",parse("2020-11-12 2:0:58"),"rate",6507,"budgetCost",5984.61,"budgetWorkload",3056.6,"actCost",8592.85,"actWorkload",2197.38,"taskState","s","taskType","7Xzv","taskClass","G","toTaskCenter","0","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","4Fia","bizFlowState","4","projectPhaseId","gN11","projectPhaseName","NKc1","taskSkillNames","9oNa","exeUsernames","h6ww","taskSkillIds","zIqI","exeUserids","UfL5","taskOut","i","planType","hq0U","settleSchemel","9dcn","menuId","fYsB","menuName","Znhe","iterationId","4tpi","iterationName","bAIl","productId","mJVo","productName","5Y6h");
		XmTask xmTask3=BaseUtils.fromMap(p3,XmTask.class);
		batchValues.add(xmTask3);
		Map p4=BaseUtils.map("id","Owes","name","fICh","parentTaskid","d4YY","parentTaskname","MfLw","projectId","Xnl5","projectName","wLxb","level","4Nq4","sortLevel","j0lD","executorUserid","drPT","executorUsername","ga57","preTaskid","Ev3y","preTaskname","8dRN","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","k75i","description","bECa","remarks","iRmK","createUserid","Z7RH","createUsername","2Rq4","createTime",parse("2020-11-12 2:0:58"),"rate",2597,"budgetCost",4856,"budgetWorkload",3316.88,"actCost",5729.09,"actWorkload",6175.15,"taskState","z","taskType","1HuO","taskClass","Q","toTaskCenter","4","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","hvJ6","bizFlowState","7","projectPhaseId","Jesx","projectPhaseName","dNz7","taskSkillNames","0CF5","exeUsernames","z4F3","taskSkillIds","q2R6","exeUserids","1B49","taskOut","F","planType","WZjv","settleSchemel","Qtw7","menuId","Ig9t","menuName","I286","iterationId","yg87","iterationName","UvEr","productId","4crM","productName","80ql");
		XmTask xmTask4=BaseUtils.fromMap(p4,XmTask.class);
		batchValues.add(xmTask4);
		Map p5=BaseUtils.map("id","x492","name","7eG8","parentTaskid","Xaal","parentTaskname","6Q6w","projectId","xV5S","projectName","IY1b","level","QK2a","sortLevel","25zo","executorUserid","s93Z","executorUsername","1iu7","preTaskid","Gp36","preTaskname","bn9p","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","KmdC","description","AO6S","remarks","CU5Y","createUserid","rsFz","createUsername","24sm","createTime",parse("2020-11-12 2:0:58"),"rate",1274,"budgetCost",9915.34,"budgetWorkload",586.24,"actCost",840.74,"actWorkload",5280.35,"taskState","m","taskType","5Jws","taskClass","Y","toTaskCenter","1","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","uA1M","bizFlowState","S","projectPhaseId","6kUd","projectPhaseName","85RZ","taskSkillNames","MZ8J","exeUsernames","XRX6","taskSkillIds","Vbnr","exeUserids","zMJV","taskOut","O","planType","q4aa","settleSchemel","395f","menuId","7mXa","menuName","yfVm","iterationId","4DuF","iterationName","05Uo","productId","5H0B","productName","2snK");
		XmTask xmTask5=BaseUtils.fromMap(p5,XmTask.class);
		batchValues.add(xmTask5);
		Map p6=BaseUtils.map("id","nZXd","name","QG1W","parentTaskid","0Fqr","parentTaskname","Q9jl","projectId","Rd75","projectName","nV76","level","VJqE","sortLevel","jfcD","executorUserid","0CsV","executorUsername","r9QE","preTaskid","Whqt","preTaskname","TN78","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","9hQy","description","I5aw","remarks","q9U5","createUserid","J626","createUsername","Ngg9","createTime",parse("2020-11-12 2:0:58"),"rate",7783,"budgetCost",6274.91,"budgetWorkload",4535.09,"actCost",5237.71,"actWorkload",2353.95,"taskState","t","taskType","f9pg","taskClass","C","toTaskCenter","x","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","mU0D","bizFlowState","9","projectPhaseId","c0hP","projectPhaseName","YzIh","taskSkillNames","i99B","exeUsernames","u95O","taskSkillIds","yxfD","exeUserids","oIEW","taskOut","v","planType","2vad","settleSchemel","Xpn8","menuId","Gm6H","menuName","SAX3","iterationId","1T84","iterationName","wQ47","productId","pk9a","productName","9FPS");
		XmTask xmTask6=BaseUtils.fromMap(p6,XmTask.class);
		batchValues.add(xmTask6);
		Map p7=BaseUtils.map("id","6yLg","name","X44b","parentTaskid","Iy00","parentTaskname","HlQV","projectId","c5AG","projectName","N5yX","level","ZWPO","sortLevel","v40K","executorUserid","q1GS","executorUsername","IP4A","preTaskid","t50z","preTaskname","Ace9","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","URPv","description","33JF","remarks","SB6c","createUserid","CPYZ","createUsername","W2uK","createTime",parse("2020-11-12 2:0:58"),"rate",2229,"budgetCost",1851.07,"budgetWorkload",5713.42,"actCost",1396.93,"actWorkload",2730.87,"taskState","c","taskType","Znx8","taskClass","9","toTaskCenter","x","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","vkS3","bizFlowState","7","projectPhaseId","SMSO","projectPhaseName","4oI1","taskSkillNames","74k5","exeUsernames","s3OF","taskSkillIds","iH18","exeUserids","gI2t","taskOut","J","planType","bhSC","settleSchemel","t83j","menuId","4o7F","menuName","eh3h","iterationId","oG54","iterationName","VRWT","productId","m1l6","productName","5i2B");
		XmTask xmTask7=BaseUtils.fromMap(p7,XmTask.class);
		batchValues.add(xmTask7);
		xmTaskService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmTask> batchValues=new ArrayList<XmTask>();
		Map p0=BaseUtils.map("id","Gq2X","name","9dPl","parentTaskid","H22g","parentTaskname","oNQT","projectId","Yo4Z","projectName","gnsR","level","yVKJ","sortLevel","F9Rs","executorUserid","4oK4","executorUsername","Q7Mt","preTaskid","cOkY","preTaskname","3xOF","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","XVI5","description","ShzP","remarks","Li2V","createUserid","Hz05","createUsername","iEli","createTime",parse("2020-11-12 2:0:58"),"rate",5135,"budgetCost",8627.51,"budgetWorkload",6380.18,"actCost",8910.73,"actWorkload",5205.25,"taskState","2","taskType","12lB","taskClass","2","toTaskCenter","a","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","qcvj","bizFlowState","G","projectPhaseId","2Okh","projectPhaseName","j07G","taskSkillNames","41tr","exeUsernames","wG42","taskSkillIds","oBbs","exeUserids","e8xQ","taskOut","s","planType","Bbm8","settleSchemel","bJpz","menuId","q672","menuName","6kCz","iterationId","hO01","iterationName","AHJZ","productId","J6Vk","productName","X8qk");
		XmTask xmTask0=BaseUtils.fromMap(p0,XmTask.class);
		batchValues.add(xmTask0);
		Map p1=BaseUtils.map("id","Zyf6","name","vmZc","parentTaskid","ejjh","parentTaskname","8MqT","projectId","Vv32","projectName","g46h","level","w3uF","sortLevel","jIJn","executorUserid","n9wZ","executorUsername","4MA6","preTaskid","0HFR","preTaskname","tTk0","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","9KUx","description","s2a4","remarks","1yxt","createUserid","0FIj","createUsername","mgW3","createTime",parse("2020-11-12 2:0:58"),"rate",8600,"budgetCost",2290.09,"budgetWorkload",9213.63,"actCost",2792.78,"actWorkload",3049.21,"taskState","d","taskType","0qDa","taskClass","Z","toTaskCenter","z","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","E9Sh","bizFlowState","8","projectPhaseId","DX6B","projectPhaseName","46C4","taskSkillNames","UsST","exeUsernames","LVMZ","taskSkillIds","3cTI","exeUserids","0NP7","taskOut","b","planType","370k","settleSchemel","fUoY","menuId","Fx4Z","menuName","MQ7R","iterationId","wk8T","iterationName","ht7r","productId","0a49","productName","rIBB");
		XmTask xmTask1=BaseUtils.fromMap(p1,XmTask.class);
		batchValues.add(xmTask1);
		Map p2=BaseUtils.map("id","16q2","name","O658","parentTaskid","Cg9T","parentTaskname","hmSb","projectId","96C6","projectName","x514","level","DRgI","sortLevel","f3PH","executorUserid","cYtZ","executorUsername","RL2L","preTaskid","t1z2","preTaskname","277V","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","Oe53","description","I4Ve","remarks","le7w","createUserid","E42W","createUsername","SdWj","createTime",parse("2020-11-12 2:0:58"),"rate",4112,"budgetCost",9385.99,"budgetWorkload",8401.01,"actCost",4936.98,"actWorkload",5101.8,"taskState","h","taskType","vaMr","taskClass","h","toTaskCenter","s","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","TBX9","bizFlowState","e","projectPhaseId","Q4G9","projectPhaseName","3w4j","taskSkillNames","i3G4","exeUsernames","zsa6","taskSkillIds","5bmS","exeUserids","6aka","taskOut","7","planType","399Q","settleSchemel","0jGY","menuId","AW73","menuName","t5VU","iterationId","e0CP","iterationName","jZs5","productId","3FEb","productName","QiiZ");
		XmTask xmTask2=BaseUtils.fromMap(p2,XmTask.class);
		batchValues.add(xmTask2);
		Map p3=BaseUtils.map("id","GVVT","name","t0K7","parentTaskid","f6AE","parentTaskname","3t7k","projectId","GVrp","projectName","aAkf","level","sZjI","sortLevel","zc1E","executorUserid","MpY5","executorUsername","90QW","preTaskid","iP9F","preTaskname","dy59","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","ChUv","description","U5er","remarks","B4hj","createUserid","k1Ih","createUsername","Qq9n","createTime",parse("2020-11-12 2:0:58"),"rate",6507,"budgetCost",5984.61,"budgetWorkload",3056.6,"actCost",8592.85,"actWorkload",2197.38,"taskState","s","taskType","7Xzv","taskClass","G","toTaskCenter","0","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","4Fia","bizFlowState","4","projectPhaseId","gN11","projectPhaseName","NKc1","taskSkillNames","9oNa","exeUsernames","h6ww","taskSkillIds","zIqI","exeUserids","UfL5","taskOut","i","planType","hq0U","settleSchemel","9dcn","menuId","fYsB","menuName","Znhe","iterationId","4tpi","iterationName","bAIl","productId","mJVo","productName","5Y6h");
		XmTask xmTask3=BaseUtils.fromMap(p3,XmTask.class);
		batchValues.add(xmTask3);
		Map p4=BaseUtils.map("id","Owes","name","fICh","parentTaskid","d4YY","parentTaskname","MfLw","projectId","Xnl5","projectName","wLxb","level","4Nq4","sortLevel","j0lD","executorUserid","drPT","executorUsername","ga57","preTaskid","Ev3y","preTaskname","8dRN","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","k75i","description","bECa","remarks","iRmK","createUserid","Z7RH","createUsername","2Rq4","createTime",parse("2020-11-12 2:0:58"),"rate",2597,"budgetCost",4856,"budgetWorkload",3316.88,"actCost",5729.09,"actWorkload",6175.15,"taskState","z","taskType","1HuO","taskClass","Q","toTaskCenter","4","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","hvJ6","bizFlowState","7","projectPhaseId","Jesx","projectPhaseName","dNz7","taskSkillNames","0CF5","exeUsernames","z4F3","taskSkillIds","q2R6","exeUserids","1B49","taskOut","F","planType","WZjv","settleSchemel","Qtw7","menuId","Ig9t","menuName","I286","iterationId","yg87","iterationName","UvEr","productId","4crM","productName","80ql");
		XmTask xmTask4=BaseUtils.fromMap(p4,XmTask.class);
		batchValues.add(xmTask4);
		Map p5=BaseUtils.map("id","x492","name","7eG8","parentTaskid","Xaal","parentTaskname","6Q6w","projectId","xV5S","projectName","IY1b","level","QK2a","sortLevel","25zo","executorUserid","s93Z","executorUsername","1iu7","preTaskid","Gp36","preTaskname","bn9p","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","KmdC","description","AO6S","remarks","CU5Y","createUserid","rsFz","createUsername","24sm","createTime",parse("2020-11-12 2:0:58"),"rate",1274,"budgetCost",9915.34,"budgetWorkload",586.24,"actCost",840.74,"actWorkload",5280.35,"taskState","m","taskType","5Jws","taskClass","Y","toTaskCenter","1","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","uA1M","bizFlowState","S","projectPhaseId","6kUd","projectPhaseName","85RZ","taskSkillNames","MZ8J","exeUsernames","XRX6","taskSkillIds","Vbnr","exeUserids","zMJV","taskOut","O","planType","q4aa","settleSchemel","395f","menuId","7mXa","menuName","yfVm","iterationId","4DuF","iterationName","05Uo","productId","5H0B","productName","2snK");
		XmTask xmTask5=BaseUtils.fromMap(p5,XmTask.class);
		batchValues.add(xmTask5);
		Map p6=BaseUtils.map("id","nZXd","name","QG1W","parentTaskid","0Fqr","parentTaskname","Q9jl","projectId","Rd75","projectName","nV76","level","VJqE","sortLevel","jfcD","executorUserid","0CsV","executorUsername","r9QE","preTaskid","Whqt","preTaskname","TN78","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","9hQy","description","I5aw","remarks","q9U5","createUserid","J626","createUsername","Ngg9","createTime",parse("2020-11-12 2:0:58"),"rate",7783,"budgetCost",6274.91,"budgetWorkload",4535.09,"actCost",5237.71,"actWorkload",2353.95,"taskState","t","taskType","f9pg","taskClass","C","toTaskCenter","x","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","mU0D","bizFlowState","9","projectPhaseId","c0hP","projectPhaseName","YzIh","taskSkillNames","i99B","exeUsernames","u95O","taskSkillIds","yxfD","exeUserids","oIEW","taskOut","v","planType","2vad","settleSchemel","Xpn8","menuId","Gm6H","menuName","SAX3","iterationId","1T84","iterationName","wQ47","productId","pk9a","productName","9FPS");
		XmTask xmTask6=BaseUtils.fromMap(p6,XmTask.class);
		batchValues.add(xmTask6);
		Map p7=BaseUtils.map("id","6yLg","name","X44b","parentTaskid","Iy00","parentTaskname","HlQV","projectId","c5AG","projectName","N5yX","level","ZWPO","sortLevel","v40K","executorUserid","q1GS","executorUsername","IP4A","preTaskid","t50z","preTaskname","Ace9","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","URPv","description","33JF","remarks","SB6c","createUserid","CPYZ","createUsername","W2uK","createTime",parse("2020-11-12 2:0:58"),"rate",2229,"budgetCost",1851.07,"budgetWorkload",5713.42,"actCost",1396.93,"actWorkload",2730.87,"taskState","c","taskType","Znx8","taskClass","9","toTaskCenter","x","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","vkS3","bizFlowState","7","projectPhaseId","SMSO","projectPhaseName","4oI1","taskSkillNames","74k5","exeUsernames","s3OF","taskSkillIds","iH18","exeUserids","gI2t","taskOut","J","planType","bhSC","settleSchemel","t83j","menuId","4o7F","menuName","eh3h","iterationId","oG54","iterationName","VRWT","productId","m1l6","productName","5i2B");
		XmTask xmTask7=BaseUtils.fromMap(p7,XmTask.class);
		batchValues.add(xmTask7);
		xmTaskService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","Gq2X");
		Map<String,Object> result=this.xmTaskService.selectOne(XmTask.class.getName()+".selectOneMap",p);
		Assert.assertEquals("Gq2X", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("name","9dPl","parentTaskid","H22g","parentTaskname","oNQT","projectId","Yo4Z","projectName","gnsR","level","yVKJ","sortLevel","F9Rs","executorUserid","4oK4","executorUsername","Q7Mt","preTaskid","cOkY","preTaskname","3xOF","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","XVI5","description","ShzP","remarks","Li2V","createUserid","Hz05","createUsername","iEli","createTime",parse("2020-11-12 2:0:58"),"rate",5135,"budgetCost",8627.51,"budgetWorkload",6380.18,"actCost",8910.73,"actWorkload",5205.25,"taskState","2","taskType","12lB","taskClass","2","toTaskCenter","a","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","qcvj","bizFlowState","G","projectPhaseId","2Okh","projectPhaseName","j07G","taskSkillNames","41tr","exeUsernames","wG42","taskSkillIds","oBbs","exeUserids","e8xQ","taskOut","s","planType","Bbm8","settleSchemel","bJpz","menuId","q672","menuName","6kCz","iterationId","hO01","iterationName","AHJZ","productId","J6Vk","productName","X8qk");
		XmTask xmTask=BaseUtils.fromMap(p,XmTask.class);
		long result=xmTaskService.countByWhere(xmTask);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("name","9dPl","parentTaskid","H22g","parentTaskname","oNQT","projectId","Yo4Z","projectName","gnsR","level","yVKJ","sortLevel","F9Rs","executorUserid","4oK4","executorUsername","Q7Mt","preTaskid","cOkY","preTaskname","3xOF","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","XVI5","description","ShzP","remarks","Li2V","createUserid","Hz05","createUsername","iEli","createTime",parse("2020-11-12 2:0:58"),"rate",5135,"budgetCost",8627.51,"budgetWorkload",6380.18,"actCost",8910.73,"actWorkload",5205.25,"taskState","2","taskType","12lB","taskClass","2","toTaskCenter","a","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","qcvj","bizFlowState","G","projectPhaseId","2Okh","projectPhaseName","j07G","taskSkillNames","41tr","exeUsernames","wG42","taskSkillIds","oBbs","exeUserids","e8xQ","taskOut","s","planType","Bbm8","settleSchemel","bJpz","menuId","q672","menuName","6kCz","iterationId","hO01","iterationName","AHJZ","productId","J6Vk","productName","X8qk");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmTask xmTask=BaseUtils.fromMap(p,XmTask.class);
		List<XmTask> result=xmTaskService.selectListByWhere(xmTask); 
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
	
		
		Map<String,Object> p=BaseUtils.map("name","9dPl","parentTaskid","H22g","parentTaskname","oNQT","projectId","Yo4Z","projectName","gnsR","level","yVKJ","sortLevel","F9Rs","executorUserid","4oK4","executorUsername","Q7Mt","preTaskid","cOkY","preTaskname","3xOF","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","XVI5","description","ShzP","remarks","Li2V","createUserid","Hz05","createUsername","iEli","createTime",parse("2020-11-12 2:0:58"),"rate",5135,"budgetCost",8627.51,"budgetWorkload",6380.18,"actCost",8910.73,"actWorkload",5205.25,"taskState","2","taskType","12lB","taskClass","2","toTaskCenter","a","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","qcvj","bizFlowState","G","projectPhaseId","2Okh","projectPhaseName","j07G","taskSkillNames","41tr","exeUsernames","wG42","taskSkillIds","oBbs","exeUserids","e8xQ","taskOut","s","planType","Bbm8","settleSchemel","bJpz","menuId","q672","menuName","6kCz","iterationId","hO01","iterationName","AHJZ","productId","J6Vk","productName","X8qk");
		XmTask xmTask=BaseUtils.fromMap(p,XmTask.class);
		List<XmTask> result=xmTaskService.selectListByWhere(xmTask);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("name","9dPl","parentTaskid","H22g","parentTaskname","oNQT","projectId","Yo4Z","projectName","gnsR","level","yVKJ","sortLevel","F9Rs","executorUserid","4oK4","executorUsername","Q7Mt","preTaskid","cOkY","preTaskname","3xOF","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","XVI5","description","ShzP","remarks","Li2V","createUserid","Hz05","createUsername","iEli","createTime",parse("2020-11-12 2:0:58"),"rate",5135,"budgetCost",8627.51,"budgetWorkload",6380.18,"actCost",8910.73,"actWorkload",5205.25,"taskState","2","taskType","12lB","taskClass","2","toTaskCenter","a","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","qcvj","bizFlowState","G","projectPhaseId","2Okh","projectPhaseName","j07G","taskSkillNames","41tr","exeUsernames","wG42","taskSkillIds","oBbs","exeUserids","e8xQ","taskOut","s","planType","Bbm8","settleSchemel","bJpz","menuId","q672","menuName","6kCz","iterationId","hO01","iterationName","AHJZ","productId","J6Vk","productName","X8qk");
		List<Map<String,Object>> result=xmTaskService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("name","9dPl","parentTaskid","H22g","parentTaskname","oNQT","projectId","Yo4Z","projectName","gnsR","level","yVKJ","sortLevel","F9Rs","executorUserid","4oK4","executorUsername","Q7Mt","preTaskid","cOkY","preTaskname","3xOF","startTime",parse("2020-11-12 2:0:58"),"endTime",parse("2020-11-12 2:0:58"),"milestone","XVI5","description","ShzP","remarks","Li2V","createUserid","Hz05","createUsername","iEli","createTime",parse("2020-11-12 2:0:58"),"rate",5135,"budgetCost",8627.51,"budgetWorkload",6380.18,"actCost",8910.73,"actWorkload",5205.25,"taskState","2","taskType","12lB","taskClass","2","toTaskCenter","a","actStartTime",parse("2020-11-12 2:0:58"),"actEndTime",parse("2020-11-12 2:0:58"),"bizProcInstId","qcvj","bizFlowState","G","projectPhaseId","2Okh","projectPhaseName","j07G","taskSkillNames","41tr","exeUsernames","wG42","taskSkillIds","oBbs","exeUserids","e8xQ","taskOut","s","planType","Bbm8","settleSchemel","bJpz","menuId","q672","menuName","6kCz","iterationId","hO01","iterationName","AHJZ","productId","J6Vk","productName","X8qk");
		List<Map<String,Object>> result=xmTaskService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmTask
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","Gq2X");
		
		XmTask xmTask1=BaseUtils.fromMap(p,XmTask.class);
		XmTask xmTask=xmTaskService.selectOneObject(xmTask1);
		Assert.assertEquals("Gq2X", xmTask.getId());
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
