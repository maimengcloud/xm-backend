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
import  com.qqkj.xm.core.service.XmMenuStateService; 
import com.qqkj.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import  com.qqkj.xm.core.entity.XmMenuState;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmMenuStateService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_menu_state 功能状态表,无需前端维护，所有数据由汇总统计得出<br>
 * 实体 XmMenuState<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,menuId,planStartTime,planEndTime,actStartTime,actEndTime,planWorkload,actWorkload,planCostAmount,actCostAmount,finishRate,demandRate,designRate,devRate,uatRate,sitRate,onlineStatus,onlineTime,planStatus,chargeUserid,chargeUsername,menuStatus,ctime,ltime,cuserid,cusername,calcTime,menuName,planWorkhours,planWorkerCnt,closedBugs,activeBugs,confirmedBugs,resolvedBugs,productId,productName,testCases,execCases,designCases,finishCases,projectCnt,iterationCnt,taskCnt,finishTaskCnt,bizDate,bugCnt;<br>
 * 当前表的所有字段名:<br>
 *	id,menu_id,plan_start_time,plan_end_time,act_start_time,act_end_time,plan_workload,act_workload,plan_cost_amount,act_cost_amount,finish_rate,demand_rate,design_rate,dev_rate,uat_rate,sit_rate,online_status,online_time,plan_status,charge_userid,charge_username,menu_status,ctime,ltime,cuserid,cusername,calc_time,menu_name,plan_workhours,plan_worker_cnt,closed_bugs,active_bugs,confirmed_bugs,resolved_bugs,product_id,product_name,test_cases,exec_cases,design_cases,finish_cases,project_cnt,iteration_cnt,task_cnt,finish_task_cnt,biz_date,bug_cnt;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmMenuStateService  {

	@Autowired
	XmMenuStateService xmMenuStateService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","IlfF","menuId","eg9z","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",5365.06,"actWorkload",8408.04,"planCostAmount",4918.87,"actCostAmount",6936.21,"finishRate",5995.51,"demandRate",8902.8,"designRate",856.81,"devRate",5333.85,"uatRate",9071.12,"sitRate",2411.15,"onlineStatus","F","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","t","chargeUserid","9ej6","chargeUsername","cm38","menuStatus","b","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","OVG5","cusername","3ui8","calcTime",parse("2020-11-11 18:53:25"),"menuName","pt5r","planWorkhours",6637.37,"planWorkerCnt",2089,"closedBugs",7900,"activeBugs",3204,"confirmedBugs",668,"resolvedBugs",6956,"productId","AQqj","productName","g8C9","testCases",3815,"execCases",8026,"designCases",4758,"finishCases",4081,"projectCnt",3067,"iterationCnt",4235,"taskCnt",3309,"finishTaskCnt",7563,"bizDate","ecC1","bugCnt",3457);
		XmMenuState xmMenuState=BaseUtils.fromMap(p,XmMenuState.class);
		xmMenuStateService.insert(xmMenuState);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("menuId","eg9z","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",5365.06,"actWorkload",8408.04,"planCostAmount",4918.87,"actCostAmount",6936.21,"finishRate",5995.51,"demandRate",8902.8,"designRate",856.81,"devRate",5333.85,"uatRate",9071.12,"sitRate",2411.15,"onlineStatus","F","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","t","chargeUserid","9ej6","chargeUsername","cm38","menuStatus","b","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","OVG5","cusername","3ui8","calcTime",parse("2020-11-11 18:53:25"),"menuName","pt5r","planWorkhours",6637.37,"planWorkerCnt",2089,"closedBugs",7900,"activeBugs",3204,"confirmedBugs",668,"resolvedBugs",6956,"productId","AQqj","productName","g8C9","testCases",3815,"execCases",8026,"designCases",4758,"finishCases",4081,"projectCnt",3067,"iterationCnt",4235,"taskCnt",3309,"finishTaskCnt",7563,"bizDate","ecC1","bugCnt",3457);
		XmMenuState xmMenuState=BaseUtils.fromMap(p,XmMenuState.class);
		xmMenuStateService.deleteByWhere(xmMenuState);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","IlfF");
		XmMenuState xmMenuState=BaseUtils.fromMap(p,XmMenuState.class);
		xmMenuStateService.deleteByPk(xmMenuState);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("menuId","eg9z","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",5365.06,"actWorkload",8408.04,"planCostAmount",4918.87,"actCostAmount",6936.21,"finishRate",5995.51,"demandRate",8902.8,"designRate",856.81,"devRate",5333.85,"uatRate",9071.12,"sitRate",2411.15,"onlineStatus","F","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","t","chargeUserid","9ej6","chargeUsername","cm38","menuStatus","b","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","OVG5","cusername","3ui8","calcTime",parse("2020-11-11 18:53:25"),"menuName","pt5r","planWorkhours",6637.37,"planWorkerCnt",2089,"closedBugs",7900,"activeBugs",3204,"confirmedBugs",668,"resolvedBugs",6956,"productId","AQqj","productName","g8C9","testCases",3815,"execCases",8026,"designCases",4758,"finishCases",4081,"projectCnt",3067,"iterationCnt",4235,"taskCnt",3309,"finishTaskCnt",7563,"bizDate","ecC1","bugCnt",3457);
		XmMenuState xmMenuState=BaseUtils.fromMap(where,XmMenuState.class);
		xmMenuStateService.updateSomeFieldByPk(xmMenuState);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","IlfF");
		XmMenuState xmMenuState=BaseUtils.fromMap(p,XmMenuState.class);
		xmMenuStateService.updateByPk(xmMenuState);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("id","IlfF","menuId","eg9z","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",5365.06,"actWorkload",8408.04,"planCostAmount",4918.87,"actCostAmount",6936.21,"finishRate",5995.51,"demandRate",8902.8,"designRate",856.81,"devRate",5333.85,"uatRate",9071.12,"sitRate",2411.15,"onlineStatus","F","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","t","chargeUserid","9ej6","chargeUsername","cm38","menuStatus","b","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","OVG5","cusername","3ui8","calcTime",parse("2020-11-11 18:53:25"),"menuName","pt5r","planWorkhours",6637.37,"planWorkerCnt",2089,"closedBugs",7900,"activeBugs",3204,"confirmedBugs",668,"resolvedBugs",6956,"productId","AQqj","productName","g8C9","testCases",3815,"execCases",8026,"designCases",4758,"finishCases",4081,"projectCnt",3067,"iterationCnt",4235,"taskCnt",3309,"finishTaskCnt",7563,"bizDate","ecC1","bugCnt",3457);
		XmMenuState xmMenuState=BaseUtils.fromMap(p,XmMenuState.class);
		xmMenuStateService.insertOrUpdate(xmMenuState);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmMenuState> batchValues=new ArrayList<XmMenuState>();
		Map p0=BaseUtils.map("id","IlfF","menuId","eg9z","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",5365.06,"actWorkload",8408.04,"planCostAmount",4918.87,"actCostAmount",6936.21,"finishRate",5995.51,"demandRate",8902.8,"designRate",856.81,"devRate",5333.85,"uatRate",9071.12,"sitRate",2411.15,"onlineStatus","F","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","t","chargeUserid","9ej6","chargeUsername","cm38","menuStatus","b","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","OVG5","cusername","3ui8","calcTime",parse("2020-11-11 18:53:25"),"menuName","pt5r","planWorkhours",6637.37,"planWorkerCnt",2089,"closedBugs",7900,"activeBugs",3204,"confirmedBugs",668,"resolvedBugs",6956,"productId","AQqj","productName","g8C9","testCases",3815,"execCases",8026,"designCases",4758,"finishCases",4081,"projectCnt",3067,"iterationCnt",4235,"taskCnt",3309,"finishTaskCnt",7563,"bizDate","ecC1","bugCnt",3457);
		XmMenuState xmMenuState0=BaseUtils.fromMap(p0,XmMenuState.class);
		batchValues.add(xmMenuState0);
		Map p1=BaseUtils.map("id","zJ10","menuId","lvP1","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",9047.83,"actWorkload",7483.95,"planCostAmount",1479.86,"actCostAmount",2319.43,"finishRate",891.9,"demandRate",6941.65,"designRate",129.85,"devRate",1711.52,"uatRate",7903.72,"sitRate",5194.12,"onlineStatus","D","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","2","chargeUserid","k69H","chargeUsername","F7FZ","menuStatus","n","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","5YrD","cusername","IfcC","calcTime",parse("2020-11-11 18:53:25"),"menuName","DKmH","planWorkhours",4265.11,"planWorkerCnt",1641.33,"closedBugs",4295,"activeBugs",2202,"confirmedBugs",2412,"resolvedBugs",4903,"productId","Ww7r","productName","P40C","testCases",8800,"execCases",1275,"designCases",8331,"finishCases",4119,"projectCnt",1617,"iterationCnt",743,"taskCnt",3177,"finishTaskCnt",8778,"bizDate","bJu8","bugCnt",5795);
		XmMenuState xmMenuState1=BaseUtils.fromMap(p1,XmMenuState.class);
		batchValues.add(xmMenuState1);
		Map p2=BaseUtils.map("id","T7bQ","menuId","oH62","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",2441.56,"actWorkload",9519.91,"planCostAmount",8212.14,"actCostAmount",5984.13,"finishRate",7658.94,"demandRate",8476.98,"designRate",5305.44,"devRate",141.65,"uatRate",5860.03,"sitRate",2716.02,"onlineStatus","2","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","c","chargeUserid","3L23","chargeUsername","tf8o","menuStatus","I","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","6S9X","cusername","aqy4","calcTime",parse("2020-11-11 18:53:25"),"menuName","Dije","planWorkhours",1682.32,"planWorkerCnt",2334.39,"closedBugs",122,"activeBugs",2830,"confirmedBugs",2380,"resolvedBugs",5960,"productId","qa24","productName","s2AG","testCases",9782,"execCases",4376,"designCases",6191,"finishCases",7701,"projectCnt",9352,"iterationCnt",1205,"taskCnt",1145,"finishTaskCnt",7238,"bizDate","bCKy","bugCnt",1781);
		XmMenuState xmMenuState2=BaseUtils.fromMap(p2,XmMenuState.class);
		batchValues.add(xmMenuState2);
		Map p3=BaseUtils.map("id","KSqG","menuId","Qqr2","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",7951.27,"actWorkload",6242.69,"planCostAmount",6073.8,"actCostAmount",1671.43,"finishRate",5744.25,"demandRate",7424.87,"designRate",8322.26,"devRate",9215.51,"uatRate",4138.83,"sitRate",168,"onlineStatus","3","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","9","chargeUserid","4xMU","chargeUsername","cFBx","menuStatus","b","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","XYgF","cusername","BWA2","calcTime",parse("2020-11-11 18:53:25"),"menuName","Z1VF","planWorkhours",7479.26,"planWorkerCnt",5580.71,"closedBugs",5774,"activeBugs",7507,"confirmedBugs",4528,"resolvedBugs",5720,"productId","z4l9","productName","52ex","testCases",6747,"execCases",3353,"designCases",8183,"finishCases",1341,"projectCnt",9873,"iterationCnt",3241,"taskCnt",9435,"finishTaskCnt",1349,"bizDate","4Sb9","bugCnt",2485);
		XmMenuState xmMenuState3=BaseUtils.fromMap(p3,XmMenuState.class);
		batchValues.add(xmMenuState3);
		Map p4=BaseUtils.map("id","GgsI","menuId","7tSV","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",999.69,"actWorkload",6531.93,"planCostAmount",1667.28,"actCostAmount",9395.24,"finishRate",3563.86,"demandRate",282.83,"designRate",8993.32,"devRate",7277.64,"uatRate",9566.53,"sitRate",1168.88,"onlineStatus","d","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","E","chargeUserid","GC92","chargeUsername","Mob8","menuStatus","0","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","o628","cusername","Q8UU","calcTime",parse("2020-11-11 18:53:25"),"menuName","FiiQ","planWorkhours",371.12,"planWorkerCnt",3461.04,"closedBugs",8128,"activeBugs",8439,"confirmedBugs",8284,"resolvedBugs",6970,"productId","4w9k","productName","6iSK","testCases",4798,"execCases",5129,"designCases",1143,"finishCases",9839,"projectCnt",5316,"iterationCnt",8130,"taskCnt",1801,"finishTaskCnt",3720,"bizDate","509i","bugCnt",3996);
		XmMenuState xmMenuState4=BaseUtils.fromMap(p4,XmMenuState.class);
		batchValues.add(xmMenuState4);
		Map p5=BaseUtils.map("id","DIJa","menuId","u592","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",5215.6,"actWorkload",3360.35,"planCostAmount",8566.78,"actCostAmount",4624.41,"finishRate",1610.67,"demandRate",7771.61,"designRate",4305.35,"devRate",1074.64,"uatRate",1623.31,"sitRate",8442.84,"onlineStatus","m","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","9","chargeUserid","Cq3l","chargeUsername","PMCF","menuStatus","s","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","o9H5","cusername","AbIT","calcTime",parse("2020-11-11 18:53:25"),"menuName","SES8","planWorkhours",8487.44,"planWorkerCnt",9935.73,"closedBugs",7476,"activeBugs",9896,"confirmedBugs",6534,"resolvedBugs",911,"productId","FVgX","productName","uoih","testCases",352,"execCases",1579,"designCases",8560,"finishCases",7662,"projectCnt",1699,"iterationCnt",2730,"taskCnt",935,"finishTaskCnt",3411,"bizDate","yX8e","bugCnt",3916);
		XmMenuState xmMenuState5=BaseUtils.fromMap(p5,XmMenuState.class);
		batchValues.add(xmMenuState5);
		Map p6=BaseUtils.map("id","6ZLk","menuId","WQL4","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",776.22,"actWorkload",541.85,"planCostAmount",9374.85,"actCostAmount",1699.15,"finishRate",5315,"demandRate",8390.47,"designRate",6638.11,"devRate",229.07,"uatRate",5375.38,"sitRate",4805.81,"onlineStatus","1","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","5","chargeUserid","FHDO","chargeUsername","tcpz","menuStatus","E","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","QKhy","cusername","0Nvp","calcTime",parse("2020-11-11 18:53:25"),"menuName","0Qnf","planWorkhours",8061.11,"planWorkerCnt",640.49,"closedBugs",6360,"activeBugs",251,"confirmedBugs",704,"resolvedBugs",6275,"productId","wR3R","productName","0s97","testCases",5497,"execCases",9245,"designCases",4580,"finishCases",655,"projectCnt",3028,"iterationCnt",3426,"taskCnt",2582,"finishTaskCnt",5876,"bizDate","7tey","bugCnt",4891);
		XmMenuState xmMenuState6=BaseUtils.fromMap(p6,XmMenuState.class);
		batchValues.add(xmMenuState6);
		Map p7=BaseUtils.map("id","2I3o","menuId","Ut63","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",321.34,"actWorkload",8163.81,"planCostAmount",7499.75,"actCostAmount",9042.03,"finishRate",7730.37,"demandRate",5200.26,"designRate",9969.44,"devRate",4398.89,"uatRate",3976.55,"sitRate",1685.47,"onlineStatus","t","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","4","chargeUserid","bX11","chargeUsername","h233","menuStatus","l","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","JI8S","cusername","1wc4","calcTime",parse("2020-11-11 18:53:25"),"menuName","Wq8R","planWorkhours",8744.07,"planWorkerCnt",3810.39,"closedBugs",5634,"activeBugs",5634,"confirmedBugs",5551,"resolvedBugs",9269,"productId","6J46","productName","9YLy","testCases",7978,"execCases",7227,"designCases",319,"finishCases",2101,"projectCnt",6358,"iterationCnt",5572,"taskCnt",9553,"finishTaskCnt",5603,"bizDate","d5Dc","bugCnt",8459);
		XmMenuState xmMenuState7=BaseUtils.fromMap(p7,XmMenuState.class);
		batchValues.add(xmMenuState7);
		xmMenuStateService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmMenuState> batchValues=new ArrayList<XmMenuState>();
		Map p0=BaseUtils.map("id","IlfF","menuId","eg9z","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",5365.06,"actWorkload",8408.04,"planCostAmount",4918.87,"actCostAmount",6936.21,"finishRate",5995.51,"demandRate",8902.8,"designRate",856.81,"devRate",5333.85,"uatRate",9071.12,"sitRate",2411.15,"onlineStatus","F","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","t","chargeUserid","9ej6","chargeUsername","cm38","menuStatus","b","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","OVG5","cusername","3ui8","calcTime",parse("2020-11-11 18:53:25"),"menuName","pt5r","planWorkhours",6637.37,"planWorkerCnt",2089,"closedBugs",7900,"activeBugs",3204,"confirmedBugs",668,"resolvedBugs",6956,"productId","AQqj","productName","g8C9","testCases",3815,"execCases",8026,"designCases",4758,"finishCases",4081,"projectCnt",3067,"iterationCnt",4235,"taskCnt",3309,"finishTaskCnt",7563,"bizDate","ecC1","bugCnt",3457);
		XmMenuState xmMenuState0=BaseUtils.fromMap(p0,XmMenuState.class);
		batchValues.add(xmMenuState0);
		Map p1=BaseUtils.map("id","zJ10","menuId","lvP1","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",9047.83,"actWorkload",7483.95,"planCostAmount",1479.86,"actCostAmount",2319.43,"finishRate",891.9,"demandRate",6941.65,"designRate",129.85,"devRate",1711.52,"uatRate",7903.72,"sitRate",5194.12,"onlineStatus","D","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","2","chargeUserid","k69H","chargeUsername","F7FZ","menuStatus","n","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","5YrD","cusername","IfcC","calcTime",parse("2020-11-11 18:53:25"),"menuName","DKmH","planWorkhours",4265.11,"planWorkerCnt",1641.33,"closedBugs",4295,"activeBugs",2202,"confirmedBugs",2412,"resolvedBugs",4903,"productId","Ww7r","productName","P40C","testCases",8800,"execCases",1275,"designCases",8331,"finishCases",4119,"projectCnt",1617,"iterationCnt",743,"taskCnt",3177,"finishTaskCnt",8778,"bizDate","bJu8","bugCnt",5795);
		XmMenuState xmMenuState1=BaseUtils.fromMap(p1,XmMenuState.class);
		batchValues.add(xmMenuState1);
		Map p2=BaseUtils.map("id","T7bQ","menuId","oH62","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",2441.56,"actWorkload",9519.91,"planCostAmount",8212.14,"actCostAmount",5984.13,"finishRate",7658.94,"demandRate",8476.98,"designRate",5305.44,"devRate",141.65,"uatRate",5860.03,"sitRate",2716.02,"onlineStatus","2","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","c","chargeUserid","3L23","chargeUsername","tf8o","menuStatus","I","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","6S9X","cusername","aqy4","calcTime",parse("2020-11-11 18:53:25"),"menuName","Dije","planWorkhours",1682.32,"planWorkerCnt",2334.39,"closedBugs",122,"activeBugs",2830,"confirmedBugs",2380,"resolvedBugs",5960,"productId","qa24","productName","s2AG","testCases",9782,"execCases",4376,"designCases",6191,"finishCases",7701,"projectCnt",9352,"iterationCnt",1205,"taskCnt",1145,"finishTaskCnt",7238,"bizDate","bCKy","bugCnt",1781);
		XmMenuState xmMenuState2=BaseUtils.fromMap(p2,XmMenuState.class);
		batchValues.add(xmMenuState2);
		Map p3=BaseUtils.map("id","KSqG","menuId","Qqr2","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",7951.27,"actWorkload",6242.69,"planCostAmount",6073.8,"actCostAmount",1671.43,"finishRate",5744.25,"demandRate",7424.87,"designRate",8322.26,"devRate",9215.51,"uatRate",4138.83,"sitRate",168,"onlineStatus","3","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","9","chargeUserid","4xMU","chargeUsername","cFBx","menuStatus","b","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","XYgF","cusername","BWA2","calcTime",parse("2020-11-11 18:53:25"),"menuName","Z1VF","planWorkhours",7479.26,"planWorkerCnt",5580.71,"closedBugs",5774,"activeBugs",7507,"confirmedBugs",4528,"resolvedBugs",5720,"productId","z4l9","productName","52ex","testCases",6747,"execCases",3353,"designCases",8183,"finishCases",1341,"projectCnt",9873,"iterationCnt",3241,"taskCnt",9435,"finishTaskCnt",1349,"bizDate","4Sb9","bugCnt",2485);
		XmMenuState xmMenuState3=BaseUtils.fromMap(p3,XmMenuState.class);
		batchValues.add(xmMenuState3);
		Map p4=BaseUtils.map("id","GgsI","menuId","7tSV","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",999.69,"actWorkload",6531.93,"planCostAmount",1667.28,"actCostAmount",9395.24,"finishRate",3563.86,"demandRate",282.83,"designRate",8993.32,"devRate",7277.64,"uatRate",9566.53,"sitRate",1168.88,"onlineStatus","d","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","E","chargeUserid","GC92","chargeUsername","Mob8","menuStatus","0","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","o628","cusername","Q8UU","calcTime",parse("2020-11-11 18:53:25"),"menuName","FiiQ","planWorkhours",371.12,"planWorkerCnt",3461.04,"closedBugs",8128,"activeBugs",8439,"confirmedBugs",8284,"resolvedBugs",6970,"productId","4w9k","productName","6iSK","testCases",4798,"execCases",5129,"designCases",1143,"finishCases",9839,"projectCnt",5316,"iterationCnt",8130,"taskCnt",1801,"finishTaskCnt",3720,"bizDate","509i","bugCnt",3996);
		XmMenuState xmMenuState4=BaseUtils.fromMap(p4,XmMenuState.class);
		batchValues.add(xmMenuState4);
		Map p5=BaseUtils.map("id","DIJa","menuId","u592","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",5215.6,"actWorkload",3360.35,"planCostAmount",8566.78,"actCostAmount",4624.41,"finishRate",1610.67,"demandRate",7771.61,"designRate",4305.35,"devRate",1074.64,"uatRate",1623.31,"sitRate",8442.84,"onlineStatus","m","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","9","chargeUserid","Cq3l","chargeUsername","PMCF","menuStatus","s","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","o9H5","cusername","AbIT","calcTime",parse("2020-11-11 18:53:25"),"menuName","SES8","planWorkhours",8487.44,"planWorkerCnt",9935.73,"closedBugs",7476,"activeBugs",9896,"confirmedBugs",6534,"resolvedBugs",911,"productId","FVgX","productName","uoih","testCases",352,"execCases",1579,"designCases",8560,"finishCases",7662,"projectCnt",1699,"iterationCnt",2730,"taskCnt",935,"finishTaskCnt",3411,"bizDate","yX8e","bugCnt",3916);
		XmMenuState xmMenuState5=BaseUtils.fromMap(p5,XmMenuState.class);
		batchValues.add(xmMenuState5);
		Map p6=BaseUtils.map("id","6ZLk","menuId","WQL4","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",776.22,"actWorkload",541.85,"planCostAmount",9374.85,"actCostAmount",1699.15,"finishRate",5315,"demandRate",8390.47,"designRate",6638.11,"devRate",229.07,"uatRate",5375.38,"sitRate",4805.81,"onlineStatus","1","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","5","chargeUserid","FHDO","chargeUsername","tcpz","menuStatus","E","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","QKhy","cusername","0Nvp","calcTime",parse("2020-11-11 18:53:25"),"menuName","0Qnf","planWorkhours",8061.11,"planWorkerCnt",640.49,"closedBugs",6360,"activeBugs",251,"confirmedBugs",704,"resolvedBugs",6275,"productId","wR3R","productName","0s97","testCases",5497,"execCases",9245,"designCases",4580,"finishCases",655,"projectCnt",3028,"iterationCnt",3426,"taskCnt",2582,"finishTaskCnt",5876,"bizDate","7tey","bugCnt",4891);
		XmMenuState xmMenuState6=BaseUtils.fromMap(p6,XmMenuState.class);
		batchValues.add(xmMenuState6);
		Map p7=BaseUtils.map("id","2I3o","menuId","Ut63","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",321.34,"actWorkload",8163.81,"planCostAmount",7499.75,"actCostAmount",9042.03,"finishRate",7730.37,"demandRate",5200.26,"designRate",9969.44,"devRate",4398.89,"uatRate",3976.55,"sitRate",1685.47,"onlineStatus","t","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","4","chargeUserid","bX11","chargeUsername","h233","menuStatus","l","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","JI8S","cusername","1wc4","calcTime",parse("2020-11-11 18:53:25"),"menuName","Wq8R","planWorkhours",8744.07,"planWorkerCnt",3810.39,"closedBugs",5634,"activeBugs",5634,"confirmedBugs",5551,"resolvedBugs",9269,"productId","6J46","productName","9YLy","testCases",7978,"execCases",7227,"designCases",319,"finishCases",2101,"projectCnt",6358,"iterationCnt",5572,"taskCnt",9553,"finishTaskCnt",5603,"bizDate","d5Dc","bugCnt",8459);
		XmMenuState xmMenuState7=BaseUtils.fromMap(p7,XmMenuState.class);
		batchValues.add(xmMenuState7);
		xmMenuStateService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmMenuState> batchValues=new ArrayList<XmMenuState>();
		Map p0=BaseUtils.map("id","IlfF","menuId","eg9z","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",5365.06,"actWorkload",8408.04,"planCostAmount",4918.87,"actCostAmount",6936.21,"finishRate",5995.51,"demandRate",8902.8,"designRate",856.81,"devRate",5333.85,"uatRate",9071.12,"sitRate",2411.15,"onlineStatus","F","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","t","chargeUserid","9ej6","chargeUsername","cm38","menuStatus","b","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","OVG5","cusername","3ui8","calcTime",parse("2020-11-11 18:53:25"),"menuName","pt5r","planWorkhours",6637.37,"planWorkerCnt",2089,"closedBugs",7900,"activeBugs",3204,"confirmedBugs",668,"resolvedBugs",6956,"productId","AQqj","productName","g8C9","testCases",3815,"execCases",8026,"designCases",4758,"finishCases",4081,"projectCnt",3067,"iterationCnt",4235,"taskCnt",3309,"finishTaskCnt",7563,"bizDate","ecC1","bugCnt",3457);
		XmMenuState xmMenuState0=BaseUtils.fromMap(p0,XmMenuState.class);
		batchValues.add(xmMenuState0);
		Map p1=BaseUtils.map("id","zJ10","menuId","lvP1","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",9047.83,"actWorkload",7483.95,"planCostAmount",1479.86,"actCostAmount",2319.43,"finishRate",891.9,"demandRate",6941.65,"designRate",129.85,"devRate",1711.52,"uatRate",7903.72,"sitRate",5194.12,"onlineStatus","D","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","2","chargeUserid","k69H","chargeUsername","F7FZ","menuStatus","n","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","5YrD","cusername","IfcC","calcTime",parse("2020-11-11 18:53:25"),"menuName","DKmH","planWorkhours",4265.11,"planWorkerCnt",1641.33,"closedBugs",4295,"activeBugs",2202,"confirmedBugs",2412,"resolvedBugs",4903,"productId","Ww7r","productName","P40C","testCases",8800,"execCases",1275,"designCases",8331,"finishCases",4119,"projectCnt",1617,"iterationCnt",743,"taskCnt",3177,"finishTaskCnt",8778,"bizDate","bJu8","bugCnt",5795);
		XmMenuState xmMenuState1=BaseUtils.fromMap(p1,XmMenuState.class);
		batchValues.add(xmMenuState1);
		Map p2=BaseUtils.map("id","T7bQ","menuId","oH62","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",2441.56,"actWorkload",9519.91,"planCostAmount",8212.14,"actCostAmount",5984.13,"finishRate",7658.94,"demandRate",8476.98,"designRate",5305.44,"devRate",141.65,"uatRate",5860.03,"sitRate",2716.02,"onlineStatus","2","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","c","chargeUserid","3L23","chargeUsername","tf8o","menuStatus","I","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","6S9X","cusername","aqy4","calcTime",parse("2020-11-11 18:53:25"),"menuName","Dije","planWorkhours",1682.32,"planWorkerCnt",2334.39,"closedBugs",122,"activeBugs",2830,"confirmedBugs",2380,"resolvedBugs",5960,"productId","qa24","productName","s2AG","testCases",9782,"execCases",4376,"designCases",6191,"finishCases",7701,"projectCnt",9352,"iterationCnt",1205,"taskCnt",1145,"finishTaskCnt",7238,"bizDate","bCKy","bugCnt",1781);
		XmMenuState xmMenuState2=BaseUtils.fromMap(p2,XmMenuState.class);
		batchValues.add(xmMenuState2);
		Map p3=BaseUtils.map("id","KSqG","menuId","Qqr2","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",7951.27,"actWorkload",6242.69,"planCostAmount",6073.8,"actCostAmount",1671.43,"finishRate",5744.25,"demandRate",7424.87,"designRate",8322.26,"devRate",9215.51,"uatRate",4138.83,"sitRate",168,"onlineStatus","3","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","9","chargeUserid","4xMU","chargeUsername","cFBx","menuStatus","b","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","XYgF","cusername","BWA2","calcTime",parse("2020-11-11 18:53:25"),"menuName","Z1VF","planWorkhours",7479.26,"planWorkerCnt",5580.71,"closedBugs",5774,"activeBugs",7507,"confirmedBugs",4528,"resolvedBugs",5720,"productId","z4l9","productName","52ex","testCases",6747,"execCases",3353,"designCases",8183,"finishCases",1341,"projectCnt",9873,"iterationCnt",3241,"taskCnt",9435,"finishTaskCnt",1349,"bizDate","4Sb9","bugCnt",2485);
		XmMenuState xmMenuState3=BaseUtils.fromMap(p3,XmMenuState.class);
		batchValues.add(xmMenuState3);
		Map p4=BaseUtils.map("id","GgsI","menuId","7tSV","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",999.69,"actWorkload",6531.93,"planCostAmount",1667.28,"actCostAmount",9395.24,"finishRate",3563.86,"demandRate",282.83,"designRate",8993.32,"devRate",7277.64,"uatRate",9566.53,"sitRate",1168.88,"onlineStatus","d","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","E","chargeUserid","GC92","chargeUsername","Mob8","menuStatus","0","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","o628","cusername","Q8UU","calcTime",parse("2020-11-11 18:53:25"),"menuName","FiiQ","planWorkhours",371.12,"planWorkerCnt",3461.04,"closedBugs",8128,"activeBugs",8439,"confirmedBugs",8284,"resolvedBugs",6970,"productId","4w9k","productName","6iSK","testCases",4798,"execCases",5129,"designCases",1143,"finishCases",9839,"projectCnt",5316,"iterationCnt",8130,"taskCnt",1801,"finishTaskCnt",3720,"bizDate","509i","bugCnt",3996);
		XmMenuState xmMenuState4=BaseUtils.fromMap(p4,XmMenuState.class);
		batchValues.add(xmMenuState4);
		Map p5=BaseUtils.map("id","DIJa","menuId","u592","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",5215.6,"actWorkload",3360.35,"planCostAmount",8566.78,"actCostAmount",4624.41,"finishRate",1610.67,"demandRate",7771.61,"designRate",4305.35,"devRate",1074.64,"uatRate",1623.31,"sitRate",8442.84,"onlineStatus","m","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","9","chargeUserid","Cq3l","chargeUsername","PMCF","menuStatus","s","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","o9H5","cusername","AbIT","calcTime",parse("2020-11-11 18:53:25"),"menuName","SES8","planWorkhours",8487.44,"planWorkerCnt",9935.73,"closedBugs",7476,"activeBugs",9896,"confirmedBugs",6534,"resolvedBugs",911,"productId","FVgX","productName","uoih","testCases",352,"execCases",1579,"designCases",8560,"finishCases",7662,"projectCnt",1699,"iterationCnt",2730,"taskCnt",935,"finishTaskCnt",3411,"bizDate","yX8e","bugCnt",3916);
		XmMenuState xmMenuState5=BaseUtils.fromMap(p5,XmMenuState.class);
		batchValues.add(xmMenuState5);
		Map p6=BaseUtils.map("id","6ZLk","menuId","WQL4","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",776.22,"actWorkload",541.85,"planCostAmount",9374.85,"actCostAmount",1699.15,"finishRate",5315,"demandRate",8390.47,"designRate",6638.11,"devRate",229.07,"uatRate",5375.38,"sitRate",4805.81,"onlineStatus","1","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","5","chargeUserid","FHDO","chargeUsername","tcpz","menuStatus","E","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","QKhy","cusername","0Nvp","calcTime",parse("2020-11-11 18:53:25"),"menuName","0Qnf","planWorkhours",8061.11,"planWorkerCnt",640.49,"closedBugs",6360,"activeBugs",251,"confirmedBugs",704,"resolvedBugs",6275,"productId","wR3R","productName","0s97","testCases",5497,"execCases",9245,"designCases",4580,"finishCases",655,"projectCnt",3028,"iterationCnt",3426,"taskCnt",2582,"finishTaskCnt",5876,"bizDate","7tey","bugCnt",4891);
		XmMenuState xmMenuState6=BaseUtils.fromMap(p6,XmMenuState.class);
		batchValues.add(xmMenuState6);
		Map p7=BaseUtils.map("id","2I3o","menuId","Ut63","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",321.34,"actWorkload",8163.81,"planCostAmount",7499.75,"actCostAmount",9042.03,"finishRate",7730.37,"demandRate",5200.26,"designRate",9969.44,"devRate",4398.89,"uatRate",3976.55,"sitRate",1685.47,"onlineStatus","t","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","4","chargeUserid","bX11","chargeUsername","h233","menuStatus","l","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","JI8S","cusername","1wc4","calcTime",parse("2020-11-11 18:53:25"),"menuName","Wq8R","planWorkhours",8744.07,"planWorkerCnt",3810.39,"closedBugs",5634,"activeBugs",5634,"confirmedBugs",5551,"resolvedBugs",9269,"productId","6J46","productName","9YLy","testCases",7978,"execCases",7227,"designCases",319,"finishCases",2101,"projectCnt",6358,"iterationCnt",5572,"taskCnt",9553,"finishTaskCnt",5603,"bizDate","d5Dc","bugCnt",8459);
		XmMenuState xmMenuState7=BaseUtils.fromMap(p7,XmMenuState.class);
		batchValues.add(xmMenuState7);
		xmMenuStateService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","IlfF");
		Map<String,Object> result=this.xmMenuStateService.selectOne(XmMenuState.class.getName()+".selectOneMap",p);
		Assert.assertEquals("IlfF", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("menuId","eg9z","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",5365.06,"actWorkload",8408.04,"planCostAmount",4918.87,"actCostAmount",6936.21,"finishRate",5995.51,"demandRate",8902.8,"designRate",856.81,"devRate",5333.85,"uatRate",9071.12,"sitRate",2411.15,"onlineStatus","F","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","t","chargeUserid","9ej6","chargeUsername","cm38","menuStatus","b","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","OVG5","cusername","3ui8","calcTime",parse("2020-11-11 18:53:25"),"menuName","pt5r","planWorkhours",6637.37,"planWorkerCnt",2089,"closedBugs",7900,"activeBugs",3204,"confirmedBugs",668,"resolvedBugs",6956,"productId","AQqj","productName","g8C9","testCases",3815,"execCases",8026,"designCases",4758,"finishCases",4081,"projectCnt",3067,"iterationCnt",4235,"taskCnt",3309,"finishTaskCnt",7563,"bizDate","ecC1","bugCnt",3457);
		XmMenuState xmMenuState=BaseUtils.fromMap(p,XmMenuState.class);
		long result=xmMenuStateService.countByWhere(xmMenuState);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("menuId","eg9z","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",5365.06,"actWorkload",8408.04,"planCostAmount",4918.87,"actCostAmount",6936.21,"finishRate",5995.51,"demandRate",8902.8,"designRate",856.81,"devRate",5333.85,"uatRate",9071.12,"sitRate",2411.15,"onlineStatus","F","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","t","chargeUserid","9ej6","chargeUsername","cm38","menuStatus","b","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","OVG5","cusername","3ui8","calcTime",parse("2020-11-11 18:53:25"),"menuName","pt5r","planWorkhours",6637.37,"planWorkerCnt",2089,"closedBugs",7900,"activeBugs",3204,"confirmedBugs",668,"resolvedBugs",6956,"productId","AQqj","productName","g8C9","testCases",3815,"execCases",8026,"designCases",4758,"finishCases",4081,"projectCnt",3067,"iterationCnt",4235,"taskCnt",3309,"finishTaskCnt",7563,"bizDate","ecC1","bugCnt",3457);
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmMenuState xmMenuState=BaseUtils.fromMap(p,XmMenuState.class);
		List<XmMenuState> result=xmMenuStateService.selectListByWhere(xmMenuState); 
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
	
		
		Map<String,Object> p=BaseUtils.map("menuId","eg9z","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",5365.06,"actWorkload",8408.04,"planCostAmount",4918.87,"actCostAmount",6936.21,"finishRate",5995.51,"demandRate",8902.8,"designRate",856.81,"devRate",5333.85,"uatRate",9071.12,"sitRate",2411.15,"onlineStatus","F","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","t","chargeUserid","9ej6","chargeUsername","cm38","menuStatus","b","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","OVG5","cusername","3ui8","calcTime",parse("2020-11-11 18:53:25"),"menuName","pt5r","planWorkhours",6637.37,"planWorkerCnt",2089,"closedBugs",7900,"activeBugs",3204,"confirmedBugs",668,"resolvedBugs",6956,"productId","AQqj","productName","g8C9","testCases",3815,"execCases",8026,"designCases",4758,"finishCases",4081,"projectCnt",3067,"iterationCnt",4235,"taskCnt",3309,"finishTaskCnt",7563,"bizDate","ecC1","bugCnt",3457);
		XmMenuState xmMenuState=BaseUtils.fromMap(p,XmMenuState.class);
		List<XmMenuState> result=xmMenuStateService.selectListByWhere(xmMenuState);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("menuId","eg9z","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",5365.06,"actWorkload",8408.04,"planCostAmount",4918.87,"actCostAmount",6936.21,"finishRate",5995.51,"demandRate",8902.8,"designRate",856.81,"devRate",5333.85,"uatRate",9071.12,"sitRate",2411.15,"onlineStatus","F","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","t","chargeUserid","9ej6","chargeUsername","cm38","menuStatus","b","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","OVG5","cusername","3ui8","calcTime",parse("2020-11-11 18:53:25"),"menuName","pt5r","planWorkhours",6637.37,"planWorkerCnt",2089,"closedBugs",7900,"activeBugs",3204,"confirmedBugs",668,"resolvedBugs",6956,"productId","AQqj","productName","g8C9","testCases",3815,"execCases",8026,"designCases",4758,"finishCases",4081,"projectCnt",3067,"iterationCnt",4235,"taskCnt",3309,"finishTaskCnt",7563,"bizDate","ecC1","bugCnt",3457);
		List<Map<String,Object>> result=xmMenuStateService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("menuId","eg9z","planStartTime",parse("2020-11-11 18:53:25"),"planEndTime",parse("2020-11-11 18:53:25"),"actStartTime",parse("2020-11-11 18:53:25"),"actEndTime",parse("2020-11-11 18:53:25"),"planWorkload",5365.06,"actWorkload",8408.04,"planCostAmount",4918.87,"actCostAmount",6936.21,"finishRate",5995.51,"demandRate",8902.8,"designRate",856.81,"devRate",5333.85,"uatRate",9071.12,"sitRate",2411.15,"onlineStatus","F","onlineTime",parse("2020-11-11 18:53:25"),"planStatus","t","chargeUserid","9ej6","chargeUsername","cm38","menuStatus","b","ctime",parse("2020-11-11 18:53:25"),"ltime",parse("2020-11-11 18:53:25"),"cuserid","OVG5","cusername","3ui8","calcTime",parse("2020-11-11 18:53:25"),"menuName","pt5r","planWorkhours",6637.37,"planWorkerCnt",2089,"closedBugs",7900,"activeBugs",3204,"confirmedBugs",668,"resolvedBugs",6956,"productId","AQqj","productName","g8C9","testCases",3815,"execCases",8026,"designCases",4758,"finishCases",4081,"projectCnt",3067,"iterationCnt",4235,"taskCnt",3309,"finishTaskCnt",7563,"bizDate","ecC1","bugCnt",3457);
		List<Map<String,Object>> result=xmMenuStateService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmMenuState
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","IlfF");
		
		XmMenuState xmMenuState1=BaseUtils.fromMap(p,XmMenuState.class);
		XmMenuState xmMenuState=xmMenuStateService.selectOneObject(xmMenuState1);
		Assert.assertEquals("IlfF", xmMenuState.getId());
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
