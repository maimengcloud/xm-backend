package com.xm.core.service;

import java.util.*;
import java.text.SimpleDateFormat;

import com.xm.core.entity.XmFile;
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
 * XmFileService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_file xm_file<br>
 * 实体 XmFile<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,name,projectId,projectName,description,createUserid,createUsername,createTime,bizProcInstId,bizFlowState;<br>
 * 当前表的所有字段名:<br>
 *	id,name,project_id,project_name,description,create_userid,create_username,create_time,biz_proc_inst_id,biz_flow_state;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmFileService  {

	@Autowired
	XmFileService xmFileService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","aS8C","name","Ccu0","projectId","WO4P","projectName","wQp6","description","RRZN","createUserid","4vx5","createUsername","d8y2","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","718a","bizFlowState","E");
		XmFile xmFile=BaseUtils.fromMap(p,XmFile.class);
		xmFileService.insert(xmFile);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("name","Ccu0","projectId","WO4P","projectName","wQp6","description","RRZN","createUserid","4vx5","createUsername","d8y2","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","718a","bizFlowState","E");
		XmFile xmFile=BaseUtils.fromMap(p,XmFile.class);
		xmFileService.deleteByWhere(xmFile);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","aS8C");
		XmFile xmFile=BaseUtils.fromMap(p,XmFile.class);
		xmFileService.deleteByPk(xmFile);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("name","Ccu0","projectId","WO4P","projectName","wQp6","description","RRZN","createUserid","4vx5","createUsername","d8y2","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","718a","bizFlowState","E");
		XmFile xmFile=BaseUtils.fromMap(where,XmFile.class);
		xmFileService.updateSomeFieldByPk(xmFile);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","aS8C");
		XmFile xmFile=BaseUtils.fromMap(p,XmFile.class);
		xmFileService.updateByPk(xmFile);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("id","aS8C","name","Ccu0","projectId","WO4P","projectName","wQp6","description","RRZN","createUserid","4vx5","createUsername","d8y2","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","718a","bizFlowState","E");
		XmFile xmFile=BaseUtils.fromMap(p,XmFile.class);
		xmFileService.insertOrUpdate(xmFile);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmFile> batchValues=new ArrayList<XmFile>();
		Map p0=BaseUtils.map("id","aS8C","name","Ccu0","projectId","WO4P","projectName","wQp6","description","RRZN","createUserid","4vx5","createUsername","d8y2","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","718a","bizFlowState","E");
		XmFile xmFile0=BaseUtils.fromMap(p0,XmFile.class);
		batchValues.add(xmFile0);
		Map p1=BaseUtils.map("id","to4C","name","cGAV","projectId","H629","projectName","VV9l","description","hHjk","createUserid","2HPC","createUsername","MaxT","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","qbxE","bizFlowState","d");
		XmFile xmFile1=BaseUtils.fromMap(p1,XmFile.class);
		batchValues.add(xmFile1);
		Map p2=BaseUtils.map("id","9rc8","name","gq98","projectId","T47z","projectName","Ghr8","description","HE88","createUserid","8lv3","createUsername","T71L","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","OH67","bizFlowState","J");
		XmFile xmFile2=BaseUtils.fromMap(p2,XmFile.class);
		batchValues.add(xmFile2);
		Map p3=BaseUtils.map("id","N78q","name","9jTm","projectId","9WXn","projectName","1G66","description","40v8","createUserid","OP9t","createUsername","p081","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","F2AG","bizFlowState","R");
		XmFile xmFile3=BaseUtils.fromMap(p3,XmFile.class);
		batchValues.add(xmFile3);
		Map p4=BaseUtils.map("id","iKgF","name","PPVL","projectId","880R","projectName","BN7T","description","S6qo","createUserid","V5v9","createUsername","EF6F","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","1m1m","bizFlowState","4");
		XmFile xmFile4=BaseUtils.fromMap(p4,XmFile.class);
		batchValues.add(xmFile4);
		Map p5=BaseUtils.map("id","T5As","name","0e0S","projectId","vKcB","projectName","mo8L","description","8ipt","createUserid","rCwF","createUsername","yj3s","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","bHTk","bizFlowState","L");
		XmFile xmFile5=BaseUtils.fromMap(p5,XmFile.class);
		batchValues.add(xmFile5);
		Map p6=BaseUtils.map("id","nFAW","name","CK9G","projectId","FoD8","projectName","xDwa","description","14JJ","createUserid","1UGA","createUsername","9gws","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","5OG3","bizFlowState","8");
		XmFile xmFile6=BaseUtils.fromMap(p6,XmFile.class);
		batchValues.add(xmFile6);
		Map p7=BaseUtils.map("id","eaDj","name","Zbk0","projectId","Y726","projectName","y8Rp","description","95Yd","createUserid","P6ui","createUsername","CovM","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","kEb9","bizFlowState","u");
		XmFile xmFile7=BaseUtils.fromMap(p7,XmFile.class);
		batchValues.add(xmFile7);
		xmFileService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmFile> batchValues=new ArrayList<XmFile>();
		Map p0=BaseUtils.map("id","aS8C","name","Ccu0","projectId","WO4P","projectName","wQp6","description","RRZN","createUserid","4vx5","createUsername","d8y2","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","718a","bizFlowState","E");
		XmFile xmFile0=BaseUtils.fromMap(p0,XmFile.class);
		batchValues.add(xmFile0);
		Map p1=BaseUtils.map("id","to4C","name","cGAV","projectId","H629","projectName","VV9l","description","hHjk","createUserid","2HPC","createUsername","MaxT","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","qbxE","bizFlowState","d");
		XmFile xmFile1=BaseUtils.fromMap(p1,XmFile.class);
		batchValues.add(xmFile1);
		Map p2=BaseUtils.map("id","9rc8","name","gq98","projectId","T47z","projectName","Ghr8","description","HE88","createUserid","8lv3","createUsername","T71L","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","OH67","bizFlowState","J");
		XmFile xmFile2=BaseUtils.fromMap(p2,XmFile.class);
		batchValues.add(xmFile2);
		Map p3=BaseUtils.map("id","N78q","name","9jTm","projectId","9WXn","projectName","1G66","description","40v8","createUserid","OP9t","createUsername","p081","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","F2AG","bizFlowState","R");
		XmFile xmFile3=BaseUtils.fromMap(p3,XmFile.class);
		batchValues.add(xmFile3);
		Map p4=BaseUtils.map("id","iKgF","name","PPVL","projectId","880R","projectName","BN7T","description","S6qo","createUserid","V5v9","createUsername","EF6F","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","1m1m","bizFlowState","4");
		XmFile xmFile4=BaseUtils.fromMap(p4,XmFile.class);
		batchValues.add(xmFile4);
		Map p5=BaseUtils.map("id","T5As","name","0e0S","projectId","vKcB","projectName","mo8L","description","8ipt","createUserid","rCwF","createUsername","yj3s","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","bHTk","bizFlowState","L");
		XmFile xmFile5=BaseUtils.fromMap(p5,XmFile.class);
		batchValues.add(xmFile5);
		Map p6=BaseUtils.map("id","nFAW","name","CK9G","projectId","FoD8","projectName","xDwa","description","14JJ","createUserid","1UGA","createUsername","9gws","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","5OG3","bizFlowState","8");
		XmFile xmFile6=BaseUtils.fromMap(p6,XmFile.class);
		batchValues.add(xmFile6);
		Map p7=BaseUtils.map("id","eaDj","name","Zbk0","projectId","Y726","projectName","y8Rp","description","95Yd","createUserid","P6ui","createUsername","CovM","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","kEb9","bizFlowState","u");
		XmFile xmFile7=BaseUtils.fromMap(p7,XmFile.class);
		batchValues.add(xmFile7);
		xmFileService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmFile> batchValues=new ArrayList<XmFile>();
		Map p0=BaseUtils.map("id","aS8C","name","Ccu0","projectId","WO4P","projectName","wQp6","description","RRZN","createUserid","4vx5","createUsername","d8y2","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","718a","bizFlowState","E");
		XmFile xmFile0=BaseUtils.fromMap(p0,XmFile.class);
		batchValues.add(xmFile0);
		Map p1=BaseUtils.map("id","to4C","name","cGAV","projectId","H629","projectName","VV9l","description","hHjk","createUserid","2HPC","createUsername","MaxT","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","qbxE","bizFlowState","d");
		XmFile xmFile1=BaseUtils.fromMap(p1,XmFile.class);
		batchValues.add(xmFile1);
		Map p2=BaseUtils.map("id","9rc8","name","gq98","projectId","T47z","projectName","Ghr8","description","HE88","createUserid","8lv3","createUsername","T71L","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","OH67","bizFlowState","J");
		XmFile xmFile2=BaseUtils.fromMap(p2,XmFile.class);
		batchValues.add(xmFile2);
		Map p3=BaseUtils.map("id","N78q","name","9jTm","projectId","9WXn","projectName","1G66","description","40v8","createUserid","OP9t","createUsername","p081","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","F2AG","bizFlowState","R");
		XmFile xmFile3=BaseUtils.fromMap(p3,XmFile.class);
		batchValues.add(xmFile3);
		Map p4=BaseUtils.map("id","iKgF","name","PPVL","projectId","880R","projectName","BN7T","description","S6qo","createUserid","V5v9","createUsername","EF6F","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","1m1m","bizFlowState","4");
		XmFile xmFile4=BaseUtils.fromMap(p4,XmFile.class);
		batchValues.add(xmFile4);
		Map p5=BaseUtils.map("id","T5As","name","0e0S","projectId","vKcB","projectName","mo8L","description","8ipt","createUserid","rCwF","createUsername","yj3s","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","bHTk","bizFlowState","L");
		XmFile xmFile5=BaseUtils.fromMap(p5,XmFile.class);
		batchValues.add(xmFile5);
		Map p6=BaseUtils.map("id","nFAW","name","CK9G","projectId","FoD8","projectName","xDwa","description","14JJ","createUserid","1UGA","createUsername","9gws","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","5OG3","bizFlowState","8");
		XmFile xmFile6=BaseUtils.fromMap(p6,XmFile.class);
		batchValues.add(xmFile6);
		Map p7=BaseUtils.map("id","eaDj","name","Zbk0","projectId","Y726","projectName","y8Rp","description","95Yd","createUserid","P6ui","createUsername","CovM","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","kEb9","bizFlowState","u");
		XmFile xmFile7=BaseUtils.fromMap(p7,XmFile.class);
		batchValues.add(xmFile7);
		xmFileService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","aS8C");
		Map<String,Object> result=this.xmFileService.selectOne(XmFile.class.getName()+".selectOneMap",p);
		Assert.assertEquals("aS8C", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("name","Ccu0","projectId","WO4P","projectName","wQp6","description","RRZN","createUserid","4vx5","createUsername","d8y2","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","718a","bizFlowState","E");
		XmFile xmFile=BaseUtils.fromMap(p,XmFile.class);
		long result=xmFileService.countByWhere(xmFile);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("name","Ccu0","projectId","WO4P","projectName","wQp6","description","RRZN","createUserid","4vx5","createUsername","d8y2","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","718a","bizFlowState","E");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmFile xmFile=BaseUtils.fromMap(p,XmFile.class);
		List<XmFile> result=xmFileService.selectListByWhere(xmFile); 
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
	
		
		Map<String,Object> p=BaseUtils.map("name","Ccu0","projectId","WO4P","projectName","wQp6","description","RRZN","createUserid","4vx5","createUsername","d8y2","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","718a","bizFlowState","E");
		XmFile xmFile=BaseUtils.fromMap(p,XmFile.class);
		List<XmFile> result=xmFileService.selectListByWhere(xmFile);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("name","Ccu0","projectId","WO4P","projectName","wQp6","description","RRZN","createUserid","4vx5","createUsername","d8y2","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","718a","bizFlowState","E");
		List<Map<String,Object>> result=xmFileService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("name","Ccu0","projectId","WO4P","projectName","wQp6","description","RRZN","createUserid","4vx5","createUsername","d8y2","createTime",parse("2020-09-28 15:48:39"),"bizProcInstId","718a","bizFlowState","E");
		List<Map<String,Object>> result=xmFileService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmFile
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","aS8C");
		
		XmFile xmFile1=BaseUtils.fromMap(p,XmFile.class);
		XmFile xmFile=xmFileService.selectOneObject(xmFile1);
		Assert.assertEquals("aS8C", xmFile.getId());
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
