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
@TableName("xm_cost_nlabor")
@ApiModel(description="项目实际人工成本费用")
public class XmCostNlabor  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.ASSIGN_ID)
	
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