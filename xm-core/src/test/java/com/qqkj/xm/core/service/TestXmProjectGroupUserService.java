package  com.qqkj.xm.core.service;

import java.util.*;
import java.text.SimpleDateFormat;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.qqkj.mdp.core.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired; 
import  com.qqkj.xm.core.service.XmProjectGroupUserService; 
import com.qqkj.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import  com.qqkj.xm.core.entity.XmProjectGroupUser;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmProjectGroupUserService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_project_group_user xm_project_group_user<br>
 * 实体 XmProjectGroupUser<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	joinTime,id,groupId,userid,username,isHead,outTime,status,bizProcInstId,bizFlowState,projectId;<br>
 * 当前表的所有字段名:<br>
 *	join_time,id,group_id,userid,username,is_head,out_time,status,biz_proc_inst_id,biz_flow_state,project_id;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmProjectGroupUserService  {

	@Autowired
	XmProjectGroupUserService xmProjectGroupUserService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","CHFR","groupId","UAmB","userid","ZiPZ","username","IxVu","isHead","G","outTime",parse("2020-11-11 18:53:27"),"status","y","bizProcInstId","5AiW","bizFlowState","R","projectId","H6Ue");
		XmProjectGroupUser xmProjectGroupUser=BaseUtils.fromMap(p,XmProjectGroupUser.class);
		xmProjectGroupUserService.insert(xmProjectGroupUser);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"groupId","UAmB","userid","ZiPZ","username","IxVu","isHead","G","outTime",parse("2020-11-11 18:53:27"),"status","y","bizProcInstId","5AiW","bizFlowState","R","projectId","H6Ue");
		XmProjectGroupUser xmProjectGroupUser=BaseUtils.fromMap(p,XmProjectGroupUser.class);
		xmProjectGroupUserService.deleteByWhere(xmProjectGroupUser);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","CHFR");
		XmProjectGroupUser xmProjectGroupUser=BaseUtils.fromMap(p,XmProjectGroupUser.class);
		xmProjectGroupUserService.deleteByPk(xmProjectGroupUser);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"groupId","UAmB","userid","ZiPZ","username","IxVu","isHead","G","outTime",parse("2020-11-11 18:53:27"),"status","y","bizProcInstId","5AiW","bizFlowState","R","projectId","H6Ue");
		XmProjectGroupUser xmProjectGroupUser=BaseUtils.fromMap(where,XmProjectGroupUser.class);
		xmProjectGroupUserService.updateSomeFieldByPk(xmProjectGroupUser);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","CHFR");
		XmProjectGroupUser xmProjectGroupUser=BaseUtils.fromMap(p,XmProjectGroupUser.class);
		xmProjectGroupUserService.updateByPk(xmProjectGroupUser);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","CHFR","groupId","UAmB","userid","ZiPZ","username","IxVu","isHead","G","outTime",parse("2020-11-11 18:53:27"),"status","y","bizProcInstId","5AiW","bizFlowState","R","projectId","H6Ue");
		XmProjectGroupUser xmProjectGroupUser=BaseUtils.fromMap(p,XmProjectGroupUser.class);
		xmProjectGroupUserService.insertOrUpdate(xmProjectGroupUser);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmProjectGroupUser> batchValues=new ArrayList<XmProjectGroupUser>();
		Map p0=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","CHFR","groupId","UAmB","userid","ZiPZ","username","IxVu","isHead","G","outTime",parse("2020-11-11 18:53:27"),"status","y","bizProcInstId","5AiW","bizFlowState","R","projectId","H6Ue");
		XmProjectGroupUser xmProjectGroupUser0=BaseUtils.fromMap(p0,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser0);
		Map p1=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","6Gvt","groupId","6ZNZ","userid","scr3","username","WOE9","isHead","a","outTime",parse("2020-11-11 18:53:27"),"status","d","bizProcInstId","3CoW","bizFlowState","o","projectId","lBD7");
		XmProjectGroupUser xmProjectGroupUser1=BaseUtils.fromMap(p1,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser1);
		Map p2=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","AYf1","groupId","7c8j","userid","u6jq","username","g7LQ","isHead","3","outTime",parse("2020-11-11 18:53:27"),"status","5","bizProcInstId","X8vB","bizFlowState","n","projectId","M97Z");
		XmProjectGroupUser xmProjectGroupUser2=BaseUtils.fromMap(p2,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser2);
		Map p3=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","bAt8","groupId","vaB2","userid","eZWO","username","fjNg","isHead","m","outTime",parse("2020-11-11 18:53:27"),"status","4","bizProcInstId","MKe0","bizFlowState","C","projectId","RL6H");
		XmProjectGroupUser xmProjectGroupUser3=BaseUtils.fromMap(p3,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser3);
		Map p4=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","t3gs","groupId","ghR1","userid","vUK0","username","6x0i","isHead","e","outTime",parse("2020-11-11 18:53:27"),"status","F","bizProcInstId","O384","bizFlowState","C","projectId","UKHW");
		XmProjectGroupUser xmProjectGroupUser4=BaseUtils.fromMap(p4,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser4);
		Map p5=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","l94a","groupId","0D68","userid","iojg","username","qxfv","isHead","N","outTime",parse("2020-11-11 18:53:27"),"status","U","bizProcInstId","N0r8","bizFlowState","4","projectId","OOv9");
		XmProjectGroupUser xmProjectGroupUser5=BaseUtils.fromMap(p5,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser5);
		Map p6=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","Sfn4","groupId","mGw5","userid","o2uL","username","iCVO","isHead","d","outTime",parse("2020-11-11 18:53:27"),"status","m","bizProcInstId","dxgX","bizFlowState","t","projectId","2YSM");
		XmProjectGroupUser xmProjectGroupUser6=BaseUtils.fromMap(p6,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser6);
		Map p7=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","yOhx","groupId","nD3u","userid","Re62","username","4012","isHead","o","outTime",parse("2020-11-11 18:53:27"),"status","u","bizProcInstId","xdso","bizFlowState","m","projectId","AAGR");
		XmProjectGroupUser xmProjectGroupUser7=BaseUtils.fromMap(p7,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser7);
		xmProjectGroupUserService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmProjectGroupUser> batchValues=new ArrayList<XmProjectGroupUser>();
		Map p0=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","CHFR","groupId","UAmB","userid","ZiPZ","username","IxVu","isHead","G","outTime",parse("2020-11-11 18:53:27"),"status","y","bizProcInstId","5AiW","bizFlowState","R","projectId","H6Ue");
		XmProjectGroupUser xmProjectGroupUser0=BaseUtils.fromMap(p0,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser0);
		Map p1=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","6Gvt","groupId","6ZNZ","userid","scr3","username","WOE9","isHead","a","outTime",parse("2020-11-11 18:53:27"),"status","d","bizProcInstId","3CoW","bizFlowState","o","projectId","lBD7");
		XmProjectGroupUser xmProjectGroupUser1=BaseUtils.fromMap(p1,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser1);
		Map p2=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","AYf1","groupId","7c8j","userid","u6jq","username","g7LQ","isHead","3","outTime",parse("2020-11-11 18:53:27"),"status","5","bizProcInstId","X8vB","bizFlowState","n","projectId","M97Z");
		XmProjectGroupUser xmProjectGroupUser2=BaseUtils.fromMap(p2,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser2);
		Map p3=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","bAt8","groupId","vaB2","userid","eZWO","username","fjNg","isHead","m","outTime",parse("2020-11-11 18:53:27"),"status","4","bizProcInstId","MKe0","bizFlowState","C","projectId","RL6H");
		XmProjectGroupUser xmProjectGroupUser3=BaseUtils.fromMap(p3,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser3);
		Map p4=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","t3gs","groupId","ghR1","userid","vUK0","username","6x0i","isHead","e","outTime",parse("2020-11-11 18:53:27"),"status","F","bizProcInstId","O384","bizFlowState","C","projectId","UKHW");
		XmProjectGroupUser xmProjectGroupUser4=BaseUtils.fromMap(p4,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser4);
		Map p5=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","l94a","groupId","0D68","userid","iojg","username","qxfv","isHead","N","outTime",parse("2020-11-11 18:53:27"),"status","U","bizProcInstId","N0r8","bizFlowState","4","projectId","OOv9");
		XmProjectGroupUser xmProjectGroupUser5=BaseUtils.fromMap(p5,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser5);
		Map p6=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","Sfn4","groupId","mGw5","userid","o2uL","username","iCVO","isHead","d","outTime",parse("2020-11-11 18:53:27"),"status","m","bizProcInstId","dxgX","bizFlowState","t","projectId","2YSM");
		XmProjectGroupUser xmProjectGroupUser6=BaseUtils.fromMap(p6,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser6);
		Map p7=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","yOhx","groupId","nD3u","userid","Re62","username","4012","isHead","o","outTime",parse("2020-11-11 18:53:27"),"status","u","bizProcInstId","xdso","bizFlowState","m","projectId","AAGR");
		XmProjectGroupUser xmProjectGroupUser7=BaseUtils.fromMap(p7,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser7);
		xmProjectGroupUserService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmProjectGroupUser> batchValues=new ArrayList<XmProjectGroupUser>();
		Map p0=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","CHFR","groupId","UAmB","userid","ZiPZ","username","IxVu","isHead","G","outTime",parse("2020-11-11 18:53:27"),"status","y","bizProcInstId","5AiW","bizFlowState","R","projectId","H6Ue");
		XmProjectGroupUser xmProjectGroupUser0=BaseUtils.fromMap(p0,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser0);
		Map p1=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","6Gvt","groupId","6ZNZ","userid","scr3","username","WOE9","isHead","a","outTime",parse("2020-11-11 18:53:27"),"status","d","bizProcInstId","3CoW","bizFlowState","o","projectId","lBD7");
		XmProjectGroupUser xmProjectGroupUser1=BaseUtils.fromMap(p1,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser1);
		Map p2=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","AYf1","groupId","7c8j","userid","u6jq","username","g7LQ","isHead","3","outTime",parse("2020-11-11 18:53:27"),"status","5","bizProcInstId","X8vB","bizFlowState","n","projectId","M97Z");
		XmProjectGroupUser xmProjectGroupUser2=BaseUtils.fromMap(p2,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser2);
		Map p3=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","bAt8","groupId","vaB2","userid","eZWO","username","fjNg","isHead","m","outTime",parse("2020-11-11 18:53:27"),"status","4","bizProcInstId","MKe0","bizFlowState","C","projectId","RL6H");
		XmProjectGroupUser xmProjectGroupUser3=BaseUtils.fromMap(p3,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser3);
		Map p4=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","t3gs","groupId","ghR1","userid","vUK0","username","6x0i","isHead","e","outTime",parse("2020-11-11 18:53:27"),"status","F","bizProcInstId","O384","bizFlowState","C","projectId","UKHW");
		XmProjectGroupUser xmProjectGroupUser4=BaseUtils.fromMap(p4,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser4);
		Map p5=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","l94a","groupId","0D68","userid","iojg","username","qxfv","isHead","N","outTime",parse("2020-11-11 18:53:27"),"status","U","bizProcInstId","N0r8","bizFlowState","4","projectId","OOv9");
		XmProjectGroupUser xmProjectGroupUser5=BaseUtils.fromMap(p5,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser5);
		Map p6=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","Sfn4","groupId","mGw5","userid","o2uL","username","iCVO","isHead","d","outTime",parse("2020-11-11 18:53:27"),"status","m","bizProcInstId","dxgX","bizFlowState","t","projectId","2YSM");
		XmProjectGroupUser xmProjectGroupUser6=BaseUtils.fromMap(p6,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser6);
		Map p7=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"id","yOhx","groupId","nD3u","userid","Re62","username","4012","isHead","o","outTime",parse("2020-11-11 18:53:27"),"status","u","bizProcInstId","xdso","bizFlowState","m","projectId","AAGR");
		XmProjectGroupUser xmProjectGroupUser7=BaseUtils.fromMap(p7,XmProjectGroupUser.class);
		batchValues.add(xmProjectGroupUser7);
		xmProjectGroupUserService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","CHFR");
		Map<String,Object> result=this.xmProjectGroupUserService.selectOne(XmProjectGroupUser.class.getName()+".selectOneMap",p);
		Assert.assertEquals("CHFR", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"groupId","UAmB","userid","ZiPZ","username","IxVu","isHead","G","outTime",parse("2020-11-11 18:53:27"),"status","y","bizProcInstId","5AiW","bizFlowState","R","projectId","H6Ue");
		XmProjectGroupUser xmProjectGroupUser=BaseUtils.fromMap(p,XmProjectGroupUser.class);
		long result=xmProjectGroupUserService.countByWhere(xmProjectGroupUser);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"groupId","UAmB","userid","ZiPZ","username","IxVu","isHead","G","outTime",parse("2020-11-11 18:53:27"),"status","y","bizProcInstId","5AiW","bizFlowState","R","projectId","H6Ue");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmProjectGroupUser xmProjectGroupUser=BaseUtils.fromMap(p,XmProjectGroupUser.class);
		List<XmProjectGroupUser> result=xmProjectGroupUserService.selectListByWhere(xmProjectGroupUser); 
		if(result instanceof Page) {
			Page page=(Page)result;   
			Assert.assertEquals(true, page.getTotal()>=0);
		}
	}
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByWhere() {
	
		
		Map<String,Object> p=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"groupId","UAmB","userid","ZiPZ","username","IxVu","isHead","G","outTime",parse("2020-11-11 18:53:27"),"status","y","bizProcInstId","5AiW","bizFlowState","R","projectId","H6Ue");
		XmProjectGroupUser xmProjectGroupUser=BaseUtils.fromMap(p,XmProjectGroupUser.class);
		List<XmProjectGroupUser> result=xmProjectGroupUserService.selectListByWhere(xmProjectGroupUser);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"groupId","UAmB","userid","ZiPZ","username","IxVu","isHead","G","outTime",parse("2020-11-11 18:53:27"),"status","y","bizProcInstId","5AiW","bizFlowState","R","projectId","H6Ue");
		List<Map<String,Object>> result=xmProjectGroupUserService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("joinTime",parse("2020-11-11 18:53:27"),"groupId","UAmB","userid","ZiPZ","username","IxVu","isHead","G","outTime",parse("2020-11-11 18:53:27"),"status","y","bizProcInstId","5AiW","bizFlowState","R","projectId","H6Ue");
		List<Map<String,Object>> result=xmProjectGroupUserService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmProjectGroupUser
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","CHFR");
		
		XmProjectGroupUser xmProjectGroupUser1=BaseUtils.fromMap(p,XmProjectGroupUser.class);
		XmProjectGroupUser xmProjectGroupUser=xmProjectGroupUserService.selectOneObject(xmProjectGroupUser1);
		Assert.assertEquals("CHFR", xmProjectGroupUser.getId());
	}

	/**
	 * 将字符串类型的日期转成Date对象
	 * @param source 如2015-10-23或者 2015-10-23 15:30:25等
	 * @param pattern 格式必须与 source的格式一致，如 2015-10-23对应的 pattern为 yyyy-MM-dd, <br>
	 *        2015-10-23 15:30:25 对应的pattern 为 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date parse(String source){
		 
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			try {
				return sdf.parse(source);
			} catch (Exception e) {
			}   
		
		return null;
	}
}
