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
import  com.qqkj.xm.core.service.XmProjectMBudgetCostUserService; 
import com.qqkj.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import  com.qqkj.xm.core.entity.XmProjectMBudgetCostUser;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmProjectMBudgetCostUserService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_project_m_budget_cost_user xm_project_m_budget_cost_user<br>
 * 实体 XmProjectMBudgetCostUser<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	projectId,userid,budgetCost,id,remark,username,subjectId,bizzStartDate,bizzEndDate,bizzMonth,bizProcInstId,bizFlowState,projectPhaseId,costType;<br>
 * 当前表的所有字段名:<br>
 *	project_id,userid,budget_cost,id,remark,username,subject_id,bizz_start_date,bizz_end_date,bizz_month,biz_proc_inst_id,biz_flow_state,project_phase_id,cost_type;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectMBudgetCostUserService  {

	@Autowired
	XmProjectMBudgetCostUserService xmProjectMBudgetCostUserService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("projectId","aH71","userid","5R6l","budgetCost",2842.17,"id","zARB","remark","FVK0","username","Sp7K","subjectId","8ONu","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","KG3H","bizProcInstId","sUMB","bizFlowState","0","projectPhaseId","mg6S","costType","E");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser=BaseUtils.fromMap(p,XmProjectMBudgetCostUser.class);
		xmProjectMBudgetCostUserService.insert(xmProjectMBudgetCostUser);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","aH71","userid","5R6l","budgetCost",2842.17,"remark","FVK0","username","Sp7K","subjectId","8ONu","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","KG3H","bizProcInstId","sUMB","bizFlowState","0","projectPhaseId","mg6S","costType","E");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser=BaseUtils.fromMap(p,XmProjectMBudgetCostUser.class);
		xmProjectMBudgetCostUserService.deleteByWhere(xmProjectMBudgetCostUser);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","zARB");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser=BaseUtils.fromMap(p,XmProjectMBudgetCostUser.class);
		xmProjectMBudgetCostUserService.deleteByPk(xmProjectMBudgetCostUser);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("projectId","aH71","userid","5R6l","budgetCost",2842.17,"remark","FVK0","username","Sp7K","subjectId","8ONu","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","KG3H","bizProcInstId","sUMB","bizFlowState","0","projectPhaseId","mg6S","costType","E");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser=BaseUtils.fromMap(where,XmProjectMBudgetCostUser.class);
		xmProjectMBudgetCostUserService.updateSomeFieldByPk(xmProjectMBudgetCostUser);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","zARB");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser=BaseUtils.fromMap(p,XmProjectMBudgetCostUser.class);
		xmProjectMBudgetCostUserService.updateByPk(xmProjectMBudgetCostUser);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("projectId","aH71","userid","5R6l","budgetCost",2842.17,"id","zARB","remark","FVK0","username","Sp7K","subjectId","8ONu","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","KG3H","bizProcInstId","sUMB","bizFlowState","0","projectPhaseId","mg6S","costType","E");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser=BaseUtils.fromMap(p,XmProjectMBudgetCostUser.class);
		xmProjectMBudgetCostUserService.insertOrUpdate(xmProjectMBudgetCostUser);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmProjectMBudgetCostUser> batchValues=new ArrayList<XmProjectMBudgetCostUser>();
		Map p0=BaseUtils.map("projectId","aH71","userid","5R6l","budgetCost",2842.17,"id","zARB","remark","FVK0","username","Sp7K","subjectId","8ONu","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","KG3H","bizProcInstId","sUMB","bizFlowState","0","projectPhaseId","mg6S","costType","E");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser0=BaseUtils.fromMap(p0,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser0);
		Map p1=BaseUtils.map("projectId","7KCP","userid","UB34","budgetCost",8708.45,"id","qyx9","remark","R0n9","username","xdZD","subjectId","e43j","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","MN5C","bizProcInstId","60z3","bizFlowState","9","projectPhaseId","0RF3","costType","G");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser1=BaseUtils.fromMap(p1,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser1);
		Map p2=BaseUtils.map("projectId","anue","userid","Rlir","budgetCost",9816.09,"id","Ftv7","remark","4ly2","username","J0TC","subjectId","Prkr","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","uN3p","bizProcInstId","3F1g","bizFlowState","R","projectPhaseId","0O45","costType","J");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser2=BaseUtils.fromMap(p2,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser2);
		Map p3=BaseUtils.map("projectId","yVNV","userid","4iFY","budgetCost",8331.36,"id","vgCA","remark","HO9v","username","6ZCg","subjectId","dgpj","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","3iva","bizProcInstId","grKn","bizFlowState","f","projectPhaseId","D2x3","costType","d");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser3=BaseUtils.fromMap(p3,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser3);
		Map p4=BaseUtils.map("projectId","i9j1","userid","pIKn","budgetCost",2159.79,"id","2Wm3","remark","5Eqo","username","4xsd","subjectId","6IcT","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","E2J7","bizProcInstId","BYzX","bizFlowState","S","projectPhaseId","rlCU","costType","O");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser4=BaseUtils.fromMap(p4,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser4);
		Map p5=BaseUtils.map("projectId","biAN","userid","U6gD","budgetCost",4169.9,"id","8jpu","remark","51ms","username","4K0y","subjectId","GS2W","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","0lTp","bizProcInstId","HQiY","bizFlowState","a","projectPhaseId","0YC7","costType","Q");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser5=BaseUtils.fromMap(p5,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser5);
		Map p6=BaseUtils.map("projectId","A1R0","userid","yr4K","budgetCost",4720.82,"id","54aW","remark","U3x6","username","61cb","subjectId","4u5Q","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","1VVg","bizProcInstId","ckVX","bizFlowState","r","projectPhaseId","DCd9","costType","q");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser6=BaseUtils.fromMap(p6,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser6);
		Map p7=BaseUtils.map("projectId","06Zc","userid","r4qE","budgetCost",4236.42,"id","sADP","remark","q8ic","username","h9gR","subjectId","N3WI","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","D1jo","bizProcInstId","rMSJ","bizFlowState","B","projectPhaseId","01ob","costType","4");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser7=BaseUtils.fromMap(p7,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser7);
		xmProjectMBudgetCostUserService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmProjectMBudgetCostUser> batchValues=new ArrayList<XmProjectMBudgetCostUser>();
		Map p0=BaseUtils.map("projectId","aH71","userid","5R6l","budgetCost",2842.17,"id","zARB","remark","FVK0","username","Sp7K","subjectId","8ONu","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","KG3H","bizProcInstId","sUMB","bizFlowState","0","projectPhaseId","mg6S","costType","E");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser0=BaseUtils.fromMap(p0,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser0);
		Map p1=BaseUtils.map("projectId","7KCP","userid","UB34","budgetCost",8708.45,"id","qyx9","remark","R0n9","username","xdZD","subjectId","e43j","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","MN5C","bizProcInstId","60z3","bizFlowState","9","projectPhaseId","0RF3","costType","G");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser1=BaseUtils.fromMap(p1,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser1);
		Map p2=BaseUtils.map("projectId","anue","userid","Rlir","budgetCost",9816.09,"id","Ftv7","remark","4ly2","username","J0TC","subjectId","Prkr","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","uN3p","bizProcInstId","3F1g","bizFlowState","R","projectPhaseId","0O45","costType","J");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser2=BaseUtils.fromMap(p2,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser2);
		Map p3=BaseUtils.map("projectId","yVNV","userid","4iFY","budgetCost",8331.36,"id","vgCA","remark","HO9v","username","6ZCg","subjectId","dgpj","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","3iva","bizProcInstId","grKn","bizFlowState","f","projectPhaseId","D2x3","costType","d");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser3=BaseUtils.fromMap(p3,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser3);
		Map p4=BaseUtils.map("projectId","i9j1","userid","pIKn","budgetCost",2159.79,"id","2Wm3","remark","5Eqo","username","4xsd","subjectId","6IcT","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","E2J7","bizProcInstId","BYzX","bizFlowState","S","projectPhaseId","rlCU","costType","O");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser4=BaseUtils.fromMap(p4,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser4);
		Map p5=BaseUtils.map("projectId","biAN","userid","U6gD","budgetCost",4169.9,"id","8jpu","remark","51ms","username","4K0y","subjectId","GS2W","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","0lTp","bizProcInstId","HQiY","bizFlowState","a","projectPhaseId","0YC7","costType","Q");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser5=BaseUtils.fromMap(p5,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser5);
		Map p6=BaseUtils.map("projectId","A1R0","userid","yr4K","budgetCost",4720.82,"id","54aW","remark","U3x6","username","61cb","subjectId","4u5Q","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","1VVg","bizProcInstId","ckVX","bizFlowState","r","projectPhaseId","DCd9","costType","q");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser6=BaseUtils.fromMap(p6,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser6);
		Map p7=BaseUtils.map("projectId","06Zc","userid","r4qE","budgetCost",4236.42,"id","sADP","remark","q8ic","username","h9gR","subjectId","N3WI","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","D1jo","bizProcInstId","rMSJ","bizFlowState","B","projectPhaseId","01ob","costType","4");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser7=BaseUtils.fromMap(p7,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser7);
		xmProjectMBudgetCostUserService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmProjectMBudgetCostUser> batchValues=new ArrayList<XmProjectMBudgetCostUser>();
		Map p0=BaseUtils.map("projectId","aH71","userid","5R6l","budgetCost",2842.17,"id","zARB","remark","FVK0","username","Sp7K","subjectId","8ONu","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","KG3H","bizProcInstId","sUMB","bizFlowState","0","projectPhaseId","mg6S","costType","E");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser0=BaseUtils.fromMap(p0,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser0);
		Map p1=BaseUtils.map("projectId","7KCP","userid","UB34","budgetCost",8708.45,"id","qyx9","remark","R0n9","username","xdZD","subjectId","e43j","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","MN5C","bizProcInstId","60z3","bizFlowState","9","projectPhaseId","0RF3","costType","G");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser1=BaseUtils.fromMap(p1,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser1);
		Map p2=BaseUtils.map("projectId","anue","userid","Rlir","budgetCost",9816.09,"id","Ftv7","remark","4ly2","username","J0TC","subjectId","Prkr","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","uN3p","bizProcInstId","3F1g","bizFlowState","R","projectPhaseId","0O45","costType","J");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser2=BaseUtils.fromMap(p2,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser2);
		Map p3=BaseUtils.map("projectId","yVNV","userid","4iFY","budgetCost",8331.36,"id","vgCA","remark","HO9v","username","6ZCg","subjectId","dgpj","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","3iva","bizProcInstId","grKn","bizFlowState","f","projectPhaseId","D2x3","costType","d");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser3=BaseUtils.fromMap(p3,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser3);
		Map p4=BaseUtils.map("projectId","i9j1","userid","pIKn","budgetCost",2159.79,"id","2Wm3","remark","5Eqo","username","4xsd","subjectId","6IcT","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","E2J7","bizProcInstId","BYzX","bizFlowState","S","projectPhaseId","rlCU","costType","O");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser4=BaseUtils.fromMap(p4,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser4);
		Map p5=BaseUtils.map("projectId","biAN","userid","U6gD","budgetCost",4169.9,"id","8jpu","remark","51ms","username","4K0y","subjectId","GS2W","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","0lTp","bizProcInstId","HQiY","bizFlowState","a","projectPhaseId","0YC7","costType","Q");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser5=BaseUtils.fromMap(p5,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser5);
		Map p6=BaseUtils.map("projectId","A1R0","userid","yr4K","budgetCost",4720.82,"id","54aW","remark","U3x6","username","61cb","subjectId","4u5Q","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","1VVg","bizProcInstId","ckVX","bizFlowState","r","projectPhaseId","DCd9","costType","q");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser6=BaseUtils.fromMap(p6,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser6);
		Map p7=BaseUtils.map("projectId","06Zc","userid","r4qE","budgetCost",4236.42,"id","sADP","remark","q8ic","username","h9gR","subjectId","N3WI","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","D1jo","bizProcInstId","rMSJ","bizFlowState","B","projectPhaseId","01ob","costType","4");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser7=BaseUtils.fromMap(p7,XmProjectMBudgetCostUser.class);
		batchValues.add(xmProjectMBudgetCostUser7);
		xmProjectMBudgetCostUserService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","zARB");
		Map<String,Object> result=this.xmProjectMBudgetCostUserService.selectOne(XmProjectMBudgetCostUser.class.getName()+".selectOneMap",p);
		Assert.assertEquals("zARB", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","aH71","userid","5R6l","budgetCost",2842.17,"remark","FVK0","username","Sp7K","subjectId","8ONu","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","KG3H","bizProcInstId","sUMB","bizFlowState","0","projectPhaseId","mg6S","costType","E");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser=BaseUtils.fromMap(p,XmProjectMBudgetCostUser.class);
		long result=xmProjectMBudgetCostUserService.countByWhere(xmProjectMBudgetCostUser);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("projectId","aH71","userid","5R6l","budgetCost",2842.17,"remark","FVK0","username","Sp7K","subjectId","8ONu","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","KG3H","bizProcInstId","sUMB","bizFlowState","0","projectPhaseId","mg6S","costType","E");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser=BaseUtils.fromMap(p,XmProjectMBudgetCostUser.class);
		List<XmProjectMBudgetCostUser> result=xmProjectMBudgetCostUserService.selectListByWhere(xmProjectMBudgetCostUser); 
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
	
		
		Map<String,Object> p=BaseUtils.map("projectId","aH71","userid","5R6l","budgetCost",2842.17,"remark","FVK0","username","Sp7K","subjectId","8ONu","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","KG3H","bizProcInstId","sUMB","bizFlowState","0","projectPhaseId","mg6S","costType","E");
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser=BaseUtils.fromMap(p,XmProjectMBudgetCostUser.class);
		List<XmProjectMBudgetCostUser> result=xmProjectMBudgetCostUserService.selectListByWhere(xmProjectMBudgetCostUser);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("projectId","aH71","userid","5R6l","budgetCost",2842.17,"remark","FVK0","username","Sp7K","subjectId","8ONu","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","KG3H","bizProcInstId","sUMB","bizFlowState","0","projectPhaseId","mg6S","costType","E");
		List<Map<String,Object>> result=xmProjectMBudgetCostUserService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","aH71","userid","5R6l","budgetCost",2842.17,"remark","FVK0","username","Sp7K","subjectId","8ONu","bizzStartDate",parse("2020-09-28 15:48:47"),"bizzEndDate",parse("2020-09-28 15:48:47"),"bizzMonth","KG3H","bizProcInstId","sUMB","bizFlowState","0","projectPhaseId","mg6S","costType","E");
		List<Map<String,Object>> result=xmProjectMBudgetCostUserService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmProjectMBudgetCostUser
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","zARB");
		
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser1=BaseUtils.fromMap(p,XmProjectMBudgetCostUser.class);
		XmProjectMBudgetCostUser xmProjectMBudgetCostUser=xmProjectMBudgetCostUserService.selectOneObject(xmProjectMBudgetCostUser1);
		Assert.assertEquals("zARB", xmProjectMBudgetCostUser.getId());
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
