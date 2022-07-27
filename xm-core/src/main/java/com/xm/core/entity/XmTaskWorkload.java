package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmTaskWorkload所有属性名: <br>
 *	"userid","员工编号","username","姓名","ctime","创建日期","taskId","任务编号，任务报工必填","cuserid","创建人编号","bizDate","业务日期yyyy-MM-dd","wstatus","状态0-待确认，1-已确认，2-无效","remark","备注","ttype","任务类型-关联字典taskType","id","主键","stime","结算提交时间","sstatus","结算状态0-无需结算，1-待结算2-已提交3-已通过4-已结算","workload","工时，一个task_id可多次提交，小时","rworkload","剩余工时（同一天取最后日期更新到task表budget_workload中）","cusername","创建人姓名","projectId","归属项目","branchId","项目归属机构","ubranchId","用户归属机构","sbillId","结算单编号","detailId","结算单明细表id","menuId","需求编号，缺陷报工、测试报工、任务报工都可以填","productId","产品编号，能关联到的都填","caseId","测试用例编号(如果是测试执行报工，必填)","planId","测试计划编号(如果是测试执行报工，必填)","bugId","缺陷编号(如果是缺陷报工，必填)","bizType","报工类型1-任务，2-缺陷，3-测试用例设计，4-测试执行";<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
 @Data
@ApiModel(description="工时登记表")
public class XmTaskWorkload  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="员工编号",allowEmptyValue=true,example="",allowableValues="")
	String userid;
	
	@ApiModelProperty(notes="姓名",allowEmptyValue=true,example="",allowableValues="")
	String username;
	
	@ApiModelProperty(notes="创建日期",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="任务编号，任务报工必填",allowEmptyValue=true,example="",allowableValues="")
	String taskId;
	
	@ApiModelProperty(notes="创建人编号",allowEmptyValue=true,example="",allowableValues="")
	String cuserid;
	
	@ApiModelProperty(notes="业务日期yyyy-MM-dd",allowEmptyValue=true,example="",allowableValues="")
	String bizDate;
	
	@ApiModelProperty(notes="状态0-待确认，1-已确认，2-无效",allowEmptyValue=true,example="",allowableValues="")
	String wstatus;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="任务类型-关联字典taskType",allowEmptyValue=true,example="",allowableValues="")
	String ttype;
	
	@ApiModelProperty(notes="结算提交时间",allowEmptyValue=true,example="",allowableValues="")
	Date stime;
	
	@ApiModelProperty(notes="结算状态0-无需结算，1-待结算2-已提交3-已通过4-已结算",allowEmptyValue=true,example="",allowableValues="")
	String sstatus;
	
	@ApiModelProperty(notes="工时，一个task_id可多次提交，小时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal workload;
	
	@ApiModelProperty(notes="剩余工时（同一天取最后日期更新到task表budget_workload中）",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal rworkload;
	
	@ApiModelProperty(notes="创建人姓名",allowEmptyValue=true,example="",allowableValues="")
	String cusername;
	
	@ApiModelProperty(notes="归属项目",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="项目归属机构",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="用户归属机构",allowEmptyValue=true,example="",allowableValues="")
	String ubranchId;
	
	@ApiModelProperty(notes="结算单编号",allowEmptyValue=true,example="",allowableValues="")
	String sbillId;
	
	@ApiModelProperty(notes="结算单明细表id",allowEmptyValue=true,example="",allowableValues="")
	String detailId;
	
	@ApiModelProperty(notes="需求编号，缺陷报工、测试报工、任务报工都可以填",allowEmptyValue=true,example="",allowableValues="")
	String menuId;
	
	@ApiModelProperty(notes="产品编号，能关联到的都填",allowEmptyValue=true,example="",allowableValues="")
	String productId;
	
	@ApiModelProperty(notes="测试用例编号(如果是测试执行报工，必填)",allowEmptyValue=true,example="",allowableValues="")
	String caseId;
	
	@ApiModelProperty(notes="测试计划编号(如果是测试执行报工，必填)",allowEmptyValue=true,example="",allowableValues="")
	String planId;
	
	@ApiModelProperty(notes="缺陷编号(如果是缺陷报工，必填)",allowEmptyValue=true,example="",allowableValues="")
	String bugId;
	
	@ApiModelProperty(notes="报工类型1-任务，2-缺陷，3-测试用例设计，4-测试执行",allowEmptyValue=true,example="",allowableValues="")
	String bizType;

	/**
	 *主键
	 **/
	public XmTaskWorkload(String id) {
		this.id = id;
	}
    
    /**
     * 工时登记表
     **/
	public XmTaskWorkload() {
	}

}