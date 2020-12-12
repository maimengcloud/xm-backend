package  com.qqkj.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com.qqkj  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmProjectPhase所有属性名: <br>
 *	id,phaseName,remark,parentPhaseId,branchId,projectId,beginDate,endDate,phaseBudgetHours,phaseBudgetStaffNu,ctime,phaseBudgetNouserAt,phaseBudgetInnerUserAt,phaseBudgetOutUserAt,projectBaselineId,bizProcInstId,bizFlowState,phaseBudgetWorkload,phaseActWorkload,phaseActInnerUserWorkload,phaseActOutUserWorkload,taskType,planType,seqNo,phaseBudgetInnerUserWorkload,phaseBudgetOutUserWorkload,actNouserAt,actInnerUserAt,phaseBudgetInnerUserPrice,phaseBudgetOutUserPrice,phaseBudgetOutUserCnt,phaseBudgetInnerUserCnt,actRate,phaseStatus,actOutUserAt,taskCnt,finishTaskCnt,iterationCnt,calcTime,taskBudgetWorkload,taskBudgetAt;<br>
 * 表 XM.xm_project_phase 项目阶段模板的所有字段名: <br>
 *	id,phase_name,remark,parent_phase_id,branch_id,project_id,begin_date,end_date,phase_budget_hours,phase_budget_staff_nu,ctime,phase_budget_nouser_at,phase_budget_inner_user_at,phase_budget_out_user_at,project_baseline_id,biz_proc_inst_id,biz_flow_state,phase_budget_workload,phase_act_workload,phase_act_inner_user_workload,phase_act_out_user_workload,task_type,plan_type,seq_no,phase_budget_inner_user_workload,phase_budget_out_user_workload,act_nouser_at,act_inner_user_at,phase_budget_inner_user_price,phase_budget_out_user_price,phase_budget_out_user_cnt,phase_budget_inner_user_cnt,act_rate,phase_status,act_out_user_at,task_cnt,finish_task_cnt,iteration_cnt,calc_time,task_budget_workload,task_budget_at;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="项目阶段模板")
