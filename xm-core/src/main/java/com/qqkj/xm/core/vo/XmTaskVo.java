package com.qqkj.xm.core.vo;

import com.qqkj.xm.core.entity.XmTask;

import io.swagger.annotations.ApiModel;

@ApiModel(description="xm_task")
public class XmTaskVo extends XmTask { 
	
	/**
	 * addSub,edit,delete
	 */
	String opType="";

	public String getOpType() {
		return opType;
	}

	public void setOpType(String opType) {
		this.opType = opType;
	}
	 
	 
}