package com.xm.core.dao;

import java.util.*;
import java.text.SimpleDateFormat;

import com.xm.core.entity.XmProjectTemplate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.mdp.core.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired; 
import com.mdp.core.dao.BaseDao;

import com.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmProjectTemplateDao的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_project_template xm_project_template<br>
 * 实体 XmProjectTemplate<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,code,name,xmType,startTime,endTime,urgent,priority,description,createUserid,createUsername,createTime,assess,assessRemarks,status,branchId,planTotalCost,bizProcInstId,bizFlowState,planNouserAt,planInnerUserAt,planOutUserAt,locked,baseTime,baseRemark,baselineId,planWorkload,totalReceivables,budgetMarginRate,contractAmt,planInnerUserPrice,planOutUserPrice,planOutUserCnt,planInnerUserCnt,planWorkingHours,taxRate,planInnerUserWorkload,planOutUserWorkload,productId,productName,templateId,tcuserid,tcusername,tremark,tctime,tcbranchId,shareScope;<br>
 * 当前表的所有字段名:<br>
 *	id,code,name,xm_type,start_time,end_time,urgent,priority,description,create_userid,create_username,create_time,assess,assess_remarks,status,branch_id,plan_total_cost,biz_proc_inst_id,biz_flow_state,plan_nouser_at,plan_inner_user_at,plan_out_user_at,locked,base_time,base_remark,baseline_id,plan_workload,total_receivables,budget_margin_rate,contract_amt,plan_inner_user_price,plan_out_user_price,plan_out_user_cnt,plan_inner_user_cnt,plan_working_hours,tax_rate,plan_inner_user_workload,plan_out_user_workload,product_id,product_name,template_id,tcuserid,tcusername,tremark,tctime,tcbranch_id,share_scope;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/
 @RunWith(SpringJUnit4ClassRunner.class)
 @SpringBootTest
public class TestXmProjectTemplateDao  {

