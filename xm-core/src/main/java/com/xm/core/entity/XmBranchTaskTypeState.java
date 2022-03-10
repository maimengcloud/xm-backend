package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmBranchTaskTypeState所有属性名: <br>
 *	taskType,planWorkload,planAmount,actWorkload,actAmount,branchId,bizDate,calcTime,planOutUserAt,planInnerUserAt,actOutUserAt,actInnerUserAt,planOutUserWorkload,planInnerUserWorkload,actOutUserWorkload,actInnerUserWorkload,planNouserAt,actNouserAt,id,branchName;<br>
 * 表 xm_branch_task_type_state 按机构编号任务类型汇总的所有字段名: <br>
 *	task_type,plan_workload,plan_amount,act_workload,act_amount,branch_id,biz_date,calc_time,plan_out_user_at,plan_inner_user_at,act_out_user_at,act_inner_user_at,plan_out_user_workload,plan_inner_user_workload,act_out_user_workload,act_inner_user_workload,plan_nouser_at,act_nouser_at,id,branch_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="按机构编号任务类型汇总")
public class XmBranchTaskTypeState  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="任务类型",allowEmptyValue=true,example="",allowableValues="")
	String taskType;
	
	@ApiModelProperty(notes="工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planWorkload;
	
	@ApiModelProperty(notes="预算金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planAmount;
	
	@ApiModelProperty(notes="实际完成工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actWorkload;
	
	@ApiModelProperty(notes="实际完成金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actAmount;
	
	@ApiModelProperty(notes="机构编号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="业务日期yyyy-MM-dd型",allowEmptyValue=true,example="",allowableValues="")
	String bizDate;
	
	@ApiModelProperty(notes="计算日期",allowEmptyValue=true,example="",allowableValues="")
	Date calcTime;
	
	@ApiModelProperty(notes="外购资金预算",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planOutUserAt;
	
	@ApiModelProperty(notes="内购资金预算",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planInnerUserAt;
	
	@ApiModelProperty(notes="实际外购成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actOutUserAt;
	
	@ApiModelProperty(notes="实际内购成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actInnerUserAt;
	
	@ApiModelProperty(notes="计划外购工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planOutUserWorkload;
	
	@ApiModelProperty(notes="计划内购工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planInnerUserWorkload;
	
	@ApiModelProperty(notes="实际外购工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actOutUserWorkload;
	
	@ApiModelProperty(notes="实际内购工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actInnerUserWorkload;
	
	@ApiModelProperty(notes="计划非人力成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planNouserAt;
	
	@ApiModelProperty(notes="实际非人力成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actNouserAt;
	
	@ApiModelProperty(notes="机构名称",allowEmptyValue=true,example="",allowableValues="")
	String branchName;

	/**主键**/
	public XmBranchTaskTypeState(String id) {
		this.id = id;
	}
    
    /**按机构编号任务类型汇总**/
	public XmBranchTaskTypeState() {
	}
	
	/**
	 * 任务类型
	 **/
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	/**
	 * 工作量
	 **/
	public void setPlanWorkload(BigDecimal planWorkload) {
		this.planWorkload = planWorkload;
	}
	/**
	 * 预算金额
	 **/
	public void setPlanAmount(BigDecimal planAmount) {
		this.planAmount = planAmount;
	}
	/**
	 * 实际完成工作量
	 **/
	public void setActWorkload(BigDecimal actWorkload) {
		this.actWorkload = actWorkload;
	}
	/**
	 * 实际完成金额
	 **/
	public void setActAmount(BigDecimal actAmount) {
		this.actAmount = actAmount;
	}
	/**
	 * 机构编号
	 **/
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	/**
	 * 业务日期yyyy-MM-dd型
	 **/
	public void setBizDate(String bizDate) {
		this.bizDate = bizDate;
	}
	/**
	 * 计算日期
	 **/
	public void setCalcTime(Date calcTime) {
		this.calcTime = calcTime;
	}
	/**
	 * 外购资金预算
	 **/
	public void setPlanOutUserAt(BigDecimal planOutUserAt) {
		this.planOutUserAt = planOutUserAt;
	}
	/**
	 * 内购资金预算
	 **/
	public void setPlanInnerUserAt(BigDecimal planInnerUserAt) {
		this.planInnerUserAt = planInnerUserAt;
	}
	/**
	 * 实际外购成本
	 **/
	public void setActOutUserAt(BigDecimal actOutUserAt) {
		this.actOutUserAt = actOutUserAt;
	}
	/**
	 * 实际内购成本
	 **/
	public void setActInnerUserAt(BigDecimal actInnerUserAt) {
		this.actInnerUserAt = actInnerUserAt;
	}
	/**
	 * 计划外购工作量
	 **/
	public void setPlanOutUserWorkload(BigDecimal planOutUserWorkload) {
		this.planOutUserWorkload = planOutUserWorkload;
	}
	/**
	 * 计划内购工作量
	 **/
	public void setPlanInnerUserWorkload(BigDecimal planInnerUserWorkload) {
		this.planInnerUserWorkload = planInnerUserWorkload;
	}
	/**
	 * 实际外购工作量
	 **/
	public void setActOutUserWorkload(BigDecimal actOutUserWorkload) {
		this.actOutUserWorkload = actOutUserWorkload;
	}
	/**
	 * 实际内购工作量
	 **/
	public void setActInnerUserWorkload(BigDecimal actInnerUserWorkload) {
		this.actInnerUserWorkload = actInnerUserWorkload;
	}
	/**
	 * 计划非人力成本
	 **/
	public void setPlanNouserAt(BigDecimal planNouserAt) {
		this.planNouserAt = planNouserAt;
	}
	/**
	 * 实际非人力成本
	 **/
	public void setActNouserAt(BigDecimal actNouserAt) {
		this.actNouserAt = actNouserAt;
	}
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 机构名称
	 **/
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	/**
	 * 任务类型
	 **/
	public String getTaskType() {
		return this.taskType;
	}
	/**
	 * 工作量
	 **/
	public BigDecimal getPlanWorkload() {
		return this.planWorkload;
	}
	/**
	 * 预算金额
	 **/
	public BigDecimal getPlanAmount() {
		return this.planAmount;
	}
	/**
	 * 实际完成工作量
	 **/
	public BigDecimal getActWorkload() {
		return this.actWorkload;
	}
	/**
	 * 实际完成金额
	 **/
	public BigDecimal getActAmount() {
		return this.actAmount;
	}
	/**
	 * 机构编号
	 **/
	public String getBranchId() {
		return this.branchId;
	}
	/**
	 * 业务日期yyyy-MM-dd型
	 **/
	public String getBizDate() {
		return this.bizDate;
	}
	/**
	 * 计算日期
	 **/
	public Date getCalcTime() {
		return this.calcTime;
	}
	/**
	 * 外购资金预算
	 **/
	public BigDecimal getPlanOutUserAt() {
		return this.planOutUserAt;
	}
	/**
	 * 内购资金预算
	 **/
	public BigDecimal getPlanInnerUserAt() {
		return this.planInnerUserAt;
	}
	/**
	 * 实际外购成本
	 **/
	public BigDecimal getActOutUserAt() {
		return this.actOutUserAt;
	}
	/**
	 * 实际内购成本
	 **/
	public BigDecimal getActInnerUserAt() {
		return this.actInnerUserAt;
	}
	/**
	 * 计划外购工作量
	 **/
	public BigDecimal getPlanOutUserWorkload() {
		return this.planOutUserWorkload;
	}
	/**
	 * 计划内购工作量
	 **/
	public BigDecimal getPlanInnerUserWorkload() {
		return this.planInnerUserWorkload;
	}
	/**
	 * 实际外购工作量
	 **/
	public BigDecimal getActOutUserWorkload() {
		return this.actOutUserWorkload;
	}
	/**
	 * 实际内购工作量
	 **/
	public BigDecimal getActInnerUserWorkload() {
		return this.actInnerUserWorkload;
	}
	/**
	 * 计划非人力成本
	 **/
	public BigDecimal getPlanNouserAt() {
		return this.planNouserAt;
	}
	/**
	 * 实际非人力成本
	 **/
	public BigDecimal getActNouserAt() {
		return this.actNouserAt;
	}
	/**
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 机构名称
	 **/
	public String getBranchName() {
		return this.branchName;
	}

}