package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 组织 com.qqkj  顶级模块 oa 大模块 xm  小模块 <br> 
 * 实体 XmProjectMCostNouser所有属性名: <br>
 *	projectId,userid,createTime,sendCostTime,username,projectName,remark,id,taskId,taskName,subjectId,bizzStartDate,bizzEndDate,bizProcInstId,bizFlowState,projectPhaseId,actCostAmount,costType,bizMonth,bizDate,subjectName,projectPhaseName;<br>
 * 表 XM.xm_project_m_cost_nouser xm_project_m_cost_nouser的所有字段名: <br>
 *	project_id,userid,create_time,send_cost_time,username,project_name,remark,id,task_id,task_name,subject_id,bizz_start_date,bizz_end_date,biz_proc_inst_id,biz_flow_state,project_phase_id,act_cost_amount,cost_type,biz_month,biz_date,subject_name,project_phase_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_project_m_cost_nouser")
public class XmProjectMCostNouser  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="用户编号",allowEmptyValue=true,example="",allowableValues="")
	String userid;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date createTime;
	
	@ApiModelProperty(notes="费用发放时间",allowEmptyValue=true,example="",allowableValues="")
	Date sendCostTime;
	
	@ApiModelProperty(notes="用户名称",allowEmptyValue=true,example="",allowableValues="")
	String username;
	
	@ApiModelProperty(notes="项目名称",allowEmptyValue=true,example="",allowableValues="")
	String projectName;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="任务编号",allowEmptyValue=true,example="",allowableValues="")
	String taskId;
	
	@ApiModelProperty(notes="任务名称",allowEmptyValue=true,example="",allowableValues="")
	String taskName;
	
	@ApiModelProperty(notes="科目编号",allowEmptyValue=true,example="",allowableValues="")
	String subjectId;
	
	@ApiModelProperty(notes="费用归属周期开始日期",allowEmptyValue=true,example="",allowableValues="")
	Date bizzStartDate;
	
	@ApiModelProperty(notes="费用归属周期结束日期",allowEmptyValue=true,example="",allowableValues="")
	Date bizzEndDate;
	
	@ApiModelProperty(notes="当前流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String bizProcInstId;
	
	@ApiModelProperty(notes="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;
	
	@ApiModelProperty(notes="项目计划计划编号",allowEmptyValue=true,example="",allowableValues="")
	String projectPhaseId;
	
	@ApiModelProperty(notes="实际成本金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actCostAmount;
	
	@ApiModelProperty(notes="成本类型0非人力1内部人力2外购人力",allowEmptyValue=true,example="",allowableValues="")
	String costType;
	
	@ApiModelProperty(notes="业务归属月份yyyy-mm",allowEmptyValue=true,example="",allowableValues="")
	String bizMonth;
	
	@ApiModelProperty(notes="业务归属日期yyyy-mm-dd",allowEmptyValue=true,example="",allowableValues="")
	String bizDate;
	
	@ApiModelProperty(notes="科目名称",allowEmptyValue=true,example="",allowableValues="")
	String subjectName;
	
	@ApiModelProperty(notes="计划名称",allowEmptyValue=true,example="",allowableValues="")
	String projectPhaseName;

	/**主键**/
	public XmProjectMCostNouser(String id) {
		this.id = id;
	}
    
    /**xm_project_m_cost_nouser**/
	public XmProjectMCostNouser() {
	}
	
	/**
	 * 项目编号
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 用户编号
	 **/
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 创建时间
	 **/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 费用发放时间
	 **/
	public void setSendCostTime(Date sendCostTime) {
		this.sendCostTime = sendCostTime;
	}
	/**
	 * 用户名称
	 **/
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 项目名称
	 **/
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 备注
	 **/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 任务编号
	 **/
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	/**
	 * 任务名称
	 **/
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * 科目编号
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
	 * 项目计划计划编号
	 **/
	public void setProjectPhaseId(String projectPhaseId) {
		this.projectPhaseId = projectPhaseId;
	}
	/**
	 * 实际成本金额
	 **/
	public void setActCostAmount(BigDecimal actCostAmount) {
		this.actCostAmount = actCostAmount;
	}
	/**
	 * 成本类型0非人力1内部人力2外购人力
	 **/
	public void setCostType(String costType) {
		this.costType = costType;
	}
	/**
	 * 业务归属月份yyyy-mm
	 **/
	public void setBizMonth(String bizMonth) {
		this.bizMonth = bizMonth;
	}
	/**
	 * 业务归属日期yyyy-mm-dd
	 **/
	public void setBizDate(String bizDate) {
		this.bizDate = bizDate;
	}
	/**
	 * 科目名称
	 **/
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	/**
	 * 计划名称
	 **/
	public void setProjectPhaseName(String projectPhaseName) {
		this.projectPhaseName = projectPhaseName;
	}
	
	/**
	 * 项目编号
	 **/
	public String getProjectId() {
		return this.projectId;
	}
	/**
	 * 用户编号
	 **/
	public String getUserid() {
		return this.userid;
	}
	/**
	 * 创建时间
	 **/
	public Date getCreateTime() {
		return this.createTime;
	}
	/**
	 * 费用发放时间
	 **/
	public Date getSendCostTime() {
		return this.sendCostTime;
	}
	/**
	 * 用户名称
	 **/
	public String getUsername() {
		return this.username;
	}
	/**
	 * 项目名称
	 **/
	public String getProjectName() {
		return this.projectName;
	}
	/**
	 * 备注
	 **/
	public String getRemark() {
		return this.remark;
	}
	/**
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 任务编号
	 **/
	public String getTaskId() {
		return this.taskId;
	}
	/**
	 * 任务名称
	 **/
	public String getTaskName() {
		return this.taskName;
	}
	/**
	 * 科目编号
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
	 * 项目计划计划编号
	 **/
	public String getProjectPhaseId() {
		return this.projectPhaseId;
	}
	/**
	 * 实际成本金额
	 **/
	public BigDecimal getActCostAmount() {
		return this.actCostAmount;
	}
	/**
	 * 成本类型0非人力1内部人力2外购人力
	 **/
	public String getCostType() {
		return this.costType;
	}
	/**
	 * 业务归属月份yyyy-mm
	 **/
	public String getBizMonth() {
		return this.bizMonth;
	}
	/**
	 * 业务归属日期yyyy-mm-dd
	 **/
	public String getBizDate() {
		return this.bizDate;
	}
	/**
	 * 科目名称
	 **/
	public String getSubjectName() {
		return this.subjectName;
	}
	/**
	 * 计划名称
	 **/
	public String getProjectPhaseName() {
		return this.projectPhaseName;
	}

}