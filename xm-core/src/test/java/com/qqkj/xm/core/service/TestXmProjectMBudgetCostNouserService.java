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
import  com.qqkj.xm.core.service.XmProjectMBudgetCostNouserService; 
import com.qqkj.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import  com.qqkj.xm.core.entity.XmProjectMBudgetCostNouser;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmProjectMBudgetCostNouserService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_project_m_budget_cost_nouser xm_project_m_budget_cost_nouser<br>
 * 实体 XmProjectMBudgetCostNouser<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	projectId,budgetCost,id,remark,subjectId,bizzStartDate,bizzEndDate,bizProcInstId,bizFlowState,projectPhaseId,costType,bizzMonth;<br>
 * 当前表的所有字段名:<br>
 *	project_id,budget_cost,id,remark,subject_id,bizz_start_date,bizz_end_date,biz_proc_inst_id,biz_flow_state,project_phase_id,cost_type,bizz_month;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectMBudgetCostNouserService  {

	@Autowired
	XmProjectMBudgetCostNouserService xmProjectMBudgetCostNouserService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("projectId","a9ls","budgetCost",9055.6,"id","6TJJ","remark","q8PA","subjectId","0bc9","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","xzav","bizFlowState","r","projectPhaseId","kcmN","costType","4","bizzMonth","4Ukt");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser=BaseUtils.fromMap(p,XmProjectMBudgetCostNouser.class);
		xmProjectMBudgetCostNouserService.insert(xmProjectMBudgetCostNouser);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","a9ls","budgetCost",9055.6,"remark","q8PA","subjectId","0bc9","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","xzav","bizFlowState","r","projectPhaseId","kcmN","costType","4","bizzMonth","4Ukt");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser=BaseUtils.fromMap(p,XmProjectMBudgetCostNouser.class);
		xmProjectMBudgetCostNouserService.deleteByWhere(xmProjectMBudgetCostNouser);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","6TJJ");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser=BaseUtils.fromMap(p,XmProjectMBudgetCostNouser.class);
		xmProjectMBudgetCostNouserService.deleteByPk(xmProjectMBudgetCostNouser);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("projectId","a9ls","budgetCost",9055.6,"remark","q8PA","subjectId","0bc9","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","xzav","bizFlowState","r","projectPhaseId","kcmN","costType","4","bizzMonth","4Ukt");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser=BaseUtils.fromMap(where,XmProjectMBudgetCostNouser.class);
		xmProjectMBudgetCostNouserService.updateSomeFieldByPk(xmProjectMBudgetCostNouser);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","6TJJ");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser=BaseUtils.fromMap(p,XmProjectMBudgetCostNouser.class);
		xmProjectMBudgetCostNouserService.updateByPk(xmProjectMBudgetCostNouser);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("projectId","a9ls","budgetCost",9055.6,"id","6TJJ","remark","q8PA","subjectId","0bc9","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","xzav","bizFlowState","r","projectPhaseId","kcmN","costType","4","bizzMonth","4Ukt");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser=BaseUtils.fromMap(p,XmProjectMBudgetCostNouser.class);
		xmProjectMBudgetCostNouserService.insertOrUpdate(xmProjectMBudgetCostNouser);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmProjectMBudgetCostNouser> batchValues=new ArrayList<XmProjectMBudgetCostNouser>();
		Map p0=BaseUtils.map("projectId","a9ls","budgetCost",9055.6,"id","6TJJ","remark","q8PA","subjectId","0bc9","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","xzav","bizFlowState","r","projectPhaseId","kcmN","costType","4","bizzMonth","4Ukt");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser0=BaseUtils.fromMap(p0,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser0);
		Map p1=BaseUtils.map("projectId","DMvZ","budgetCost",6211.13,"id","Uo77","remark","w997","subjectId","PzGW","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","ASDl","bizFlowState","I","projectPhaseId","KNCO","costType","E","bizzMonth","nUuc");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser1=BaseUtils.fromMap(p1,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser1);
		Map p2=BaseUtils.map("projectId","nL91","budgetCost",5894.14,"id","6ETx","remark","8qs8","subjectId","Rci8","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","BBbl","bizFlowState","x","projectPhaseId","2ycP","costType","F","bizzMonth","n9B5");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser2=BaseUtils.fromMap(p2,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser2);
		Map p3=BaseUtils.map("projectId","tnEX","budgetCost",6161.8,"id","rry7","remark","IS32","subjectId","V4J3","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","YONB","bizFlowState","0","projectPhaseId","3dKn","costType","5","bizzMonth","5J4E");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser3=BaseUtils.fromMap(p3,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser3);
		Map p4=BaseUtils.map("projectId","o0Nv","budgetCost",864.83,"id","IEb6","remark","XW5g","subjectId","lA1N","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","F8K3","bizFlowState","8","projectPhaseId","4rxq","costType","1","bizzMonth","E3p3");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser4=BaseUtils.fromMap(p4,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser4);
		Map p5=BaseUtils.map("projectId","thfF","budgetCost",904.96,"id","tZVi","remark","Pk8O","subjectId","uHyU","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","zk34","bizFlowState","F","projectPhaseId","Uw8c","costType","S","bizzMonth","qIXV");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser5=BaseUtils.fromMap(p5,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser5);
		Map p6=BaseUtils.map("projectId","3QrR","budgetCost",3900.61,"id","2uYv","remark","uvg0","subjectId","yYns","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","l16F","bizFlowState","d","projectPhaseId","2gy0","costType","h","bizzMonth","29m5");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser6=BaseUtils.fromMap(p6,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser6);
		Map p7=BaseUtils.map("projectId","QUQy","budgetCost",4049.37,"id","sCHu","remark","Fe13","subjectId","D5jG","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","F5xn","bizFlowState","G","projectPhaseId","tGtB","costType","f","bizzMonth","ngH6");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser7=BaseUtils.fromMap(p7,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser7);
		xmProjectMBudgetCostNouserService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmProjectMBudgetCostNouser> batchValues=new ArrayList<XmProjectMBudgetCostNouser>();
		Map p0=BaseUtils.map("projectId","a9ls","budgetCost",9055.6,"id","6TJJ","remark","q8PA","subjectId","0bc9","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","xzav","bizFlowState","r","projectPhaseId","kcmN","costType","4","bizzMonth","4Ukt");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser0=BaseUtils.fromMap(p0,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser0);
		Map p1=BaseUtils.map("projectId","DMvZ","budgetCost",6211.13,"id","Uo77","remark","w997","subjectId","PzGW","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","ASDl","bizFlowState","I","projectPhaseId","KNCO","costType","E","bizzMonth","nUuc");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser1=BaseUtils.fromMap(p1,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser1);
		Map p2=BaseUtils.map("projectId","nL91","budgetCost",5894.14,"id","6ETx","remark","8qs8","subjectId","Rci8","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","BBbl","bizFlowState","x","projectPhaseId","2ycP","costType","F","bizzMonth","n9B5");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser2=BaseUtils.fromMap(p2,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser2);
		Map p3=BaseUtils.map("projectId","tnEX","budgetCost",6161.8,"id","rry7","remark","IS32","subjectId","V4J3","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","YONB","bizFlowState","0","projectPhaseId","3dKn","costType","5","bizzMonth","5J4E");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser3=BaseUtils.fromMap(p3,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser3);
		Map p4=BaseUtils.map("projectId","o0Nv","budgetCost",864.83,"id","IEb6","remark","XW5g","subjectId","lA1N","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","F8K3","bizFlowState","8","projectPhaseId","4rxq","costType","1","bizzMonth","E3p3");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser4=BaseUtils.fromMap(p4,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser4);
		Map p5=BaseUtils.map("projectId","thfF","budgetCost",904.96,"id","tZVi","remark","Pk8O","subjectId","uHyU","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","zk34","bizFlowState","F","projectPhaseId","Uw8c","costType","S","bizzMonth","qIXV");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser5=BaseUtils.fromMap(p5,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser5);
		Map p6=BaseUtils.map("projectId","3QrR","budgetCost",3900.61,"id","2uYv","remark","uvg0","subjectId","yYns","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","l16F","bizFlowState","d","projectPhaseId","2gy0","costType","h","bizzMonth","29m5");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser6=BaseUtils.fromMap(p6,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser6);
		Map p7=BaseUtils.map("projectId","QUQy","budgetCost",4049.37,"id","sCHu","remark","Fe13","subjectId","D5jG","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","F5xn","bizFlowState","G","projectPhaseId","tGtB","costType","f","bizzMonth","ngH6");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser7=BaseUtils.fromMap(p7,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser7);
		xmProjectMBudgetCostNouserService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmProjectMBudgetCostNouser> batchValues=new ArrayList<XmProjectMBudgetCostNouser>();
		Map p0=BaseUtils.map("projectId","a9ls","budgetCost",9055.6,"id","6TJJ","remark","q8PA","subjectId","0bc9","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","xzav","bizFlowState","r","projectPhaseId","kcmN","costType","4","bizzMonth","4Ukt");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser0=BaseUtils.fromMap(p0,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser0);
		Map p1=BaseUtils.map("projectId","DMvZ","budgetCost",6211.13,"id","Uo77","remark","w997","subjectId","PzGW","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","ASDl","bizFlowState","I","projectPhaseId","KNCO","costType","E","bizzMonth","nUuc");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser1=BaseUtils.fromMap(p1,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser1);
		Map p2=BaseUtils.map("projectId","nL91","budgetCost",5894.14,"id","6ETx","remark","8qs8","subjectId","Rci8","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","BBbl","bizFlowState","x","projectPhaseId","2ycP","costType","F","bizzMonth","n9B5");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser2=BaseUtils.fromMap(p2,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser2);
		Map p3=BaseUtils.map("projectId","tnEX","budgetCost",6161.8,"id","rry7","remark","IS32","subjectId","V4J3","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","YONB","bizFlowState","0","projectPhaseId","3dKn","costType","5","bizzMonth","5J4E");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser3=BaseUtils.fromMap(p3,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser3);
		Map p4=BaseUtils.map("projectId","o0Nv","budgetCost",864.83,"id","IEb6","remark","XW5g","subjectId","lA1N","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","F8K3","bizFlowState","8","projectPhaseId","4rxq","costType","1","bizzMonth","E3p3");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser4=BaseUtils.fromMap(p4,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser4);
		Map p5=BaseUtils.map("projectId","thfF","budgetCost",904.96,"id","tZVi","remark","Pk8O","subjectId","uHyU","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","zk34","bizFlowState","F","projectPhaseId","Uw8c","costType","S","bizzMonth","qIXV");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser5=BaseUtils.fromMap(p5,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser5);
		Map p6=BaseUtils.map("projectId","3QrR","budgetCost",3900.61,"id","2uYv","remark","uvg0","subjectId","yYns","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","l16F","bizFlowState","d","projectPhaseId","2gy0","costType","h","bizzMonth","29m5");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser6=BaseUtils.fromMap(p6,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser6);
		Map p7=BaseUtils.map("projectId","QUQy","budgetCost",4049.37,"id","sCHu","remark","Fe13","subjectId","D5jG","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","F5xn","bizFlowState","G","projectPhaseId","tGtB","costType","f","bizzMonth","ngH6");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser7=BaseUtils.fromMap(p7,XmProjectMBudgetCostNouser.class);
		batchValues.add(xmProjectMBudgetCostNouser7);
		xmProjectMBudgetCostNouserService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","6TJJ");
		Map<String,Object> result=this.xmProjectMBudgetCostNouserService.selectOne(XmProjectMBudgetCostNouser.class.getName()+".selectOneMap",p);
		Assert.assertEquals("6TJJ", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","a9ls","budgetCost",9055.6,"remark","q8PA","subjectId","0bc9","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","xzav","bizFlowState","r","projectPhaseId","kcmN","costType","4","bizzMonth","4Ukt");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser=BaseUtils.fromMap(p,XmProjectMBudgetCostNouser.class);
		long result=xmProjectMBudgetCostNouserService.countByWhere(xmProjectMBudgetCostNouser);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("projectId","a9ls","budgetCost",9055.6,"remark","q8PA","subjectId","0bc9","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","xzav","bizFlowState","r","projectPhaseId","kcmN","costType","4","bizzMonth","4Ukt");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser=BaseUtils.fromMap(p,XmProjectMBudgetCostNouser.class);
		List<XmProjectMBudgetCostNouser> result=xmProjectMBudgetCostNouserService.selectListByWhere(xmProjectMBudgetCostNouser); 
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
	
		
		Map<String,Object> p=BaseUtils.map("projectId","a9ls","budgetCost",9055.6,"remark","q8PA","subjectId","0bc9","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","xzav","bizFlowState","r","projectPhaseId","kcmN","costType","4","bizzMonth","4Ukt");
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser=BaseUtils.fromMap(p,XmProjectMBudgetCostNouser.class);
		List<XmProjectMBudgetCostNouser> result=xmProjectMBudgetCostNouserService.selectListByWhere(xmProjectMBudgetCostNouser);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("projectId","a9ls","budgetCost",9055.6,"remark","q8PA","subjectId","0bc9","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","xzav","bizFlowState","r","projectPhaseId","kcmN","costType","4","bizzMonth","4Ukt");
		List<Map<String,Object>> result=xmProjectMBudgetCostNouserService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","a9ls","budgetCost",9055.6,"remark","q8PA","subjectId","0bc9","bizzStartDate",parse("2020-09-28 15:48:44"),"bizzEndDate",parse("2020-09-28 15:48:44"),"bizProcInstId","xzav","bizFlowState","r","projectPhaseId","kcmN","costType","4","bizzMonth","4Ukt");
		List<Map<String,Object>> result=xmProjectMBudgetCostNouserService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmProjectMBudgetCostNouser
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","6TJJ");
		
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser1=BaseUtils.fromMap(p,XmProjectMBudgetCostNouser.class);
		XmProjectMBudgetCostNouser xmProjectMBudgetCostNouser=xmProjectMBudgetCostNouserService.selectOneObject(xmProjectMBudgetCostNouser1);
		Assert.assertEquals("6TJJ", xmProjectMBudgetCostNouser.getId());
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
