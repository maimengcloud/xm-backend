package com.xm.core.dao;

import com.mdp.core.dao.BaseDao;
import com.mdp.core.utils.BaseUtils;
import com.xm.core.entity.XmMenu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;
/**
 * XmMenuDao的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_menu 功能表<br>
 * 实体 XmMenu<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	menuId,menuName,pmenuId,productId,remark,status,online,demandUrl,codeUrl,designUrl,docUrl,helpUrl,operDocUrl,seqNo,mmUserid,mmUsername;<br>
 * 当前表的所有字段名:<br>
 *	menu_id,menu_name,pmenu_id,product_id,remark,status,online,demand_url,code_url,design_url,doc_url,help_url,oper_doc_url,seq_no,mm_userid,mm_username;<br>
 * 当前主键(包括多主键):<br>
 *	menu_id;<br>
 ***/
 @RunWith(SpringJUnit4ClassRunner.class)
 @SpringBootTest
public class TestXmMenuDao  {

	@Autowired
	BaseDao baseDao;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("menuId","iZQc","menuName","Hf16","pmenuId","Unx4","productId","Fmb2","remark","JAz3","status","Y","online","W","demandUrl","144e","codeUrl","u3UN","designUrl","FWSi","docUrl","KAXq","helpUrl","qWGk","operDocUrl","MQYM","seqNo","Utj5","mmUserid","vWDr","mmUsername","mUdd");
		XmMenu xmMenu=BaseUtils.fromMap(p,XmMenu.class);
		baseDao.insert(xmMenu);
		//Assert.assertEquals(1, result);
	} 
}
