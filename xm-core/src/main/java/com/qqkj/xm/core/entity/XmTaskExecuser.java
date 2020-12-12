package  com.qqkj.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com.qqkj  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmTaskExecuser所有属性名: <br>
 *	createTime,id,taskId,userid,startTime,endTime,status,remarks,settleAmount,settleWorkload,settleStatus,settleTime,createUserid,createUsername,username,matchScore,quoteWeekday,quoteAmount,quoteTime,bizProcInstId,bizFlowState,projectId,projectPhaseId,skillRemark,quoteWorkload,quoteStartTime,quoteEndTime,branchId,projectPhaseName,taskName,isLeader;<br>
 * 表 XM.xm_task_execuser xm_task_execuser的所有字段名: <br>
 *	create_time,id,task_id,userid,start_time,end_time,status,remarks,settle_amount,settle_workload,settle_status,settle_time,create_userid,create_username,username,match_score,quote_weekday,quote_amount,quote_time,biz_proc_inst_id,biz_flow_state,project_id,project_phase_id,skill_remark,quote_workload,quote_start_time,quote_end_time,branch_id,project_phase_name,task_name,is_leader;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_task_execuser")
public class XmTaskExecuser  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date createTime;
	
	@ApiModelProperty(notes="任务id",allowEmptyValue=true,example="",allowableValues="")
	String taskId;
	
	@ApiModelProperty(notes="执行人id",allowEmptyValue=true,example="",allowableValues="")
	String userid;
	
	@ApiModelProperty(notes="加入时间",allowEmptyValue=true,example="",allowableValues="")
	Date startTime;
	
	@ApiModelProperty(notes="离开时间",allowEmptyValue=true,example="",allowableValues="")
	Date endTime;
	
	@ApiModelProperty(notes="执行人状态0候选排队中1执行任务中2提交任务3验收成功4验收不通过5付款中6付款成功7放弃任务",allowEmptyValue=true,example="",allowableValues="")
	String status;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remarks;
	
	@ApiModelProperty(notes="已结算金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal settleAmount;
	
	@ApiModelProperty(notes="已结算工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal settleWorkload;
	
	@ApiModelProperty(notes="结算状态0未结算1已部分结算2无需结算4已申请结算5结算失败6已全部结算",allowEmptyValue=true,example="",allowableValues="")
	String settleStatus;
	
	@ApiModelProperty(notes="上次结算时间",allowEmptyValue=true,example="",allowableValues="")
	Date settleTime;
	
	@ApiModelProperty(notes="创建人",allowEmptyValue=true,example="",allowableValues="")
	String createUserid;
	
	@ApiModelProperty(notes="创建人姓名",allowEmptyValue=true,example="",allowableValues="")
	String createUsername;
	
	@ApiModelProperty(notes="执行人姓名",allowEmptyValue=true,example="",allowableValues="")
	String username;
	
	@ApiModelProperty(notes="任务能力匹配分数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal matchScore;
	
	@ApiModelProperty(notes="报价天数，不包括周六日",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal quoteWeekday;
	
	@ApiModelProperty(notes="报价金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal quoteAmount;
	
	@ApiModelProperty(notes="报价时间",allowEmptyValue=true,example="",allowableValues="")
	Date quoteTime;
	
	@ApiModelProperty(notes="当前流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String bizProcInstId;
	
	@ApiModelProperty(notes="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="阶段计划编号",allowEmptyValue=true,example="",allowableValues="")
	String projectPhaseId;
	
	@ApiModelProperty(notes="技能说明",allowEmptyValue=true,example="",allowableValues="")
	String skillRemark;
	
	@ApiModelProperty(notes="报价工作量单位人时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal quoteWorkload;
	
	@ApiModelProperty(notes="报价-开始工作日期",allowEmptyValue=true,example="",allowableValues="")
	Date quoteStartTime;
	
	@ApiModelProperty(notes="报价-结束工作日期",allowEmptyValue=true,example="",allowableValues="")
	Date quoteEndTime;
	
	@ApiModelProperty(notes="项目所属机构",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="阶段计划名称",allowEmptyValue=true,example="",allowableValues="")
	String projectPhaseName;
	
	@ApiModelProperty(notes="任务名称",allowEmptyValue=true,example="",allowableValues="")
	String taskName;
	
	@ApiModelProperty(notes="是否主负责人0否1是",allowEmptyValue=true,example="",allowableValues="")
	String isLeader;

	/**编号**/
	public XmTaskExecuser(String id) {
		this.id = id;
	}
    
    /**xm_task_execuser**/
	public XmTaskExecuser() {
	}
	
	/**
	 * 创建时间
	 **/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 编号
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 任务id
	 **/
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	/**
	 * 执行人id
	 **/
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 加入时间
	 **/
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 离开时间
	 **/
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 执行人状态0候选排队中1执行任务中2提交任务3验收成功4验收不通过5付款中6付款成功7放弃任务
	 **/
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 备注
	 **/
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 已结算金额
	 **/
	public void setSettleAmount(BigDecimal settleAmount) {
		this.settleAmount = settleAmount;
	}
	/**
	 * 已结算工作量
	 **/
	public void setSettleWorkload(BigDecimal settleWorkload) {
		this.settleWorkload = settleWorkload;
	}
	/**
	 * 结算状态0未结算1已部分结算2无需结算4已申请结算5结算失败6已全部结算
	 **/
	public void setSettleStatus(String settleStatus) {
		this.settleStatus = settleStatus;
	}
	/**
	 * 上次结算时间
	 **/
	public void setSettleTime(Date settleTime) {
		this.settleTime = settleTime;
	}
	/**
	 * 创建人
	 **/
	public void setCreateUserid(String createUserid) {
		this.createUserid = createUserid;
	}
	/**
	 * 创建人姓名
	 **/
	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}
	/**
	 * 执行人姓名
	 **/
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 任务能力匹配分数
	 **/
	public void setMatchScore(BigDecimal matchScore) {
		this.matchScore = matchScore;
	}
	/**
	 * 报价天数，不包括周六日
	 **/
	public void setQuoteWeekday(BigDecimal quoteWeekday) {
		this.quoteWeekday = quoteWeekday;
	}
	/**
	 * 报价金额
	 **/
	public void setQuoteAmount(BigDecimal quoteAmount) {
		this.quoteAmount = quoteAmount;
	}
	/**
	 * 报价时间
	 **/
	public void setQuoteTime(Date quoteTime) {
		this.quoteTime = quoteTime;
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
	 * 项目编号
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 阶段计划编号
	 **/
	public void setProjectPhaseId(String projectPhaseId) {
		this.projectPhaseId = projectPhaseId;
	}
	/**
	 * 技能说明
	 **/
	public void setSkillRemark(String skillRemark) {
		this.skillRemark = skillRemark;
	}
	/**
	 * 报价工作量单位人时
	 **/
	public void setQuoteWorkload(BigDecimal quoteWorkload) {
		this.quoteWorkload = quoteWorkload;
	}
	/**
	 * 报价-开始工作日期
	 **/
	public void setQuoteStartTime(Date quoteStartTime) {
		this.quoteStartTime = quoteStartTime;
	}
	/**
	 * 报价-结束工作日期
	 **/
	public void setQuoteEndTime(Date quoteEndTime) {
		this.quoteEndTime = quoteEndTime;
	}
	/**
	 * 项目所属机构
	 **/
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	/**
	 * 阶段计划名称
	 **/
	public void setProjectPhaseName(String projectPhaseName) {
		this.projectPhaseName = projectPhaseName;
	}
	/**
	 * 任务名称
	 **/
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * 是否主负责人0否1是
	 **/
	public void setIsLeader(String isLeader) {
		this.isLeader = isLeader;
	}
	
	/**
	 * 创建时间
	 **/
	public Date getCreateTime() {
		return this.createTime;
	}
	/**
	 * 编号
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 任务id
	 **/
	public String getTaskId() {
		return this.taskId;
	}
	/**
	 * 执行人id
	 **/
	public String getUserid() {
		return this.userid;
	}
	/**
	 * 加入时间
	 **/
	public Date getStartTime() {
		return this.startTime;
	}
	/**
	 * 离开时间
	 **/
	public Date getEndTime() {
		return this.endTime;
	}
	/**
	 * 执行人状态0候选排队中1执行任务中2提交任务3验收成功4验收不通过5付款中6付款成功7放弃任务
	 **/
	public String getStatus() {
		return this.status;
	}
	/**
	 * 备注
	 **/
	public String getRemarks() {
		return this.remarks;
	}
	/**
	 * 已结算金额
	 **/
	public BigDecimal getSettleAmount() {
		return this.settleAmount;
	}
	/**
	 * 已结算工作量
	 **/
	public BigDecimal getSettleWorkload() {
		return this.settleWorkload;
	}
	/**
	 * 结算状态0未结算1已部分结算2无需结算4已申请结算5结算失败6已全部结算
	 **/
	public String getSettleStatus() {
		return this.settleStatus;
	}
	/**
	 * 上次结算时间
	 **/
	public Date getSettleTime() {
		return this.settleTime;
	}
	/**
	 * 创建人
	 **/
	public String getCreateUserid() {
		return this.createUserid;
	}
	/**
	 * 创建人姓名
	 **/
	public String getCreateUsername() {
		return this.createUsername;
	}
	/**
	 * 执行人姓名
	 **/
	public String getUsername() {
		return this.username;
	}
	/**
	 * 任务能力匹配分数
	 **/
	public BigDecimal getMatchScore() {
		return this.matchScore;
	}
	/**
	 * 报价天数，不包括周六日
	 **/
	public BigDecimal getQuoteWeekday() {
		return this.quoteWeekday;
	}
	/**
	 * 报价金额
	 **/
	public BigDecimal getQuoteAmount() {
		return this.quoteAmount;
	}
	/**
	 * 报价时间
	 **/
	public Date getQuoteTime() {
		return this.quoteTime;
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
	 * 项目编号
	 **/
	public String getProjectId() {
		return this.projectId;
	}
	/**
	 * 阶段计划编号
	 **/
	public String getProjectPhaseId() {
		return this.projectPhaseId;
	}
	/**
	 * 技能说明
	 **/
	public String getSkillRemark() {
		return this.skillRemark;
	}
	/**
	 * 报价工作量单位人时
	 **/
	public BigDecimal getQuoteWorkload() {
		return this.quoteWorkload;
	}
	/**
	 * 报价-开始工作日期
	 **/
	public Date getQuoteStartTime() {
		return this.quoteStartTime;
	}
	/**
	 * 报价-结束工作日期
	 **/
	public Date getQuoteEndTime() {
		return this.quoteEndTime;
	}
	/**
	 * 项目所属机构
	 **/
	public String getBranchId() {
		return this.branchId;
	}
	/**
	 * 阶段计划名称
	 **/
	public String getProjectPhaseName() {
		return this.projectPhaseName;
	}
	/**
	 * 任务名称
	 **/
	public String getTaskName() {
		return this.taskName;
	}
	/**
	 * 是否主负责人0否1是
	 **/
	public String getIsLeader() {
		return this.isLeader;
	}

}