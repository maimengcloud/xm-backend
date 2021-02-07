package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 组织 com.qqkj  顶级模块 oa 大模块 xm  小模块 <br> 
 * 实体 XmIteration所有属性名: <br>
 *	id,branchId,iterationName,startTime,endTime,onlineTime,pid,adminUserid,adminUsername,ctime,budgetCost,budgetWorkload,seqNo,istatus,cuserid,cusername,remark;<br>
 * 表 XM.xm_iteration 迭代定义的所有字段名: <br>
 *	id,branch_id,iteration_name,start_time,end_time,online_time,pid,admin_userid,admin_username,ctime,budget_cost,budget_workload,seq_no,istatus,cuserid,cusername,remark;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="迭代定义")
public class XmIteration  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="迭代编码,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="机构编号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="迭代名称",allowEmptyValue=true,example="",allowableValues="")
	String iterationName;
	
	@ApiModelProperty(notes="开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date startTime;
	
	@ApiModelProperty(notes="结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date endTime;
	
	@ApiModelProperty(notes="上线时间",allowEmptyValue=true,example="",allowableValues="")
	Date onlineTime;
	
	@ApiModelProperty(notes="上级迭代",allowEmptyValue=true,example="",allowableValues="")
	String pid;
	
	@ApiModelProperty(notes="负责人",allowEmptyValue=true,example="",allowableValues="")
	String adminUserid;
	
	@ApiModelProperty(notes="负责人姓名",allowEmptyValue=true,example="",allowableValues="")
	String adminUsername;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="预算成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetCost;
	
	@ApiModelProperty(notes="预算工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetWorkload;
	
	@ApiModelProperty(notes="顺序号",allowEmptyValue=true,example="",allowableValues="")
	String seqNo;
	
	@ApiModelProperty(notes="迭代状态0未结束1已结束",allowEmptyValue=true,example="",allowableValues="")
	String istatus;
	
	@ApiModelProperty(notes="创建人编号",allowEmptyValue=true,example="",allowableValues="")
	String cuserid;
	
	@ApiModelProperty(notes="创建人人姓名",allowEmptyValue=true,example="",allowableValues="")
	String cusername;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;

	/**迭代编码**/
	public XmIteration(String id) {
		this.id = id;
	}
    
    /**迭代定义**/
	public XmIteration() {
	}
	
	/**
	 * 迭代编码
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
	 * 迭代名称
	 **/
	public void setIterationName(String iterationName) {
		this.iterationName = iterationName;
	}
	/**
	 * 开始时间
	 **/
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 结束时间
	 **/
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 上线时间
	 **/
	public void setOnlineTime(Date onlineTime) {
		this.onlineTime = onlineTime;
	}
	/**
	 * 上级迭代
	 **/
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 负责人
	 **/
	public void setAdminUserid(String adminUserid) {
		this.adminUserid = adminUserid;
	}
	/**
	 * 负责人姓名
	 **/
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	/**
	 * 创建时间
	 **/
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	/**
	 * 预算成本
	 **/
	public void setBudgetCost(BigDecimal budgetCost) {
		this.budgetCost = budgetCost;
	}
	/**
	 * 预算工作量
	 **/
	public void setBudgetWorkload(BigDecimal budgetWorkload) {
		this.budgetWorkload = budgetWorkload;
	}
	/**
	 * 顺序号
	 **/
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	/**
	 * 迭代状态0未结束1已结束
	 **/
	public void setIstatus(String istatus) {
		this.istatus = istatus;
	}
	/**
	 * 创建人编号
	 **/
	public void setCuserid(String cuserid) {
		this.cuserid = cuserid;
	}
	/**
	 * 创建人人姓名
	 **/
	public void setCusername(String cusername) {
		this.cusername = cusername;
	}
	/**
	 * 备注
	 **/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * 迭代编码
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
	 * 迭代名称
	 **/
	public String getIterationName() {
		return this.iterationName;
	}
	/**
	 * 开始时间
	 **/
	public Date getStartTime() {
		return this.startTime;
	}
	/**
	 * 结束时间
	 **/
	public Date getEndTime() {
		return this.endTime;
	}
	/**
	 * 上线时间
	 **/
	public Date getOnlineTime() {
		return this.onlineTime;
	}
	/**
	 * 上级迭代
	 **/
	public String getPid() {
		return this.pid;
	}
	/**
	 * 负责人
	 **/
	public String getAdminUserid() {
		return this.adminUserid;
	}
	/**
	 * 负责人姓名
	 **/
	public String getAdminUsername() {
		return this.adminUsername;
	}
	/**
	 * 创建时间
	 **/
	public Date getCtime() {
		return this.ctime;
	}
	/**
	 * 预算成本
	 **/
	public BigDecimal getBudgetCost() {
		return this.budgetCost;
	}
	/**
	 * 预算工作量
	 **/
	public BigDecimal getBudgetWorkload() {
		return this.budgetWorkload;
	}
	/**
	 * 顺序号
	 **/
	public String getSeqNo() {
		return this.seqNo;
	}
	/**
	 * 迭代状态0未结束1已结束
	 **/
	public String getIstatus() {
		return this.istatus;
	}
	/**
	 * 创建人编号
	 **/
	public String getCuserid() {
		return this.cuserid;
	}
	/**
	 * 创建人人姓名
	 **/
	public String getCusername() {
		return this.cusername;
	}
	/**
	 * 备注
	 **/
	public String getRemark() {
		return this.remark;
	}

}