package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmMenuState所有属性名: <br>
 *	menuId,finishRate,menuStatus,ctime,calcTime,menuName,planWorkhours,planWorkerCnt,closedBugs,activeBugs,confirmedBugs,resolvedBugs,productId,testCases,execCases,designCases,finishCases,bizDate,bugCnt,taskCnt,taskUnstartCnt,taskExecCnt,taskFinishCnt,taskSetCnt,taskOutCnt,taskCloseCnt,budgetNouserAt,budgetOuserAt,budgetIuserAt,actUserAt,actIuserAt,actOuserAt,actNouserAt,budgetWorkload,budgetOuserWorkload,budgetIuserWorkload,actWorkload,actOuserWorkload,actIuserWorkload,estimateWorkload,budgetAt,actAt,minStartTime,maxEndTime,productCnt,iterationCnt,projectCnt;<br>
 * 表 xm_menu_state 功能状态表,无需前端维护，所有数据由汇总统计得出的所有字段名: <br>
 *	menu_id,finish_rate,menu_status,ctime,calc_time,menu_name,plan_workhours,plan_worker_cnt,closed_bugs,active_bugs,confirmed_bugs,resolved_bugs,product_id,test_cases,exec_cases,design_cases,finish_cases,biz_date,bug_cnt,task_cnt,task_unstart_cnt,task_exec_cnt,task_finish_cnt,task_set_cnt,task_out_cnt,task_close_cnt,budget_nouser_at,budget_ouser_at,budget_iuser_at,act_user_at,act_iuser_at,act_ouser_at,act_nouser_at,budget_workload,budget_ouser_workload,budget_iuser_workload,act_workload,act_ouser_workload,act_iuser_workload,estimate_workload,budget_at,act_at,min_start_time,max_end_time,product_cnt,iteration_cnt,project_cnt;<br>
 * 当前主键(包括多主键):<br>
 *	menu_id;<br>
 */
