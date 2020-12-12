package  com.qqkj.xm.core.service;

import java.util.*;
import java.text.SimpleDateFormat;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.qqkj.mdp.core.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired; 
import  com.qqkj.xm.core.service.XmIterationService; 
import com.qqkj.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import  com.qqkj.xm.core.entity.XmIteration;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmIterationService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_iteration 迭代定义<br>
 * 实体 XmIteration<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,branchId,iterationName,startTime,endTime,onlineTime,pid,adminUserid,adminUsername,ctime,budgetCost,budgetWorkload,distBudgetCost,distBudgetWorkload,actCost,actWorkload,actStaffNum,seqNo,finishRate,istatus,cuserid,cusername,remark;<br>
 * 当前表的所有字段名:<br>
 *	id,branch_id,iteration_name,start_time,end_time,online_time,pid,admin_userid,admin_username,ctime,budget_cost,budget_workload,dist_budget_cost,dist_budget_workload,act_cost,act_workload,act_staff_num,seq_no,finish_rate,istatus,cuserid,cusername,remark;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmIterationService  {

	@Autowired
	XmIterationService xmIterationService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","R3rw","branchId","49GI","iterationName","N8lX","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","CB9e","adminUserid","r0R0","adminUsername","CZk9","ctime",parse("2020-11-07 22:55:27"),"budgetCost",7464.74,"budgetWorkload",1895.55,"distBudgetCost",7673.16,"distBudgetWorkload",8525.11,"actCost",2694.35,"actWorkload",5708.21,"actStaffNum",1741,"seqNo","dIEl","finishRate",8162.92,"istatus","W","cuserid","1FNB","cusername","0Jr5","remark","Hxwd");
		XmIteration xmIteration=BaseUtils.fromMap(p,XmIteration.class);
		xmIterationService.insert(xmIteration);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("branchId","49GI","iterationName","N8lX","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","CB9e","adminUserid","r0R0","adminUsername","CZk9","ctime",parse("2020-11-07 22:55:27"),"budgetCost",7464.74,"budgetWorkload",1895.55,"distBudgetCost",7673.16,"distBudgetWorkload",8525.11,"actCost",2694.35,"actWorkload",5708.21,"actStaffNum",1741,"seqNo","dIEl","finishRate",8162.92,"istatus","W","cuserid","1FNB","cusername","0Jr5","remark","Hxwd");
		XmIteration xmIteration=BaseUtils.fromMap(p,XmIteration.class);
		xmIterationService.deleteByWhere(xmIteration);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","R3rw");
		XmIteration xmIteration=BaseUtils.fromMap(p,XmIteration.class);
		xmIterationService.deleteByPk(xmIteration);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("branchId","49GI","iterationName","N8lX","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","CB9e","adminUserid","r0R0","adminUsername","CZk9","ctime",parse("2020-11-07 22:55:27"),"budgetCost",7464.74,"budgetWorkload",1895.55,"distBudgetCost",7673.16,"distBudgetWorkload",8525.11,"actCost",2694.35,"actWorkload",5708.21,"actStaffNum",1741,"seqNo","dIEl","finishRate",8162.92,"istatus","W","cuserid","1FNB","cusername","0Jr5","remark","Hxwd");
		XmIteration xmIteration=BaseUtils.fromMap(where,XmIteration.class);
		xmIterationService.updateSomeFieldByPk(xmIteration);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","R3rw");
		XmIteration xmIteration=BaseUtils.fromMap(p,XmIteration.class);
		xmIterationService.updateByPk(xmIteration);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("id","R3rw","branchId","49GI","iterationName","N8lX","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","CB9e","adminUserid","r0R0","adminUsername","CZk9","ctime",parse("2020-11-07 22:55:27"),"budgetCost",7464.74,"budgetWorkload",1895.55,"distBudgetCost",7673.16,"distBudgetWorkload",8525.11,"actCost",2694.35,"actWorkload",5708.21,"actStaffNum",1741,"seqNo","dIEl","finishRate",8162.92,"istatus","W","cuserid","1FNB","cusername","0Jr5","remark","Hxwd");
		XmIteration xmIteration=BaseUtils.fromMap(p,XmIteration.class);
		xmIterationService.insertOrUpdate(xmIteration);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmIteration> batchValues=new ArrayList<XmIteration>();
		Map p0=BaseUtils.map("id","R3rw","branchId","49GI","iterationName","N8lX","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","CB9e","adminUserid","r0R0","adminUsername","CZk9","ctime",parse("2020-11-07 22:55:27"),"budgetCost",7464.74,"budgetWorkload",1895.55,"distBudgetCost",7673.16,"distBudgetWorkload",8525.11,"actCost",2694.35,"actWorkload",5708.21,"actStaffNum",1741,"seqNo","dIEl","finishRate",8162.92,"istatus","W","cuserid","1FNB","cusername","0Jr5","remark","Hxwd");
		XmIteration xmIteration0=BaseUtils.fromMap(p0,XmIteration.class);
		batchValues.add(xmIteration0);
		Map p1=BaseUtils.map("id","3k5s","branchId","Lv78","iterationName","eA0r","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","066k","adminUserid","oM6s","adminUsername","U4Xd","ctime",parse("2020-11-07 22:55:27"),"budgetCost",7370.6,"budgetWorkload",4457.18,"distBudgetCost",6381.32,"distBudgetWorkload",4419.85,"actCost",5977.55,"actWorkload",6439.52,"actStaffNum",2460,"seqNo","dRH7","finishRate",9507.77,"istatus","x","cuserid","NKt5","cusername","K4gf","remark","2LwG");
		XmIteration xmIteration1=BaseUtils.fromMap(p1,XmIteration.class);
		batchValues.add(xmIteration1);
		Map p2=BaseUtils.map("id","gnCz","branchId","CJ3x","iterationName","ZZTq","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","OssT","adminUserid","8ogp","adminUsername","dlc3","ctime",parse("2020-11-07 22:55:27"),"budgetCost",9912.41,"budgetWorkload",6940.8,"distBudgetCost",316.8,"distBudgetWorkload",8493.53,"actCost",7644.38,"actWorkload",8319.57,"actStaffNum",8273,"seqNo","4XGE","finishRate",6632.04,"istatus","k","cuserid","E6xC","cusername","64i4","remark","3Ch5");
		XmIteration xmIteration2=BaseUtils.fromMap(p2,XmIteration.class);
		batchValues.add(xmIteration2);
		Map p3=BaseUtils.map("id","8M0y","branchId","FYwh","iterationName","rohd","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","JG09","adminUserid","1638","adminUsername","WviB","ctime",parse("2020-11-07 22:55:27"),"budgetCost",8744.8,"budgetWorkload",7732.59,"distBudgetCost",5841.61,"distBudgetWorkload",6397.69,"actCost",6075.67,"actWorkload",3189.45,"actStaffNum",688,"seqNo","p7aC","finishRate",4281.08,"istatus","s","cuserid","5eDy","cusername","m7W6","remark","6X05");
		XmIteration xmIteration3=BaseUtils.fromMap(p3,XmIteration.class);
		batchValues.add(xmIteration3);
		Map p4=BaseUtils.map("id","c23l","branchId","whX8","iterationName","10Fo","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","9R3E","adminUserid","cYAv","adminUsername","w9Ri","ctime",parse("2020-11-07 22:55:27"),"budgetCost",9259.49,"budgetWorkload",2189.05,"distBudgetCost",3938.45,"distBudgetWorkload",2588.15,"actCost",6706.39,"actWorkload",5581.25,"actStaffNum",5533,"seqNo","ejeQ","finishRate",7176.06,"istatus","t","cuserid","M45T","cusername","ZI3M","remark","C44t");
		XmIteration xmIteration4=BaseUtils.fromMap(p4,XmIteration.class);
		batchValues.add(xmIteration4);
		Map p5=BaseUtils.map("id","3JmK","branchId","3aLN","iterationName","8j3T","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","whht","adminUserid","hcjd","adminUsername","H2XE","ctime",parse("2020-11-07 22:55:27"),"budgetCost",2316.1,"budgetWorkload",4596.26,"distBudgetCost",9193.54,"distBudgetWorkload",4726.66,"actCost",6482.68,"actWorkload",1279.29,"actStaffNum",6783,"seqNo","5g67","finishRate",3375.65,"istatus","6","cuserid","WgK3","cusername","5gD8","remark","eN7K");
		XmIteration xmIteration5=BaseUtils.fromMap(p5,XmIteration.class);
		batchValues.add(xmIteration5);
		Map p6=BaseUtils.map("id","5dWK","branchId","3tA0","iterationName","A4tq","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","06Rl","adminUserid","bSgr","adminUsername","O1IA","ctime",parse("2020-11-07 22:55:27"),"budgetCost",4161.58,"budgetWorkload",6259.54,"distBudgetCost",1342.4,"distBudgetWorkload",9911.06,"actCost",3347.67,"actWorkload",1048.53,"actStaffNum",4638,"seqNo","sicS","finishRate",9170.83,"istatus","H","cuserid","C1Ry","cusername","8621","remark","wEab");
		XmIteration xmIteration6=BaseUtils.fromMap(p6,XmIteration.class);
		batchValues.add(xmIteration6);
		Map p7=BaseUtils.map("id","0UZw","branchId","LcIS","iterationName","kxyc","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","qS75","adminUserid","4je3","adminUsername","ZgpD","ctime",parse("2020-11-07 22:55:27"),"budgetCost",1858.22,"budgetWorkload",903.28,"distBudgetCost",9169.9,"distBudgetWorkload",2073.06,"actCost",7368.7,"actWorkload",1604.43,"actStaffNum",9963,"seqNo","Lm4c","finishRate",2401.6,"istatus","x","cuserid","33N7","cusername","z4Wa","remark","7Kjp");
		XmIteration xmIteration7=BaseUtils.fromMap(p7,XmIteration.class);
		batchValues.add(xmIteration7);
		xmIterationService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmIteration> batchValues=new ArrayList<XmIteration>();
		Map p0=BaseUtils.map("id","R3rw","branchId","49GI","iterationName","N8lX","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","CB9e","adminUserid","r0R0","adminUsername","CZk9","ctime",parse("2020-11-07 22:55:27"),"budgetCost",7464.74,"budgetWorkload",1895.55,"distBudgetCost",7673.16,"distBudgetWorkload",8525.11,"actCost",2694.35,"actWorkload",5708.21,"actStaffNum",1741,"seqNo","dIEl","finishRate",8162.92,"istatus","W","cuserid","1FNB","cusername","0Jr5","remark","Hxwd");
		XmIteration xmIteration0=BaseUtils.fromMap(p0,XmIteration.class);
		batchValues.add(xmIteration0);
		Map p1=BaseUtils.map("id","3k5s","branchId","Lv78","iterationName","eA0r","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","066k","adminUserid","oM6s","adminUsername","U4Xd","ctime",parse("2020-11-07 22:55:27"),"budgetCost",7370.6,"budgetWorkload",4457.18,"distBudgetCost",6381.32,"distBudgetWorkload",4419.85,"actCost",5977.55,"actWorkload",6439.52,"actStaffNum",2460,"seqNo","dRH7","finishRate",9507.77,"istatus","x","cuserid","NKt5","cusername","K4gf","remark","2LwG");
		XmIteration xmIteration1=BaseUtils.fromMap(p1,XmIteration.class);
		batchValues.add(xmIteration1);
		Map p2=BaseUtils.map("id","gnCz","branchId","CJ3x","iterationName","ZZTq","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","OssT","adminUserid","8ogp","adminUsername","dlc3","ctime",parse("2020-11-07 22:55:27"),"budgetCost",9912.41,"budgetWorkload",6940.8,"distBudgetCost",316.8,"distBudgetWorkload",8493.53,"actCost",7644.38,"actWorkload",8319.57,"actStaffNum",8273,"seqNo","4XGE","finishRate",6632.04,"istatus","k","cuserid","E6xC","cusername","64i4","remark","3Ch5");
		XmIteration xmIteration2=BaseUtils.fromMap(p2,XmIteration.class);
		batchValues.add(xmIteration2);
		Map p3=BaseUtils.map("id","8M0y","branchId","FYwh","iterationName","rohd","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","JG09","adminUserid","1638","adminUsername","WviB","ctime",parse("2020-11-07 22:55:27"),"budgetCost",8744.8,"budgetWorkload",7732.59,"distBudgetCost",5841.61,"distBudgetWorkload",6397.69,"actCost",6075.67,"actWorkload",3189.45,"actStaffNum",688,"seqNo","p7aC","finishRate",4281.08,"istatus","s","cuserid","5eDy","cusername","m7W6","remark","6X05");
		XmIteration xmIteration3=BaseUtils.fromMap(p3,XmIteration.class);
		batchValues.add(xmIteration3);
		Map p4=BaseUtils.map("id","c23l","branchId","whX8","iterationName","10Fo","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","9R3E","adminUserid","cYAv","adminUsername","w9Ri","ctime",parse("2020-11-07 22:55:27"),"budgetCost",9259.49,"budgetWorkload",2189.05,"distBudgetCost",3938.45,"distBudgetWorkload",2588.15,"actCost",6706.39,"actWorkload",5581.25,"actStaffNum",5533,"seqNo","ejeQ","finishRate",7176.06,"istatus","t","cuserid","M45T","cusername","ZI3M","remark","C44t");
		XmIteration xmIteration4=BaseUtils.fromMap(p4,XmIteration.class);
		batchValues.add(xmIteration4);
		Map p5=BaseUtils.map("id","3JmK","branchId","3aLN","iterationName","8j3T","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","whht","adminUserid","hcjd","adminUsername","H2XE","ctime",parse("2020-11-07 22:55:27"),"budgetCost",2316.1,"budgetWorkload",4596.26,"distBudgetCost",9193.54,"distBudgetWorkload",4726.66,"actCost",6482.68,"actWorkload",1279.29,"actStaffNum",6783,"seqNo","5g67","finishRate",3375.65,"istatus","6","cuserid","WgK3","cusername","5gD8","remark","eN7K");
		XmIteration xmIteration5=BaseUtils.fromMap(p5,XmIteration.class);
		batchValues.add(xmIteration5);
		Map p6=BaseUtils.map("id","5dWK","branchId","3tA0","iterationName","A4tq","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","06Rl","adminUserid","bSgr","adminUsername","O1IA","ctime",parse("2020-11-07 22:55:27"),"budgetCost",4161.58,"budgetWorkload",6259.54,"distBudgetCost",1342.4,"distBudgetWorkload",9911.06,"actCost",3347.67,"actWorkload",1048.53,"actStaffNum",4638,"seqNo","sicS","finishRate",9170.83,"istatus","H","cuserid","C1Ry","cusername","8621","remark","wEab");
		XmIteration xmIteration6=BaseUtils.fromMap(p6,XmIteration.class);
		batchValues.add(xmIteration6);
		Map p7=BaseUtils.map("id","0UZw","branchId","LcIS","iterationName","kxyc","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","qS75","adminUserid","4je3","adminUsername","ZgpD","ctime",parse("2020-11-07 22:55:27"),"budgetCost",1858.22,"budgetWorkload",903.28,"distBudgetCost",9169.9,"distBudgetWorkload",2073.06,"actCost",7368.7,"actWorkload",1604.43,"actStaffNum",9963,"seqNo","Lm4c","finishRate",2401.6,"istatus","x","cuserid","33N7","cusername","z4Wa","remark","7Kjp");
		XmIteration xmIteration7=BaseUtils.fromMap(p7,XmIteration.class);
		batchValues.add(xmIteration7);
		xmIterationService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmIteration> batchValues=new ArrayList<XmIteration>();
		Map p0=BaseUtils.map("id","R3rw","branchId","49GI","iterationName","N8lX","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","CB9e","adminUserid","r0R0","adminUsername","CZk9","ctime",parse("2020-11-07 22:55:27"),"budgetCost",7464.74,"budgetWorkload",1895.55,"distBudgetCost",7673.16,"distBudgetWorkload",8525.11,"actCost",2694.35,"actWorkload",5708.21,"actStaffNum",1741,"seqNo","dIEl","finishRate",8162.92,"istatus","W","cuserid","1FNB","cusername","0Jr5","remark","Hxwd");
		XmIteration xmIteration0=BaseUtils.fromMap(p0,XmIteration.class);
		batchValues.add(xmIteration0);
		Map p1=BaseUtils.map("id","3k5s","branchId","Lv78","iterationName","eA0r","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","066k","adminUserid","oM6s","adminUsername","U4Xd","ctime",parse("2020-11-07 22:55:27"),"budgetCost",7370.6,"budgetWorkload",4457.18,"distBudgetCost",6381.32,"distBudgetWorkload",4419.85,"actCost",5977.55,"actWorkload",6439.52,"actStaffNum",2460,"seqNo","dRH7","finishRate",9507.77,"istatus","x","cuserid","NKt5","cusername","K4gf","remark","2LwG");
		XmIteration xmIteration1=BaseUtils.fromMap(p1,XmIteration.class);
		batchValues.add(xmIteration1);
		Map p2=BaseUtils.map("id","gnCz","branchId","CJ3x","iterationName","ZZTq","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","OssT","adminUserid","8ogp","adminUsername","dlc3","ctime",parse("2020-11-07 22:55:27"),"budgetCost",9912.41,"budgetWorkload",6940.8,"distBudgetCost",316.8,"distBudgetWorkload",8493.53,"actCost",7644.38,"actWorkload",8319.57,"actStaffNum",8273,"seqNo","4XGE","finishRate",6632.04,"istatus","k","cuserid","E6xC","cusername","64i4","remark","3Ch5");
		XmIteration xmIteration2=BaseUtils.fromMap(p2,XmIteration.class);
		batchValues.add(xmIteration2);
		Map p3=BaseUtils.map("id","8M0y","branchId","FYwh","iterationName","rohd","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","JG09","adminUserid","1638","adminUsername","WviB","ctime",parse("2020-11-07 22:55:27"),"budgetCost",8744.8,"budgetWorkload",7732.59,"distBudgetCost",5841.61,"distBudgetWorkload",6397.69,"actCost",6075.67,"actWorkload",3189.45,"actStaffNum",688,"seqNo","p7aC","finishRate",4281.08,"istatus","s","cuserid","5eDy","cusername","m7W6","remark","6X05");
		XmIteration xmIteration3=BaseUtils.fromMap(p3,XmIteration.class);
		batchValues.add(xmIteration3);
		Map p4=BaseUtils.map("id","c23l","branchId","whX8","iterationName","10Fo","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","9R3E","adminUserid","cYAv","adminUsername","w9Ri","ctime",parse("2020-11-07 22:55:27"),"budgetCost",9259.49,"budgetWorkload",2189.05,"distBudgetCost",3938.45,"distBudgetWorkload",2588.15,"actCost",6706.39,"actWorkload",5581.25,"actStaffNum",5533,"seqNo","ejeQ","finishRate",7176.06,"istatus","t","cuserid","M45T","cusername","ZI3M","remark","C44t");
		XmIteration xmIteration4=BaseUtils.fromMap(p4,XmIteration.class);
		batchValues.add(xmIteration4);
		Map p5=BaseUtils.map("id","3JmK","branchId","3aLN","iterationName","8j3T","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","whht","adminUserid","hcjd","adminUsername","H2XE","ctime",parse("2020-11-07 22:55:27"),"budgetCost",2316.1,"budgetWorkload",4596.26,"distBudgetCost",9193.54,"distBudgetWorkload",4726.66,"actCost",6482.68,"actWorkload",1279.29,"actStaffNum",6783,"seqNo","5g67","finishRate",3375.65,"istatus","6","cuserid","WgK3","cusername","5gD8","remark","eN7K");
		XmIteration xmIteration5=BaseUtils.fromMap(p5,XmIteration.class);
		batchValues.add(xmIteration5);
		Map p6=BaseUtils.map("id","5dWK","branchId","3tA0","iterationName","A4tq","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","06Rl","adminUserid","bSgr","adminUsername","O1IA","ctime",parse("2020-11-07 22:55:27"),"budgetCost",4161.58,"budgetWorkload",6259.54,"distBudgetCost",1342.4,"distBudgetWorkload",9911.06,"actCost",3347.67,"actWorkload",1048.53,"actStaffNum",4638,"seqNo","sicS","finishRate",9170.83,"istatus","H","cuserid","C1Ry","cusername","8621","remark","wEab");
		XmIteration xmIteration6=BaseUtils.fromMap(p6,XmIteration.class);
		batchValues.add(xmIteration6);
		Map p7=BaseUtils.map("id","0UZw","branchId","LcIS","iterationName","kxyc","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","qS75","adminUserid","4je3","adminUsername","ZgpD","ctime",parse("2020-11-07 22:55:27"),"budgetCost",1858.22,"budgetWorkload",903.28,"distBudgetCost",9169.9,"distBudgetWorkload",2073.06,"actCost",7368.7,"actWorkload",1604.43,"actStaffNum",9963,"seqNo","Lm4c","finishRate",2401.6,"istatus","x","cuserid","33N7","cusername","z4Wa","remark","7Kjp");
		XmIteration xmIteration7=BaseUtils.fromMap(p7,XmIteration.class);
		batchValues.add(xmIteration7);
		xmIterationService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","R3rw");
		Map<String,Object> result=this.xmIterationService.selectOne(XmIteration.class.getName()+".selectOneMap",p);
		Assert.assertEquals("R3rw", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("branchId","49GI","iterationName","N8lX","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","CB9e","adminUserid","r0R0","adminUsername","CZk9","ctime",parse("2020-11-07 22:55:27"),"budgetCost",7464.74,"budgetWorkload",1895.55,"distBudgetCost",7673.16,"distBudgetWorkload",8525.11,"actCost",2694.35,"actWorkload",5708.21,"actStaffNum",1741,"seqNo","dIEl","finishRate",8162.92,"istatus","W","cuserid","1FNB","cusername","0Jr5","remark","Hxwd");
		XmIteration xmIteration=BaseUtils.fromMap(p,XmIteration.class);
		long result=xmIterationService.countByWhere(xmIteration);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("branchId","49GI","iterationName","N8lX","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","CB9e","adminUserid","r0R0","adminUsername","CZk9","ctime",parse("2020-11-07 22:55:27"),"budgetCost",7464.74,"budgetWorkload",1895.55,"distBudgetCost",7673.16,"distBudgetWorkload",8525.11,"actCost",2694.35,"actWorkload",5708.21,"actStaffNum",1741,"seqNo","dIEl","finishRate",8162.92,"istatus","W","cuserid","1FNB","cusername","0Jr5","remark","Hxwd");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmIteration xmIteration=BaseUtils.fromMap(p,XmIteration.class);
		List<XmIteration> result=xmIterationService.selectListByWhere(xmIteration); 
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
	
		
		Map<String,Object> p=BaseUtils.map("branchId","49GI","iterationName","N8lX","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","CB9e","adminUserid","r0R0","adminUsername","CZk9","ctime",parse("2020-11-07 22:55:27"),"budgetCost",7464.74,"budgetWorkload",1895.55,"distBudgetCost",7673.16,"distBudgetWorkload",8525.11,"actCost",2694.35,"actWorkload",5708.21,"actStaffNum",1741,"seqNo","dIEl","finishRate",8162.92,"istatus","W","cuserid","1FNB","cusername","0Jr5","remark","Hxwd");
		XmIteration xmIteration=BaseUtils.fromMap(p,XmIteration.class);
		List<XmIteration> result=xmIterationService.selectListByWhere(xmIteration);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("branchId","49GI","iterationName","N8lX","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","CB9e","adminUserid","r0R0","adminUsername","CZk9","ctime",parse("2020-11-07 22:55:27"),"budgetCost",7464.74,"budgetWorkload",1895.55,"distBudgetCost",7673.16,"distBudgetWorkload",8525.11,"actCost",2694.35,"actWorkload",5708.21,"actStaffNum",1741,"seqNo","dIEl","finishRate",8162.92,"istatus","W","cuserid","1FNB","cusername","0Jr5","remark","Hxwd");
		List<Map<String,Object>> result=xmIterationService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("branchId","49GI","iterationName","N8lX","startTime",parse("2020-11-07 22:55:27"),"endTime",parse("2020-11-07 22:55:27"),"onlineTime",parse("2020-11-07 22:55:27"),"pid","CB9e","adminUserid","r0R0","adminUsername","CZk9","ctime",parse("2020-11-07 22:55:27"),"budgetCost",7464.74,"budgetWorkload",1895.55,"distBudgetCost",7673.16,"distBudgetWorkload",8525.11,"actCost",2694.35,"actWorkload",5708.21,"actStaffNum",1741,"seqNo","dIEl","finishRate",8162.92,"istatus","W","cuserid","1FNB","cusername","0Jr5","remark","Hxwd");
		List<Map<String,Object>> result=xmIterationService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmIteration
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","R3rw");
		
		XmIteration xmIteration1=BaseUtils.fromMap(p,XmIteration.class);
		XmIteration xmIteration=xmIterationService.selectOneObject(xmIteration1);
		Assert.assertEquals("R3rw", xmIteration.getId());
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
