package  com.xm.share.service;

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
import  com.xm.share.service.ShareBizInfoService; 
import com.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import  com.xm.share.entity.ShareBizInfo;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * ShareBizInfoService的测试案例
 * 组织 com<br>
 * 顶级模块 xm<br>
 * 大模块 share<br>
 * 小模块 <br>
 * 表 XM.xm_share_biz_info 分享行为记录表<br>
 * 实体 ShareBizInfo<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	shareKey,shareUserid,shareUsername,pageUrl,pageType,shareTime,bizPkId,bizBranchId,shareBranchId,bizSubPkId,params,shareType,pshareKey,pshareUserid,pshareUsername,bizType,bizCategoryId;<br>
 * 当前表的所有字段名:<br>
 *	share_key,share_userid,share_username,page_url,page_type,share_time,biz_pk_id,biz_branch_id,share_branch_id,biz_sub_pk_id,params,share_type,pshare_key,pshare_userid,pshare_username,biz_type,biz_category_id;<br>
 * 当前主键(包括多主键):<br>
 *	share_key;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestShareBizInfoService  {

	@Autowired
	ShareBizInfoService shareBizInfoService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("shareKey","9303","shareUserid","zZoc","shareUsername","V9tr","pageUrl","wBF3","pageType","ylHj","shareTime",new Date("2021-04-22 17:12:53"),"bizPkId","c6DC","bizBranchId","5HjB","shareBranchId","0aSc","bizSubPkId","5ps3","params","b175","shareType","q0Jh","pshareKey","it9W","pshareUserid","IaYJ","pshareUsername","GGIz","bizType","9Uqr","bizCategoryId","FL8C");
		ShareBizInfo shareBizInfo=BaseUtils.fromMap(p,ShareBizInfo.class);
		shareBizInfoService.insert(shareBizInfo);
		//Assert.assertEquals(1, result);
	}
	 
}
