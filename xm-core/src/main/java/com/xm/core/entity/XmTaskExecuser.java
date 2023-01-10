package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmTaskExecuser所有属性名: <br>
 *	"createTime","创建时间","taskId","任务id","userid","执行人id","startTime","加入时间","endTime","离开时间","status","执行人状态0候选排队中1执行任务中7放弃任务8黑名单","remarks","备注","createUserid","创建人","createUsername","创建人姓名","username","执行人姓名","matchScore","任务能力匹配分数","quoteWeekday","报价天数，不包括周六日","quoteAmount","报价金额","quoteTime","报价时间","projectId","项目编号","phaseId","阶段计划编号","skillRemark","技能说明","quoteWorkload","报价工作量单位人时","quoteStartTime","报价-开始工作日期","quoteEndTime","报价-结束工作日期","branchId","项目所属机构","phaseName","阶段计划名称","taskName","任务名称","distUserid","推荐人编号","distUsername","推荐人姓名","execUserBranchId","执行人归属公司","shareKey","分享码","sfeeRate","服务费率","sfee","众包服务费","provinceId","省编号","provinceName","省名称","cityId","城市编号","cityName","城市名称","areaId","区县编号","areaName","区县名称","gradeId","能力等级编号","guardId","保障等级编号","ilvlId","会员等级编号","creditId","信用等级编号","ctotalBids","投标总数","srvTimes","服务总次数","cmonthExp","本月获得经验值","cmonthBids","本月投标数","bidDirect","是否开启投标直通车";<br>
 * 当前主键(包括多主键):<br>
 *	task_id,userid;<br>
 */
 @Data
@ApiModel(description="任务候选人、执行人表")
public class XmTaskExecuser  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="任务id,主键",allowEmptyValue=true,example="",allowableValues="")
	String taskId;
	
	@ApiModelProperty(notes="执行人id,主键",allowEmptyValue=true,example="",allowableValues="")
	String userid;
  	
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date createTime;
	
	@ApiModelProperty(notes="加入时间",allowEmptyValue=true,example="",allowableValues="")
	Date startTime;
	
	@ApiModelProperty(notes="离开时间",allowEmptyValue=true,example="",allowableValues="")
	Date endTime;
	
	@ApiModelProperty(notes="执行人状态0候选排队中1执行任务中7放弃任务8黑名单",allowEmptyValue=true,example="",allowableValues="")
	String status;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remarks;
	
	@ApiModelProperty(notes="创建人",allowEmptyValue=true,example="",allowableValues="")
	String createUserid;
	
	@ApiModelProperty(notes="创建人姓名",allowEmptyValue=true,example="",allowableValues="")
	String createUsername;
	
	@ApiModelProperty(notes="执行人姓名",allowEmptyValue=true,example="",allowableValues="")
	String username;
	
	@ApiModelProperty(notes="任务能力匹配分数",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal matchScore;
	
	@ApiModelProperty(notes="报价天数，不包括周六日",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal quoteWeekday;
	
	@ApiModelProperty(notes="报价金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal quoteAmount;
	
	@ApiModelProperty(notes="报价时间",allowEmptyValue=true,example="",allowableValues="")
	Date quoteTime;
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="阶段计划编号",allowEmptyValue=true,example="",allowableValues="")
	String phaseId;
	
	@ApiModelProperty(notes="技能说明",allowEmptyValue=true,example="",allowableValues="")
	String skillRemark;
	
	@ApiModelProperty(notes="报价工作量单位人时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal quoteWorkload;
	
	@ApiModelProperty(notes="报价-开始工作日期",allowEmptyValue=true,example="",allowableValues="")
	Date quoteStartTime;
	
	@ApiModelProperty(notes="报价-结束工作日期",allowEmptyValue=true,example="",allowableValues="")
	Date quoteEndTime;
	
	@ApiModelProperty(notes="项目所属机构",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="阶段计划名称",allowEmptyValue=true,example="",allowableValues="")
	String phaseName;
	
	@ApiModelProperty(notes="任务名称",allowEmptyValue=true,example="",allowableValues="")
	String taskName;
	
	@ApiModelProperty(notes="推荐人编号",allowEmptyValue=true,example="",allowableValues="")
	String distUserid;
	
	@ApiModelProperty(notes="推荐人姓名",allowEmptyValue=true,example="",allowableValues="")
	String distUsername;
	
	@ApiModelProperty(notes="执行人归属公司",allowEmptyValue=true,example="",allowableValues="")
	String execUserBranchId;
	
	@ApiModelProperty(notes="分享码",allowEmptyValue=true,example="",allowableValues="")
	String shareKey;
	
	@ApiModelProperty(notes="服务费率",allowEmptyValue=true,example="",allowableValues="")
	Integer sfeeRate;
	
	@ApiModelProperty(notes="众包服务费",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal sfee;
	
	@ApiModelProperty(notes="省编号",allowEmptyValue=true,example="",allowableValues="")
	String provinceId;
	
	@ApiModelProperty(notes="省名称",allowEmptyValue=true,example="",allowableValues="")
	String provinceName;
	
	@ApiModelProperty(notes="城市编号",allowEmptyValue=true,example="",allowableValues="")
	String cityId;
	
	@ApiModelProperty(notes="城市名称",allowEmptyValue=true,example="",allowableValues="")
	String cityName;
	
	@ApiModelProperty(notes="区县编号",allowEmptyValue=true,example="",allowableValues="")
	String areaId;
	
	@ApiModelProperty(notes="区县名称",allowEmptyValue=true,example="",allowableValues="")
	String areaName;
	
	@ApiModelProperty(notes="能力等级编号",allowEmptyValue=true,example="",allowableValues="")
	String gradeId;
	
	@ApiModelProperty(notes="保障等级编号",allowEmptyValue=true,example="",allowableValues="")
	String guardId;
	
	@ApiModelProperty(notes="会员等级编号",allowEmptyValue=true,example="",allowableValues="")
	String ilvlId;
	
	@ApiModelProperty(notes="信用等级编号",allowEmptyValue=true,example="",allowableValues="")
	String creditId;
	
	@ApiModelProperty(notes="投标总数",allowEmptyValue=true,example="",allowableValues="")
	Integer ctotalBids;
	
	@ApiModelProperty(notes="服务总次数",allowEmptyValue=true,example="",allowableValues="")
	Integer srvTimes;
	
	@ApiModelProperty(notes="本月获得经验值",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal cmonthExp;
	
	@ApiModelProperty(notes="本月投标数",allowEmptyValue=true,example="",allowableValues="")
	Integer cmonthBids;
	
	@ApiModelProperty(notes="是否开启投标直通车",allowEmptyValue=true,example="",allowableValues="")
	String bidDirect;

	/**
	 *任务id,执行人id
	 **/
	public XmTaskExecuser(String taskId,String userid) {
		this.taskId = taskId;
		this.userid = userid;
	}
    
    /**
     * 任务候选人、执行人表
     **/
	public XmTaskExecuser() {
	}

}