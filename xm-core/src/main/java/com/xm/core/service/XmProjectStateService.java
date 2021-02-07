package com.xm.core.service;

import com.mdp.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmProjectState 表 XM.xm_project_state 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmProjectStateService")
public class XmProjectStateService extends BaseService {
	
	/** 请在此类添加自定义函数 */
	

	@Autowired
	XmRecordService xmRecordService;
	
	   
	public int loadTasksToXmProjectState(String projectId) {
		return this.update("loadTasksToXmProjectState", projectId);
	}
	public int loadTasksSettleToXmProjectState(String projectId) {
		return this.update("loadTasksSettleToXmProjectState", projectId);
	}
}

