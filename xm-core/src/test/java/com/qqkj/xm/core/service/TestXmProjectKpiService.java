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
import  com.qqkj.xm.core.service.XmProjectKpiService; 
import com.qqkj.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import  com.qqkj.xm.core.entity.XmProjectKpi;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmProjectKpiService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_project_kpi xm_project_kpi<br>
 * 实体 XmProjectKpi<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	projectId,branchId,kpiIndex,kpiName,maxValue,minValue,id,score,scoreDate,bizFlowState,bizProcInstId,kpiValue,remark,calcType,nextCalcDate;<br>
 * 当前表的所有字段名:<br>
 *	project_id,branch_id,kpi_index,kpi_name,max_value,min_value,id,score,score_date,biz_flow_state,biz_proc_inst_id,kpi_value,remark,calc_type,next_calc_date;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectKpiService  {

	@Autowired
	XmProjectKpiService xmProjectKpiService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("projectId","TuVY","branchId","4C86","kpiIndex","gO3m","kpiName","8NTh","maxValue","MIT8","minValue","0hiC","id","kFbZ","score",3540,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","omD2","bizProcInstId","376R","kpiValue","8qu0","remark","j1vX","calcType","BCxu","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi=BaseUtils.fromMap(p,XmProjectKpi.class);
		xmProjectKpiService.insert(xmProjectKpi);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","TuVY","branchId","4C86","kpiIndex","gO3m","kpiName","8NTh","maxValue","MIT8","minValue","0hiC","score",3540,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","omD2","bizProcInstId","376R","kpiValue","8qu0","remark","j1vX","calcType","BCxu","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi=BaseUtils.fromMap(p,XmProjectKpi.class);
		xmProjectKpiService.deleteByWhere(xmProjectKpi);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","kFbZ");
		XmProjectKpi xmProjectKpi=BaseUtils.fromMap(p,XmProjectKpi.class);
		xmProjectKpiService.deleteByPk(xmProjectKpi);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("projectId","TuVY","branchId","4C86","kpiIndex","gO3m","kpiName","8NTh","maxValue","MIT8","minValue","0hiC","score",3540,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","omD2","bizProcInstId","376R","kpiValue","8qu0","remark","j1vX","calcType","BCxu","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi=BaseUtils.fromMap(where,XmProjectKpi.class);
		xmProjectKpiService.updateSomeFieldByPk(xmProjectKpi);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","kFbZ");
		XmProjectKpi xmProjectKpi=BaseUtils.fromMap(p,XmProjectKpi.class);
		xmProjectKpiService.updateByPk(xmProjectKpi);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("projectId","TuVY","branchId","4C86","kpiIndex","gO3m","kpiName","8NTh","maxValue","MIT8","minValue","0hiC","id","kFbZ","score",3540,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","omD2","bizProcInstId","376R","kpiValue","8qu0","remark","j1vX","calcType","BCxu","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi=BaseUtils.fromMap(p,XmProjectKpi.class);
		xmProjectKpiService.insertOrUpdate(xmProjectKpi);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmProjectKpi> batchValues=new ArrayList<XmProjectKpi>();
		Map p0=BaseUtils.map("projectId","TuVY","branchId","4C86","kpiIndex","gO3m","kpiName","8NTh","maxValue","MIT8","minValue","0hiC","id","kFbZ","score",3540,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","omD2","bizProcInstId","376R","kpiValue","8qu0","remark","j1vX","calcType","BCxu","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi0=BaseUtils.fromMap(p0,XmProjectKpi.class);
		batchValues.add(xmProjectKpi0);
		Map p1=BaseUtils.map("projectId","XHpE","branchId","PlHO","kpiIndex","1qds","kpiName","Huwf","maxValue","vw8V","minValue","7Gp0","id","oV4E","score",63,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","M9Y7","bizProcInstId","iEO3","kpiValue","AK6w","remark","NJ12","calcType","NFYP","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi1=BaseUtils.fromMap(p1,XmProjectKpi.class);
		batchValues.add(xmProjectKpi1);
		Map p2=BaseUtils.map("projectId","5uWl","branchId","v93K","kpiIndex","IYcB","kpiName","H3HT","maxValue","rJCb","minValue","GgOA","id","GpH0","score",3356,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","jXLI","bizProcInstId","WV57","kpiValue","Y8Ds","remark","4eaq","calcType","9E5s","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi2=BaseUtils.fromMap(p2,XmProjectKpi.class);
		batchValues.add(xmProjectKpi2);
		Map p3=BaseUtils.map("projectId","iW02","branchId","prwV","kpiIndex","4wec","kpiName","iF7z","maxValue","5A0f","minValue","4g4b","id","nbfj","score",6795,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","p19d","bizProcInstId","RY00","kpiValue","i4U2","remark","hyu6","calcType","X9ng","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi3=BaseUtils.fromMap(p3,XmProjectKpi.class);
		batchValues.add(xmProjectKpi3);
		Map p4=BaseUtils.map("projectId","JiAq","branchId","b4CK","kpiIndex","PkiA","kpiName","JMPa","maxValue","VloF","minValue","elQN","id","75bm","score",4981,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","nloa","bizProcInstId","GGh0","kpiValue","nm57","remark","54DI","calcType","Wud7","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi4=BaseUtils.fromMap(p4,XmProjectKpi.class);
		batchValues.add(xmProjectKpi4);
		Map p5=BaseUtils.map("projectId","621K","branchId","8cXq","kpiIndex","jKnL","kpiName","Fv76","maxValue","73ML","minValue","DLc0","id","fAIZ","score",7297,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","QvJ5","bizProcInstId","8ta7","kpiValue","q85K","remark","ytS2","calcType","D8ek","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi5=BaseUtils.fromMap(p5,XmProjectKpi.class);
		batchValues.add(xmProjectKpi5);
		Map p6=BaseUtils.map("projectId","mcWs","branchId","eY3M","kpiIndex","tS6k","kpiName","ThP6","maxValue","stMe","minValue","03Zj","id","o4U0","score",3061,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","dMvt","bizProcInstId","Jg80","kpiValue","5cM4","remark","7j0w","calcType","K9Qd","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi6=BaseUtils.fromMap(p6,XmProjectKpi.class);
		batchValues.add(xmProjectKpi6);
		Map p7=BaseUtils.map("projectId","o8ef","branchId","KXL8","kpiIndex","usFB","kpiName","r5K8","maxValue","J25V","minValue","0AIr","id","uEy4","score",3644,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","EyJ2","bizProcInstId","7tSV","kpiValue","S6b2","remark","qyFj","calcType","9Xkw","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi7=BaseUtils.fromMap(p7,XmProjectKpi.class);
		batchValues.add(xmProjectKpi7);
		xmProjectKpiService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmProjectKpi> batchValues=new ArrayList<XmProjectKpi>();
		Map p0=BaseUtils.map("projectId","TuVY","branchId","4C86","kpiIndex","gO3m","kpiName","8NTh","maxValue","MIT8","minValue","0hiC","id","kFbZ","score",3540,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","omD2","bizProcInstId","376R","kpiValue","8qu0","remark","j1vX","calcType","BCxu","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi0=BaseUtils.fromMap(p0,XmProjectKpi.class);
		batchValues.add(xmProjectKpi0);
		Map p1=BaseUtils.map("projectId","XHpE","branchId","PlHO","kpiIndex","1qds","kpiName","Huwf","maxValue","vw8V","minValue","7Gp0","id","oV4E","score",63,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","M9Y7","bizProcInstId","iEO3","kpiValue","AK6w","remark","NJ12","calcType","NFYP","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi1=BaseUtils.fromMap(p1,XmProjectKpi.class);
		batchValues.add(xmProjectKpi1);
		Map p2=BaseUtils.map("projectId","5uWl","branchId","v93K","kpiIndex","IYcB","kpiName","H3HT","maxValue","rJCb","minValue","GgOA","id","GpH0","score",3356,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","jXLI","bizProcInstId","WV57","kpiValue","Y8Ds","remark","4eaq","calcType","9E5s","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi2=BaseUtils.fromMap(p2,XmProjectKpi.class);
		batchValues.add(xmProjectKpi2);
		Map p3=BaseUtils.map("projectId","iW02","branchId","prwV","kpiIndex","4wec","kpiName","iF7z","maxValue","5A0f","minValue","4g4b","id","nbfj","score",6795,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","p19d","bizProcInstId","RY00","kpiValue","i4U2","remark","hyu6","calcType","X9ng","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi3=BaseUtils.fromMap(p3,XmProjectKpi.class);
		batchValues.add(xmProjectKpi3);
		Map p4=BaseUtils.map("projectId","JiAq","branchId","b4CK","kpiIndex","PkiA","kpiName","JMPa","maxValue","VloF","minValue","elQN","id","75bm","score",4981,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","nloa","bizProcInstId","GGh0","kpiValue","nm57","remark","54DI","calcType","Wud7","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi4=BaseUtils.fromMap(p4,XmProjectKpi.class);
		batchValues.add(xmProjectKpi4);
		Map p5=BaseUtils.map("projectId","621K","branchId","8cXq","kpiIndex","jKnL","kpiName","Fv76","maxValue","73ML","minValue","DLc0","id","fAIZ","score",7297,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","QvJ5","bizProcInstId","8ta7","kpiValue","q85K","remark","ytS2","calcType","D8ek","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi5=BaseUtils.fromMap(p5,XmProjectKpi.class);
		batchValues.add(xmProjectKpi5);
		Map p6=BaseUtils.map("projectId","mcWs","branchId","eY3M","kpiIndex","tS6k","kpiName","ThP6","maxValue","stMe","minValue","03Zj","id","o4U0","score",3061,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","dMvt","bizProcInstId","Jg80","kpiValue","5cM4","remark","7j0w","calcType","K9Qd","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi6=BaseUtils.fromMap(p6,XmProjectKpi.class);
		batchValues.add(xmProjectKpi6);
		Map p7=BaseUtils.map("projectId","o8ef","branchId","KXL8","kpiIndex","usFB","kpiName","r5K8","maxValue","J25V","minValue","0AIr","id","uEy4","score",3644,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","EyJ2","bizProcInstId","7tSV","kpiValue","S6b2","remark","qyFj","calcType","9Xkw","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi7=BaseUtils.fromMap(p7,XmProjectKpi.class);
		batchValues.add(xmProjectKpi7);
		xmProjectKpiService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmProjectKpi> batchValues=new ArrayList<XmProjectKpi>();
		Map p0=BaseUtils.map("projectId","TuVY","branchId","4C86","kpiIndex","gO3m","kpiName","8NTh","maxValue","MIT8","minValue","0hiC","id","kFbZ","score",3540,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","omD2","bizProcInstId","376R","kpiValue","8qu0","remark","j1vX","calcType","BCxu","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi0=BaseUtils.fromMap(p0,XmProjectKpi.class);
		batchValues.add(xmProjectKpi0);
		Map p1=BaseUtils.map("projectId","XHpE","branchId","PlHO","kpiIndex","1qds","kpiName","Huwf","maxValue","vw8V","minValue","7Gp0","id","oV4E","score",63,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","M9Y7","bizProcInstId","iEO3","kpiValue","AK6w","remark","NJ12","calcType","NFYP","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi1=BaseUtils.fromMap(p1,XmProjectKpi.class);
		batchValues.add(xmProjectKpi1);
		Map p2=BaseUtils.map("projectId","5uWl","branchId","v93K","kpiIndex","IYcB","kpiName","H3HT","maxValue","rJCb","minValue","GgOA","id","GpH0","score",3356,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","jXLI","bizProcInstId","WV57","kpiValue","Y8Ds","remark","4eaq","calcType","9E5s","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi2=BaseUtils.fromMap(p2,XmProjectKpi.class);
		batchValues.add(xmProjectKpi2);
		Map p3=BaseUtils.map("projectId","iW02","branchId","prwV","kpiIndex","4wec","kpiName","iF7z","maxValue","5A0f","minValue","4g4b","id","nbfj","score",6795,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","p19d","bizProcInstId","RY00","kpiValue","i4U2","remark","hyu6","calcType","X9ng","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi3=BaseUtils.fromMap(p3,XmProjectKpi.class);
		batchValues.add(xmProjectKpi3);
		Map p4=BaseUtils.map("projectId","JiAq","branchId","b4CK","kpiIndex","PkiA","kpiName","JMPa","maxValue","VloF","minValue","elQN","id","75bm","score",4981,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","nloa","bizProcInstId","GGh0","kpiValue","nm57","remark","54DI","calcType","Wud7","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi4=BaseUtils.fromMap(p4,XmProjectKpi.class);
		batchValues.add(xmProjectKpi4);
		Map p5=BaseUtils.map("projectId","621K","branchId","8cXq","kpiIndex","jKnL","kpiName","Fv76","maxValue","73ML","minValue","DLc0","id","fAIZ","score",7297,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","QvJ5","bizProcInstId","8ta7","kpiValue","q85K","remark","ytS2","calcType","D8ek","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi5=BaseUtils.fromMap(p5,XmProjectKpi.class);
		batchValues.add(xmProjectKpi5);
		Map p6=BaseUtils.map("projectId","mcWs","branchId","eY3M","kpiIndex","tS6k","kpiName","ThP6","maxValue","stMe","minValue","03Zj","id","o4U0","score",3061,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","dMvt","bizProcInstId","Jg80","kpiValue","5cM4","remark","7j0w","calcType","K9Qd","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi6=BaseUtils.fromMap(p6,XmProjectKpi.class);
		batchValues.add(xmProjectKpi6);
		Map p7=BaseUtils.map("projectId","o8ef","branchId","KXL8","kpiIndex","usFB","kpiName","r5K8","maxValue","J25V","minValue","0AIr","id","uEy4","score",3644,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","EyJ2","bizProcInstId","7tSV","kpiValue","S6b2","remark","qyFj","calcType","9Xkw","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi7=BaseUtils.fromMap(p7,XmProjectKpi.class);
		batchValues.add(xmProjectKpi7);
		xmProjectKpiService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","kFbZ");
		Map<String,Object> result=this.xmProjectKpiService.selectOne(XmProjectKpi.class.getName()+".selectOneMap",p);
		Assert.assertEquals("kFbZ", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","TuVY","branchId","4C86","kpiIndex","gO3m","kpiName","8NTh","maxValue","MIT8","minValue","0hiC","score",3540,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","omD2","bizProcInstId","376R","kpiValue","8qu0","remark","j1vX","calcType","BCxu","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi=BaseUtils.fromMap(p,XmProjectKpi.class);
		long result=xmProjectKpiService.countByWhere(xmProjectKpi);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("projectId","TuVY","branchId","4C86","kpiIndex","gO3m","kpiName","8NTh","maxValue","MIT8","minValue","0hiC","score",3540,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","omD2","bizProcInstId","376R","kpiValue","8qu0","remark","j1vX","calcType","BCxu","nextCalcDate",parse("2020-10-01 0:41:52"));
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmProjectKpi xmProjectKpi=BaseUtils.fromMap(p,XmProjectKpi.class);
		List<XmProjectKpi> result=xmProjectKpiService.selectListByWhere(xmProjectKpi); 
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
	
		
		Map<String,Object> p=BaseUtils.map("projectId","TuVY","branchId","4C86","kpiIndex","gO3m","kpiName","8NTh","maxValue","MIT8","minValue","0hiC","score",3540,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","omD2","bizProcInstId","376R","kpiValue","8qu0","remark","j1vX","calcType","BCxu","nextCalcDate",parse("2020-10-01 0:41:52"));
		XmProjectKpi xmProjectKpi=BaseUtils.fromMap(p,XmProjectKpi.class);
		List<XmProjectKpi> result=xmProjectKpiService.selectListByWhere(xmProjectKpi);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("projectId","TuVY","branchId","4C86","kpiIndex","gO3m","kpiName","8NTh","maxValue","MIT8","minValue","0hiC","score",3540,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","omD2","bizProcInstId","376R","kpiValue","8qu0","remark","j1vX","calcType","BCxu","nextCalcDate",parse("2020-10-01 0:41:52"));
		List<Map<String,Object>> result=xmProjectKpiService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("projectId","TuVY","branchId","4C86","kpiIndex","gO3m","kpiName","8NTh","maxValue","MIT8","minValue","0hiC","score",3540,"scoreDate",parse("2020-10-01 0:41:52"),"bizFlowState","omD2","bizProcInstId","376R","kpiValue","8qu0","remark","j1vX","calcType","BCxu","nextCalcDate",parse("2020-10-01 0:41:52"));
		List<Map<String,Object>> result=xmProjectKpiService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmProjectKpi
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","kFbZ");
		
		XmProjectKpi xmProjectKpi1=BaseUtils.fromMap(p,XmProjectKpi.class);
		XmProjectKpi xmProjectKpi=xmProjectKpiService.selectOneObject(xmProjectKpi1);
		Assert.assertEquals("kFbZ", xmProjectKpi.getId());
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
