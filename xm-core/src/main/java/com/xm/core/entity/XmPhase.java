package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmPhase所有属性名: <br>
 *	id,name,remark,parentId,branchId,projectId,beginDate,endDate,budgetHours,budgetStaffNu,ctime,budgetNouserAt,budgetIuserAt,budgetOuserAt,baselineId,bizProcInstId,bizFlowState,budgetWorkload,actWorkload,actIuserWorkload,actOuserWorkload,taskType,planType,seqNo,udgetIuserWorkload,budgetOuserWorkload,actNouserAt,actIuserAt,budgetIuserPrice,budgetOuserPrice,budgetOuserCnt,budgetIuserCnt,actRate,pstatus,actOutUserAt,taskCnt,finishTaskCnt,iterationCnt,calcTime,taskBudgetWorkload,taskBudgetAt,mngUserid,mngUsername,milestone,pleaf,tagIds,tagNames,ntype,childrenCnt,ltime,isKeyPath,pidPaths,lvl,isTpl,phaseClass,productId,budgetAt,calcType,actAt;<br>
 * 表 xm_phase 项目、产品计划表（将计划并入任务表，暂时作废），合并进任务表了的所有字段名: <br>
 *	id,name,remark,parent_id,branch_id,project_id,begin_date,end_date,budget_hours,budget_staff_nu,ctime,budget_nouser_at,budget_iuser_at,budget_ouser_at,baseline_id,biz_proc_inst_id,biz_flow_state,budget_workload,act_workload,act_iuser_workload,act_ouser_workload,task_type,plan_type,seq_no,udget_iuser_workload,budget_ouser_workload,act_nouser_at,act_iuser_at,budget_iuser_price,budget_ouser_price,budget_ouser_cnt,budget_iuser_cnt,act_rate,pstatus,act_out_user_at,task_cnt,finish_task_cnt,iteration_cnt,calc_time,task_budget_workload,task_budget_at,mng_userid,mng_username,milestone,pleaf,tag_ids,tag_names,ntype,children_cnt,ltime,is_key_path,pid_paths,lvl,is_tpl,phase_class,product_id,budget_at,calc_type,act_at;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="项目、产品计划表（将计划并入任务表，暂时作废），合并进任务表了")
