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
@TableName("xm_question")
@ApiModel(description="缺陷列表")
public class XmQuestion  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.ASSIGN_ID)
	
	@ApiModelProperty(notes="问题编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;

	
	@ApiModelProperty(notes="问题标题",allowEmptyValue=true,example="",allowableValues="")
	String name;

	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;

	
	@ApiModelProperty(notes="项目名称",allowEmptyValue=true,example="",allowableValues="")
	String projectName;

	
	@ApiModelProperty(notes="测试案例编号",allowEmptyValue=true,example="",allowableValues="")
	String caseId;

	
	@ApiModelProperty(notes="测试案例名称",allowEmptyValue=true,example="",allowableValues="")
	String caseName;

	
	@ApiModelProperty(notes="到期时间",allowEmptyValue=true,example="",allowableValues="")
	Date endTime;

	
	@ApiModelProperty(notes="提出人编号",allowEmptyValue=true,example="",allowableValues="")
	String askUserid;

	
	@ApiModelProperty(notes="提出人",allowEmptyValue=true,example="",allowableValues="")
	String askUsername;

	
	@ApiModelProperty(notes="处理人编号",allowEmptyValue=true,example="",allowableValues="")
	String handlerUserid;

	
	@ApiModelProperty(notes="处理人",allowEmptyValue=true,example="",allowableValues="")
	String handlerUsername;

	
	@ApiModelProperty(notes="优先级别1-非常紧急，2-紧急，3-一般紧急，4-低",allowEmptyValue=true,example="",allowableValues="")
	String priority;

	
	@ApiModelProperty(notes="解决方案:",allowEmptyValue=true,example="",allowableValues="")
	String solution;

	
	@ApiModelProperty(notes="问题描述",allowEmptyValue=true,example="",allowableValues="")
	String description;

	
	@ApiModelProperty(notes="问题创建人编号",allowEmptyValue=true,example="",allowableValues="")
	String createUserid;

	
	@ApiModelProperty(notes="问题创建人",allowEmptyValue=true,example="",allowableValues="")
	String createUsername;

	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date createTime;

	
	@ApiModelProperty(notes="1|新提交",allowEmptyValue=true,example="",allowableValues="")
	String bugStatus;

	
	@ApiModelProperty(notes="当前流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String bizProcInstId;

	
	@ApiModelProperty(notes="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;

	
	@ApiModelProperty(notes="故事编号",allowEmptyValue=true,example="",allowableValues="")
	String menuId;

	
	@ApiModelProperty(notes="故事名称",allowEmptyValue=true,example="",allowableValues="")
	String menuName;

	
	@ApiModelProperty(notes="预估工时单位人时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetWorkload;

	
	@ApiModelProperty(notes="预估成本金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetAt;

	
	@ApiModelProperty(notes="实际工时（取报工实际工时汇总）",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actWorkload;

	
	@ApiModelProperty(notes="实际总金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actAt;

	
	@ApiModelProperty(notes="期望结果",allowEmptyValue=true,example="",allowableValues="")
	String expectResult;

	
	@ApiModelProperty(notes="测试步骤",allowEmptyValue=true,example="",allowableValues="")
	String opStep;

	
	@ApiModelProperty(notes="当前结果",allowEmptyValue=true,example="",allowableValues="")
	String currResult;

	
	@ApiModelProperty(notes="相关需求",allowEmptyValue=true,example="",allowableValues="")
	String refRequire;

	
	@ApiModelProperty(notes="严重程度1、2、3、4，分别对应：致命缺陷、严重缺陷、普通缺陷、轻微缺陷",allowEmptyValue=true,example="",allowableValues="")
	String bugSeverity;

	
	@ApiModelProperty(notes="BUG类型1、2、3、4，分别对应：代码错误、低级缺陷、设计缺陷、配置相关、安全相关、性能问题、其他",allowEmptyValue=true,example="",allowableValues="")
	String bugType;

	
	@ApiModelProperty(notes="标签id列表逗号分隔",allowEmptyValue=true,example="",allowableValues="")
	String tagIds;

	
	@ApiModelProperty(notes="标签名称列表逗号分隔",allowEmptyValue=true,example="",allowableValues="")
	String tagNames;

	
	@ApiModelProperty(notes="链接地址列表逗号分隔",allowEmptyValue=true,example="",allowableValues="")
	String urls;

	
	@ApiModelProperty(notes="最后更新时间",allowEmptyValue=true,example="",allowableValues="")
	Date ltime;

	
	@ApiModelProperty(notes="问题类型2-风险、1-功能问题、3-普通咨询、（暂时不用这个字段了）",allowEmptyValue=true,example="",allowableValues="")
	String qtype;

	
	@ApiModelProperty(notes="关联的案例执行编号",allowEmptyValue=true,example="",allowableValues="")
	String caseExecId;

	
	@ApiModelProperty(notes="最后更新说明",allowEmptyValue=true,example="",allowableValues="")
	String remarks;

	
	@ApiModelProperty(notes="产品编号",allowEmptyValue=true,example="",allowableValues="")
	String productId;

	
	@ApiModelProperty(notes="复现频率1-必现，2-大概率复现，3-小概率复现，4-仅出现一次",allowEmptyValue=true,example="",allowableValues="")
	String repRate;

	
	@ApiModelProperty(notes="版本号",allowEmptyValue=true,example="",allowableValues="")
	String verNum;

	
	@ApiModelProperty(notes="访问路径/斜杠分割",allowEmptyValue=true,example="",allowableValues="")
	String vpath;

	
	@ApiModelProperty(notes="发布版本",allowEmptyValue=true,example="",allowableValues="")
	String pverNum;

	
	@ApiModelProperty(notes="原因分析",allowEmptyValue=true,example="",allowableValues="")
	String bugReason;

	
	@ApiModelProperty(notes="进度0-100",allowEmptyValue=true,example="",allowableValues="")
	Integer rate;

	
	@ApiModelProperty(notes="原始预估工作量，budget_workload发生变化后，进行备份",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal initWorkload;

	
	@ApiModelProperty(notes="是否众包0否1是",allowEmptyValue=true,example="",allowableValues="")
	String taskOut;

	
	@ApiModelProperty(notes="任务编号-可以在任务下直接创建bug-废弃，不用了",allowEmptyValue=true,example="",allowableValues="")
	String taskId;

	
	@ApiModelProperty(notes="功能菜单编号",allowEmptyValue=true,example="",allowableValues="")
	String funcId;

	
	@ApiModelProperty(notes="功能菜单名称",allowEmptyValue=true,example="",allowableValues="")
	String funcName;

	
	@ApiModelProperty(notes="上级名称逗号分割",allowEmptyValue=true,example="",allowableValues="")
	String funcPnames;

	
	@ApiModelProperty(notes="测试计划编号",allowEmptyValue=true,example="",allowableValues="")
	String planId;

	
	@ApiModelProperty(notes="测试库编号",allowEmptyValue=true,example="",allowableValues="")
	String casedbId;

	
	@ApiModelProperty(notes="产品或者项目归属企业编号",allowEmptyValue=true,example="",allowableValues="")
	String pbranchId;

	/**
	 *问题编号
	 **/
	public XmQuestion(String id) {
		this.id = id;
	}
    
    /**
     * 缺陷列表
     **/
	public XmQuestion() {
	}

}