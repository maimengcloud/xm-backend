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
import  com.xm.core.service.XmBudgetLaborService;
import  com.xm.core.entity.XmBudgetLabor;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * @author code-gen
 * @since 2023-10-3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmBudgetLaborService  {

	@Autowired
	XmBudgetLaborService xmBudgetLaborService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("projectId","CpH7","userid","BSng","budgetAt",81.23,"id","K54u","remark","0Hg1","username","vp1B","subjectId","mGnj","bizSdate",new Date("2023-10-03 4:17:22"),"bizEdate",new Date("2023-10-03 4:17:22"),"bizMonth","bLtQ","instId","hgaZ","bizFlowState","D","costType","X","subjectName","al1h","branchId","7pmi","ubranchId","RIsU");
		XmBudgetLabor xmBudgetLabor=BaseUtils.fromMap(p,XmBudgetLabor.class);
		xmBudgetLaborService.save(xmBudgetLabor);
		//Assert.assertEquals(1, result);
	}
	 
}
