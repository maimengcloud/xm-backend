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
import com.qqkj.xm.core.entity.XmTaskExecuser;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmTaskExecuserDao的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_task_execuser xm_task_execuser<br>
 * 实体 XmTaskExecuser<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	createTime,id,taskId,userid,startTime,endTime,status,remarks,settleAmount,settleWorkload,settleStatus,settleTime,createUserid,createUsername,username,matchScore,quoteWeekday,quoteAmount,quoteTime,bizProcInstId,bizFlowState,projectId,projectPhaseId,skillRemark,quoteWorkload,quoteStartTime,quoteEndTime,branchId,projectPhaseName,taskName,isLeader;<br>
 * 当前表的所有字段名:<br>
 *	create_time,id,task_id,userid,start_time,end_time,status,remarks,settle_amount,settle_workload,settle_status,settle_time,create_userid,create_username,username,match_score,quote_weekday,quote_amount,quote_time,biz_proc_inst_id,biz_flow_state,project_id,project_phase_id,skill_remark,quote_workload,quote_start_time,quote_end_time,branch_id,project_phase_name,task_name,is_leader;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/
 @RunWith(SpringJUnit4ClassRunner.class)
 @SpringBootTest
public class TestXmTaskExecuserDao  {

	@Autowired
	BaseDao baseDao;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","ng3t","taskId","itQ9","userid","Cn46","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","0YtP","remarks","bcE4","settleAmount",157.39,"settleWorkload",5112.74,"settleStatus","A1S1","settleTime",parse("2020-11-16 16:51:34"),"createUserid","CSZ1","createUsername","xlM7","username","vwUD","matchScore",8067.21,"quoteWeekday",8706,"quoteAmount",1332.62,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","2r9y","bizFlowState","m","projectId","fJsF","projectPhaseId","4e53","skillRemark","Op1J","quoteWorkload",3013.62,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","K9s0","projectPhaseName","8tQV","taskName","0z9g","isLeader","S");
		XmTaskExecuser xmTaskExecuser=BaseUtils.fromMap(p,XmTaskExecuser.class);
		baseDao.insert(xmTaskExecuser);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"taskId","itQ9","userid","Cn46","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","0YtP","remarks","bcE4","settleAmount",157.39,"settleWorkload",5112.74,"settleStatus","A1S1","settleTime",parse("2020-11-16 16:51:34"),"createUserid","CSZ1","createUsername","xlM7","username","vwUD","matchScore",8067.21,"quoteWeekday",8706,"quoteAmount",1332.62,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","2r9y","bizFlowState","m","projectId","fJsF","projectPhaseId","4e53","skillRemark","Op1J","quoteWorkload",3013.62,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","K9s0","projectPhaseName","8tQV","taskName","0z9g","isLeader","S");
		XmTaskExecuser xmTaskExecuser=BaseUtils.fromMap(p,XmTaskExecuser.class);
		baseDao.deleteByWhere(xmTaskExecuser);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","ng3t");
		XmTaskExecuser xmTaskExecuser=BaseUtils.fromMap(p,XmTaskExecuser.class);
		baseDao.deleteByPk(xmTaskExecuser);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"taskId","itQ9","userid","Cn46","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","0YtP","remarks","bcE4","settleAmount",157.39,"settleWorkload",5112.74,"settleStatus","A1S1","settleTime",parse("2020-11-16 16:51:34"),"createUserid","CSZ1","createUsername","xlM7","username","vwUD","matchScore",8067.21,"quoteWeekday",8706,"quoteAmount",1332.62,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","2r9y","bizFlowState","m","projectId","fJsF","projectPhaseId","4e53","skillRemark","Op1J","quoteWorkload",3013.62,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","K9s0","projectPhaseName","8tQV","taskName","0z9g","isLeader","S");
		XmTaskExecuser xmTaskExecuser=BaseUtils.fromMap(where,XmTaskExecuser.class);
		baseDao.updateSomeFieldByPk(xmTaskExecuser);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","ng3t");
		XmTaskExecuser xmTaskExecuser=BaseUtils.fromMap(p,XmTaskExecuser.class);
		baseDao.updateByPk(xmTaskExecuser);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","ng3t","taskId","itQ9","userid","Cn46","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","0YtP","remarks","bcE4","settleAmount",157.39,"settleWorkload",5112.74,"settleStatus","A1S1","settleTime",parse("2020-11-16 16:51:34"),"createUserid","CSZ1","createUsername","xlM7","username","vwUD","matchScore",8067.21,"quoteWeekday",8706,"quoteAmount",1332.62,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","2r9y","bizFlowState","m","projectId","fJsF","projectPhaseId","4e53","skillRemark","Op1J","quoteWorkload",3013.62,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","K9s0","projectPhaseName","8tQV","taskName","0z9g","isLeader","S");
		XmTaskExecuser xmTaskExecuser=BaseUtils.fromMap(p,XmTaskExecuser.class);
		baseDao.insertOrUpdate(xmTaskExecuser);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmTaskExecuser> batchValues=new ArrayList<XmTaskExecuser>();
		Map p0=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","ng3t","taskId","itQ9","userid","Cn46","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","0YtP","remarks","bcE4","settleAmount",157.39,"settleWorkload",5112.74,"settleStatus","A1S1","settleTime",parse("2020-11-16 16:51:34"),"createUserid","CSZ1","createUsername","xlM7","username","vwUD","matchScore",8067.21,"quoteWeekday",8706,"quoteAmount",1332.62,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","2r9y","bizFlowState","m","projectId","fJsF","projectPhaseId","4e53","skillRemark","Op1J","quoteWorkload",3013.62,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","K9s0","projectPhaseName","8tQV","taskName","0z9g","isLeader","S");
		XmTaskExecuser xmTaskExecuser0=BaseUtils.fromMap(p0,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser0);
		Map p1=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","m5Bu","taskId","0vd4","userid","YYWR","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","Drd1","remarks","6HQJ","settleAmount",4567.78,"settleWorkload",6801.05,"settleStatus","bea5","settleTime",parse("2020-11-16 16:51:34"),"createUserid","bLz9","createUsername","Cspj","username","k47c","matchScore",8299.51,"quoteWeekday",8539.43,"quoteAmount",1668.38,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","IHwP","bizFlowState","h","projectId","5JTa","projectPhaseId","zoW3","skillRemark","9yBl","quoteWorkload",4771.1,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","dBzG","projectPhaseName","Pbc2","taskName","DGFI","isLeader","0");
		XmTaskExecuser xmTaskExecuser1=BaseUtils.fromMap(p1,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser1);
		Map p2=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","Frq8","taskId","jSN6","userid","0lm9","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","Y90I","remarks","scNj","settleAmount",6497.86,"settleWorkload",913.9,"settleStatus","z6gC","settleTime",parse("2020-11-16 16:51:34"),"createUserid","THR0","createUsername","egNS","username","qJAK","matchScore",5914.66,"quoteWeekday",9815.78,"quoteAmount",3563.48,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","YMCR","bizFlowState","m","projectId","P592","projectPhaseId","wxP4","skillRemark","hI5y","quoteWorkload",389.49,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","vV11","projectPhaseName","G9Jk","taskName","Z7ia","isLeader","Q");
		XmTaskExecuser xmTaskExecuser2=BaseUtils.fromMap(p2,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser2);
		Map p3=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","62bw","taskId","58qu","userid","b1Te","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","cC4s","remarks","X1Ed","settleAmount",6333.27,"settleWorkload",460.9,"settleStatus","pCQQ","settleTime",parse("2020-11-16 16:51:34"),"createUserid","Me4D","createUsername","99sw","username","K5cu","matchScore",5586.75,"quoteWeekday",9815.02,"quoteAmount",307.21,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","nARA","bizFlowState","u","projectId","9qy0","projectPhaseId","8PpL","skillRemark","b4Ac","quoteWorkload",3239.54,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","arz9","projectPhaseName","7B20","taskName","5wl9","isLeader","y");
		XmTaskExecuser xmTaskExecuser3=BaseUtils.fromMap(p3,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser3);
		Map p4=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","8ii2","taskId","aPIO","userid","4GK3","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","3nud","remarks","TTdh","settleAmount",5478.28,"settleWorkload",2431.9,"settleStatus","cM6c","settleTime",parse("2020-11-16 16:51:34"),"createUserid","J5Go","createUsername","L3q4","username","Y0xI","matchScore",8925.57,"quoteWeekday",6039.02,"quoteAmount",9292.34,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","8lkL","bizFlowState","n","projectId","5hto","projectPhaseId","t08u","skillRemark","8hBA","quoteWorkload",1042.63,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","Hfvd","projectPhaseName","P0A4","taskName","fcJq","isLeader","P");
		XmTaskExecuser xmTaskExecuser4=BaseUtils.fromMap(p4,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser4);
		Map p5=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","ftF3","taskId","uQe2","userid","K5Xb","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","TyAA","remarks","1Oc0","settleAmount",4132.08,"settleWorkload",8291.33,"settleStatus","r9s7","settleTime",parse("2020-11-16 16:51:34"),"createUserid","di0I","createUsername","e49z","username","P6NV","matchScore",9128.15,"quoteWeekday",8267.32,"quoteAmount",9728.41,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","Yn9g","bizFlowState","E","projectId","DUAK","projectPhaseId","93a1","skillRemark","q5oE","quoteWorkload",9881.78,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","LBRu","projectPhaseName","4fPy","taskName","3yI3","isLeader","H");
		XmTaskExecuser xmTaskExecuser5=BaseUtils.fromMap(p5,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser5);
		Map p6=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","K1dM","taskId","zK9P","userid","rEi0","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","19fP","remarks","Hlj2","settleAmount",1822.92,"settleWorkload",4831.62,"settleStatus","YC7w","settleTime",parse("2020-11-16 16:51:34"),"createUserid","xYR4","createUsername","Ws3S","username","El54","matchScore",8971.12,"quoteWeekday",8994.47,"quoteAmount",1979.29,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","Q2W5","bizFlowState","w","projectId","WULm","projectPhaseId","VOJR","skillRemark","jwu8","quoteWorkload",6554.81,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","fqYb","projectPhaseName","zXJ5","taskName","8d4L","isLeader","b");
		XmTaskExecuser xmTaskExecuser6=BaseUtils.fromMap(p6,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser6);
		Map p7=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","sMx1","taskId","xnxK","userid","5vF0","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","tzRI","remarks","O8mS","settleAmount",9010.79,"settleWorkload",9706.25,"settleStatus","87Xt","settleTime",parse("2020-11-16 16:51:34"),"createUserid","7Urj","createUsername","u6TU","username","UKZI","matchScore",81.08,"quoteWeekday",3132.04,"quoteAmount",2343.64,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","0k71","bizFlowState","5","projectId","H3K3","projectPhaseId","55i2","skillRemark","qnye","quoteWorkload",1962.11,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","7OQs","projectPhaseName","0iEG","taskName","Xp06","isLeader","W");
		XmTaskExecuser xmTaskExecuser7=BaseUtils.fromMap(p7,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser7);
		baseDao.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmTaskExecuser> batchValues=new ArrayList<XmTaskExecuser>();
		Map p0=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","ng3t","taskId","itQ9","userid","Cn46","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","0YtP","remarks","bcE4","settleAmount",157.39,"settleWorkload",5112.74,"settleStatus","A1S1","settleTime",parse("2020-11-16 16:51:34"),"createUserid","CSZ1","createUsername","xlM7","username","vwUD","matchScore",8067.21,"quoteWeekday",8706,"quoteAmount",1332.62,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","2r9y","bizFlowState","m","projectId","fJsF","projectPhaseId","4e53","skillRemark","Op1J","quoteWorkload",3013.62,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","K9s0","projectPhaseName","8tQV","taskName","0z9g","isLeader","S");
		XmTaskExecuser xmTaskExecuser0=BaseUtils.fromMap(p0,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser0);
		Map p1=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","m5Bu","taskId","0vd4","userid","YYWR","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","Drd1","remarks","6HQJ","settleAmount",4567.78,"settleWorkload",6801.05,"settleStatus","bea5","settleTime",parse("2020-11-16 16:51:34"),"createUserid","bLz9","createUsername","Cspj","username","k47c","matchScore",8299.51,"quoteWeekday",8539.43,"quoteAmount",1668.38,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","IHwP","bizFlowState","h","projectId","5JTa","projectPhaseId","zoW3","skillRemark","9yBl","quoteWorkload",4771.1,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","dBzG","projectPhaseName","Pbc2","taskName","DGFI","isLeader","0");
		XmTaskExecuser xmTaskExecuser1=BaseUtils.fromMap(p1,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser1);
		Map p2=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","Frq8","taskId","jSN6","userid","0lm9","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","Y90I","remarks","scNj","settleAmount",6497.86,"settleWorkload",913.9,"settleStatus","z6gC","settleTime",parse("2020-11-16 16:51:34"),"createUserid","THR0","createUsername","egNS","username","qJAK","matchScore",5914.66,"quoteWeekday",9815.78,"quoteAmount",3563.48,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","YMCR","bizFlowState","m","projectId","P592","projectPhaseId","wxP4","skillRemark","hI5y","quoteWorkload",389.49,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","vV11","projectPhaseName","G9Jk","taskName","Z7ia","isLeader","Q");
		XmTaskExecuser xmTaskExecuser2=BaseUtils.fromMap(p2,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser2);
		Map p3=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","62bw","taskId","58qu","userid","b1Te","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","cC4s","remarks","X1Ed","settleAmount",6333.27,"settleWorkload",460.9,"settleStatus","pCQQ","settleTime",parse("2020-11-16 16:51:34"),"createUserid","Me4D","createUsername","99sw","username","K5cu","matchScore",5586.75,"quoteWeekday",9815.02,"quoteAmount",307.21,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","nARA","bizFlowState","u","projectId","9qy0","projectPhaseId","8PpL","skillRemark","b4Ac","quoteWorkload",3239.54,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","arz9","projectPhaseName","7B20","taskName","5wl9","isLeader","y");
		XmTaskExecuser xmTaskExecuser3=BaseUtils.fromMap(p3,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser3);
		Map p4=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","8ii2","taskId","aPIO","userid","4GK3","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","3nud","remarks","TTdh","settleAmount",5478.28,"settleWorkload",2431.9,"settleStatus","cM6c","settleTime",parse("2020-11-16 16:51:34"),"createUserid","J5Go","createUsername","L3q4","username","Y0xI","matchScore",8925.57,"quoteWeekday",6039.02,"quoteAmount",9292.34,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","8lkL","bizFlowState","n","projectId","5hto","projectPhaseId","t08u","skillRemark","8hBA","quoteWorkload",1042.63,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","Hfvd","projectPhaseName","P0A4","taskName","fcJq","isLeader","P");
		XmTaskExecuser xmTaskExecuser4=BaseUtils.fromMap(p4,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser4);
		Map p5=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","ftF3","taskId","uQe2","userid","K5Xb","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","TyAA","remarks","1Oc0","settleAmount",4132.08,"settleWorkload",8291.33,"settleStatus","r9s7","settleTime",parse("2020-11-16 16:51:34"),"createUserid","di0I","createUsername","e49z","username","P6NV","matchScore",9128.15,"quoteWeekday",8267.32,"quoteAmount",9728.41,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","Yn9g","bizFlowState","E","projectId","DUAK","projectPhaseId","93a1","skillRemark","q5oE","quoteWorkload",9881.78,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","LBRu","projectPhaseName","4fPy","taskName","3yI3","isLeader","H");
		XmTaskExecuser xmTaskExecuser5=BaseUtils.fromMap(p5,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser5);
		Map p6=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","K1dM","taskId","zK9P","userid","rEi0","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","19fP","remarks","Hlj2","settleAmount",1822.92,"settleWorkload",4831.62,"settleStatus","YC7w","settleTime",parse("2020-11-16 16:51:34"),"createUserid","xYR4","createUsername","Ws3S","username","El54","matchScore",8971.12,"quoteWeekday",8994.47,"quoteAmount",1979.29,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","Q2W5","bizFlowState","w","projectId","WULm","projectPhaseId","VOJR","skillRemark","jwu8","quoteWorkload",6554.81,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","fqYb","projectPhaseName","zXJ5","taskName","8d4L","isLeader","b");
		XmTaskExecuser xmTaskExecuser6=BaseUtils.fromMap(p6,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser6);
		Map p7=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","sMx1","taskId","xnxK","userid","5vF0","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","tzRI","remarks","O8mS","settleAmount",9010.79,"settleWorkload",9706.25,"settleStatus","87Xt","settleTime",parse("2020-11-16 16:51:34"),"createUserid","7Urj","createUsername","u6TU","username","UKZI","matchScore",81.08,"quoteWeekday",3132.04,"quoteAmount",2343.64,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","0k71","bizFlowState","5","projectId","H3K3","projectPhaseId","55i2","skillRemark","qnye","quoteWorkload",1962.11,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","7OQs","projectPhaseName","0iEG","taskName","Xp06","isLeader","W");
		XmTaskExecuser xmTaskExecuser7=BaseUtils.fromMap(p7,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser7);
		baseDao.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmTaskExecuser> batchValues=new ArrayList<XmTaskExecuser>();
		Map p0=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","ng3t","taskId","itQ9","userid","Cn46","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","0YtP","remarks","bcE4","settleAmount",157.39,"settleWorkload",5112.74,"settleStatus","A1S1","settleTime",parse("2020-11-16 16:51:34"),"createUserid","CSZ1","createUsername","xlM7","username","vwUD","matchScore",8067.21,"quoteWeekday",8706,"quoteAmount",1332.62,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","2r9y","bizFlowState","m","projectId","fJsF","projectPhaseId","4e53","skillRemark","Op1J","quoteWorkload",3013.62,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","K9s0","projectPhaseName","8tQV","taskName","0z9g","isLeader","S");
		XmTaskExecuser xmTaskExecuser0=BaseUtils.fromMap(p0,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser0);
		Map p1=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","m5Bu","taskId","0vd4","userid","YYWR","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","Drd1","remarks","6HQJ","settleAmount",4567.78,"settleWorkload",6801.05,"settleStatus","bea5","settleTime",parse("2020-11-16 16:51:34"),"createUserid","bLz9","createUsername","Cspj","username","k47c","matchScore",8299.51,"quoteWeekday",8539.43,"quoteAmount",1668.38,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","IHwP","bizFlowState","h","projectId","5JTa","projectPhaseId","zoW3","skillRemark","9yBl","quoteWorkload",4771.1,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","dBzG","projectPhaseName","Pbc2","taskName","DGFI","isLeader","0");
		XmTaskExecuser xmTaskExecuser1=BaseUtils.fromMap(p1,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser1);
		Map p2=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","Frq8","taskId","jSN6","userid","0lm9","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","Y90I","remarks","scNj","settleAmount",6497.86,"settleWorkload",913.9,"settleStatus","z6gC","settleTime",parse("2020-11-16 16:51:34"),"createUserid","THR0","createUsername","egNS","username","qJAK","matchScore",5914.66,"quoteWeekday",9815.78,"quoteAmount",3563.48,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","YMCR","bizFlowState","m","projectId","P592","projectPhaseId","wxP4","skillRemark","hI5y","quoteWorkload",389.49,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","vV11","projectPhaseName","G9Jk","taskName","Z7ia","isLeader","Q");
		XmTaskExecuser xmTaskExecuser2=BaseUtils.fromMap(p2,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser2);
		Map p3=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","62bw","taskId","58qu","userid","b1Te","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","cC4s","remarks","X1Ed","settleAmount",6333.27,"settleWorkload",460.9,"settleStatus","pCQQ","settleTime",parse("2020-11-16 16:51:34"),"createUserid","Me4D","createUsername","99sw","username","K5cu","matchScore",5586.75,"quoteWeekday",9815.02,"quoteAmount",307.21,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","nARA","bizFlowState","u","projectId","9qy0","projectPhaseId","8PpL","skillRemark","b4Ac","quoteWorkload",3239.54,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","arz9","projectPhaseName","7B20","taskName","5wl9","isLeader","y");
		XmTaskExecuser xmTaskExecuser3=BaseUtils.fromMap(p3,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser3);
		Map p4=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","8ii2","taskId","aPIO","userid","4GK3","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","3nud","remarks","TTdh","settleAmount",5478.28,"settleWorkload",2431.9,"settleStatus","cM6c","settleTime",parse("2020-11-16 16:51:34"),"createUserid","J5Go","createUsername","L3q4","username","Y0xI","matchScore",8925.57,"quoteWeekday",6039.02,"quoteAmount",9292.34,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","8lkL","bizFlowState","n","projectId","5hto","projectPhaseId","t08u","skillRemark","8hBA","quoteWorkload",1042.63,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","Hfvd","projectPhaseName","P0A4","taskName","fcJq","isLeader","P");
		XmTaskExecuser xmTaskExecuser4=BaseUtils.fromMap(p4,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser4);
		Map p5=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","ftF3","taskId","uQe2","userid","K5Xb","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","TyAA","remarks","1Oc0","settleAmount",4132.08,"settleWorkload",8291.33,"settleStatus","r9s7","settleTime",parse("2020-11-16 16:51:34"),"createUserid","di0I","createUsername","e49z","username","P6NV","matchScore",9128.15,"quoteWeekday",8267.32,"quoteAmount",9728.41,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","Yn9g","bizFlowState","E","projectId","DUAK","projectPhaseId","93a1","skillRemark","q5oE","quoteWorkload",9881.78,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","LBRu","projectPhaseName","4fPy","taskName","3yI3","isLeader","H");
		XmTaskExecuser xmTaskExecuser5=BaseUtils.fromMap(p5,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser5);
		Map p6=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","K1dM","taskId","zK9P","userid","rEi0","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","19fP","remarks","Hlj2","settleAmount",1822.92,"settleWorkload",4831.62,"settleStatus","YC7w","settleTime",parse("2020-11-16 16:51:34"),"createUserid","xYR4","createUsername","Ws3S","username","El54","matchScore",8971.12,"quoteWeekday",8994.47,"quoteAmount",1979.29,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","Q2W5","bizFlowState","w","projectId","WULm","projectPhaseId","VOJR","skillRemark","jwu8","quoteWorkload",6554.81,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","fqYb","projectPhaseName","zXJ5","taskName","8d4L","isLeader","b");
		XmTaskExecuser xmTaskExecuser6=BaseUtils.fromMap(p6,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser6);
		Map p7=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"id","sMx1","taskId","xnxK","userid","5vF0","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","tzRI","remarks","O8mS","settleAmount",9010.79,"settleWorkload",9706.25,"settleStatus","87Xt","settleTime",parse("2020-11-16 16:51:34"),"createUserid","7Urj","createUsername","u6TU","username","UKZI","matchScore",81.08,"quoteWeekday",3132.04,"quoteAmount",2343.64,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","0k71","bizFlowState","5","projectId","H3K3","projectPhaseId","55i2","skillRemark","qnye","quoteWorkload",1962.11,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","7OQs","projectPhaseName","0iEG","taskName","Xp06","isLeader","W");
		XmTaskExecuser xmTaskExecuser7=BaseUtils.fromMap(p7,XmTaskExecuser.class);
		batchValues.add(xmTaskExecuser7);
		baseDao.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","ng3t");
		Map<String,Object> result=this.baseDao.selectOne(XmTaskExecuser.class.getName()+".selectOneMap",p);
		Assert.assertEquals("ng3t", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"taskId","itQ9","userid","Cn46","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","0YtP","remarks","bcE4","settleAmount",157.39,"settleWorkload",5112.74,"settleStatus","A1S1","settleTime",parse("2020-11-16 16:51:34"),"createUserid","CSZ1","createUsername","xlM7","username","vwUD","matchScore",8067.21,"quoteWeekday",8706,"quoteAmount",1332.62,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","2r9y","bizFlowState","m","projectId","fJsF","projectPhaseId","4e53","skillRemark","Op1J","quoteWorkload",3013.62,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","K9s0","projectPhaseName","8tQV","taskName","0z9g","isLeader","S");
		XmTaskExecuser xmTaskExecuser=BaseUtils.fromMap(p,XmTaskExecuser.class);
		long result=baseDao.countByWhere(xmTaskExecuser);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
 		
		
		Map<String,Object> p=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"taskId","itQ9","userid","Cn46","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","0YtP","remarks","bcE4","settleAmount",157.39,"settleWorkload",5112.74,"settleStatus","A1S1","settleTime",parse("2020-11-16 16:51:34"),"createUserid","CSZ1","createUsername","xlM7","username","vwUD","matchScore",8067.21,"quoteWeekday",8706,"quoteAmount",1332.62,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","2r9y","bizFlowState","m","projectId","fJsF","projectPhaseId","4e53","skillRemark","Op1J","quoteWorkload",3013.62,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","K9s0","projectPhaseName","8tQV","taskName","0z9g","isLeader","S");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmTaskExecuser xmTaskExecuser=BaseUtils.fromMap(p,XmTaskExecuser.class);
		List<XmTaskExecuser> result=baseDao.selectListByWhere(xmTaskExecuser); 
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
	
		
		Map<String,Object> p=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"taskId","itQ9","userid","Cn46","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","0YtP","remarks","bcE4","settleAmount",157.39,"settleWorkload",5112.74,"settleStatus","A1S1","settleTime",parse("2020-11-16 16:51:34"),"createUserid","CSZ1","createUsername","xlM7","username","vwUD","matchScore",8067.21,"quoteWeekday",8706,"quoteAmount",1332.62,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","2r9y","bizFlowState","m","projectId","fJsF","projectPhaseId","4e53","skillRemark","Op1J","quoteWorkload",3013.62,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","K9s0","projectPhaseName","8tQV","taskName","0z9g","isLeader","S");
		XmTaskExecuser xmTaskExecuser=BaseUtils.fromMap(p,XmTaskExecuser.class);
		List<XmTaskExecuser> result=baseDao.selectListByWhere(xmTaskExecuser);
		Assert.assertEquals(true, result.size()>=1);
	}

	
	/**
	 * 查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"taskId","itQ9","userid","Cn46","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","0YtP","remarks","bcE4","settleAmount",157.39,"settleWorkload",5112.74,"settleStatus","A1S1","settleTime",parse("2020-11-16 16:51:34"),"createUserid","CSZ1","createUsername","xlM7","username","vwUD","matchScore",8067.21,"quoteWeekday",8706,"quoteAmount",1332.62,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","2r9y","bizFlowState","m","projectId","fJsF","projectPhaseId","4e53","skillRemark","Op1J","quoteWorkload",3013.62,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","K9s0","projectPhaseName","8tQV","taskName","0z9g","isLeader","S");
		List<Map<String,Object>> result=baseDao.selectList(XmTaskExecuser.class.getName()+".selectListMapByWhere",p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("createTime",parse("2020-11-16 16:51:34"),"taskId","itQ9","userid","Cn46","startTime",parse("2020-11-16 16:51:34"),"endTime",parse("2020-11-16 16:51:34"),"status","0YtP","remarks","bcE4","settleAmount",157.39,"settleWorkload",5112.74,"settleStatus","A1S1","settleTime",parse("2020-11-16 16:51:34"),"createUserid","CSZ1","createUsername","xlM7","username","vwUD","matchScore",8067.21,"quoteWeekday",8706,"quoteAmount",1332.62,"quoteTime",parse("2020-11-16 16:51:34"),"bizProcInstId","2r9y","bizFlowState","m","projectId","fJsF","projectPhaseId","4e53","skillRemark","Op1J","quoteWorkload",3013.62,"quoteStartTime",parse("2020-11-16 16:51:34"),"quoteEndTime",parse("2020-11-16 16:51:34"),"branchId","K9s0","projectPhaseName","8tQV","taskName","0z9g","isLeader","S");
		List<Map<String,Object>> result=baseDao.selectList(XmTaskExecuser.class.getName()+".selectListMapByKey",p);
		Assert.assertEquals(true, result.size()>=0);
	}
 
	/**
	 * 查询一个对象 XmTaskExecuser
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","ng3t");
		
		XmTaskExecuser xmTaskExecuser1=BaseUtils.fromMap(p,XmTaskExecuser.class);
		XmTaskExecuser xmTaskExecuser=baseDao.selectOneObject(xmTaskExecuser1);
		Assert.assertEquals("ng3t", xmTaskExecuser.getId());
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
