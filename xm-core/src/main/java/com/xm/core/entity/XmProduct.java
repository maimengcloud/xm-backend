package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmProduct所有属性名: <br>
 *	"id","产品编号","productName","产品名称","branchId","机构号","remark","备注","version","版本号","pmUserid","产品经理编号","pmUsername","产品经理名称","ctime","创建日期","deptid","归属部门","pstatus","产品阶段:0未开始,1研发中,2已完成,3已关闭","startTime","开始日期","endTime","结束日期","deptName","主管部门名称","admUserid","主管领导编号","admUsername","主管领导名称","assUserid","副经理编号","assUsername","副经理名称","bizProcInstId","当前流程实例编号","bizFlowState","当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除","isTpl","是否为模板","baselineId","基线编号","baseTime","基线时间","code","产品编码","pbudgetWorkload","产品预计总工作量，应该大于一级需求总预算工作量","pbudgetAmount","产品预计总金额，应该大于一级需求总预算金额","pmenuBudgetWorkload","从需求汇总来的总预算工作量","pmenuBudgetAmount","从需求汇总的总预算金额","budgetCtrl","是否进行预算控制，计划中一级计划总预算不能大于项目预算","phaseBudgetCtrl","是否进行计划明细预算控制，计划中下级预算不能大于上级预算","phaseActCtrl","计划是否进行实际金额控制，实际金额不能大于预算金额","locked","是否锁定不允许编号0否1是","del","是否已删除0否一是","ltime","最后更新时间","qxCode","";<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
 @Data
@ApiModel(description="产品表")
public class XmProduct  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
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