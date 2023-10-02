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

/**
 * @author code-gen
 * @since 2023-10-3
 */
@Data
@TableName("xm_task_skill")
@ApiModel(description="任务技能关联表")
public class XmTaskSkill  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
    @TableIds
	
    @ApiModelProperty(notes="任务编号,主键",allowEmptyValue=true,example="",allowableValues="")
    String taskId;
    @TableIds
	
    @ApiModelProperty(notes="技能要求,主键",allowEmptyValue=true,example="",allowableValues="")
    String skillId;

	
	@ApiModelProperty(notes="技能名称",allowEmptyValue=true,example="",allowableValues="")
	String skillName;

	
	@ApiModelProperty(notes="技能分类",allowEmptyValue=true,example="",allowableValues="")
	String categoryId;

	/**
	 *任务编号,技能要求
	 **/
	public XmTaskSkill(String taskId,String skillId) {
		this.taskId = taskId;
		this.skillId = skillId;
	}
    
    /**
     * 任务技能关联表
     **/
	public XmTaskSkill() {
	}

}