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
import com.qqkj.xm.core.entity.XmProjectKpiHis;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmProjectKpiHisDao的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_project_kpi_his xm_project_kpi_his<br>
 * 实体 XmProjectKpiHis<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	projectId,branchId,kpiIndex,kpiName,maxValue,minValue,kpiId,score,scoreDate,bizFlowState,bizProcInstId,kpiValue,cdate,id,remark,calcType,nextCalcDate;<br>
 * 当前表的所有字段名:<br>
 *	project_id,branch_id,kpi_index,kpi_name,max_value,min_value,kpi_id,score,score_date,biz_flow_state,biz_proc_inst_id,kpi_value,cdate,id,remark,calc_type,next_calc_date;<br>
 * 当前主键(包括多主键):<br>
 *	kpi_id;<br>
 ***/
 @RunWith(SpringJUnit4ClassRunner.class)
 @SpringBootTest
public class TestXmProjectKpiHisDao  {

	@Autowired
	BaseDao baseDao;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("projectId","ynG6","branchId","w49f","kpiIndex","Wamp","kpiName","scfM","maxValue","dhi0","minValue","ak6C","kpiId","dB26","score",4140,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","H90W","bizProcInstId","1lol","kpiValue","MkoY","cdate",parse("2020-10-01 0:41:53"),"id","I6CN","remark","LvSY","calcType","hR8y","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis=BaseUtils.fromMap(p,XmProjectKpiHis.class);
		baseDao.insert(xmProjectKpiHis);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","ynG6","branchId","w49f","kpiIndex","Wamp","kpiName","scfM","maxValue","dhi0","minValue","ak6C","score",4140,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","H90W","bizProcInstId","1lol","kpiValue","MkoY","cdate",parse("2020-10-01 0:41:53"),"id","I6CN","remark","LvSY","calcType","hR8y","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis=BaseUtils.fromMap(p,XmProjectKpiHis.class);
		baseDao.deleteByWhere(xmProjectKpiHis);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("kpiId","dB26");
		XmProjectKpiHis xmProjectKpiHis=BaseUtils.fromMap(p,XmProjectKpiHis.class);
		baseDao.deleteByPk(xmProjectKpiHis);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("projectId","ynG6","branchId","w49f","kpiIndex","Wamp","kpiName","scfM","maxValue","dhi0","minValue","ak6C","score",4140,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","H90W","bizProcInstId","1lol","kpiValue","MkoY","cdate",parse("2020-10-01 0:41:53"),"id","I6CN","remark","LvSY","calcType","hR8y","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis=BaseUtils.fromMap(where,XmProjectKpiHis.class);
		baseDao.updateSomeFieldByPk(xmProjectKpiHis);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("kpiId","dB26");
		XmProjectKpiHis xmProjectKpiHis=BaseUtils.fromMap(p,XmProjectKpiHis.class);
		baseDao.updateByPk(xmProjectKpiHis);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("projectId","ynG6","branchId","w49f","kpiIndex","Wamp","kpiName","scfM","maxValue","dhi0","minValue","ak6C","kpiId","dB26","score",4140,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","H90W","bizProcInstId","1lol","kpiValue","MkoY","cdate",parse("2020-10-01 0:41:53"),"id","I6CN","remark","LvSY","calcType","hR8y","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis=BaseUtils.fromMap(p,XmProjectKpiHis.class);
		baseDao.insertOrUpdate(xmProjectKpiHis);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmProjectKpiHis> batchValues=new ArrayList<XmProjectKpiHis>();
		Map p0=BaseUtils.map("projectId","ynG6","branchId","w49f","kpiIndex","Wamp","kpiName","scfM","maxValue","dhi0","minValue","ak6C","kpiId","dB26","score",4140,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","H90W","bizProcInstId","1lol","kpiValue","MkoY","cdate",parse("2020-10-01 0:41:53"),"id","I6CN","remark","LvSY","calcType","hR8y","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis0=BaseUtils.fromMap(p0,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis0);
		Map p1=BaseUtils.map("projectId","k9v8","branchId","6WCT","kpiIndex","jb9w","kpiName","0BVI","maxValue","gM03","minValue","1k09","kpiId","6kBE","score",2013,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","HmIC","bizProcInstId","i9yk","kpiValue","7Qf9","cdate",parse("2020-10-01 0:41:53"),"id","h6nC","remark","9b76","calcType","gmKa","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis1=BaseUtils.fromMap(p1,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis1);
		Map p2=BaseUtils.map("projectId","e2Iq","branchId","H7U7","kpiIndex","5Ij3","kpiName","FRsG","maxValue","V3Sf","minValue","svyw","kpiId","J9U3","score",61,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","feWS","bizProcInstId","8fU2","kpiValue","mG1A","cdate",parse("2020-10-01 0:41:53"),"id","yUVu","remark","N0II","calcType","d530","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis2=BaseUtils.fromMap(p2,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis2);
		Map p3=BaseUtils.map("projectId","gqzt","branchId","u47T","kpiIndex","aT9Y","kpiName","FJJA","maxValue","xnI4","minValue","S3s2","kpiId","7Nbh","score",4902,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","x8iP","bizProcInstId","jNp9","kpiValue","41r3","cdate",parse("2020-10-01 0:41:53"),"id","7pNO","remark","Wwcw","calcType","kgsp","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis3=BaseUtils.fromMap(p3,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis3);
		Map p4=BaseUtils.map("projectId","wPmp","branchId","UWPW","kpiIndex","06x2","kpiName","QOtS","maxValue","V63A","minValue","7200","kpiId","IOsD","score",3845,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","8L72","bizProcInstId","4gJb","kpiValue","FxU5","cdate",parse("2020-10-01 0:41:53"),"id","WZ3x","remark","shHX","calcType","5imd","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis4=BaseUtils.fromMap(p4,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis4);
		Map p5=BaseUtils.map("projectId","x12w","branchId","E3Yf","kpiIndex","9lda","kpiName","eaox","maxValue","Jv1y","minValue","cD4r","kpiId","NwjU","score",3064,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","4jQi","bizProcInstId","nY9q","kpiValue","pqw6","cdate",parse("2020-10-01 0:41:53"),"id","XWDF","remark","m11i","calcType","rf1T","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis5=BaseUtils.fromMap(p5,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis5);
		Map p6=BaseUtils.map("projectId","Bp06","branchId","81aC","kpiIndex","7FCs","kpiName","T0uY","maxValue","l5Kw","minValue","7g5I","kpiId","9taH","score",7218,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","7tVV","bizProcInstId","TV7q","kpiValue","mTF6","cdate",parse("2020-10-01 0:41:53"),"id","e65N","remark","bvw7","calcType","Ef0i","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis6=BaseUtils.fromMap(p6,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis6);
		Map p7=BaseUtils.map("projectId","oNzN","branchId","L8mV","kpiIndex","5vMS","kpiName","fRHY","maxValue","tN0T","minValue","U8xm","kpiId","gjun","score",9767,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","6X46","bizProcInstId","0Qah","kpiValue","sgUK","cdate",parse("2020-10-01 0:41:53"),"id","g8Lr","remark","WNh3","calcType","08Zw","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis7=BaseUtils.fromMap(p7,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis7);
		baseDao.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmProjectKpiHis> batchValues=new ArrayList<XmProjectKpiHis>();
		Map p0=BaseUtils.map("projectId","ynG6","branchId","w49f","kpiIndex","Wamp","kpiName","scfM","maxValue","dhi0","minValue","ak6C","kpiId","dB26","score",4140,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","H90W","bizProcInstId","1lol","kpiValue","MkoY","cdate",parse("2020-10-01 0:41:53"),"id","I6CN","remark","LvSY","calcType","hR8y","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis0=BaseUtils.fromMap(p0,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis0);
		Map p1=BaseUtils.map("projectId","k9v8","branchId","6WCT","kpiIndex","jb9w","kpiName","0BVI","maxValue","gM03","minValue","1k09","kpiId","6kBE","score",2013,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","HmIC","bizProcInstId","i9yk","kpiValue","7Qf9","cdate",parse("2020-10-01 0:41:53"),"id","h6nC","remark","9b76","calcType","gmKa","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis1=BaseUtils.fromMap(p1,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis1);
		Map p2=BaseUtils.map("projectId","e2Iq","branchId","H7U7","kpiIndex","5Ij3","kpiName","FRsG","maxValue","V3Sf","minValue","svyw","kpiId","J9U3","score",61,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","feWS","bizProcInstId","8fU2","kpiValue","mG1A","cdate",parse("2020-10-01 0:41:53"),"id","yUVu","remark","N0II","calcType","d530","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis2=BaseUtils.fromMap(p2,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis2);
		Map p3=BaseUtils.map("projectId","gqzt","branchId","u47T","kpiIndex","aT9Y","kpiName","FJJA","maxValue","xnI4","minValue","S3s2","kpiId","7Nbh","score",4902,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","x8iP","bizProcInstId","jNp9","kpiValue","41r3","cdate",parse("2020-10-01 0:41:53"),"id","7pNO","remark","Wwcw","calcType","kgsp","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis3=BaseUtils.fromMap(p3,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis3);
		Map p4=BaseUtils.map("projectId","wPmp","branchId","UWPW","kpiIndex","06x2","kpiName","QOtS","maxValue","V63A","minValue","7200","kpiId","IOsD","score",3845,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","8L72","bizProcInstId","4gJb","kpiValue","FxU5","cdate",parse("2020-10-01 0:41:53"),"id","WZ3x","remark","shHX","calcType","5imd","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis4=BaseUtils.fromMap(p4,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis4);
		Map p5=BaseUtils.map("projectId","x12w","branchId","E3Yf","kpiIndex","9lda","kpiName","eaox","maxValue","Jv1y","minValue","cD4r","kpiId","NwjU","score",3064,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","4jQi","bizProcInstId","nY9q","kpiValue","pqw6","cdate",parse("2020-10-01 0:41:53"),"id","XWDF","remark","m11i","calcType","rf1T","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis5=BaseUtils.fromMap(p5,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis5);
		Map p6=BaseUtils.map("projectId","Bp06","branchId","81aC","kpiIndex","7FCs","kpiName","T0uY","maxValue","l5Kw","minValue","7g5I","kpiId","9taH","score",7218,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","7tVV","bizProcInstId","TV7q","kpiValue","mTF6","cdate",parse("2020-10-01 0:41:53"),"id","e65N","remark","bvw7","calcType","Ef0i","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis6=BaseUtils.fromMap(p6,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis6);
		Map p7=BaseUtils.map("projectId","oNzN","branchId","L8mV","kpiIndex","5vMS","kpiName","fRHY","maxValue","tN0T","minValue","U8xm","kpiId","gjun","score",9767,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","6X46","bizProcInstId","0Qah","kpiValue","sgUK","cdate",parse("2020-10-01 0:41:53"),"id","g8Lr","remark","WNh3","calcType","08Zw","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis7=BaseUtils.fromMap(p7,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis7);
		baseDao.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmProjectKpiHis> batchValues=new ArrayList<XmProjectKpiHis>();
		Map p0=BaseUtils.map("projectId","ynG6","branchId","w49f","kpiIndex","Wamp","kpiName","scfM","maxValue","dhi0","minValue","ak6C","kpiId","dB26","score",4140,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","H90W","bizProcInstId","1lol","kpiValue","MkoY","cdate",parse("2020-10-01 0:41:53"),"id","I6CN","remark","LvSY","calcType","hR8y","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis0=BaseUtils.fromMap(p0,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis0);
		Map p1=BaseUtils.map("projectId","k9v8","branchId","6WCT","kpiIndex","jb9w","kpiName","0BVI","maxValue","gM03","minValue","1k09","kpiId","6kBE","score",2013,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","HmIC","bizProcInstId","i9yk","kpiValue","7Qf9","cdate",parse("2020-10-01 0:41:53"),"id","h6nC","remark","9b76","calcType","gmKa","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis1=BaseUtils.fromMap(p1,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis1);
		Map p2=BaseUtils.map("projectId","e2Iq","branchId","H7U7","kpiIndex","5Ij3","kpiName","FRsG","maxValue","V3Sf","minValue","svyw","kpiId","J9U3","score",61,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","feWS","bizProcInstId","8fU2","kpiValue","mG1A","cdate",parse("2020-10-01 0:41:53"),"id","yUVu","remark","N0II","calcType","d530","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis2=BaseUtils.fromMap(p2,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis2);
		Map p3=BaseUtils.map("projectId","gqzt","branchId","u47T","kpiIndex","aT9Y","kpiName","FJJA","maxValue","xnI4","minValue","S3s2","kpiId","7Nbh","score",4902,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","x8iP","bizProcInstId","jNp9","kpiValue","41r3","cdate",parse("2020-10-01 0:41:53"),"id","7pNO","remark","Wwcw","calcType","kgsp","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis3=BaseUtils.fromMap(p3,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis3);
		Map p4=BaseUtils.map("projectId","wPmp","branchId","UWPW","kpiIndex","06x2","kpiName","QOtS","maxValue","V63A","minValue","7200","kpiId","IOsD","score",3845,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","8L72","bizProcInstId","4gJb","kpiValue","FxU5","cdate",parse("2020-10-01 0:41:53"),"id","WZ3x","remark","shHX","calcType","5imd","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis4=BaseUtils.fromMap(p4,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis4);
		Map p5=BaseUtils.map("projectId","x12w","branchId","E3Yf","kpiIndex","9lda","kpiName","eaox","maxValue","Jv1y","minValue","cD4r","kpiId","NwjU","score",3064,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","4jQi","bizProcInstId","nY9q","kpiValue","pqw6","cdate",parse("2020-10-01 0:41:53"),"id","XWDF","remark","m11i","calcType","rf1T","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis5=BaseUtils.fromMap(p5,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis5);
		Map p6=BaseUtils.map("projectId","Bp06","branchId","81aC","kpiIndex","7FCs","kpiName","T0uY","maxValue","l5Kw","minValue","7g5I","kpiId","9taH","score",7218,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","7tVV","bizProcInstId","TV7q","kpiValue","mTF6","cdate",parse("2020-10-01 0:41:53"),"id","e65N","remark","bvw7","calcType","Ef0i","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis6=BaseUtils.fromMap(p6,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis6);
		Map p7=BaseUtils.map("projectId","oNzN","branchId","L8mV","kpiIndex","5vMS","kpiName","fRHY","maxValue","tN0T","minValue","U8xm","kpiId","gjun","score",9767,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","6X46","bizProcInstId","0Qah","kpiValue","sgUK","cdate",parse("2020-10-01 0:41:53"),"id","g8Lr","remark","WNh3","calcType","08Zw","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis7=BaseUtils.fromMap(p7,XmProjectKpiHis.class);
		batchValues.add(xmProjectKpiHis7);
		baseDao.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("kpiId","dB26");
		Map<String,Object> result=this.baseDao.selectOne(XmProjectKpiHis.class.getName()+".selectOneMap",p);
		Assert.assertEquals("dB26", result.get("kpi_id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","ynG6","branchId","w49f","kpiIndex","Wamp","kpiName","scfM","maxValue","dhi0","minValue","ak6C","score",4140,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","H90W","bizProcInstId","1lol","kpiValue","MkoY","cdate",parse("2020-10-01 0:41:53"),"id","I6CN","remark","LvSY","calcType","hR8y","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis=BaseUtils.fromMap(p,XmProjectKpiHis.class);
		long result=baseDao.countByWhere(xmProjectKpiHis);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
 		
		
		Map<String,Object> p=BaseUtils.map("projectId","ynG6","branchId","w49f","kpiIndex","Wamp","kpiName","scfM","maxValue","dhi0","minValue","ak6C","score",4140,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","H90W","bizProcInstId","1lol","kpiValue","MkoY","cdate",parse("2020-10-01 0:41:53"),"id","I6CN","remark","LvSY","calcType","hR8y","nextCalcDate",parse("2020-10-01 0:41:53"));
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmProjectKpiHis xmProjectKpiHis=BaseUtils.fromMap(p,XmProjectKpiHis.class);
		List<XmProjectKpiHis> result=baseDao.selectListByWhere(xmProjectKpiHis); 
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
	
		
		Map<String,Object> p=BaseUtils.map("projectId","ynG6","branchId","w49f","kpiIndex","Wamp","kpiName","scfM","maxValue","dhi0","minValue","ak6C","score",4140,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","H90W","bizProcInstId","1lol","kpiValue","MkoY","cdate",parse("2020-10-01 0:41:53"),"id","I6CN","remark","LvSY","calcType","hR8y","nextCalcDate",parse("2020-10-01 0:41:53"));
		XmProjectKpiHis xmProjectKpiHis=BaseUtils.fromMap(p,XmProjectKpiHis.class);
		List<XmProjectKpiHis> result=baseDao.selectListByWhere(xmProjectKpiHis);
		Assert.assertEquals(true, result.size()>=1);
	}

	
	/**
	 * 查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","ynG6","branchId","w49f","kpiIndex","Wamp","kpiName","scfM","maxValue","dhi0","minValue","ak6C","score",4140,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","H90W","bizProcInstId","1lol","kpiValue","MkoY","cdate",parse("2020-10-01 0:41:53"),"id","I6CN","remark","LvSY","calcType","hR8y","nextCalcDate",parse("2020-10-01 0:41:53"));
		List<Map<String,Object>> result=baseDao.selectList(XmProjectKpiHis.class.getName()+".selectListMapByWhere",p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("projectId","ynG6","branchId","w49f","kpiIndex","Wamp","kpiName","scfM","maxValue","dhi0","minValue","ak6C","score",4140,"scoreDate",parse("2020-10-01 0:41:53"),"bizFlowState","H90W","bizProcInstId","1lol","kpiValue","MkoY","cdate",parse("2020-10-01 0:41:53"),"id","I6CN","remark","LvSY","calcType","hR8y","nextCalcDate",parse("2020-10-01 0:41:53"));
		List<Map<String,Object>> result=baseDao.selectList(XmProjectKpiHis.class.getName()+".selectListMapByKey",p);
		Assert.assertEquals(true, result.size()>=0);
	}
 
	/**
	 * 查询一个对象 XmProjectKpiHis
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("kpiId","dB26");
		
		XmProjectKpiHis xmProjectKpiHis1=BaseUtils.fromMap(p,XmProjectKpiHis.class);
		XmProjectKpiHis xmProjectKpiHis=baseDao.selectOneObject(xmProjectKpiHis1);
		Assert.assertEquals("dB26", xmProjectKpiHis.getKpiId());
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
