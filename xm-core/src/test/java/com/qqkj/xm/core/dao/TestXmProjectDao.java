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
import com.qqkj.xm.core.entity.XmProject;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmProjectDao的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_project xm_project<br>
 * 实体 XmProject<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,code,name,xmType,startTime,endTime,urgent,priority,description,createUserid,createUsername,createTime,assess,assessRemarks,status,branchId,planTotalCost,bizProcInstId,bizFlowState,planNouserAt,planInnerUserAt,planOutUserAt,locked,baseTime,baseRemark,baselineId,planWorkload,totalReceivables,budgetMarginRate,contractAmt,planInnerUserPrice,planOutUserPrice,planOutUserCnt,planInnerUserCnt,planWorkingHours,taxRate,planInnerUserWorkload,planOutUserWorkload,fromTplId,budgetCtrl;<br>
 * 当前表的所有字段名:<br>
 *	id,code,name,xm_type,start_time,end_time,urgent,priority,description,create_userid,create_username,create_time,assess,assess_remarks,status,branch_id,plan_total_cost,biz_proc_inst_id,biz_flow_state,plan_nouser_at,plan_inner_user_at,plan_out_user_at,locked,base_time,base_remark,baseline_id,plan_workload,total_receivables,budget_margin_rate,contract_amt,plan_inner_user_price,plan_out_user_price,plan_out_user_cnt,plan_inner_user_cnt,plan_working_hours,tax_rate,plan_inner_user_workload,plan_out_user_workload,from_tpl_id,budget_ctrl;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/
 @RunWith(SpringJUnit4ClassRunner.class)
 @SpringBootTest
public class TestXmProjectDao  {

