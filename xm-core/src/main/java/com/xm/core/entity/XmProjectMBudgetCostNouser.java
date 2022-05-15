package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmProjectMBudgetCostNouser所有属性名: <br>
 *	projectId,budgetCost,id,remark,subjectId,bizzStartDate,bizzEndDate,bizProcInstId,bizFlowState,phaseId,costType,bizzMonth,subjectName;<br>
 * 表 xm_project_m_budget_cost_nouser 项目人力成本预算的所有字段名: <br>
 *	project_id,budget_cost,id,remark,subject_id,bizz_start_date,bizz_end_date,biz_proc_inst_id,biz_flow_state,phase_id,cost_type,bizz_month,subject_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="项目人力成本预算")
public class XmProjectMBudgetCostNouser  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="预算金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetCost;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="预算科目",allowEmptyValue=true,example="",allowableValues="")
	String subjectId;
	
	@ApiModelProperty(notes="费用归属周期开始日期",allowEmptyValue=true,example="",allowableValues="")
	Date bizzStartDate;
	
	@ApiModelProperty(notes="费用归属周期结束日期",allowEmptyValue=true,example="",allowableValues="")
	Date bizzEndDate;
	
	@ApiModelProperty(notes="当前流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String bizProcInstId;
	
	@ApiModelProperty(notes="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;
	
	@ApiModelProperty(notes="阶段计划编号",allowEmptyValue=true,example="",allowableValues="")
	String phaseId;
	
	@ApiModelProperty(notes="成本类型0非人力1内部人力2外购人力",allowEmptyValue=true,example="",allowableValues="")
	String costType;
	
	@ApiModelProperty(notes="费用归属月份yyyy-mm",allowEmptyValue=true,example="",allowableValues="")
	String bizzMonth;
	
	@ApiModelProperty(notes="科目名称",allowEmptyValue=true,example="",allowableValues="")
	String subjectName;

	/**主键**/
	public XmProjectMBudgetCostNouser(String id) {
		this.id = id;
	}
    
    /**项目人力成本预算**/
	public XmProjectMBudgetCostNouser() {
	}
	
	/**
	 * 项目编号
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 预算金额
	 **/
	public void setBudgetCost(BigDecimal budgetCost) {
		this.budgetCost = budgetCost;
	}
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 备注
	 **/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 预算科目
	 **/
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	/**
	 * 费用归属周期开始日期
	 **/
	public void setBizzStartDate(Date bizzStartDate) {
		this.bizzStartDate = bizzStartDate;
	}
	/**
	 * 费用归属周期结束日期
	 **/
	public void setBizzEndDate(Date bizzEndDate) {
		this.bizzEndDate = bizzEndDate;
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
	 * 阶段计划编号
	 **/
	public void setPhaseId(String phaseId) {
		this.phaseId = phaseId;
	}
	/**
	 * 成本类型0非人力1内部人力2外购人力
	 **/
	public void setCostType(String costType) {
		this.costType = costType;
	}
	/**
	 * 费用归属月份yyyy-mm
	 **/
	public void setBizzMonth(String bizzMonth) {
		this.bizzMonth = bizzMonth;
	}
	/**
	 * 科目名称
	 **/
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	/**
	 * 项目编号
	 **/
	public String getProjectId() {
		return this.projectId;
	}
	/**
	 * 预算金额
	 **/
	public BigDecimal getBudgetCost() {
		return this.budgetCost;
	}
	/**
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 备注
	 **/
	public String getRemark() {
		return this.remark;
	}
	/**
	 * 预算科目
	 **/
	public String getSubjectId() {
		return this.subjectId;
	}
	/**
	 * 费用归属周期开始日期
	 **/
	public Date getBizzStartDate() {
		return this.bizzStartDate;
	}
	/**
	 * 费用归属周期结束日期
	 **/
	public Date getBizzEndDate() {
		return this.bizzEndDate;
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
	 * 阶段计划编号
	 **/
	public String getPhaseId() {
		return this.phaseId;
	}
	/**
	 * 成本类型0非人力1内部人力2外购人力
	 **/
	public String getCostType() {
		return this.costType;
	}
	/**
	 * 费用归属月份yyyy-mm
	 **/
	public String getBizzMonth() {
		return this.bizzMonth;
	}
	/**
	 * 科目名称
	 **/
	public String getSubjectName() {
		return this.subjectName;
	}

}