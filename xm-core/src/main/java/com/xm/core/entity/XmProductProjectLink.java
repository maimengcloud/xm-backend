package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmProductProjectLink所有属性名: <br>
 *	projectId,productId,ctime,cuserid,cusername,linkStatus;<br>
 * 表 XM.xm_product_project_link 产品与项目的关联关系表，一般由产品经理挂接项目到产品上的所有字段名: <br>
 *	project_id,product_id,ctime,cuserid,cusername,link_status;<br>
 * 当前主键(包括多主键):<br>
 *	project_id,product_id;<br>
 */
@ApiModel(description="产品与项目的关联关系表，一般由产品经理挂接项目到产品上")
public class XmProductProjectLink  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="项目表中的主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="产品表中的主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String productId;
  	
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="创建人编号",allowEmptyValue=true,example="",allowableValues="")
	String cuserid;
	
	@ApiModelProperty(notes="创建人姓名",allowEmptyValue=true,example="",allowableValues="")
	String cusername;
	
	@ApiModelProperty(notes="关联状态1关联0取消关联",allowEmptyValue=true,example="",allowableValues="")
	String linkStatus;

	/**项目表中的主键,产品表中的主键**/
	public XmProductProjectLink(String projectId,String productId) {
		this.projectId = projectId;
		this.productId = productId;
	}
    
    /**产品与项目的关联关系表，一般由产品经理挂接项目到产品上**/
	public XmProductProjectLink() {
	}
	
	/**
	 * 项目表中的主键
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 产品表中的主键
	 **/
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * 创建时间
	 **/
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	/**
	 * 创建人编号
	 **/
	public void setCuserid(String cuserid) {
		this.cuserid = cuserid;
	}
	/**
	 * 创建人姓名
	 **/
	public void setCusername(String cusername) {
		this.cusername = cusername;
	}
	/**
	 * 关联状态1关联0取消关联
	 **/
	public void setLinkStatus(String linkStatus) {
		this.linkStatus = linkStatus;
	}
	
	/**
	 * 项目表中的主键
	 **/
	public String getProjectId() {
		return this.projectId;
	}
	/**
	 * 产品表中的主键
	 **/
	public String getProductId() {
		return this.productId;
	}
	/**
	 * 创建时间
	 **/
	public Date getCtime() {
		return this.ctime;
	}
	/**
	 * 创建人编号
	 **/
	public String getCuserid() {
		return this.cuserid;
	}
	/**
	 * 创建人姓名
	 **/
	public String getCusername() {
		return this.cusername;
	}
	/**
	 * 关联状态1关联0取消关联
	 **/
	public String getLinkStatus() {
		return this.linkStatus;
	}

}