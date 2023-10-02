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
import  com.xm.core.service.XmRptDataService;
import  com.xm.core.entity.XmRptData;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * @author code-gen
 * @since 2023-10-3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmRptDataService  {

	@Autowired
	XmRptDataService xmRptDataService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","SW5B","rptName","FaU9","cfgId","1Roy","rptData","zpM8","cuserid","rj00","cbranchId","GJg9","cusername","YYqq","ctime",new Date("2023-10-03 4:17:29"),"bizDate","O8I9","bizType","3","bizId","mpCA");
		XmRptData xmRptData=BaseUtils.fromMap(p,XmRptData.class);
		xmRptDataService.save(xmRptData);
		//Assert.assertEquals(1, result);
	}
	 
}
