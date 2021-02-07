package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com.qqkj  顶级模块 oa 大模块 xm  小模块 <br> 
 * 实体 XmProjectPhaseBaseline所有属性名: <br>
 *	baseCtime,projectPhaseId,phaseName,remark,parentPhaseId,branchId,projectId,beginDate,endDate,planWorkingHours,planWorkingStaffNu,ctime,totalBudgetNouser,totalBudgetInnerUser,totalBudgetOutUser,id,baseRemark,projectBaselineId,bizProcInstId,bizFlowState,totalBudgetWorkload,totalActWorkload;<br>
 * 表 XM.xm_project_phase_baseline xm_project_phase_baseline的所有字段名: <br>
 *	base_ctime,project_phase_id,phase_name,remark,parent_phase_id,branch_id,project_id,begin_date,end_date,plan_working_hours,plan_working_staff_nu,ctime,total_budget_nouser,total_budget_inner_user,total_budget_out_user,id,base_remark,project_baseline_id,biz_proc_inst_id,biz_flow_state,total_budget_workload,total_act_workload;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_project_phase_baseline")
public class XmProjectPhaseBaseline  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="基线主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="基线建立时间",allowEmptyValue=true,example="",allowableValues="")
	Date baseCtime;
	
	@ApiModelProperty(notes="阶段主键",allowEmptyValue=true,example="",allowableValues="")
	String projectPhaseId;
	
	@ApiModelProperty(notes="阶段名称",allowEmptyValue=true,example="",allowableValues="")
	String phaseName;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="上级阶段编号",allowEmptyValue=true,example="",allowableValues="")
	String parentPhaseId;
	
	@ApiModelProperty(notes="机构编号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="当前项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date beginDate;
	
	@ApiModelProperty(notes="结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date endDate;
	
	@ApiModelProperty(notes="工时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planWorkingHours;
	
	@ApiModelProperty(notes="投入人员数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planWorkingStaffNu;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="非人力成本总预算",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalBudgetNouser;
	
	@ApiModelProperty(notes="内部人力成本总预算",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalBudgetInnerUser;
	
	@ApiModelProperty(notes="外购人力成本总预算",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalBudgetOutUser;
	
	@ApiModelProperty(notes="基线备注",allowEmptyValue=true,example="",allowableValues="")
	String baseRemark;
	
	@ApiModelProperty(notes="项目级基线",allowEmptyValue=true,example="",allowableValues="")
	String projectBaselineId;
	
	@ApiModelProperty(notes="当前流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String bizProcInstId;
	
	@ApiModelProperty(notes="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;
	
	@ApiModelProperty(notes="总工作量单位人时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalBudgetWorkload;
	
	@ApiModelProperty(notes="已完成工作量单位人时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalActWorkload;

	/**基线主键**/
	public XmProjectPhaseBaseline(String id) {
		this.id = id;
	}
    
    /**xm_project_phase_baseline**/
	public XmProjectPhaseBaseline() {
	}
	
	/**
	 * 基线建立时间
	 **/
	public void setBaseCtime(Date baseCtime) {
		this.baseCtime = baseCtime;
	}
	/**
	 * 阶段主键
	 **/
	public void setProjectPhaseId(String projectPhaseId) {
		this.projectPhaseId = projectPhaseId;
	}
	/**
	 * 阶段名称
	 **/
	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}
	/**
	 * 备注
	 **/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 上级阶段编号
	 **/
	public void setParentPhaseId(String parentPhaseId) {
		this.parentPhaseId = parentPhaseId;
	}
	/**
	 * 机构编号
	 **/
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	/**
	 * 当前项目编号
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 开始时间
	 **/
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	/**
	 * 结束时间
	 **/
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * 工时
	 **/
	public void setPlanWorkingHours(BigDecimal planWorkingHours) {
		this.planWorkingHours = planWorkingHours;
	}
	/**
	 * 投入人员数
	 **/
	public void setPlanWorkingStaffNu(BigDecimal planWorkingStaffNu) {
		this.planWorkingStaffNu = planWorkingStaffNu;
	}
	/**
	 * 创建时间
	 **/
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	/**
	 * 非人力成本总预算
	 **/
	public void setTotalBudgetNouser(BigDecimal totalBudgetNouser) {
		this.totalBudgetNouser = totalBudgetNouser;
	}
	/**
	 * 内部人力成本总预算
	 **/
	public void setTotalBudgetInnerUser(BigDecimal totalBudgetInnerUser) {
		this.totalBudgetInnerUser = totalBudgetInnerUser;
	}
	/**
	 * 外购人力成本总预算
	 **/
	public void setTotalBudgetOutUser(BigDecimal totalBudgetOutUser) {
		this.totalBudgetOutUser = totalBudgetOutUser;
	}
	/**
	 * 基线主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 基线备注
	 **/
	public void setBaseRemark(String baseRemark) {
		this.baseRemark = baseRemark;
	}
	/**
	 * 项目级基线
	 **/
	public void setProjectBaselineId(String projectBaselineId) {
		this.projectBaselineId = projectBaselineId;
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
	 * 总工作量单位人时
	 **/
	public void setTotalBudgetWorkload(BigDecimal totalBudgetWorkload) {
		this.totalBudgetWorkload = totalBudgetWorkload;
	}
	/**
	 * 已完成工作量单位人时
	 **/
	public void setTotalActWorkload(BigDecimal totalActWorkload) {
		this.totalActWorkload = totalActWorkload;
	}
	
	/**
	 * 基线建立时间
	 **/
	public Date getBaseCtime() {
		return this.baseCtime;
	}
	/**
	 * 阶段主键
	 **/
	public String getProjectPhaseId() {
		return this.projectPhaseId;
	}
	/**
	 * 阶段名称
	 **/
	public String getPhaseName() {
		return this.phaseName;
	}
	/**
	 * 备注
	 **/
	public String getRemark() {
		return this.remark;
	}
	/**
	 * 上级阶段编号
	 **/
	public String getParentPhaseId() {
		return this.parentPhaseId;
	}
	/**
	 * 机构编号
	 **/
	public String getBranchId() {
		return this.branchId;
	}
	/**
	 * 当前项目编号
	 **/
	public String getProjectId() {
		return this.projectId;
	}
	/**
	 * 开始时间
	 **/
	public Date getBeginDate() {
		return this.beginDate;
	}
	/**
	 * 结束时间
	 **/
	public Date getEndDate() {
		return this.endDate;
	}
	/**
	 * 工时
	 **/
	public BigDecimal getPlanWorkingHours() {
		return this.planWorkingHours;
	}
	/**
	 * 投入人员数
	 **/
	public BigDecimal getPlanWorkingStaffNu() {
		return this.planWorkingStaffNu;
	}
	/**
	 * 创建时间
	 **/
	public Date getCtime() {
		return this.ctime;
	}
	/**
	 * 非人力成本总预算
	 **/
	public BigDecimal getTotalBudgetNouser() {
		return this.totalBudgetNouser;
	}
	/**
	 * 内部人力成本总预算
	 **/
	public BigDecimal getTotalBudgetInnerUser() {
		return this.totalBudgetInnerUser;
	}
	/**
	 * 外购人力成本总预算
	 **/
	public BigDecimal getTotalBudgetOutUser() {
		return this.totalBudgetOutUser;
	}
	/**
	 * 基线主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 基线备注
	 **/
	public String getBaseRemark() {
		return this.baseRemark;
	}
	/**
	 * 项目级基线
	 **/
	public String getProjectBaselineId() {
		return this.projectBaselineId;
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
	 * 总工作量单位人时
	 **/
	public BigDecimal getTotalBudgetWorkload() {
		return this.totalBudgetWorkload;
	}
	/**
	 * 已完成工作量单位人时
	 **/
	public BigDecimal getTotalActWorkload() {
		return this.totalActWorkload;
	}

}