@ApiModel(description="功能状态表,无需前端维护，所有数据由汇总统计得出")
public class XmMenuState  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="功能编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String menuId;
  	
	
	@ApiModelProperty(notes="总体完成比例0-100之间,根据taskType进行汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal finishRate;
	
	@ApiModelProperty(notes="状态0初始1设计中2开发中3测试中4uat测试2已上线3已下线4已删除",allowEmptyValue=true,example="",allowableValues="")
	String menuStatus;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="汇总时间",allowEmptyValue=true,example="",allowableValues="")
	Date calcTime;
	
	@ApiModelProperty(notes="菜单名字",allowEmptyValue=true,example="",allowableValues="")
	String menuName;
	
	@ApiModelProperty(notes="工时数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planWorkhours;
	
	@ApiModelProperty(notes="总人数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planWorkerCnt;
	
	@ApiModelProperty(notes="总关闭bugs",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal closedBugs;
	
	@ApiModelProperty(notes="激活bugs",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal activeBugs;
	
	@ApiModelProperty(notes="已确认bugs总数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal confirmedBugs;
	
	@ApiModelProperty(notes="已解决bugs总数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal resolvedBugs;
	
	@ApiModelProperty(notes="产品编号",allowEmptyValue=true,example="",allowableValues="")
	String productId;
	
	@ApiModelProperty(notes="测试案例总数",allowEmptyValue=true,example="",allowableValues="")
	Integer testCases;
	
	@ApiModelProperty(notes="测试中案例总数",allowEmptyValue=true,example="",allowableValues="")
	Integer execCases;
	
	@ApiModelProperty(notes="设计中案例总数",allowEmptyValue=true,example="",allowableValues="")
	Integer designCases;
	
	@ApiModelProperty(notes="完成案例总数",allowEmptyValue=true,example="",allowableValues="")
	Integer finishCases;
	
	@ApiModelProperty(notes="业务日期yyyy-MM-dd字符串",allowEmptyValue=true,example="",allowableValues="")
	String bizDate;
	
	@ApiModelProperty(notes="bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer bugCnt;
	
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
	
	@ApiModelProperty(notes="项目总预算工作量-来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetWorkload;
	
	@ApiModelProperty(notes="外购人力总工作量-应该大于或等于阶段计划外购人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetOuserWorkload;
	
	@ApiModelProperty(notes="内部人力总工作量-应该大于或等于阶段计划内部人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetIuserWorkload;
	
	@ApiModelProperty(notes="已完成工作量-来自计划中实际完成工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actWorkload;
	
	@ApiModelProperty(notes="实际外购总工作量，来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actOuserWorkload;
	
	@ApiModelProperty(notes="实际内部总工作量，来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actIuserWorkload;
	
	@ApiModelProperty(notes="预估工时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal estimateWorkload;
	
	@ApiModelProperty(notes="预算金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetAt;
	
	@ApiModelProperty(notes="实际金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actAt;
	
	@ApiModelProperty(notes="最早开始日期",allowEmptyValue=true,example="",allowableValues="")
	Date minStartTime;
	
	@ApiModelProperty(notes="最晚结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date maxEndTime;
	
	@ApiModelProperty(notes="关联产品数（主要是指子节点关联）",allowEmptyValue=true,example="",allowableValues="")
	Integer productCnt;
	
	@ApiModelProperty(notes="关联迭代数（主要是指子节点关联）",allowEmptyValue=true,example="",allowableValues="")
	Integer iterationCnt;
	
	@ApiModelProperty(notes="关联项目数（主要是指子节点关联）",allowEmptyValue=true,example="",allowableValues="")
	Integer projectCnt;

	/**功能编号**/
	public XmMenuState(String menuId) {
		this.menuId = menuId;
	}
    
    /**功能状态表,无需前端维护，所有数据由汇总统计得出**/
	public XmMenuState() {
	}
	
	/**
	 * 功能编号
	 **/
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	/**
	 * 总体完成比例0-100之间,根据taskType进行汇总
	 **/
	public void setFinishRate(BigDecimal finishRate) {
		this.finishRate = finishRate;
	}
	/**
	 * 状态0初始1设计中2开发中3测试中4uat测试2已上线3已下线4已删除
	 **/
	public void setMenuStatus(String menuStatus) {
		this.menuStatus = menuStatus;
	}
	/**
	 * 创建时间
	 **/
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	/**
	 * 汇总时间
	 **/
	public void setCalcTime(Date calcTime) {
		this.calcTime = calcTime;
	}
	/**
	 * 菜单名字
	 **/
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/**
	 * 工时数
	 **/
	public void setPlanWorkhours(BigDecimal planWorkhours) {
		this.planWorkhours = planWorkhours;
	}
	/**
	 * 总人数
	 **/
	public void setPlanWorkerCnt(BigDecimal planWorkerCnt) {
		this.planWorkerCnt = planWorkerCnt;
	}
	/**
	 * 总关闭bugs
	 **/
	public void setClosedBugs(BigDecimal closedBugs) {
		this.closedBugs = closedBugs;
	}
	/**
	 * 激活bugs
	 **/
	public void setActiveBugs(BigDecimal activeBugs) {
		this.activeBugs = activeBugs;
	}
	/**
	 * 已确认bugs总数
	 **/
	public void setConfirmedBugs(BigDecimal confirmedBugs) {
		this.confirmedBugs = confirmedBugs;
	}
	/**
	 * 已解决bugs总数
	 **/
	public void setResolvedBugs(BigDecimal resolvedBugs) {
		this.resolvedBugs = resolvedBugs;
	}
	/**
	 * 产品编号
	 **/
	public void setProductId(String productId) {
		this.productId = productId;
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
	 * 业务日期yyyy-MM-dd字符串
	 **/
	public void setBizDate(String bizDate) {
		this.bizDate = bizDate;
	}
	/**
	 * bug总数
	 **/
	public void setBugCnt(Integer bugCnt) {
		this.bugCnt = bugCnt;
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
	 * 已完成工作量-来自计划中实际完成工作量
	 **/
	public void setActWorkload(BigDecimal actWorkload) {
		this.actWorkload = actWorkload;
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
	 * 预估工时
	 **/
	public void setEstimateWorkload(BigDecimal estimateWorkload) {
		this.estimateWorkload = estimateWorkload;
	}
	/**
	 * 预算金额
	 **/
	public void setBudgetAt(BigDecimal budgetAt) {
		this.budgetAt = budgetAt;
	}
	/**
	 * 实际金额
	 **/
	public void setActAt(BigDecimal actAt) {
		this.actAt = actAt;
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
	 * 关联产品数（主要是指子节点关联）
	 **/
	public void setProductCnt(Integer productCnt) {
		this.productCnt = productCnt;
	}
	/**
	 * 关联迭代数（主要是指子节点关联）
	 **/
	public void setIterationCnt(Integer iterationCnt) {
		this.iterationCnt = iterationCnt;
	}
	/**
	 * 关联项目数（主要是指子节点关联）
	 **/
	public void setProjectCnt(Integer projectCnt) {
		this.projectCnt = projectCnt;
	}
	
	/**
	 * 功能编号
	 **/
	public String getMenuId() {
		return this.menuId;
	}
	/**
	 * 总体完成比例0-100之间,根据taskType进行汇总
	 **/
	public BigDecimal getFinishRate() {
		return this.finishRate;
	}
	/**
	 * 状态0初始1设计中2开发中3测试中4uat测试2已上线3已下线4已删除
	 **/
	public String getMenuStatus() {
		return this.menuStatus;
	}
	/**
	 * 创建时间
	 **/
	public Date getCtime() {
		return this.ctime;
	}
	/**
	 * 汇总时间
	 **/
	public Date getCalcTime() {
		return this.calcTime;
	}
	/**
	 * 菜单名字
	 **/
	public String getMenuName() {
		return this.menuName;
	}
	/**
	 * 工时数
	 **/
	public BigDecimal getPlanWorkhours() {
		return this.planWorkhours;
	}
	/**
	 * 总人数
	 **/
	public BigDecimal getPlanWorkerCnt() {
		return this.planWorkerCnt;
	}
	/**
	 * 总关闭bugs
	 **/
	public BigDecimal getClosedBugs() {
		return this.closedBugs;
	}
	/**
	 * 激活bugs
	 **/
	public BigDecimal getActiveBugs() {
		return this.activeBugs;
	}
	/**
	 * 已确认bugs总数
	 **/
	public BigDecimal getConfirmedBugs() {
		return this.confirmedBugs;
	}
	/**
	 * 已解决bugs总数
	 **/
	public BigDecimal getResolvedBugs() {
		return this.resolvedBugs;
	}
	/**
	 * 产品编号
	 **/
	public String getProductId() {
		return this.productId;
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
	 * 业务日期yyyy-MM-dd字符串
	 **/
	public String getBizDate() {
		return this.bizDate;
	}
	/**
	 * bug总数
	 **/
	public Integer getBugCnt() {
		return this.bugCnt;
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
	 * 已完成工作量-来自计划中实际完成工作量
	 **/
	public BigDecimal getActWorkload() {
		return this.actWorkload;
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
	 * 预估工时
	 **/
	public BigDecimal getEstimateWorkload() {
		return this.estimateWorkload;
	}
	/**
	 * 预算金额
	 **/
	public BigDecimal getBudgetAt() {
		return this.budgetAt;
	}
	/**
	 * 实际金额
	 **/
	public BigDecimal getActAt() {
		return this.actAt;
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
	 * 关联产品数（主要是指子节点关联）
	 **/
	public Integer getProductCnt() {
		return this.productCnt;
	}
	/**
	 * 关联迭代数（主要是指子节点关联）
	 **/
	public Integer getIterationCnt() {
		return this.iterationCnt;
	}
	/**
	 * 关联项目数（主要是指子节点关联）
	 **/
	public Integer getProjectCnt() {
		return this.projectCnt;
	}

}