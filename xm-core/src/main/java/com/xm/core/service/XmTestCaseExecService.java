package com.xm.core.service;

import com.mdp.core.service.BaseService;
import com.xm.core.entity.XmTestCaseExec;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmTestCaseExec 表 XM.xm_test_case_exec 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmTestCaseExecService")
public class XmTestCaseExecService extends BaseService {

	public List<XmTestCaseExec> listByProjectAndCaseIds(String projectId, List<String> caseIds) {
		// TODO Auto-generated method stub
		Map<String,Object> p=new HashMap<>();
		p.put("projectId", projectId);
		p.put("caseIds", caseIds.toArray());
		return this.selectList("listByProjectAndCaseIds", p);
	}
	
	/** 请在此类添加自定义函数 */

}

