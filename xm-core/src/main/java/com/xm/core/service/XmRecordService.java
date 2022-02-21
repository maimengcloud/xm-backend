package com.xm.core.service;

import com.mdp.core.service.BaseService;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmRecord;
import org.slf4j.MDC;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmRecord 表 XM.xm_record 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmRecordService")
public class XmRecordService extends BaseService {
	
	/** 请在此类添加自定义函数 */
	
	
	public XmRecord initXmRecord( ) {
		User user=LoginUtils.getCurrentUserInfo();
		XmRecord record=new XmRecord();
		record.setId(this.createKey("id"));
		record.setOperTime(new Date());
		record.setReqNo(MDC.get("reqNo"));
		record.setOperUserid(user.getUserid());
		record.setOperUsername(user.getUsername());
		record.setBranchId(user.getBranchId()); 
		return record;
	}
	
	/**
	 * 针对项目的所有的操作日志用此方法
	 * @param projectId 项目编号
	 * @param action 操作如 新增项目，修改项目，修改项目进度 等
	 * @param remarks 人性化语言描述
	 * @param newValue 需要记录下来的新数据，可空
	 * @param oldValue 需要记录下来的旧数据，可空
	 */
	@Async
	public void addXmProjectRecord(String projectId,String action,String remarks,String newValue,String oldValue) {
		XmRecord record=this.initXmRecord();
		record.setProjectId(projectId);
		record.setAction(action);
		record.setRemarks(remarks); 
		record.setObjType("project"); 
		record.setNewValue(newValue);
		record.setOldValue(oldValue);
		this.insert(record);
	}
	
	/**
	 * 针对项目的所有的操作日志用此方法
	 * @param projectId 项目编号
	 * @param action 操作如 新增项目，修改项目，修改项目进度 等
	 * @param remarks 人性化语言描述 
	 */
	@Async
	public void addXmProjectRecord(String projectId,String action,String remarks) {
		XmRecord record=this.initXmRecord();
		record.setProjectId(projectId);
		record.setAction(action);
		record.setRemarks(remarks); 
		record.setObjType("project");  
		this.insert(record);
	}
	
	/**
	 * 针对项目下的任务的所有操作用此方法
	 * @param projectId 项目编号
	 * @param taskId 任务编号
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述 
	 */
	@Async
	public void addXmTaskRecord(String projectId,String taskId,String action,String remarks) {
		XmRecord record=this.initXmRecord();
		record.setProjectId(projectId);
		record.setTaskId(taskId);
		record.setAction(action);
		record.setRemarks(remarks); 
		record.setObjType("task"); 
		this.insert(record);
	}

	/**
	 * 针对项目下的任务的所有操作用此方法
	 * @param projectId 项目编号
	 * @param taskId 任务编号
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述
	 * @param newValue 需要记录下来的新数据 可空
	 * @param oldValue 需要记录下来的旧数据 可空
	 */
	@Async
	public void addXmTaskRecord(String projectId,String taskId,String action,String remarks,String newValue,String oldValue) {
		XmRecord record=this.initXmRecord();
		record.setProjectId(projectId);
		record.setTaskId(taskId);
		record.setAction(action);
		record.setRemarks(remarks); 
		record.setObjType("task");
		record.setNewValue(newValue);
		record.setOldValue(oldValue);
		this.insert(record);
	}
	

	/**
	 * 针对项目下的任务的所有操作用此方法
	 * @param projectId 项目编号
	 * @param phaseId 计划编号
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述 
	 */
	@Async
	public void addXmPhaseRecord(String projectId,String phaseId,String action,String remarks) {
		XmRecord record=this.initXmRecord();
		record.setProjectId(projectId);
		record.setTaskId(phaseId);
		record.setAction(action);
		record.setRemarks(remarks); 
		record.setObjType("phase"); 
		this.insert(record);
	}

