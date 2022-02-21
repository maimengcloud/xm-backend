package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 组织 com.qqkj  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmProjectStateHis所有属性名: <br>
 *	projectId,bizDate,totalFileCnt,totalBugCnt,totalTaskCnt,totalBudgetNouserAmount,projectName,id,totalStaffCnt,calcTime,calcStatus,totalCostNouserAmount,totalClosedBugCnt,totalResolvedBugCnt,totalCompleteTaskCnt,totalPhaseCnt,totalCompletePhaseCnt,totalNeedPayAmount,totalFinishPayAmount,totalNeedColAmount,totalFinishColAmount,totalCostUserAmount,totalBudgetInnerUserAmount,totalPlanWorkload,totalRiskCnt,totalCompleteRiskCnt,branchId,branchName,totalBudgetOutUserAmount,totalCompleteWorkload,totalCostInnerUserAmount,totalCostOutUserAmount,totalProgress,totalActiveBugCnt,totalConfirmedBugCnt,projectStatus,totalActWorkload,totalActOutWorkload,totalActInnerWorkload,totalTaskBudgetCostAt,totalTaskOutCnt,totalNeedPayCnt,totalFinishPayCnt,totalFinishPayUserCnt,totalNeedPayUserCnt,totalPlanInnerUserWorkload,totalPlanOutUserWorkload,testCases,execCases,designCases,finishCases,iterationCnt,productCnt,menuCnt;<br>
 * 表 XM.xm_project_state_his 项目指标日统计表的所有字段名: <br>
 *	project_id,biz_date,total_file_cnt,total_bug_cnt,total_task_cnt,total_budget_nouser_amount,project_name,id,total_staff_cnt,calc_time,calc_status,total_cost_nouser_amount,total_closed_bug_cnt,total_resolved_bug_cnt,total_complete_task_cnt,total_phase_cnt,total_complete_phase_cnt,total_need_pay_amount,total_finish_pay_amount,total_need_col_amount,total_finish_col_amount,total_cost_user_amount,total_budget_inner_user_amount,total_plan_workload,total_risk_cnt,total_complete_risk_cnt,branch_id,branch_name,total_budget_out_user_amount,total_complete_workload,total_cost_inner_user_amount,total_cost_out_user_amount,total_progress,total_active_bug_cnt,total_confirmed_bug_cnt,project_status,total_act_workload,total_act_out_workload,total_act_inner_workload,total_task_budget_cost_at,total_task_out_cnt,total_need_pay_cnt,total_finish_pay_cnt,total_finish_pay_user_cnt,total_need_pay_user_cnt,total_plan_inner_user_workload,total_plan_out_user_workload,test_cases,exec_cases,design_cases,finish_cases,iteration_cnt,product_cnt,menu_cnt;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="项目指标日统计表")
