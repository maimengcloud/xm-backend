package com.xm.core.service;

import com.mdp.core.service.BaseService;
import com.xm.core.entity.XmTestPlanCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmTestPlanCase 表 xm_test_plan_case 当前主键(包括多主键): case_id,plan_id; 
 ***/
@Service("xm.core.xmTestPlanCaseService")
public class XmTestPlanCaseService extends BaseService {
	static Logger logger =LoggerFactory.getLogger(XmTestPlanCaseService.class);

    public List<XmTestPlanCase> selectListByCaseIdsAndPlanId(String planId, List<String> caseIds) {
        return super.selectList("selectListByCaseIdsAndPlanId",map("planId",planId,"caseIds",caseIds));
    }

    public List<Map<String, Object>> getXmTestPlanCaseExecStatusDist(Map<String, Object> xmTestPlanCase) {
        return super.selectList("getXmTestPlanCaseExecStatusDist",xmTestPlanCase);
    }

    public List<Map<String, Object>> getXmTestPlanCaseUserDist(Map<String, Object> xmTestPlanCase) {
        return super.selectList("getXmTestPlanCaseUserDist",xmTestPlanCase);
    }
}

