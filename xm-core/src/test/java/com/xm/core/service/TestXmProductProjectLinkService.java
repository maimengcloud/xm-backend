package  com.xm.core.service;

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
import  com.xm.core.service.XmProductProjectLinkService; 
import com.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import  com.xm.core.entity.XmProductProjectLink;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmProductProjectLinkService的测试案例
 * 组织 com<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_product_project_link 产品与项目的关联关系表，一般由产品经理挂接项目到产品上<br>
 * 实体 XmProductProjectLink<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	projectId,productId,ctime,cuserid,cusername,linkStatus;<br>
 * 当前表的所有字段名:<br>
 *	project_id,product_id,ctime,cuserid,cusername,link_status;<br>
 * 当前主键(包括多主键):<br>
 *	project_id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProductProjectLinkService  {

	@Autowired
	XmProductProjectLinkService xmProductProjectLinkService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("projectId","b1g5","productId","V9Uu","ctime",new Date("2021-07-17 20:28:11"),"cuserid","uw3F","cusername","sPev","linkStatus","1");
		XmProductProjectLink xmProductProjectLink=BaseUtils.fromMap(p,XmProductProjectLink.class);
		xmProductProjectLinkService.insert(xmProductProjectLink);
		//Assert.assertEquals(1, result);
	}
	 
}
