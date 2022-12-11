package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmMenuComment所有属性名: <br>
 *	"id","主键","userid","评论人","username","评论人姓名","star","星级","cdate","时间","menuId","需求编号","pid","上级评论","ups","点赞数量","isShow","是否显示0否1是","toUserid","回复用户编号","toUsername","回复用户名","lvl","层级0,1,2,3,4","context","评论内容","branchId","机构编号","ip","ip地址","cityId","城市编号","cityName","城市名称","status","状态0未审核，1已审核，3审核不通过","childNums","儿子节点数量";<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
 @Data
@ApiModel(description="档案评论表")
public class XmMenuComment  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="评论人",allowEmptyValue=true,example="",allowableValues="")
	String userid;
	
	@ApiModelProperty(notes="评论人姓名",allowEmptyValue=true,example="",allowableValues="")
	String username;
	
	@ApiModelProperty(notes="星级",allowEmptyValue=true,example="",allowableValues="")
	String star;
	
	@ApiModelProperty(notes="时间",allowEmptyValue=true,example="",allowableValues="")
	Date cdate;
	
	@ApiModelProperty(notes="需求编号",allowEmptyValue=true,example="",allowableValues="")
	String menuId;
	
	@ApiModelProperty(notes="上级评论",allowEmptyValue=true,example="",allowableValues="")
	String pid;
	
	@ApiModelProperty(notes="点赞数量",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal ups;
	
	@ApiModelProperty(notes="是否显示0否1是",allowEmptyValue=true,example="",allowableValues="")
	String isShow;
	
	@ApiModelProperty(notes="回复用户编号",allowEmptyValue=true,example="",allowableValues="")
	String toUserid;
	
	@ApiModelProperty(notes="回复用户名",allowEmptyValue=true,example="",allowableValues="")
	String toUsername;
	
	@ApiModelProperty(notes="层级0,1,2,3,4",allowEmptyValue=true,example="",allowableValues="")
	String lvl;
	
	@ApiModelProperty(notes="评论内容",allowEmptyValue=true,example="",allowableValues="")
	String context;
	
	@ApiModelProperty(notes="机构编号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="ip地址",allowEmptyValue=true,example="",allowableValues="")
	String ip;
	
	@ApiModelProperty(notes="城市编号",allowEmptyValue=true,example="",allowableValues="")
	String cityId;
	
	@ApiModelProperty(notes="城市名称",allowEmptyValue=true,example="",allowableValues="")
	String cityName;
	
	@ApiModelProperty(notes="状态0未审核，1已审核，3审核不通过",allowEmptyValue=true,example="",allowableValues="")
	String status;
	
	@ApiModelProperty(notes="儿子节点数量",allowEmptyValue=true,example="",allowableValues="")
	Integer childNums;

	/**
	 *主键
	 **/
	public XmMenuComment(String id) {
		this.id = id;
	}
    
    /**
     * 档案评论表
     **/
	public XmMenuComment() {
	}

}