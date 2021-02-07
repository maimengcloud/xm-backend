package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com.qqkj  顶级模块 oa 大模块 xm  小模块 <br> 
 * 实体 XmIterationMenu所有属性名: <br>
 *	id,iterationId,menuId,productId,ctime,relStatus,hasTask,cuserid,cusername;<br>
 * 表 XM.xm_iteration_menu 迭代定义的所有字段名: <br>
 *	id,iteration_id,menu_id,product_id,ctime,rel_status,has_task,cuserid,cusername;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="迭代定义")
public class XmIterationMenu  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="对应的迭代编号",allowEmptyValue=true,example="",allowableValues="")
	String iterationId;
	
	@ApiModelProperty(notes="故事编号",allowEmptyValue=true,example="",allowableValues="")
	String menuId;
	
	@ApiModelProperty(notes="产品编号",allowEmptyValue=true,example="",allowableValues="")
	String productId;
	
	@ApiModelProperty(notes="关联时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="关联状态0不再关联1正常关联",allowEmptyValue=true,example="",allowableValues="")
	String relStatus;
	
	@ApiModelProperty(notes="是否已有任务在关联0否1有",allowEmptyValue=true,example="",allowableValues="")
	String hasTask;
	
	@ApiModelProperty(notes="创建人编号",allowEmptyValue=true,example="",allowableValues="")
	String cuserid;
	
	@ApiModelProperty(notes="创建人姓名",allowEmptyValue=true,example="",allowableValues="")
	String cusername;

	/**主键**/
	public XmIterationMenu(String id) {
		this.id = id;
	}
    
    /**迭代定义**/
	public XmIterationMenu() {
	}
	
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 对应的迭代编号
	 **/
	public void setIterationId(String iterationId) {
		this.iterationId = iterationId;
	}
	/**
	 * 故事编号
	 **/
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	/**
	 * 产品编号
	 **/
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * 关联时间
	 **/
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	/**
	 * 关联状态0不再关联1正常关联
	 **/
	public void setRelStatus(String relStatus) {
		this.relStatus = relStatus;
	}
	/**
	 * 是否已有任务在关联0否1有
	 **/
	public void setHasTask(String hasTask) {
		this.hasTask = hasTask;
	}
	/**
	 * 创建人编号
	 **/
	public void setCuserid(String cuserid) {
		this.cuserid = cuserid;
	}
	/**
	 * 创建人姓名
	 **/
	public void setCusername(String cusername) {
		this.cusername = cusername;
	}
	
	/**
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 对应的迭代编号
	 **/
	public String getIterationId() {
		return this.iterationId;
	}
	/**
	 * 故事编号
	 **/
	public String getMenuId() {
		return this.menuId;
	}
	/**
	 * 产品编号
	 **/
	public String getProductId() {
		return this.productId;
	}
	/**
	 * 关联时间
	 **/
	public Date getCtime() {
		return this.ctime;
	}
	/**
	 * 关联状态0不再关联1正常关联
	 **/
	public String getRelStatus() {
		return this.relStatus;
	}
	/**
	 * 是否已有任务在关联0否1有
	 **/
	public String getHasTask() {
		return this.hasTask;
	}
	/**
	 * 创建人编号
	 **/
	public String getCuserid() {
		return this.cuserid;
	}
	/**
	 * 创建人姓名
	 **/
	public String getCusername() {
		return this.cusername;
	}

}