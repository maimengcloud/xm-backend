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
import  com.xm.core.service.XmProjectKpiHisService;
import  com.xm.core.entity.XmProjectKpiHis;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * @author code-gen
 * @since 2023-10-3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectKpiHisService  {

	@Autowired
	XmProjectKpiHisService xmProjectKpiHisService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("projectId","RJPG","branchId","R8Zc","kpiIndex","4tv0","kpiName","8xmJ","maxValue","j4bV","minValue","b2h8","kpiId","N8Aa","score",1997,"scoreDate",new Date("2023-10-03 4:17:27"),"bizFlowState","C8Pv","bizProcInstId","24m2","kpiValue","d5MK","cdate",new Date("2023-10-03 4:17:27"),"id","wf3V","remark","lN29","calcType","Zkzd","nextCalcDate",new Date("2023-10-03 4:17:27"));
		XmProjectKpiHis xmProjectKpiHis=BaseUtils.fromMap(p,XmProjectKpiHis.class);
		xmProjectKpiHisService.save(xmProjectKpiHis);
		//Assert.assertEquals(1, result);
	}
	 
}
