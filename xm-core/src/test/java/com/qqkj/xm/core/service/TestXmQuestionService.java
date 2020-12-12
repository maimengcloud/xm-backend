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
import  com.qqkj.xm.core.service.XmQuestionService; 
import com.qqkj.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import  com.qqkj.xm.core.entity.XmQuestion;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmQuestionService的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 xm<br>
 * 大模块 core<br>
 * 小模块 <br>
 * 表 XM.xm_question xm_question<br>
 * 实体 XmQuestion<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	id,name,projectId,projectName,caseId,caseName,endTime,askUserid,askUsername,handlerUserid,handlerUsername,priority,solution,description,createUserid,createUsername,createTime,bugStatus,bizProcInstId,bizFlowState,menuId,menuName,planWorkload,planCostAmount,totalActWorkload,totalActCostAmount,expectResult,opStep,currResult,refRequire,bugSeverity,bugType,tagIds,tagNames,urls,ltime,qtype,taskId,taskName,iterationId,iterationName,caseExecId;<br>
 * 当前表的所有字段名:<br>
 *	id,name,project_id,project_name,case_id,case_name,end_time,ask_userid,ask_username,handler_userid,handler_username,priority,solution,description,create_userid,create_username,create_time,bug_status,biz_proc_inst_id,biz_flow_state,menu_id,menu_name,plan_workload,plan_cost_amount,total_act_workload,total_act_cost_amount,expect_result,op_step,curr_result,ref_require,bug_severity,bug_type,tag_ids,tag_names,urls,ltime,qtype,task_id,task_name,iteration_id,iteration_name,case_exec_id;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestXmQuestionService  {

	@Autowired
	XmQuestionService xmQuestionService;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("id","sXoS","name","wWfb","projectId","dxOl","projectName","O9Be","caseId","X3C9","caseName","afZN","endTime",parse("2020-11-11 18:53:26"),"askUserid","GnKv","askUsername","GkhN","handlerUserid","QEll","handlerUsername","KBvz","priority","d33J","solution","WIv5","description","kVLA","createUserid","6z8B","createUsername","ZqWq","createTime",parse("2020-11-11 18:53:26"),"bugStatus","m540","bizProcInstId","Sk4o","bizFlowState","l","menuId","fO72","menuName","6en0","planWorkload",1481.06,"planCostAmount",990.82,"totalActWorkload",7620.18,"totalActCostAmount",946.55,"expectResult","rWD8","opStep","q96s","currResult","bmNR","refRequire","wGWE","bugSeverity","v7x9","bugType","VX22","tagIds","kgJR","tagNames","JWLK","urls","LIjV","ltime",parse("2020-11-11 18:53:26"),"qtype","80wt","taskId","TG0X","taskName","raGt","iterationId","ZfNn","iterationName","QgRg","caseExecId","Aq9i");
		XmQuestion xmQuestion=BaseUtils.fromMap(p,XmQuestion.class);
		xmQuestionService.insert(xmQuestion);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("name","wWfb","projectId","dxOl","projectName","O9Be","caseId","X3C9","caseName","afZN","endTime",parse("2020-11-11 18:53:26"),"askUserid","GnKv","askUsername","GkhN","handlerUserid","QEll","handlerUsername","KBvz","priority","d33J","solution","WIv5","description","kVLA","createUserid","6z8B","createUsername","ZqWq","createTime",parse("2020-11-11 18:53:26"),"bugStatus","m540","bizProcInstId","Sk4o","bizFlowState","l","menuId","fO72","menuName","6en0","planWorkload",1481.06,"planCostAmount",990.82,"totalActWorkload",7620.18,"totalActCostAmount",946.55,"expectResult","rWD8","opStep","q96s","currResult","bmNR","refRequire","wGWE","bugSeverity","v7x9","bugType","VX22","tagIds","kgJR","tagNames","JWLK","urls","LIjV","ltime",parse("2020-11-11 18:53:26"),"qtype","80wt","taskId","TG0X","taskName","raGt","iterationId","ZfNn","iterationName","QgRg","caseExecId","Aq9i");
		XmQuestion xmQuestion=BaseUtils.fromMap(p,XmQuestion.class);
		xmQuestionService.deleteByWhere(xmQuestion);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","sXoS");
		XmQuestion xmQuestion=BaseUtils.fromMap(p,XmQuestion.class);
		xmQuestionService.deleteByPk(xmQuestion);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("name","wWfb","projectId","dxOl","projectName","O9Be","caseId","X3C9","caseName","afZN","endTime",parse("2020-11-11 18:53:26"),"askUserid","GnKv","askUsername","GkhN","handlerUserid","QEll","handlerUsername","KBvz","priority","d33J","solution","WIv5","description","kVLA","createUserid","6z8B","createUsername","ZqWq","createTime",parse("2020-11-11 18:53:26"),"bugStatus","m540","bizProcInstId","Sk4o","bizFlowState","l","menuId","fO72","menuName","6en0","planWorkload",1481.06,"planCostAmount",990.82,"totalActWorkload",7620.18,"totalActCostAmount",946.55,"expectResult","rWD8","opStep","q96s","currResult","bmNR","refRequire","wGWE","bugSeverity","v7x9","bugType","VX22","tagIds","kgJR","tagNames","JWLK","urls","LIjV","ltime",parse("2020-11-11 18:53:26"),"qtype","80wt","taskId","TG0X","taskName","raGt","iterationId","ZfNn","iterationName","QgRg","caseExecId","Aq9i");
		XmQuestion xmQuestion=BaseUtils.fromMap(where,XmQuestion.class);
		xmQuestionService.updateSomeFieldByPk(xmQuestion);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","sXoS");
		XmQuestion xmQuestion=BaseUtils.fromMap(p,XmQuestion.class);
		xmQuestionService.updateByPk(xmQuestion);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("id","sXoS","name","wWfb","projectId","dxOl","projectName","O9Be","caseId","X3C9","caseName","afZN","endTime",parse("2020-11-11 18:53:26"),"askUserid","GnKv","askUsername","GkhN","handlerUserid","QEll","handlerUsername","KBvz","priority","d33J","solution","WIv5","description","kVLA","createUserid","6z8B","createUsername","ZqWq","createTime",parse("2020-11-11 18:53:26"),"bugStatus","m540","bizProcInstId","Sk4o","bizFlowState","l","menuId","fO72","menuName","6en0","planWorkload",1481.06,"planCostAmount",990.82,"totalActWorkload",7620.18,"totalActCostAmount",946.55,"expectResult","rWD8","opStep","q96s","currResult","bmNR","refRequire","wGWE","bugSeverity","v7x9","bugType","VX22","tagIds","kgJR","tagNames","JWLK","urls","LIjV","ltime",parse("2020-11-11 18:53:26"),"qtype","80wt","taskId","TG0X","taskName","raGt","iterationId","ZfNn","iterationName","QgRg","caseExecId","Aq9i");
		XmQuestion xmQuestion=BaseUtils.fromMap(p,XmQuestion.class);
		xmQuestionService.insertOrUpdate(xmQuestion);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmQuestion> batchValues=new ArrayList<XmQuestion>();
		Map p0=BaseUtils.map("id","sXoS","name","wWfb","projectId","dxOl","projectName","O9Be","caseId","X3C9","caseName","afZN","endTime",parse("2020-11-11 18:53:26"),"askUserid","GnKv","askUsername","GkhN","handlerUserid","QEll","handlerUsername","KBvz","priority","d33J","solution","WIv5","description","kVLA","createUserid","6z8B","createUsername","ZqWq","createTime",parse("2020-11-11 18:53:26"),"bugStatus","m540","bizProcInstId","Sk4o","bizFlowState","l","menuId","fO72","menuName","6en0","planWorkload",1481.06,"planCostAmount",990.82,"totalActWorkload",7620.18,"totalActCostAmount",946.55,"expectResult","rWD8","opStep","q96s","currResult","bmNR","refRequire","wGWE","bugSeverity","v7x9","bugType","VX22","tagIds","kgJR","tagNames","JWLK","urls","LIjV","ltime",parse("2020-11-11 18:53:26"),"qtype","80wt","taskId","TG0X","taskName","raGt","iterationId","ZfNn","iterationName","QgRg","caseExecId","Aq9i");
		XmQuestion xmQuestion0=BaseUtils.fromMap(p0,XmQuestion.class);
		batchValues.add(xmQuestion0);
		Map p1=BaseUtils.map("id","50pg","name","Gq0X","projectId","44m9","projectName","9UFu","caseId","8C0j","caseName","cdwS","endTime",parse("2020-11-11 18:53:26"),"askUserid","6eWC","askUsername","9y1a","handlerUserid","v695","handlerUsername","02Yp","priority","v577","solution","q1i8","description","m2VR","createUserid","YvYA","createUsername","O70c","createTime",parse("2020-11-11 18:53:26"),"bugStatus","5FH9","bizProcInstId","x3eN","bizFlowState","m","menuId","ydW8","menuName","r47z","planWorkload",9384.6,"planCostAmount",5519.96,"totalActWorkload",2766.98,"totalActCostAmount",4622.16,"expectResult","G7oc","opStep","zr0d","currResult","w1e2","refRequire","Zpv9","bugSeverity","xZ5H","bugType","0mXL","tagIds","3n06","tagNames","40M1","urls","wMGp","ltime",parse("2020-11-11 18:53:26"),"qtype","zQdp","taskId","GeLz","taskName","wOMI","iterationId","wq69","iterationName","o88X","caseExecId","aWrl");
		XmQuestion xmQuestion1=BaseUtils.fromMap(p1,XmQuestion.class);
		batchValues.add(xmQuestion1);
		Map p2=BaseUtils.map("id","l9vS","name","J4hW","projectId","2u0M","projectName","J7nT","caseId","zi5Y","caseName","gpuX","endTime",parse("2020-11-11 18:53:26"),"askUserid","aVpl","askUsername","SNat","handlerUserid","1a9y","handlerUsername","vQhP","priority","H977","solution","G2MT","description","wZdv","createUserid","DVk9","createUsername","f66T","createTime",parse("2020-11-11 18:53:26"),"bugStatus","K038","bizProcInstId","yT73","bizFlowState","R","menuId","WFE6","menuName","PSrF","planWorkload",2972.08,"planCostAmount",9849.54,"totalActWorkload",4571.17,"totalActCostAmount",7253.63,"expectResult","ayko","opStep","V0aS","currResult","d2LX","refRequire","gXA9","bugSeverity","06oM","bugType","5sv9","tagIds","wufb","tagNames","liRr","urls","u9UC","ltime",parse("2020-11-11 18:53:26"),"qtype","NNsK","taskId","eIpO","taskName","5GuX","iterationId","m5hv","iterationName","hcJL","caseExecId","c1kg");
		XmQuestion xmQuestion2=BaseUtils.fromMap(p2,XmQuestion.class);
		batchValues.add(xmQuestion2);
		Map p3=BaseUtils.map("id","YDKh","name","SWpX","projectId","jS9s","projectName","6131","caseId","fxls","caseName","f2pD","endTime",parse("2020-11-11 18:53:26"),"askUserid","wv5b","askUsername","sUYS","handlerUserid","6Ycg","handlerUsername","A007","priority","g8X4","solution","11eh","description","R5d7","createUserid","3v01","createUsername","oCn3","createTime",parse("2020-11-11 18:53:26"),"bugStatus","9uB3","bizProcInstId","g95A","bizFlowState","5","menuId","114u","menuName","nbfj","planWorkload",9836.08,"planCostAmount",5333.21,"totalActWorkload",3080.36,"totalActCostAmount",7667.61,"expectResult","CdJN","opStep","vMy2","currResult","3yXS","refRequire","0GJD","bugSeverity","2U36","bugType","ZEaJ","tagIds","7559","tagNames","8Hlv","urls","T2Tg","ltime",parse("2020-11-11 18:53:26"),"qtype","702p","taskId","syOZ","taskName","K5zD","iterationId","cwH8","iterationName","UlOQ","caseExecId","LXxp");
		XmQuestion xmQuestion3=BaseUtils.fromMap(p3,XmQuestion.class);
		batchValues.add(xmQuestion3);
		Map p4=BaseUtils.map("id","2HUw","name","0d4O","projectId","8znF","projectName","j4pV","caseId","h7hx","caseName","kTq0","endTime",parse("2020-11-11 18:53:26"),"askUserid","5TyW","askUsername","GF8K","handlerUserid","y7G1","handlerUsername","oFef","priority","g84h","solution","BMd3","description","87Pz","createUserid","mmEG","createUsername","OWk7","createTime",parse("2020-11-11 18:53:26"),"bugStatus","h4cy","bizProcInstId","LG3B","bizFlowState","0","menuId","33h1","menuName","6q9A","planWorkload",6950.26,"planCostAmount",249.89,"totalActWorkload",1488.02,"totalActCostAmount",647.16,"expectResult","XtrG","opStep","LwFg","currResult","0Lap","refRequire","hINc","bugSeverity","j9dm","bugType","ln97","tagIds","6R3l","tagNames","QEDd","urls","0fbV","ltime",parse("2020-11-11 18:53:26"),"qtype","t0mp","taskId","qxQl","taskName","l1nj","iterationId","b9yw","iterationName","inQR","caseExecId","rUlZ");
		XmQuestion xmQuestion4=BaseUtils.fromMap(p4,XmQuestion.class);
		batchValues.add(xmQuestion4);
		Map p5=BaseUtils.map("id","HUtn","name","A39p","projectId","CQ5I","projectName","DR07","caseId","9c7M","caseName","qaYs","endTime",parse("2020-11-11 18:53:26"),"askUserid","R1m7","askUsername","9StS","handlerUserid","86Tc","handlerUsername","FBN9","priority","g6b6","solution","3nMH","description","Aj8F","createUserid","eua2","createUsername","c9v3","createTime",parse("2020-11-11 18:53:26"),"bugStatus","Ei71","bizProcInstId","1U9E","bizFlowState","l","menuId","8Q3A","menuName","9N0y","planWorkload",7634.4,"planCostAmount",1943.8,"totalActWorkload",2808.45,"totalActCostAmount",2412.82,"expectResult","ZWW6","opStep","jXki","currResult","Qrfi","refRequire","QE7C","bugSeverity","5Bg1","bugType","HD5p","tagIds","boSg","tagNames","zycV","urls","JMJ3","ltime",parse("2020-11-11 18:53:26"),"qtype","yYe2","taskId","b0fl","taskName","c0Q1","iterationId","Vh1g","iterationName","r5zY","caseExecId","aJvR");
		XmQuestion xmQuestion5=BaseUtils.fromMap(p5,XmQuestion.class);
		batchValues.add(xmQuestion5);
		Map p6=BaseUtils.map("id","xID4","name","IQkO","projectId","PCP2","projectName","pOcX","caseId","9Krc","caseName","slIM","endTime",parse("2020-11-11 18:53:26"),"askUserid","F5Rz","askUsername","x3Ve","handlerUserid","I2Nv","handlerUsername","BnW2","priority","QF3z","solution","MnMw","description","RmdA","createUserid","7hWm","createUsername","GYW4","createTime",parse("2020-11-11 18:53:26"),"bugStatus","s9HE","bizProcInstId","96LL","bizFlowState","1","menuId","aMtj","menuName","Zsw5","planWorkload",5318.04,"planCostAmount",8381.43,"totalActWorkload",2379.45,"totalActCostAmount",25.19,"expectResult","sImi","opStep","vmDT","currResult","klo2","refRequire","1HkS","bugSeverity","2fed","bugType","72KX","tagIds","p85i","tagNames","3vAl","urls","a3D9","ltime",parse("2020-11-11 18:53:26"),"qtype","Dsp3","taskId","x17e","taskName","9iAX","iterationId","Bvi9","iterationName","Sm31","caseExecId","FFCD");
		XmQuestion xmQuestion6=BaseUtils.fromMap(p6,XmQuestion.class);
		batchValues.add(xmQuestion6);
		Map p7=BaseUtils.map("id","T7de","name","n8hc","projectId","Ig05","projectName","DoYP","caseId","E1L3","caseName","eJT2","endTime",parse("2020-11-11 18:53:26"),"askUserid","F9UL","askUsername","1z9Y","handlerUserid","CvE8","handlerUsername","wkc2","priority","052T","solution","1zur","description","X8lA","createUserid","6ygW","createUsername","xNgy","createTime",parse("2020-11-11 18:53:26"),"bugStatus","EHGD","bizProcInstId","fF33","bizFlowState","U","menuId","frSF","menuName","GMNF","planWorkload",3771.31,"planCostAmount",8011.66,"totalActWorkload",7602.82,"totalActCostAmount",3576.53,"expectResult","VIMz","opStep","t4nn","currResult","95yg","refRequire","2ijG","bugSeverity","qcqR","bugType","ZXYJ","tagIds","G3Ne","tagNames","GLJU","urls","WmU3","ltime",parse("2020-11-11 18:53:26"),"qtype","JHjR","taskId","2qtU","taskName","7232","iterationId","DY8Y","iterationName","EEc9","caseExecId","iIhs");
		XmQuestion xmQuestion7=BaseUtils.fromMap(p7,XmQuestion.class);
		batchValues.add(xmQuestion7);
		xmQuestionService.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
		
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmQuestion> batchValues=new ArrayList<XmQuestion>();
		Map p0=BaseUtils.map("id","sXoS","name","wWfb","projectId","dxOl","projectName","O9Be","caseId","X3C9","caseName","afZN","endTime",parse("2020-11-11 18:53:26"),"askUserid","GnKv","askUsername","GkhN","handlerUserid","QEll","handlerUsername","KBvz","priority","d33J","solution","WIv5","description","kVLA","createUserid","6z8B","createUsername","ZqWq","createTime",parse("2020-11-11 18:53:26"),"bugStatus","m540","bizProcInstId","Sk4o","bizFlowState","l","menuId","fO72","menuName","6en0","planWorkload",1481.06,"planCostAmount",990.82,"totalActWorkload",7620.18,"totalActCostAmount",946.55,"expectResult","rWD8","opStep","q96s","currResult","bmNR","refRequire","wGWE","bugSeverity","v7x9","bugType","VX22","tagIds","kgJR","tagNames","JWLK","urls","LIjV","ltime",parse("2020-11-11 18:53:26"),"qtype","80wt","taskId","TG0X","taskName","raGt","iterationId","ZfNn","iterationName","QgRg","caseExecId","Aq9i");
		XmQuestion xmQuestion0=BaseUtils.fromMap(p0,XmQuestion.class);
		batchValues.add(xmQuestion0);
		Map p1=BaseUtils.map("id","50pg","name","Gq0X","projectId","44m9","projectName","9UFu","caseId","8C0j","caseName","cdwS","endTime",parse("2020-11-11 18:53:26"),"askUserid","6eWC","askUsername","9y1a","handlerUserid","v695","handlerUsername","02Yp","priority","v577","solution","q1i8","description","m2VR","createUserid","YvYA","createUsername","O70c","createTime",parse("2020-11-11 18:53:26"),"bugStatus","5FH9","bizProcInstId","x3eN","bizFlowState","m","menuId","ydW8","menuName","r47z","planWorkload",9384.6,"planCostAmount",5519.96,"totalActWorkload",2766.98,"totalActCostAmount",4622.16,"expectResult","G7oc","opStep","zr0d","currResult","w1e2","refRequire","Zpv9","bugSeverity","xZ5H","bugType","0mXL","tagIds","3n06","tagNames","40M1","urls","wMGp","ltime",parse("2020-11-11 18:53:26"),"qtype","zQdp","taskId","GeLz","taskName","wOMI","iterationId","wq69","iterationName","o88X","caseExecId","aWrl");
		XmQuestion xmQuestion1=BaseUtils.fromMap(p1,XmQuestion.class);
		batchValues.add(xmQuestion1);
		Map p2=BaseUtils.map("id","l9vS","name","J4hW","projectId","2u0M","projectName","J7nT","caseId","zi5Y","caseName","gpuX","endTime",parse("2020-11-11 18:53:26"),"askUserid","aVpl","askUsername","SNat","handlerUserid","1a9y","handlerUsername","vQhP","priority","H977","solution","G2MT","description","wZdv","createUserid","DVk9","createUsername","f66T","createTime",parse("2020-11-11 18:53:26"),"bugStatus","K038","bizProcInstId","yT73","bizFlowState","R","menuId","WFE6","menuName","PSrF","planWorkload",2972.08,"planCostAmount",9849.54,"totalActWorkload",4571.17,"totalActCostAmount",7253.63,"expectResult","ayko","opStep","V0aS","currResult","d2LX","refRequire","gXA9","bugSeverity","06oM","bugType","5sv9","tagIds","wufb","tagNames","liRr","urls","u9UC","ltime",parse("2020-11-11 18:53:26"),"qtype","NNsK","taskId","eIpO","taskName","5GuX","iterationId","m5hv","iterationName","hcJL","caseExecId","c1kg");
		XmQuestion xmQuestion2=BaseUtils.fromMap(p2,XmQuestion.class);
		batchValues.add(xmQuestion2);
		Map p3=BaseUtils.map("id","YDKh","name","SWpX","projectId","jS9s","projectName","6131","caseId","fxls","caseName","f2pD","endTime",parse("2020-11-11 18:53:26"),"askUserid","wv5b","askUsername","sUYS","handlerUserid","6Ycg","handlerUsername","A007","priority","g8X4","solution","11eh","description","R5d7","createUserid","3v01","createUsername","oCn3","createTime",parse("2020-11-11 18:53:26"),"bugStatus","9uB3","bizProcInstId","g95A","bizFlowState","5","menuId","114u","menuName","nbfj","planWorkload",9836.08,"planCostAmount",5333.21,"totalActWorkload",3080.36,"totalActCostAmount",7667.61,"expectResult","CdJN","opStep","vMy2","currResult","3yXS","refRequire","0GJD","bugSeverity","2U36","bugType","ZEaJ","tagIds","7559","tagNames","8Hlv","urls","T2Tg","ltime",parse("2020-11-11 18:53:26"),"qtype","702p","taskId","syOZ","taskName","K5zD","iterationId","cwH8","iterationName","UlOQ","caseExecId","LXxp");
		XmQuestion xmQuestion3=BaseUtils.fromMap(p3,XmQuestion.class);
		batchValues.add(xmQuestion3);
		Map p4=BaseUtils.map("id","2HUw","name","0d4O","projectId","8znF","projectName","j4pV","caseId","h7hx","caseName","kTq0","endTime",parse("2020-11-11 18:53:26"),"askUserid","5TyW","askUsername","GF8K","handlerUserid","y7G1","handlerUsername","oFef","priority","g84h","solution","BMd3","description","87Pz","createUserid","mmEG","createUsername","OWk7","createTime",parse("2020-11-11 18:53:26"),"bugStatus","h4cy","bizProcInstId","LG3B","bizFlowState","0","menuId","33h1","menuName","6q9A","planWorkload",6950.26,"planCostAmount",249.89,"totalActWorkload",1488.02,"totalActCostAmount",647.16,"expectResult","XtrG","opStep","LwFg","currResult","0Lap","refRequire","hINc","bugSeverity","j9dm","bugType","ln97","tagIds","6R3l","tagNames","QEDd","urls","0fbV","ltime",parse("2020-11-11 18:53:26"),"qtype","t0mp","taskId","qxQl","taskName","l1nj","iterationId","b9yw","iterationName","inQR","caseExecId","rUlZ");
		XmQuestion xmQuestion4=BaseUtils.fromMap(p4,XmQuestion.class);
		batchValues.add(xmQuestion4);
		Map p5=BaseUtils.map("id","HUtn","name","A39p","projectId","CQ5I","projectName","DR07","caseId","9c7M","caseName","qaYs","endTime",parse("2020-11-11 18:53:26"),"askUserid","R1m7","askUsername","9StS","handlerUserid","86Tc","handlerUsername","FBN9","priority","g6b6","solution","3nMH","description","Aj8F","createUserid","eua2","createUsername","c9v3","createTime",parse("2020-11-11 18:53:26"),"bugStatus","Ei71","bizProcInstId","1U9E","bizFlowState","l","menuId","8Q3A","menuName","9N0y","planWorkload",7634.4,"planCostAmount",1943.8,"totalActWorkload",2808.45,"totalActCostAmount",2412.82,"expectResult","ZWW6","opStep","jXki","currResult","Qrfi","refRequire","QE7C","bugSeverity","5Bg1","bugType","HD5p","tagIds","boSg","tagNames","zycV","urls","JMJ3","ltime",parse("2020-11-11 18:53:26"),"qtype","yYe2","taskId","b0fl","taskName","c0Q1","iterationId","Vh1g","iterationName","r5zY","caseExecId","aJvR");
		XmQuestion xmQuestion5=BaseUtils.fromMap(p5,XmQuestion.class);
		batchValues.add(xmQuestion5);
		Map p6=BaseUtils.map("id","xID4","name","IQkO","projectId","PCP2","projectName","pOcX","caseId","9Krc","caseName","slIM","endTime",parse("2020-11-11 18:53:26"),"askUserid","F5Rz","askUsername","x3Ve","handlerUserid","I2Nv","handlerUsername","BnW2","priority","QF3z","solution","MnMw","description","RmdA","createUserid","7hWm","createUsername","GYW4","createTime",parse("2020-11-11 18:53:26"),"bugStatus","s9HE","bizProcInstId","96LL","bizFlowState","1","menuId","aMtj","menuName","Zsw5","planWorkload",5318.04,"planCostAmount",8381.43,"totalActWorkload",2379.45,"totalActCostAmount",25.19,"expectResult","sImi","opStep","vmDT","currResult","klo2","refRequire","1HkS","bugSeverity","2fed","bugType","72KX","tagIds","p85i","tagNames","3vAl","urls","a3D9","ltime",parse("2020-11-11 18:53:26"),"qtype","Dsp3","taskId","x17e","taskName","9iAX","iterationId","Bvi9","iterationName","Sm31","caseExecId","FFCD");
		XmQuestion xmQuestion6=BaseUtils.fromMap(p6,XmQuestion.class);
		batchValues.add(xmQuestion6);
		Map p7=BaseUtils.map("id","T7de","name","n8hc","projectId","Ig05","projectName","DoYP","caseId","E1L3","caseName","eJT2","endTime",parse("2020-11-11 18:53:26"),"askUserid","F9UL","askUsername","1z9Y","handlerUserid","CvE8","handlerUsername","wkc2","priority","052T","solution","1zur","description","X8lA","createUserid","6ygW","createUsername","xNgy","createTime",parse("2020-11-11 18:53:26"),"bugStatus","EHGD","bizProcInstId","fF33","bizFlowState","U","menuId","frSF","menuName","GMNF","planWorkload",3771.31,"planCostAmount",8011.66,"totalActWorkload",7602.82,"totalActCostAmount",3576.53,"expectResult","VIMz","opStep","t4nn","currResult","95yg","refRequire","2ijG","bugSeverity","qcqR","bugType","ZXYJ","tagIds","G3Ne","tagNames","GLJU","urls","WmU3","ltime",parse("2020-11-11 18:53:26"),"qtype","JHjR","taskId","2qtU","taskName","7232","iterationId","DY8Y","iterationName","EEc9","caseExecId","iIhs");
		XmQuestion xmQuestion7=BaseUtils.fromMap(p7,XmQuestion.class);
		batchValues.add(xmQuestion7);
		xmQuestionService.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmQuestion> batchValues=new ArrayList<XmQuestion>();
		Map p0=BaseUtils.map("id","sXoS","name","wWfb","projectId","dxOl","projectName","O9Be","caseId","X3C9","caseName","afZN","endTime",parse("2020-11-11 18:53:26"),"askUserid","GnKv","askUsername","GkhN","handlerUserid","QEll","handlerUsername","KBvz","priority","d33J","solution","WIv5","description","kVLA","createUserid","6z8B","createUsername","ZqWq","createTime",parse("2020-11-11 18:53:26"),"bugStatus","m540","bizProcInstId","Sk4o","bizFlowState","l","menuId","fO72","menuName","6en0","planWorkload",1481.06,"planCostAmount",990.82,"totalActWorkload",7620.18,"totalActCostAmount",946.55,"expectResult","rWD8","opStep","q96s","currResult","bmNR","refRequire","wGWE","bugSeverity","v7x9","bugType","VX22","tagIds","kgJR","tagNames","JWLK","urls","LIjV","ltime",parse("2020-11-11 18:53:26"),"qtype","80wt","taskId","TG0X","taskName","raGt","iterationId","ZfNn","iterationName","QgRg","caseExecId","Aq9i");
		XmQuestion xmQuestion0=BaseUtils.fromMap(p0,XmQuestion.class);
		batchValues.add(xmQuestion0);
		Map p1=BaseUtils.map("id","50pg","name","Gq0X","projectId","44m9","projectName","9UFu","caseId","8C0j","caseName","cdwS","endTime",parse("2020-11-11 18:53:26"),"askUserid","6eWC","askUsername","9y1a","handlerUserid","v695","handlerUsername","02Yp","priority","v577","solution","q1i8","description","m2VR","createUserid","YvYA","createUsername","O70c","createTime",parse("2020-11-11 18:53:26"),"bugStatus","5FH9","bizProcInstId","x3eN","bizFlowState","m","menuId","ydW8","menuName","r47z","planWorkload",9384.6,"planCostAmount",5519.96,"totalActWorkload",2766.98,"totalActCostAmount",4622.16,"expectResult","G7oc","opStep","zr0d","currResult","w1e2","refRequire","Zpv9","bugSeverity","xZ5H","bugType","0mXL","tagIds","3n06","tagNames","40M1","urls","wMGp","ltime",parse("2020-11-11 18:53:26"),"qtype","zQdp","taskId","GeLz","taskName","wOMI","iterationId","wq69","iterationName","o88X","caseExecId","aWrl");
		XmQuestion xmQuestion1=BaseUtils.fromMap(p1,XmQuestion.class);
		batchValues.add(xmQuestion1);
		Map p2=BaseUtils.map("id","l9vS","name","J4hW","projectId","2u0M","projectName","J7nT","caseId","zi5Y","caseName","gpuX","endTime",parse("2020-11-11 18:53:26"),"askUserid","aVpl","askUsername","SNat","handlerUserid","1a9y","handlerUsername","vQhP","priority","H977","solution","G2MT","description","wZdv","createUserid","DVk9","createUsername","f66T","createTime",parse("2020-11-11 18:53:26"),"bugStatus","K038","bizProcInstId","yT73","bizFlowState","R","menuId","WFE6","menuName","PSrF","planWorkload",2972.08,"planCostAmount",9849.54,"totalActWorkload",4571.17,"totalActCostAmount",7253.63,"expectResult","ayko","opStep","V0aS","currResult","d2LX","refRequire","gXA9","bugSeverity","06oM","bugType","5sv9","tagIds","wufb","tagNames","liRr","urls","u9UC","ltime",parse("2020-11-11 18:53:26"),"qtype","NNsK","taskId","eIpO","taskName","5GuX","iterationId","m5hv","iterationName","hcJL","caseExecId","c1kg");
		XmQuestion xmQuestion2=BaseUtils.fromMap(p2,XmQuestion.class);
		batchValues.add(xmQuestion2);
		Map p3=BaseUtils.map("id","YDKh","name","SWpX","projectId","jS9s","projectName","6131","caseId","fxls","caseName","f2pD","endTime",parse("2020-11-11 18:53:26"),"askUserid","wv5b","askUsername","sUYS","handlerUserid","6Ycg","handlerUsername","A007","priority","g8X4","solution","11eh","description","R5d7","createUserid","3v01","createUsername","oCn3","createTime",parse("2020-11-11 18:53:26"),"bugStatus","9uB3","bizProcInstId","g95A","bizFlowState","5","menuId","114u","menuName","nbfj","planWorkload",9836.08,"planCostAmount",5333.21,"totalActWorkload",3080.36,"totalActCostAmount",7667.61,"expectResult","CdJN","opStep","vMy2","currResult","3yXS","refRequire","0GJD","bugSeverity","2U36","bugType","ZEaJ","tagIds","7559","tagNames","8Hlv","urls","T2Tg","ltime",parse("2020-11-11 18:53:26"),"qtype","702p","taskId","syOZ","taskName","K5zD","iterationId","cwH8","iterationName","UlOQ","caseExecId","LXxp");
		XmQuestion xmQuestion3=BaseUtils.fromMap(p3,XmQuestion.class);
		batchValues.add(xmQuestion3);
		Map p4=BaseUtils.map("id","2HUw","name","0d4O","projectId","8znF","projectName","j4pV","caseId","h7hx","caseName","kTq0","endTime",parse("2020-11-11 18:53:26"),"askUserid","5TyW","askUsername","GF8K","handlerUserid","y7G1","handlerUsername","oFef","priority","g84h","solution","BMd3","description","87Pz","createUserid","mmEG","createUsername","OWk7","createTime",parse("2020-11-11 18:53:26"),"bugStatus","h4cy","bizProcInstId","LG3B","bizFlowState","0","menuId","33h1","menuName","6q9A","planWorkload",6950.26,"planCostAmount",249.89,"totalActWorkload",1488.02,"totalActCostAmount",647.16,"expectResult","XtrG","opStep","LwFg","currResult","0Lap","refRequire","hINc","bugSeverity","j9dm","bugType","ln97","tagIds","6R3l","tagNames","QEDd","urls","0fbV","ltime",parse("2020-11-11 18:53:26"),"qtype","t0mp","taskId","qxQl","taskName","l1nj","iterationId","b9yw","iterationName","inQR","caseExecId","rUlZ");
		XmQuestion xmQuestion4=BaseUtils.fromMap(p4,XmQuestion.class);
		batchValues.add(xmQuestion4);
		Map p5=BaseUtils.map("id","HUtn","name","A39p","projectId","CQ5I","projectName","DR07","caseId","9c7M","caseName","qaYs","endTime",parse("2020-11-11 18:53:26"),"askUserid","R1m7","askUsername","9StS","handlerUserid","86Tc","handlerUsername","FBN9","priority","g6b6","solution","3nMH","description","Aj8F","createUserid","eua2","createUsername","c9v3","createTime",parse("2020-11-11 18:53:26"),"bugStatus","Ei71","bizProcInstId","1U9E","bizFlowState","l","menuId","8Q3A","menuName","9N0y","planWorkload",7634.4,"planCostAmount",1943.8,"totalActWorkload",2808.45,"totalActCostAmount",2412.82,"expectResult","ZWW6","opStep","jXki","currResult","Qrfi","refRequire","QE7C","bugSeverity","5Bg1","bugType","HD5p","tagIds","boSg","tagNames","zycV","urls","JMJ3","ltime",parse("2020-11-11 18:53:26"),"qtype","yYe2","taskId","b0fl","taskName","c0Q1","iterationId","Vh1g","iterationName","r5zY","caseExecId","aJvR");
		XmQuestion xmQuestion5=BaseUtils.fromMap(p5,XmQuestion.class);
		batchValues.add(xmQuestion5);
		Map p6=BaseUtils.map("id","xID4","name","IQkO","projectId","PCP2","projectName","pOcX","caseId","9Krc","caseName","slIM","endTime",parse("2020-11-11 18:53:26"),"askUserid","F5Rz","askUsername","x3Ve","handlerUserid","I2Nv","handlerUsername","BnW2","priority","QF3z","solution","MnMw","description","RmdA","createUserid","7hWm","createUsername","GYW4","createTime",parse("2020-11-11 18:53:26"),"bugStatus","s9HE","bizProcInstId","96LL","bizFlowState","1","menuId","aMtj","menuName","Zsw5","planWorkload",5318.04,"planCostAmount",8381.43,"totalActWorkload",2379.45,"totalActCostAmount",25.19,"expectResult","sImi","opStep","vmDT","currResult","klo2","refRequire","1HkS","bugSeverity","2fed","bugType","72KX","tagIds","p85i","tagNames","3vAl","urls","a3D9","ltime",parse("2020-11-11 18:53:26"),"qtype","Dsp3","taskId","x17e","taskName","9iAX","iterationId","Bvi9","iterationName","Sm31","caseExecId","FFCD");
		XmQuestion xmQuestion6=BaseUtils.fromMap(p6,XmQuestion.class);
		batchValues.add(xmQuestion6);
		Map p7=BaseUtils.map("id","T7de","name","n8hc","projectId","Ig05","projectName","DoYP","caseId","E1L3","caseName","eJT2","endTime",parse("2020-11-11 18:53:26"),"askUserid","F9UL","askUsername","1z9Y","handlerUserid","CvE8","handlerUsername","wkc2","priority","052T","solution","1zur","description","X8lA","createUserid","6ygW","createUsername","xNgy","createTime",parse("2020-11-11 18:53:26"),"bugStatus","EHGD","bizProcInstId","fF33","bizFlowState","U","menuId","frSF","menuName","GMNF","planWorkload",3771.31,"planCostAmount",8011.66,"totalActWorkload",7602.82,"totalActCostAmount",3576.53,"expectResult","VIMz","opStep","t4nn","currResult","95yg","refRequire","2ijG","bugSeverity","qcqR","bugType","ZXYJ","tagIds","G3Ne","tagNames","GLJU","urls","WmU3","ltime",parse("2020-11-11 18:53:26"),"qtype","JHjR","taskId","2qtU","taskName","7232","iterationId","DY8Y","iterationName","EEc9","caseExecId","iIhs");
		XmQuestion xmQuestion7=BaseUtils.fromMap(p7,XmQuestion.class);
		batchValues.add(xmQuestion7);
		xmQuestionService.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","sXoS");
		Map<String,Object> result=this.xmQuestionService.selectOne(XmQuestion.class.getName()+".selectOneMap",p);
		Assert.assertEquals("sXoS", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("name","wWfb","projectId","dxOl","projectName","O9Be","caseId","X3C9","caseName","afZN","endTime",parse("2020-11-11 18:53:26"),"askUserid","GnKv","askUsername","GkhN","handlerUserid","QEll","handlerUsername","KBvz","priority","d33J","solution","WIv5","description","kVLA","createUserid","6z8B","createUsername","ZqWq","createTime",parse("2020-11-11 18:53:26"),"bugStatus","m540","bizProcInstId","Sk4o","bizFlowState","l","menuId","fO72","menuName","6en0","planWorkload",1481.06,"planCostAmount",990.82,"totalActWorkload",7620.18,"totalActCostAmount",946.55,"expectResult","rWD8","opStep","q96s","currResult","bmNR","refRequire","wGWE","bugSeverity","v7x9","bugType","VX22","tagIds","kgJR","tagNames","JWLK","urls","LIjV","ltime",parse("2020-11-11 18:53:26"),"qtype","80wt","taskId","TG0X","taskName","raGt","iterationId","ZfNn","iterationName","QgRg","caseExecId","Aq9i");
		XmQuestion xmQuestion=BaseUtils.fromMap(p,XmQuestion.class);
		long result=xmQuestionService.countByWhere(xmQuestion);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
		Map<String,Object> p=BaseUtils.map("name","wWfb","projectId","dxOl","projectName","O9Be","caseId","X3C9","caseName","afZN","endTime",parse("2020-11-11 18:53:26"),"askUserid","GnKv","askUsername","GkhN","handlerUserid","QEll","handlerUsername","KBvz","priority","d33J","solution","WIv5","description","kVLA","createUserid","6z8B","createUsername","ZqWq","createTime",parse("2020-11-11 18:53:26"),"bugStatus","m540","bizProcInstId","Sk4o","bizFlowState","l","menuId","fO72","menuName","6en0","planWorkload",1481.06,"planCostAmount",990.82,"totalActWorkload",7620.18,"totalActCostAmount",946.55,"expectResult","rWD8","opStep","q96s","currResult","bmNR","refRequire","wGWE","bugSeverity","v7x9","bugType","VX22","tagIds","kgJR","tagNames","JWLK","urls","LIjV","ltime",parse("2020-11-11 18:53:26"),"qtype","80wt","taskId","TG0X","taskName","raGt","iterationId","ZfNn","iterationName","QgRg","caseExecId","Aq9i");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmQuestion xmQuestion=BaseUtils.fromMap(p,XmQuestion.class);
		List<XmQuestion> result=xmQuestionService.selectListByWhere(xmQuestion); 
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
	
		
		Map<String,Object> p=BaseUtils.map("name","wWfb","projectId","dxOl","projectName","O9Be","caseId","X3C9","caseName","afZN","endTime",parse("2020-11-11 18:53:26"),"askUserid","GnKv","askUsername","GkhN","handlerUserid","QEll","handlerUsername","KBvz","priority","d33J","solution","WIv5","description","kVLA","createUserid","6z8B","createUsername","ZqWq","createTime",parse("2020-11-11 18:53:26"),"bugStatus","m540","bizProcInstId","Sk4o","bizFlowState","l","menuId","fO72","menuName","6en0","planWorkload",1481.06,"planCostAmount",990.82,"totalActWorkload",7620.18,"totalActCostAmount",946.55,"expectResult","rWD8","opStep","q96s","currResult","bmNR","refRequire","wGWE","bugSeverity","v7x9","bugType","VX22","tagIds","kgJR","tagNames","JWLK","urls","LIjV","ltime",parse("2020-11-11 18:53:26"),"qtype","80wt","taskId","TG0X","taskName","raGt","iterationId","ZfNn","iterationName","QgRg","caseExecId","Aq9i");
		XmQuestion xmQuestion=BaseUtils.fromMap(p,XmQuestion.class);
		List<XmQuestion> result=xmQuestionService.selectListByWhere(xmQuestion);
		Assert.assertEquals(true, result.size()>=1);
	}

 
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("name","wWfb","projectId","dxOl","projectName","O9Be","caseId","X3C9","caseName","afZN","endTime",parse("2020-11-11 18:53:26"),"askUserid","GnKv","askUsername","GkhN","handlerUserid","QEll","handlerUsername","KBvz","priority","d33J","solution","WIv5","description","kVLA","createUserid","6z8B","createUsername","ZqWq","createTime",parse("2020-11-11 18:53:26"),"bugStatus","m540","bizProcInstId","Sk4o","bizFlowState","l","menuId","fO72","menuName","6en0","planWorkload",1481.06,"planCostAmount",990.82,"totalActWorkload",7620.18,"totalActCostAmount",946.55,"expectResult","rWD8","opStep","q96s","currResult","bmNR","refRequire","wGWE","bugSeverity","v7x9","bugType","VX22","tagIds","kgJR","tagNames","JWLK","urls","LIjV","ltime",parse("2020-11-11 18:53:26"),"qtype","80wt","taskId","TG0X","taskName","raGt","iterationId","ZfNn","iterationName","QgRg","caseExecId","Aq9i");
		List<Map<String,Object>> result=xmQuestionService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("name","wWfb","projectId","dxOl","projectName","O9Be","caseId","X3C9","caseName","afZN","endTime",parse("2020-11-11 18:53:26"),"askUserid","GnKv","askUsername","GkhN","handlerUserid","QEll","handlerUsername","KBvz","priority","d33J","solution","WIv5","description","kVLA","createUserid","6z8B","createUsername","ZqWq","createTime",parse("2020-11-11 18:53:26"),"bugStatus","m540","bizProcInstId","Sk4o","bizFlowState","l","menuId","fO72","menuName","6en0","planWorkload",1481.06,"planCostAmount",990.82,"totalActWorkload",7620.18,"totalActCostAmount",946.55,"expectResult","rWD8","opStep","q96s","currResult","bmNR","refRequire","wGWE","bugSeverity","v7x9","bugType","VX22","tagIds","kgJR","tagNames","JWLK","urls","LIjV","ltime",parse("2020-11-11 18:53:26"),"qtype","80wt","taskId","TG0X","taskName","raGt","iterationId","ZfNn","iterationName","QgRg","caseExecId","Aq9i");
		List<Map<String,Object>> result=xmQuestionService.selectListMapByKey(p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 查询一个对象 XmQuestion
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","sXoS");
		
		XmQuestion xmQuestion1=BaseUtils.fromMap(p,XmQuestion.class);
		XmQuestion xmQuestion=xmQuestionService.selectOneObject(xmQuestion1);
		Assert.assertEquals("sXoS", xmQuestion.getId());
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
