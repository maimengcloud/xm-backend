package com.qqkj.xm.core.dao;

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
import com.qqkj.mdp.core.dao.BaseDao;
import com.qqkj.mdp.core.context.ContextHolder;
import com.qqkj.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import com.qqkj.xm.core.entity.XmIterationState;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmIterationStateDao的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_iteration_state 迭代定义<br>
 * 实体 XmIterationState<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,distBudgetCost,distBudgetWorkload,actCost,actWorkload,actStaffNum,finishRate,testCases,execCases,designCases,finishCases,projectCnt,productCnt,menuCnt,taskCnt,finishTaskCnt,calcTime,iterationName,budgetCost,budgetWorkload,iterationId,bizDate,closedBugCnt,resolvedBugCnt,activeBugCnt,confirmedBugCnt,bugCnt;<br>
 * 当前表的所有字段名:<br>
 *	id,dist_budget_cost,dist_budget_workload,act_cost,act_workload,act_staff_num,finish_rate,test_cases,exec_cases,design_cases,finish_cases,project_cnt,product_cnt,menu_cnt,task_cnt,finish_task_cnt,calc_time,iteration_name,budget_cost,budget_workload,iteration_id,biz_date,closed_bug_cnt,resolved_bug_cnt,active_bug_cnt,confirmed_bug_cnt,bug_cnt;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/
 @RunWith(SpringJUnit4ClassRunner.class)
 @SpringBootTest
public class TestXmIterationStateDao  {

