package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmProduct所有属性名: <br>
 *	id,productName,branchId,remark,version,pmUserid,pmUsername,ctime,deptid,pstatus,startTime,endTime,deptName,admUserid,admUsername,assistantUserid,assistantUsername,bizProcInstId,bizFlowState,isTpl,baselineId,baseTime,code,pbudgetWorkload,pbudgetAmount,pmenuBudgetWorkload,pmenuBudgetAmount;<br>
 * 表 xm_product 产品表的所有字段名: <br>
 *	id,product_name,branch_id,remark,version,pm_userid,pm_username,ctime,deptid,pstatus,start_time,end_time,dept_name,adm_userid,adm_username,assistant_userid,assistant_username,biz_proc_inst_id,biz_flow_state,is_tpl,baseline_id,base_time,code,pbudget_workload,pbudget_amount,pmenu_budget_workload,pmenu_budget_amount;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="产品表")
public class XmProduct  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="产品编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="产品名称",allowEmptyValue=true,example="",allowableValues="")
	String productName;
	
	@ApiModelProperty(notes="机构号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="版本号",allowEmptyValue=true,example="",allowableValues="")
	String version;
	
	@ApiModelProperty(notes="产品经理编号",allowEmptyValue=true,example="",allowableValues="")
	String pmUserid;
	
	@ApiModelProperty(notes="产品经理名称",allowEmptyValue=true,example="",allowableValues="")
	String pmUsername;
	
	@ApiModelProperty(notes="创建日期",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="归属部门",allowEmptyValue=true,example="",allowableValues="")
	String deptid;
	
	@ApiModelProperty(notes="产品阶段:0未开始,1研发中,2已完成,3已关闭",allowEmptyValue=true,example="",allowableValues="")
	String pstatus;
	
	@ApiModelProperty(notes="开始日期",allowEmptyValue=true,example="",allowableValues="")
	Date startTime;
	
	@ApiModelProperty(notes="结束日期",allowEmptyValue=true,example="",allowableValues="")
	Date endTime;
	
	@ApiModelProperty(notes="主管部门名称",allowEmptyValue=true,example="",allowableValues="")
	String deptName;
	
	@ApiModelProperty(notes="主管领导编号",allowEmptyValue=true,example="",allowableValues="")
	String admUserid;
	
	@ApiModelProperty(notes="主管领导名称",allowEmptyValue=true,example="",allowableValues="")
	String admUsername;
	
	@ApiModelProperty(notes="副经理编号",allowEmptyValue=true,example="",allowableValues="")
	String assistantUserid;
	
	@ApiModelProperty(notes="副经理名称",allowEmptyValue=true,example="",allowableValues="")
	String assistantUsername;
	
	@ApiModelProperty(notes="当前流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String bizProcInstId;
	
	@ApiModelProperty(notes="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;
	
	@ApiModelProperty(notes="是否为模板",allowEmptyValue=true,example="",allowableValues="")
	String isTpl;
	
	@ApiModelProperty(notes="基线编号",allowEmptyValue=true,example="",allowableValues="")
	String baselineId;
	
	@ApiModelProperty(notes="基线时间",allowEmptyValue=true,example="",allowableValues="")
	Date baseTime;
	
	@ApiModelProperty(notes="产品编码",allowEmptyValue=true,example="",allowableValues="")
	String code;
	
	@ApiModelProperty(notes="产品预计总工作量，应该大于一级需求总预算工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal pbudgetWorkload;
	
	@ApiModelProperty(notes="产品预计总金额，应该大于一级需求总预算金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal pbudgetAmount;
	
	@ApiModelProperty(notes="从需求汇总来的总预算工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal pmenuBudgetWorkload;
	
	@ApiModelProperty(notes="从需求汇总的总预算金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal pmenuBudgetAmount;

	/**产品编号**/
	public XmProduct(String id) {
		this.id = id;
	}
    
    /**产品表**/
	public XmProduct() {
	}
	
	/**
	 * 产品编号
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 产品名称
	 **/
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * 机构号
	 **/
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	/**
	 * 备注
	 **/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 版本号
	 **/
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * 产品经理编号
	 **/
	public void setPmUserid(String pmUserid) {
		this.pmUserid = pmUserid;
	}
	/**
	 * 产品经理名称
	 **/
	public void setPmUsername(String pmUsername) {
		this.pmUsername = pmUsername;
	}
	/**
	 * 创建日期
	 **/
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	/**
	 * 归属部门
	 **/
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	/**
	 * 产品阶段:0未开始,1研发中,2已完成,3已关闭
	 **/
	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}
	/**
	 * 开始日期
	 **/
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 结束日期
	 **/
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 主管部门名称
	 **/
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * 主管领导编号
	 **/
	public void setAdmUserid(String admUserid) {
		this.admUserid = admUserid;
	}
	/**
	 * 主管领导名称
	 **/
	public void setAdmUsername(String admUsername) {
		this.admUsername = admUsername;
	}
	/**
	 * 副经理编号
	 **/
	public void setAssistantUserid(String assistantUserid) {
		this.assistantUserid = assistantUserid;
	}
	/**
	 * 副经理名称
	 **/
	public void setAssistantUsername(String assistantUsername) {
		this.assistantUsername = assistantUsername;
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
	 * 是否为模板
	 **/
	public void setIsTpl(String isTpl) {
		this.isTpl = isTpl;
	}
	/**
	 * 基线编号
	 **/
	public void setBaselineId(String baselineId) {
		this.baselineId = baselineId;
	}
	/**
	 * 基线时间
	 **/
	public void setBaseTime(Date baseTime) {
		this.baseTime = baseTime;
	}
	/**
	 * 产品编码
	 **/
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 产品预计总工作量，应该大于一级需求总预算工作量
	 **/
	public void setPbudgetWorkload(BigDecimal pbudgetWorkload) {
		this.pbudgetWorkload = pbudgetWorkload;
	}
	/**
	 * 产品预计总金额，应该大于一级需求总预算金额
	 **/
	public void setPbudgetAmount(BigDecimal pbudgetAmount) {
		this.pbudgetAmount = pbudgetAmount;
	}
	/**
	 * 从需求汇总来的总预算工作量
	 **/
	public void setPmenuBudgetWorkload(BigDecimal pmenuBudgetWorkload) {
		this.pmenuBudgetWorkload = pmenuBudgetWorkload;
	}
	/**
	 * 从需求汇总的总预算金额
	 **/
	public void setPmenuBudgetAmount(BigDecimal pmenuBudgetAmount) {
		this.pmenuBudgetAmount = pmenuBudgetAmount;
	}
	
	/**
	 * 产品编号
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 产品名称
	 **/
	public String getProductName() {
		return this.productName;
	}
	/**
	 * 机构号
	 **/
	public String getBranchId() {
		return this.branchId;
	}
	/**
	 * 备注
	 **/
	public String getRemark() {
		return this.remark;
	}
	/**
	 * 版本号
	 **/
	public String getVersion() {
		return this.version;
	}
	/**
	 * 产品经理编号
	 **/
	public String getPmUserid() {
		return this.pmUserid;
	}
	/**
	 * 产品经理名称
	 **/
	public String getPmUsername() {
		return this.pmUsername;
	}
	/**
	 * 创建日期
	 **/
	public Date getCtime() {
		return this.ctime;
	}
	/**
	 * 归属部门
	 **/
	public String getDeptid() {
		return this.deptid;
	}
	/**
	 * 产品阶段:0未开始,1研发中,2已完成,3已关闭
	 **/
	public String getPstatus() {
		return this.pstatus;
	}
	/**
	 * 开始日期
	 **/
	public Date getStartTime() {
		return this.startTime;
	}
	/**
	 * 结束日期
	 **/
	public Date getEndTime() {
		return this.endTime;
	}
	/**
	 * 主管部门名称
	 **/
	public String getDeptName() {
		return this.deptName;
	}
	/**
	 * 主管领导编号
	 **/
	public String getAdmUserid() {
		return this.admUserid;
	}
	/**
	 * 主管领导名称
	 **/
	public String getAdmUsername() {
		return this.admUsername;
	}
	/**
	 * 副经理编号
	 **/
	public String getAssistantUserid() {
		return this.assistantUserid;
	}
	/**
	 * 副经理名称
	 **/
	public String getAssistantUsername() {
		return this.assistantUsername;
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
	 * 是否为模板
	 **/
	public String getIsTpl() {
		return this.isTpl;
	}
	/**
	 * 基线编号
	 **/
	public String getBaselineId() {
		return this.baselineId;
	}
	/**
	 * 基线时间
	 **/
	public Date getBaseTime() {
		return this.baseTime;
	}
	/**
	 * 产品编码
	 **/
	public String getCode() {
		return this.code;
	}
	/**
	 * 产品预计总工作量，应该大于一级需求总预算工作量
	 **/
	public BigDecimal getPbudgetWorkload() {
		return this.pbudgetWorkload;
	}
	/**
	 * 产品预计总金额，应该大于一级需求总预算金额
	 **/
	public BigDecimal getPbudgetAmount() {
		return this.pbudgetAmount;
	}
	/**
	 * 从需求汇总来的总预算工作量
	 **/
	public BigDecimal getPmenuBudgetWorkload() {
		return this.pmenuBudgetWorkload;
	}
	/**
	 * 从需求汇总的总预算金额
	 **/
	public BigDecimal getPmenuBudgetAmount() {
		return this.pmenuBudgetAmount;
	}

}