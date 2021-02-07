package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com.qqkj  顶级模块 oa 大模块 xm  小模块 <br> 
 * 实体 XmEnvList所有属性名: <br>
 *	id,remark,ipAddress,port,branchId,accessUserid,accessPassword,effect,accessUrl,supplier,webIpAddress,webPort,otherRemark,createUserid,createUsername,createTime,envState,startTime,endTime,feeAmount,feeRule;<br>
 * 表 XM.xm_env_list xm_env_list的所有字段名: <br>
 *	id,remark,ip_address,port,branch_id,access_userid,access_password,effect,access_url,supplier,web_ip_address,web_port,other_remark,create_userid,create_username,create_time,env_state,start_time,end_time,fee_amount,fee_rule;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_env_list")
public class XmEnvList  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="备注说明",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="内网ip地址",allowEmptyValue=true,example="",allowableValues="")
	String ipAddress;
	
	@ApiModelProperty(notes="内网访问端口",allowEmptyValue=true,example="",allowableValues="")
	String port;
	
	@ApiModelProperty(notes="归属机构",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="访问用户编号",allowEmptyValue=true,example="",allowableValues="")
	String accessUserid;
	
	@ApiModelProperty(notes="访问密码",allowEmptyValue=true,example="",allowableValues="")
	String accessPassword;
	
	@ApiModelProperty(notes="作用说明",allowEmptyValue=true,example="",allowableValues="")
	String effect;
	
	@ApiModelProperty(notes="访问链接",allowEmptyValue=true,example="",allowableValues="")
	String accessUrl;
	
	@ApiModelProperty(notes="供应商",allowEmptyValue=true,example="",allowableValues="")
	String supplier;
	
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
	
	@ApiModelProperty(notes="状态0不可用1已启用2已过期",allowEmptyValue=true,example="",allowableValues="")
	String envState;
	
	@ApiModelProperty(notes="有效日期开始",allowEmptyValue=true,example="",allowableValues="")
	Date startTime;
	
	@ApiModelProperty(notes="有效日期结束",allowEmptyValue=true,example="",allowableValues="")
	Date endTime;
	
	@ApiModelProperty(notes="费用",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal feeAmount;
	
	@ApiModelProperty(notes="计费规则",allowEmptyValue=true,example="",allowableValues="")
	String feeRule;

	/**主键**/
	public XmEnvList(String id) {
		this.id = id;
	}
    
    /**xm_env_list**/
	public XmEnvList() {
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
	 * 内网ip地址
	 **/
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	/**
	 * 内网访问端口
	 **/
	public void setPort(String port) {
		this.port = port;
	}
	/**
	 * 归属机构
	 **/
	public void setBranchId(String branchId) {
		this.branchId = branchId;
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
	 * 供应商
	 **/
	public void setSupplier(String supplier) {
		this.supplier = supplier;
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
	 * 状态0不可用1已启用2已过期
	 **/
	public void setEnvState(String envState) {
		this.envState = envState;
	}
	/**
	 * 有效日期开始
	 **/
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 有效日期结束
	 **/
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 费用
	 **/
	public void setFeeAmount(BigDecimal feeAmount) {
		this.feeAmount = feeAmount;
	}
	/**
	 * 计费规则
	 **/
	public void setFeeRule(String feeRule) {
		this.feeRule = feeRule;
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
	 * 内网ip地址
	 **/
	public String getIpAddress() {
		return this.ipAddress;
	}
	/**
	 * 内网访问端口
	 **/
	public String getPort() {
		return this.port;
	}
	/**
	 * 归属机构
	 **/
	public String getBranchId() {
		return this.branchId;
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
	 * 供应商
	 **/
	public String getSupplier() {
		return this.supplier;
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
	 * 状态0不可用1已启用2已过期
	 **/
	public String getEnvState() {
		return this.envState;
	}
	/**
	 * 有效日期开始
	 **/
	public Date getStartTime() {
		return this.startTime;
	}
	/**
	 * 有效日期结束
	 **/
	public Date getEndTime() {
		return this.endTime;
	}
	/**
	 * 费用
	 **/
	public BigDecimal getFeeAmount() {
		return this.feeAmount;
	}
	/**
	 * 计费规则
	 **/
	public String getFeeRule() {
		return this.feeRule;
	}

}