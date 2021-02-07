package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 组织 com.qqkj  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmTask所有属性名: <br>
 *	id,name,parentTaskid,parentTaskname,projectId,projectName,level,sortLevel,executorUserid,executorUsername,preTaskid,preTaskname,startTime,endTime,milestone,description,remarks,createUserid,createUsername,createTime,rate,budgetCost,budgetWorkload,actCost,actWorkload,taskState,taskType,taskClass,toTaskCenter,actStartTime,actEndTime,bizProcInstId,bizFlowState,projectPhaseId,projectPhaseName,taskSkillNames,exeUsernames,taskSkillIds,exeUserids,taskOut,planType,settleSchemel,menuId,menuName,iterationId,iterationName,productId,productName;<br>
 * 表 XM.xm_task xm_task的所有字段名: <br>
 *	id,name,parent_taskid,parent_taskname,project_id,project_name,level,sort_level,executor_userid,executor_username,pre_taskid,pre_taskname,start_time,end_time,milestone,description,remarks,create_userid,create_username,create_time,rate,budget_cost,budget_workload,act_cost,act_workload,task_state,task_type,task_class,to_task_center,act_start_time,act_end_time,biz_proc_inst_id,biz_flow_state,project_phase_id,project_phase_name,task_skill_names,exe_usernames,task_skill_ids,exe_userids,task_out,plan_type,settle_schemel,menu_id,menu_name,iteration_id,iteration_name,product_id,product_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_task")
