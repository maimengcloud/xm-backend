package com.xm.core.dao;

import java.util.*;
import java.text.SimpleDateFormat;

import com.xm.core.entity.XmExchange;
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
 * XmExchangeDao的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_exchange 功能表<br>
 * 实体 XmExchange<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	taskId,taskName,projectId,remark,id,pid,cuserid,cusername,ctime,cbranchId,adopt,adoptUserid,adoptUsername,adoptTime,closed,puserid,pusername,premark,notifyUserids,notifyChannels,notifyUsernames,cuserHeadImg,replyType;<br>
 * 当前表的所有字段名:<br>
 *	task_id,task_name,project_id,remark,id,pid,cuserid,cusername,ctime,cbranch_id,adopt,adopt_userid,adopt_username,adopt_time,closed,puserid,pusername,premark,notify_userids,notify_channels,notify_usernames,cuser_head_img,reply_type;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/
 @RunWith(SpringJUnit4ClassRunner.class)
 @SpringBootTest
public class TestXmExchangeDao  {

	@Autowired
	BaseDao baseDao;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("taskId","2bgZ","taskName","0iKN","projectId","fQuY","remark","6479","id","93aP","pid","2duW","cuserid","XtBe","cusername","5joK","ctime",parse("2020-11-04 3:27:11"),"cbranchId","l9yY","adopt","h","adoptUserid","EEtj","adoptUsername","DLi9","adoptTime",parse("2020-11-04 3:27:11"),"closed","7","puserid","l74e","pusername","9bo3","premark","3FSH","notifyUserids","6Jgx","notifyChannels","18GL","notifyUsernames","OFrR","cuserHeadImg","vZyQ","replyType","O");
		XmExchange xmExchange=BaseUtils.fromMap(p,XmExchange.class);
		baseDao.insert(xmExchange);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("taskId","2bgZ","taskName","0iKN","projectId","fQuY","remark","6479","pid","2duW","cuserid","XtBe","cusername","5joK","ctime",parse("2020-11-04 3:27:11"),"cbranchId","l9yY","adopt","h","adoptUserid","EEtj","adoptUsername","DLi9","adoptTime",parse("2020-11-04 3:27:11"),"closed","7","puserid","l74e","pusername","9bo3","premark","3FSH","notifyUserids","6Jgx","notifyChannels","18GL","notifyUsernames","OFrR","cuserHeadImg","vZyQ","replyType","O");
		XmExchange xmExchange=BaseUtils.fromMap(p,XmExchange.class);
		baseDao.deleteByWhere(xmExchange);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","93aP");
		XmExchange xmExchange=BaseUtils.fromMap(p,XmExchange.class);
		baseDao.deleteByPk(xmExchange);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("taskId","2bgZ","taskName","0iKN","projectId","fQuY","remark","6479","pid","2duW","cuserid","XtBe","cusername","5joK","ctime",parse("2020-11-04 3:27:11"),"cbranchId","l9yY","adopt","h","adoptUserid","EEtj","adoptUsername","DLi9","adoptTime",parse("2020-11-04 3:27:11"),"closed","7","puserid","l74e","pusername","9bo3","premark","3FSH","notifyUserids","6Jgx","notifyChannels","18GL","notifyUsernames","OFrR","cuserHeadImg","vZyQ","replyType","O");
		XmExchange xmExchange=BaseUtils.fromMap(where,XmExchange.class);
		baseDao.updateSomeFieldByPk(xmExchange);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","93aP");
		XmExchange xmExchange=BaseUtils.fromMap(p,XmExchange.class);
		baseDao.updateByPk(xmExchange);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("taskId","2bgZ","taskName","0iKN","projectId","fQuY","remark","6479","id","93aP","pid","2duW","cuserid","XtBe","cusername","5joK","ctime",parse("2020-11-04 3:27:11"),"cbranchId","l9yY","adopt","h","adoptUserid","EEtj","adoptUsername","DLi9","adoptTime",parse("2020-11-04 3:27:11"),"closed","7","puserid","l74e","pusername","9bo3","premark","3FSH","notifyUserids","6Jgx","notifyChannels","18GL","notifyUsernames","OFrR","cuserHeadImg","vZyQ","replyType","O");
		XmExchange xmExchange=BaseUtils.fromMap(p,XmExchange.class);
		baseDao.insertOrUpdate(xmExchange);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmExchange> batchValues=new ArrayList<XmExchange>();
		Map p0=BaseUtils.map("taskId","2bgZ","taskName","0iKN","projectId","fQuY","remark","6479","id","93aP","pid","2duW","cuserid","XtBe","cusername","5joK","ctime",parse("2020-11-04 3:27:11"),"cbranchId","l9yY","adopt","h","adoptUserid","EEtj","adoptUsername","DLi9","adoptTime",parse("2020-11-04 3:27:11"),"closed","7","puserid","l74e","pusername","9bo3","premark","3FSH","notifyUserids","6Jgx","notifyChannels","18GL","notifyUsernames","OFrR","cuserHeadImg","vZyQ","replyType","O");
		XmExchange xmExchange0=BaseUtils.fromMap(p0,XmExchange.class);
		batchValues.add(xmExchange0);
		Map p1=BaseUtils.map("taskId","01mH","taskName","5uwl","projectId","BAL5","remark","59W1","id","ca2w","pid","kMmP","cuserid","i10D","cusername","OqvV","ctime",parse("2020-11-04 3:27:11"),"cbranchId","69Z4","adopt","J","adoptUserid","vlfq","adoptUsername","eJcQ","adoptTime",parse("2020-11-04 3:27:11"),"closed","0","puserid","SI2t","pusername","BZ24","premark","8WTH","notifyUserids","CJ5e","notifyChannels","3882","notifyUsernames","ui4f","cuserHeadImg","aTgO","replyType","3");
		XmExchange xmExchange1=BaseUtils.fromMap(p1,XmExchange.class);
		batchValues.add(xmExchange1);
		Map p2=BaseUtils.map("taskId","8IJ2","taskName","UCUK","projectId","HVuC","remark","41lh","id","u1dR","pid","JuBu","cuserid","zi45","cusername","i2K0","ctime",parse("2020-11-04 3:27:11"),"cbranchId","0fRY","adopt","5","adoptUserid","PkwF","adoptUsername","zaub","adoptTime",parse("2020-11-04 3:27:11"),"closed","w","puserid","60AQ","pusername","gOc6","premark","9C9T","notifyUserids","0kEZ","notifyChannels","gG1v","notifyUsernames","8p63","cuserHeadImg","wh4t","replyType","O");
		XmExchange xmExchange2=BaseUtils.fromMap(p2,XmExchange.class);
		batchValues.add(xmExchange2);
		Map p3=BaseUtils.map("taskId","NUnb","taskName","892E","projectId","vOIR","remark","hO3b","id","FNOi","pid","0bsg","cuserid","q0pJ","cusername","RXtC","ctime",parse("2020-11-04 3:27:11"),"cbranchId","Dkfm","adopt","B","adoptUserid","mh7X","adoptUsername","wS3L","adoptTime",parse("2020-11-04 3:27:11"),"closed","0","puserid","gpnp","pusername","c80z","premark","32jh","notifyUserids","9bvI","notifyChannels","42ib","notifyUsernames","kkam","cuserHeadImg","GUWh","replyType","r");
		XmExchange xmExchange3=BaseUtils.fromMap(p3,XmExchange.class);
		batchValues.add(xmExchange3);
		Map p4=BaseUtils.map("taskId","cRq1","taskName","8XXO","projectId","qG9W","remark","2Y0v","id","NN2H","pid","8vV2","cuserid","JgUC","cusername","430q","ctime",parse("2020-11-04 3:27:11"),"cbranchId","gd08","adopt","K","adoptUserid","6Vbe","adoptUsername","oXIm","adoptTime",parse("2020-11-04 3:27:11"),"closed","y","puserid","Wuq1","pusername","qiG0","premark","9KCS","notifyUserids","jqVy","notifyChannels","5XO2","notifyUsernames","Haz0","cuserHeadImg","61v5","replyType","p");
		XmExchange xmExchange4=BaseUtils.fromMap(p4,XmExchange.class);
		batchValues.add(xmExchange4);
		Map p5=BaseUtils.map("taskId","164e","taskName","Fo1K","projectId","3suQ","remark","m3m9","id","VEvB","pid","f3kw","cuserid","dIwn","cusername","632s","ctime",parse("2020-11-04 3:27:11"),"cbranchId","3YLr","adopt","1","adoptUserid","7OFq","adoptUsername","Xurx","adoptTime",parse("2020-11-04 3:27:11"),"closed","2","puserid","FumZ","pusername","3vu8","premark","j9xB","notifyUserids","G076","notifyChannels","cj52","notifyUsernames","usZG","cuserHeadImg","a3qZ","replyType","4");
		XmExchange xmExchange5=BaseUtils.fromMap(p5,XmExchange.class);
		batchValues.add(xmExchange5);
		Map p6=BaseUtils.map("taskId","ZiGH","taskName","lxWt","projectId","18e7","remark","3925","id","u1Sl","pid","XB1m","cuserid","DNN9","cusername","2bwY","ctime",parse("2020-11-04 3:27:11"),"cbranchId","7xX8","adopt","m","adoptUserid","Ze8F","adoptUsername","fSJa","adoptTime",parse("2020-11-04 3:27:11"),"closed","R","puserid","Uq8F","pusername","0mij","premark","5iZn","notifyUserids","16Td","notifyChannels","4eZX","notifyUsernames","6eoD","cuserHeadImg","byyR","replyType","3");
		XmExchange xmExchange6=BaseUtils.fromMap(p6,XmExchange.class);
		batchValues.add(xmExchange6);
		Map p7=BaseUtils.map("taskId","ESa5","taskName","31JM","projectId","hgI5","remark","KHAf","id","mxj4","pid","9W57","cuserid","22GI","cusername","3clI","ctime",parse("2020-11-04 3:27:11"),"cbranchId","iGV7","adopt","R","adoptUserid","V7N0","adoptUsername","kUxb","adoptTime",parse("2020-11-04 3:27:11"),"closed","b","puserid","m1KV","pusername","4pXH","premark","zZM1","notifyUserids","8XW5","notifyChannels","5g9C","notifyUsernames","mVHg","cuserHeadImg","O3sb","replyType","r");
		XmExchange xmExchange7=BaseUtils.fromMap(p7,XmExchange.class);
		batchValues.add(xmExchange7);
		baseDao.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmExchange> batchValues=new ArrayList<XmExchange>();
		Map p0=BaseUtils.map("taskId","2bgZ","taskName","0iKN","projectId","fQuY","remark","6479","id","93aP","pid","2duW","cuserid","XtBe","cusername","5joK","ctime",parse("2020-11-04 3:27:11"),"cbranchId","l9yY","adopt","h","adoptUserid","EEtj","adoptUsername","DLi9","adoptTime",parse("2020-11-04 3:27:11"),"closed","7","puserid","l74e","pusername","9bo3","premark","3FSH","notifyUserids","6Jgx","notifyChannels","18GL","notifyUsernames","OFrR","cuserHeadImg","vZyQ","replyType","O");
		XmExchange xmExchange0=BaseUtils.fromMap(p0,XmExchange.class);
		batchValues.add(xmExchange0);
		Map p1=BaseUtils.map("taskId","01mH","taskName","5uwl","projectId","BAL5","remark","59W1","id","ca2w","pid","kMmP","cuserid","i10D","cusername","OqvV","ctime",parse("2020-11-04 3:27:11"),"cbranchId","69Z4","adopt","J","adoptUserid","vlfq","adoptUsername","eJcQ","adoptTime",parse("2020-11-04 3:27:11"),"closed","0","puserid","SI2t","pusername","BZ24","premark","8WTH","notifyUserids","CJ5e","notifyChannels","3882","notifyUsernames","ui4f","cuserHeadImg","aTgO","replyType","3");
		XmExchange xmExchange1=BaseUtils.fromMap(p1,XmExchange.class);
		batchValues.add(xmExchange1);
		Map p2=BaseUtils.map("taskId","8IJ2","taskName","UCUK","projectId","HVuC","remark","41lh","id","u1dR","pid","JuBu","cuserid","zi45","cusername","i2K0","ctime",parse("2020-11-04 3:27:11"),"cbranchId","0fRY","adopt","5","adoptUserid","PkwF","adoptUsername","zaub","adoptTime",parse("2020-11-04 3:27:11"),"closed","w","puserid","60AQ","pusername","gOc6","premark","9C9T","notifyUserids","0kEZ","notifyChannels","gG1v","notifyUsernames","8p63","cuserHeadImg","wh4t","replyType","O");
		XmExchange xmExchange2=BaseUtils.fromMap(p2,XmExchange.class);
		batchValues.add(xmExchange2);
		Map p3=BaseUtils.map("taskId","NUnb","taskName","892E","projectId","vOIR","remark","hO3b","id","FNOi","pid","0bsg","cuserid","q0pJ","cusername","RXtC","ctime",parse("2020-11-04 3:27:11"),"cbranchId","Dkfm","adopt","B","adoptUserid","mh7X","adoptUsername","wS3L","adoptTime",parse("2020-11-04 3:27:11"),"closed","0","puserid","gpnp","pusername","c80z","premark","32jh","notifyUserids","9bvI","notifyChannels","42ib","notifyUsernames","kkam","cuserHeadImg","GUWh","replyType","r");
		XmExchange xmExchange3=BaseUtils.fromMap(p3,XmExchange.class);
		batchValues.add(xmExchange3);
		Map p4=BaseUtils.map("taskId","cRq1","taskName","8XXO","projectId","qG9W","remark","2Y0v","id","NN2H","pid","8vV2","cuserid","JgUC","cusername","430q","ctime",parse("2020-11-04 3:27:11"),"cbranchId","gd08","adopt","K","adoptUserid","6Vbe","adoptUsername","oXIm","adoptTime",parse("2020-11-04 3:27:11"),"closed","y","puserid","Wuq1","pusername","qiG0","premark","9KCS","notifyUserids","jqVy","notifyChannels","5XO2","notifyUsernames","Haz0","cuserHeadImg","61v5","replyType","p");
		XmExchange xmExchange4=BaseUtils.fromMap(p4,XmExchange.class);
		batchValues.add(xmExchange4);
		Map p5=BaseUtils.map("taskId","164e","taskName","Fo1K","projectId","3suQ","remark","m3m9","id","VEvB","pid","f3kw","cuserid","dIwn","cusername","632s","ctime",parse("2020-11-04 3:27:11"),"cbranchId","3YLr","adopt","1","adoptUserid","7OFq","adoptUsername","Xurx","adoptTime",parse("2020-11-04 3:27:11"),"closed","2","puserid","FumZ","pusername","3vu8","premark","j9xB","notifyUserids","G076","notifyChannels","cj52","notifyUsernames","usZG","cuserHeadImg","a3qZ","replyType","4");
		XmExchange xmExchange5=BaseUtils.fromMap(p5,XmExchange.class);
		batchValues.add(xmExchange5);
		Map p6=BaseUtils.map("taskId","ZiGH","taskName","lxWt","projectId","18e7","remark","3925","id","u1Sl","pid","XB1m","cuserid","DNN9","cusername","2bwY","ctime",parse("2020-11-04 3:27:11"),"cbranchId","7xX8","adopt","m","adoptUserid","Ze8F","adoptUsername","fSJa","adoptTime",parse("2020-11-04 3:27:11"),"closed","R","puserid","Uq8F","pusername","0mij","premark","5iZn","notifyUserids","16Td","notifyChannels","4eZX","notifyUsernames","6eoD","cuserHeadImg","byyR","replyType","3");
		XmExchange xmExchange6=BaseUtils.fromMap(p6,XmExchange.class);
		batchValues.add(xmExchange6);
		Map p7=BaseUtils.map("taskId","ESa5","taskName","31JM","projectId","hgI5","remark","KHAf","id","mxj4","pid","9W57","cuserid","22GI","cusername","3clI","ctime",parse("2020-11-04 3:27:11"),"cbranchId","iGV7","adopt","R","adoptUserid","V7N0","adoptUsername","kUxb","adoptTime",parse("2020-11-04 3:27:11"),"closed","b","puserid","m1KV","pusername","4pXH","premark","zZM1","notifyUserids","8XW5","notifyChannels","5g9C","notifyUsernames","mVHg","cuserHeadImg","O3sb","replyType","r");
		XmExchange xmExchange7=BaseUtils.fromMap(p7,XmExchange.class);
		batchValues.add(xmExchange7);
		baseDao.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmExchange> batchValues=new ArrayList<XmExchange>();
		Map p0=BaseUtils.map("taskId","2bgZ","taskName","0iKN","projectId","fQuY","remark","6479","id","93aP","pid","2duW","cuserid","XtBe","cusername","5joK","ctime",parse("2020-11-04 3:27:11"),"cbranchId","l9yY","adopt","h","adoptUserid","EEtj","adoptUsername","DLi9","adoptTime",parse("2020-11-04 3:27:11"),"closed","7","puserid","l74e","pusername","9bo3","premark","3FSH","notifyUserids","6Jgx","notifyChannels","18GL","notifyUsernames","OFrR","cuserHeadImg","vZyQ","replyType","O");
		XmExchange xmExchange0=BaseUtils.fromMap(p0,XmExchange.class);
		batchValues.add(xmExchange0);
		Map p1=BaseUtils.map("taskId","01mH","taskName","5uwl","projectId","BAL5","remark","59W1","id","ca2w","pid","kMmP","cuserid","i10D","cusername","OqvV","ctime",parse("2020-11-04 3:27:11"),"cbranchId","69Z4","adopt","J","adoptUserid","vlfq","adoptUsername","eJcQ","adoptTime",parse("2020-11-04 3:27:11"),"closed","0","puserid","SI2t","pusername","BZ24","premark","8WTH","notifyUserids","CJ5e","notifyChannels","3882","notifyUsernames","ui4f","cuserHeadImg","aTgO","replyType","3");
		XmExchange xmExchange1=BaseUtils.fromMap(p1,XmExchange.class);
		batchValues.add(xmExchange1);
		Map p2=BaseUtils.map("taskId","8IJ2","taskName","UCUK","projectId","HVuC","remark","41lh","id","u1dR","pid","JuBu","cuserid","zi45","cusername","i2K0","ctime",parse("2020-11-04 3:27:11"),"cbranchId","0fRY","adopt","5","adoptUserid","PkwF","adoptUsername","zaub","adoptTime",parse("2020-11-04 3:27:11"),"closed","w","puserid","60AQ","pusername","gOc6","premark","9C9T","notifyUserids","0kEZ","notifyChannels","gG1v","notifyUsernames","8p63","cuserHeadImg","wh4t","replyType","O");
		XmExchange xmExchange2=BaseUtils.fromMap(p2,XmExchange.class);
		batchValues.add(xmExchange2);
		Map p3=BaseUtils.map("taskId","NUnb","taskName","892E","projectId","vOIR","remark","hO3b","id","FNOi","pid","0bsg","cuserid","q0pJ","cusername","RXtC","ctime",parse("2020-11-04 3:27:11"),"cbranchId","Dkfm","adopt","B","adoptUserid","mh7X","adoptUsername","wS3L","adoptTime",parse("2020-11-04 3:27:11"),"closed","0","puserid","gpnp","pusername","c80z","premark","32jh","notifyUserids","9bvI","notifyChannels","42ib","notifyUsernames","kkam","cuserHeadImg","GUWh","replyType","r");
		XmExchange xmExchange3=BaseUtils.fromMap(p3,XmExchange.class);
		batchValues.add(xmExchange3);
		Map p4=BaseUtils.map("taskId","cRq1","taskName","8XXO","projectId","qG9W","remark","2Y0v","id","NN2H","pid","8vV2","cuserid","JgUC","cusername","430q","ctime",parse("2020-11-04 3:27:11"),"cbranchId","gd08","adopt","K","adoptUserid","6Vbe","adoptUsername","oXIm","adoptTime",parse("2020-11-04 3:27:11"),"closed","y","puserid","Wuq1","pusername","qiG0","premark","9KCS","notifyUserids","jqVy","notifyChannels","5XO2","notifyUsernames","Haz0","cuserHeadImg","61v5","replyType","p");
		XmExchange xmExchange4=BaseUtils.fromMap(p4,XmExchange.class);
		batchValues.add(xmExchange4);
		Map p5=BaseUtils.map("taskId","164e","taskName","Fo1K","projectId","3suQ","remark","m3m9","id","VEvB","pid","f3kw","cuserid","dIwn","cusername","632s","ctime",parse("2020-11-04 3:27:11"),"cbranchId","3YLr","adopt","1","adoptUserid","7OFq","adoptUsername","Xurx","adoptTime",parse("2020-11-04 3:27:11"),"closed","2","puserid","FumZ","pusername","3vu8","premark","j9xB","notifyUserids","G076","notifyChannels","cj52","notifyUsernames","usZG","cuserHeadImg","a3qZ","replyType","4");
		XmExchange xmExchange5=BaseUtils.fromMap(p5,XmExchange.class);
		batchValues.add(xmExchange5);
		Map p6=BaseUtils.map("taskId","ZiGH","taskName","lxWt","projectId","18e7","remark","3925","id","u1Sl","pid","XB1m","cuserid","DNN9","cusername","2bwY","ctime",parse("2020-11-04 3:27:11"),"cbranchId","7xX8","adopt","m","adoptUserid","Ze8F","adoptUsername","fSJa","adoptTime",parse("2020-11-04 3:27:11"),"closed","R","puserid","Uq8F","pusername","0mij","premark","5iZn","notifyUserids","16Td","notifyChannels","4eZX","notifyUsernames","6eoD","cuserHeadImg","byyR","replyType","3");
		XmExchange xmExchange6=BaseUtils.fromMap(p6,XmExchange.class);
		batchValues.add(xmExchange6);
		Map p7=BaseUtils.map("taskId","ESa5","taskName","31JM","projectId","hgI5","remark","KHAf","id","mxj4","pid","9W57","cuserid","22GI","cusername","3clI","ctime",parse("2020-11-04 3:27:11"),"cbranchId","iGV7","adopt","R","adoptUserid","V7N0","adoptUsername","kUxb","adoptTime",parse("2020-11-04 3:27:11"),"closed","b","puserid","m1KV","pusername","4pXH","premark","zZM1","notifyUserids","8XW5","notifyChannels","5g9C","notifyUsernames","mVHg","cuserHeadImg","O3sb","replyType","r");
		XmExchange xmExchange7=BaseUtils.fromMap(p7,XmExchange.class);
		batchValues.add(xmExchange7);
		baseDao.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","93aP");
		Map<String,Object> result=this.baseDao.selectOne(XmExchange.class.getName()+".selectOneMap",p);
		Assert.assertEquals("93aP", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("taskId","2bgZ","taskName","0iKN","projectId","fQuY","remark","6479","pid","2duW","cuserid","XtBe","cusername","5joK","ctime",parse("2020-11-04 3:27:11"),"cbranchId","l9yY","adopt","h","adoptUserid","EEtj","adoptUsername","DLi9","adoptTime",parse("2020-11-04 3:27:11"),"closed","7","puserid","l74e","pusername","9bo3","premark","3FSH","notifyUserids","6Jgx","notifyChannels","18GL","notifyUsernames","OFrR","cuserHeadImg","vZyQ","replyType","O");
		XmExchange xmExchange=BaseUtils.fromMap(p,XmExchange.class);
		long result=baseDao.countByWhere(xmExchange);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
 		
		
		Map<String,Object> p=BaseUtils.map("taskId","2bgZ","taskName","0iKN","projectId","fQuY","remark","6479","pid","2duW","cuserid","XtBe","cusername","5joK","ctime",parse("2020-11-04 3:27:11"),"cbranchId","l9yY","adopt","h","adoptUserid","EEtj","adoptUsername","DLi9","adoptTime",parse("2020-11-04 3:27:11"),"closed","7","puserid","l74e","pusername","9bo3","premark","3FSH","notifyUserids","6Jgx","notifyChannels","18GL","notifyUsernames","OFrR","cuserHeadImg","vZyQ","replyType","O");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmExchange xmExchange=BaseUtils.fromMap(p,XmExchange.class);
		List<XmExchange> result=baseDao.selectListByWhere(xmExchange); 
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
	
		
		Map<String,Object> p=BaseUtils.map("taskId","2bgZ","taskName","0iKN","projectId","fQuY","remark","6479","pid","2duW","cuserid","XtBe","cusername","5joK","ctime",parse("2020-11-04 3:27:11"),"cbranchId","l9yY","adopt","h","adoptUserid","EEtj","adoptUsername","DLi9","adoptTime",parse("2020-11-04 3:27:11"),"closed","7","puserid","l74e","pusername","9bo3","premark","3FSH","notifyUserids","6Jgx","notifyChannels","18GL","notifyUsernames","OFrR","cuserHeadImg","vZyQ","replyType","O");
		XmExchange xmExchange=BaseUtils.fromMap(p,XmExchange.class);
		List<XmExchange> result=baseDao.selectListByWhere(xmExchange);
		Assert.assertEquals(true, result.size()>=1);
	}

	
	/**
	 * 查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("taskId","2bgZ","taskName","0iKN","projectId","fQuY","remark","6479","pid","2duW","cuserid","XtBe","cusername","5joK","ctime",parse("2020-11-04 3:27:11"),"cbranchId","l9yY","adopt","h","adoptUserid","EEtj","adoptUsername","DLi9","adoptTime",parse("2020-11-04 3:27:11"),"closed","7","puserid","l74e","pusername","9bo3","premark","3FSH","notifyUserids","6Jgx","notifyChannels","18GL","notifyUsernames","OFrR","cuserHeadImg","vZyQ","replyType","O");
		List<Map<String,Object>> result=baseDao.selectList(XmExchange.class.getName()+".selectListMapByWhere",p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("taskId","2bgZ","taskName","0iKN","projectId","fQuY","remark","6479","pid","2duW","cuserid","XtBe","cusername","5joK","ctime",parse("2020-11-04 3:27:11"),"cbranchId","l9yY","adopt","h","adoptUserid","EEtj","adoptUsername","DLi9","adoptTime",parse("2020-11-04 3:27:11"),"closed","7","puserid","l74e","pusername","9bo3","premark","3FSH","notifyUserids","6Jgx","notifyChannels","18GL","notifyUsernames","OFrR","cuserHeadImg","vZyQ","replyType","O");
		List<Map<String,Object>> result=baseDao.selectList(XmExchange.class.getName()+".selectListMapByKey",p);
		Assert.assertEquals(true, result.size()>=0);
	}
 
	/**
	 * 查询一个对象 XmExchange
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","93aP");
		
		XmExchange xmExchange1=BaseUtils.fromMap(p,XmExchange.class);
		XmExchange xmExchange=baseDao.selectOneObject(xmExchange1);
		Assert.assertEquals("93aP", xmExchange.getId());
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
