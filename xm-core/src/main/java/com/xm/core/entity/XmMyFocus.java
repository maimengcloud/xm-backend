package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 组织 com.qqkj  顶级模块 oa 大模块 xm  小模块 <br> 
 * 实体 XmMyFocus所有属性名: <br>
 *	userid,username,taskId,focusType,projectId,id,projectName,taskName;<br>
 * 表 XM.xm_my_focus xm_my_focus的所有字段名: <br>
 *	userid,username,task_id,focus_type,project_id,id,project_name,task_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_my_focus")
public class XmMyFocus  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="用户编号",allowEmptyValue=true,example="",allowableValues="")
	String userid;
	
	@ApiModelProperty(notes="用户名称",allowEmptyValue=true,example="",allowableValues="")
	String username;
	
	@ApiModelProperty(notes="关注的任务主键",allowEmptyValue=true,example="",allowableValues="")
	String taskId;
	
	@ApiModelProperty(notes="对象类型项目-project/任务-task",allowEmptyValue=true,example="",allowableValues="")
	String focusType;
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="项目名称",allowEmptyValue=true,example="",allowableValues="")
	String projectName;
	
	@ApiModelProperty(notes="任务名称",allowEmptyValue=true,example="",allowableValues="")
	String taskName;

	/**主键**/
	public XmMyFocus(String id) {
		this.id = id;
	}
    
    /**xm_my_focus**/
	public XmMyFocus() {
	}
	
	/**
	 * 用户编号
	 **/
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 用户名称
	 **/
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 关注的任务主键
	 **/
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	/**
	 * 对象类型项目-project/任务-task
	 **/
	public void setFocusType(String focusType) {
		this.focusType = focusType;
	}
	/**
	 * 项目编号
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 项目名称
	 **/
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 任务名称
	 **/
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	/**
	 * 用户编号
	 **/
	public String getUserid() {
		return this.userid;
	}
	/**
	 * 用户名称
	 **/
	public String getUsername() {
		return this.username;
	}
	/**
	 * 关注的任务主键
	 **/
	public String getTaskId() {
		return this.taskId;
	}
	/**
	 * 对象类型项目-project/任务-task
	 **/
	public String getFocusType() {
		return this.focusType;
	}
	/**
	 * 项目编号
	 **/
	public String getProjectId() {
		return this.projectId;
	}
	/**
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 项目名称
	 **/
	public String getProjectName() {
		return this.projectName;
	}
	/**
	 * 任务名称
	 **/
	public String getTaskName() {
		return this.taskName;
	}

}