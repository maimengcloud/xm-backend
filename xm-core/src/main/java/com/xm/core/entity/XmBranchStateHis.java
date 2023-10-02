package  com.xm.core.entity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.mdp.core.dao.annotation.TableIds;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.ibatis.type.Alias;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author code-gen
 * @since 2023-10-3
 */
@Data
@TableName("xm_branch_state_his")
@ApiModel(description="机构内所有项目指标汇总")
public class XmBranchStateHis  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
    @TableIds
	
    @ApiModelProperty(notes="统计日期yyyy-mm-dd类型,主键",allowEmptyValue=true,example="",allowableValues="")
    String bizDate;
    @TableIds
	
    @ApiModelProperty(notes="机构编号,主键",allowEmptyValue=true,example="",allowableValues="")
    String branchId;

	
	@ApiModelProperty(notes="项目数",allowEmptyValue=true,example="",allowableValues="")
	Integer projectCnt;

	
	@ApiModelProperty(notes="文件数据",allowEmptyValue=true,example="",allowableValues="")
	Integer fileCnt;

	
	@ApiModelProperty(notes="统计执行日期",allowEmptyValue=true,example="",allowableValues="")
	Date calcTime;

	
	@ApiModelProperty(notes="0-暂时的1稳定的，暂时的可以被覆盖，稳定的不允许覆盖",allowEmptyValue=true,example="",allowableValues="")
	String calcStatus;

	
	@ApiModelProperty(notes="项目阶段计划数",allowEmptyValue=true,example="",allowableValues="")
	Integer phaseCnt;

	
	@ApiModelProperty(notes="项目阶段计划已完成数",allowEmptyValue=true,example="",allowableValues="")
	Integer phaseFinishCnt;

	
	@ApiModelProperty(notes="待付款总金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal needPayAt;

	
	@ApiModelProperty(notes="已付款总金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal finishPayAt;

	
	@ApiModelProperty(notes="待收款总金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal needColAt;

	
	@ApiModelProperty(notes="已收款总金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal finishColAt;

	
	@ApiModelProperty(notes="项目风险总数",allowEmptyValue=true,example="",allowableValues="")
	Integer riskCnt;

	
	@ApiModelProperty(notes="已完成风险总数",allowEmptyValue=true,example="",allowableValues="")
	Integer riskFinishCnt;

	
	@ApiModelProperty(notes="机构名称",allowEmptyValue=true,example="",allowableValues="")
	String branchName;

	
	@ApiModelProperty(notes="项目总非人力预算-来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetNouserAt;

	
	@ApiModelProperty(notes="项目总外购人力预算-来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetOuserAt;

	
	@ApiModelProperty(notes="项目总内部人力预算-来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetIuserAt;

	
	@ApiModelProperty(notes="项目总人力成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actUserAt;

	
	@ApiModelProperty(notes="项目总内部人力成本金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actIuserAt;

	
	@ApiModelProperty(notes="项目总外购人力成本金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actOuserAt;

	
	@ApiModelProperty(notes="项目总非人力成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actNouserAt;

	
	@ApiModelProperty(notes="项目进度0~100之间，来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal finishRate;

	
	@ApiModelProperty(notes="项目总预算工作量-来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetWorkload;

	
	@ApiModelProperty(notes="外购人力总工作量-应该大于或等于阶段计划外购人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetOuserWorkload;

	
	@ApiModelProperty(notes="内部人力总工作量-应该大于或等于阶段计划内部人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetIuserWorkload;

	
	@ApiModelProperty(notes="预估工时=计划结束时间在计算当日前完成的任务的预算工时总和",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal estimateWorkload;

	
	@ApiModelProperty(notes="已完成工作量-来自计划中实际完成工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actWorkload;

	
	@ApiModelProperty(notes="实际外购总工作量，来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actOuserWorkload;

	
	@ApiModelProperty(notes="实际内部总工作量，来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actIuserWorkload;

	
	@ApiModelProperty(notes="待付款笔数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal needPayCnt;

	
	@ApiModelProperty(notes="完成付款总比数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal finishPayCnt;

	
	@ApiModelProperty(notes="已付款总人数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal finishPayUserCnt;

	
	@ApiModelProperty(notes="待付款总人数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal needPayUserCnt;

	
	@ApiModelProperty(notes="测试案例总数",allowEmptyValue=true,example="",allowableValues="")
	Integer testCases;

	
	@ApiModelProperty(notes="测试中案例总数",allowEmptyValue=true,example="",allowableValues="")
	Integer execCases;

	
	@ApiModelProperty(notes="设计中案例总数",allowEmptyValue=true,example="",allowableValues="")
	Integer designCases;

	
	@ApiModelProperty(notes="完成案例总数",allowEmptyValue=true,example="",allowableValues="")
	Integer finishCases;

	
	@ApiModelProperty(notes="迭代数",allowEmptyValue=true,example="",allowableValues="")
	Integer iterationCnt;

	
	@ApiModelProperty(notes="产品数",allowEmptyValue=true,example="",allowableValues="")
	Integer productCnt;

	
	@ApiModelProperty(notes="最早开始日期",allowEmptyValue=true,example="",allowableValues="")
	Date minStartTime;

	
	@ApiModelProperty(notes="最晚结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date maxEndTime;

	
	@ApiModelProperty(notes="故事数",allowEmptyValue=true,example="",allowableValues="")
	Integer menuCnt;

	
	@ApiModelProperty(notes="已完成需求数，2状态需求",allowEmptyValue=true,example="",allowableValues="")
	Integer menuFinishCnt;

	
	@ApiModelProperty(notes="执行中需求数，1状态的需求",allowEmptyValue=true,example="",allowableValues="")
	Integer menuExecCnt;

	
	@ApiModelProperty(notes="未开始需求数，0状态数据",allowEmptyValue=true,example="",allowableValues="")
	Integer menuUnstartCnt;

	
	@ApiModelProperty(notes="已关闭需求数，3状态数据",allowEmptyValue=true,example="",allowableValues="")
	Integer menuCloseCnt;

	
	@ApiModelProperty(notes="任务总数",allowEmptyValue=true,example="",allowableValues="")
	Integer taskCnt;

	
	@ApiModelProperty(notes="待开始任务",allowEmptyValue=true,example="",allowableValues="")
	Integer taskUnstartCnt;

	
	@ApiModelProperty(notes="执行中任务",allowEmptyValue=true,example="",allowableValues="")
	Integer taskExecCnt;

	
	@ApiModelProperty(notes="已完成任务总数-来自任务表",allowEmptyValue=true,example="",allowableValues="")
	Integer taskFinishCnt;

	
	@ApiModelProperty(notes="已结算任务",allowEmptyValue=true,example="",allowableValues="")
	Integer taskSetCnt;

	
	@ApiModelProperty(notes="外购任务数，来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal taskOutCnt;

	
	@ApiModelProperty(notes="已关闭任务",allowEmptyValue=true,example="",allowableValues="")
	Integer taskCloseCnt;

	
	@ApiModelProperty(notes="bug数目",allowEmptyValue=true,example="",allowableValues="")
	Integer bugCnt;

	
	@ApiModelProperty(notes="已关闭bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer closedBugs;

	
	@ApiModelProperty(notes="已解决bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer resolvedBugs;

	
	@ApiModelProperty(notes="激活的bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer activeBugs;

	
	@ApiModelProperty(notes="已解决bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer confirmedBugs;

	
	@ApiModelProperty(notes="工期（小时）",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planWorkhours;

	
	@ApiModelProperty(notes="总人数",allowEmptyValue=true,example="",allowableValues="")
	Integer planWorkerCnt;

	
	@ApiModelProperty(notes="实际投入人员数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actWorkerCnt;

	
	@ApiModelProperty(notes="预算金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetAt;

	
	@ApiModelProperty(notes="实际金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actAt;

	
	@ApiModelProperty(notes="产品工时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal productBudgetWorkload;

	
	@ApiModelProperty(notes="产品实际工时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal productActWorkload;

	/**
	 *统计日期yyyy-mm-dd类型,机构编号
	 **/
	public XmBranchStateHis(String bizDate,String branchId) {
		this.bizDate = bizDate;
		this.branchId = branchId;
	}
    
    /**
     * 机构内所有项目指标汇总
     **/
	public XmBranchStateHis() {
	}

}