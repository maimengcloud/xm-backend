package com.xm.core.service;

import java.util.*;

import com.xm.core.entity.XmProject;
import com.xm.core.entity.XmProjectGroup;
import com.xm.core.entity.XmProjectGroupUser;
import com.xm.core.vo.XmProjectGroupVo;
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
 * XmProjectGroupService的测试案例
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
public class TestXmProjectGroupService  {

	@Autowired
	XmProjectGroupService xmProjectGroupService;
	
	@Autowired
	XmProjectService xmProjectService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","K345","groupName","h8Ry","projectId","w7r2","pgTypeId","N6mS","pgTypeName","HOzL");
		XmProjectGroup xmProjectGroup=BaseUtils.fromMap(p,XmProjectGroup.class);
		xmProjectGroupService.insert(xmProjectGroup);
		//Assert.assertEquals(1, result);
	} 
	
	@Test
	public void updateGroup() {
  		List<XmProject> projects=xmProjectService.selectListByWhere(new XmProject());

  		String projectId=projects.get(0).getId();
 		List<XmProjectGroupVo> xmProjectGroupVoList = xmProjectGroupService.getProjectGroupVoList(projectId);
		XmProjectGroupVo gvo=new XmProjectGroupVo();
		gvo.setId("xxxx3");
		gvo.setGroupName("xxxx3_name");
		List<XmProjectGroupUser> users=new ArrayList<>();
		XmProjectGroupUser user1=new XmProjectGroupUser();
		user1.setUserid("cyc-03");
		user1.setUsername("cyc_003_name");
		users.add(user1);
		gvo.setGroupUsers(users);
		xmProjectGroupVoList.add(gvo);
		gvo.setProjectId(projectId);
		xmProjectGroupService.updateGroup(projectId, xmProjectGroupVoList);

		//Assert.assertEquals(1, result);
	} 
}
