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
import com.qqkj.xm.core.entity.XmMenuPlan;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmMenuPlanDao的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_menu_plan 功能计划表,无需前端维护，所有数据由汇总统计得出<br>
 * 实体 XmMenuPlan<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	projectId,id,projectName,menuId,planStartTime,planEndTime,actStartTime,actEndTime,planWorkload,actWorkload,planCostAmount,actCostAmount,finishRate,demandRate,designRate,devRate,uatRate,sitRate,onlineStatus,onlineTime,planStatus,chargeUserid,chargeUsername,menuStatus,ctime,ltime,cuserid,cusername,calcTime,menuName,planWorkhours,planWorkerCnt,closedBugs,activeBugs,confirmedBugs,resolvedBugs,testCases,execCases,designCases,finishCases,iterationCnt,taskCnt,finishTaskCnt,productId,productName,bugCnt;<br>
 * 当前表的所有字段名:<br>
 *	project_id,id,project_name,menu_id,plan_start_time,plan_end_time,act_start_time,act_end_time,plan_workload,act_workload,plan_cost_amount,act_cost_amount,finish_rate,demand_rate,design_rate,dev_rate,uat_rate,sit_rate,online_status,online_time,plan_status,charge_userid,charge_username,menu_status,ctime,ltime,cuserid,cusername,calc_time,menu_name,plan_workhours,plan_worker_cnt,closed_bugs,active_bugs,confirmed_bugs,resolved_bugs,test_cases,exec_cases,design_cases,finish_cases,iteration_cnt,task_cnt,finish_task_cnt,product_id,product_name,bug_cnt;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/
 @RunWith(SpringJUnit4ClassRunner.class)
 @SpringBootTest
public class TestXmMenuPlanDao  {

