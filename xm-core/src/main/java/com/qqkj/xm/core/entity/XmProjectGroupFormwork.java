package  com.qqkj.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 组织 com.qqkj  顶级模块 oa 大模块 xm  小模块 <br> 
 * 实体 XmProjectGroupFormwork所有属性名: <br>
 *	id,branchId,groupName,isPub,pgTypeId,pgTypeName;<br>
 * 表 XM.xm_project_group_formwork xm_project_group_formwork的所有字段名: <br>
 *	id,branch_id,group_name,is_pub,pg_type_id,pg_type_name;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_project_group_formwork")
public class XmProjectGroupFormwork  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="机构编号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="团队名称",allowEmptyValue=true,example="",allowableValues="")
	String groupName;
	
	@ApiModelProperty(notes="是否公共，0为否，1为是",allowEmptyValue=true,example="",allowableValues="")
	String isPub;
	
	@ApiModelProperty(notes="团队类型编号",allowEmptyValue=true,example="",allowableValues="")
	String pgTypeId;
	
	@ApiModelProperty(notes="团队类型名称",allowEmptyValue=true,example="",allowableValues="")
	String pgTypeName;

	/**主键**/
	public XmProjectGroupFormwork(String id) {
		this.id = id;
	}
    
    /**xm_project_group_formwork**/
	public XmProjectGroupFormwork() {
	}
	
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 机构编号
	 **/
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	/**
	 * 团队名称
	 **/
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/**
	 * 是否公共，0为否，1为是
	 **/
	public void setIsPub(String isPub) {
		this.isPub = isPub;
	}
	/**
	 * 团队类型编号
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
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 机构编号
	 **/
	public String getBranchId() {
		return this.branchId;
	}
	/**
	 * 团队名称
	 **/
	public String getGroupName() {
		return this.groupName;
	}
	/**
	 * 是否公共，0为否，1为是
	 **/
	public String getIsPub() {
		return this.isPub;
	}
	/**
	 * 团队类型编号
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

}