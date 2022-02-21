package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 组织 com.qqkj  顶级模块 oa 大模块 xm  小模块 <br> 
 * 实体 XmProjectMCostUser所有属性名: <br>
 *	subjectId,projectId,userid,createTime,sendCostTime,username,projectName,remark,id,taskId,taskName,actWorkload,bizzStartDate,bizzEndDate,bizProcInstId,bizFlowState,projectPhaseId,actCostAmount,costType,bizMonth,bizDate,subjectName,projectPhaseName,execuserProcInstId,execuserStatus,payStatus,payOpUserid,payOpUsername;<br>
 * 表 XM.xm_project_m_cost_user 项目实际人工成本费用的所有字段名: <br>
 *	subject_id,project_id,userid,create_time,send_cost_time,username,project_name,remark,id,task_id,task_name,act_workload,bizz_start_date,bizz_end_date,biz_proc_inst_id,biz_flow_state,project_phase_id,act_cost_amount,cost_type,biz_month,biz_date,subject_name,project_phase_name,execuser_proc_inst_id,execuser_status,pay_status,pay_op_userid,pay_op_username;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="项目实际人工成本费用")
public class XmProjectMCostUser  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="科目编号",allowEmptyValue=true,example="",allowableValues="")
	String subjectId;
	
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
	
	@ApiModelProperty(notes="实际工时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actWorkload;
	
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
	
	@ApiModelProperty(notes="金额",allowEmptyValue=true,example="",allowableValues="")
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
	
	@ApiModelProperty(notes="执行人申请结算时的流程编号",allowEmptyValue=true,example="",allowableValues="")
	String execuserProcInstId;
	
	@ApiModelProperty(notes="执行人结算申请状态0审批中1审批通过2申请不通过删除数据",allowEmptyValue=true,example="",allowableValues="")
	String execuserStatus;
	
	@ApiModelProperty(notes="付款状态0未付款1已付款",allowEmptyValue=true,example="",allowableValues="")
	String payStatus;
	
	@ApiModelProperty(notes="付款操作人员编号",allowEmptyValue=true,example="",allowableValues="")
	String payOpUserid;
	
	@ApiModelProperty(notes="付款操作人员姓名",allowEmptyValue=true,example="",allowableValues="")
	String payOpUsername;

	/**主键**/
	public XmProjectMCostUser(String id) {
		this.id = id;
	}
    
    /**项目实际人工成本费用**/
	public XmProjectMCostUser() {
	}
	
	/**
	 * 科目编号
	 **/
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
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
	 * 实际工时
	 **/
	public void setActWorkload(BigDecimal actWorkload) {
		this.actWorkload = actWorkload;
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
	 * 金额
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
	 * 执行人申请结算时的流程编号
	 **/
	public void setExecuserProcInstId(String execuserProcInstId) {
		this.execuserProcInstId = execuserProcInstId;
	}
	/**
	 * 执行人结算申请状态0审批中1审批通过2申请不通过删除数据
	 **/
	public void setExecuserStatus(String execuserStatus) {
		this.execuserStatus = execuserStatus;
	}
	/**
	 * 付款状态0未付款1已付款
	 **/
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	/**
	 * 付款操作人员编号
	 **/
	public void setPayOpUserid(String payOpUserid) {
		this.payOpUserid = payOpUserid;
	}
	/**
	 * 付款操作人员姓名
	 **/
	public void setPayOpUsername(String payOpUsername) {
		this.payOpUsername = payOpUsername;
	}
	
	/**
	 * 科目编号
	 **/
	public String getSubjectId() {
		return this.subjectId;
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
	 * 实际工时
	 **/
	public BigDecimal getActWorkload() {
		return this.actWorkload;
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
	 * 金额
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
	/**
	 * 执行人申请结算时的流程编号
	 **/
	public String getExecuserProcInstId() {
		return this.execuserProcInstId;
	}
	/**
	 * 执行人结算申请状态0审批中1审批通过2申请不通过删除数据
	 **/
	public String getExecuserStatus() {
		return this.execuserStatus;
	}
	/**
	 * 付款状态0未付款1已付款
	 **/
	public String getPayStatus() {
		return this.payStatus;
	}
	/**
	 * 付款操作人员编号
	 **/
	public String getPayOpUserid() {
		return this.payOpUserid;
	}
	/**
	 * 付款操作人员姓名
	 **/
	public String getPayOpUsername() {
		return this.payOpUsername;
	}

}