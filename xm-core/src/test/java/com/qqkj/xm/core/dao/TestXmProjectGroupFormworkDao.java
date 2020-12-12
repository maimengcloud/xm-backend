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
import com.qqkj.xm.core.entity.XmProjectGroupFormwork;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmProjectGroupFormworkDao的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_project_group_formwork xm_project_group_formwork<br>
 * 实体 XmProjectGroupFormwork<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,branchId,groupName,isPub,pgTypeId,pgTypeName;<br>
 * 当前表的所有字段名:<br>
 *	id,branch_id,group_name,is_pub,pg_type_id,pg_type_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/
 @RunWith(SpringJUnit4ClassRunner.class)
 @SpringBootTest
public class TestXmProjectGroupFormworkDao  {

	@Autowired
	BaseDao baseDao;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","vnXu","branchId","5HBp","groupName","yefQ","isPub","4","pgTypeId","Q6tZ","pgTypeName","HHT0");
		XmProjectGroupFormwork xmProjectGroupFormwork=BaseUtils.fromMap(p,XmProjectGroupFormwork.class);
		baseDao.insert(xmProjectGroupFormwork);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("branchId","5HBp","groupName","yefQ","isPub","4","pgTypeId","Q6tZ","pgTypeName","HHT0");
		XmProjectGroupFormwork xmProjectGroupFormwork=BaseUtils.fromMap(p,XmProjectGroupFormwork.class);
		baseDao.deleteByWhere(xmProjectGroupFormwork);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","vnXu");
		XmProjectGroupFormwork xmProjectGroupFormwork=BaseUtils.fromMap(p,XmProjectGroupFormwork.class);
		baseDao.deleteByPk(xmProjectGroupFormwork);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("branchId","5HBp","groupName","yefQ","isPub","4","pgTypeId","Q6tZ","pgTypeName","HHT0");
		XmProjectGroupFormwork xmProjectGroupFormwork=BaseUtils.fromMap(where,XmProjectGroupFormwork.class);
		baseDao.updateSomeFieldByPk(xmProjectGroupFormwork);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","vnXu");
		XmProjectGroupFormwork xmProjectGroupFormwork=BaseUtils.fromMap(p,XmProjectGroupFormwork.class);
		baseDao.updateByPk(xmProjectGroupFormwork);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("id","vnXu","branchId","5HBp","groupName","yefQ","isPub","4","pgTypeId","Q6tZ","pgTypeName","HHT0");
		XmProjectGroupFormwork xmProjectGroupFormwork=BaseUtils.fromMap(p,XmProjectGroupFormwork.class);
		baseDao.insertOrUpdate(xmProjectGroupFormwork);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmProjectGroupFormwork> batchValues=new ArrayList<XmProjectGroupFormwork>();
		Map p0=BaseUtils.map("id","vnXu","branchId","5HBp","groupName","yefQ","isPub","4","pgTypeId","Q6tZ","pgTypeName","HHT0");
		XmProjectGroupFormwork xmProjectGroupFormwork0=BaseUtils.fromMap(p0,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork0);
		Map p1=BaseUtils.map("id","BhNO","branchId","0is4","groupName","f4Qr","isPub","8","pgTypeId","ArBg","pgTypeName","OFu0");
		XmProjectGroupFormwork xmProjectGroupFormwork1=BaseUtils.fromMap(p1,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork1);
		Map p2=BaseUtils.map("id","Uuzk","branchId","KJ9l","groupName","KOi3","isPub","8","pgTypeId","79VZ","pgTypeName","qIHf");
		XmProjectGroupFormwork xmProjectGroupFormwork2=BaseUtils.fromMap(p2,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork2);
		Map p3=BaseUtils.map("id","U1v9","branchId","asZn","groupName","eMLC","isPub","Z","pgTypeId","47x6","pgTypeName","N097");
		XmProjectGroupFormwork xmProjectGroupFormwork3=BaseUtils.fromMap(p3,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork3);
		Map p4=BaseUtils.map("id","h75E","branchId","UZs2","groupName","inFj","isPub","b","pgTypeId","9iQH","pgTypeName","pUBJ");
		XmProjectGroupFormwork xmProjectGroupFormwork4=BaseUtils.fromMap(p4,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork4);
		Map p5=BaseUtils.map("id","p9JR","branchId","6YB3","groupName","Ju47","isPub","0","pgTypeId","4Hdf","pgTypeName","7gG7");
		XmProjectGroupFormwork xmProjectGroupFormwork5=BaseUtils.fromMap(p5,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork5);
		Map p6=BaseUtils.map("id","E9os","branchId","nWKt","groupName","mldG","isPub","3","pgTypeId","hdJP","pgTypeName","CqxZ");
		XmProjectGroupFormwork xmProjectGroupFormwork6=BaseUtils.fromMap(p6,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork6);
		Map p7=BaseUtils.map("id","Q24e","branchId","5YXV","groupName","y0B9","isPub","M","pgTypeId","O2it","pgTypeName","j3VV");
		XmProjectGroupFormwork xmProjectGroupFormwork7=BaseUtils.fromMap(p7,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork7);
		baseDao.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmProjectGroupFormwork> batchValues=new ArrayList<XmProjectGroupFormwork>();
		Map p0=BaseUtils.map("id","vnXu","branchId","5HBp","groupName","yefQ","isPub","4","pgTypeId","Q6tZ","pgTypeName","HHT0");
		XmProjectGroupFormwork xmProjectGroupFormwork0=BaseUtils.fromMap(p0,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork0);
		Map p1=BaseUtils.map("id","BhNO","branchId","0is4","groupName","f4Qr","isPub","8","pgTypeId","ArBg","pgTypeName","OFu0");
		XmProjectGroupFormwork xmProjectGroupFormwork1=BaseUtils.fromMap(p1,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork1);
		Map p2=BaseUtils.map("id","Uuzk","branchId","KJ9l","groupName","KOi3","isPub","8","pgTypeId","79VZ","pgTypeName","qIHf");
		XmProjectGroupFormwork xmProjectGroupFormwork2=BaseUtils.fromMap(p2,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork2);
		Map p3=BaseUtils.map("id","U1v9","branchId","asZn","groupName","eMLC","isPub","Z","pgTypeId","47x6","pgTypeName","N097");
		XmProjectGroupFormwork xmProjectGroupFormwork3=BaseUtils.fromMap(p3,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork3);
		Map p4=BaseUtils.map("id","h75E","branchId","UZs2","groupName","inFj","isPub","b","pgTypeId","9iQH","pgTypeName","pUBJ");
		XmProjectGroupFormwork xmProjectGroupFormwork4=BaseUtils.fromMap(p4,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork4);
		Map p5=BaseUtils.map("id","p9JR","branchId","6YB3","groupName","Ju47","isPub","0","pgTypeId","4Hdf","pgTypeName","7gG7");
		XmProjectGroupFormwork xmProjectGroupFormwork5=BaseUtils.fromMap(p5,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork5);
		Map p6=BaseUtils.map("id","E9os","branchId","nWKt","groupName","mldG","isPub","3","pgTypeId","hdJP","pgTypeName","CqxZ");
		XmProjectGroupFormwork xmProjectGroupFormwork6=BaseUtils.fromMap(p6,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork6);
		Map p7=BaseUtils.map("id","Q24e","branchId","5YXV","groupName","y0B9","isPub","M","pgTypeId","O2it","pgTypeName","j3VV");
		XmProjectGroupFormwork xmProjectGroupFormwork7=BaseUtils.fromMap(p7,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork7);
		baseDao.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmProjectGroupFormwork> batchValues=new ArrayList<XmProjectGroupFormwork>();
		Map p0=BaseUtils.map("id","vnXu","branchId","5HBp","groupName","yefQ","isPub","4","pgTypeId","Q6tZ","pgTypeName","HHT0");
		XmProjectGroupFormwork xmProjectGroupFormwork0=BaseUtils.fromMap(p0,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork0);
		Map p1=BaseUtils.map("id","BhNO","branchId","0is4","groupName","f4Qr","isPub","8","pgTypeId","ArBg","pgTypeName","OFu0");
		XmProjectGroupFormwork xmProjectGroupFormwork1=BaseUtils.fromMap(p1,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork1);
		Map p2=BaseUtils.map("id","Uuzk","branchId","KJ9l","groupName","KOi3","isPub","8","pgTypeId","79VZ","pgTypeName","qIHf");
		XmProjectGroupFormwork xmProjectGroupFormwork2=BaseUtils.fromMap(p2,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork2);
		Map p3=BaseUtils.map("id","U1v9","branchId","asZn","groupName","eMLC","isPub","Z","pgTypeId","47x6","pgTypeName","N097");
		XmProjectGroupFormwork xmProjectGroupFormwork3=BaseUtils.fromMap(p3,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork3);
		Map p4=BaseUtils.map("id","h75E","branchId","UZs2","groupName","inFj","isPub","b","pgTypeId","9iQH","pgTypeName","pUBJ");
		XmProjectGroupFormwork xmProjectGroupFormwork4=BaseUtils.fromMap(p4,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork4);
		Map p5=BaseUtils.map("id","p9JR","branchId","6YB3","groupName","Ju47","isPub","0","pgTypeId","4Hdf","pgTypeName","7gG7");
		XmProjectGroupFormwork xmProjectGroupFormwork5=BaseUtils.fromMap(p5,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork5);
		Map p6=BaseUtils.map("id","E9os","branchId","nWKt","groupName","mldG","isPub","3","pgTypeId","hdJP","pgTypeName","CqxZ");
		XmProjectGroupFormwork xmProjectGroupFormwork6=BaseUtils.fromMap(p6,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork6);
		Map p7=BaseUtils.map("id","Q24e","branchId","5YXV","groupName","y0B9","isPub","M","pgTypeId","O2it","pgTypeName","j3VV");
		XmProjectGroupFormwork xmProjectGroupFormwork7=BaseUtils.fromMap(p7,XmProjectGroupFormwork.class);
		batchValues.add(xmProjectGroupFormwork7);
		baseDao.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","vnXu");
		Map<String,Object> result=this.baseDao.selectOne(XmProjectGroupFormwork.class.getName()+".selectOneMap",p);
		Assert.assertEquals("vnXu", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("branchId","5HBp","groupName","yefQ","isPub","4","pgTypeId","Q6tZ","pgTypeName","HHT0");
		XmProjectGroupFormwork xmProjectGroupFormwork=BaseUtils.fromMap(p,XmProjectGroupFormwork.class);
		long result=baseDao.countByWhere(xmProjectGroupFormwork);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
 		
		
		Map<String,Object> p=BaseUtils.map("branchId","5HBp","groupName","yefQ","isPub","4","pgTypeId","Q6tZ","pgTypeName","HHT0");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmProjectGroupFormwork xmProjectGroupFormwork=BaseUtils.fromMap(p,XmProjectGroupFormwork.class);
		List<XmProjectGroupFormwork> result=baseDao.selectListByWhere(xmProjectGroupFormwork); 
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
	
		
		Map<String,Object> p=BaseUtils.map("branchId","5HBp","groupName","yefQ","isPub","4","pgTypeId","Q6tZ","pgTypeName","HHT0");
		XmProjectGroupFormwork xmProjectGroupFormwork=BaseUtils.fromMap(p,XmProjectGroupFormwork.class);
		List<XmProjectGroupFormwork> result=baseDao.selectListByWhere(xmProjectGroupFormwork);
		Assert.assertEquals(true, result.size()>=1);
	}

	
	/**
	 * 查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("branchId","5HBp","groupName","yefQ","isPub","4","pgTypeId","Q6tZ","pgTypeName","HHT0");
		List<Map<String,Object>> result=baseDao.selectList(XmProjectGroupFormwork.class.getName()+".selectListMapByWhere",p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("branchId","5HBp","groupName","yefQ","isPub","4","pgTypeId","Q6tZ","pgTypeName","HHT0");
		List<Map<String,Object>> result=baseDao.selectList(XmProjectGroupFormwork.class.getName()+".selectListMapByKey",p);
		Assert.assertEquals(true, result.size()>=0);
	}
 
	/**
	 * 查询一个对象 XmProjectGroupFormwork
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","vnXu");
		
		XmProjectGroupFormwork xmProjectGroupFormwork1=BaseUtils.fromMap(p,XmProjectGroupFormwork.class);
		XmProjectGroupFormwork xmProjectGroupFormwork=baseDao.selectOneObject(xmProjectGroupFormwork1);
		Assert.assertEquals("vnXu", xmProjectGroupFormwork.getId());
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
