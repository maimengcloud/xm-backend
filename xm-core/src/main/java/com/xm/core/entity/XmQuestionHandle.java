package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com.qqkj  顶级模块 oa 大模块 xm  小模块 <br> 
 * 实体 XmQuestionHandle所有属性名: <br>
 *	id,handlerUserid,handlerUsername,handleSolution,receiptMessage,receiptTime,handleStatus,bizProcInstId,bizFlowState,questionId,lastUpdateTime,createTime,actWorkload,actCostAmount,urls,targetUserid,targetUsername;<br>
 * 表 XM.xm_question_handle xm_question_handle的所有字段名: <br>
 *	id,handler_userid,handler_username,handle_solution,receipt_message,receipt_time,handle_status,biz_proc_inst_id,biz_flow_state,question_id,last_update_time,create_time,act_workload,act_cost_amount,urls,target_userid,target_username;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_question_handle")
public class XmQuestionHandle  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="处理人编号",allowEmptyValue=true,example="",allowableValues="")
	String handlerUserid;
	
	@ApiModelProperty(notes="处理人",allowEmptyValue=true,example="",allowableValues="")
	String handlerUsername;
	
	@ApiModelProperty(notes="解决方案:",allowEmptyValue=true,example="",allowableValues="")
	String handleSolution;
	
	@ApiModelProperty(notes="回执信息",allowEmptyValue=true,example="",allowableValues="")
	String receiptMessage;
	
	@ApiModelProperty(notes="回执时间",allowEmptyValue=true,example="",allowableValues="")
	Date receiptTime;
	
	@ApiModelProperty(notes="create创建（active激活）–confirm确认（confirmed已确认）–solve解决（resolved已解决）–close关闭（closed已关闭）",allowEmptyValue=true,example="",allowableValues="")
	String handleStatus;
	
	@ApiModelProperty(notes="当前流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String bizProcInstId;
	
	@ApiModelProperty(notes="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;
	
	@ApiModelProperty(notes="问题编号",allowEmptyValue=true,example="",allowableValues="")
	String questionId;
	
	@ApiModelProperty(notes="最后更新日期",allowEmptyValue=true,example="",allowableValues="")
	Date lastUpdateTime;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date createTime;
	
	@ApiModelProperty(notes="实际工时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actWorkload;
	
	@ApiModelProperty(notes="实际金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actCostAmount;
	
	@ApiModelProperty(notes="链接地址列表逗号分隔",allowEmptyValue=true,example="",allowableValues="")
	String urls;
	
	@ApiModelProperty(notes="指派给谁",allowEmptyValue=true,example="",allowableValues="")
	String targetUserid;
	
	@ApiModelProperty(notes="指派给谁",allowEmptyValue=true,example="",allowableValues="")
	String targetUsername;

	/**主键**/
	public XmQuestionHandle(String id) {
		this.id = id;
	}
    
    /**xm_question_handle**/
	public XmQuestionHandle() {
	}
	
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 处理人编号
	 **/
	public void setHandlerUserid(String handlerUserid) {
		this.handlerUserid = handlerUserid;
	}
	/**
	 * 处理人
	 **/
	public void setHandlerUsername(String handlerUsername) {
		this.handlerUsername = handlerUsername;
	}
	/**
	 * 解决方案:
	 **/
	public void setHandleSolution(String handleSolution) {
		this.handleSolution = handleSolution;
	}
	/**
	 * 回执信息
	 **/
	public void setReceiptMessage(String receiptMessage) {
		this.receiptMessage = receiptMessage;
	}
	/**
	 * 回执时间
	 **/
	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}
	/**
	 * create创建（active激活）–confirm确认（confirmed已确认）–solve解决（resolved已解决）–close关闭（closed已关闭）
	 **/
	public void setHandleStatus(String handleStatus) {
		this.handleStatus = handleStatus;
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
	 * 问题编号
	 **/
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	/**
	 * 最后更新日期
	 **/
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	/**
	 * 创建时间
	 **/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 实际工时
	 **/
	public void setActWorkload(BigDecimal actWorkload) {
		this.actWorkload = actWorkload;
	}
	/**
	 * 实际金额
	 **/
	public void setActCostAmount(BigDecimal actCostAmount) {
		this.actCostAmount = actCostAmount;
	}
	/**
	 * 链接地址列表逗号分隔
	 **/
	public void setUrls(String urls) {
		this.urls = urls;
	}
	/**
	 * 指派给谁
	 **/
	public void setTargetUserid(String targetUserid) {
		this.targetUserid = targetUserid;
	}
	/**
	 * 指派给谁
	 **/
	public void setTargetUsername(String targetUsername) {
		this.targetUsername = targetUsername;
	}
	
	/**
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 处理人编号
	 **/
	public String getHandlerUserid() {
		return this.handlerUserid;
	}
	/**
	 * 处理人
	 **/
	public String getHandlerUsername() {
		return this.handlerUsername;
	}
	/**
	 * 解决方案:
	 **/
	public String getHandleSolution() {
		return this.handleSolution;
	}
	/**
	 * 回执信息
	 **/
	public String getReceiptMessage() {
		return this.receiptMessage;
	}
	/**
	 * 回执时间
	 **/
	public Date getReceiptTime() {
		return this.receiptTime;
	}
	/**
	 * create创建（active激活）–confirm确认（confirmed已确认）–solve解决（resolved已解决）–close关闭（closed已关闭）
	 **/
	public String getHandleStatus() {
		return this.handleStatus;
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
	 * 问题编号
	 **/
	public String getQuestionId() {
		return this.questionId;
	}
	/**
	 * 最后更新日期
	 **/
	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}
	/**
	 * 创建时间
	 **/
	public Date getCreateTime() {
		return this.createTime;
	}
	/**
	 * 实际工时
	 **/
	public BigDecimal getActWorkload() {
		return this.actWorkload;
	}
	/**
	 * 实际金额
	 **/
	public BigDecimal getActCostAmount() {
		return this.actCostAmount;
	}
	/**
	 * 链接地址列表逗号分隔
	 **/
	public String getUrls() {
		return this.urls;
	}
	/**
	 * 指派给谁
	 **/
	public String getTargetUserid() {
		return this.targetUserid;
	}
	/**
	 * 指派给谁
	 **/
	public String getTargetUsername() {
		return this.targetUsername;
	}

}