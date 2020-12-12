package com.qqkj.xm.core.vo;

import java.util.List;

import com.qqkj.xm.core.entity.XmMenu;

public class XmMenuPlanVo {
	String projectId;
	String projectName;
	List<XmMenu> xmMenus;
	
	
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<XmMenu> getXmMenus() {
		return xmMenus;
	}
	public void setXmMenus(List<XmMenu> xmMenus) {
		this.xmMenus = xmMenus;
	}
}
