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
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author code-gen
 * @since 2023-10-3
 */
@Data
@TableName("xm_menu_state")
@ApiModel(description="功能状态表,无需前端维护，所有数据由汇总统计得出")
public class XmMenuState  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.ASSIGN_ID)
	
	@ApiModelProperty(notes="功能编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String menuId;

	
	@ApiModelProperty(notes="总体完成比例0-100之间,根据taskType进行汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal finishRate;

	
	@ApiModelProperty(notes="状态0初始1设计中2开发中3测试中4uat测试2已上线3已下线4已删除",allowEmptyValue=true,example="",allowableValues="")
	String menuStatus;

	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;

	
	@ApiModelProperty(notes="汇总时间",allowEmptyValue=true,example="",allowableValues="")
	Date calcTime;

	
	@ApiModelProperty(notes="菜单名字",allowEmptyValue=true,example="",allowableValues="")
	String menuName;

	
	@ApiModelProperty(notes="工时数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planWorkhours;

	
	@ApiModelProperty(notes="总人数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planWorkerCnt;

	
	@ApiModelProperty(notes="总关闭bugs",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal closedBugs;

	
	@ApiModelProperty(notes="激活bugs",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal activeBugs;

	
	@ApiModelProperty(notes="已确认bugs总数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal confirmedBugs;

	
	@ApiModelProperty(notes="已解决bugs总数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal resolvedBugs;

	
	@ApiModelProperty(notes="产品编号",allowEmptyValue=true,example="",allowableValues="")
	String productId;

	
	@ApiModelProperty(notes="测试案例总数-指测试库中总用例数",allowEmptyValue=true,example="",allowableValues="")
	Integer testCases;

	
	@ApiModelProperty(notes="测试中案例总数-指有测试计划的阻塞和失败的用例总数-去重",allowEmptyValue=true,example="",allowableValues="")
	Integer execCases;

	
	@ApiModelProperty(notes="设计中案例总数-指有测试计划的未测状态的用例数-去重",allowEmptyValue=true,example="",allowableValues="")
	Integer designCases;

	
	@ApiModelProperty(notes="完成案例总数-指有测试计划的已通过和忽略状态的用例数-去重",allowEmptyValue=true,example="",allowableValues="")
	Integer finishCases;

	
	@ApiModelProperty(notes="业务日期yyyy-MM-dd字符串",allowEmptyValue=true,example="",allowableValues="")
	String bizDate;

	
	@ApiModelProperty(notes="bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer bugCnt;

	
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

	
	@ApiModelProperty(notes="项目总预算工作量-来自任务表+缺陷表+用例表+用例执行表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetWorkload;

	
	@ApiModelProperty(notes="外购人力总工作量-应该大于或等于阶段计划外购人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetOuserWorkload;

	
	@ApiModelProperty(notes="内部人力总工作量-应该大于或等于阶段计划内部人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetIuserWorkload;

	
	@ApiModelProperty(notes="已完成工作量-来自工时明细表同需求的汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actWorkload;

	
	@ApiModelProperty(notes="实际外购总工作量，来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actOuserWorkload;

	
	@ApiModelProperty(notes="实际内部总工作量，来自任务表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actIuserWorkload;

	
	@ApiModelProperty(notes="预估工时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal estimateWorkload;

	
	@ApiModelProperty(notes="预算金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetAt;

	
	@ApiModelProperty(notes="实际金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actAt;

	
	@ApiModelProperty(notes="最早开始日期",allowEmptyValue=true,example="",allowableValues="")
	Date minStartTime;

	
	@ApiModelProperty(notes="最晚结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date maxEndTime;

	
	@ApiModelProperty(notes="关联产品数（主要是指子节点关联）",allowEmptyValue=true,example="",allowableValues="")
	Integer productCnt;

	
	@ApiModelProperty(notes="关联迭代数（主要是指子节点关联）",allowEmptyValue=true,example="",allowableValues="")
	Integer iterationCnt;

	
	@ApiModelProperty(notes="关联项目数（主要是指子节点关联）",allowEmptyValue=true,example="",allowableValues="")
	Integer projectCnt;

	/**
	 *功能编号
	 **/
	public XmMenuState(String menuId) {
		this.menuId = menuId;
	}
    
    /**
     * 功能状态表,无需前端维护，所有数据由汇总统计得出
     **/
	public XmMenuState() {
	}

}