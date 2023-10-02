package com.xm.core.service;

import com.mdp.core.service.BaseService;
import com.xm.core.entity.XmBranchStateHis;
import com.xm.core.mapper.XmBranchStateHisMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmBranchStateHis 表 xm_branch_state_his 当前主键(包括多主键): biz_date,branch_id; 
 ***/
@Service("xm.core.xmBranchStateHisService")
public class XmBranchStateHisService extends BaseService<XmBranchStateHisMapper, XmBranchStateHis> {
	static Logger logger =LoggerFactory.getLogger(XmBranchStateHisService.class);

    public List<Map<String, Object>> listXmBranchFiveDayTaskCnt(Map<String, Object> xmBranchStateHis) {
        return super.selectList("listXmBranchFiveDayTaskCnt",xmBranchStateHis);
    }
}

