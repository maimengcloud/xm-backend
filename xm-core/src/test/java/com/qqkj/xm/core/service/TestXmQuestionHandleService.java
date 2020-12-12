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
import  com.qqkj.xm.core.service.XmQuestionHandleService; 
import com.qqkj.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import  com.qqkj.xm.core.entity.XmQuestionHandle;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmQuestionHandleService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_question_handle xm_question_handle<br>
 * 实体 XmQuestionHandle<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,handlerUserid,handlerUsername,handleSolution,receiptMessage,receiptTime,handleStatus,bizProcInstId,bizFlowState,questionId,lastUpdateTime,createTime,actWorkload,actCostAmount,urls,targetUserid,targetUsername;<br>
 * 当前表的所有字段名:<br>
 *	id,handler_userid,handler_username,handle_solution,receipt_message,receipt_time,handle_status,biz_proc_inst_id,biz_flow_state,question_id,last_update_time,create_time,act_workload,act_cost_amount,urls,target_userid,target_username;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmQuestionHandleService  {

	@Autowired
	XmQuestionHandleService xmQuestionHandleService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","X8g8","handlerUserid","f2dJ","handlerUsername","c1U9","handleSolution","Cxxv","receiptMessage","9D10","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","jU8B","bizProcInstId","p8CH","bizFlowState","4","questionId","G3DH","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",8652.78,"actCostAmount",629.49,"urls","ps8t","targetUserid","BJD4","targetUsername","r8Kl");
		XmQuestionHandle xmQuestionHandle=BaseUtils.fromMap(p,XmQuestionHandle.class);
		xmQuestionHandleService.insert(xmQuestionHandle);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("handlerUserid","f2dJ","handlerUsername","c1U9","handleSolution","Cxxv","receiptMessage","9D10","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","jU8B","bizProcInstId","p8CH","bizFlowState","4","questionId","G3DH","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",8652.78,"actCostAmount",629.49,"urls","ps8t","targetUserid","BJD4","targetUsername","r8Kl");
		XmQuestionHandle xmQuestionHandle=BaseUtils.fromMap(p,XmQuestionHandle.class);
		xmQuestionHandleService.deleteByWhere(xmQuestionHandle);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","X8g8");
		XmQuestionHandle xmQuestionHandle=BaseUtils.fromMap(p,XmQuestionHandle.class);
		xmQuestionHandleService.deleteByPk(xmQuestionHandle);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("handlerUserid","f2dJ","handlerUsername","c1U9","handleSolution","Cxxv","receiptMessage","9D10","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","jU8B","bizProcInstId","p8CH","bizFlowState","4","questionId","G3DH","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",8652.78,"actCostAmount",629.49,"urls","ps8t","targetUserid","BJD4","targetUsername","r8Kl");
		XmQuestionHandle xmQuestionHandle=BaseUtils.fromMap(where,XmQuestionHandle.class);
		xmQuestionHandleService.updateSomeFieldByPk(xmQuestionHandle);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","X8g8");
		XmQuestionHandle xmQuestionHandle=BaseUtils.fromMap(p,XmQuestionHandle.class);
		xmQuestionHandleService.updateByPk(xmQuestionHandle);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("id","X8g8","handlerUserid","f2dJ","handlerUsername","c1U9","handleSolution","Cxxv","receiptMessage","9D10","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","jU8B","bizProcInstId","p8CH","bizFlowState","4","questionId","G3DH","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",8652.78,"actCostAmount",629.49,"urls","ps8t","targetUserid","BJD4","targetUsername","r8Kl");
		XmQuestionHandle xmQuestionHandle=BaseUtils.fromMap(p,XmQuestionHandle.class);
		xmQuestionHandleService.insertOrUpdate(xmQuestionHandle);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmQuestionHandle> batchValues=new ArrayList<XmQuestionHandle>();
		Map p0=BaseUtils.map("id","X8g8","handlerUserid","f2dJ","handlerUsername","c1U9","handleSolution","Cxxv","receiptMessage","9D10","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","jU8B","bizProcInstId","p8CH","bizFlowState","4","questionId","G3DH","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",8652.78,"actCostAmount",629.49,"urls","ps8t","targetUserid","BJD4","targetUsername","r8Kl");
		XmQuestionHandle xmQuestionHandle0=BaseUtils.fromMap(p0,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle0);
		Map p1=BaseUtils.map("id","maiG","handlerUserid","4thC","handlerUsername","2hcO","handleSolution","31zM","receiptMessage","IsWm","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","XY9m","bizProcInstId","S1ms","bizFlowState","5","questionId","8TB7","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",9216.14,"actCostAmount",9226.09,"urls","55xM","targetUserid","4uHH","targetUsername","PB17");
		XmQuestionHandle xmQuestionHandle1=BaseUtils.fromMap(p1,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle1);
		Map p2=BaseUtils.map("id","ldfL","handlerUserid","7JCs","handlerUsername","WDTC","handleSolution","ozbs","receiptMessage","nBNe","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","7vDJ","bizProcInstId","G49F","bizFlowState","j","questionId","s6xy","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",4216.73,"actCostAmount",364.67,"urls","N1qt","targetUserid","I9Rp","targetUsername","R1P7");
		XmQuestionHandle xmQuestionHandle2=BaseUtils.fromMap(p2,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle2);
		Map p3=BaseUtils.map("id","cBlG","handlerUserid","0pGU","handlerUsername","PXfS","handleSolution","2cPX","receiptMessage","Hb52","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","9645","bizProcInstId","8rB0","bizFlowState","1","questionId","4ZF2","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",239.62,"actCostAmount",3114.4,"urls","CU0D","targetUserid","Lxg7","targetUsername","83Pi");
		XmQuestionHandle xmQuestionHandle3=BaseUtils.fromMap(p3,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle3);
		Map p4=BaseUtils.map("id","GSv8","handlerUserid","8xzS","handlerUsername","j2IG","handleSolution","FeOq","receiptMessage","zb0n","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","2vEx","bizProcInstId","A2qn","bizFlowState","r","questionId","EeqV","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",6557.98,"actCostAmount",5572.2,"urls","sNov","targetUserid","c4kX","targetUsername","0RHm");
		XmQuestionHandle xmQuestionHandle4=BaseUtils.fromMap(p4,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle4);
		Map p5=BaseUtils.map("id","5rZo","handlerUserid","1OK1","handlerUsername","SXgM","handleSolution","Agi2","receiptMessage","BnO8","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","Uh3o","bizProcInstId","pVck","bizFlowState","I","questionId","HOg6","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",8268.34,"actCostAmount",2953.62,"urls","e9MY","targetUserid","38fJ","targetUsername","0F2n");
		XmQuestionHandle xmQuestionHandle5=BaseUtils.fromMap(p5,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle5);
		Map p6=BaseUtils.map("id","3meW","handlerUserid","sflD","handlerUsername","zWl3","handleSolution","2qkf","receiptMessage","ifoN","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","NgkW","bizProcInstId","loip","bizFlowState","r","questionId","5pbZ","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",8069.98,"actCostAmount",6703.62,"urls","rWtu","targetUserid","1Fr8","targetUsername","FIQ7");
		XmQuestionHandle xmQuestionHandle6=BaseUtils.fromMap(p6,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle6);
		Map p7=BaseUtils.map("id","gIhk","handlerUserid","464T","handlerUsername","w3g8","handleSolution","s1Pi","receiptMessage","0qYx","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","ZYMt","bizProcInstId","lZkK","bizFlowState","l","questionId","nJbP","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",2365.73,"actCostAmount",8278.79,"urls","o4H2","targetUserid","BCXd","targetUsername","yi1j");
		XmQuestionHandle xmQuestionHandle7=BaseUtils.fromMap(p7,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle7);
		xmQuestionHandleService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmQuestionHandle> batchValues=new ArrayList<XmQuestionHandle>();
		Map p0=BaseUtils.map("id","X8g8","handlerUserid","f2dJ","handlerUsername","c1U9","handleSolution","Cxxv","receiptMessage","9D10","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","jU8B","bizProcInstId","p8CH","bizFlowState","4","questionId","G3DH","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",8652.78,"actCostAmount",629.49,"urls","ps8t","targetUserid","BJD4","targetUsername","r8Kl");
		XmQuestionHandle xmQuestionHandle0=BaseUtils.fromMap(p0,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle0);
		Map p1=BaseUtils.map("id","maiG","handlerUserid","4thC","handlerUsername","2hcO","handleSolution","31zM","receiptMessage","IsWm","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","XY9m","bizProcInstId","S1ms","bizFlowState","5","questionId","8TB7","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",9216.14,"actCostAmount",9226.09,"urls","55xM","targetUserid","4uHH","targetUsername","PB17");
		XmQuestionHandle xmQuestionHandle1=BaseUtils.fromMap(p1,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle1);
		Map p2=BaseUtils.map("id","ldfL","handlerUserid","7JCs","handlerUsername","WDTC","handleSolution","ozbs","receiptMessage","nBNe","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","7vDJ","bizProcInstId","G49F","bizFlowState","j","questionId","s6xy","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",4216.73,"actCostAmount",364.67,"urls","N1qt","targetUserid","I9Rp","targetUsername","R1P7");
		XmQuestionHandle xmQuestionHandle2=BaseUtils.fromMap(p2,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle2);
		Map p3=BaseUtils.map("id","cBlG","handlerUserid","0pGU","handlerUsername","PXfS","handleSolution","2cPX","receiptMessage","Hb52","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","9645","bizProcInstId","8rB0","bizFlowState","1","questionId","4ZF2","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",239.62,"actCostAmount",3114.4,"urls","CU0D","targetUserid","Lxg7","targetUsername","83Pi");
		XmQuestionHandle xmQuestionHandle3=BaseUtils.fromMap(p3,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle3);
		Map p4=BaseUtils.map("id","GSv8","handlerUserid","8xzS","handlerUsername","j2IG","handleSolution","FeOq","receiptMessage","zb0n","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","2vEx","bizProcInstId","A2qn","bizFlowState","r","questionId","EeqV","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",6557.98,"actCostAmount",5572.2,"urls","sNov","targetUserid","c4kX","targetUsername","0RHm");
		XmQuestionHandle xmQuestionHandle4=BaseUtils.fromMap(p4,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle4);
		Map p5=BaseUtils.map("id","5rZo","handlerUserid","1OK1","handlerUsername","SXgM","handleSolution","Agi2","receiptMessage","BnO8","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","Uh3o","bizProcInstId","pVck","bizFlowState","I","questionId","HOg6","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",8268.34,"actCostAmount",2953.62,"urls","e9MY","targetUserid","38fJ","targetUsername","0F2n");
		XmQuestionHandle xmQuestionHandle5=BaseUtils.fromMap(p5,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle5);
		Map p6=BaseUtils.map("id","3meW","handlerUserid","sflD","handlerUsername","zWl3","handleSolution","2qkf","receiptMessage","ifoN","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","NgkW","bizProcInstId","loip","bizFlowState","r","questionId","5pbZ","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",8069.98,"actCostAmount",6703.62,"urls","rWtu","targetUserid","1Fr8","targetUsername","FIQ7");
		XmQuestionHandle xmQuestionHandle6=BaseUtils.fromMap(p6,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle6);
		Map p7=BaseUtils.map("id","gIhk","handlerUserid","464T","handlerUsername","w3g8","handleSolution","s1Pi","receiptMessage","0qYx","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","ZYMt","bizProcInstId","lZkK","bizFlowState","l","questionId","nJbP","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",2365.73,"actCostAmount",8278.79,"urls","o4H2","targetUserid","BCXd","targetUsername","yi1j");
		XmQuestionHandle xmQuestionHandle7=BaseUtils.fromMap(p7,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle7);
		xmQuestionHandleService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmQuestionHandle> batchValues=new ArrayList<XmQuestionHandle>();
		Map p0=BaseUtils.map("id","X8g8","handlerUserid","f2dJ","handlerUsername","c1U9","handleSolution","Cxxv","receiptMessage","9D10","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","jU8B","bizProcInstId","p8CH","bizFlowState","4","questionId","G3DH","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",8652.78,"actCostAmount",629.49,"urls","ps8t","targetUserid","BJD4","targetUsername","r8Kl");
		XmQuestionHandle xmQuestionHandle0=BaseUtils.fromMap(p0,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle0);
		Map p1=BaseUtils.map("id","maiG","handlerUserid","4thC","handlerUsername","2hcO","handleSolution","31zM","receiptMessage","IsWm","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","XY9m","bizProcInstId","S1ms","bizFlowState","5","questionId","8TB7","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",9216.14,"actCostAmount",9226.09,"urls","55xM","targetUserid","4uHH","targetUsername","PB17");
		XmQuestionHandle xmQuestionHandle1=BaseUtils.fromMap(p1,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle1);
		Map p2=BaseUtils.map("id","ldfL","handlerUserid","7JCs","handlerUsername","WDTC","handleSolution","ozbs","receiptMessage","nBNe","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","7vDJ","bizProcInstId","G49F","bizFlowState","j","questionId","s6xy","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",4216.73,"actCostAmount",364.67,"urls","N1qt","targetUserid","I9Rp","targetUsername","R1P7");
		XmQuestionHandle xmQuestionHandle2=BaseUtils.fromMap(p2,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle2);
		Map p3=BaseUtils.map("id","cBlG","handlerUserid","0pGU","handlerUsername","PXfS","handleSolution","2cPX","receiptMessage","Hb52","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","9645","bizProcInstId","8rB0","bizFlowState","1","questionId","4ZF2","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",239.62,"actCostAmount",3114.4,"urls","CU0D","targetUserid","Lxg7","targetUsername","83Pi");
		XmQuestionHandle xmQuestionHandle3=BaseUtils.fromMap(p3,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle3);
		Map p4=BaseUtils.map("id","GSv8","handlerUserid","8xzS","handlerUsername","j2IG","handleSolution","FeOq","receiptMessage","zb0n","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","2vEx","bizProcInstId","A2qn","bizFlowState","r","questionId","EeqV","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",6557.98,"actCostAmount",5572.2,"urls","sNov","targetUserid","c4kX","targetUsername","0RHm");
		XmQuestionHandle xmQuestionHandle4=BaseUtils.fromMap(p4,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle4);
		Map p5=BaseUtils.map("id","5rZo","handlerUserid","1OK1","handlerUsername","SXgM","handleSolution","Agi2","receiptMessage","BnO8","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","Uh3o","bizProcInstId","pVck","bizFlowState","I","questionId","HOg6","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",8268.34,"actCostAmount",2953.62,"urls","e9MY","targetUserid","38fJ","targetUsername","0F2n");
		XmQuestionHandle xmQuestionHandle5=BaseUtils.fromMap(p5,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle5);
		Map p6=BaseUtils.map("id","3meW","handlerUserid","sflD","handlerUsername","zWl3","handleSolution","2qkf","receiptMessage","ifoN","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","NgkW","bizProcInstId","loip","bizFlowState","r","questionId","5pbZ","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",8069.98,"actCostAmount",6703.62,"urls","rWtu","targetUserid","1Fr8","targetUsername","FIQ7");
		XmQuestionHandle xmQuestionHandle6=BaseUtils.fromMap(p6,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle6);
		Map p7=BaseUtils.map("id","gIhk","handlerUserid","464T","handlerUsername","w3g8","handleSolution","s1Pi","receiptMessage","0qYx","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","ZYMt","bizProcInstId","lZkK","bizFlowState","l","questionId","nJbP","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",2365.73,"actCostAmount",8278.79,"urls","o4H2","targetUserid","BCXd","targetUsername","yi1j");
		XmQuestionHandle xmQuestionHandle7=BaseUtils.fromMap(p7,XmQuestionHandle.class);
		batchValues.add(xmQuestionHandle7);
		xmQuestionHandleService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","X8g8");
		Map<String,Object> result=this.xmQuestionHandleService.selectOne(XmQuestionHandle.class.getName()+".selectOneMap",p);
		Assert.assertEquals("X8g8", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("handlerUserid","f2dJ","handlerUsername","c1U9","handleSolution","Cxxv","receiptMessage","9D10","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","jU8B","bizProcInstId","p8CH","bizFlowState","4","questionId","G3DH","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",8652.78,"actCostAmount",629.49,"urls","ps8t","targetUserid","BJD4","targetUsername","r8Kl");
		XmQuestionHandle xmQuestionHandle=BaseUtils.fromMap(p,XmQuestionHandle.class);
		long result=xmQuestionHandleService.countByWhere(xmQuestionHandle);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("handlerUserid","f2dJ","handlerUsername","c1U9","handleSolution","Cxxv","receiptMessage","9D10","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","jU8B","bizProcInstId","p8CH","bizFlowState","4","questionId","G3DH","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",8652.78,"actCostAmount",629.49,"urls","ps8t","targetUserid","BJD4","targetUsername","r8Kl");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmQuestionHandle xmQuestionHandle=BaseUtils.fromMap(p,XmQuestionHandle.class);
		List<XmQuestionHandle> result=xmQuestionHandleService.selectListByWhere(xmQuestionHandle); 
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
	
		
		Map<String,Object> p=BaseUtils.map("handlerUserid","f2dJ","handlerUsername","c1U9","handleSolution","Cxxv","receiptMessage","9D10","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","jU8B","bizProcInstId","p8CH","bizFlowState","4","questionId","G3DH","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",8652.78,"actCostAmount",629.49,"urls","ps8t","targetUserid","BJD4","targetUsername","r8Kl");
		XmQuestionHandle xmQuestionHandle=BaseUtils.fromMap(p,XmQuestionHandle.class);
		List<XmQuestionHandle> result=xmQuestionHandleService.selectListByWhere(xmQuestionHandle);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("handlerUserid","f2dJ","handlerUsername","c1U9","handleSolution","Cxxv","receiptMessage","9D10","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","jU8B","bizProcInstId","p8CH","bizFlowState","4","questionId","G3DH","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",8652.78,"actCostAmount",629.49,"urls","ps8t","targetUserid","BJD4","targetUsername","r8Kl");
		List<Map<String,Object>> result=xmQuestionHandleService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("handlerUserid","f2dJ","handlerUsername","c1U9","handleSolution","Cxxv","receiptMessage","9D10","receiptTime",parse("2020-10-15 23:29:30"),"handleStatus","jU8B","bizProcInstId","p8CH","bizFlowState","4","questionId","G3DH","lastUpdateTime",parse("2020-10-15 23:29:30"),"createTime",parse("2020-10-15 23:29:30"),"actWorkload",8652.78,"actCostAmount",629.49,"urls","ps8t","targetUserid","BJD4","targetUsername","r8Kl");
		List<Map<String,Object>> result=xmQuestionHandleService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmQuestionHandle
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","X8g8");
		
		XmQuestionHandle xmQuestionHandle1=BaseUtils.fromMap(p,XmQuestionHandle.class);
		XmQuestionHandle xmQuestionHandle=xmQuestionHandleService.selectOneObject(xmQuestionHandle1);
		Assert.assertEquals("X8g8", xmQuestionHandle.getId());
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
