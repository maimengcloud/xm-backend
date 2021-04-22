package com.xm.share.dao;

import java.util.*;
import java.text.SimpleDateFormat;
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
import com.xm.share.entity.ShareReceInfo;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * ShareReceInfoDao的测试案例
 * 组织 com<br>
 * 顶级模块 xm<br>
 * 大模块 share<br>
 * 小模块 <br>
 * 表 XM.xm_share_rece_info 分享后接收人行为记录表<br>
 * 实体 ShareReceInfo<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,shareKey,receiverId,receiverName,receTime;<br>
 * 当前表的所有字段名:<br>
 *	id,share_key,receiver_id,receiver_name,rece_time;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/
 @RunWith(SpringJUnit4ClassRunner.class)
 @SpringBootTest
public class TestShareReceInfoDao  {

	@Autowired
	BaseDao baseDao;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","1zr2","shareKey","dp61","receiverId","9s6n","receiverName","83i7","receTime",new Date("2021-04-22 17:12:53"));
		ShareReceInfo shareReceInfo=BaseUtils.fromMap(p,ShareReceInfo.class);
		baseDao.insert(shareReceInfo);
		//Assert.assertEquals(1, result);
	} 
}