public class XmTask  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="任务编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="任务名称",allowEmptyValue=true,example="",allowableValues="")
	String name;
	
	@ApiModelProperty(notes="父任务编号",allowEmptyValue=true,example="",allowableValues="")
	String parentTaskid;
	
	@ApiModelProperty(notes="父任务名称",allowEmptyValue=true,example="",allowableValues="")
	String parentTaskname;
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="项目名称",allowEmptyValue=true,example="",allowableValues="")
	String projectName;
	
	@ApiModelProperty(notes="任务级别",allowEmptyValue=true,example="",allowableValues="")
	String level;
	
	@ApiModelProperty(notes="排序级别",allowEmptyValue=true,example="",allowableValues="")
	String sortLevel;
	
	@ApiModelProperty(notes="任务执行人编号",allowEmptyValue=true,example="",allowableValues="")
	String executorUserid;
	
	@ApiModelProperty(notes="任务执行人",allowEmptyValue=true,example="",allowableValues="")
	String executorUsername;
	
	@ApiModelProperty(notes="前置任务编号",allowEmptyValue=true,example="",allowableValues="")
	String preTaskid;
	
	@ApiModelProperty(notes="前置任务名称",allowEmptyValue=true,example="",allowableValues="")
	String preTaskname;
	
	@ApiModelProperty(notes="任务开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date startTime;
	
	@ApiModelProperty(notes="任务结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date endTime;
	
	@ApiModelProperty(notes="里程碑",allowEmptyValue=true,example="",allowableValues="")
	String milestone;
	
	@ApiModelProperty(notes="任务描述",allowEmptyValue=true,example="",allowableValues="")
	String description;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remarks;
	
	@ApiModelProperty(notes="任务创建人编号",allowEmptyValue=true,example="",allowableValues="")
	String createUserid;
	
	@ApiModelProperty(notes="任务创建人",allowEmptyValue=true,example="",allowableValues="")
	String createUsername;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date createTime;
	
	@ApiModelProperty(notes="任务进度0-100",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal rate;
	
	@ApiModelProperty(notes="当前任务预算金额（包括所有成本，不包括下一级）",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetCost;
	
	@ApiModelProperty(notes="预算工时（不包括下一级）",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetWorkload;
	
	@ApiModelProperty(notes="当前任务实际费用金额（包括所有成本，不包括下一级）",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actCost;
	
	@ApiModelProperty(notes="实际工时（不包括下一级）",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actWorkload;
	
	@ApiModelProperty(notes="任务状态0待领取1已领取执行中2已完工3已结算",allowEmptyValue=true,example="",allowableValues="")
	String taskState;
	
	@ApiModelProperty(notes="0售前方案1投标2需求3设计4开发5测试6验收7部署8运维--来自基础数据表taskType",allowEmptyValue=true,example="",allowableValues="")
	String taskType;
	
	@ApiModelProperty(notes="1需结算0不需结算",allowEmptyValue=true,example="",allowableValues="")
	String taskClass;
	
	@ApiModelProperty(notes="是否发布到任务大厅0否1是",allowEmptyValue=true,example="",allowableValues="")
	String toTaskCenter;
	
	@ApiModelProperty(notes="实际开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date actStartTime;
	
	@ApiModelProperty(notes="实际结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date actEndTime;
	
	@ApiModelProperty(notes="当前流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String bizProcInstId;
	
	@ApiModelProperty(notes="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;
	
	@ApiModelProperty(notes="项目阶段编号",allowEmptyValue=true,example="",allowableValues="")
	String projectPhaseId;
	
	@ApiModelProperty(notes="项目阶段名称",allowEmptyValue=true,example="",allowableValues="")
	String projectPhaseName;
	
	@ApiModelProperty(notes="技能列表,逗号分隔",allowEmptyValue=true,example="",allowableValues="")
	String taskSkillNames;
	
	@ApiModelProperty(notes="执行人列表逗号分隔如陈x(审核人),王x(监控人)",allowEmptyValue=true,example="",allowableValues="")
	String exeUsernames;
	
	@ApiModelProperty(notes="技能编号列表逗号分隔",allowEmptyValue=true,example="",allowableValues="")
	String taskSkillIds;
	
	@ApiModelProperty(notes="执行人编号列表逗号分隔如u1(1),u2(2)",allowEmptyValue=true,example="",allowableValues="")
	String exeUserids;
	
	@ApiModelProperty(notes="是否外购",allowEmptyValue=true,example="",allowableValues="")
	String taskOut;
	
	@ApiModelProperty(notes="计划类型w1-周,w2-2周,w3-3周,m1-1月,m2-2月,q1-季,q2-半年，y1-年",allowEmptyValue=true,example="",allowableValues="")
	String planType;
	
	@ApiModelProperty(notes="任务结算方案-来自数字字典xmTaskSettleSchemel",allowEmptyValue=true,example="",allowableValues="")
	String settleSchemel;
	
	@ApiModelProperty(notes="归属功能编号",allowEmptyValue=true,example="",allowableValues="")
	String menuId;
	
	@ApiModelProperty(notes="归属功能名称",allowEmptyValue=true,example="",allowableValues="")
	String menuName;
	
	@ApiModelProperty(notes="迭代编号",allowEmptyValue=true,example="",allowableValues="")
	String iterationId;
	
	@ApiModelProperty(notes="迭代名称",allowEmptyValue=true,example="",allowableValues="")
	String iterationName;
	
	@ApiModelProperty(notes="产品编号",allowEmptyValue=true,example="",allowableValues="")
	String productId;
	
	@ApiModelProperty(notes="产品名称",allowEmptyValue=true,example="",allowableValues="")
	String productName;

	/**任务编号**/
	public XmTask(String id) {
		this.id = id;
	}
    
    /**xm_task**/
	public XmTask() {
	}
	
	/**
	 * 任务编号
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 任务名称
	 **/
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 父任务编号
	 **/
	public void setParentTaskid(String parentTaskid) {
		this.parentTaskid = parentTaskid;
	}
	/**
	 * 父任务名称
	 **/
	public void setParentTaskname(String parentTaskname) {
		this.parentTaskname = parentTaskname;
	}
	/**
	 * 项目编号
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 项目名称
	 **/
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 任务级别
	 **/
	public void setLevel(String level) {
		this.level = level;
	}
	/**
	 * 排序级别
	 **/
	public void setSortLevel(String sortLevel) {
		this.sortLevel = sortLevel;
	}
	/**
	 * 任务执行人编号
	 **/
	public void setExecutorUserid(String executorUserid) {
		this.executorUserid = executorUserid;
	}
	/**
	 * 任务执行人
	 **/
	public void setExecutorUsername(String executorUsername) {
		this.executorUsername = executorUsername;
	}
	/**
	 * 前置任务编号
	 **/
	public void setPreTaskid(String preTaskid) {
		this.preTaskid = preTaskid;
	}
	/**
	 * 前置任务名称
	 **/
	public void setPreTaskname(String preTaskname) {
		this.preTaskname = preTaskname;
	}
	/**
	 * 任务开始时间
	 **/
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 任务结束时间
	 **/
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 里程碑
	 **/
	public void setMilestone(String milestone) {
		this.milestone = milestone;
	}
	/**
	 * 任务描述
	 **/
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 备注
	 **/
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 任务创建人编号
	 **/
	public void setCreateUserid(String createUserid) {
		this.createUserid = createUserid;
	}
	/**
	 * 任务创建人
	 **/
	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}
	/**
	 * 创建时间
	 **/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 任务进度0-100
	 **/
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	/**
	 * 当前任务预算金额（包括所有成本，不包括下一级）
	 **/
	public void setBudgetCost(BigDecimal budgetCost) {
		this.budgetCost = budgetCost;
	}
	/**
	 * 预算工时（不包括下一级）
	 **/
	public void setBudgetWorkload(BigDecimal budgetWorkload) {
		this.budgetWorkload = budgetWorkload;
	}
	/**
	 * 当前任务实际费用金额（包括所有成本，不包括下一级）
	 **/
	public void setActCost(BigDecimal actCost) {
		this.actCost = actCost;
	}
	/**
	 * 实际工时（不包括下一级）
	 **/
	public void setActWorkload(BigDecimal actWorkload) {
		this.actWorkload = actWorkload;
	}
	/**
	 * 任务状态0待领取1已领取执行中2已完工3已结算
	 **/
	public void setTaskState(String taskState) {
		this.taskState = taskState;
	}
	/**
	 * 0售前方案1投标2需求3设计4开发5测试6验收7部署8运维--来自基础数据表taskType
	 **/
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	/**
	 * 1需结算0不需结算
	 **/
	public void setTaskClass(String taskClass) {
		this.taskClass = taskClass;
	}
	/**
	 * 是否发布到任务大厅0否1是
	 **/
	public void setToTaskCenter(String toTaskCenter) {
		this.toTaskCenter = toTaskCenter;
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
	 * 项目阶段编号
	 **/
	public void setProjectPhaseId(String projectPhaseId) {
		this.projectPhaseId = projectPhaseId;
	}
	/**
	 * 项目阶段名称
	 **/
	public void setProjectPhaseName(String projectPhaseName) {
		this.projectPhaseName = projectPhaseName;
	}
	/**
	 * 技能列表,逗号分隔
	 **/
	public void setTaskSkillNames(String taskSkillNames) {
		this.taskSkillNames = taskSkillNames;
	}
	/**
	 * 执行人列表逗号分隔如陈x(审核人),王x(监控人)
	 **/
	public void setExeUsernames(String exeUsernames) {
		this.exeUsernames = exeUsernames;
	}
	/**
	 * 技能编号列表逗号分隔
	 **/
	public void setTaskSkillIds(String taskSkillIds) {
		this.taskSkillIds = taskSkillIds;
	}
	/**
	 * 执行人编号列表逗号分隔如u1(1),u2(2)
	 **/
	public void setExeUserids(String exeUserids) {
		this.exeUserids = exeUserids;
	}
	/**
	 * 是否外购
	 **/
	public void setTaskOut(String taskOut) {
		this.taskOut = taskOut;
	}
	/**
	 * 计划类型w1-周,w2-2周,w3-3周,m1-1月,m2-2月,q1-季,q2-半年，y1-年
	 **/
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	/**
	 * 任务结算方案-来自数字字典xmTaskSettleSchemel
	 **/
	public void setSettleSchemel(String settleSchemel) {
		this.settleSchemel = settleSchemel;
	}
	/**
	 * 归属功能编号
	 **/
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	/**
	 * 归属功能名称
	 **/
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/**
	 * 迭代编号
	 **/
	public void setIterationId(String iterationId) {
		this.iterationId = iterationId;
	}
	/**
	 * 迭代名称
	 **/
	public void setIterationName(String iterationName) {
		this.iterationName = iterationName;
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
	 * 任务编号
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 任务名称
	 **/
	public String getName() {
		return this.name;
	}
	/**
	 * 父任务编号
	 **/
	public String getParentTaskid() {
		return this.parentTaskid;
	}
	/**
	 * 父任务名称
	 **/
	public String getParentTaskname() {
		return this.parentTaskname;
	}
	/**
	 * 项目编号
	 **/
	public String getProjectId() {
		return this.projectId;
	}
	/**
	 * 项目名称
	 **/
	public String getProjectName() {
		return this.projectName;
	}
	/**
	 * 任务级别
	 **/
	public String getLevel() {
		return this.level;
	}
	/**
	 * 排序级别
	 **/
	public String getSortLevel() {
		return this.sortLevel;
	}
	/**
	 * 任务执行人编号
	 **/
	public String getExecutorUserid() {
		return this.executorUserid;
	}
	/**
	 * 任务执行人
	 **/
	public String getExecutorUsername() {
		return this.executorUsername;
	}
	/**
	 * 前置任务编号
	 **/
	public String getPreTaskid() {
		return this.preTaskid;
	}
	/**
	 * 前置任务名称
	 **/
	public String getPreTaskname() {
		return this.preTaskname;
	}
	/**
	 * 任务开始时间
	 **/
	public Date getStartTime() {
		return this.startTime;
	}
	/**
	 * 任务结束时间
	 **/
	public Date getEndTime() {
		return this.endTime;
	}
	/**
	 * 里程碑
	 **/
	public String getMilestone() {
		return this.milestone;
	}
	/**
	 * 任务描述
	 **/
	public String getDescription() {
		return this.description;
	}
	/**
	 * 备注
	 **/
	public String getRemarks() {
		return this.remarks;
	}
	/**
	 * 任务创建人编号
	 **/
	public String getCreateUserid() {
		return this.createUserid;
	}
	/**
	 * 任务创建人
	 **/
	public String getCreateUsername() {
		return this.createUsername;
	}
	/**
	 * 创建时间
	 **/
	public Date getCreateTime() {
		return this.createTime;
	}
	/**
	 * 任务进度0-100
	 **/
	public BigDecimal getRate() {
		return this.rate;
	}
	/**
	 * 当前任务预算金额（包括所有成本，不包括下一级）
	 **/
	public BigDecimal getBudgetCost() {
		return this.budgetCost;
	}
	/**
	 * 预算工时（不包括下一级）
	 **/
	public BigDecimal getBudgetWorkload() {
		return this.budgetWorkload;
	}
	/**
	 * 当前任务实际费用金额（包括所有成本，不包括下一级）
	 **/
	public BigDecimal getActCost() {
		return this.actCost;
	}
	/**
	 * 实际工时（不包括下一级）
	 **/
	public BigDecimal getActWorkload() {
		return this.actWorkload;
	}
	/**
	 * 任务状态0待领取1已领取执行中2已完工3已结算
	 **/
	public String getTaskState() {
		return this.taskState;
	}
	/**
	 * 0售前方案1投标2需求3设计4开发5测试6验收7部署8运维--来自基础数据表taskType
	 **/
	public String getTaskType() {
		return this.taskType;
	}
	/**
	 * 1需结算0不需结算
	 **/
	public String getTaskClass() {
		return this.taskClass;
	}
	/**
	 * 是否发布到任务大厅0否1是
	 **/
	public String getToTaskCenter() {
		return this.toTaskCenter;
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
	 * 项目阶段编号
	 **/
	public String getProjectPhaseId() {
		return this.projectPhaseId;
	}
	/**
	 * 项目阶段名称
	 **/
	public String getProjectPhaseName() {
		return this.projectPhaseName;
	}
	/**
	 * 技能列表,逗号分隔
	 **/
	public String getTaskSkillNames() {
		return this.taskSkillNames;
	}
	/**
	 * 执行人列表逗号分隔如陈x(审核人),王x(监控人)
	 **/
	public String getExeUsernames() {
		return this.exeUsernames;
	}
	/**
	 * 技能编号列表逗号分隔
	 **/
	public String getTaskSkillIds() {
		return this.taskSkillIds;
	}
	/**
	 * 执行人编号列表逗号分隔如u1(1),u2(2)
	 **/
	public String getExeUserids() {
		return this.exeUserids;
	}
	/**
	 * 是否外购
	 **/
	public String getTaskOut() {
		return this.taskOut;
	}
	/**
	 * 计划类型w1-周,w2-2周,w3-3周,m1-1月,m2-2月,q1-季,q2-半年，y1-年
	 **/
	public String getPlanType() {
		return this.planType;
	}
	/**
	 * 任务结算方案-来自数字字典xmTaskSettleSchemel
	 **/
	public String getSettleSchemel() {
		return this.settleSchemel;
	}
	/**
	 * 归属功能编号
	 **/
	public String getMenuId() {
		return this.menuId;
	}
	/**
	 * 归属功能名称
	 **/
	public String getMenuName() {
		return this.menuName;
	}
	/**
	 * 迭代编号
	 **/
	public String getIterationId() {
		return this.iterationId;
	}
	/**
	 * 迭代名称
	 **/
	public String getIterationName() {
		return this.iterationName;
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

}