package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 组织 com.qqkj  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmMenu所有属性名: <br>
 *	menuId,menuName,pmenuId,productId,remark,status,online,demandUrl,codeUrl,designUrl,docUrl,helpUrl,operDocUrl,seqNo,mmUserid,mmUsername;<br>
 * 表 XM.xm_menu 功能表的所有字段名: <br>
 *	menu_id,menu_name,pmenu_id,product_id,remark,status,online,demand_url,code_url,design_url,doc_url,help_url,oper_doc_url,seq_no,mm_userid,mm_username;<br>
 * 当前主键(包括多主键):<br>
 *	menu_id;<br>
 */
@ApiModel(description="功能表")
public class XmMenu  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="功能编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String menuId;
  	
	
	@ApiModelProperty(notes="功能名称",allowEmptyValue=true,example="",allowableValues="")
	String menuName;
	
	@ApiModelProperty(notes="上级功能",allowEmptyValue=true,example="",allowableValues="")
	String pmenuId;
	
	@ApiModelProperty(notes="归属产品编号",allowEmptyValue=true,example="",allowableValues="")
	String productId;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="状态0初始1设计中2开发中3测试中4uat测试2已上线3已下线4已删除",allowEmptyValue=true,example="",allowableValues="")
	String status;
	
	@ApiModelProperty(notes="是否已上线",allowEmptyValue=true,example="",allowableValues="")
	String online;
	
	@ApiModelProperty(notes="需求链接",allowEmptyValue=true,example="",allowableValues="")
	String demandUrl;
	
	@ApiModelProperty(notes="代码链接",allowEmptyValue=true,example="",allowableValues="")
	String codeUrl;
	
	@ApiModelProperty(notes="设计链接",allowEmptyValue=true,example="",allowableValues="")
	String designUrl;
	
	@ApiModelProperty(notes="文档链接",allowEmptyValue=true,example="",allowableValues="")
	String docUrl;
	
	@ApiModelProperty(notes="帮助文档链接",allowEmptyValue=true,example="",allowableValues="")
	String helpUrl;
	
	@ApiModelProperty(notes="操作手册链接",allowEmptyValue=true,example="",allowableValues="")
	String operDocUrl;
	
	@ApiModelProperty(notes="排序序号",allowEmptyValue=true,example="",allowableValues="")
	String seqNo;
	
	@ApiModelProperty(notes="故事管理员编号",allowEmptyValue=true,example="",allowableValues="")
	String mmUserid;
	
	@ApiModelProperty(notes="故事管理员姓名",allowEmptyValue=true,example="",allowableValues="")
	String mmUsername;

	/**功能编号**/
	public XmMenu(String menuId) {
		this.menuId = menuId;
	}
    
    /**功能表**/
	public XmMenu() {
	}
	
	/**
	 * 功能编号
	 **/
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	/**
	 * 功能名称
	 **/
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/**
	 * 上级功能
	 **/
	public void setPmenuId(String pmenuId) {
		this.pmenuId = pmenuId;
	}
	/**
	 * 归属产品编号
	 **/
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * 备注
	 **/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 状态0初始1设计中2开发中3测试中4uat测试2已上线3已下线4已删除
	 **/
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 是否已上线
	 **/
	public void setOnline(String online) {
		this.online = online;
	}
	/**
	 * 需求链接
	 **/
	public void setDemandUrl(String demandUrl) {
		this.demandUrl = demandUrl;
	}
	/**
	 * 代码链接
	 **/
	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}
	/**
	 * 设计链接
	 **/
	public void setDesignUrl(String designUrl) {
		this.designUrl = designUrl;
	}
	/**
	 * 文档链接
	 **/
	public void setDocUrl(String docUrl) {
		this.docUrl = docUrl;
	}
	/**
	 * 帮助文档链接
	 **/
	public void setHelpUrl(String helpUrl) {
		this.helpUrl = helpUrl;
	}
	/**
	 * 操作手册链接
	 **/
	public void setOperDocUrl(String operDocUrl) {
		this.operDocUrl = operDocUrl;
	}
	/**
	 * 排序序号
	 **/
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	/**
	 * 故事管理员编号
	 **/
	public void setMmUserid(String mmUserid) {
		this.mmUserid = mmUserid;
	}
	/**
	 * 故事管理员姓名
	 **/
	public void setMmUsername(String mmUsername) {
		this.mmUsername = mmUsername;
	}
	
	/**
	 * 功能编号
	 **/
	public String getMenuId() {
		return this.menuId;
	}
	/**
	 * 功能名称
	 **/
	public String getMenuName() {
		return this.menuName;
	}
	/**
	 * 上级功能
	 **/
	public String getPmenuId() {
		return this.pmenuId;
	}
	/**
	 * 归属产品编号
	 **/
	public String getProductId() {
		return this.productId;
	}
	/**
	 * 备注
	 **/
	public String getRemark() {
		return this.remark;
	}
	/**
	 * 状态0初始1设计中2开发中3测试中4uat测试2已上线3已下线4已删除
	 **/
	public String getStatus() {
		return this.status;
	}
	/**
	 * 是否已上线
	 **/
	public String getOnline() {
		return this.online;
	}
	/**
	 * 需求链接
	 **/
	public String getDemandUrl() {
		return this.demandUrl;
	}
	/**
	 * 代码链接
	 **/
	public String getCodeUrl() {
		return this.codeUrl;
	}
	/**
	 * 设计链接
	 **/
	public String getDesignUrl() {
		return this.designUrl;
	}
	/**
	 * 文档链接
	 **/
	public String getDocUrl() {
		return this.docUrl;
	}
	/**
	 * 帮助文档链接
	 **/
	public String getHelpUrl() {
		return this.helpUrl;
	}
	/**
	 * 操作手册链接
	 **/
	public String getOperDocUrl() {
		return this.operDocUrl;
	}
	/**
	 * 排序序号
	 **/
	public String getSeqNo() {
		return this.seqNo;
	}
	/**
	 * 故事管理员编号
	 **/
	public String getMmUserid() {
		return this.mmUserid;
	}
	/**
	 * 故事管理员姓名
	 **/
	public String getMmUsername() {
		return this.mmUsername;
	}

}