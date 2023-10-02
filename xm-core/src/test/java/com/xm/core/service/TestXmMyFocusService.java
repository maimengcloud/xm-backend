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
import  com.xm.core.service.XmMyFocusService;
import  com.xm.core.entity.XmMyFocus;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * @author code-gen
 * @since 2023-10-3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmMyFocusService  {

	@Autowired
	XmMyFocusService xmMyFocusService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("userid","gwT7","username","2If0","bizId","pz6a","focusType","h","pbizId","6gdT","bizName","n7Ss","pbizName","8207","ftime",new Date("2023-10-03 4:17:25"),"ubranchId","5BT7");
		XmMyFocus xmMyFocus=BaseUtils.fromMap(p,XmMyFocus.class);
		xmMyFocusService.save(xmMyFocus);
		//Assert.assertEquals(1, result);
	}
	 
}
