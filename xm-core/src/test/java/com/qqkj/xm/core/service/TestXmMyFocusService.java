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
import  com.qqkj.xm.core.service.XmMyFocusService; 
import com.qqkj.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import  com.qqkj.xm.core.entity.XmMyFocus;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmMyFocusService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_my_focus xm_my_focus<br>
 * 实体 XmMyFocus<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	userid,username,taskId,focusType,projectId,id,projectName,taskName;<br>
 * 当前表的所有字段名:<br>
 *	userid,username,task_id,focus_type,project_id,id,project_name,task_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmMyFocusService  {

	@Autowired
	XmMyFocusService xmMyFocusService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("userid","NCtn","username","tIfz","taskId","6kzC","focusType","4kuo","projectId","qWJ1","id","7zYR","projectName","wKvC","taskName","Vjqg");
		XmMyFocus xmMyFocus=BaseUtils.fromMap(p,XmMyFocus.class);
		xmMyFocusService.insert(xmMyFocus);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("userid","NCtn","username","tIfz","taskId","6kzC","focusType","4kuo","projectId","qWJ1","projectName","wKvC","taskName","Vjqg");
		XmMyFocus xmMyFocus=BaseUtils.fromMap(p,XmMyFocus.class);
		xmMyFocusService.deleteByWhere(xmMyFocus);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","7zYR");
		XmMyFocus xmMyFocus=BaseUtils.fromMap(p,XmMyFocus.class);
		xmMyFocusService.deleteByPk(xmMyFocus);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("userid","NCtn","username","tIfz","taskId","6kzC","focusType","4kuo","projectId","qWJ1","projectName","wKvC","taskName","Vjqg");
		XmMyFocus xmMyFocus=BaseUtils.fromMap(where,XmMyFocus.class);
		xmMyFocusService.updateSomeFieldByPk(xmMyFocus);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","7zYR");
		XmMyFocus xmMyFocus=BaseUtils.fromMap(p,XmMyFocus.class);
		xmMyFocusService.updateByPk(xmMyFocus);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("userid","NCtn","username","tIfz","taskId","6kzC","focusType","4kuo","projectId","qWJ1","id","7zYR","projectName","wKvC","taskName","Vjqg");
		XmMyFocus xmMyFocus=BaseUtils.fromMap(p,XmMyFocus.class);
		xmMyFocusService.insertOrUpdate(xmMyFocus);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmMyFocus> batchValues=new ArrayList<XmMyFocus>();
		Map p0=BaseUtils.map("userid","NCtn","username","tIfz","taskId","6kzC","focusType","4kuo","projectId","qWJ1","id","7zYR","projectName","wKvC","taskName","Vjqg");
		XmMyFocus xmMyFocus0=BaseUtils.fromMap(p0,XmMyFocus.class);
		batchValues.add(xmMyFocus0);
		Map p1=BaseUtils.map("userid","oam2","username","hKic","taskId","I0o1","focusType","rqzU","projectId","2oN4","id","Cp3I","projectName","TBOT","taskName","G23j");
		XmMyFocus xmMyFocus1=BaseUtils.fromMap(p1,XmMyFocus.class);
		batchValues.add(xmMyFocus1);
		Map p2=BaseUtils.map("userid","w8Z4","username","7467","taskId","wWyW","focusType","Q1M4","projectId","JxSX","id","ZZIZ","projectName","j4Hg","taskName","ESSK");
		XmMyFocus xmMyFocus2=BaseUtils.fromMap(p2,XmMyFocus.class);
		batchValues.add(xmMyFocus2);
		Map p3=BaseUtils.map("userid","2iN0","username","Hs58","taskId","t25a","focusType","K6Us","projectId","dm1E","id","Sz20","projectName","Fygl","taskName","Rlwx");
		XmMyFocus xmMyFocus3=BaseUtils.fromMap(p3,XmMyFocus.class);
		batchValues.add(xmMyFocus3);
		Map p4=BaseUtils.map("userid","HIL5","username","yKQp","taskId","uz2P","focusType","TeLJ","projectId","b2Ts","id","46Jj","projectName","dJ38","taskName","N0Zr");
		XmMyFocus xmMyFocus4=BaseUtils.fromMap(p4,XmMyFocus.class);
		batchValues.add(xmMyFocus4);
		Map p5=BaseUtils.map("userid","IrRu","username","zYn3","taskId","J7Wm","focusType","0Kv8","projectId","2crV","id","z2Nl","projectName","58r4","taskName","4GF6");
		XmMyFocus xmMyFocus5=BaseUtils.fromMap(p5,XmMyFocus.class);
		batchValues.add(xmMyFocus5);
		Map p6=BaseUtils.map("userid","Ony0","username","BmKb","taskId","4567","focusType","JAbu","projectId","601N","id","rn3b","projectName","r4gk","taskName","0KD7");
		XmMyFocus xmMyFocus6=BaseUtils.fromMap(p6,XmMyFocus.class);
		batchValues.add(xmMyFocus6);
		Map p7=BaseUtils.map("userid","I0VM","username","qBFh","taskId","3qKc","focusType","Hl9O","projectId","njz8","id","FZyK","projectName","C5yO","taskName","l2g3");
		XmMyFocus xmMyFocus7=BaseUtils.fromMap(p7,XmMyFocus.class);
		batchValues.add(xmMyFocus7);
		xmMyFocusService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmMyFocus> batchValues=new ArrayList<XmMyFocus>();
		Map p0=BaseUtils.map("userid","NCtn","username","tIfz","taskId","6kzC","focusType","4kuo","projectId","qWJ1","id","7zYR","projectName","wKvC","taskName","Vjqg");
		XmMyFocus xmMyFocus0=BaseUtils.fromMap(p0,XmMyFocus.class);
		batchValues.add(xmMyFocus0);
		Map p1=BaseUtils.map("userid","oam2","username","hKic","taskId","I0o1","focusType","rqzU","projectId","2oN4","id","Cp3I","projectName","TBOT","taskName","G23j");
		XmMyFocus xmMyFocus1=BaseUtils.fromMap(p1,XmMyFocus.class);
		batchValues.add(xmMyFocus1);
		Map p2=BaseUtils.map("userid","w8Z4","username","7467","taskId","wWyW","focusType","Q1M4","projectId","JxSX","id","ZZIZ","projectName","j4Hg","taskName","ESSK");
		XmMyFocus xmMyFocus2=BaseUtils.fromMap(p2,XmMyFocus.class);
		batchValues.add(xmMyFocus2);
		Map p3=BaseUtils.map("userid","2iN0","username","Hs58","taskId","t25a","focusType","K6Us","projectId","dm1E","id","Sz20","projectName","Fygl","taskName","Rlwx");
		XmMyFocus xmMyFocus3=BaseUtils.fromMap(p3,XmMyFocus.class);
		batchValues.add(xmMyFocus3);
		Map p4=BaseUtils.map("userid","HIL5","username","yKQp","taskId","uz2P","focusType","TeLJ","projectId","b2Ts","id","46Jj","projectName","dJ38","taskName","N0Zr");
		XmMyFocus xmMyFocus4=BaseUtils.fromMap(p4,XmMyFocus.class);
		batchValues.add(xmMyFocus4);
		Map p5=BaseUtils.map("userid","IrRu","username","zYn3","taskId","J7Wm","focusType","0Kv8","projectId","2crV","id","z2Nl","projectName","58r4","taskName","4GF6");
		XmMyFocus xmMyFocus5=BaseUtils.fromMap(p5,XmMyFocus.class);
		batchValues.add(xmMyFocus5);
		Map p6=BaseUtils.map("userid","Ony0","username","BmKb","taskId","4567","focusType","JAbu","projectId","601N","id","rn3b","projectName","r4gk","taskName","0KD7");
		XmMyFocus xmMyFocus6=BaseUtils.fromMap(p6,XmMyFocus.class);
		batchValues.add(xmMyFocus6);
		Map p7=BaseUtils.map("userid","I0VM","username","qBFh","taskId","3qKc","focusType","Hl9O","projectId","njz8","id","FZyK","projectName","C5yO","taskName","l2g3");
		XmMyFocus xmMyFocus7=BaseUtils.fromMap(p7,XmMyFocus.class);
		batchValues.add(xmMyFocus7);
		xmMyFocusService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmMyFocus> batchValues=new ArrayList<XmMyFocus>();
		Map p0=BaseUtils.map("userid","NCtn","username","tIfz","taskId","6kzC","focusType","4kuo","projectId","qWJ1","id","7zYR","projectName","wKvC","taskName","Vjqg");
		XmMyFocus xmMyFocus0=BaseUtils.fromMap(p0,XmMyFocus.class);
		batchValues.add(xmMyFocus0);
		Map p1=BaseUtils.map("userid","oam2","username","hKic","taskId","I0o1","focusType","rqzU","projectId","2oN4","id","Cp3I","projectName","TBOT","taskName","G23j");
		XmMyFocus xmMyFocus1=BaseUtils.fromMap(p1,XmMyFocus.class);
		batchValues.add(xmMyFocus1);
		Map p2=BaseUtils.map("userid","w8Z4","username","7467","taskId","wWyW","focusType","Q1M4","projectId","JxSX","id","ZZIZ","projectName","j4Hg","taskName","ESSK");
		XmMyFocus xmMyFocus2=BaseUtils.fromMap(p2,XmMyFocus.class);
		batchValues.add(xmMyFocus2);
		Map p3=BaseUtils.map("userid","2iN0","username","Hs58","taskId","t25a","focusType","K6Us","projectId","dm1E","id","Sz20","projectName","Fygl","taskName","Rlwx");
		XmMyFocus xmMyFocus3=BaseUtils.fromMap(p3,XmMyFocus.class);
		batchValues.add(xmMyFocus3);
		Map p4=BaseUtils.map("userid","HIL5","username","yKQp","taskId","uz2P","focusType","TeLJ","projectId","b2Ts","id","46Jj","projectName","dJ38","taskName","N0Zr");
		XmMyFocus xmMyFocus4=BaseUtils.fromMap(p4,XmMyFocus.class);
		batchValues.add(xmMyFocus4);
		Map p5=BaseUtils.map("userid","IrRu","username","zYn3","taskId","J7Wm","focusType","0Kv8","projectId","2crV","id","z2Nl","projectName","58r4","taskName","4GF6");
		XmMyFocus xmMyFocus5=BaseUtils.fromMap(p5,XmMyFocus.class);
		batchValues.add(xmMyFocus5);
		Map p6=BaseUtils.map("userid","Ony0","username","BmKb","taskId","4567","focusType","JAbu","projectId","601N","id","rn3b","projectName","r4gk","taskName","0KD7");
		XmMyFocus xmMyFocus6=BaseUtils.fromMap(p6,XmMyFocus.class);
		batchValues.add(xmMyFocus6);
		Map p7=BaseUtils.map("userid","I0VM","username","qBFh","taskId","3qKc","focusType","Hl9O","projectId","njz8","id","FZyK","projectName","C5yO","taskName","l2g3");
		XmMyFocus xmMyFocus7=BaseUtils.fromMap(p7,XmMyFocus.class);
		batchValues.add(xmMyFocus7);
		xmMyFocusService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","7zYR");
		Map<String,Object> result=this.xmMyFocusService.selectOne(XmMyFocus.class.getName()+".selectOneMap",p);
		Assert.assertEquals("7zYR", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("userid","NCtn","username","tIfz","taskId","6kzC","focusType","4kuo","projectId","qWJ1","projectName","wKvC","taskName","Vjqg");
		XmMyFocus xmMyFocus=BaseUtils.fromMap(p,XmMyFocus.class);
		long result=xmMyFocusService.countByWhere(xmMyFocus);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("userid","NCtn","username","tIfz","taskId","6kzC","focusType","4kuo","projectId","qWJ1","projectName","wKvC","taskName","Vjqg");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmMyFocus xmMyFocus=BaseUtils.fromMap(p,XmMyFocus.class);
		List<XmMyFocus> result=xmMyFocusService.selectListByWhere(xmMyFocus); 
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
	
		
		Map<String,Object> p=BaseUtils.map("userid","NCtn","username","tIfz","taskId","6kzC","focusType","4kuo","projectId","qWJ1","projectName","wKvC","taskName","Vjqg");
		XmMyFocus xmMyFocus=BaseUtils.fromMap(p,XmMyFocus.class);
		List<XmMyFocus> result=xmMyFocusService.selectListByWhere(xmMyFocus);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("userid","NCtn","username","tIfz","taskId","6kzC","focusType","4kuo","projectId","qWJ1","projectName","wKvC","taskName","Vjqg");
		List<Map<String,Object>> result=xmMyFocusService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("userid","NCtn","username","tIfz","taskId","6kzC","focusType","4kuo","projectId","qWJ1","projectName","wKvC","taskName","Vjqg");
		List<Map<String,Object>> result=xmMyFocusService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmMyFocus
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","7zYR");
		
		XmMyFocus xmMyFocus1=BaseUtils.fromMap(p,XmMyFocus.class);
		XmMyFocus xmMyFocus=xmMyFocusService.selectOneObject(xmMyFocus1);
		Assert.assertEquals("7zYR", xmMyFocus.getId());
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