	@Autowired
	BaseDao baseDao;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("projectId","92L2","id","K4UV","projectName","7C8K","menuId","ZoCy","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",3083.41,"actWorkload",5102.45,"planCostAmount",2900.54,"actCostAmount",2403.45,"finishRate",227.31,"demandRate",2263.22,"designRate",9674.08,"devRate",2436.28,"uatRate",3131.71,"sitRate",3942.87,"onlineStatus","f","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","T","chargeUserid","ITyh","chargeUsername","5THs","menuStatus","z","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","uIf9","cusername","eKFy","calcTime",parse("2020-11-11 18:53:27"),"menuName","qnt3","planWorkhours",8871.29,"planWorkerCnt",5464,"closedBugs",7713,"activeBugs",1030,"confirmedBugs",9548,"resolvedBugs",3104,"testCases",9131,"execCases",4126,"designCases",1588,"finishCases",8318,"iterationCnt",9685,"taskCnt",7721,"finishTaskCnt",9967,"productId","tKNQ","productName","2a5f","bugCnt",977);
		XmMenuPlan xmMenuPlan=BaseUtils.fromMap(p,XmMenuPlan.class);
		baseDao.insert(xmMenuPlan);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","92L2","projectName","7C8K","menuId","ZoCy","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",3083.41,"actWorkload",5102.45,"planCostAmount",2900.54,"actCostAmount",2403.45,"finishRate",227.31,"demandRate",2263.22,"designRate",9674.08,"devRate",2436.28,"uatRate",3131.71,"sitRate",3942.87,"onlineStatus","f","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","T","chargeUserid","ITyh","chargeUsername","5THs","menuStatus","z","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","uIf9","cusername","eKFy","calcTime",parse("2020-11-11 18:53:27"),"menuName","qnt3","planWorkhours",8871.29,"planWorkerCnt",5464,"closedBugs",7713,"activeBugs",1030,"confirmedBugs",9548,"resolvedBugs",3104,"testCases",9131,"execCases",4126,"designCases",1588,"finishCases",8318,"iterationCnt",9685,"taskCnt",7721,"finishTaskCnt",9967,"productId","tKNQ","productName","2a5f","bugCnt",977);
		XmMenuPlan xmMenuPlan=BaseUtils.fromMap(p,XmMenuPlan.class);
		baseDao.deleteByWhere(xmMenuPlan);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","K4UV");
		XmMenuPlan xmMenuPlan=BaseUtils.fromMap(p,XmMenuPlan.class);
		baseDao.deleteByPk(xmMenuPlan);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("projectId","92L2","projectName","7C8K","menuId","ZoCy","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",3083.41,"actWorkload",5102.45,"planCostAmount",2900.54,"actCostAmount",2403.45,"finishRate",227.31,"demandRate",2263.22,"designRate",9674.08,"devRate",2436.28,"uatRate",3131.71,"sitRate",3942.87,"onlineStatus","f","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","T","chargeUserid","ITyh","chargeUsername","5THs","menuStatus","z","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","uIf9","cusername","eKFy","calcTime",parse("2020-11-11 18:53:27"),"menuName","qnt3","planWorkhours",8871.29,"planWorkerCnt",5464,"closedBugs",7713,"activeBugs",1030,"confirmedBugs",9548,"resolvedBugs",3104,"testCases",9131,"execCases",4126,"designCases",1588,"finishCases",8318,"iterationCnt",9685,"taskCnt",7721,"finishTaskCnt",9967,"productId","tKNQ","productName","2a5f","bugCnt",977);
		XmMenuPlan xmMenuPlan=BaseUtils.fromMap(where,XmMenuPlan.class);
		baseDao.updateSomeFieldByPk(xmMenuPlan);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","K4UV");
		XmMenuPlan xmMenuPlan=BaseUtils.fromMap(p,XmMenuPlan.class);
		baseDao.updateByPk(xmMenuPlan);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("projectId","92L2","id","K4UV","projectName","7C8K","menuId","ZoCy","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",3083.41,"actWorkload",5102.45,"planCostAmount",2900.54,"actCostAmount",2403.45,"finishRate",227.31,"demandRate",2263.22,"designRate",9674.08,"devRate",2436.28,"uatRate",3131.71,"sitRate",3942.87,"onlineStatus","f","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","T","chargeUserid","ITyh","chargeUsername","5THs","menuStatus","z","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","uIf9","cusername","eKFy","calcTime",parse("2020-11-11 18:53:27"),"menuName","qnt3","planWorkhours",8871.29,"planWorkerCnt",5464,"closedBugs",7713,"activeBugs",1030,"confirmedBugs",9548,"resolvedBugs",3104,"testCases",9131,"execCases",4126,"designCases",1588,"finishCases",8318,"iterationCnt",9685,"taskCnt",7721,"finishTaskCnt",9967,"productId","tKNQ","productName","2a5f","bugCnt",977);
		XmMenuPlan xmMenuPlan=BaseUtils.fromMap(p,XmMenuPlan.class);
		baseDao.insertOrUpdate(xmMenuPlan);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmMenuPlan> batchValues=new ArrayList<XmMenuPlan>();
		Map p0=BaseUtils.map("projectId","92L2","id","K4UV","projectName","7C8K","menuId","ZoCy","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",3083.41,"actWorkload",5102.45,"planCostAmount",2900.54,"actCostAmount",2403.45,"finishRate",227.31,"demandRate",2263.22,"designRate",9674.08,"devRate",2436.28,"uatRate",3131.71,"sitRate",3942.87,"onlineStatus","f","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","T","chargeUserid","ITyh","chargeUsername","5THs","menuStatus","z","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","uIf9","cusername","eKFy","calcTime",parse("2020-11-11 18:53:27"),"menuName","qnt3","planWorkhours",8871.29,"planWorkerCnt",5464,"closedBugs",7713,"activeBugs",1030,"confirmedBugs",9548,"resolvedBugs",3104,"testCases",9131,"execCases",4126,"designCases",1588,"finishCases",8318,"iterationCnt",9685,"taskCnt",7721,"finishTaskCnt",9967,"productId","tKNQ","productName","2a5f","bugCnt",977);
		XmMenuPlan xmMenuPlan0=BaseUtils.fromMap(p0,XmMenuPlan.class);
		batchValues.add(xmMenuPlan0);
		Map p1=BaseUtils.map("projectId","fRVN","id","idZj","projectName","ghGO","menuId","1eyi","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",4432.12,"actWorkload",6894.79,"planCostAmount",8983.34,"actCostAmount",1144.65,"finishRate",9806.79,"demandRate",2613.35,"designRate",7172.64,"devRate",5718.66,"uatRate",1280.02,"sitRate",1328.35,"onlineStatus","1","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","i","chargeUserid","yx0Z","chargeUsername","57I4","menuStatus","s","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","PlTY","cusername","5VQe","calcTime",parse("2020-11-11 18:53:27"),"menuName","EQew","planWorkhours",4214.17,"planWorkerCnt",6213,"closedBugs",858,"activeBugs",903,"confirmedBugs",2580,"resolvedBugs",9718,"testCases",4562,"execCases",5013,"designCases",2951,"finishCases",1760,"iterationCnt",3751,"taskCnt",3566,"finishTaskCnt",4624,"productId","NgDq","productName","vMwS","bugCnt",936);
		XmMenuPlan xmMenuPlan1=BaseUtils.fromMap(p1,XmMenuPlan.class);
		batchValues.add(xmMenuPlan1);
		Map p2=BaseUtils.map("projectId","NTfi","id","qC23","projectName","6aTP","menuId","6GKU","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",4020.33,"actWorkload",6248.1,"planCostAmount",8437.42,"actCostAmount",8686.4,"finishRate",5809.16,"demandRate",9295.68,"designRate",3723.81,"devRate",6334.46,"uatRate",3022.15,"sitRate",8562.61,"onlineStatus","6","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","K","chargeUserid","gC84","chargeUsername","qbc0","menuStatus","m","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","TB8x","cusername","LMi0","calcTime",parse("2020-11-11 18:53:27"),"menuName","7Wbx","planWorkhours",5945.13,"planWorkerCnt",8538,"closedBugs",60,"activeBugs",162,"confirmedBugs",2296,"resolvedBugs",2162,"testCases",9855,"execCases",8858,"designCases",56,"finishCases",8263,"iterationCnt",6217,"taskCnt",6297,"finishTaskCnt",7556,"productId","t0J7","productName","fh9I","bugCnt",9869);
		XmMenuPlan xmMenuPlan2=BaseUtils.fromMap(p2,XmMenuPlan.class);
		batchValues.add(xmMenuPlan2);
		Map p3=BaseUtils.map("projectId","3QgY","id","D6uk","projectName","L40s","menuId","85ar","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",8470.3,"actWorkload",1858.81,"planCostAmount",1465.92,"actCostAmount",6427.84,"finishRate",9143.56,"demandRate",2594.58,"designRate",5647.5,"devRate",6186.27,"uatRate",4200.21,"sitRate",6916.29,"onlineStatus","B","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","Y","chargeUserid","5O6K","chargeUsername","5iNO","menuStatus","y","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","20JM","cusername","51Up","calcTime",parse("2020-11-11 18:53:27"),"menuName","34QY","planWorkhours",1062.26,"planWorkerCnt",8258,"closedBugs",8562,"activeBugs",6051,"confirmedBugs",2911,"resolvedBugs",6871,"testCases",4182,"execCases",9300,"designCases",8235,"finishCases",8302,"iterationCnt",8398,"taskCnt",4345,"finishTaskCnt",3044,"productId","0nXL","productName","0Zdv","bugCnt",2420);
		XmMenuPlan xmMenuPlan3=BaseUtils.fromMap(p3,XmMenuPlan.class);
		batchValues.add(xmMenuPlan3);
		Map p4=BaseUtils.map("projectId","f0dI","id","SJI7","projectName","940v","menuId","tw58","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",1942.33,"actWorkload",5832.89,"planCostAmount",9916.17,"actCostAmount",8423.63,"finishRate",3515.93,"demandRate",315.58,"designRate",6174.79,"devRate",9123.16,"uatRate",3733.6,"sitRate",9463.47,"onlineStatus","5","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","s","chargeUserid","XUij","chargeUsername","9yij","menuStatus","n","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","K2Ti","cusername","KTyL","calcTime",parse("2020-11-11 18:53:27"),"menuName","2JVp","planWorkhours",7357.84,"planWorkerCnt",4334,"closedBugs",8438,"activeBugs",3990,"confirmedBugs",6360,"resolvedBugs",3959,"testCases",5696,"execCases",160,"designCases",314,"finishCases",7497,"iterationCnt",8560,"taskCnt",6829,"finishTaskCnt",7398,"productId","dr77","productName","JAuR","bugCnt",2063);
		XmMenuPlan xmMenuPlan4=BaseUtils.fromMap(p4,XmMenuPlan.class);
		batchValues.add(xmMenuPlan4);
		Map p5=BaseUtils.map("projectId","2UKH","id","bD46","projectName","eYUZ","menuId","55IZ","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",1964.73,"actWorkload",1499.41,"planCostAmount",2494.41,"actCostAmount",474.74,"finishRate",2335.55,"demandRate",1652.13,"designRate",7559.89,"devRate",1104.08,"uatRate",7240.34,"sitRate",3259.2,"onlineStatus","u","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","y","chargeUserid","5eKc","chargeUsername","8h62","menuStatus","L","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","004s","cusername","H4Y6","calcTime",parse("2020-11-11 18:53:27"),"menuName","GF4W","planWorkhours",6315.46,"planWorkerCnt",4794,"closedBugs",2112,"activeBugs",9219,"confirmedBugs",634,"resolvedBugs",753,"testCases",6608,"execCases",2237,"designCases",9584,"finishCases",4456,"iterationCnt",4766,"taskCnt",5965,"finishTaskCnt",9003,"productId","r1ql","productName","K9Sd","bugCnt",5069);
		XmMenuPlan xmMenuPlan5=BaseUtils.fromMap(p5,XmMenuPlan.class);
		batchValues.add(xmMenuPlan5);
		Map p6=BaseUtils.map("projectId","matZ","id","w902","projectName","GBrH","menuId","61lx","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5802.02,"actWorkload",4435.55,"planCostAmount",3365.51,"actCostAmount",8552.34,"finishRate",2056.08,"demandRate",31.25,"designRate",8338.34,"devRate",682.46,"uatRate",436.67,"sitRate",9294.59,"onlineStatus","2","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","L","chargeUserid","423D","chargeUsername","32Q5","menuStatus","W","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","J79n","cusername","xKai","calcTime",parse("2020-11-11 18:53:27"),"menuName","et89","planWorkhours",1281.39,"planWorkerCnt",3,"closedBugs",7157,"activeBugs",9,"confirmedBugs",5836,"resolvedBugs",4788,"testCases",8828,"execCases",1373,"designCases",7518,"finishCases",3630,"iterationCnt",380,"taskCnt",7239,"finishTaskCnt",4425,"productId","J32t","productName","dDLh","bugCnt",7433);
		XmMenuPlan xmMenuPlan6=BaseUtils.fromMap(p6,XmMenuPlan.class);
		batchValues.add(xmMenuPlan6);
		Map p7=BaseUtils.map("projectId","Izt4","id","69C4","projectName","u926","menuId","cxQv","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",8728.06,"actWorkload",1687.6,"planCostAmount",6923.75,"actCostAmount",1374.7,"finishRate",1365.07,"demandRate",9560.09,"designRate",9258.89,"devRate",2734.7,"uatRate",9683.32,"sitRate",4465.24,"onlineStatus","7","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","h","chargeUserid","6WwY","chargeUsername","LJa1","menuStatus","R","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","PZb4","cusername","Zbq4","calcTime",parse("2020-11-11 18:53:27"),"menuName","1Dc9","planWorkhours",7920.48,"planWorkerCnt",9094,"closedBugs",4768,"activeBugs",1159,"confirmedBugs",2242,"resolvedBugs",4824,"testCases",2107,"execCases",7297,"designCases",1842,"finishCases",7628,"iterationCnt",9532,"taskCnt",5174,"finishTaskCnt",8262,"productId","Qx7q","productName","b29B","bugCnt",8185);
		XmMenuPlan xmMenuPlan7=BaseUtils.fromMap(p7,XmMenuPlan.class);
		batchValues.add(xmMenuPlan7);
		baseDao.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmMenuPlan> batchValues=new ArrayList<XmMenuPlan>();
		Map p0=BaseUtils.map("projectId","92L2","id","K4UV","projectName","7C8K","menuId","ZoCy","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",3083.41,"actWorkload",5102.45,"planCostAmount",2900.54,"actCostAmount",2403.45,"finishRate",227.31,"demandRate",2263.22,"designRate",9674.08,"devRate",2436.28,"uatRate",3131.71,"sitRate",3942.87,"onlineStatus","f","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","T","chargeUserid","ITyh","chargeUsername","5THs","menuStatus","z","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","uIf9","cusername","eKFy","calcTime",parse("2020-11-11 18:53:27"),"menuName","qnt3","planWorkhours",8871.29,"planWorkerCnt",5464,"closedBugs",7713,"activeBugs",1030,"confirmedBugs",9548,"resolvedBugs",3104,"testCases",9131,"execCases",4126,"designCases",1588,"finishCases",8318,"iterationCnt",9685,"taskCnt",7721,"finishTaskCnt",9967,"productId","tKNQ","productName","2a5f","bugCnt",977);
		XmMenuPlan xmMenuPlan0=BaseUtils.fromMap(p0,XmMenuPlan.class);
		batchValues.add(xmMenuPlan0);
		Map p1=BaseUtils.map("projectId","fRVN","id","idZj","projectName","ghGO","menuId","1eyi","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",4432.12,"actWorkload",6894.79,"planCostAmount",8983.34,"actCostAmount",1144.65,"finishRate",9806.79,"demandRate",2613.35,"designRate",7172.64,"devRate",5718.66,"uatRate",1280.02,"sitRate",1328.35,"onlineStatus","1","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","i","chargeUserid","yx0Z","chargeUsername","57I4","menuStatus","s","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","PlTY","cusername","5VQe","calcTime",parse("2020-11-11 18:53:27"),"menuName","EQew","planWorkhours",4214.17,"planWorkerCnt",6213,"closedBugs",858,"activeBugs",903,"confirmedBugs",2580,"resolvedBugs",9718,"testCases",4562,"execCases",5013,"designCases",2951,"finishCases",1760,"iterationCnt",3751,"taskCnt",3566,"finishTaskCnt",4624,"productId","NgDq","productName","vMwS","bugCnt",936);
		XmMenuPlan xmMenuPlan1=BaseUtils.fromMap(p1,XmMenuPlan.class);
		batchValues.add(xmMenuPlan1);
		Map p2=BaseUtils.map("projectId","NTfi","id","qC23","projectName","6aTP","menuId","6GKU","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",4020.33,"actWorkload",6248.1,"planCostAmount",8437.42,"actCostAmount",8686.4,"finishRate",5809.16,"demandRate",9295.68,"designRate",3723.81,"devRate",6334.46,"uatRate",3022.15,"sitRate",8562.61,"onlineStatus","6","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","K","chargeUserid","gC84","chargeUsername","qbc0","menuStatus","m","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","TB8x","cusername","LMi0","calcTime",parse("2020-11-11 18:53:27"),"menuName","7Wbx","planWorkhours",5945.13,"planWorkerCnt",8538,"closedBugs",60,"activeBugs",162,"confirmedBugs",2296,"resolvedBugs",2162,"testCases",9855,"execCases",8858,"designCases",56,"finishCases",8263,"iterationCnt",6217,"taskCnt",6297,"finishTaskCnt",7556,"productId","t0J7","productName","fh9I","bugCnt",9869);
		XmMenuPlan xmMenuPlan2=BaseUtils.fromMap(p2,XmMenuPlan.class);
		batchValues.add(xmMenuPlan2);
		Map p3=BaseUtils.map("projectId","3QgY","id","D6uk","projectName","L40s","menuId","85ar","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",8470.3,"actWorkload",1858.81,"planCostAmount",1465.92,"actCostAmount",6427.84,"finishRate",9143.56,"demandRate",2594.58,"designRate",5647.5,"devRate",6186.27,"uatRate",4200.21,"sitRate",6916.29,"onlineStatus","B","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","Y","chargeUserid","5O6K","chargeUsername","5iNO","menuStatus","y","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","20JM","cusername","51Up","calcTime",parse("2020-11-11 18:53:27"),"menuName","34QY","planWorkhours",1062.26,"planWorkerCnt",8258,"closedBugs",8562,"activeBugs",6051,"confirmedBugs",2911,"resolvedBugs",6871,"testCases",4182,"execCases",9300,"designCases",8235,"finishCases",8302,"iterationCnt",8398,"taskCnt",4345,"finishTaskCnt",3044,"productId","0nXL","productName","0Zdv","bugCnt",2420);
		XmMenuPlan xmMenuPlan3=BaseUtils.fromMap(p3,XmMenuPlan.class);
		batchValues.add(xmMenuPlan3);
		Map p4=BaseUtils.map("projectId","f0dI","id","SJI7","projectName","940v","menuId","tw58","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",1942.33,"actWorkload",5832.89,"planCostAmount",9916.17,"actCostAmount",8423.63,"finishRate",3515.93,"demandRate",315.58,"designRate",6174.79,"devRate",9123.16,"uatRate",3733.6,"sitRate",9463.47,"onlineStatus","5","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","s","chargeUserid","XUij","chargeUsername","9yij","menuStatus","n","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","K2Ti","cusername","KTyL","calcTime",parse("2020-11-11 18:53:27"),"menuName","2JVp","planWorkhours",7357.84,"planWorkerCnt",4334,"closedBugs",8438,"activeBugs",3990,"confirmedBugs",6360,"resolvedBugs",3959,"testCases",5696,"execCases",160,"designCases",314,"finishCases",7497,"iterationCnt",8560,"taskCnt",6829,"finishTaskCnt",7398,"productId","dr77","productName","JAuR","bugCnt",2063);
		XmMenuPlan xmMenuPlan4=BaseUtils.fromMap(p4,XmMenuPlan.class);
		batchValues.add(xmMenuPlan4);
		Map p5=BaseUtils.map("projectId","2UKH","id","bD46","projectName","eYUZ","menuId","55IZ","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",1964.73,"actWorkload",1499.41,"planCostAmount",2494.41,"actCostAmount",474.74,"finishRate",2335.55,"demandRate",1652.13,"designRate",7559.89,"devRate",1104.08,"uatRate",7240.34,"sitRate",3259.2,"onlineStatus","u","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","y","chargeUserid","5eKc","chargeUsername","8h62","menuStatus","L","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","004s","cusername","H4Y6","calcTime",parse("2020-11-11 18:53:27"),"menuName","GF4W","planWorkhours",6315.46,"planWorkerCnt",4794,"closedBugs",2112,"activeBugs",9219,"confirmedBugs",634,"resolvedBugs",753,"testCases",6608,"execCases",2237,"designCases",9584,"finishCases",4456,"iterationCnt",4766,"taskCnt",5965,"finishTaskCnt",9003,"productId","r1ql","productName","K9Sd","bugCnt",5069);
		XmMenuPlan xmMenuPlan5=BaseUtils.fromMap(p5,XmMenuPlan.class);
		batchValues.add(xmMenuPlan5);
		Map p6=BaseUtils.map("projectId","matZ","id","w902","projectName","GBrH","menuId","61lx","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5802.02,"actWorkload",4435.55,"planCostAmount",3365.51,"actCostAmount",8552.34,"finishRate",2056.08,"demandRate",31.25,"designRate",8338.34,"devRate",682.46,"uatRate",436.67,"sitRate",9294.59,"onlineStatus","2","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","L","chargeUserid","423D","chargeUsername","32Q5","menuStatus","W","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","J79n","cusername","xKai","calcTime",parse("2020-11-11 18:53:27"),"menuName","et89","planWorkhours",1281.39,"planWorkerCnt",3,"closedBugs",7157,"activeBugs",9,"confirmedBugs",5836,"resolvedBugs",4788,"testCases",8828,"execCases",1373,"designCases",7518,"finishCases",3630,"iterationCnt",380,"taskCnt",7239,"finishTaskCnt",4425,"productId","J32t","productName","dDLh","bugCnt",7433);
		XmMenuPlan xmMenuPlan6=BaseUtils.fromMap(p6,XmMenuPlan.class);
		batchValues.add(xmMenuPlan6);
		Map p7=BaseUtils.map("projectId","Izt4","id","69C4","projectName","u926","menuId","cxQv","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",8728.06,"actWorkload",1687.6,"planCostAmount",6923.75,"actCostAmount",1374.7,"finishRate",1365.07,"demandRate",9560.09,"designRate",9258.89,"devRate",2734.7,"uatRate",9683.32,"sitRate",4465.24,"onlineStatus","7","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","h","chargeUserid","6WwY","chargeUsername","LJa1","menuStatus","R","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","PZb4","cusername","Zbq4","calcTime",parse("2020-11-11 18:53:27"),"menuName","1Dc9","planWorkhours",7920.48,"planWorkerCnt",9094,"closedBugs",4768,"activeBugs",1159,"confirmedBugs",2242,"resolvedBugs",4824,"testCases",2107,"execCases",7297,"designCases",1842,"finishCases",7628,"iterationCnt",9532,"taskCnt",5174,"finishTaskCnt",8262,"productId","Qx7q","productName","b29B","bugCnt",8185);
		XmMenuPlan xmMenuPlan7=BaseUtils.fromMap(p7,XmMenuPlan.class);
		batchValues.add(xmMenuPlan7);
		baseDao.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmMenuPlan> batchValues=new ArrayList<XmMenuPlan>();
		Map p0=BaseUtils.map("projectId","92L2","id","K4UV","projectName","7C8K","menuId","ZoCy","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",3083.41,"actWorkload",5102.45,"planCostAmount",2900.54,"actCostAmount",2403.45,"finishRate",227.31,"demandRate",2263.22,"designRate",9674.08,"devRate",2436.28,"uatRate",3131.71,"sitRate",3942.87,"onlineStatus","f","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","T","chargeUserid","ITyh","chargeUsername","5THs","menuStatus","z","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","uIf9","cusername","eKFy","calcTime",parse("2020-11-11 18:53:27"),"menuName","qnt3","planWorkhours",8871.29,"planWorkerCnt",5464,"closedBugs",7713,"activeBugs",1030,"confirmedBugs",9548,"resolvedBugs",3104,"testCases",9131,"execCases",4126,"designCases",1588,"finishCases",8318,"iterationCnt",9685,"taskCnt",7721,"finishTaskCnt",9967,"productId","tKNQ","productName","2a5f","bugCnt",977);
		XmMenuPlan xmMenuPlan0=BaseUtils.fromMap(p0,XmMenuPlan.class);
		batchValues.add(xmMenuPlan0);
		Map p1=BaseUtils.map("projectId","fRVN","id","idZj","projectName","ghGO","menuId","1eyi","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",4432.12,"actWorkload",6894.79,"planCostAmount",8983.34,"actCostAmount",1144.65,"finishRate",9806.79,"demandRate",2613.35,"designRate",7172.64,"devRate",5718.66,"uatRate",1280.02,"sitRate",1328.35,"onlineStatus","1","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","i","chargeUserid","yx0Z","chargeUsername","57I4","menuStatus","s","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","PlTY","cusername","5VQe","calcTime",parse("2020-11-11 18:53:27"),"menuName","EQew","planWorkhours",4214.17,"planWorkerCnt",6213,"closedBugs",858,"activeBugs",903,"confirmedBugs",2580,"resolvedBugs",9718,"testCases",4562,"execCases",5013,"designCases",2951,"finishCases",1760,"iterationCnt",3751,"taskCnt",3566,"finishTaskCnt",4624,"productId","NgDq","productName","vMwS","bugCnt",936);
		XmMenuPlan xmMenuPlan1=BaseUtils.fromMap(p1,XmMenuPlan.class);
		batchValues.add(xmMenuPlan1);
		Map p2=BaseUtils.map("projectId","NTfi","id","qC23","projectName","6aTP","menuId","6GKU","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",4020.33,"actWorkload",6248.1,"planCostAmount",8437.42,"actCostAmount",8686.4,"finishRate",5809.16,"demandRate",9295.68,"designRate",3723.81,"devRate",6334.46,"uatRate",3022.15,"sitRate",8562.61,"onlineStatus","6","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","K","chargeUserid","gC84","chargeUsername","qbc0","menuStatus","m","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","TB8x","cusername","LMi0","calcTime",parse("2020-11-11 18:53:27"),"menuName","7Wbx","planWorkhours",5945.13,"planWorkerCnt",8538,"closedBugs",60,"activeBugs",162,"confirmedBugs",2296,"resolvedBugs",2162,"testCases",9855,"execCases",8858,"designCases",56,"finishCases",8263,"iterationCnt",6217,"taskCnt",6297,"finishTaskCnt",7556,"productId","t0J7","productName","fh9I","bugCnt",9869);
		XmMenuPlan xmMenuPlan2=BaseUtils.fromMap(p2,XmMenuPlan.class);
		batchValues.add(xmMenuPlan2);
		Map p3=BaseUtils.map("projectId","3QgY","id","D6uk","projectName","L40s","menuId","85ar","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",8470.3,"actWorkload",1858.81,"planCostAmount",1465.92,"actCostAmount",6427.84,"finishRate",9143.56,"demandRate",2594.58,"designRate",5647.5,"devRate",6186.27,"uatRate",4200.21,"sitRate",6916.29,"onlineStatus","B","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","Y","chargeUserid","5O6K","chargeUsername","5iNO","menuStatus","y","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","20JM","cusername","51Up","calcTime",parse("2020-11-11 18:53:27"),"menuName","34QY","planWorkhours",1062.26,"planWorkerCnt",8258,"closedBugs",8562,"activeBugs",6051,"confirmedBugs",2911,"resolvedBugs",6871,"testCases",4182,"execCases",9300,"designCases",8235,"finishCases",8302,"iterationCnt",8398,"taskCnt",4345,"finishTaskCnt",3044,"productId","0nXL","productName","0Zdv","bugCnt",2420);
		XmMenuPlan xmMenuPlan3=BaseUtils.fromMap(p3,XmMenuPlan.class);
		batchValues.add(xmMenuPlan3);
		Map p4=BaseUtils.map("projectId","f0dI","id","SJI7","projectName","940v","menuId","tw58","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",1942.33,"actWorkload",5832.89,"planCostAmount",9916.17,"actCostAmount",8423.63,"finishRate",3515.93,"demandRate",315.58,"designRate",6174.79,"devRate",9123.16,"uatRate",3733.6,"sitRate",9463.47,"onlineStatus","5","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","s","chargeUserid","XUij","chargeUsername","9yij","menuStatus","n","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","K2Ti","cusername","KTyL","calcTime",parse("2020-11-11 18:53:27"),"menuName","2JVp","planWorkhours",7357.84,"planWorkerCnt",4334,"closedBugs",8438,"activeBugs",3990,"confirmedBugs",6360,"resolvedBugs",3959,"testCases",5696,"execCases",160,"designCases",314,"finishCases",7497,"iterationCnt",8560,"taskCnt",6829,"finishTaskCnt",7398,"productId","dr77","productName","JAuR","bugCnt",2063);
		XmMenuPlan xmMenuPlan4=BaseUtils.fromMap(p4,XmMenuPlan.class);
		batchValues.add(xmMenuPlan4);
		Map p5=BaseUtils.map("projectId","2UKH","id","bD46","projectName","eYUZ","menuId","55IZ","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",1964.73,"actWorkload",1499.41,"planCostAmount",2494.41,"actCostAmount",474.74,"finishRate",2335.55,"demandRate",1652.13,"designRate",7559.89,"devRate",1104.08,"uatRate",7240.34,"sitRate",3259.2,"onlineStatus","u","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","y","chargeUserid","5eKc","chargeUsername","8h62","menuStatus","L","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","004s","cusername","H4Y6","calcTime",parse("2020-11-11 18:53:27"),"menuName","GF4W","planWorkhours",6315.46,"planWorkerCnt",4794,"closedBugs",2112,"activeBugs",9219,"confirmedBugs",634,"resolvedBugs",753,"testCases",6608,"execCases",2237,"designCases",9584,"finishCases",4456,"iterationCnt",4766,"taskCnt",5965,"finishTaskCnt",9003,"productId","r1ql","productName","K9Sd","bugCnt",5069);
		XmMenuPlan xmMenuPlan5=BaseUtils.fromMap(p5,XmMenuPlan.class);
		batchValues.add(xmMenuPlan5);
		Map p6=BaseUtils.map("projectId","matZ","id","w902","projectName","GBrH","menuId","61lx","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5802.02,"actWorkload",4435.55,"planCostAmount",3365.51,"actCostAmount",8552.34,"finishRate",2056.08,"demandRate",31.25,"designRate",8338.34,"devRate",682.46,"uatRate",436.67,"sitRate",9294.59,"onlineStatus","2","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","L","chargeUserid","423D","chargeUsername","32Q5","menuStatus","W","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","J79n","cusername","xKai","calcTime",parse("2020-11-11 18:53:27"),"menuName","et89","planWorkhours",1281.39,"planWorkerCnt",3,"closedBugs",7157,"activeBugs",9,"confirmedBugs",5836,"resolvedBugs",4788,"testCases",8828,"execCases",1373,"designCases",7518,"finishCases",3630,"iterationCnt",380,"taskCnt",7239,"finishTaskCnt",4425,"productId","J32t","productName","dDLh","bugCnt",7433);
		XmMenuPlan xmMenuPlan6=BaseUtils.fromMap(p6,XmMenuPlan.class);
		batchValues.add(xmMenuPlan6);
		Map p7=BaseUtils.map("projectId","Izt4","id","69C4","projectName","u926","menuId","cxQv","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",8728.06,"actWorkload",1687.6,"planCostAmount",6923.75,"actCostAmount",1374.7,"finishRate",1365.07,"demandRate",9560.09,"designRate",9258.89,"devRate",2734.7,"uatRate",9683.32,"sitRate",4465.24,"onlineStatus","7","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","h","chargeUserid","6WwY","chargeUsername","LJa1","menuStatus","R","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","PZb4","cusername","Zbq4","calcTime",parse("2020-11-11 18:53:27"),"menuName","1Dc9","planWorkhours",7920.48,"planWorkerCnt",9094,"closedBugs",4768,"activeBugs",1159,"confirmedBugs",2242,"resolvedBugs",4824,"testCases",2107,"execCases",7297,"designCases",1842,"finishCases",7628,"iterationCnt",9532,"taskCnt",5174,"finishTaskCnt",8262,"productId","Qx7q","productName","b29B","bugCnt",8185);
		XmMenuPlan xmMenuPlan7=BaseUtils.fromMap(p7,XmMenuPlan.class);
		batchValues.add(xmMenuPlan7);
		baseDao.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","K4UV");
		Map<String,Object> result=this.baseDao.selectOne(XmMenuPlan.class.getName()+".selectOneMap",p);
		Assert.assertEquals("K4UV", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","92L2","projectName","7C8K","menuId","ZoCy","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",3083.41,"actWorkload",5102.45,"planCostAmount",2900.54,"actCostAmount",2403.45,"finishRate",227.31,"demandRate",2263.22,"designRate",9674.08,"devRate",2436.28,"uatRate",3131.71,"sitRate",3942.87,"onlineStatus","f","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","T","chargeUserid","ITyh","chargeUsername","5THs","menuStatus","z","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","uIf9","cusername","eKFy","calcTime",parse("2020-11-11 18:53:27"),"menuName","qnt3","planWorkhours",8871.29,"planWorkerCnt",5464,"closedBugs",7713,"activeBugs",1030,"confirmedBugs",9548,"resolvedBugs",3104,"testCases",9131,"execCases",4126,"designCases",1588,"finishCases",8318,"iterationCnt",9685,"taskCnt",7721,"finishTaskCnt",9967,"productId","tKNQ","productName","2a5f","bugCnt",977);
		XmMenuPlan xmMenuPlan=BaseUtils.fromMap(p,XmMenuPlan.class);
		long result=baseDao.countByWhere(xmMenuPlan);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
 		
		
		Map<String,Object> p=BaseUtils.map("projectId","92L2","projectName","7C8K","menuId","ZoCy","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",3083.41,"actWorkload",5102.45,"planCostAmount",2900.54,"actCostAmount",2403.45,"finishRate",227.31,"demandRate",2263.22,"designRate",9674.08,"devRate",2436.28,"uatRate",3131.71,"sitRate",3942.87,"onlineStatus","f","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","T","chargeUserid","ITyh","chargeUsername","5THs","menuStatus","z","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","uIf9","cusername","eKFy","calcTime",parse("2020-11-11 18:53:27"),"menuName","qnt3","planWorkhours",8871.29,"planWorkerCnt",5464,"closedBugs",7713,"activeBugs",1030,"confirmedBugs",9548,"resolvedBugs",3104,"testCases",9131,"execCases",4126,"designCases",1588,"finishCases",8318,"iterationCnt",9685,"taskCnt",7721,"finishTaskCnt",9967,"productId","tKNQ","productName","2a5f","bugCnt",977);
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmMenuPlan xmMenuPlan=BaseUtils.fromMap(p,XmMenuPlan.class);
		List<XmMenuPlan> result=baseDao.selectListByWhere(xmMenuPlan); 
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
	
		
		Map<String,Object> p=BaseUtils.map("projectId","92L2","projectName","7C8K","menuId","ZoCy","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",3083.41,"actWorkload",5102.45,"planCostAmount",2900.54,"actCostAmount",2403.45,"finishRate",227.31,"demandRate",2263.22,"designRate",9674.08,"devRate",2436.28,"uatRate",3131.71,"sitRate",3942.87,"onlineStatus","f","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","T","chargeUserid","ITyh","chargeUsername","5THs","menuStatus","z","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","uIf9","cusername","eKFy","calcTime",parse("2020-11-11 18:53:27"),"menuName","qnt3","planWorkhours",8871.29,"planWorkerCnt",5464,"closedBugs",7713,"activeBugs",1030,"confirmedBugs",9548,"resolvedBugs",3104,"testCases",9131,"execCases",4126,"designCases",1588,"finishCases",8318,"iterationCnt",9685,"taskCnt",7721,"finishTaskCnt",9967,"productId","tKNQ","productName","2a5f","bugCnt",977);
		XmMenuPlan xmMenuPlan=BaseUtils.fromMap(p,XmMenuPlan.class);
		List<XmMenuPlan> result=baseDao.selectListByWhere(xmMenuPlan);
		Assert.assertEquals(true, result.size()>=1);
	}

	
	/**
	 * 查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","92L2","projectName","7C8K","menuId","ZoCy","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",3083.41,"actWorkload",5102.45,"planCostAmount",2900.54,"actCostAmount",2403.45,"finishRate",227.31,"demandRate",2263.22,"designRate",9674.08,"devRate",2436.28,"uatRate",3131.71,"sitRate",3942.87,"onlineStatus","f","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","T","chargeUserid","ITyh","chargeUsername","5THs","menuStatus","z","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","uIf9","cusername","eKFy","calcTime",parse("2020-11-11 18:53:27"),"menuName","qnt3","planWorkhours",8871.29,"planWorkerCnt",5464,"closedBugs",7713,"activeBugs",1030,"confirmedBugs",9548,"resolvedBugs",3104,"testCases",9131,"execCases",4126,"designCases",1588,"finishCases",8318,"iterationCnt",9685,"taskCnt",7721,"finishTaskCnt",9967,"productId","tKNQ","productName","2a5f","bugCnt",977);
		List<Map<String,Object>> result=baseDao.selectList(XmMenuPlan.class.getName()+".selectListMapByWhere",p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("projectId","92L2","projectName","7C8K","menuId","ZoCy","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",3083.41,"actWorkload",5102.45,"planCostAmount",2900.54,"actCostAmount",2403.45,"finishRate",227.31,"demandRate",2263.22,"designRate",9674.08,"devRate",2436.28,"uatRate",3131.71,"sitRate",3942.87,"onlineStatus","f","onlineTime",parse("2020-11-11 18:53:27"),"planStatus","T","chargeUserid","ITyh","chargeUsername","5THs","menuStatus","z","ctime",parse("2020-11-11 18:53:27"),"ltime",parse("2020-11-11 18:53:27"),"cuserid","uIf9","cusername","eKFy","calcTime",parse("2020-11-11 18:53:27"),"menuName","qnt3","planWorkhours",8871.29,"planWorkerCnt",5464,"closedBugs",7713,"activeBugs",1030,"confirmedBugs",9548,"resolvedBugs",3104,"testCases",9131,"execCases",4126,"designCases",1588,"finishCases",8318,"iterationCnt",9685,"taskCnt",7721,"finishTaskCnt",9967,"productId","tKNQ","productName","2a5f","bugCnt",977);
		List<Map<String,Object>> result=baseDao.selectList(XmMenuPlan.class.getName()+".selectListMapByKey",p);
		Assert.assertEquals(true, result.size()>=0);
	}
 
	/**
	 * 查询一个对象 XmMenuPlan
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","K4UV");
		
		XmMenuPlan xmMenuPlan1=BaseUtils.fromMap(p,XmMenuPlan.class);
		XmMenuPlan xmMenuPlan=baseDao.selectOneObject(xmMenuPlan1);
		Assert.assertEquals("K4UV", xmMenuPlan.getId());
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