	@Autowired
	BaseDao baseDao;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","2HW9","code","a893","name","SV0h","xmType","GAee","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","V7wc","priority","w8zx","description","GJO1","createUserid","M171","createUsername","Zzq2","createTime",parse("2020-11-07 22:55:26"),"assess","y7bZ","assessRemarks","T7nC","status","cniI","branchId","z7mF","planTotalCost",3054.34,"bizProcInstId","12fk","bizFlowState","m","planNouserAt",2007,"planInnerUserAt",5068.15,"planOutUserAt",3456.37,"locked","P","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","0LRN","baselineId","7ko4","planWorkload",5663.95,"totalReceivables",3440.08,"budgetMarginRate",7898.8322,"contractAmt",7716.36,"planInnerUserPrice",2520.13,"planOutUserPrice",3947.2,"planOutUserCnt",2129,"planInnerUserCnt",1476,"planWorkingHours",7676,"taxRate",5235.52,"planInnerUserWorkload",4485.83,"planOutUserWorkload",9041.45,"fromTplId","bz0b","budgetCtrl","X");
		XmProject xmProject=BaseUtils.fromMap(p,XmProject.class);
		baseDao.insert(xmProject);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("code","a893","name","SV0h","xmType","GAee","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","V7wc","priority","w8zx","description","GJO1","createUserid","M171","createUsername","Zzq2","createTime",parse("2020-11-07 22:55:26"),"assess","y7bZ","assessRemarks","T7nC","status","cniI","branchId","z7mF","planTotalCost",3054.34,"bizProcInstId","12fk","bizFlowState","m","planNouserAt",2007,"planInnerUserAt",5068.15,"planOutUserAt",3456.37,"locked","P","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","0LRN","baselineId","7ko4","planWorkload",5663.95,"totalReceivables",3440.08,"budgetMarginRate",7898.8322,"contractAmt",7716.36,"planInnerUserPrice",2520.13,"planOutUserPrice",3947.2,"planOutUserCnt",2129,"planInnerUserCnt",1476,"planWorkingHours",7676,"taxRate",5235.52,"planInnerUserWorkload",4485.83,"planOutUserWorkload",9041.45,"fromTplId","bz0b","budgetCtrl","X");
		XmProject xmProject=BaseUtils.fromMap(p,XmProject.class);
		baseDao.deleteByWhere(xmProject);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","2HW9");
		XmProject xmProject=BaseUtils.fromMap(p,XmProject.class);
		baseDao.deleteByPk(xmProject);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("code","a893","name","SV0h","xmType","GAee","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","V7wc","priority","w8zx","description","GJO1","createUserid","M171","createUsername","Zzq2","createTime",parse("2020-11-07 22:55:26"),"assess","y7bZ","assessRemarks","T7nC","status","cniI","branchId","z7mF","planTotalCost",3054.34,"bizProcInstId","12fk","bizFlowState","m","planNouserAt",2007,"planInnerUserAt",5068.15,"planOutUserAt",3456.37,"locked","P","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","0LRN","baselineId","7ko4","planWorkload",5663.95,"totalReceivables",3440.08,"budgetMarginRate",7898.8322,"contractAmt",7716.36,"planInnerUserPrice",2520.13,"planOutUserPrice",3947.2,"planOutUserCnt",2129,"planInnerUserCnt",1476,"planWorkingHours",7676,"taxRate",5235.52,"planInnerUserWorkload",4485.83,"planOutUserWorkload",9041.45,"fromTplId","bz0b","budgetCtrl","X");
		XmProject xmProject=BaseUtils.fromMap(where,XmProject.class);
		baseDao.updateSomeFieldByPk(xmProject);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","2HW9");
		XmProject xmProject=BaseUtils.fromMap(p,XmProject.class);
		baseDao.updateByPk(xmProject);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("id","2HW9","code","a893","name","SV0h","xmType","GAee","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","V7wc","priority","w8zx","description","GJO1","createUserid","M171","createUsername","Zzq2","createTime",parse("2020-11-07 22:55:26"),"assess","y7bZ","assessRemarks","T7nC","status","cniI","branchId","z7mF","planTotalCost",3054.34,"bizProcInstId","12fk","bizFlowState","m","planNouserAt",2007,"planInnerUserAt",5068.15,"planOutUserAt",3456.37,"locked","P","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","0LRN","baselineId","7ko4","planWorkload",5663.95,"totalReceivables",3440.08,"budgetMarginRate",7898.8322,"contractAmt",7716.36,"planInnerUserPrice",2520.13,"planOutUserPrice",3947.2,"planOutUserCnt",2129,"planInnerUserCnt",1476,"planWorkingHours",7676,"taxRate",5235.52,"planInnerUserWorkload",4485.83,"planOutUserWorkload",9041.45,"fromTplId","bz0b","budgetCtrl","X");
		XmProject xmProject=BaseUtils.fromMap(p,XmProject.class);
		baseDao.insertOrUpdate(xmProject);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmProject> batchValues=new ArrayList<XmProject>();
		Map p0=BaseUtils.map("id","2HW9","code","a893","name","SV0h","xmType","GAee","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","V7wc","priority","w8zx","description","GJO1","createUserid","M171","createUsername","Zzq2","createTime",parse("2020-11-07 22:55:26"),"assess","y7bZ","assessRemarks","T7nC","status","cniI","branchId","z7mF","planTotalCost",3054.34,"bizProcInstId","12fk","bizFlowState","m","planNouserAt",2007,"planInnerUserAt",5068.15,"planOutUserAt",3456.37,"locked","P","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","0LRN","baselineId","7ko4","planWorkload",5663.95,"totalReceivables",3440.08,"budgetMarginRate",7898.8322,"contractAmt",7716.36,"planInnerUserPrice",2520.13,"planOutUserPrice",3947.2,"planOutUserCnt",2129,"planInnerUserCnt",1476,"planWorkingHours",7676,"taxRate",5235.52,"planInnerUserWorkload",4485.83,"planOutUserWorkload",9041.45,"fromTplId","bz0b","budgetCtrl","X");
		XmProject xmProject0=BaseUtils.fromMap(p0,XmProject.class);
		batchValues.add(xmProject0);
		Map p1=BaseUtils.map("id","CDBP","code","sBJw","name","urs4","xmType","NEJT","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","Qabc","priority","1B9a","description","6FTV","createUserid","LKM4","createUsername","AzXA","createTime",parse("2020-11-07 22:55:26"),"assess","U46T","assessRemarks","2Pu9","status","1GZ5","branchId","hmcZ","planTotalCost",4433.62,"bizProcInstId","9Luc","bizFlowState","l","planNouserAt",9648.47,"planInnerUserAt",944.85,"planOutUserAt",493.81,"locked","9","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","GWwv","baselineId","S8Z7","planWorkload",8431.47,"totalReceivables",9009.92,"budgetMarginRate",9918.3716,"contractAmt",6129.6,"planInnerUserPrice",6689.94,"planOutUserPrice",8080.99,"planOutUserCnt",9589,"planInnerUserCnt",254,"planWorkingHours",9790,"taxRate",9841.29,"planInnerUserWorkload",6500.17,"planOutUserWorkload",2446.13,"fromTplId","H8cF","budgetCtrl","k");
		XmProject xmProject1=BaseUtils.fromMap(p1,XmProject.class);
		batchValues.add(xmProject1);
		Map p2=BaseUtils.map("id","32qi","code","CW9A","name","9D3o","xmType","3wfw","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","6h6n","priority","RBdh","description","LC8A","createUserid","hF4B","createUsername","9i00","createTime",parse("2020-11-07 22:55:26"),"assess","FNk7","assessRemarks","SIWT","status","xL6l","branchId","n9lO","planTotalCost",4077.53,"bizProcInstId","zmyL","bizFlowState","x","planNouserAt",4969.77,"planInnerUserAt",7177.97,"planOutUserAt",1283.84,"locked","h","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","88bR","baselineId","hhxP","planWorkload",8675.63,"totalReceivables",5026.53,"budgetMarginRate",3013.5722,"contractAmt",7177.64,"planInnerUserPrice",2419.44,"planOutUserPrice",3279.61,"planOutUserCnt",2573,"planInnerUserCnt",529,"planWorkingHours",3883,"taxRate",7899.06,"planInnerUserWorkload",5781.46,"planOutUserWorkload",1361.72,"fromTplId","XuO2","budgetCtrl","N");
		XmProject xmProject2=BaseUtils.fromMap(p2,XmProject.class);
		batchValues.add(xmProject2);
		Map p3=BaseUtils.map("id","f8y4","code","hA63","name","Uijo","xmType","H69O","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","crjR","priority","7WXu","description","3Ot3","createUserid","2w9y","createUsername","2Jah","createTime",parse("2020-11-07 22:55:26"),"assess","0RgN","assessRemarks","YeOH","status","6454","branchId","91J3","planTotalCost",7876.94,"bizProcInstId","JvF4","bizFlowState","r","planNouserAt",617.49,"planInnerUserAt",8969,"planOutUserAt",3709.24,"locked","2","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","zMVY","baselineId","LpE2","planWorkload",4859.51,"totalReceivables",7460.48,"budgetMarginRate",1328.4639,"contractAmt",1703.97,"planInnerUserPrice",361.02,"planOutUserPrice",6614.87,"planOutUserCnt",1217,"planInnerUserCnt",5044,"planWorkingHours",7674,"taxRate",2039.46,"planInnerUserWorkload",257.69,"planOutUserWorkload",5287.01,"fromTplId","Mdez","budgetCtrl","j");
		XmProject xmProject3=BaseUtils.fromMap(p3,XmProject.class);
		batchValues.add(xmProject3);
		Map p4=BaseUtils.map("id","Ud6j","code","chaJ","name","3kjD","xmType","4Tx2","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","Aa3X","priority","L8Z3","description","X12k","createUserid","FnPd","createUsername","Y566","createTime",parse("2020-11-07 22:55:26"),"assess","1tk0","assessRemarks","0E0g","status","JQ4G","branchId","1q4F","planTotalCost",2660.32,"bizProcInstId","912o","bizFlowState","8","planNouserAt",3606.26,"planInnerUserAt",505.5,"planOutUserAt",4045.93,"locked","d","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","ZF9H","baselineId","gT5A","planWorkload",2570.69,"totalReceivables",4922.79,"budgetMarginRate",3232.9137,"contractAmt",5632.07,"planInnerUserPrice",7894.67,"planOutUserPrice",4470.93,"planOutUserCnt",3949,"planInnerUserCnt",4418,"planWorkingHours",5054,"taxRate",1423.31,"planInnerUserWorkload",2691.66,"planOutUserWorkload",2314.45,"fromTplId","rHNG","budgetCtrl","0");
		XmProject xmProject4=BaseUtils.fromMap(p4,XmProject.class);
		batchValues.add(xmProject4);
		Map p5=BaseUtils.map("id","lduS","code","9F0j","name","ud5I","xmType","Ehzx","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","Mro9","priority","fQHo","description","88LR","createUserid","4b8R","createUsername","o6fS","createTime",parse("2020-11-07 22:55:26"),"assess","1NRN","assessRemarks","ETjB","status","24pu","branchId","3D3o","planTotalCost",725.41,"bizProcInstId","dr8U","bizFlowState","l","planNouserAt",8341.04,"planInnerUserAt",5143.63,"planOutUserAt",7877.6,"locked","T","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","Frhr","baselineId","DSoM","planWorkload",5382.89,"totalReceivables",9603.22,"budgetMarginRate",4894.8634,"contractAmt",5170.13,"planInnerUserPrice",5644.77,"planOutUserPrice",6418.57,"planOutUserCnt",1108,"planInnerUserCnt",1823,"planWorkingHours",8468,"taxRate",9692.13,"planInnerUserWorkload",6978.01,"planOutUserWorkload",1692.08,"fromTplId","i5a1","budgetCtrl","Z");
		XmProject xmProject5=BaseUtils.fromMap(p5,XmProject.class);
		batchValues.add(xmProject5);
		Map p6=BaseUtils.map("id","cces","code","8ORU","name","2D7D","xmType","4lBf","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","9fff","priority","Ibx5","description","1cJz","createUserid","9RVC","createUsername","Gu53","createTime",parse("2020-11-07 22:55:26"),"assess","iIZ1","assessRemarks","ZO96","status","Ip8W","branchId","GdZM","planTotalCost",1496.27,"bizProcInstId","u78C","bizFlowState","u","planNouserAt",4196.01,"planInnerUserAt",6462.68,"planOutUserAt",8543.71,"locked","a","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","c1Qj","baselineId","v11P","planWorkload",4809.79,"totalReceivables",583.34,"budgetMarginRate",5942.0862,"contractAmt",6023.35,"planInnerUserPrice",4899.52,"planOutUserPrice",4938.53,"planOutUserCnt",5950,"planInnerUserCnt",8410,"planWorkingHours",2691,"taxRate",9621.75,"planInnerUserWorkload",1625.37,"planOutUserWorkload",572.31,"fromTplId","55Wb","budgetCtrl","J");
		XmProject xmProject6=BaseUtils.fromMap(p6,XmProject.class);
		batchValues.add(xmProject6);
		Map p7=BaseUtils.map("id","HzVW","code","31CC","name","o8Un","xmType","qA7R","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","3Z54","priority","Z5rB","description","hap3","createUserid","r2P7","createUsername","eN1A","createTime",parse("2020-11-07 22:55:26"),"assess","048V","assessRemarks","Oe2N","status","BmPr","branchId","t80J","planTotalCost",9971.29,"bizProcInstId","Sg43","bizFlowState","K","planNouserAt",5779.9,"planInnerUserAt",3881.32,"planOutUserAt",5727.18,"locked","G","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","0Gat","baselineId","KGbC","planWorkload",3707.02,"totalReceivables",4040.79,"budgetMarginRate",8020.6741,"contractAmt",835.83,"planInnerUserPrice",984.9,"planOutUserPrice",6010.48,"planOutUserCnt",2671,"planInnerUserCnt",8919,"planWorkingHours",4411,"taxRate",9949.19,"planInnerUserWorkload",181.51,"planOutUserWorkload",1598.13,"fromTplId","Tel6","budgetCtrl","7");
		XmProject xmProject7=BaseUtils.fromMap(p7,XmProject.class);
		batchValues.add(xmProject7);
		baseDao.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmProject> batchValues=new ArrayList<XmProject>();
		Map p0=BaseUtils.map("id","2HW9","code","a893","name","SV0h","xmType","GAee","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","V7wc","priority","w8zx","description","GJO1","createUserid","M171","createUsername","Zzq2","createTime",parse("2020-11-07 22:55:26"),"assess","y7bZ","assessRemarks","T7nC","status","cniI","branchId","z7mF","planTotalCost",3054.34,"bizProcInstId","12fk","bizFlowState","m","planNouserAt",2007,"planInnerUserAt",5068.15,"planOutUserAt",3456.37,"locked","P","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","0LRN","baselineId","7ko4","planWorkload",5663.95,"totalReceivables",3440.08,"budgetMarginRate",7898.8322,"contractAmt",7716.36,"planInnerUserPrice",2520.13,"planOutUserPrice",3947.2,"planOutUserCnt",2129,"planInnerUserCnt",1476,"planWorkingHours",7676,"taxRate",5235.52,"planInnerUserWorkload",4485.83,"planOutUserWorkload",9041.45,"fromTplId","bz0b","budgetCtrl","X");
		XmProject xmProject0=BaseUtils.fromMap(p0,XmProject.class);
		batchValues.add(xmProject0);
		Map p1=BaseUtils.map("id","CDBP","code","sBJw","name","urs4","xmType","NEJT","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","Qabc","priority","1B9a","description","6FTV","createUserid","LKM4","createUsername","AzXA","createTime",parse("2020-11-07 22:55:26"),"assess","U46T","assessRemarks","2Pu9","status","1GZ5","branchId","hmcZ","planTotalCost",4433.62,"bizProcInstId","9Luc","bizFlowState","l","planNouserAt",9648.47,"planInnerUserAt",944.85,"planOutUserAt",493.81,"locked","9","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","GWwv","baselineId","S8Z7","planWorkload",8431.47,"totalReceivables",9009.92,"budgetMarginRate",9918.3716,"contractAmt",6129.6,"planInnerUserPrice",6689.94,"planOutUserPrice",8080.99,"planOutUserCnt",9589,"planInnerUserCnt",254,"planWorkingHours",9790,"taxRate",9841.29,"planInnerUserWorkload",6500.17,"planOutUserWorkload",2446.13,"fromTplId","H8cF","budgetCtrl","k");
		XmProject xmProject1=BaseUtils.fromMap(p1,XmProject.class);
		batchValues.add(xmProject1);
		Map p2=BaseUtils.map("id","32qi","code","CW9A","name","9D3o","xmType","3wfw","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","6h6n","priority","RBdh","description","LC8A","createUserid","hF4B","createUsername","9i00","createTime",parse("2020-11-07 22:55:26"),"assess","FNk7","assessRemarks","SIWT","status","xL6l","branchId","n9lO","planTotalCost",4077.53,"bizProcInstId","zmyL","bizFlowState","x","planNouserAt",4969.77,"planInnerUserAt",7177.97,"planOutUserAt",1283.84,"locked","h","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","88bR","baselineId","hhxP","planWorkload",8675.63,"totalReceivables",5026.53,"budgetMarginRate",3013.5722,"contractAmt",7177.64,"planInnerUserPrice",2419.44,"planOutUserPrice",3279.61,"planOutUserCnt",2573,"planInnerUserCnt",529,"planWorkingHours",3883,"taxRate",7899.06,"planInnerUserWorkload",5781.46,"planOutUserWorkload",1361.72,"fromTplId","XuO2","budgetCtrl","N");
		XmProject xmProject2=BaseUtils.fromMap(p2,XmProject.class);
		batchValues.add(xmProject2);
		Map p3=BaseUtils.map("id","f8y4","code","hA63","name","Uijo","xmType","H69O","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","crjR","priority","7WXu","description","3Ot3","createUserid","2w9y","createUsername","2Jah","createTime",parse("2020-11-07 22:55:26"),"assess","0RgN","assessRemarks","YeOH","status","6454","branchId","91J3","planTotalCost",7876.94,"bizProcInstId","JvF4","bizFlowState","r","planNouserAt",617.49,"planInnerUserAt",8969,"planOutUserAt",3709.24,"locked","2","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","zMVY","baselineId","LpE2","planWorkload",4859.51,"totalReceivables",7460.48,"budgetMarginRate",1328.4639,"contractAmt",1703.97,"planInnerUserPrice",361.02,"planOutUserPrice",6614.87,"planOutUserCnt",1217,"planInnerUserCnt",5044,"planWorkingHours",7674,"taxRate",2039.46,"planInnerUserWorkload",257.69,"planOutUserWorkload",5287.01,"fromTplId","Mdez","budgetCtrl","j");
		XmProject xmProject3=BaseUtils.fromMap(p3,XmProject.class);
		batchValues.add(xmProject3);
		Map p4=BaseUtils.map("id","Ud6j","code","chaJ","name","3kjD","xmType","4Tx2","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","Aa3X","priority","L8Z3","description","X12k","createUserid","FnPd","createUsername","Y566","createTime",parse("2020-11-07 22:55:26"),"assess","1tk0","assessRemarks","0E0g","status","JQ4G","branchId","1q4F","planTotalCost",2660.32,"bizProcInstId","912o","bizFlowState","8","planNouserAt",3606.26,"planInnerUserAt",505.5,"planOutUserAt",4045.93,"locked","d","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","ZF9H","baselineId","gT5A","planWorkload",2570.69,"totalReceivables",4922.79,"budgetMarginRate",3232.9137,"contractAmt",5632.07,"planInnerUserPrice",7894.67,"planOutUserPrice",4470.93,"planOutUserCnt",3949,"planInnerUserCnt",4418,"planWorkingHours",5054,"taxRate",1423.31,"planInnerUserWorkload",2691.66,"planOutUserWorkload",2314.45,"fromTplId","rHNG","budgetCtrl","0");
		XmProject xmProject4=BaseUtils.fromMap(p4,XmProject.class);
		batchValues.add(xmProject4);
		Map p5=BaseUtils.map("id","lduS","code","9F0j","name","ud5I","xmType","Ehzx","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","Mro9","priority","fQHo","description","88LR","createUserid","4b8R","createUsername","o6fS","createTime",parse("2020-11-07 22:55:26"),"assess","1NRN","assessRemarks","ETjB","status","24pu","branchId","3D3o","planTotalCost",725.41,"bizProcInstId","dr8U","bizFlowState","l","planNouserAt",8341.04,"planInnerUserAt",5143.63,"planOutUserAt",7877.6,"locked","T","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","Frhr","baselineId","DSoM","planWorkload",5382.89,"totalReceivables",9603.22,"budgetMarginRate",4894.8634,"contractAmt",5170.13,"planInnerUserPrice",5644.77,"planOutUserPrice",6418.57,"planOutUserCnt",1108,"planInnerUserCnt",1823,"planWorkingHours",8468,"taxRate",9692.13,"planInnerUserWorkload",6978.01,"planOutUserWorkload",1692.08,"fromTplId","i5a1","budgetCtrl","Z");
		XmProject xmProject5=BaseUtils.fromMap(p5,XmProject.class);
		batchValues.add(xmProject5);
		Map p6=BaseUtils.map("id","cces","code","8ORU","name","2D7D","xmType","4lBf","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","9fff","priority","Ibx5","description","1cJz","createUserid","9RVC","createUsername","Gu53","createTime",parse("2020-11-07 22:55:26"),"assess","iIZ1","assessRemarks","ZO96","status","Ip8W","branchId","GdZM","planTotalCost",1496.27,"bizProcInstId","u78C","bizFlowState","u","planNouserAt",4196.01,"planInnerUserAt",6462.68,"planOutUserAt",8543.71,"locked","a","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","c1Qj","baselineId","v11P","planWorkload",4809.79,"totalReceivables",583.34,"budgetMarginRate",5942.0862,"contractAmt",6023.35,"planInnerUserPrice",4899.52,"planOutUserPrice",4938.53,"planOutUserCnt",5950,"planInnerUserCnt",8410,"planWorkingHours",2691,"taxRate",9621.75,"planInnerUserWorkload",1625.37,"planOutUserWorkload",572.31,"fromTplId","55Wb","budgetCtrl","J");
		XmProject xmProject6=BaseUtils.fromMap(p6,XmProject.class);
		batchValues.add(xmProject6);
		Map p7=BaseUtils.map("id","HzVW","code","31CC","name","o8Un","xmType","qA7R","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","3Z54","priority","Z5rB","description","hap3","createUserid","r2P7","createUsername","eN1A","createTime",parse("2020-11-07 22:55:26"),"assess","048V","assessRemarks","Oe2N","status","BmPr","branchId","t80J","planTotalCost",9971.29,"bizProcInstId","Sg43","bizFlowState","K","planNouserAt",5779.9,"planInnerUserAt",3881.32,"planOutUserAt",5727.18,"locked","G","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","0Gat","baselineId","KGbC","planWorkload",3707.02,"totalReceivables",4040.79,"budgetMarginRate",8020.6741,"contractAmt",835.83,"planInnerUserPrice",984.9,"planOutUserPrice",6010.48,"planOutUserCnt",2671,"planInnerUserCnt",8919,"planWorkingHours",4411,"taxRate",9949.19,"planInnerUserWorkload",181.51,"planOutUserWorkload",1598.13,"fromTplId","Tel6","budgetCtrl","7");
		XmProject xmProject7=BaseUtils.fromMap(p7,XmProject.class);
		batchValues.add(xmProject7);
		baseDao.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmProject> batchValues=new ArrayList<XmProject>();
		Map p0=BaseUtils.map("id","2HW9","code","a893","name","SV0h","xmType","GAee","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","V7wc","priority","w8zx","description","GJO1","createUserid","M171","createUsername","Zzq2","createTime",parse("2020-11-07 22:55:26"),"assess","y7bZ","assessRemarks","T7nC","status","cniI","branchId","z7mF","planTotalCost",3054.34,"bizProcInstId","12fk","bizFlowState","m","planNouserAt",2007,"planInnerUserAt",5068.15,"planOutUserAt",3456.37,"locked","P","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","0LRN","baselineId","7ko4","planWorkload",5663.95,"totalReceivables",3440.08,"budgetMarginRate",7898.8322,"contractAmt",7716.36,"planInnerUserPrice",2520.13,"planOutUserPrice",3947.2,"planOutUserCnt",2129,"planInnerUserCnt",1476,"planWorkingHours",7676,"taxRate",5235.52,"planInnerUserWorkload",4485.83,"planOutUserWorkload",9041.45,"fromTplId","bz0b","budgetCtrl","X");
		XmProject xmProject0=BaseUtils.fromMap(p0,XmProject.class);
		batchValues.add(xmProject0);
		Map p1=BaseUtils.map("id","CDBP","code","sBJw","name","urs4","xmType","NEJT","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","Qabc","priority","1B9a","description","6FTV","createUserid","LKM4","createUsername","AzXA","createTime",parse("2020-11-07 22:55:26"),"assess","U46T","assessRemarks","2Pu9","status","1GZ5","branchId","hmcZ","planTotalCost",4433.62,"bizProcInstId","9Luc","bizFlowState","l","planNouserAt",9648.47,"planInnerUserAt",944.85,"planOutUserAt",493.81,"locked","9","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","GWwv","baselineId","S8Z7","planWorkload",8431.47,"totalReceivables",9009.92,"budgetMarginRate",9918.3716,"contractAmt",6129.6,"planInnerUserPrice",6689.94,"planOutUserPrice",8080.99,"planOutUserCnt",9589,"planInnerUserCnt",254,"planWorkingHours",9790,"taxRate",9841.29,"planInnerUserWorkload",6500.17,"planOutUserWorkload",2446.13,"fromTplId","H8cF","budgetCtrl","k");
		XmProject xmProject1=BaseUtils.fromMap(p1,XmProject.class);
		batchValues.add(xmProject1);
		Map p2=BaseUtils.map("id","32qi","code","CW9A","name","9D3o","xmType","3wfw","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","6h6n","priority","RBdh","description","LC8A","createUserid","hF4B","createUsername","9i00","createTime",parse("2020-11-07 22:55:26"),"assess","FNk7","assessRemarks","SIWT","status","xL6l","branchId","n9lO","planTotalCost",4077.53,"bizProcInstId","zmyL","bizFlowState","x","planNouserAt",4969.77,"planInnerUserAt",7177.97,"planOutUserAt",1283.84,"locked","h","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","88bR","baselineId","hhxP","planWorkload",8675.63,"totalReceivables",5026.53,"budgetMarginRate",3013.5722,"contractAmt",7177.64,"planInnerUserPrice",2419.44,"planOutUserPrice",3279.61,"planOutUserCnt",2573,"planInnerUserCnt",529,"planWorkingHours",3883,"taxRate",7899.06,"planInnerUserWorkload",5781.46,"planOutUserWorkload",1361.72,"fromTplId","XuO2","budgetCtrl","N");
		XmProject xmProject2=BaseUtils.fromMap(p2,XmProject.class);
		batchValues.add(xmProject2);
		Map p3=BaseUtils.map("id","f8y4","code","hA63","name","Uijo","xmType","H69O","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","crjR","priority","7WXu","description","3Ot3","createUserid","2w9y","createUsername","2Jah","createTime",parse("2020-11-07 22:55:26"),"assess","0RgN","assessRemarks","YeOH","status","6454","branchId","91J3","planTotalCost",7876.94,"bizProcInstId","JvF4","bizFlowState","r","planNouserAt",617.49,"planInnerUserAt",8969,"planOutUserAt",3709.24,"locked","2","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","zMVY","baselineId","LpE2","planWorkload",4859.51,"totalReceivables",7460.48,"budgetMarginRate",1328.4639,"contractAmt",1703.97,"planInnerUserPrice",361.02,"planOutUserPrice",6614.87,"planOutUserCnt",1217,"planInnerUserCnt",5044,"planWorkingHours",7674,"taxRate",2039.46,"planInnerUserWorkload",257.69,"planOutUserWorkload",5287.01,"fromTplId","Mdez","budgetCtrl","j");
		XmProject xmProject3=BaseUtils.fromMap(p3,XmProject.class);
		batchValues.add(xmProject3);
		Map p4=BaseUtils.map("id","Ud6j","code","chaJ","name","3kjD","xmType","4Tx2","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","Aa3X","priority","L8Z3","description","X12k","createUserid","FnPd","createUsername","Y566","createTime",parse("2020-11-07 22:55:26"),"assess","1tk0","assessRemarks","0E0g","status","JQ4G","branchId","1q4F","planTotalCost",2660.32,"bizProcInstId","912o","bizFlowState","8","planNouserAt",3606.26,"planInnerUserAt",505.5,"planOutUserAt",4045.93,"locked","d","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","ZF9H","baselineId","gT5A","planWorkload",2570.69,"totalReceivables",4922.79,"budgetMarginRate",3232.9137,"contractAmt",5632.07,"planInnerUserPrice",7894.67,"planOutUserPrice",4470.93,"planOutUserCnt",3949,"planInnerUserCnt",4418,"planWorkingHours",5054,"taxRate",1423.31,"planInnerUserWorkload",2691.66,"planOutUserWorkload",2314.45,"fromTplId","rHNG","budgetCtrl","0");
		XmProject xmProject4=BaseUtils.fromMap(p4,XmProject.class);
		batchValues.add(xmProject4);
		Map p5=BaseUtils.map("id","lduS","code","9F0j","name","ud5I","xmType","Ehzx","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","Mro9","priority","fQHo","description","88LR","createUserid","4b8R","createUsername","o6fS","createTime",parse("2020-11-07 22:55:26"),"assess","1NRN","assessRemarks","ETjB","status","24pu","branchId","3D3o","planTotalCost",725.41,"bizProcInstId","dr8U","bizFlowState","l","planNouserAt",8341.04,"planInnerUserAt",5143.63,"planOutUserAt",7877.6,"locked","T","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","Frhr","baselineId","DSoM","planWorkload",5382.89,"totalReceivables",9603.22,"budgetMarginRate",4894.8634,"contractAmt",5170.13,"planInnerUserPrice",5644.77,"planOutUserPrice",6418.57,"planOutUserCnt",1108,"planInnerUserCnt",1823,"planWorkingHours",8468,"taxRate",9692.13,"planInnerUserWorkload",6978.01,"planOutUserWorkload",1692.08,"fromTplId","i5a1","budgetCtrl","Z");
		XmProject xmProject5=BaseUtils.fromMap(p5,XmProject.class);
		batchValues.add(xmProject5);
		Map p6=BaseUtils.map("id","cces","code","8ORU","name","2D7D","xmType","4lBf","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","9fff","priority","Ibx5","description","1cJz","createUserid","9RVC","createUsername","Gu53","createTime",parse("2020-11-07 22:55:26"),"assess","iIZ1","assessRemarks","ZO96","status","Ip8W","branchId","GdZM","planTotalCost",1496.27,"bizProcInstId","u78C","bizFlowState","u","planNouserAt",4196.01,"planInnerUserAt",6462.68,"planOutUserAt",8543.71,"locked","a","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","c1Qj","baselineId","v11P","planWorkload",4809.79,"totalReceivables",583.34,"budgetMarginRate",5942.0862,"contractAmt",6023.35,"planInnerUserPrice",4899.52,"planOutUserPrice",4938.53,"planOutUserCnt",5950,"planInnerUserCnt",8410,"planWorkingHours",2691,"taxRate",9621.75,"planInnerUserWorkload",1625.37,"planOutUserWorkload",572.31,"fromTplId","55Wb","budgetCtrl","J");
		XmProject xmProject6=BaseUtils.fromMap(p6,XmProject.class);
		batchValues.add(xmProject6);
		Map p7=BaseUtils.map("id","HzVW","code","31CC","name","o8Un","xmType","qA7R","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","3Z54","priority","Z5rB","description","hap3","createUserid","r2P7","createUsername","eN1A","createTime",parse("2020-11-07 22:55:26"),"assess","048V","assessRemarks","Oe2N","status","BmPr","branchId","t80J","planTotalCost",9971.29,"bizProcInstId","Sg43","bizFlowState","K","planNouserAt",5779.9,"planInnerUserAt",3881.32,"planOutUserAt",5727.18,"locked","G","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","0Gat","baselineId","KGbC","planWorkload",3707.02,"totalReceivables",4040.79,"budgetMarginRate",8020.6741,"contractAmt",835.83,"planInnerUserPrice",984.9,"planOutUserPrice",6010.48,"planOutUserCnt",2671,"planInnerUserCnt",8919,"planWorkingHours",4411,"taxRate",9949.19,"planInnerUserWorkload",181.51,"planOutUserWorkload",1598.13,"fromTplId","Tel6","budgetCtrl","7");
		XmProject xmProject7=BaseUtils.fromMap(p7,XmProject.class);
		batchValues.add(xmProject7);
		baseDao.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","2HW9");
		Map<String,Object> result=this.baseDao.selectOne(XmProject.class.getName()+".selectOneMap",p);
		Assert.assertEquals("2HW9", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("code","a893","name","SV0h","xmType","GAee","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","V7wc","priority","w8zx","description","GJO1","createUserid","M171","createUsername","Zzq2","createTime",parse("2020-11-07 22:55:26"),"assess","y7bZ","assessRemarks","T7nC","status","cniI","branchId","z7mF","planTotalCost",3054.34,"bizProcInstId","12fk","bizFlowState","m","planNouserAt",2007,"planInnerUserAt",5068.15,"planOutUserAt",3456.37,"locked","P","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","0LRN","baselineId","7ko4","planWorkload",5663.95,"totalReceivables",3440.08,"budgetMarginRate",7898.8322,"contractAmt",7716.36,"planInnerUserPrice",2520.13,"planOutUserPrice",3947.2,"planOutUserCnt",2129,"planInnerUserCnt",1476,"planWorkingHours",7676,"taxRate",5235.52,"planInnerUserWorkload",4485.83,"planOutUserWorkload",9041.45,"fromTplId","bz0b","budgetCtrl","X");
		XmProject xmProject=BaseUtils.fromMap(p,XmProject.class);
		long result=baseDao.countByWhere(xmProject);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
 		
		
		Map<String,Object> p=BaseUtils.map("code","a893","name","SV0h","xmType","GAee","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","V7wc","priority","w8zx","description","GJO1","createUserid","M171","createUsername","Zzq2","createTime",parse("2020-11-07 22:55:26"),"assess","y7bZ","assessRemarks","T7nC","status","cniI","branchId","z7mF","planTotalCost",3054.34,"bizProcInstId","12fk","bizFlowState","m","planNouserAt",2007,"planInnerUserAt",5068.15,"planOutUserAt",3456.37,"locked","P","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","0LRN","baselineId","7ko4","planWorkload",5663.95,"totalReceivables",3440.08,"budgetMarginRate",7898.8322,"contractAmt",7716.36,"planInnerUserPrice",2520.13,"planOutUserPrice",3947.2,"planOutUserCnt",2129,"planInnerUserCnt",1476,"planWorkingHours",7676,"taxRate",5235.52,"planInnerUserWorkload",4485.83,"planOutUserWorkload",9041.45,"fromTplId","bz0b","budgetCtrl","X");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmProject xmProject=BaseUtils.fromMap(p,XmProject.class);
		List<XmProject> result=baseDao.selectListByWhere(xmProject); 
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
	
		
		Map<String,Object> p=BaseUtils.map("code","a893","name","SV0h","xmType","GAee","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","V7wc","priority","w8zx","description","GJO1","createUserid","M171","createUsername","Zzq2","createTime",parse("2020-11-07 22:55:26"),"assess","y7bZ","assessRemarks","T7nC","status","cniI","branchId","z7mF","planTotalCost",3054.34,"bizProcInstId","12fk","bizFlowState","m","planNouserAt",2007,"planInnerUserAt",5068.15,"planOutUserAt",3456.37,"locked","P","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","0LRN","baselineId","7ko4","planWorkload",5663.95,"totalReceivables",3440.08,"budgetMarginRate",7898.8322,"contractAmt",7716.36,"planInnerUserPrice",2520.13,"planOutUserPrice",3947.2,"planOutUserCnt",2129,"planInnerUserCnt",1476,"planWorkingHours",7676,"taxRate",5235.52,"planInnerUserWorkload",4485.83,"planOutUserWorkload",9041.45,"fromTplId","bz0b","budgetCtrl","X");
		XmProject xmProject=BaseUtils.fromMap(p,XmProject.class);
		List<XmProject> result=baseDao.selectListByWhere(xmProject);
		Assert.assertEquals(true, result.size()>=1);
	}

	
	/**
	 * 查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("code","a893","name","SV0h","xmType","GAee","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","V7wc","priority","w8zx","description","GJO1","createUserid","M171","createUsername","Zzq2","createTime",parse("2020-11-07 22:55:26"),"assess","y7bZ","assessRemarks","T7nC","status","cniI","branchId","z7mF","planTotalCost",3054.34,"bizProcInstId","12fk","bizFlowState","m","planNouserAt",2007,"planInnerUserAt",5068.15,"planOutUserAt",3456.37,"locked","P","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","0LRN","baselineId","7ko4","planWorkload",5663.95,"totalReceivables",3440.08,"budgetMarginRate",7898.8322,"contractAmt",7716.36,"planInnerUserPrice",2520.13,"planOutUserPrice",3947.2,"planOutUserCnt",2129,"planInnerUserCnt",1476,"planWorkingHours",7676,"taxRate",5235.52,"planInnerUserWorkload",4485.83,"planOutUserWorkload",9041.45,"fromTplId","bz0b","budgetCtrl","X");
		List<Map<String,Object>> result=baseDao.selectList(XmProject.class.getName()+".selectListMapByWhere",p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("code","a893","name","SV0h","xmType","GAee","startTime",parse("2020-11-07 22:55:26"),"endTime",parse("2020-11-07 22:55:26"),"urgent","V7wc","priority","w8zx","description","GJO1","createUserid","M171","createUsername","Zzq2","createTime",parse("2020-11-07 22:55:26"),"assess","y7bZ","assessRemarks","T7nC","status","cniI","branchId","z7mF","planTotalCost",3054.34,"bizProcInstId","12fk","bizFlowState","m","planNouserAt",2007,"planInnerUserAt",5068.15,"planOutUserAt",3456.37,"locked","P","baseTime",parse("2020-11-07 22:55:26"),"baseRemark","0LRN","baselineId","7ko4","planWorkload",5663.95,"totalReceivables",3440.08,"budgetMarginRate",7898.8322,"contractAmt",7716.36,"planInnerUserPrice",2520.13,"planOutUserPrice",3947.2,"planOutUserCnt",2129,"planInnerUserCnt",1476,"planWorkingHours",7676,"taxRate",5235.52,"planInnerUserWorkload",4485.83,"planOutUserWorkload",9041.45,"fromTplId","bz0b","budgetCtrl","X");
		List<Map<String,Object>> result=baseDao.selectList(XmProject.class.getName()+".selectListMapByKey",p);
		Assert.assertEquals(true, result.size()>=0);
	}
 
	/**
	 * 查询一个对象 XmProject
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","2HW9");
		
		XmProject xmProject1=BaseUtils.fromMap(p,XmProject.class);
		XmProject xmProject=baseDao.selectOneObject(xmProject1);
		Assert.assertEquals("2HW9", xmProject.getId());
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
