package com.qqkj.xm.core.vo;

import java.util.List;

import com.qqkj.xm.core.entity.XmAttachment;
import com.qqkj.xm.core.entity.XmFile;

import io.swagger.annotations.ApiModel;

@ApiModel(description="xm_task")
public class XmFileVo extends XmFile {
    List<XmAttachment> attachment;

    public List<XmAttachment> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<XmAttachment> attachment) {
        this.attachment = attachment;
    }
}
