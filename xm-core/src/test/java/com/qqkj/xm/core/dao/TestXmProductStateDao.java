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
import com.qqkj.xm.core.entity.XmProductState;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmProductStateDao的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_product_state 功能状态表,无需前端维护，所有数据由汇总统计得出<br>
 * 实体 XmProductState<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,planStartTime,planEndTime,actStartTime,actEndTime,planWorkload,actWorkload,planCostAmount,actCostAmount,finishRate,demandRate,designRate,devRate,uatRate,sitRate,ctime,ltime,cuserid,cusername,calcTime,planWorkhours,planWorkerCnt,closedBugs,activeBugs,confirmedBugs,resolvedBugs,productId,productName,testCases,execCases,designCases,finishCases,projectCnt,iterationCnt,taskCnt,finishTaskCnt,bizDate,branchId,bugCnt;<br>
 * 当前表的所有字段名:<br>
 *	id,plan_start_time,plan_end_time,act_start_time,act_end_time,plan_workload,act_workload,plan_cost_amount,act_cost_amount,finish_rate,demand_rate,design_rate,dev_rate,uat_rate,sit_rate,ctime,ltime,cuserid,cusername,calc_time,plan_workhours,plan_worker_cnt,closed_bugs,active_bugs,confirmed_bugs,resolved_bugs,product_id,product_name,test_cases,exec_cases,design_cases,finish_cases,project_cnt,iteration_cnt,task_cnt,finish_task_cnt,biz_date,branch_id,bug_cnt;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/
 @RunWith(SpringJUnit4ClassRunner.class)
 @SpringBootTest
public class TestXmProductStateDao  {

