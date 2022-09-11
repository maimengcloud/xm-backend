package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmTaskEval所有属性名: <br>
 *	"id","评价","type","评价类型1-雇主对服务商的评价，2-服务商对雇主的评价，3-组长对组员的评价","wspeed","工作速度0-5分","wattit","工作态度0-5分","wquality","工作质量0-5分","totalStar","总体评价0-5分","remark","评价内容","evalUserid","评价人编号","evalUsername","评价人姓名","toUserid","被评价人编号","toUsername","被评价人姓名","evalBranchId","评价人归属机构","toBranchId","被评价人归属机构号","taskId","任务编号","evalTime","评价时间";<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
 @Data
@ApiModel(description="xm_task_eval")
public class XmTaskEval  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="评价,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="评价类型1-雇主对服务商的评价，2-服务商对雇主的评价，3-组长对组员的评价",allowEmptyValue=true,example="",allowableValues="")
	String type;
	
	@ApiModelProperty(notes="工作速度0-5分",allowEmptyValue=true,example="",allowableValues="")
	Integer wspeed;
	
	@ApiModelProperty(notes="工作态度0-5分",allowEmptyValue=true,example="",allowableValues="")
	Integer wattit;
	
	@ApiModelProperty(notes="工作质量0-5分",allowEmptyValue=true,example="",allowableValues="")
	Integer wquality;
	
	@ApiModelProperty(notes="总体评价0-5分",allowEmptyValue=true,example="",allowableValues="")
	Integer totalStar;
	
	@ApiModelProperty(notes="评价内容",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="评价人编号",allowEmptyValue=true,example="",allowableValues="")
	String evalUserid;
	
	@ApiModelProperty(notes="评价人姓名",allowEmptyValue=true,example="",allowableValues="")
	String evalUsername;
	
	@ApiModelProperty(notes="被评价人编号",allowEmptyValue=true,example="",allowableValues="")
	String toUserid;
	
	@ApiModelProperty(notes="被评价人姓名",allowEmptyValue=true,example="",allowableValues="")
	String toUsername;
	
	@ApiModelProperty(notes="评价人归属机构",allowEmptyValue=true,example="",allowableValues="")
	String evalBranchId;
	
	@ApiModelProperty(notes="被评价人归属机构号",allowEmptyValue=true,example="",allowableValues="")
	String toBranchId;
	
	@ApiModelProperty(notes="任务编号",allowEmptyValue=true,example="",allowableValues="")
	String taskId;
	
	@ApiModelProperty(notes="评价时间",allowEmptyValue=true,example="",allowableValues="")
	Date evalTime;

	/**
	 *评价
	 **/
	public XmTaskEval(String id) {
		this.id = id;
	}
    
    /**
     * xm_task_eval
     **/
	public XmTaskEval() {
	}

}