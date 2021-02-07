package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com.qqkj  顶级模块 oa 大模块 xm  小模块 <br> 
 * 实体 XmProjectEnvList所有属性名: <br>
 *	id,remark,ipAddress,port,projectId,projectName,accessUserid,accessPassword,effect,accessUrl,webIpAddress,webPort,otherRemark,createUserid,createUsername,createTime,bizProcInstId,bizFlowState;<br>
 * 表 XM.xm_project_env_list xm_project_env_list的所有字段名: <br>
 *	id,remark,ip_address,port,project_id,project_name,access_userid,access_password,effect,access_url,web_ip_address,web_port,other_remark,create_userid,create_username,create_time,biz_proc_inst_id,biz_flow_state;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_project_env_list")
public class XmProjectEnvList  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="备注说明",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="ip地址",allowEmptyValue=true,example="",allowableValues="")
	String ipAddress;
	
	@ApiModelProperty(notes="访问端口",allowEmptyValue=true,example="",allowableValues="")
	String port;
	
	@ApiModelProperty(notes="归属项目组",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="归属项目组名称",allowEmptyValue=true,example="",allowableValues="")
	String projectName;
	
	@ApiModelProperty(notes="访问用户编号",allowEmptyValue=true,example="",allowableValues="")
	String accessUserid;
	
	@ApiModelProperty(notes="访问密码",allowEmptyValue=true,example="",allowableValues="")
	String accessPassword;
	
	@ApiModelProperty(notes="作用说明",allowEmptyValue=true,example="",allowableValues="")
	String effect;
	
	@ApiModelProperty(notes="访问链接",allowEmptyValue=true,example="",allowableValues="")
	String accessUrl;
	
	@ApiModelProperty(notes="外网ip地址",allowEmptyValue=true,example="",allowableValues="")
	String webIpAddress;
	
	@ApiModelProperty(notes="外网端口",allowEmptyValue=true,example="",allowableValues="")
	String webPort;
	
	@ApiModelProperty(notes="其它说明",allowEmptyValue=true,example="",allowableValues="")
	String otherRemark;
	
	@ApiModelProperty(notes="添加人员",allowEmptyValue=true,example="",allowableValues="")
	String createUserid;
	
	@ApiModelProperty(notes="添加人员姓名",allowEmptyValue=true,example="",allowableValues="")
	String createUsername;
	
	@ApiModelProperty(notes="添加时间",allowEmptyValue=true,example="",allowableValues="")
	Date createTime;
	
	@ApiModelProperty(notes="当前流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String bizProcInstId;
	
	@ApiModelProperty(notes="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;

	/**主键**/
	public XmProjectEnvList(String id) {
		this.id = id;
	}
    
    /**xm_project_env_list**/
	public XmProjectEnvList() {
	}
	
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 备注说明
	 **/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * ip地址
	 **/
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	/**
	 * 访问端口
	 **/
	public void setPort(String port) {
		this.port = port;
	}
	/**
	 * 归属项目组
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 归属项目组名称
	 **/
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 访问用户编号
	 **/
	public void setAccessUserid(String accessUserid) {
		this.accessUserid = accessUserid;
	}
	/**
	 * 访问密码
	 **/
	public void setAccessPassword(String accessPassword) {
		this.accessPassword = accessPassword;
	}
	/**
	 * 作用说明
	 **/
	public void setEffect(String effect) {
		this.effect = effect;
	}
	/**
	 * 访问链接
	 **/
	public void setAccessUrl(String accessUrl) {
		this.accessUrl = accessUrl;
	}
	/**
	 * 外网ip地址
	 **/
	public void setWebIpAddress(String webIpAddress) {
		this.webIpAddress = webIpAddress;
	}
	/**
	 * 外网端口
	 **/
	public void setWebPort(String webPort) {
		this.webPort = webPort;
	}
	/**
	 * 其它说明
	 **/
	public void setOtherRemark(String otherRemark) {
		this.otherRemark = otherRemark;
	}
	/**
	 * 添加人员
	 **/
	public void setCreateUserid(String createUserid) {
		this.createUserid = createUserid;
	}
	/**
	 * 添加人员姓名
	 **/
	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}
	/**
	 * 添加时间
	 **/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 备注说明
	 **/
	public String getRemark() {
		return this.remark;
	}
	/**
	 * ip地址
	 **/
	public String getIpAddress() {
		return this.ipAddress;
	}
	/**
	 * 访问端口
	 **/
	public String getPort() {
		return this.port;
	}
	/**
	 * 归属项目组
	 **/
	public String getProjectId() {
		return this.projectId;
	}
	/**
	 * 归属项目组名称
	 **/
	public String getProjectName() {
		return this.projectName;
	}
	/**
	 * 访问用户编号
	 **/
	public String getAccessUserid() {
		return this.accessUserid;
	}
	/**
	 * 访问密码
	 **/
	public String getAccessPassword() {
		return this.accessPassword;
	}
	/**
	 * 作用说明
	 **/
	public String getEffect() {
		return this.effect;
	}
	/**
	 * 访问链接
	 **/
	public String getAccessUrl() {
		return this.accessUrl;
	}
	/**
	 * 外网ip地址
	 **/
	public String getWebIpAddress() {
		return this.webIpAddress;
	}
	/**
	 * 外网端口
	 **/
	public String getWebPort() {
		return this.webPort;
	}
	/**
	 * 其它说明
	 **/
	public String getOtherRemark() {
		return this.otherRemark;
	}
	/**
	 * 添加人员
	 **/
	public String getCreateUserid() {
		return this.createUserid;
	}
	/**
	 * 添加人员姓名
	 **/
	public String getCreateUsername() {
		return this.createUsername;
	}
	/**
	 * 添加时间
	 **/
	public Date getCreateTime() {
		return this.createTime;
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

}