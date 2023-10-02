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
import  com.xm.core.service.XmBudgetNlaborService;
import  com.xm.core.entity.XmBudgetNlabor;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * @author code-gen
 * @since 2023-10-3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmBudgetNlaborService  {

	@Autowired
	XmBudgetNlaborService xmBudgetNlaborService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","o7hs","projectId","4GL7","budgetAt",9489.49,"remark","x957","subjectId","m25J","bizSdate",new Date("2023-10-03 4:17:23"),"bizEdate",new Date("2023-10-03 4:17:23"),"instId","cfoN","bizFlowState","3","costType","u","bizMonth","fngK","subjectName","h860","branchId","CUjP");
		XmBudgetNlabor xmBudgetNlabor=BaseUtils.fromMap(p,XmBudgetNlabor.class);
		xmBudgetNlaborService.save(xmBudgetNlabor);
		//Assert.assertEquals(1, result);
	}
	 
}
