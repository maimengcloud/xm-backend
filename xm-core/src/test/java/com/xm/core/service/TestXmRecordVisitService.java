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
import  com.xm.core.service.XmRecordVisitService;
import  com.xm.core.entity.XmRecordVisit;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * @author code-gen
 * @since 2023-11-6
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmRecordVisitService  {

	@Autowired
	XmRecordVisitService xmRecordVisitService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","3zBV","operUserid","iPZA","operUsername","FV25","operTime",new Date("2023-11-06 19:20:47"),"objType","5hG5","action","TPoT","remarks","OMTO","gloNo","2qho","branchId","do3z","ip","1Xgx","bizId","bql7","pbizId","fL6G","bizName","1b93");
		XmRecordVisit xmRecordVisit=BaseUtils.fromMap(p,XmRecordVisit.class);
		xmRecordVisitService.save(xmRecordVisit);
		//Assert.assertEquals(1, result);
	}
	 
}