public class XmProjectPhase  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="阶段主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
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
	
	@ApiModelProperty(notes="工时(不包括下一级)-应该大于或等于task中总工时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseBudgetHours;
	
	@ApiModelProperty(notes="投入人员数(不包括下一级)-应该大于或等于task中总人数",allowEmptyValue=true,example="",allowableValues="")
	Integer phaseBudgetStaffNu;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="非人力成本总预算(不包括下一级)-应该大于或等于task中非人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseBudgetNouserAt;
	
	@ApiModelProperty(notes="内部人力成本总预算(不包括下一级)-应该大于或等于task中内部人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseBudgetInnerUserAt;
	
	@ApiModelProperty(notes="外购人力成本总预算(不包括下一级)-应该大于或等于task中外购总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseBudgetOutUserAt;
	
	@ApiModelProperty(notes="项目级基线",allowEmptyValue=true,example="",allowableValues="")
	String projectBaselineId;
	
	@ApiModelProperty(notes="当前流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String bizProcInstId;
	
	@ApiModelProperty(notes="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;
	
	@ApiModelProperty(notes="总工作量单位人时-应该大于或者等于task中的预算总工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseBudgetWorkload;
	
	@ApiModelProperty(notes="已完成工作量单位人时-从task中的实际工作量算出",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseActWorkload;
	
	@ApiModelProperty(notes="实际内部人力工作量-来自任务表合计",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseActInnerUserWorkload;
	
	@ApiModelProperty(notes="实际外购人力工作量-来自任务表合计",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseActOutUserWorkload;
	
	@ApiModelProperty(notes="0售前方案1投标2需求3设计4开发5测试6验收7部署8运维--来自基础数据表taskType",allowEmptyValue=true,example="",allowableValues="")
	String taskType;
	
	@ApiModelProperty(notes="计划类型w1-周,w2-2周,w3-3周,m1-1月,m2-2月,q1-季,q2-半年，y1-年",allowEmptyValue=true,example="",allowableValues="")
	String planType;
	
	@ApiModelProperty(notes="顺序号",allowEmptyValue=true,example="",allowableValues="")
	String seqNo;
	
	@ApiModelProperty(notes="内部人力工作量总预算(不包括下一级)-应该大于或等于task中内部人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseBudgetInnerUserWorkload;
	
	@ApiModelProperty(notes="外购人力工作量总预算(不包括下一级)-应该大于或等于task中外购总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseBudgetOutUserWorkload;
	
	@ApiModelProperty(notes="实际非人力成本-来自任务表合计",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actNouserAt;
	
	@ApiModelProperty(notes="实际内部人力成本-来自任务表合计",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actInnerUserAt;
	
	@ApiModelProperty(notes="内部人力成本单价元/人时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseBudgetInnerUserPrice;
	
	@ApiModelProperty(notes="外购人力成本单价元/人时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseBudgetOutUserPrice;
	
	@ApiModelProperty(notes="外购人数",allowEmptyValue=true,example="",allowableValues="")
	Integer phaseBudgetOutUserCnt;
	
	@ApiModelProperty(notes="内部人数",allowEmptyValue=true,example="",allowableValues="")
	Integer phaseBudgetInnerUserCnt;
	
	@ApiModelProperty(notes="实际进度0-100",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actRate;
	
	@ApiModelProperty(notes="阶段状态0初始1执行中2完工3关闭4删除中5已删除6暂停",allowEmptyValue=true,example="",allowableValues="")
	String phaseStatus;
	
	@ApiModelProperty(notes="实际外部人力成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actOutUserAt;
	
	@ApiModelProperty(notes="任务数",allowEmptyValue=true,example="",allowableValues="")
	Integer taskCnt;
	
	@ApiModelProperty(notes="完成的任务数",allowEmptyValue=true,example="",allowableValues="")
	Integer finishTaskCnt;
	
	@ApiModelProperty(notes="迭代数",allowEmptyValue=true,example="",allowableValues="")
	Integer iterationCnt;
	
	@ApiModelProperty(notes="统计数据时间",allowEmptyValue=true,example="",allowableValues="")
	Date calcTime;
	
	@ApiModelProperty(notes="从任务汇总的预算工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal taskBudgetWorkload;
	
	@ApiModelProperty(notes="从任务汇总的预算金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal taskBudgetAt;

	/**阶段主键**/
	public XmProjectPhase(String id) {
		this.id = id;
	}
    
    /**项目阶段模板**/
	public XmProjectPhase() {
	}
	
	/**
	 * 阶段主键
	 **/
	public void setId(String id) {
		this.id = id;
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
	 * 工时(不包括下一级)-应该大于或等于task中总工时
	 **/
	public void setPhaseBudgetHours(BigDecimal phaseBudgetHours) {
		this.phaseBudgetHours = phaseBudgetHours;
	}
	/**
	 * 投入人员数(不包括下一级)-应该大于或等于task中总人数
	 **/
	public void setPhaseBudgetStaffNu(Integer phaseBudgetStaffNu) {
		this.phaseBudgetStaffNu = phaseBudgetStaffNu;
	}
	/**
	 * 创建时间
	 **/
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	/**
	 * 非人力成本总预算(不包括下一级)-应该大于或等于task中非人力总成本
	 **/
	public void setPhaseBudgetNouserAt(BigDecimal phaseBudgetNouserAt) {
		this.phaseBudgetNouserAt = phaseBudgetNouserAt;
	}
	/**
	 * 内部人力成本总预算(不包括下一级)-应该大于或等于task中内部人力总成本
	 **/
	public void setPhaseBudgetInnerUserAt(BigDecimal phaseBudgetInnerUserAt) {
		this.phaseBudgetInnerUserAt = phaseBudgetInnerUserAt;
	}
	/**
	 * 外购人力成本总预算(不包括下一级)-应该大于或等于task中外购总成本
	 **/
	public void setPhaseBudgetOutUserAt(BigDecimal phaseBudgetOutUserAt) {
		this.phaseBudgetOutUserAt = phaseBudgetOutUserAt;
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
	 * 总工作量单位人时-应该大于或者等于task中的预算总工作量
	 **/
	public void setPhaseBudgetWorkload(BigDecimal phaseBudgetWorkload) {
		this.phaseBudgetWorkload = phaseBudgetWorkload;
	}
	/**
	 * 已完成工作量单位人时-从task中的实际工作量算出
	 **/
	public void setPhaseActWorkload(BigDecimal phaseActWorkload) {
		this.phaseActWorkload = phaseActWorkload;
	}
	/**
	 * 实际内部人力工作量-来自任务表合计
	 **/
	public void setPhaseActInnerUserWorkload(BigDecimal phaseActInnerUserWorkload) {
		this.phaseActInnerUserWorkload = phaseActInnerUserWorkload;
	}
	/**
	 * 实际外购人力工作量-来自任务表合计
	 **/
	public void setPhaseActOutUserWorkload(BigDecimal phaseActOutUserWorkload) {
		this.phaseActOutUserWorkload = phaseActOutUserWorkload;
	}
	/**
	 * 0售前方案1投标2需求3设计4开发5测试6验收7部署8运维--来自基础数据表taskType
	 **/
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	/**
	 * 计划类型w1-周,w2-2周,w3-3周,m1-1月,m2-2月,q1-季,q2-半年，y1-年
	 **/
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	/**
	 * 顺序号
	 **/
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	/**
	 * 内部人力工作量总预算(不包括下一级)-应该大于或等于task中内部人力总成本
	 **/
	public void setPhaseBudgetInnerUserWorkload(BigDecimal phaseBudgetInnerUserWorkload) {
		this.phaseBudgetInnerUserWorkload = phaseBudgetInnerUserWorkload;
	}
	/**
	 * 外购人力工作量总预算(不包括下一级)-应该大于或等于task中外购总成本
	 **/
	public void setPhaseBudgetOutUserWorkload(BigDecimal phaseBudgetOutUserWorkload) {
		this.phaseBudgetOutUserWorkload = phaseBudgetOutUserWorkload;
	}
	/**
	 * 实际非人力成本-来自任务表合计
	 **/
	public void setActNouserAt(BigDecimal actNouserAt) {
		this.actNouserAt = actNouserAt;
	}
	/**
	 * 实际内部人力成本-来自任务表合计
	 **/
	public void setActInnerUserAt(BigDecimal actInnerUserAt) {
		this.actInnerUserAt = actInnerUserAt;
	}
	/**
	 * 内部人力成本单价元/人时
	 **/
	public void setPhaseBudgetInnerUserPrice(BigDecimal phaseBudgetInnerUserPrice) {
		this.phaseBudgetInnerUserPrice = phaseBudgetInnerUserPrice;
	}
	/**
	 * 外购人力成本单价元/人时
	 **/
	public void setPhaseBudgetOutUserPrice(BigDecimal phaseBudgetOutUserPrice) {
		this.phaseBudgetOutUserPrice = phaseBudgetOutUserPrice;
	}
	/**
	 * 外购人数
	 **/
	public void setPhaseBudgetOutUserCnt(Integer phaseBudgetOutUserCnt) {
		this.phaseBudgetOutUserCnt = phaseBudgetOutUserCnt;
	}
	/**
	 * 内部人数
	 **/
	public void setPhaseBudgetInnerUserCnt(Integer phaseBudgetInnerUserCnt) {
		this.phaseBudgetInnerUserCnt = phaseBudgetInnerUserCnt;
	}
	/**
	 * 实际进度0-100
	 **/
	public void setActRate(BigDecimal actRate) {
		this.actRate = actRate;
	}
	/**
	 * 阶段状态0初始1执行中2完工3关闭4删除中5已删除6暂停
	 **/
	public void setPhaseStatus(String phaseStatus) {
		this.phaseStatus = phaseStatus;
	}
	/**
	 * 实际外部人力成本
	 **/
	public void setActOutUserAt(BigDecimal actOutUserAt) {
		this.actOutUserAt = actOutUserAt;
	}
	/**
	 * 任务数
	 **/
	public void setTaskCnt(Integer taskCnt) {
		this.taskCnt = taskCnt;
	}
	/**
	 * 完成的任务数
	 **/
	public void setFinishTaskCnt(Integer finishTaskCnt) {
		this.finishTaskCnt = finishTaskCnt;
	}
	/**
	 * 迭代数
	 **/
	public void setIterationCnt(Integer iterationCnt) {
		this.iterationCnt = iterationCnt;
	}
	/**
	 * 统计数据时间
	 **/
	public void setCalcTime(Date calcTime) {
		this.calcTime = calcTime;
	}
	/**
	 * 从任务汇总的预算工作量
	 **/
	public void setTaskBudgetWorkload(BigDecimal taskBudgetWorkload) {
		this.taskBudgetWorkload = taskBudgetWorkload;
	}
	/**
	 * 从任务汇总的预算金额
	 **/
	public void setTaskBudgetAt(BigDecimal taskBudgetAt) {
		this.taskBudgetAt = taskBudgetAt;
	}
	
	/**
	 * 阶段主键
	 **/
	public String getId() {
		return this.id;
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
	 * 工时(不包括下一级)-应该大于或等于task中总工时
	 **/
	public BigDecimal getPhaseBudgetHours() {
		return this.phaseBudgetHours;
	}
	/**
	 * 投入人员数(不包括下一级)-应该大于或等于task中总人数
	 **/
	public Integer getPhaseBudgetStaffNu() {
		return this.phaseBudgetStaffNu;
	}
	/**
	 * 创建时间
	 **/
	public Date getCtime() {
		return this.ctime;
	}
	/**
	 * 非人力成本总预算(不包括下一级)-应该大于或等于task中非人力总成本
	 **/
	public BigDecimal getPhaseBudgetNouserAt() {
		return this.phaseBudgetNouserAt;
	}
	/**
	 * 内部人力成本总预算(不包括下一级)-应该大于或等于task中内部人力总成本
	 **/
	public BigDecimal getPhaseBudgetInnerUserAt() {
		return this.phaseBudgetInnerUserAt;
	}
	/**
	 * 外购人力成本总预算(不包括下一级)-应该大于或等于task中外购总成本
	 **/
	public BigDecimal getPhaseBudgetOutUserAt() {
		return this.phaseBudgetOutUserAt;
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
	 * 总工作量单位人时-应该大于或者等于task中的预算总工作量
	 **/
	public BigDecimal getPhaseBudgetWorkload() {
		return this.phaseBudgetWorkload;
	}
	/**
	 * 已完成工作量单位人时-从task中的实际工作量算出
	 **/
	public BigDecimal getPhaseActWorkload() {
		return this.phaseActWorkload;
	}
	/**
	 * 实际内部人力工作量-来自任务表合计
	 **/
	public BigDecimal getPhaseActInnerUserWorkload() {
		return this.phaseActInnerUserWorkload;
	}
	/**
	 * 实际外购人力工作量-来自任务表合计
	 **/
	public BigDecimal getPhaseActOutUserWorkload() {
		return this.phaseActOutUserWorkload;
	}
	/**
	 * 0售前方案1投标2需求3设计4开发5测试6验收7部署8运维--来自基础数据表taskType
	 **/
	public String getTaskType() {
		return this.taskType;
	}
	/**
	 * 计划类型w1-周,w2-2周,w3-3周,m1-1月,m2-2月,q1-季,q2-半年，y1-年
	 **/
	public String getPlanType() {
		return this.planType;
	}
	/**
	 * 顺序号
	 **/
	public String getSeqNo() {
		return this.seqNo;
	}
	/**
	 * 内部人力工作量总预算(不包括下一级)-应该大于或等于task中内部人力总成本
	 **/
	public BigDecimal getPhaseBudgetInnerUserWorkload() {
		return this.phaseBudgetInnerUserWorkload;
	}
	/**
	 * 外购人力工作量总预算(不包括下一级)-应该大于或等于task中外购总成本
	 **/
	public BigDecimal getPhaseBudgetOutUserWorkload() {
		return this.phaseBudgetOutUserWorkload;
	}
	/**
	 * 实际非人力成本-来自任务表合计
	 **/
	public BigDecimal getActNouserAt() {
		return this.actNouserAt;
	}
	/**
	 * 实际内部人力成本-来自任务表合计
	 **/
	public BigDecimal getActInnerUserAt() {
		return this.actInnerUserAt;
	}
	/**
	 * 内部人力成本单价元/人时
	 **/
	public BigDecimal getPhaseBudgetInnerUserPrice() {
		return this.phaseBudgetInnerUserPrice;
	}
	/**
	 * 外购人力成本单价元/人时
	 **/
	public BigDecimal getPhaseBudgetOutUserPrice() {
		return this.phaseBudgetOutUserPrice;
	}
	/**
	 * 外购人数
	 **/
	public Integer getPhaseBudgetOutUserCnt() {
		return this.phaseBudgetOutUserCnt;
	}
	/**
	 * 内部人数
	 **/
	public Integer getPhaseBudgetInnerUserCnt() {
		return this.phaseBudgetInnerUserCnt;
	}
	/**
	 * 实际进度0-100
	 **/
	public BigDecimal getActRate() {
		return this.actRate;
	}
	/**
	 * 阶段状态0初始1执行中2完工3关闭4删除中5已删除6暂停
	 **/
	public String getPhaseStatus() {
		return this.phaseStatus;
	}
	/**
	 * 实际外部人力成本
	 **/
	public BigDecimal getActOutUserAt() {
		return this.actOutUserAt;
	}
	/**
	 * 任务数
	 **/
	public Integer getTaskCnt() {
		return this.taskCnt;
	}
	/**
	 * 完成的任务数
	 **/
	public Integer getFinishTaskCnt() {
		return this.finishTaskCnt;
	}
	/**
	 * 迭代数
	 **/
	public Integer getIterationCnt() {
		return this.iterationCnt;
	}
	/**
	 * 统计数据时间
	 **/
	public Date getCalcTime() {
		return this.calcTime;
	}
	/**
	 * 从任务汇总的预算工作量
	 **/
	public BigDecimal getTaskBudgetWorkload() {
		return this.taskBudgetWorkload;
	}
	/**
	 * 从任务汇总的预算金额
	 **/
	public BigDecimal getTaskBudgetAt() {
		return this.taskBudgetAt;
	}

}