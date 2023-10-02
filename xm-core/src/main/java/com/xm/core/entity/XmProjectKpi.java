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

/**
 * @author code-gen
 * @since 2023-10-3
 */
@Data
@TableName("xm_project_kpi")
@ApiModel(description="项目关键指标考核")
public class XmProjectKpi  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.ASSIGN_ID)
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;

	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;

	
	@ApiModelProperty(notes="机构编码",allowEmptyValue=true,example="",allowableValues="")
	String branchId;

	
	@ApiModelProperty(notes="指标编号",allowEmptyValue=true,example="",allowableValues="")
	String kpiIndex;

	
	@ApiModelProperty(notes="指标名称",allowEmptyValue=true,example="",allowableValues="")
	String kpiName;

	
	@ApiModelProperty(notes="最大值",allowEmptyValue=true,example="",allowableValues="")
	String maxValue;

	
	@ApiModelProperty(notes="最小值",allowEmptyValue=true,example="",allowableValues="")
	String minValue;

	
	@ApiModelProperty(notes="得分0~10分",allowEmptyValue=true,example="",allowableValues="")
	Integer score;

	
	@ApiModelProperty(notes="评分日期",allowEmptyValue=true,example="",allowableValues="")
	Date scoreDate;

	
	@ApiModelProperty(notes="流程状态",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;

	
	@ApiModelProperty(notes="流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String bizProcInstId;

	
	@ApiModelProperty(notes="kpi当前值",allowEmptyValue=true,example="",allowableValues="")
	String kpiValue;

	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;

	
	@ApiModelProperty(notes="考核方式0月1季度3半年4一年",allowEmptyValue=true,example="",allowableValues="")
	String calcType;

	
	@ApiModelProperty(notes="下次考核开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date nextCalcDate;

	/**
	 *主键
	 **/
	public XmProjectKpi(String id) {
		this.id = id;
	}
    
    /**
     * 项目关键指标考核
     **/
	public XmProjectKpi() {
	}

}