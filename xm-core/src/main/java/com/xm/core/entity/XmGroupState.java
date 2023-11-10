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
 * @since 2023-11-10
 */
@Data
@TableName("xm_group_state")
@ApiModel(description="团队状态表,无需前端维护，所有数据由汇总统计得出")
public class XmGroupState  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.ASSIGN_ID)
	
	@ApiModelProperty(notes="团队编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String groupId;

	
	@ApiModelProperty(notes="开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date planStartTime;

	
	@ApiModelProperty(notes="结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date planEndTime;

	
	@ApiModelProperty(notes="实际开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date actStartTime;

	
	@ApiModelProperty(notes="实际结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date actEndTime;

	
	@ApiModelProperty(notes="计划工作量，根据关联任务汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planWorkload;

	
	@ApiModelProperty(notes="实际工作量，根据关联任务汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actWorkload;

	
	@ApiModelProperty(notes="计划成本，根据关联任务汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planCostAmount;

	
	@ApiModelProperty(notes="实际成本金额根据关联任务汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actCostAmount;

	
	@ApiModelProperty(notes="总体完成比例0-100之间,根据taskType进行汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal finishRate;

	
	@ApiModelProperty(notes="需求完成率0-100之间,根据taskType进行汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal demandRate;

	
	@ApiModelProperty(notes="设计完成率0-100之间,根据taskType进行汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal designRate;

	
	@ApiModelProperty(notes="开发完成率0-100之间,根据taskType进行汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal devRate;

	
	@ApiModelProperty(notes="uat测试完成率0-100之间,根据taskType进行汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal uatRate;

	
	@ApiModelProperty(notes="sit测试完成率0-100之间,根据taskType进行汇总",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal sitRate;

	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;

	
	@ApiModelProperty(notes="汇总时间",allowEmptyValue=true,example="",allowableValues="")
	Date calcTime;

	
	@ApiModelProperty(notes="工时数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planWorkhours;

	
	@ApiModelProperty(notes="总人数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planWorkerCnt;

	
	@ApiModelProperty(notes="总关闭bugs",allowEmptyValue=true,example="",allowableValues="")
	Integer closedBugs;

	
	@ApiModelProperty(notes="激活bugs",allowEmptyValue=true,example="",allowableValues="")
	Integer activeBugs;

	
	@ApiModelProperty(notes="已确认bugs总数",allowEmptyValue=true,example="",allowableValues="")
	Integer confirmedBugs;

	
	@ApiModelProperty(notes="已解决bugs总数",allowEmptyValue=true,example="",allowableValues="")
	Integer resolvedBugs;

	
	@ApiModelProperty(notes="测试案例总数",allowEmptyValue=true,example="",allowableValues="")
	Integer testCases;

	
	@ApiModelProperty(notes="测试中案例总数",allowEmptyValue=true,example="",allowableValues="")
	Integer execCases;

	
	@ApiModelProperty(notes="设计中案例总数",allowEmptyValue=true,example="",allowableValues="")
	Integer designCases;

	
	@ApiModelProperty(notes="完成案例总数",allowEmptyValue=true,example="",allowableValues="")
	Integer finishCases;

	
	@ApiModelProperty(notes="关联迭代数",allowEmptyValue=true,example="",allowableValues="")
	Integer iterationCnt;

	
	@ApiModelProperty(notes="任务数",allowEmptyValue=true,example="",allowableValues="")
	Integer taskCnt;

	
	@ApiModelProperty(notes="完成的任务数",allowEmptyValue=true,example="",allowableValues="")
	Integer finishTaskCnt;

	
	@ApiModelProperty(notes="业务日期yyyy-MM-dd字符串",allowEmptyValue=true,example="",allowableValues="")
	String bizDate;

	
	@ApiModelProperty(notes="bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer bugCnt;

	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;

	
	@ApiModelProperty(notes="项目名称",allowEmptyValue=true,example="",allowableValues="")
	String projectName;

	
	@ApiModelProperty(notes="团队名称",allowEmptyValue=true,example="",allowableValues="")
	String groupName;

	/**
	 *团队编号
	 **/
	public XmGroupState(String groupId) {
		this.groupId = groupId;
	}
    
    /**
     * 团队状态表,无需前端维护，所有数据由汇总统计得出
     **/
	public XmGroupState() {
	}

}