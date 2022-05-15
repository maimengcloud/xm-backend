package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmIterationStateHis所有属性名: <br>
 *	iterationId,bizDate,fileCnt,iterationName,calcTime,calcStatus,phaseCnt,phaseFinishCnt,needPayAt,finishPayAt,needColAt,finishColAt,riskCnt,riskFinishCnt,branchId,branchName,budgetNouserAt,budgetOuserAt,budgetIuserAt,actUserAt,actIuserAt,actOuserAt,actNouserAt,finishRate,budgetWorkload,budgetOuserWorkload,budgetIuserWorkload,estimateWorkload,actWorkload,projectStatus,actOuserWorkload,actIuserWorkload,needPayCnt,finishPayCnt,finishPayUserCnt,needPayUserCnt,testCases,execCases,designCases,finishCases,iterationCnt,productCnt,minStartTime,maxEndTime,menuCnt,menuFinishCnt,menuExecCnt,menuUnstartCnt,menuCloseCnt,taskCnt,taskUnstartCnt,taskExecCnt,taskFinishCnt,taskSetCnt,taskOutCnt,taskCloseCnt,bugCnt,closedBugs,resolvedBugs,activeBugs,confirmedBugs,planWorkhours,planWorkerCnt,actWorkerCnt,projectCnt,budgetAt,actAt;<br>
 * 表 xm_iteration_state_his 项目指标日统计表的所有字段名: <br>
 *	iteration_id,biz_date,file_cnt,iteration_name,calc_time,calc_status,phase_cnt,phase_finish_cnt,need_pay_at,finish_pay_at,need_col_at,finish_col_at,risk_cnt,risk_finish_cnt,branch_id,branch_name,budget_nouser_at,budget_ouser_at,budget_iuser_at,act_user_at,act_iuser_at,act_ouser_at,act_nouser_at,finish_rate,budget_workload,budget_ouser_workload,budget_iuser_workload,estimate_workload,act_workload,project_status,act_ouser_workload,act_iuser_workload,need_pay_cnt,finish_pay_cnt,finish_pay_user_cnt,need_pay_user_cnt,test_cases,exec_cases,design_cases,finish_cases,iteration_cnt,product_cnt,min_start_time,max_end_time,menu_cnt,menu_finish_cnt,menu_exec_cnt,menu_unstart_cnt,menu_close_cnt,task_cnt,task_unstart_cnt,task_exec_cnt,task_finish_cnt,task_set_cnt,task_out_cnt,task_close_cnt,bug_cnt,closed_bugs,resolved_bugs,active_bugs,confirmed_bugs,plan_workhours,plan_worker_cnt,act_worker_cnt,project_cnt,budget_at,act_at;<br>
 * 当前主键(包括多主键):<br>
 *	iteration_id,biz_date;<br>
 */
