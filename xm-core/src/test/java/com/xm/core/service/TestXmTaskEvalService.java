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
import  com.xm.core.service.XmTaskEvalService;
import  com.xm.core.entity.XmTaskEval;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * @author code-gen
 * @since 2023-10-3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmTaskEvalService  {

	@Autowired
	XmTaskEvalService xmTaskEvalService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","iAKL","type","j","wspeed",4534,"wattit",6332,"wquality",3545,"totalStar",326,"remark","e1xF","evalUserid","gtp0","evalUsername","qCMR","toUserid","TDe8","toUsername","53Hv","evalBranchId","57T5","toBranchId","l1OK","taskId","z8a1","evalTime",new Date("2023-10-03 4:17:29"),"paySpeed",5328,"coopHappy",5479);
		XmTaskEval xmTaskEval=BaseUtils.fromMap(p,XmTaskEval.class);
		xmTaskEvalService.save(xmTaskEval);
		//Assert.assertEquals(1, result);
	}
	 
}
