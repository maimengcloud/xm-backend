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
@TableName("xm_question_workload")
@ApiModel(description="工时登记表")
public class XmQuestionWorkload  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.ASSIGN_ID)
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	Integer id;

	
	@ApiModelProperty(notes="员工编号",allowEmptyValue=true,example="",allowableValues="")
	String userid;

	
	@ApiModelProperty(notes="姓名",allowEmptyValue=true,example="",allowableValues="")
	String username;

	
	@ApiModelProperty(notes="创建日期",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;

	
	@ApiModelProperty(notes="业务对象主键任务编号",allowEmptyValue=true,example="",allowableValues="")
	String bugId;

	
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

	
	@ApiModelProperty(notes="结算单据编号",allowEmptyValue=true,example="",allowableValues="")
	String sbillId;

	
	@ApiModelProperty(notes="结算提交时间",allowEmptyValue=true,example="",allowableValues="")
	Date stime;

	
	@ApiModelProperty(notes="结算状态0-无需结算，1-待结算2-已提交3-已通过4-已结算",allowEmptyValue=true,example="",allowableValues="")
	String sstatus;

	
	@ApiModelProperty(notes="工时对应金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal amt;

	
	@ApiModelProperty(notes="结算金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal samt;

	
	@ApiModelProperty(notes="工时，一个bug可多次提交，小时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal workload;

	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;

	/**
	 *主键
	 **/
	public XmQuestionWorkload(Integer id) {
		this.id = id;
	}
    
    /**
     * 工时登记表
     **/
	public XmQuestionWorkload() {
	}

}