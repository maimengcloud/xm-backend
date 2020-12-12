package com.qqkj.xm.core.vo;

import java.util.List;

import com.qqkj.xm.core.entity.XmProject;

public class XmProjectVo extends XmProject {
	
	List<XmProjectGroupVo> groups;
	
	

	public List<XmProjectGroupVo> getGroups() {
		return groups;
	}

	public void setGroups(List<XmProjectGroupVo> groups) {
		this.groups = groups;
	}
}
