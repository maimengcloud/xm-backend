package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmProjectGroup所有属性名: <br>
 *	id,groupName,projectId,pgTypeId,pgTypeName,leaderUserid,leaderUsername,ctime,ltime,productId,branchId,pgClass,pgroupId,lvl,pidPaths,isTpl,assUserid,assUsername,childrenCnt,userCnt,qxCode,calcWorkload,ntype,crowBranchId,crowBranchName,isCrow;<br>
 * 表 xm_group xm_group的所有字段名: <br>
 *	id,group_name,project_id,pg_type_id,pg_type_name,leader_userid,leader_username,ctime,ltime,product_id,branch_id,pg_class,pgroup_id,lvl,pid_paths,is_tpl,ass_userid,ass_username,children_cnt,user_cnt,qx_code,calc_workload,ntype,crow_branch_id,crow_branch_name,is_crow;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_group")
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
	
	@ApiModelProperty(notes="上级团队编号",allowEmptyValue=true,example="",allowableValues="")
	String pgroupId;
	
	@ApiModelProperty(notes="级别0级1级2级3级4级",allowEmptyValue=true,example="",allowableValues="")
	Integer lvl;
	
	@ApiModelProperty(notes="上级编号路径逗号分割,0,开始，本组编号+逗号结束",allowEmptyValue=true,example="",allowableValues="")
	String pidPaths;
	
	@ApiModelProperty(notes="是否为模板",allowEmptyValue=true,example="",allowableValues="")
	String isTpl;
	
	@ApiModelProperty(notes="副组长编号",allowEmptyValue=true,example="",allowableValues="")
	String assUserid;
	
	@ApiModelProperty(notes="副组长姓名",allowEmptyValue=true,example="",allowableValues="")
	String assUsername;
	
	@ApiModelProperty(notes="下级团队数量",allowEmptyValue=true,example="",allowableValues="")
	Integer childrenCnt;
	
	@ApiModelProperty(notes="组员数量",allowEmptyValue=true,example="",allowableValues="")
	Integer userCnt;
	
	@ApiModelProperty(notes="权限码",allowEmptyValue=true,example="",allowableValues="")
	String qxCode;
	
	@ApiModelProperty(notes="是否计算工作量0否1是",allowEmptyValue=true,example="",allowableValues="")
	String calcWorkload;
	
	@ApiModelProperty(notes="节点类型0管理团队、1执行团队",allowEmptyValue=true,example="",allowableValues="")
	String ntype;
	
	@ApiModelProperty(notes="协作公司编号",allowEmptyValue=true,example="",allowableValues="")
	String crowBranchId;
	
	@ApiModelProperty(notes="协作公司名称",allowEmptyValue=true,example="",allowableValues="")
	String crowBranchName;
	
	@ApiModelProperty(notes="是否众包团队",allowEmptyValue=true,example="",allowableValues="")
	String isCrow;

	/**主键**/
	public XmProjectGroup(String id) {
		this.id = id;
	}
    
    /**xm_group**/
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
	 * 上级团队编号
	 **/
	public void setPgroupId(String pgroupId) {
		this.pgroupId = pgroupId;
	}
	/**
	 * 级别0级1级2级3级4级
	 **/
	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}
	/**
	 * 上级编号路径逗号分割,0,开始，本组编号+逗号结束
	 **/
	public void setPidPaths(String pidPaths) {
		this.pidPaths = pidPaths;
	}
	/**
	 * 是否为模板
	 **/
	public void setIsTpl(String isTpl) {
		this.isTpl = isTpl;
	}
	/**
	 * 副组长编号
	 **/
	public void setAssUserid(String assUserid) {
		this.assUserid = assUserid;
	}
	/**
	 * 副组长姓名
	 **/
	public void setAssUsername(String assUsername) {
		this.assUsername = assUsername;
	}
	/**
	 * 下级团队数量
	 **/
	public void setChildrenCnt(Integer childrenCnt) {
		this.childrenCnt = childrenCnt;
	}
	/**
	 * 组员数量
	 **/
	public void setUserCnt(Integer userCnt) {
		this.userCnt = userCnt;
	}
	/**
	 * 权限码
	 **/
	public void setQxCode(String qxCode) {
		this.qxCode = qxCode;
	}
	/**
	 * 是否计算工作量0否1是
	 **/
	public void setCalcWorkload(String calcWorkload) {
		this.calcWorkload = calcWorkload;
	}
	/**
	 * 节点类型0管理团队、1执行团队
	 **/
	public void setNtype(String ntype) {
		this.ntype = ntype;
	}
	/**
	 * 协作公司编号
	 **/
	public void setCrowBranchId(String crowBranchId) {
		this.crowBranchId = crowBranchId;
	}
	/**
	 * 协作公司名称
	 **/
	public void setCrowBranchName(String crowBranchName) {
		this.crowBranchName = crowBranchName;
	}
	/**
	 * 是否众包团队
	 **/
	public void setIsCrow(String isCrow) {
		this.isCrow = isCrow;
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
	/**
	 * 上级团队编号
	 **/
	public String getPgroupId() {
		return this.pgroupId;
	}
	/**
	 * 级别0级1级2级3级4级
	 **/
	public Integer getLvl() {
		return this.lvl;
	}
	/**
	 * 上级编号路径逗号分割,0,开始，本组编号+逗号结束
	 **/
	public String getPidPaths() {
		return this.pidPaths;
	}
	/**
	 * 是否为模板
	 **/
	public String getIsTpl() {
		return this.isTpl;
	}
	/**
	 * 副组长编号
	 **/
	public String getAssUserid() {
		return this.assUserid;
	}
	/**
	 * 副组长姓名
	 **/
	public String getAssUsername() {
		return this.assUsername;
	}
	/**
	 * 下级团队数量
	 **/
	public Integer getChildrenCnt() {
		return this.childrenCnt;
	}
	/**
	 * 组员数量
	 **/
	public Integer getUserCnt() {
		return this.userCnt;
	}
	/**
	 * 权限码
	 **/
	public String getQxCode() {
		return this.qxCode;
	}
	/**
	 * 是否计算工作量0否1是
	 **/
	public String getCalcWorkload() {
		return this.calcWorkload;
	}
	/**
	 * 节点类型0管理团队、1执行团队
	 **/
	public String getNtype() {
		return this.ntype;
	}
	/**
	 * 协作公司编号
	 **/
	public String getCrowBranchId() {
		return this.crowBranchId;
	}
	/**
	 * 协作公司名称
	 **/
	public String getCrowBranchName() {
		return this.crowBranchName;
	}
	/**
	 * 是否众包团队
	 **/
	public String getIsCrow() {
		return this.isCrow;
	}

}