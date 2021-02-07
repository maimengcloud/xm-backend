package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com.qqkj  顶级模块 oa 大模块 xm  小模块 <br> 
 * 实体 XmExchange所有属性名: <br>
 *	taskId,taskName,projectId,remark,id,pid,cuserid,cusername,ctime,cbranchId,adopt,adoptUserid,adoptUsername,adoptTime,closed,puserid,pusername,premark,notifyUserids,notifyChannels,notifyUsernames,cuserHeadImg,replyType;<br>
 * 表 XM.xm_exchange 功能表的所有字段名: <br>
 *	task_id,task_name,project_id,remark,id,pid,cuserid,cusername,ctime,cbranch_id,adopt,adopt_userid,adopt_username,adopt_time,closed,puserid,pusername,premark,notify_userids,notify_channels,notify_usernames,cuser_head_img,reply_type;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="功能表")
public class XmExchange  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="评论编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="功能编号",allowEmptyValue=true,example="",allowableValues="")
	String taskId;
	
	@ApiModelProperty(notes="功能名称",allowEmptyValue=true,example="",allowableValues="")
	String taskName;
	
	@ApiModelProperty(notes="归属产品编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="上级评论编号",allowEmptyValue=true,example="",allowableValues="")
	String pid;
	
	@ApiModelProperty(notes="评论人编号",allowEmptyValue=true,example="",allowableValues="")
	String cuserid;
	
	@ApiModelProperty(notes="评论人名称",allowEmptyValue=true,example="",allowableValues="")
	String cusername;
	
	@ApiModelProperty(notes="评论时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="评论人所属机构",allowEmptyValue=true,example="",allowableValues="")
	String cbranchId;
	
	@ApiModelProperty(notes="是否采纳0否1采纳",allowEmptyValue=true,example="",allowableValues="")
	String adopt;
	
	@ApiModelProperty(notes="采纳人编号",allowEmptyValue=true,example="",allowableValues="")
	String adoptUserid;
	
	@ApiModelProperty(notes="采纳人名称",allowEmptyValue=true,example="",allowableValues="")
	String adoptUsername;
	
	@ApiModelProperty(notes="采纳时间",allowEmptyValue=true,example="",allowableValues="")
	Date adoptTime;
	
	@ApiModelProperty(notes="关闭该评论0否1是",allowEmptyValue=true,example="",allowableValues="")
	String closed;
	
	@ApiModelProperty(notes="上级用户编号",allowEmptyValue=true,example="",allowableValues="")
	String puserid;
	
	@ApiModelProperty(notes="上级姓名",allowEmptyValue=true,example="",allowableValues="")
	String pusername;
	
	@ApiModelProperty(notes="上级备注",allowEmptyValue=true,example="",allowableValues="")
	String premark;
	
	@ApiModelProperty(notes="本评论需要同步给的人列表,逗号分隔",allowEmptyValue=true,example="",allowableValues="")
	String notifyUserids;
	
	@ApiModelProperty(notes="发送通知渠道inner-email/wxpub/sms/im/out-email等逗号分割",allowEmptyValue=true,example="",allowableValues="")
	String notifyChannels;
	
	@ApiModelProperty(notes="通知用户姓名逗号分隔",allowEmptyValue=true,example="",allowableValues="")
	String notifyUsernames;
	
	@ApiModelProperty(notes="发言人头像地址",allowEmptyValue=true,example="",allowableValues="")
	String cuserHeadImg;
	
	@ApiModelProperty(notes="回复方式1引用2回复",allowEmptyValue=true,example="",allowableValues="")
	String replyType;

	/**评论编号**/
	public XmExchange(String id) {
		this.id = id;
	}
    
    /**功能表**/
	public XmExchange() {
	}
	
	/**
	 * 功能编号
	 **/
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	/**
	 * 功能名称
	 **/
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * 归属产品编号
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 备注
	 **/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 评论编号
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 上级评论编号
	 **/
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 评论人编号
	 **/
	public void setCuserid(String cuserid) {
		this.cuserid = cuserid;
	}
	/**
	 * 评论人名称
	 **/
	public void setCusername(String cusername) {
		this.cusername = cusername;
	}
	/**
	 * 评论时间
	 **/
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	/**
	 * 评论人所属机构
	 **/
	public void setCbranchId(String cbranchId) {
		this.cbranchId = cbranchId;
	}
	/**
	 * 是否采纳0否1采纳
	 **/
	public void setAdopt(String adopt) {
		this.adopt = adopt;
	}
	/**
	 * 采纳人编号
	 **/
	public void setAdoptUserid(String adoptUserid) {
		this.adoptUserid = adoptUserid;
	}
	/**
	 * 采纳人名称
	 **/
	public void setAdoptUsername(String adoptUsername) {
		this.adoptUsername = adoptUsername;
	}
	/**
	 * 采纳时间
	 **/
	public void setAdoptTime(Date adoptTime) {
		this.adoptTime = adoptTime;
	}
	/**
	 * 关闭该评论0否1是
	 **/
	public void setClosed(String closed) {
		this.closed = closed;
	}
	/**
	 * 上级用户编号
	 **/
	public void setPuserid(String puserid) {
		this.puserid = puserid;
	}
	/**
	 * 上级姓名
	 **/
	public void setPusername(String pusername) {
		this.pusername = pusername;
	}
	/**
	 * 上级备注
	 **/
	public void setPremark(String premark) {
		this.premark = premark;
	}
	/**
	 * 本评论需要同步给的人列表,逗号分隔
	 **/
	public void setNotifyUserids(String notifyUserids) {
		this.notifyUserids = notifyUserids;
	}
	/**
	 * 发送通知渠道inner-email/wxpub/sms/im/out-email等逗号分割
	 **/
	public void setNotifyChannels(String notifyChannels) {
		this.notifyChannels = notifyChannels;
	}
	/**
	 * 通知用户姓名逗号分隔
	 **/
	public void setNotifyUsernames(String notifyUsernames) {
		this.notifyUsernames = notifyUsernames;
	}
	/**
	 * 发言人头像地址
	 **/
	public void setCuserHeadImg(String cuserHeadImg) {
		this.cuserHeadImg = cuserHeadImg;
	}
	/**
	 * 回复方式1引用2回复
	 **/
	public void setReplyType(String replyType) {
		this.replyType = replyType;
	}
	
	/**
	 * 功能编号
	 **/
	public String getTaskId() {
		return this.taskId;
	}
	/**
	 * 功能名称
	 **/
	public String getTaskName() {
		return this.taskName;
	}
	/**
	 * 归属产品编号
	 **/
	public String getProjectId() {
		return this.projectId;
	}
	/**
	 * 备注
	 **/
	public String getRemark() {
		return this.remark;
	}
	/**
	 * 评论编号
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 上级评论编号
	 **/
	public String getPid() {
		return this.pid;
	}
	/**
	 * 评论人编号
	 **/
	public String getCuserid() {
		return this.cuserid;
	}
	/**
	 * 评论人名称
	 **/
	public String getCusername() {
		return this.cusername;
	}
	/**
	 * 评论时间
	 **/
	public Date getCtime() {
		return this.ctime;
	}
	/**
	 * 评论人所属机构
	 **/
	public String getCbranchId() {
		return this.cbranchId;
	}
	/**
	 * 是否采纳0否1采纳
	 **/
	public String getAdopt() {
		return this.adopt;
	}
	/**
	 * 采纳人编号
	 **/
	public String getAdoptUserid() {
		return this.adoptUserid;
	}
	/**
	 * 采纳人名称
	 **/
	public String getAdoptUsername() {
		return this.adoptUsername;
	}
	/**
	 * 采纳时间
	 **/
	public Date getAdoptTime() {
		return this.adoptTime;
	}
	/**
	 * 关闭该评论0否1是
	 **/
	public String getClosed() {
		return this.closed;
	}
	/**
	 * 上级用户编号
	 **/
	public String getPuserid() {
		return this.puserid;
	}
	/**
	 * 上级姓名
	 **/
	public String getPusername() {
		return this.pusername;
	}
	/**
	 * 上级备注
	 **/
	public String getPremark() {
		return this.premark;
	}
	/**
	 * 本评论需要同步给的人列表,逗号分隔
	 **/
	public String getNotifyUserids() {
		return this.notifyUserids;
	}
	/**
	 * 发送通知渠道inner-email/wxpub/sms/im/out-email等逗号分割
	 **/
	public String getNotifyChannels() {
		return this.notifyChannels;
	}
	/**
	 * 通知用户姓名逗号分隔
	 **/
	public String getNotifyUsernames() {
		return this.notifyUsernames;
	}
	/**
	 * 发言人头像地址
	 **/
	public String getCuserHeadImg() {
		return this.cuserHeadImg;
	}
	/**
	 * 回复方式1引用2回复
	 **/
	public String getReplyType() {
		return this.replyType;
	}

}