	@Autowired
	BaseDao baseDao;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","1g8O","distBudgetCost",2580.66,"distBudgetWorkload",5963.69,"actCost",6187.77,"actWorkload",7364.31,"actStaffNum",7393,"finishRate",7196.84,"testCases",6244,"execCases",6389,"designCases",6823,"finishCases",5397,"projectCnt",4062,"productCnt",5338,"menuCnt",4450,"taskCnt",1630,"finishTaskCnt",4194,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","Md56","budgetCost",2647.08,"budgetWorkload",908.36,"iterationId","2yyX","bizDate","4Wb0","closedBugCnt",7878,"resolvedBugCnt",99,"activeBugCnt",9616,"confirmedBugCnt",8834,"bugCnt",6075);
		XmIterationState xmIterationState=BaseUtils.fromMap(p,XmIterationState.class);
		baseDao.insert(xmIterationState);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("distBudgetCost",2580.66,"distBudgetWorkload",5963.69,"actCost",6187.77,"actWorkload",7364.31,"actStaffNum",7393,"finishRate",7196.84,"testCases",6244,"execCases",6389,"designCases",6823,"finishCases",5397,"projectCnt",4062,"productCnt",5338,"menuCnt",4450,"taskCnt",1630,"finishTaskCnt",4194,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","Md56","budgetCost",2647.08,"budgetWorkload",908.36,"iterationId","2yyX","bizDate","4Wb0","closedBugCnt",7878,"resolvedBugCnt",99,"activeBugCnt",9616,"confirmedBugCnt",8834,"bugCnt",6075);
		XmIterationState xmIterationState=BaseUtils.fromMap(p,XmIterationState.class);
		baseDao.deleteByWhere(xmIterationState);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","1g8O");
		XmIterationState xmIterationState=BaseUtils.fromMap(p,XmIterationState.class);
		baseDao.deleteByPk(xmIterationState);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("distBudgetCost",2580.66,"distBudgetWorkload",5963.69,"actCost",6187.77,"actWorkload",7364.31,"actStaffNum",7393,"finishRate",7196.84,"testCases",6244,"execCases",6389,"designCases",6823,"finishCases",5397,"projectCnt",4062,"productCnt",5338,"menuCnt",4450,"taskCnt",1630,"finishTaskCnt",4194,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","Md56","budgetCost",2647.08,"budgetWorkload",908.36,"iterationId","2yyX","bizDate","4Wb0","closedBugCnt",7878,"resolvedBugCnt",99,"activeBugCnt",9616,"confirmedBugCnt",8834,"bugCnt",6075);
		XmIterationState xmIterationState=BaseUtils.fromMap(where,XmIterationState.class);
		baseDao.updateSomeFieldByPk(xmIterationState);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","1g8O");
		XmIterationState xmIterationState=BaseUtils.fromMap(p,XmIterationState.class);
		baseDao.updateByPk(xmIterationState);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("id","1g8O","distBudgetCost",2580.66,"distBudgetWorkload",5963.69,"actCost",6187.77,"actWorkload",7364.31,"actStaffNum",7393,"finishRate",7196.84,"testCases",6244,"execCases",6389,"designCases",6823,"finishCases",5397,"projectCnt",4062,"productCnt",5338,"menuCnt",4450,"taskCnt",1630,"finishTaskCnt",4194,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","Md56","budgetCost",2647.08,"budgetWorkload",908.36,"iterationId","2yyX","bizDate","4Wb0","closedBugCnt",7878,"resolvedBugCnt",99,"activeBugCnt",9616,"confirmedBugCnt",8834,"bugCnt",6075);
		XmIterationState xmIterationState=BaseUtils.fromMap(p,XmIterationState.class);
		baseDao.insertOrUpdate(xmIterationState);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmIterationState> batchValues=new ArrayList<XmIterationState>();
		Map p0=BaseUtils.map("id","1g8O","distBudgetCost",2580.66,"distBudgetWorkload",5963.69,"actCost",6187.77,"actWorkload",7364.31,"actStaffNum",7393,"finishRate",7196.84,"testCases",6244,"execCases",6389,"designCases",6823,"finishCases",5397,"projectCnt",4062,"productCnt",5338,"menuCnt",4450,"taskCnt",1630,"finishTaskCnt",4194,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","Md56","budgetCost",2647.08,"budgetWorkload",908.36,"iterationId","2yyX","bizDate","4Wb0","closedBugCnt",7878,"resolvedBugCnt",99,"activeBugCnt",9616,"confirmedBugCnt",8834,"bugCnt",6075);
		XmIterationState xmIterationState0=BaseUtils.fromMap(p0,XmIterationState.class);
		batchValues.add(xmIterationState0);
		Map p1=BaseUtils.map("id","ZVXU","distBudgetCost",4039.89,"distBudgetWorkload",791.91,"actCost",6663.8,"actWorkload",1743.53,"actStaffNum",6173,"finishRate",5431.77,"testCases",2955,"execCases",3610,"designCases",8610,"finishCases",2146,"projectCnt",6409,"productCnt",284,"menuCnt",3371,"taskCnt",7020,"finishTaskCnt",1279,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","TQ5Y","budgetCost",5224.22,"budgetWorkload",2657.73,"iterationId","wA92","bizDate","EvIo","closedBugCnt",452,"resolvedBugCnt",7760,"activeBugCnt",4337,"confirmedBugCnt",5244,"bugCnt",1083);
		XmIterationState xmIterationState1=BaseUtils.fromMap(p1,XmIterationState.class);
		batchValues.add(xmIterationState1);
		Map p2=BaseUtils.map("id","Ofra","distBudgetCost",3069.79,"distBudgetWorkload",4630.63,"actCost",1194.74,"actWorkload",6488.35,"actStaffNum",842,"finishRate",4049.9,"testCases",8309,"execCases",8807,"designCases",1313,"finishCases",3269,"projectCnt",4346,"productCnt",3566,"menuCnt",926,"taskCnt",3947,"finishTaskCnt",9202,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","0dfL","budgetCost",520.76,"budgetWorkload",2671.08,"iterationId","953G","bizDate","Vy02","closedBugCnt",3032,"resolvedBugCnt",4920,"activeBugCnt",2028,"confirmedBugCnt",6975,"bugCnt",9895);
		XmIterationState xmIterationState2=BaseUtils.fromMap(p2,XmIterationState.class);
		batchValues.add(xmIterationState2);
		Map p3=BaseUtils.map("id","15Pj","distBudgetCost",9186.19,"distBudgetWorkload",9378.9,"actCost",322.29,"actWorkload",84.87,"actStaffNum",5376,"finishRate",1031.1,"testCases",9862,"execCases",2058,"designCases",7208,"finishCases",9667,"projectCnt",2487,"productCnt",592,"menuCnt",6820,"taskCnt",6645,"finishTaskCnt",522,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","1URZ","budgetCost",9556.71,"budgetWorkload",6365.05,"iterationId","26UF","bizDate","fggZ","closedBugCnt",4593,"resolvedBugCnt",7244,"activeBugCnt",7306,"confirmedBugCnt",6867,"bugCnt",4282);
		XmIterationState xmIterationState3=BaseUtils.fromMap(p3,XmIterationState.class);
		batchValues.add(xmIterationState3);
		Map p4=BaseUtils.map("id","50e2","distBudgetCost",6384.09,"distBudgetWorkload",1935.29,"actCost",7709.49,"actWorkload",6936.27,"actStaffNum",2799,"finishRate",1357.17,"testCases",7324,"execCases",8595,"designCases",7923,"finishCases",9678,"projectCnt",1639,"productCnt",3312,"menuCnt",7111,"taskCnt",1710,"finishTaskCnt",3433,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","Yi3p","budgetCost",7126.72,"budgetWorkload",3912.65,"iterationId","1K7Q","bizDate","82BK","closedBugCnt",5429,"resolvedBugCnt",3500,"activeBugCnt",2060,"confirmedBugCnt",479,"bugCnt",394);
		XmIterationState xmIterationState4=BaseUtils.fromMap(p4,XmIterationState.class);
		batchValues.add(xmIterationState4);
		Map p5=BaseUtils.map("id","uwBm","distBudgetCost",3302.98,"distBudgetWorkload",2348.81,"actCost",8707.42,"actWorkload",7541.24,"actStaffNum",4293,"finishRate",731.09,"testCases",5663,"execCases",1182,"designCases",1391,"finishCases",7160,"projectCnt",8822,"productCnt",8820,"menuCnt",8772,"taskCnt",6354,"finishTaskCnt",9169,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","5H9h","budgetCost",3231.85,"budgetWorkload",9117.95,"iterationId","4Gi5","bizDate","zN6N","closedBugCnt",9797,"resolvedBugCnt",5037,"activeBugCnt",328,"confirmedBugCnt",7516,"bugCnt",8366);
		XmIterationState xmIterationState5=BaseUtils.fromMap(p5,XmIterationState.class);
		batchValues.add(xmIterationState5);
		Map p6=BaseUtils.map("id","U55R","distBudgetCost",7172.27,"distBudgetWorkload",5872.42,"actCost",1791.22,"actWorkload",8138.91,"actStaffNum",8766,"finishRate",3716.61,"testCases",4043,"execCases",9215,"designCases",5373,"finishCases",4288,"projectCnt",7972,"productCnt",4353,"menuCnt",6979,"taskCnt",2198,"finishTaskCnt",5258,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","5ana","budgetCost",1934.83,"budgetWorkload",3156.04,"iterationId","12N3","bizDate","DDZ8","closedBugCnt",1612,"resolvedBugCnt",2891,"activeBugCnt",6345,"confirmedBugCnt",2729,"bugCnt",9786);
		XmIterationState xmIterationState6=BaseUtils.fromMap(p6,XmIterationState.class);
		batchValues.add(xmIterationState6);
		Map p7=BaseUtils.map("id","s59m","distBudgetCost",2448.26,"distBudgetWorkload",1655.3,"actCost",3623.94,"actWorkload",2439.07,"actStaffNum",143,"finishRate",6116.02,"testCases",9307,"execCases",8127,"designCases",7744,"finishCases",602,"projectCnt",4165,"productCnt",1071,"menuCnt",2721,"taskCnt",5302,"finishTaskCnt",1343,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","3P0R","budgetCost",5877.6,"budgetWorkload",7681.42,"iterationId","cwQR","bizDate","94Ni","closedBugCnt",9060,"resolvedBugCnt",8482,"activeBugCnt",6195,"confirmedBugCnt",5190,"bugCnt",2123);
		XmIterationState xmIterationState7=BaseUtils.fromMap(p7,XmIterationState.class);
		batchValues.add(xmIterationState7);
		baseDao.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmIterationState> batchValues=new ArrayList<XmIterationState>();
		Map p0=BaseUtils.map("id","1g8O","distBudgetCost",2580.66,"distBudgetWorkload",5963.69,"actCost",6187.77,"actWorkload",7364.31,"actStaffNum",7393,"finishRate",7196.84,"testCases",6244,"execCases",6389,"designCases",6823,"finishCases",5397,"projectCnt",4062,"productCnt",5338,"menuCnt",4450,"taskCnt",1630,"finishTaskCnt",4194,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","Md56","budgetCost",2647.08,"budgetWorkload",908.36,"iterationId","2yyX","bizDate","4Wb0","closedBugCnt",7878,"resolvedBugCnt",99,"activeBugCnt",9616,"confirmedBugCnt",8834,"bugCnt",6075);
		XmIterationState xmIterationState0=BaseUtils.fromMap(p0,XmIterationState.class);
		batchValues.add(xmIterationState0);
		Map p1=BaseUtils.map("id","ZVXU","distBudgetCost",4039.89,"distBudgetWorkload",791.91,"actCost",6663.8,"actWorkload",1743.53,"actStaffNum",6173,"finishRate",5431.77,"testCases",2955,"execCases",3610,"designCases",8610,"finishCases",2146,"projectCnt",6409,"productCnt",284,"menuCnt",3371,"taskCnt",7020,"finishTaskCnt",1279,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","TQ5Y","budgetCost",5224.22,"budgetWorkload",2657.73,"iterationId","wA92","bizDate","EvIo","closedBugCnt",452,"resolvedBugCnt",7760,"activeBugCnt",4337,"confirmedBugCnt",5244,"bugCnt",1083);
		XmIterationState xmIterationState1=BaseUtils.fromMap(p1,XmIterationState.class);
		batchValues.add(xmIterationState1);
		Map p2=BaseUtils.map("id","Ofra","distBudgetCost",3069.79,"distBudgetWorkload",4630.63,"actCost",1194.74,"actWorkload",6488.35,"actStaffNum",842,"finishRate",4049.9,"testCases",8309,"execCases",8807,"designCases",1313,"finishCases",3269,"projectCnt",4346,"productCnt",3566,"menuCnt",926,"taskCnt",3947,"finishTaskCnt",9202,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","0dfL","budgetCost",520.76,"budgetWorkload",2671.08,"iterationId","953G","bizDate","Vy02","closedBugCnt",3032,"resolvedBugCnt",4920,"activeBugCnt",2028,"confirmedBugCnt",6975,"bugCnt",9895);
		XmIterationState xmIterationState2=BaseUtils.fromMap(p2,XmIterationState.class);
		batchValues.add(xmIterationState2);
		Map p3=BaseUtils.map("id","15Pj","distBudgetCost",9186.19,"distBudgetWorkload",9378.9,"actCost",322.29,"actWorkload",84.87,"actStaffNum",5376,"finishRate",1031.1,"testCases",9862,"execCases",2058,"designCases",7208,"finishCases",9667,"projectCnt",2487,"productCnt",592,"menuCnt",6820,"taskCnt",6645,"finishTaskCnt",522,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","1URZ","budgetCost",9556.71,"budgetWorkload",6365.05,"iterationId","26UF","bizDate","fggZ","closedBugCnt",4593,"resolvedBugCnt",7244,"activeBugCnt",7306,"confirmedBugCnt",6867,"bugCnt",4282);
		XmIterationState xmIterationState3=BaseUtils.fromMap(p3,XmIterationState.class);
		batchValues.add(xmIterationState3);
		Map p4=BaseUtils.map("id","50e2","distBudgetCost",6384.09,"distBudgetWorkload",1935.29,"actCost",7709.49,"actWorkload",6936.27,"actStaffNum",2799,"finishRate",1357.17,"testCases",7324,"execCases",8595,"designCases",7923,"finishCases",9678,"projectCnt",1639,"productCnt",3312,"menuCnt",7111,"taskCnt",1710,"finishTaskCnt",3433,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","Yi3p","budgetCost",7126.72,"budgetWorkload",3912.65,"iterationId","1K7Q","bizDate","82BK","closedBugCnt",5429,"resolvedBugCnt",3500,"activeBugCnt",2060,"confirmedBugCnt",479,"bugCnt",394);
		XmIterationState xmIterationState4=BaseUtils.fromMap(p4,XmIterationState.class);
		batchValues.add(xmIterationState4);
		Map p5=BaseUtils.map("id","uwBm","distBudgetCost",3302.98,"distBudgetWorkload",2348.81,"actCost",8707.42,"actWorkload",7541.24,"actStaffNum",4293,"finishRate",731.09,"testCases",5663,"execCases",1182,"designCases",1391,"finishCases",7160,"projectCnt",8822,"productCnt",8820,"menuCnt",8772,"taskCnt",6354,"finishTaskCnt",9169,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","5H9h","budgetCost",3231.85,"budgetWorkload",9117.95,"iterationId","4Gi5","bizDate","zN6N","closedBugCnt",9797,"resolvedBugCnt",5037,"activeBugCnt",328,"confirmedBugCnt",7516,"bugCnt",8366);
		XmIterationState xmIterationState5=BaseUtils.fromMap(p5,XmIterationState.class);
		batchValues.add(xmIterationState5);
		Map p6=BaseUtils.map("id","U55R","distBudgetCost",7172.27,"distBudgetWorkload",5872.42,"actCost",1791.22,"actWorkload",8138.91,"actStaffNum",8766,"finishRate",3716.61,"testCases",4043,"execCases",9215,"designCases",5373,"finishCases",4288,"projectCnt",7972,"productCnt",4353,"menuCnt",6979,"taskCnt",2198,"finishTaskCnt",5258,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","5ana","budgetCost",1934.83,"budgetWorkload",3156.04,"iterationId","12N3","bizDate","DDZ8","closedBugCnt",1612,"resolvedBugCnt",2891,"activeBugCnt",6345,"confirmedBugCnt",2729,"bugCnt",9786);
		XmIterationState xmIterationState6=BaseUtils.fromMap(p6,XmIterationState.class);
		batchValues.add(xmIterationState6);
		Map p7=BaseUtils.map("id","s59m","distBudgetCost",2448.26,"distBudgetWorkload",1655.3,"actCost",3623.94,"actWorkload",2439.07,"actStaffNum",143,"finishRate",6116.02,"testCases",9307,"execCases",8127,"designCases",7744,"finishCases",602,"projectCnt",4165,"productCnt",1071,"menuCnt",2721,"taskCnt",5302,"finishTaskCnt",1343,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","3P0R","budgetCost",5877.6,"budgetWorkload",7681.42,"iterationId","cwQR","bizDate","94Ni","closedBugCnt",9060,"resolvedBugCnt",8482,"activeBugCnt",6195,"confirmedBugCnt",5190,"bugCnt",2123);
		XmIterationState xmIterationState7=BaseUtils.fromMap(p7,XmIterationState.class);
		batchValues.add(xmIterationState7);
		baseDao.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmIterationState> batchValues=new ArrayList<XmIterationState>();
		Map p0=BaseUtils.map("id","1g8O","distBudgetCost",2580.66,"distBudgetWorkload",5963.69,"actCost",6187.77,"actWorkload",7364.31,"actStaffNum",7393,"finishRate",7196.84,"testCases",6244,"execCases",6389,"designCases",6823,"finishCases",5397,"projectCnt",4062,"productCnt",5338,"menuCnt",4450,"taskCnt",1630,"finishTaskCnt",4194,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","Md56","budgetCost",2647.08,"budgetWorkload",908.36,"iterationId","2yyX","bizDate","4Wb0","closedBugCnt",7878,"resolvedBugCnt",99,"activeBugCnt",9616,"confirmedBugCnt",8834,"bugCnt",6075);
		XmIterationState xmIterationState0=BaseUtils.fromMap(p0,XmIterationState.class);
		batchValues.add(xmIterationState0);
		Map p1=BaseUtils.map("id","ZVXU","distBudgetCost",4039.89,"distBudgetWorkload",791.91,"actCost",6663.8,"actWorkload",1743.53,"actStaffNum",6173,"finishRate",5431.77,"testCases",2955,"execCases",3610,"designCases",8610,"finishCases",2146,"projectCnt",6409,"productCnt",284,"menuCnt",3371,"taskCnt",7020,"finishTaskCnt",1279,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","TQ5Y","budgetCost",5224.22,"budgetWorkload",2657.73,"iterationId","wA92","bizDate","EvIo","closedBugCnt",452,"resolvedBugCnt",7760,"activeBugCnt",4337,"confirmedBugCnt",5244,"bugCnt",1083);
		XmIterationState xmIterationState1=BaseUtils.fromMap(p1,XmIterationState.class);
		batchValues.add(xmIterationState1);
		Map p2=BaseUtils.map("id","Ofra","distBudgetCost",3069.79,"distBudgetWorkload",4630.63,"actCost",1194.74,"actWorkload",6488.35,"actStaffNum",842,"finishRate",4049.9,"testCases",8309,"execCases",8807,"designCases",1313,"finishCases",3269,"projectCnt",4346,"productCnt",3566,"menuCnt",926,"taskCnt",3947,"finishTaskCnt",9202,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","0dfL","budgetCost",520.76,"budgetWorkload",2671.08,"iterationId","953G","bizDate","Vy02","closedBugCnt",3032,"resolvedBugCnt",4920,"activeBugCnt",2028,"confirmedBugCnt",6975,"bugCnt",9895);
		XmIterationState xmIterationState2=BaseUtils.fromMap(p2,XmIterationState.class);
		batchValues.add(xmIterationState2);
		Map p3=BaseUtils.map("id","15Pj","distBudgetCost",9186.19,"distBudgetWorkload",9378.9,"actCost",322.29,"actWorkload",84.87,"actStaffNum",5376,"finishRate",1031.1,"testCases",9862,"execCases",2058,"designCases",7208,"finishCases",9667,"projectCnt",2487,"productCnt",592,"menuCnt",6820,"taskCnt",6645,"finishTaskCnt",522,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","1URZ","budgetCost",9556.71,"budgetWorkload",6365.05,"iterationId","26UF","bizDate","fggZ","closedBugCnt",4593,"resolvedBugCnt",7244,"activeBugCnt",7306,"confirmedBugCnt",6867,"bugCnt",4282);
		XmIterationState xmIterationState3=BaseUtils.fromMap(p3,XmIterationState.class);
		batchValues.add(xmIterationState3);
		Map p4=BaseUtils.map("id","50e2","distBudgetCost",6384.09,"distBudgetWorkload",1935.29,"actCost",7709.49,"actWorkload",6936.27,"actStaffNum",2799,"finishRate",1357.17,"testCases",7324,"execCases",8595,"designCases",7923,"finishCases",9678,"projectCnt",1639,"productCnt",3312,"menuCnt",7111,"taskCnt",1710,"finishTaskCnt",3433,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","Yi3p","budgetCost",7126.72,"budgetWorkload",3912.65,"iterationId","1K7Q","bizDate","82BK","closedBugCnt",5429,"resolvedBugCnt",3500,"activeBugCnt",2060,"confirmedBugCnt",479,"bugCnt",394);
		XmIterationState xmIterationState4=BaseUtils.fromMap(p4,XmIterationState.class);
		batchValues.add(xmIterationState4);
		Map p5=BaseUtils.map("id","uwBm","distBudgetCost",3302.98,"distBudgetWorkload",2348.81,"actCost",8707.42,"actWorkload",7541.24,"actStaffNum",4293,"finishRate",731.09,"testCases",5663,"execCases",1182,"designCases",1391,"finishCases",7160,"projectCnt",8822,"productCnt",8820,"menuCnt",8772,"taskCnt",6354,"finishTaskCnt",9169,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","5H9h","budgetCost",3231.85,"budgetWorkload",9117.95,"iterationId","4Gi5","bizDate","zN6N","closedBugCnt",9797,"resolvedBugCnt",5037,"activeBugCnt",328,"confirmedBugCnt",7516,"bugCnt",8366);
		XmIterationState xmIterationState5=BaseUtils.fromMap(p5,XmIterationState.class);
		batchValues.add(xmIterationState5);
		Map p6=BaseUtils.map("id","U55R","distBudgetCost",7172.27,"distBudgetWorkload",5872.42,"actCost",1791.22,"actWorkload",8138.91,"actStaffNum",8766,"finishRate",3716.61,"testCases",4043,"execCases",9215,"designCases",5373,"finishCases",4288,"projectCnt",7972,"productCnt",4353,"menuCnt",6979,"taskCnt",2198,"finishTaskCnt",5258,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","5ana","budgetCost",1934.83,"budgetWorkload",3156.04,"iterationId","12N3","bizDate","DDZ8","closedBugCnt",1612,"resolvedBugCnt",2891,"activeBugCnt",6345,"confirmedBugCnt",2729,"bugCnt",9786);
		XmIterationState xmIterationState6=BaseUtils.fromMap(p6,XmIterationState.class);
		batchValues.add(xmIterationState6);
		Map p7=BaseUtils.map("id","s59m","distBudgetCost",2448.26,"distBudgetWorkload",1655.3,"actCost",3623.94,"actWorkload",2439.07,"actStaffNum",143,"finishRate",6116.02,"testCases",9307,"execCases",8127,"designCases",7744,"finishCases",602,"projectCnt",4165,"productCnt",1071,"menuCnt",2721,"taskCnt",5302,"finishTaskCnt",1343,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","3P0R","budgetCost",5877.6,"budgetWorkload",7681.42,"iterationId","cwQR","bizDate","94Ni","closedBugCnt",9060,"resolvedBugCnt",8482,"activeBugCnt",6195,"confirmedBugCnt",5190,"bugCnt",2123);
		XmIterationState xmIterationState7=BaseUtils.fromMap(p7,XmIterationState.class);
		batchValues.add(xmIterationState7);
		baseDao.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","1g8O");
		Map<String,Object> result=this.baseDao.selectOne(XmIterationState.class.getName()+".selectOneMap",p);
		Assert.assertEquals("1g8O", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("distBudgetCost",2580.66,"distBudgetWorkload",5963.69,"actCost",6187.77,"actWorkload",7364.31,"actStaffNum",7393,"finishRate",7196.84,"testCases",6244,"execCases",6389,"designCases",6823,"finishCases",5397,"projectCnt",4062,"productCnt",5338,"menuCnt",4450,"taskCnt",1630,"finishTaskCnt",4194,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","Md56","budgetCost",2647.08,"budgetWorkload",908.36,"iterationId","2yyX","bizDate","4Wb0","closedBugCnt",7878,"resolvedBugCnt",99,"activeBugCnt",9616,"confirmedBugCnt",8834,"bugCnt",6075);
		XmIterationState xmIterationState=BaseUtils.fromMap(p,XmIterationState.class);
		long result=baseDao.countByWhere(xmIterationState);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
 		
		
		Map<String,Object> p=BaseUtils.map("distBudgetCost",2580.66,"distBudgetWorkload",5963.69,"actCost",6187.77,"actWorkload",7364.31,"actStaffNum",7393,"finishRate",7196.84,"testCases",6244,"execCases",6389,"designCases",6823,"finishCases",5397,"projectCnt",4062,"productCnt",5338,"menuCnt",4450,"taskCnt",1630,"finishTaskCnt",4194,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","Md56","budgetCost",2647.08,"budgetWorkload",908.36,"iterationId","2yyX","bizDate","4Wb0","closedBugCnt",7878,"resolvedBugCnt",99,"activeBugCnt",9616,"confirmedBugCnt",8834,"bugCnt",6075);
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmIterationState xmIterationState=BaseUtils.fromMap(p,XmIterationState.class);
		List<XmIterationState> result=baseDao.selectListByWhere(xmIterationState); 
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
	
		
		Map<String,Object> p=BaseUtils.map("distBudgetCost",2580.66,"distBudgetWorkload",5963.69,"actCost",6187.77,"actWorkload",7364.31,"actStaffNum",7393,"finishRate",7196.84,"testCases",6244,"execCases",6389,"designCases",6823,"finishCases",5397,"projectCnt",4062,"productCnt",5338,"menuCnt",4450,"taskCnt",1630,"finishTaskCnt",4194,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","Md56","budgetCost",2647.08,"budgetWorkload",908.36,"iterationId","2yyX","bizDate","4Wb0","closedBugCnt",7878,"resolvedBugCnt",99,"activeBugCnt",9616,"confirmedBugCnt",8834,"bugCnt",6075);
		XmIterationState xmIterationState=BaseUtils.fromMap(p,XmIterationState.class);
		List<XmIterationState> result=baseDao.selectListByWhere(xmIterationState);
		Assert.assertEquals(true, result.size()>=1);
	}

	
	/**
	 * 查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("distBudgetCost",2580.66,"distBudgetWorkload",5963.69,"actCost",6187.77,"actWorkload",7364.31,"actStaffNum",7393,"finishRate",7196.84,"testCases",6244,"execCases",6389,"designCases",6823,"finishCases",5397,"projectCnt",4062,"productCnt",5338,"menuCnt",4450,"taskCnt",1630,"finishTaskCnt",4194,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","Md56","budgetCost",2647.08,"budgetWorkload",908.36,"iterationId","2yyX","bizDate","4Wb0","closedBugCnt",7878,"resolvedBugCnt",99,"activeBugCnt",9616,"confirmedBugCnt",8834,"bugCnt",6075);
		List<Map<String,Object>> result=baseDao.selectList(XmIterationState.class.getName()+".selectListMapByWhere",p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("distBudgetCost",2580.66,"distBudgetWorkload",5963.69,"actCost",6187.77,"actWorkload",7364.31,"actStaffNum",7393,"finishRate",7196.84,"testCases",6244,"execCases",6389,"designCases",6823,"finishCases",5397,"projectCnt",4062,"productCnt",5338,"menuCnt",4450,"taskCnt",1630,"finishTaskCnt",4194,"calcTime",parse("2020-11-11 18:53:24"),"iterationName","Md56","budgetCost",2647.08,"budgetWorkload",908.36,"iterationId","2yyX","bizDate","4Wb0","closedBugCnt",7878,"resolvedBugCnt",99,"activeBugCnt",9616,"confirmedBugCnt",8834,"bugCnt",6075);
		List<Map<String,Object>> result=baseDao.selectList(XmIterationState.class.getName()+".selectListMapByKey",p);
		Assert.assertEquals(true, result.size()>=0);
	}
 
	/**
	 * 查询一个对象 XmIterationState
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","1g8O");
		
		XmIterationState xmIterationState1=BaseUtils.fromMap(p,XmIterationState.class);
		XmIterationState xmIterationState=baseDao.selectOneObject(xmIterationState1);
		Assert.assertEquals("1g8O", xmIterationState.getId());
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
