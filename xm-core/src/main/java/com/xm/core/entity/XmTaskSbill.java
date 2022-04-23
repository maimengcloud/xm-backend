package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmTaskSbill所有属性名: <br>
 *	id,title,amt,ctime,cuserid,cusername,remark,branchId,deptid,cpId,cpName,workload,bizMonth,bizDate,bizFlowState,bizProcInstId,ltime,status,fmsg,projectId,projectName,userCnt;<br>
 * 表 xm_task_sbill 任务结算表的所有字段名: <br>
 *	id,title,amt,ctime,cuserid,cusername,remark,branch_id,deptid,cp_id,cp_name,workload,biz_month,biz_date,biz_flow_state,biz_proc_inst_id,ltime,status,fmsg,project_id,project_name,user_cnt;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="任务结算表")
public class XmTaskSbill  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="结算单据编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="结算单标题",allowEmptyValue=true,example="",allowableValues="")
	String title;
	
	@ApiModelProperty(notes="金额=工时表中结算金额之和",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal amt;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="创建人编号",allowEmptyValue=true,example="",allowableValues="")
	String cuserid;
	
	@ApiModelProperty(notes="创建人姓名",allowEmptyValue=true,example="",allowableValues="")
	String cusername;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="机构编号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="部门编号",allowEmptyValue=true,example="",allowableValues="")
	String deptid;
	
	@ApiModelProperty(notes="相对方编号(机构写机构号，个人写个人编号)",allowEmptyValue=true,example="",allowableValues="")
	String cpId;
	
	@ApiModelProperty(notes="相对方名称（机构写机构名称，个人写个人名称）",allowEmptyValue=true,example="",allowableValues="")
	String cpName;
	
	@ApiModelProperty(notes="结算工作量=工时表中工时之和",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal workload;
	
	@ApiModelProperty(notes="业务月份yyyy-MM",allowEmptyValue=true,example="",allowableValues="")
	String bizMonth;
	
	@ApiModelProperty(notes="业务日期yyyy-MM-dd",allowEmptyValue=true,example="",allowableValues="")
	String bizDate;
	
	@ApiModelProperty(notes="结算流程状态：0初始1审批中2审批通过3审批不通过4流程取消或者删除",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;
	
	@ApiModelProperty(notes="结算流程实例",allowEmptyValue=true,example="",allowableValues="")
	String bizProcInstId;
	
	@ApiModelProperty(notes="更新时间",allowEmptyValue=true,example="",allowableValues="")
	Date ltime;
	
	@ApiModelProperty(notes="0-待提交，1-已提交，2-已通过，3-已付款，4-已完成",allowEmptyValue=true,example="",allowableValues="")
	String status;
	
	@ApiModelProperty(notes="最后审核意见",allowEmptyValue=true,example="",allowableValues="")
	String fmsg;
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="项目名称",allowEmptyValue=true,example="",allowableValues="")
	String projectName;
	
	@ApiModelProperty(notes="结算人数",allowEmptyValue=true,example="",allowableValues="")
	Integer userCnt;

	/**结算单据编号**/
	public XmTaskSbill(String id) {
		this.id = id;
	}
    
    /**任务结算表**/
	public XmTaskSbill() {
	}
	
	/**
	 * 结算单据编号
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 结算单标题
	 **/
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 金额=工时表中结算金额之和
	 **/
	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}
	/**
	 * 创建时间
	 **/
	public void setCtime(Date ctime) {
		this.ctime = ctime;
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
	 * 备注
	 **/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 机构编号
	 **/
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	/**
	 * 部门编号
	 **/
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	/**
	 * 相对方编号(机构写机构号，个人写个人编号)
	 **/
	public void setCpId(String cpId) {
		this.cpId = cpId;
	}
	/**
	 * 相对方名称（机构写机构名称，个人写个人名称）
	 **/
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	/**
	 * 结算工作量=工时表中工时之和
	 **/
	public void setWorkload(BigDecimal workload) {
		this.workload = workload;
	}
	/**
	 * 业务月份yyyy-MM
	 **/
	public void setBizMonth(String bizMonth) {
		this.bizMonth = bizMonth;
	}
	/**
	 * 业务日期yyyy-MM-dd
	 **/
	public void setBizDate(String bizDate) {
		this.bizDate = bizDate;
	}
	/**
	 * 结算流程状态：0初始1审批中2审批通过3审批不通过4流程取消或者删除
	 **/
	public void setBizFlowState(String bizFlowState) {
		this.bizFlowState = bizFlowState;
	}
	/**
	 * 结算流程实例
	 **/
	public void setBizProcInstId(String bizProcInstId) {
		this.bizProcInstId = bizProcInstId;
	}
	/**
	 * 更新时间
	 **/
	public void setLtime(Date ltime) {
		this.ltime = ltime;
	}
	/**
	 * 0-待提交，1-已提交，2-已通过，3-已付款，4-已完成
	 **/
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 最后审核意见
	 **/
	public void setFmsg(String fmsg) {
		this.fmsg = fmsg;
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
	 * 结算人数
	 **/
	public void setUserCnt(Integer userCnt) {
		this.userCnt = userCnt;
	}
	
	/**
	 * 结算单据编号
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 结算单标题
	 **/
	public String getTitle() {
		return this.title;
	}
	/**
	 * 金额=工时表中结算金额之和
	 **/
	public BigDecimal getAmt() {
		return this.amt;
	}
	/**
	 * 创建时间
	 **/
	public Date getCtime() {
		return this.ctime;
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
	 * 备注
	 **/
	public String getRemark() {
		return this.remark;
	}
	/**
	 * 机构编号
	 **/
	public String getBranchId() {
		return this.branchId;
	}
	/**
	 * 部门编号
	 **/
	public String getDeptid() {
		return this.deptid;
	}
	/**
	 * 相对方编号(机构写机构号，个人写个人编号)
	 **/
	public String getCpId() {
		return this.cpId;
	}
	/**
	 * 相对方名称（机构写机构名称，个人写个人名称）
	 **/
	public String getCpName() {
		return this.cpName;
	}
	/**
	 * 结算工作量=工时表中工时之和
	 **/
	public BigDecimal getWorkload() {
		return this.workload;
	}
	/**
	 * 业务月份yyyy-MM
	 **/
	public String getBizMonth() {
		return this.bizMonth;
	}
	/**
	 * 业务日期yyyy-MM-dd
	 **/
	public String getBizDate() {
		return this.bizDate;
	}
	/**
	 * 结算流程状态：0初始1审批中2审批通过3审批不通过4流程取消或者删除
	 **/
	public String getBizFlowState() {
		return this.bizFlowState;
	}
	/**
	 * 结算流程实例
	 **/
	public String getBizProcInstId() {
		return this.bizProcInstId;
	}
	/**
	 * 更新时间
	 **/
	public Date getLtime() {
		return this.ltime;
	}
	/**
	 * 0-待提交，1-已提交，2-已通过，3-已付款，4-已完成
	 **/
	public String getStatus() {
		return this.status;
	}
	/**
	 * 最后审核意见
	 **/
	public String getFmsg() {
		return this.fmsg;
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
	 * 结算人数
	 **/
	public Integer getUserCnt() {
		return this.userCnt;
	}

}