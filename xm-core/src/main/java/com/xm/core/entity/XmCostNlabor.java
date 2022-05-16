package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmCostNlabor所有属性名: <br>
 *	"projectId","项目编号","userid","用户编号-费用主责人","ctime","创建时间","sendTime","费用发放时间","username","用户名称","projectName","项目名称","remark","备注","id","主键","taskId","任务编号","taskName","任务名称","subjectId","科目编号","bizSdate","费用归属周期开始日期","bizEdate","费用归属周期结束日期","actAt","实际成本金额","costType","成本类型0非人力1内部人力2外购人力,此表都是非人力","bizMonth","业务归属月份yyyy-MM","bizDate","业务归属日期yyyy-MM-dd","subjectName","科目名称","ubranchId","用户归属机构","branchId","项目归属机构";<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
 @Data
@ApiModel(description="项目实际人工成本费用")
public class XmCostNlabor  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="用户编号-费用主责人",allowEmptyValue=true,example="",allowableValues="")
	String userid;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="费用发放时间",allowEmptyValue=true,example="",allowableValues="")
	Date sendTime;
	
	@ApiModelProperty(notes="用户名称",allowEmptyValue=true,example="",allowableValues="")
	String username;
	
	@ApiModelProperty(notes="项目名称",allowEmptyValue=true,example="",allowableValues="")
	String projectName;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="任务编号",allowEmptyValue=true,example="",allowableValues="")
	String taskId;
	
	@ApiModelProperty(notes="任务名称",allowEmptyValue=true,example="",allowableValues="")
	String taskName;
	
	@ApiModelProperty(notes="科目编号",allowEmptyValue=true,example="",allowableValues="")
	String subjectId;
	
	@ApiModelProperty(notes="费用归属周期开始日期",allowEmptyValue=true,example="",allowableValues="")
	Date bizSdate;
	
	@ApiModelProperty(notes="费用归属周期结束日期",allowEmptyValue=true,example="",allowableValues="")
	Date bizEdate;
	
	@ApiModelProperty(notes="实际成本金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actAt;
	
	@ApiModelProperty(notes="成本类型0非人力1内部人力2外购人力,此表都是非人力",allowEmptyValue=true,example="",allowableValues="")
	String costType;
	
	@ApiModelProperty(notes="业务归属月份yyyy-MM",allowEmptyValue=true,example="",allowableValues="")
	String bizMonth;
	
	@ApiModelProperty(notes="业务归属日期yyyy-MM-dd",allowEmptyValue=true,example="",allowableValues="")
	String bizDate;
	
	@ApiModelProperty(notes="科目名称",allowEmptyValue=true,example="",allowableValues="")
	String subjectName;
	
	@ApiModelProperty(notes="用户归属机构",allowEmptyValue=true,example="",allowableValues="")
	String ubranchId;
	
	@ApiModelProperty(notes="项目归属机构",allowEmptyValue=true,example="",allowableValues="")
	String branchId;

	/**
	 *主键
	 **/
	public XmCostNlabor(String id) {
		this.id = id;
	}
    
    /**
     * 项目实际人工成本费用
     **/
	public XmCostNlabor() {
	}

}