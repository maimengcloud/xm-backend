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
import  com.qqkj.xm.core.service.XmProjectPhaseBaselineService; 
import com.qqkj.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import  com.qqkj.xm.core.entity.XmProjectPhaseBaseline;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmProjectPhaseBaselineService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_project_phase_baseline xm_project_phase_baseline<br>
 * 实体 XmProjectPhaseBaseline<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	baseCtime,projectPhaseId,phaseName,remark,parentPhaseId,branchId,projectId,beginDate,endDate,planWorkingHours,planWorkingStaffNu,ctime,totalBudgetNouser,totalBudgetInnerUser,totalBudgetOutUser,id,baseRemark,projectBaselineId,bizProcInstId,bizFlowState,totalBudgetWorkload,totalActWorkload;<br>
 * 当前表的所有字段名:<br>
 *	base_ctime,project_phase_id,phase_name,remark,parent_phase_id,branch_id,project_id,begin_date,end_date,plan_working_hours,plan_working_staff_nu,ctime,total_budget_nouser,total_budget_inner_user,total_budget_out_user,id,base_remark,project_baseline_id,biz_proc_inst_id,biz_flow_state,total_budget_workload,total_act_workload;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectPhaseBaselineService  {

	@Autowired
	XmProjectPhaseBaselineService xmProjectPhaseBaselineService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","pd7P","phaseName","pVg2","remark","BFeD","parentPhaseId","HLs3","branchId","Do6b","projectId","xH3I","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",4634.93,"planWorkingStaffNu",6990.98,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",4075.36,"totalBudgetInnerUser",2003.36,"totalBudgetOutUser",4365.6,"id","FqYc","baseRemark","7Ixb","projectBaselineId","WeKC","bizProcInstId","PBqj","bizFlowState","9","totalBudgetWorkload",8434.8,"totalActWorkload",4439.97);
		XmProjectPhaseBaseline xmProjectPhaseBaseline=BaseUtils.fromMap(p,XmProjectPhaseBaseline.class);
		xmProjectPhaseBaselineService.insert(xmProjectPhaseBaseline);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","pd7P","phaseName","pVg2","remark","BFeD","parentPhaseId","HLs3","branchId","Do6b","projectId","xH3I","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",4634.93,"planWorkingStaffNu",6990.98,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",4075.36,"totalBudgetInnerUser",2003.36,"totalBudgetOutUser",4365.6,"baseRemark","7Ixb","projectBaselineId","WeKC","bizProcInstId","PBqj","bizFlowState","9","totalBudgetWorkload",8434.8,"totalActWorkload",4439.97);
		XmProjectPhaseBaseline xmProjectPhaseBaseline=BaseUtils.fromMap(p,XmProjectPhaseBaseline.class);
		xmProjectPhaseBaselineService.deleteByWhere(xmProjectPhaseBaseline);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","FqYc");
		XmProjectPhaseBaseline xmProjectPhaseBaseline=BaseUtils.fromMap(p,XmProjectPhaseBaseline.class);
		xmProjectPhaseBaselineService.deleteByPk(xmProjectPhaseBaseline);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","pd7P","phaseName","pVg2","remark","BFeD","parentPhaseId","HLs3","branchId","Do6b","projectId","xH3I","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",4634.93,"planWorkingStaffNu",6990.98,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",4075.36,"totalBudgetInnerUser",2003.36,"totalBudgetOutUser",4365.6,"baseRemark","7Ixb","projectBaselineId","WeKC","bizProcInstId","PBqj","bizFlowState","9","totalBudgetWorkload",8434.8,"totalActWorkload",4439.97);
		XmProjectPhaseBaseline xmProjectPhaseBaseline=BaseUtils.fromMap(where,XmProjectPhaseBaseline.class);
		xmProjectPhaseBaselineService.updateSomeFieldByPk(xmProjectPhaseBaseline);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","FqYc");
		XmProjectPhaseBaseline xmProjectPhaseBaseline=BaseUtils.fromMap(p,XmProjectPhaseBaseline.class);
		xmProjectPhaseBaselineService.updateByPk(xmProjectPhaseBaseline);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","pd7P","phaseName","pVg2","remark","BFeD","parentPhaseId","HLs3","branchId","Do6b","projectId","xH3I","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",4634.93,"planWorkingStaffNu",6990.98,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",4075.36,"totalBudgetInnerUser",2003.36,"totalBudgetOutUser",4365.6,"id","FqYc","baseRemark","7Ixb","projectBaselineId","WeKC","bizProcInstId","PBqj","bizFlowState","9","totalBudgetWorkload",8434.8,"totalActWorkload",4439.97);
		XmProjectPhaseBaseline xmProjectPhaseBaseline=BaseUtils.fromMap(p,XmProjectPhaseBaseline.class);
		xmProjectPhaseBaselineService.insertOrUpdate(xmProjectPhaseBaseline);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmProjectPhaseBaseline> batchValues=new ArrayList<XmProjectPhaseBaseline>();
		Map p0=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","pd7P","phaseName","pVg2","remark","BFeD","parentPhaseId","HLs3","branchId","Do6b","projectId","xH3I","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",4634.93,"planWorkingStaffNu",6990.98,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",4075.36,"totalBudgetInnerUser",2003.36,"totalBudgetOutUser",4365.6,"id","FqYc","baseRemark","7Ixb","projectBaselineId","WeKC","bizProcInstId","PBqj","bizFlowState","9","totalBudgetWorkload",8434.8,"totalActWorkload",4439.97);
		XmProjectPhaseBaseline xmProjectPhaseBaseline0=BaseUtils.fromMap(p0,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline0);
		Map p1=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","ftkZ","phaseName","813w","remark","VPW3","parentPhaseId","Sp3y","branchId","vD6P","projectId","emhJ","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",1804.1,"planWorkingStaffNu",1441.84,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",163.77,"totalBudgetInnerUser",561.97,"totalBudgetOutUser",3573.49,"id","wMXq","baseRemark","o1c6","projectBaselineId","ch26","bizProcInstId","n86x","bizFlowState","q","totalBudgetWorkload",85.19,"totalActWorkload",7172.61);
		XmProjectPhaseBaseline xmProjectPhaseBaseline1=BaseUtils.fromMap(p1,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline1);
		Map p2=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","5sR8","phaseName","YxtU","remark","BxGk","parentPhaseId","3cUz","branchId","QiJ5","projectId","zzmT","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",8180.58,"planWorkingStaffNu",919.23,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",6122.42,"totalBudgetInnerUser",2862.58,"totalBudgetOutUser",6784.89,"id","0ynR","baseRemark","y53h","projectBaselineId","28YF","bizProcInstId","8NB4","bizFlowState","x","totalBudgetWorkload",9176.51,"totalActWorkload",3830.25);
		XmProjectPhaseBaseline xmProjectPhaseBaseline2=BaseUtils.fromMap(p2,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline2);
		Map p3=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","kcU9","phaseName","QhNd","remark","PtBj","parentPhaseId","03k6","branchId","9mKm","projectId","izLW","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",7006.16,"planWorkingStaffNu",3176.57,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",9307.64,"totalBudgetInnerUser",5589.46,"totalBudgetOutUser",5589.43,"id","53qG","baseRemark","P9b1","projectBaselineId","9Uyc","bizProcInstId","NqaD","bizFlowState","Q","totalBudgetWorkload",419.73,"totalActWorkload",4227.2);
		XmProjectPhaseBaseline xmProjectPhaseBaseline3=BaseUtils.fromMap(p3,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline3);
		Map p4=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","kvSh","phaseName","sh63","remark","YH8l","parentPhaseId","l2t1","branchId","dmsu","projectId","KEBD","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",4736.52,"planWorkingStaffNu",3076.49,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",6077.39,"totalBudgetInnerUser",3535.85,"totalBudgetOutUser",3942.49,"id","fAQI","baseRemark","o2j0","projectBaselineId","z65Y","bizProcInstId","xHg1","bizFlowState","h","totalBudgetWorkload",5457.66,"totalActWorkload",937.19);
		XmProjectPhaseBaseline xmProjectPhaseBaseline4=BaseUtils.fromMap(p4,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline4);
		Map p5=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","K0DX","phaseName","Twda","remark","homc","parentPhaseId","Q3N4","branchId","td88","projectId","EFwK","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",957.5,"planWorkingStaffNu",5084.68,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",3828.62,"totalBudgetInnerUser",8554.9,"totalBudgetOutUser",5498.15,"id","aOBg","baseRemark","GyVT","projectBaselineId","Dgu2","bizProcInstId","Ka7X","bizFlowState","E","totalBudgetWorkload",8628.63,"totalActWorkload",7554.21);
		XmProjectPhaseBaseline xmProjectPhaseBaseline5=BaseUtils.fromMap(p5,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline5);
		Map p6=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","G3NY","phaseName","kQ1k","remark","r98Y","parentPhaseId","yE70","branchId","M7qf","projectId","0G0h","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",7488.64,"planWorkingStaffNu",2552.27,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",1782.24,"totalBudgetInnerUser",6696.23,"totalBudgetOutUser",9154.03,"id","6BbK","baseRemark","5V28","projectBaselineId","3bW8","bizProcInstId","o4O7","bizFlowState","0","totalBudgetWorkload",1946.66,"totalActWorkload",7445.56);
		XmProjectPhaseBaseline xmProjectPhaseBaseline6=BaseUtils.fromMap(p6,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline6);
		Map p7=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","kFWQ","phaseName","B8RF","remark","5Uo9","parentPhaseId","3q06","branchId","Q92m","projectId","1aIS","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",4735.86,"planWorkingStaffNu",5076.29,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",2045.29,"totalBudgetInnerUser",9141.16,"totalBudgetOutUser",4167.98,"id","12VQ","baseRemark","7Sd9","projectBaselineId","4ItM","bizProcInstId","K0r1","bizFlowState","7","totalBudgetWorkload",4598.17,"totalActWorkload",7792.73);
		XmProjectPhaseBaseline xmProjectPhaseBaseline7=BaseUtils.fromMap(p7,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline7);
		xmProjectPhaseBaselineService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmProjectPhaseBaseline> batchValues=new ArrayList<XmProjectPhaseBaseline>();
		Map p0=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","pd7P","phaseName","pVg2","remark","BFeD","parentPhaseId","HLs3","branchId","Do6b","projectId","xH3I","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",4634.93,"planWorkingStaffNu",6990.98,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",4075.36,"totalBudgetInnerUser",2003.36,"totalBudgetOutUser",4365.6,"id","FqYc","baseRemark","7Ixb","projectBaselineId","WeKC","bizProcInstId","PBqj","bizFlowState","9","totalBudgetWorkload",8434.8,"totalActWorkload",4439.97);
		XmProjectPhaseBaseline xmProjectPhaseBaseline0=BaseUtils.fromMap(p0,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline0);
		Map p1=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","ftkZ","phaseName","813w","remark","VPW3","parentPhaseId","Sp3y","branchId","vD6P","projectId","emhJ","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",1804.1,"planWorkingStaffNu",1441.84,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",163.77,"totalBudgetInnerUser",561.97,"totalBudgetOutUser",3573.49,"id","wMXq","baseRemark","o1c6","projectBaselineId","ch26","bizProcInstId","n86x","bizFlowState","q","totalBudgetWorkload",85.19,"totalActWorkload",7172.61);
		XmProjectPhaseBaseline xmProjectPhaseBaseline1=BaseUtils.fromMap(p1,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline1);
		Map p2=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","5sR8","phaseName","YxtU","remark","BxGk","parentPhaseId","3cUz","branchId","QiJ5","projectId","zzmT","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",8180.58,"planWorkingStaffNu",919.23,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",6122.42,"totalBudgetInnerUser",2862.58,"totalBudgetOutUser",6784.89,"id","0ynR","baseRemark","y53h","projectBaselineId","28YF","bizProcInstId","8NB4","bizFlowState","x","totalBudgetWorkload",9176.51,"totalActWorkload",3830.25);
		XmProjectPhaseBaseline xmProjectPhaseBaseline2=BaseUtils.fromMap(p2,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline2);
		Map p3=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","kcU9","phaseName","QhNd","remark","PtBj","parentPhaseId","03k6","branchId","9mKm","projectId","izLW","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",7006.16,"planWorkingStaffNu",3176.57,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",9307.64,"totalBudgetInnerUser",5589.46,"totalBudgetOutUser",5589.43,"id","53qG","baseRemark","P9b1","projectBaselineId","9Uyc","bizProcInstId","NqaD","bizFlowState","Q","totalBudgetWorkload",419.73,"totalActWorkload",4227.2);
		XmProjectPhaseBaseline xmProjectPhaseBaseline3=BaseUtils.fromMap(p3,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline3);
		Map p4=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","kvSh","phaseName","sh63","remark","YH8l","parentPhaseId","l2t1","branchId","dmsu","projectId","KEBD","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",4736.52,"planWorkingStaffNu",3076.49,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",6077.39,"totalBudgetInnerUser",3535.85,"totalBudgetOutUser",3942.49,"id","fAQI","baseRemark","o2j0","projectBaselineId","z65Y","bizProcInstId","xHg1","bizFlowState","h","totalBudgetWorkload",5457.66,"totalActWorkload",937.19);
		XmProjectPhaseBaseline xmProjectPhaseBaseline4=BaseUtils.fromMap(p4,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline4);
		Map p5=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","K0DX","phaseName","Twda","remark","homc","parentPhaseId","Q3N4","branchId","td88","projectId","EFwK","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",957.5,"planWorkingStaffNu",5084.68,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",3828.62,"totalBudgetInnerUser",8554.9,"totalBudgetOutUser",5498.15,"id","aOBg","baseRemark","GyVT","projectBaselineId","Dgu2","bizProcInstId","Ka7X","bizFlowState","E","totalBudgetWorkload",8628.63,"totalActWorkload",7554.21);
		XmProjectPhaseBaseline xmProjectPhaseBaseline5=BaseUtils.fromMap(p5,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline5);
		Map p6=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","G3NY","phaseName","kQ1k","remark","r98Y","parentPhaseId","yE70","branchId","M7qf","projectId","0G0h","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",7488.64,"planWorkingStaffNu",2552.27,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",1782.24,"totalBudgetInnerUser",6696.23,"totalBudgetOutUser",9154.03,"id","6BbK","baseRemark","5V28","projectBaselineId","3bW8","bizProcInstId","o4O7","bizFlowState","0","totalBudgetWorkload",1946.66,"totalActWorkload",7445.56);
		XmProjectPhaseBaseline xmProjectPhaseBaseline6=BaseUtils.fromMap(p6,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline6);
		Map p7=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","kFWQ","phaseName","B8RF","remark","5Uo9","parentPhaseId","3q06","branchId","Q92m","projectId","1aIS","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",4735.86,"planWorkingStaffNu",5076.29,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",2045.29,"totalBudgetInnerUser",9141.16,"totalBudgetOutUser",4167.98,"id","12VQ","baseRemark","7Sd9","projectBaselineId","4ItM","bizProcInstId","K0r1","bizFlowState","7","totalBudgetWorkload",4598.17,"totalActWorkload",7792.73);
		XmProjectPhaseBaseline xmProjectPhaseBaseline7=BaseUtils.fromMap(p7,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline7);
		xmProjectPhaseBaselineService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmProjectPhaseBaseline> batchValues=new ArrayList<XmProjectPhaseBaseline>();
		Map p0=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","pd7P","phaseName","pVg2","remark","BFeD","parentPhaseId","HLs3","branchId","Do6b","projectId","xH3I","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",4634.93,"planWorkingStaffNu",6990.98,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",4075.36,"totalBudgetInnerUser",2003.36,"totalBudgetOutUser",4365.6,"id","FqYc","baseRemark","7Ixb","projectBaselineId","WeKC","bizProcInstId","PBqj","bizFlowState","9","totalBudgetWorkload",8434.8,"totalActWorkload",4439.97);
		XmProjectPhaseBaseline xmProjectPhaseBaseline0=BaseUtils.fromMap(p0,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline0);
		Map p1=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","ftkZ","phaseName","813w","remark","VPW3","parentPhaseId","Sp3y","branchId","vD6P","projectId","emhJ","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",1804.1,"planWorkingStaffNu",1441.84,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",163.77,"totalBudgetInnerUser",561.97,"totalBudgetOutUser",3573.49,"id","wMXq","baseRemark","o1c6","projectBaselineId","ch26","bizProcInstId","n86x","bizFlowState","q","totalBudgetWorkload",85.19,"totalActWorkload",7172.61);
		XmProjectPhaseBaseline xmProjectPhaseBaseline1=BaseUtils.fromMap(p1,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline1);
		Map p2=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","5sR8","phaseName","YxtU","remark","BxGk","parentPhaseId","3cUz","branchId","QiJ5","projectId","zzmT","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",8180.58,"planWorkingStaffNu",919.23,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",6122.42,"totalBudgetInnerUser",2862.58,"totalBudgetOutUser",6784.89,"id","0ynR","baseRemark","y53h","projectBaselineId","28YF","bizProcInstId","8NB4","bizFlowState","x","totalBudgetWorkload",9176.51,"totalActWorkload",3830.25);
		XmProjectPhaseBaseline xmProjectPhaseBaseline2=BaseUtils.fromMap(p2,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline2);
		Map p3=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","kcU9","phaseName","QhNd","remark","PtBj","parentPhaseId","03k6","branchId","9mKm","projectId","izLW","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",7006.16,"planWorkingStaffNu",3176.57,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",9307.64,"totalBudgetInnerUser",5589.46,"totalBudgetOutUser",5589.43,"id","53qG","baseRemark","P9b1","projectBaselineId","9Uyc","bizProcInstId","NqaD","bizFlowState","Q","totalBudgetWorkload",419.73,"totalActWorkload",4227.2);
		XmProjectPhaseBaseline xmProjectPhaseBaseline3=BaseUtils.fromMap(p3,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline3);
		Map p4=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","kvSh","phaseName","sh63","remark","YH8l","parentPhaseId","l2t1","branchId","dmsu","projectId","KEBD","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",4736.52,"planWorkingStaffNu",3076.49,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",6077.39,"totalBudgetInnerUser",3535.85,"totalBudgetOutUser",3942.49,"id","fAQI","baseRemark","o2j0","projectBaselineId","z65Y","bizProcInstId","xHg1","bizFlowState","h","totalBudgetWorkload",5457.66,"totalActWorkload",937.19);
		XmProjectPhaseBaseline xmProjectPhaseBaseline4=BaseUtils.fromMap(p4,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline4);
		Map p5=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","K0DX","phaseName","Twda","remark","homc","parentPhaseId","Q3N4","branchId","td88","projectId","EFwK","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",957.5,"planWorkingStaffNu",5084.68,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",3828.62,"totalBudgetInnerUser",8554.9,"totalBudgetOutUser",5498.15,"id","aOBg","baseRemark","GyVT","projectBaselineId","Dgu2","bizProcInstId","Ka7X","bizFlowState","E","totalBudgetWorkload",8628.63,"totalActWorkload",7554.21);
		XmProjectPhaseBaseline xmProjectPhaseBaseline5=BaseUtils.fromMap(p5,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline5);
		Map p6=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","G3NY","phaseName","kQ1k","remark","r98Y","parentPhaseId","yE70","branchId","M7qf","projectId","0G0h","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",7488.64,"planWorkingStaffNu",2552.27,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",1782.24,"totalBudgetInnerUser",6696.23,"totalBudgetOutUser",9154.03,"id","6BbK","baseRemark","5V28","projectBaselineId","3bW8","bizProcInstId","o4O7","bizFlowState","0","totalBudgetWorkload",1946.66,"totalActWorkload",7445.56);
		XmProjectPhaseBaseline xmProjectPhaseBaseline6=BaseUtils.fromMap(p6,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline6);
		Map p7=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","kFWQ","phaseName","B8RF","remark","5Uo9","parentPhaseId","3q06","branchId","Q92m","projectId","1aIS","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",4735.86,"planWorkingStaffNu",5076.29,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",2045.29,"totalBudgetInnerUser",9141.16,"totalBudgetOutUser",4167.98,"id","12VQ","baseRemark","7Sd9","projectBaselineId","4ItM","bizProcInstId","K0r1","bizFlowState","7","totalBudgetWorkload",4598.17,"totalActWorkload",7792.73);
		XmProjectPhaseBaseline xmProjectPhaseBaseline7=BaseUtils.fromMap(p7,XmProjectPhaseBaseline.class);
		batchValues.add(xmProjectPhaseBaseline7);
		xmProjectPhaseBaselineService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","FqYc");
		Map<String,Object> result=this.xmProjectPhaseBaselineService.selectOne(XmProjectPhaseBaseline.class.getName()+".selectOneMap",p);
		Assert.assertEquals("FqYc", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","pd7P","phaseName","pVg2","remark","BFeD","parentPhaseId","HLs3","branchId","Do6b","projectId","xH3I","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",4634.93,"planWorkingStaffNu",6990.98,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",4075.36,"totalBudgetInnerUser",2003.36,"totalBudgetOutUser",4365.6,"baseRemark","7Ixb","projectBaselineId","WeKC","bizProcInstId","PBqj","bizFlowState","9","totalBudgetWorkload",8434.8,"totalActWorkload",4439.97);
		XmProjectPhaseBaseline xmProjectPhaseBaseline=BaseUtils.fromMap(p,XmProjectPhaseBaseline.class);
		long result=xmProjectPhaseBaselineService.countByWhere(xmProjectPhaseBaseline);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","pd7P","phaseName","pVg2","remark","BFeD","parentPhaseId","HLs3","branchId","Do6b","projectId","xH3I","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",4634.93,"planWorkingStaffNu",6990.98,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",4075.36,"totalBudgetInnerUser",2003.36,"totalBudgetOutUser",4365.6,"baseRemark","7Ixb","projectBaselineId","WeKC","bizProcInstId","PBqj","bizFlowState","9","totalBudgetWorkload",8434.8,"totalActWorkload",4439.97);
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmProjectPhaseBaseline xmProjectPhaseBaseline=BaseUtils.fromMap(p,XmProjectPhaseBaseline.class);
		List<XmProjectPhaseBaseline> result=xmProjectPhaseBaselineService.selectListByWhere(xmProjectPhaseBaseline); 
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
	
		
		Map<String,Object> p=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","pd7P","phaseName","pVg2","remark","BFeD","parentPhaseId","HLs3","branchId","Do6b","projectId","xH3I","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",4634.93,"planWorkingStaffNu",6990.98,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",4075.36,"totalBudgetInnerUser",2003.36,"totalBudgetOutUser",4365.6,"baseRemark","7Ixb","projectBaselineId","WeKC","bizProcInstId","PBqj","bizFlowState","9","totalBudgetWorkload",8434.8,"totalActWorkload",4439.97);
		XmProjectPhaseBaseline xmProjectPhaseBaseline=BaseUtils.fromMap(p,XmProjectPhaseBaseline.class);
		List<XmProjectPhaseBaseline> result=xmProjectPhaseBaselineService.selectListByWhere(xmProjectPhaseBaseline);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","pd7P","phaseName","pVg2","remark","BFeD","parentPhaseId","HLs3","branchId","Do6b","projectId","xH3I","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",4634.93,"planWorkingStaffNu",6990.98,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",4075.36,"totalBudgetInnerUser",2003.36,"totalBudgetOutUser",4365.6,"baseRemark","7Ixb","projectBaselineId","WeKC","bizProcInstId","PBqj","bizFlowState","9","totalBudgetWorkload",8434.8,"totalActWorkload",4439.97);
		List<Map<String,Object>> result=xmProjectPhaseBaselineService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("baseCtime",parse("2020-09-28 15:48:46"),"projectPhaseId","pd7P","phaseName","pVg2","remark","BFeD","parentPhaseId","HLs3","branchId","Do6b","projectId","xH3I","beginDate",parse("2020-09-28 15:48:46"),"endDate",parse("2020-09-28 15:48:46"),"planWorkingHours",4634.93,"planWorkingStaffNu",6990.98,"ctime",parse("2020-09-28 15:48:46"),"totalBudgetNouser",4075.36,"totalBudgetInnerUser",2003.36,"totalBudgetOutUser",4365.6,"baseRemark","7Ixb","projectBaselineId","WeKC","bizProcInstId","PBqj","bizFlowState","9","totalBudgetWorkload",8434.8,"totalActWorkload",4439.97);
		List<Map<String,Object>> result=xmProjectPhaseBaselineService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmProjectPhaseBaseline
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","FqYc");
		
		XmProjectPhaseBaseline xmProjectPhaseBaseline1=BaseUtils.fromMap(p,XmProjectPhaseBaseline.class);
		XmProjectPhaseBaseline xmProjectPhaseBaseline=xmProjectPhaseBaselineService.selectOneObject(xmProjectPhaseBaseline1);
		Assert.assertEquals("FqYc", xmProjectPhaseBaseline.getId());
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
