package com.xm.core.service;

import java.util.*;
import java.text.SimpleDateFormat;

import com.xm.core.entity.XmTestCaseExec;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.mdp.core.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmTestCaseExecService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_test_case_exec xm_test_case_exec<br>
 * 实体 XmTestCaseExec<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	execUserid,startTime,id,projectId,projectName,caseId,caseName,endTime,remark,createUserid,createUsername,createTime,execStatus,iterationId,iterationName,execUsername,taskId,taskName,menuId,menuName;<br>
 * 当前表的所有字段名:<br>
 *	exec_userid,start_time,id,project_id,project_name,case_id,case_name,end_time,remark,create_userid,create_username,create_time,exec_status,iteration_id,iteration_name,exec_username,task_id,task_name,menu_id,menu_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmTestCaseExecService  {

	@Autowired
	XmTestCaseExecService xmTestCaseExecService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("execUserid","vQXx","startTime",parse("2020-11-13 2:28:31"),"id","IMeb","projectId","eyLs","projectName","omUL","caseId","Pmaa","caseName","b9qi","endTime",parse("2020-11-13 2:28:31"),"remark","Ns5O","createUserid","YHU7","createUsername","hueb","createTime",parse("2020-11-13 2:28:31"),"execStatus","D","iterationId","Z0mT","iterationName","Pn9M","execUsername","f1ob","taskId","aJhV","taskName","KgQF","menuId","2o3l","menuName","yFwY");
		XmTestCaseExec xmTestCaseExec=BaseUtils.fromMap(p,XmTestCaseExec.class);
		xmTestCaseExecService.insert(xmTestCaseExec);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("execUserid","vQXx","startTime",parse("2020-11-13 2:28:31"),"projectId","eyLs","projectName","omUL","caseId","Pmaa","caseName","b9qi","endTime",parse("2020-11-13 2:28:31"),"remark","Ns5O","createUserid","YHU7","createUsername","hueb","createTime",parse("2020-11-13 2:28:31"),"execStatus","D","iterationId","Z0mT","iterationName","Pn9M","execUsername","f1ob","taskId","aJhV","taskName","KgQF","menuId","2o3l","menuName","yFwY");
		XmTestCaseExec xmTestCaseExec=BaseUtils.fromMap(p,XmTestCaseExec.class);
		xmTestCaseExecService.deleteByWhere(xmTestCaseExec);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","IMeb");
		XmTestCaseExec xmTestCaseExec=BaseUtils.fromMap(p,XmTestCaseExec.class);
		xmTestCaseExecService.deleteByPk(xmTestCaseExec);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("execUserid","vQXx","startTime",parse("2020-11-13 2:28:31"),"projectId","eyLs","projectName","omUL","caseId","Pmaa","caseName","b9qi","endTime",parse("2020-11-13 2:28:31"),"remark","Ns5O","createUserid","YHU7","createUsername","hueb","createTime",parse("2020-11-13 2:28:31"),"execStatus","D","iterationId","Z0mT","iterationName","Pn9M","execUsername","f1ob","taskId","aJhV","taskName","KgQF","menuId","2o3l","menuName","yFwY");
		XmTestCaseExec xmTestCaseExec=BaseUtils.fromMap(where,XmTestCaseExec.class);
		xmTestCaseExecService.updateSomeFieldByPk(xmTestCaseExec);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","IMeb");
		XmTestCaseExec xmTestCaseExec=BaseUtils.fromMap(p,XmTestCaseExec.class);
		xmTestCaseExecService.updateByPk(xmTestCaseExec);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("execUserid","vQXx","startTime",parse("2020-11-13 2:28:31"),"id","IMeb","projectId","eyLs","projectName","omUL","caseId","Pmaa","caseName","b9qi","endTime",parse("2020-11-13 2:28:31"),"remark","Ns5O","createUserid","YHU7","createUsername","hueb","createTime",parse("2020-11-13 2:28:31"),"execStatus","D","iterationId","Z0mT","iterationName","Pn9M","execUsername","f1ob","taskId","aJhV","taskName","KgQF","menuId","2o3l","menuName","yFwY");
		XmTestCaseExec xmTestCaseExec=BaseUtils.fromMap(p,XmTestCaseExec.class);
		xmTestCaseExecService.insertOrUpdate(xmTestCaseExec);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmTestCaseExec> batchValues=new ArrayList<XmTestCaseExec>();
		Map p0=BaseUtils.map("execUserid","vQXx","startTime",parse("2020-11-13 2:28:31"),"id","IMeb","projectId","eyLs","projectName","omUL","caseId","Pmaa","caseName","b9qi","endTime",parse("2020-11-13 2:28:31"),"remark","Ns5O","createUserid","YHU7","createUsername","hueb","createTime",parse("2020-11-13 2:28:31"),"execStatus","D","iterationId","Z0mT","iterationName","Pn9M","execUsername","f1ob","taskId","aJhV","taskName","KgQF","menuId","2o3l","menuName","yFwY");
		XmTestCaseExec xmTestCaseExec0=BaseUtils.fromMap(p0,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec0);
		Map p1=BaseUtils.map("execUserid","X2D9","startTime",parse("2020-11-13 2:28:31"),"id","E258","projectId","AWeN","projectName","apbP","caseId","nX38","caseName","MY4D","endTime",parse("2020-11-13 2:28:31"),"remark","NNeG","createUserid","sCw0","createUsername","0cwW","createTime",parse("2020-11-13 2:28:31"),"execStatus","7","iterationId","1waM","iterationName","P82b","execUsername","jE36","taskId","F5j8","taskName","8j7k","menuId","bz7q","menuName","qk3k");
		XmTestCaseExec xmTestCaseExec1=BaseUtils.fromMap(p1,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec1);
		Map p2=BaseUtils.map("execUserid","V7Jl","startTime",parse("2020-11-13 2:28:31"),"id","M2se","projectId","N1f5","projectName","oBZp","caseId","NHc5","caseName","suxU","endTime",parse("2020-11-13 2:28:31"),"remark","52jk","createUserid","2K3X","createUsername","1G4H","createTime",parse("2020-11-13 2:28:31"),"execStatus","y","iterationId","gKOQ","iterationName","o3GE","execUsername","xk2r","taskId","M9ty","taskName","7FL4","menuId","sIA1","menuName","1o9b");
		XmTestCaseExec xmTestCaseExec2=BaseUtils.fromMap(p2,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec2);
		Map p3=BaseUtils.map("execUserid","V5Mx","startTime",parse("2020-11-13 2:28:31"),"id","tUxu","projectId","K307","projectName","vXps","caseId","1H3n","caseName","8Qlu","endTime",parse("2020-11-13 2:28:31"),"remark","Rjf6","createUserid","IaBa","createUsername","Dawe","createTime",parse("2020-11-13 2:28:31"),"execStatus","9","iterationId","wC7E","iterationName","mQr3","execUsername","QkSI","taskId","6UXH","taskName","12XN","menuId","4AA3","menuName","h5nr");
		XmTestCaseExec xmTestCaseExec3=BaseUtils.fromMap(p3,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec3);
		Map p4=BaseUtils.map("execUserid","2243","startTime",parse("2020-11-13 2:28:31"),"id","95IU","projectId","uI3U","projectName","J2Fm","caseId","v3e7","caseName","IKZ9","endTime",parse("2020-11-13 2:28:31"),"remark","bMD1","createUserid","597G","createUsername","06nt","createTime",parse("2020-11-13 2:28:31"),"execStatus","6","iterationId","Kz9W","iterationName","52j3","execUsername","LJIt","taskId","QlCI","taskName","V84b","menuId","iaKg","menuName","MGLe");
		XmTestCaseExec xmTestCaseExec4=BaseUtils.fromMap(p4,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec4);
		Map p5=BaseUtils.map("execUserid","t4Qh","startTime",parse("2020-11-13 2:28:31"),"id","6tju","projectId","6Ci6","projectName","83Z9","caseId","MVD6","caseName","A168","endTime",parse("2020-11-13 2:28:31"),"remark","bqCW","createUserid","P255","createUsername","5PKQ","createTime",parse("2020-11-13 2:28:31"),"execStatus","w","iterationId","W66C","iterationName","dheT","execUsername","cB8H","taskId","OpSI","taskName","6JB1","menuId","1BJp","menuName","OYWE");
		XmTestCaseExec xmTestCaseExec5=BaseUtils.fromMap(p5,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec5);
		Map p6=BaseUtils.map("execUserid","NjOB","startTime",parse("2020-11-13 2:28:31"),"id","6o65","projectId","UhlA","projectName","w525","caseId","2T26","caseName","xAAP","endTime",parse("2020-11-13 2:28:31"),"remark","Sf90","createUserid","nPzg","createUsername","PgT5","createTime",parse("2020-11-13 2:28:31"),"execStatus","s","iterationId","a83o","iterationName","mYrj","execUsername","icFI","taskId","8WR4","taskName","lc03","menuId","f5NN","menuName","3pSL");
		XmTestCaseExec xmTestCaseExec6=BaseUtils.fromMap(p6,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec6);
		Map p7=BaseUtils.map("execUserid","S3hF","startTime",parse("2020-11-13 2:28:31"),"id","7z00","projectId","1Y2g","projectName","8nsz","caseId","bVqf","caseName","w0r6","endTime",parse("2020-11-13 2:28:31"),"remark","1Fs9","createUserid","jaIb","createUsername","87u6","createTime",parse("2020-11-13 2:28:31"),"execStatus","6","iterationId","nTuO","iterationName","CI7k","execUsername","eDYA","taskId","6w6T","taskName","tDz3","menuId","3bv6","menuName","ppRk");
		XmTestCaseExec xmTestCaseExec7=BaseUtils.fromMap(p7,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec7);
		xmTestCaseExecService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmTestCaseExec> batchValues=new ArrayList<XmTestCaseExec>();
		Map p0=BaseUtils.map("execUserid","vQXx","startTime",parse("2020-11-13 2:28:31"),"id","IMeb","projectId","eyLs","projectName","omUL","caseId","Pmaa","caseName","b9qi","endTime",parse("2020-11-13 2:28:31"),"remark","Ns5O","createUserid","YHU7","createUsername","hueb","createTime",parse("2020-11-13 2:28:31"),"execStatus","D","iterationId","Z0mT","iterationName","Pn9M","execUsername","f1ob","taskId","aJhV","taskName","KgQF","menuId","2o3l","menuName","yFwY");
		XmTestCaseExec xmTestCaseExec0=BaseUtils.fromMap(p0,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec0);
		Map p1=BaseUtils.map("execUserid","X2D9","startTime",parse("2020-11-13 2:28:31"),"id","E258","projectId","AWeN","projectName","apbP","caseId","nX38","caseName","MY4D","endTime",parse("2020-11-13 2:28:31"),"remark","NNeG","createUserid","sCw0","createUsername","0cwW","createTime",parse("2020-11-13 2:28:31"),"execStatus","7","iterationId","1waM","iterationName","P82b","execUsername","jE36","taskId","F5j8","taskName","8j7k","menuId","bz7q","menuName","qk3k");
		XmTestCaseExec xmTestCaseExec1=BaseUtils.fromMap(p1,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec1);
		Map p2=BaseUtils.map("execUserid","V7Jl","startTime",parse("2020-11-13 2:28:31"),"id","M2se","projectId","N1f5","projectName","oBZp","caseId","NHc5","caseName","suxU","endTime",parse("2020-11-13 2:28:31"),"remark","52jk","createUserid","2K3X","createUsername","1G4H","createTime",parse("2020-11-13 2:28:31"),"execStatus","y","iterationId","gKOQ","iterationName","o3GE","execUsername","xk2r","taskId","M9ty","taskName","7FL4","menuId","sIA1","menuName","1o9b");
		XmTestCaseExec xmTestCaseExec2=BaseUtils.fromMap(p2,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec2);
		Map p3=BaseUtils.map("execUserid","V5Mx","startTime",parse("2020-11-13 2:28:31"),"id","tUxu","projectId","K307","projectName","vXps","caseId","1H3n","caseName","8Qlu","endTime",parse("2020-11-13 2:28:31"),"remark","Rjf6","createUserid","IaBa","createUsername","Dawe","createTime",parse("2020-11-13 2:28:31"),"execStatus","9","iterationId","wC7E","iterationName","mQr3","execUsername","QkSI","taskId","6UXH","taskName","12XN","menuId","4AA3","menuName","h5nr");
		XmTestCaseExec xmTestCaseExec3=BaseUtils.fromMap(p3,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec3);
		Map p4=BaseUtils.map("execUserid","2243","startTime",parse("2020-11-13 2:28:31"),"id","95IU","projectId","uI3U","projectName","J2Fm","caseId","v3e7","caseName","IKZ9","endTime",parse("2020-11-13 2:28:31"),"remark","bMD1","createUserid","597G","createUsername","06nt","createTime",parse("2020-11-13 2:28:31"),"execStatus","6","iterationId","Kz9W","iterationName","52j3","execUsername","LJIt","taskId","QlCI","taskName","V84b","menuId","iaKg","menuName","MGLe");
		XmTestCaseExec xmTestCaseExec4=BaseUtils.fromMap(p4,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec4);
		Map p5=BaseUtils.map("execUserid","t4Qh","startTime",parse("2020-11-13 2:28:31"),"id","6tju","projectId","6Ci6","projectName","83Z9","caseId","MVD6","caseName","A168","endTime",parse("2020-11-13 2:28:31"),"remark","bqCW","createUserid","P255","createUsername","5PKQ","createTime",parse("2020-11-13 2:28:31"),"execStatus","w","iterationId","W66C","iterationName","dheT","execUsername","cB8H","taskId","OpSI","taskName","6JB1","menuId","1BJp","menuName","OYWE");
		XmTestCaseExec xmTestCaseExec5=BaseUtils.fromMap(p5,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec5);
		Map p6=BaseUtils.map("execUserid","NjOB","startTime",parse("2020-11-13 2:28:31"),"id","6o65","projectId","UhlA","projectName","w525","caseId","2T26","caseName","xAAP","endTime",parse("2020-11-13 2:28:31"),"remark","Sf90","createUserid","nPzg","createUsername","PgT5","createTime",parse("2020-11-13 2:28:31"),"execStatus","s","iterationId","a83o","iterationName","mYrj","execUsername","icFI","taskId","8WR4","taskName","lc03","menuId","f5NN","menuName","3pSL");
		XmTestCaseExec xmTestCaseExec6=BaseUtils.fromMap(p6,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec6);
		Map p7=BaseUtils.map("execUserid","S3hF","startTime",parse("2020-11-13 2:28:31"),"id","7z00","projectId","1Y2g","projectName","8nsz","caseId","bVqf","caseName","w0r6","endTime",parse("2020-11-13 2:28:31"),"remark","1Fs9","createUserid","jaIb","createUsername","87u6","createTime",parse("2020-11-13 2:28:31"),"execStatus","6","iterationId","nTuO","iterationName","CI7k","execUsername","eDYA","taskId","6w6T","taskName","tDz3","menuId","3bv6","menuName","ppRk");
		XmTestCaseExec xmTestCaseExec7=BaseUtils.fromMap(p7,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec7);
		xmTestCaseExecService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmTestCaseExec> batchValues=new ArrayList<XmTestCaseExec>();
		Map p0=BaseUtils.map("execUserid","vQXx","startTime",parse("2020-11-13 2:28:31"),"id","IMeb","projectId","eyLs","projectName","omUL","caseId","Pmaa","caseName","b9qi","endTime",parse("2020-11-13 2:28:31"),"remark","Ns5O","createUserid","YHU7","createUsername","hueb","createTime",parse("2020-11-13 2:28:31"),"execStatus","D","iterationId","Z0mT","iterationName","Pn9M","execUsername","f1ob","taskId","aJhV","taskName","KgQF","menuId","2o3l","menuName","yFwY");
		XmTestCaseExec xmTestCaseExec0=BaseUtils.fromMap(p0,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec0);
		Map p1=BaseUtils.map("execUserid","X2D9","startTime",parse("2020-11-13 2:28:31"),"id","E258","projectId","AWeN","projectName","apbP","caseId","nX38","caseName","MY4D","endTime",parse("2020-11-13 2:28:31"),"remark","NNeG","createUserid","sCw0","createUsername","0cwW","createTime",parse("2020-11-13 2:28:31"),"execStatus","7","iterationId","1waM","iterationName","P82b","execUsername","jE36","taskId","F5j8","taskName","8j7k","menuId","bz7q","menuName","qk3k");
		XmTestCaseExec xmTestCaseExec1=BaseUtils.fromMap(p1,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec1);
		Map p2=BaseUtils.map("execUserid","V7Jl","startTime",parse("2020-11-13 2:28:31"),"id","M2se","projectId","N1f5","projectName","oBZp","caseId","NHc5","caseName","suxU","endTime",parse("2020-11-13 2:28:31"),"remark","52jk","createUserid","2K3X","createUsername","1G4H","createTime",parse("2020-11-13 2:28:31"),"execStatus","y","iterationId","gKOQ","iterationName","o3GE","execUsername","xk2r","taskId","M9ty","taskName","7FL4","menuId","sIA1","menuName","1o9b");
		XmTestCaseExec xmTestCaseExec2=BaseUtils.fromMap(p2,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec2);
		Map p3=BaseUtils.map("execUserid","V5Mx","startTime",parse("2020-11-13 2:28:31"),"id","tUxu","projectId","K307","projectName","vXps","caseId","1H3n","caseName","8Qlu","endTime",parse("2020-11-13 2:28:31"),"remark","Rjf6","createUserid","IaBa","createUsername","Dawe","createTime",parse("2020-11-13 2:28:31"),"execStatus","9","iterationId","wC7E","iterationName","mQr3","execUsername","QkSI","taskId","6UXH","taskName","12XN","menuId","4AA3","menuName","h5nr");
		XmTestCaseExec xmTestCaseExec3=BaseUtils.fromMap(p3,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec3);
		Map p4=BaseUtils.map("execUserid","2243","startTime",parse("2020-11-13 2:28:31"),"id","95IU","projectId","uI3U","projectName","J2Fm","caseId","v3e7","caseName","IKZ9","endTime",parse("2020-11-13 2:28:31"),"remark","bMD1","createUserid","597G","createUsername","06nt","createTime",parse("2020-11-13 2:28:31"),"execStatus","6","iterationId","Kz9W","iterationName","52j3","execUsername","LJIt","taskId","QlCI","taskName","V84b","menuId","iaKg","menuName","MGLe");
		XmTestCaseExec xmTestCaseExec4=BaseUtils.fromMap(p4,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec4);
		Map p5=BaseUtils.map("execUserid","t4Qh","startTime",parse("2020-11-13 2:28:31"),"id","6tju","projectId","6Ci6","projectName","83Z9","caseId","MVD6","caseName","A168","endTime",parse("2020-11-13 2:28:31"),"remark","bqCW","createUserid","P255","createUsername","5PKQ","createTime",parse("2020-11-13 2:28:31"),"execStatus","w","iterationId","W66C","iterationName","dheT","execUsername","cB8H","taskId","OpSI","taskName","6JB1","menuId","1BJp","menuName","OYWE");
		XmTestCaseExec xmTestCaseExec5=BaseUtils.fromMap(p5,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec5);
		Map p6=BaseUtils.map("execUserid","NjOB","startTime",parse("2020-11-13 2:28:31"),"id","6o65","projectId","UhlA","projectName","w525","caseId","2T26","caseName","xAAP","endTime",parse("2020-11-13 2:28:31"),"remark","Sf90","createUserid","nPzg","createUsername","PgT5","createTime",parse("2020-11-13 2:28:31"),"execStatus","s","iterationId","a83o","iterationName","mYrj","execUsername","icFI","taskId","8WR4","taskName","lc03","menuId","f5NN","menuName","3pSL");
		XmTestCaseExec xmTestCaseExec6=BaseUtils.fromMap(p6,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec6);
		Map p7=BaseUtils.map("execUserid","S3hF","startTime",parse("2020-11-13 2:28:31"),"id","7z00","projectId","1Y2g","projectName","8nsz","caseId","bVqf","caseName","w0r6","endTime",parse("2020-11-13 2:28:31"),"remark","1Fs9","createUserid","jaIb","createUsername","87u6","createTime",parse("2020-11-13 2:28:31"),"execStatus","6","iterationId","nTuO","iterationName","CI7k","execUsername","eDYA","taskId","6w6T","taskName","tDz3","menuId","3bv6","menuName","ppRk");
		XmTestCaseExec xmTestCaseExec7=BaseUtils.fromMap(p7,XmTestCaseExec.class);
		batchValues.add(xmTestCaseExec7);
		xmTestCaseExecService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","IMeb");
		Map<String,Object> result=this.xmTestCaseExecService.selectOne(XmTestCaseExec.class.getName()+".selectOneMap",p);
		Assert.assertEquals("IMeb", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("execUserid","vQXx","startTime",parse("2020-11-13 2:28:31"),"projectId","eyLs","projectName","omUL","caseId","Pmaa","caseName","b9qi","endTime",parse("2020-11-13 2:28:31"),"remark","Ns5O","createUserid","YHU7","createUsername","hueb","createTime",parse("2020-11-13 2:28:31"),"execStatus","D","iterationId","Z0mT","iterationName","Pn9M","execUsername","f1ob","taskId","aJhV","taskName","KgQF","menuId","2o3l","menuName","yFwY");
		XmTestCaseExec xmTestCaseExec=BaseUtils.fromMap(p,XmTestCaseExec.class);
		long result=xmTestCaseExecService.countByWhere(xmTestCaseExec);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("execUserid","vQXx","startTime",parse("2020-11-13 2:28:31"),"projectId","eyLs","projectName","omUL","caseId","Pmaa","caseName","b9qi","endTime",parse("2020-11-13 2:28:31"),"remark","Ns5O","createUserid","YHU7","createUsername","hueb","createTime",parse("2020-11-13 2:28:31"),"execStatus","D","iterationId","Z0mT","iterationName","Pn9M","execUsername","f1ob","taskId","aJhV","taskName","KgQF","menuId","2o3l","menuName","yFwY");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmTestCaseExec xmTestCaseExec=BaseUtils.fromMap(p,XmTestCaseExec.class);
		List<XmTestCaseExec> result=xmTestCaseExecService.selectListByWhere(xmTestCaseExec); 
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
	
		
		Map<String,Object> p=BaseUtils.map("execUserid","vQXx","startTime",parse("2020-11-13 2:28:31"),"projectId","eyLs","projectName","omUL","caseId","Pmaa","caseName","b9qi","endTime",parse("2020-11-13 2:28:31"),"remark","Ns5O","createUserid","YHU7","createUsername","hueb","createTime",parse("2020-11-13 2:28:31"),"execStatus","D","iterationId","Z0mT","iterationName","Pn9M","execUsername","f1ob","taskId","aJhV","taskName","KgQF","menuId","2o3l","menuName","yFwY");
		XmTestCaseExec xmTestCaseExec=BaseUtils.fromMap(p,XmTestCaseExec.class);
		List<XmTestCaseExec> result=xmTestCaseExecService.selectListByWhere(xmTestCaseExec);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("execUserid","vQXx","startTime",parse("2020-11-13 2:28:31"),"projectId","eyLs","projectName","omUL","caseId","Pmaa","caseName","b9qi","endTime",parse("2020-11-13 2:28:31"),"remark","Ns5O","createUserid","YHU7","createUsername","hueb","createTime",parse("2020-11-13 2:28:31"),"execStatus","D","iterationId","Z0mT","iterationName","Pn9M","execUsername","f1ob","taskId","aJhV","taskName","KgQF","menuId","2o3l","menuName","yFwY");
		List<Map<String,Object>> result=xmTestCaseExecService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("execUserid","vQXx","startTime",parse("2020-11-13 2:28:31"),"projectId","eyLs","projectName","omUL","caseId","Pmaa","caseName","b9qi","endTime",parse("2020-11-13 2:28:31"),"remark","Ns5O","createUserid","YHU7","createUsername","hueb","createTime",parse("2020-11-13 2:28:31"),"execStatus","D","iterationId","Z0mT","iterationName","Pn9M","execUsername","f1ob","taskId","aJhV","taskName","KgQF","menuId","2o3l","menuName","yFwY");
		List<Map<String,Object>> result=xmTestCaseExecService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmTestCaseExec
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","IMeb");
		
		XmTestCaseExec xmTestCaseExec1=BaseUtils.fromMap(p,XmTestCaseExec.class);
		XmTestCaseExec xmTestCaseExec=xmTestCaseExecService.selectOneObject(xmTestCaseExec1);
		Assert.assertEquals("IMeb", xmTestCaseExec.getId());
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
