package  com.qqkj.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com.qqkj  顶级模块 oa 大模块 xm  小模块 <br> 
 * 实体 XmTaskTemplate所有属性名: <br>
 *	id,name,parentTaskid,parentTaskname,projectId,projectName,level,sortLevel,preTaskid,preTaskname,startTime,endTime,milestone,description,remarks,createUserid,createUsername,createTime,rate,budgetCost,budgetWorkload,taskState,taskType,taskClass,toTaskCenter,projectPhaseId,projectPhaseName,taskSkillNames,taskSkillIds,taskOut,planType,settleSchemel,menuId,menuName;<br>
 * 表 XM.xm_task_template xm_task_template的所有字段名: <br>
 *	id,name,parent_taskid,parent_taskname,project_id,project_name,level,sort_level,pre_taskid,pre_taskname,start_time,end_time,milestone,description,remarks,create_userid,create_username,create_time,rate,budget_cost,budget_workload,task_state,task_type,task_class,to_task_center,project_phase_id,project_phase_name,task_skill_names,task_skill_ids,task_out,plan_type,settle_schemel,menu_id,menu_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_task_template")
public class XmTaskTemplate  implements java.io.Serializable {
	
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
	
	@ApiModelProperty(notes="任务状态0待领取1已领取执行中2已完工3已结算",allowEmptyValue=true,example="",allowableValues="")
	String taskState;
	
	@ApiModelProperty(notes="0售前方案1投标2需求3设计4开发5测试6验收7部署8运维--来自基础数据表taskType",allowEmptyValue=true,example="",allowableValues="")
	String taskType;
	
	@ApiModelProperty(notes="1需结算0不需结算",allowEmptyValue=true,example="",allowableValues="")
	String taskClass;
	
	@ApiModelProperty(notes="是否发布到任务大厅0否1是",allowEmptyValue=true,example="",allowableValues="")
	String toTaskCenter;
	
	@ApiModelProperty(notes="项目阶段编号",allowEmptyValue=true,example="",allowableValues="")
	String projectPhaseId;
	
	@ApiModelProperty(notes="项目阶段名称",allowEmptyValue=true,example="",allowableValues="")
	String projectPhaseName;
	
	@ApiModelProperty(notes="技能列表,逗号分隔",allowEmptyValue=true,example="",allowableValues="")
	String taskSkillNames;
	
	@ApiModelProperty(notes="技能编号列表逗号分隔",allowEmptyValue=true,example="",allowableValues="")
	String taskSkillIds;
	
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

	/**任务编号**/
	public XmTaskTemplate(String id) {
		this.id = id;
	}
    
    /**xm_task_template**/
	public XmTaskTemplate() {
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
	 * 技能编号列表逗号分隔
	 **/
	public void setTaskSkillIds(String taskSkillIds) {
		this.taskSkillIds = taskSkillIds;
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
	 * 技能编号列表逗号分隔
	 **/
	public String getTaskSkillIds() {
		return this.taskSkillIds;
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

}