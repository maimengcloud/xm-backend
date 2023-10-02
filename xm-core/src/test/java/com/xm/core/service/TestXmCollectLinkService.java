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
import  com.xm.core.service.XmCollectLinkService;
import  com.xm.core.entity.XmCollectLink;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * @author code-gen
 * @since 2023-10-3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmCollectLinkService  {

	@Autowired
	XmCollectLinkService xmCollectLinkService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("collectId","26P8","projectId","Qa4L");
		XmCollectLink xmCollectLink=BaseUtils.fromMap(p,XmCollectLink.class);
		xmCollectLinkService.save(xmCollectLink);
		//Assert.assertEquals(1, result);
	}
	 
}
