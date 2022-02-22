package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmProjectGroup所有属性名: <br>
 *	id,groupName,projectId,pgTypeId,pgTypeName,leaderUserid,leaderUsername,ctime,ltime,productId,branchId,pgClass;<br>
 * 表 xm_project_group xm_project_group的所有字段名: <br>
 *	id,group_name,project_id,pg_type_id,pg_type_name,leader_userid,leader_username,ctime,ltime,product_id,branch_id,pg_class;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_project_group")
public class XmProjectGroup  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="团队名称",allowEmptyValue=true,example="",allowableValues="")
	String groupName;
	
	@ApiModelProperty(notes="项目编号-属于产品线则可为空",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="项目团队类型编号",allowEmptyValue=true,example="",allowableValues="")
	String pgTypeId;
	
	@ApiModelProperty(notes="团队类型名称",allowEmptyValue=true,example="",allowableValues="")
	String pgTypeName;
	
	@ApiModelProperty(notes="团队负责人",allowEmptyValue=true,example="",allowableValues="")
	String leaderUserid;
	
	@ApiModelProperty(notes="负责人姓名",allowEmptyValue=true,example="",allowableValues="")
	String leaderUsername;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="更新时间",allowEmptyValue=true,example="",allowableValues="")
	Date ltime;
	
	@ApiModelProperty(notes="产品编号，属于项目组的团队则可为空",allowEmptyValue=true,example="",allowableValues="")
	String productId;
	
	@ApiModelProperty(notes="机构编号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="团队类别0项目1产品",allowEmptyValue=true,example="",allowableValues="")
	String pgClass;

	/**主键**/
	public XmProjectGroup(String id) {
		this.id = id;
	}
    
    /**xm_project_group**/
	public XmProjectGroup() {
	}
	
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 团队名称
	 **/
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/**
	 * 项目编号-属于产品线则可为空
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 项目团队类型编号
	 **/
	public void setPgTypeId(String pgTypeId) {
		this.pgTypeId = pgTypeId;
	}
	/**
	 * 团队类型名称
	 **/
	public void setPgTypeName(String pgTypeName) {
		this.pgTypeName = pgTypeName;
	}
	/**
	 * 团队负责人
	 **/
	public void setLeaderUserid(String leaderUserid) {
		this.leaderUserid = leaderUserid;
	}
	/**
	 * 负责人姓名
	 **/
	public void setLeaderUsername(String leaderUsername) {
		this.leaderUsername = leaderUsername;
	}
	/**
	 * 创建时间
	 **/
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	/**
	 * 更新时间
	 **/
	public void setLtime(Date ltime) {
		this.ltime = ltime;
	}
	/**
	 * 产品编号，属于项目组的团队则可为空
	 **/
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * 机构编号
	 **/
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	/**
	 * 团队类别0项目1产品
	 **/
	public void setPgClass(String pgClass) {
		this.pgClass = pgClass;
	}
	
	/**
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 团队名称
	 **/
	public String getGroupName() {
		return this.groupName;
	}
	/**
	 * 项目编号-属于产品线则可为空
	 **/
	public String getProjectId() {
		return this.projectId;
	}
	/**
	 * 项目团队类型编号
	 **/
	public String getPgTypeId() {
		return this.pgTypeId;
	}
	/**
	 * 团队类型名称
	 **/
	public String getPgTypeName() {
		return this.pgTypeName;
	}
	/**
	 * 团队负责人
	 **/
	public String getLeaderUserid() {
		return this.leaderUserid;
	}
	/**
	 * 负责人姓名
	 **/
	public String getLeaderUsername() {
		return this.leaderUsername;
	}
	/**
	 * 创建时间
	 **/
	public Date getCtime() {
		return this.ctime;
	}
	/**
	 * 更新时间
	 **/
	public Date getLtime() {
		return this.ltime;
	}
	/**
	 * 产品编号，属于项目组的团队则可为空
	 **/
	public String getProductId() {
		return this.productId;
	}
	/**
	 * 机构编号
	 **/
	public String getBranchId() {
		return this.branchId;
	}
	/**
	 * 团队类别0项目1产品
	 **/
	public String getPgClass() {
		return this.pgClass;
	}

}