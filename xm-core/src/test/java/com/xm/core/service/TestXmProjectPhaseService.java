package com.xm.core.service;

import java.util.*;
import java.text.SimpleDateFormat;

import com.xm.core.entity.XmProjectPhase;
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
 * XmProjectPhaseService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_project_phase 项目阶段模板<br>
 * 实体 XmProjectPhase<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,phaseName,remark,parentPhaseId,branchId,projectId,beginDate,endDate,phaseBudgetHours,phaseBudgetStaffNu,ctime,phaseBudgetNouserAt,phaseBudgetInnerUserAt,phaseBudgetOutUserAt,projectBaselineId,bizProcInstId,bizFlowState,phaseBudgetWorkload,phaseActWorkload,phaseActInnerUserWorkload,phaseActOutUserWorkload,taskType,planType,seqNo,phaseBudgetInnerUserWorkload,phaseBudgetOutUserWorkload,actNouserAt,actInnerUserAt,phaseBudgetInnerUserPrice,phaseBudgetOutUserPrice,phaseBudgetOutUserCnt,phaseBudgetInnerUserCnt,actRate,phaseStatus,actOutUserAt,taskCnt,finishTaskCnt,iterationCnt,calcTime,taskBudgetWorkload,taskBudgetAt;<br>
 * 当前表的所有字段名:<br>
 *	id,phase_name,remark,parent_phase_id,branch_id,project_id,begin_date,end_date,phase_budget_hours,phase_budget_staff_nu,ctime,phase_budget_nouser_at,phase_budget_inner_user_at,phase_budget_out_user_at,project_baseline_id,biz_proc_inst_id,biz_flow_state,phase_budget_workload,phase_act_workload,phase_act_inner_user_workload,phase_act_out_user_workload,task_type,plan_type,seq_no,phase_budget_inner_user_workload,phase_budget_out_user_workload,act_nouser_at,act_inner_user_at,phase_budget_inner_user_price,phase_budget_out_user_price,phase_budget_out_user_cnt,phase_budget_inner_user_cnt,act_rate,phase_status,act_out_user_at,task_cnt,finish_task_cnt,iteration_cnt,calc_time,task_budget_workload,task_budget_at;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectPhaseService  {

	@Autowired
	XmProjectPhaseService xmProjectPhaseService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","W3Cl","phaseName","oC8h","remark","6qnJ","parentPhaseId","iAvB","branchId","X21N","projectId","JM48","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",6480.9,"phaseBudgetStaffNu",9252,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",2941.61,"phaseBudgetInnerUserAt",5005.56,"phaseBudgetOutUserAt",4509.56,"projectBaselineId","9ha7","bizProcInstId","nteE","bizFlowState","g","phaseBudgetWorkload",6773.34,"phaseActWorkload",1844.77,"phaseActInnerUserWorkload",1973.77,"phaseActOutUserWorkload",3328.2,"taskType","Hain","planType","Fp16","seqNo","rSK2","phaseBudgetInnerUserWorkload",3782.43,"phaseBudgetOutUserWorkload",5948.69,"actNouserAt",5275.47,"actInnerUserAt",9374.98,"phaseBudgetInnerUserPrice",531.05,"phaseBudgetOutUserPrice",3718.12,"phaseBudgetOutUserCnt",342,"phaseBudgetInnerUserCnt",7108,"actRate",4924.7,"phaseStatus","K","actOutUserAt",8346.62,"taskCnt",8397,"finishTaskCnt",5822,"iterationCnt",9512,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",9739.52,"taskBudgetAt",213.68);
		XmProjectPhase xmProjectPhase=BaseUtils.fromMap(p,XmProjectPhase.class);
		xmProjectPhaseService.insert(xmProjectPhase);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("phaseName","oC8h","remark","6qnJ","parentPhaseId","iAvB","branchId","X21N","projectId","JM48","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",6480.9,"phaseBudgetStaffNu",9252,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",2941.61,"phaseBudgetInnerUserAt",5005.56,"phaseBudgetOutUserAt",4509.56,"projectBaselineId","9ha7","bizProcInstId","nteE","bizFlowState","g","phaseBudgetWorkload",6773.34,"phaseActWorkload",1844.77,"phaseActInnerUserWorkload",1973.77,"phaseActOutUserWorkload",3328.2,"taskType","Hain","planType","Fp16","seqNo","rSK2","phaseBudgetInnerUserWorkload",3782.43,"phaseBudgetOutUserWorkload",5948.69,"actNouserAt",5275.47,"actInnerUserAt",9374.98,"phaseBudgetInnerUserPrice",531.05,"phaseBudgetOutUserPrice",3718.12,"phaseBudgetOutUserCnt",342,"phaseBudgetInnerUserCnt",7108,"actRate",4924.7,"phaseStatus","K","actOutUserAt",8346.62,"taskCnt",8397,"finishTaskCnt",5822,"iterationCnt",9512,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",9739.52,"taskBudgetAt",213.68);
		XmProjectPhase xmProjectPhase=BaseUtils.fromMap(p,XmProjectPhase.class);
		xmProjectPhaseService.deleteByWhere(xmProjectPhase);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","W3Cl");
		XmProjectPhase xmProjectPhase=BaseUtils.fromMap(p,XmProjectPhase.class);
		xmProjectPhaseService.deleteByPk(xmProjectPhase);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("phaseName","oC8h","remark","6qnJ","parentPhaseId","iAvB","branchId","X21N","projectId","JM48","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",6480.9,"phaseBudgetStaffNu",9252,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",2941.61,"phaseBudgetInnerUserAt",5005.56,"phaseBudgetOutUserAt",4509.56,"projectBaselineId","9ha7","bizProcInstId","nteE","bizFlowState","g","phaseBudgetWorkload",6773.34,"phaseActWorkload",1844.77,"phaseActInnerUserWorkload",1973.77,"phaseActOutUserWorkload",3328.2,"taskType","Hain","planType","Fp16","seqNo","rSK2","phaseBudgetInnerUserWorkload",3782.43,"phaseBudgetOutUserWorkload",5948.69,"actNouserAt",5275.47,"actInnerUserAt",9374.98,"phaseBudgetInnerUserPrice",531.05,"phaseBudgetOutUserPrice",3718.12,"phaseBudgetOutUserCnt",342,"phaseBudgetInnerUserCnt",7108,"actRate",4924.7,"phaseStatus","K","actOutUserAt",8346.62,"taskCnt",8397,"finishTaskCnt",5822,"iterationCnt",9512,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",9739.52,"taskBudgetAt",213.68);
		XmProjectPhase xmProjectPhase=BaseUtils.fromMap(where,XmProjectPhase.class);
		xmProjectPhaseService.updateSomeFieldByPk(xmProjectPhase);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","W3Cl");
		XmProjectPhase xmProjectPhase=BaseUtils.fromMap(p,XmProjectPhase.class);
		xmProjectPhaseService.updateByPk(xmProjectPhase);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("id","W3Cl","phaseName","oC8h","remark","6qnJ","parentPhaseId","iAvB","branchId","X21N","projectId","JM48","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",6480.9,"phaseBudgetStaffNu",9252,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",2941.61,"phaseBudgetInnerUserAt",5005.56,"phaseBudgetOutUserAt",4509.56,"projectBaselineId","9ha7","bizProcInstId","nteE","bizFlowState","g","phaseBudgetWorkload",6773.34,"phaseActWorkload",1844.77,"phaseActInnerUserWorkload",1973.77,"phaseActOutUserWorkload",3328.2,"taskType","Hain","planType","Fp16","seqNo","rSK2","phaseBudgetInnerUserWorkload",3782.43,"phaseBudgetOutUserWorkload",5948.69,"actNouserAt",5275.47,"actInnerUserAt",9374.98,"phaseBudgetInnerUserPrice",531.05,"phaseBudgetOutUserPrice",3718.12,"phaseBudgetOutUserCnt",342,"phaseBudgetInnerUserCnt",7108,"actRate",4924.7,"phaseStatus","K","actOutUserAt",8346.62,"taskCnt",8397,"finishTaskCnt",5822,"iterationCnt",9512,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",9739.52,"taskBudgetAt",213.68);
		XmProjectPhase xmProjectPhase=BaseUtils.fromMap(p,XmProjectPhase.class);
		xmProjectPhaseService.insertOrUpdate(xmProjectPhase);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmProjectPhase> batchValues=new ArrayList<XmProjectPhase>();
		Map p0=BaseUtils.map("id","W3Cl","phaseName","oC8h","remark","6qnJ","parentPhaseId","iAvB","branchId","X21N","projectId","JM48","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",6480.9,"phaseBudgetStaffNu",9252,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",2941.61,"phaseBudgetInnerUserAt",5005.56,"phaseBudgetOutUserAt",4509.56,"projectBaselineId","9ha7","bizProcInstId","nteE","bizFlowState","g","phaseBudgetWorkload",6773.34,"phaseActWorkload",1844.77,"phaseActInnerUserWorkload",1973.77,"phaseActOutUserWorkload",3328.2,"taskType","Hain","planType","Fp16","seqNo","rSK2","phaseBudgetInnerUserWorkload",3782.43,"phaseBudgetOutUserWorkload",5948.69,"actNouserAt",5275.47,"actInnerUserAt",9374.98,"phaseBudgetInnerUserPrice",531.05,"phaseBudgetOutUserPrice",3718.12,"phaseBudgetOutUserCnt",342,"phaseBudgetInnerUserCnt",7108,"actRate",4924.7,"phaseStatus","K","actOutUserAt",8346.62,"taskCnt",8397,"finishTaskCnt",5822,"iterationCnt",9512,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",9739.52,"taskBudgetAt",213.68);
		XmProjectPhase xmProjectPhase0=BaseUtils.fromMap(p0,XmProjectPhase.class);
		batchValues.add(xmProjectPhase0);
		Map p1=BaseUtils.map("id","9X1J","phaseName","Ic0m","remark","nmu5","parentPhaseId","Utpu","branchId","vtw8","projectId","R09Y","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",2578.94,"phaseBudgetStaffNu",6624,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",1499.89,"phaseBudgetInnerUserAt",6847.22,"phaseBudgetOutUserAt",7766.82,"projectBaselineId","Q2zv","bizProcInstId","6q52","bizFlowState","2","phaseBudgetWorkload",5628.35,"phaseActWorkload",4114.37,"phaseActInnerUserWorkload",5990.03,"phaseActOutUserWorkload",680.85,"taskType","22I5","planType","TVpa","seqNo","oN6E","phaseBudgetInnerUserWorkload",982.17,"phaseBudgetOutUserWorkload",9562.9,"actNouserAt",5130.21,"actInnerUserAt",8524.19,"phaseBudgetInnerUserPrice",6943.26,"phaseBudgetOutUserPrice",1342.18,"phaseBudgetOutUserCnt",5815,"phaseBudgetInnerUserCnt",5563,"actRate",3708.21,"phaseStatus","0","actOutUserAt",7063.18,"taskCnt",5680,"finishTaskCnt",1358,"iterationCnt",522,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",4310.16,"taskBudgetAt",4926.4);
		XmProjectPhase xmProjectPhase1=BaseUtils.fromMap(p1,XmProjectPhase.class);
		batchValues.add(xmProjectPhase1);
		Map p2=BaseUtils.map("id","Fnxb","phaseName","896T","remark","d8ol","parentPhaseId","r5c2","branchId","YgZG","projectId","Wpdw","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",9664.61,"phaseBudgetStaffNu",3972,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",1078.93,"phaseBudgetInnerUserAt",7945.02,"phaseBudgetOutUserAt",7878.41,"projectBaselineId","G3ce","bizProcInstId","4DE4","bizFlowState","v","phaseBudgetWorkload",6433.15,"phaseActWorkload",9788.83,"phaseActInnerUserWorkload",2872.58,"phaseActOutUserWorkload",8052.15,"taskType","Te8W","planType","7fUT","seqNo","KJkX","phaseBudgetInnerUserWorkload",5070.58,"phaseBudgetOutUserWorkload",1771.98,"actNouserAt",2238.79,"actInnerUserAt",8578.85,"phaseBudgetInnerUserPrice",8134.44,"phaseBudgetOutUserPrice",76.52,"phaseBudgetOutUserCnt",6144,"phaseBudgetInnerUserCnt",1904,"actRate",7479.62,"phaseStatus","c","actOutUserAt",5682.42,"taskCnt",8534,"finishTaskCnt",2474,"iterationCnt",8561,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",3761.65,"taskBudgetAt",5123.5);
		XmProjectPhase xmProjectPhase2=BaseUtils.fromMap(p2,XmProjectPhase.class);
		batchValues.add(xmProjectPhase2);
		Map p3=BaseUtils.map("id","S49b","phaseName","3FyN","remark","7PR6","parentPhaseId","C7HX","branchId","5Qvm","projectId","YaKV","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",9485.47,"phaseBudgetStaffNu",5720,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",5039.66,"phaseBudgetInnerUserAt",971.39,"phaseBudgetOutUserAt",7568.96,"projectBaselineId","VFTV","bizProcInstId","8Giy","bizFlowState","z","phaseBudgetWorkload",2500.55,"phaseActWorkload",6651.3,"phaseActInnerUserWorkload",6157.94,"phaseActOutUserWorkload",1872.06,"taskType","xpOG","planType","cDmb","seqNo","Vh7k","phaseBudgetInnerUserWorkload",5997.28,"phaseBudgetOutUserWorkload",5312.65,"actNouserAt",2279.08,"actInnerUserAt",8262.48,"phaseBudgetInnerUserPrice",1912.51,"phaseBudgetOutUserPrice",9620.53,"phaseBudgetOutUserCnt",1024,"phaseBudgetInnerUserCnt",2528,"actRate",5943.26,"phaseStatus","h","actOutUserAt",9151.41,"taskCnt",3460,"finishTaskCnt",185,"iterationCnt",8457,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",8407.23,"taskBudgetAt",4678.11);
		XmProjectPhase xmProjectPhase3=BaseUtils.fromMap(p3,XmProjectPhase.class);
		batchValues.add(xmProjectPhase3);
		Map p4=BaseUtils.map("id","tLjO","phaseName","3h16","remark","J4z7","parentPhaseId","2F9n","branchId","LvR1","projectId","52f2","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",9752.65,"phaseBudgetStaffNu",1010,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",4901.91,"phaseBudgetInnerUserAt",6749.47,"phaseBudgetOutUserAt",468.92,"projectBaselineId","T6M9","bizProcInstId","SVeN","bizFlowState","q","phaseBudgetWorkload",1949.1,"phaseActWorkload",8536.96,"phaseActInnerUserWorkload",9617.83,"phaseActOutUserWorkload",140.89,"taskType","Na1C","planType","HTdZ","seqNo","jcm4","phaseBudgetInnerUserWorkload",7108.37,"phaseBudgetOutUserWorkload",4673.03,"actNouserAt",4063.7,"actInnerUserAt",7147.31,"phaseBudgetInnerUserPrice",1583.15,"phaseBudgetOutUserPrice",212.08,"phaseBudgetOutUserCnt",4071,"phaseBudgetInnerUserCnt",8878,"actRate",4713.97,"phaseStatus","1","actOutUserAt",2482.2,"taskCnt",6095,"finishTaskCnt",9038,"iterationCnt",542,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",9459.73,"taskBudgetAt",9459.13);
		XmProjectPhase xmProjectPhase4=BaseUtils.fromMap(p4,XmProjectPhase.class);
		batchValues.add(xmProjectPhase4);
		Map p5=BaseUtils.map("id","F6t3","phaseName","2oc6","remark","avOU","parentPhaseId","1Yx1","branchId","kxax","projectId","6885","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",8678.63,"phaseBudgetStaffNu",9393,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",3682.07,"phaseBudgetInnerUserAt",3077.88,"phaseBudgetOutUserAt",7804.67,"projectBaselineId","Xh1A","bizProcInstId","FqYg","bizFlowState","B","phaseBudgetWorkload",946.9,"phaseActWorkload",9595.57,"phaseActInnerUserWorkload",7448.34,"phaseActOutUserWorkload",9409.16,"taskType","Twk2","planType","kj2k","seqNo","TtFX","phaseBudgetInnerUserWorkload",9571.33,"phaseBudgetOutUserWorkload",4692.07,"actNouserAt",837.04,"actInnerUserAt",8830.08,"phaseBudgetInnerUserPrice",8737.67,"phaseBudgetOutUserPrice",1386.36,"phaseBudgetOutUserCnt",7730,"phaseBudgetInnerUserCnt",9638,"actRate",6671.62,"phaseStatus","3","actOutUserAt",5801.17,"taskCnt",4034,"finishTaskCnt",405,"iterationCnt",1301,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",9167.15,"taskBudgetAt",518.33);
		XmProjectPhase xmProjectPhase5=BaseUtils.fromMap(p5,XmProjectPhase.class);
		batchValues.add(xmProjectPhase5);
		Map p6=BaseUtils.map("id","9P4D","phaseName","8K1M","remark","5JMA","parentPhaseId","nVZh","branchId","96FR","projectId","7U6c","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",3112.73,"phaseBudgetStaffNu",5506,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",4433.76,"phaseBudgetInnerUserAt",2556.02,"phaseBudgetOutUserAt",2943.59,"projectBaselineId","Sx3S","bizProcInstId","bKL1","bizFlowState","y","phaseBudgetWorkload",7414.91,"phaseActWorkload",2545.74,"phaseActInnerUserWorkload",5337.85,"phaseActOutUserWorkload",9069.58,"taskType","0INq","planType","AQvV","seqNo","qkAd","phaseBudgetInnerUserWorkload",2165.39,"phaseBudgetOutUserWorkload",8381.93,"actNouserAt",1908.62,"actInnerUserAt",8010.21,"phaseBudgetInnerUserPrice",2966.84,"phaseBudgetOutUserPrice",5711.44,"phaseBudgetOutUserCnt",5013,"phaseBudgetInnerUserCnt",7954,"actRate",6177.5,"phaseStatus","m","actOutUserAt",9891.94,"taskCnt",8458,"finishTaskCnt",2123,"iterationCnt",1042,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",5774.75,"taskBudgetAt",2634.02);
		XmProjectPhase xmProjectPhase6=BaseUtils.fromMap(p6,XmProjectPhase.class);
		batchValues.add(xmProjectPhase6);
		Map p7=BaseUtils.map("id","jnoU","phaseName","9FEi","remark","sRGt","parentPhaseId","86ir","branchId","b22d","projectId","R710","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",1733.51,"phaseBudgetStaffNu",9042,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",2516.35,"phaseBudgetInnerUserAt",8901.65,"phaseBudgetOutUserAt",1997.33,"projectBaselineId","seGM","bizProcInstId","C540","bizFlowState","O","phaseBudgetWorkload",4681.68,"phaseActWorkload",5345.8,"phaseActInnerUserWorkload",9063.62,"phaseActOutUserWorkload",9373.87,"taskType","9mTi","planType","Z5We","seqNo","GALJ","phaseBudgetInnerUserWorkload",1146.58,"phaseBudgetOutUserWorkload",6622.04,"actNouserAt",5792.03,"actInnerUserAt",1300.49,"phaseBudgetInnerUserPrice",2354.42,"phaseBudgetOutUserPrice",8684.7,"phaseBudgetOutUserCnt",414,"phaseBudgetInnerUserCnt",3569,"actRate",2499.19,"phaseStatus","0","actOutUserAt",4257.37,"taskCnt",7806,"finishTaskCnt",4244,"iterationCnt",9890,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",5492.9,"taskBudgetAt",6263.77);
		XmProjectPhase xmProjectPhase7=BaseUtils.fromMap(p7,XmProjectPhase.class);
		batchValues.add(xmProjectPhase7);
		xmProjectPhaseService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmProjectPhase> batchValues=new ArrayList<XmProjectPhase>();
		Map p0=BaseUtils.map("id","W3Cl","phaseName","oC8h","remark","6qnJ","parentPhaseId","iAvB","branchId","X21N","projectId","JM48","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",6480.9,"phaseBudgetStaffNu",9252,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",2941.61,"phaseBudgetInnerUserAt",5005.56,"phaseBudgetOutUserAt",4509.56,"projectBaselineId","9ha7","bizProcInstId","nteE","bizFlowState","g","phaseBudgetWorkload",6773.34,"phaseActWorkload",1844.77,"phaseActInnerUserWorkload",1973.77,"phaseActOutUserWorkload",3328.2,"taskType","Hain","planType","Fp16","seqNo","rSK2","phaseBudgetInnerUserWorkload",3782.43,"phaseBudgetOutUserWorkload",5948.69,"actNouserAt",5275.47,"actInnerUserAt",9374.98,"phaseBudgetInnerUserPrice",531.05,"phaseBudgetOutUserPrice",3718.12,"phaseBudgetOutUserCnt",342,"phaseBudgetInnerUserCnt",7108,"actRate",4924.7,"phaseStatus","K","actOutUserAt",8346.62,"taskCnt",8397,"finishTaskCnt",5822,"iterationCnt",9512,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",9739.52,"taskBudgetAt",213.68);
		XmProjectPhase xmProjectPhase0=BaseUtils.fromMap(p0,XmProjectPhase.class);
		batchValues.add(xmProjectPhase0);
		Map p1=BaseUtils.map("id","9X1J","phaseName","Ic0m","remark","nmu5","parentPhaseId","Utpu","branchId","vtw8","projectId","R09Y","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",2578.94,"phaseBudgetStaffNu",6624,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",1499.89,"phaseBudgetInnerUserAt",6847.22,"phaseBudgetOutUserAt",7766.82,"projectBaselineId","Q2zv","bizProcInstId","6q52","bizFlowState","2","phaseBudgetWorkload",5628.35,"phaseActWorkload",4114.37,"phaseActInnerUserWorkload",5990.03,"phaseActOutUserWorkload",680.85,"taskType","22I5","planType","TVpa","seqNo","oN6E","phaseBudgetInnerUserWorkload",982.17,"phaseBudgetOutUserWorkload",9562.9,"actNouserAt",5130.21,"actInnerUserAt",8524.19,"phaseBudgetInnerUserPrice",6943.26,"phaseBudgetOutUserPrice",1342.18,"phaseBudgetOutUserCnt",5815,"phaseBudgetInnerUserCnt",5563,"actRate",3708.21,"phaseStatus","0","actOutUserAt",7063.18,"taskCnt",5680,"finishTaskCnt",1358,"iterationCnt",522,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",4310.16,"taskBudgetAt",4926.4);
		XmProjectPhase xmProjectPhase1=BaseUtils.fromMap(p1,XmProjectPhase.class);
		batchValues.add(xmProjectPhase1);
		Map p2=BaseUtils.map("id","Fnxb","phaseName","896T","remark","d8ol","parentPhaseId","r5c2","branchId","YgZG","projectId","Wpdw","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",9664.61,"phaseBudgetStaffNu",3972,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",1078.93,"phaseBudgetInnerUserAt",7945.02,"phaseBudgetOutUserAt",7878.41,"projectBaselineId","G3ce","bizProcInstId","4DE4","bizFlowState","v","phaseBudgetWorkload",6433.15,"phaseActWorkload",9788.83,"phaseActInnerUserWorkload",2872.58,"phaseActOutUserWorkload",8052.15,"taskType","Te8W","planType","7fUT","seqNo","KJkX","phaseBudgetInnerUserWorkload",5070.58,"phaseBudgetOutUserWorkload",1771.98,"actNouserAt",2238.79,"actInnerUserAt",8578.85,"phaseBudgetInnerUserPrice",8134.44,"phaseBudgetOutUserPrice",76.52,"phaseBudgetOutUserCnt",6144,"phaseBudgetInnerUserCnt",1904,"actRate",7479.62,"phaseStatus","c","actOutUserAt",5682.42,"taskCnt",8534,"finishTaskCnt",2474,"iterationCnt",8561,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",3761.65,"taskBudgetAt",5123.5);
		XmProjectPhase xmProjectPhase2=BaseUtils.fromMap(p2,XmProjectPhase.class);
		batchValues.add(xmProjectPhase2);
		Map p3=BaseUtils.map("id","S49b","phaseName","3FyN","remark","7PR6","parentPhaseId","C7HX","branchId","5Qvm","projectId","YaKV","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",9485.47,"phaseBudgetStaffNu",5720,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",5039.66,"phaseBudgetInnerUserAt",971.39,"phaseBudgetOutUserAt",7568.96,"projectBaselineId","VFTV","bizProcInstId","8Giy","bizFlowState","z","phaseBudgetWorkload",2500.55,"phaseActWorkload",6651.3,"phaseActInnerUserWorkload",6157.94,"phaseActOutUserWorkload",1872.06,"taskType","xpOG","planType","cDmb","seqNo","Vh7k","phaseBudgetInnerUserWorkload",5997.28,"phaseBudgetOutUserWorkload",5312.65,"actNouserAt",2279.08,"actInnerUserAt",8262.48,"phaseBudgetInnerUserPrice",1912.51,"phaseBudgetOutUserPrice",9620.53,"phaseBudgetOutUserCnt",1024,"phaseBudgetInnerUserCnt",2528,"actRate",5943.26,"phaseStatus","h","actOutUserAt",9151.41,"taskCnt",3460,"finishTaskCnt",185,"iterationCnt",8457,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",8407.23,"taskBudgetAt",4678.11);
		XmProjectPhase xmProjectPhase3=BaseUtils.fromMap(p3,XmProjectPhase.class);
		batchValues.add(xmProjectPhase3);
		Map p4=BaseUtils.map("id","tLjO","phaseName","3h16","remark","J4z7","parentPhaseId","2F9n","branchId","LvR1","projectId","52f2","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",9752.65,"phaseBudgetStaffNu",1010,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",4901.91,"phaseBudgetInnerUserAt",6749.47,"phaseBudgetOutUserAt",468.92,"projectBaselineId","T6M9","bizProcInstId","SVeN","bizFlowState","q","phaseBudgetWorkload",1949.1,"phaseActWorkload",8536.96,"phaseActInnerUserWorkload",9617.83,"phaseActOutUserWorkload",140.89,"taskType","Na1C","planType","HTdZ","seqNo","jcm4","phaseBudgetInnerUserWorkload",7108.37,"phaseBudgetOutUserWorkload",4673.03,"actNouserAt",4063.7,"actInnerUserAt",7147.31,"phaseBudgetInnerUserPrice",1583.15,"phaseBudgetOutUserPrice",212.08,"phaseBudgetOutUserCnt",4071,"phaseBudgetInnerUserCnt",8878,"actRate",4713.97,"phaseStatus","1","actOutUserAt",2482.2,"taskCnt",6095,"finishTaskCnt",9038,"iterationCnt",542,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",9459.73,"taskBudgetAt",9459.13);
		XmProjectPhase xmProjectPhase4=BaseUtils.fromMap(p4,XmProjectPhase.class);
		batchValues.add(xmProjectPhase4);
		Map p5=BaseUtils.map("id","F6t3","phaseName","2oc6","remark","avOU","parentPhaseId","1Yx1","branchId","kxax","projectId","6885","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",8678.63,"phaseBudgetStaffNu",9393,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",3682.07,"phaseBudgetInnerUserAt",3077.88,"phaseBudgetOutUserAt",7804.67,"projectBaselineId","Xh1A","bizProcInstId","FqYg","bizFlowState","B","phaseBudgetWorkload",946.9,"phaseActWorkload",9595.57,"phaseActInnerUserWorkload",7448.34,"phaseActOutUserWorkload",9409.16,"taskType","Twk2","planType","kj2k","seqNo","TtFX","phaseBudgetInnerUserWorkload",9571.33,"phaseBudgetOutUserWorkload",4692.07,"actNouserAt",837.04,"actInnerUserAt",8830.08,"phaseBudgetInnerUserPrice",8737.67,"phaseBudgetOutUserPrice",1386.36,"phaseBudgetOutUserCnt",7730,"phaseBudgetInnerUserCnt",9638,"actRate",6671.62,"phaseStatus","3","actOutUserAt",5801.17,"taskCnt",4034,"finishTaskCnt",405,"iterationCnt",1301,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",9167.15,"taskBudgetAt",518.33);
		XmProjectPhase xmProjectPhase5=BaseUtils.fromMap(p5,XmProjectPhase.class);
		batchValues.add(xmProjectPhase5);
		Map p6=BaseUtils.map("id","9P4D","phaseName","8K1M","remark","5JMA","parentPhaseId","nVZh","branchId","96FR","projectId","7U6c","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",3112.73,"phaseBudgetStaffNu",5506,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",4433.76,"phaseBudgetInnerUserAt",2556.02,"phaseBudgetOutUserAt",2943.59,"projectBaselineId","Sx3S","bizProcInstId","bKL1","bizFlowState","y","phaseBudgetWorkload",7414.91,"phaseActWorkload",2545.74,"phaseActInnerUserWorkload",5337.85,"phaseActOutUserWorkload",9069.58,"taskType","0INq","planType","AQvV","seqNo","qkAd","phaseBudgetInnerUserWorkload",2165.39,"phaseBudgetOutUserWorkload",8381.93,"actNouserAt",1908.62,"actInnerUserAt",8010.21,"phaseBudgetInnerUserPrice",2966.84,"phaseBudgetOutUserPrice",5711.44,"phaseBudgetOutUserCnt",5013,"phaseBudgetInnerUserCnt",7954,"actRate",6177.5,"phaseStatus","m","actOutUserAt",9891.94,"taskCnt",8458,"finishTaskCnt",2123,"iterationCnt",1042,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",5774.75,"taskBudgetAt",2634.02);
		XmProjectPhase xmProjectPhase6=BaseUtils.fromMap(p6,XmProjectPhase.class);
		batchValues.add(xmProjectPhase6);
		Map p7=BaseUtils.map("id","jnoU","phaseName","9FEi","remark","sRGt","parentPhaseId","86ir","branchId","b22d","projectId","R710","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",1733.51,"phaseBudgetStaffNu",9042,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",2516.35,"phaseBudgetInnerUserAt",8901.65,"phaseBudgetOutUserAt",1997.33,"projectBaselineId","seGM","bizProcInstId","C540","bizFlowState","O","phaseBudgetWorkload",4681.68,"phaseActWorkload",5345.8,"phaseActInnerUserWorkload",9063.62,"phaseActOutUserWorkload",9373.87,"taskType","9mTi","planType","Z5We","seqNo","GALJ","phaseBudgetInnerUserWorkload",1146.58,"phaseBudgetOutUserWorkload",6622.04,"actNouserAt",5792.03,"actInnerUserAt",1300.49,"phaseBudgetInnerUserPrice",2354.42,"phaseBudgetOutUserPrice",8684.7,"phaseBudgetOutUserCnt",414,"phaseBudgetInnerUserCnt",3569,"actRate",2499.19,"phaseStatus","0","actOutUserAt",4257.37,"taskCnt",7806,"finishTaskCnt",4244,"iterationCnt",9890,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",5492.9,"taskBudgetAt",6263.77);
		XmProjectPhase xmProjectPhase7=BaseUtils.fromMap(p7,XmProjectPhase.class);
		batchValues.add(xmProjectPhase7);
		xmProjectPhaseService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmProjectPhase> batchValues=new ArrayList<XmProjectPhase>();
		Map p0=BaseUtils.map("id","W3Cl","phaseName","oC8h","remark","6qnJ","parentPhaseId","iAvB","branchId","X21N","projectId","JM48","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",6480.9,"phaseBudgetStaffNu",9252,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",2941.61,"phaseBudgetInnerUserAt",5005.56,"phaseBudgetOutUserAt",4509.56,"projectBaselineId","9ha7","bizProcInstId","nteE","bizFlowState","g","phaseBudgetWorkload",6773.34,"phaseActWorkload",1844.77,"phaseActInnerUserWorkload",1973.77,"phaseActOutUserWorkload",3328.2,"taskType","Hain","planType","Fp16","seqNo","rSK2","phaseBudgetInnerUserWorkload",3782.43,"phaseBudgetOutUserWorkload",5948.69,"actNouserAt",5275.47,"actInnerUserAt",9374.98,"phaseBudgetInnerUserPrice",531.05,"phaseBudgetOutUserPrice",3718.12,"phaseBudgetOutUserCnt",342,"phaseBudgetInnerUserCnt",7108,"actRate",4924.7,"phaseStatus","K","actOutUserAt",8346.62,"taskCnt",8397,"finishTaskCnt",5822,"iterationCnt",9512,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",9739.52,"taskBudgetAt",213.68);
		XmProjectPhase xmProjectPhase0=BaseUtils.fromMap(p0,XmProjectPhase.class);
		batchValues.add(xmProjectPhase0);
		Map p1=BaseUtils.map("id","9X1J","phaseName","Ic0m","remark","nmu5","parentPhaseId","Utpu","branchId","vtw8","projectId","R09Y","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",2578.94,"phaseBudgetStaffNu",6624,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",1499.89,"phaseBudgetInnerUserAt",6847.22,"phaseBudgetOutUserAt",7766.82,"projectBaselineId","Q2zv","bizProcInstId","6q52","bizFlowState","2","phaseBudgetWorkload",5628.35,"phaseActWorkload",4114.37,"phaseActInnerUserWorkload",5990.03,"phaseActOutUserWorkload",680.85,"taskType","22I5","planType","TVpa","seqNo","oN6E","phaseBudgetInnerUserWorkload",982.17,"phaseBudgetOutUserWorkload",9562.9,"actNouserAt",5130.21,"actInnerUserAt",8524.19,"phaseBudgetInnerUserPrice",6943.26,"phaseBudgetOutUserPrice",1342.18,"phaseBudgetOutUserCnt",5815,"phaseBudgetInnerUserCnt",5563,"actRate",3708.21,"phaseStatus","0","actOutUserAt",7063.18,"taskCnt",5680,"finishTaskCnt",1358,"iterationCnt",522,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",4310.16,"taskBudgetAt",4926.4);
		XmProjectPhase xmProjectPhase1=BaseUtils.fromMap(p1,XmProjectPhase.class);
		batchValues.add(xmProjectPhase1);
		Map p2=BaseUtils.map("id","Fnxb","phaseName","896T","remark","d8ol","parentPhaseId","r5c2","branchId","YgZG","projectId","Wpdw","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",9664.61,"phaseBudgetStaffNu",3972,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",1078.93,"phaseBudgetInnerUserAt",7945.02,"phaseBudgetOutUserAt",7878.41,"projectBaselineId","G3ce","bizProcInstId","4DE4","bizFlowState","v","phaseBudgetWorkload",6433.15,"phaseActWorkload",9788.83,"phaseActInnerUserWorkload",2872.58,"phaseActOutUserWorkload",8052.15,"taskType","Te8W","planType","7fUT","seqNo","KJkX","phaseBudgetInnerUserWorkload",5070.58,"phaseBudgetOutUserWorkload",1771.98,"actNouserAt",2238.79,"actInnerUserAt",8578.85,"phaseBudgetInnerUserPrice",8134.44,"phaseBudgetOutUserPrice",76.52,"phaseBudgetOutUserCnt",6144,"phaseBudgetInnerUserCnt",1904,"actRate",7479.62,"phaseStatus","c","actOutUserAt",5682.42,"taskCnt",8534,"finishTaskCnt",2474,"iterationCnt",8561,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",3761.65,"taskBudgetAt",5123.5);
		XmProjectPhase xmProjectPhase2=BaseUtils.fromMap(p2,XmProjectPhase.class);
		batchValues.add(xmProjectPhase2);
		Map p3=BaseUtils.map("id","S49b","phaseName","3FyN","remark","7PR6","parentPhaseId","C7HX","branchId","5Qvm","projectId","YaKV","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",9485.47,"phaseBudgetStaffNu",5720,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",5039.66,"phaseBudgetInnerUserAt",971.39,"phaseBudgetOutUserAt",7568.96,"projectBaselineId","VFTV","bizProcInstId","8Giy","bizFlowState","z","phaseBudgetWorkload",2500.55,"phaseActWorkload",6651.3,"phaseActInnerUserWorkload",6157.94,"phaseActOutUserWorkload",1872.06,"taskType","xpOG","planType","cDmb","seqNo","Vh7k","phaseBudgetInnerUserWorkload",5997.28,"phaseBudgetOutUserWorkload",5312.65,"actNouserAt",2279.08,"actInnerUserAt",8262.48,"phaseBudgetInnerUserPrice",1912.51,"phaseBudgetOutUserPrice",9620.53,"phaseBudgetOutUserCnt",1024,"phaseBudgetInnerUserCnt",2528,"actRate",5943.26,"phaseStatus","h","actOutUserAt",9151.41,"taskCnt",3460,"finishTaskCnt",185,"iterationCnt",8457,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",8407.23,"taskBudgetAt",4678.11);
		XmProjectPhase xmProjectPhase3=BaseUtils.fromMap(p3,XmProjectPhase.class);
		batchValues.add(xmProjectPhase3);
		Map p4=BaseUtils.map("id","tLjO","phaseName","3h16","remark","J4z7","parentPhaseId","2F9n","branchId","LvR1","projectId","52f2","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",9752.65,"phaseBudgetStaffNu",1010,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",4901.91,"phaseBudgetInnerUserAt",6749.47,"phaseBudgetOutUserAt",468.92,"projectBaselineId","T6M9","bizProcInstId","SVeN","bizFlowState","q","phaseBudgetWorkload",1949.1,"phaseActWorkload",8536.96,"phaseActInnerUserWorkload",9617.83,"phaseActOutUserWorkload",140.89,"taskType","Na1C","planType","HTdZ","seqNo","jcm4","phaseBudgetInnerUserWorkload",7108.37,"phaseBudgetOutUserWorkload",4673.03,"actNouserAt",4063.7,"actInnerUserAt",7147.31,"phaseBudgetInnerUserPrice",1583.15,"phaseBudgetOutUserPrice",212.08,"phaseBudgetOutUserCnt",4071,"phaseBudgetInnerUserCnt",8878,"actRate",4713.97,"phaseStatus","1","actOutUserAt",2482.2,"taskCnt",6095,"finishTaskCnt",9038,"iterationCnt",542,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",9459.73,"taskBudgetAt",9459.13);
		XmProjectPhase xmProjectPhase4=BaseUtils.fromMap(p4,XmProjectPhase.class);
		batchValues.add(xmProjectPhase4);
		Map p5=BaseUtils.map("id","F6t3","phaseName","2oc6","remark","avOU","parentPhaseId","1Yx1","branchId","kxax","projectId","6885","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",8678.63,"phaseBudgetStaffNu",9393,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",3682.07,"phaseBudgetInnerUserAt",3077.88,"phaseBudgetOutUserAt",7804.67,"projectBaselineId","Xh1A","bizProcInstId","FqYg","bizFlowState","B","phaseBudgetWorkload",946.9,"phaseActWorkload",9595.57,"phaseActInnerUserWorkload",7448.34,"phaseActOutUserWorkload",9409.16,"taskType","Twk2","planType","kj2k","seqNo","TtFX","phaseBudgetInnerUserWorkload",9571.33,"phaseBudgetOutUserWorkload",4692.07,"actNouserAt",837.04,"actInnerUserAt",8830.08,"phaseBudgetInnerUserPrice",8737.67,"phaseBudgetOutUserPrice",1386.36,"phaseBudgetOutUserCnt",7730,"phaseBudgetInnerUserCnt",9638,"actRate",6671.62,"phaseStatus","3","actOutUserAt",5801.17,"taskCnt",4034,"finishTaskCnt",405,"iterationCnt",1301,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",9167.15,"taskBudgetAt",518.33);
		XmProjectPhase xmProjectPhase5=BaseUtils.fromMap(p5,XmProjectPhase.class);
		batchValues.add(xmProjectPhase5);
		Map p6=BaseUtils.map("id","9P4D","phaseName","8K1M","remark","5JMA","parentPhaseId","nVZh","branchId","96FR","projectId","7U6c","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",3112.73,"phaseBudgetStaffNu",5506,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",4433.76,"phaseBudgetInnerUserAt",2556.02,"phaseBudgetOutUserAt",2943.59,"projectBaselineId","Sx3S","bizProcInstId","bKL1","bizFlowState","y","phaseBudgetWorkload",7414.91,"phaseActWorkload",2545.74,"phaseActInnerUserWorkload",5337.85,"phaseActOutUserWorkload",9069.58,"taskType","0INq","planType","AQvV","seqNo","qkAd","phaseBudgetInnerUserWorkload",2165.39,"phaseBudgetOutUserWorkload",8381.93,"actNouserAt",1908.62,"actInnerUserAt",8010.21,"phaseBudgetInnerUserPrice",2966.84,"phaseBudgetOutUserPrice",5711.44,"phaseBudgetOutUserCnt",5013,"phaseBudgetInnerUserCnt",7954,"actRate",6177.5,"phaseStatus","m","actOutUserAt",9891.94,"taskCnt",8458,"finishTaskCnt",2123,"iterationCnt",1042,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",5774.75,"taskBudgetAt",2634.02);
		XmProjectPhase xmProjectPhase6=BaseUtils.fromMap(p6,XmProjectPhase.class);
		batchValues.add(xmProjectPhase6);
		Map p7=BaseUtils.map("id","jnoU","phaseName","9FEi","remark","sRGt","parentPhaseId","86ir","branchId","b22d","projectId","R710","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",1733.51,"phaseBudgetStaffNu",9042,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",2516.35,"phaseBudgetInnerUserAt",8901.65,"phaseBudgetOutUserAt",1997.33,"projectBaselineId","seGM","bizProcInstId","C540","bizFlowState","O","phaseBudgetWorkload",4681.68,"phaseActWorkload",5345.8,"phaseActInnerUserWorkload",9063.62,"phaseActOutUserWorkload",9373.87,"taskType","9mTi","planType","Z5We","seqNo","GALJ","phaseBudgetInnerUserWorkload",1146.58,"phaseBudgetOutUserWorkload",6622.04,"actNouserAt",5792.03,"actInnerUserAt",1300.49,"phaseBudgetInnerUserPrice",2354.42,"phaseBudgetOutUserPrice",8684.7,"phaseBudgetOutUserCnt",414,"phaseBudgetInnerUserCnt",3569,"actRate",2499.19,"phaseStatus","0","actOutUserAt",4257.37,"taskCnt",7806,"finishTaskCnt",4244,"iterationCnt",9890,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",5492.9,"taskBudgetAt",6263.77);
		XmProjectPhase xmProjectPhase7=BaseUtils.fromMap(p7,XmProjectPhase.class);
		batchValues.add(xmProjectPhase7);
		xmProjectPhaseService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","W3Cl");
		Map<String,Object> result=this.xmProjectPhaseService.selectOne(XmProjectPhase.class.getName()+".selectOneMap",p);
		Assert.assertEquals("W3Cl", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("phaseName","oC8h","remark","6qnJ","parentPhaseId","iAvB","branchId","X21N","projectId","JM48","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",6480.9,"phaseBudgetStaffNu",9252,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",2941.61,"phaseBudgetInnerUserAt",5005.56,"phaseBudgetOutUserAt",4509.56,"projectBaselineId","9ha7","bizProcInstId","nteE","bizFlowState","g","phaseBudgetWorkload",6773.34,"phaseActWorkload",1844.77,"phaseActInnerUserWorkload",1973.77,"phaseActOutUserWorkload",3328.2,"taskType","Hain","planType","Fp16","seqNo","rSK2","phaseBudgetInnerUserWorkload",3782.43,"phaseBudgetOutUserWorkload",5948.69,"actNouserAt",5275.47,"actInnerUserAt",9374.98,"phaseBudgetInnerUserPrice",531.05,"phaseBudgetOutUserPrice",3718.12,"phaseBudgetOutUserCnt",342,"phaseBudgetInnerUserCnt",7108,"actRate",4924.7,"phaseStatus","K","actOutUserAt",8346.62,"taskCnt",8397,"finishTaskCnt",5822,"iterationCnt",9512,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",9739.52,"taskBudgetAt",213.68);
		XmProjectPhase xmProjectPhase=BaseUtils.fromMap(p,XmProjectPhase.class);
		long result=xmProjectPhaseService.countByWhere(xmProjectPhase);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("phaseName","oC8h","remark","6qnJ","parentPhaseId","iAvB","branchId","X21N","projectId","JM48","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",6480.9,"phaseBudgetStaffNu",9252,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",2941.61,"phaseBudgetInnerUserAt",5005.56,"phaseBudgetOutUserAt",4509.56,"projectBaselineId","9ha7","bizProcInstId","nteE","bizFlowState","g","phaseBudgetWorkload",6773.34,"phaseActWorkload",1844.77,"phaseActInnerUserWorkload",1973.77,"phaseActOutUserWorkload",3328.2,"taskType","Hain","planType","Fp16","seqNo","rSK2","phaseBudgetInnerUserWorkload",3782.43,"phaseBudgetOutUserWorkload",5948.69,"actNouserAt",5275.47,"actInnerUserAt",9374.98,"phaseBudgetInnerUserPrice",531.05,"phaseBudgetOutUserPrice",3718.12,"phaseBudgetOutUserCnt",342,"phaseBudgetInnerUserCnt",7108,"actRate",4924.7,"phaseStatus","K","actOutUserAt",8346.62,"taskCnt",8397,"finishTaskCnt",5822,"iterationCnt",9512,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",9739.52,"taskBudgetAt",213.68);
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmProjectPhase xmProjectPhase=BaseUtils.fromMap(p,XmProjectPhase.class);
		List<XmProjectPhase> result=xmProjectPhaseService.selectListByWhere(xmProjectPhase); 
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
	
		
		Map<String,Object> p=BaseUtils.map("phaseName","oC8h","remark","6qnJ","parentPhaseId","iAvB","branchId","X21N","projectId","JM48","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",6480.9,"phaseBudgetStaffNu",9252,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",2941.61,"phaseBudgetInnerUserAt",5005.56,"phaseBudgetOutUserAt",4509.56,"projectBaselineId","9ha7","bizProcInstId","nteE","bizFlowState","g","phaseBudgetWorkload",6773.34,"phaseActWorkload",1844.77,"phaseActInnerUserWorkload",1973.77,"phaseActOutUserWorkload",3328.2,"taskType","Hain","planType","Fp16","seqNo","rSK2","phaseBudgetInnerUserWorkload",3782.43,"phaseBudgetOutUserWorkload",5948.69,"actNouserAt",5275.47,"actInnerUserAt",9374.98,"phaseBudgetInnerUserPrice",531.05,"phaseBudgetOutUserPrice",3718.12,"phaseBudgetOutUserCnt",342,"phaseBudgetInnerUserCnt",7108,"actRate",4924.7,"phaseStatus","K","actOutUserAt",8346.62,"taskCnt",8397,"finishTaskCnt",5822,"iterationCnt",9512,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",9739.52,"taskBudgetAt",213.68);
		XmProjectPhase xmProjectPhase=BaseUtils.fromMap(p,XmProjectPhase.class);
		List<XmProjectPhase> result=xmProjectPhaseService.selectListByWhere(xmProjectPhase);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("phaseName","oC8h","remark","6qnJ","parentPhaseId","iAvB","branchId","X21N","projectId","JM48","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",6480.9,"phaseBudgetStaffNu",9252,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",2941.61,"phaseBudgetInnerUserAt",5005.56,"phaseBudgetOutUserAt",4509.56,"projectBaselineId","9ha7","bizProcInstId","nteE","bizFlowState","g","phaseBudgetWorkload",6773.34,"phaseActWorkload",1844.77,"phaseActInnerUserWorkload",1973.77,"phaseActOutUserWorkload",3328.2,"taskType","Hain","planType","Fp16","seqNo","rSK2","phaseBudgetInnerUserWorkload",3782.43,"phaseBudgetOutUserWorkload",5948.69,"actNouserAt",5275.47,"actInnerUserAt",9374.98,"phaseBudgetInnerUserPrice",531.05,"phaseBudgetOutUserPrice",3718.12,"phaseBudgetOutUserCnt",342,"phaseBudgetInnerUserCnt",7108,"actRate",4924.7,"phaseStatus","K","actOutUserAt",8346.62,"taskCnt",8397,"finishTaskCnt",5822,"iterationCnt",9512,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",9739.52,"taskBudgetAt",213.68);
		List<Map<String,Object>> result=xmProjectPhaseService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("phaseName","oC8h","remark","6qnJ","parentPhaseId","iAvB","branchId","X21N","projectId","JM48","beginDate",parse("2020-11-11 18:53:27"),"endDate",parse("2020-11-11 18:53:27"),"phaseBudgetHours",6480.9,"phaseBudgetStaffNu",9252,"ctime",parse("2020-11-11 18:53:27"),"phaseBudgetNouserAt",2941.61,"phaseBudgetInnerUserAt",5005.56,"phaseBudgetOutUserAt",4509.56,"projectBaselineId","9ha7","bizProcInstId","nteE","bizFlowState","g","phaseBudgetWorkload",6773.34,"phaseActWorkload",1844.77,"phaseActInnerUserWorkload",1973.77,"phaseActOutUserWorkload",3328.2,"taskType","Hain","planType","Fp16","seqNo","rSK2","phaseBudgetInnerUserWorkload",3782.43,"phaseBudgetOutUserWorkload",5948.69,"actNouserAt",5275.47,"actInnerUserAt",9374.98,"phaseBudgetInnerUserPrice",531.05,"phaseBudgetOutUserPrice",3718.12,"phaseBudgetOutUserCnt",342,"phaseBudgetInnerUserCnt",7108,"actRate",4924.7,"phaseStatus","K","actOutUserAt",8346.62,"taskCnt",8397,"finishTaskCnt",5822,"iterationCnt",9512,"calcTime",parse("2020-11-11 18:53:27"),"taskBudgetWorkload",9739.52,"taskBudgetAt",213.68);
		List<Map<String,Object>> result=xmProjectPhaseService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmProjectPhase
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","W3Cl");
		
		XmProjectPhase xmProjectPhase1=BaseUtils.fromMap(p,XmProjectPhase.class);
		XmProjectPhase xmProjectPhase=xmProjectPhaseService.selectOneObject(xmProjectPhase1);
		Assert.assertEquals("W3Cl", xmProjectPhase.getId());
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
