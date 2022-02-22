package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmProjectGroupUser所有属性名: <br>
 *	joinTime,id,groupId,userid,username,isHead,outTime,status,bizProcInstId,bizFlowState,projectId;<br>
 * 表 xm_project_group_user xm_project_group_user的所有字段名: <br>
 *	join_time,id,group_id,userid,username,is_head,out_time,status,biz_proc_inst_id,biz_flow_state,project_id;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_project_group_user")
public class XmProjectGroupUser  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="加入时间",allowEmptyValue=true,example="",allowableValues="")
	Date joinTime;
	
	@ApiModelProperty(notes="团队编号",allowEmptyValue=true,example="",allowableValues="")
	String groupId;
	
	@ApiModelProperty(notes="团队成员编号",allowEmptyValue=true,example="",allowableValues="")
	String userid;
	
	@ApiModelProperty(notes="团队成员",allowEmptyValue=true,example="",allowableValues="")
	String username;
	
	@ApiModelProperty(notes="是否组长，1是，0否",allowEmptyValue=true,example="",allowableValues="")
	String isHead;
	
	@ApiModelProperty(notes="离队时间",allowEmptyValue=true,example="",allowableValues="")
	Date outTime;
	
	@ApiModelProperty(notes="当前状态0参与中1已退出团队",allowEmptyValue=true,example="",allowableValues="")
	String status;
	
	@ApiModelProperty(notes="当前流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String bizProcInstId;
	
	@ApiModelProperty(notes="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;

	/**主键**/
	public XmProjectGroupUser(String id) {
		this.id = id;
	}
    
    /**xm_project_group_user**/
	public XmProjectGroupUser() {
	}
	
	/**
	 * 加入时间
	 **/
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 团队编号
	 **/
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	/**
	 * 团队成员编号
	 **/
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 团队成员
	 **/
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 是否组长，1是，0否
	 **/
	public void setIsHead(String isHead) {
		this.isHead = isHead;
	}
	/**
	 * 离队时间
	 **/
	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}
	/**
	 * 当前状态0参与中1已退出团队
	 **/
	public void setStatus(String status) {
		this.status = status;
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
	 * 项目编号
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	/**
	 * 加入时间
	 **/
	public Date getJoinTime() {
		return this.joinTime;
	}
	/**
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 团队编号
	 **/
	public String getGroupId() {
		return this.groupId;
	}
	/**
	 * 团队成员编号
	 **/
	public String getUserid() {
		return this.userid;
	}
	/**
	 * 团队成员
	 **/
	public String getUsername() {
		return this.username;
	}
	/**
	 * 是否组长，1是，0否
	 **/
	public String getIsHead() {
		return this.isHead;
	}
	/**
	 * 离队时间
	 **/
	public Date getOutTime() {
		return this.outTime;
	}
	/**
	 * 当前状态0参与中1已退出团队
	 **/
	public String getStatus() {
		return this.status;
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
	 * 项目编号
	 **/
	public String getProjectId() {
		return this.projectId;
	}

}