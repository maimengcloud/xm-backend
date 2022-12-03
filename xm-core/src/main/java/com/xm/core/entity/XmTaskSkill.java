package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmTaskSkill所有属性名: <br>
 *	"taskId","任务编号","skillId","技能要求","skillName","技能名称","categoryId","技能分类";<br>
 * 当前主键(包括多主键):<br>
 *	task_id,skill_id;<br>
 */
 @Data
@ApiModel(description="任务技能关联表")
public class XmTaskSkill  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="任务编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String taskId;
	
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