	@Autowired
	BaseDao baseDao;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","nKcH","code","9h2e","name","2LSI","xmType","0odU","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","djav","priority","K97L","description","VrxN","createUserid","Sb8X","createUsername","T8mf","createTime",parse("2020-11-02 21:15:1"),"assess","qDwX","assessRemarks","Y1HH","status","Z34x","branchId","24m0","planTotalCost",6555.25,"bizProcInstId","VeW9","bizFlowState","9","planNouserAt",2140.46,"planInnerUserAt",934.12,"planOutUserAt",8488.98,"locked","3","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","jsLa","baselineId","IlU8","planWorkload",2853.96,"totalReceivables",2358.89,"budgetMarginRate",2168.6643,"contractAmt",9010.66,"planInnerUserPrice",2912.83,"planOutUserPrice",9664.67,"planOutUserCnt",7257,"planInnerUserCnt",8108,"planWorkingHours",5108,"taxRate",3658.61,"planInnerUserWorkload",5254.45,"planOutUserWorkload",760.81,"productId","U5Nm","productName","27si","templateId","Sn7a","tcuserid","nEn0","tcusername","x092","tremark","U0fg","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","EsLo","shareScope","kbGz");
		XmProjectTemplate xmProjectTemplate=BaseUtils.fromMap(p,XmProjectTemplate.class);
		baseDao.insert(xmProjectTemplate);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("code","9h2e","name","2LSI","xmType","0odU","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","djav","priority","K97L","description","VrxN","createUserid","Sb8X","createUsername","T8mf","createTime",parse("2020-11-02 21:15:1"),"assess","qDwX","assessRemarks","Y1HH","status","Z34x","branchId","24m0","planTotalCost",6555.25,"bizProcInstId","VeW9","bizFlowState","9","planNouserAt",2140.46,"planInnerUserAt",934.12,"planOutUserAt",8488.98,"locked","3","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","jsLa","baselineId","IlU8","planWorkload",2853.96,"totalReceivables",2358.89,"budgetMarginRate",2168.6643,"contractAmt",9010.66,"planInnerUserPrice",2912.83,"planOutUserPrice",9664.67,"planOutUserCnt",7257,"planInnerUserCnt",8108,"planWorkingHours",5108,"taxRate",3658.61,"planInnerUserWorkload",5254.45,"planOutUserWorkload",760.81,"productId","U5Nm","productName","27si","templateId","Sn7a","tcuserid","nEn0","tcusername","x092","tremark","U0fg","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","EsLo","shareScope","kbGz");
		XmProjectTemplate xmProjectTemplate=BaseUtils.fromMap(p,XmProjectTemplate.class);
		baseDao.deleteByWhere(xmProjectTemplate);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","nKcH");
		XmProjectTemplate xmProjectTemplate=BaseUtils.fromMap(p,XmProjectTemplate.class);
		baseDao.deleteByPk(xmProjectTemplate);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("code","9h2e","name","2LSI","xmType","0odU","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","djav","priority","K97L","description","VrxN","createUserid","Sb8X","createUsername","T8mf","createTime",parse("2020-11-02 21:15:1"),"assess","qDwX","assessRemarks","Y1HH","status","Z34x","branchId","24m0","planTotalCost",6555.25,"bizProcInstId","VeW9","bizFlowState","9","planNouserAt",2140.46,"planInnerUserAt",934.12,"planOutUserAt",8488.98,"locked","3","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","jsLa","baselineId","IlU8","planWorkload",2853.96,"totalReceivables",2358.89,"budgetMarginRate",2168.6643,"contractAmt",9010.66,"planInnerUserPrice",2912.83,"planOutUserPrice",9664.67,"planOutUserCnt",7257,"planInnerUserCnt",8108,"planWorkingHours",5108,"taxRate",3658.61,"planInnerUserWorkload",5254.45,"planOutUserWorkload",760.81,"productId","U5Nm","productName","27si","templateId","Sn7a","tcuserid","nEn0","tcusername","x092","tremark","U0fg","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","EsLo","shareScope","kbGz");
		XmProjectTemplate xmProjectTemplate=BaseUtils.fromMap(where,XmProjectTemplate.class);
		baseDao.updateSomeFieldByPk(xmProjectTemplate);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","nKcH");
		XmProjectTemplate xmProjectTemplate=BaseUtils.fromMap(p,XmProjectTemplate.class);
		baseDao.updateByPk(xmProjectTemplate);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("id","nKcH","code","9h2e","name","2LSI","xmType","0odU","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","djav","priority","K97L","description","VrxN","createUserid","Sb8X","createUsername","T8mf","createTime",parse("2020-11-02 21:15:1"),"assess","qDwX","assessRemarks","Y1HH","status","Z34x","branchId","24m0","planTotalCost",6555.25,"bizProcInstId","VeW9","bizFlowState","9","planNouserAt",2140.46,"planInnerUserAt",934.12,"planOutUserAt",8488.98,"locked","3","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","jsLa","baselineId","IlU8","planWorkload",2853.96,"totalReceivables",2358.89,"budgetMarginRate",2168.6643,"contractAmt",9010.66,"planInnerUserPrice",2912.83,"planOutUserPrice",9664.67,"planOutUserCnt",7257,"planInnerUserCnt",8108,"planWorkingHours",5108,"taxRate",3658.61,"planInnerUserWorkload",5254.45,"planOutUserWorkload",760.81,"productId","U5Nm","productName","27si","templateId","Sn7a","tcuserid","nEn0","tcusername","x092","tremark","U0fg","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","EsLo","shareScope","kbGz");
		XmProjectTemplate xmProjectTemplate=BaseUtils.fromMap(p,XmProjectTemplate.class);
		baseDao.insertOrUpdate(xmProjectTemplate);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmProjectTemplate> batchValues=new ArrayList<XmProjectTemplate>();
		Map p0=BaseUtils.map("id","nKcH","code","9h2e","name","2LSI","xmType","0odU","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","djav","priority","K97L","description","VrxN","createUserid","Sb8X","createUsername","T8mf","createTime",parse("2020-11-02 21:15:1"),"assess","qDwX","assessRemarks","Y1HH","status","Z34x","branchId","24m0","planTotalCost",6555.25,"bizProcInstId","VeW9","bizFlowState","9","planNouserAt",2140.46,"planInnerUserAt",934.12,"planOutUserAt",8488.98,"locked","3","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","jsLa","baselineId","IlU8","planWorkload",2853.96,"totalReceivables",2358.89,"budgetMarginRate",2168.6643,"contractAmt",9010.66,"planInnerUserPrice",2912.83,"planOutUserPrice",9664.67,"planOutUserCnt",7257,"planInnerUserCnt",8108,"planWorkingHours",5108,"taxRate",3658.61,"planInnerUserWorkload",5254.45,"planOutUserWorkload",760.81,"productId","U5Nm","productName","27si","templateId","Sn7a","tcuserid","nEn0","tcusername","x092","tremark","U0fg","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","EsLo","shareScope","kbGz");
		XmProjectTemplate xmProjectTemplate0=BaseUtils.fromMap(p0,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate0);
		Map p1=BaseUtils.map("id","EMb5","code","FQeK","name","E2YS","xmType","NKLU","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","4CUe","priority","yN04","description","tUb4","createUserid","PUbW","createUsername","U9l1","createTime",parse("2020-11-02 21:15:1"),"assess","2VFW","assessRemarks","DsXI","status","MZy7","branchId","yFbG","planTotalCost",3054.43,"bizProcInstId","lqA0","bizFlowState","F","planNouserAt",7271.28,"planInnerUserAt",5287.57,"planOutUserAt",7660.62,"locked","L","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","BfXu","baselineId","iLn6","planWorkload",4873.46,"totalReceivables",664.82,"budgetMarginRate",652.9721,"contractAmt",4570.04,"planInnerUserPrice",1707.95,"planOutUserPrice",6580.14,"planOutUserCnt",9647,"planInnerUserCnt",228,"planWorkingHours",8866,"taxRate",2476.72,"planInnerUserWorkload",3362.69,"planOutUserWorkload",1744.73,"productId","u8Rq","productName","GqNu","templateId","8Hpq","tcuserid","i3i6","tcusername","nLUB","tremark","CTxH","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","5VEl","shareScope","Ghpo");
		XmProjectTemplate xmProjectTemplate1=BaseUtils.fromMap(p1,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate1);
		Map p2=BaseUtils.map("id","nid3","code","b7OT","name","5aM4","xmType","dj9J","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","aM9R","priority","76hU","description","kR73","createUserid","m9ZI","createUsername","ng34","createTime",parse("2020-11-02 21:15:1"),"assess","WQ3a","assessRemarks","5t89","status","d81O","branchId","8ZfV","planTotalCost",9148.31,"bizProcInstId","9P5b","bizFlowState","x","planNouserAt",4162.49,"planInnerUserAt",6968.47,"planOutUserAt",8275.41,"locked","C","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","kZ5J","baselineId","8Ij8","planWorkload",9988,"totalReceivables",9822.55,"budgetMarginRate",2541.5555,"contractAmt",7826.89,"planInnerUserPrice",3368.44,"planOutUserPrice",4449.44,"planOutUserCnt",5942,"planInnerUserCnt",6254,"planWorkingHours",7398,"taxRate",7047.7,"planInnerUserWorkload",9449.93,"planOutUserWorkload",425.37,"productId","pCy5","productName","wSxZ","templateId","hEL8","tcuserid","ms26","tcusername","dusL","tremark","jBpG","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","CX6j","shareScope","KF0N");
		XmProjectTemplate xmProjectTemplate2=BaseUtils.fromMap(p2,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate2);
		Map p3=BaseUtils.map("id","6o7t","code","91VX","name","Q1US","xmType","j4h4","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","C8QV","priority","TCwy","description","yM6t","createUserid","o9YN","createUsername","zNAo","createTime",parse("2020-11-02 21:15:1"),"assess","Zwa3","assessRemarks","QVbR","status","6fVC","branchId","ySxH","planTotalCost",4094.12,"bizProcInstId","vGVb","bizFlowState","K","planNouserAt",357.98,"planInnerUserAt",7009.34,"planOutUserAt",8230.25,"locked","6","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","j185","baselineId","k7ky","planWorkload",4587.04,"totalReceivables",2569.94,"budgetMarginRate",1937.1748,"contractAmt",949.37,"planInnerUserPrice",3794.39,"planOutUserPrice",9286.81,"planOutUserCnt",3429,"planInnerUserCnt",6338,"planWorkingHours",8575,"taxRate",7315.27,"planInnerUserWorkload",718.98,"planOutUserWorkload",2106.43,"productId","j77S","productName","8HAC","templateId","83gl","tcuserid","4la9","tcusername","318T","tremark","GjUV","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","B9m8","shareScope","HWWR");
		XmProjectTemplate xmProjectTemplate3=BaseUtils.fromMap(p3,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate3);
		Map p4=BaseUtils.map("id","9CfH","code","7Rf2","name","ljGS","xmType","WObb","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","88d9","priority","IuiR","description","AlC9","createUserid","Hw68","createUsername","qo2S","createTime",parse("2020-11-02 21:15:1"),"assess","6l4C","assessRemarks","W1r0","status","T33p","branchId","hSK0","planTotalCost",1643.13,"bizProcInstId","jeUQ","bizFlowState","K","planNouserAt",4531.03,"planInnerUserAt",9098.86,"planOutUserAt",4659.5,"locked","S","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","64wz","baselineId","B31K","planWorkload",6749.26,"totalReceivables",3659.42,"budgetMarginRate",7753.5184,"contractAmt",6995.97,"planInnerUserPrice",7902.23,"planOutUserPrice",4969.48,"planOutUserCnt",7890,"planInnerUserCnt",3390,"planWorkingHours",4807,"taxRate",2042.76,"planInnerUserWorkload",6592.71,"planOutUserWorkload",8266.16,"productId","ZKW8","productName","Bw7z","templateId","A4qO","tcuserid","WCRB","tcusername","RdH5","tremark","bcZC","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","id8h","shareScope","T68P");
		XmProjectTemplate xmProjectTemplate4=BaseUtils.fromMap(p4,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate4);
		Map p5=BaseUtils.map("id","4elG","code","8VHG","name","8JJj","xmType","lyHv","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","H1JC","priority","oPi4","description","Be5u","createUserid","5ciT","createUsername","ni0x","createTime",parse("2020-11-02 21:15:1"),"assess","kQh5","assessRemarks","b46G","status","q0GH","branchId","xSem","planTotalCost",2637.86,"bizProcInstId","X89S","bizFlowState","w","planNouserAt",2802.21,"planInnerUserAt",1531.47,"planOutUserAt",2506.04,"locked","V","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","9GgG","baselineId","EBBK","planWorkload",8615.84,"totalReceivables",5095.93,"budgetMarginRate",2212.042,"contractAmt",4600.15,"planInnerUserPrice",3509.92,"planOutUserPrice",4140.72,"planOutUserCnt",3682,"planInnerUserCnt",9549,"planWorkingHours",4729,"taxRate",1065.52,"planInnerUserWorkload",7334.37,"planOutUserWorkload",2519.08,"productId","fNQp","productName","lDfd","templateId","NOa6","tcuserid","wJ3Y","tcusername","2fze","tremark","4u94","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","CNiH","shareScope","Zspz");
		XmProjectTemplate xmProjectTemplate5=BaseUtils.fromMap(p5,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate5);
		Map p6=BaseUtils.map("id","o8sb","code","tch7","name","ykph","xmType","oh24","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","9Ux1","priority","9jpL","description","4LDd","createUserid","c09H","createUsername","dp06","createTime",parse("2020-11-02 21:15:1"),"assess","gXv4","assessRemarks","OED8","status","nKQU","branchId","KJeu","planTotalCost",9450.81,"bizProcInstId","g5S3","bizFlowState","t","planNouserAt",8010.23,"planInnerUserAt",6256.05,"planOutUserAt",6043.45,"locked","k","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","uOYs","baselineId","LCO9","planWorkload",3188.95,"totalReceivables",1431.93,"budgetMarginRate",2970.4277,"contractAmt",3283.24,"planInnerUserPrice",783,"planOutUserPrice",4601.51,"planOutUserCnt",6305,"planInnerUserCnt",6321,"planWorkingHours",3079,"taxRate",172.75,"planInnerUserWorkload",7608.78,"planOutUserWorkload",5763.5,"productId","1v54","productName","hrrb","templateId","015R","tcuserid","nUuv","tcusername","4q22","tremark","rIwp","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","IS0D","shareScope","fcuo");
		XmProjectTemplate xmProjectTemplate6=BaseUtils.fromMap(p6,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate6);
		Map p7=BaseUtils.map("id","KJR9","code","P0n6","name","5Ax4","xmType","MlCG","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","hzdD","priority","hq5O","description","ZH9W","createUserid","Kna7","createUsername","1AFt","createTime",parse("2020-11-02 21:15:1"),"assess","o0t0","assessRemarks","f7J8","status","2c3J","branchId","6n4n","planTotalCost",845.73,"bizProcInstId","Xg94","bizFlowState","C","planNouserAt",3975.84,"planInnerUserAt",9303.22,"planOutUserAt",249.3,"locked","6","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","XDRq","baselineId","MO5A","planWorkload",3058.09,"totalReceivables",4292.7,"budgetMarginRate",4525.5556,"contractAmt",573.26,"planInnerUserPrice",5304.97,"planOutUserPrice",6437.04,"planOutUserCnt",3335,"planInnerUserCnt",6117,"planWorkingHours",3428,"taxRate",9618,"planInnerUserWorkload",6163.07,"planOutUserWorkload",6980.95,"productId","krYA","productName","lB8c","templateId","tJNd","tcuserid","yO2H","tcusername","Z42r","tremark","E940","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","w5cR","shareScope","B87x");
		XmProjectTemplate xmProjectTemplate7=BaseUtils.fromMap(p7,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate7);
		baseDao.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmProjectTemplate> batchValues=new ArrayList<XmProjectTemplate>();
		Map p0=BaseUtils.map("id","nKcH","code","9h2e","name","2LSI","xmType","0odU","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","djav","priority","K97L","description","VrxN","createUserid","Sb8X","createUsername","T8mf","createTime",parse("2020-11-02 21:15:1"),"assess","qDwX","assessRemarks","Y1HH","status","Z34x","branchId","24m0","planTotalCost",6555.25,"bizProcInstId","VeW9","bizFlowState","9","planNouserAt",2140.46,"planInnerUserAt",934.12,"planOutUserAt",8488.98,"locked","3","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","jsLa","baselineId","IlU8","planWorkload",2853.96,"totalReceivables",2358.89,"budgetMarginRate",2168.6643,"contractAmt",9010.66,"planInnerUserPrice",2912.83,"planOutUserPrice",9664.67,"planOutUserCnt",7257,"planInnerUserCnt",8108,"planWorkingHours",5108,"taxRate",3658.61,"planInnerUserWorkload",5254.45,"planOutUserWorkload",760.81,"productId","U5Nm","productName","27si","templateId","Sn7a","tcuserid","nEn0","tcusername","x092","tremark","U0fg","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","EsLo","shareScope","kbGz");
		XmProjectTemplate xmProjectTemplate0=BaseUtils.fromMap(p0,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate0);
		Map p1=BaseUtils.map("id","EMb5","code","FQeK","name","E2YS","xmType","NKLU","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","4CUe","priority","yN04","description","tUb4","createUserid","PUbW","createUsername","U9l1","createTime",parse("2020-11-02 21:15:1"),"assess","2VFW","assessRemarks","DsXI","status","MZy7","branchId","yFbG","planTotalCost",3054.43,"bizProcInstId","lqA0","bizFlowState","F","planNouserAt",7271.28,"planInnerUserAt",5287.57,"planOutUserAt",7660.62,"locked","L","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","BfXu","baselineId","iLn6","planWorkload",4873.46,"totalReceivables",664.82,"budgetMarginRate",652.9721,"contractAmt",4570.04,"planInnerUserPrice",1707.95,"planOutUserPrice",6580.14,"planOutUserCnt",9647,"planInnerUserCnt",228,"planWorkingHours",8866,"taxRate",2476.72,"planInnerUserWorkload",3362.69,"planOutUserWorkload",1744.73,"productId","u8Rq","productName","GqNu","templateId","8Hpq","tcuserid","i3i6","tcusername","nLUB","tremark","CTxH","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","5VEl","shareScope","Ghpo");
		XmProjectTemplate xmProjectTemplate1=BaseUtils.fromMap(p1,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate1);
		Map p2=BaseUtils.map("id","nid3","code","b7OT","name","5aM4","xmType","dj9J","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","aM9R","priority","76hU","description","kR73","createUserid","m9ZI","createUsername","ng34","createTime",parse("2020-11-02 21:15:1"),"assess","WQ3a","assessRemarks","5t89","status","d81O","branchId","8ZfV","planTotalCost",9148.31,"bizProcInstId","9P5b","bizFlowState","x","planNouserAt",4162.49,"planInnerUserAt",6968.47,"planOutUserAt",8275.41,"locked","C","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","kZ5J","baselineId","8Ij8","planWorkload",9988,"totalReceivables",9822.55,"budgetMarginRate",2541.5555,"contractAmt",7826.89,"planInnerUserPrice",3368.44,"planOutUserPrice",4449.44,"planOutUserCnt",5942,"planInnerUserCnt",6254,"planWorkingHours",7398,"taxRate",7047.7,"planInnerUserWorkload",9449.93,"planOutUserWorkload",425.37,"productId","pCy5","productName","wSxZ","templateId","hEL8","tcuserid","ms26","tcusername","dusL","tremark","jBpG","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","CX6j","shareScope","KF0N");
		XmProjectTemplate xmProjectTemplate2=BaseUtils.fromMap(p2,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate2);
		Map p3=BaseUtils.map("id","6o7t","code","91VX","name","Q1US","xmType","j4h4","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","C8QV","priority","TCwy","description","yM6t","createUserid","o9YN","createUsername","zNAo","createTime",parse("2020-11-02 21:15:1"),"assess","Zwa3","assessRemarks","QVbR","status","6fVC","branchId","ySxH","planTotalCost",4094.12,"bizProcInstId","vGVb","bizFlowState","K","planNouserAt",357.98,"planInnerUserAt",7009.34,"planOutUserAt",8230.25,"locked","6","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","j185","baselineId","k7ky","planWorkload",4587.04,"totalReceivables",2569.94,"budgetMarginRate",1937.1748,"contractAmt",949.37,"planInnerUserPrice",3794.39,"planOutUserPrice",9286.81,"planOutUserCnt",3429,"planInnerUserCnt",6338,"planWorkingHours",8575,"taxRate",7315.27,"planInnerUserWorkload",718.98,"planOutUserWorkload",2106.43,"productId","j77S","productName","8HAC","templateId","83gl","tcuserid","4la9","tcusername","318T","tremark","GjUV","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","B9m8","shareScope","HWWR");
		XmProjectTemplate xmProjectTemplate3=BaseUtils.fromMap(p3,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate3);
		Map p4=BaseUtils.map("id","9CfH","code","7Rf2","name","ljGS","xmType","WObb","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","88d9","priority","IuiR","description","AlC9","createUserid","Hw68","createUsername","qo2S","createTime",parse("2020-11-02 21:15:1"),"assess","6l4C","assessRemarks","W1r0","status","T33p","branchId","hSK0","planTotalCost",1643.13,"bizProcInstId","jeUQ","bizFlowState","K","planNouserAt",4531.03,"planInnerUserAt",9098.86,"planOutUserAt",4659.5,"locked","S","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","64wz","baselineId","B31K","planWorkload",6749.26,"totalReceivables",3659.42,"budgetMarginRate",7753.5184,"contractAmt",6995.97,"planInnerUserPrice",7902.23,"planOutUserPrice",4969.48,"planOutUserCnt",7890,"planInnerUserCnt",3390,"planWorkingHours",4807,"taxRate",2042.76,"planInnerUserWorkload",6592.71,"planOutUserWorkload",8266.16,"productId","ZKW8","productName","Bw7z","templateId","A4qO","tcuserid","WCRB","tcusername","RdH5","tremark","bcZC","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","id8h","shareScope","T68P");
		XmProjectTemplate xmProjectTemplate4=BaseUtils.fromMap(p4,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate4);
		Map p5=BaseUtils.map("id","4elG","code","8VHG","name","8JJj","xmType","lyHv","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","H1JC","priority","oPi4","description","Be5u","createUserid","5ciT","createUsername","ni0x","createTime",parse("2020-11-02 21:15:1"),"assess","kQh5","assessRemarks","b46G","status","q0GH","branchId","xSem","planTotalCost",2637.86,"bizProcInstId","X89S","bizFlowState","w","planNouserAt",2802.21,"planInnerUserAt",1531.47,"planOutUserAt",2506.04,"locked","V","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","9GgG","baselineId","EBBK","planWorkload",8615.84,"totalReceivables",5095.93,"budgetMarginRate",2212.042,"contractAmt",4600.15,"planInnerUserPrice",3509.92,"planOutUserPrice",4140.72,"planOutUserCnt",3682,"planInnerUserCnt",9549,"planWorkingHours",4729,"taxRate",1065.52,"planInnerUserWorkload",7334.37,"planOutUserWorkload",2519.08,"productId","fNQp","productName","lDfd","templateId","NOa6","tcuserid","wJ3Y","tcusername","2fze","tremark","4u94","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","CNiH","shareScope","Zspz");
		XmProjectTemplate xmProjectTemplate5=BaseUtils.fromMap(p5,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate5);
		Map p6=BaseUtils.map("id","o8sb","code","tch7","name","ykph","xmType","oh24","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","9Ux1","priority","9jpL","description","4LDd","createUserid","c09H","createUsername","dp06","createTime",parse("2020-11-02 21:15:1"),"assess","gXv4","assessRemarks","OED8","status","nKQU","branchId","KJeu","planTotalCost",9450.81,"bizProcInstId","g5S3","bizFlowState","t","planNouserAt",8010.23,"planInnerUserAt",6256.05,"planOutUserAt",6043.45,"locked","k","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","uOYs","baselineId","LCO9","planWorkload",3188.95,"totalReceivables",1431.93,"budgetMarginRate",2970.4277,"contractAmt",3283.24,"planInnerUserPrice",783,"planOutUserPrice",4601.51,"planOutUserCnt",6305,"planInnerUserCnt",6321,"planWorkingHours",3079,"taxRate",172.75,"planInnerUserWorkload",7608.78,"planOutUserWorkload",5763.5,"productId","1v54","productName","hrrb","templateId","015R","tcuserid","nUuv","tcusername","4q22","tremark","rIwp","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","IS0D","shareScope","fcuo");
		XmProjectTemplate xmProjectTemplate6=BaseUtils.fromMap(p6,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate6);
		Map p7=BaseUtils.map("id","KJR9","code","P0n6","name","5Ax4","xmType","MlCG","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","hzdD","priority","hq5O","description","ZH9W","createUserid","Kna7","createUsername","1AFt","createTime",parse("2020-11-02 21:15:1"),"assess","o0t0","assessRemarks","f7J8","status","2c3J","branchId","6n4n","planTotalCost",845.73,"bizProcInstId","Xg94","bizFlowState","C","planNouserAt",3975.84,"planInnerUserAt",9303.22,"planOutUserAt",249.3,"locked","6","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","XDRq","baselineId","MO5A","planWorkload",3058.09,"totalReceivables",4292.7,"budgetMarginRate",4525.5556,"contractAmt",573.26,"planInnerUserPrice",5304.97,"planOutUserPrice",6437.04,"planOutUserCnt",3335,"planInnerUserCnt",6117,"planWorkingHours",3428,"taxRate",9618,"planInnerUserWorkload",6163.07,"planOutUserWorkload",6980.95,"productId","krYA","productName","lB8c","templateId","tJNd","tcuserid","yO2H","tcusername","Z42r","tremark","E940","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","w5cR","shareScope","B87x");
		XmProjectTemplate xmProjectTemplate7=BaseUtils.fromMap(p7,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate7);
		baseDao.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmProjectTemplate> batchValues=new ArrayList<XmProjectTemplate>();
		Map p0=BaseUtils.map("id","nKcH","code","9h2e","name","2LSI","xmType","0odU","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","djav","priority","K97L","description","VrxN","createUserid","Sb8X","createUsername","T8mf","createTime",parse("2020-11-02 21:15:1"),"assess","qDwX","assessRemarks","Y1HH","status","Z34x","branchId","24m0","planTotalCost",6555.25,"bizProcInstId","VeW9","bizFlowState","9","planNouserAt",2140.46,"planInnerUserAt",934.12,"planOutUserAt",8488.98,"locked","3","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","jsLa","baselineId","IlU8","planWorkload",2853.96,"totalReceivables",2358.89,"budgetMarginRate",2168.6643,"contractAmt",9010.66,"planInnerUserPrice",2912.83,"planOutUserPrice",9664.67,"planOutUserCnt",7257,"planInnerUserCnt",8108,"planWorkingHours",5108,"taxRate",3658.61,"planInnerUserWorkload",5254.45,"planOutUserWorkload",760.81,"productId","U5Nm","productName","27si","templateId","Sn7a","tcuserid","nEn0","tcusername","x092","tremark","U0fg","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","EsLo","shareScope","kbGz");
		XmProjectTemplate xmProjectTemplate0=BaseUtils.fromMap(p0,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate0);
		Map p1=BaseUtils.map("id","EMb5","code","FQeK","name","E2YS","xmType","NKLU","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","4CUe","priority","yN04","description","tUb4","createUserid","PUbW","createUsername","U9l1","createTime",parse("2020-11-02 21:15:1"),"assess","2VFW","assessRemarks","DsXI","status","MZy7","branchId","yFbG","planTotalCost",3054.43,"bizProcInstId","lqA0","bizFlowState","F","planNouserAt",7271.28,"planInnerUserAt",5287.57,"planOutUserAt",7660.62,"locked","L","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","BfXu","baselineId","iLn6","planWorkload",4873.46,"totalReceivables",664.82,"budgetMarginRate",652.9721,"contractAmt",4570.04,"planInnerUserPrice",1707.95,"planOutUserPrice",6580.14,"planOutUserCnt",9647,"planInnerUserCnt",228,"planWorkingHours",8866,"taxRate",2476.72,"planInnerUserWorkload",3362.69,"planOutUserWorkload",1744.73,"productId","u8Rq","productName","GqNu","templateId","8Hpq","tcuserid","i3i6","tcusername","nLUB","tremark","CTxH","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","5VEl","shareScope","Ghpo");
		XmProjectTemplate xmProjectTemplate1=BaseUtils.fromMap(p1,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate1);
		Map p2=BaseUtils.map("id","nid3","code","b7OT","name","5aM4","xmType","dj9J","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","aM9R","priority","76hU","description","kR73","createUserid","m9ZI","createUsername","ng34","createTime",parse("2020-11-02 21:15:1"),"assess","WQ3a","assessRemarks","5t89","status","d81O","branchId","8ZfV","planTotalCost",9148.31,"bizProcInstId","9P5b","bizFlowState","x","planNouserAt",4162.49,"planInnerUserAt",6968.47,"planOutUserAt",8275.41,"locked","C","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","kZ5J","baselineId","8Ij8","planWorkload",9988,"totalReceivables",9822.55,"budgetMarginRate",2541.5555,"contractAmt",7826.89,"planInnerUserPrice",3368.44,"planOutUserPrice",4449.44,"planOutUserCnt",5942,"planInnerUserCnt",6254,"planWorkingHours",7398,"taxRate",7047.7,"planInnerUserWorkload",9449.93,"planOutUserWorkload",425.37,"productId","pCy5","productName","wSxZ","templateId","hEL8","tcuserid","ms26","tcusername","dusL","tremark","jBpG","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","CX6j","shareScope","KF0N");
		XmProjectTemplate xmProjectTemplate2=BaseUtils.fromMap(p2,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate2);
		Map p3=BaseUtils.map("id","6o7t","code","91VX","name","Q1US","xmType","j4h4","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","C8QV","priority","TCwy","description","yM6t","createUserid","o9YN","createUsername","zNAo","createTime",parse("2020-11-02 21:15:1"),"assess","Zwa3","assessRemarks","QVbR","status","6fVC","branchId","ySxH","planTotalCost",4094.12,"bizProcInstId","vGVb","bizFlowState","K","planNouserAt",357.98,"planInnerUserAt",7009.34,"planOutUserAt",8230.25,"locked","6","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","j185","baselineId","k7ky","planWorkload",4587.04,"totalReceivables",2569.94,"budgetMarginRate",1937.1748,"contractAmt",949.37,"planInnerUserPrice",3794.39,"planOutUserPrice",9286.81,"planOutUserCnt",3429,"planInnerUserCnt",6338,"planWorkingHours",8575,"taxRate",7315.27,"planInnerUserWorkload",718.98,"planOutUserWorkload",2106.43,"productId","j77S","productName","8HAC","templateId","83gl","tcuserid","4la9","tcusername","318T","tremark","GjUV","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","B9m8","shareScope","HWWR");
		XmProjectTemplate xmProjectTemplate3=BaseUtils.fromMap(p3,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate3);
		Map p4=BaseUtils.map("id","9CfH","code","7Rf2","name","ljGS","xmType","WObb","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","88d9","priority","IuiR","description","AlC9","createUserid","Hw68","createUsername","qo2S","createTime",parse("2020-11-02 21:15:1"),"assess","6l4C","assessRemarks","W1r0","status","T33p","branchId","hSK0","planTotalCost",1643.13,"bizProcInstId","jeUQ","bizFlowState","K","planNouserAt",4531.03,"planInnerUserAt",9098.86,"planOutUserAt",4659.5,"locked","S","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","64wz","baselineId","B31K","planWorkload",6749.26,"totalReceivables",3659.42,"budgetMarginRate",7753.5184,"contractAmt",6995.97,"planInnerUserPrice",7902.23,"planOutUserPrice",4969.48,"planOutUserCnt",7890,"planInnerUserCnt",3390,"planWorkingHours",4807,"taxRate",2042.76,"planInnerUserWorkload",6592.71,"planOutUserWorkload",8266.16,"productId","ZKW8","productName","Bw7z","templateId","A4qO","tcuserid","WCRB","tcusername","RdH5","tremark","bcZC","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","id8h","shareScope","T68P");
		XmProjectTemplate xmProjectTemplate4=BaseUtils.fromMap(p4,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate4);
		Map p5=BaseUtils.map("id","4elG","code","8VHG","name","8JJj","xmType","lyHv","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","H1JC","priority","oPi4","description","Be5u","createUserid","5ciT","createUsername","ni0x","createTime",parse("2020-11-02 21:15:1"),"assess","kQh5","assessRemarks","b46G","status","q0GH","branchId","xSem","planTotalCost",2637.86,"bizProcInstId","X89S","bizFlowState","w","planNouserAt",2802.21,"planInnerUserAt",1531.47,"planOutUserAt",2506.04,"locked","V","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","9GgG","baselineId","EBBK","planWorkload",8615.84,"totalReceivables",5095.93,"budgetMarginRate",2212.042,"contractAmt",4600.15,"planInnerUserPrice",3509.92,"planOutUserPrice",4140.72,"planOutUserCnt",3682,"planInnerUserCnt",9549,"planWorkingHours",4729,"taxRate",1065.52,"planInnerUserWorkload",7334.37,"planOutUserWorkload",2519.08,"productId","fNQp","productName","lDfd","templateId","NOa6","tcuserid","wJ3Y","tcusername","2fze","tremark","4u94","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","CNiH","shareScope","Zspz");
		XmProjectTemplate xmProjectTemplate5=BaseUtils.fromMap(p5,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate5);
		Map p6=BaseUtils.map("id","o8sb","code","tch7","name","ykph","xmType","oh24","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","9Ux1","priority","9jpL","description","4LDd","createUserid","c09H","createUsername","dp06","createTime",parse("2020-11-02 21:15:1"),"assess","gXv4","assessRemarks","OED8","status","nKQU","branchId","KJeu","planTotalCost",9450.81,"bizProcInstId","g5S3","bizFlowState","t","planNouserAt",8010.23,"planInnerUserAt",6256.05,"planOutUserAt",6043.45,"locked","k","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","uOYs","baselineId","LCO9","planWorkload",3188.95,"totalReceivables",1431.93,"budgetMarginRate",2970.4277,"contractAmt",3283.24,"planInnerUserPrice",783,"planOutUserPrice",4601.51,"planOutUserCnt",6305,"planInnerUserCnt",6321,"planWorkingHours",3079,"taxRate",172.75,"planInnerUserWorkload",7608.78,"planOutUserWorkload",5763.5,"productId","1v54","productName","hrrb","templateId","015R","tcuserid","nUuv","tcusername","4q22","tremark","rIwp","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","IS0D","shareScope","fcuo");
		XmProjectTemplate xmProjectTemplate6=BaseUtils.fromMap(p6,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate6);
		Map p7=BaseUtils.map("id","KJR9","code","P0n6","name","5Ax4","xmType","MlCG","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","hzdD","priority","hq5O","description","ZH9W","createUserid","Kna7","createUsername","1AFt","createTime",parse("2020-11-02 21:15:1"),"assess","o0t0","assessRemarks","f7J8","status","2c3J","branchId","6n4n","planTotalCost",845.73,"bizProcInstId","Xg94","bizFlowState","C","planNouserAt",3975.84,"planInnerUserAt",9303.22,"planOutUserAt",249.3,"locked","6","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","XDRq","baselineId","MO5A","planWorkload",3058.09,"totalReceivables",4292.7,"budgetMarginRate",4525.5556,"contractAmt",573.26,"planInnerUserPrice",5304.97,"planOutUserPrice",6437.04,"planOutUserCnt",3335,"planInnerUserCnt",6117,"planWorkingHours",3428,"taxRate",9618,"planInnerUserWorkload",6163.07,"planOutUserWorkload",6980.95,"productId","krYA","productName","lB8c","templateId","tJNd","tcuserid","yO2H","tcusername","Z42r","tremark","E940","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","w5cR","shareScope","B87x");
		XmProjectTemplate xmProjectTemplate7=BaseUtils.fromMap(p7,XmProjectTemplate.class);
		batchValues.add(xmProjectTemplate7);
		baseDao.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","nKcH");
		Map<String,Object> result=this.baseDao.selectOne(XmProjectTemplate.class.getName()+".selectOneMap",p);
		Assert.assertEquals("nKcH", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("code","9h2e","name","2LSI","xmType","0odU","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","djav","priority","K97L","description","VrxN","createUserid","Sb8X","createUsername","T8mf","createTime",parse("2020-11-02 21:15:1"),"assess","qDwX","assessRemarks","Y1HH","status","Z34x","branchId","24m0","planTotalCost",6555.25,"bizProcInstId","VeW9","bizFlowState","9","planNouserAt",2140.46,"planInnerUserAt",934.12,"planOutUserAt",8488.98,"locked","3","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","jsLa","baselineId","IlU8","planWorkload",2853.96,"totalReceivables",2358.89,"budgetMarginRate",2168.6643,"contractAmt",9010.66,"planInnerUserPrice",2912.83,"planOutUserPrice",9664.67,"planOutUserCnt",7257,"planInnerUserCnt",8108,"planWorkingHours",5108,"taxRate",3658.61,"planInnerUserWorkload",5254.45,"planOutUserWorkload",760.81,"productId","U5Nm","productName","27si","templateId","Sn7a","tcuserid","nEn0","tcusername","x092","tremark","U0fg","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","EsLo","shareScope","kbGz");
		XmProjectTemplate xmProjectTemplate=BaseUtils.fromMap(p,XmProjectTemplate.class);
		long result=baseDao.countByWhere(xmProjectTemplate);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
 		
		
		Map<String,Object> p=BaseUtils.map("code","9h2e","name","2LSI","xmType","0odU","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","djav","priority","K97L","description","VrxN","createUserid","Sb8X","createUsername","T8mf","createTime",parse("2020-11-02 21:15:1"),"assess","qDwX","assessRemarks","Y1HH","status","Z34x","branchId","24m0","planTotalCost",6555.25,"bizProcInstId","VeW9","bizFlowState","9","planNouserAt",2140.46,"planInnerUserAt",934.12,"planOutUserAt",8488.98,"locked","3","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","jsLa","baselineId","IlU8","planWorkload",2853.96,"totalReceivables",2358.89,"budgetMarginRate",2168.6643,"contractAmt",9010.66,"planInnerUserPrice",2912.83,"planOutUserPrice",9664.67,"planOutUserCnt",7257,"planInnerUserCnt",8108,"planWorkingHours",5108,"taxRate",3658.61,"planInnerUserWorkload",5254.45,"planOutUserWorkload",760.81,"productId","U5Nm","productName","27si","templateId","Sn7a","tcuserid","nEn0","tcusername","x092","tremark","U0fg","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","EsLo","shareScope","kbGz");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmProjectTemplate xmProjectTemplate=BaseUtils.fromMap(p,XmProjectTemplate.class);
		List<XmProjectTemplate> result=baseDao.selectListByWhere(xmProjectTemplate); 
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
	
		
		Map<String,Object> p=BaseUtils.map("code","9h2e","name","2LSI","xmType","0odU","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","djav","priority","K97L","description","VrxN","createUserid","Sb8X","createUsername","T8mf","createTime",parse("2020-11-02 21:15:1"),"assess","qDwX","assessRemarks","Y1HH","status","Z34x","branchId","24m0","planTotalCost",6555.25,"bizProcInstId","VeW9","bizFlowState","9","planNouserAt",2140.46,"planInnerUserAt",934.12,"planOutUserAt",8488.98,"locked","3","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","jsLa","baselineId","IlU8","planWorkload",2853.96,"totalReceivables",2358.89,"budgetMarginRate",2168.6643,"contractAmt",9010.66,"planInnerUserPrice",2912.83,"planOutUserPrice",9664.67,"planOutUserCnt",7257,"planInnerUserCnt",8108,"planWorkingHours",5108,"taxRate",3658.61,"planInnerUserWorkload",5254.45,"planOutUserWorkload",760.81,"productId","U5Nm","productName","27si","templateId","Sn7a","tcuserid","nEn0","tcusername","x092","tremark","U0fg","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","EsLo","shareScope","kbGz");
		XmProjectTemplate xmProjectTemplate=BaseUtils.fromMap(p,XmProjectTemplate.class);
		List<XmProjectTemplate> result=baseDao.selectListByWhere(xmProjectTemplate);
		Assert.assertEquals(true, result.size()>=1);
	}

	
	/**
	 * 查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("code","9h2e","name","2LSI","xmType","0odU","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","djav","priority","K97L","description","VrxN","createUserid","Sb8X","createUsername","T8mf","createTime",parse("2020-11-02 21:15:1"),"assess","qDwX","assessRemarks","Y1HH","status","Z34x","branchId","24m0","planTotalCost",6555.25,"bizProcInstId","VeW9","bizFlowState","9","planNouserAt",2140.46,"planInnerUserAt",934.12,"planOutUserAt",8488.98,"locked","3","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","jsLa","baselineId","IlU8","planWorkload",2853.96,"totalReceivables",2358.89,"budgetMarginRate",2168.6643,"contractAmt",9010.66,"planInnerUserPrice",2912.83,"planOutUserPrice",9664.67,"planOutUserCnt",7257,"planInnerUserCnt",8108,"planWorkingHours",5108,"taxRate",3658.61,"planInnerUserWorkload",5254.45,"planOutUserWorkload",760.81,"productId","U5Nm","productName","27si","templateId","Sn7a","tcuserid","nEn0","tcusername","x092","tremark","U0fg","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","EsLo","shareScope","kbGz");
		List<Map<String,Object>> result=baseDao.selectList(XmProjectTemplate.class.getName()+".selectListMapByWhere",p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("code","9h2e","name","2LSI","xmType","0odU","startTime",parse("2020-11-02 21:15:1"),"endTime",parse("2020-11-02 21:15:1"),"urgent","djav","priority","K97L","description","VrxN","createUserid","Sb8X","createUsername","T8mf","createTime",parse("2020-11-02 21:15:1"),"assess","qDwX","assessRemarks","Y1HH","status","Z34x","branchId","24m0","planTotalCost",6555.25,"bizProcInstId","VeW9","bizFlowState","9","planNouserAt",2140.46,"planInnerUserAt",934.12,"planOutUserAt",8488.98,"locked","3","baseTime",parse("2020-11-02 21:15:1"),"baseRemark","jsLa","baselineId","IlU8","planWorkload",2853.96,"totalReceivables",2358.89,"budgetMarginRate",2168.6643,"contractAmt",9010.66,"planInnerUserPrice",2912.83,"planOutUserPrice",9664.67,"planOutUserCnt",7257,"planInnerUserCnt",8108,"planWorkingHours",5108,"taxRate",3658.61,"planInnerUserWorkload",5254.45,"planOutUserWorkload",760.81,"productId","U5Nm","productName","27si","templateId","Sn7a","tcuserid","nEn0","tcusername","x092","tremark","U0fg","tctime",parse("2020-11-02 21:15:1"),"tcbranchId","EsLo","shareScope","kbGz");
		List<Map<String,Object>> result=baseDao.selectList(XmProjectTemplate.class.getName()+".selectListMapByKey",p);
		Assert.assertEquals(true, result.size()>=0);
	}
 
	/**
	 * 查询一个对象 XmProjectTemplate
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","nKcH");
		
		XmProjectTemplate xmProjectTemplate1=BaseUtils.fromMap(p,XmProjectTemplate.class);
		XmProjectTemplate xmProjectTemplate=baseDao.selectOneObject(xmProjectTemplate1);
		Assert.assertEquals("nKcH", xmProjectTemplate.getId());
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
