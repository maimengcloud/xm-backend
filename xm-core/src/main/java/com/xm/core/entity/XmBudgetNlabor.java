package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmBudgetNlabor所有属性名: <br>
 *	"id","主键","projectId","项目编号","budgetAt","预算金额","remark","备注","subjectId","预算科目","bizSdate","费用归属周期开始日期","bizEdate","费用归属周期结束日期","instId","当前流程实例编号","bizFlowState","当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除","costType","成本类型0非人力1内部人力2外购人力","bizMonth","费用归属月份yyyy-MM","subjectName","科目名称","branchId","项目归属企业编号";<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
 @Data
@ApiModel(description="项目人力成本预算")
public class XmBudgetNlabor  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="预算金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetAt;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="预算科目",allowEmptyValue=true,example="",allowableValues="")
	String subjectId;
	
	@ApiModelProperty(notes="费用归属周期开始日期",allowEmptyValue=true,example="",allowableValues="")
	Date bizSdate;
	
	@ApiModelProperty(notes="费用归属周期结束日期",allowEmptyValue=true,example="",allowableValues="")
	Date bizEdate;
	
	@ApiModelProperty(notes="当前流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String instId;
	
	@ApiModelProperty(notes="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;
	
	@ApiModelProperty(notes="成本类型0非人力1内部人力2外购人力",allowEmptyValue=true,example="",allowableValues="")
	String costType;
	
	@ApiModelProperty(notes="费用归属月份yyyy-MM",allowEmptyValue=true,example="",allowableValues="")
	String bizMonth;
	
	@ApiModelProperty(notes="科目名称",allowEmptyValue=true,example="",allowableValues="")
	String subjectName;
	
	@ApiModelProperty(notes="项目归属企业编号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;

	/**
	 *主键
	 **/
	public XmBudgetNlabor(String id) {
		this.id = id;
	}
    
    /**
     * 项目人力成本预算
     **/
	public XmBudgetNlabor() {
	}

}