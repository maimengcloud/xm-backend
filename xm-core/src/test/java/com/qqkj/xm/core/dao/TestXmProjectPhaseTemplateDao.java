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
import com.qqkj.xm.core.entity.XmProjectPhaseTemplate;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmProjectPhaseTemplateDao的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_project_phase_template 项目阶段模板<br>
 * 实体 XmProjectPhaseTemplate<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,phaseName,remark,parentPhaseId,branchId,projectId,beginDate,endDate,phaseBudgetHours,phaseBudgetStaffNu,ctime,phaseBudgetNouserAt,phaseBudgetInnerUserAt,phaseBudgetOutUserAt,phaseBudgetWorkload,taskType,planType,seqNo,phaseBudgetInnerUserWorkload,phaseBudgetOutUserWorkload,phaseBudgetInnerUserPrice,phaseBudgetOutUserPrice,phaseBudgetOutUserCnt,phaseBudgetInnerUserCnt;<br>
 * 当前表的所有字段名:<br>
 *	id,phase_name,remark,parent_phase_id,branch_id,project_id,begin_date,end_date,phase_budget_hours,phase_budget_staff_nu,ctime,phase_budget_nouser_at,phase_budget_inner_user_at,phase_budget_out_user_at,phase_budget_workload,task_type,plan_type,seq_no,phase_budget_inner_user_workload,phase_budget_out_user_workload,phase_budget_inner_user_price,phase_budget_out_user_price,phase_budget_out_user_cnt,phase_budget_inner_user_cnt;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/
 @RunWith(SpringJUnit4ClassRunner.class)
 @SpringBootTest
public class TestXmProjectPhaseTemplateDao  {

