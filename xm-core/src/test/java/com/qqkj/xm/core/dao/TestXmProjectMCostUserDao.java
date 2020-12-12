package com.qqkj.xm.core.dao;

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
import com.qqkj.mdp.core.dao.BaseDao;
import com.qqkj.mdp.core.context.ContextHolder;
import com.qqkj.mdp.mybatis.PageUtils;
import com.github.pagehelper.Page;
import com.qqkj.xm.core.entity.XmProjectMCostUser;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * XmProjectMCostUserDao的测试案例
 * 组织 com.qqkj<br>
 * 顶级模块 oa<br>
 * 大模块 xm<br>
 * 小模块 <br>
 * 表 XM.xm_project_m_cost_user 项目实际人工成本费用<br>
 * 实体 XmProjectMCostUser<br>
 * 表是指数据库结构中的表,实体是指java类型中的实体类<br>
 * 当前实体所有属性名:<br>
 *	subjectId,projectId,userid,createTime,sendCostTime,username,projectName,remark,id,taskId,taskName,actWorkload,bizzStartDate,bizzEndDate,bizProcInstId,bizFlowState,projectPhaseId,actCostAmount,costType,bizMonth,bizDate,subjectName,projectPhaseName,execuserProcInstId,execuserStatus,payStatus,payOpUserid,payOpUsername;<br>
 * 当前表的所有字段名:<br>
 *	subject_id,project_id,userid,create_time,send_cost_time,username,project_name,remark,id,task_id,task_name,act_workload,bizz_start_date,bizz_end_date,biz_proc_inst_id,biz_flow_state,project_phase_id,act_cost_amount,cost_type,biz_month,biz_date,subject_name,project_phase_name,execuser_proc_inst_id,execuser_status,pay_status,pay_op_userid,pay_op_username;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 ***/
 @RunWith(SpringJUnit4ClassRunner.class)
 @SpringBootTest
public class TestXmProjectMCostUserDao  {

	@Autowired
	BaseDao baseDao;

