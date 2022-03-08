package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmProjectGroupUser所有属性名: <br>
 *	joinTime,groupId,userid,username,outTime,status,obranchId,isPri,seqNo,projectId,productId,pgClass,obranchName;<br>
 * 表 xm_group_user xm_group_user的所有字段名: <br>
 *	join_time,group_id,userid,username,out_time,status,obranch_id,is_pri,seq_no,project_id,product_id,pg_class,obranch_name;<br>
 * 当前主键(包括多主键):<br>
 *	group_id,userid;<br>
 */
@ApiModel(description="xm_group_user")
public class XmProjectGroupUser  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="团队编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String groupId;
	
	@ApiModelProperty(notes="团队成员编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String userid;
  	
	
	@ApiModelProperty(notes="加入时间",allowEmptyValue=true,example="",allowableValues="")
	Date joinTime;
	
	@ApiModelProperty(notes="团队成员",allowEmptyValue=true,example="",allowableValues="")
	String username;
	
	@ApiModelProperty(notes="离队时间",allowEmptyValue=true,example="",allowableValues="")
	Date outTime;
	
	@ApiModelProperty(notes="当前状态0参与中1已退出团队",allowEmptyValue=true,example="",allowableValues="")
	String status;
	
	@ApiModelProperty(notes="组员原归属机构编号",allowEmptyValue=true,example="",allowableValues="")
	String obranchId;
	
	@ApiModelProperty(notes="是否私人加入0否1是",allowEmptyValue=true,example="",allowableValues="")
	String isPri;
	
	@ApiModelProperty(notes="排序号--从1开始",allowEmptyValue=true,example="",allowableValues="")
	Integer seqNo;
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="产品编号",allowEmptyValue=true,example="",allowableValues="")
	String productId;
	
	@ApiModelProperty(notes="0-项目，1-产品",allowEmptyValue=true,example="",allowableValues="")
	String pgClass;
	
	@ApiModelProperty(notes="原归属机构名称",allowEmptyValue=true,example="",allowableValues="")
	String obranchName;

	/**团队编号,团队成员编号**/
	public XmProjectGroupUser(String groupId,String userid) {
		this.groupId = groupId;
		this.userid = userid;
	}
    
    /**xm_group_user**/
	public XmProjectGroupUser() {
	}
	
	/**
	 * 加入时间
	 **/
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
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
	 * 组员原归属机构编号
	 **/
	public void setObranchId(String obranchId) {
		this.obranchId = obranchId;
	}
	/**
	 * 是否私人加入0否1是
	 **/
	public void setIsPri(String isPri) {
		this.isPri = isPri;
	}
	/**
	 * 排序号--从1开始
	 **/
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
	/**
	 * 项目编号
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 产品编号
	 **/
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * 0-项目，1-产品
	 **/
	public void setPgClass(String pgClass) {
		this.pgClass = pgClass;
	}
	/**
	 * 原归属机构名称
	 **/
	public void setObranchName(String obranchName) {
		this.obranchName = obranchName;
	}
	
	/**
	 * 加入时间
	 **/
	public Date getJoinTime() {
		return this.joinTime;
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
	 * 组员原归属机构编号
	 **/
	public String getObranchId() {
		return this.obranchId;
	}
	/**
	 * 是否私人加入0否1是
	 **/
	public String getIsPri() {
		return this.isPri;
	}
	/**
	 * 排序号--从1开始
	 **/
	public Integer getSeqNo() {
		return this.seqNo;
	}
	/**
	 * 项目编号
	 **/
	public String getProjectId() {
		return this.projectId;
	}
	/**
	 * 产品编号
	 **/
	public String getProductId() {
		return this.productId;
	}
	/**
	 * 0-项目，1-产品
	 **/
	public String getPgClass() {
		return this.pgClass;
	}
	/**
	 * 原归属机构名称
	 **/
	public String getObranchName() {
		return this.obranchName;
	}

}