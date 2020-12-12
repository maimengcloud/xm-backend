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
import  com.qqkj.xm.core.service.XmBranchTaskTypeStateService; 
import com.qqkj.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import  com.qqkj.xm.core.entity.XmBranchTaskTypeState;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmBranchTaskTypeStateService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_branch_task_type_state 按机构编号任务类型汇总<br>
 * 实体 XmBranchTaskTypeState<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	taskType,planWorkload,planAmount,actWorkload,actAmount,branchId,bizDate,calcTime,planOutUserAt,planInnerUserAt,actOutUserAt,actInnerUserAt,planOutUserWorkload,planInnerUserWorkload,actOutUserWorkload,actInnerUserWorkload,planNouserAt,actNouserAt,id,branchName;<br>
 * 当前表的所有字段名:<br>
 *	task_type,plan_workload,plan_amount,act_workload,act_amount,branch_id,biz_date,calc_time,plan_out_user_at,plan_inner_user_at,act_out_user_at,act_inner_user_at,plan_out_user_workload,plan_inner_user_workload,act_out_user_workload,act_inner_user_workload,plan_nouser_at,act_nouser_at,id,branch_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmBranchTaskTypeStateService  {

	@Autowired
	XmBranchTaskTypeStateService xmBranchTaskTypeStateService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("taskType","E09l","planWorkload",1192.81,"planAmount",6555.18,"actWorkload",4241.27,"actAmount",3880.71,"branchId","2mgw","bizDate","o1Ey","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",139.59,"planInnerUserAt",9731.77,"actOutUserAt",4480.89,"actInnerUserAt",495.38,"planOutUserWorkload",8957.68,"planInnerUserWorkload",5976.21,"actOutUserWorkload",8269.72,"actInnerUserWorkload",3691.71,"planNouserAt",7317.09,"actNouserAt",6360.64,"id","V5oK","branchName","C92i");
		XmBranchTaskTypeState xmBranchTaskTypeState=BaseUtils.fromMap(p,XmBranchTaskTypeState.class);
		xmBranchTaskTypeStateService.insert(xmBranchTaskTypeState);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("taskType","E09l","planWorkload",1192.81,"planAmount",6555.18,"actWorkload",4241.27,"actAmount",3880.71,"branchId","2mgw","bizDate","o1Ey","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",139.59,"planInnerUserAt",9731.77,"actOutUserAt",4480.89,"actInnerUserAt",495.38,"planOutUserWorkload",8957.68,"planInnerUserWorkload",5976.21,"actOutUserWorkload",8269.72,"actInnerUserWorkload",3691.71,"planNouserAt",7317.09,"actNouserAt",6360.64,"branchName","C92i");
		XmBranchTaskTypeState xmBranchTaskTypeState=BaseUtils.fromMap(p,XmBranchTaskTypeState.class);
		xmBranchTaskTypeStateService.deleteByWhere(xmBranchTaskTypeState);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","V5oK");
		XmBranchTaskTypeState xmBranchTaskTypeState=BaseUtils.fromMap(p,XmBranchTaskTypeState.class);
		xmBranchTaskTypeStateService.deleteByPk(xmBranchTaskTypeState);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("taskType","E09l","planWorkload",1192.81,"planAmount",6555.18,"actWorkload",4241.27,"actAmount",3880.71,"branchId","2mgw","bizDate","o1Ey","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",139.59,"planInnerUserAt",9731.77,"actOutUserAt",4480.89,"actInnerUserAt",495.38,"planOutUserWorkload",8957.68,"planInnerUserWorkload",5976.21,"actOutUserWorkload",8269.72,"actInnerUserWorkload",3691.71,"planNouserAt",7317.09,"actNouserAt",6360.64,"branchName","C92i");
		XmBranchTaskTypeState xmBranchTaskTypeState=BaseUtils.fromMap(where,XmBranchTaskTypeState.class);
		xmBranchTaskTypeStateService.updateSomeFieldByPk(xmBranchTaskTypeState);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","V5oK");
		XmBranchTaskTypeState xmBranchTaskTypeState=BaseUtils.fromMap(p,XmBranchTaskTypeState.class);
		xmBranchTaskTypeStateService.updateByPk(xmBranchTaskTypeState);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("taskType","E09l","planWorkload",1192.81,"planAmount",6555.18,"actWorkload",4241.27,"actAmount",3880.71,"branchId","2mgw","bizDate","o1Ey","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",139.59,"planInnerUserAt",9731.77,"actOutUserAt",4480.89,"actInnerUserAt",495.38,"planOutUserWorkload",8957.68,"planInnerUserWorkload",5976.21,"actOutUserWorkload",8269.72,"actInnerUserWorkload",3691.71,"planNouserAt",7317.09,"actNouserAt",6360.64,"id","V5oK","branchName","C92i");
		XmBranchTaskTypeState xmBranchTaskTypeState=BaseUtils.fromMap(p,XmBranchTaskTypeState.class);
		xmBranchTaskTypeStateService.insertOrUpdate(xmBranchTaskTypeState);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmBranchTaskTypeState> batchValues=new ArrayList<XmBranchTaskTypeState>();
		Map p0=BaseUtils.map("taskType","E09l","planWorkload",1192.81,"planAmount",6555.18,"actWorkload",4241.27,"actAmount",3880.71,"branchId","2mgw","bizDate","o1Ey","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",139.59,"planInnerUserAt",9731.77,"actOutUserAt",4480.89,"actInnerUserAt",495.38,"planOutUserWorkload",8957.68,"planInnerUserWorkload",5976.21,"actOutUserWorkload",8269.72,"actInnerUserWorkload",3691.71,"planNouserAt",7317.09,"actNouserAt",6360.64,"id","V5oK","branchName","C92i");
		XmBranchTaskTypeState xmBranchTaskTypeState0=BaseUtils.fromMap(p0,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState0);
		Map p1=BaseUtils.map("taskType","9zmQ","planWorkload",6414.29,"planAmount",8613.01,"actWorkload",6074.24,"actAmount",1585.63,"branchId","F1B1","bizDate","4J09","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",4986.51,"planInnerUserAt",5269.71,"actOutUserAt",6358.17,"actInnerUserAt",5748.92,"planOutUserWorkload",3795.92,"planInnerUserWorkload",2411.19,"actOutUserWorkload",8545.13,"actInnerUserWorkload",5644.14,"planNouserAt",4031.15,"actNouserAt",1601.44,"id","OCR8","branchName","LS4m");
		XmBranchTaskTypeState xmBranchTaskTypeState1=BaseUtils.fromMap(p1,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState1);
		Map p2=BaseUtils.map("taskType","0499","planWorkload",3150.36,"planAmount",1174.81,"actWorkload",5450.83,"actAmount",1609.23,"branchId","pb30","bizDate","wyBq","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",2149.09,"planInnerUserAt",1744.78,"actOutUserAt",9299.14,"actInnerUserAt",5674.23,"planOutUserWorkload",5381.09,"planInnerUserWorkload",8149.75,"actOutUserWorkload",5947.91,"actInnerUserWorkload",1138.58,"planNouserAt",1334.43,"actNouserAt",8830.81,"id","gkX5","branchName","kd3l");
		XmBranchTaskTypeState xmBranchTaskTypeState2=BaseUtils.fromMap(p2,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState2);
		Map p3=BaseUtils.map("taskType","78dR","planWorkload",9331.67,"planAmount",4397.45,"actWorkload",8392.93,"actAmount",4271.1,"branchId","MXg9","bizDate","BW9R","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",7219.8,"planInnerUserAt",9087.28,"actOutUserAt",5339.45,"actInnerUserAt",5841.62,"planOutUserWorkload",2937.35,"planInnerUserWorkload",3122.85,"actOutUserWorkload",8990.22,"actInnerUserWorkload",2142,"planNouserAt",3682.42,"actNouserAt",6455.77,"id","JDDa","branchName","XmNq");
		XmBranchTaskTypeState xmBranchTaskTypeState3=BaseUtils.fromMap(p3,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState3);
		Map p4=BaseUtils.map("taskType","pJPE","planWorkload",1004.09,"planAmount",5690.94,"actWorkload",2782.96,"actAmount",3504.56,"branchId","636Z","bizDate","QC7N","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",1337.46,"planInnerUserAt",5807.1,"actOutUserAt",4191.36,"actInnerUserAt",2427.2,"planOutUserWorkload",5968.46,"planInnerUserWorkload",5722.18,"actOutUserWorkload",8499.01,"actInnerUserWorkload",8061.72,"planNouserAt",8467.33,"actNouserAt",6898.51,"id","3FjI","branchName","5hI4");
		XmBranchTaskTypeState xmBranchTaskTypeState4=BaseUtils.fromMap(p4,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState4);
		Map p5=BaseUtils.map("taskType","E7hV","planWorkload",4065.19,"planAmount",4859.69,"actWorkload",2773.52,"actAmount",9133.84,"branchId","m8P8","bizDate","Ferr","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",1773.84,"planInnerUserAt",7103.96,"actOutUserAt",8400.91,"actInnerUserAt",6569.62,"planOutUserWorkload",4487.13,"planInnerUserWorkload",7318.36,"actOutUserWorkload",225.64,"actInnerUserWorkload",9977.53,"planNouserAt",5301.97,"actNouserAt",906.55,"id","4X4N","branchName","7a5k");
		XmBranchTaskTypeState xmBranchTaskTypeState5=BaseUtils.fromMap(p5,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState5);
		Map p6=BaseUtils.map("taskType","VwfW","planWorkload",6439.48,"planAmount",1921.73,"actWorkload",2982.42,"actAmount",625.11,"branchId","SA5j","bizDate","2y6L","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",6188.12,"planInnerUserAt",4814.84,"actOutUserAt",1460.09,"actInnerUserAt",4180.83,"planOutUserWorkload",1089.6,"planInnerUserWorkload",4590.41,"actOutUserWorkload",1971.7,"actInnerUserWorkload",9267.74,"planNouserAt",412.02,"actNouserAt",9991.32,"id","p55O","branchName","1q67");
		XmBranchTaskTypeState xmBranchTaskTypeState6=BaseUtils.fromMap(p6,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState6);
		Map p7=BaseUtils.map("taskType","N07H","planWorkload",6114.26,"planAmount",4207.99,"actWorkload",7117.07,"actAmount",8282.75,"branchId","STb2","bizDate","2T8D","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",5942.76,"planInnerUserAt",9748.28,"actOutUserAt",3153.36,"actInnerUserAt",4898.11,"planOutUserWorkload",4317.44,"planInnerUserWorkload",8157.29,"actOutUserWorkload",3959.44,"actInnerUserWorkload",334.16,"planNouserAt",4234.39,"actNouserAt",508.76,"id","LSoy","branchName","7A4x");
		XmBranchTaskTypeState xmBranchTaskTypeState7=BaseUtils.fromMap(p7,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState7);
		xmBranchTaskTypeStateService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmBranchTaskTypeState> batchValues=new ArrayList<XmBranchTaskTypeState>();
		Map p0=BaseUtils.map("taskType","E09l","planWorkload",1192.81,"planAmount",6555.18,"actWorkload",4241.27,"actAmount",3880.71,"branchId","2mgw","bizDate","o1Ey","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",139.59,"planInnerUserAt",9731.77,"actOutUserAt",4480.89,"actInnerUserAt",495.38,"planOutUserWorkload",8957.68,"planInnerUserWorkload",5976.21,"actOutUserWorkload",8269.72,"actInnerUserWorkload",3691.71,"planNouserAt",7317.09,"actNouserAt",6360.64,"id","V5oK","branchName","C92i");
		XmBranchTaskTypeState xmBranchTaskTypeState0=BaseUtils.fromMap(p0,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState0);
		Map p1=BaseUtils.map("taskType","9zmQ","planWorkload",6414.29,"planAmount",8613.01,"actWorkload",6074.24,"actAmount",1585.63,"branchId","F1B1","bizDate","4J09","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",4986.51,"planInnerUserAt",5269.71,"actOutUserAt",6358.17,"actInnerUserAt",5748.92,"planOutUserWorkload",3795.92,"planInnerUserWorkload",2411.19,"actOutUserWorkload",8545.13,"actInnerUserWorkload",5644.14,"planNouserAt",4031.15,"actNouserAt",1601.44,"id","OCR8","branchName","LS4m");
		XmBranchTaskTypeState xmBranchTaskTypeState1=BaseUtils.fromMap(p1,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState1);
		Map p2=BaseUtils.map("taskType","0499","planWorkload",3150.36,"planAmount",1174.81,"actWorkload",5450.83,"actAmount",1609.23,"branchId","pb30","bizDate","wyBq","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",2149.09,"planInnerUserAt",1744.78,"actOutUserAt",9299.14,"actInnerUserAt",5674.23,"planOutUserWorkload",5381.09,"planInnerUserWorkload",8149.75,"actOutUserWorkload",5947.91,"actInnerUserWorkload",1138.58,"planNouserAt",1334.43,"actNouserAt",8830.81,"id","gkX5","branchName","kd3l");
		XmBranchTaskTypeState xmBranchTaskTypeState2=BaseUtils.fromMap(p2,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState2);
		Map p3=BaseUtils.map("taskType","78dR","planWorkload",9331.67,"planAmount",4397.45,"actWorkload",8392.93,"actAmount",4271.1,"branchId","MXg9","bizDate","BW9R","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",7219.8,"planInnerUserAt",9087.28,"actOutUserAt",5339.45,"actInnerUserAt",5841.62,"planOutUserWorkload",2937.35,"planInnerUserWorkload",3122.85,"actOutUserWorkload",8990.22,"actInnerUserWorkload",2142,"planNouserAt",3682.42,"actNouserAt",6455.77,"id","JDDa","branchName","XmNq");
		XmBranchTaskTypeState xmBranchTaskTypeState3=BaseUtils.fromMap(p3,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState3);
		Map p4=BaseUtils.map("taskType","pJPE","planWorkload",1004.09,"planAmount",5690.94,"actWorkload",2782.96,"actAmount",3504.56,"branchId","636Z","bizDate","QC7N","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",1337.46,"planInnerUserAt",5807.1,"actOutUserAt",4191.36,"actInnerUserAt",2427.2,"planOutUserWorkload",5968.46,"planInnerUserWorkload",5722.18,"actOutUserWorkload",8499.01,"actInnerUserWorkload",8061.72,"planNouserAt",8467.33,"actNouserAt",6898.51,"id","3FjI","branchName","5hI4");
		XmBranchTaskTypeState xmBranchTaskTypeState4=BaseUtils.fromMap(p4,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState4);
		Map p5=BaseUtils.map("taskType","E7hV","planWorkload",4065.19,"planAmount",4859.69,"actWorkload",2773.52,"actAmount",9133.84,"branchId","m8P8","bizDate","Ferr","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",1773.84,"planInnerUserAt",7103.96,"actOutUserAt",8400.91,"actInnerUserAt",6569.62,"planOutUserWorkload",4487.13,"planInnerUserWorkload",7318.36,"actOutUserWorkload",225.64,"actInnerUserWorkload",9977.53,"planNouserAt",5301.97,"actNouserAt",906.55,"id","4X4N","branchName","7a5k");
		XmBranchTaskTypeState xmBranchTaskTypeState5=BaseUtils.fromMap(p5,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState5);
		Map p6=BaseUtils.map("taskType","VwfW","planWorkload",6439.48,"planAmount",1921.73,"actWorkload",2982.42,"actAmount",625.11,"branchId","SA5j","bizDate","2y6L","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",6188.12,"planInnerUserAt",4814.84,"actOutUserAt",1460.09,"actInnerUserAt",4180.83,"planOutUserWorkload",1089.6,"planInnerUserWorkload",4590.41,"actOutUserWorkload",1971.7,"actInnerUserWorkload",9267.74,"planNouserAt",412.02,"actNouserAt",9991.32,"id","p55O","branchName","1q67");
		XmBranchTaskTypeState xmBranchTaskTypeState6=BaseUtils.fromMap(p6,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState6);
		Map p7=BaseUtils.map("taskType","N07H","planWorkload",6114.26,"planAmount",4207.99,"actWorkload",7117.07,"actAmount",8282.75,"branchId","STb2","bizDate","2T8D","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",5942.76,"planInnerUserAt",9748.28,"actOutUserAt",3153.36,"actInnerUserAt",4898.11,"planOutUserWorkload",4317.44,"planInnerUserWorkload",8157.29,"actOutUserWorkload",3959.44,"actInnerUserWorkload",334.16,"planNouserAt",4234.39,"actNouserAt",508.76,"id","LSoy","branchName","7A4x");
		XmBranchTaskTypeState xmBranchTaskTypeState7=BaseUtils.fromMap(p7,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState7);
		xmBranchTaskTypeStateService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmBranchTaskTypeState> batchValues=new ArrayList<XmBranchTaskTypeState>();
		Map p0=BaseUtils.map("taskType","E09l","planWorkload",1192.81,"planAmount",6555.18,"actWorkload",4241.27,"actAmount",3880.71,"branchId","2mgw","bizDate","o1Ey","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",139.59,"planInnerUserAt",9731.77,"actOutUserAt",4480.89,"actInnerUserAt",495.38,"planOutUserWorkload",8957.68,"planInnerUserWorkload",5976.21,"actOutUserWorkload",8269.72,"actInnerUserWorkload",3691.71,"planNouserAt",7317.09,"actNouserAt",6360.64,"id","V5oK","branchName","C92i");
		XmBranchTaskTypeState xmBranchTaskTypeState0=BaseUtils.fromMap(p0,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState0);
		Map p1=BaseUtils.map("taskType","9zmQ","planWorkload",6414.29,"planAmount",8613.01,"actWorkload",6074.24,"actAmount",1585.63,"branchId","F1B1","bizDate","4J09","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",4986.51,"planInnerUserAt",5269.71,"actOutUserAt",6358.17,"actInnerUserAt",5748.92,"planOutUserWorkload",3795.92,"planInnerUserWorkload",2411.19,"actOutUserWorkload",8545.13,"actInnerUserWorkload",5644.14,"planNouserAt",4031.15,"actNouserAt",1601.44,"id","OCR8","branchName","LS4m");
		XmBranchTaskTypeState xmBranchTaskTypeState1=BaseUtils.fromMap(p1,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState1);
		Map p2=BaseUtils.map("taskType","0499","planWorkload",3150.36,"planAmount",1174.81,"actWorkload",5450.83,"actAmount",1609.23,"branchId","pb30","bizDate","wyBq","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",2149.09,"planInnerUserAt",1744.78,"actOutUserAt",9299.14,"actInnerUserAt",5674.23,"planOutUserWorkload",5381.09,"planInnerUserWorkload",8149.75,"actOutUserWorkload",5947.91,"actInnerUserWorkload",1138.58,"planNouserAt",1334.43,"actNouserAt",8830.81,"id","gkX5","branchName","kd3l");
		XmBranchTaskTypeState xmBranchTaskTypeState2=BaseUtils.fromMap(p2,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState2);
		Map p3=BaseUtils.map("taskType","78dR","planWorkload",9331.67,"planAmount",4397.45,"actWorkload",8392.93,"actAmount",4271.1,"branchId","MXg9","bizDate","BW9R","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",7219.8,"planInnerUserAt",9087.28,"actOutUserAt",5339.45,"actInnerUserAt",5841.62,"planOutUserWorkload",2937.35,"planInnerUserWorkload",3122.85,"actOutUserWorkload",8990.22,"actInnerUserWorkload",2142,"planNouserAt",3682.42,"actNouserAt",6455.77,"id","JDDa","branchName","XmNq");
		XmBranchTaskTypeState xmBranchTaskTypeState3=BaseUtils.fromMap(p3,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState3);
		Map p4=BaseUtils.map("taskType","pJPE","planWorkload",1004.09,"planAmount",5690.94,"actWorkload",2782.96,"actAmount",3504.56,"branchId","636Z","bizDate","QC7N","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",1337.46,"planInnerUserAt",5807.1,"actOutUserAt",4191.36,"actInnerUserAt",2427.2,"planOutUserWorkload",5968.46,"planInnerUserWorkload",5722.18,"actOutUserWorkload",8499.01,"actInnerUserWorkload",8061.72,"planNouserAt",8467.33,"actNouserAt",6898.51,"id","3FjI","branchName","5hI4");
		XmBranchTaskTypeState xmBranchTaskTypeState4=BaseUtils.fromMap(p4,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState4);
		Map p5=BaseUtils.map("taskType","E7hV","planWorkload",4065.19,"planAmount",4859.69,"actWorkload",2773.52,"actAmount",9133.84,"branchId","m8P8","bizDate","Ferr","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",1773.84,"planInnerUserAt",7103.96,"actOutUserAt",8400.91,"actInnerUserAt",6569.62,"planOutUserWorkload",4487.13,"planInnerUserWorkload",7318.36,"actOutUserWorkload",225.64,"actInnerUserWorkload",9977.53,"planNouserAt",5301.97,"actNouserAt",906.55,"id","4X4N","branchName","7a5k");
		XmBranchTaskTypeState xmBranchTaskTypeState5=BaseUtils.fromMap(p5,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState5);
		Map p6=BaseUtils.map("taskType","VwfW","planWorkload",6439.48,"planAmount",1921.73,"actWorkload",2982.42,"actAmount",625.11,"branchId","SA5j","bizDate","2y6L","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",6188.12,"planInnerUserAt",4814.84,"actOutUserAt",1460.09,"actInnerUserAt",4180.83,"planOutUserWorkload",1089.6,"planInnerUserWorkload",4590.41,"actOutUserWorkload",1971.7,"actInnerUserWorkload",9267.74,"planNouserAt",412.02,"actNouserAt",9991.32,"id","p55O","branchName","1q67");
		XmBranchTaskTypeState xmBranchTaskTypeState6=BaseUtils.fromMap(p6,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState6);
		Map p7=BaseUtils.map("taskType","N07H","planWorkload",6114.26,"planAmount",4207.99,"actWorkload",7117.07,"actAmount",8282.75,"branchId","STb2","bizDate","2T8D","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",5942.76,"planInnerUserAt",9748.28,"actOutUserAt",3153.36,"actInnerUserAt",4898.11,"planOutUserWorkload",4317.44,"planInnerUserWorkload",8157.29,"actOutUserWorkload",3959.44,"actInnerUserWorkload",334.16,"planNouserAt",4234.39,"actNouserAt",508.76,"id","LSoy","branchName","7A4x");
		XmBranchTaskTypeState xmBranchTaskTypeState7=BaseUtils.fromMap(p7,XmBranchTaskTypeState.class);
		batchValues.add(xmBranchTaskTypeState7);
		xmBranchTaskTypeStateService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","V5oK");
		Map<String,Object> result=this.xmBranchTaskTypeStateService.selectOne(XmBranchTaskTypeState.class.getName()+".selectOneMap",p);
		Assert.assertEquals("V5oK", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("taskType","E09l","planWorkload",1192.81,"planAmount",6555.18,"actWorkload",4241.27,"actAmount",3880.71,"branchId","2mgw","bizDate","o1Ey","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",139.59,"planInnerUserAt",9731.77,"actOutUserAt",4480.89,"actInnerUserAt",495.38,"planOutUserWorkload",8957.68,"planInnerUserWorkload",5976.21,"actOutUserWorkload",8269.72,"actInnerUserWorkload",3691.71,"planNouserAt",7317.09,"actNouserAt",6360.64,"branchName","C92i");
		XmBranchTaskTypeState xmBranchTaskTypeState=BaseUtils.fromMap(p,XmBranchTaskTypeState.class);
		long result=xmBranchTaskTypeStateService.countByWhere(xmBranchTaskTypeState);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("taskType","E09l","planWorkload",1192.81,"planAmount",6555.18,"actWorkload",4241.27,"actAmount",3880.71,"branchId","2mgw","bizDate","o1Ey","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",139.59,"planInnerUserAt",9731.77,"actOutUserAt",4480.89,"actInnerUserAt",495.38,"planOutUserWorkload",8957.68,"planInnerUserWorkload",5976.21,"actOutUserWorkload",8269.72,"actInnerUserWorkload",3691.71,"planNouserAt",7317.09,"actNouserAt",6360.64,"branchName","C92i");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmBranchTaskTypeState xmBranchTaskTypeState=BaseUtils.fromMap(p,XmBranchTaskTypeState.class);
		List<XmBranchTaskTypeState> result=xmBranchTaskTypeStateService.selectListByWhere(xmBranchTaskTypeState); 
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
	
		
		Map<String,Object> p=BaseUtils.map("taskType","E09l","planWorkload",1192.81,"planAmount",6555.18,"actWorkload",4241.27,"actAmount",3880.71,"branchId","2mgw","bizDate","o1Ey","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",139.59,"planInnerUserAt",9731.77,"actOutUserAt",4480.89,"actInnerUserAt",495.38,"planOutUserWorkload",8957.68,"planInnerUserWorkload",5976.21,"actOutUserWorkload",8269.72,"actInnerUserWorkload",3691.71,"planNouserAt",7317.09,"actNouserAt",6360.64,"branchName","C92i");
		XmBranchTaskTypeState xmBranchTaskTypeState=BaseUtils.fromMap(p,XmBranchTaskTypeState.class);
		List<XmBranchTaskTypeState> result=xmBranchTaskTypeStateService.selectListByWhere(xmBranchTaskTypeState);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("taskType","E09l","planWorkload",1192.81,"planAmount",6555.18,"actWorkload",4241.27,"actAmount",3880.71,"branchId","2mgw","bizDate","o1Ey","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",139.59,"planInnerUserAt",9731.77,"actOutUserAt",4480.89,"actInnerUserAt",495.38,"planOutUserWorkload",8957.68,"planInnerUserWorkload",5976.21,"actOutUserWorkload",8269.72,"actInnerUserWorkload",3691.71,"planNouserAt",7317.09,"actNouserAt",6360.64,"branchName","C92i");
		List<Map<String,Object>> result=xmBranchTaskTypeStateService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("taskType","E09l","planWorkload",1192.81,"planAmount",6555.18,"actWorkload",4241.27,"actAmount",3880.71,"branchId","2mgw","bizDate","o1Ey","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",139.59,"planInnerUserAt",9731.77,"actOutUserAt",4480.89,"actInnerUserAt",495.38,"planOutUserWorkload",8957.68,"planInnerUserWorkload",5976.21,"actOutUserWorkload",8269.72,"actInnerUserWorkload",3691.71,"planNouserAt",7317.09,"actNouserAt",6360.64,"branchName","C92i");
		List<Map<String,Object>> result=xmBranchTaskTypeStateService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmBranchTaskTypeState
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","V5oK");
		
		XmBranchTaskTypeState xmBranchTaskTypeState1=BaseUtils.fromMap(p,XmBranchTaskTypeState.class);
		XmBranchTaskTypeState xmBranchTaskTypeState=xmBranchTaskTypeStateService.selectOneObject(xmBranchTaskTypeState1);
		Assert.assertEquals("V5oK", xmBranchTaskTypeState.getId());
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