	/**
	 * 新增一条数据
	 ***/
	@Test
	public void insert() {
		Map<String,Object> p=BaseUtils.map("subjectId","Q02E","projectId","PO73","userid","2GI5","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","r8Fh","projectName","NC4L","remark","4Al6","id","7SwH","taskId","j9na","taskName","urKG","actWorkload",9880.61,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","DmlP","bizFlowState","k","projectPhaseId","mL83","actCostAmount",3132.8,"costType","a","bizMonth","f8SN","bizDate","eehe","subjectName","I80q","projectPhaseName","F12G","execuserProcInstId","V7S7","execuserStatus","O","payStatus","w","payOpUserid","UiKn","payOpUsername","b6c0");
		XmProjectMCostUser xmProjectMCostUser=BaseUtils.fromMap(p,XmProjectMCostUser.class);
		baseDao.insert(xmProjectMCostUser);
		//Assert.assertEquals(1, result);
	}
	/**
	 * 删除满足条件的一条或者一批数据
	 ***/
	@Test
	public void deleteByWhere() {
		Map<String,Object> p=BaseUtils.map("subjectId","Q02E","projectId","PO73","userid","2GI5","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","r8Fh","projectName","NC4L","remark","4Al6","taskId","j9na","taskName","urKG","actWorkload",9880.61,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","DmlP","bizFlowState","k","projectPhaseId","mL83","actCostAmount",3132.8,"costType","a","bizMonth","f8SN","bizDate","eehe","subjectName","I80q","projectPhaseName","F12G","execuserProcInstId","V7S7","execuserStatus","O","payStatus","w","payOpUserid","UiKn","payOpUsername","b6c0");
		XmProjectMCostUser xmProjectMCostUser=BaseUtils.fromMap(p,XmProjectMCostUser.class);
		baseDao.deleteByWhere(xmProjectMCostUser);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 跟进主键删除一条数据
	 ***/
	@Test
	public void deleteByPk() {
		Map<String,Object> p=BaseUtils.map("id","7SwH");
		XmProjectMCostUser xmProjectMCostUser=BaseUtils.fromMap(p,XmProjectMCostUser.class);
		baseDao.deleteByPk(xmProjectMCostUser);
		//Assert.assertEquals(1, result);
	}
	
	/**
	 * 更新满足条件的一条或者一批数据
	 ***/
	@Test
	public void updateSomeFieldByPk() {
		Map<String,Object> where=BaseUtils.map("subjectId","Q02E","projectId","PO73","userid","2GI5","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","r8Fh","projectName","NC4L","remark","4Al6","taskId","j9na","taskName","urKG","actWorkload",9880.61,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","DmlP","bizFlowState","k","projectPhaseId","mL83","actCostAmount",3132.8,"costType","a","bizMonth","f8SN","bizDate","eehe","subjectName","I80q","projectPhaseName","F12G","execuserProcInstId","V7S7","execuserStatus","O","payStatus","w","payOpUserid","UiKn","payOpUsername","b6c0");
		XmProjectMCostUser xmProjectMCostUser=BaseUtils.fromMap(where,XmProjectMCostUser.class);
		baseDao.updateSomeFieldByPk(xmProjectMCostUser);
		//Assert.assertEquals(1, result);
	}
	
	
	
	/**
	 * 根据主键更新一条数据
	 ***/
	@Test
	public void updateByPk() {
		Map<String,Object> p=BaseUtils.map("id","7SwH");
		XmProjectMCostUser xmProjectMCostUser=BaseUtils.fromMap(p,XmProjectMCostUser.class);
		baseDao.updateByPk(xmProjectMCostUser);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 新增或者修改一条数据
	 ***/
	@Test
	public void insertOrUpdate() {
		Map<String,Object> p=BaseUtils.map("subjectId","Q02E","projectId","PO73","userid","2GI5","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","r8Fh","projectName","NC4L","remark","4Al6","id","7SwH","taskId","j9na","taskName","urKG","actWorkload",9880.61,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","DmlP","bizFlowState","k","projectPhaseId","mL83","actCostAmount",3132.8,"costType","a","bizMonth","f8SN","bizDate","eehe","subjectName","I80q","projectPhaseName","F12G","execuserProcInstId","V7S7","execuserStatus","O","payStatus","w","payOpUserid","UiKn","payOpUsername","b6c0");
		XmProjectMCostUser xmProjectMCostUser=BaseUtils.fromMap(p,XmProjectMCostUser.class);
		baseDao.insertOrUpdate(xmProjectMCostUser);
		//Assert.assertEquals(1, result);
	}
	
	
	/**
	 * 批量更新一批数据到数据库
	 ***/
	@Test
	public void batchUpdate() {
		List<XmProjectMCostUser> batchValues=new ArrayList<XmProjectMCostUser>();
		Map p0=BaseUtils.map("subjectId","Q02E","projectId","PO73","userid","2GI5","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","r8Fh","projectName","NC4L","remark","4Al6","id","7SwH","taskId","j9na","taskName","urKG","actWorkload",9880.61,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","DmlP","bizFlowState","k","projectPhaseId","mL83","actCostAmount",3132.8,"costType","a","bizMonth","f8SN","bizDate","eehe","subjectName","I80q","projectPhaseName","F12G","execuserProcInstId","V7S7","execuserStatus","O","payStatus","w","payOpUserid","UiKn","payOpUsername","b6c0");
		XmProjectMCostUser xmProjectMCostUser0=BaseUtils.fromMap(p0,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser0);
		Map p1=BaseUtils.map("subjectId","UgtT","projectId","E0Z8","userid","hS25","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","ypgR","projectName","6Ja3","remark","q6Uy","id","3gAY","taskId","49cH","taskName","2meS","actWorkload",4118.28,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","ZK0c","bizFlowState","r","projectPhaseId","xf3b","actCostAmount",8366.74,"costType","Z","bizMonth","R0o7","bizDate","09Sl","subjectName","1sIa","projectPhaseName","os7G","execuserProcInstId","RUX9","execuserStatus","n","payStatus","6","payOpUserid","YB33","payOpUsername","xQR8");
		XmProjectMCostUser xmProjectMCostUser1=BaseUtils.fromMap(p1,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser1);
		Map p2=BaseUtils.map("subjectId","vHTZ","projectId","A0I5","userid","A0r4","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","3KF9","projectName","euKE","remark","e1ie","id","79xG","taskId","hUfr","taskName","Zkxx","actWorkload",9913.14,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","P11L","bizFlowState","e","projectPhaseId","APZK","actCostAmount",733.05,"costType","R","bizMonth","1Ne5","bizDate","b9Oi","subjectName","3c4Y","projectPhaseName","C913","execuserProcInstId","XhYb","execuserStatus","k","payStatus","y","payOpUserid","GIsd","payOpUsername","lQ41");
		XmProjectMCostUser xmProjectMCostUser2=BaseUtils.fromMap(p2,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser2);
		Map p3=BaseUtils.map("subjectId","Te9O","projectId","WIhE","userid","nYkS","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","C0K2","projectName","3IO8","remark","LuNC","id","uIsH","taskId","pwm2","taskName","NERE","actWorkload",3487.04,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","pRJ2","bizFlowState","f","projectPhaseId","kFAT","actCostAmount",8905.84,"costType","1","bizMonth","5vPH","bizDate","1XEp","subjectName","s2zp","projectPhaseName","c3g6","execuserProcInstId","mb4c","execuserStatus","q","payStatus","7","payOpUserid","m5IS","payOpUsername","NxPa");
		XmProjectMCostUser xmProjectMCostUser3=BaseUtils.fromMap(p3,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser3);
		Map p4=BaseUtils.map("subjectId","9hZ4","projectId","53B4","userid","NSnU","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","H6gi","projectName","Y7QJ","remark","3TFu","id","0U27","taskId","Uk5E","taskName","KSP8","actWorkload",6345.32,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","4Dri","bizFlowState","a","projectPhaseId","KXQS","actCostAmount",5736.39,"costType","b","bizMonth","S9a6","bizDate","TLOQ","subjectName","j7C8","projectPhaseName","Y1CL","execuserProcInstId","NAc5","execuserStatus","M","payStatus","N","payOpUserid","uPp8","payOpUsername","h7UA");
		XmProjectMCostUser xmProjectMCostUser4=BaseUtils.fromMap(p4,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser4);
		Map p5=BaseUtils.map("subjectId","qdN1","projectId","YYNn","userid","l4sh","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","SJO9","projectName","VIeQ","remark","O2X9","id","9dH7","taskId","l5h0","taskName","OPxc","actWorkload",4137.19,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","7SDW","bizFlowState","3","projectPhaseId","qq1a","actCostAmount",754.66,"costType","f","bizMonth","kp7u","bizDate","a0Tm","subjectName","S9o8","projectPhaseName","sURc","execuserProcInstId","Bh7o","execuserStatus","p","payStatus","6","payOpUserid","rCr3","payOpUsername","ylKO");
		XmProjectMCostUser xmProjectMCostUser5=BaseUtils.fromMap(p5,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser5);
		Map p6=BaseUtils.map("subjectId","l0RD","projectId","Esmw","userid","mR1E","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","0Sul","projectName","bvNR","remark","XkcK","id","X7te","taskId","W8v2","taskName","Uy1D","actWorkload",1257.2,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","2790","bizFlowState","M","projectPhaseId","T94h","actCostAmount",6861.88,"costType","j","bizMonth","CHv5","bizDate","1yP7","subjectName","yW92","projectPhaseName","g270","execuserProcInstId","K0UH","execuserStatus","U","payStatus","n","payOpUserid","1Njh","payOpUsername","4BGX");
		XmProjectMCostUser xmProjectMCostUser6=BaseUtils.fromMap(p6,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser6);
		Map p7=BaseUtils.map("subjectId","4FIK","projectId","iA90","userid","Wu90","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","km4B","projectName","oj1Q","remark","rgQG","id","xcTq","taskId","zr60","taskName","24PZ","actWorkload",6726.61,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","TUmv","bizFlowState","9","projectPhaseId","1dXw","actCostAmount",8492.86,"costType","l","bizMonth","OO8z","bizDate","79J2","subjectName","e4Q9","projectPhaseName","1K5o","execuserProcInstId","uFCB","execuserStatus","g","payStatus","O","payOpUserid","dBao","payOpUsername","8KfX");
		XmProjectMCostUser xmProjectMCostUser7=BaseUtils.fromMap(p7,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser7);
		baseDao.batchUpdate(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	/**
	 * 批量删除一批数据到数据库
	 ***/
	@Test
	public void batchDelete() {
		List<XmProjectMCostUser> batchValues=new ArrayList<XmProjectMCostUser>();
		Map p0=BaseUtils.map("subjectId","Q02E","projectId","PO73","userid","2GI5","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","r8Fh","projectName","NC4L","remark","4Al6","id","7SwH","taskId","j9na","taskName","urKG","actWorkload",9880.61,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","DmlP","bizFlowState","k","projectPhaseId","mL83","actCostAmount",3132.8,"costType","a","bizMonth","f8SN","bizDate","eehe","subjectName","I80q","projectPhaseName","F12G","execuserProcInstId","V7S7","execuserStatus","O","payStatus","w","payOpUserid","UiKn","payOpUsername","b6c0");
		XmProjectMCostUser xmProjectMCostUser0=BaseUtils.fromMap(p0,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser0);
		Map p1=BaseUtils.map("subjectId","UgtT","projectId","E0Z8","userid","hS25","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","ypgR","projectName","6Ja3","remark","q6Uy","id","3gAY","taskId","49cH","taskName","2meS","actWorkload",4118.28,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","ZK0c","bizFlowState","r","projectPhaseId","xf3b","actCostAmount",8366.74,"costType","Z","bizMonth","R0o7","bizDate","09Sl","subjectName","1sIa","projectPhaseName","os7G","execuserProcInstId","RUX9","execuserStatus","n","payStatus","6","payOpUserid","YB33","payOpUsername","xQR8");
		XmProjectMCostUser xmProjectMCostUser1=BaseUtils.fromMap(p1,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser1);
		Map p2=BaseUtils.map("subjectId","vHTZ","projectId","A0I5","userid","A0r4","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","3KF9","projectName","euKE","remark","e1ie","id","79xG","taskId","hUfr","taskName","Zkxx","actWorkload",9913.14,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","P11L","bizFlowState","e","projectPhaseId","APZK","actCostAmount",733.05,"costType","R","bizMonth","1Ne5","bizDate","b9Oi","subjectName","3c4Y","projectPhaseName","C913","execuserProcInstId","XhYb","execuserStatus","k","payStatus","y","payOpUserid","GIsd","payOpUsername","lQ41");
		XmProjectMCostUser xmProjectMCostUser2=BaseUtils.fromMap(p2,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser2);
		Map p3=BaseUtils.map("subjectId","Te9O","projectId","WIhE","userid","nYkS","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","C0K2","projectName","3IO8","remark","LuNC","id","uIsH","taskId","pwm2","taskName","NERE","actWorkload",3487.04,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","pRJ2","bizFlowState","f","projectPhaseId","kFAT","actCostAmount",8905.84,"costType","1","bizMonth","5vPH","bizDate","1XEp","subjectName","s2zp","projectPhaseName","c3g6","execuserProcInstId","mb4c","execuserStatus","q","payStatus","7","payOpUserid","m5IS","payOpUsername","NxPa");
		XmProjectMCostUser xmProjectMCostUser3=BaseUtils.fromMap(p3,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser3);
		Map p4=BaseUtils.map("subjectId","9hZ4","projectId","53B4","userid","NSnU","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","H6gi","projectName","Y7QJ","remark","3TFu","id","0U27","taskId","Uk5E","taskName","KSP8","actWorkload",6345.32,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","4Dri","bizFlowState","a","projectPhaseId","KXQS","actCostAmount",5736.39,"costType","b","bizMonth","S9a6","bizDate","TLOQ","subjectName","j7C8","projectPhaseName","Y1CL","execuserProcInstId","NAc5","execuserStatus","M","payStatus","N","payOpUserid","uPp8","payOpUsername","h7UA");
		XmProjectMCostUser xmProjectMCostUser4=BaseUtils.fromMap(p4,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser4);
		Map p5=BaseUtils.map("subjectId","qdN1","projectId","YYNn","userid","l4sh","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","SJO9","projectName","VIeQ","remark","O2X9","id","9dH7","taskId","l5h0","taskName","OPxc","actWorkload",4137.19,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","7SDW","bizFlowState","3","projectPhaseId","qq1a","actCostAmount",754.66,"costType","f","bizMonth","kp7u","bizDate","a0Tm","subjectName","S9o8","projectPhaseName","sURc","execuserProcInstId","Bh7o","execuserStatus","p","payStatus","6","payOpUserid","rCr3","payOpUsername","ylKO");
		XmProjectMCostUser xmProjectMCostUser5=BaseUtils.fromMap(p5,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser5);
		Map p6=BaseUtils.map("subjectId","l0RD","projectId","Esmw","userid","mR1E","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","0Sul","projectName","bvNR","remark","XkcK","id","X7te","taskId","W8v2","taskName","Uy1D","actWorkload",1257.2,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","2790","bizFlowState","M","projectPhaseId","T94h","actCostAmount",6861.88,"costType","j","bizMonth","CHv5","bizDate","1yP7","subjectName","yW92","projectPhaseName","g270","execuserProcInstId","K0UH","execuserStatus","U","payStatus","n","payOpUserid","1Njh","payOpUsername","4BGX");
		XmProjectMCostUser xmProjectMCostUser6=BaseUtils.fromMap(p6,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser6);
		Map p7=BaseUtils.map("subjectId","4FIK","projectId","iA90","userid","Wu90","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","km4B","projectName","oj1Q","remark","rgQG","id","xcTq","taskId","zr60","taskName","24PZ","actWorkload",6726.61,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","TUmv","bizFlowState","9","projectPhaseId","1dXw","actCostAmount",8492.86,"costType","l","bizMonth","OO8z","bizDate","79J2","subjectName","e4Q9","projectPhaseName","1K5o","execuserProcInstId","uFCB","execuserStatus","g","payStatus","O","payOpUserid","dBao","payOpUsername","8KfX");
		XmProjectMCostUser xmProjectMCostUser7=BaseUtils.fromMap(p7,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser7);
		baseDao.batchDelete(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 批量新增一批数据到数据库
	 ***/
	@Test
	public void batchInsert() {
		List<XmProjectMCostUser> batchValues=new ArrayList<XmProjectMCostUser>();
		Map p0=BaseUtils.map("subjectId","Q02E","projectId","PO73","userid","2GI5","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","r8Fh","projectName","NC4L","remark","4Al6","id","7SwH","taskId","j9na","taskName","urKG","actWorkload",9880.61,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","DmlP","bizFlowState","k","projectPhaseId","mL83","actCostAmount",3132.8,"costType","a","bizMonth","f8SN","bizDate","eehe","subjectName","I80q","projectPhaseName","F12G","execuserProcInstId","V7S7","execuserStatus","O","payStatus","w","payOpUserid","UiKn","payOpUsername","b6c0");
		XmProjectMCostUser xmProjectMCostUser0=BaseUtils.fromMap(p0,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser0);
		Map p1=BaseUtils.map("subjectId","UgtT","projectId","E0Z8","userid","hS25","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","ypgR","projectName","6Ja3","remark","q6Uy","id","3gAY","taskId","49cH","taskName","2meS","actWorkload",4118.28,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","ZK0c","bizFlowState","r","projectPhaseId","xf3b","actCostAmount",8366.74,"costType","Z","bizMonth","R0o7","bizDate","09Sl","subjectName","1sIa","projectPhaseName","os7G","execuserProcInstId","RUX9","execuserStatus","n","payStatus","6","payOpUserid","YB33","payOpUsername","xQR8");
		XmProjectMCostUser xmProjectMCostUser1=BaseUtils.fromMap(p1,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser1);
		Map p2=BaseUtils.map("subjectId","vHTZ","projectId","A0I5","userid","A0r4","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","3KF9","projectName","euKE","remark","e1ie","id","79xG","taskId","hUfr","taskName","Zkxx","actWorkload",9913.14,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","P11L","bizFlowState","e","projectPhaseId","APZK","actCostAmount",733.05,"costType","R","bizMonth","1Ne5","bizDate","b9Oi","subjectName","3c4Y","projectPhaseName","C913","execuserProcInstId","XhYb","execuserStatus","k","payStatus","y","payOpUserid","GIsd","payOpUsername","lQ41");
		XmProjectMCostUser xmProjectMCostUser2=BaseUtils.fromMap(p2,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser2);
		Map p3=BaseUtils.map("subjectId","Te9O","projectId","WIhE","userid","nYkS","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","C0K2","projectName","3IO8","remark","LuNC","id","uIsH","taskId","pwm2","taskName","NERE","actWorkload",3487.04,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","pRJ2","bizFlowState","f","projectPhaseId","kFAT","actCostAmount",8905.84,"costType","1","bizMonth","5vPH","bizDate","1XEp","subjectName","s2zp","projectPhaseName","c3g6","execuserProcInstId","mb4c","execuserStatus","q","payStatus","7","payOpUserid","m5IS","payOpUsername","NxPa");
		XmProjectMCostUser xmProjectMCostUser3=BaseUtils.fromMap(p3,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser3);
		Map p4=BaseUtils.map("subjectId","9hZ4","projectId","53B4","userid","NSnU","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","H6gi","projectName","Y7QJ","remark","3TFu","id","0U27","taskId","Uk5E","taskName","KSP8","actWorkload",6345.32,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","4Dri","bizFlowState","a","projectPhaseId","KXQS","actCostAmount",5736.39,"costType","b","bizMonth","S9a6","bizDate","TLOQ","subjectName","j7C8","projectPhaseName","Y1CL","execuserProcInstId","NAc5","execuserStatus","M","payStatus","N","payOpUserid","uPp8","payOpUsername","h7UA");
		XmProjectMCostUser xmProjectMCostUser4=BaseUtils.fromMap(p4,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser4);
		Map p5=BaseUtils.map("subjectId","qdN1","projectId","YYNn","userid","l4sh","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","SJO9","projectName","VIeQ","remark","O2X9","id","9dH7","taskId","l5h0","taskName","OPxc","actWorkload",4137.19,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","7SDW","bizFlowState","3","projectPhaseId","qq1a","actCostAmount",754.66,"costType","f","bizMonth","kp7u","bizDate","a0Tm","subjectName","S9o8","projectPhaseName","sURc","execuserProcInstId","Bh7o","execuserStatus","p","payStatus","6","payOpUserid","rCr3","payOpUsername","ylKO");
		XmProjectMCostUser xmProjectMCostUser5=BaseUtils.fromMap(p5,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser5);
		Map p6=BaseUtils.map("subjectId","l0RD","projectId","Esmw","userid","mR1E","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","0Sul","projectName","bvNR","remark","XkcK","id","X7te","taskId","W8v2","taskName","Uy1D","actWorkload",1257.2,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","2790","bizFlowState","M","projectPhaseId","T94h","actCostAmount",6861.88,"costType","j","bizMonth","CHv5","bizDate","1yP7","subjectName","yW92","projectPhaseName","g270","execuserProcInstId","K0UH","execuserStatus","U","payStatus","n","payOpUserid","1Njh","payOpUsername","4BGX");
		XmProjectMCostUser xmProjectMCostUser6=BaseUtils.fromMap(p6,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser6);
		Map p7=BaseUtils.map("subjectId","4FIK","projectId","iA90","userid","Wu90","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","km4B","projectName","oj1Q","remark","rgQG","id","xcTq","taskId","zr60","taskName","24PZ","actWorkload",6726.61,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","TUmv","bizFlowState","9","projectPhaseId","1dXw","actCostAmount",8492.86,"costType","l","bizMonth","OO8z","bizDate","79J2","subjectName","e4Q9","projectPhaseName","1K5o","execuserProcInstId","uFCB","execuserStatus","g","payStatus","O","payOpUserid","dBao","payOpUsername","8KfX");
		XmProjectMCostUser xmProjectMCostUser7=BaseUtils.fromMap(p7,XmProjectMCostUser.class);
		batchValues.add(xmProjectMCostUser7);
		baseDao.batchInsert(batchValues);
		//Assert.assertEquals(1, result[0]);
	}
	
	
	/**
	 * 查询一条数据到Map中
	 ***/
	@Test
	public void selectOneMap() {
		Map<String,Object> p=BaseUtils.map("id","7SwH");
		Map<String,Object> result=this.baseDao.selectOne(XmProjectMCostUser.class.getName()+".selectOneMap",p);
		Assert.assertEquals("7SwH", result.get("id"));
	}
	
	
	/**
	 * 计算满足条件的行数
	 ***/
	@Test
	public void countByWhere() {
		Map<String,Object> p=BaseUtils.map("subjectId","Q02E","projectId","PO73","userid","2GI5","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","r8Fh","projectName","NC4L","remark","4Al6","taskId","j9na","taskName","urKG","actWorkload",9880.61,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","DmlP","bizFlowState","k","projectPhaseId","mL83","actCostAmount",3132.8,"costType","a","bizMonth","f8SN","bizDate","eehe","subjectName","I80q","projectPhaseName","F12G","execuserProcInstId","V7S7","execuserStatus","O","payStatus","w","payOpUserid","UiKn","payOpUsername","b6c0");
		XmProjectMCostUser xmProjectMCostUser=BaseUtils.fromMap(p,XmProjectMCostUser.class);
		long result=baseDao.countByWhere(xmProjectMCostUser);
		Assert.assertEquals(true, result>0);
	}
	
	
	/**
	 * 分页查询,分页数据由平台自动组装并返回前台,后台不需要手工拼装.
	 ***/
	@Test
	public void selectListByPage() {
	
 		
		
		Map<String,Object> p=BaseUtils.map("subjectId","Q02E","projectId","PO73","userid","2GI5","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","r8Fh","projectName","NC4L","remark","4Al6","taskId","j9na","taskName","urKG","actWorkload",9880.61,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","DmlP","bizFlowState","k","projectPhaseId","mL83","actCostAmount",3132.8,"costType","a","bizMonth","f8SN","bizDate","eehe","subjectName","I80q","projectPhaseName","F12G","execuserProcInstId","V7S7","execuserStatus","O","payStatus","w","payOpUserid","UiKn","payOpUsername","b6c0");
		p.put("pageNum","1");
		p.put("pageSize","10");
		PageUtils.startPage(p);
		XmProjectMCostUser xmProjectMCostUser=BaseUtils.fromMap(p,XmProjectMCostUser.class);
		List<XmProjectMCostUser> result=baseDao.selectListByWhere(xmProjectMCostUser); 
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
	
		
		Map<String,Object> p=BaseUtils.map("subjectId","Q02E","projectId","PO73","userid","2GI5","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","r8Fh","projectName","NC4L","remark","4Al6","taskId","j9na","taskName","urKG","actWorkload",9880.61,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","DmlP","bizFlowState","k","projectPhaseId","mL83","actCostAmount",3132.8,"costType","a","bizMonth","f8SN","bizDate","eehe","subjectName","I80q","projectPhaseName","F12G","execuserProcInstId","V7S7","execuserStatus","O","payStatus","w","payOpUserid","UiKn","payOpUsername","b6c0");
		XmProjectMCostUser xmProjectMCostUser=BaseUtils.fromMap(p,XmProjectMCostUser.class);
		List<XmProjectMCostUser> result=baseDao.selectListByWhere(xmProjectMCostUser);
		Assert.assertEquals(true, result.size()>=1);
	}

	
	/**
	 * 查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByWhere() {
		Map<String,Object> p=BaseUtils.map("subjectId","Q02E","projectId","PO73","userid","2GI5","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","r8Fh","projectName","NC4L","remark","4Al6","taskId","j9na","taskName","urKG","actWorkload",9880.61,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","DmlP","bizFlowState","k","projectPhaseId","mL83","actCostAmount",3132.8,"costType","a","bizMonth","f8SN","bizDate","eehe","subjectName","I80q","projectPhaseName","F12G","execuserProcInstId","V7S7","execuserStatus","O","payStatus","w","payOpUserid","UiKn","payOpUsername","b6c0");
		List<Map<String,Object>> result=baseDao.selectList(XmProjectMCostUser.class.getName()+".selectListMapByWhere",p);
		Assert.assertEquals(true, result.size()>=0);
	}
	/**
	 * 模糊查询一批map.不分页.
	 ***/
	@Test
	public void selectListMapByKey() {
		Map<String,Object> p=BaseUtils.map("subjectId","Q02E","projectId","PO73","userid","2GI5","createTime",parse("2020-10-20 15:36:15"),"sendCostTime",parse("2020-10-20 15:36:15"),"username","r8Fh","projectName","NC4L","remark","4Al6","taskId","j9na","taskName","urKG","actWorkload",9880.61,"bizzStartDate",parse("2020-10-20 15:36:15"),"bizzEndDate",parse("2020-10-20 15:36:15"),"bizProcInstId","DmlP","bizFlowState","k","projectPhaseId","mL83","actCostAmount",3132.8,"costType","a","bizMonth","f8SN","bizDate","eehe","subjectName","I80q","projectPhaseName","F12G","execuserProcInstId","V7S7","execuserStatus","O","payStatus","w","payOpUserid","UiKn","payOpUsername","b6c0");
		List<Map<String,Object>> result=baseDao.selectList(XmProjectMCostUser.class.getName()+".selectListMapByKey",p);
		Assert.assertEquals(true, result.size()>=0);
	}
 
	/**
	 * 查询一个对象 XmProjectMCostUser
	 ***/
	@Test
	public void selectOneObject() {
		Map<String,Object> p=BaseUtils.map("id","7SwH");
		
		XmProjectMCostUser xmProjectMCostUser1=BaseUtils.fromMap(p,XmProjectMCostUser.class);
		XmProjectMCostUser xmProjectMCostUser=baseDao.selectOneObject(xmProjectMCostUser1);
		Assert.assertEquals("7SwH", xmProjectMCostUser.getId());
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
