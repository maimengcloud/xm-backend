package com.qqkj.xm.core.vo;

import java.util.List;

import com.qqkj.xm.core.entity.XmProjectGroup;
import com.qqkj.xm.core.entity.XmProjectGroupUser;

import io.swagger.annotations.ApiModel;

@ApiModel(description="xm_project_group")
public class XmProjectGroupVo extends XmProjectGroup {
	List<XmProjectGroupUser> groupUsers;

	public List<XmProjectGroupUser> getGroupUsers() { return groupUsers; }

	public void setGroupUsers(List<XmProjectGroupUser> groupUsers) { this.groupUsers = groupUsers; }
}