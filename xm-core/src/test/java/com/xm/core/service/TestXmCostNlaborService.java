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
import  com.xm.core.service.XmCostNlaborService;
import  com.xm.core.entity.XmCostNlabor;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * @author code-gen
 * @since 2023-10-3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmCostNlaborService  {

	@Autowired
	XmCostNlaborService xmCostNlaborService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("projectId","13N4","userid","wCCt","ctime",new Date("2023-10-03 4:17:23"),"sendTime",new Date("2023-10-03 4:17:23"),"username","b05X","projectName","T0Bz","remark","0f1n","id","0mjM","taskId","W9GH","taskName","iClA","subjectId","kP6m","bizSdate",new Date("2023-10-03 4:17:23"),"bizEdate",new Date("2023-10-03 4:17:23"),"actAt",9601.87,"costType","c","bizMonth","snSJ","bizDate","uRD9","subjectName","DI1P","ubranchId","mRcP","branchId","PgRp");
		XmCostNlabor xmCostNlabor=BaseUtils.fromMap(p,XmCostNlabor.class);
		xmCostNlaborService.save(xmCostNlabor);
		//Assert.assertEquals(1, result);
	}
	 
}