public class XmPhase  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="阶段主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="阶段名称",allowEmptyValue=true,example="",allowableValues="")
	String name;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="上级阶段编号",allowEmptyValue=true,example="",allowableValues="")
	String parentId;
	
	@ApiModelProperty(notes="机构编号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="当前项目编号，如果是项目计划，必填项目",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date beginDate;
	
	@ApiModelProperty(notes="结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date endDate;
	
	@ApiModelProperty(notes="工时(上到下控制大于儿子总数)-应该大于或等于task中总工时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetHours;
	
	@ApiModelProperty(notes="投入人员数(上到下控制大于儿子总数)-应该大于或等于task中总人数",allowEmptyValue=true,example="",allowableValues="")
	Integer budgetStaffNu;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="非人力成本总预算(上到下控制大于儿子总数)-应该大于或等于task中非人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetNouserAt;
	
	@ApiModelProperty(notes="内部人力成本总预算(上到下控制大于儿子总数)-应该大于或等于task中内部人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetIuserAt;
	
	@ApiModelProperty(notes="外购人力成本总预算(上到下控制大于儿子总数)-应该大于或等于task中外购总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetOuserAt;
	
	@ApiModelProperty(notes="项目级基线",allowEmptyValue=true,example="",allowableValues="")
	String baselineId;
	
	@ApiModelProperty(notes="当前流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String bizProcInstId;
	
	@ApiModelProperty(notes="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;
	
	@ApiModelProperty(notes="总工作量单位人时上到下控制大于儿子总数-应该大于或者等于task中的预算总工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetWorkload;
	
	@ApiModelProperty(notes="已完成工作量单位人时-从task中的实际工作量算出",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actWorkload;
	
	@ApiModelProperty(notes="实际内部人力工作量-来自任务表合计",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actIuserWorkload;
	
	@ApiModelProperty(notes="实际外购人力工作量-来自任务表合计",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actOuserWorkload;
	
	@ApiModelProperty(notes="0售前方案1投标2需求3设计4开发5测试6验收7部署8运维--来自基础数据表taskType",allowEmptyValue=true,example="",allowableValues="")
	String taskType;
	
	@ApiModelProperty(notes="计划类型w1-周,w2-2周,w3-3周,m1-1月,m2-2月,q1-季,q2-半年，y1-年",allowEmptyValue=true,example="",allowableValues="")
	String planType;
	
	@ApiModelProperty(notes="顺序号",allowEmptyValue=true,example="",allowableValues="")
	String seqNo;
	
	@ApiModelProperty(notes="内部人力工作量总预算(上到下控制大于儿子总数)-应该大于或等于task中内部人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal udgetIuserWorkload;
	
	@ApiModelProperty(notes="外购人力工作量总预算(上到下控制大于儿子总数)-应该大于或等于task中外购总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetOuserWorkload;
	
	@ApiModelProperty(notes="实际非人力成本-来自任务表合计",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actNouserAt;
	
	@ApiModelProperty(notes="实际内部人力成本-来自任务表合计",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actIuserAt;
	
	@ApiModelProperty(notes="内部人力成本单价元/人时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetIuserPrice;
	
	@ApiModelProperty(notes="外购人力成本单价元/人时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetOuserPrice;
	
	@ApiModelProperty(notes="外购人数",allowEmptyValue=true,example="",allowableValues="")
	Integer budgetOuserCnt;
	
	@ApiModelProperty(notes="内部人数",allowEmptyValue=true,example="",allowableValues="")
	Integer budgetIuserCnt;
	
	@ApiModelProperty(notes="实际进度0-100",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actRate;
	
	@ApiModelProperty(notes="阶段状态0初始1执行中2完工3关闭4删除中5已删除6暂停",allowEmptyValue=true,example="",allowableValues="")
	String pstatus;
	
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
	
	@ApiModelProperty(notes="管理者编号",allowEmptyValue=true,example="",allowableValues="")
	String mngUserid;
	
	@ApiModelProperty(notes="管理者姓名",allowEmptyValue=true,example="",allowableValues="")
	String mngUsername;
	
	@ApiModelProperty(notes="是否里程碑0否1是",allowEmptyValue=true,example="",allowableValues="")
	String milestone;
	
	@ApiModelProperty(notes="节点是否为叶子节点",allowEmptyValue=true,example="",allowableValues="")
	String pleaf;
	
	@ApiModelProperty(notes="标签编号，逗号分割",allowEmptyValue=true,example="",allowableValues="")
	String tagIds;
	
	@ApiModelProperty(notes="标签名称，逗号分割",allowEmptyValue=true,example="",allowableValues="")
	String tagNames;
	
	@ApiModelProperty(notes="节点类型0-任务，1-任务集。任务集下建任务，任务下不允许建立任何子节点",allowEmptyValue=true,example="",allowableValues="")
	String ntype;
	
	@ApiModelProperty(notes="儿子节点个数",allowEmptyValue=true,example="",allowableValues="")
	Integer childrenCnt;
	
	@ApiModelProperty(notes="更新时间",allowEmptyValue=true,example="",allowableValues="")
	Date ltime;
	
	@ApiModelProperty(notes="是否为关键路径上的节点",allowEmptyValue=true,example="",allowableValues="")
	String isKeyPath;
	
	@ApiModelProperty(notes="父级id逗号分割，最后一个为本节点节点编号,以,号结尾",allowEmptyValue=true,example="",allowableValues="")
	String pidPaths;
	
	@ApiModelProperty(notes="层级0-顶级，1-一级，2-二级，3-三级，4-四级。总共5级",allowEmptyValue=true,example="",allowableValues="")
	Integer lvl;
	
	@ApiModelProperty(notes="是否为模板",allowEmptyValue=true,example="",allowableValues="")
	String isTpl;
	
	@ApiModelProperty(notes="计划分类0项目1产品",allowEmptyValue=true,example="",allowableValues="")
	String phaseClass;
	
	@ApiModelProperty(notes="如果是产品计划，必填产品编号，其它的可不填",allowEmptyValue=true,example="",allowableValues="")
	String productId;
	
	@ApiModelProperty(notes="预算金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetAt;
	
	@ApiModelProperty(notes="叶子节点数据收集方式0-不计算，1-由任务汇总，2-手工填报",allowEmptyValue=true,example="",allowableValues="")
	String calcType;
	
	@ApiModelProperty(notes="实际金额，如手工填写，则为填写金额，否则为汇总金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actAt;

	/**阶段主键**/
	public XmPhase(String id) {
		this.id = id;
	}
    
    /**项目、产品计划表（将计划并入任务表，暂时作废），合并进任务表了**/
	public XmPhase() {
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
	public void setName(String name) {
		this.name = name;
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
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * 机构编号
	 **/
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	/**
	 * 当前项目编号，如果是项目计划，必填项目
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
	 * 工时(上到下控制大于儿子总数)-应该大于或等于task中总工时
	 **/
	public void setBudgetHours(BigDecimal budgetHours) {
		this.budgetHours = budgetHours;
	}
	/**
	 * 投入人员数(上到下控制大于儿子总数)-应该大于或等于task中总人数
	 **/
	public void setBudgetStaffNu(Integer budgetStaffNu) {
		this.budgetStaffNu = budgetStaffNu;
	}
	/**
	 * 创建时间
	 **/
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	/**
	 * 非人力成本总预算(上到下控制大于儿子总数)-应该大于或等于task中非人力总成本
	 **/
	public void setBudgetNouserAt(BigDecimal budgetNouserAt) {
		this.budgetNouserAt = budgetNouserAt;
	}
	/**
	 * 内部人力成本总预算(上到下控制大于儿子总数)-应该大于或等于task中内部人力总成本
	 **/
	public void setBudgetIuserAt(BigDecimal budgetIuserAt) {
		this.budgetIuserAt = budgetIuserAt;
	}
	/**
	 * 外购人力成本总预算(上到下控制大于儿子总数)-应该大于或等于task中外购总成本
	 **/
	public void setBudgetOuserAt(BigDecimal budgetOuserAt) {
		this.budgetOuserAt = budgetOuserAt;
	}
	/**
	 * 项目级基线
	 **/
	public void setBaselineId(String baselineId) {
		this.baselineId = baselineId;
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
	 * 总工作量单位人时上到下控制大于儿子总数-应该大于或者等于task中的预算总工作量
	 **/
	public void setBudgetWorkload(BigDecimal budgetWorkload) {
		this.budgetWorkload = budgetWorkload;
	}
	/**
	 * 已完成工作量单位人时-从task中的实际工作量算出
	 **/
	public void setActWorkload(BigDecimal actWorkload) {
		this.actWorkload = actWorkload;
	}
	/**
	 * 实际内部人力工作量-来自任务表合计
	 **/
	public void setActIuserWorkload(BigDecimal actIuserWorkload) {
		this.actIuserWorkload = actIuserWorkload;
	}
	/**
	 * 实际外购人力工作量-来自任务表合计
	 **/
	public void setActOuserWorkload(BigDecimal actOuserWorkload) {
		this.actOuserWorkload = actOuserWorkload;
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
	 * 内部人力工作量总预算(上到下控制大于儿子总数)-应该大于或等于task中内部人力总成本
	 **/
	public void setUdgetIuserWorkload(BigDecimal udgetIuserWorkload) {
		this.udgetIuserWorkload = udgetIuserWorkload;
	}
	/**
	 * 外购人力工作量总预算(上到下控制大于儿子总数)-应该大于或等于task中外购总成本
	 **/
	public void setBudgetOuserWorkload(BigDecimal budgetOuserWorkload) {
		this.budgetOuserWorkload = budgetOuserWorkload;
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
	public void setActIuserAt(BigDecimal actIuserAt) {
		this.actIuserAt = actIuserAt;
	}
	/**
	 * 内部人力成本单价元/人时
	 **/
	public void setBudgetIuserPrice(BigDecimal budgetIuserPrice) {
		this.budgetIuserPrice = budgetIuserPrice;
	}
	/**
	 * 外购人力成本单价元/人时
	 **/
	public void setBudgetOuserPrice(BigDecimal budgetOuserPrice) {
		this.budgetOuserPrice = budgetOuserPrice;
	}
	/**
	 * 外购人数
	 **/
	public void setBudgetOuserCnt(Integer budgetOuserCnt) {
		this.budgetOuserCnt = budgetOuserCnt;
	}
	/**
	 * 内部人数
	 **/
	public void setBudgetIuserCnt(Integer budgetIuserCnt) {
		this.budgetIuserCnt = budgetIuserCnt;
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
	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
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
	 * 管理者编号
	 **/
	public void setMngUserid(String mngUserid) {
		this.mngUserid = mngUserid;
	}
	/**
	 * 管理者姓名
	 **/
	public void setMngUsername(String mngUsername) {
		this.mngUsername = mngUsername;
	}
	/**
	 * 是否里程碑0否1是
	 **/
	public void setMilestone(String milestone) {
		this.milestone = milestone;
	}
	/**
	 * 节点是否为叶子节点
	 **/
	public void setPleaf(String pleaf) {
		this.pleaf = pleaf;
	}
	/**
	 * 标签编号，逗号分割
	 **/
	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}
	/**
	 * 标签名称，逗号分割
	 **/
	public void setTagNames(String tagNames) {
		this.tagNames = tagNames;
	}
	/**
	 * 节点类型0-任务，1-任务集。任务集下建任务，任务下不允许建立任何子节点
	 **/
	public void setNtype(String ntype) {
		this.ntype = ntype;
	}
	/**
	 * 儿子节点个数
	 **/
	public void setChildrenCnt(Integer childrenCnt) {
		this.childrenCnt = childrenCnt;
	}
	/**
	 * 更新时间
	 **/
	public void setLtime(Date ltime) {
		this.ltime = ltime;
	}
	/**
	 * 是否为关键路径上的节点
	 **/
	public void setIsKeyPath(String isKeyPath) {
		this.isKeyPath = isKeyPath;
	}
	/**
	 * 父级id逗号分割，最后一个为本节点节点编号,以,号结尾
	 **/
	public void setPidPaths(String pidPaths) {
		this.pidPaths = pidPaths;
	}
	/**
	 * 层级0-顶级，1-一级，2-二级，3-三级，4-四级。总共5级
	 **/
	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}
	/**
	 * 是否为模板
	 **/
	public void setIsTpl(String isTpl) {
		this.isTpl = isTpl;
	}
	/**
	 * 计划分类0项目1产品
	 **/
	public void setPhaseClass(String phaseClass) {
		this.phaseClass = phaseClass;
	}
	/**
	 * 如果是产品计划，必填产品编号，其它的可不填
	 **/
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * 预算金额
	 **/
	public void setBudgetAt(BigDecimal budgetAt) {
		this.budgetAt = budgetAt;
	}
	/**
	 * 叶子节点数据收集方式0-不计算，1-由任务汇总，2-手工填报
	 **/
	public void setCalcType(String calcType) {
		this.calcType = calcType;
	}
	/**
	 * 实际金额，如手工填写，则为填写金额，否则为汇总金额
	 **/
	public void setActAt(BigDecimal actAt) {
		this.actAt = actAt;
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
	public String getName() {
		return this.name;
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
	public String getParentId() {
		return this.parentId;
	}
	/**
	 * 机构编号
	 **/
	public String getBranchId() {
		return this.branchId;
	}
	/**
	 * 当前项目编号，如果是项目计划，必填项目
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
	 * 工时(上到下控制大于儿子总数)-应该大于或等于task中总工时
	 **/
	public BigDecimal getBudgetHours() {
		return this.budgetHours;
	}
	/**
	 * 投入人员数(上到下控制大于儿子总数)-应该大于或等于task中总人数
	 **/
	public Integer getBudgetStaffNu() {
		return this.budgetStaffNu;
	}
	/**
	 * 创建时间
	 **/
	public Date getCtime() {
		return this.ctime;
	}
	/**
	 * 非人力成本总预算(上到下控制大于儿子总数)-应该大于或等于task中非人力总成本
	 **/
	public BigDecimal getBudgetNouserAt() {
		return this.budgetNouserAt;
	}
	/**
	 * 内部人力成本总预算(上到下控制大于儿子总数)-应该大于或等于task中内部人力总成本
	 **/
	public BigDecimal getBudgetIuserAt() {
		return this.budgetIuserAt;
	}
	/**
	 * 外购人力成本总预算(上到下控制大于儿子总数)-应该大于或等于task中外购总成本
	 **/
	public BigDecimal getBudgetOuserAt() {
		return this.budgetOuserAt;
	}
	/**
	 * 项目级基线
	 **/
	public String getBaselineId() {
		return this.baselineId;
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
	 * 总工作量单位人时上到下控制大于儿子总数-应该大于或者等于task中的预算总工作量
	 **/
	public BigDecimal getBudgetWorkload() {
		return this.budgetWorkload;
	}
	/**
	 * 已完成工作量单位人时-从task中的实际工作量算出
	 **/
	public BigDecimal getActWorkload() {
		return this.actWorkload;
	}
	/**
	 * 实际内部人力工作量-来自任务表合计
	 **/
	public BigDecimal getActIuserWorkload() {
		return this.actIuserWorkload;
	}
	/**
	 * 实际外购人力工作量-来自任务表合计
	 **/
	public BigDecimal getActOuserWorkload() {
		return this.actOuserWorkload;
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
	 * 内部人力工作量总预算(上到下控制大于儿子总数)-应该大于或等于task中内部人力总成本
	 **/
	public BigDecimal getUdgetIuserWorkload() {
		return this.udgetIuserWorkload;
	}
	/**
	 * 外购人力工作量总预算(上到下控制大于儿子总数)-应该大于或等于task中外购总成本
	 **/
	public BigDecimal getBudgetOuserWorkload() {
		return this.budgetOuserWorkload;
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
	public BigDecimal getActIuserAt() {
		return this.actIuserAt;
	}
	/**
	 * 内部人力成本单价元/人时
	 **/
	public BigDecimal getBudgetIuserPrice() {
		return this.budgetIuserPrice;
	}
	/**
	 * 外购人力成本单价元/人时
	 **/
	public BigDecimal getBudgetOuserPrice() {
		return this.budgetOuserPrice;
	}
	/**
	 * 外购人数
	 **/
	public Integer getBudgetOuserCnt() {
		return this.budgetOuserCnt;
	}
	/**
	 * 内部人数
	 **/
	public Integer getBudgetIuserCnt() {
		return this.budgetIuserCnt;
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
	public String getPstatus() {
		return this.pstatus;
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
	/**
	 * 管理者编号
	 **/
	public String getMngUserid() {
		return this.mngUserid;
	}
	/**
	 * 管理者姓名
	 **/
	public String getMngUsername() {
		return this.mngUsername;
	}
	/**
	 * 是否里程碑0否1是
	 **/
	public String getMilestone() {
		return this.milestone;
	}
	/**
	 * 节点是否为叶子节点
	 **/
	public String getPleaf() {
		return this.pleaf;
	}
	/**
	 * 标签编号，逗号分割
	 **/
	public String getTagIds() {
		return this.tagIds;
	}
	/**
	 * 标签名称，逗号分割
	 **/
	public String getTagNames() {
		return this.tagNames;
	}
	/**
	 * 节点类型0-任务，1-任务集。任务集下建任务，任务下不允许建立任何子节点
	 **/
	public String getNtype() {
		return this.ntype;
	}
	/**
	 * 儿子节点个数
	 **/
	public Integer getChildrenCnt() {
		return this.childrenCnt;
	}
	/**
	 * 更新时间
	 **/
	public Date getLtime() {
		return this.ltime;
	}
	/**
	 * 是否为关键路径上的节点
	 **/
	public String getIsKeyPath() {
		return this.isKeyPath;
	}
	/**
	 * 父级id逗号分割，最后一个为本节点节点编号,以,号结尾
	 **/
	public String getPidPaths() {
		return this.pidPaths;
	}
	/**
	 * 层级0-顶级，1-一级，2-二级，3-三级，4-四级。总共5级
	 **/
	public Integer getLvl() {
		return this.lvl;
	}
	/**
	 * 是否为模板
	 **/
	public String getIsTpl() {
		return this.isTpl;
	}
	/**
	 * 计划分类0项目1产品
	 **/
	public String getPhaseClass() {
		return this.phaseClass;
	}
	/**
	 * 如果是产品计划，必填产品编号，其它的可不填
	 **/
	public String getProductId() {
		return this.productId;
	}
	/**
	 * 预算金额
	 **/
	public BigDecimal getBudgetAt() {
		return this.budgetAt;
	}
	/**
	 * 叶子节点数据收集方式0-不计算，1-由任务汇总，2-手工填报
	 **/
	public String getCalcType() {
		return this.calcType;
	}
	/**
	 * 实际金额，如手工填写，则为填写金额，否则为汇总金额
	 **/
	public BigDecimal getActAt() {
		return this.actAt;
	}

}