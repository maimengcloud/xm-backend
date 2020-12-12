package  com.qqkj.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 组织 com.qqkj  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmIterationState所有属性名: <br>
 *	id,distBudgetCost,distBudgetWorkload,actCost,actWorkload,actStaffNum,finishRate,testCases,execCases,designCases,finishCases,projectCnt,productCnt,menuCnt,taskCnt,finishTaskCnt,calcTime,iterationName,budgetCost,budgetWorkload,iterationId,bizDate,closedBugCnt,resolvedBugCnt,activeBugCnt,confirmedBugCnt,bugCnt;<br>
 * 表 XM.xm_iteration_state 迭代定义的所有字段名: <br>
 *	id,dist_budget_cost,dist_budget_workload,act_cost,act_workload,act_staff_num,finish_rate,test_cases,exec_cases,design_cases,finish_cases,project_cnt,product_cnt,menu_cnt,task_cnt,finish_task_cnt,calc_time,iteration_name,budget_cost,budget_workload,iteration_id,biz_date,closed_bug_cnt,resolved_bug_cnt,active_bug_cnt,confirmed_bug_cnt,bug_cnt;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="迭代定义")
public class XmIterationState  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="迭代编码,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="已分配到任务的预算从任务表汇总而来",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal distBudgetCost;
	
	@ApiModelProperty(notes="已分配到任务的预算工作量从任务表汇总而来",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal distBudgetWorkload;
	
	@ApiModelProperty(notes="实际成本从任务表汇总而来",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actCost;
	
	@ApiModelProperty(notes="实际工作量从任务表汇总而来",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actWorkload;
	
	@ApiModelProperty(notes="实际投入人员数",allowEmptyValue=true,example="",allowableValues="")
	Integer actStaffNum;
	
	@ApiModelProperty(notes="进度",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal finishRate;
	
	@ApiModelProperty(notes="测试案例总数",allowEmptyValue=true,example="",allowableValues="")
	Integer testCases;
	
	@ApiModelProperty(notes="测试中案例总数",allowEmptyValue=true,example="",allowableValues="")
	Integer execCases;
	
	@ApiModelProperty(notes="设计中案例总数",allowEmptyValue=true,example="",allowableValues="")
	Integer designCases;
	
	@ApiModelProperty(notes="完成案例总数",allowEmptyValue=true,example="",allowableValues="")
	Integer finishCases;
	
	@ApiModelProperty(notes="关联项目数",allowEmptyValue=true,example="",allowableValues="")
	Integer projectCnt;
	
	@ApiModelProperty(notes="关联产品数",allowEmptyValue=true,example="",allowableValues="")
	Integer productCnt;
	
	@ApiModelProperty(notes="关联故事数",allowEmptyValue=true,example="",allowableValues="")
	Integer menuCnt;
	
	@ApiModelProperty(notes="关联任务数",allowEmptyValue=true,example="",allowableValues="")
	Integer taskCnt;
	
	@ApiModelProperty(notes="已完成的任务数",allowEmptyValue=true,example="",allowableValues="")
	Integer finishTaskCnt;
	
	@ApiModelProperty(notes="计算日期",allowEmptyValue=true,example="",allowableValues="")
	Date calcTime;
	
	@ApiModelProperty(notes="迭代名称",allowEmptyValue=true,example="",allowableValues="")
	String iterationName;
	
	@ApiModelProperty(notes="预算成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetCost;
	
	@ApiModelProperty(notes="预算工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetWorkload;
	
	@ApiModelProperty(notes="迭代编号",allowEmptyValue=true,example="",allowableValues="")
	String iterationId;
	
	@ApiModelProperty(notes="业务日期yyyy-MM-dd字符串",allowEmptyValue=true,example="",allowableValues="")
	String bizDate;
	
	@ApiModelProperty(notes="已关闭bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer closedBugCnt;
	
	@ApiModelProperty(notes="已解决bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer resolvedBugCnt;
	
	@ApiModelProperty(notes="激活的bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer activeBugCnt;
	
	@ApiModelProperty(notes="已解决bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer confirmedBugCnt;
	
	@ApiModelProperty(notes="bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer bugCnt;

	/**迭代编码**/
	public XmIterationState(String id) {
		this.id = id;
	}
    
    /**迭代定义**/
	public XmIterationState() {
	}
	
	/**
	 * 迭代编码
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 已分配到任务的预算从任务表汇总而来
	 **/
	public void setDistBudgetCost(BigDecimal distBudgetCost) {
		this.distBudgetCost = distBudgetCost;
	}
	/**
	 * 已分配到任务的预算工作量从任务表汇总而来
	 **/
	public void setDistBudgetWorkload(BigDecimal distBudgetWorkload) {
		this.distBudgetWorkload = distBudgetWorkload;
	}
	/**
	 * 实际成本从任务表汇总而来
	 **/
	public void setActCost(BigDecimal actCost) {
		this.actCost = actCost;
	}
	/**
	 * 实际工作量从任务表汇总而来
	 **/
	public void setActWorkload(BigDecimal actWorkload) {
		this.actWorkload = actWorkload;
	}
	/**
	 * 实际投入人员数
	 **/
	public void setActStaffNum(Integer actStaffNum) {
		this.actStaffNum = actStaffNum;
	}
	/**
	 * 进度
	 **/
	public void setFinishRate(BigDecimal finishRate) {
		this.finishRate = finishRate;
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
	 * 关联项目数
	 **/
	public void setProjectCnt(Integer projectCnt) {
		this.projectCnt = projectCnt;
	}
	/**
	 * 关联产品数
	 **/
	public void setProductCnt(Integer productCnt) {
		this.productCnt = productCnt;
	}
	/**
	 * 关联故事数
	 **/
	public void setMenuCnt(Integer menuCnt) {
		this.menuCnt = menuCnt;
	}
	/**
	 * 关联任务数
	 **/
	public void setTaskCnt(Integer taskCnt) {
		this.taskCnt = taskCnt;
	}
	/**
	 * 已完成的任务数
	 **/
	public void setFinishTaskCnt(Integer finishTaskCnt) {
		this.finishTaskCnt = finishTaskCnt;
	}
	/**
	 * 计算日期
	 **/
	public void setCalcTime(Date calcTime) {
		this.calcTime = calcTime;
	}
	/**
	 * 迭代名称
	 **/
	public void setIterationName(String iterationName) {
		this.iterationName = iterationName;
	}
	/**
	 * 预算成本
	 **/
	public void setBudgetCost(BigDecimal budgetCost) {
		this.budgetCost = budgetCost;
	}
	/**
	 * 预算工作量
	 **/
	public void setBudgetWorkload(BigDecimal budgetWorkload) {
		this.budgetWorkload = budgetWorkload;
	}
	/**
	 * 迭代编号
	 **/
	public void setIterationId(String iterationId) {
		this.iterationId = iterationId;
	}
	/**
	 * 业务日期yyyy-MM-dd字符串
	 **/
	public void setBizDate(String bizDate) {
		this.bizDate = bizDate;
	}
	/**
	 * 已关闭bug总数
	 **/
	public void setClosedBugCnt(Integer closedBugCnt) {
		this.closedBugCnt = closedBugCnt;
	}
	/**
	 * 已解决bug总数
	 **/
	public void setResolvedBugCnt(Integer resolvedBugCnt) {
		this.resolvedBugCnt = resolvedBugCnt;
	}
	/**
	 * 激活的bug总数
	 **/
	public void setActiveBugCnt(Integer activeBugCnt) {
		this.activeBugCnt = activeBugCnt;
	}
	/**
	 * 已解决bug总数
	 **/
	public void setConfirmedBugCnt(Integer confirmedBugCnt) {
		this.confirmedBugCnt = confirmedBugCnt;
	}
	/**
	 * bug总数
	 **/
	public void setBugCnt(Integer bugCnt) {
		this.bugCnt = bugCnt;
	}
	
	/**
	 * 迭代编码
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 已分配到任务的预算从任务表汇总而来
	 **/
	public BigDecimal getDistBudgetCost() {
		return this.distBudgetCost;
	}
	/**
	 * 已分配到任务的预算工作量从任务表汇总而来
	 **/
	public BigDecimal getDistBudgetWorkload() {
		return this.distBudgetWorkload;
	}
	/**
	 * 实际成本从任务表汇总而来
	 **/
	public BigDecimal getActCost() {
		return this.actCost;
	}
	/**
	 * 实际工作量从任务表汇总而来
	 **/
	public BigDecimal getActWorkload() {
		return this.actWorkload;
	}
	/**
	 * 实际投入人员数
	 **/
	public Integer getActStaffNum() {
		return this.actStaffNum;
	}
	/**
	 * 进度
	 **/
	public BigDecimal getFinishRate() {
		return this.finishRate;
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
	 * 关联项目数
	 **/
	public Integer getProjectCnt() {
		return this.projectCnt;
	}
	/**
	 * 关联产品数
	 **/
	public Integer getProductCnt() {
		return this.productCnt;
	}
	/**
	 * 关联故事数
	 **/
	public Integer getMenuCnt() {
		return this.menuCnt;
	}
	/**
	 * 关联任务数
	 **/
	public Integer getTaskCnt() {
		return this.taskCnt;
	}
	/**
	 * 已完成的任务数
	 **/
	public Integer getFinishTaskCnt() {
		return this.finishTaskCnt;
	}
	/**
	 * 计算日期
	 **/
	public Date getCalcTime() {
		return this.calcTime;
	}
	/**
	 * 迭代名称
	 **/
	public String getIterationName() {
		return this.iterationName;
	}
	/**
	 * 预算成本
	 **/
	public BigDecimal getBudgetCost() {
		return this.budgetCost;
	}
	/**
	 * 预算工作量
	 **/
	public BigDecimal getBudgetWorkload() {
		return this.budgetWorkload;
	}
	/**
	 * 迭代编号
	 **/
	public String getIterationId() {
		return this.iterationId;
	}
	/**
	 * 业务日期yyyy-MM-dd字符串
	 **/
	public String getBizDate() {
		return this.bizDate;
	}
	/**
	 * 已关闭bug总数
	 **/
	public Integer getClosedBugCnt() {
		return this.closedBugCnt;
	}
	/**
	 * 已解决bug总数
	 **/
	public Integer getResolvedBugCnt() {
		return this.resolvedBugCnt;
	}
	/**
	 * 激活的bug总数
	 **/
	public Integer getActiveBugCnt() {
		return this.activeBugCnt;
	}
	/**
	 * 已解决bug总数
	 **/
	public Integer getConfirmedBugCnt() {
		return this.confirmedBugCnt;
	}
	/**
	 * bug总数
	 **/
	public Integer getBugCnt() {
		return this.bugCnt;
	}

}