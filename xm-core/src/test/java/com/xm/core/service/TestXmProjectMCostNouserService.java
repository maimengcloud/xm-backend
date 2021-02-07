package com.xm.core.service;

import java.util.*;
import java.text.SimpleDateFormat;

import com.xm.core.entity.XmProjectMCostNouser;
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
 * XmProjectMCostNouserService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_project_m_cost_nouser xm_project_m_cost_nouser<br>
 * 实体 XmProjectMCostNouser<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	projectId,userid,createTime,sendCostTime,username,projectName,remark,id,taskId,taskName,subjectId,bizzStartDate,bizzEndDate,bizProcInstId,bizFlowState,projectPhaseId,actCostAmount,costType,bizMonth,bizDate;<br>
 * 当前表的所有字段名:<br>
 *	project_id,userid,create_time,send_cost_time,username,project_name,remark,id,task_id,task_name,subject_id,bizz_start_date,bizz_end_date,biz_proc_inst_id,biz_flow_state,project_phase_id,act_cost_amount,cost_type,biz_month,biz_date;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectMCostNouserService  {

	@Autowired
	XmProjectMCostNouserService xmProjectMCostNouserService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("projectId","Uz5H","userid","7BPs","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","YNs1","projectName","UHq4","remark","kS6Q","id","a3XR","taskId","aKjk","taskName","3ylX","subjectId","pqSA","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","f3rC","bizFlowState","u","projectPhaseId","lVKX","actCostAmount",5921.4,"costType","e","bizMonth","Q3G6","bizDate","2Yqo");
		XmProjectMCostNouser xmProjectMCostNouser=BaseUtils.fromMap(p,XmProjectMCostNouser.class);
		xmProjectMCostNouserService.insert(xmProjectMCostNouser);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","Uz5H","userid","7BPs","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","YNs1","projectName","UHq4","remark","kS6Q","taskId","aKjk","taskName","3ylX","subjectId","pqSA","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","f3rC","bizFlowState","u","projectPhaseId","lVKX","actCostAmount",5921.4,"costType","e","bizMonth","Q3G6","bizDate","2Yqo");
		XmProjectMCostNouser xmProjectMCostNouser=BaseUtils.fromMap(p,XmProjectMCostNouser.class);
		xmProjectMCostNouserService.deleteByWhere(xmProjectMCostNouser);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","a3XR");
		XmProjectMCostNouser xmProjectMCostNouser=BaseUtils.fromMap(p,XmProjectMCostNouser.class);
		xmProjectMCostNouserService.deleteByPk(xmProjectMCostNouser);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("projectId","Uz5H","userid","7BPs","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","YNs1","projectName","UHq4","remark","kS6Q","taskId","aKjk","taskName","3ylX","subjectId","pqSA","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","f3rC","bizFlowState","u","projectPhaseId","lVKX","actCostAmount",5921.4,"costType","e","bizMonth","Q3G6","bizDate","2Yqo");
		XmProjectMCostNouser xmProjectMCostNouser=BaseUtils.fromMap(where,XmProjectMCostNouser.class);
		xmProjectMCostNouserService.updateSomeFieldByPk(xmProjectMCostNouser);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","a3XR");
		XmProjectMCostNouser xmProjectMCostNouser=BaseUtils.fromMap(p,XmProjectMCostNouser.class);
		xmProjectMCostNouserService.updateByPk(xmProjectMCostNouser);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("projectId","Uz5H","userid","7BPs","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","YNs1","projectName","UHq4","remark","kS6Q","id","a3XR","taskId","aKjk","taskName","3ylX","subjectId","pqSA","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","f3rC","bizFlowState","u","projectPhaseId","lVKX","actCostAmount",5921.4,"costType","e","bizMonth","Q3G6","bizDate","2Yqo");
		XmProjectMCostNouser xmProjectMCostNouser=BaseUtils.fromMap(p,XmProjectMCostNouser.class);
		xmProjectMCostNouserService.insertOrUpdate(xmProjectMCostNouser);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmProjectMCostNouser> batchValues=new ArrayList<XmProjectMCostNouser>();
		Map p0=BaseUtils.map("projectId","Uz5H","userid","7BPs","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","YNs1","projectName","UHq4","remark","kS6Q","id","a3XR","taskId","aKjk","taskName","3ylX","subjectId","pqSA","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","f3rC","bizFlowState","u","projectPhaseId","lVKX","actCostAmount",5921.4,"costType","e","bizMonth","Q3G6","bizDate","2Yqo");
		XmProjectMCostNouser xmProjectMCostNouser0=BaseUtils.fromMap(p0,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser0);
		Map p1=BaseUtils.map("projectId","2W6W","userid","0Ba3","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","Wnfc","projectName","9imu","remark","kXXF","id","vAz0","taskId","GbUq","taskName","Pvoa","subjectId","B5aa","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","201A","bizFlowState","Y","projectPhaseId","Nc35","actCostAmount",3313.66,"costType","3","bizMonth","r0Bd","bizDate","AL2F");
		XmProjectMCostNouser xmProjectMCostNouser1=BaseUtils.fromMap(p1,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser1);
		Map p2=BaseUtils.map("projectId","Unya","userid","xwIy","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","hK1H","projectName","Yp1V","remark","l149","id","29j0","taskId","tZOx","taskName","XEhP","subjectId","Q8K9","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","MXXr","bizFlowState","p","projectPhaseId","J0l9","actCostAmount",9834.97,"costType","6","bizMonth","Ky0x","bizDate","cWf1");
		XmProjectMCostNouser xmProjectMCostNouser2=BaseUtils.fromMap(p2,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser2);
		Map p3=BaseUtils.map("projectId","h5TE","userid","N5bQ","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","e7U4","projectName","qOHo","remark","7R6g","id","5nyo","taskId","k5Ko","taskName","Du88","subjectId","46oi","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","3v1r","bizFlowState","o","projectPhaseId","5FrD","actCostAmount",6253.13,"costType","K","bizMonth","L5pC","bizDate","z0tj");
		XmProjectMCostNouser xmProjectMCostNouser3=BaseUtils.fromMap(p3,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser3);
		Map p4=BaseUtils.map("projectId","icxz","userid","GtS2","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","kIhS","projectName","NO3d","remark","rGAT","id","G45R","taskId","0ssu","taskName","g47J","subjectId","5ah3","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","Jl2N","bizFlowState","q","projectPhaseId","Qs3z","actCostAmount",4445.52,"costType","j","bizMonth","cB5h","bizDate","vn37");
		XmProjectMCostNouser xmProjectMCostNouser4=BaseUtils.fromMap(p4,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser4);
		Map p5=BaseUtils.map("projectId","xm8J","userid","8c5p","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","TokZ","projectName","5kc2","remark","76cN","id","8An3","taskId","Gx74","taskName","Zq83","subjectId","oMku","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","YmxY","bizFlowState","X","projectPhaseId","yQF3","actCostAmount",2937.08,"costType","3","bizMonth","7XGG","bizDate","fzwN");
		XmProjectMCostNouser xmProjectMCostNouser5=BaseUtils.fromMap(p5,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser5);
		Map p6=BaseUtils.map("projectId","0k9Y","userid","F9Cp","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","0ye3","projectName","3kj6","remark","tZYU","id","9PAI","taskId","M03V","taskName","vB23","subjectId","tiXd","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","1vl3","bizFlowState","X","projectPhaseId","5fUO","actCostAmount",4147.7,"costType","N","bizMonth","aa1T","bizDate","Fa3H");
		XmProjectMCostNouser xmProjectMCostNouser6=BaseUtils.fromMap(p6,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser6);
		Map p7=BaseUtils.map("projectId","Uek3","userid","dGRV","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","7sGE","projectName","gTUN","remark","g178","id","6NXT","taskId","8mfz","taskName","4D0P","subjectId","k0Nu","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","hqD2","bizFlowState","y","projectPhaseId","FtUE","actCostAmount",1094.6,"costType","y","bizMonth","pvk4","bizDate","je5A");
		XmProjectMCostNouser xmProjectMCostNouser7=BaseUtils.fromMap(p7,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser7);
		xmProjectMCostNouserService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmProjectMCostNouser> batchValues=new ArrayList<XmProjectMCostNouser>();
		Map p0=BaseUtils.map("projectId","Uz5H","userid","7BPs","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","YNs1","projectName","UHq4","remark","kS6Q","id","a3XR","taskId","aKjk","taskName","3ylX","subjectId","pqSA","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","f3rC","bizFlowState","u","projectPhaseId","lVKX","actCostAmount",5921.4,"costType","e","bizMonth","Q3G6","bizDate","2Yqo");
		XmProjectMCostNouser xmProjectMCostNouser0=BaseUtils.fromMap(p0,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser0);
		Map p1=BaseUtils.map("projectId","2W6W","userid","0Ba3","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","Wnfc","projectName","9imu","remark","kXXF","id","vAz0","taskId","GbUq","taskName","Pvoa","subjectId","B5aa","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","201A","bizFlowState","Y","projectPhaseId","Nc35","actCostAmount",3313.66,"costType","3","bizMonth","r0Bd","bizDate","AL2F");
		XmProjectMCostNouser xmProjectMCostNouser1=BaseUtils.fromMap(p1,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser1);
		Map p2=BaseUtils.map("projectId","Unya","userid","xwIy","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","hK1H","projectName","Yp1V","remark","l149","id","29j0","taskId","tZOx","taskName","XEhP","subjectId","Q8K9","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","MXXr","bizFlowState","p","projectPhaseId","J0l9","actCostAmount",9834.97,"costType","6","bizMonth","Ky0x","bizDate","cWf1");
		XmProjectMCostNouser xmProjectMCostNouser2=BaseUtils.fromMap(p2,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser2);
		Map p3=BaseUtils.map("projectId","h5TE","userid","N5bQ","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","e7U4","projectName","qOHo","remark","7R6g","id","5nyo","taskId","k5Ko","taskName","Du88","subjectId","46oi","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","3v1r","bizFlowState","o","projectPhaseId","5FrD","actCostAmount",6253.13,"costType","K","bizMonth","L5pC","bizDate","z0tj");
		XmProjectMCostNouser xmProjectMCostNouser3=BaseUtils.fromMap(p3,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser3);
		Map p4=BaseUtils.map("projectId","icxz","userid","GtS2","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","kIhS","projectName","NO3d","remark","rGAT","id","G45R","taskId","0ssu","taskName","g47J","subjectId","5ah3","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","Jl2N","bizFlowState","q","projectPhaseId","Qs3z","actCostAmount",4445.52,"costType","j","bizMonth","cB5h","bizDate","vn37");
		XmProjectMCostNouser xmProjectMCostNouser4=BaseUtils.fromMap(p4,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser4);
		Map p5=BaseUtils.map("projectId","xm8J","userid","8c5p","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","TokZ","projectName","5kc2","remark","76cN","id","8An3","taskId","Gx74","taskName","Zq83","subjectId","oMku","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","YmxY","bizFlowState","X","projectPhaseId","yQF3","actCostAmount",2937.08,"costType","3","bizMonth","7XGG","bizDate","fzwN");
		XmProjectMCostNouser xmProjectMCostNouser5=BaseUtils.fromMap(p5,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser5);
		Map p6=BaseUtils.map("projectId","0k9Y","userid","F9Cp","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","0ye3","projectName","3kj6","remark","tZYU","id","9PAI","taskId","M03V","taskName","vB23","subjectId","tiXd","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","1vl3","bizFlowState","X","projectPhaseId","5fUO","actCostAmount",4147.7,"costType","N","bizMonth","aa1T","bizDate","Fa3H");
		XmProjectMCostNouser xmProjectMCostNouser6=BaseUtils.fromMap(p6,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser6);
		Map p7=BaseUtils.map("projectId","Uek3","userid","dGRV","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","7sGE","projectName","gTUN","remark","g178","id","6NXT","taskId","8mfz","taskName","4D0P","subjectId","k0Nu","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","hqD2","bizFlowState","y","projectPhaseId","FtUE","actCostAmount",1094.6,"costType","y","bizMonth","pvk4","bizDate","je5A");
		XmProjectMCostNouser xmProjectMCostNouser7=BaseUtils.fromMap(p7,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser7);
		xmProjectMCostNouserService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmProjectMCostNouser> batchValues=new ArrayList<XmProjectMCostNouser>();
		Map p0=BaseUtils.map("projectId","Uz5H","userid","7BPs","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","YNs1","projectName","UHq4","remark","kS6Q","id","a3XR","taskId","aKjk","taskName","3ylX","subjectId","pqSA","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","f3rC","bizFlowState","u","projectPhaseId","lVKX","actCostAmount",5921.4,"costType","e","bizMonth","Q3G6","bizDate","2Yqo");
		XmProjectMCostNouser xmProjectMCostNouser0=BaseUtils.fromMap(p0,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser0);
		Map p1=BaseUtils.map("projectId","2W6W","userid","0Ba3","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","Wnfc","projectName","9imu","remark","kXXF","id","vAz0","taskId","GbUq","taskName","Pvoa","subjectId","B5aa","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","201A","bizFlowState","Y","projectPhaseId","Nc35","actCostAmount",3313.66,"costType","3","bizMonth","r0Bd","bizDate","AL2F");
		XmProjectMCostNouser xmProjectMCostNouser1=BaseUtils.fromMap(p1,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser1);
		Map p2=BaseUtils.map("projectId","Unya","userid","xwIy","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","hK1H","projectName","Yp1V","remark","l149","id","29j0","taskId","tZOx","taskName","XEhP","subjectId","Q8K9","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","MXXr","bizFlowState","p","projectPhaseId","J0l9","actCostAmount",9834.97,"costType","6","bizMonth","Ky0x","bizDate","cWf1");
		XmProjectMCostNouser xmProjectMCostNouser2=BaseUtils.fromMap(p2,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser2);
		Map p3=BaseUtils.map("projectId","h5TE","userid","N5bQ","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","e7U4","projectName","qOHo","remark","7R6g","id","5nyo","taskId","k5Ko","taskName","Du88","subjectId","46oi","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","3v1r","bizFlowState","o","projectPhaseId","5FrD","actCostAmount",6253.13,"costType","K","bizMonth","L5pC","bizDate","z0tj");
		XmProjectMCostNouser xmProjectMCostNouser3=BaseUtils.fromMap(p3,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser3);
		Map p4=BaseUtils.map("projectId","icxz","userid","GtS2","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","kIhS","projectName","NO3d","remark","rGAT","id","G45R","taskId","0ssu","taskName","g47J","subjectId","5ah3","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","Jl2N","bizFlowState","q","projectPhaseId","Qs3z","actCostAmount",4445.52,"costType","j","bizMonth","cB5h","bizDate","vn37");
		XmProjectMCostNouser xmProjectMCostNouser4=BaseUtils.fromMap(p4,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser4);
		Map p5=BaseUtils.map("projectId","xm8J","userid","8c5p","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","TokZ","projectName","5kc2","remark","76cN","id","8An3","taskId","Gx74","taskName","Zq83","subjectId","oMku","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","YmxY","bizFlowState","X","projectPhaseId","yQF3","actCostAmount",2937.08,"costType","3","bizMonth","7XGG","bizDate","fzwN");
		XmProjectMCostNouser xmProjectMCostNouser5=BaseUtils.fromMap(p5,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser5);
		Map p6=BaseUtils.map("projectId","0k9Y","userid","F9Cp","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","0ye3","projectName","3kj6","remark","tZYU","id","9PAI","taskId","M03V","taskName","vB23","subjectId","tiXd","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","1vl3","bizFlowState","X","projectPhaseId","5fUO","actCostAmount",4147.7,"costType","N","bizMonth","aa1T","bizDate","Fa3H");
		XmProjectMCostNouser xmProjectMCostNouser6=BaseUtils.fromMap(p6,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser6);
		Map p7=BaseUtils.map("projectId","Uek3","userid","dGRV","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","7sGE","projectName","gTUN","remark","g178","id","6NXT","taskId","8mfz","taskName","4D0P","subjectId","k0Nu","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","hqD2","bizFlowState","y","projectPhaseId","FtUE","actCostAmount",1094.6,"costType","y","bizMonth","pvk4","bizDate","je5A");
		XmProjectMCostNouser xmProjectMCostNouser7=BaseUtils.fromMap(p7,XmProjectMCostNouser.class);
		batchValues.add(xmProjectMCostNouser7);
		xmProjectMCostNouserService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","a3XR");
		Map<String,Object> result=this.xmProjectMCostNouserService.selectOne(XmProjectMCostNouser.class.getName()+".selectOneMap",p);
		Assert.assertEquals("a3XR", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","Uz5H","userid","7BPs","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","YNs1","projectName","UHq4","remark","kS6Q","taskId","aKjk","taskName","3ylX","subjectId","pqSA","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","f3rC","bizFlowState","u","projectPhaseId","lVKX","actCostAmount",5921.4,"costType","e","bizMonth","Q3G6","bizDate","2Yqo");
		XmProjectMCostNouser xmProjectMCostNouser=BaseUtils.fromMap(p,XmProjectMCostNouser.class);
		long result=xmProjectMCostNouserService.countByWhere(xmProjectMCostNouser);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("projectId","Uz5H","userid","7BPs","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","YNs1","projectName","UHq4","remark","kS6Q","taskId","aKjk","taskName","3ylX","subjectId","pqSA","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","f3rC","bizFlowState","u","projectPhaseId","lVKX","actCostAmount",5921.4,"costType","e","bizMonth","Q3G6","bizDate","2Yqo");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmProjectMCostNouser xmProjectMCostNouser=BaseUtils.fromMap(p,XmProjectMCostNouser.class);
		List<XmProjectMCostNouser> result=xmProjectMCostNouserService.selectListByWhere(xmProjectMCostNouser); 
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
	
		
		Map<String,Object> p=BaseUtils.map("projectId","Uz5H","userid","7BPs","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","YNs1","projectName","UHq4","remark","kS6Q","taskId","aKjk","taskName","3ylX","subjectId","pqSA","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","f3rC","bizFlowState","u","projectPhaseId","lVKX","actCostAmount",5921.4,"costType","e","bizMonth","Q3G6","bizDate","2Yqo");
		XmProjectMCostNouser xmProjectMCostNouser=BaseUtils.fromMap(p,XmProjectMCostNouser.class);
		List<XmProjectMCostNouser> result=xmProjectMCostNouserService.selectListByWhere(xmProjectMCostNouser);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("projectId","Uz5H","userid","7BPs","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","YNs1","projectName","UHq4","remark","kS6Q","taskId","aKjk","taskName","3ylX","subjectId","pqSA","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","f3rC","bizFlowState","u","projectPhaseId","lVKX","actCostAmount",5921.4,"costType","e","bizMonth","Q3G6","bizDate","2Yqo");
		List<Map<String,Object>> result=xmProjectMCostNouserService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","Uz5H","userid","7BPs","createTime",parse("2020-09-28 15:48:47"),"sendCostTime",parse("2020-09-28 15:48:47"),"username","YNs1","projectName","UHq4","remark","kS6Q","taskId","aKjk","taskName","3ylX","subjectId","pqSA","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizProcInstId","f3rC","bizFlowState","u","projectPhaseId","lVKX","actCostAmount",5921.4,"costType","e","bizMonth","Q3G6","bizDate","2Yqo");
		List<Map<String,Object>> result=xmProjectMCostNouserService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmProjectMCostNouser
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","a3XR");
		
		XmProjectMCostNouser xmProjectMCostNouser1=BaseUtils.fromMap(p,XmProjectMCostNouser.class);
		XmProjectMCostNouser xmProjectMCostNouser=xmProjectMCostNouserService.selectOneObject(xmProjectMCostNouser1);
		Assert.assertEquals("a3XR", xmProjectMCostNouser.getId());
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
