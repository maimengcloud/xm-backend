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
import  com.xm.core.service.XmMenuCommentService;
import  com.xm.core.entity.XmMenuComment;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * @author code-gen
 * @since 2023-10-3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmMenuCommentService  {

	@Autowired
	XmMenuCommentService xmMenuCommentService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","4Ws2","userid","vkTj","username","pNR5","star","9","cdate",new Date("2023-10-03 4:17:25"),"menuId","qYV0","pid","zOpZ","ups",7581,"isShow","d","toUserid","Gv32","toUsername","w20V","lvl","6","context","ycNd","branchId","v1Vl","ip","AZg5","cityId","j1Ik","cityName","kA79","status","U","childNums",7949);
		XmMenuComment xmMenuComment=BaseUtils.fromMap(p,XmMenuComment.class);
		xmMenuCommentService.save(xmMenuComment);
		//Assert.assertEquals(1, result);
	}
	 
}
