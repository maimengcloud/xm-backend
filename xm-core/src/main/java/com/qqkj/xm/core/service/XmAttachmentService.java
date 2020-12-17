package com.qqkj.xm.core.service;

import com.qqkj.mdp.core.service.BaseService;
import com.qqkj.xm.core.entity.XmAttachment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com.qqkj  顶级模块 oa 大模块 xm 小模块 <br>
 * 实体 XmAttachment 表 XM.xm_attachment 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmAttachmentService")
public class XmAttachmentService extends BaseService {
	
    public void insertOrUpdate(String originId,String originType, List<XmAttachment> attachmentList) {
        XmAttachment del = new XmAttachment();
        del.setOriginId(originId);
        del.setOriginType(originType);
        this.delete("deleteByOrigin",del);
        if(attachmentList.size() > 0) {
            attachmentList.forEach(attach->{
                attach.setOriginId(originId);
                attach.setOriginType(originType);
                this.insert(attach);
            });
        }
    }
    
	/** 请在此类添加自定义函数 */

}

