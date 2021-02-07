package com.xm.core.service;

import java.util.*;
import java.text.SimpleDateFormat;

import com.xm.core.entity.XmQuestionTag;
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
 * XmQuestionTagService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_question_tag 问题标签关联表<br>
 * 实体 XmQuestionTag<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	questionId,tagId,tagName,ctime,id;<br>
 * 当前表的所有字段名:<br>
 *	question_id,tag_id,tag_name,ctime,id;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmQuestionTagService  {

	@Autowired
	XmQuestionTagService xmQuestionTagService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("questionId","MsQw","tagId","oc42","tagName","YNqd","ctime",parse("2020-10-15 15:31:20"),"id","jfME");
		XmQuestionTag xmQuestionTag=BaseUtils.fromMap(p,XmQuestionTag.class);
		xmQuestionTagService.insert(xmQuestionTag);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("questionId","MsQw","tagId","oc42","tagName","YNqd","ctime",parse("2020-10-15 15:31:20"));
		XmQuestionTag xmQuestionTag=BaseUtils.fromMap(p,XmQuestionTag.class);
		xmQuestionTagService.deleteByWhere(xmQuestionTag);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","jfME");
		XmQuestionTag xmQuestionTag=BaseUtils.fromMap(p,XmQuestionTag.class);
		xmQuestionTagService.deleteByPk(xmQuestionTag);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("questionId","MsQw","tagId","oc42","tagName","YNqd","ctime",parse("2020-10-15 15:31:20"));
		XmQuestionTag xmQuestionTag=BaseUtils.fromMap(where,XmQuestionTag.class);
		xmQuestionTagService.updateSomeFieldByPk(xmQuestionTag);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","jfME");
		XmQuestionTag xmQuestionTag=BaseUtils.fromMap(p,XmQuestionTag.class);
		xmQuestionTagService.updateByPk(xmQuestionTag);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("questionId","MsQw","tagId","oc42","tagName","YNqd","ctime",parse("2020-10-15 15:31:20"),"id","jfME");
		XmQuestionTag xmQuestionTag=BaseUtils.fromMap(p,XmQuestionTag.class);
		xmQuestionTagService.insertOrUpdate(xmQuestionTag);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmQuestionTag> batchValues=new ArrayList<XmQuestionTag>();
		Map p0=BaseUtils.map("questionId","MsQw","tagId","oc42","tagName","YNqd","ctime",parse("2020-10-15 15:31:20"),"id","jfME");
		XmQuestionTag xmQuestionTag0=BaseUtils.fromMap(p0,XmQuestionTag.class);
		batchValues.add(xmQuestionTag0);
		Map p1=BaseUtils.map("questionId","q9w1","tagId","4Yoq","tagName","gz94","ctime",parse("2020-10-15 15:31:20"),"id","jdV7");
		XmQuestionTag xmQuestionTag1=BaseUtils.fromMap(p1,XmQuestionTag.class);
		batchValues.add(xmQuestionTag1);
		Map p2=BaseUtils.map("questionId","27I2","tagId","IhzC","tagName","0gQc","ctime",parse("2020-10-15 15:31:20"),"id","iKkM");
		XmQuestionTag xmQuestionTag2=BaseUtils.fromMap(p2,XmQuestionTag.class);
		batchValues.add(xmQuestionTag2);
		Map p3=BaseUtils.map("questionId","fEnF","tagId","TCxI","tagName","RW8I","ctime",parse("2020-10-15 15:31:20"),"id","4Ko6");
		XmQuestionTag xmQuestionTag3=BaseUtils.fromMap(p3,XmQuestionTag.class);
		batchValues.add(xmQuestionTag3);
		Map p4=BaseUtils.map("questionId","hxjz","tagId","TCkt","tagName","t2ZQ","ctime",parse("2020-10-15 15:31:20"),"id","QReq");
		XmQuestionTag xmQuestionTag4=BaseUtils.fromMap(p4,XmQuestionTag.class);
		batchValues.add(xmQuestionTag4);
		Map p5=BaseUtils.map("questionId","7Uz6","tagId","3hZ1","tagName","Liao","ctime",parse("2020-10-15 15:31:20"),"id","N7RU");
		XmQuestionTag xmQuestionTag5=BaseUtils.fromMap(p5,XmQuestionTag.class);
		batchValues.add(xmQuestionTag5);
		Map p6=BaseUtils.map("questionId","X10r","tagId","319E","tagName","1wdD","ctime",parse("2020-10-15 15:31:20"),"id","kS2Y");
		XmQuestionTag xmQuestionTag6=BaseUtils.fromMap(p6,XmQuestionTag.class);
		batchValues.add(xmQuestionTag6);
		Map p7=BaseUtils.map("questionId","gV6j","tagId","W0vS","tagName","4sZM","ctime",parse("2020-10-15 15:31:20"),"id","71Lp");
		XmQuestionTag xmQuestionTag7=BaseUtils.fromMap(p7,XmQuestionTag.class);
		batchValues.add(xmQuestionTag7);
		xmQuestionTagService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmQuestionTag> batchValues=new ArrayList<XmQuestionTag>();
		Map p0=BaseUtils.map("questionId","MsQw","tagId","oc42","tagName","YNqd","ctime",parse("2020-10-15 15:31:20"),"id","jfME");
		XmQuestionTag xmQuestionTag0=BaseUtils.fromMap(p0,XmQuestionTag.class);
		batchValues.add(xmQuestionTag0);
		Map p1=BaseUtils.map("questionId","q9w1","tagId","4Yoq","tagName","gz94","ctime",parse("2020-10-15 15:31:20"),"id","jdV7");
		XmQuestionTag xmQuestionTag1=BaseUtils.fromMap(p1,XmQuestionTag.class);
		batchValues.add(xmQuestionTag1);
		Map p2=BaseUtils.map("questionId","27I2","tagId","IhzC","tagName","0gQc","ctime",parse("2020-10-15 15:31:20"),"id","iKkM");
		XmQuestionTag xmQuestionTag2=BaseUtils.fromMap(p2,XmQuestionTag.class);
		batchValues.add(xmQuestionTag2);
		Map p3=BaseUtils.map("questionId","fEnF","tagId","TCxI","tagName","RW8I","ctime",parse("2020-10-15 15:31:20"),"id","4Ko6");
		XmQuestionTag xmQuestionTag3=BaseUtils.fromMap(p3,XmQuestionTag.class);
		batchValues.add(xmQuestionTag3);
		Map p4=BaseUtils.map("questionId","hxjz","tagId","TCkt","tagName","t2ZQ","ctime",parse("2020-10-15 15:31:20"),"id","QReq");
		XmQuestionTag xmQuestionTag4=BaseUtils.fromMap(p4,XmQuestionTag.class);
		batchValues.add(xmQuestionTag4);
		Map p5=BaseUtils.map("questionId","7Uz6","tagId","3hZ1","tagName","Liao","ctime",parse("2020-10-15 15:31:20"),"id","N7RU");
		XmQuestionTag xmQuestionTag5=BaseUtils.fromMap(p5,XmQuestionTag.class);
		batchValues.add(xmQuestionTag5);
		Map p6=BaseUtils.map("questionId","X10r","tagId","319E","tagName","1wdD","ctime",parse("2020-10-15 15:31:20"),"id","kS2Y");
		XmQuestionTag xmQuestionTag6=BaseUtils.fromMap(p6,XmQuestionTag.class);
		batchValues.add(xmQuestionTag6);
		Map p7=BaseUtils.map("questionId","gV6j","tagId","W0vS","tagName","4sZM","ctime",parse("2020-10-15 15:31:20"),"id","71Lp");
		XmQuestionTag xmQuestionTag7=BaseUtils.fromMap(p7,XmQuestionTag.class);
		batchValues.add(xmQuestionTag7);
		xmQuestionTagService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmQuestionTag> batchValues=new ArrayList<XmQuestionTag>();
		Map p0=BaseUtils.map("questionId","MsQw","tagId","oc42","tagName","YNqd","ctime",parse("2020-10-15 15:31:20"),"id","jfME");
		XmQuestionTag xmQuestionTag0=BaseUtils.fromMap(p0,XmQuestionTag.class);
		batchValues.add(xmQuestionTag0);
		Map p1=BaseUtils.map("questionId","q9w1","tagId","4Yoq","tagName","gz94","ctime",parse("2020-10-15 15:31:20"),"id","jdV7");
		XmQuestionTag xmQuestionTag1=BaseUtils.fromMap(p1,XmQuestionTag.class);
		batchValues.add(xmQuestionTag1);
		Map p2=BaseUtils.map("questionId","27I2","tagId","IhzC","tagName","0gQc","ctime",parse("2020-10-15 15:31:20"),"id","iKkM");
		XmQuestionTag xmQuestionTag2=BaseUtils.fromMap(p2,XmQuestionTag.class);
		batchValues.add(xmQuestionTag2);
		Map p3=BaseUtils.map("questionId","fEnF","tagId","TCxI","tagName","RW8I","ctime",parse("2020-10-15 15:31:20"),"id","4Ko6");
		XmQuestionTag xmQuestionTag3=BaseUtils.fromMap(p3,XmQuestionTag.class);
		batchValues.add(xmQuestionTag3);
		Map p4=BaseUtils.map("questionId","hxjz","tagId","TCkt","tagName","t2ZQ","ctime",parse("2020-10-15 15:31:20"),"id","QReq");
		XmQuestionTag xmQuestionTag4=BaseUtils.fromMap(p4,XmQuestionTag.class);
		batchValues.add(xmQuestionTag4);
		Map p5=BaseUtils.map("questionId","7Uz6","tagId","3hZ1","tagName","Liao","ctime",parse("2020-10-15 15:31:20"),"id","N7RU");
		XmQuestionTag xmQuestionTag5=BaseUtils.fromMap(p5,XmQuestionTag.class);
		batchValues.add(xmQuestionTag5);
		Map p6=BaseUtils.map("questionId","X10r","tagId","319E","tagName","1wdD","ctime",parse("2020-10-15 15:31:20"),"id","kS2Y");
		XmQuestionTag xmQuestionTag6=BaseUtils.fromMap(p6,XmQuestionTag.class);
		batchValues.add(xmQuestionTag6);
		Map p7=BaseUtils.map("questionId","gV6j","tagId","W0vS","tagName","4sZM","ctime",parse("2020-10-15 15:31:20"),"id","71Lp");
		XmQuestionTag xmQuestionTag7=BaseUtils.fromMap(p7,XmQuestionTag.class);
		batchValues.add(xmQuestionTag7);
		xmQuestionTagService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","jfME");
		Map<String,Object> result=this.xmQuestionTagService.selectOne(XmQuestionTag.class.getName()+".selectOneMap",p);
		Assert.assertEquals("jfME", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("questionId","MsQw","tagId","oc42","tagName","YNqd","ctime",parse("2020-10-15 15:31:20"));
		XmQuestionTag xmQuestionTag=BaseUtils.fromMap(p,XmQuestionTag.class);
		long result=xmQuestionTagService.countByWhere(xmQuestionTag);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("questionId","MsQw","tagId","oc42","tagName","YNqd","ctime",parse("2020-10-15 15:31:20"));
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmQuestionTag xmQuestionTag=BaseUtils.fromMap(p,XmQuestionTag.class);
		List<XmQuestionTag> result=xmQuestionTagService.selectListByWhere(xmQuestionTag); 
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
	
		
		Map<String,Object> p=BaseUtils.map("questionId","MsQw","tagId","oc42","tagName","YNqd","ctime",parse("2020-10-15 15:31:20"));
		XmQuestionTag xmQuestionTag=BaseUtils.fromMap(p,XmQuestionTag.class);
		List<XmQuestionTag> result=xmQuestionTagService.selectListByWhere(xmQuestionTag);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("questionId","MsQw","tagId","oc42","tagName","YNqd","ctime",parse("2020-10-15 15:31:20"));
		List<Map<String,Object>> result=xmQuestionTagService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("questionId","MsQw","tagId","oc42","tagName","YNqd","ctime",parse("2020-10-15 15:31:20"));
		List<Map<String,Object>> result=xmQuestionTagService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmQuestionTag
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","jfME");
		
		XmQuestionTag xmQuestionTag1=BaseUtils.fromMap(p,XmQuestionTag.class);
		XmQuestionTag xmQuestionTag=xmQuestionTagService.selectOneObject(xmQuestionTag1);
		Assert.assertEquals("jfME", xmQuestionTag.getId());
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
