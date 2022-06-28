package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmIteration所有属性名: <br>
 *	"id","迭代编码","branchId","机构编号","iterationName","迭代名称","startTime","开始时间","endTime","结束时间","onlineTime","上线时间","pid","上级迭代-作废，不以树状结构","adminUserid","负责人","adminUsername","负责人姓名","ctime","创建时间","budgetCost","预算成本","budgetWorkload","预算工作量","seqNo","顺序号","istatus","迭代状态0未结束1已结束","cuserid","创建人编号","cusername","创建人人姓名","remark","备注","iphase","迭代阶段:0未开始,1需求评审,2计划会,3研发中,4测试中,5迭代上线,6已完成7已关闭","isTpl","是否为模板","productId","产品编号";<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
 @Data
@ApiModel(description="迭代定义")
public class XmIteration  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="迭代编码,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="机构编号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="迭代名称",allowEmptyValue=true,example="",allowableValues="")
	String iterationName;
	
	@ApiModelProperty(notes="开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date startTime;
	
	@ApiModelProperty(notes="结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date endTime;
	
	@ApiModelProperty(notes="上线时间",allowEmptyValue=true,example="",allowableValues="")
	Date onlineTime;
	
	@ApiModelProperty(notes="上级迭代-作废，不以树状结构",allowEmptyValue=true,example="",allowableValues="")
	String pid;
	
	@ApiModelProperty(notes="负责人",allowEmptyValue=true,example="",allowableValues="")
	String adminUserid;
	
	@ApiModelProperty(notes="负责人姓名",allowEmptyValue=true,example="",allowableValues="")
	String adminUsername;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="预算成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetCost;
	
	@ApiModelProperty(notes="预算工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetWorkload;
	
	@ApiModelProperty(notes="顺序号",allowEmptyValue=true,example="",allowableValues="")
	String seqNo;
	
	@ApiModelProperty(notes="迭代状态0未结束1已结束",allowEmptyValue=true,example="",allowableValues="")
	String istatus;
	
	@ApiModelProperty(notes="创建人编号",allowEmptyValue=true,example="",allowableValues="")
	String cuserid;
	
	@ApiModelProperty(notes="创建人人姓名",allowEmptyValue=true,example="",allowableValues="")
	String cusername;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="迭代阶段:0未开始,1需求评审,2计划会,3研发中,4测试中,5迭代上线,6已完成7已关闭",allowEmptyValue=true,example="",allowableValues="")
	String iphase;
	
	@ApiModelProperty(notes="是否为模板",allowEmptyValue=true,example="",allowableValues="")
	String isTpl;
	
	@ApiModelProperty(notes="产品编号",allowEmptyValue=true,example="",allowableValues="")
	String productId;

	/**
	 *迭代编码
	 **/
	public XmIteration(String id) {
		this.id = id;
	}
    
    /**
     * 迭代定义
     **/
	public XmIteration() {
	}

}