package com.xm.core.dao;

import java.util.*;

import com.xm.core.entity.XmProduct;
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
 * XmProductDao的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_product 产品表<br>
 * 实体 XmProduct<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,productName,branchId,remark,version,pmUserid,pmUsername,ctime;<br>
 * 当前表的所有字段名:<br>
 *	id,product_name,branch_id,remark,version,pm_userid,pm_username,ctime;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/
 @RunWith(SpringJUnit4ClassRunner.class)
 @SpringBootTest
public class TestXmProductDao  {

	@Autowired
	BaseDao baseDao;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","bDL6","productName","fXAx","branchId","2kXz","remark","tge3","version","rlh3","pmUserid","Ar1H","pmUsername","2NBT","ctime",new Date("2020-11-24 21:26:13"));
		XmProduct xmProduct=BaseUtils.fromMap(p,XmProduct.class);
		baseDao.insert(xmProduct);
		//Assert.assertEquals(1, result);
	} 
}
