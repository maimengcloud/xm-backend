package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 组织 com.qqkj  顶级模块 oa 大模块 xm  小模块 <br> 
 * 实体 XmProjectOptions所有属性名: <br>
 *	id,branchId,optionType,name;<br>
 * 表 XM.xm_project_options xm_project_options的所有字段名: <br>
 *	id,branch_id,option_type,name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_project_options")
public class XmProjectOptions  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="机构编号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="选项类型，0项目类型，1紧急程度，2优先程度",allowEmptyValue=true,example="",allowableValues="")
	String optionType;
	
	@ApiModelProperty(notes="选项名字",allowEmptyValue=true,example="",allowableValues="")
	String name;

	/**主键**/
	public XmProjectOptions(String id) {
		this.id = id;
	}
    
    /**xm_project_options**/
	public XmProjectOptions() {
	}
	
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 机构编号
	 **/
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	/**
	 * 选项类型，0项目类型，1紧急程度，2优先程度
	 **/
	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}
	/**
	 * 选项名字
	 **/
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 机构编号
	 **/
	public String getBranchId() {
		return this.branchId;
	}
	/**
	 * 选项类型，0项目类型，1紧急程度，2优先程度
	 **/
	public String getOptionType() {
		return this.optionType;
	}
	/**
	 * 选项名字
	 **/
	public String getName() {
		return this.name;
	}

}