	/**
	 * 针对项目下的任务的所有操作用此方法
	 * @param projectId 项目编号
	 * @param phaseId 计划编号
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述
	 * @param newValue 需要记录下来的新数据 可空
	 * @param oldValue 需要记录下来的旧数据 可空
	 */
	@Async
	public void addXmPhaseRecord(String projectId,String phaseId,String action,String remarks,String newValue,String oldValue) {
		XmRecord record=this.initXmRecord();
		record.setProjectId(projectId);
		record.setTaskId(phaseId);
		record.setAction(action);
		record.setRemarks(remarks); 
		record.setObjType("phase");
		record.setNewValue(newValue);
		record.setOldValue(oldValue);
		this.insert(record);
	}
	

	/**
	 * 针对项目下的任务的所有操作用此方法
	 * @param projectId 项目编号
	 * @param groupId 小组编号
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述 
	 */
	@Async
	public void addXmGroupRecord(String projectId,String groupId,String action,String remarks) {
		XmRecord record=this.initXmRecord();
		record.setProjectId(projectId);
		record.setTaskId(groupId);
		record.setAction(action);
		record.setRemarks(remarks); 
		record.setObjType("group"); 
		this.insert(record);
	}

	/**
	 * 针对项目下的任务的所有操作用此方法
	 * @param projectId 项目编号
	 * @param phaseId 小组编号
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述
	 * @param newValue 需要记录下来的新数据 可空
	 * @param oldValue 需要记录下来的旧数据 可空
	 */
	@Async
	public void addXmGroupRecord(String projectId,String groupId,String action,String remarks,String newValue,String oldValue) {
		XmRecord record=this.initXmRecord();
		record.setProjectId(projectId);
		record.setTaskId(groupId);
		record.setAction(action);
		record.setRemarks(remarks); 
		record.setObjType("group");
		record.setNewValue(newValue);
		record.setOldValue(oldValue);
		this.insert(record);
	}
	

	/**
	 * 针对项目下的任务的所有操作用此方法
	 * @param projectId 项目编号
	 * @param budgetId 预算编号
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述 
	 */
	@Async
	public void addXmBudgetRecord(String projectId,String budgetId,String action,String remarks) {
		XmRecord record=this.initXmRecord();
		record.setProjectId(projectId);
		record.setTaskId(budgetId);
		record.setAction(action);
		record.setRemarks(remarks); 
		record.setObjType("budget"); 
		this.insert(record);
	}

	/**
	 * 针对项目下的任务的所有操作用此方法
	 * @param projectId 项目编号
	 * @param budgetId 预算编号
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述
	 * @param newValue 需要记录下来的新数据 可空
	 * @param oldValue 需要记录下来的旧数据 可空
	 */
	@Async
	public void addXmBudgetRecord(String projectId,String budgetId,String action,String remarks,String newValue,String oldValue) {
		XmRecord record=this.initXmRecord();
		record.setProjectId(projectId);
		record.setTaskId(budgetId);
		record.setAction(action);
		record.setRemarks(remarks); 
		record.setObjType("budget");
		record.setNewValue(newValue);
		record.setOldValue(oldValue);
		this.insert(record);
	}
	

	/**
	 * 针对项目下的任务的所有操作用此方法
	 * @param projectId 项目编号
	 * @param costId 成本编号
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述 
	 */
	@Async
	public void addXmCostRecord(String projectId,String costId,String action,String remarks) {
		XmRecord record=this.initXmRecord();
		record.setProjectId(projectId);
		record.setTaskId(costId);
		record.setAction(action);
		record.setRemarks(remarks); 
		record.setObjType("group"); 
		this.insert(record);
	}

	/**
	 * 针对项目下的任务的所有操作用此方法
	 * @param projectId 项目编号
	 * @param costId 成本编号
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述
	 * @param newValue 需要记录下来的新数据 可空
	 * @param oldValue 需要记录下来的旧数据 可空
	 */
	@Async
	public void addXmCostRecord(String projectId,String costId,String action,String remarks,String newValue,String oldValue) {
		XmRecord record=this.initXmRecord();
		record.setProjectId(projectId);
		record.setTaskId(costId);
		record.setAction(action);
		record.setRemarks(remarks); 
		record.setObjType("group");
		record.setNewValue(newValue);
		record.setOldValue(oldValue);
		this.insert(record);
	}
}

