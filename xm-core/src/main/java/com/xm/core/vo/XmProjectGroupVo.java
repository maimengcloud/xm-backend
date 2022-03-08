package com.xm.core.vo;

import com.xm.core.entity.XmProjectGroup;
import com.xm.core.entity.XmProjectGroupUser;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(description="xm_group")
public class XmProjectGroupVo extends XmProjectGroup {
	List<XmProjectGroupUser> groupUsers;

	public List<XmProjectGroupUser> getGroupUsers() { return groupUsers; }

	public void setGroupUsers(List<XmProjectGroupUser> groupUsers) { this.groupUsers = groupUsers; }
}