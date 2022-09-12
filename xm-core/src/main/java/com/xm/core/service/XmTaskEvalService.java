package com.xm.core.service;

import com.mdp.core.service.BaseService;
import com.mdp.safe.client.entity.User;
import com.xm.core.entity.MyTotalEval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmTaskEval 表 xm_task_eval 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmTaskEvalService")
public class XmTaskEvalService extends BaseService {
	static Logger logger =LoggerFactory.getLogger(XmTaskEvalService.class);

    public MyTotalEval getServiceProviderEval(User user) {
        return super.selectOne("getServiceProviderEval",user);
    }

    public MyTotalEval getPersonEval(User user) {
        return super.selectOne("getPersonEval",user);
    }
}

