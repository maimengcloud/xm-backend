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
import com.qqkj.xm.core.entity.XmProjectGroup;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmProjectGroupDao的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_project_group xm_project_group<br>
 * 实体 XmProjectGroup<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,groupName,projectId,pgTypeId,pgTypeName;<br>
 * 当前表的所有字段名:<br>
 *	id,group_name,project_id,pg_type_id,pg_type_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/
 @RunWith(SpringJUnit4ClassRunner.class)
 @SpringBootTest
public class TestXmProjectGroupDao  {

	@Autowired
	BaseDao baseDao;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","K345","groupName","h8Ry","projectId","w7r2","pgTypeId","N6mS","pgTypeName","HOzL");
		XmProjectGroup xmProjectGroup=BaseUtils.fromMap(p,XmProjectGroup.class);
		baseDao.insert(xmProjectGroup);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("groupName","h8Ry","projectId","w7r2","pgTypeId","N6mS","pgTypeName","HOzL");
		XmProjectGroup xmProjectGroup=BaseUtils.fromMap(p,XmProjectGroup.class);
		baseDao.deleteByWhere(xmProjectGroup);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","K345");
		XmProjectGroup xmProjectGroup=BaseUtils.fromMap(p,XmProjectGroup.class);
		baseDao.deleteByPk(xmProjectGroup);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("groupName","h8Ry","projectId","w7r2","pgTypeId","N6mS","pgTypeName","HOzL");
		XmProjectGroup xmProjectGroup=BaseUtils.fromMap(where,XmProjectGroup.class);
		baseDao.updateSomeFieldByPk(xmProjectGroup);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","K345");
		XmProjectGroup xmProjectGroup=BaseUtils.fromMap(p,XmProjectGroup.class);
		baseDao.updateByPk(xmProjectGroup);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("id","K345","groupName","h8Ry","projectId","w7r2","pgTypeId","N6mS","pgTypeName","HOzL");
		XmProjectGroup xmProjectGroup=BaseUtils.fromMap(p,XmProjectGroup.class);
		baseDao.insertOrUpdate(xmProjectGroup);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmProjectGroup> batchValues=new ArrayList<XmProjectGroup>();
		Map p0=BaseUtils.map("id","K345","groupName","h8Ry","projectId","w7r2","pgTypeId","N6mS","pgTypeName","HOzL");
		XmProjectGroup xmProjectGroup0=BaseUtils.fromMap(p0,XmProjectGroup.class);
		batchValues.add(xmProjectGroup0);
		Map p1=BaseUtils.map("id","p9Xu","groupName","uZT4","projectId","3tR1","pgTypeId","3204","pgTypeName","IvN3");
		XmProjectGroup xmProjectGroup1=BaseUtils.fromMap(p1,XmProjectGroup.class);
		batchValues.add(xmProjectGroup1);
		Map p2=BaseUtils.map("id","0ror","groupName","pVX0","projectId","s66W","pgTypeId","B6MT","pgTypeName","sTjJ");
		XmProjectGroup xmProjectGroup2=BaseUtils.fromMap(p2,XmProjectGroup.class);
		batchValues.add(xmProjectGroup2);
		Map p3=BaseUtils.map("id","XEt1","groupName","KK8m","projectId","eGGJ","pgTypeId","FCVt","pgTypeName","fE7q");
		XmProjectGroup xmProjectGroup3=BaseUtils.fromMap(p3,XmProjectGroup.class);
		batchValues.add(xmProjectGroup3);
		Map p4=BaseUtils.map("id","tJau","groupName","u0fh","projectId","2d2s","pgTypeId","l1Wp","pgTypeName","9HLS");
		XmProjectGroup xmProjectGroup4=BaseUtils.fromMap(p4,XmProjectGroup.class);
		batchValues.add(xmProjectGroup4);
		Map p5=BaseUtils.map("id","X16d","groupName","kVl0","projectId","Sydq","pgTypeId","1wu7","pgTypeName","H13G");
		XmProjectGroup xmProjectGroup5=BaseUtils.fromMap(p5,XmProjectGroup.class);
		batchValues.add(xmProjectGroup5);
		Map p6=BaseUtils.map("id","L8xG","groupName","1su1","projectId","N0ed","pgTypeId","eFtw","pgTypeName","30gk");
		XmProjectGroup xmProjectGroup6=BaseUtils.fromMap(p6,XmProjectGroup.class);
		batchValues.add(xmProjectGroup6);
		Map p7=BaseUtils.map("id","HWeD","groupName","cgt2","projectId","oLDr","pgTypeId","b03Z","pgTypeName","ufdO");
		XmProjectGroup xmProjectGroup7=BaseUtils.fromMap(p7,XmProjectGroup.class);
		batchValues.add(xmProjectGroup7);
		baseDao.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmProjectGroup> batchValues=new ArrayList<XmProjectGroup>();
		Map p0=BaseUtils.map("id","K345","groupName","h8Ry","projectId","w7r2","pgTypeId","N6mS","pgTypeName","HOzL");
		XmProjectGroup xmProjectGroup0=BaseUtils.fromMap(p0,XmProjectGroup.class);
		batchValues.add(xmProjectGroup0);
		Map p1=BaseUtils.map("id","p9Xu","groupName","uZT4","projectId","3tR1","pgTypeId","3204","pgTypeName","IvN3");
		XmProjectGroup xmProjectGroup1=BaseUtils.fromMap(p1,XmProjectGroup.class);
		batchValues.add(xmProjectGroup1);
		Map p2=BaseUtils.map("id","0ror","groupName","pVX0","projectId","s66W","pgTypeId","B6MT","pgTypeName","sTjJ");
		XmProjectGroup xmProjectGroup2=BaseUtils.fromMap(p2,XmProjectGroup.class);
		batchValues.add(xmProjectGroup2);
		Map p3=BaseUtils.map("id","XEt1","groupName","KK8m","projectId","eGGJ","pgTypeId","FCVt","pgTypeName","fE7q");
		XmProjectGroup xmProjectGroup3=BaseUtils.fromMap(p3,XmProjectGroup.class);
		batchValues.add(xmProjectGroup3);
		Map p4=BaseUtils.map("id","tJau","groupName","u0fh","projectId","2d2s","pgTypeId","l1Wp","pgTypeName","9HLS");
		XmProjectGroup xmProjectGroup4=BaseUtils.fromMap(p4,XmProjectGroup.class);
		batchValues.add(xmProjectGroup4);
		Map p5=BaseUtils.map("id","X16d","groupName","kVl0","projectId","Sydq","pgTypeId","1wu7","pgTypeName","H13G");
		XmProjectGroup xmProjectGroup5=BaseUtils.fromMap(p5,XmProjectGroup.class);
		batchValues.add(xmProjectGroup5);
		Map p6=BaseUtils.map("id","L8xG","groupName","1su1","projectId","N0ed","pgTypeId","eFtw","pgTypeName","30gk");
		XmProjectGroup xmProjectGroup6=BaseUtils.fromMap(p6,XmProjectGroup.class);
		batchValues.add(xmProjectGroup6);
		Map p7=BaseUtils.map("id","HWeD","groupName","cgt2","projectId","oLDr","pgTypeId","b03Z","pgTypeName","ufdO");
		XmProjectGroup xmProjectGroup7=BaseUtils.fromMap(p7,XmProjectGroup.class);
		batchValues.add(xmProjectGroup7);
		baseDao.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmProjectGroup> batchValues=new ArrayList<XmProjectGroup>();
		Map p0=BaseUtils.map("id","K345","groupName","h8Ry","projectId","w7r2","pgTypeId","N6mS","pgTypeName","HOzL");
		XmProjectGroup xmProjectGroup0=BaseUtils.fromMap(p0,XmProjectGroup.class);
		batchValues.add(xmProjectGroup0);
		Map p1=BaseUtils.map("id","p9Xu","groupName","uZT4","projectId","3tR1","pgTypeId","3204","pgTypeName","IvN3");
		XmProjectGroup xmProjectGroup1=BaseUtils.fromMap(p1,XmProjectGroup.class);
		batchValues.add(xmProjectGroup1);
		Map p2=BaseUtils.map("id","0ror","groupName","pVX0","projectId","s66W","pgTypeId","B6MT","pgTypeName","sTjJ");
		XmProjectGroup xmProjectGroup2=BaseUtils.fromMap(p2,XmProjectGroup.class);
		batchValues.add(xmProjectGroup2);
		Map p3=BaseUtils.map("id","XEt1","groupName","KK8m","projectId","eGGJ","pgTypeId","FCVt","pgTypeName","fE7q");
		XmProjectGroup xmProjectGroup3=BaseUtils.fromMap(p3,XmProjectGroup.class);
		batchValues.add(xmProjectGroup3);
		Map p4=BaseUtils.map("id","tJau","groupName","u0fh","projectId","2d2s","pgTypeId","l1Wp","pgTypeName","9HLS");
		XmProjectGroup xmProjectGroup4=BaseUtils.fromMap(p4,XmProjectGroup.class);
		batchValues.add(xmProjectGroup4);
		Map p5=BaseUtils.map("id","X16d","groupName","kVl0","projectId","Sydq","pgTypeId","1wu7","pgTypeName","H13G");
		XmProjectGroup xmProjectGroup5=BaseUtils.fromMap(p5,XmProjectGroup.class);
		batchValues.add(xmProjectGroup5);
		Map p6=BaseUtils.map("id","L8xG","groupName","1su1","projectId","N0ed","pgTypeId","eFtw","pgTypeName","30gk");
		XmProjectGroup xmProjectGroup6=BaseUtils.fromMap(p6,XmProjectGroup.class);
		batchValues.add(xmProjectGroup6);
		Map p7=BaseUtils.map("id","HWeD","groupName","cgt2","projectId","oLDr","pgTypeId","b03Z","pgTypeName","ufdO");
		XmProjectGroup xmProjectGroup7=BaseUtils.fromMap(p7,XmProjectGroup.class);
		batchValues.add(xmProjectGroup7);
		baseDao.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","K345");
		Map<String,Object> result=this.baseDao.selectOne(XmProjectGroup.class.getName()+".selectOneMap",p);
		Assert.assertEquals("K345", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("groupName","h8Ry","projectId","w7r2","pgTypeId","N6mS","pgTypeName","HOzL");
		XmProjectGroup xmProjectGroup=BaseUtils.fromMap(p,XmProjectGroup.class);
		long result=baseDao.countByWhere(xmProjectGroup);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
 		
		
		Map<String,Object> p=BaseUtils.map("groupName","h8Ry","projectId","w7r2","pgTypeId","N6mS","pgTypeName","HOzL");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmProjectGroup xmProjectGroup=BaseUtils.fromMap(p,XmProjectGroup.class);
		List<XmProjectGroup> result=baseDao.selectListByWhere(xmProjectGroup); 
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
	
		
		Map<String,Object> p=BaseUtils.map("groupName","h8Ry","projectId","w7r2","pgTypeId","N6mS","pgTypeName","HOzL");
		XmProjectGroup xmProjectGroup=BaseUtils.fromMap(p,XmProjectGroup.class);
		List<XmProjectGroup> result=baseDao.selectListByWhere(xmProjectGroup);
		Assert.assertEquals(true, result.size()>=1);
	}

	
	/**
	 * 查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("groupName","h8Ry","projectId","w7r2","pgTypeId","N6mS","pgTypeName","HOzL");
		List<Map<String,Object>> result=baseDao.selectList(XmProjectGroup.class.getName()+".selectListMapByWhere",p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("groupName","h8Ry","projectId","w7r2","pgTypeId","N6mS","pgTypeName","HOzL");
		List<Map<String,Object>> result=baseDao.selectList(XmProjectGroup.class.getName()+".selectListMapByKey",p);
		Assert.assertEquals(true, result.size()>=0);
	}
 
	/**
	 * 查询一个对象 XmProjectGroup
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","K345");
		
		XmProjectGroup xmProjectGroup1=BaseUtils.fromMap(p,XmProjectGroup.class);
		XmProjectGroup xmProjectGroup=baseDao.selectOneObject(xmProjectGroup1);
		Assert.assertEquals("K345", xmProjectGroup.getId());
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
