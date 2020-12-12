package com.qqkj.xm.core.service;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.qqkj.mdp.core.service.BaseService;
import com.qqkj.xm.core.entity.XmBranchState;
/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmBranchState 表 XM.xm_branch_state 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmBranchStateService")
public class XmBranchStateService extends BaseService {

	public void loadProjectStateToXmBranchState(String branchId) {
		this.update("loadProjectStateToXmBranchState", branchId);
		
	}
	
	/** 请在此类添加自定义函数 */

}

