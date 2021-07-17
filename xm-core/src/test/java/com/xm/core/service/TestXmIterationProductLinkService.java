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
import  com.xm.core.service.XmIterationProductLinkService; 
import com.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import  com.xm.core.entity.XmIterationProductLink;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmIterationProductLinkService的测试案例
 * 组织 com<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_iteration_product_link 迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表<br>
 * 实体 XmIterationProductLink<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	iterationId,productId,ctime,cuserid,cusername,linkStatus;<br>
 * 当前表的所有字段名:<br>
 *	iteration_id,product_id,ctime,cuserid,cusername,link_status;<br>
 * 当前主键(包括多主键):<br>
 *	iteration_id,product_id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmIterationProductLinkService  {

	@Autowired
	XmIterationProductLinkService xmIterationProductLinkService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("iterationId","BcN5","productId","7rUG","ctime",new Date("2021-07-17 20:28:11"),"cuserid","UpT2","cusername","y2y7","linkStatus","p");
		XmIterationProductLink xmIterationProductLink=BaseUtils.fromMap(p,XmIterationProductLink.class);
		xmIterationProductLinkService.insert(xmIterationProductLink);
		//Assert.assertEquals(1, result);
	}
	 
}
