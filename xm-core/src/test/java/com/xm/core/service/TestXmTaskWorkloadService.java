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
import  com.xm.core.service.XmTaskWorkloadService;
import  com.xm.core.entity.XmTaskWorkload;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * @author code-gen
 * @since 2023-10-3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmTaskWorkloadService  {

	@Autowired
	XmTaskWorkloadService xmTaskWorkloadService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("userid","7k10","username","S6BU","ctime",new Date("2023-10-03 4:17:30"),"taskId","39Y2","cuserid","5x3D","bizDate","x519","wstatus","6","remark","T004","ttype","Vz21","id","pQuQ","stime",new Date("2023-10-03 4:17:30"),"sstatus","4","workload",1131.99,"rworkload",3945.39,"cusername","iR4u","projectId","WnLi","branchId","wBMj","ubranchId","5NwO","sbillId","0Dbd","detailId","SlWH","menuId","OFIs","productId","Bc6z","caseId","hKdt","planId","P7Sy","bugId","l4Sz","bizType","6");
		XmTaskWorkload xmTaskWorkload=BaseUtils.fromMap(p,XmTaskWorkload.class);
		xmTaskWorkloadService.save(xmTaskWorkload);
		//Assert.assertEquals(1, result);
	}
	 
}
