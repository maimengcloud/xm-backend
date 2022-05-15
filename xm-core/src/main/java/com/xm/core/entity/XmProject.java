package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmProject所有属性名: <br>
 *	id,code,name,xmType,startTime,endTime,urgent,priority,description,createUserid,createUsername,createTime,assess,assessRemarks,status,branchId,planTotalCost,bizProcInstId,bizFlowState,planNouserAt,planIuserAt,planOuserAt,locked,baseTime,baseRemark,baselineId,planWorkload,totalReceivables,budgetMarginRate,contractAmt,planIuserPrice,planOuserPrice,planOuserCnt,planIuserCnt,planWorkingHours,taxRate,planIuserWorkload,planOuserWorkload,fromTplId,budgetCtrl,deptid,showOut,isTpl,pmUserid,pmUsername,assUserid,assUsername,admUserid,admUsername,budgetEarly,phaseActCtrl,del,ltime,ostatus,workType,wtype,earlyAmt;<br>
 * 表 xm_project xm_project的所有字段名: <br>
 *	id,code,name,xm_type,start_time,end_time,urgent,priority,description,create_userid,create_username,create_time,assess,assess_remarks,status,branch_id,plan_total_cost,biz_proc_inst_id,biz_flow_state,plan_nouser_at,plan_iuser_at,plan_ouser_at,locked,base_time,base_remark,baseline_id,plan_workload,total_receivables,budget_margin_rate,contract_amt,plan_iuser_price,plan_ouser_price,plan_ouser_cnt,plan_iuser_cnt,plan_working_hours,tax_rate,plan_iuser_workload,plan_ouser_workload,from_tpl_id,budget_ctrl,deptid,show_out,is_tpl,pm_userid,pm_username,ass_userid,ass_username,adm_userid,adm_username,budget_early,phase_act_ctrl,del,ltime,ostatus,work_type,wtype,early_amt;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_project")
