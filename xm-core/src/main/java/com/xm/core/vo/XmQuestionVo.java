package com.xm.core.vo;

import com.xm.core.entity.XmAttachment;
import com.xm.core.entity.XmQuestion;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(description="xm_task")
public class XmQuestionVo extends XmQuestion {
    List<XmAttachment> attachment;
    
    String receiptMessage;
    String tardgetBugStatus;

    public List<XmAttachment> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<XmAttachment> attachment) {
        this.attachment = attachment;
    }

	public String getReceiptMessage() {
		return receiptMessage;
	}

	public void setReceiptMessage(String receiptMessage) {
		this.receiptMessage = receiptMessage;
	}

	public String getTardgetBugStatus() {
		return tardgetBugStatus;
	}

	public void setTardgetBugStatus(String tardgetBugStatus) {
		this.tardgetBugStatus = tardgetBugStatus;
	}

	 
    
}
