package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 组织 com.qqkj  顶级模块 oa 大模块 xm  小模块 <br> 
 * 实体 XmProjectBaseline所有属性名: <br>
 *	id,code,name,xmType,startTime,endTime,urgent,priority,description,createUserid,createUsername,createTime,assess,assessRemarks,status,branchId,planTotalCost,bizProcInstId,bizFlowState,planNouserAt,planInnerUserAt,planOutUserAt,locked,baseTime,baseRemark,baselineId,planWorkload,totalReceivables,budgetMarginRate,contractAmt,planInnerUserPrice,planOutUserPrice,planOutUserCnt,planInnerUserCnt,planWorkingHours,taxRate,planInnerUserWorkload,planOutUserWorkload,projectId,ctime;<br>
 * 表 XM.xm_project_baseline xm_project_baseline的所有字段名: <br>
 *	id,code,name,xm_type,start_time,end_time,urgent,priority,description,create_userid,create_username,create_time,assess,assess_remarks,status,branch_id,plan_total_cost,biz_proc_inst_id,biz_flow_state,plan_nouser_at,plan_inner_user_at,plan_out_user_at,locked,base_time,base_remark,baseline_id,plan_workload,total_receivables,budget_margin_rate,contract_amt,plan_inner_user_price,plan_out_user_price,plan_out_user_cnt,plan_inner_user_cnt,plan_working_hours,tax_rate,plan_inner_user_workload,plan_out_user_workload,project_id,ctime;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_project_baseline")
public class XmProjectBaseline  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="基线表主键,主键",allowEmptyValue=true,example="",allowableValues="")
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
	
	@ApiModelProperty(notes="项目状态，0-初始，1-立项中，2-执行中，3-已结项，4-暂停",allowEmptyValue=true,example="",allowableValues="")
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
	BigDecimal planInnerUserAt;
	
	@ApiModelProperty(notes="外购人力成本总预算-应该大于或等于阶段计划外购人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planOutUserAt;
	
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
	BigDecimal planInnerUserPrice;
	
	@ApiModelProperty(notes="外购人力成本单价元/人时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planOutUserPrice;
	
	@ApiModelProperty(notes="外购人数",allowEmptyValue=true,example="",allowableValues="")
	Integer planOutUserCnt;
	
	@ApiModelProperty(notes="内部人数",allowEmptyValue=true,example="",allowableValues="")
	Integer planInnerUserCnt;
	
	@ApiModelProperty(notes="预计工作小时数目",allowEmptyValue=true,example="",allowableValues="")
	Integer planWorkingHours;
	
	@ApiModelProperty(notes="税率",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal taxRate;
	
	@ApiModelProperty(notes="内部人力总工作量-应该大于或等于阶段计划内部人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planInnerUserWorkload;
	
	@ApiModelProperty(notes="外购人力总工作量-应该大于或等于阶段计划外购人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planOutUserWorkload;
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;

	/**基线表主键**/
	public XmProjectBaseline(String id) {
		this.id = id;
	}
    
    /**xm_project_baseline**/
	public XmProjectBaseline() {
	}
	
	/**
	 * 基线表主键
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
	 * 项目状态，0-初始，1-立项中，2-执行中，3-已结项，4-暂停
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
	public void setPlanInnerUserAt(BigDecimal planInnerUserAt) {
		this.planInnerUserAt = planInnerUserAt;
	}
	/**
	 * 外购人力成本总预算-应该大于或等于阶段计划外购人力总成本
	 **/
	public void setPlanOutUserAt(BigDecimal planOutUserAt) {
		this.planOutUserAt = planOutUserAt;
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
	public void setPlanInnerUserPrice(BigDecimal planInnerUserPrice) {
		this.planInnerUserPrice = planInnerUserPrice;
	}
	/**
	 * 外购人力成本单价元/人时
	 **/
	public void setPlanOutUserPrice(BigDecimal planOutUserPrice) {
		this.planOutUserPrice = planOutUserPrice;
	}
	/**
	 * 外购人数
	 **/
	public void setPlanOutUserCnt(Integer planOutUserCnt) {
		this.planOutUserCnt = planOutUserCnt;
	}
	/**
	 * 内部人数
	 **/
	public void setPlanInnerUserCnt(Integer planInnerUserCnt) {
		this.planInnerUserCnt = planInnerUserCnt;
	}
	/**
	 * 预计工作小时数目
	 **/
	public void setPlanWorkingHours(Integer planWorkingHours) {
		this.planWorkingHours = planWorkingHours;
	}
	/**
	 * 税率
	 **/
	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}
	/**
	 * 内部人力总工作量-应该大于或等于阶段计划内部人力总成本
	 **/
	public void setPlanInnerUserWorkload(BigDecimal planInnerUserWorkload) {
		this.planInnerUserWorkload = planInnerUserWorkload;
	}
	/**
	 * 外购人力总工作量-应该大于或等于阶段计划外购人力总成本
	 **/
	public void setPlanOutUserWorkload(BigDecimal planOutUserWorkload) {
		this.planOutUserWorkload = planOutUserWorkload;
	}
	/**
	 * 项目编号
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 创建时间
	 **/
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	
	/**
	 * 基线表主键
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
	 * 项目状态，0-初始，1-立项中，2-执行中，3-已结项，4-暂停
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
	public BigDecimal getPlanInnerUserAt() {
		return this.planInnerUserAt;
	}
	/**
	 * 外购人力成本总预算-应该大于或等于阶段计划外购人力总成本
	 **/
	public BigDecimal getPlanOutUserAt() {
		return this.planOutUserAt;
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
	public BigDecimal getPlanInnerUserPrice() {
		return this.planInnerUserPrice;
	}
	/**
	 * 外购人力成本单价元/人时
	 **/
	public BigDecimal getPlanOutUserPrice() {
		return this.planOutUserPrice;
	}
	/**
	 * 外购人数
	 **/
	public Integer getPlanOutUserCnt() {
		return this.planOutUserCnt;
	}
	/**
	 * 内部人数
	 **/
	public Integer getPlanInnerUserCnt() {
		return this.planInnerUserCnt;
	}
	/**
	 * 预计工作小时数目
	 **/
	public Integer getPlanWorkingHours() {
		return this.planWorkingHours;
	}
	/**
	 * 税率
	 **/
	public BigDecimal getTaxRate() {
		return this.taxRate;
	}
	/**
	 * 内部人力总工作量-应该大于或等于阶段计划内部人力总成本
	 **/
	public BigDecimal getPlanInnerUserWorkload() {
		return this.planInnerUserWorkload;
	}
	/**
	 * 外购人力总工作量-应该大于或等于阶段计划外购人力总成本
	 **/
	public BigDecimal getPlanOutUserWorkload() {
		return this.planOutUserWorkload;
	}
	/**
	 * 项目编号
	 **/
	public String getProjectId() {
		return this.projectId;
	}
	/**
	 * 创建时间
	 **/
	public Date getCtime() {
		return this.ctime;
	}

}