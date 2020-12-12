package  com.qqkj.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com.qqkj  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmProductState所有属性名: <br>
 *	id,planStartTime,planEndTime,actStartTime,actEndTime,planWorkload,actWorkload,planCostAmount,actCostAmount,finishRate,demandRate,designRate,devRate,uatRate,sitRate,ctime,ltime,cuserid,cusername,calcTime,planWorkhours,planWorkerCnt,closedBugs,activeBugs,confirmedBugs,resolvedBugs,productId,productName,testCases,execCases,designCases,finishCases,projectCnt,iterationCnt,taskCnt,finishTaskCnt,bizDate,branchId,bugCnt;<br>
 * 表 XM.xm_product_state 功能状态表,无需前端维护，所有数据由汇总统计得出的所有字段名: <br>
 *	id,plan_start_time,plan_end_time,act_start_time,act_end_time,plan_workload,act_workload,plan_cost_amount,act_cost_amount,finish_rate,demand_rate,design_rate,dev_rate,uat_rate,sit_rate,ctime,ltime,cuserid,cusername,calc_time,plan_workhours,plan_worker_cnt,closed_bugs,active_bugs,confirmed_bugs,resolved_bugs,product_id,product_name,test_cases,exec_cases,design_cases,finish_cases,project_cnt,iteration_cnt,task_cnt,finish_task_cnt,biz_date,branch_id,bug_cnt;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="功能状态表,无需前端维护，所有数据由汇总统计得出")
