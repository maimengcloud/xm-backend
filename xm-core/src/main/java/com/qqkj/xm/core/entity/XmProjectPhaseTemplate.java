package  com.qqkj.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com.qqkj  顶级模块 oa 大模块 xm  小模块 <br> 
 * 实体 XmProjectPhaseTemplate所有属性名: <br>
 *	id,phaseName,remark,parentPhaseId,branchId,projectId,beginDate,endDate,phaseBudgetHours,phaseBudgetStaffNu,ctime,phaseBudgetNouserAt,phaseBudgetInnerUserAt,phaseBudgetOutUserAt,phaseBudgetWorkload,taskType,planType,seqNo,phaseBudgetInnerUserWorkload,phaseBudgetOutUserWorkload,phaseBudgetInnerUserPrice,phaseBudgetOutUserPrice,phaseBudgetOutUserCnt,phaseBudgetInnerUserCnt;<br>
 * 表 XM.xm_project_phase_template 项目阶段模板的所有字段名: <br>
 *	id,phase_name,remark,parent_phase_id,branch_id,project_id,begin_date,end_date,phase_budget_hours,phase_budget_staff_nu,ctime,phase_budget_nouser_at,phase_budget_inner_user_at,phase_budget_out_user_at,phase_budget_workload,task_type,plan_type,seq_no,phase_budget_inner_user_workload,phase_budget_out_user_workload,phase_budget_inner_user_price,phase_budget_out_user_price,phase_budget_out_user_cnt,phase_budget_inner_user_cnt;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="项目阶段模板")
