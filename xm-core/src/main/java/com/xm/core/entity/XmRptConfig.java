package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmRptConfig所有属性名: <br>
 *	"bizId","业务编号","id","报告编号","name","报告名称","cuserid","创建人","cusername","创建人姓名","ctime","创建时间","cbranchId","创建机构","cfg","报告配置项";<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
 @Data
@ApiModel(description="测试报告配置表")
public class XmRptConfig  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="报告编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="业务编号",allowEmptyValue=true,example="",allowableValues="")
	String bizId;
	
	@ApiModelProperty(notes="报告名称",allowEmptyValue=true,example="",allowableValues="")
	String name;
	
	@ApiModelProperty(notes="创建人",allowEmptyValue=true,example="",allowableValues="")
	String cuserid;
	
	@ApiModelProperty(notes="创建人姓名",allowEmptyValue=true,example="",allowableValues="")
	String cusername;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="创建机构",allowEmptyValue=true,example="",allowableValues="")
	String cbranchId;
	
	@ApiModelProperty(notes="报告配置项",allowEmptyValue=true,example="",allowableValues="")
	String cfg;

	/**
	 *报告编号
	 **/
	public XmRptConfig(String id) {
		this.id = id;
	}
    
    /**
     * 测试报告配置表
     **/
	public XmRptConfig() {
	}

}