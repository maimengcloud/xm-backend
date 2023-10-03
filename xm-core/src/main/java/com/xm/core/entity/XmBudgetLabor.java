package  com.xm.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author code-gen
 * @since 2023-10-3
 */
@Data
@TableName("xm_budget_labor")
@ApiModel(description="项目人力成本预算")
public class XmBudgetLabor  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.ASSIGN_ID)
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;

	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;

	
	@ApiModelProperty(notes="项目成员编号",allowEmptyValue=true,example="",allowableValues="")
	String userid;

	
	@ApiModelProperty(notes="预算金额/每月",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetAt;

	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;

	
	@ApiModelProperty(notes="用户名",allowEmptyValue=true,example="",allowableValues="")
	String username;

	
	@ApiModelProperty(notes="预算科目编号",allowEmptyValue=true,example="",allowableValues="")
	String subjectId;

	
	@ApiModelProperty(notes="费用归属周期开始日期",allowEmptyValue=true,example="",allowableValues="")
	Date bizSdate;

	
	@ApiModelProperty(notes="费用归属周期结束日期",allowEmptyValue=true,example="",allowableValues="")
	Date bizEdate;

	
	@ApiModelProperty(notes="费用归属月份yyyy-mm",allowEmptyValue=true,example="",allowableValues="")
	String bizMonth;

	
	@ApiModelProperty(notes="当前流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String instId;

	
	@ApiModelProperty(notes="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;

	
	@ApiModelProperty(notes="成本类型0非人力1内部人力2外购人力",allowEmptyValue=true,example="",allowableValues="")
	String costType;

	
	@ApiModelProperty(notes="科目名称",allowEmptyValue=true,example="",allowableValues="")
	String subjectName;

	
	@ApiModelProperty(notes="项目归属机构编号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;

	
	@ApiModelProperty(notes="用户归属机构编号-也就是将来的结算对象",allowEmptyValue=true,example="",allowableValues="")
	String ubranchId;

	/**
	 *主键
	 **/
	public XmBudgetLabor(String id) {
		this.id = id;
	}
    
    /**
     * 项目人力成本预算
     **/
	public XmBudgetLabor() {
	}

}