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
import  com.xm.core.service.XmProjectEnvListService;
import  com.xm.core.entity.XmProjectEnvList;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * @author code-gen
 * @since 2023-10-3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectEnvListService  {

	@Autowired
	XmProjectEnvListService xmProjectEnvListService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","0Bs7","remark","zMWO","ipAddress","SIGB","port","V0hs","projectId","zG1N","projectName","dO85","accessUserid","Gb8Z","accessPassword","2uFJ","effect","u7ZX","accessUrl","LU8S","webIpAddress","wJ6s","webPort","5Na9","otherRemark","3kd2","createUserid","S5Hp","createUsername","bMtJ","createTime",new Date("2023-10-03 4:17:27"),"bizProcInstId","HNCo","bizFlowState","A");
		XmProjectEnvList xmProjectEnvList=BaseUtils.fromMap(p,XmProjectEnvList.class);
		xmProjectEnvListService.save(xmProjectEnvList);
		//Assert.assertEquals(1, result);
	}
	 
}
