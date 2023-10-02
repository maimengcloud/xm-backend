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
@TableName("xm_project")
@ApiModel(description="项目表")
public class XmProject  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.ASSIGN_ID)
	
	@ApiModelProperty(notes="项目编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;

	
	@ApiModelProperty(notes="项目代号",allowEmptyValue=true,example="",allowableValues="")
	String code;

	
	@ApiModelProperty(notes="项目名称",allowEmptyValue=true,example="",allowableValues="")
	String name;

	
	@ApiModelProperty(notes="项目类型",allowEmptyValue=true,example="",allowableValues="")
	String xmType;

	
	@ApiModelProperty(notes="项目开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date startTime;

	
	@ApiModelProperty(notes="项目结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date endTime;

	
	@ApiModelProperty(notes="紧急程度",allowEmptyValue=true,example="",allowableValues="")
	String urgent;

	
	@ApiModelProperty(notes="优先程度",allowEmptyValue=true,example="",allowableValues="")
	String priority;

	
	@ApiModelProperty(notes="项目描述",allowEmptyValue=true,example="",allowableValues="")
	String description;

	
	@ApiModelProperty(notes="项目创建人编号",allowEmptyValue=true,example="",allowableValues="")
	String createUserid;

	
	@ApiModelProperty(notes="项目创建人",allowEmptyValue=true,example="",allowableValues="")
	String createUsername;

	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date createTime;

	
	@ApiModelProperty(notes="项目考核",allowEmptyValue=true,example="",allowableValues="")
	String assess;

	
	@ApiModelProperty(notes="考核备注",allowEmptyValue=true,example="",allowableValues="")
	String assessRemarks;

	
	@ApiModelProperty(notes="0|初始1|售前2|立项中3|实施中4|暂停中5|结项中6|已结项7|售后8|已完成9|已关闭",allowEmptyValue=true,example="",allowableValues="")
	String status;

	
	@ApiModelProperty(notes="机构编号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;

	
	@ApiModelProperty(notes="总预算",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planTotalCost;

	
	@ApiModelProperty(notes="当前流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String bizProcInstId;

	
	@ApiModelProperty(notes="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;

	
	@ApiModelProperty(notes="非人力成本总预算-应该大于或等于阶段计划非人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planNouserAt;

	
	@ApiModelProperty(notes="内部人力成本总预算-应该大于或等于阶段计划内部人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planIuserAt;

	
	@ApiModelProperty(notes="外购人力成本总预算-应该大于或等于阶段计划外购人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planOuserAt;

	
	@ApiModelProperty(notes="是否锁定整个项目不允许变化0否1是",allowEmptyValue=true,example="",allowableValues="")
	String locked;

	
	@ApiModelProperty(notes="基线时间",allowEmptyValue=true,example="",allowableValues="")
	Date baseTime;

	
	@ApiModelProperty(notes="基线备注",allowEmptyValue=true,example="",allowableValues="")
	String baseRemark;

	
	@ApiModelProperty(notes="基线主键",allowEmptyValue=true,example="",allowableValues="")
	String baselineId;

	
	@ApiModelProperty(notes="总预算工作量-应该大于或等于阶段计划总工作量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planWorkload;

	
	@ApiModelProperty(notes="总预计收款金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal totalReceivables;

	
	@ApiModelProperty(notes="预估毛利率",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetMarginRate;

	
	@ApiModelProperty(notes="合同总金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal contractAmt;

	
	@ApiModelProperty(notes="内部人力成本单价元/人时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planIuserPrice;

	
	@ApiModelProperty(notes="外购人力成本单价元/人时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planOuserPrice;

	
	@ApiModelProperty(notes="外购人数",allowEmptyValue=true,example="",allowableValues="")
	Integer planOuserCnt;

	
	@ApiModelProperty(notes="内部人数",allowEmptyValue=true,example="",allowableValues="")
	Integer planIuserCnt;

	
	@ApiModelProperty(notes="预计工作小时数目",allowEmptyValue=true,example="",allowableValues="")
	Integer planWorkingHours;

	
	@ApiModelProperty(notes="税率0-100之间",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal taxRate;

	
	@ApiModelProperty(notes="内部人力总工作量-应该大于或等于阶段计划内部人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planIuserWorkload;

	
	@ApiModelProperty(notes="外购人力总工作量-应该大于或等于阶段计划外购人力总成本",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal planOuserWorkload;

	
	@ApiModelProperty(notes="关联模板编号",allowEmptyValue=true,example="",allowableValues="")
	String fromTplId;

	
	@ApiModelProperty(notes="是否进行预算控制，计划中一级计划总预算大于项目预算则拒绝添加计划,一般用于瀑布型项目",allowEmptyValue=true,example="",allowableValues="")
	String budgetCtrl;

	
	@ApiModelProperty(notes="部门编号",allowEmptyValue=true,example="",allowableValues="")
	String deptid;

	
	@ApiModelProperty(notes="是否对外公开0-完全不可见，1-仅本司人员可见，2-关联人员可见（众包-外包-招投标）",allowEmptyValue=true,example="",allowableValues="")
	String showOut;

	
	@ApiModelProperty(notes="是否为模板",allowEmptyValue=true,example="",allowableValues="")
	String isTpl;

	
	@ApiModelProperty(notes="项目经理编号",allowEmptyValue=true,example="",allowableValues="")
	String pmUserid;

	
	@ApiModelProperty(notes="项目经理名称",allowEmptyValue=true,example="",allowableValues="")
	String pmUsername;

	
	@ApiModelProperty(notes="助理、副经理编号",allowEmptyValue=true,example="",allowableValues="")
	String assUserid;

	
	@ApiModelProperty(notes="助理、副经理姓名",allowEmptyValue=true,example="",allowableValues="")
	String assUsername;

	
	@ApiModelProperty(notes="主管领导编号",allowEmptyValue=true,example="",allowableValues="")
	String admUserid;

	
	@ApiModelProperty(notes="主管领导姓名",allowEmptyValue=true,example="",allowableValues="")
	String admUsername;

	
	@ApiModelProperty(notes="是否进行计划预算预警，计划预算超出项目预算既定额度进行预警",allowEmptyValue=true,example="",allowableValues="")
	String budgetEarly;

	
	@ApiModelProperty(notes="计划是否进行实际金额控制，实际金额不能大于预算金额（大于预算金额不得结算）",allowEmptyValue=true,example="",allowableValues="")
	String phaseActCtrl;

	
	@ApiModelProperty(notes="是否已删除0否1是",allowEmptyValue=true,example="",allowableValues="")
	String del;

	
	@ApiModelProperty(notes="最后更新时间",allowEmptyValue=true,example="",allowableValues="")
	Date ltime;

	
	@ApiModelProperty(notes="原状态，暂停时记录原状态，暂停恢复后把原状态恢复",allowEmptyValue=true,example="",allowableValues="")
	String ostatus;

	
	@ApiModelProperty(notes="工作方式1-scrum、2-kanban",allowEmptyValue=true,example="",allowableValues="")
	String workType;

	
	@ApiModelProperty(notes="报工方式0-无须报工，1-每日报工，2-工期内报工",allowEmptyValue=true,example="",allowableValues="")
	String wtype;

	
	@ApiModelProperty(notes="超出预算金额多少金额进行预警，正数代表超出的额度，负数代表距离预算的额度",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal earlyAmt;

	
	@ApiModelProperty(notes="单个任务最大金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal maxTaskAmt;

	
	@ApiModelProperty(notes="任务是否必须严格关联用户故事，0不限制，1必须关联，2-完全不关联",allowEmptyValue=true,example="",allowableValues="")
	String menuLink;

	
	@ApiModelProperty(notes="任务是否必须关联计划，0-不限制，1必须关联，2完全不关联",allowEmptyValue=true,example="",allowableValues="")
	String phaseLink;

	
	@ApiModelProperty(notes="模板类型1-全域公开，2-本机构公开",allowEmptyValue=true,example="",allowableValues="")
	String tplType;

	
	@ApiModelProperty(notes="",allowEmptyValue=true,example="",allowableValues="")
	String qxCode;

	/**
	 *项目编号
	 **/
	public XmProject(String id) {
		this.id = id;
	}
    
    /**
     * 项目表
     **/
	public XmProject() {
	}

}