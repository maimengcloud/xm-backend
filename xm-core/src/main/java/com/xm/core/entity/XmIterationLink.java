package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmIterationProductLink所有属性名: <br>
 *	iterationId,productId,ctime,cuserid,cusername,linkStatus;<br>
 * 表 XM.xm_iteration_product_link 迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表的所有字段名: <br>
 *	iteration_id,product_id,ctime,cuserid,cusername,link_status;<br>
 * 当前主键(包括多主键):<br>
 *	iteration_id,product_id;<br>
 */
@ApiModel(description="迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表")
public class XmIterationLink implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="迭代表主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String iterationId;
	
	@ApiModelProperty(notes="产品表主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String productId;
  	
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="创建人编号",allowEmptyValue=true,example="",allowableValues="")
	String cuserid;
	
	@ApiModelProperty(notes="创建人姓名",allowEmptyValue=true,example="",allowableValues="")
	String cusername;
	
	@ApiModelProperty(notes="关联状态1关联0取消关联",allowEmptyValue=true,example="",allowableValues="")
	String linkStatus;

	/**迭代表主键,产品表主键**/
	public XmIterationLink(String iterationId, String productId) {
		this.iterationId = iterationId;
		this.productId = productId;
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
	 * 产品表主键
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
	 * 迭代表主键
	 **/
	public String getIterationId() {
		return this.iterationId;
	}
	/**
	 * 产品表主键
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