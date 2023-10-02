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
import  com.xm.core.service.XmMyFootPrintService;
import  com.xm.core.entity.XmMyFootPrint;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * @author code-gen
 * @since 2023-10-3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmMyFootPrintService  {

	@Autowired
	XmMyFootPrintService xmMyFootPrintService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("userid","dr6S","username","9a9f","bizId","4YUg","focusType","S","pbizId","eOXh","bizName","3xNI","pbizName","S19c","ftime",new Date("2023-10-03 4:17:26"),"ubranchId","5FxF","ltime",new Date("2023-10-03 4:17:26"));
		XmMyFootPrint xmMyFootPrint=BaseUtils.fromMap(p,XmMyFootPrint.class);
		xmMyFootPrintService.save(xmMyFootPrint);
		//Assert.assertEquals(1, result);
	}
	 
}
