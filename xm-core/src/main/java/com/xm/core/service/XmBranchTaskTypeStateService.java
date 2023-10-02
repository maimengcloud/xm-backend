package com.xm.core.service;

import com.mdp.core.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmBranchTaskTypeState 表 XM.xm_branch_task_type_state 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmBranchTaskTypeStateService")
public class XmBranchTaskTypeStateService extends BaseService<XmBranchTaskTypeStateMapper,XmBranchTaskTypeState> {

	public void loadProjectTaskTypeStateToXmBranchTaskTypeState(String branchId) {
		this.update("loadProjectTaskTypeStateToXmBranchTaskTypeState", branchId);
	}
	
	/** 请在此类添加自定义函数 */

}

