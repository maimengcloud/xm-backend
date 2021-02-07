package com.xm.core.dao;

import java.util.*;
import java.text.SimpleDateFormat;

import com.xm.core.entity.XmTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.mdp.core.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired; 
import com.mdp.core.dao.BaseDao;

import com.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmTestCaseDao的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_test_case 测试用例<br>
 * 实体 XmTestCase<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,caseName,caseRemark,testStep,expectResult,menuId,menuName,ctime,ltime,luserid,lusername,cbranchId,moduleId,moduleName,caseStatus;<br>
 * 当前表的所有字段名:<br>
 *	id,case_name,case_remark,test_step,expect_result,menu_id,menu_name,ctime,ltime,luserid,lusername,cbranch_id,module_id,module_name,case_status;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/
 @RunWith(SpringJUnit4ClassRunner.class)
 @SpringBootTest
public class TestXmTestCaseDao  {

	@Autowired
	BaseDao baseDao;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","0xhr","caseName","1R0K","caseRemark","qp2c","testStep","6t2c","expectResult","2xaC","menuId","dJL4","menuName","T342","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","9oSC","lusername","Vhw2","cbranchId","5oeq","moduleId","Z33D","moduleName","X90K","caseStatus","e");
		XmTestCase xmTestCase=BaseUtils.fromMap(p,XmTestCase.class);
		baseDao.insert(xmTestCase);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("caseName","1R0K","caseRemark","qp2c","testStep","6t2c","expectResult","2xaC","menuId","dJL4","menuName","T342","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","9oSC","lusername","Vhw2","cbranchId","5oeq","moduleId","Z33D","moduleName","X90K","caseStatus","e");
		XmTestCase xmTestCase=BaseUtils.fromMap(p,XmTestCase.class);
		baseDao.deleteByWhere(xmTestCase);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","0xhr");
		XmTestCase xmTestCase=BaseUtils.fromMap(p,XmTestCase.class);
		baseDao.deleteByPk(xmTestCase);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("caseName","1R0K","caseRemark","qp2c","testStep","6t2c","expectResult","2xaC","menuId","dJL4","menuName","T342","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","9oSC","lusername","Vhw2","cbranchId","5oeq","moduleId","Z33D","moduleName","X90K","caseStatus","e");
		XmTestCase xmTestCase=BaseUtils.fromMap(where,XmTestCase.class);
		baseDao.updateSomeFieldByPk(xmTestCase);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","0xhr");
		XmTestCase xmTestCase=BaseUtils.fromMap(p,XmTestCase.class);
		baseDao.updateByPk(xmTestCase);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("id","0xhr","caseName","1R0K","caseRemark","qp2c","testStep","6t2c","expectResult","2xaC","menuId","dJL4","menuName","T342","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","9oSC","lusername","Vhw2","cbranchId","5oeq","moduleId","Z33D","moduleName","X90K","caseStatus","e");
		XmTestCase xmTestCase=BaseUtils.fromMap(p,XmTestCase.class);
		baseDao.insertOrUpdate(xmTestCase);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmTestCase> batchValues=new ArrayList<XmTestCase>();
		Map p0=BaseUtils.map("id","0xhr","caseName","1R0K","caseRemark","qp2c","testStep","6t2c","expectResult","2xaC","menuId","dJL4","menuName","T342","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","9oSC","lusername","Vhw2","cbranchId","5oeq","moduleId","Z33D","moduleName","X90K","caseStatus","e");
		XmTestCase xmTestCase0=BaseUtils.fromMap(p0,XmTestCase.class);
		batchValues.add(xmTestCase0);
		Map p1=BaseUtils.map("id","np1k","caseName","6S0E","caseRemark","0IL6","testStep","RgQC","expectResult","L2hS","menuId","p94U","menuName","Jhc0","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","XMOM","lusername","05yz","cbranchId","XxUT","moduleId","KnT8","moduleName","bafg","caseStatus","z");
		XmTestCase xmTestCase1=BaseUtils.fromMap(p1,XmTestCase.class);
		batchValues.add(xmTestCase1);
		Map p2=BaseUtils.map("id","Cppd","caseName","9toR","caseRemark","2lqs","testStep","F4K0","expectResult","XLy0","menuId","hmEd","menuName","RW0X","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","byGk","lusername","nNPm","cbranchId","Ohx7","moduleId","KvDE","moduleName","3yPn","caseStatus","k");
		XmTestCase xmTestCase2=BaseUtils.fromMap(p2,XmTestCase.class);
		batchValues.add(xmTestCase2);
		Map p3=BaseUtils.map("id","x29y","caseName","92T8","caseRemark","H49n","testStep","TaJz","expectResult","V8Dv","menuId","2K7A","menuName","ms5y","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","Hjy8","lusername","D7J1","cbranchId","aHOR","moduleId","ZDw7","moduleName","Eq6D","caseStatus","p");
		XmTestCase xmTestCase3=BaseUtils.fromMap(p3,XmTestCase.class);
		batchValues.add(xmTestCase3);
		Map p4=BaseUtils.map("id","ZNYT","caseName","9Hjo","caseRemark","xZiG","testStep","DrWU","expectResult","0yWo","menuId","83hS","menuName","9d5L","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","4u3Z","lusername","1L28","cbranchId","jnLF","moduleId","O2GI","moduleName","TW57","caseStatus","L");
		XmTestCase xmTestCase4=BaseUtils.fromMap(p4,XmTestCase.class);
		batchValues.add(xmTestCase4);
		Map p5=BaseUtils.map("id","Z20z","caseName","rnva","caseRemark","XFA9","testStep","Jd7y","expectResult","ly23","menuId","0gSo","menuName","UZrw","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","025n","lusername","NjBw","cbranchId","sx7D","moduleId","L99T","moduleName","yXuX","caseStatus","C");
		XmTestCase xmTestCase5=BaseUtils.fromMap(p5,XmTestCase.class);
		batchValues.add(xmTestCase5);
		Map p6=BaseUtils.map("id","hSY0","caseName","max7","caseRemark","r79F","testStep","h4A0","expectResult","mY8n","menuId","aYLs","menuName","l8B1","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","Uf4H","lusername","RpTW","cbranchId","WggN","moduleId","2B1O","moduleName","wfc9","caseStatus","q");
		XmTestCase xmTestCase6=BaseUtils.fromMap(p6,XmTestCase.class);
		batchValues.add(xmTestCase6);
		Map p7=BaseUtils.map("id","0pAH","caseName","4qRc","caseRemark","9izF","testStep","t5xo","expectResult","hMA7","menuId","Sgs5","menuName","FzVO","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","3A7I","lusername","2OCX","cbranchId","H1Wr","moduleId","meat","moduleName","Al90","caseStatus","K");
		XmTestCase xmTestCase7=BaseUtils.fromMap(p7,XmTestCase.class);
		batchValues.add(xmTestCase7);
		baseDao.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmTestCase> batchValues=new ArrayList<XmTestCase>();
		Map p0=BaseUtils.map("id","0xhr","caseName","1R0K","caseRemark","qp2c","testStep","6t2c","expectResult","2xaC","menuId","dJL4","menuName","T342","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","9oSC","lusername","Vhw2","cbranchId","5oeq","moduleId","Z33D","moduleName","X90K","caseStatus","e");
		XmTestCase xmTestCase0=BaseUtils.fromMap(p0,XmTestCase.class);
		batchValues.add(xmTestCase0);
		Map p1=BaseUtils.map("id","np1k","caseName","6S0E","caseRemark","0IL6","testStep","RgQC","expectResult","L2hS","menuId","p94U","menuName","Jhc0","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","XMOM","lusername","05yz","cbranchId","XxUT","moduleId","KnT8","moduleName","bafg","caseStatus","z");
		XmTestCase xmTestCase1=BaseUtils.fromMap(p1,XmTestCase.class);
		batchValues.add(xmTestCase1);
		Map p2=BaseUtils.map("id","Cppd","caseName","9toR","caseRemark","2lqs","testStep","F4K0","expectResult","XLy0","menuId","hmEd","menuName","RW0X","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","byGk","lusername","nNPm","cbranchId","Ohx7","moduleId","KvDE","moduleName","3yPn","caseStatus","k");
		XmTestCase xmTestCase2=BaseUtils.fromMap(p2,XmTestCase.class);
		batchValues.add(xmTestCase2);
		Map p3=BaseUtils.map("id","x29y","caseName","92T8","caseRemark","H49n","testStep","TaJz","expectResult","V8Dv","menuId","2K7A","menuName","ms5y","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","Hjy8","lusername","D7J1","cbranchId","aHOR","moduleId","ZDw7","moduleName","Eq6D","caseStatus","p");
		XmTestCase xmTestCase3=BaseUtils.fromMap(p3,XmTestCase.class);
		batchValues.add(xmTestCase3);
		Map p4=BaseUtils.map("id","ZNYT","caseName","9Hjo","caseRemark","xZiG","testStep","DrWU","expectResult","0yWo","menuId","83hS","menuName","9d5L","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","4u3Z","lusername","1L28","cbranchId","jnLF","moduleId","O2GI","moduleName","TW57","caseStatus","L");
		XmTestCase xmTestCase4=BaseUtils.fromMap(p4,XmTestCase.class);
		batchValues.add(xmTestCase4);
		Map p5=BaseUtils.map("id","Z20z","caseName","rnva","caseRemark","XFA9","testStep","Jd7y","expectResult","ly23","menuId","0gSo","menuName","UZrw","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","025n","lusername","NjBw","cbranchId","sx7D","moduleId","L99T","moduleName","yXuX","caseStatus","C");
		XmTestCase xmTestCase5=BaseUtils.fromMap(p5,XmTestCase.class);
		batchValues.add(xmTestCase5);
		Map p6=BaseUtils.map("id","hSY0","caseName","max7","caseRemark","r79F","testStep","h4A0","expectResult","mY8n","menuId","aYLs","menuName","l8B1","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","Uf4H","lusername","RpTW","cbranchId","WggN","moduleId","2B1O","moduleName","wfc9","caseStatus","q");
		XmTestCase xmTestCase6=BaseUtils.fromMap(p6,XmTestCase.class);
		batchValues.add(xmTestCase6);
		Map p7=BaseUtils.map("id","0pAH","caseName","4qRc","caseRemark","9izF","testStep","t5xo","expectResult","hMA7","menuId","Sgs5","menuName","FzVO","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","3A7I","lusername","2OCX","cbranchId","H1Wr","moduleId","meat","moduleName","Al90","caseStatus","K");
		XmTestCase xmTestCase7=BaseUtils.fromMap(p7,XmTestCase.class);
		batchValues.add(xmTestCase7);
		baseDao.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmTestCase> batchValues=new ArrayList<XmTestCase>();
		Map p0=BaseUtils.map("id","0xhr","caseName","1R0K","caseRemark","qp2c","testStep","6t2c","expectResult","2xaC","menuId","dJL4","menuName","T342","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","9oSC","lusername","Vhw2","cbranchId","5oeq","moduleId","Z33D","moduleName","X90K","caseStatus","e");
		XmTestCase xmTestCase0=BaseUtils.fromMap(p0,XmTestCase.class);
		batchValues.add(xmTestCase0);
		Map p1=BaseUtils.map("id","np1k","caseName","6S0E","caseRemark","0IL6","testStep","RgQC","expectResult","L2hS","menuId","p94U","menuName","Jhc0","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","XMOM","lusername","05yz","cbranchId","XxUT","moduleId","KnT8","moduleName","bafg","caseStatus","z");
		XmTestCase xmTestCase1=BaseUtils.fromMap(p1,XmTestCase.class);
		batchValues.add(xmTestCase1);
		Map p2=BaseUtils.map("id","Cppd","caseName","9toR","caseRemark","2lqs","testStep","F4K0","expectResult","XLy0","menuId","hmEd","menuName","RW0X","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","byGk","lusername","nNPm","cbranchId","Ohx7","moduleId","KvDE","moduleName","3yPn","caseStatus","k");
		XmTestCase xmTestCase2=BaseUtils.fromMap(p2,XmTestCase.class);
		batchValues.add(xmTestCase2);
		Map p3=BaseUtils.map("id","x29y","caseName","92T8","caseRemark","H49n","testStep","TaJz","expectResult","V8Dv","menuId","2K7A","menuName","ms5y","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","Hjy8","lusername","D7J1","cbranchId","aHOR","moduleId","ZDw7","moduleName","Eq6D","caseStatus","p");
		XmTestCase xmTestCase3=BaseUtils.fromMap(p3,XmTestCase.class);
		batchValues.add(xmTestCase3);
		Map p4=BaseUtils.map("id","ZNYT","caseName","9Hjo","caseRemark","xZiG","testStep","DrWU","expectResult","0yWo","menuId","83hS","menuName","9d5L","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","4u3Z","lusername","1L28","cbranchId","jnLF","moduleId","O2GI","moduleName","TW57","caseStatus","L");
		XmTestCase xmTestCase4=BaseUtils.fromMap(p4,XmTestCase.class);
		batchValues.add(xmTestCase4);
		Map p5=BaseUtils.map("id","Z20z","caseName","rnva","caseRemark","XFA9","testStep","Jd7y","expectResult","ly23","menuId","0gSo","menuName","UZrw","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","025n","lusername","NjBw","cbranchId","sx7D","moduleId","L99T","moduleName","yXuX","caseStatus","C");
		XmTestCase xmTestCase5=BaseUtils.fromMap(p5,XmTestCase.class);
		batchValues.add(xmTestCase5);
		Map p6=BaseUtils.map("id","hSY0","caseName","max7","caseRemark","r79F","testStep","h4A0","expectResult","mY8n","menuId","aYLs","menuName","l8B1","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","Uf4H","lusername","RpTW","cbranchId","WggN","moduleId","2B1O","moduleName","wfc9","caseStatus","q");
		XmTestCase xmTestCase6=BaseUtils.fromMap(p6,XmTestCase.class);
		batchValues.add(xmTestCase6);
		Map p7=BaseUtils.map("id","0pAH","caseName","4qRc","caseRemark","9izF","testStep","t5xo","expectResult","hMA7","menuId","Sgs5","menuName","FzVO","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","3A7I","lusername","2OCX","cbranchId","H1Wr","moduleId","meat","moduleName","Al90","caseStatus","K");
		XmTestCase xmTestCase7=BaseUtils.fromMap(p7,XmTestCase.class);
		batchValues.add(xmTestCase7);
		baseDao.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","0xhr");
		Map<String,Object> result=this.baseDao.selectOne(XmTestCase.class.getName()+".selectOneMap",p);
		Assert.assertEquals("0xhr", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("caseName","1R0K","caseRemark","qp2c","testStep","6t2c","expectResult","2xaC","menuId","dJL4","menuName","T342","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","9oSC","lusername","Vhw2","cbranchId","5oeq","moduleId","Z33D","moduleName","X90K","caseStatus","e");
		XmTestCase xmTestCase=BaseUtils.fromMap(p,XmTestCase.class);
		long result=baseDao.countByWhere(xmTestCase);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
 		
		
		Map<String,Object> p=BaseUtils.map("caseName","1R0K","caseRemark","qp2c","testStep","6t2c","expectResult","2xaC","menuId","dJL4","menuName","T342","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","9oSC","lusername","Vhw2","cbranchId","5oeq","moduleId","Z33D","moduleName","X90K","caseStatus","e");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmTestCase xmTestCase=BaseUtils.fromMap(p,XmTestCase.class);
		List<XmTestCase> result=baseDao.selectListByWhere(xmTestCase); 
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
	
		
		Map<String,Object> p=BaseUtils.map("caseName","1R0K","caseRemark","qp2c","testStep","6t2c","expectResult","2xaC","menuId","dJL4","menuName","T342","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","9oSC","lusername","Vhw2","cbranchId","5oeq","moduleId","Z33D","moduleName","X90K","caseStatus","e");
		XmTestCase xmTestCase=BaseUtils.fromMap(p,XmTestCase.class);
		List<XmTestCase> result=baseDao.selectListByWhere(xmTestCase);
		Assert.assertEquals(true, result.size()>=1);
	}

	
	/**
	 * 查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("caseName","1R0K","caseRemark","qp2c","testStep","6t2c","expectResult","2xaC","menuId","dJL4","menuName","T342","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","9oSC","lusername","Vhw2","cbranchId","5oeq","moduleId","Z33D","moduleName","X90K","caseStatus","e");
		List<Map<String,Object>> result=baseDao.selectList(XmTestCase.class.getName()+".selectListMapByWhere",p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("caseName","1R0K","caseRemark","qp2c","testStep","6t2c","expectResult","2xaC","menuId","dJL4","menuName","T342","ctime",parse("2020-11-11 18:53:26"),"ltime",parse("2020-11-11 18:53:26"),"luserid","9oSC","lusername","Vhw2","cbranchId","5oeq","moduleId","Z33D","moduleName","X90K","caseStatus","e");
		List<Map<String,Object>> result=baseDao.selectList(XmTestCase.class.getName()+".selectListMapByKey",p);
		Assert.assertEquals(true, result.size()>=0);
	}
 
	/**
	 * 查询一个对象 XmTestCase
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","0xhr");
		
		XmTestCase xmTestCase1=BaseUtils.fromMap(p,XmTestCase.class);
		XmTestCase xmTestCase=baseDao.selectOneObject(xmTestCase1);
		Assert.assertEquals("0xhr", xmTestCase.getId());
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
