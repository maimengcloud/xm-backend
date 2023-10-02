package com.xm.core.service;

import com.mdp.core.service.BaseService;
import com.xm.core.entity.XmQuestionHandle;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmQuestionHandle 表 XM.xm_question_handle 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmQuestionHandleService")
public class XmQuestionHandleService extends BaseService<XmQuestionHandleMapper,XmQuestionHandle> {

    @Async
    public void batchAddAsync(List<XmQuestionHandle> handles) {
        super.batchInsert(handles);
    }

    /** 请在此类添加自定义函数 */

}

