package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmIterationLink所有属性名: <br>
 *	iterationId,proId,ctime,cuserid,cusername,linkStatus,ltype;<br>
 * 表 xm_iteration_link 迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表的所有字段名: <br>
 *	iteration_id,pro_id,ctime,cuserid,cusername,link_status,ltype;<br>
 * 当前主键(包括多主键):<br>
 *	iteration_id,pro_id;<br>
 */
@ApiModel(description="迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表")
public class XmIterationLink  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="迭代表主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String iterationId;
	
	@ApiModelProperty(notes="产品/或者项目表主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String proId;
  	
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="创建人编号",allowEmptyValue=true,example="",allowableValues="")
	String cuserid;
	
	@ApiModelProperty(notes="创建人姓名",allowEmptyValue=true,example="",allowableValues="")
	String cusername;
	
	@ApiModelProperty(notes="关联状态1关联0取消关联",allowEmptyValue=true,example="",allowableValues="")
	String linkStatus;
	
	@ApiModelProperty(notes="关联类型0-项目，1-产品",allowEmptyValue=true,example="",allowableValues="")
	String ltype;

	/**迭代表主键,产品或者项目表主键**/
	public XmIterationLink(String iterationId,String proId) {
		this.iterationId = iterationId;
		this.proId = proId;
	}
    
    /**迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表**/
	public XmIterationLink() {
	}
	
	/**
	 * 迭代表主键
	 **/
	public void setIterationId(String iterationId) {
		this.iterationId = iterationId;
	}
	/**
	 * 产品\或者项目表主键
	 **/
	public void setProId(String proId) {
		this.proId = proId;
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
	 * 关联类型0-项目，1-产品
	 **/
	public void setLtype(String ltype) {
		this.ltype = ltype;
	}
	
	/**
	 * 迭代表主键
	 **/
	public String getIterationId() {
		return this.iterationId;
	}
	/**
	 * 产品或者项目表主键
	 **/
	public String getProId() {
		return this.proId;
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
	/**
	 * 关联类型0-项目，1-产品
	 **/
	public String getLtype() {
		return this.ltype;
	}

}