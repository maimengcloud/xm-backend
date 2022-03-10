package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 组织 com.qqkj  顶级模块 oa 大模块 xm  小模块 <br> 
 * 实体 XmProjectMBudgetCostUser所有属性名: <br>
 *	projectId,userid,budgetCost,id,remark,username,subjectId,bizzStartDate,bizzEndDate,bizzMonth,bizProcInstId,bizFlowState,projectPhaseId,costType;<br>
 * 表 XM.xm_project_m_budget_cost_user xm_project_m_budget_cost_user的所有字段名: <br>
 *	project_id,userid,budget_cost,id,remark,username,subject_id,bizz_start_date,bizz_end_date,bizz_month,biz_proc_inst_id,biz_flow_state,project_phase_id,cost_type;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_project_m_budget_cost_user")
public class XmProjectMBudgetCostUser  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="项目成员编号",allowEmptyValue=true,example="",allowableValues="")
	String userid;
	
	@ApiModelProperty(notes="预算金额/每月",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetCost;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="用户名",allowEmptyValue=true,example="",allowableValues="")
	String username;
	
	@ApiModelProperty(notes="预算科目编号",allowEmptyValue=true,example="",allowableValues="")
	String subjectId;
	
	@ApiModelProperty(notes="费用归属周期开始日期",allowEmptyValue=true,example="",allowableValues="")
	Date bizzStartDate;
	
	@ApiModelProperty(notes="费用归属周期结束日期",allowEmptyValue=true,example="",allowableValues="")
	Date bizzEndDate;
	
	@ApiModelProperty(notes="费用归属月份yyyy-mm",allowEmptyValue=true,example="",allowableValues="")
	String bizzMonth;
	
	@ApiModelProperty(notes="当前流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String bizProcInstId;
	
	@ApiModelProperty(notes="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;
	
	@ApiModelProperty(notes="项目计划",allowEmptyValue=true,example="",allowableValues="")
	String projectPhaseId;
	
	@ApiModelProperty(notes="成本类型0非人力1内部人力2外购人力",allowEmptyValue=true,example="",allowableValues="")
	String costType;

	/**主键**/
	public XmProjectMBudgetCostUser(String id) {
		this.id = id;
	}
    
    /**xm_project_m_budget_cost_user**/
	public XmProjectMBudgetCostUser() {
	}
	
	/**
	 * 项目编号
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 项目成员编号
	 **/
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 预算金额/每月
	 **/
	public void setBudgetCost(BigDecimal budgetCost) {
		this.budgetCost = budgetCost;
	}
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 备注
	 **/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 用户名
	 **/
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 预算科目编号
	 **/
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	/**
	 * 费用归属周期开始日期
	 **/
	public void setBizzStartDate(Date bizzStartDate) {
		this.bizzStartDate = bizzStartDate;
	}
	/**
	 * 费用归属周期结束日期
	 **/
	public void setBizzEndDate(Date bizzEndDate) {
		this.bizzEndDate = bizzEndDate;
	}
	/**
	 * 费用归属月份yyyy-mm
	 **/
	public void setBizzMonth(String bizzMonth) {
		this.bizzMonth = bizzMonth;
	}
	/**
	 * 当前流程实例编号
	 **/
	public void setBizProcInstId(String bizProcInstId) {
		this.bizProcInstId = bizProcInstId;
	}
	/**
	 * 当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除
	 **/
	public void setBizFlowState(String bizFlowState) {
		this.bizFlowState = bizFlowState;
	}
	/**
	 * 项目计划
	 **/
	public void setPhaseId(String projectPhaseId) {
		this.projectPhaseId = projectPhaseId;
	}
	/**
	 * 成本类型0非人力1内部人力2外购人力
	 **/
	public void setCostType(String costType) {
		this.costType = costType;
	}
	
	/**
	 * 项目编号
	 **/
	public String getProjectId() {
		return this.projectId;
	}
	/**
	 * 项目成员编号
	 **/
	public String getUserid() {
		return this.userid;
	}
	/**
	 * 预算金额/每月
	 **/
	public BigDecimal getBudgetCost() {
		return this.budgetCost;
	}
	/**
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 备注
	 **/
	public String getRemark() {
		return this.remark;
	}
	/**
	 * 用户名
	 **/
	public String getUsername() {
		return this.username;
	}
	/**
	 * 预算科目编号
	 **/
	public String getSubjectId() {
		return this.subjectId;
	}
	/**
	 * 费用归属周期开始日期
	 **/
	public Date getBizzStartDate() {
		return this.bizzStartDate;
	}
	/**
	 * 费用归属周期结束日期
	 **/
	public Date getBizzEndDate() {
		return this.bizzEndDate;
	}
	/**
	 * 费用归属月份yyyy-mm
	 **/
	public String getBizzMonth() {
		return this.bizzMonth;
	}
	/**
	 * 当前流程实例编号
	 **/
	public String getBizProcInstId() {
		return this.bizProcInstId;
	}
	/**
	 * 当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除
	 **/
	public String getBizFlowState() {
		return this.bizFlowState;
	}
	/**
	 * 项目计划
	 **/
	public String getPhaseId() {
		return this.projectPhaseId;
	}
	/**
	 * 成本类型0非人力1内部人力2外购人力
	 **/
	public String getCostType() {
		return this.costType;
	}

}