public class XmProductState  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date planStartTime;
	
	@ApiModelProperty(notes="结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date planEndTime;
	
	@ApiModelProperty(notes="实际开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date actStartTime;
	
	@ApiModelProperty(notes="实际结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date actEndTime;
	
	@ApiModelProperty(notes="计划工作量，根据关联任务汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planWorkload;
	
	@ApiModelProperty(notes="实际工作量，根据关联任务汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actWorkload;
	
	@ApiModelProperty(notes="计划成本，根据关联任务汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planCostAmount;
	
	@ApiModelProperty(notes="实际成本金额根据关联任务汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actCostAmount;
	
	@ApiModelProperty(notes="总体完成比例0-100之间,根据taskType进行汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal finishRate;
	
	@ApiModelProperty(notes="需求完成率0-100之间,根据taskType进行汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal demandRate;
	
	@ApiModelProperty(notes="设计完成率0-100之间,根据taskType进行汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal designRate;
	
	@ApiModelProperty(notes="开发完成率0-100之间,根据taskType进行汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal devRate;
	
	@ApiModelProperty(notes="uat测试完成率0-100之间,根据taskType进行汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal uatRate;
	
	@ApiModelProperty(notes="sit测试完成率0-100之间,根据taskType进行汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal sitRate;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="更新时间",allowEmptyValue=true,example="",allowableValues="")
	Date ltime;
	
	@ApiModelProperty(notes="创建人编号",allowEmptyValue=true,example="",allowableValues="")
	String cuserid;
	
	@ApiModelProperty(notes="创建人姓名",allowEmptyValue=true,example="",allowableValues="")
	String cusername;
	
	@ApiModelProperty(notes="汇总时间",allowEmptyValue=true,example="",allowableValues="")
	Date calcTime;
	
	@ApiModelProperty(notes="工时数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planWorkhours;
	
	@ApiModelProperty(notes="总人数",allowEmptyValue=true,example="",allowableValues="")
	Integer planWorkerCnt;
	
	@ApiModelProperty(notes="总关闭bugs",allowEmptyValue=true,example="",allowableValues="")
	Integer closedBugs;
	
	@ApiModelProperty(notes="激活bugs",allowEmptyValue=true,example="",allowableValues="")
	Integer activeBugs;
	
	@ApiModelProperty(notes="已确认bugs总数",allowEmptyValue=true,example="",allowableValues="")
	Integer confirmedBugs;
	
	@ApiModelProperty(notes="已解决bugs总数",allowEmptyValue=true,example="",allowableValues="")
	Integer resolvedBugs;
	
	@ApiModelProperty(notes="产品编号",allowEmptyValue=true,example="",allowableValues="")
	String productId;
	
	@ApiModelProperty(notes="产品名称",allowEmptyValue=true,example="",allowableValues="")
	String productName;
	
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
	
	@ApiModelProperty(notes="关联迭代数",allowEmptyValue=true,example="",allowableValues="")
	Integer iterationCnt;
	
	@ApiModelProperty(notes="任务总数",allowEmptyValue=true,example="",allowableValues="")
	Integer taskCnt;
	
	@ApiModelProperty(notes="已完成的任务总数",allowEmptyValue=true,example="",allowableValues="")
	Integer finishTaskCnt;
	
	@ApiModelProperty(notes="业务日期yyyy-MM-dd字符串",allowEmptyValue=true,example="",allowableValues="")
	String bizDate;
	
	@ApiModelProperty(notes="机构号码",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer bugCnt;

	/**主键**/
	public XmProductState(String id) {
		this.id = id;
	}
    
    /**功能状态表,无需前端维护，所有数据由汇总统计得出**/
	public XmProductState() {
	}
	
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 开始时间
	 **/
	public void setPlanStartTime(Date planStartTime) {
		this.planStartTime = planStartTime;
	}
	/**
	 * 结束时间
	 **/
	public void setPlanEndTime(Date planEndTime) {
		this.planEndTime = planEndTime;
	}
	/**
	 * 实际开始时间
	 **/
	public void setActStartTime(Date actStartTime) {
		this.actStartTime = actStartTime;
	}
	/**
	 * 实际结束时间
	 **/
	public void setActEndTime(Date actEndTime) {
		this.actEndTime = actEndTime;
	}
	/**
	 * 计划工作量，根据关联任务汇总
	 **/
	public void setPlanWorkload(BigDecimal planWorkload) {
		this.planWorkload = planWorkload;
	}
	/**
	 * 实际工作量，根据关联任务汇总
	 **/
	public void setActWorkload(BigDecimal actWorkload) {
		this.actWorkload = actWorkload;
	}
	/**
	 * 计划成本，根据关联任务汇总
	 **/
	public void setPlanCostAmount(BigDecimal planCostAmount) {
		this.planCostAmount = planCostAmount;
	}
	/**
	 * 实际成本金额根据关联任务汇总
	 **/
	public void setActCostAmount(BigDecimal actCostAmount) {
		this.actCostAmount = actCostAmount;
	}
	/**
	 * 总体完成比例0-100之间,根据taskType进行汇总
	 **/
	public void setFinishRate(BigDecimal finishRate) {
		this.finishRate = finishRate;
	}
	/**
	 * 需求完成率0-100之间,根据taskType进行汇总
	 **/
	public void setDemandRate(BigDecimal demandRate) {
		this.demandRate = demandRate;
	}
	/**
	 * 设计完成率0-100之间,根据taskType进行汇总
	 **/
	public void setDesignRate(BigDecimal designRate) {
		this.designRate = designRate;
	}
	/**
	 * 开发完成率0-100之间,根据taskType进行汇总
	 **/
	public void setDevRate(BigDecimal devRate) {
		this.devRate = devRate;
	}
	/**
	 * uat测试完成率0-100之间,根据taskType进行汇总
	 **/
	public void setUatRate(BigDecimal uatRate) {
		this.uatRate = uatRate;
	}
	/**
	 * sit测试完成率0-100之间,根据taskType进行汇总
	 **/
	public void setSitRate(BigDecimal sitRate) {
		this.sitRate = sitRate;
	}
	/**
	 * 创建时间
	 **/
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	/**
	 * 更新时间
	 **/
	public void setLtime(Date ltime) {
		this.ltime = ltime;
	}
	/**
	 * 创建人编号
	 **/
	public void setCuserid(String cuserid) {
		this.cuserid = cuserid;
	}
	/**
	 * 创建人姓名
	 **/
	public void setCusername(String cusername) {
		this.cusername = cusername;
	}
	/**
	 * 汇总时间
	 **/
	public void setCalcTime(Date calcTime) {
		this.calcTime = calcTime;
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
	public void setPlanWorkerCnt(Integer planWorkerCnt) {
		this.planWorkerCnt = planWorkerCnt;
	}
	/**
	 * 总关闭bugs
	 **/
	public void setClosedBugs(Integer closedBugs) {
		this.closedBugs = closedBugs;
	}
	/**
	 * 激活bugs
	 **/
	public void setActiveBugs(Integer activeBugs) {
		this.activeBugs = activeBugs;
	}
	/**
	 * 已确认bugs总数
	 **/
	public void setConfirmedBugs(Integer confirmedBugs) {
		this.confirmedBugs = confirmedBugs;
	}
	/**
	 * 已解决bugs总数
	 **/
	public void setResolvedBugs(Integer resolvedBugs) {
		this.resolvedBugs = resolvedBugs;
	}
	/**
	 * 产品编号
	 **/
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * 产品名称
	 **/
	public void setProductName(String productName) {
		this.productName = productName;
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
	 * 关联迭代数
	 **/
	public void setIterationCnt(Integer iterationCnt) {
		this.iterationCnt = iterationCnt;
	}
	/**
	 * 任务总数
	 **/
	public void setTaskCnt(Integer taskCnt) {
		this.taskCnt = taskCnt;
	}
	/**
	 * 已完成的任务总数
	 **/
	public void setFinishTaskCnt(Integer finishTaskCnt) {
		this.finishTaskCnt = finishTaskCnt;
	}
	/**
	 * 业务日期yyyy-MM-dd字符串
	 **/
	public void setBizDate(String bizDate) {
		this.bizDate = bizDate;
	}
	/**
	 * 机构号码
	 **/
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	/**
	 * bug总数
	 **/
	public void setBugCnt(Integer bugCnt) {
		this.bugCnt = bugCnt;
	}
	
	/**
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 开始时间
	 **/
	public Date getPlanStartTime() {
		return this.planStartTime;
	}
	/**
	 * 结束时间
	 **/
	public Date getPlanEndTime() {
		return this.planEndTime;
	}
	/**
	 * 实际开始时间
	 **/
	public Date getActStartTime() {
		return this.actStartTime;
	}
	/**
	 * 实际结束时间
	 **/
	public Date getActEndTime() {
		return this.actEndTime;
	}
	/**
	 * 计划工作量，根据关联任务汇总
	 **/
	public BigDecimal getPlanWorkload() {
		return this.planWorkload;
	}
	/**
	 * 实际工作量，根据关联任务汇总
	 **/
	public BigDecimal getActWorkload() {
		return this.actWorkload;
	}
	/**
	 * 计划成本，根据关联任务汇总
	 **/
	public BigDecimal getPlanCostAmount() {
		return this.planCostAmount;
	}
	/**
	 * 实际成本金额根据关联任务汇总
	 **/
	public BigDecimal getActCostAmount() {
		return this.actCostAmount;
	}
	/**
	 * 总体完成比例0-100之间,根据taskType进行汇总
	 **/
	public BigDecimal getFinishRate() {
		return this.finishRate;
	}
	/**
	 * 需求完成率0-100之间,根据taskType进行汇总
	 **/
	public BigDecimal getDemandRate() {
		return this.demandRate;
	}
	/**
	 * 设计完成率0-100之间,根据taskType进行汇总
	 **/
	public BigDecimal getDesignRate() {
		return this.designRate;
	}
	/**
	 * 开发完成率0-100之间,根据taskType进行汇总
	 **/
	public BigDecimal getDevRate() {
		return this.devRate;
	}
	/**
	 * uat测试完成率0-100之间,根据taskType进行汇总
	 **/
	public BigDecimal getUatRate() {
		return this.uatRate;
	}
	/**
	 * sit测试完成率0-100之间,根据taskType进行汇总
	 **/
	public BigDecimal getSitRate() {
		return this.sitRate;
	}
	/**
	 * 创建时间
	 **/
	public Date getCtime() {
		return this.ctime;
	}
	/**
	 * 更新时间
	 **/
	public Date getLtime() {
		return this.ltime;
	}
	/**
	 * 创建人编号
	 **/
	public String getCuserid() {
		return this.cuserid;
	}
	/**
	 * 创建人姓名
	 **/
	public String getCusername() {
		return this.cusername;
	}
	/**
	 * 汇总时间
	 **/
	public Date getCalcTime() {
		return this.calcTime;
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
	public Integer getPlanWorkerCnt() {
		return this.planWorkerCnt;
	}
	/**
	 * 总关闭bugs
	 **/
	public Integer getClosedBugs() {
		return this.closedBugs;
	}
	/**
	 * 激活bugs
	 **/
	public Integer getActiveBugs() {
		return this.activeBugs;
	}
	/**
	 * 已确认bugs总数
	 **/
	public Integer getConfirmedBugs() {
		return this.confirmedBugs;
	}
	/**
	 * 已解决bugs总数
	 **/
	public Integer getResolvedBugs() {
		return this.resolvedBugs;
	}
	/**
	 * 产品编号
	 **/
	public String getProductId() {
		return this.productId;
	}
	/**
	 * 产品名称
	 **/
	public String getProductName() {
		return this.productName;
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
	 * 关联迭代数
	 **/
	public Integer getIterationCnt() {
		return this.iterationCnt;
	}
	/**
	 * 任务总数
	 **/
	public Integer getTaskCnt() {
		return this.taskCnt;
	}
	/**
	 * 已完成的任务总数
	 **/
	public Integer getFinishTaskCnt() {
		return this.finishTaskCnt;
	}
	/**
	 * 业务日期yyyy-MM-dd字符串
	 **/
	public String getBizDate() {
		return this.bizDate;
	}
	/**
	 * 机构号码
	 **/
	public String getBranchId() {
		return this.branchId;
	}
	/**
	 * bug总数
	 **/
	public Integer getBugCnt() {
		return this.bugCnt;
	}

}