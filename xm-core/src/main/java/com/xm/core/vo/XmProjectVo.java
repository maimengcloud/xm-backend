package com.xm.core.vo;

import com.xm.core.entity.XmProject;

import java.util.List;

public class XmProjectVo extends XmProject {
	
	List<XmGroupVo> groups;
	
	

	public List<XmGroupVo> getGroups() {
		return groups;
	}

	public void setGroups(List<XmGroupVo> groups) {
		this.groups = groups;
	}
}
