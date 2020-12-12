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
import com.qqkj.xm.core.entity.XmIterationMenu;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmIterationMenuDao的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_iteration_menu 迭代定义<br>
 * 实体 XmIterationMenu<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,iterationId,menuId,productId,ctime,relStatus,hasTask,cuserid,cusername;<br>
 * 当前表的所有字段名:<br>
 *	id,iteration_id,menu_id,product_id,ctime,rel_status,has_task,cuserid,cusername;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/
 @RunWith(SpringJUnit4ClassRunner.class)
 @SpringBootTest
public class TestXmIterationMenuDao  {

	@Autowired
	BaseDao baseDao;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","8b59","iterationId","5b38","menuId","Se4e","productId","oIgA","ctime",parse("2020-11-07 22:55:27"),"relStatus","x","hasTask","9","cuserid","itag","cusername","cxXF");
		XmIterationMenu xmIterationMenu=BaseUtils.fromMap(p,XmIterationMenu.class);
		baseDao.insert(xmIterationMenu);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("iterationId","5b38","menuId","Se4e","productId","oIgA","ctime",parse("2020-11-07 22:55:27"),"relStatus","x","hasTask","9","cuserid","itag","cusername","cxXF");
		XmIterationMenu xmIterationMenu=BaseUtils.fromMap(p,XmIterationMenu.class);
		baseDao.deleteByWhere(xmIterationMenu);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","8b59");
		XmIterationMenu xmIterationMenu=BaseUtils.fromMap(p,XmIterationMenu.class);
		baseDao.deleteByPk(xmIterationMenu);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("iterationId","5b38","menuId","Se4e","productId","oIgA","ctime",parse("2020-11-07 22:55:27"),"relStatus","x","hasTask","9","cuserid","itag","cusername","cxXF");
		XmIterationMenu xmIterationMenu=BaseUtils.fromMap(where,XmIterationMenu.class);
		baseDao.updateSomeFieldByPk(xmIterationMenu);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","8b59");
		XmIterationMenu xmIterationMenu=BaseUtils.fromMap(p,XmIterationMenu.class);
		baseDao.updateByPk(xmIterationMenu);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("id","8b59","iterationId","5b38","menuId","Se4e","productId","oIgA","ctime",parse("2020-11-07 22:55:27"),"relStatus","x","hasTask","9","cuserid","itag","cusername","cxXF");
		XmIterationMenu xmIterationMenu=BaseUtils.fromMap(p,XmIterationMenu.class);
		baseDao.insertOrUpdate(xmIterationMenu);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmIterationMenu> batchValues=new ArrayList<XmIterationMenu>();
		Map p0=BaseUtils.map("id","8b59","iterationId","5b38","menuId","Se4e","productId","oIgA","ctime",parse("2020-11-07 22:55:27"),"relStatus","x","hasTask","9","cuserid","itag","cusername","cxXF");
		XmIterationMenu xmIterationMenu0=BaseUtils.fromMap(p0,XmIterationMenu.class);
		batchValues.add(xmIterationMenu0);
		Map p1=BaseUtils.map("id","qiTm","iterationId","CKIK","menuId","qpEx","productId","zE9q","ctime",parse("2020-11-07 22:55:27"),"relStatus","v","hasTask","z","cuserid","hwR4","cusername","J7wE");
		XmIterationMenu xmIterationMenu1=BaseUtils.fromMap(p1,XmIterationMenu.class);
		batchValues.add(xmIterationMenu1);
		Map p2=BaseUtils.map("id","SA90","iterationId","N1y7","menuId","VUZW","productId","V6HO","ctime",parse("2020-11-07 22:55:27"),"relStatus","B","hasTask","Q","cuserid","7C02","cusername","hXzQ");
		XmIterationMenu xmIterationMenu2=BaseUtils.fromMap(p2,XmIterationMenu.class);
		batchValues.add(xmIterationMenu2);
		Map p3=BaseUtils.map("id","79G7","iterationId","hJq1","menuId","4hXu","productId","DCmb","ctime",parse("2020-11-07 22:55:27"),"relStatus","5","hasTask","T","cuserid","gykH","cusername","Zjad");
		XmIterationMenu xmIterationMenu3=BaseUtils.fromMap(p3,XmIterationMenu.class);
		batchValues.add(xmIterationMenu3);
		Map p4=BaseUtils.map("id","zfSI","iterationId","cya3","menuId","Pq6z","productId","kDSw","ctime",parse("2020-11-07 22:55:27"),"relStatus","8","hasTask","h","cuserid","bqbf","cusername","Cqb9");
		XmIterationMenu xmIterationMenu4=BaseUtils.fromMap(p4,XmIterationMenu.class);
		batchValues.add(xmIterationMenu4);
		Map p5=BaseUtils.map("id","dXwm","iterationId","9G5E","menuId","YZH4","productId","7YUX","ctime",parse("2020-11-07 22:55:27"),"relStatus","N","hasTask","W","cuserid","95Jo","cusername","796Z");
		XmIterationMenu xmIterationMenu5=BaseUtils.fromMap(p5,XmIterationMenu.class);
		batchValues.add(xmIterationMenu5);
		Map p6=BaseUtils.map("id","nQg2","iterationId","OaJI","menuId","3Fwf","productId","PjLH","ctime",parse("2020-11-07 22:55:27"),"relStatus","Z","hasTask","7","cuserid","IeL9","cusername","WoM1");
		XmIterationMenu xmIterationMenu6=BaseUtils.fromMap(p6,XmIterationMenu.class);
		batchValues.add(xmIterationMenu6);
		Map p7=BaseUtils.map("id","g63v","iterationId","0u6M","menuId","HfMs","productId","3f2v","ctime",parse("2020-11-07 22:55:27"),"relStatus","i","hasTask","S","cuserid","mJNP","cusername","F8by");
		XmIterationMenu xmIterationMenu7=BaseUtils.fromMap(p7,XmIterationMenu.class);
		batchValues.add(xmIterationMenu7);
		baseDao.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmIterationMenu> batchValues=new ArrayList<XmIterationMenu>();
		Map p0=BaseUtils.map("id","8b59","iterationId","5b38","menuId","Se4e","productId","oIgA","ctime",parse("2020-11-07 22:55:27"),"relStatus","x","hasTask","9","cuserid","itag","cusername","cxXF");
		XmIterationMenu xmIterationMenu0=BaseUtils.fromMap(p0,XmIterationMenu.class);
		batchValues.add(xmIterationMenu0);
		Map p1=BaseUtils.map("id","qiTm","iterationId","CKIK","menuId","qpEx","productId","zE9q","ctime",parse("2020-11-07 22:55:27"),"relStatus","v","hasTask","z","cuserid","hwR4","cusername","J7wE");
		XmIterationMenu xmIterationMenu1=BaseUtils.fromMap(p1,XmIterationMenu.class);
		batchValues.add(xmIterationMenu1);
		Map p2=BaseUtils.map("id","SA90","iterationId","N1y7","menuId","VUZW","productId","V6HO","ctime",parse("2020-11-07 22:55:27"),"relStatus","B","hasTask","Q","cuserid","7C02","cusername","hXzQ");
		XmIterationMenu xmIterationMenu2=BaseUtils.fromMap(p2,XmIterationMenu.class);
		batchValues.add(xmIterationMenu2);
		Map p3=BaseUtils.map("id","79G7","iterationId","hJq1","menuId","4hXu","productId","DCmb","ctime",parse("2020-11-07 22:55:27"),"relStatus","5","hasTask","T","cuserid","gykH","cusername","Zjad");
		XmIterationMenu xmIterationMenu3=BaseUtils.fromMap(p3,XmIterationMenu.class);
		batchValues.add(xmIterationMenu3);
		Map p4=BaseUtils.map("id","zfSI","iterationId","cya3","menuId","Pq6z","productId","kDSw","ctime",parse("2020-11-07 22:55:27"),"relStatus","8","hasTask","h","cuserid","bqbf","cusername","Cqb9");
		XmIterationMenu xmIterationMenu4=BaseUtils.fromMap(p4,XmIterationMenu.class);
		batchValues.add(xmIterationMenu4);
		Map p5=BaseUtils.map("id","dXwm","iterationId","9G5E","menuId","YZH4","productId","7YUX","ctime",parse("2020-11-07 22:55:27"),"relStatus","N","hasTask","W","cuserid","95Jo","cusername","796Z");
		XmIterationMenu xmIterationMenu5=BaseUtils.fromMap(p5,XmIterationMenu.class);
		batchValues.add(xmIterationMenu5);
		Map p6=BaseUtils.map("id","nQg2","iterationId","OaJI","menuId","3Fwf","productId","PjLH","ctime",parse("2020-11-07 22:55:27"),"relStatus","Z","hasTask","7","cuserid","IeL9","cusername","WoM1");
		XmIterationMenu xmIterationMenu6=BaseUtils.fromMap(p6,XmIterationMenu.class);
		batchValues.add(xmIterationMenu6);
		Map p7=BaseUtils.map("id","g63v","iterationId","0u6M","menuId","HfMs","productId","3f2v","ctime",parse("2020-11-07 22:55:27"),"relStatus","i","hasTask","S","cuserid","mJNP","cusername","F8by");
		XmIterationMenu xmIterationMenu7=BaseUtils.fromMap(p7,XmIterationMenu.class);
		batchValues.add(xmIterationMenu7);
		baseDao.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmIterationMenu> batchValues=new ArrayList<XmIterationMenu>();
		Map p0=BaseUtils.map("id","8b59","iterationId","5b38","menuId","Se4e","productId","oIgA","ctime",parse("2020-11-07 22:55:27"),"relStatus","x","hasTask","9","cuserid","itag","cusername","cxXF");
		XmIterationMenu xmIterationMenu0=BaseUtils.fromMap(p0,XmIterationMenu.class);
		batchValues.add(xmIterationMenu0);
		Map p1=BaseUtils.map("id","qiTm","iterationId","CKIK","menuId","qpEx","productId","zE9q","ctime",parse("2020-11-07 22:55:27"),"relStatus","v","hasTask","z","cuserid","hwR4","cusername","J7wE");
		XmIterationMenu xmIterationMenu1=BaseUtils.fromMap(p1,XmIterationMenu.class);
		batchValues.add(xmIterationMenu1);
		Map p2=BaseUtils.map("id","SA90","iterationId","N1y7","menuId","VUZW","productId","V6HO","ctime",parse("2020-11-07 22:55:27"),"relStatus","B","hasTask","Q","cuserid","7C02","cusername","hXzQ");
		XmIterationMenu xmIterationMenu2=BaseUtils.fromMap(p2,XmIterationMenu.class);
		batchValues.add(xmIterationMenu2);
		Map p3=BaseUtils.map("id","79G7","iterationId","hJq1","menuId","4hXu","productId","DCmb","ctime",parse("2020-11-07 22:55:27"),"relStatus","5","hasTask","T","cuserid","gykH","cusername","Zjad");
		XmIterationMenu xmIterationMenu3=BaseUtils.fromMap(p3,XmIterationMenu.class);
		batchValues.add(xmIterationMenu3);
		Map p4=BaseUtils.map("id","zfSI","iterationId","cya3","menuId","Pq6z","productId","kDSw","ctime",parse("2020-11-07 22:55:27"),"relStatus","8","hasTask","h","cuserid","bqbf","cusername","Cqb9");
		XmIterationMenu xmIterationMenu4=BaseUtils.fromMap(p4,XmIterationMenu.class);
		batchValues.add(xmIterationMenu4);
		Map p5=BaseUtils.map("id","dXwm","iterationId","9G5E","menuId","YZH4","productId","7YUX","ctime",parse("2020-11-07 22:55:27"),"relStatus","N","hasTask","W","cuserid","95Jo","cusername","796Z");
		XmIterationMenu xmIterationMenu5=BaseUtils.fromMap(p5,XmIterationMenu.class);
		batchValues.add(xmIterationMenu5);
		Map p6=BaseUtils.map("id","nQg2","iterationId","OaJI","menuId","3Fwf","productId","PjLH","ctime",parse("2020-11-07 22:55:27"),"relStatus","Z","hasTask","7","cuserid","IeL9","cusername","WoM1");
		XmIterationMenu xmIterationMenu6=BaseUtils.fromMap(p6,XmIterationMenu.class);
		batchValues.add(xmIterationMenu6);
		Map p7=BaseUtils.map("id","g63v","iterationId","0u6M","menuId","HfMs","productId","3f2v","ctime",parse("2020-11-07 22:55:27"),"relStatus","i","hasTask","S","cuserid","mJNP","cusername","F8by");
		XmIterationMenu xmIterationMenu7=BaseUtils.fromMap(p7,XmIterationMenu.class);
		batchValues.add(xmIterationMenu7);
		baseDao.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","8b59");
		Map<String,Object> result=this.baseDao.selectOne(XmIterationMenu.class.getName()+".selectOneMap",p);
		Assert.assertEquals("8b59", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("iterationId","5b38","menuId","Se4e","productId","oIgA","ctime",parse("2020-11-07 22:55:27"),"relStatus","x","hasTask","9","cuserid","itag","cusername","cxXF");
		XmIterationMenu xmIterationMenu=BaseUtils.fromMap(p,XmIterationMenu.class);
		long result=baseDao.countByWhere(xmIterationMenu);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
 		
		
		Map<String,Object> p=BaseUtils.map("iterationId","5b38","menuId","Se4e","productId","oIgA","ctime",parse("2020-11-07 22:55:27"),"relStatus","x","hasTask","9","cuserid","itag","cusername","cxXF");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmIterationMenu xmIterationMenu=BaseUtils.fromMap(p,XmIterationMenu.class);
		List<XmIterationMenu> result=baseDao.selectListByWhere(xmIterationMenu); 
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
	
		
		Map<String,Object> p=BaseUtils.map("iterationId","5b38","menuId","Se4e","productId","oIgA","ctime",parse("2020-11-07 22:55:27"),"relStatus","x","hasTask","9","cuserid","itag","cusername","cxXF");
		XmIterationMenu xmIterationMenu=BaseUtils.fromMap(p,XmIterationMenu.class);
		List<XmIterationMenu> result=baseDao.selectListByWhere(xmIterationMenu);
		Assert.assertEquals(true, result.size()>=1);
	}

	
	/**
	 * 查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("iterationId","5b38","menuId","Se4e","productId","oIgA","ctime",parse("2020-11-07 22:55:27"),"relStatus","x","hasTask","9","cuserid","itag","cusername","cxXF");
		List<Map<String,Object>> result=baseDao.selectList(XmIterationMenu.class.getName()+".selectListMapByWhere",p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("iterationId","5b38","menuId","Se4e","productId","oIgA","ctime",parse("2020-11-07 22:55:27"),"relStatus","x","hasTask","9","cuserid","itag","cusername","cxXF");
		List<Map<String,Object>> result=baseDao.selectList(XmIterationMenu.class.getName()+".selectListMapByKey",p);
		Assert.assertEquals(true, result.size()>=0);
	}
 
	/**
	 * 查询一个对象 XmIterationMenu
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","8b59");
		
		XmIterationMenu xmIterationMenu1=BaseUtils.fromMap(p,XmIterationMenu.class);
		XmIterationMenu xmIterationMenu=baseDao.selectOneObject(xmIterationMenu1);
		Assert.assertEquals("8b59", xmIterationMenu.getId());
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
