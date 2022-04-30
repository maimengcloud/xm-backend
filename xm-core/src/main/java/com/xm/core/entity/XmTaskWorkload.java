package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmTaskWorkload所有属性名: <br>
 *	userid,username,ctime,taskId,cuserid,bizDate,wstatus,remark,ttype,id,stime,sstatus,workload,rworkload,cusername,projectId,detailId,branchId,ubranchId;<br>
 * 表 xm_task_workload 工时登记表的所有字段名: <br>
 *	userid,username,ctime,task_id,cuserid,biz_date,wstatus,remark,ttype,id,stime,sstatus,workload,rworkload,cusername,project_id,detail_id,branch_id,ubranch_id;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="工时登记表")
public class XmTaskWorkload  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="员工编号",allowEmptyValue=true,example="",allowableValues="")
	String userid;
	
	@ApiModelProperty(notes="姓名",allowEmptyValue=true,example="",allowableValues="")
	String username;
	
	@ApiModelProperty(notes="创建日期",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="业务对象主键任务编号",allowEmptyValue=true,example="",allowableValues="")
	String taskId;
	
	@ApiModelProperty(notes="创建人编号",allowEmptyValue=true,example="",allowableValues="")
	String cuserid;
	
	@ApiModelProperty(notes="业务日期yyyy-MM-dd",allowEmptyValue=true,example="",allowableValues="")
	String bizDate;
	
	@ApiModelProperty(notes="状态0-待确认，1-已确认，2-无效",allowEmptyValue=true,example="",allowableValues="")
	String wstatus;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="任务类型-关联字典taskType",allowEmptyValue=true,example="",allowableValues="")
	String ttype;
	
	@ApiModelProperty(notes="结算提交时间",allowEmptyValue=true,example="",allowableValues="")
	Date stime;
	
	@ApiModelProperty(notes="结算状态0-无需结算，1-待结算2-已提交3-已通过4-已结算",allowEmptyValue=true,example="",allowableValues="")
	String sstatus;
	
	@ApiModelProperty(notes="工时，一个task_id可多次提交，小时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal workload;
	
	@ApiModelProperty(notes="剩余工时（同一天取最后日期更新到task表budget_workload中）",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal rworkload;
	
	@ApiModelProperty(notes="创建人姓名",allowEmptyValue=true,example="",allowableValues="")
	String cusername;
	
	@ApiModelProperty(notes="归属项目",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="结算明细编号，指向xm_task_sbill_detail.id",allowEmptyValue=true,example="",allowableValues="")
	String detailId;
	
	@ApiModelProperty(notes="项目归属机构",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="用户归属机构",allowEmptyValue=true,example="",allowableValues="")
	String ubranchId;

	/**主键**/
	public XmTaskWorkload(String id) {
		this.id = id;
	}
    
    /**工时登记表**/
	public XmTaskWorkload() {
	}
	
	/**
	 * 员工编号
	 **/
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 姓名
	 **/
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 创建日期
	 **/
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	/**
	 * 业务对象主键任务编号
	 **/
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	/**
	 * 创建人编号
	 **/
	public void setCuserid(String cuserid) {
		this.cuserid = cuserid;
	}
	/**
	 * 业务日期yyyy-MM-dd
	 **/
	public void setBizDate(String bizDate) {
		this.bizDate = bizDate;
	}
	/**
	 * 状态0-待确认，1-已确认，2-无效
	 **/
	public void setWstatus(String wstatus) {
		this.wstatus = wstatus;
	}
	/**
	 * 备注
	 **/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 任务类型-关联字典taskType
	 **/
	public void setTtype(String ttype) {
		this.ttype = ttype;
	}
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 结算提交时间
	 **/
	public void setStime(Date stime) {
		this.stime = stime;
	}
	/**
	 * 结算状态0-无需结算，1-待结算2-已提交3-已通过4-已结算
	 **/
	public void setSstatus(String sstatus) {
		this.sstatus = sstatus;
	}
	/**
	 * 工时，一个task_id可多次提交，小时
	 **/
	public void setWorkload(BigDecimal workload) {
		this.workload = workload;
	}
	/**
	 * 剩余工时（同一天取最后日期更新到task表budget_workload中）
	 **/
	public void setRworkload(BigDecimal rworkload) {
		this.rworkload = rworkload;
	}
	/**
	 * 创建人姓名
	 **/
	public void setCusername(String cusername) {
		this.cusername = cusername;
	}
	/**
	 * 归属项目
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 结算明细编号，指向xm_task_sbill_detail.id
	 **/
	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}
	/**
	 * 项目归属机构
	 **/
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	/**
	 * 用户归属机构
	 **/
	public void setUbranchId(String ubranchId) {
		this.ubranchId = ubranchId;
	}
	
	/**
	 * 员工编号
	 **/
	public String getUserid() {
		return this.userid;
	}
	/**
	 * 姓名
	 **/
	public String getUsername() {
		return this.username;
	}
	/**
	 * 创建日期
	 **/
	public Date getCtime() {
		return this.ctime;
	}
	/**
	 * 业务对象主键任务编号
	 **/
	public String getTaskId() {
		return this.taskId;
	}
	/**
	 * 创建人编号
	 **/
	public String getCuserid() {
		return this.cuserid;
	}
	/**
	 * 业务日期yyyy-MM-dd
	 **/
	public String getBizDate() {
		return this.bizDate;
	}
	/**
	 * 状态0-待确认，1-已确认，2-无效
	 **/
	public String getWstatus() {
		return this.wstatus;
	}
	/**
	 * 备注
	 **/
	public String getRemark() {
		return this.remark;
	}
	/**
	 * 任务类型-关联字典taskType
	 **/
	public String getTtype() {
		return this.ttype;
	}
	/**
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 结算提交时间
	 **/
	public Date getStime() {
		return this.stime;
	}
	/**
	 * 结算状态0-无需结算，1-待结算2-已提交3-已通过4-已结算
	 **/
	public String getSstatus() {
		return this.sstatus;
	}
	/**
	 * 工时，一个task_id可多次提交，小时
	 **/
	public BigDecimal getWorkload() {
		return this.workload;
	}
	/**
	 * 剩余工时（同一天取最后日期更新到task表budget_workload中）
	 **/
	public BigDecimal getRworkload() {
		return this.rworkload;
	}
	/**
	 * 创建人姓名
	 **/
	public String getCusername() {
		return this.cusername;
	}
	/**
	 * 归属项目
	 **/
	public String getProjectId() {
		return this.projectId;
	}
	/**
	 * 结算明细编号，指向xm_task_sbill_detail.id
	 **/
	public String getDetailId() {
		return this.detailId;
	}
	/**
	 * 项目归属机构
	 **/
	public String getBranchId() {
		return this.branchId;
	}
	/**
	 * 用户归属机构
	 **/
	public String getUbranchId() {
		return this.ubranchId;
	}

}