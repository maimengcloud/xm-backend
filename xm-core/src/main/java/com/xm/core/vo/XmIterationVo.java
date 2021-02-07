package com.xm.core.vo;

import com.xm.core.entity.XmIteration;

public class XmIterationVo extends XmIteration {
	private static final long serialVersionUID = 1534268338972176747L;
	
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
