package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmIterationLink所有属性名: <br>
 *	"iterationId","迭代表主键","proId","产品或者项目表主键","ctime","创建时间","cuserid","创建人编号","cusername","创建人姓名","linkStatus","关联状态1关联0取消关联","ltype","关联类型0-项目，1-产品，为了简化，只关联产品，无须关联项目；项目通过产品关联";<br>
 * 当前主键(包括多主键):<br>
 *	iteration_id,pro_id;<br>
 */
 @Data
@ApiModel(description="迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表")
public class XmIterationLink  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="迭代表主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String iterationId;
	
	@ApiModelProperty(notes="产品或者项目表主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String proId;
  	
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="创建人编号",allowEmptyValue=true,example="",allowableValues="")
	String cuserid;
	
	@ApiModelProperty(notes="创建人姓名",allowEmptyValue=true,example="",allowableValues="")
	String cusername;
	
	@ApiModelProperty(notes="关联状态1关联0取消关联",allowEmptyValue=true,example="",allowableValues="")
	String linkStatus;
	
	@ApiModelProperty(notes="关联类型0-项目，1-产品，为了简化，只关联产品，无须关联项目；项目通过产品关联",allowEmptyValue=true,example="",allowableValues="")
	String ltype;

	/**
	 *迭代表主键,产品或者项目表主键
	 **/
	public XmIterationLink(String iterationId,String proId) {
		this.iterationId = iterationId;
		this.proId = proId;
	}
    
    /**
     * 迭代表与产品表的关联关系，一般由迭代管理员将迭代挂接到产品表
     **/
	public XmIterationLink() {
	}

}