	@Autowired
	BaseDao baseDao;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","16A9","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",6759.81,"actWorkload",7481.08,"planCostAmount",7711.91,"actCostAmount",6571.38,"finishRate",958.62,"demandRate",5923.61,"designRate",1050.6,"devRate",7740.03,"uatRate",2278.37,"sitRate",2987.53,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","aUHt","cusername","6H1M","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",3065.83,"planWorkerCnt",3604,"closedBugs",7249,"activeBugs",5944,"confirmedBugs",2349,"resolvedBugs",4427,"productId","tQLs","productName","wFpv","testCases",2957,"execCases",417,"designCases",1798,"finishCases",1228,"projectCnt",2462,"iterationCnt",8541,"taskCnt",1352,"finishTaskCnt",6859,"bizDate","jWmR","branchId","NfPV","bugCnt",3688);
		XmProductState xmProductState=BaseUtils.fromMap(p,XmProductState.class);
		baseDao.insert(xmProductState);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",6759.81,"actWorkload",7481.08,"planCostAmount",7711.91,"actCostAmount",6571.38,"finishRate",958.62,"demandRate",5923.61,"designRate",1050.6,"devRate",7740.03,"uatRate",2278.37,"sitRate",2987.53,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","aUHt","cusername","6H1M","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",3065.83,"planWorkerCnt",3604,"closedBugs",7249,"activeBugs",5944,"confirmedBugs",2349,"resolvedBugs",4427,"productId","tQLs","productName","wFpv","testCases",2957,"execCases",417,"designCases",1798,"finishCases",1228,"projectCnt",2462,"iterationCnt",8541,"taskCnt",1352,"finishTaskCnt",6859,"bizDate","jWmR","branchId","NfPV","bugCnt",3688);
		XmProductState xmProductState=BaseUtils.fromMap(p,XmProductState.class);
		baseDao.deleteByWhere(xmProductState);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","16A9");
		XmProductState xmProductState=BaseUtils.fromMap(p,XmProductState.class);
		baseDao.deleteByPk(xmProductState);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",6759.81,"actWorkload",7481.08,"planCostAmount",7711.91,"actCostAmount",6571.38,"finishRate",958.62,"demandRate",5923.61,"designRate",1050.6,"devRate",7740.03,"uatRate",2278.37,"sitRate",2987.53,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","aUHt","cusername","6H1M","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",3065.83,"planWorkerCnt",3604,"closedBugs",7249,"activeBugs",5944,"confirmedBugs",2349,"resolvedBugs",4427,"productId","tQLs","productName","wFpv","testCases",2957,"execCases",417,"designCases",1798,"finishCases",1228,"projectCnt",2462,"iterationCnt",8541,"taskCnt",1352,"finishTaskCnt",6859,"bizDate","jWmR","branchId","NfPV","bugCnt",3688);
		XmProductState xmProductState=BaseUtils.fromMap(where,XmProductState.class);
		baseDao.updateSomeFieldByPk(xmProductState);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","16A9");
		XmProductState xmProductState=BaseUtils.fromMap(p,XmProductState.class);
		baseDao.updateByPk(xmProductState);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("id","16A9","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",6759.81,"actWorkload",7481.08,"planCostAmount",7711.91,"actCostAmount",6571.38,"finishRate",958.62,"demandRate",5923.61,"designRate",1050.6,"devRate",7740.03,"uatRate",2278.37,"sitRate",2987.53,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","aUHt","cusername","6H1M","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",3065.83,"planWorkerCnt",3604,"closedBugs",7249,"activeBugs",5944,"confirmedBugs",2349,"resolvedBugs",4427,"productId","tQLs","productName","wFpv","testCases",2957,"execCases",417,"designCases",1798,"finishCases",1228,"projectCnt",2462,"iterationCnt",8541,"taskCnt",1352,"finishTaskCnt",6859,"bizDate","jWmR","branchId","NfPV","bugCnt",3688);
		XmProductState xmProductState=BaseUtils.fromMap(p,XmProductState.class);
		baseDao.insertOrUpdate(xmProductState);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmProductState> batchValues=new ArrayList<XmProductState>();
		Map p0=BaseUtils.map("id","16A9","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",6759.81,"actWorkload",7481.08,"planCostAmount",7711.91,"actCostAmount",6571.38,"finishRate",958.62,"demandRate",5923.61,"designRate",1050.6,"devRate",7740.03,"uatRate",2278.37,"sitRate",2987.53,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","aUHt","cusername","6H1M","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",3065.83,"planWorkerCnt",3604,"closedBugs",7249,"activeBugs",5944,"confirmedBugs",2349,"resolvedBugs",4427,"productId","tQLs","productName","wFpv","testCases",2957,"execCases",417,"designCases",1798,"finishCases",1228,"projectCnt",2462,"iterationCnt",8541,"taskCnt",1352,"finishTaskCnt",6859,"bizDate","jWmR","branchId","NfPV","bugCnt",3688);
		XmProductState xmProductState0=BaseUtils.fromMap(p0,XmProductState.class);
		batchValues.add(xmProductState0);
		Map p1=BaseUtils.map("id","T5pm","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",7351.47,"actWorkload",3553.56,"planCostAmount",1071.93,"actCostAmount",3796.22,"finishRate",2258.33,"demandRate",4800.21,"designRate",5135.83,"devRate",7675.75,"uatRate",6457.4,"sitRate",9798.34,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","smOK","cusername","2vVD","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",2054.1,"planWorkerCnt",6882,"closedBugs",9045,"activeBugs",6568,"confirmedBugs",5248,"resolvedBugs",3973,"productId","44fd","productName","Uijn","testCases",311,"execCases",8692,"designCases",683,"finishCases",649,"projectCnt",2914,"iterationCnt",7210,"taskCnt",9102,"finishTaskCnt",951,"bizDate","672T","branchId","uvbx","bugCnt",4905);
		XmProductState xmProductState1=BaseUtils.fromMap(p1,XmProductState.class);
		batchValues.add(xmProductState1);
		Map p2=BaseUtils.map("id","GCnQ","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",3866.88,"actWorkload",6429.53,"planCostAmount",3438.21,"actCostAmount",8161.43,"finishRate",7980.94,"demandRate",1895.55,"designRate",9110.99,"devRate",9219.79,"uatRate",3453.78,"sitRate",1241.04,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","UmqF","cusername","BpBA","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",23.02,"planWorkerCnt",6166,"closedBugs",9247,"activeBugs",8829,"confirmedBugs",8958,"resolvedBugs",431,"productId","cC62","productName","oOk6","testCases",6267,"execCases",4668,"designCases",8665,"finishCases",5048,"projectCnt",8452,"iterationCnt",912,"taskCnt",313,"finishTaskCnt",9308,"bizDate","CBkP","branchId","38OV","bugCnt",4109);
		XmProductState xmProductState2=BaseUtils.fromMap(p2,XmProductState.class);
		batchValues.add(xmProductState2);
		Map p3=BaseUtils.map("id","7zV8","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",7635.09,"actWorkload",2838.92,"planCostAmount",702.85,"actCostAmount",7997.91,"finishRate",83.53,"demandRate",2897.85,"designRate",2548.42,"devRate",8562.43,"uatRate",3861.68,"sitRate",3108,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","st3p","cusername","95Nr","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",9411.09,"planWorkerCnt",6188,"closedBugs",1724,"activeBugs",2381,"confirmedBugs",6445,"resolvedBugs",4850,"productId","LqS5","productName","SnDc","testCases",1981,"execCases",8513,"designCases",3722,"finishCases",2461,"projectCnt",9130,"iterationCnt",9832,"taskCnt",7495,"finishTaskCnt",1640,"bizDate","MClr","branchId","5Jls","bugCnt",9157);
		XmProductState xmProductState3=BaseUtils.fromMap(p3,XmProductState.class);
		batchValues.add(xmProductState3);
		Map p4=BaseUtils.map("id","65JX","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",2837.35,"actWorkload",5023.66,"planCostAmount",16.65,"actCostAmount",1961.31,"finishRate",6564.13,"demandRate",8787.2,"designRate",9943.18,"devRate",9669.33,"uatRate",928.52,"sitRate",4210.22,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","0jUK","cusername","OaGF","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",9375.14,"planWorkerCnt",8622,"closedBugs",4718,"activeBugs",8882,"confirmedBugs",5692,"resolvedBugs",6628,"productId","T9zr","productName","Obqb","testCases",6309,"execCases",1710,"designCases",4195,"finishCases",2925,"projectCnt",5923,"iterationCnt",1741,"taskCnt",6856,"finishTaskCnt",7338,"bizDate","n30a","branchId","jdqd","bugCnt",6137);
		XmProductState xmProductState4=BaseUtils.fromMap(p4,XmProductState.class);
		batchValues.add(xmProductState4);
		Map p5=BaseUtils.map("id","a094","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",9457.33,"actWorkload",8738.03,"planCostAmount",2389.57,"actCostAmount",5975.39,"finishRate",1584.53,"demandRate",4823.23,"designRate",340.26,"devRate",591.49,"uatRate",787.13,"sitRate",2060.8,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","3K7H","cusername","pLqW","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",8327.77,"planWorkerCnt",6164,"closedBugs",5805,"activeBugs",927,"confirmedBugs",7861,"resolvedBugs",4615,"productId","6iDh","productName","a9P4","testCases",5165,"execCases",9205,"designCases",7704,"finishCases",3667,"projectCnt",4098,"iterationCnt",8875,"taskCnt",5503,"finishTaskCnt",4092,"bizDate","2yEm","branchId","fiGU","bugCnt",2453);
		XmProductState xmProductState5=BaseUtils.fromMap(p5,XmProductState.class);
		batchValues.add(xmProductState5);
		Map p6=BaseUtils.map("id","vDrP","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",9883.1,"actWorkload",9534.95,"planCostAmount",5614.75,"actCostAmount",8870.29,"finishRate",1561.67,"demandRate",1510.68,"designRate",6944.32,"devRate",2067.3,"uatRate",2039.67,"sitRate",7352.85,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","ku3p","cusername","99ic","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",6933.34,"planWorkerCnt",6929,"closedBugs",5399,"activeBugs",287,"confirmedBugs",5313,"resolvedBugs",5350,"productId","XIt4","productName","4A5C","testCases",4651,"execCases",4635,"designCases",4133,"finishCases",2759,"projectCnt",8560,"iterationCnt",7153,"taskCnt",161,"finishTaskCnt",2978,"bizDate","GWvG","branchId","sYXf","bugCnt",1778);
		XmProductState xmProductState6=BaseUtils.fromMap(p6,XmProductState.class);
		batchValues.add(xmProductState6);
		Map p7=BaseUtils.map("id","Ym1i","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",4775.63,"actWorkload",725.92,"planCostAmount",4685.02,"actCostAmount",127.11,"finishRate",1752.78,"demandRate",6395.64,"designRate",2443.47,"devRate",1821.64,"uatRate",8176.08,"sitRate",725.82,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","s5qc","cusername","h1ck","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",2748.24,"planWorkerCnt",762,"closedBugs",3360,"activeBugs",748,"confirmedBugs",7681,"resolvedBugs",5859,"productId","3vW9","productName","Hfwj","testCases",3525,"execCases",9372,"designCases",9390,"finishCases",755,"projectCnt",4548,"iterationCnt",8122,"taskCnt",9339,"finishTaskCnt",1702,"bizDate","rVFJ","branchId","3BRg","bugCnt",7946);
		XmProductState xmProductState7=BaseUtils.fromMap(p7,XmProductState.class);
		batchValues.add(xmProductState7);
		baseDao.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmProductState> batchValues=new ArrayList<XmProductState>();
		Map p0=BaseUtils.map("id","16A9","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",6759.81,"actWorkload",7481.08,"planCostAmount",7711.91,"actCostAmount",6571.38,"finishRate",958.62,"demandRate",5923.61,"designRate",1050.6,"devRate",7740.03,"uatRate",2278.37,"sitRate",2987.53,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","aUHt","cusername","6H1M","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",3065.83,"planWorkerCnt",3604,"closedBugs",7249,"activeBugs",5944,"confirmedBugs",2349,"resolvedBugs",4427,"productId","tQLs","productName","wFpv","testCases",2957,"execCases",417,"designCases",1798,"finishCases",1228,"projectCnt",2462,"iterationCnt",8541,"taskCnt",1352,"finishTaskCnt",6859,"bizDate","jWmR","branchId","NfPV","bugCnt",3688);
		XmProductState xmProductState0=BaseUtils.fromMap(p0,XmProductState.class);
		batchValues.add(xmProductState0);
		Map p1=BaseUtils.map("id","T5pm","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",7351.47,"actWorkload",3553.56,"planCostAmount",1071.93,"actCostAmount",3796.22,"finishRate",2258.33,"demandRate",4800.21,"designRate",5135.83,"devRate",7675.75,"uatRate",6457.4,"sitRate",9798.34,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","smOK","cusername","2vVD","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",2054.1,"planWorkerCnt",6882,"closedBugs",9045,"activeBugs",6568,"confirmedBugs",5248,"resolvedBugs",3973,"productId","44fd","productName","Uijn","testCases",311,"execCases",8692,"designCases",683,"finishCases",649,"projectCnt",2914,"iterationCnt",7210,"taskCnt",9102,"finishTaskCnt",951,"bizDate","672T","branchId","uvbx","bugCnt",4905);
		XmProductState xmProductState1=BaseUtils.fromMap(p1,XmProductState.class);
		batchValues.add(xmProductState1);
		Map p2=BaseUtils.map("id","GCnQ","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",3866.88,"actWorkload",6429.53,"planCostAmount",3438.21,"actCostAmount",8161.43,"finishRate",7980.94,"demandRate",1895.55,"designRate",9110.99,"devRate",9219.79,"uatRate",3453.78,"sitRate",1241.04,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","UmqF","cusername","BpBA","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",23.02,"planWorkerCnt",6166,"closedBugs",9247,"activeBugs",8829,"confirmedBugs",8958,"resolvedBugs",431,"productId","cC62","productName","oOk6","testCases",6267,"execCases",4668,"designCases",8665,"finishCases",5048,"projectCnt",8452,"iterationCnt",912,"taskCnt",313,"finishTaskCnt",9308,"bizDate","CBkP","branchId","38OV","bugCnt",4109);
		XmProductState xmProductState2=BaseUtils.fromMap(p2,XmProductState.class);
		batchValues.add(xmProductState2);
		Map p3=BaseUtils.map("id","7zV8","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",7635.09,"actWorkload",2838.92,"planCostAmount",702.85,"actCostAmount",7997.91,"finishRate",83.53,"demandRate",2897.85,"designRate",2548.42,"devRate",8562.43,"uatRate",3861.68,"sitRate",3108,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","st3p","cusername","95Nr","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",9411.09,"planWorkerCnt",6188,"closedBugs",1724,"activeBugs",2381,"confirmedBugs",6445,"resolvedBugs",4850,"productId","LqS5","productName","SnDc","testCases",1981,"execCases",8513,"designCases",3722,"finishCases",2461,"projectCnt",9130,"iterationCnt",9832,"taskCnt",7495,"finishTaskCnt",1640,"bizDate","MClr","branchId","5Jls","bugCnt",9157);
		XmProductState xmProductState3=BaseUtils.fromMap(p3,XmProductState.class);
		batchValues.add(xmProductState3);
		Map p4=BaseUtils.map("id","65JX","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",2837.35,"actWorkload",5023.66,"planCostAmount",16.65,"actCostAmount",1961.31,"finishRate",6564.13,"demandRate",8787.2,"designRate",9943.18,"devRate",9669.33,"uatRate",928.52,"sitRate",4210.22,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","0jUK","cusername","OaGF","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",9375.14,"planWorkerCnt",8622,"closedBugs",4718,"activeBugs",8882,"confirmedBugs",5692,"resolvedBugs",6628,"productId","T9zr","productName","Obqb","testCases",6309,"execCases",1710,"designCases",4195,"finishCases",2925,"projectCnt",5923,"iterationCnt",1741,"taskCnt",6856,"finishTaskCnt",7338,"bizDate","n30a","branchId","jdqd","bugCnt",6137);
		XmProductState xmProductState4=BaseUtils.fromMap(p4,XmProductState.class);
		batchValues.add(xmProductState4);
		Map p5=BaseUtils.map("id","a094","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",9457.33,"actWorkload",8738.03,"planCostAmount",2389.57,"actCostAmount",5975.39,"finishRate",1584.53,"demandRate",4823.23,"designRate",340.26,"devRate",591.49,"uatRate",787.13,"sitRate",2060.8,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","3K7H","cusername","pLqW","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",8327.77,"planWorkerCnt",6164,"closedBugs",5805,"activeBugs",927,"confirmedBugs",7861,"resolvedBugs",4615,"productId","6iDh","productName","a9P4","testCases",5165,"execCases",9205,"designCases",7704,"finishCases",3667,"projectCnt",4098,"iterationCnt",8875,"taskCnt",5503,"finishTaskCnt",4092,"bizDate","2yEm","branchId","fiGU","bugCnt",2453);
		XmProductState xmProductState5=BaseUtils.fromMap(p5,XmProductState.class);
		batchValues.add(xmProductState5);
		Map p6=BaseUtils.map("id","vDrP","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",9883.1,"actWorkload",9534.95,"planCostAmount",5614.75,"actCostAmount",8870.29,"finishRate",1561.67,"demandRate",1510.68,"designRate",6944.32,"devRate",2067.3,"uatRate",2039.67,"sitRate",7352.85,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","ku3p","cusername","99ic","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",6933.34,"planWorkerCnt",6929,"closedBugs",5399,"activeBugs",287,"confirmedBugs",5313,"resolvedBugs",5350,"productId","XIt4","productName","4A5C","testCases",4651,"execCases",4635,"designCases",4133,"finishCases",2759,"projectCnt",8560,"iterationCnt",7153,"taskCnt",161,"finishTaskCnt",2978,"bizDate","GWvG","branchId","sYXf","bugCnt",1778);
		XmProductState xmProductState6=BaseUtils.fromMap(p6,XmProductState.class);
		batchValues.add(xmProductState6);
		Map p7=BaseUtils.map("id","Ym1i","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",4775.63,"actWorkload",725.92,"planCostAmount",4685.02,"actCostAmount",127.11,"finishRate",1752.78,"demandRate",6395.64,"designRate",2443.47,"devRate",1821.64,"uatRate",8176.08,"sitRate",725.82,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","s5qc","cusername","h1ck","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",2748.24,"planWorkerCnt",762,"closedBugs",3360,"activeBugs",748,"confirmedBugs",7681,"resolvedBugs",5859,"productId","3vW9","productName","Hfwj","testCases",3525,"execCases",9372,"designCases",9390,"finishCases",755,"projectCnt",4548,"iterationCnt",8122,"taskCnt",9339,"finishTaskCnt",1702,"bizDate","rVFJ","branchId","3BRg","bugCnt",7946);
		XmProductState xmProductState7=BaseUtils.fromMap(p7,XmProductState.class);
		batchValues.add(xmProductState7);
		baseDao.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmProductState> batchValues=new ArrayList<XmProductState>();
		Map p0=BaseUtils.map("id","16A9","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",6759.81,"actWorkload",7481.08,"planCostAmount",7711.91,"actCostAmount",6571.38,"finishRate",958.62,"demandRate",5923.61,"designRate",1050.6,"devRate",7740.03,"uatRate",2278.37,"sitRate",2987.53,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","aUHt","cusername","6H1M","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",3065.83,"planWorkerCnt",3604,"closedBugs",7249,"activeBugs",5944,"confirmedBugs",2349,"resolvedBugs",4427,"productId","tQLs","productName","wFpv","testCases",2957,"execCases",417,"designCases",1798,"finishCases",1228,"projectCnt",2462,"iterationCnt",8541,"taskCnt",1352,"finishTaskCnt",6859,"bizDate","jWmR","branchId","NfPV","bugCnt",3688);
		XmProductState xmProductState0=BaseUtils.fromMap(p0,XmProductState.class);
		batchValues.add(xmProductState0);
		Map p1=BaseUtils.map("id","T5pm","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",7351.47,"actWorkload",3553.56,"planCostAmount",1071.93,"actCostAmount",3796.22,"finishRate",2258.33,"demandRate",4800.21,"designRate",5135.83,"devRate",7675.75,"uatRate",6457.4,"sitRate",9798.34,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","smOK","cusername","2vVD","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",2054.1,"planWorkerCnt",6882,"closedBugs",9045,"activeBugs",6568,"confirmedBugs",5248,"resolvedBugs",3973,"productId","44fd","productName","Uijn","testCases",311,"execCases",8692,"designCases",683,"finishCases",649,"projectCnt",2914,"iterationCnt",7210,"taskCnt",9102,"finishTaskCnt",951,"bizDate","672T","branchId","uvbx","bugCnt",4905);
		XmProductState xmProductState1=BaseUtils.fromMap(p1,XmProductState.class);
		batchValues.add(xmProductState1);
		Map p2=BaseUtils.map("id","GCnQ","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",3866.88,"actWorkload",6429.53,"planCostAmount",3438.21,"actCostAmount",8161.43,"finishRate",7980.94,"demandRate",1895.55,"designRate",9110.99,"devRate",9219.79,"uatRate",3453.78,"sitRate",1241.04,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","UmqF","cusername","BpBA","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",23.02,"planWorkerCnt",6166,"closedBugs",9247,"activeBugs",8829,"confirmedBugs",8958,"resolvedBugs",431,"productId","cC62","productName","oOk6","testCases",6267,"execCases",4668,"designCases",8665,"finishCases",5048,"projectCnt",8452,"iterationCnt",912,"taskCnt",313,"finishTaskCnt",9308,"bizDate","CBkP","branchId","38OV","bugCnt",4109);
		XmProductState xmProductState2=BaseUtils.fromMap(p2,XmProductState.class);
		batchValues.add(xmProductState2);
		Map p3=BaseUtils.map("id","7zV8","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",7635.09,"actWorkload",2838.92,"planCostAmount",702.85,"actCostAmount",7997.91,"finishRate",83.53,"demandRate",2897.85,"designRate",2548.42,"devRate",8562.43,"uatRate",3861.68,"sitRate",3108,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","st3p","cusername","95Nr","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",9411.09,"planWorkerCnt",6188,"closedBugs",1724,"activeBugs",2381,"confirmedBugs",6445,"resolvedBugs",4850,"productId","LqS5","productName","SnDc","testCases",1981,"execCases",8513,"designCases",3722,"finishCases",2461,"projectCnt",9130,"iterationCnt",9832,"taskCnt",7495,"finishTaskCnt",1640,"bizDate","MClr","branchId","5Jls","bugCnt",9157);
		XmProductState xmProductState3=BaseUtils.fromMap(p3,XmProductState.class);
		batchValues.add(xmProductState3);
		Map p4=BaseUtils.map("id","65JX","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",2837.35,"actWorkload",5023.66,"planCostAmount",16.65,"actCostAmount",1961.31,"finishRate",6564.13,"demandRate",8787.2,"designRate",9943.18,"devRate",9669.33,"uatRate",928.52,"sitRate",4210.22,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","0jUK","cusername","OaGF","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",9375.14,"planWorkerCnt",8622,"closedBugs",4718,"activeBugs",8882,"confirmedBugs",5692,"resolvedBugs",6628,"productId","T9zr","productName","Obqb","testCases",6309,"execCases",1710,"designCases",4195,"finishCases",2925,"projectCnt",5923,"iterationCnt",1741,"taskCnt",6856,"finishTaskCnt",7338,"bizDate","n30a","branchId","jdqd","bugCnt",6137);
		XmProductState xmProductState4=BaseUtils.fromMap(p4,XmProductState.class);
		batchValues.add(xmProductState4);
		Map p5=BaseUtils.map("id","a094","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",9457.33,"actWorkload",8738.03,"planCostAmount",2389.57,"actCostAmount",5975.39,"finishRate",1584.53,"demandRate",4823.23,"designRate",340.26,"devRate",591.49,"uatRate",787.13,"sitRate",2060.8,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","3K7H","cusername","pLqW","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",8327.77,"planWorkerCnt",6164,"closedBugs",5805,"activeBugs",927,"confirmedBugs",7861,"resolvedBugs",4615,"productId","6iDh","productName","a9P4","testCases",5165,"execCases",9205,"designCases",7704,"finishCases",3667,"projectCnt",4098,"iterationCnt",8875,"taskCnt",5503,"finishTaskCnt",4092,"bizDate","2yEm","branchId","fiGU","bugCnt",2453);
		XmProductState xmProductState5=BaseUtils.fromMap(p5,XmProductState.class);
		batchValues.add(xmProductState5);
		Map p6=BaseUtils.map("id","vDrP","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",9883.1,"actWorkload",9534.95,"planCostAmount",5614.75,"actCostAmount",8870.29,"finishRate",1561.67,"demandRate",1510.68,"designRate",6944.32,"devRate",2067.3,"uatRate",2039.67,"sitRate",7352.85,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","ku3p","cusername","99ic","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",6933.34,"planWorkerCnt",6929,"closedBugs",5399,"activeBugs",287,"confirmedBugs",5313,"resolvedBugs",5350,"productId","XIt4","productName","4A5C","testCases",4651,"execCases",4635,"designCases",4133,"finishCases",2759,"projectCnt",8560,"iterationCnt",7153,"taskCnt",161,"finishTaskCnt",2978,"bizDate","GWvG","branchId","sYXf","bugCnt",1778);
		XmProductState xmProductState6=BaseUtils.fromMap(p6,XmProductState.class);
		batchValues.add(xmProductState6);
		Map p7=BaseUtils.map("id","Ym1i","planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",4775.63,"actWorkload",725.92,"planCostAmount",4685.02,"actCostAmount",127.11,"finishRate",1752.78,"demandRate",6395.64,"designRate",2443.47,"devRate",1821.64,"uatRate",8176.08,"sitRate",725.82,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","s5qc","cusername","h1ck","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",2748.24,"planWorkerCnt",762,"closedBugs",3360,"activeBugs",748,"confirmedBugs",7681,"resolvedBugs",5859,"productId","3vW9","productName","Hfwj","testCases",3525,"execCases",9372,"designCases",9390,"finishCases",755,"projectCnt",4548,"iterationCnt",8122,"taskCnt",9339,"finishTaskCnt",1702,"bizDate","rVFJ","branchId","3BRg","bugCnt",7946);
		XmProductState xmProductState7=BaseUtils.fromMap(p7,XmProductState.class);
		batchValues.add(xmProductState7);
		baseDao.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","16A9");
		Map<String,Object> result=this.baseDao.selectOne(XmProductState.class.getName()+".selectOneMap",p);
		Assert.assertEquals("16A9", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",6759.81,"actWorkload",7481.08,"planCostAmount",7711.91,"actCostAmount",6571.38,"finishRate",958.62,"demandRate",5923.61,"designRate",1050.6,"devRate",7740.03,"uatRate",2278.37,"sitRate",2987.53,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","aUHt","cusername","6H1M","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",3065.83,"planWorkerCnt",3604,"closedBugs",7249,"activeBugs",5944,"confirmedBugs",2349,"resolvedBugs",4427,"productId","tQLs","productName","wFpv","testCases",2957,"execCases",417,"designCases",1798,"finishCases",1228,"projectCnt",2462,"iterationCnt",8541,"taskCnt",1352,"finishTaskCnt",6859,"bizDate","jWmR","branchId","NfPV","bugCnt",3688);
		XmProductState xmProductState=BaseUtils.fromMap(p,XmProductState.class);
		long result=baseDao.countByWhere(xmProductState);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
 		
		
		Map<String,Object> p=BaseUtils.map("planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",6759.81,"actWorkload",7481.08,"planCostAmount",7711.91,"actCostAmount",6571.38,"finishRate",958.62,"demandRate",5923.61,"designRate",1050.6,"devRate",7740.03,"uatRate",2278.37,"sitRate",2987.53,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","aUHt","cusername","6H1M","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",3065.83,"planWorkerCnt",3604,"closedBugs",7249,"activeBugs",5944,"confirmedBugs",2349,"resolvedBugs",4427,"productId","tQLs","productName","wFpv","testCases",2957,"execCases",417,"designCases",1798,"finishCases",1228,"projectCnt",2462,"iterationCnt",8541,"taskCnt",1352,"finishTaskCnt",6859,"bizDate","jWmR","branchId","NfPV","bugCnt",3688);
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmProductState xmProductState=BaseUtils.fromMap(p,XmProductState.class);
		List<XmProductState> result=baseDao.selectListByWhere(xmProductState); 
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
	
		
		Map<String,Object> p=BaseUtils.map("planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",6759.81,"actWorkload",7481.08,"planCostAmount",7711.91,"actCostAmount",6571.38,"finishRate",958.62,"demandRate",5923.61,"designRate",1050.6,"devRate",7740.03,"uatRate",2278.37,"sitRate",2987.53,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","aUHt","cusername","6H1M","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",3065.83,"planWorkerCnt",3604,"closedBugs",7249,"activeBugs",5944,"confirmedBugs",2349,"resolvedBugs",4427,"productId","tQLs","productName","wFpv","testCases",2957,"execCases",417,"designCases",1798,"finishCases",1228,"projectCnt",2462,"iterationCnt",8541,"taskCnt",1352,"finishTaskCnt",6859,"bizDate","jWmR","branchId","NfPV","bugCnt",3688);
		XmProductState xmProductState=BaseUtils.fromMap(p,XmProductState.class);
		List<XmProductState> result=baseDao.selectListByWhere(xmProductState);
		Assert.assertEquals(true, result.size()>=1);
	}

	
	/**
	 * 查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",6759.81,"actWorkload",7481.08,"planCostAmount",7711.91,"actCostAmount",6571.38,"finishRate",958.62,"demandRate",5923.61,"designRate",1050.6,"devRate",7740.03,"uatRate",2278.37,"sitRate",2987.53,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","aUHt","cusername","6H1M","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",3065.83,"planWorkerCnt",3604,"closedBugs",7249,"activeBugs",5944,"confirmedBugs",2349,"resolvedBugs",4427,"productId","tQLs","productName","wFpv","testCases",2957,"execCases",417,"designCases",1798,"finishCases",1228,"projectCnt",2462,"iterationCnt",8541,"taskCnt",1352,"finishTaskCnt",6859,"bizDate","jWmR","branchId","NfPV","bugCnt",3688);
		List<Map<String,Object>> result=baseDao.selectList(XmProductState.class.getName()+".selectListMapByWhere",p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("planStartTime",parse("2020-11-11 18:53:26"),"planEndTime",parse("2020-11-11 18:53:26"),"actStartTime",parse("2020-11-11 18:53:26"),"actEndTime",parse("2020-11-11 18:53:26"),"planWorkload",6759.81,"actWorkload",7481.08,"planCostAmount",7711.91,"actCostAmount",6571.38,"finishRate",958.62,"demandRate",5923.61,"designRate",1050.6,"devRate",7740.03,"uatRate",2278.37,"sitRate",2987.53,"ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"cuserid","aUHt","cusername","6H1M","calcTime",parse("2020-11-11 18:53:26"),"planWorkhours",3065.83,"planWorkerCnt",3604,"closedBugs",7249,"activeBugs",5944,"confirmedBugs",2349,"resolvedBugs",4427,"productId","tQLs","productName","wFpv","testCases",2957,"execCases",417,"designCases",1798,"finishCases",1228,"projectCnt",2462,"iterationCnt",8541,"taskCnt",1352,"finishTaskCnt",6859,"bizDate","jWmR","branchId","NfPV","bugCnt",3688);
		List<Map<String,Object>> result=baseDao.selectList(XmProductState.class.getName()+".selectListMapByKey",p);
		Assert.assertEquals(true, result.size()>=0);
	}
 
	/**
	 * 查询一个对象 XmProductState
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","16A9");
		
		XmProductState xmProductState1=BaseUtils.fromMap(p,XmProductState.class);
		XmProductState xmProductState=baseDao.selectOneObject(xmProductState1);
		Assert.assertEquals("16A9", xmProductState.getId());
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
