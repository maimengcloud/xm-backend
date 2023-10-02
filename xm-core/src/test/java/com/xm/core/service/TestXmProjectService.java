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
import  com.xm.core.service.XmProjectService;
import  com.xm.core.entity.XmProject;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * @author code-gen
 * @since 2023-10-3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectService  {

	@Autowired
	XmProjectService xmProjectService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","jWFZ","code","lkT1","name","C6QF","xmType","HJcr","startTime",new Date("2023-10-03 4:17:27"),"endTime",new Date("2023-10-03 4:17:27"),"urgent","bZys","priority","j5Q4","description","4j38","createUserid","5Y57","createUsername","6Tiu","createTime",new Date("2023-10-03 4:17:27"),"assess","rCVE","assessRemarks","siVt","status","vWGR","branchId","fxGK","planTotalCost",5748.24,"bizProcInstId","9wYB","bizFlowState","f","planNouserAt",5815.64,"planIuserAt",1197.5,"planOuserAt",5978.6,"locked","a","baseTime",new Date("2023-10-03 4:17:27"),"baseRemark","t8jN","baselineId","8RMY","planWorkload",4145.19,"totalReceivables",5771.78,"budgetMarginRate",1494.92,"contractAmt",1752.18,"planIuserPrice",7191.82,"planOuserPrice",6079.8,"planOuserCnt",3568,"planIuserCnt",3134,"planWorkingHours",7772,"taxRate",4882.08,"planIuserWorkload",5932.43,"planOuserWorkload",1286.76,"fromTplId","cg0z","budgetCtrl","1","deptid","s3D7","showOut","i","isTpl","B","pmUserid","KVHQ","pmUsername","kYAd","assUserid","NCPV","assUsername","satD","admUserid","ZF1l","admUsername","0TeX","budgetEarly","E","phaseActCtrl","H","del","K","ltime",new Date("2023-10-03 4:17:27"),"ostatus","8","workType","cOV8","wtype","7","earlyAmt",8497.65,"maxTaskAmt",4941.96,"menuLink","d","phaseLink","R","tplType","v","qxCode","rZD6");
		XmProject xmProject=BaseUtils.fromMap(p,XmProject.class);
		xmProjectService.save(xmProject);
		//Assert.assertEquals(1, result);
	}
	 
}
