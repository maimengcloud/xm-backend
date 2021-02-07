package com.xm.core.vo;

import com.xm.core.entity.XmProject;

import java.util.List;

public class XmProjectVo extends XmProject {
	
	List<XmProjectGroupVo> groups;
	
	

	public List<XmProjectGroupVo> getGroups() {
		return groups;
	}

	public void setGroups(List<XmProjectGroupVo> groups) {
		this.groups = groups;
	}
}
