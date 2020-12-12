package  com.qqkj.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 组织 com.qqkj  顶级模块 oa 大模块 xm  小模块 <br> 
 * 实体 XmTaskSkill所有属性名: <br>
 *	id,taskId,taskSkillId,taskSkillName,skillRemarks;<br>
 * 表 XM.xm_task_skill xm_task_skill的所有字段名: <br>
 *	id,task_id,task_skill_id,task_skill_name,skill_remarks;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_task_skill")
public class XmTaskSkill  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="任务编号",allowEmptyValue=true,example="",allowableValues="")
	String taskId;
	
	@ApiModelProperty(notes="技能要求",allowEmptyValue=true,example="",allowableValues="")
	String taskSkillId;
	
	@ApiModelProperty(notes="技能名称",allowEmptyValue=true,example="",allowableValues="")
	String taskSkillName;
	
	@ApiModelProperty(notes="技能描述",allowEmptyValue=true,example="",allowableValues="")
	String skillRemarks;

	/**主键**/
	public XmTaskSkill(String id) {
		this.id = id;
	}
    
    /**xm_task_skill**/
	public XmTaskSkill() {
	}
	
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 任务编号
	 **/
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	/**
	 * 技能要求
	 **/
	public void setTaskSkillId(String taskSkillId) {
		this.taskSkillId = taskSkillId;
	}
	/**
	 * 技能名称
	 **/
	public void setTaskSkillName(String taskSkillName) {
		this.taskSkillName = taskSkillName;
	}
	/**
	 * 技能描述
	 **/
	public void setSkillRemarks(String skillRemarks) {
		this.skillRemarks = skillRemarks;
	}
	
	/**
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 任务编号
	 **/
	public String getTaskId() {
		return this.taskId;
	}
	/**
	 * 技能要求
	 **/
	public String getTaskSkillId() {
		return this.taskSkillId;
	}
	/**
	 * 技能名称
	 **/
	public String getTaskSkillName() {
		return this.taskSkillName;
	}
	/**
	 * 技能描述
	 **/
	public String getSkillRemarks() {
		return this.skillRemarks;
	}

}