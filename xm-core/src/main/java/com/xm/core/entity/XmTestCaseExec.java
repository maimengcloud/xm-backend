package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com.qqkj  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmTestCaseExec所有属性名: <br>
 *	execUserid,startTime,id,projectId,projectName,caseId,caseName,endTime,remark,createUserid,createUsername,createTime,execStatus,iterationId,iterationName,execUsername,taskId,taskName,menuId,menuName;<br>
 * 表 XM.xm_test_case_exec xm_test_case_exec的所有字段名: <br>
 *	exec_userid,start_time,id,project_id,project_name,case_id,case_name,end_time,remark,create_userid,create_username,create_time,exec_status,iteration_id,iteration_name,exec_username,task_id,task_name,menu_id,menu_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_test_case_exec")
public class XmTestCaseExec  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="执行编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="执行人",allowEmptyValue=true,example="",allowableValues="")
	String execUserid;
	
	@ApiModelProperty(notes="开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date startTime;
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="项目名称",allowEmptyValue=true,example="",allowableValues="")
	String projectName;
	
	@ApiModelProperty(notes="测试案例编号",allowEmptyValue=true,example="",allowableValues="")
	String caseId;
	
	@ApiModelProperty(notes="测试案例名称",allowEmptyValue=true,example="",allowableValues="")
	String caseName;
	
	@ApiModelProperty(notes="到期时间",allowEmptyValue=true,example="",allowableValues="")
	Date endTime;
	
	@ApiModelProperty(notes="问题描述",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="问题创建人编号",allowEmptyValue=true,example="",allowableValues="")
	String createUserid;
	
	@ApiModelProperty(notes="问题创建人",allowEmptyValue=true,example="",allowableValues="")
	String createUsername;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date createTime;
	
	@ApiModelProperty(notes="0新建1测试中2已完成",allowEmptyValue=true,example="",allowableValues="")
	String execStatus;
	
	@ApiModelProperty(notes="迭代编号",allowEmptyValue=true,example="",allowableValues="")
	String iterationId;
	
	@ApiModelProperty(notes="迭代名称",allowEmptyValue=true,example="",allowableValues="")
	String iterationName;
	
	@ApiModelProperty(notes="执行人姓名",allowEmptyValue=true,example="",allowableValues="")
	String execUsername;
	
	@ApiModelProperty(notes="归属测试任务编号",allowEmptyValue=true,example="",allowableValues="")
	String taskId;
	
	@ApiModelProperty(notes="归属测试任务名称",allowEmptyValue=true,example="",allowableValues="")
	String taskName;
	
	@ApiModelProperty(notes="故事编号",allowEmptyValue=true,example="",allowableValues="")
	String menuId;
	
	@ApiModelProperty(notes="故事名称",allowEmptyValue=true,example="",allowableValues="")
	String menuName;

	/**执行编号**/
	public XmTestCaseExec(String id) {
		this.id = id;
	}
    
    /**xm_test_case_exec**/
	public XmTestCaseExec() {
	}
	
	/**
	 * 执行人
	 **/
	public void setExecUserid(String execUserid) {
		this.execUserid = execUserid;
	}
	/**
	 * 开始时间
	 **/
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 执行编号
	 **/
	public void setId(String id) {
		this.id = id;
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
	 * 测试案例编号
	 **/
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	/**
	 * 测试案例名称
	 **/
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	/**
	 * 到期时间
	 **/
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 问题描述
	 **/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 问题创建人编号
	 **/
	public void setCreateUserid(String createUserid) {
		this.createUserid = createUserid;
	}
	/**
	 * 问题创建人
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
	 * 0新建1测试中2已完成
	 **/
	public void setExecStatus(String execStatus) {
		this.execStatus = execStatus;
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
	 * 执行人姓名
	 **/
	public void setExecUsername(String execUsername) {
		this.execUsername = execUsername;
	}
	/**
	 * 归属测试任务编号
	 **/
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	/**
	 * 归属测试任务名称
	 **/
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * 故事编号
	 **/
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	/**
	 * 故事名称
	 **/
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	/**
	 * 执行人
	 **/
	public String getExecUserid() {
		return this.execUserid;
	}
	/**
	 * 开始时间
	 **/
	public Date getStartTime() {
		return this.startTime;
	}
	/**
	 * 执行编号
	 **/
	public String getId() {
		return this.id;
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
	 * 测试案例编号
	 **/
	public String getCaseId() {
		return this.caseId;
	}
	/**
	 * 测试案例名称
	 **/
	public String getCaseName() {
		return this.caseName;
	}
	/**
	 * 到期时间
	 **/
	public Date getEndTime() {
		return this.endTime;
	}
	/**
	 * 问题描述
	 **/
	public String getRemark() {
		return this.remark;
	}
	/**
	 * 问题创建人编号
	 **/
	public String getCreateUserid() {
		return this.createUserid;
	}
	/**
	 * 问题创建人
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
	 * 0新建1测试中2已完成
	 **/
	public String getExecStatus() {
		return this.execStatus;
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
	 * 执行人姓名
	 **/
	public String getExecUsername() {
		return this.execUsername;
	}
	/**
	 * 归属测试任务编号
	 **/
	public String getTaskId() {
		return this.taskId;
	}
	/**
	 * 归属测试任务名称
	 **/
	public String getTaskName() {
		return this.taskName;
	}
	/**
	 * 故事编号
	 **/
	public String getMenuId() {
		return this.menuId;
	}
	/**
	 * 故事名称
	 **/
	public String getMenuName() {
		return this.menuName;
	}

}