public class XmProjectStateHis  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="统计日期yyyy-mm-dd类型",allowEmptyValue=true,example="",allowableValues="")
	String bizDate;
	
	@ApiModelProperty(notes="文件数据",allowEmptyValue=true,example="",allowableValues="")
	Integer totalFileCnt;
	
	@ApiModelProperty(notes="bug数目",allowEmptyValue=true,example="",allowableValues="")
	Integer totalBugCnt;
	
	@ApiModelProperty(notes="任务数",allowEmptyValue=true,example="",allowableValues="")
	Integer totalTaskCnt;
	
	@ApiModelProperty(notes="项目总非人力预算-来自项目表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalBudgetNouserAmount;
	
	@ApiModelProperty(notes="项目名称",allowEmptyValue=true,example="",allowableValues="")
	String projectName;
	
	@ApiModelProperty(notes="总参与人数",allowEmptyValue=true,example="",allowableValues="")
	Integer totalStaffCnt;
	
	@ApiModelProperty(notes="统计执行日期",allowEmptyValue=true,example="",allowableValues="")
	Date calcTime;
	
	@ApiModelProperty(notes="0-暂时的1稳定的，暂时的可以被覆盖，稳定的不允许覆盖",allowEmptyValue=true,example="",allowableValues="")
	String calcStatus;
	
	@ApiModelProperty(notes="项目总非人力成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalCostNouserAmount;
	
	@ApiModelProperty(notes="已关闭bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer totalClosedBugCnt;
	
	@ApiModelProperty(notes="已解决bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer totalResolvedBugCnt;
	
	@ApiModelProperty(notes="已完成任务总数-来自任务表",allowEmptyValue=true,example="",allowableValues="")
	Integer totalCompleteTaskCnt;
	
	@ApiModelProperty(notes="项目计划数",allowEmptyValue=true,example="",allowableValues="")
	Integer totalPhaseCnt;
	
	@ApiModelProperty(notes="项目计划已完成数",allowEmptyValue=true,example="",allowableValues="")
	Integer totalCompletePhaseCnt;
	
	@ApiModelProperty(notes="待付款总金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalNeedPayAmount;
	
	@ApiModelProperty(notes="已付款总金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalFinishPayAmount;
	
	@ApiModelProperty(notes="待收款总金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalNeedColAmount;
	
	@ApiModelProperty(notes="已收款总金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalFinishColAmount;
	
	@ApiModelProperty(notes="项目总人力成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalCostUserAmount;
	
	@ApiModelProperty(notes="项目总内部人力预算-来自项目表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalBudgetInnerUserAmount;
	
	@ApiModelProperty(notes="项目总预算工作量-来自项目表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalPlanWorkload;
	
	@ApiModelProperty(notes="项目风险总数",allowEmptyValue=true,example="",allowableValues="")
	Integer totalRiskCnt;
	
	@ApiModelProperty(notes="已完成风险总数",allowEmptyValue=true,example="",allowableValues="")
	Integer totalCompleteRiskCnt;
	
	@ApiModelProperty(notes="机构编号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="机构名称",allowEmptyValue=true,example="",allowableValues="")
	String branchName;
	
	@ApiModelProperty(notes="项目总外购人力预算-来自项目表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalBudgetOutUserAmount;
	
	@ApiModelProperty(notes="已完成工作量-来自计划中实际完成工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalCompleteWorkload;
	
	@ApiModelProperty(notes="项目总内部人力成本金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalCostInnerUserAmount;
	
	@ApiModelProperty(notes="项目总外购人力成本金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalCostOutUserAmount;
	
	@ApiModelProperty(notes="项目进度0~100之间，来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalProgress;
	
	@ApiModelProperty(notes="激活的bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer totalActiveBugCnt;
	
	@ApiModelProperty(notes="已解决bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer totalConfirmedBugCnt;
	
	@ApiModelProperty(notes="项目状态，0-初始，1-立项中，2-执行中，3-已结项，4-暂停",allowEmptyValue=true,example="",allowableValues="")
	String projectStatus;
	
	@ApiModelProperty(notes="实际总工作量，来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalActWorkload;
	
	@ApiModelProperty(notes="实际外购总工作量，来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalActOutWorkload;
	
	@ApiModelProperty(notes="实际内部总工作量，来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalActInnerWorkload;
	
	@ApiModelProperty(notes="已经分配到任务的总预算",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalTaskBudgetCostAt;
	
	@ApiModelProperty(notes="外购任务数，来自任务表",allowEmptyValue=true,example="",allowableValues="")
	Integer totalTaskOutCnt;
	
	@ApiModelProperty(notes="待付款笔数",allowEmptyValue=true,example="",allowableValues="")
	Integer totalNeedPayCnt;
	
	@ApiModelProperty(notes="完成付款总比数",allowEmptyValue=true,example="",allowableValues="")
	Integer totalFinishPayCnt;
	
	@ApiModelProperty(notes="已付款总人数",allowEmptyValue=true,example="",allowableValues="")
	Integer totalFinishPayUserCnt;
	
	@ApiModelProperty(notes="待付款总人数",allowEmptyValue=true,example="",allowableValues="")
	Integer totalNeedPayUserCnt;
	
	@ApiModelProperty(notes="内部人力总工作量-应该大于或等于计划内部人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalPlanInnerUserWorkload;
	
	@ApiModelProperty(notes="外购人力总工作量-应该大于或等于计划外购人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalPlanOutUserWorkload;
	
	@ApiModelProperty(notes="测试案例总数",allowEmptyValue=true,example="",allowableValues="")
	Integer testCases;
	
	@ApiModelProperty(notes="测试中案例总数",allowEmptyValue=true,example="",allowableValues="")
	Integer execCases;
	
	@ApiModelProperty(notes="设计中案例总数",allowEmptyValue=true,example="",allowableValues="")
	Integer designCases;
	
	@ApiModelProperty(notes="完成案例总数",allowEmptyValue=true,example="",allowableValues="")
	Integer finishCases;
	
	@ApiModelProperty(notes="迭代数",allowEmptyValue=true,example="",allowableValues="")
	Integer iterationCnt;
	
	@ApiModelProperty(notes="产品数",allowEmptyValue=true,example="",allowableValues="")
	Integer productCnt;
	
	@ApiModelProperty(notes="需求数",allowEmptyValue=true,example="",allowableValues="")
	Integer menuCnt;

	/**主键**/
	public XmProjectStateHis(String id) {
		this.id = id;
	}
    
    /**项目指标日统计表**/
	public XmProjectStateHis() {
	}
	
	/**
	 * 项目编号
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 统计日期yyyy-mm-dd类型
	 **/
	public void setBizDate(String bizDate) {
		this.bizDate = bizDate;
	}
	/**
	 * 文件数据
	 **/
	public void setTotalFileCnt(Integer totalFileCnt) {
		this.totalFileCnt = totalFileCnt;
	}
	/**
	 * bug数目
	 **/
	public void setTotalBugCnt(Integer totalBugCnt) {
		this.totalBugCnt = totalBugCnt;
	}
	/**
	 * 任务数
	 **/
	public void setTotalTaskCnt(Integer totalTaskCnt) {
		this.totalTaskCnt = totalTaskCnt;
	}
	/**
	 * 项目总非人力预算-来自项目表
	 **/
	public void setTotalBudgetNouserAmount(BigDecimal totalBudgetNouserAmount) {
		this.totalBudgetNouserAmount = totalBudgetNouserAmount;
	}
	/**
	 * 项目名称
	 **/
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 总参与人数
	 **/
	public void setTotalStaffCnt(Integer totalStaffCnt) {
		this.totalStaffCnt = totalStaffCnt;
	}
	/**
	 * 统计执行日期
	 **/
	public void setCalcTime(Date calcTime) {
		this.calcTime = calcTime;
	}
	/**
	 * 0-暂时的1稳定的，暂时的可以被覆盖，稳定的不允许覆盖
	 **/
	public void setCalcStatus(String calcStatus) {
		this.calcStatus = calcStatus;
	}
	/**
	 * 项目总非人力成本
	 **/
	public void setTotalCostNouserAmount(BigDecimal totalCostNouserAmount) {
		this.totalCostNouserAmount = totalCostNouserAmount;
	}
	/**
	 * 已关闭bug总数
	 **/
	public void setTotalClosedBugCnt(Integer totalClosedBugCnt) {
		this.totalClosedBugCnt = totalClosedBugCnt;
	}
	/**
	 * 已解决bug总数
	 **/
	public void setTotalResolvedBugCnt(Integer totalResolvedBugCnt) {
		this.totalResolvedBugCnt = totalResolvedBugCnt;
	}
	/**
	 * 已完成任务总数-来自任务表
	 **/
	public void setTotalCompleteTaskCnt(Integer totalCompleteTaskCnt) {
		this.totalCompleteTaskCnt = totalCompleteTaskCnt;
	}
	/**
	 * 项目计划数
	 **/
	public void setTotalPhaseCnt(Integer totalPhaseCnt) {
		this.totalPhaseCnt = totalPhaseCnt;
	}
	/**
	 * 项目计划已完成数
	 **/
	public void setTotalCompletePhaseCnt(Integer totalCompletePhaseCnt) {
		this.totalCompletePhaseCnt = totalCompletePhaseCnt;
	}
	/**
	 * 待付款总金额
	 **/
	public void setTotalNeedPayAmount(BigDecimal totalNeedPayAmount) {
		this.totalNeedPayAmount = totalNeedPayAmount;
	}
	/**
	 * 已付款总金额
	 **/
	public void setTotalFinishPayAmount(BigDecimal totalFinishPayAmount) {
		this.totalFinishPayAmount = totalFinishPayAmount;
	}
	/**
	 * 待收款总金额
	 **/
	public void setTotalNeedColAmount(BigDecimal totalNeedColAmount) {
		this.totalNeedColAmount = totalNeedColAmount;
	}
	/**
	 * 已收款总金额
	 **/
	public void setTotalFinishColAmount(BigDecimal totalFinishColAmount) {
		this.totalFinishColAmount = totalFinishColAmount;
	}
	/**
	 * 项目总人力成本
	 **/
	public void setTotalCostUserAmount(BigDecimal totalCostUserAmount) {
		this.totalCostUserAmount = totalCostUserAmount;
	}
	/**
	 * 项目总内部人力预算-来自项目表
	 **/
	public void setTotalBudgetInnerUserAmount(BigDecimal totalBudgetInnerUserAmount) {
		this.totalBudgetInnerUserAmount = totalBudgetInnerUserAmount;
	}
	/**
	 * 项目总预算工作量-来自项目表
	 **/
	public void setTotalPlanWorkload(BigDecimal totalPlanWorkload) {
		this.totalPlanWorkload = totalPlanWorkload;
	}
	/**
	 * 项目风险总数
	 **/
	public void setTotalRiskCnt(Integer totalRiskCnt) {
		this.totalRiskCnt = totalRiskCnt;
	}
	/**
	 * 已完成风险总数
	 **/
	public void setTotalCompleteRiskCnt(Integer totalCompleteRiskCnt) {
		this.totalCompleteRiskCnt = totalCompleteRiskCnt;
	}
	/**
	 * 机构编号
	 **/
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	/**
	 * 机构名称
	 **/
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	/**
	 * 项目总外购人力预算-来自项目表
	 **/
	public void setTotalBudgetOutUserAmount(BigDecimal totalBudgetOutUserAmount) {
		this.totalBudgetOutUserAmount = totalBudgetOutUserAmount;
	}
	/**
	 * 已完成工作量-来自计划中实际完成工作量
	 **/
	public void setTotalCompleteWorkload(BigDecimal totalCompleteWorkload) {
		this.totalCompleteWorkload = totalCompleteWorkload;
	}
	/**
	 * 项目总内部人力成本金额
	 **/
	public void setTotalCostInnerUserAmount(BigDecimal totalCostInnerUserAmount) {
		this.totalCostInnerUserAmount = totalCostInnerUserAmount;
	}
	/**
	 * 项目总外购人力成本金额
	 **/
	public void setTotalCostOutUserAmount(BigDecimal totalCostOutUserAmount) {
		this.totalCostOutUserAmount = totalCostOutUserAmount;
	}
	/**
	 * 项目进度0~100之间，来自任务表
	 **/
	public void setTotalProgress(BigDecimal totalProgress) {
		this.totalProgress = totalProgress;
	}
	/**
	 * 激活的bug总数
	 **/
	public void setTotalActiveBugCnt(Integer totalActiveBugCnt) {
		this.totalActiveBugCnt = totalActiveBugCnt;
	}
	/**
	 * 已解决bug总数
	 **/
	public void setTotalConfirmedBugCnt(Integer totalConfirmedBugCnt) {
		this.totalConfirmedBugCnt = totalConfirmedBugCnt;
	}
	/**
	 * 项目状态，0-初始，1-立项中，2-执行中，3-已结项，4-暂停
	 **/
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	/**
	 * 实际总工作量，来自任务表
	 **/
	public void setTotalActWorkload(BigDecimal totalActWorkload) {
		this.totalActWorkload = totalActWorkload;
	}
	/**
	 * 实际外购总工作量，来自任务表
	 **/
	public void setTotalActOutWorkload(BigDecimal totalActOutWorkload) {
		this.totalActOutWorkload = totalActOutWorkload;
	}
	/**
	 * 实际内部总工作量，来自任务表
	 **/
	public void setTotalActInnerWorkload(BigDecimal totalActInnerWorkload) {
		this.totalActInnerWorkload = totalActInnerWorkload;
	}
	/**
	 * 已经分配到任务的总预算
	 **/
	public void setTotalTaskBudgetCostAt(BigDecimal totalTaskBudgetCostAt) {
		this.totalTaskBudgetCostAt = totalTaskBudgetCostAt;
	}
	/**
	 * 外购任务数，来自任务表
	 **/
	public void setTotalTaskOutCnt(Integer totalTaskOutCnt) {
		this.totalTaskOutCnt = totalTaskOutCnt;
	}
	/**
	 * 待付款笔数
	 **/
	public void setTotalNeedPayCnt(Integer totalNeedPayCnt) {
		this.totalNeedPayCnt = totalNeedPayCnt;
	}
	/**
	 * 完成付款总比数
	 **/
	public void setTotalFinishPayCnt(Integer totalFinishPayCnt) {
		this.totalFinishPayCnt = totalFinishPayCnt;
	}
	/**
	 * 已付款总人数
	 **/
	public void setTotalFinishPayUserCnt(Integer totalFinishPayUserCnt) {
		this.totalFinishPayUserCnt = totalFinishPayUserCnt;
	}
	/**
	 * 待付款总人数
	 **/
	public void setTotalNeedPayUserCnt(Integer totalNeedPayUserCnt) {
		this.totalNeedPayUserCnt = totalNeedPayUserCnt;
	}
	/**
	 * 内部人力总工作量-应该大于或等于计划内部人力总成本
	 **/
	public void setTotalPlanInnerUserWorkload(BigDecimal totalPlanInnerUserWorkload) {
		this.totalPlanInnerUserWorkload = totalPlanInnerUserWorkload;
	}
	/**
	 * 外购人力总工作量-应该大于或等于计划外购人力总成本
	 **/
	public void setTotalPlanOutUserWorkload(BigDecimal totalPlanOutUserWorkload) {
		this.totalPlanOutUserWorkload = totalPlanOutUserWorkload;
	}
	/**
	 * 测试案例总数
	 **/
	public void setTestCases(Integer testCases) {
		this.testCases = testCases;
	}
	/**
	 * 测试中案例总数
	 **/
	public void setExecCases(Integer execCases) {
		this.execCases = execCases;
	}
	/**
	 * 设计中案例总数
	 **/
	public void setDesignCases(Integer designCases) {
		this.designCases = designCases;
	}
	/**
	 * 完成案例总数
	 **/
	public void setFinishCases(Integer finishCases) {
		this.finishCases = finishCases;
	}
	/**
	 * 迭代数
	 **/
	public void setIterationCnt(Integer iterationCnt) {
		this.iterationCnt = iterationCnt;
	}
	/**
	 * 产品数
	 **/
	public void setProductCnt(Integer productCnt) {
		this.productCnt = productCnt;
	}
	/**
	 * 需求数
	 **/
	public void setMenuCnt(Integer menuCnt) {
		this.menuCnt = menuCnt;
	}
	
	/**
	 * 项目编号
	 **/
	public String getProjectId() {
		return this.projectId;
	}
	/**
	 * 统计日期yyyy-mm-dd类型
	 **/
	public String getBizDate() {
		return this.bizDate;
	}
	/**
	 * 文件数据
	 **/
	public Integer getTotalFileCnt() {
		return this.totalFileCnt;
	}
	/**
	 * bug数目
	 **/
	public Integer getTotalBugCnt() {
		return this.totalBugCnt;
	}
	/**
	 * 任务数
	 **/
	public Integer getTotalTaskCnt() {
		return this.totalTaskCnt;
	}
	/**
	 * 项目总非人力预算-来自项目表
	 **/
	public BigDecimal getTotalBudgetNouserAmount() {
		return this.totalBudgetNouserAmount;
	}
	/**
	 * 项目名称
	 **/
	public String getProjectName() {
		return this.projectName;
	}
	/**
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 总参与人数
	 **/
	public Integer getTotalStaffCnt() {
		return this.totalStaffCnt;
	}
	/**
	 * 统计执行日期
	 **/
	public Date getCalcTime() {
		return this.calcTime;
	}
	/**
	 * 0-暂时的1稳定的，暂时的可以被覆盖，稳定的不允许覆盖
	 **/
	public String getCalcStatus() {
		return this.calcStatus;
	}
	/**
	 * 项目总非人力成本
	 **/
	public BigDecimal getTotalCostNouserAmount() {
		return this.totalCostNouserAmount;
	}
	/**
	 * 已关闭bug总数
	 **/
	public Integer getTotalClosedBugCnt() {
		return this.totalClosedBugCnt;
	}
	/**
	 * 已解决bug总数
	 **/
	public Integer getTotalResolvedBugCnt() {
		return this.totalResolvedBugCnt;
	}
	/**
	 * 已完成任务总数-来自任务表
	 **/
	public Integer getTotalCompleteTaskCnt() {
		return this.totalCompleteTaskCnt;
	}
	/**
	 * 项目计划数
	 **/
	public Integer getTotalPhaseCnt() {
		return this.totalPhaseCnt;
	}
	/**
	 * 项目计划已完成数
	 **/
	public Integer getTotalCompletePhaseCnt() {
		return this.totalCompletePhaseCnt;
	}
	/**
	 * 待付款总金额
	 **/
	public BigDecimal getTotalNeedPayAmount() {
		return this.totalNeedPayAmount;
	}
	/**
	 * 已付款总金额
	 **/
	public BigDecimal getTotalFinishPayAmount() {
		return this.totalFinishPayAmount;
	}
	/**
	 * 待收款总金额
	 **/
	public BigDecimal getTotalNeedColAmount() {
		return this.totalNeedColAmount;
	}
	/**
	 * 已收款总金额
	 **/
	public BigDecimal getTotalFinishColAmount() {
		return this.totalFinishColAmount;
	}
	/**
	 * 项目总人力成本
	 **/
	public BigDecimal getTotalCostUserAmount() {
		return this.totalCostUserAmount;
	}
	/**
	 * 项目总内部人力预算-来自项目表
	 **/
	public BigDecimal getTotalBudgetInnerUserAmount() {
		return this.totalBudgetInnerUserAmount;
	}
	/**
	 * 项目总预算工作量-来自项目表
	 **/
	public BigDecimal getTotalPlanWorkload() {
		return this.totalPlanWorkload;
	}
	/**
	 * 项目风险总数
	 **/
	public Integer getTotalRiskCnt() {
		return this.totalRiskCnt;
	}
	/**
	 * 已完成风险总数
	 **/
	public Integer getTotalCompleteRiskCnt() {
		return this.totalCompleteRiskCnt;
	}
	/**
	 * 机构编号
	 **/
	public String getBranchId() {
		return this.branchId;
	}
	/**
	 * 机构名称
	 **/
	public String getBranchName() {
		return this.branchName;
	}
	/**
	 * 项目总外购人力预算-来自项目表
	 **/
	public BigDecimal getTotalBudgetOutUserAmount() {
		return this.totalBudgetOutUserAmount;
	}
	/**
	 * 已完成工作量-来自计划中实际完成工作量
	 **/
	public BigDecimal getTotalCompleteWorkload() {
		return this.totalCompleteWorkload;
	}
	/**
	 * 项目总内部人力成本金额
	 **/
	public BigDecimal getTotalCostInnerUserAmount() {
		return this.totalCostInnerUserAmount;
	}
	/**
	 * 项目总外购人力成本金额
	 **/
	public BigDecimal getTotalCostOutUserAmount() {
		return this.totalCostOutUserAmount;
	}
	/**
	 * 项目进度0~100之间，来自任务表
	 **/
	public BigDecimal getTotalProgress() {
		return this.totalProgress;
	}
	/**
	 * 激活的bug总数
	 **/
	public Integer getTotalActiveBugCnt() {
		return this.totalActiveBugCnt;
	}
	/**
	 * 已解决bug总数
	 **/
	public Integer getTotalConfirmedBugCnt() {
		return this.totalConfirmedBugCnt;
	}
	/**
	 * 项目状态，0-初始，1-立项中，2-执行中，3-已结项，4-暂停
	 **/
	public String getProjectStatus() {
		return this.projectStatus;
	}
	/**
	 * 实际总工作量，来自任务表
	 **/
	public BigDecimal getTotalActWorkload() {
		return this.totalActWorkload;
	}
	/**
	 * 实际外购总工作量，来自任务表
	 **/
	public BigDecimal getTotalActOutWorkload() {
		return this.totalActOutWorkload;
	}
	/**
	 * 实际内部总工作量，来自任务表
	 **/
	public BigDecimal getTotalActInnerWorkload() {
		return this.totalActInnerWorkload;
	}
	/**
	 * 已经分配到任务的总预算
	 **/
	public BigDecimal getTotalTaskBudgetCostAt() {
		return this.totalTaskBudgetCostAt;
	}
	/**
	 * 外购任务数，来自任务表
	 **/
	public Integer getTotalTaskOutCnt() {
		return this.totalTaskOutCnt;
	}
	/**
	 * 待付款笔数
	 **/
	public Integer getTotalNeedPayCnt() {
		return this.totalNeedPayCnt;
	}
	/**
	 * 完成付款总比数
	 **/
	public Integer getTotalFinishPayCnt() {
		return this.totalFinishPayCnt;
	}
	/**
	 * 已付款总人数
	 **/
	public Integer getTotalFinishPayUserCnt() {
		return this.totalFinishPayUserCnt;
	}
	/**
	 * 待付款总人数
	 **/
	public Integer getTotalNeedPayUserCnt() {
		return this.totalNeedPayUserCnt;
	}
	/**
	 * 内部人力总工作量-应该大于或等于计划内部人力总成本
	 **/
	public BigDecimal getTotalPlanInnerUserWorkload() {
		return this.totalPlanInnerUserWorkload;
	}
	/**
	 * 外购人力总工作量-应该大于或等于计划外购人力总成本
	 **/
	public BigDecimal getTotalPlanOutUserWorkload() {
		return this.totalPlanOutUserWorkload;
	}
	/**
	 * 测试案例总数
	 **/
	public Integer getTestCases() {
		return this.testCases;
	}
	/**
	 * 测试中案例总数
	 **/
	public Integer getExecCases() {
		return this.execCases;
	}
	/**
	 * 设计中案例总数
	 **/
	public Integer getDesignCases() {
		return this.designCases;
	}
	/**
	 * 完成案例总数
	 **/
	public Integer getFinishCases() {
		return this.finishCases;
	}
	/**
	 * 迭代数
	 **/
	public Integer getIterationCnt() {
		return this.iterationCnt;
	}
	/**
	 * 产品数
	 **/
	public Integer getProductCnt() {
		return this.productCnt;
	}
	/**
	 * 需求数
	 **/
	public Integer getMenuCnt() {
		return this.menuCnt;
	}

}