public class XmProjectPhaseTemplate  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="阶段主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="阶段名称",allowEmptyValue=true,example="",allowableValues="")
	String phaseName;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="上级阶段编号",allowEmptyValue=true,example="",allowableValues="")
	String parentPhaseId;
	
	@ApiModelProperty(notes="机构编号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="当前项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date beginDate;
	
	@ApiModelProperty(notes="结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date endDate;
	
	@ApiModelProperty(notes="工时(不包括下一级)-应该大于或等于task中总工时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseBudgetHours;
	
	@ApiModelProperty(notes="投入人员数(不包括下一级)-应该大于或等于task中总人数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseBudgetStaffNu;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="非人力成本总预算(不包括下一级)-应该大于或等于task中非人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseBudgetNouserAt;
	
	@ApiModelProperty(notes="内部人力成本总预算(不包括下一级)-应该大于或等于task中内部人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseBudgetInnerUserAt;
	
	@ApiModelProperty(notes="外购人力成本总预算(不包括下一级)-应该大于或等于task中外购总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseBudgetOutUserAt;
	
	@ApiModelProperty(notes="总工作量单位人时-应该大于或者等于task中的预算总工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseBudgetWorkload;
	
	@ApiModelProperty(notes="0售前方案1投标2需求3设计4开发5测试6验收7部署8运维--来自基础数据表taskType",allowEmptyValue=true,example="",allowableValues="")
	String taskType;
	
	@ApiModelProperty(notes="计划类型w1-周,w2-2周,w3-3周,m1-1月,m2-2月,q1-季,q2-半年，y1-年",allowEmptyValue=true,example="",allowableValues="")
	String planType;
	
	@ApiModelProperty(notes="顺序号",allowEmptyValue=true,example="",allowableValues="")
	String seqNo;
	
	@ApiModelProperty(notes="内部人力工作量总预算(不包括下一级)-应该大于或等于task中内部人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseBudgetInnerUserWorkload;
	
	@ApiModelProperty(notes="外购人力工作量总预算(不包括下一级)-应该大于或等于task中外购总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseBudgetOutUserWorkload;
	
	@ApiModelProperty(notes="内部人力成本单价元/人时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseBudgetInnerUserPrice;
	
	@ApiModelProperty(notes="外购人力成本单价元/人时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseBudgetOutUserPrice;
	
	@ApiModelProperty(notes="外购人数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseBudgetOutUserCnt;
	
	@ApiModelProperty(notes="内部人数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal phaseBudgetInnerUserCnt;

	/**阶段主键**/
	public XmProjectPhaseTemplate(String id) {
		this.id = id;
	}
    
    /**项目阶段模板**/
	public XmProjectPhaseTemplate() {
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
	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
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
	public void setParentPhaseId(String parentPhaseId) {
		this.parentPhaseId = parentPhaseId;
	}
	/**
	 * 机构编号
	 **/
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	/**
	 * 当前项目编号
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
	 * 工时(不包括下一级)-应该大于或等于task中总工时
	 **/
	public void setPhaseBudgetHours(BigDecimal phaseBudgetHours) {
		this.phaseBudgetHours = phaseBudgetHours;
	}
	/**
	 * 投入人员数(不包括下一级)-应该大于或等于task中总人数
	 **/
	public void setPhaseBudgetStaffNu(BigDecimal phaseBudgetStaffNu) {
		this.phaseBudgetStaffNu = phaseBudgetStaffNu;
	}
	/**
	 * 创建时间
	 **/
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	/**
	 * 非人力成本总预算(不包括下一级)-应该大于或等于task中非人力总成本
	 **/
	public void setPhaseBudgetNouserAt(BigDecimal phaseBudgetNouserAt) {
		this.phaseBudgetNouserAt = phaseBudgetNouserAt;
	}
	/**
	 * 内部人力成本总预算(不包括下一级)-应该大于或等于task中内部人力总成本
	 **/
	public void setPhaseBudgetInnerUserAt(BigDecimal phaseBudgetInnerUserAt) {
		this.phaseBudgetInnerUserAt = phaseBudgetInnerUserAt;
	}
	/**
	 * 外购人力成本总预算(不包括下一级)-应该大于或等于task中外购总成本
	 **/
	public void setPhaseBudgetOutUserAt(BigDecimal phaseBudgetOutUserAt) {
		this.phaseBudgetOutUserAt = phaseBudgetOutUserAt;
	}
	/**
	 * 总工作量单位人时-应该大于或者等于task中的预算总工作量
	 **/
	public void setPhaseBudgetWorkload(BigDecimal phaseBudgetWorkload) {
		this.phaseBudgetWorkload = phaseBudgetWorkload;
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
	 * 内部人力工作量总预算(不包括下一级)-应该大于或等于task中内部人力总成本
	 **/
	public void setPhaseBudgetInnerUserWorkload(BigDecimal phaseBudgetInnerUserWorkload) {
		this.phaseBudgetInnerUserWorkload = phaseBudgetInnerUserWorkload;
	}
	/**
	 * 外购人力工作量总预算(不包括下一级)-应该大于或等于task中外购总成本
	 **/
	public void setPhaseBudgetOutUserWorkload(BigDecimal phaseBudgetOutUserWorkload) {
		this.phaseBudgetOutUserWorkload = phaseBudgetOutUserWorkload;
	}
	/**
	 * 内部人力成本单价元/人时
	 **/
	public void setPhaseBudgetInnerUserPrice(BigDecimal phaseBudgetInnerUserPrice) {
		this.phaseBudgetInnerUserPrice = phaseBudgetInnerUserPrice;
	}
	/**
	 * 外购人力成本单价元/人时
	 **/
	public void setPhaseBudgetOutUserPrice(BigDecimal phaseBudgetOutUserPrice) {
		this.phaseBudgetOutUserPrice = phaseBudgetOutUserPrice;
	}
	/**
	 * 外购人数
	 **/
	public void setPhaseBudgetOutUserCnt(BigDecimal phaseBudgetOutUserCnt) {
		this.phaseBudgetOutUserCnt = phaseBudgetOutUserCnt;
	}
	/**
	 * 内部人数
	 **/
	public void setPhaseBudgetInnerUserCnt(BigDecimal phaseBudgetInnerUserCnt) {
		this.phaseBudgetInnerUserCnt = phaseBudgetInnerUserCnt;
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
	public String getPhaseName() {
		return this.phaseName;
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
	public String getParentPhaseId() {
		return this.parentPhaseId;
	}
	/**
	 * 机构编号
	 **/
	public String getBranchId() {
		return this.branchId;
	}
	/**
	 * 当前项目编号
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
	 * 工时(不包括下一级)-应该大于或等于task中总工时
	 **/
	public BigDecimal getPhaseBudgetHours() {
		return this.phaseBudgetHours;
	}
	/**
	 * 投入人员数(不包括下一级)-应该大于或等于task中总人数
	 **/
	public BigDecimal getPhaseBudgetStaffNu() {
		return this.phaseBudgetStaffNu;
	}
	/**
	 * 创建时间
	 **/
	public Date getCtime() {
		return this.ctime;
	}
	/**
	 * 非人力成本总预算(不包括下一级)-应该大于或等于task中非人力总成本
	 **/
	public BigDecimal getPhaseBudgetNouserAt() {
		return this.phaseBudgetNouserAt;
	}
	/**
	 * 内部人力成本总预算(不包括下一级)-应该大于或等于task中内部人力总成本
	 **/
	public BigDecimal getPhaseBudgetInnerUserAt() {
		return this.phaseBudgetInnerUserAt;
	}
	/**
	 * 外购人力成本总预算(不包括下一级)-应该大于或等于task中外购总成本
	 **/
	public BigDecimal getPhaseBudgetOutUserAt() {
		return this.phaseBudgetOutUserAt;
	}
	/**
	 * 总工作量单位人时-应该大于或者等于task中的预算总工作量
	 **/
	public BigDecimal getPhaseBudgetWorkload() {
		return this.phaseBudgetWorkload;
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
	 * 内部人力工作量总预算(不包括下一级)-应该大于或等于task中内部人力总成本
	 **/
	public BigDecimal getPhaseBudgetInnerUserWorkload() {
		return this.phaseBudgetInnerUserWorkload;
	}
	/**
	 * 外购人力工作量总预算(不包括下一级)-应该大于或等于task中外购总成本
	 **/
	public BigDecimal getPhaseBudgetOutUserWorkload() {
		return this.phaseBudgetOutUserWorkload;
	}
	/**
	 * 内部人力成本单价元/人时
	 **/
	public BigDecimal getPhaseBudgetInnerUserPrice() {
		return this.phaseBudgetInnerUserPrice;
	}
	/**
	 * 外购人力成本单价元/人时
	 **/
	public BigDecimal getPhaseBudgetOutUserPrice() {
		return this.phaseBudgetOutUserPrice;
	}
	/**
	 * 外购人数
	 **/
	public BigDecimal getPhaseBudgetOutUserCnt() {
		return this.phaseBudgetOutUserCnt;
	}
	/**
	 * 内部人数
	 **/
	public BigDecimal getPhaseBudgetInnerUserCnt() {
		return this.phaseBudgetInnerUserCnt;
	}

}