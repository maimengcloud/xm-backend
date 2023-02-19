package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmTestPlanCase所有属性名: <br>
 *	"bugs","bug数目","execUserid","执行人","caseId","测试用例编号","ltime","更新时间","ctime","创建时间","execStatus","0-未测，1-通过，2-受阻，3-忽略，4-失败","execUsername","执行人姓名","priority","优先级","remark","执行备注","testStep","测试步骤","planId","计划编号","projectId","项目编号","budgetWorkload","预算工时","actWorkload","实际工时","initWorkload","原估工时","execDate","执行日期，以执行状态变更日期为准yyyy-MM-dd型","execType","执行类型0-手工，1-自动化","productId","归属产品","autoStep","自动化测试";<br>
 * 当前主键(包括多主键):<br>
 *	case_id,plan_id;<br>
 */
 @Data
@ApiModel(description="测试计划与用例关系表")
public class XmTestPlanCase  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="测试用例编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String caseId;
	
	@ApiModelProperty(notes="计划编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String planId;
  	
	
	@ApiModelProperty(notes="bug数目",allowEmptyValue=true,example="",allowableValues="")
	Integer bugs;
	
	@ApiModelProperty(notes="执行人",allowEmptyValue=true,example="",allowableValues="")
	String execUserid;
	
	@ApiModelProperty(notes="更新时间",allowEmptyValue=true,example="",allowableValues="")
	Date ltime;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="0-未测，1-通过，2-受阻，3-忽略，4-失败",allowEmptyValue=true,example="",allowableValues="")
	String execStatus;
	
	@ApiModelProperty(notes="执行人姓名",allowEmptyValue=true,example="",allowableValues="")
	String execUsername;
	
	@ApiModelProperty(notes="优先级",allowEmptyValue=true,example="",allowableValues="")
	String priority;
	
	@ApiModelProperty(notes="执行备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="测试步骤",allowEmptyValue=true,example="",allowableValues="")
	String testStep;
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="预算工时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetWorkload;
	
	@ApiModelProperty(notes="实际工时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actWorkload;
	
	@ApiModelProperty(notes="原估工时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal initWorkload;
	
	@ApiModelProperty(notes="执行日期，以执行状态变更日期为准yyyy-MM-dd型",allowEmptyValue=true,example="",allowableValues="")
	String execDate;
	
	@ApiModelProperty(notes="执行类型0-手工，1-自动化",allowEmptyValue=true,example="",allowableValues="")
	String execType;
	
	@ApiModelProperty(notes="归属产品",allowEmptyValue=true,example="",allowableValues="")
	String productId;
	
	@ApiModelProperty(notes="自动化测试",allowEmptyValue=true,example="",allowableValues="")
	String autoStep;

	/**
	 *测试用例编号,计划编号
	 **/
	public XmTestPlanCase(String caseId,String planId) {
		this.caseId = caseId;
		this.planId = planId;
	}
    
    /**
     * 测试计划与用例关系表
     **/
	public XmTestPlanCase() {
	}

}