package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmTaskExecuser所有属性名: <br>
 *	createTime,taskId,userid,startTime,endTime,status,remarks,createUserid,createUsername,username,matchScore,quoteWeekday,quoteAmount,quoteTime,projectId,phaseId,skillRemark,quoteWorkload,quoteStartTime,quoteEndTime,branchId,phaseName,taskName,distUserid,distUsername,execUserBranchId,shareKey,sfeeRate,sfee;<br>
 * 表 xm_task_execuser xm_task_execuser的所有字段名: <br>
 *	create_time,task_id,userid,start_time,end_time,status,remarks,create_userid,create_username,username,match_score,quote_weekday,quote_amount,quote_time,project_id,phase_id,skill_remark,quote_workload,quote_start_time,quote_end_time,branch_id,phase_name,task_name,dist_userid,dist_username,exec_user_branch_id,share_key,sfee_rate,sfee;<br>
 * 当前主键(包括多主键):<br>
 *	task_id,userid;<br>
 */
@ApiModel(description="xm_task_execuser")
public class XmTaskExecuser  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="任务id,主键",allowEmptyValue=true,example="",allowableValues="")
	String taskId;
	
	@ApiModelProperty(notes="执行人id,主键",allowEmptyValue=true,example="",allowableValues="")
	String userid;
  	
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date createTime;
	
	@ApiModelProperty(notes="加入时间",allowEmptyValue=true,example="",allowableValues="")
	Date startTime;
	
	@ApiModelProperty(notes="离开时间",allowEmptyValue=true,example="",allowableValues="")
	Date endTime;
	
	@ApiModelProperty(notes="执行人状态0候选排队中1执行任务中7放弃任务8黑名单",allowEmptyValue=true,example="",allowableValues="")
	String status;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remarks;
	
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
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="阶段计划编号",allowEmptyValue=true,example="",allowableValues="")
	String phaseId;
	
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
	String phaseName;
	
	@ApiModelProperty(notes="任务名称",allowEmptyValue=true,example="",allowableValues="")
	String taskName;
	
	@ApiModelProperty(notes="推荐人编号",allowEmptyValue=true,example="",allowableValues="")
	String distUserid;
	
	@ApiModelProperty(notes="推荐人姓名",allowEmptyValue=true,example="",allowableValues="")
	String distUsername;
	
	@ApiModelProperty(notes="执行人归属公司",allowEmptyValue=true,example="",allowableValues="")
	String execUserBranchId;
	
	@ApiModelProperty(notes="分享码",allowEmptyValue=true,example="",allowableValues="")
	String shareKey;
	
	@ApiModelProperty(notes="服务费率",allowEmptyValue=true,example="",allowableValues="")
	Integer sfeeRate;
	
	@ApiModelProperty(notes="众包服务费",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal sfee;

	/**任务id,执行人id**/
	public XmTaskExecuser(String taskId,String userid) {
		this.taskId = taskId;
		this.userid = userid;
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
	 * 执行人状态0候选排队中1执行任务中7放弃任务8黑名单
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
	 * 项目编号
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 阶段计划编号
	 **/
	public void setPhaseId(String phaseId) {
		this.phaseId = phaseId;
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
	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}
	/**
	 * 任务名称
	 **/
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * 推荐人编号
	 **/
	public void setDistUserid(String distUserid) {
		this.distUserid = distUserid;
	}
	/**
	 * 推荐人姓名
	 **/
	public void setDistUsername(String distUsername) {
		this.distUsername = distUsername;
	}
	/**
	 * 执行人归属公司
	 **/
	public void setExecUserBranchId(String execUserBranchId) {
		this.execUserBranchId = execUserBranchId;
	}
	/**
	 * 分享码
	 **/
	public void setShareKey(String shareKey) {
		this.shareKey = shareKey;
	}
	/**
	 * 服务费率
	 **/
	public void setSfeeRate(Integer sfeeRate) {
		this.sfeeRate = sfeeRate;
	}
	/**
	 * 众包服务费
	 **/
	public void setSfee(BigDecimal sfee) {
		this.sfee = sfee;
	}
	
	/**
	 * 创建时间
	 **/
	public Date getCreateTime() {
		return this.createTime;
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
	 * 执行人状态0候选排队中1执行任务中7放弃任务8黑名单
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
	 * 项目编号
	 **/
	public String getProjectId() {
		return this.projectId;
	}
	/**
	 * 阶段计划编号
	 **/
	public String getPhaseId() {
		return this.phaseId;
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
	public String getPhaseName() {
		return this.phaseName;
	}
	/**
	 * 任务名称
	 **/
	public String getTaskName() {
		return this.taskName;
	}
	/**
	 * 推荐人编号
	 **/
	public String getDistUserid() {
		return this.distUserid;
	}
	/**
	 * 推荐人姓名
	 **/
	public String getDistUsername() {
		return this.distUsername;
	}
	/**
	 * 执行人归属公司
	 **/
	public String getExecUserBranchId() {
		return this.execUserBranchId;
	}
	/**
	 * 分享码
	 **/
	public String getShareKey() {
		return this.shareKey;
	}
	/**
	 * 服务费率
	 **/
	public Integer getSfeeRate() {
		return this.sfeeRate;
	}
	/**
	 * 众包服务费
	 **/
	public BigDecimal getSfee() {
		return this.sfee;
	}

}