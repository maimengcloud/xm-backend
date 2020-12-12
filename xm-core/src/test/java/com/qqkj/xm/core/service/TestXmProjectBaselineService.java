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
import  com.qqkj.xm.core.service.XmProjectBaselineService; 
import com.qqkj.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import  com.qqkj.xm.core.entity.XmProjectBaseline;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmProjectBaselineService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_project_baseline xm_project_baseline<br>
 * 实体 XmProjectBaseline<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,code,name,xmType,startTime,endTime,urgent,priority,description,createUserid,createUsername,createTime,assess,assessRemarks,status,branchId,planTotalCost,bizProcInstId,bizFlowState,planNouserAt,planInnerUserAt,planOutUserAt,locked,baseTime,baseRemark,baselineId,planWorkload,totalReceivables,budgetMarginRate,contractAmt,planInnerUserPrice,planOutUserPrice,planOutUserCnt,planInnerUserCnt,planWorkingHours,taxRate,planInnerUserWorkload,planOutUserWorkload,projectId,ctime;<br>
 * 当前表的所有字段名:<br>
 *	id,code,name,xm_type,start_time,end_time,urgent,priority,description,create_userid,create_username,create_time,assess,assess_remarks,status,branch_id,plan_total_cost,biz_proc_inst_id,biz_flow_state,plan_nouser_at,plan_inner_user_at,plan_out_user_at,locked,base_time,base_remark,baseline_id,plan_workload,total_receivables,budget_margin_rate,contract_amt,plan_inner_user_price,plan_out_user_price,plan_out_user_cnt,plan_inner_user_cnt,plan_working_hours,tax_rate,plan_inner_user_workload,plan_out_user_workload,project_id,ctime;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectBaselineService  {

	@Autowired
	XmProjectBaselineService xmProjectBaselineService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","kHCU","code","8Foq","name","2K8N","xmType","814x","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","YhSu","priority","v1l0","description","WHYq","createUserid","DRRD","createUsername","rBL3","createTime",parse("2020-10-19 23:44:56"),"assess","K4x2","assessRemarks","yx1Z","status","ezeD","branchId","XyHf","planTotalCost",2963.44,"bizProcInstId","uk6h","bizFlowState","6","planNouserAt",1015.07,"planInnerUserAt",5329.31,"planOutUserAt",116.42,"locked","k","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","WsjM","baselineId","8E29","planWorkload",7137.78,"totalReceivables",1274.3,"budgetMarginRate",3150.2501,"contractAmt",9040.85,"planInnerUserPrice",7957.85,"planOutUserPrice",8023.57,"planOutUserCnt",6727,"planInnerUserCnt",479,"planWorkingHours",3703,"taxRate",9747.29,"planInnerUserWorkload",7170.65,"planOutUserWorkload",1348.6,"projectId","sURl","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline=BaseUtils.fromMap(p,XmProjectBaseline.class);
		xmProjectBaselineService.insert(xmProjectBaseline);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("code","8Foq","name","2K8N","xmType","814x","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","YhSu","priority","v1l0","description","WHYq","createUserid","DRRD","createUsername","rBL3","createTime",parse("2020-10-19 23:44:56"),"assess","K4x2","assessRemarks","yx1Z","status","ezeD","branchId","XyHf","planTotalCost",2963.44,"bizProcInstId","uk6h","bizFlowState","6","planNouserAt",1015.07,"planInnerUserAt",5329.31,"planOutUserAt",116.42,"locked","k","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","WsjM","baselineId","8E29","planWorkload",7137.78,"totalReceivables",1274.3,"budgetMarginRate",3150.2501,"contractAmt",9040.85,"planInnerUserPrice",7957.85,"planOutUserPrice",8023.57,"planOutUserCnt",6727,"planInnerUserCnt",479,"planWorkingHours",3703,"taxRate",9747.29,"planInnerUserWorkload",7170.65,"planOutUserWorkload",1348.6,"projectId","sURl","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline=BaseUtils.fromMap(p,XmProjectBaseline.class);
		xmProjectBaselineService.deleteByWhere(xmProjectBaseline);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","kHCU");
		XmProjectBaseline xmProjectBaseline=BaseUtils.fromMap(p,XmProjectBaseline.class);
		xmProjectBaselineService.deleteByPk(xmProjectBaseline);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("code","8Foq","name","2K8N","xmType","814x","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","YhSu","priority","v1l0","description","WHYq","createUserid","DRRD","createUsername","rBL3","createTime",parse("2020-10-19 23:44:56"),"assess","K4x2","assessRemarks","yx1Z","status","ezeD","branchId","XyHf","planTotalCost",2963.44,"bizProcInstId","uk6h","bizFlowState","6","planNouserAt",1015.07,"planInnerUserAt",5329.31,"planOutUserAt",116.42,"locked","k","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","WsjM","baselineId","8E29","planWorkload",7137.78,"totalReceivables",1274.3,"budgetMarginRate",3150.2501,"contractAmt",9040.85,"planInnerUserPrice",7957.85,"planOutUserPrice",8023.57,"planOutUserCnt",6727,"planInnerUserCnt",479,"planWorkingHours",3703,"taxRate",9747.29,"planInnerUserWorkload",7170.65,"planOutUserWorkload",1348.6,"projectId","sURl","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline=BaseUtils.fromMap(where,XmProjectBaseline.class);
		xmProjectBaselineService.updateSomeFieldByPk(xmProjectBaseline);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","kHCU");
		XmProjectBaseline xmProjectBaseline=BaseUtils.fromMap(p,XmProjectBaseline.class);
		xmProjectBaselineService.updateByPk(xmProjectBaseline);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("id","kHCU","code","8Foq","name","2K8N","xmType","814x","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","YhSu","priority","v1l0","description","WHYq","createUserid","DRRD","createUsername","rBL3","createTime",parse("2020-10-19 23:44:56"),"assess","K4x2","assessRemarks","yx1Z","status","ezeD","branchId","XyHf","planTotalCost",2963.44,"bizProcInstId","uk6h","bizFlowState","6","planNouserAt",1015.07,"planInnerUserAt",5329.31,"planOutUserAt",116.42,"locked","k","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","WsjM","baselineId","8E29","planWorkload",7137.78,"totalReceivables",1274.3,"budgetMarginRate",3150.2501,"contractAmt",9040.85,"planInnerUserPrice",7957.85,"planOutUserPrice",8023.57,"planOutUserCnt",6727,"planInnerUserCnt",479,"planWorkingHours",3703,"taxRate",9747.29,"planInnerUserWorkload",7170.65,"planOutUserWorkload",1348.6,"projectId","sURl","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline=BaseUtils.fromMap(p,XmProjectBaseline.class);
		xmProjectBaselineService.insertOrUpdate(xmProjectBaseline);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmProjectBaseline> batchValues=new ArrayList<XmProjectBaseline>();
		Map p0=BaseUtils.map("id","kHCU","code","8Foq","name","2K8N","xmType","814x","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","YhSu","priority","v1l0","description","WHYq","createUserid","DRRD","createUsername","rBL3","createTime",parse("2020-10-19 23:44:56"),"assess","K4x2","assessRemarks","yx1Z","status","ezeD","branchId","XyHf","planTotalCost",2963.44,"bizProcInstId","uk6h","bizFlowState","6","planNouserAt",1015.07,"planInnerUserAt",5329.31,"planOutUserAt",116.42,"locked","k","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","WsjM","baselineId","8E29","planWorkload",7137.78,"totalReceivables",1274.3,"budgetMarginRate",3150.2501,"contractAmt",9040.85,"planInnerUserPrice",7957.85,"planOutUserPrice",8023.57,"planOutUserCnt",6727,"planInnerUserCnt",479,"planWorkingHours",3703,"taxRate",9747.29,"planInnerUserWorkload",7170.65,"planOutUserWorkload",1348.6,"projectId","sURl","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline0=BaseUtils.fromMap(p0,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline0);
		Map p1=BaseUtils.map("id","8My6","code","VfeQ","name","tnCo","xmType","zn14","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","ZqbB","priority","Jv8Q","description","H9Fa","createUserid","lqaS","createUsername","OcYg","createTime",parse("2020-10-19 23:44:56"),"assess","NoSw","assessRemarks","97o1","status","1ZWS","branchId","8bCj","planTotalCost",4771.57,"bizProcInstId","254g","bizFlowState","c","planNouserAt",5630.44,"planInnerUserAt",8351.38,"planOutUserAt",3786.63,"locked","y","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","I3lo","baselineId","3qqY","planWorkload",6333.12,"totalReceivables",9944.61,"budgetMarginRate",6390.6224,"contractAmt",6552.22,"planInnerUserPrice",786.74,"planOutUserPrice",8525.71,"planOutUserCnt",4572,"planInnerUserCnt",6395,"planWorkingHours",4573,"taxRate",5240.24,"planInnerUserWorkload",2037.86,"planOutUserWorkload",1677.36,"projectId","VtUw","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline1=BaseUtils.fromMap(p1,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline1);
		Map p2=BaseUtils.map("id","6vE9","code","LV2E","name","2cxB","xmType","1593","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","IO1t","priority","QmlI","description","Fj04","createUserid","5e8P","createUsername","94Lw","createTime",parse("2020-10-19 23:44:56"),"assess","I1q4","assessRemarks","1KVs","status","KZC0","branchId","56AA","planTotalCost",4994,"bizProcInstId","CaNj","bizFlowState","0","planNouserAt",6886.1,"planInnerUserAt",8219.25,"planOutUserAt",137.35,"locked","C","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","Qgvw","baselineId","w8Ox","planWorkload",4071.68,"totalReceivables",322.59,"budgetMarginRate",5158.9692,"contractAmt",700.86,"planInnerUserPrice",7066.71,"planOutUserPrice",4968.93,"planOutUserCnt",4988,"planInnerUserCnt",4385,"planWorkingHours",363,"taxRate",1654.61,"planInnerUserWorkload",3641.22,"planOutUserWorkload",911.82,"projectId","eNgA","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline2=BaseUtils.fromMap(p2,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline2);
		Map p3=BaseUtils.map("id","nFzV","code","K6Ht","name","Vulu","xmType","oubh","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","KZ3m","priority","26n7","description","w6qU","createUserid","oJ7B","createUsername","25qW","createTime",parse("2020-10-19 23:44:56"),"assess","3A6j","assessRemarks","ujC4","status","v9FF","branchId","7Ao2","planTotalCost",607.56,"bizProcInstId","6SW4","bizFlowState","S","planNouserAt",5643.73,"planInnerUserAt",4994.06,"planOutUserAt",9603.1,"locked","x","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","1o08","baselineId","6NjO","planWorkload",6494.26,"totalReceivables",7974.22,"budgetMarginRate",8232.129,"contractAmt",7686.05,"planInnerUserPrice",2112.74,"planOutUserPrice",7183.03,"planOutUserCnt",6225,"planInnerUserCnt",1275,"planWorkingHours",2055,"taxRate",2537.21,"planInnerUserWorkload",4077.86,"planOutUserWorkload",6398.68,"projectId","hJsD","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline3=BaseUtils.fromMap(p3,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline3);
		Map p4=BaseUtils.map("id","WMm2","code","u9gR","name","Au75","xmType","1P1o","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","bXfP","priority","fYH8","description","lnEH","createUserid","qNM2","createUsername","cfMw","createTime",parse("2020-10-19 23:44:56"),"assess","Ane8","assessRemarks","ASmx","status","lsVG","branchId","fLqZ","planTotalCost",2615.69,"bizProcInstId","00L0","bizFlowState","T","planNouserAt",1371.64,"planInnerUserAt",9229.75,"planOutUserAt",9784.53,"locked","2","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","IcS6","baselineId","Z3K8","planWorkload",4102.57,"totalReceivables",1318.92,"budgetMarginRate",9782.6622,"contractAmt",618.57,"planInnerUserPrice",498.12,"planOutUserPrice",5777.63,"planOutUserCnt",1362,"planInnerUserCnt",9917,"planWorkingHours",8695,"taxRate",8546.87,"planInnerUserWorkload",8013.11,"planOutUserWorkload",8389.93,"projectId","MNNF","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline4=BaseUtils.fromMap(p4,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline4);
		Map p5=BaseUtils.map("id","4U2N","code","naAe","name","SJE1","xmType","3wPG","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","2b13","priority","7q9X","description","6UUV","createUserid","gh1r","createUsername","kh90","createTime",parse("2020-10-19 23:44:56"),"assess","cRxy","assessRemarks","QXqL","status","7aeY","branchId","N1HT","planTotalCost",6440.96,"bizProcInstId","U02r","bizFlowState","r","planNouserAt",4433.64,"planInnerUserAt",8631.94,"planOutUserAt",219.32,"locked","E","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","0USW","baselineId","LqRR","planWorkload",3652.5,"totalReceivables",408.83,"budgetMarginRate",4253.5332,"contractAmt",6371.25,"planInnerUserPrice",6843.73,"planOutUserPrice",1513.29,"planOutUserCnt",9289,"planInnerUserCnt",4703,"planWorkingHours",4355,"taxRate",4740.06,"planInnerUserWorkload",6857.03,"planOutUserWorkload",3528.27,"projectId","Zwh7","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline5=BaseUtils.fromMap(p5,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline5);
		Map p6=BaseUtils.map("id","NnNu","code","ISs4","name","5Vkx","xmType","h41c","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","5clb","priority","UjOq","description","IClI","createUserid","JMCS","createUsername","VV8e","createTime",parse("2020-10-19 23:44:56"),"assess","M0bS","assessRemarks","Y40T","status","ARpj","branchId","tMGW","planTotalCost",4601.85,"bizProcInstId","5C2N","bizFlowState","E","planNouserAt",8989.8,"planInnerUserAt",8680.44,"planOutUserAt",5300.48,"locked","m","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","UxL0","baselineId","0fbW","planWorkload",7712.97,"totalReceivables",182.85,"budgetMarginRate",6516.6959,"contractAmt",3466.45,"planInnerUserPrice",6682.84,"planOutUserPrice",8522.3,"planOutUserCnt",8594,"planInnerUserCnt",5938,"planWorkingHours",1984,"taxRate",7434.95,"planInnerUserWorkload",1923.09,"planOutUserWorkload",9180.09,"projectId","sDOO","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline6=BaseUtils.fromMap(p6,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline6);
		Map p7=BaseUtils.map("id","e636","code","Cp5V","name","FN98","xmType","aLjY","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","EIpn","priority","61UG","description","MJ8K","createUserid","5Q9S","createUsername","gOiX","createTime",parse("2020-10-19 23:44:56"),"assess","Wsl0","assessRemarks","EZmb","status","KD5h","branchId","4p74","planTotalCost",4793.56,"bizProcInstId","zXgB","bizFlowState","8","planNouserAt",6204.33,"planInnerUserAt",6053.23,"planOutUserAt",4440.15,"locked","6","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","SRbk","baselineId","DG97","planWorkload",9842.63,"totalReceivables",5578.23,"budgetMarginRate",9447.9943,"contractAmt",5878.83,"planInnerUserPrice",922.59,"planOutUserPrice",643.13,"planOutUserCnt",306,"planInnerUserCnt",7078,"planWorkingHours",2644,"taxRate",3932.87,"planInnerUserWorkload",2686.03,"planOutUserWorkload",5881.98,"projectId","xx01","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline7=BaseUtils.fromMap(p7,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline7);
		xmProjectBaselineService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmProjectBaseline> batchValues=new ArrayList<XmProjectBaseline>();
		Map p0=BaseUtils.map("id","kHCU","code","8Foq","name","2K8N","xmType","814x","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","YhSu","priority","v1l0","description","WHYq","createUserid","DRRD","createUsername","rBL3","createTime",parse("2020-10-19 23:44:56"),"assess","K4x2","assessRemarks","yx1Z","status","ezeD","branchId","XyHf","planTotalCost",2963.44,"bizProcInstId","uk6h","bizFlowState","6","planNouserAt",1015.07,"planInnerUserAt",5329.31,"planOutUserAt",116.42,"locked","k","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","WsjM","baselineId","8E29","planWorkload",7137.78,"totalReceivables",1274.3,"budgetMarginRate",3150.2501,"contractAmt",9040.85,"planInnerUserPrice",7957.85,"planOutUserPrice",8023.57,"planOutUserCnt",6727,"planInnerUserCnt",479,"planWorkingHours",3703,"taxRate",9747.29,"planInnerUserWorkload",7170.65,"planOutUserWorkload",1348.6,"projectId","sURl","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline0=BaseUtils.fromMap(p0,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline0);
		Map p1=BaseUtils.map("id","8My6","code","VfeQ","name","tnCo","xmType","zn14","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","ZqbB","priority","Jv8Q","description","H9Fa","createUserid","lqaS","createUsername","OcYg","createTime",parse("2020-10-19 23:44:56"),"assess","NoSw","assessRemarks","97o1","status","1ZWS","branchId","8bCj","planTotalCost",4771.57,"bizProcInstId","254g","bizFlowState","c","planNouserAt",5630.44,"planInnerUserAt",8351.38,"planOutUserAt",3786.63,"locked","y","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","I3lo","baselineId","3qqY","planWorkload",6333.12,"totalReceivables",9944.61,"budgetMarginRate",6390.6224,"contractAmt",6552.22,"planInnerUserPrice",786.74,"planOutUserPrice",8525.71,"planOutUserCnt",4572,"planInnerUserCnt",6395,"planWorkingHours",4573,"taxRate",5240.24,"planInnerUserWorkload",2037.86,"planOutUserWorkload",1677.36,"projectId","VtUw","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline1=BaseUtils.fromMap(p1,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline1);
		Map p2=BaseUtils.map("id","6vE9","code","LV2E","name","2cxB","xmType","1593","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","IO1t","priority","QmlI","description","Fj04","createUserid","5e8P","createUsername","94Lw","createTime",parse("2020-10-19 23:44:56"),"assess","I1q4","assessRemarks","1KVs","status","KZC0","branchId","56AA","planTotalCost",4994,"bizProcInstId","CaNj","bizFlowState","0","planNouserAt",6886.1,"planInnerUserAt",8219.25,"planOutUserAt",137.35,"locked","C","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","Qgvw","baselineId","w8Ox","planWorkload",4071.68,"totalReceivables",322.59,"budgetMarginRate",5158.9692,"contractAmt",700.86,"planInnerUserPrice",7066.71,"planOutUserPrice",4968.93,"planOutUserCnt",4988,"planInnerUserCnt",4385,"planWorkingHours",363,"taxRate",1654.61,"planInnerUserWorkload",3641.22,"planOutUserWorkload",911.82,"projectId","eNgA","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline2=BaseUtils.fromMap(p2,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline2);
		Map p3=BaseUtils.map("id","nFzV","code","K6Ht","name","Vulu","xmType","oubh","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","KZ3m","priority","26n7","description","w6qU","createUserid","oJ7B","createUsername","25qW","createTime",parse("2020-10-19 23:44:56"),"assess","3A6j","assessRemarks","ujC4","status","v9FF","branchId","7Ao2","planTotalCost",607.56,"bizProcInstId","6SW4","bizFlowState","S","planNouserAt",5643.73,"planInnerUserAt",4994.06,"planOutUserAt",9603.1,"locked","x","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","1o08","baselineId","6NjO","planWorkload",6494.26,"totalReceivables",7974.22,"budgetMarginRate",8232.129,"contractAmt",7686.05,"planInnerUserPrice",2112.74,"planOutUserPrice",7183.03,"planOutUserCnt",6225,"planInnerUserCnt",1275,"planWorkingHours",2055,"taxRate",2537.21,"planInnerUserWorkload",4077.86,"planOutUserWorkload",6398.68,"projectId","hJsD","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline3=BaseUtils.fromMap(p3,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline3);
		Map p4=BaseUtils.map("id","WMm2","code","u9gR","name","Au75","xmType","1P1o","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","bXfP","priority","fYH8","description","lnEH","createUserid","qNM2","createUsername","cfMw","createTime",parse("2020-10-19 23:44:56"),"assess","Ane8","assessRemarks","ASmx","status","lsVG","branchId","fLqZ","planTotalCost",2615.69,"bizProcInstId","00L0","bizFlowState","T","planNouserAt",1371.64,"planInnerUserAt",9229.75,"planOutUserAt",9784.53,"locked","2","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","IcS6","baselineId","Z3K8","planWorkload",4102.57,"totalReceivables",1318.92,"budgetMarginRate",9782.6622,"contractAmt",618.57,"planInnerUserPrice",498.12,"planOutUserPrice",5777.63,"planOutUserCnt",1362,"planInnerUserCnt",9917,"planWorkingHours",8695,"taxRate",8546.87,"planInnerUserWorkload",8013.11,"planOutUserWorkload",8389.93,"projectId","MNNF","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline4=BaseUtils.fromMap(p4,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline4);
		Map p5=BaseUtils.map("id","4U2N","code","naAe","name","SJE1","xmType","3wPG","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","2b13","priority","7q9X","description","6UUV","createUserid","gh1r","createUsername","kh90","createTime",parse("2020-10-19 23:44:56"),"assess","cRxy","assessRemarks","QXqL","status","7aeY","branchId","N1HT","planTotalCost",6440.96,"bizProcInstId","U02r","bizFlowState","r","planNouserAt",4433.64,"planInnerUserAt",8631.94,"planOutUserAt",219.32,"locked","E","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","0USW","baselineId","LqRR","planWorkload",3652.5,"totalReceivables",408.83,"budgetMarginRate",4253.5332,"contractAmt",6371.25,"planInnerUserPrice",6843.73,"planOutUserPrice",1513.29,"planOutUserCnt",9289,"planInnerUserCnt",4703,"planWorkingHours",4355,"taxRate",4740.06,"planInnerUserWorkload",6857.03,"planOutUserWorkload",3528.27,"projectId","Zwh7","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline5=BaseUtils.fromMap(p5,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline5);
		Map p6=BaseUtils.map("id","NnNu","code","ISs4","name","5Vkx","xmType","h41c","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","5clb","priority","UjOq","description","IClI","createUserid","JMCS","createUsername","VV8e","createTime",parse("2020-10-19 23:44:56"),"assess","M0bS","assessRemarks","Y40T","status","ARpj","branchId","tMGW","planTotalCost",4601.85,"bizProcInstId","5C2N","bizFlowState","E","planNouserAt",8989.8,"planInnerUserAt",8680.44,"planOutUserAt",5300.48,"locked","m","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","UxL0","baselineId","0fbW","planWorkload",7712.97,"totalReceivables",182.85,"budgetMarginRate",6516.6959,"contractAmt",3466.45,"planInnerUserPrice",6682.84,"planOutUserPrice",8522.3,"planOutUserCnt",8594,"planInnerUserCnt",5938,"planWorkingHours",1984,"taxRate",7434.95,"planInnerUserWorkload",1923.09,"planOutUserWorkload",9180.09,"projectId","sDOO","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline6=BaseUtils.fromMap(p6,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline6);
		Map p7=BaseUtils.map("id","e636","code","Cp5V","name","FN98","xmType","aLjY","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","EIpn","priority","61UG","description","MJ8K","createUserid","5Q9S","createUsername","gOiX","createTime",parse("2020-10-19 23:44:56"),"assess","Wsl0","assessRemarks","EZmb","status","KD5h","branchId","4p74","planTotalCost",4793.56,"bizProcInstId","zXgB","bizFlowState","8","planNouserAt",6204.33,"planInnerUserAt",6053.23,"planOutUserAt",4440.15,"locked","6","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","SRbk","baselineId","DG97","planWorkload",9842.63,"totalReceivables",5578.23,"budgetMarginRate",9447.9943,"contractAmt",5878.83,"planInnerUserPrice",922.59,"planOutUserPrice",643.13,"planOutUserCnt",306,"planInnerUserCnt",7078,"planWorkingHours",2644,"taxRate",3932.87,"planInnerUserWorkload",2686.03,"planOutUserWorkload",5881.98,"projectId","xx01","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline7=BaseUtils.fromMap(p7,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline7);
		xmProjectBaselineService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmProjectBaseline> batchValues=new ArrayList<XmProjectBaseline>();
		Map p0=BaseUtils.map("id","kHCU","code","8Foq","name","2K8N","xmType","814x","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","YhSu","priority","v1l0","description","WHYq","createUserid","DRRD","createUsername","rBL3","createTime",parse("2020-10-19 23:44:56"),"assess","K4x2","assessRemarks","yx1Z","status","ezeD","branchId","XyHf","planTotalCost",2963.44,"bizProcInstId","uk6h","bizFlowState","6","planNouserAt",1015.07,"planInnerUserAt",5329.31,"planOutUserAt",116.42,"locked","k","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","WsjM","baselineId","8E29","planWorkload",7137.78,"totalReceivables",1274.3,"budgetMarginRate",3150.2501,"contractAmt",9040.85,"planInnerUserPrice",7957.85,"planOutUserPrice",8023.57,"planOutUserCnt",6727,"planInnerUserCnt",479,"planWorkingHours",3703,"taxRate",9747.29,"planInnerUserWorkload",7170.65,"planOutUserWorkload",1348.6,"projectId","sURl","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline0=BaseUtils.fromMap(p0,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline0);
		Map p1=BaseUtils.map("id","8My6","code","VfeQ","name","tnCo","xmType","zn14","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","ZqbB","priority","Jv8Q","description","H9Fa","createUserid","lqaS","createUsername","OcYg","createTime",parse("2020-10-19 23:44:56"),"assess","NoSw","assessRemarks","97o1","status","1ZWS","branchId","8bCj","planTotalCost",4771.57,"bizProcInstId","254g","bizFlowState","c","planNouserAt",5630.44,"planInnerUserAt",8351.38,"planOutUserAt",3786.63,"locked","y","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","I3lo","baselineId","3qqY","planWorkload",6333.12,"totalReceivables",9944.61,"budgetMarginRate",6390.6224,"contractAmt",6552.22,"planInnerUserPrice",786.74,"planOutUserPrice",8525.71,"planOutUserCnt",4572,"planInnerUserCnt",6395,"planWorkingHours",4573,"taxRate",5240.24,"planInnerUserWorkload",2037.86,"planOutUserWorkload",1677.36,"projectId","VtUw","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline1=BaseUtils.fromMap(p1,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline1);
		Map p2=BaseUtils.map("id","6vE9","code","LV2E","name","2cxB","xmType","1593","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","IO1t","priority","QmlI","description","Fj04","createUserid","5e8P","createUsername","94Lw","createTime",parse("2020-10-19 23:44:56"),"assess","I1q4","assessRemarks","1KVs","status","KZC0","branchId","56AA","planTotalCost",4994,"bizProcInstId","CaNj","bizFlowState","0","planNouserAt",6886.1,"planInnerUserAt",8219.25,"planOutUserAt",137.35,"locked","C","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","Qgvw","baselineId","w8Ox","planWorkload",4071.68,"totalReceivables",322.59,"budgetMarginRate",5158.9692,"contractAmt",700.86,"planInnerUserPrice",7066.71,"planOutUserPrice",4968.93,"planOutUserCnt",4988,"planInnerUserCnt",4385,"planWorkingHours",363,"taxRate",1654.61,"planInnerUserWorkload",3641.22,"planOutUserWorkload",911.82,"projectId","eNgA","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline2=BaseUtils.fromMap(p2,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline2);
		Map p3=BaseUtils.map("id","nFzV","code","K6Ht","name","Vulu","xmType","oubh","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","KZ3m","priority","26n7","description","w6qU","createUserid","oJ7B","createUsername","25qW","createTime",parse("2020-10-19 23:44:56"),"assess","3A6j","assessRemarks","ujC4","status","v9FF","branchId","7Ao2","planTotalCost",607.56,"bizProcInstId","6SW4","bizFlowState","S","planNouserAt",5643.73,"planInnerUserAt",4994.06,"planOutUserAt",9603.1,"locked","x","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","1o08","baselineId","6NjO","planWorkload",6494.26,"totalReceivables",7974.22,"budgetMarginRate",8232.129,"contractAmt",7686.05,"planInnerUserPrice",2112.74,"planOutUserPrice",7183.03,"planOutUserCnt",6225,"planInnerUserCnt",1275,"planWorkingHours",2055,"taxRate",2537.21,"planInnerUserWorkload",4077.86,"planOutUserWorkload",6398.68,"projectId","hJsD","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline3=BaseUtils.fromMap(p3,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline3);
		Map p4=BaseUtils.map("id","WMm2","code","u9gR","name","Au75","xmType","1P1o","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","bXfP","priority","fYH8","description","lnEH","createUserid","qNM2","createUsername","cfMw","createTime",parse("2020-10-19 23:44:56"),"assess","Ane8","assessRemarks","ASmx","status","lsVG","branchId","fLqZ","planTotalCost",2615.69,"bizProcInstId","00L0","bizFlowState","T","planNouserAt",1371.64,"planInnerUserAt",9229.75,"planOutUserAt",9784.53,"locked","2","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","IcS6","baselineId","Z3K8","planWorkload",4102.57,"totalReceivables",1318.92,"budgetMarginRate",9782.6622,"contractAmt",618.57,"planInnerUserPrice",498.12,"planOutUserPrice",5777.63,"planOutUserCnt",1362,"planInnerUserCnt",9917,"planWorkingHours",8695,"taxRate",8546.87,"planInnerUserWorkload",8013.11,"planOutUserWorkload",8389.93,"projectId","MNNF","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline4=BaseUtils.fromMap(p4,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline4);
		Map p5=BaseUtils.map("id","4U2N","code","naAe","name","SJE1","xmType","3wPG","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","2b13","priority","7q9X","description","6UUV","createUserid","gh1r","createUsername","kh90","createTime",parse("2020-10-19 23:44:56"),"assess","cRxy","assessRemarks","QXqL","status","7aeY","branchId","N1HT","planTotalCost",6440.96,"bizProcInstId","U02r","bizFlowState","r","planNouserAt",4433.64,"planInnerUserAt",8631.94,"planOutUserAt",219.32,"locked","E","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","0USW","baselineId","LqRR","planWorkload",3652.5,"totalReceivables",408.83,"budgetMarginRate",4253.5332,"contractAmt",6371.25,"planInnerUserPrice",6843.73,"planOutUserPrice",1513.29,"planOutUserCnt",9289,"planInnerUserCnt",4703,"planWorkingHours",4355,"taxRate",4740.06,"planInnerUserWorkload",6857.03,"planOutUserWorkload",3528.27,"projectId","Zwh7","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline5=BaseUtils.fromMap(p5,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline5);
		Map p6=BaseUtils.map("id","NnNu","code","ISs4","name","5Vkx","xmType","h41c","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","5clb","priority","UjOq","description","IClI","createUserid","JMCS","createUsername","VV8e","createTime",parse("2020-10-19 23:44:56"),"assess","M0bS","assessRemarks","Y40T","status","ARpj","branchId","tMGW","planTotalCost",4601.85,"bizProcInstId","5C2N","bizFlowState","E","planNouserAt",8989.8,"planInnerUserAt",8680.44,"planOutUserAt",5300.48,"locked","m","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","UxL0","baselineId","0fbW","planWorkload",7712.97,"totalReceivables",182.85,"budgetMarginRate",6516.6959,"contractAmt",3466.45,"planInnerUserPrice",6682.84,"planOutUserPrice",8522.3,"planOutUserCnt",8594,"planInnerUserCnt",5938,"planWorkingHours",1984,"taxRate",7434.95,"planInnerUserWorkload",1923.09,"planOutUserWorkload",9180.09,"projectId","sDOO","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline6=BaseUtils.fromMap(p6,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline6);
		Map p7=BaseUtils.map("id","e636","code","Cp5V","name","FN98","xmType","aLjY","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","EIpn","priority","61UG","description","MJ8K","createUserid","5Q9S","createUsername","gOiX","createTime",parse("2020-10-19 23:44:56"),"assess","Wsl0","assessRemarks","EZmb","status","KD5h","branchId","4p74","planTotalCost",4793.56,"bizProcInstId","zXgB","bizFlowState","8","planNouserAt",6204.33,"planInnerUserAt",6053.23,"planOutUserAt",4440.15,"locked","6","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","SRbk","baselineId","DG97","planWorkload",9842.63,"totalReceivables",5578.23,"budgetMarginRate",9447.9943,"contractAmt",5878.83,"planInnerUserPrice",922.59,"planOutUserPrice",643.13,"planOutUserCnt",306,"planInnerUserCnt",7078,"planWorkingHours",2644,"taxRate",3932.87,"planInnerUserWorkload",2686.03,"planOutUserWorkload",5881.98,"projectId","xx01","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline7=BaseUtils.fromMap(p7,XmProjectBaseline.class);
		batchValues.add(xmProjectBaseline7);
		xmProjectBaselineService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","kHCU");
		Map<String,Object> result=this.xmProjectBaselineService.selectOne(XmProjectBaseline.class.getName()+".selectOneMap",p);
		Assert.assertEquals("kHCU", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("code","8Foq","name","2K8N","xmType","814x","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","YhSu","priority","v1l0","description","WHYq","createUserid","DRRD","createUsername","rBL3","createTime",parse("2020-10-19 23:44:56"),"assess","K4x2","assessRemarks","yx1Z","status","ezeD","branchId","XyHf","planTotalCost",2963.44,"bizProcInstId","uk6h","bizFlowState","6","planNouserAt",1015.07,"planInnerUserAt",5329.31,"planOutUserAt",116.42,"locked","k","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","WsjM","baselineId","8E29","planWorkload",7137.78,"totalReceivables",1274.3,"budgetMarginRate",3150.2501,"contractAmt",9040.85,"planInnerUserPrice",7957.85,"planOutUserPrice",8023.57,"planOutUserCnt",6727,"planInnerUserCnt",479,"planWorkingHours",3703,"taxRate",9747.29,"planInnerUserWorkload",7170.65,"planOutUserWorkload",1348.6,"projectId","sURl","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline=BaseUtils.fromMap(p,XmProjectBaseline.class);
		long result=xmProjectBaselineService.countByWhere(xmProjectBaseline);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("code","8Foq","name","2K8N","xmType","814x","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","YhSu","priority","v1l0","description","WHYq","createUserid","DRRD","createUsername","rBL3","createTime",parse("2020-10-19 23:44:56"),"assess","K4x2","assessRemarks","yx1Z","status","ezeD","branchId","XyHf","planTotalCost",2963.44,"bizProcInstId","uk6h","bizFlowState","6","planNouserAt",1015.07,"planInnerUserAt",5329.31,"planOutUserAt",116.42,"locked","k","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","WsjM","baselineId","8E29","planWorkload",7137.78,"totalReceivables",1274.3,"budgetMarginRate",3150.2501,"contractAmt",9040.85,"planInnerUserPrice",7957.85,"planOutUserPrice",8023.57,"planOutUserCnt",6727,"planInnerUserCnt",479,"planWorkingHours",3703,"taxRate",9747.29,"planInnerUserWorkload",7170.65,"planOutUserWorkload",1348.6,"projectId","sURl","ctime",parse("2020-10-19 23:44:56"));
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmProjectBaseline xmProjectBaseline=BaseUtils.fromMap(p,XmProjectBaseline.class);
		List<XmProjectBaseline> result=xmProjectBaselineService.selectListByWhere(xmProjectBaseline); 
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
	
		
		Map<String,Object> p=BaseUtils.map("code","8Foq","name","2K8N","xmType","814x","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","YhSu","priority","v1l0","description","WHYq","createUserid","DRRD","createUsername","rBL3","createTime",parse("2020-10-19 23:44:56"),"assess","K4x2","assessRemarks","yx1Z","status","ezeD","branchId","XyHf","planTotalCost",2963.44,"bizProcInstId","uk6h","bizFlowState","6","planNouserAt",1015.07,"planInnerUserAt",5329.31,"planOutUserAt",116.42,"locked","k","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","WsjM","baselineId","8E29","planWorkload",7137.78,"totalReceivables",1274.3,"budgetMarginRate",3150.2501,"contractAmt",9040.85,"planInnerUserPrice",7957.85,"planOutUserPrice",8023.57,"planOutUserCnt",6727,"planInnerUserCnt",479,"planWorkingHours",3703,"taxRate",9747.29,"planInnerUserWorkload",7170.65,"planOutUserWorkload",1348.6,"projectId","sURl","ctime",parse("2020-10-19 23:44:56"));
		XmProjectBaseline xmProjectBaseline=BaseUtils.fromMap(p,XmProjectBaseline.class);
		List<XmProjectBaseline> result=xmProjectBaselineService.selectListByWhere(xmProjectBaseline);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("code","8Foq","name","2K8N","xmType","814x","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","YhSu","priority","v1l0","description","WHYq","createUserid","DRRD","createUsername","rBL3","createTime",parse("2020-10-19 23:44:56"),"assess","K4x2","assessRemarks","yx1Z","status","ezeD","branchId","XyHf","planTotalCost",2963.44,"bizProcInstId","uk6h","bizFlowState","6","planNouserAt",1015.07,"planInnerUserAt",5329.31,"planOutUserAt",116.42,"locked","k","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","WsjM","baselineId","8E29","planWorkload",7137.78,"totalReceivables",1274.3,"budgetMarginRate",3150.2501,"contractAmt",9040.85,"planInnerUserPrice",7957.85,"planOutUserPrice",8023.57,"planOutUserCnt",6727,"planInnerUserCnt",479,"planWorkingHours",3703,"taxRate",9747.29,"planInnerUserWorkload",7170.65,"planOutUserWorkload",1348.6,"projectId","sURl","ctime",parse("2020-10-19 23:44:56"));
		List<Map<String,Object>> result=xmProjectBaselineService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("code","8Foq","name","2K8N","xmType","814x","startTime",parse("2020-10-19 23:44:56"),"endTime",parse("2020-10-19 23:44:56"),"urgent","YhSu","priority","v1l0","description","WHYq","createUserid","DRRD","createUsername","rBL3","createTime",parse("2020-10-19 23:44:56"),"assess","K4x2","assessRemarks","yx1Z","status","ezeD","branchId","XyHf","planTotalCost",2963.44,"bizProcInstId","uk6h","bizFlowState","6","planNouserAt",1015.07,"planInnerUserAt",5329.31,"planOutUserAt",116.42,"locked","k","baseTime",parse("2020-10-19 23:44:56"),"baseRemark","WsjM","baselineId","8E29","planWorkload",7137.78,"totalReceivables",1274.3,"budgetMarginRate",3150.2501,"contractAmt",9040.85,"planInnerUserPrice",7957.85,"planOutUserPrice",8023.57,"planOutUserCnt",6727,"planInnerUserCnt",479,"planWorkingHours",3703,"taxRate",9747.29,"planInnerUserWorkload",7170.65,"planOutUserWorkload",1348.6,"projectId","sURl","ctime",parse("2020-10-19 23:44:56"));
		List<Map<String,Object>> result=xmProjectBaselineService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmProjectBaseline
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","kHCU");
		
		XmProjectBaseline xmProjectBaseline1=BaseUtils.fromMap(p,XmProjectBaseline.class);
		XmProjectBaseline xmProjectBaseline=xmProjectBaselineService.selectOneObject(xmProjectBaseline1);
		Assert.assertEquals("kHCU", xmProjectBaseline.getId());
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
