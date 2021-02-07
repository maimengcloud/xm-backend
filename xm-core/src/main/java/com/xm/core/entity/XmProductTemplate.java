package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com.qqkj  顶级模块 oa 大模块 xm  小模块 <br> 
 * 实体 XmProductTemplate所有属性名: <br>
 *	id,productName,branchId,remark,templateId,tcuserid,tcusername,tremark,tctime,tcbranchId,shareScope;<br>
 * 表 XM.xm_product_template 产品表的所有字段名: <br>
 *	id,product_name,branch_id,remark,template_id,tcuserid,tcusername,tremark,tctime,tcbranch_id,share_scope;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="产品表")
public class XmProductTemplate  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="产品编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="产品名称",allowEmptyValue=true,example="",allowableValues="")
	String productName;
	
	@ApiModelProperty(notes="机构号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="项目模板编号",allowEmptyValue=true,example="",allowableValues="")
	String templateId;
	
	@ApiModelProperty(notes="模板创建人编号",allowEmptyValue=true,example="",allowableValues="")
	String tcuserid;
	
	@ApiModelProperty(notes="模板创建人姓名",allowEmptyValue=true,example="",allowableValues="")
	String tcusername;
	
	@ApiModelProperty(notes="模板备注",allowEmptyValue=true,example="",allowableValues="")
	String tremark;
	
	@ApiModelProperty(notes="模板创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date tctime;
	
	@ApiModelProperty(notes="模板创建机构编号",allowEmptyValue=true,example="",allowableValues="")
	String tcbranchId;
	
	@ApiModelProperty(notes="共享范围0-全部,1-本机构",allowEmptyValue=true,example="",allowableValues="")
	String shareScope;

	/**产品编号**/
	public XmProductTemplate(String id) {
		this.id = id;
	}
    
    /**产品表**/
	public XmProductTemplate() {
	}
	
	/**
	 * 产品编号
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 产品名称
	 **/
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * 机构号
	 **/
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	/**
	 * 备注
	 **/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 项目模板编号
	 **/
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	/**
	 * 模板创建人编号
	 **/
	public void setTcuserid(String tcuserid) {
		this.tcuserid = tcuserid;
	}
	/**
	 * 模板创建人姓名
	 **/
	public void setTcusername(String tcusername) {
		this.tcusername = tcusername;
	}
	/**
	 * 模板备注
	 **/
	public void setTremark(String tremark) {
		this.tremark = tremark;
	}
	/**
	 * 模板创建时间
	 **/
	public void setTctime(Date tctime) {
		this.tctime = tctime;
	}
	/**
	 * 模板创建机构编号
	 **/
	public void setTcbranchId(String tcbranchId) {
		this.tcbranchId = tcbranchId;
	}
	/**
	 * 共享范围0-全部,1-本机构
	 **/
	public void setShareScope(String shareScope) {
		this.shareScope = shareScope;
	}
	
	/**
	 * 产品编号
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 产品名称
	 **/
	public String getProductName() {
		return this.productName;
	}
	/**
	 * 机构号
	 **/
	public String getBranchId() {
		return this.branchId;
	}
	/**
	 * 备注
	 **/
	public String getRemark() {
		return this.remark;
	}
	/**
	 * 项目模板编号
	 **/
	public String getTemplateId() {
		return this.templateId;
	}
	/**
	 * 模板创建人编号
	 **/
	public String getTcuserid() {
		return this.tcuserid;
	}
	/**
	 * 模板创建人姓名
	 **/
	public String getTcusername() {
		return this.tcusername;
	}
	/**
	 * 模板备注
	 **/
	public String getTremark() {
		return this.tremark;
	}
	/**
	 * 模板创建时间
	 **/
	public Date getTctime() {
		return this.tctime;
	}
	/**
	 * 模板创建机构编号
	 **/
	public String getTcbranchId() {
		return this.tcbranchId;
	}
	/**
	 * 共享范围0-全部,1-本机构
	 **/
	public String getShareScope() {
		return this.shareScope;
	}

}