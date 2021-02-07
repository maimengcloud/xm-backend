package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com.qqkj  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmProduct所有属性名: <br>
 *	id,productName,branchId,remark,version,pmUserid,pmUsername,ctime;<br>
 * 表 XM.xm_product 产品表的所有字段名: <br>
 *	id,product_name,branch_id,remark,version,pm_userid,pm_username,ctime;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="产品表")
public class XmProduct  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="产品编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="产品名称",allowEmptyValue=true,example="",allowableValues="")
	String productName;
	
	@ApiModelProperty(notes="机构号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="版本号",allowEmptyValue=true,example="",allowableValues="")
	String version;
	
	@ApiModelProperty(notes="产品经理编号",allowEmptyValue=true,example="",allowableValues="")
	String pmUserid;
	
	@ApiModelProperty(notes="产品经理名称",allowEmptyValue=true,example="",allowableValues="")
	String pmUsername;
	
	@ApiModelProperty(notes="创建日期",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;

	/**产品编号**/
	public XmProduct(String id) {
		this.id = id;
	}
    
    /**产品表**/
	public XmProduct() {
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
	 * 版本号
	 **/
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * 产品经理编号
	 **/
	public void setPmUserid(String pmUserid) {
		this.pmUserid = pmUserid;
	}
	/**
	 * 产品经理名称
	 **/
	public void setPmUsername(String pmUsername) {
		this.pmUsername = pmUsername;
	}
	/**
	 * 创建日期
	 **/
	public void setCtime(Date ctime) {
		this.ctime = ctime;
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
	 * 版本号
	 **/
	public String getVersion() {
		return this.version;
	}
	/**
	 * 产品经理编号
	 **/
	public String getPmUserid() {
		return this.pmUserid;
	}
	/**
	 * 产品经理名称
	 **/
	public String getPmUsername() {
		return this.pmUsername;
	}
	/**
	 * 创建日期
	 **/
	public Date getCtime() {
		return this.ctime;
	}

}