package com.xm.core.service;

import com.mdp.core.service.BaseService;
import com.mdp.core.utils.RequestUtils;
import com.mdp.safe.client.entity.User;
import com.mdp.safe.client.utils.LoginUtils;
import com.xm.core.entity.XmMenu;
import com.xm.core.entity.XmRecord;
import com.xm.core.entity.XmTask;
import org.slf4j.MDC;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		record.setIp(RequestUtils.getIpAddr(RequestUtils.getRequest()));
		return record;
	}

	/**
	 * 针对产品的所有的操作日志用此方法
	 * @param productId 项目编号
	 * @param action 操作如 新增产品，修改产品，修改产品进度 等
	 * @param remarks 人性化语言描述
	 * @param newValue 需要记录下来的新数据，可空
	 * @param oldValue 需要记录下来的旧数据，可空
	 */
	@Async
	public void addXmProductRecord(String productId,String action,String remarks,String newValue,String oldValue) {
		XmRecord record=this.initXmRecord();
		record.setProductId(productId);
		record.setBizId(productId);
		record.setAction(action);
		record.setRemarks(remarks);
		record.setObjType("product");
		record.setNewValue(newValue);
		record.setOldValue(oldValue);
		this.insert(record);
	}

	/**
	 * 针对产品的所有的操作日志用此方法
	 * @param productId 产品编号
	 * @param action 操作如 新增产品，修改产品，修改产品进度 等
	 * @param remarks 人性化语言描述
	 */
	@Async
	public void addXmProductRecord(String productId,String action,String remarks) {
		XmRecord record=this.initXmRecord();
		record.setProductId(productId);
		record.setAction(action);
		record.setBizId(productId);
		record.setRemarks(remarks);
		record.setObjType("product");
		this.insert(record);
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
		record.setBizId(projectId);
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
		record.setBizId(projectId);
		record.setObjType("project");  
		this.insert(record);
	}

	/**
	 * 针对项目下的任务的所有操作用此方法
	 * @param tasks 任务列表
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述
	 */
	@Async
	public void addXmTaskRecord(List<XmTask> tasks,String action, String remarks) {
		User user=LoginUtils.getCurrentUserInfo();
		List<XmRecord> records=new ArrayList<>();
		String ip= RequestUtils.getIpAddr(RequestUtils.getRequest());
		for (XmTask task : tasks) {
			XmRecord record=new XmRecord();
			record.setId(this.createKey("id"));
			record.setOperTime(new Date());
			record.setReqNo(MDC.get("reqNo"));
			record.setOperUserid(user.getUserid());
			record.setOperUsername(user.getUsername());
			record.setBranchId(user.getBranchId());
			record.setProductId(task.getProductId());
			record.setBizId(task.getId());
			record.setAction(action);
			record.setRemarks(remarks+" 任务名称【"+task.getName()+"】");
			record.setObjType("task");
			records.add(record);
			record.setIp(ip);
		}
		if(records.size()>0){
			super.batchInsert(records);
		}
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
		record.setBizId(taskId);
		record.setAction(action);
		record.setRemarks(remarks); 
		record.setObjType("task"); 
		this.insert(record);
	}
	/**
	 * 针对项目下的任务的所有操作用此方法
	 * @param productId 产品编号
	 * @param taskId 任务编号
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述
	 */
	@Async
	public void addProductXmTaskRecord(String productId,String taskId,String action,String remarks) {
		XmRecord record=this.initXmRecord();
		record.setProductId(productId);
		record.setBizId(taskId);
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
		record.setBizId(taskId);
		record.setAction(action);
		record.setRemarks(remarks); 
		record.setObjType("task");
		record.setNewValue(newValue);
		record.setOldValue(oldValue);
		this.insert(record);
	}

	/**
	 * 针对产品下的需求的所有操作用此方法
	 * @param productId 产品编号
	 * @param menuId 需求编号
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述 
	 */
	@Async
	public void addXmMenuRecord(String productId,String menuId,String action,String remarks) {
		XmRecord record=this.initXmRecord();
		record.setProductId(productId);
		record.setBizId(menuId);
		record.setAction(action);
		record.setRemarks(remarks);
		record.setObjType("menu");
		this.insert(record);
	}
	/**
	 * 针对产品下的需求的所有操作用此方法
	 * @param menus 需求列表
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述 ,自动添加 需求名称【xxxxx】
	 */
	@Async
	public void addXmMenuRecord(List<XmMenu> menus, String action, String remarks) {
		User user=LoginUtils.getCurrentUserInfo();
		List<XmRecord> records=new ArrayList<>();

		String ip= RequestUtils.getIpAddr(RequestUtils.getRequest());
		for (XmMenu menu : menus) {
			XmRecord record=new XmRecord();
			record.setId(this.createKey("id"));
			record.setOperTime(new Date());
			record.setReqNo(MDC.get("reqNo"));
			record.setOperUserid(user.getUserid());
			record.setOperUsername(user.getUsername());
			record.setBranchId(user.getBranchId());
			record.setProductId(menu.getProductId());
			record.setBizId(menu.getMenuId());
			record.setAction(action);
			record.setRemarks(remarks+" 需求名称【"+menu.getMenuName()+"】");
			record.setObjType("menu");
			records.add(record);
			record.setIp(ip);
		}
		if(records.size()>0){
			super.batchInsert(records);
		}

	}
	/**
	 * 针对产品下的需求的所有操作用此方法
	 * @param productId 产品编号
	 * @param menuId 需求编号
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述
	 * @param newValue 需要记录下来的新数据 可空
	 * @param oldValue 需要记录下来的旧数据 可空
	 */
	@Async
	public void addXmMenuRecord(String productId,String menuId,String action,String remarks,String newValue,String oldValue) {
		XmRecord record=this.initXmRecord();
		record.setProductId(productId);
		record.setBizId(menuId);
		record.setAction(action);
		record.setRemarks(remarks);
		record.setObjType("task");
		record.setNewValue(newValue);
		record.setOldValue(oldValue);
		this.insert(record);
	}
	/**
	 * 针对迭代下的所有操作用此方法
	 * @param iterationId 迭代编号
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述 ,自动添加 需求名称【xxxxx】
	 */
	@Async
	public void addXmIterationRecord(String iterationId, String action, String remarks) {
		XmRecord record=this.initXmRecord();
		 record.setBizId(iterationId);
		 record.setObjType("iteration");
		 record.setAction(action);
		 record.setRemarks(remarks);
		 super.insert(record);

	}
	/**
	 * 针对迭代下的所有操作用此方法
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述
	 * @param newValue 需要记录下来的新数据 可空
	 * @param oldValue 需要记录下来的旧数据 可空
	 */
	@Async
	public void addXmIterationRecord(String iterationId,String action,String remarks,String newValue,String oldValue) {
		XmRecord record=this.initXmRecord();
		record.setBizId(iterationId);
		record.setObjType("iteration");
		record.setAction(action);
		record.setRemarks(remarks);
		record.setNewValue(newValue);
		record.setOldValue(oldValue);
		super.insert(record);
	}
	/**
	 * 针对项目下的任务的所有操作用此方法
	 * @param projectId 项目编号
	 * @param phaseId 计划编号
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述 
	 */
	@Async
	public void addProjectPhaseRecord(String projectId, String phaseId, String action, String remarks) {
		XmRecord record=this.initXmRecord();
		record.setProjectId(projectId);
		record.setBizId(phaseId);
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
	public void addProjectPhaseRecord(String projectId, String phaseId, String action, String remarks, String newValue, String oldValue) {
		XmRecord record=this.initXmRecord();
		record.setProjectId(projectId);
		record.setBizId(phaseId);
		record.setAction(action);
		record.setRemarks(remarks); 
		record.setObjType("phase");
		record.setNewValue(newValue);
		record.setOldValue(oldValue);
		this.insert(record);
	}

	/**
	 * 针对项目下的任务的所有操作用此方法
	 * @param productId 产品编号
	 * @param phaseId 计划编号
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述
	 */
	@Async
	public void addProductPhaseRecord(String productId, String phaseId, String action, String remarks) {
		XmRecord record=this.initXmRecord();
		record.setProductId(productId);
		record.setBizId(phaseId);
		record.setAction(action);
		record.setRemarks(remarks);
		record.setObjType("phase");
		this.insert(record);
	}

	/**
	 * 针对项目下的任务的所有操作用此方法
	 * @param productId 产品编号
	 * @param phaseId 计划编号
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述
	 * @param newValue 需要记录下来的新数据 可空
	 * @param oldValue 需要记录下来的旧数据 可空
	 */
	@Async
	public void addProductPhaseRecord(String productId, String phaseId, String action, String remarks, String newValue, String oldValue) {
		XmRecord record=this.initXmRecord();
		record.setProductId(productId);
		record.setBizId(phaseId);
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
		record.setProductId(projectId);
		record.setBizId(groupId);
		record.setAction(action);
		record.setRemarks(remarks); 
		record.setObjType("group"); 
		this.insert(record);
	}

	/**
	 * 针对项目下的任务的所有操作用此方法
	 * @param projectId 项目编号
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述
	 * @param newValue 需要记录下来的新数据 可空
	 * @param oldValue 需要记录下来的旧数据 可空
	 */
	@Async
	public void addXmGroupRecord(String projectId,String groupId,String action,String remarks,String newValue,String oldValue) {
		XmRecord record=this.initXmRecord();
		record.setProjectId(projectId);
		record.setBizId(groupId);
		record.setProductId(projectId);
		record.setAction(action);
		record.setRemarks(remarks); 
		record.setObjType("group");
		record.setNewValue(newValue);
		record.setOldValue(oldValue);
		this.insert(record);
	}

	/**
	 * 针对项目下的任务的所有操作用此方法
	 * @param productId 产品编号
	 * @param groupId 小组编号
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述
	 */
	@Async
	public void addXmProductGroupRecord(String productId,String groupId,String action,String remarks) {
		XmRecord record=this.initXmRecord();
		record.setProductId(productId);
		record.setBizId(groupId);
		record.setAction(action);
		record.setRemarks(remarks);
		record.setObjType("group");
		this.insert(record);
	}

	/**
	 * 针对项目下的任务的所有操作用此方法
	 * @param productId 产品编号
	 * @param action 操作如 新增任务，修改任务信息，修改任务进度 等
	 * @param remarks 人性化语言描述
	 * @param newValue 需要记录下来的新数据 可空
	 * @param oldValue 需要记录下来的旧数据 可空
	 */
	@Async
	public void addXmProductGroupRecord(String productId,String groupId,String action,String remarks,String newValue,String oldValue) {
		XmRecord record=this.initXmRecord();
		record.setProductId(productId);
		record.setBizId(groupId);
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
		record.setBizId(budgetId);
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
		record.setBizId(budgetId);
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
		record.setBizId(costId);
		record.setAction(action);
		record.setRemarks(remarks); 
		record.setObjType("cost");
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
		record.setBizId(costId);
		record.setAction(action);
		record.setRemarks(remarks); 
		record.setObjType("cost");
		record.setNewValue(newValue);
		record.setOldValue(oldValue);
		this.insert(record);
	}
}

