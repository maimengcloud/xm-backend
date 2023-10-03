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
@TableName("xm_product")
@ApiModel(description="产品表")
public class XmProduct  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.ASSIGN_ID)
	
	@ApiModelProperty(notes="产品编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;

	
	@ApiModelProperty(notes="产品名称",allowEmptyValue=true,example="",allowableValues="")
	String productName;

	
	@ApiModelProperty(notes="机构号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;

	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;

	
	@ApiModelProperty(notes="版本号",allowEmptyValue=true,example="",allowableValues="")
	String version;

	
	@ApiModelProperty(notes="产品经理编号",allowEmptyValue=true,example="",allowableValues="")
	String pmUserid;

	
	@ApiModelProperty(notes="产品经理名称",allowEmptyValue=true,example="",allowableValues="")
	String pmUsername;

	
	@ApiModelProperty(notes="创建日期",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;

	
	@ApiModelProperty(notes="归属部门",allowEmptyValue=true,example="",allowableValues="")
	String deptid;

	
	@ApiModelProperty(notes="产品阶段:0未开始,1研发中,2已完成,3已关闭",allowEmptyValue=true,example="",allowableValues="")
	String pstatus;

	
	@ApiModelProperty(notes="开始日期",allowEmptyValue=true,example="",allowableValues="")
	Date startTime;

	
	@ApiModelProperty(notes="结束日期",allowEmptyValue=true,example="",allowableValues="")
	Date endTime;

	
	@ApiModelProperty(notes="主管部门名称",allowEmptyValue=true,example="",allowableValues="")
	String deptName;

	
	@ApiModelProperty(notes="主管领导编号",allowEmptyValue=true,example="",allowableValues="")
	String admUserid;

	
	@ApiModelProperty(notes="主管领导名称",allowEmptyValue=true,example="",allowableValues="")
	String admUsername;

	
	@ApiModelProperty(notes="副经理编号",allowEmptyValue=true,example="",allowableValues="")
	String assUserid;

	
	@ApiModelProperty(notes="副经理名称",allowEmptyValue=true,example="",allowableValues="")
	String assUsername;

	
	@ApiModelProperty(notes="当前流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String bizProcInstId;

	
	@ApiModelProperty(notes="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;

	
	@ApiModelProperty(notes="是否为模板",allowEmptyValue=true,example="",allowableValues="")
	String isTpl;

	
	@ApiModelProperty(notes="基线编号",allowEmptyValue=true,example="",allowableValues="")
	String baselineId;

	
	@ApiModelProperty(notes="基线时间",allowEmptyValue=true,example="",allowableValues="")
	Date baseTime;

	
	@ApiModelProperty(notes="产品编码",allowEmptyValue=true,example="",allowableValues="")
	String code;

	
	@ApiModelProperty(notes="产品预计总工作量，应该大于一级需求总预算工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal pbudgetWorkload;

	
	@ApiModelProperty(notes="产品预计总金额，应该大于一级需求总预算金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal pbudgetAmount;

	
	@ApiModelProperty(notes="从需求汇总来的总预算工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal pmenuBudgetWorkload;

	
	@ApiModelProperty(notes="从需求汇总的总预算金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal pmenuBudgetAmount;

	
	@ApiModelProperty(notes="是否进行预算控制，计划中一级计划总预算不能大于项目预算",allowEmptyValue=true,example="",allowableValues="")
	String budgetCtrl;

	
	@ApiModelProperty(notes="是否进行计划明细预算控制，计划中下级预算不能大于上级预算",allowEmptyValue=true,example="",allowableValues="")
	String phaseBudgetCtrl;

	
	@ApiModelProperty(notes="计划是否进行实际金额控制，实际金额不能大于预算金额",allowEmptyValue=true,example="",allowableValues="")
	String phaseActCtrl;

	
	@ApiModelProperty(notes="是否锁定不允许编号0否1是",allowEmptyValue=true,example="",allowableValues="")
	String locked;

	
	@ApiModelProperty(notes="是否已删除0否一是",allowEmptyValue=true,example="",allowableValues="")
	String del;

	
	@ApiModelProperty(notes="最后更新时间",allowEmptyValue=true,example="",allowableValues="")
	Date ltime;

	
	@ApiModelProperty(notes="",allowEmptyValue=true,example="",allowableValues="")
	String qxCode;

	/**
	 *产品编号
	 **/
	public XmProduct(String id) {
		this.id = id;
	}
    
    /**
     * 产品表
     **/
	public XmProduct() {
	}

}