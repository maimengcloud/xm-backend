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
import  com.xm.core.service.XmTaskService;
import  com.xm.core.entity.XmTask;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * @author code-gen
 * @since 2023-10-3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmTaskService  {

	@Autowired
	XmTaskService xmTaskService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","3A6S","name","SlbY","parentTaskid","Ij54","parentTaskname","3AyX","projectId","8dDB","projectName","syvI","level","sc7W","sortLevel","KO4X","executorUserid","VbS3","executorUsername","dQ8Y","preTaskid","B7x3","preTaskname","XO1r","startTime",new Date("2023-10-03 4:17:29"),"endTime",new Date("2023-10-03 4:17:29"),"milestone","OpEc","description","L920","remarks","I04Z","createUserid","1icl","createUsername","iI87","createTime",new Date("2023-10-03 4:17:29"),"rate",3184,"budgetAt",7666.7,"budgetWorkload",17.61,"actAt",8016.38,"actWorkload",624.82,"taskState","t","taskType","7L51","taskClass","v","toTaskCenter","n","actStartTime",new Date("2023-10-03 4:17:29"),"actEndTime",new Date("2023-10-03 4:17:29"),"bizProcInstId","i9b0","bizFlowState","W","phaseId","aTRf","phaseName","lThZ","taskSkillNames","FQDP","exeUsernames","P571","taskSkillIds","56aQ","exeUserids","st4n","taskOut","A","planType","rx7h","settleSchemel","FskP","menuId","W1MO","menuName","s24O","productId","CO85","cbranchId","U4e8","cdeptid","1WSJ","tagIds","3h6m","tagNames","h9HT","ntype","I","childrenCnt",3631,"ltime",new Date("2023-10-03 4:17:29"),"pidPaths","ubCt","lvl",3261,"isTpl","J","keyPath","4","uniInnerPrice",9066.73,"uniOutPrice",2740.38,"calcType","Y","ptype","Q","wtype","6","bctrl","y","initWorkload",1586.31,"shareFee",6705,"oshare","3","crowd","l","browseUsers",7938,"execUsers",6738,"cityId","07Lb","cityName","rDpG","regionType","0","browseTimes",3564,"capaLvls","ORcM","tranMode","y","supRequires","CiLg","hot","3","top","I","urgent","U","crmSup","3","bidStep","1","interestLvls","hXdJ","filePaths","51me","estate","B","efunds",6347.4753,"etoPlatTime",new Date("2023-10-03 4:17:29"),"etoDevTime",new Date("2023-10-03 4:17:29"),"ebackTime",new Date("2023-10-03 4:17:29"),"topStime",new Date("2023-10-03 4:17:29"),"topEtime",new Date("2023-10-03 4:17:29"),"hotStime",new Date("2023-10-03 4:17:29"),"hotEtime",new Date("2023-10-03 4:17:29"),"urgentStime",new Date("2023-10-03 4:17:29"),"urgentEtime",new Date("2023-10-03 4:17:29"),"quoteFinalAt",6096.56,"provinceId","3QaN","provinceName","J4qa","areaId","rd0k","areaName","J41z","status","O","bidEtime",new Date("2023-10-03 4:17:29"),"serviceId","tWnf","creditId","joWh","pbranchId","9Lng");
		XmTask xmTask=BaseUtils.fromMap(p,XmTask.class);
		xmTaskService.save(xmTask);
		//Assert.assertEquals(1, result);
	}
	 
}
