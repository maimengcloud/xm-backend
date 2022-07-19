package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmFunc所有属性名: <br>
 *	"id","主键","name","名称","pid","上级编号","pname","上级名称","pidPaths","上级路径，直到自身，逗号分割，包含自身","productId","产品编号","lvl","菜单级别0-根，1，2，3，4，5依次类推";<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
 @Data
@ApiModel(description="功能模块表")
public class XmFunc  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="名称",allowEmptyValue=true,example="",allowableValues="")
	String name;
	
	@ApiModelProperty(notes="上级编号",allowEmptyValue=true,example="",allowableValues="")
	String pid;
	
	@ApiModelProperty(notes="上级名称",allowEmptyValue=true,example="",allowableValues="")
	String pname;
	
	@ApiModelProperty(notes="上级路径，直到自身，逗号分割，包含自身",allowEmptyValue=true,example="",allowableValues="")
	String pidPaths;
	
	@ApiModelProperty(notes="产品编号",allowEmptyValue=true,example="",allowableValues="")
	String productId;
	
	@ApiModelProperty(notes="菜单级别0-根，1，2，3，4，5依次类推",allowEmptyValue=true,example="",allowableValues="")
	Integer lvl;

	/**
	 *主键
	 **/
	public XmFunc(String id) {
		this.id = id;
	}
    
    /**
     * 功能模块表
     **/
	public XmFunc() {
	}

}