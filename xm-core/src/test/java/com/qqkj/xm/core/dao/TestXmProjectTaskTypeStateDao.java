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
import com.qqkj.xm.core.entity.XmProjectTaskTypeState;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmProjectTaskTypeStateDao的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_project_task_type_state 按任务类型汇总<br>
 * 实体 XmProjectTaskTypeState<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	projectId,projectName,taskType,planWorkload,planAmount,actWorkload,actAmount,branchId,bizDate,calcTime,planOutUserAt,planInnerUserAt,actOutUserAt,actInnerUserAt,planOutUserWorkload,planInnerUserWorkload,actOutUserWorkload,actInnerUserWorkload,planNouserAt,actNouserAt,id;<br>
 * 当前表的所有字段名:<br>
 *	project_id,project_name,task_type,plan_workload,plan_amount,act_workload,act_amount,branch_id,biz_date,calc_time,plan_out_user_at,plan_inner_user_at,act_out_user_at,act_inner_user_at,plan_out_user_workload,plan_inner_user_workload,act_out_user_workload,act_inner_user_workload,plan_nouser_at,act_nouser_at,id;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/
 @RunWith(SpringJUnit4ClassRunner.class)
 @SpringBootTest
public class TestXmProjectTaskTypeStateDao  {

	@Autowired
	BaseDao baseDao;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("projectId","2026","projectName","s04L","taskType","21dl","planWorkload",5018.64,"planAmount",5303.27,"actWorkload",3877.43,"actAmount",6905.88,"branchId","5kDo","bizDate","Vh9r","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",4913.84,"planInnerUserAt",7569.39,"actOutUserAt",8610.81,"actInnerUserAt",7444.48,"planOutUserWorkload",4087.88,"planInnerUserWorkload",9368.57,"actOutUserWorkload",9103.11,"actInnerUserWorkload",5913.89,"planNouserAt",4466.72,"actNouserAt",655.77,"id","5miH");
		XmProjectTaskTypeState xmProjectTaskTypeState=BaseUtils.fromMap(p,XmProjectTaskTypeState.class);
		baseDao.insert(xmProjectTaskTypeState);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","2026","projectName","s04L","taskType","21dl","planWorkload",5018.64,"planAmount",5303.27,"actWorkload",3877.43,"actAmount",6905.88,"branchId","5kDo","bizDate","Vh9r","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",4913.84,"planInnerUserAt",7569.39,"actOutUserAt",8610.81,"actInnerUserAt",7444.48,"planOutUserWorkload",4087.88,"planInnerUserWorkload",9368.57,"actOutUserWorkload",9103.11,"actInnerUserWorkload",5913.89,"planNouserAt",4466.72,"actNouserAt",655.77);
		XmProjectTaskTypeState xmProjectTaskTypeState=BaseUtils.fromMap(p,XmProjectTaskTypeState.class);
		baseDao.deleteByWhere(xmProjectTaskTypeState);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","5miH");
		XmProjectTaskTypeState xmProjectTaskTypeState=BaseUtils.fromMap(p,XmProjectTaskTypeState.class);
		baseDao.deleteByPk(xmProjectTaskTypeState);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("projectId","2026","projectName","s04L","taskType","21dl","planWorkload",5018.64,"planAmount",5303.27,"actWorkload",3877.43,"actAmount",6905.88,"branchId","5kDo","bizDate","Vh9r","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",4913.84,"planInnerUserAt",7569.39,"actOutUserAt",8610.81,"actInnerUserAt",7444.48,"planOutUserWorkload",4087.88,"planInnerUserWorkload",9368.57,"actOutUserWorkload",9103.11,"actInnerUserWorkload",5913.89,"planNouserAt",4466.72,"actNouserAt",655.77);
		XmProjectTaskTypeState xmProjectTaskTypeState=BaseUtils.fromMap(where,XmProjectTaskTypeState.class);
		baseDao.updateSomeFieldByPk(xmProjectTaskTypeState);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","5miH");
		XmProjectTaskTypeState xmProjectTaskTypeState=BaseUtils.fromMap(p,XmProjectTaskTypeState.class);
		baseDao.updateByPk(xmProjectTaskTypeState);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("projectId","2026","projectName","s04L","taskType","21dl","planWorkload",5018.64,"planAmount",5303.27,"actWorkload",3877.43,"actAmount",6905.88,"branchId","5kDo","bizDate","Vh9r","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",4913.84,"planInnerUserAt",7569.39,"actOutUserAt",8610.81,"actInnerUserAt",7444.48,"planOutUserWorkload",4087.88,"planInnerUserWorkload",9368.57,"actOutUserWorkload",9103.11,"actInnerUserWorkload",5913.89,"planNouserAt",4466.72,"actNouserAt",655.77,"id","5miH");
		XmProjectTaskTypeState xmProjectTaskTypeState=BaseUtils.fromMap(p,XmProjectTaskTypeState.class);
		baseDao.insertOrUpdate(xmProjectTaskTypeState);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmProjectTaskTypeState> batchValues=new ArrayList<XmProjectTaskTypeState>();
		Map p0=BaseUtils.map("projectId","2026","projectName","s04L","taskType","21dl","planWorkload",5018.64,"planAmount",5303.27,"actWorkload",3877.43,"actAmount",6905.88,"branchId","5kDo","bizDate","Vh9r","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",4913.84,"planInnerUserAt",7569.39,"actOutUserAt",8610.81,"actInnerUserAt",7444.48,"planOutUserWorkload",4087.88,"planInnerUserWorkload",9368.57,"actOutUserWorkload",9103.11,"actInnerUserWorkload",5913.89,"planNouserAt",4466.72,"actNouserAt",655.77,"id","5miH");
		XmProjectTaskTypeState xmProjectTaskTypeState0=BaseUtils.fromMap(p0,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState0);
		Map p1=BaseUtils.map("projectId","zpxu","projectName","FNzf","taskType","GD46","planWorkload",8360.89,"planAmount",2770.41,"actWorkload",687.95,"actAmount",5419.82,"branchId","O4HL","bizDate","nNa3","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",9547.72,"planInnerUserAt",2632.66,"actOutUserAt",1421.22,"actInnerUserAt",902.52,"planOutUserWorkload",9573.99,"planInnerUserWorkload",8618.8,"actOutUserWorkload",3015.97,"actInnerUserWorkload",8961.62,"planNouserAt",1032.87,"actNouserAt",5239.03,"id","st8V");
		XmProjectTaskTypeState xmProjectTaskTypeState1=BaseUtils.fromMap(p1,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState1);
		Map p2=BaseUtils.map("projectId","EmaF","projectName","ArGG","taskType","t65I","planWorkload",6736.25,"planAmount",9459.09,"actWorkload",2648.56,"actAmount",5414.67,"branchId","X2tM","bizDate","Euzd","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",4593.8,"planInnerUserAt",6994.52,"actOutUserAt",4085.81,"actInnerUserAt",2721.16,"planOutUserWorkload",8193.56,"planInnerUserWorkload",5690.8,"actOutUserWorkload",4297.97,"actInnerUserWorkload",6487.93,"planNouserAt",4085.71,"actNouserAt",7128.26,"id","L50C");
		XmProjectTaskTypeState xmProjectTaskTypeState2=BaseUtils.fromMap(p2,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState2);
		Map p3=BaseUtils.map("projectId","J9hT","projectName","Qhid","taskType","4Gx3","planWorkload",6381.88,"planAmount",4502.95,"actWorkload",6312.29,"actAmount",7137.88,"branchId","nfUj","bizDate","rpc7","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",2407.18,"planInnerUserAt",2154.5,"actOutUserAt",6675.75,"actInnerUserAt",979.35,"planOutUserWorkload",6889.42,"planInnerUserWorkload",6311.26,"actOutUserWorkload",7478.65,"actInnerUserWorkload",3125.83,"planNouserAt",9780.51,"actNouserAt",5107.95,"id","XiQq");
		XmProjectTaskTypeState xmProjectTaskTypeState3=BaseUtils.fromMap(p3,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState3);
		Map p4=BaseUtils.map("projectId","zwZH","projectName","b9a1","taskType","k13x","planWorkload",6777.71,"planAmount",4894.82,"actWorkload",4648.59,"actAmount",8900.13,"branchId","1GNw","bizDate","7tzz","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",7166.6,"planInnerUserAt",267.56,"actOutUserAt",9021.39,"actInnerUserAt",5306.62,"planOutUserWorkload",4489.34,"planInnerUserWorkload",6036.72,"actOutUserWorkload",3846.75,"actInnerUserWorkload",4104.51,"planNouserAt",4012.35,"actNouserAt",2442.02,"id","QoL5");
		XmProjectTaskTypeState xmProjectTaskTypeState4=BaseUtils.fromMap(p4,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState4);
		Map p5=BaseUtils.map("projectId","172z","projectName","870e","taskType","YTvh","planWorkload",6850.45,"planAmount",5703.35,"actWorkload",7552.31,"actAmount",7365.76,"branchId","FX8N","bizDate","jfh7","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",5688.38,"planInnerUserAt",6126.3,"actOutUserAt",9261.45,"actInnerUserAt",7031.49,"planOutUserWorkload",7399.75,"planInnerUserWorkload",9187.34,"actOutUserWorkload",4810.29,"actInnerUserWorkload",4894.86,"planNouserAt",7546.85,"actNouserAt",1384.16,"id","HfZ7");
		XmProjectTaskTypeState xmProjectTaskTypeState5=BaseUtils.fromMap(p5,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState5);
		Map p6=BaseUtils.map("projectId","DTS3","projectName","kFg7","taskType","SHNr","planWorkload",7492.81,"planAmount",157.85,"actWorkload",9165.6,"actAmount",5106.28,"branchId","K87l","bizDate","bi6o","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",8936.6,"planInnerUserAt",2243.51,"actOutUserAt",7002.45,"actInnerUserAt",3707.25,"planOutUserWorkload",6012.9,"planInnerUserWorkload",9261.6,"actOutUserWorkload",834.55,"actInnerUserWorkload",7937.09,"planNouserAt",4740.94,"actNouserAt",6047.75,"id","49C8");
		XmProjectTaskTypeState xmProjectTaskTypeState6=BaseUtils.fromMap(p6,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState6);
		Map p7=BaseUtils.map("projectId","86ps","projectName","VkZn","taskType","UD6D","planWorkload",7417.9,"planAmount",6701,"actWorkload",3818.8,"actAmount",5495.64,"branchId","ZTmY","bizDate","a1G1","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",1172.07,"planInnerUserAt",4547.13,"actOutUserAt",6924.5,"actInnerUserAt",3778.61,"planOutUserWorkload",8435.66,"planInnerUserWorkload",7494.59,"actOutUserWorkload",9311.23,"actInnerUserWorkload",8165.79,"planNouserAt",5555.72,"actNouserAt",1200.95,"id","10s1");
		XmProjectTaskTypeState xmProjectTaskTypeState7=BaseUtils.fromMap(p7,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState7);
		baseDao.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmProjectTaskTypeState> batchValues=new ArrayList<XmProjectTaskTypeState>();
		Map p0=BaseUtils.map("projectId","2026","projectName","s04L","taskType","21dl","planWorkload",5018.64,"planAmount",5303.27,"actWorkload",3877.43,"actAmount",6905.88,"branchId","5kDo","bizDate","Vh9r","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",4913.84,"planInnerUserAt",7569.39,"actOutUserAt",8610.81,"actInnerUserAt",7444.48,"planOutUserWorkload",4087.88,"planInnerUserWorkload",9368.57,"actOutUserWorkload",9103.11,"actInnerUserWorkload",5913.89,"planNouserAt",4466.72,"actNouserAt",655.77,"id","5miH");
		XmProjectTaskTypeState xmProjectTaskTypeState0=BaseUtils.fromMap(p0,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState0);
		Map p1=BaseUtils.map("projectId","zpxu","projectName","FNzf","taskType","GD46","planWorkload",8360.89,"planAmount",2770.41,"actWorkload",687.95,"actAmount",5419.82,"branchId","O4HL","bizDate","nNa3","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",9547.72,"planInnerUserAt",2632.66,"actOutUserAt",1421.22,"actInnerUserAt",902.52,"planOutUserWorkload",9573.99,"planInnerUserWorkload",8618.8,"actOutUserWorkload",3015.97,"actInnerUserWorkload",8961.62,"planNouserAt",1032.87,"actNouserAt",5239.03,"id","st8V");
		XmProjectTaskTypeState xmProjectTaskTypeState1=BaseUtils.fromMap(p1,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState1);
		Map p2=BaseUtils.map("projectId","EmaF","projectName","ArGG","taskType","t65I","planWorkload",6736.25,"planAmount",9459.09,"actWorkload",2648.56,"actAmount",5414.67,"branchId","X2tM","bizDate","Euzd","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",4593.8,"planInnerUserAt",6994.52,"actOutUserAt",4085.81,"actInnerUserAt",2721.16,"planOutUserWorkload",8193.56,"planInnerUserWorkload",5690.8,"actOutUserWorkload",4297.97,"actInnerUserWorkload",6487.93,"planNouserAt",4085.71,"actNouserAt",7128.26,"id","L50C");
		XmProjectTaskTypeState xmProjectTaskTypeState2=BaseUtils.fromMap(p2,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState2);
		Map p3=BaseUtils.map("projectId","J9hT","projectName","Qhid","taskType","4Gx3","planWorkload",6381.88,"planAmount",4502.95,"actWorkload",6312.29,"actAmount",7137.88,"branchId","nfUj","bizDate","rpc7","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",2407.18,"planInnerUserAt",2154.5,"actOutUserAt",6675.75,"actInnerUserAt",979.35,"planOutUserWorkload",6889.42,"planInnerUserWorkload",6311.26,"actOutUserWorkload",7478.65,"actInnerUserWorkload",3125.83,"planNouserAt",9780.51,"actNouserAt",5107.95,"id","XiQq");
		XmProjectTaskTypeState xmProjectTaskTypeState3=BaseUtils.fromMap(p3,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState3);
		Map p4=BaseUtils.map("projectId","zwZH","projectName","b9a1","taskType","k13x","planWorkload",6777.71,"planAmount",4894.82,"actWorkload",4648.59,"actAmount",8900.13,"branchId","1GNw","bizDate","7tzz","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",7166.6,"planInnerUserAt",267.56,"actOutUserAt",9021.39,"actInnerUserAt",5306.62,"planOutUserWorkload",4489.34,"planInnerUserWorkload",6036.72,"actOutUserWorkload",3846.75,"actInnerUserWorkload",4104.51,"planNouserAt",4012.35,"actNouserAt",2442.02,"id","QoL5");
		XmProjectTaskTypeState xmProjectTaskTypeState4=BaseUtils.fromMap(p4,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState4);
		Map p5=BaseUtils.map("projectId","172z","projectName","870e","taskType","YTvh","planWorkload",6850.45,"planAmount",5703.35,"actWorkload",7552.31,"actAmount",7365.76,"branchId","FX8N","bizDate","jfh7","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",5688.38,"planInnerUserAt",6126.3,"actOutUserAt",9261.45,"actInnerUserAt",7031.49,"planOutUserWorkload",7399.75,"planInnerUserWorkload",9187.34,"actOutUserWorkload",4810.29,"actInnerUserWorkload",4894.86,"planNouserAt",7546.85,"actNouserAt",1384.16,"id","HfZ7");
		XmProjectTaskTypeState xmProjectTaskTypeState5=BaseUtils.fromMap(p5,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState5);
		Map p6=BaseUtils.map("projectId","DTS3","projectName","kFg7","taskType","SHNr","planWorkload",7492.81,"planAmount",157.85,"actWorkload",9165.6,"actAmount",5106.28,"branchId","K87l","bizDate","bi6o","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",8936.6,"planInnerUserAt",2243.51,"actOutUserAt",7002.45,"actInnerUserAt",3707.25,"planOutUserWorkload",6012.9,"planInnerUserWorkload",9261.6,"actOutUserWorkload",834.55,"actInnerUserWorkload",7937.09,"planNouserAt",4740.94,"actNouserAt",6047.75,"id","49C8");
		XmProjectTaskTypeState xmProjectTaskTypeState6=BaseUtils.fromMap(p6,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState6);
		Map p7=BaseUtils.map("projectId","86ps","projectName","VkZn","taskType","UD6D","planWorkload",7417.9,"planAmount",6701,"actWorkload",3818.8,"actAmount",5495.64,"branchId","ZTmY","bizDate","a1G1","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",1172.07,"planInnerUserAt",4547.13,"actOutUserAt",6924.5,"actInnerUserAt",3778.61,"planOutUserWorkload",8435.66,"planInnerUserWorkload",7494.59,"actOutUserWorkload",9311.23,"actInnerUserWorkload",8165.79,"planNouserAt",5555.72,"actNouserAt",1200.95,"id","10s1");
		XmProjectTaskTypeState xmProjectTaskTypeState7=BaseUtils.fromMap(p7,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState7);
		baseDao.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmProjectTaskTypeState> batchValues=new ArrayList<XmProjectTaskTypeState>();
		Map p0=BaseUtils.map("projectId","2026","projectName","s04L","taskType","21dl","planWorkload",5018.64,"planAmount",5303.27,"actWorkload",3877.43,"actAmount",6905.88,"branchId","5kDo","bizDate","Vh9r","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",4913.84,"planInnerUserAt",7569.39,"actOutUserAt",8610.81,"actInnerUserAt",7444.48,"planOutUserWorkload",4087.88,"planInnerUserWorkload",9368.57,"actOutUserWorkload",9103.11,"actInnerUserWorkload",5913.89,"planNouserAt",4466.72,"actNouserAt",655.77,"id","5miH");
		XmProjectTaskTypeState xmProjectTaskTypeState0=BaseUtils.fromMap(p0,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState0);
		Map p1=BaseUtils.map("projectId","zpxu","projectName","FNzf","taskType","GD46","planWorkload",8360.89,"planAmount",2770.41,"actWorkload",687.95,"actAmount",5419.82,"branchId","O4HL","bizDate","nNa3","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",9547.72,"planInnerUserAt",2632.66,"actOutUserAt",1421.22,"actInnerUserAt",902.52,"planOutUserWorkload",9573.99,"planInnerUserWorkload",8618.8,"actOutUserWorkload",3015.97,"actInnerUserWorkload",8961.62,"planNouserAt",1032.87,"actNouserAt",5239.03,"id","st8V");
		XmProjectTaskTypeState xmProjectTaskTypeState1=BaseUtils.fromMap(p1,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState1);
		Map p2=BaseUtils.map("projectId","EmaF","projectName","ArGG","taskType","t65I","planWorkload",6736.25,"planAmount",9459.09,"actWorkload",2648.56,"actAmount",5414.67,"branchId","X2tM","bizDate","Euzd","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",4593.8,"planInnerUserAt",6994.52,"actOutUserAt",4085.81,"actInnerUserAt",2721.16,"planOutUserWorkload",8193.56,"planInnerUserWorkload",5690.8,"actOutUserWorkload",4297.97,"actInnerUserWorkload",6487.93,"planNouserAt",4085.71,"actNouserAt",7128.26,"id","L50C");
		XmProjectTaskTypeState xmProjectTaskTypeState2=BaseUtils.fromMap(p2,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState2);
		Map p3=BaseUtils.map("projectId","J9hT","projectName","Qhid","taskType","4Gx3","planWorkload",6381.88,"planAmount",4502.95,"actWorkload",6312.29,"actAmount",7137.88,"branchId","nfUj","bizDate","rpc7","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",2407.18,"planInnerUserAt",2154.5,"actOutUserAt",6675.75,"actInnerUserAt",979.35,"planOutUserWorkload",6889.42,"planInnerUserWorkload",6311.26,"actOutUserWorkload",7478.65,"actInnerUserWorkload",3125.83,"planNouserAt",9780.51,"actNouserAt",5107.95,"id","XiQq");
		XmProjectTaskTypeState xmProjectTaskTypeState3=BaseUtils.fromMap(p3,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState3);
		Map p4=BaseUtils.map("projectId","zwZH","projectName","b9a1","taskType","k13x","planWorkload",6777.71,"planAmount",4894.82,"actWorkload",4648.59,"actAmount",8900.13,"branchId","1GNw","bizDate","7tzz","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",7166.6,"planInnerUserAt",267.56,"actOutUserAt",9021.39,"actInnerUserAt",5306.62,"planOutUserWorkload",4489.34,"planInnerUserWorkload",6036.72,"actOutUserWorkload",3846.75,"actInnerUserWorkload",4104.51,"planNouserAt",4012.35,"actNouserAt",2442.02,"id","QoL5");
		XmProjectTaskTypeState xmProjectTaskTypeState4=BaseUtils.fromMap(p4,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState4);
		Map p5=BaseUtils.map("projectId","172z","projectName","870e","taskType","YTvh","planWorkload",6850.45,"planAmount",5703.35,"actWorkload",7552.31,"actAmount",7365.76,"branchId","FX8N","bizDate","jfh7","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",5688.38,"planInnerUserAt",6126.3,"actOutUserAt",9261.45,"actInnerUserAt",7031.49,"planOutUserWorkload",7399.75,"planInnerUserWorkload",9187.34,"actOutUserWorkload",4810.29,"actInnerUserWorkload",4894.86,"planNouserAt",7546.85,"actNouserAt",1384.16,"id","HfZ7");
		XmProjectTaskTypeState xmProjectTaskTypeState5=BaseUtils.fromMap(p5,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState5);
		Map p6=BaseUtils.map("projectId","DTS3","projectName","kFg7","taskType","SHNr","planWorkload",7492.81,"planAmount",157.85,"actWorkload",9165.6,"actAmount",5106.28,"branchId","K87l","bizDate","bi6o","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",8936.6,"planInnerUserAt",2243.51,"actOutUserAt",7002.45,"actInnerUserAt",3707.25,"planOutUserWorkload",6012.9,"planInnerUserWorkload",9261.6,"actOutUserWorkload",834.55,"actInnerUserWorkload",7937.09,"planNouserAt",4740.94,"actNouserAt",6047.75,"id","49C8");
		XmProjectTaskTypeState xmProjectTaskTypeState6=BaseUtils.fromMap(p6,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState6);
		Map p7=BaseUtils.map("projectId","86ps","projectName","VkZn","taskType","UD6D","planWorkload",7417.9,"planAmount",6701,"actWorkload",3818.8,"actAmount",5495.64,"branchId","ZTmY","bizDate","a1G1","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",1172.07,"planInnerUserAt",4547.13,"actOutUserAt",6924.5,"actInnerUserAt",3778.61,"planOutUserWorkload",8435.66,"planInnerUserWorkload",7494.59,"actOutUserWorkload",9311.23,"actInnerUserWorkload",8165.79,"planNouserAt",5555.72,"actNouserAt",1200.95,"id","10s1");
		XmProjectTaskTypeState xmProjectTaskTypeState7=BaseUtils.fromMap(p7,XmProjectTaskTypeState.class);
		batchValues.add(xmProjectTaskTypeState7);
		baseDao.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","5miH");
		Map<String,Object> result=this.baseDao.selectOne(XmProjectTaskTypeState.class.getName()+".selectOneMap",p);
		Assert.assertEquals("5miH", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","2026","projectName","s04L","taskType","21dl","planWorkload",5018.64,"planAmount",5303.27,"actWorkload",3877.43,"actAmount",6905.88,"branchId","5kDo","bizDate","Vh9r","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",4913.84,"planInnerUserAt",7569.39,"actOutUserAt",8610.81,"actInnerUserAt",7444.48,"planOutUserWorkload",4087.88,"planInnerUserWorkload",9368.57,"actOutUserWorkload",9103.11,"actInnerUserWorkload",5913.89,"planNouserAt",4466.72,"actNouserAt",655.77);
		XmProjectTaskTypeState xmProjectTaskTypeState=BaseUtils.fromMap(p,XmProjectTaskTypeState.class);
		long result=baseDao.countByWhere(xmProjectTaskTypeState);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
 		
		
		Map<String,Object> p=BaseUtils.map("projectId","2026","projectName","s04L","taskType","21dl","planWorkload",5018.64,"planAmount",5303.27,"actWorkload",3877.43,"actAmount",6905.88,"branchId","5kDo","bizDate","Vh9r","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",4913.84,"planInnerUserAt",7569.39,"actOutUserAt",8610.81,"actInnerUserAt",7444.48,"planOutUserWorkload",4087.88,"planInnerUserWorkload",9368.57,"actOutUserWorkload",9103.11,"actInnerUserWorkload",5913.89,"planNouserAt",4466.72,"actNouserAt",655.77);
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmProjectTaskTypeState xmProjectTaskTypeState=BaseUtils.fromMap(p,XmProjectTaskTypeState.class);
		List<XmProjectTaskTypeState> result=baseDao.selectListByWhere(xmProjectTaskTypeState); 
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
	
		
		Map<String,Object> p=BaseUtils.map("projectId","2026","projectName","s04L","taskType","21dl","planWorkload",5018.64,"planAmount",5303.27,"actWorkload",3877.43,"actAmount",6905.88,"branchId","5kDo","bizDate","Vh9r","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",4913.84,"planInnerUserAt",7569.39,"actOutUserAt",8610.81,"actInnerUserAt",7444.48,"planOutUserWorkload",4087.88,"planInnerUserWorkload",9368.57,"actOutUserWorkload",9103.11,"actInnerUserWorkload",5913.89,"planNouserAt",4466.72,"actNouserAt",655.77);
		XmProjectTaskTypeState xmProjectTaskTypeState=BaseUtils.fromMap(p,XmProjectTaskTypeState.class);
		List<XmProjectTaskTypeState> result=baseDao.selectListByWhere(xmProjectTaskTypeState);
		Assert.assertEquals(true, result.size()>=1);
	}

	
	/**
	 * 查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","2026","projectName","s04L","taskType","21dl","planWorkload",5018.64,"planAmount",5303.27,"actWorkload",3877.43,"actAmount",6905.88,"branchId","5kDo","bizDate","Vh9r","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",4913.84,"planInnerUserAt",7569.39,"actOutUserAt",8610.81,"actInnerUserAt",7444.48,"planOutUserWorkload",4087.88,"planInnerUserWorkload",9368.57,"actOutUserWorkload",9103.11,"actInnerUserWorkload",5913.89,"planNouserAt",4466.72,"actNouserAt",655.77);
		List<Map<String,Object>> result=baseDao.selectList(XmProjectTaskTypeState.class.getName()+".selectListMapByWhere",p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("projectId","2026","projectName","s04L","taskType","21dl","planWorkload",5018.64,"planAmount",5303.27,"actWorkload",3877.43,"actAmount",6905.88,"branchId","5kDo","bizDate","Vh9r","calcTime",parse("2020-11-15 12:57:54"),"planOutUserAt",4913.84,"planInnerUserAt",7569.39,"actOutUserAt",8610.81,"actInnerUserAt",7444.48,"planOutUserWorkload",4087.88,"planInnerUserWorkload",9368.57,"actOutUserWorkload",9103.11,"actInnerUserWorkload",5913.89,"planNouserAt",4466.72,"actNouserAt",655.77);
		List<Map<String,Object>> result=baseDao.selectList(XmProjectTaskTypeState.class.getName()+".selectListMapByKey",p);
		Assert.assertEquals(true, result.size()>=0);
	}
 
	/**
	 * 查询一个对象 XmProjectTaskTypeState
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","5miH");
		
		XmProjectTaskTypeState xmProjectTaskTypeState1=BaseUtils.fromMap(p,XmProjectTaskTypeState.class);
		XmProjectTaskTypeState xmProjectTaskTypeState=baseDao.selectOneObject(xmProjectTaskTypeState1);
		Assert.assertEquals("5miH", xmProjectTaskTypeState.getId());
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
