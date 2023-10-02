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
import  com.xm.core.service.XmProjectKpiService;
import  com.xm.core.entity.XmProjectKpi;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * @author code-gen
 * @since 2023-10-3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectKpiService  {

	@Autowired
	XmProjectKpiService xmProjectKpiService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("projectId","MYB8","branchId","Leoz","kpiIndex","NnZC","kpiName","v8G3","maxValue","HzGN","minValue","iV6C","id","EisM","score",155,"scoreDate",new Date("2023-10-03 4:17:27"),"bizFlowState","ALbA","bizProcInstId","AqQw","kpiValue","3iG5","remark","rYCo","calcType","b909","nextCalcDate",new Date("2023-10-03 4:17:27"));
		XmProjectKpi xmProjectKpi=BaseUtils.fromMap(p,XmProjectKpi.class);
		xmProjectKpiService.save(xmProjectKpi);
		//Assert.assertEquals(1, result);
	}
	 
}
