package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 组织 com.qqkj  顶级模块 oa 大模块 xm  小模块 <br> 
 * 实体 XmQuestionTag所有属性名: <br>
 *	questionId,tagId,tagName,ctime,id;<br>
 * 表 XM.xm_question_tag 问题标签关联表的所有字段名: <br>
 *	question_id,tag_id,tag_name,ctime,id;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="问题标签关联表")
public class XmQuestionTag  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="问题编号",allowEmptyValue=true,example="",allowableValues="")
	String questionId;
	
	@ApiModelProperty(notes="标签编号",allowEmptyValue=true,example="",allowableValues="")
	String tagId;
	
	@ApiModelProperty(notes="标签名称",allowEmptyValue=true,example="",allowableValues="")
	String tagName;
	
	@ApiModelProperty(notes="添加时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;

	/**主键**/
	public XmQuestionTag(String id) {
		this.id = id;
	}
    
    /**问题标签关联表**/
	public XmQuestionTag() {
	}
	
	/**
	 * 问题编号
	 **/
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	/**
	 * 标签编号
	 **/
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
	/**
	 * 标签名称
	 **/
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	/**
	 * 添加时间
	 **/
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 问题编号
	 **/
	public String getQuestionId() {
		return this.questionId;
	}
	/**
	 * 标签编号
	 **/
	public String getTagId() {
		return this.tagId;
	}
	/**
	 * 标签名称
	 **/
	public String getTagName() {
		return this.tagName;
	}
	/**
	 * 添加时间
	 **/
	public Date getCtime() {
		return this.ctime;
	}
	/**
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}

}