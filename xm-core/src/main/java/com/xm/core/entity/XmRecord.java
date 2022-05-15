package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmRecord所有属性名: <br>
 *	"id","日志编号","projectId","项目编号","operUserid","操作人id","operUsername","操作人名字","operTime","操作时间","objType","操作对象project/task/phase/group/product/menu/iteration","action","操作的id","oldValue","历史值","newValue","新值","remarks","备注-只描述新旧值之间的变化","gloNo","全局根踪号，用于跟踪日志","branchId","机构编号","ip","ip地址","bizId","业务主键编号","pbizId","上级业务主键编号","productId","产品编号","bizName","对象名称";<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
 @Data
@ApiModel(description="xm_record")
public class XmRecord  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="日志编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="操作人id",allowEmptyValue=true,example="",allowableValues="")
	String operUserid;
	
	@ApiModelProperty(notes="操作人名字",allowEmptyValue=true,example="",allowableValues="")
	String operUsername;
	
	@ApiModelProperty(notes="操作时间",allowEmptyValue=true,example="",allowableValues="")
	Date operTime;
	
	@ApiModelProperty(notes="操作对象project/task/phase/group/product/menu/iteration",allowEmptyValue=true,example="",allowableValues="")
	String objType;
	
	@ApiModelProperty(notes="操作的id",allowEmptyValue=true,example="",allowableValues="")
	String action;
	
	@ApiModelProperty(notes="历史值",allowEmptyValue=true,example="",allowableValues="")
	String oldValue;
	
	@ApiModelProperty(notes="新值",allowEmptyValue=true,example="",allowableValues="")
	String newValue;
	
	@ApiModelProperty(notes="备注-只描述新旧值之间的变化",allowEmptyValue=true,example="",allowableValues="")
	String remarks;
	
	@ApiModelProperty(notes="全局根踪号，用于跟踪日志",allowEmptyValue=true,example="",allowableValues="")
	String gloNo;
	
	@ApiModelProperty(notes="机构编号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="ip地址",allowEmptyValue=true,example="",allowableValues="")
	String ip;
	
	@ApiModelProperty(notes="业务主键编号",allowEmptyValue=true,example="",allowableValues="")
	String bizId;
	
	@ApiModelProperty(notes="上级业务主键编号",allowEmptyValue=true,example="",allowableValues="")
	String pbizId;
	
	@ApiModelProperty(notes="产品编号",allowEmptyValue=true,example="",allowableValues="")
	String productId;
	
	@ApiModelProperty(notes="对象名称",allowEmptyValue=true,example="",allowableValues="")
	String bizName;

	/**
	 *日志编号
	 **/
	public XmRecord(String id) {
		this.id = id;
	}
    
    /**
     * xm_record
     **/
	public XmRecord() {
	}

}