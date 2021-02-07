package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 组织 com.qqkj  顶级模块 oa 大模块 xm  小模块 <br> 
 * 实体 XmProjectGroup所有属性名: <br>
 *	id,groupName,projectId,pgTypeId,pgTypeName;<br>
 * 表 XM.xm_project_group xm_project_group的所有字段名: <br>
 *	id,group_name,project_id,pg_type_id,pg_type_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_project_group")
public class XmProjectGroup  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="团队名称",allowEmptyValue=true,example="",allowableValues="")
	String groupName;
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="项目团队类型编号",allowEmptyValue=true,example="",allowableValues="")
	String pgTypeId;
	
	@ApiModelProperty(notes="团队类型名称",allowEmptyValue=true,example="",allowableValues="")
	String pgTypeName;

	/**主键**/
	public XmProjectGroup(String id) {
		this.id = id;
	}
    
    /**xm_project_group**/
	public XmProjectGroup() {
	}
	
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 团队名称
	 **/
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/**
	 * 项目编号
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 项目团队类型编号
	 **/
	public void setPgTypeId(String pgTypeId) {
		this.pgTypeId = pgTypeId;
	}
	/**
	 * 团队类型名称
	 **/
	public void setPgTypeName(String pgTypeName) {
		this.pgTypeName = pgTypeName;
	}
	
	/**
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 团队名称
	 **/
	public String getGroupName() {
		return this.groupName;
	}
	/**
	 * 项目编号
	 **/
	public String getProjectId() {
		return this.projectId;
	}
	/**
	 * 项目团队类型编号
	 **/
	public String getPgTypeId() {
		return this.pgTypeId;
	}
	/**
	 * 团队类型名称
	 **/
	public String getPgTypeName() {
		return this.pgTypeName;
	}

}