public class XmProject  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="项目编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="项目代号",allowEmptyValue=true,example="",allowableValues="")
	String code;
	
	@ApiModelProperty(notes="项目名称",allowEmptyValue=true,example="",allowableValues="")
	String name;
	
	@ApiModelProperty(notes="项目类型",allowEmptyValue=true,example="",allowableValues="")
	String xmType;
	
	@ApiModelProperty(notes="项目开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date startTime;
	
	@ApiModelProperty(notes="项目结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date endTime;
	
	@ApiModelProperty(notes="紧急程度",allowEmptyValue=true,example="",allowableValues="")
	String urgent;
	
	@ApiModelProperty(notes="优先程度",allowEmptyValue=true,example="",allowableValues="")
	String priority;
	
	@ApiModelProperty(notes="项目描述",allowEmptyValue=true,example="",allowableValues="")
	String description;
	
	@ApiModelProperty(notes="项目创建人编号",allowEmptyValue=true,example="",allowableValues="")
	String createUserid;
	
	@ApiModelProperty(notes="项目创建人",allowEmptyValue=true,example="",allowableValues="")
	String createUsername;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date createTime;
	
	@ApiModelProperty(notes="项目考核",allowEmptyValue=true,example="",allowableValues="")
	String assess;
	
	@ApiModelProperty(notes="考核备注",allowEmptyValue=true,example="",allowableValues="")
	String assessRemarks;
	
	@ApiModelProperty(notes="0|初始1|售前2|立项中3|实施中4|暂停中5|结项中6|已结项7|售后8|已完成9|已关闭",allowEmptyValue=true,example="",allowableValues="")
	String status;
	
	@ApiModelProperty(notes="机构编号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="总预算",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planTotalCost;
	
	@ApiModelProperty(notes="当前流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String bizProcInstId;
	
	@ApiModelProperty(notes="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;
	
	@ApiModelProperty(notes="非人力成本总预算-应该大于或等于阶段计划非人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planNouserAt;
	
	@ApiModelProperty(notes="内部人力成本总预算-应该大于或等于阶段计划内部人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planIuserAt;
	
	@ApiModelProperty(notes="外购人力成本总预算-应该大于或等于阶段计划外购人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planOuserAt;
	
	@ApiModelProperty(notes="是否锁定整个项目不允许变化0否1是",allowEmptyValue=true,example="",allowableValues="")
	String locked;
	
	@ApiModelProperty(notes="基线时间",allowEmptyValue=true,example="",allowableValues="")
	Date baseTime;
	
	@ApiModelProperty(notes="基线备注",allowEmptyValue=true,example="",allowableValues="")
	String baseRemark;
	
	@ApiModelProperty(notes="基线主键",allowEmptyValue=true,example="",allowableValues="")
	String baselineId;
	
	@ApiModelProperty(notes="总预算工作量-应该大于或等于阶段计划总工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planWorkload;
	
	@ApiModelProperty(notes="总预计收款金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalReceivables;
	
	@ApiModelProperty(notes="预估毛利率",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetMarginRate;
	
	@ApiModelProperty(notes="合同总金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal contractAmt;
	
	@ApiModelProperty(notes="内部人力成本单价元/人时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planIuserPrice;
	
	@ApiModelProperty(notes="外购人力成本单价元/人时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planOuserPrice;
	
	@ApiModelProperty(notes="外购人数",allowEmptyValue=true,example="",allowableValues="")
	Integer planOuserCnt;
	
	@ApiModelProperty(notes="内部人数",allowEmptyValue=true,example="",allowableValues="")
	Integer planIuserCnt;
	
	@ApiModelProperty(notes="预计工作小时数目",allowEmptyValue=true,example="",allowableValues="")
	Integer planWorkingHours;
	
	@ApiModelProperty(notes="税率0-100之间",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal taxRate;
	
	@ApiModelProperty(notes="内部人力总工作量-应该大于或等于阶段计划内部人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planIuserWorkload;
	
	@ApiModelProperty(notes="外购人力总工作量-应该大于或等于阶段计划外购人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planOuserWorkload;
	
	@ApiModelProperty(notes="关联模板编号",allowEmptyValue=true,example="",allowableValues="")
	String fromTplId;
	
	@ApiModelProperty(notes="是否进行预算控制，计划中一级计划总预算大于项目预算则拒绝添加计划,一般用于瀑布型项目",allowEmptyValue=true,example="",allowableValues="")
	String budgetCtrl;
	
	@ApiModelProperty(notes="部门编号",allowEmptyValue=true,example="",allowableValues="")
	String deptid;
	
	@ApiModelProperty(notes="是否对外公开0-完全不可见，1-仅本司人员可见，2-关联人员可见（众包-外包-招投标）",allowEmptyValue=true,example="",allowableValues="")
	String showOut;
	
	@ApiModelProperty(notes="是否为模板",allowEmptyValue=true,example="",allowableValues="")
	String isTpl;
	
	@ApiModelProperty(notes="项目经理编号",allowEmptyValue=true,example="",allowableValues="")
	String pmUserid;
	
	@ApiModelProperty(notes="项目经理名称",allowEmptyValue=true,example="",allowableValues="")
	String pmUsername;
	
	@ApiModelProperty(notes="助理、副经理编号",allowEmptyValue=true,example="",allowableValues="")
	String assUserid;
	
	@ApiModelProperty(notes="助理、副经理姓名",allowEmptyValue=true,example="",allowableValues="")
	String assUsername;
	
	@ApiModelProperty(notes="主管领导编号",allowEmptyValue=true,example="",allowableValues="")
	String admUserid;
	
	@ApiModelProperty(notes="主管领导姓名",allowEmptyValue=true,example="",allowableValues="")
	String admUsername;
	
	@ApiModelProperty(notes="是否进行计划预算预警，计划预算超出项目预算既定额度进行预警",allowEmptyValue=true,example="",allowableValues="")
	String budgetEarly;
	
	@ApiModelProperty(notes="计划是否进行实际金额控制，实际金额不能大于预算金额（大于预算金额不得结算）",allowEmptyValue=true,example="",allowableValues="")
	String phaseActCtrl;
	
	@ApiModelProperty(notes="是否已删除0否1是",allowEmptyValue=true,example="",allowableValues="")
	String del;
	
	@ApiModelProperty(notes="最后更新时间",allowEmptyValue=true,example="",allowableValues="")
	Date ltime;
	
	@ApiModelProperty(notes="原状态，暂停时记录原状态，暂停恢复后把原状态恢复",allowEmptyValue=true,example="",allowableValues="")
	String ostatus;
	
	@ApiModelProperty(notes="工作方式scrum、kanban",allowEmptyValue=true,example="",allowableValues="")
	String workType;
	
	@ApiModelProperty(notes="报工方式0-无须报工，1-每日报工，2-工期内报工",allowEmptyValue=true,example="",allowableValues="")
	String wtype;
	
	@ApiModelProperty(notes="超出预算金额多少金额进行预警，正数代表超出的额度，负数代表距离预算的额度",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal earlyAmt;

	/**项目编号**/
	public XmProject(String id) {
		this.id = id;
	}
    
    /**xm_project**/
	public XmProject() {
	}
	
	/**
	 * 项目编号
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 项目代号
	 **/
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 项目名称
	 **/
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 项目类型
	 **/
	public void setXmType(String xmType) {
		this.xmType = xmType;
	}
	/**
	 * 项目开始时间
	 **/
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 项目结束时间
	 **/
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 紧急程度
	 **/
	public void setUrgent(String urgent) {
		this.urgent = urgent;
	}
	/**
	 * 优先程度
	 **/
	public void setPriority(String priority) {
		this.priority = priority;
	}
	/**
	 * 项目描述
	 **/
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 项目创建人编号
	 **/
	public void setCreateUserid(String createUserid) {
		this.createUserid = createUserid;
	}
	/**
	 * 项目创建人
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
	 * 项目考核
	 **/
	public void setAssess(String assess) {
		this.assess = assess;
	}
	/**
	 * 考核备注
	 **/
	public void setAssessRemarks(String assessRemarks) {
		this.assessRemarks = assessRemarks;
	}
	/**
	 * 0|初始1|售前2|立项中3|实施中4|暂停中5|结项中6|已结项7|售后8|已完成9|已关闭
	 **/
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 机构编号
	 **/
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	/**
	 * 总预算
	 **/
	public void setPlanTotalCost(BigDecimal planTotalCost) {
		this.planTotalCost = planTotalCost;
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
	 * 非人力成本总预算-应该大于或等于阶段计划非人力总成本
	 **/
	public void setPlanNouserAt(BigDecimal planNouserAt) {
		this.planNouserAt = planNouserAt;
	}
	/**
	 * 内部人力成本总预算-应该大于或等于阶段计划内部人力总成本
	 **/
	public void setPlanIuserAt(BigDecimal planIuserAt) {
		this.planIuserAt = planIuserAt;
	}
	/**
	 * 外购人力成本总预算-应该大于或等于阶段计划外购人力总成本
	 **/
	public void setPlanOuserAt(BigDecimal planOuserAt) {
		this.planOuserAt = planOuserAt;
	}
	/**
	 * 是否锁定整个项目不允许变化0否1是
	 **/
	public void setLocked(String locked) {
		this.locked = locked;
	}
	/**
	 * 基线时间
	 **/
	public void setBaseTime(Date baseTime) {
		this.baseTime = baseTime;
	}
	/**
	 * 基线备注
	 **/
	public void setBaseRemark(String baseRemark) {
		this.baseRemark = baseRemark;
	}
	/**
	 * 基线主键
	 **/
	public void setBaselineId(String baselineId) {
		this.baselineId = baselineId;
	}
	/**
	 * 总预算工作量-应该大于或等于阶段计划总工作量
	 **/
	public void setPlanWorkload(BigDecimal planWorkload) {
		this.planWorkload = planWorkload;
	}
	/**
	 * 总预计收款金额
	 **/
	public void setTotalReceivables(BigDecimal totalReceivables) {
		this.totalReceivables = totalReceivables;
	}
	/**
	 * 预估毛利率
	 **/
	public void setBudgetMarginRate(BigDecimal budgetMarginRate) {
		this.budgetMarginRate = budgetMarginRate;
	}
	/**
	 * 合同总金额
	 **/
	public void setContractAmt(BigDecimal contractAmt) {
		this.contractAmt = contractAmt;
	}
	/**
	 * 内部人力成本单价元/人时
	 **/
	public void setPlanIuserPrice(BigDecimal planIuserPrice) {
		this.planIuserPrice = planIuserPrice;
	}
	/**
	 * 外购人力成本单价元/人时
	 **/
	public void setPlanOuserPrice(BigDecimal planOuserPrice) {
		this.planOuserPrice = planOuserPrice;
	}
	/**
	 * 外购人数
	 **/
	public void setPlanOuserCnt(Integer planOuserCnt) {
		this.planOuserCnt = planOuserCnt;
	}
	/**
	 * 内部人数
	 **/
	public void setPlanIuserCnt(Integer planIuserCnt) {
		this.planIuserCnt = planIuserCnt;
	}
	/**
	 * 预计工作小时数目
	 **/
	public void setPlanWorkingHours(Integer planWorkingHours) {
		this.planWorkingHours = planWorkingHours;
	}
	/**
	 * 税率0-100之间
	 **/
	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}
	/**
	 * 内部人力总工作量-应该大于或等于阶段计划内部人力总成本
	 **/
	public void setPlanIuserWorkload(BigDecimal planIuserWorkload) {
		this.planIuserWorkload = planIuserWorkload;
	}
	/**
	 * 外购人力总工作量-应该大于或等于阶段计划外购人力总成本
	 **/
	public void setPlanOuserWorkload(BigDecimal planOuserWorkload) {
		this.planOuserWorkload = planOuserWorkload;
	}
	/**
	 * 关联模板编号
	 **/
	public void setFromTplId(String fromTplId) {
		this.fromTplId = fromTplId;
	}
	/**
	 * 是否进行预算控制，计划中一级计划总预算大于项目预算则拒绝添加计划,一般用于瀑布型项目
	 **/
	public void setBudgetCtrl(String budgetCtrl) {
		this.budgetCtrl = budgetCtrl;
	}
	/**
	 * 部门编号
	 **/
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	/**
	 * 是否对外公开0-完全不可见，1-仅本司人员可见，2-关联人员可见（众包-外包-招投标）
	 **/
	public void setShowOut(String showOut) {
		this.showOut = showOut;
	}
	/**
	 * 是否为模板
	 **/
	public void setIsTpl(String isTpl) {
		this.isTpl = isTpl;
	}
	/**
	 * 项目经理编号
	 **/
	public void setPmUserid(String pmUserid) {
		this.pmUserid = pmUserid;
	}
	/**
	 * 项目经理名称
	 **/
	public void setPmUsername(String pmUsername) {
		this.pmUsername = pmUsername;
	}
	/**
	 * 助理、副经理编号
	 **/
	public void setAssUserid(String assUserid) {
		this.assUserid = assUserid;
	}
	/**
	 * 助理、副经理姓名
	 **/
	public void setAssUsername(String assUsername) {
		this.assUsername = assUsername;
	}
	/**
	 * 主管领导编号
	 **/
	public void setAdmUserid(String admUserid) {
		this.admUserid = admUserid;
	}
	/**
	 * 主管领导姓名
	 **/
	public void setAdmUsername(String admUsername) {
		this.admUsername = admUsername;
	}
	/**
	 * 是否进行计划预算预警，计划预算超出项目预算既定额度进行预警
	 **/
	public void setBudgetEarly(String budgetEarly) {
		this.budgetEarly = budgetEarly;
	}
	/**
	 * 计划是否进行实际金额控制，实际金额不能大于预算金额（大于预算金额不得结算）
	 **/
	public void setPhaseActCtrl(String phaseActCtrl) {
		this.phaseActCtrl = phaseActCtrl;
	}
	/**
	 * 是否已删除0否1是
	 **/
	public void setDel(String del) {
		this.del = del;
	}
	/**
	 * 最后更新时间
	 **/
	public void setLtime(Date ltime) {
		this.ltime = ltime;
	}
	/**
	 * 原状态，暂停时记录原状态，暂停恢复后把原状态恢复
	 **/
	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}
	/**
	 * 工作方式scrum、kanban
	 **/
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	/**
	 * 报工方式0-无须报工，1-每日报工，2-工期内报工
	 **/
	public void setWtype(String wtype) {
		this.wtype = wtype;
	}
	/**
	 * 超出预算金额多少金额进行预警，正数代表超出的额度，负数代表距离预算的额度
	 **/
	public void setEarlyAmt(BigDecimal earlyAmt) {
		this.earlyAmt = earlyAmt;
	}
	
	/**
	 * 项目编号
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 项目代号
	 **/
	public String getCode() {
		return this.code;
	}
	/**
	 * 项目名称
	 **/
	public String getName() {
		return this.name;
	}
	/**
	 * 项目类型
	 **/
	public String getXmType() {
		return this.xmType;
	}
	/**
	 * 项目开始时间
	 **/
	public Date getStartTime() {
		return this.startTime;
	}
	/**
	 * 项目结束时间
	 **/
	public Date getEndTime() {
		return this.endTime;
	}
	/**
	 * 紧急程度
	 **/
	public String getUrgent() {
		return this.urgent;
	}
	/**
	 * 优先程度
	 **/
	public String getPriority() {
		return this.priority;
	}
	/**
	 * 项目描述
	 **/
	public String getDescription() {
		return this.description;
	}
	/**
	 * 项目创建人编号
	 **/
	public String getCreateUserid() {
		return this.createUserid;
	}
	/**
	 * 项目创建人
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
	 * 项目考核
	 **/
	public String getAssess() {
		return this.assess;
	}
	/**
	 * 考核备注
	 **/
	public String getAssessRemarks() {
		return this.assessRemarks;
	}
	/**
	 * 0|初始1|售前2|立项中3|实施中4|暂停中5|结项中6|已结项7|售后8|已完成9|已关闭
	 **/
	public String getStatus() {
		return this.status;
	}
	/**
	 * 机构编号
	 **/
	public String getBranchId() {
		return this.branchId;
	}
	/**
	 * 总预算
	 **/
	public BigDecimal getPlanTotalCost() {
		return this.planTotalCost;
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
	 * 非人力成本总预算-应该大于或等于阶段计划非人力总成本
	 **/
	public BigDecimal getPlanNouserAt() {
		return this.planNouserAt;
	}
	/**
	 * 内部人力成本总预算-应该大于或等于阶段计划内部人力总成本
	 **/
	public BigDecimal getPlanIuserAt() {
		return this.planIuserAt;
	}
	/**
	 * 外购人力成本总预算-应该大于或等于阶段计划外购人力总成本
	 **/
	public BigDecimal getPlanOuserAt() {
		return this.planOuserAt;
	}
	/**
	 * 是否锁定整个项目不允许变化0否1是
	 **/
	public String getLocked() {
		return this.locked;
	}
	/**
	 * 基线时间
	 **/
	public Date getBaseTime() {
		return this.baseTime;
	}
	/**
	 * 基线备注
	 **/
	public String getBaseRemark() {
		return this.baseRemark;
	}
	/**
	 * 基线主键
	 **/
	public String getBaselineId() {
		return this.baselineId;
	}
	/**
	 * 总预算工作量-应该大于或等于阶段计划总工作量
	 **/
	public BigDecimal getPlanWorkload() {
		return this.planWorkload;
	}
	/**
	 * 总预计收款金额
	 **/
	public BigDecimal getTotalReceivables() {
		return this.totalReceivables;
	}
	/**
	 * 预估毛利率
	 **/
	public BigDecimal getBudgetMarginRate() {
		return this.budgetMarginRate;
	}
	/**
	 * 合同总金额
	 **/
	public BigDecimal getContractAmt() {
		return this.contractAmt;
	}
	/**
	 * 内部人力成本单价元/人时
	 **/
	public BigDecimal getPlanIuserPrice() {
		return this.planIuserPrice;
	}
	/**
	 * 外购人力成本单价元/人时
	 **/
	public BigDecimal getPlanOuserPrice() {
		return this.planOuserPrice;
	}
	/**
	 * 外购人数
	 **/
	public Integer getPlanOuserCnt() {
		return this.planOuserCnt;
	}
	/**
	 * 内部人数
	 **/
	public Integer getPlanIuserCnt() {
		return this.planIuserCnt;
	}
	/**
	 * 预计工作小时数目
	 **/
	public Integer getPlanWorkingHours() {
		return this.planWorkingHours;
	}
	/**
	 * 税率0-100之间
	 **/
	public BigDecimal getTaxRate() {
		return this.taxRate;
	}
	/**
	 * 内部人力总工作量-应该大于或等于阶段计划内部人力总成本
	 **/
	public BigDecimal getPlanIuserWorkload() {
		return this.planIuserWorkload;
	}
	/**
	 * 外购人力总工作量-应该大于或等于阶段计划外购人力总成本
	 **/
	public BigDecimal getPlanOuserWorkload() {
		return this.planOuserWorkload;
	}
	/**
	 * 关联模板编号
	 **/
	public String getFromTplId() {
		return this.fromTplId;
	}
	/**
	 * 是否进行预算控制，计划中一级计划总预算大于项目预算则拒绝添加计划,一般用于瀑布型项目
	 **/
	public String getBudgetCtrl() {
		return this.budgetCtrl;
	}
	/**
	 * 部门编号
	 **/
	public String getDeptid() {
		return this.deptid;
	}
	/**
	 * 是否对外公开0-完全不可见，1-仅本司人员可见，2-关联人员可见（众包-外包-招投标）
	 **/
	public String getShowOut() {
		return this.showOut;
	}
	/**
	 * 是否为模板
	 **/
	public String getIsTpl() {
		return this.isTpl;
	}
	/**
	 * 项目经理编号
	 **/
	public String getPmUserid() {
		return this.pmUserid;
	}
	/**
	 * 项目经理名称
	 **/
	public String getPmUsername() {
		return this.pmUsername;
	}
	/**
	 * 助理、副经理编号
	 **/
	public String getAssUserid() {
		return this.assUserid;
	}
	/**
	 * 助理、副经理姓名
	 **/
	public String getAssUsername() {
		return this.assUsername;
	}
	/**
	 * 主管领导编号
	 **/
	public String getAdmUserid() {
		return this.admUserid;
	}
	/**
	 * 主管领导姓名
	 **/
	public String getAdmUsername() {
		return this.admUsername;
	}
	/**
	 * 是否进行计划预算预警，计划预算超出项目预算既定额度进行预警
	 **/
	public String getBudgetEarly() {
		return this.budgetEarly;
	}
	/**
	 * 计划是否进行实际金额控制，实际金额不能大于预算金额（大于预算金额不得结算）
	 **/
	public String getPhaseActCtrl() {
		return this.phaseActCtrl;
	}
	/**
	 * 是否已删除0否1是
	 **/
	public String getDel() {
		return this.del;
	}
	/**
	 * 最后更新时间
	 **/
	public Date getLtime() {
		return this.ltime;
	}
	/**
	 * 原状态，暂停时记录原状态，暂停恢复后把原状态恢复
	 **/
	public String getOstatus() {
		return this.ostatus;
	}
	/**
	 * 工作方式scrum、kanban
	 **/
	public String getWorkType() {
		return this.workType;
	}
	/**
	 * 报工方式0-无须报工，1-每日报工，2-工期内报工
	 **/
	public String getWtype() {
		return this.wtype;
	}
	/**
	 * 超出预算金额多少金额进行预警，正数代表超出的额度，负数代表距离预算的额度
	 **/
	public BigDecimal getEarlyAmt() {
		return this.earlyAmt;
	}

}