	@Autowired
	BaseDao baseDao;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","px91","phaseName","XHk9","remark","PE8H","parentPhaseId","B52t","branchId","v3td","projectId","j95e","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",3548.39,"phaseBudgetStaffNu",6024.62,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",2868.15,"phaseBudgetInnerUserAt",9081.54,"phaseBudgetOutUserAt",947.44,"phaseBudgetWorkload",7776.59,"taskType","MnCB","planType","dyuS","seqNo","qPqj","phaseBudgetInnerUserWorkload",9748.55,"phaseBudgetOutUserWorkload",4165.76,"phaseBudgetInnerUserPrice",5218.25,"phaseBudgetOutUserPrice",653.52,"phaseBudgetOutUserCnt",9752.9,"phaseBudgetInnerUserCnt",5358.33);
		XmProjectPhaseTemplate xmProjectPhaseTemplate=BaseUtils.fromMap(p,XmProjectPhaseTemplate.class);
		baseDao.insert(xmProjectPhaseTemplate);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("phaseName","XHk9","remark","PE8H","parentPhaseId","B52t","branchId","v3td","projectId","j95e","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",3548.39,"phaseBudgetStaffNu",6024.62,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",2868.15,"phaseBudgetInnerUserAt",9081.54,"phaseBudgetOutUserAt",947.44,"phaseBudgetWorkload",7776.59,"taskType","MnCB","planType","dyuS","seqNo","qPqj","phaseBudgetInnerUserWorkload",9748.55,"phaseBudgetOutUserWorkload",4165.76,"phaseBudgetInnerUserPrice",5218.25,"phaseBudgetOutUserPrice",653.52,"phaseBudgetOutUserCnt",9752.9,"phaseBudgetInnerUserCnt",5358.33);
		XmProjectPhaseTemplate xmProjectPhaseTemplate=BaseUtils.fromMap(p,XmProjectPhaseTemplate.class);
		baseDao.deleteByWhere(xmProjectPhaseTemplate);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","px91");
		XmProjectPhaseTemplate xmProjectPhaseTemplate=BaseUtils.fromMap(p,XmProjectPhaseTemplate.class);
		baseDao.deleteByPk(xmProjectPhaseTemplate);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("phaseName","XHk9","remark","PE8H","parentPhaseId","B52t","branchId","v3td","projectId","j95e","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",3548.39,"phaseBudgetStaffNu",6024.62,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",2868.15,"phaseBudgetInnerUserAt",9081.54,"phaseBudgetOutUserAt",947.44,"phaseBudgetWorkload",7776.59,"taskType","MnCB","planType","dyuS","seqNo","qPqj","phaseBudgetInnerUserWorkload",9748.55,"phaseBudgetOutUserWorkload",4165.76,"phaseBudgetInnerUserPrice",5218.25,"phaseBudgetOutUserPrice",653.52,"phaseBudgetOutUserCnt",9752.9,"phaseBudgetInnerUserCnt",5358.33);
		XmProjectPhaseTemplate xmProjectPhaseTemplate=BaseUtils.fromMap(where,XmProjectPhaseTemplate.class);
		baseDao.updateSomeFieldByPk(xmProjectPhaseTemplate);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","px91");
		XmProjectPhaseTemplate xmProjectPhaseTemplate=BaseUtils.fromMap(p,XmProjectPhaseTemplate.class);
		baseDao.updateByPk(xmProjectPhaseTemplate);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("id","px91","phaseName","XHk9","remark","PE8H","parentPhaseId","B52t","branchId","v3td","projectId","j95e","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",3548.39,"phaseBudgetStaffNu",6024.62,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",2868.15,"phaseBudgetInnerUserAt",9081.54,"phaseBudgetOutUserAt",947.44,"phaseBudgetWorkload",7776.59,"taskType","MnCB","planType","dyuS","seqNo","qPqj","phaseBudgetInnerUserWorkload",9748.55,"phaseBudgetOutUserWorkload",4165.76,"phaseBudgetInnerUserPrice",5218.25,"phaseBudgetOutUserPrice",653.52,"phaseBudgetOutUserCnt",9752.9,"phaseBudgetInnerUserCnt",5358.33);
		XmProjectPhaseTemplate xmProjectPhaseTemplate=BaseUtils.fromMap(p,XmProjectPhaseTemplate.class);
		baseDao.insertOrUpdate(xmProjectPhaseTemplate);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmProjectPhaseTemplate> batchValues=new ArrayList<XmProjectPhaseTemplate>();
		Map p0=BaseUtils.map("id","px91","phaseName","XHk9","remark","PE8H","parentPhaseId","B52t","branchId","v3td","projectId","j95e","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",3548.39,"phaseBudgetStaffNu",6024.62,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",2868.15,"phaseBudgetInnerUserAt",9081.54,"phaseBudgetOutUserAt",947.44,"phaseBudgetWorkload",7776.59,"taskType","MnCB","planType","dyuS","seqNo","qPqj","phaseBudgetInnerUserWorkload",9748.55,"phaseBudgetOutUserWorkload",4165.76,"phaseBudgetInnerUserPrice",5218.25,"phaseBudgetOutUserPrice",653.52,"phaseBudgetOutUserCnt",9752.9,"phaseBudgetInnerUserCnt",5358.33);
		XmProjectPhaseTemplate xmProjectPhaseTemplate0=BaseUtils.fromMap(p0,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate0);
		Map p1=BaseUtils.map("id","JTwl","phaseName","HPy0","remark","P1K9","parentPhaseId","ulzl","branchId","otl0","projectId","WU30","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",2650.87,"phaseBudgetStaffNu",593.65,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",2531.28,"phaseBudgetInnerUserAt",8104.42,"phaseBudgetOutUserAt",1854.88,"phaseBudgetWorkload",7368.03,"taskType","owJ2","planType","yd1R","seqNo","U1rY","phaseBudgetInnerUserWorkload",2908.05,"phaseBudgetOutUserWorkload",4663.22,"phaseBudgetInnerUserPrice",9660.53,"phaseBudgetOutUserPrice",6694.59,"phaseBudgetOutUserCnt",4045.31,"phaseBudgetInnerUserCnt",8613.09);
		XmProjectPhaseTemplate xmProjectPhaseTemplate1=BaseUtils.fromMap(p1,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate1);
		Map p2=BaseUtils.map("id","ra05","phaseName","b2oD","remark","j280","parentPhaseId","1fnI","branchId","KwHK","projectId","ttlc","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",6577.75,"phaseBudgetStaffNu",5978.56,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",721.69,"phaseBudgetInnerUserAt",4107.52,"phaseBudgetOutUserAt",4519.04,"phaseBudgetWorkload",3386.48,"taskType","fru9","planType","nmb0","seqNo","4T1O","phaseBudgetInnerUserWorkload",7657.16,"phaseBudgetOutUserWorkload",8814.09,"phaseBudgetInnerUserPrice",982.32,"phaseBudgetOutUserPrice",4708.33,"phaseBudgetOutUserCnt",5216.21,"phaseBudgetInnerUserCnt",7137.88);
		XmProjectPhaseTemplate xmProjectPhaseTemplate2=BaseUtils.fromMap(p2,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate2);
		Map p3=BaseUtils.map("id","5ujJ","phaseName","6lxP","remark","DXgA","parentPhaseId","907d","branchId","cRBw","projectId","xNql","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",5209.62,"phaseBudgetStaffNu",9415.7,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",6744.44,"phaseBudgetInnerUserAt",8380.76,"phaseBudgetOutUserAt",2814.09,"phaseBudgetWorkload",6870.96,"taskType","o5V5","planType","8P86","seqNo","svc2","phaseBudgetInnerUserWorkload",8310.65,"phaseBudgetOutUserWorkload",2552.41,"phaseBudgetInnerUserPrice",7660.59,"phaseBudgetOutUserPrice",893.91,"phaseBudgetOutUserCnt",1917.43,"phaseBudgetInnerUserCnt",5859.97);
		XmProjectPhaseTemplate xmProjectPhaseTemplate3=BaseUtils.fromMap(p3,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate3);
		Map p4=BaseUtils.map("id","he37","phaseName","tW1Z","remark","0f6a","parentPhaseId","QIqG","branchId","o2j2","projectId","8FfC","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",7947.81,"phaseBudgetStaffNu",6985.43,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",6950.07,"phaseBudgetInnerUserAt",6320.11,"phaseBudgetOutUserAt",7218.81,"phaseBudgetWorkload",3943.84,"taskType","6nAa","planType","KlJ8","seqNo","77s3","phaseBudgetInnerUserWorkload",2244.1,"phaseBudgetOutUserWorkload",9468.2,"phaseBudgetInnerUserPrice",2491.53,"phaseBudgetOutUserPrice",6754.35,"phaseBudgetOutUserCnt",8399.54,"phaseBudgetInnerUserCnt",1691.57);
		XmProjectPhaseTemplate xmProjectPhaseTemplate4=BaseUtils.fromMap(p4,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate4);
		Map p5=BaseUtils.map("id","pgvN","phaseName","CzL5","remark","9X06","parentPhaseId","3qHT","branchId","s91a","projectId","bgPK","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",8223.97,"phaseBudgetStaffNu",9191.17,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",4881,"phaseBudgetInnerUserAt",7390.25,"phaseBudgetOutUserAt",4366.86,"phaseBudgetWorkload",3896.1,"taskType","Mxg3","planType","piu8","seqNo","8TL8","phaseBudgetInnerUserWorkload",8789.81,"phaseBudgetOutUserWorkload",1081.8,"phaseBudgetInnerUserPrice",1777.47,"phaseBudgetOutUserPrice",9835.94,"phaseBudgetOutUserCnt",5200.32,"phaseBudgetInnerUserCnt",1105.43);
		XmProjectPhaseTemplate xmProjectPhaseTemplate5=BaseUtils.fromMap(p5,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate5);
		Map p6=BaseUtils.map("id","FUsU","phaseName","tjKd","remark","959C","parentPhaseId","yX6u","branchId","Pi5j","projectId","U0hm","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",4469.95,"phaseBudgetStaffNu",8664.74,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",8896.02,"phaseBudgetInnerUserAt",8104.53,"phaseBudgetOutUserAt",8643.24,"phaseBudgetWorkload",371.29,"taskType","21b4","planType","5zUT","seqNo","Py7u","phaseBudgetInnerUserWorkload",6965.24,"phaseBudgetOutUserWorkload",8368.32,"phaseBudgetInnerUserPrice",5496.05,"phaseBudgetOutUserPrice",2363.23,"phaseBudgetOutUserCnt",8548.98,"phaseBudgetInnerUserCnt",7294.22);
		XmProjectPhaseTemplate xmProjectPhaseTemplate6=BaseUtils.fromMap(p6,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate6);
		Map p7=BaseUtils.map("id","In1f","phaseName","RP9X","remark","QMLO","parentPhaseId","K4lC","branchId","DfrX","projectId","t51H","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",738.97,"phaseBudgetStaffNu",2267.71,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",7917.71,"phaseBudgetInnerUserAt",776.36,"phaseBudgetOutUserAt",4672.23,"phaseBudgetWorkload",3427.04,"taskType","1U80","planType","k2ly","seqNo","zF4y","phaseBudgetInnerUserWorkload",3260.38,"phaseBudgetOutUserWorkload",3804.49,"phaseBudgetInnerUserPrice",1819.78,"phaseBudgetOutUserPrice",1264.49,"phaseBudgetOutUserCnt",9394.31,"phaseBudgetInnerUserCnt",4954.56);
		XmProjectPhaseTemplate xmProjectPhaseTemplate7=BaseUtils.fromMap(p7,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate7);
		baseDao.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmProjectPhaseTemplate> batchValues=new ArrayList<XmProjectPhaseTemplate>();
		Map p0=BaseUtils.map("id","px91","phaseName","XHk9","remark","PE8H","parentPhaseId","B52t","branchId","v3td","projectId","j95e","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",3548.39,"phaseBudgetStaffNu",6024.62,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",2868.15,"phaseBudgetInnerUserAt",9081.54,"phaseBudgetOutUserAt",947.44,"phaseBudgetWorkload",7776.59,"taskType","MnCB","planType","dyuS","seqNo","qPqj","phaseBudgetInnerUserWorkload",9748.55,"phaseBudgetOutUserWorkload",4165.76,"phaseBudgetInnerUserPrice",5218.25,"phaseBudgetOutUserPrice",653.52,"phaseBudgetOutUserCnt",9752.9,"phaseBudgetInnerUserCnt",5358.33);
		XmProjectPhaseTemplate xmProjectPhaseTemplate0=BaseUtils.fromMap(p0,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate0);
		Map p1=BaseUtils.map("id","JTwl","phaseName","HPy0","remark","P1K9","parentPhaseId","ulzl","branchId","otl0","projectId","WU30","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",2650.87,"phaseBudgetStaffNu",593.65,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",2531.28,"phaseBudgetInnerUserAt",8104.42,"phaseBudgetOutUserAt",1854.88,"phaseBudgetWorkload",7368.03,"taskType","owJ2","planType","yd1R","seqNo","U1rY","phaseBudgetInnerUserWorkload",2908.05,"phaseBudgetOutUserWorkload",4663.22,"phaseBudgetInnerUserPrice",9660.53,"phaseBudgetOutUserPrice",6694.59,"phaseBudgetOutUserCnt",4045.31,"phaseBudgetInnerUserCnt",8613.09);
		XmProjectPhaseTemplate xmProjectPhaseTemplate1=BaseUtils.fromMap(p1,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate1);
		Map p2=BaseUtils.map("id","ra05","phaseName","b2oD","remark","j280","parentPhaseId","1fnI","branchId","KwHK","projectId","ttlc","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",6577.75,"phaseBudgetStaffNu",5978.56,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",721.69,"phaseBudgetInnerUserAt",4107.52,"phaseBudgetOutUserAt",4519.04,"phaseBudgetWorkload",3386.48,"taskType","fru9","planType","nmb0","seqNo","4T1O","phaseBudgetInnerUserWorkload",7657.16,"phaseBudgetOutUserWorkload",8814.09,"phaseBudgetInnerUserPrice",982.32,"phaseBudgetOutUserPrice",4708.33,"phaseBudgetOutUserCnt",5216.21,"phaseBudgetInnerUserCnt",7137.88);
		XmProjectPhaseTemplate xmProjectPhaseTemplate2=BaseUtils.fromMap(p2,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate2);
		Map p3=BaseUtils.map("id","5ujJ","phaseName","6lxP","remark","DXgA","parentPhaseId","907d","branchId","cRBw","projectId","xNql","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",5209.62,"phaseBudgetStaffNu",9415.7,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",6744.44,"phaseBudgetInnerUserAt",8380.76,"phaseBudgetOutUserAt",2814.09,"phaseBudgetWorkload",6870.96,"taskType","o5V5","planType","8P86","seqNo","svc2","phaseBudgetInnerUserWorkload",8310.65,"phaseBudgetOutUserWorkload",2552.41,"phaseBudgetInnerUserPrice",7660.59,"phaseBudgetOutUserPrice",893.91,"phaseBudgetOutUserCnt",1917.43,"phaseBudgetInnerUserCnt",5859.97);
		XmProjectPhaseTemplate xmProjectPhaseTemplate3=BaseUtils.fromMap(p3,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate3);
		Map p4=BaseUtils.map("id","he37","phaseName","tW1Z","remark","0f6a","parentPhaseId","QIqG","branchId","o2j2","projectId","8FfC","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",7947.81,"phaseBudgetStaffNu",6985.43,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",6950.07,"phaseBudgetInnerUserAt",6320.11,"phaseBudgetOutUserAt",7218.81,"phaseBudgetWorkload",3943.84,"taskType","6nAa","planType","KlJ8","seqNo","77s3","phaseBudgetInnerUserWorkload",2244.1,"phaseBudgetOutUserWorkload",9468.2,"phaseBudgetInnerUserPrice",2491.53,"phaseBudgetOutUserPrice",6754.35,"phaseBudgetOutUserCnt",8399.54,"phaseBudgetInnerUserCnt",1691.57);
		XmProjectPhaseTemplate xmProjectPhaseTemplate4=BaseUtils.fromMap(p4,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate4);
		Map p5=BaseUtils.map("id","pgvN","phaseName","CzL5","remark","9X06","parentPhaseId","3qHT","branchId","s91a","projectId","bgPK","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",8223.97,"phaseBudgetStaffNu",9191.17,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",4881,"phaseBudgetInnerUserAt",7390.25,"phaseBudgetOutUserAt",4366.86,"phaseBudgetWorkload",3896.1,"taskType","Mxg3","planType","piu8","seqNo","8TL8","phaseBudgetInnerUserWorkload",8789.81,"phaseBudgetOutUserWorkload",1081.8,"phaseBudgetInnerUserPrice",1777.47,"phaseBudgetOutUserPrice",9835.94,"phaseBudgetOutUserCnt",5200.32,"phaseBudgetInnerUserCnt",1105.43);
		XmProjectPhaseTemplate xmProjectPhaseTemplate5=BaseUtils.fromMap(p5,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate5);
		Map p6=BaseUtils.map("id","FUsU","phaseName","tjKd","remark","959C","parentPhaseId","yX6u","branchId","Pi5j","projectId","U0hm","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",4469.95,"phaseBudgetStaffNu",8664.74,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",8896.02,"phaseBudgetInnerUserAt",8104.53,"phaseBudgetOutUserAt",8643.24,"phaseBudgetWorkload",371.29,"taskType","21b4","planType","5zUT","seqNo","Py7u","phaseBudgetInnerUserWorkload",6965.24,"phaseBudgetOutUserWorkload",8368.32,"phaseBudgetInnerUserPrice",5496.05,"phaseBudgetOutUserPrice",2363.23,"phaseBudgetOutUserCnt",8548.98,"phaseBudgetInnerUserCnt",7294.22);
		XmProjectPhaseTemplate xmProjectPhaseTemplate6=BaseUtils.fromMap(p6,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate6);
		Map p7=BaseUtils.map("id","In1f","phaseName","RP9X","remark","QMLO","parentPhaseId","K4lC","branchId","DfrX","projectId","t51H","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",738.97,"phaseBudgetStaffNu",2267.71,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",7917.71,"phaseBudgetInnerUserAt",776.36,"phaseBudgetOutUserAt",4672.23,"phaseBudgetWorkload",3427.04,"taskType","1U80","planType","k2ly","seqNo","zF4y","phaseBudgetInnerUserWorkload",3260.38,"phaseBudgetOutUserWorkload",3804.49,"phaseBudgetInnerUserPrice",1819.78,"phaseBudgetOutUserPrice",1264.49,"phaseBudgetOutUserCnt",9394.31,"phaseBudgetInnerUserCnt",4954.56);
		XmProjectPhaseTemplate xmProjectPhaseTemplate7=BaseUtils.fromMap(p7,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate7);
		baseDao.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmProjectPhaseTemplate> batchValues=new ArrayList<XmProjectPhaseTemplate>();
		Map p0=BaseUtils.map("id","px91","phaseName","XHk9","remark","PE8H","parentPhaseId","B52t","branchId","v3td","projectId","j95e","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",3548.39,"phaseBudgetStaffNu",6024.62,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",2868.15,"phaseBudgetInnerUserAt",9081.54,"phaseBudgetOutUserAt",947.44,"phaseBudgetWorkload",7776.59,"taskType","MnCB","planType","dyuS","seqNo","qPqj","phaseBudgetInnerUserWorkload",9748.55,"phaseBudgetOutUserWorkload",4165.76,"phaseBudgetInnerUserPrice",5218.25,"phaseBudgetOutUserPrice",653.52,"phaseBudgetOutUserCnt",9752.9,"phaseBudgetInnerUserCnt",5358.33);
		XmProjectPhaseTemplate xmProjectPhaseTemplate0=BaseUtils.fromMap(p0,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate0);
		Map p1=BaseUtils.map("id","JTwl","phaseName","HPy0","remark","P1K9","parentPhaseId","ulzl","branchId","otl0","projectId","WU30","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",2650.87,"phaseBudgetStaffNu",593.65,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",2531.28,"phaseBudgetInnerUserAt",8104.42,"phaseBudgetOutUserAt",1854.88,"phaseBudgetWorkload",7368.03,"taskType","owJ2","planType","yd1R","seqNo","U1rY","phaseBudgetInnerUserWorkload",2908.05,"phaseBudgetOutUserWorkload",4663.22,"phaseBudgetInnerUserPrice",9660.53,"phaseBudgetOutUserPrice",6694.59,"phaseBudgetOutUserCnt",4045.31,"phaseBudgetInnerUserCnt",8613.09);
		XmProjectPhaseTemplate xmProjectPhaseTemplate1=BaseUtils.fromMap(p1,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate1);
		Map p2=BaseUtils.map("id","ra05","phaseName","b2oD","remark","j280","parentPhaseId","1fnI","branchId","KwHK","projectId","ttlc","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",6577.75,"phaseBudgetStaffNu",5978.56,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",721.69,"phaseBudgetInnerUserAt",4107.52,"phaseBudgetOutUserAt",4519.04,"phaseBudgetWorkload",3386.48,"taskType","fru9","planType","nmb0","seqNo","4T1O","phaseBudgetInnerUserWorkload",7657.16,"phaseBudgetOutUserWorkload",8814.09,"phaseBudgetInnerUserPrice",982.32,"phaseBudgetOutUserPrice",4708.33,"phaseBudgetOutUserCnt",5216.21,"phaseBudgetInnerUserCnt",7137.88);
		XmProjectPhaseTemplate xmProjectPhaseTemplate2=BaseUtils.fromMap(p2,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate2);
		Map p3=BaseUtils.map("id","5ujJ","phaseName","6lxP","remark","DXgA","parentPhaseId","907d","branchId","cRBw","projectId","xNql","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",5209.62,"phaseBudgetStaffNu",9415.7,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",6744.44,"phaseBudgetInnerUserAt",8380.76,"phaseBudgetOutUserAt",2814.09,"phaseBudgetWorkload",6870.96,"taskType","o5V5","planType","8P86","seqNo","svc2","phaseBudgetInnerUserWorkload",8310.65,"phaseBudgetOutUserWorkload",2552.41,"phaseBudgetInnerUserPrice",7660.59,"phaseBudgetOutUserPrice",893.91,"phaseBudgetOutUserCnt",1917.43,"phaseBudgetInnerUserCnt",5859.97);
		XmProjectPhaseTemplate xmProjectPhaseTemplate3=BaseUtils.fromMap(p3,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate3);
		Map p4=BaseUtils.map("id","he37","phaseName","tW1Z","remark","0f6a","parentPhaseId","QIqG","branchId","o2j2","projectId","8FfC","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",7947.81,"phaseBudgetStaffNu",6985.43,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",6950.07,"phaseBudgetInnerUserAt",6320.11,"phaseBudgetOutUserAt",7218.81,"phaseBudgetWorkload",3943.84,"taskType","6nAa","planType","KlJ8","seqNo","77s3","phaseBudgetInnerUserWorkload",2244.1,"phaseBudgetOutUserWorkload",9468.2,"phaseBudgetInnerUserPrice",2491.53,"phaseBudgetOutUserPrice",6754.35,"phaseBudgetOutUserCnt",8399.54,"phaseBudgetInnerUserCnt",1691.57);
		XmProjectPhaseTemplate xmProjectPhaseTemplate4=BaseUtils.fromMap(p4,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate4);
		Map p5=BaseUtils.map("id","pgvN","phaseName","CzL5","remark","9X06","parentPhaseId","3qHT","branchId","s91a","projectId","bgPK","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",8223.97,"phaseBudgetStaffNu",9191.17,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",4881,"phaseBudgetInnerUserAt",7390.25,"phaseBudgetOutUserAt",4366.86,"phaseBudgetWorkload",3896.1,"taskType","Mxg3","planType","piu8","seqNo","8TL8","phaseBudgetInnerUserWorkload",8789.81,"phaseBudgetOutUserWorkload",1081.8,"phaseBudgetInnerUserPrice",1777.47,"phaseBudgetOutUserPrice",9835.94,"phaseBudgetOutUserCnt",5200.32,"phaseBudgetInnerUserCnt",1105.43);
		XmProjectPhaseTemplate xmProjectPhaseTemplate5=BaseUtils.fromMap(p5,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate5);
		Map p6=BaseUtils.map("id","FUsU","phaseName","tjKd","remark","959C","parentPhaseId","yX6u","branchId","Pi5j","projectId","U0hm","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",4469.95,"phaseBudgetStaffNu",8664.74,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",8896.02,"phaseBudgetInnerUserAt",8104.53,"phaseBudgetOutUserAt",8643.24,"phaseBudgetWorkload",371.29,"taskType","21b4","planType","5zUT","seqNo","Py7u","phaseBudgetInnerUserWorkload",6965.24,"phaseBudgetOutUserWorkload",8368.32,"phaseBudgetInnerUserPrice",5496.05,"phaseBudgetOutUserPrice",2363.23,"phaseBudgetOutUserCnt",8548.98,"phaseBudgetInnerUserCnt",7294.22);
		XmProjectPhaseTemplate xmProjectPhaseTemplate6=BaseUtils.fromMap(p6,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate6);
		Map p7=BaseUtils.map("id","In1f","phaseName","RP9X","remark","QMLO","parentPhaseId","K4lC","branchId","DfrX","projectId","t51H","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",738.97,"phaseBudgetStaffNu",2267.71,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",7917.71,"phaseBudgetInnerUserAt",776.36,"phaseBudgetOutUserAt",4672.23,"phaseBudgetWorkload",3427.04,"taskType","1U80","planType","k2ly","seqNo","zF4y","phaseBudgetInnerUserWorkload",3260.38,"phaseBudgetOutUserWorkload",3804.49,"phaseBudgetInnerUserPrice",1819.78,"phaseBudgetOutUserPrice",1264.49,"phaseBudgetOutUserCnt",9394.31,"phaseBudgetInnerUserCnt",4954.56);
		XmProjectPhaseTemplate xmProjectPhaseTemplate7=BaseUtils.fromMap(p7,XmProjectPhaseTemplate.class);
		batchValues.add(xmProjectPhaseTemplate7);
		baseDao.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","px91");
		Map<String,Object> result=this.baseDao.selectOne(XmProjectPhaseTemplate.class.getName()+".selectOneMap",p);
		Assert.assertEquals("px91", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("phaseName","XHk9","remark","PE8H","parentPhaseId","B52t","branchId","v3td","projectId","j95e","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",3548.39,"phaseBudgetStaffNu",6024.62,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",2868.15,"phaseBudgetInnerUserAt",9081.54,"phaseBudgetOutUserAt",947.44,"phaseBudgetWorkload",7776.59,"taskType","MnCB","planType","dyuS","seqNo","qPqj","phaseBudgetInnerUserWorkload",9748.55,"phaseBudgetOutUserWorkload",4165.76,"phaseBudgetInnerUserPrice",5218.25,"phaseBudgetOutUserPrice",653.52,"phaseBudgetOutUserCnt",9752.9,"phaseBudgetInnerUserCnt",5358.33);
		XmProjectPhaseTemplate xmProjectPhaseTemplate=BaseUtils.fromMap(p,XmProjectPhaseTemplate.class);
		long result=baseDao.countByWhere(xmProjectPhaseTemplate);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
 		
		
		Map<String,Object> p=BaseUtils.map("phaseName","XHk9","remark","PE8H","parentPhaseId","B52t","branchId","v3td","projectId","j95e","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",3548.39,"phaseBudgetStaffNu",6024.62,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",2868.15,"phaseBudgetInnerUserAt",9081.54,"phaseBudgetOutUserAt",947.44,"phaseBudgetWorkload",7776.59,"taskType","MnCB","planType","dyuS","seqNo","qPqj","phaseBudgetInnerUserWorkload",9748.55,"phaseBudgetOutUserWorkload",4165.76,"phaseBudgetInnerUserPrice",5218.25,"phaseBudgetOutUserPrice",653.52,"phaseBudgetOutUserCnt",9752.9,"phaseBudgetInnerUserCnt",5358.33);
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmProjectPhaseTemplate xmProjectPhaseTemplate=BaseUtils.fromMap(p,XmProjectPhaseTemplate.class);
		List<XmProjectPhaseTemplate> result=baseDao.selectListByWhere(xmProjectPhaseTemplate); 
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
	
		
		Map<String,Object> p=BaseUtils.map("phaseName","XHk9","remark","PE8H","parentPhaseId","B52t","branchId","v3td","projectId","j95e","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",3548.39,"phaseBudgetStaffNu",6024.62,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",2868.15,"phaseBudgetInnerUserAt",9081.54,"phaseBudgetOutUserAt",947.44,"phaseBudgetWorkload",7776.59,"taskType","MnCB","planType","dyuS","seqNo","qPqj","phaseBudgetInnerUserWorkload",9748.55,"phaseBudgetOutUserWorkload",4165.76,"phaseBudgetInnerUserPrice",5218.25,"phaseBudgetOutUserPrice",653.52,"phaseBudgetOutUserCnt",9752.9,"phaseBudgetInnerUserCnt",5358.33);
		XmProjectPhaseTemplate xmProjectPhaseTemplate=BaseUtils.fromMap(p,XmProjectPhaseTemplate.class);
		List<XmProjectPhaseTemplate> result=baseDao.selectListByWhere(xmProjectPhaseTemplate);
		Assert.assertEquals(true, result.size()>=1);
	}

	
	/**
	 * 查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("phaseName","XHk9","remark","PE8H","parentPhaseId","B52t","branchId","v3td","projectId","j95e","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",3548.39,"phaseBudgetStaffNu",6024.62,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",2868.15,"phaseBudgetInnerUserAt",9081.54,"phaseBudgetOutUserAt",947.44,"phaseBudgetWorkload",7776.59,"taskType","MnCB","planType","dyuS","seqNo","qPqj","phaseBudgetInnerUserWorkload",9748.55,"phaseBudgetOutUserWorkload",4165.76,"phaseBudgetInnerUserPrice",5218.25,"phaseBudgetOutUserPrice",653.52,"phaseBudgetOutUserCnt",9752.9,"phaseBudgetInnerUserCnt",5358.33);
		List<Map<String,Object>> result=baseDao.selectList(XmProjectPhaseTemplate.class.getName()+".selectListMapByWhere",p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("phaseName","XHk9","remark","PE8H","parentPhaseId","B52t","branchId","v3td","projectId","j95e","beginDate",parse("2020-11-05 12:30:38"),"endDate",parse("2020-11-05 12:30:38"),"phaseBudgetHours",3548.39,"phaseBudgetStaffNu",6024.62,"ctime",parse("2020-11-05 12:30:38"),"phaseBudgetNouserAt",2868.15,"phaseBudgetInnerUserAt",9081.54,"phaseBudgetOutUserAt",947.44,"phaseBudgetWorkload",7776.59,"taskType","MnCB","planType","dyuS","seqNo","qPqj","phaseBudgetInnerUserWorkload",9748.55,"phaseBudgetOutUserWorkload",4165.76,"phaseBudgetInnerUserPrice",5218.25,"phaseBudgetOutUserPrice",653.52,"phaseBudgetOutUserCnt",9752.9,"phaseBudgetInnerUserCnt",5358.33);
		List<Map<String,Object>> result=baseDao.selectList(XmProjectPhaseTemplate.class.getName()+".selectListMapByKey",p);
		Assert.assertEquals(true, result.size()>=0);
	}
 
	/**
	 * 查询一个对象 XmProjectPhaseTemplate
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","px91");
		
		XmProjectPhaseTemplate xmProjectPhaseTemplate1=BaseUtils.fromMap(p,XmProjectPhaseTemplate.class);
		XmProjectPhaseTemplate xmProjectPhaseTemplate=baseDao.selectOneObject(xmProjectPhaseTemplate1);
		Assert.assertEquals("px91", xmProjectPhaseTemplate.getId());
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