@ApiModel(description="项目指标日统计表")
public class XmIterationStateHis  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="迭代编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String iterationId;
	
	@ApiModelProperty(notes="统计日期yyyy-mm-dd类型,主键",allowEmptyValue=true,example="",allowableValues="")
	String bizDate;
  	
	
	@ApiModelProperty(notes="文件数据",allowEmptyValue=true,example="",allowableValues="")
	Integer fileCnt;
	
	@ApiModelProperty(notes="迭代名称",allowEmptyValue=true,example="",allowableValues="")
	String iterationName;
	
	@ApiModelProperty(notes="统计执行日期",allowEmptyValue=true,example="",allowableValues="")
	Date calcTime;
	
	@ApiModelProperty(notes="0-暂时的1稳定的，暂时的可以被覆盖，稳定的不允许覆盖",allowEmptyValue=true,example="",allowableValues="")
	String calcStatus;
	
	@ApiModelProperty(notes="项目阶段计划数",allowEmptyValue=true,example="",allowableValues="")
	Integer phaseCnt;
	
	@ApiModelProperty(notes="项目阶段计划已完成数",allowEmptyValue=true,example="",allowableValues="")
	Integer phaseFinishCnt;
	
	@ApiModelProperty(notes="待付款总金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal needPayAt;
	
	@ApiModelProperty(notes="已付款总金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal finishPayAt;
	
	@ApiModelProperty(notes="待收款总金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal needColAt;
	
	@ApiModelProperty(notes="已收款总金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal finishColAt;
	
	@ApiModelProperty(notes="项目风险总数",allowEmptyValue=true,example="",allowableValues="")
	Integer riskCnt;
	
	@ApiModelProperty(notes="已完成风险总数",allowEmptyValue=true,example="",allowableValues="")
	Integer riskFinishCnt;
	
	@ApiModelProperty(notes="机构编号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="机构名称",allowEmptyValue=true,example="",allowableValues="")
	String branchName;
	
	@ApiModelProperty(notes="项目总非人力预算-来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetNouserAt;
	
	@ApiModelProperty(notes="项目总外购人力预算-来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetOuserAt;
	
	@ApiModelProperty(notes="项目总内部人力预算-来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetIuserAt;
	
	@ApiModelProperty(notes="项目总人力成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actUserAt;
	
	@ApiModelProperty(notes="项目总内部人力成本金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actIuserAt;
	
	@ApiModelProperty(notes="项目总外购人力成本金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actOuserAt;
	
	@ApiModelProperty(notes="项目总非人力成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actNouserAt;
	
	@ApiModelProperty(notes="项目进度0~100之间，来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal finishRate;
	
	@ApiModelProperty(notes="项目总预算工作量-来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetWorkload;
	
	@ApiModelProperty(notes="外购人力总工作量-应该大于或等于阶段计划外购人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetOuserWorkload;
	
	@ApiModelProperty(notes="内部人力总工作量-应该大于或等于阶段计划内部人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetIuserWorkload;
	
	@ApiModelProperty(notes="预估工时=计划结束时间在计算当日前完成的任务的预算工时总和",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal estimateWorkload;
	
	@ApiModelProperty(notes="已完成工作量-来自计划中实际完成工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actWorkload;
	
	@ApiModelProperty(notes="0|初始",allowEmptyValue=true,example="",allowableValues="")
	String projectStatus;
	
	@ApiModelProperty(notes="实际外购总工作量，来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actOuserWorkload;
	
	@ApiModelProperty(notes="实际内部总工作量，来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actIuserWorkload;
	
	@ApiModelProperty(notes="待付款笔数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal needPayCnt;
	
	@ApiModelProperty(notes="完成付款总比数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal finishPayCnt;
	
	@ApiModelProperty(notes="已付款总人数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal finishPayUserCnt;
	
	@ApiModelProperty(notes="待付款总人数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal needPayUserCnt;
	
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
	
	@ApiModelProperty(notes="最早开始日期",allowEmptyValue=true,example="",allowableValues="")
	Date minStartTime;
	
	@ApiModelProperty(notes="最晚结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date maxEndTime;
	
	@ApiModelProperty(notes="故事数",allowEmptyValue=true,example="",allowableValues="")
	Integer menuCnt;
	
	@ApiModelProperty(notes="已完成需求数，2状态需求",allowEmptyValue=true,example="",allowableValues="")
	Integer menuFinishCnt;
	
	@ApiModelProperty(notes="执行中需求数，1状态的需求",allowEmptyValue=true,example="",allowableValues="")
	Integer menuExecCnt;
	
	@ApiModelProperty(notes="未开始需求数，0状态数据",allowEmptyValue=true,example="",allowableValues="")
	Integer menuUnstartCnt;
	
	@ApiModelProperty(notes="已关闭需求数，3状态数据",allowEmptyValue=true,example="",allowableValues="")
	Integer menuCloseCnt;
	
	@ApiModelProperty(notes="任务总数",allowEmptyValue=true,example="",allowableValues="")
	Integer taskCnt;
	
	@ApiModelProperty(notes="待开始任务",allowEmptyValue=true,example="",allowableValues="")
	Integer taskUnstartCnt;
	
	@ApiModelProperty(notes="执行中任务",allowEmptyValue=true,example="",allowableValues="")
	Integer taskExecCnt;
	
	@ApiModelProperty(notes="已完成任务总数-来自任务表",allowEmptyValue=true,example="",allowableValues="")
	Integer taskFinishCnt;
	
	@ApiModelProperty(notes="已结算任务",allowEmptyValue=true,example="",allowableValues="")
	Integer taskSetCnt;
	
	@ApiModelProperty(notes="外购任务数，来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal taskOutCnt;
	
	@ApiModelProperty(notes="已关闭任务",allowEmptyValue=true,example="",allowableValues="")
	Integer taskCloseCnt;
	
	@ApiModelProperty(notes="bug数目",allowEmptyValue=true,example="",allowableValues="")
	Integer bugCnt;
	
	@ApiModelProperty(notes="已关闭bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer closedBugs;
	
	@ApiModelProperty(notes="已解决bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer resolvedBugs;
	
	@ApiModelProperty(notes="激活的bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer activeBugs;
	
	@ApiModelProperty(notes="已解决bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer confirmedBugs;
	
	@ApiModelProperty(notes="工期（小时）",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planWorkhours;
	
	@ApiModelProperty(notes="总人数",allowEmptyValue=true,example="",allowableValues="")
	Integer planWorkerCnt;
	
	@ApiModelProperty(notes="实际投入人员数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actWorkerCnt;
	
	@ApiModelProperty(notes="项目数",allowEmptyValue=true,example="",allowableValues="")
	Integer projectCnt;
	
	@ApiModelProperty(notes="预算总金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetAt;
	
	@ApiModelProperty(notes="实际总金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actAt;

	/**迭代编号,统计日期yyyy-mm-dd类型**/
	public XmIterationStateHis(String iterationId,String bizDate) {
		this.iterationId = iterationId;
		this.bizDate = bizDate;
	}
    
    /**项目指标日统计表**/
	public XmIterationStateHis() {
	}
	
	/**
	 * 迭代编号
	 **/
	public void setIterationId(String iterationId) {
		this.iterationId = iterationId;
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
	public void setFileCnt(Integer fileCnt) {
		this.fileCnt = fileCnt;
	}
	/**
	 * 迭代名称
	 **/
	public void setIterationName(String iterationName) {
		this.iterationName = iterationName;
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
	 * 项目阶段计划数
	 **/
	public void setPhaseCnt(Integer phaseCnt) {
		this.phaseCnt = phaseCnt;
	}
	/**
	 * 项目阶段计划已完成数
	 **/
	public void setPhaseFinishCnt(Integer phaseFinishCnt) {
		this.phaseFinishCnt = phaseFinishCnt;
	}
	/**
	 * 待付款总金额
	 **/
	public void setNeedPayAt(BigDecimal needPayAt) {
		this.needPayAt = needPayAt;
	}
	/**
	 * 已付款总金额
	 **/
	public void setFinishPayAt(BigDecimal finishPayAt) {
		this.finishPayAt = finishPayAt;
	}
	/**
	 * 待收款总金额
	 **/
	public void setNeedColAt(BigDecimal needColAt) {
		this.needColAt = needColAt;
	}
	/**
	 * 已收款总金额
	 **/
	public void setFinishColAt(BigDecimal finishColAt) {
		this.finishColAt = finishColAt;
	}
	/**
	 * 项目风险总数
	 **/
	public void setRiskCnt(Integer riskCnt) {
		this.riskCnt = riskCnt;
	}
	/**
	 * 已完成风险总数
	 **/
	public void setRiskFinishCnt(Integer riskFinishCnt) {
		this.riskFinishCnt = riskFinishCnt;
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
	 * 项目总非人力预算-来自任务表
	 **/
	public void setBudgetNouserAt(BigDecimal budgetNouserAt) {
		this.budgetNouserAt = budgetNouserAt;
	}
	/**
	 * 项目总外购人力预算-来自任务表
	 **/
	public void setBudgetOuserAt(BigDecimal budgetOuserAt) {
		this.budgetOuserAt = budgetOuserAt;
	}
	/**
	 * 项目总内部人力预算-来自任务表
	 **/
	public void setBudgetIuserAt(BigDecimal budgetIuserAt) {
		this.budgetIuserAt = budgetIuserAt;
	}
	/**
	 * 项目总人力成本
	 **/
	public void setActUserAt(BigDecimal actUserAt) {
		this.actUserAt = actUserAt;
	}
	/**
	 * 项目总内部人力成本金额
	 **/
	public void setActIuserAt(BigDecimal actIuserAt) {
		this.actIuserAt = actIuserAt;
	}
	/**
	 * 项目总外购人力成本金额
	 **/
	public void setActOuserAt(BigDecimal actOuserAt) {
		this.actOuserAt = actOuserAt;
	}
	/**
	 * 项目总非人力成本
	 **/
	public void setActNouserAt(BigDecimal actNouserAt) {
		this.actNouserAt = actNouserAt;
	}
	/**
	 * 项目进度0~100之间，来自任务表
	 **/
	public void setFinishRate(BigDecimal finishRate) {
		this.finishRate = finishRate;
	}
	/**
	 * 项目总预算工作量-来自任务表
	 **/
	public void setBudgetWorkload(BigDecimal budgetWorkload) {
		this.budgetWorkload = budgetWorkload;
	}
	/**
	 * 外购人力总工作量-应该大于或等于阶段计划外购人力总成本
	 **/
	public void setBudgetOuserWorkload(BigDecimal budgetOuserWorkload) {
		this.budgetOuserWorkload = budgetOuserWorkload;
	}
	/**
	 * 内部人力总工作量-应该大于或等于阶段计划内部人力总成本
	 **/
	public void setBudgetIuserWorkload(BigDecimal budgetIuserWorkload) {
		this.budgetIuserWorkload = budgetIuserWorkload;
	}
	/**
	 * 预估工时=计划结束时间在计算当日前完成的任务的预算工时总和
	 **/
	public void setEstimateWorkload(BigDecimal estimateWorkload) {
		this.estimateWorkload = estimateWorkload;
	}
	/**
	 * 已完成工作量-来自计划中实际完成工作量
	 **/
	public void setActWorkload(BigDecimal actWorkload) {
		this.actWorkload = actWorkload;
	}
	/**
	 * 0|初始
	 **/
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	/**
	 * 实际外购总工作量，来自任务表
	 **/
	public void setActOuserWorkload(BigDecimal actOuserWorkload) {
		this.actOuserWorkload = actOuserWorkload;
	}
	/**
	 * 实际内部总工作量，来自任务表
	 **/
	public void setActIuserWorkload(BigDecimal actIuserWorkload) {
		this.actIuserWorkload = actIuserWorkload;
	}
	/**
	 * 待付款笔数
	 **/
	public void setNeedPayCnt(BigDecimal needPayCnt) {
		this.needPayCnt = needPayCnt;
	}
	/**
	 * 完成付款总比数
	 **/
	public void setFinishPayCnt(BigDecimal finishPayCnt) {
		this.finishPayCnt = finishPayCnt;
	}
	/**
	 * 已付款总人数
	 **/
	public void setFinishPayUserCnt(BigDecimal finishPayUserCnt) {
		this.finishPayUserCnt = finishPayUserCnt;
	}
	/**
	 * 待付款总人数
	 **/
	public void setNeedPayUserCnt(BigDecimal needPayUserCnt) {
		this.needPayUserCnt = needPayUserCnt;
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
	 * 最早开始日期
	 **/
	public void setMinStartTime(Date minStartTime) {
		this.minStartTime = minStartTime;
	}
	/**
	 * 最晚结束时间
	 **/
	public void setMaxEndTime(Date maxEndTime) {
		this.maxEndTime = maxEndTime;
	}
	/**
	 * 故事数
	 **/
	public void setMenuCnt(Integer menuCnt) {
		this.menuCnt = menuCnt;
	}
	/**
	 * 已完成需求数，2状态需求
	 **/
	public void setMenuFinishCnt(Integer menuFinishCnt) {
		this.menuFinishCnt = menuFinishCnt;
	}
	/**
	 * 执行中需求数，1状态的需求
	 **/
	public void setMenuExecCnt(Integer menuExecCnt) {
		this.menuExecCnt = menuExecCnt;
	}
	/**
	 * 未开始需求数，0状态数据
	 **/
	public void setMenuUnstartCnt(Integer menuUnstartCnt) {
		this.menuUnstartCnt = menuUnstartCnt;
	}
	/**
	 * 已关闭需求数，3状态数据
	 **/
	public void setMenuCloseCnt(Integer menuCloseCnt) {
		this.menuCloseCnt = menuCloseCnt;
	}
	/**
	 * 任务总数
	 **/
	public void setTaskCnt(Integer taskCnt) {
		this.taskCnt = taskCnt;
	}
	/**
	 * 待开始任务
	 **/
	public void setTaskUnstartCnt(Integer taskUnstartCnt) {
		this.taskUnstartCnt = taskUnstartCnt;
	}
	/**
	 * 执行中任务
	 **/
	public void setTaskExecCnt(Integer taskExecCnt) {
		this.taskExecCnt = taskExecCnt;
	}
	/**
	 * 已完成任务总数-来自任务表
	 **/
	public void setTaskFinishCnt(Integer taskFinishCnt) {
		this.taskFinishCnt = taskFinishCnt;
	}
	/**
	 * 已结算任务
	 **/
	public void setTaskSetCnt(Integer taskSetCnt) {
		this.taskSetCnt = taskSetCnt;
	}
	/**
	 * 外购任务数，来自任务表
	 **/
	public void setTaskOutCnt(BigDecimal taskOutCnt) {
		this.taskOutCnt = taskOutCnt;
	}
	/**
	 * 已关闭任务
	 **/
	public void setTaskCloseCnt(Integer taskCloseCnt) {
		this.taskCloseCnt = taskCloseCnt;
	}
	/**
	 * bug数目
	 **/
	public void setBugCnt(Integer bugCnt) {
		this.bugCnt = bugCnt;
	}
	/**
	 * 已关闭bug总数
	 **/
	public void setClosedBugs(Integer closedBugs) {
		this.closedBugs = closedBugs;
	}
	/**
	 * 已解决bug总数
	 **/
	public void setResolvedBugs(Integer resolvedBugs) {
		this.resolvedBugs = resolvedBugs;
	}
	/**
	 * 激活的bug总数
	 **/
	public void setActiveBugs(Integer activeBugs) {
		this.activeBugs = activeBugs;
	}
	/**
	 * 已解决bug总数
	 **/
	public void setConfirmedBugs(Integer confirmedBugs) {
		this.confirmedBugs = confirmedBugs;
	}
	/**
	 * 工期（小时）
	 **/
	public void setPlanWorkhours(BigDecimal planWorkhours) {
		this.planWorkhours = planWorkhours;
	}
	/**
	 * 总人数
	 **/
	public void setPlanWorkerCnt(Integer planWorkerCnt) {
		this.planWorkerCnt = planWorkerCnt;
	}
	/**
	 * 实际投入人员数
	 **/
	public void setActWorkerCnt(BigDecimal actWorkerCnt) {
		this.actWorkerCnt = actWorkerCnt;
	}
	/**
	 * 项目数
	 **/
	public void setProjectCnt(Integer projectCnt) {
		this.projectCnt = projectCnt;
	}
	/**
	 * 预算总金额
	 **/
	public void setBudgetAt(BigDecimal budgetAt) {
		this.budgetAt = budgetAt;
	}
	/**
	 * 实际总金额
	 **/
	public void setActAt(BigDecimal actAt) {
		this.actAt = actAt;
	}
	
	/**
	 * 迭代编号
	 **/
	public String getIterationId() {
		return this.iterationId;
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
	public Integer getFileCnt() {
		return this.fileCnt;
	}
	/**
	 * 迭代名称
	 **/
	public String getIterationName() {
		return this.iterationName;
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
	 * 项目阶段计划数
	 **/
	public Integer getPhaseCnt() {
		return this.phaseCnt;
	}
	/**
	 * 项目阶段计划已完成数
	 **/
	public Integer getPhaseFinishCnt() {
		return this.phaseFinishCnt;
	}
	/**
	 * 待付款总金额
	 **/
	public BigDecimal getNeedPayAt() {
		return this.needPayAt;
	}
	/**
	 * 已付款总金额
	 **/
	public BigDecimal getFinishPayAt() {
		return this.finishPayAt;
	}
	/**
	 * 待收款总金额
	 **/
	public BigDecimal getNeedColAt() {
		return this.needColAt;
	}
	/**
	 * 已收款总金额
	 **/
	public BigDecimal getFinishColAt() {
		return this.finishColAt;
	}
	/**
	 * 项目风险总数
	 **/
	public Integer getRiskCnt() {
		return this.riskCnt;
	}
	/**
	 * 已完成风险总数
	 **/
	public Integer getRiskFinishCnt() {
		return this.riskFinishCnt;
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
	 * 项目总非人力预算-来自任务表
	 **/
	public BigDecimal getBudgetNouserAt() {
		return this.budgetNouserAt;
	}
	/**
	 * 项目总外购人力预算-来自任务表
	 **/
	public BigDecimal getBudgetOuserAt() {
		return this.budgetOuserAt;
	}
	/**
	 * 项目总内部人力预算-来自任务表
	 **/
	public BigDecimal getBudgetIuserAt() {
		return this.budgetIuserAt;
	}
	/**
	 * 项目总人力成本
	 **/
	public BigDecimal getActUserAt() {
		return this.actUserAt;
	}
	/**
	 * 项目总内部人力成本金额
	 **/
	public BigDecimal getActIuserAt() {
		return this.actIuserAt;
	}
	/**
	 * 项目总外购人力成本金额
	 **/
	public BigDecimal getActOuserAt() {
		return this.actOuserAt;
	}
	/**
	 * 项目总非人力成本
	 **/
	public BigDecimal getActNouserAt() {
		return this.actNouserAt;
	}
	/**
	 * 项目进度0~100之间，来自任务表
	 **/
	public BigDecimal getFinishRate() {
		return this.finishRate;
	}
	/**
	 * 项目总预算工作量-来自任务表
	 **/
	public BigDecimal getBudgetWorkload() {
		return this.budgetWorkload;
	}
	/**
	 * 外购人力总工作量-应该大于或等于阶段计划外购人力总成本
	 **/
	public BigDecimal getBudgetOuserWorkload() {
		return this.budgetOuserWorkload;
	}
	/**
	 * 内部人力总工作量-应该大于或等于阶段计划内部人力总成本
	 **/
	public BigDecimal getBudgetIuserWorkload() {
		return this.budgetIuserWorkload;
	}
	/**
	 * 预估工时=计划结束时间在计算当日前完成的任务的预算工时总和
	 **/
	public BigDecimal getEstimateWorkload() {
		return this.estimateWorkload;
	}
	/**
	 * 已完成工作量-来自计划中实际完成工作量
	 **/
	public BigDecimal getActWorkload() {
		return this.actWorkload;
	}
	/**
	 * 0|初始
	 **/
	public String getProjectStatus() {
		return this.projectStatus;
	}
	/**
	 * 实际外购总工作量，来自任务表
	 **/
	public BigDecimal getActOuserWorkload() {
		return this.actOuserWorkload;
	}
	/**
	 * 实际内部总工作量，来自任务表
	 **/
	public BigDecimal getActIuserWorkload() {
		return this.actIuserWorkload;
	}
	/**
	 * 待付款笔数
	 **/
	public BigDecimal getNeedPayCnt() {
		return this.needPayCnt;
	}
	/**
	 * 完成付款总比数
	 **/
	public BigDecimal getFinishPayCnt() {
		return this.finishPayCnt;
	}
	/**
	 * 已付款总人数
	 **/
	public BigDecimal getFinishPayUserCnt() {
		return this.finishPayUserCnt;
	}
	/**
	 * 待付款总人数
	 **/
	public BigDecimal getNeedPayUserCnt() {
		return this.needPayUserCnt;
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
	 * 最早开始日期
	 **/
	public Date getMinStartTime() {
		return this.minStartTime;
	}
	/**
	 * 最晚结束时间
	 **/
	public Date getMaxEndTime() {
		return this.maxEndTime;
	}
	/**
	 * 故事数
	 **/
	public Integer getMenuCnt() {
		return this.menuCnt;
	}
	/**
	 * 已完成需求数，2状态需求
	 **/
	public Integer getMenuFinishCnt() {
		return this.menuFinishCnt;
	}
	/**
	 * 执行中需求数，1状态的需求
	 **/
	public Integer getMenuExecCnt() {
		return this.menuExecCnt;
	}
	/**
	 * 未开始需求数，0状态数据
	 **/
	public Integer getMenuUnstartCnt() {
		return this.menuUnstartCnt;
	}
	/**
	 * 已关闭需求数，3状态数据
	 **/
	public Integer getMenuCloseCnt() {
		return this.menuCloseCnt;
	}
	/**
	 * 任务总数
	 **/
	public Integer getTaskCnt() {
		return this.taskCnt;
	}
	/**
	 * 待开始任务
	 **/
	public Integer getTaskUnstartCnt() {
		return this.taskUnstartCnt;
	}
	/**
	 * 执行中任务
	 **/
	public Integer getTaskExecCnt() {
		return this.taskExecCnt;
	}
	/**
	 * 已完成任务总数-来自任务表
	 **/
	public Integer getTaskFinishCnt() {
		return this.taskFinishCnt;
	}
	/**
	 * 已结算任务
	 **/
	public Integer getTaskSetCnt() {
		return this.taskSetCnt;
	}
	/**
	 * 外购任务数，来自任务表
	 **/
	public BigDecimal getTaskOutCnt() {
		return this.taskOutCnt;
	}
	/**
	 * 已关闭任务
	 **/
	public Integer getTaskCloseCnt() {
		return this.taskCloseCnt;
	}
	/**
	 * bug数目
	 **/
	public Integer getBugCnt() {
		return this.bugCnt;
	}
	/**
	 * 已关闭bug总数
	 **/
	public Integer getClosedBugs() {
		return this.closedBugs;
	}
	/**
	 * 已解决bug总数
	 **/
	public Integer getResolvedBugs() {
		return this.resolvedBugs;
	}
	/**
	 * 激活的bug总数
	 **/
	public Integer getActiveBugs() {
		return this.activeBugs;
	}
	/**
	 * 已解决bug总数
	 **/
	public Integer getConfirmedBugs() {
		return this.confirmedBugs;
	}
	/**
	 * 工期（小时）
	 **/
	public BigDecimal getPlanWorkhours() {
		return this.planWorkhours;
	}
	/**
	 * 总人数
	 **/
	public Integer getPlanWorkerCnt() {
		return this.planWorkerCnt;
	}
	/**
	 * 实际投入人员数
	 **/
	public BigDecimal getActWorkerCnt() {
		return this.actWorkerCnt;
	}
	/**
	 * 项目数
	 **/
	public Integer getProjectCnt() {
		return this.projectCnt;
	}
	/**
	 * 预算总金额
	 **/
	public BigDecimal getBudgetAt() {
		return this.budgetAt;
	}
	/**
	 * 实际总金额
	 **/
	public BigDecimal getActAt() {
		return this.actAt;
	}

}