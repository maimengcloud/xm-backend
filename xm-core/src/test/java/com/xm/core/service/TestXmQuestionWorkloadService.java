package  com.xm.core.service;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.mdp.core.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * @author code-gen
 * @since 2023-10-3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmQuestionWorkloadService  {

	@Autowired
	XmQuestionWorkloadService xmQuestionWorkloadService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("userid","XGRb","username","jlKn","ctime",new Date("2023-10-03 4:17:28"),"bugId","h983","cuserid","","bizDate","wlIs","wstatus","v","remark","367b","ttype","F","id",6088,"sbillId","m4eW","stime",new Date("2023-10-03 4:17:28"),"sstatus","i","amt",6612.85,"samt",6616,"workload",459.03,"projectId","oaRb");
		XmQuestionWorkload xmQuestionWorkload=BaseUtils.fromMap(p,XmQuestionWorkload.class);
		xmQuestionWorkloadService.save(xmQuestionWorkload);
		//Assert.assertEquals(1, result);
	}
	 
}
