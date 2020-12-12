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
import  com.qqkj.xm.core.service.XmProjectGroupStateService; 
import com.qqkj.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import  com.qqkj.xm.core.entity.XmProjectGroupState;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmProjectGroupStateService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_project_group_state 功能状态表,无需前端维护，所有数据由汇总统计得出<br>
 * 实体 XmProjectGroupState<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,planStartTime,planEndTime,actStartTime,actEndTime,planWorkload,actWorkload,planCostAmount,actCostAmount,finishRate,demandRate,designRate,devRate,uatRate,sitRate,ctime,calcTime,planWorkhours,planWorkerCnt,closedBugs,activeBugs,confirmedBugs,resolvedBugs,testCases,execCases,designCases,finishCases,iterationCnt,taskCnt,finishTaskCnt,bizDate,bugCnt,groupId,projectId,projectName,groupName;<br>
 * 当前表的所有字段名:<br>
 *	id,plan_start_time,plan_end_time,act_start_time,act_end_time,plan_workload,act_workload,plan_cost_amount,act_cost_amount,finish_rate,demand_rate,design_rate,dev_rate,uat_rate,sit_rate,ctime,calc_time,plan_workhours,plan_worker_cnt,closed_bugs,active_bugs,confirmed_bugs,resolved_bugs,test_cases,exec_cases,design_cases,finish_cases,iteration_cnt,task_cnt,finish_task_cnt,biz_date,bug_cnt,group_id,project_id,project_name,group_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectGroupStateService  {

	@Autowired
	XmProjectGroupStateService xmProjectGroupStateService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","DOvX","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5488.29,"actWorkload",825.29,"planCostAmount",8827.71,"actCostAmount",3822.04,"finishRate",1922.27,"demandRate",406.64,"designRate",7908.15,"devRate",7840.41,"uatRate",2388.7,"sitRate",1579.68,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",5541.15,"planWorkerCnt",4294.3,"closedBugs",7483,"activeBugs",7367,"confirmedBugs",2008,"resolvedBugs",9839,"testCases",9608,"execCases",8125,"designCases",833,"finishCases",7535,"iterationCnt",39,"taskCnt",9196,"finishTaskCnt",8478,"bizDate","L2PF","bugCnt",6252,"groupId","83u4","projectId","yYyx","projectName","j2vJ","groupName","rYC6");
		XmProjectGroupState xmProjectGroupState=BaseUtils.fromMap(p,XmProjectGroupState.class);
		xmProjectGroupStateService.insert(xmProjectGroupState);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5488.29,"actWorkload",825.29,"planCostAmount",8827.71,"actCostAmount",3822.04,"finishRate",1922.27,"demandRate",406.64,"designRate",7908.15,"devRate",7840.41,"uatRate",2388.7,"sitRate",1579.68,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",5541.15,"planWorkerCnt",4294.3,"closedBugs",7483,"activeBugs",7367,"confirmedBugs",2008,"resolvedBugs",9839,"testCases",9608,"execCases",8125,"designCases",833,"finishCases",7535,"iterationCnt",39,"taskCnt",9196,"finishTaskCnt",8478,"bizDate","L2PF","bugCnt",6252,"groupId","83u4","projectId","yYyx","projectName","j2vJ","groupName","rYC6");
		XmProjectGroupState xmProjectGroupState=BaseUtils.fromMap(p,XmProjectGroupState.class);
		xmProjectGroupStateService.deleteByWhere(xmProjectGroupState);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","DOvX");
		XmProjectGroupState xmProjectGroupState=BaseUtils.fromMap(p,XmProjectGroupState.class);
		xmProjectGroupStateService.deleteByPk(xmProjectGroupState);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5488.29,"actWorkload",825.29,"planCostAmount",8827.71,"actCostAmount",3822.04,"finishRate",1922.27,"demandRate",406.64,"designRate",7908.15,"devRate",7840.41,"uatRate",2388.7,"sitRate",1579.68,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",5541.15,"planWorkerCnt",4294.3,"closedBugs",7483,"activeBugs",7367,"confirmedBugs",2008,"resolvedBugs",9839,"testCases",9608,"execCases",8125,"designCases",833,"finishCases",7535,"iterationCnt",39,"taskCnt",9196,"finishTaskCnt",8478,"bizDate","L2PF","bugCnt",6252,"groupId","83u4","projectId","yYyx","projectName","j2vJ","groupName","rYC6");
		XmProjectGroupState xmProjectGroupState=BaseUtils.fromMap(where,XmProjectGroupState.class);
		xmProjectGroupStateService.updateSomeFieldByPk(xmProjectGroupState);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","DOvX");
		XmProjectGroupState xmProjectGroupState=BaseUtils.fromMap(p,XmProjectGroupState.class);
		xmProjectGroupStateService.updateByPk(xmProjectGroupState);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("id","DOvX","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5488.29,"actWorkload",825.29,"planCostAmount",8827.71,"actCostAmount",3822.04,"finishRate",1922.27,"demandRate",406.64,"designRate",7908.15,"devRate",7840.41,"uatRate",2388.7,"sitRate",1579.68,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",5541.15,"planWorkerCnt",4294.3,"closedBugs",7483,"activeBugs",7367,"confirmedBugs",2008,"resolvedBugs",9839,"testCases",9608,"execCases",8125,"designCases",833,"finishCases",7535,"iterationCnt",39,"taskCnt",9196,"finishTaskCnt",8478,"bizDate","L2PF","bugCnt",6252,"groupId","83u4","projectId","yYyx","projectName","j2vJ","groupName","rYC6");
		XmProjectGroupState xmProjectGroupState=BaseUtils.fromMap(p,XmProjectGroupState.class);
		xmProjectGroupStateService.insertOrUpdate(xmProjectGroupState);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmProjectGroupState> batchValues=new ArrayList<XmProjectGroupState>();
		Map p0=BaseUtils.map("id","DOvX","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5488.29,"actWorkload",825.29,"planCostAmount",8827.71,"actCostAmount",3822.04,"finishRate",1922.27,"demandRate",406.64,"designRate",7908.15,"devRate",7840.41,"uatRate",2388.7,"sitRate",1579.68,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",5541.15,"planWorkerCnt",4294.3,"closedBugs",7483,"activeBugs",7367,"confirmedBugs",2008,"resolvedBugs",9839,"testCases",9608,"execCases",8125,"designCases",833,"finishCases",7535,"iterationCnt",39,"taskCnt",9196,"finishTaskCnt",8478,"bizDate","L2PF","bugCnt",6252,"groupId","83u4","projectId","yYyx","projectName","j2vJ","groupName","rYC6");
		XmProjectGroupState xmProjectGroupState0=BaseUtils.fromMap(p0,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState0);
		Map p1=BaseUtils.map("id","EUJM","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",617.76,"actWorkload",783.22,"planCostAmount",1274.92,"actCostAmount",3618.43,"finishRate",4708.39,"demandRate",5992.55,"designRate",9174.16,"devRate",1957.67,"uatRate",42.99,"sitRate",2536.12,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",3548.38,"planWorkerCnt",2102.75,"closedBugs",9733,"activeBugs",1947,"confirmedBugs",877,"resolvedBugs",2019,"testCases",3403,"execCases",6043,"designCases",6199,"finishCases",2130,"iterationCnt",652,"taskCnt",3506,"finishTaskCnt",7108,"bizDate","TKj3","bugCnt",2360,"groupId","P2Uu","projectId","OYr1","projectName","JTVV","groupName","2pnV");
		XmProjectGroupState xmProjectGroupState1=BaseUtils.fromMap(p1,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState1);
		Map p2=BaseUtils.map("id","1YeW","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",98.43,"actWorkload",5783.09,"planCostAmount",7610.18,"actCostAmount",5938.59,"finishRate",8626.3,"demandRate",4516.56,"designRate",8407.81,"devRate",5794.13,"uatRate",5135.29,"sitRate",5660.68,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",272.19,"planWorkerCnt",8830.04,"closedBugs",8998,"activeBugs",8700,"confirmedBugs",9366,"resolvedBugs",2041,"testCases",8860,"execCases",4314,"designCases",9651,"finishCases",904,"iterationCnt",9949,"taskCnt",2144,"finishTaskCnt",9102,"bizDate","L9a1","bugCnt",8487,"groupId","zlJz","projectId","d8Ki","projectName","QIOK","groupName","MGY7");
		XmProjectGroupState xmProjectGroupState2=BaseUtils.fromMap(p2,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState2);
		Map p3=BaseUtils.map("id","4PxH","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5333.37,"actWorkload",3346.64,"planCostAmount",2818.49,"actCostAmount",9414.22,"finishRate",5881.15,"demandRate",6518.12,"designRate",1686.26,"devRate",9814.01,"uatRate",2988.59,"sitRate",3443.32,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",570.91,"planWorkerCnt",623.31,"closedBugs",9590,"activeBugs",415,"confirmedBugs",6990,"resolvedBugs",5464,"testCases",7787,"execCases",4031,"designCases",8331,"finishCases",3687,"iterationCnt",3871,"taskCnt",3034,"finishTaskCnt",218,"bizDate","8H18","bugCnt",9453,"groupId","VWH7","projectId","l42y","projectName","1rzV","groupName","3j1W");
		XmProjectGroupState xmProjectGroupState3=BaseUtils.fromMap(p3,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState3);
		Map p4=BaseUtils.map("id","s06p","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",8437.65,"actWorkload",3335.25,"planCostAmount",653.12,"actCostAmount",8343.87,"finishRate",8123.18,"demandRate",9655.17,"designRate",3098.1,"devRate",4656.57,"uatRate",9338.11,"sitRate",6700.86,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",1669.7,"planWorkerCnt",386.19,"closedBugs",9914,"activeBugs",7629,"confirmedBugs",6410,"resolvedBugs",5669,"testCases",2875,"execCases",403,"designCases",5957,"finishCases",3264,"iterationCnt",1658,"taskCnt",5591,"finishTaskCnt",1854,"bizDate","qM6b","bugCnt",6199,"groupId","tlfS","projectId","CYo7","projectName","2vm1","groupName","1ZC1");
		XmProjectGroupState xmProjectGroupState4=BaseUtils.fromMap(p4,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState4);
		Map p5=BaseUtils.map("id","9J5k","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5481.59,"actWorkload",7823.25,"planCostAmount",9313.53,"actCostAmount",6602.51,"finishRate",2541.96,"demandRate",2656.73,"designRate",6974.25,"devRate",549.91,"uatRate",7661.16,"sitRate",2952.45,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",1456.38,"planWorkerCnt",1030.67,"closedBugs",3632,"activeBugs",5079,"confirmedBugs",2632,"resolvedBugs",6489,"testCases",713,"execCases",8918,"designCases",8804,"finishCases",8210,"iterationCnt",6830,"taskCnt",3998,"finishTaskCnt",5117,"bizDate","aF5k","bugCnt",250,"groupId","IVjB","projectId","TkC4","projectName","a0z7","groupName","YeYe");
		XmProjectGroupState xmProjectGroupState5=BaseUtils.fromMap(p5,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState5);
		Map p6=BaseUtils.map("id","IxoE","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",6574.41,"actWorkload",9728.25,"planCostAmount",2898.42,"actCostAmount",367.59,"finishRate",9159.54,"demandRate",6003.78,"designRate",1154.92,"devRate",3272.4,"uatRate",8451.33,"sitRate",8890.1,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",2116.26,"planWorkerCnt",3230.55,"closedBugs",6862,"activeBugs",2297,"confirmedBugs",7321,"resolvedBugs",4838,"testCases",3768,"execCases",6510,"designCases",5674,"finishCases",5634,"iterationCnt",2592,"taskCnt",8343,"finishTaskCnt",6688,"bizDate","33hp","bugCnt",631,"groupId","iLYo","projectId","XHb8","projectName","l0Hw","groupName","60U1");
		XmProjectGroupState xmProjectGroupState6=BaseUtils.fromMap(p6,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState6);
		Map p7=BaseUtils.map("id","9FKt","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5780.46,"actWorkload",9926.04,"planCostAmount",1192.03,"actCostAmount",7299.85,"finishRate",232.8,"demandRate",3484.97,"designRate",7637.16,"devRate",8210.62,"uatRate",2463.07,"sitRate",9300.27,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",6162.17,"planWorkerCnt",5981.89,"closedBugs",5910,"activeBugs",3090,"confirmedBugs",25,"resolvedBugs",6796,"testCases",7335,"execCases",1891,"designCases",2428,"finishCases",3734,"iterationCnt",2524,"taskCnt",6396,"finishTaskCnt",4043,"bizDate","A0vR","bugCnt",9356,"groupId","bpRG","projectId","det9","projectName","JD7Y","groupName","0DQo");
		XmProjectGroupState xmProjectGroupState7=BaseUtils.fromMap(p7,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState7);
		xmProjectGroupStateService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmProjectGroupState> batchValues=new ArrayList<XmProjectGroupState>();
		Map p0=BaseUtils.map("id","DOvX","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5488.29,"actWorkload",825.29,"planCostAmount",8827.71,"actCostAmount",3822.04,"finishRate",1922.27,"demandRate",406.64,"designRate",7908.15,"devRate",7840.41,"uatRate",2388.7,"sitRate",1579.68,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",5541.15,"planWorkerCnt",4294.3,"closedBugs",7483,"activeBugs",7367,"confirmedBugs",2008,"resolvedBugs",9839,"testCases",9608,"execCases",8125,"designCases",833,"finishCases",7535,"iterationCnt",39,"taskCnt",9196,"finishTaskCnt",8478,"bizDate","L2PF","bugCnt",6252,"groupId","83u4","projectId","yYyx","projectName","j2vJ","groupName","rYC6");
		XmProjectGroupState xmProjectGroupState0=BaseUtils.fromMap(p0,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState0);
		Map p1=BaseUtils.map("id","EUJM","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",617.76,"actWorkload",783.22,"planCostAmount",1274.92,"actCostAmount",3618.43,"finishRate",4708.39,"demandRate",5992.55,"designRate",9174.16,"devRate",1957.67,"uatRate",42.99,"sitRate",2536.12,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",3548.38,"planWorkerCnt",2102.75,"closedBugs",9733,"activeBugs",1947,"confirmedBugs",877,"resolvedBugs",2019,"testCases",3403,"execCases",6043,"designCases",6199,"finishCases",2130,"iterationCnt",652,"taskCnt",3506,"finishTaskCnt",7108,"bizDate","TKj3","bugCnt",2360,"groupId","P2Uu","projectId","OYr1","projectName","JTVV","groupName","2pnV");
		XmProjectGroupState xmProjectGroupState1=BaseUtils.fromMap(p1,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState1);
		Map p2=BaseUtils.map("id","1YeW","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",98.43,"actWorkload",5783.09,"planCostAmount",7610.18,"actCostAmount",5938.59,"finishRate",8626.3,"demandRate",4516.56,"designRate",8407.81,"devRate",5794.13,"uatRate",5135.29,"sitRate",5660.68,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",272.19,"planWorkerCnt",8830.04,"closedBugs",8998,"activeBugs",8700,"confirmedBugs",9366,"resolvedBugs",2041,"testCases",8860,"execCases",4314,"designCases",9651,"finishCases",904,"iterationCnt",9949,"taskCnt",2144,"finishTaskCnt",9102,"bizDate","L9a1","bugCnt",8487,"groupId","zlJz","projectId","d8Ki","projectName","QIOK","groupName","MGY7");
		XmProjectGroupState xmProjectGroupState2=BaseUtils.fromMap(p2,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState2);
		Map p3=BaseUtils.map("id","4PxH","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5333.37,"actWorkload",3346.64,"planCostAmount",2818.49,"actCostAmount",9414.22,"finishRate",5881.15,"demandRate",6518.12,"designRate",1686.26,"devRate",9814.01,"uatRate",2988.59,"sitRate",3443.32,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",570.91,"planWorkerCnt",623.31,"closedBugs",9590,"activeBugs",415,"confirmedBugs",6990,"resolvedBugs",5464,"testCases",7787,"execCases",4031,"designCases",8331,"finishCases",3687,"iterationCnt",3871,"taskCnt",3034,"finishTaskCnt",218,"bizDate","8H18","bugCnt",9453,"groupId","VWH7","projectId","l42y","projectName","1rzV","groupName","3j1W");
		XmProjectGroupState xmProjectGroupState3=BaseUtils.fromMap(p3,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState3);
		Map p4=BaseUtils.map("id","s06p","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",8437.65,"actWorkload",3335.25,"planCostAmount",653.12,"actCostAmount",8343.87,"finishRate",8123.18,"demandRate",9655.17,"designRate",3098.1,"devRate",4656.57,"uatRate",9338.11,"sitRate",6700.86,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",1669.7,"planWorkerCnt",386.19,"closedBugs",9914,"activeBugs",7629,"confirmedBugs",6410,"resolvedBugs",5669,"testCases",2875,"execCases",403,"designCases",5957,"finishCases",3264,"iterationCnt",1658,"taskCnt",5591,"finishTaskCnt",1854,"bizDate","qM6b","bugCnt",6199,"groupId","tlfS","projectId","CYo7","projectName","2vm1","groupName","1ZC1");
		XmProjectGroupState xmProjectGroupState4=BaseUtils.fromMap(p4,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState4);
		Map p5=BaseUtils.map("id","9J5k","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5481.59,"actWorkload",7823.25,"planCostAmount",9313.53,"actCostAmount",6602.51,"finishRate",2541.96,"demandRate",2656.73,"designRate",6974.25,"devRate",549.91,"uatRate",7661.16,"sitRate",2952.45,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",1456.38,"planWorkerCnt",1030.67,"closedBugs",3632,"activeBugs",5079,"confirmedBugs",2632,"resolvedBugs",6489,"testCases",713,"execCases",8918,"designCases",8804,"finishCases",8210,"iterationCnt",6830,"taskCnt",3998,"finishTaskCnt",5117,"bizDate","aF5k","bugCnt",250,"groupId","IVjB","projectId","TkC4","projectName","a0z7","groupName","YeYe");
		XmProjectGroupState xmProjectGroupState5=BaseUtils.fromMap(p5,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState5);
		Map p6=BaseUtils.map("id","IxoE","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",6574.41,"actWorkload",9728.25,"planCostAmount",2898.42,"actCostAmount",367.59,"finishRate",9159.54,"demandRate",6003.78,"designRate",1154.92,"devRate",3272.4,"uatRate",8451.33,"sitRate",8890.1,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",2116.26,"planWorkerCnt",3230.55,"closedBugs",6862,"activeBugs",2297,"confirmedBugs",7321,"resolvedBugs",4838,"testCases",3768,"execCases",6510,"designCases",5674,"finishCases",5634,"iterationCnt",2592,"taskCnt",8343,"finishTaskCnt",6688,"bizDate","33hp","bugCnt",631,"groupId","iLYo","projectId","XHb8","projectName","l0Hw","groupName","60U1");
		XmProjectGroupState xmProjectGroupState6=BaseUtils.fromMap(p6,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState6);
		Map p7=BaseUtils.map("id","9FKt","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5780.46,"actWorkload",9926.04,"planCostAmount",1192.03,"actCostAmount",7299.85,"finishRate",232.8,"demandRate",3484.97,"designRate",7637.16,"devRate",8210.62,"uatRate",2463.07,"sitRate",9300.27,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",6162.17,"planWorkerCnt",5981.89,"closedBugs",5910,"activeBugs",3090,"confirmedBugs",25,"resolvedBugs",6796,"testCases",7335,"execCases",1891,"designCases",2428,"finishCases",3734,"iterationCnt",2524,"taskCnt",6396,"finishTaskCnt",4043,"bizDate","A0vR","bugCnt",9356,"groupId","bpRG","projectId","det9","projectName","JD7Y","groupName","0DQo");
		XmProjectGroupState xmProjectGroupState7=BaseUtils.fromMap(p7,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState7);
		xmProjectGroupStateService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmProjectGroupState> batchValues=new ArrayList<XmProjectGroupState>();
		Map p0=BaseUtils.map("id","DOvX","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5488.29,"actWorkload",825.29,"planCostAmount",8827.71,"actCostAmount",3822.04,"finishRate",1922.27,"demandRate",406.64,"designRate",7908.15,"devRate",7840.41,"uatRate",2388.7,"sitRate",1579.68,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",5541.15,"planWorkerCnt",4294.3,"closedBugs",7483,"activeBugs",7367,"confirmedBugs",2008,"resolvedBugs",9839,"testCases",9608,"execCases",8125,"designCases",833,"finishCases",7535,"iterationCnt",39,"taskCnt",9196,"finishTaskCnt",8478,"bizDate","L2PF","bugCnt",6252,"groupId","83u4","projectId","yYyx","projectName","j2vJ","groupName","rYC6");
		XmProjectGroupState xmProjectGroupState0=BaseUtils.fromMap(p0,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState0);
		Map p1=BaseUtils.map("id","EUJM","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",617.76,"actWorkload",783.22,"planCostAmount",1274.92,"actCostAmount",3618.43,"finishRate",4708.39,"demandRate",5992.55,"designRate",9174.16,"devRate",1957.67,"uatRate",42.99,"sitRate",2536.12,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",3548.38,"planWorkerCnt",2102.75,"closedBugs",9733,"activeBugs",1947,"confirmedBugs",877,"resolvedBugs",2019,"testCases",3403,"execCases",6043,"designCases",6199,"finishCases",2130,"iterationCnt",652,"taskCnt",3506,"finishTaskCnt",7108,"bizDate","TKj3","bugCnt",2360,"groupId","P2Uu","projectId","OYr1","projectName","JTVV","groupName","2pnV");
		XmProjectGroupState xmProjectGroupState1=BaseUtils.fromMap(p1,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState1);
		Map p2=BaseUtils.map("id","1YeW","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",98.43,"actWorkload",5783.09,"planCostAmount",7610.18,"actCostAmount",5938.59,"finishRate",8626.3,"demandRate",4516.56,"designRate",8407.81,"devRate",5794.13,"uatRate",5135.29,"sitRate",5660.68,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",272.19,"planWorkerCnt",8830.04,"closedBugs",8998,"activeBugs",8700,"confirmedBugs",9366,"resolvedBugs",2041,"testCases",8860,"execCases",4314,"designCases",9651,"finishCases",904,"iterationCnt",9949,"taskCnt",2144,"finishTaskCnt",9102,"bizDate","L9a1","bugCnt",8487,"groupId","zlJz","projectId","d8Ki","projectName","QIOK","groupName","MGY7");
		XmProjectGroupState xmProjectGroupState2=BaseUtils.fromMap(p2,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState2);
		Map p3=BaseUtils.map("id","4PxH","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5333.37,"actWorkload",3346.64,"planCostAmount",2818.49,"actCostAmount",9414.22,"finishRate",5881.15,"demandRate",6518.12,"designRate",1686.26,"devRate",9814.01,"uatRate",2988.59,"sitRate",3443.32,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",570.91,"planWorkerCnt",623.31,"closedBugs",9590,"activeBugs",415,"confirmedBugs",6990,"resolvedBugs",5464,"testCases",7787,"execCases",4031,"designCases",8331,"finishCases",3687,"iterationCnt",3871,"taskCnt",3034,"finishTaskCnt",218,"bizDate","8H18","bugCnt",9453,"groupId","VWH7","projectId","l42y","projectName","1rzV","groupName","3j1W");
		XmProjectGroupState xmProjectGroupState3=BaseUtils.fromMap(p3,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState3);
		Map p4=BaseUtils.map("id","s06p","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",8437.65,"actWorkload",3335.25,"planCostAmount",653.12,"actCostAmount",8343.87,"finishRate",8123.18,"demandRate",9655.17,"designRate",3098.1,"devRate",4656.57,"uatRate",9338.11,"sitRate",6700.86,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",1669.7,"planWorkerCnt",386.19,"closedBugs",9914,"activeBugs",7629,"confirmedBugs",6410,"resolvedBugs",5669,"testCases",2875,"execCases",403,"designCases",5957,"finishCases",3264,"iterationCnt",1658,"taskCnt",5591,"finishTaskCnt",1854,"bizDate","qM6b","bugCnt",6199,"groupId","tlfS","projectId","CYo7","projectName","2vm1","groupName","1ZC1");
		XmProjectGroupState xmProjectGroupState4=BaseUtils.fromMap(p4,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState4);
		Map p5=BaseUtils.map("id","9J5k","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5481.59,"actWorkload",7823.25,"planCostAmount",9313.53,"actCostAmount",6602.51,"finishRate",2541.96,"demandRate",2656.73,"designRate",6974.25,"devRate",549.91,"uatRate",7661.16,"sitRate",2952.45,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",1456.38,"planWorkerCnt",1030.67,"closedBugs",3632,"activeBugs",5079,"confirmedBugs",2632,"resolvedBugs",6489,"testCases",713,"execCases",8918,"designCases",8804,"finishCases",8210,"iterationCnt",6830,"taskCnt",3998,"finishTaskCnt",5117,"bizDate","aF5k","bugCnt",250,"groupId","IVjB","projectId","TkC4","projectName","a0z7","groupName","YeYe");
		XmProjectGroupState xmProjectGroupState5=BaseUtils.fromMap(p5,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState5);
		Map p6=BaseUtils.map("id","IxoE","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",6574.41,"actWorkload",9728.25,"planCostAmount",2898.42,"actCostAmount",367.59,"finishRate",9159.54,"demandRate",6003.78,"designRate",1154.92,"devRate",3272.4,"uatRate",8451.33,"sitRate",8890.1,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",2116.26,"planWorkerCnt",3230.55,"closedBugs",6862,"activeBugs",2297,"confirmedBugs",7321,"resolvedBugs",4838,"testCases",3768,"execCases",6510,"designCases",5674,"finishCases",5634,"iterationCnt",2592,"taskCnt",8343,"finishTaskCnt",6688,"bizDate","33hp","bugCnt",631,"groupId","iLYo","projectId","XHb8","projectName","l0Hw","groupName","60U1");
		XmProjectGroupState xmProjectGroupState6=BaseUtils.fromMap(p6,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState6);
		Map p7=BaseUtils.map("id","9FKt","planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5780.46,"actWorkload",9926.04,"planCostAmount",1192.03,"actCostAmount",7299.85,"finishRate",232.8,"demandRate",3484.97,"designRate",7637.16,"devRate",8210.62,"uatRate",2463.07,"sitRate",9300.27,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",6162.17,"planWorkerCnt",5981.89,"closedBugs",5910,"activeBugs",3090,"confirmedBugs",25,"resolvedBugs",6796,"testCases",7335,"execCases",1891,"designCases",2428,"finishCases",3734,"iterationCnt",2524,"taskCnt",6396,"finishTaskCnt",4043,"bizDate","A0vR","bugCnt",9356,"groupId","bpRG","projectId","det9","projectName","JD7Y","groupName","0DQo");
		XmProjectGroupState xmProjectGroupState7=BaseUtils.fromMap(p7,XmProjectGroupState.class);
		batchValues.add(xmProjectGroupState7);
		xmProjectGroupStateService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","DOvX");
		Map<String,Object> result=this.xmProjectGroupStateService.selectOne(XmProjectGroupState.class.getName()+".selectOneMap",p);
		Assert.assertEquals("DOvX", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5488.29,"actWorkload",825.29,"planCostAmount",8827.71,"actCostAmount",3822.04,"finishRate",1922.27,"demandRate",406.64,"designRate",7908.15,"devRate",7840.41,"uatRate",2388.7,"sitRate",1579.68,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",5541.15,"planWorkerCnt",4294.3,"closedBugs",7483,"activeBugs",7367,"confirmedBugs",2008,"resolvedBugs",9839,"testCases",9608,"execCases",8125,"designCases",833,"finishCases",7535,"iterationCnt",39,"taskCnt",9196,"finishTaskCnt",8478,"bizDate","L2PF","bugCnt",6252,"groupId","83u4","projectId","yYyx","projectName","j2vJ","groupName","rYC6");
		XmProjectGroupState xmProjectGroupState=BaseUtils.fromMap(p,XmProjectGroupState.class);
		long result=xmProjectGroupStateService.countByWhere(xmProjectGroupState);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5488.29,"actWorkload",825.29,"planCostAmount",8827.71,"actCostAmount",3822.04,"finishRate",1922.27,"demandRate",406.64,"designRate",7908.15,"devRate",7840.41,"uatRate",2388.7,"sitRate",1579.68,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",5541.15,"planWorkerCnt",4294.3,"closedBugs",7483,"activeBugs",7367,"confirmedBugs",2008,"resolvedBugs",9839,"testCases",9608,"execCases",8125,"designCases",833,"finishCases",7535,"iterationCnt",39,"taskCnt",9196,"finishTaskCnt",8478,"bizDate","L2PF","bugCnt",6252,"groupId","83u4","projectId","yYyx","projectName","j2vJ","groupName","rYC6");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmProjectGroupState xmProjectGroupState=BaseUtils.fromMap(p,XmProjectGroupState.class);
		List<XmProjectGroupState> result=xmProjectGroupStateService.selectListByWhere(xmProjectGroupState); 
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
	
		
		Map<String,Object> p=BaseUtils.map("planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5488.29,"actWorkload",825.29,"planCostAmount",8827.71,"actCostAmount",3822.04,"finishRate",1922.27,"demandRate",406.64,"designRate",7908.15,"devRate",7840.41,"uatRate",2388.7,"sitRate",1579.68,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",5541.15,"planWorkerCnt",4294.3,"closedBugs",7483,"activeBugs",7367,"confirmedBugs",2008,"resolvedBugs",9839,"testCases",9608,"execCases",8125,"designCases",833,"finishCases",7535,"iterationCnt",39,"taskCnt",9196,"finishTaskCnt",8478,"bizDate","L2PF","bugCnt",6252,"groupId","83u4","projectId","yYyx","projectName","j2vJ","groupName","rYC6");
		XmProjectGroupState xmProjectGroupState=BaseUtils.fromMap(p,XmProjectGroupState.class);
		List<XmProjectGroupState> result=xmProjectGroupStateService.selectListByWhere(xmProjectGroupState);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5488.29,"actWorkload",825.29,"planCostAmount",8827.71,"actCostAmount",3822.04,"finishRate",1922.27,"demandRate",406.64,"designRate",7908.15,"devRate",7840.41,"uatRate",2388.7,"sitRate",1579.68,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",5541.15,"planWorkerCnt",4294.3,"closedBugs",7483,"activeBugs",7367,"confirmedBugs",2008,"resolvedBugs",9839,"testCases",9608,"execCases",8125,"designCases",833,"finishCases",7535,"iterationCnt",39,"taskCnt",9196,"finishTaskCnt",8478,"bizDate","L2PF","bugCnt",6252,"groupId","83u4","projectId","yYyx","projectName","j2vJ","groupName","rYC6");
		List<Map<String,Object>> result=xmProjectGroupStateService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("planStartTime",parse("2020-11-11 18:53:27"),"planEndTime",parse("2020-11-11 18:53:27"),"actStartTime",parse("2020-11-11 18:53:27"),"actEndTime",parse("2020-11-11 18:53:27"),"planWorkload",5488.29,"actWorkload",825.29,"planCostAmount",8827.71,"actCostAmount",3822.04,"finishRate",1922.27,"demandRate",406.64,"designRate",7908.15,"devRate",7840.41,"uatRate",2388.7,"sitRate",1579.68,"ctime",parse("2020-11-11 18:53:27"),"calcTime",parse("2020-11-11 18:53:27"),"planWorkhours",5541.15,"planWorkerCnt",4294.3,"closedBugs",7483,"activeBugs",7367,"confirmedBugs",2008,"resolvedBugs",9839,"testCases",9608,"execCases",8125,"designCases",833,"finishCases",7535,"iterationCnt",39,"taskCnt",9196,"finishTaskCnt",8478,"bizDate","L2PF","bugCnt",6252,"groupId","83u4","projectId","yYyx","projectName","j2vJ","groupName","rYC6");
		List<Map<String,Object>> result=xmProjectGroupStateService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmProjectGroupState
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","DOvX");
		
		XmProjectGroupState xmProjectGroupState1=BaseUtils.fromMap(p,XmProjectGroupState.class);
		XmProjectGroupState xmProjectGroupState=xmProjectGroupStateService.selectOneObject(xmProjectGroupState1);
		Assert.assertEquals("DOvX", xmProjectGroupState.getId());
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
