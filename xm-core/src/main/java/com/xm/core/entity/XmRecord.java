package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmRecord所有属性名: <br>
 *	id,projectId,operUserid,operUsername,operTime,objType,action,oldValue,newValue,remarks,reqNo,branchId,ip,bizId,pbizId,productId;<br>
 * 表 xm_record xm_record的所有字段名: <br>
 *	id,project_id,oper_userid,oper_username,oper_time,obj_type,action,old_value,new_value,remarks,req_no,branch_id,ip,biz_id,pbiz_id,product_id;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_record")
public class XmRecord  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="日志编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="操作人id",allowEmptyValue=true,example="",allowableValues="")
	String operUserid;
	
	@ApiModelProperty(notes="操作人名字",allowEmptyValue=true,example="",allowableValues="")
	String operUsername;
	
	@ApiModelProperty(notes="操作时间",allowEmptyValue=true,example="",allowableValues="")
	Date operTime;
	
	@ApiModelProperty(notes="操作对象project/task/phase/group/budget/cost",allowEmptyValue=true,example="",allowableValues="")
	String objType;
	
	@ApiModelProperty(notes="操作的id",allowEmptyValue=true,example="",allowableValues="")
	String action;
	
	@ApiModelProperty(notes="历史值",allowEmptyValue=true,example="",allowableValues="")
	String oldValue;
	
	@ApiModelProperty(notes="新值",allowEmptyValue=true,example="",allowableValues="")
	String newValue;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remarks;
	
	@ApiModelProperty(notes="请求编号，用于跟踪日志",allowEmptyValue=true,example="",allowableValues="")
	String reqNo;
	
	@ApiModelProperty(notes="机构编号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="ip地址",allowEmptyValue=true,example="",allowableValues="")
	String ip;
	
	@ApiModelProperty(notes="业务主键编号",allowEmptyValue=true,example="",allowableValues="")
	String bizId;
	
	@ApiModelProperty(notes="上级业务主键编号",allowEmptyValue=true,example="",allowableValues="")
	String pbizId;
	
	@ApiModelProperty(notes="产品编号",allowEmptyValue=true,example="",allowableValues="")
	String productId;

	/**日志编号**/
	public XmRecord(String id) {
		this.id = id;
	}
    
    /**xm_record**/
	public XmRecord() {
	}
	
	/**
	 * 日志编号
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 项目编号
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 操作人id
	 **/
	public void setOperUserid(String operUserid) {
		this.operUserid = operUserid;
	}
	/**
	 * 操作人名字
	 **/
	public void setOperUsername(String operUsername) {
		this.operUsername = operUsername;
	}
	/**
	 * 操作时间
	 **/
	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}
	/**
	 * 操作对象project/task/phase/group/budget/cost
	 **/
	public void setObjType(String objType) {
		this.objType = objType;
	}
	/**
	 * 操作的id
	 **/
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * 历史值
	 **/
	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}
	/**
	 * 新值
	 **/
	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}
	/**
	 * 备注
	 **/
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 请求编号，用于跟踪日志
	 **/
	public void setReqNo(String reqNo) {
		this.reqNo = reqNo;
	}
	/**
	 * 机构编号
	 **/
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	/**
	 * ip地址
	 **/
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * 业务主键编号
	 **/
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}
	/**
	 * 上级业务主键编号
	 **/
	public void setPbizId(String pbizId) {
		this.pbizId = pbizId;
	}
	/**
	 * 产品编号
	 **/
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	/**
	 * 日志编号
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 项目编号
	 **/
	public String getProjectId() {
		return this.projectId;
	}
	/**
	 * 操作人id
	 **/
	public String getOperUserid() {
		return this.operUserid;
	}
	/**
	 * 操作人名字
	 **/
	public String getOperUsername() {
		return this.operUsername;
	}
	/**
	 * 操作时间
	 **/
	public Date getOperTime() {
		return this.operTime;
	}
	/**
	 * 操作对象project/task/phase/group/budget/cost
	 **/
	public String getObjType() {
		return this.objType;
	}
	/**
	 * 操作的id
	 **/
	public String getAction() {
		return this.action;
	}
	/**
	 * 历史值
	 **/
	public String getOldValue() {
		return this.oldValue;
	}
	/**
	 * 新值
	 **/
	public String getNewValue() {
		return this.newValue;
	}
	/**
	 * 备注
	 **/
	public String getRemarks() {
		return this.remarks;
	}
	/**
	 * 请求编号，用于跟踪日志
	 **/
	public String getReqNo() {
		return this.reqNo;
	}
	/**
	 * 机构编号
	 **/
	public String getBranchId() {
		return this.branchId;
	}
	/**
	 * ip地址
	 **/
	public String getIp() {
		return this.ip;
	}
	/**
	 * 业务主键编号
	 **/
	public String getBizId() {
		return this.bizId;
	}
	/**
	 * 上级业务主键编号
	 **/
	public String getPbizId() {
		return this.pbizId;
	}
	/**
	 * 产品编号
	 **/
	public String getProductId() {
		return this.productId;
	}

}