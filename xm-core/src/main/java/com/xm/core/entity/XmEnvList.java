package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmEnvList所有属性名: <br>
 *	"id","主键","remark","备注说明","ipAddress","内网ip地址","port","内网访问端口","branchId","归属机构","accessUserid","访问用户编号","accessPassword","访问密码","accessUrl","访问链接","supplier","供应商","webIpAddress","外网ip地址","webPort","外网端口","createUserid","添加人员","createUsername","添加人员姓名","createTime","添加时间","envState","状态0不可用1已启用2已过期","startTime","有效日期开始","endTime","有效日期结束","feeAmount","费用","feeRule","计费规则","projectId","归属项目编号","readQx","0-全部可看，1-同机构可看，2-同机构同项目可看，3-同项目上级可看，9-仅自己可看","writeQx","0-全部可写，1-同机构可写，2-同机构同项目可写，3-同项目上级可写，9-仅自己可修改","ltime","修改时间","luserid","修改人编号","lusername","修改人姓名";<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
 @Data
@ApiModel(description="项目环境清单")
public class XmEnvList  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="备注说明",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="内网ip地址",allowEmptyValue=true,example="",allowableValues="")
	String ipAddress;
	
	@ApiModelProperty(notes="内网访问端口",allowEmptyValue=true,example="",allowableValues="")
	String port;
	
	@ApiModelProperty(notes="归属机构",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="访问用户编号",allowEmptyValue=true,example="",allowableValues="")
	String accessUserid;
	
	@ApiModelProperty(notes="访问密码",allowEmptyValue=true,example="",allowableValues="")
	String accessPassword;
	
	@ApiModelProperty(notes="访问链接",allowEmptyValue=true,example="",allowableValues="")
	String accessUrl;
	
	@ApiModelProperty(notes="供应商",allowEmptyValue=true,example="",allowableValues="")
	String supplier;
	
	@ApiModelProperty(notes="外网ip地址",allowEmptyValue=true,example="",allowableValues="")
	String webIpAddress;
	
	@ApiModelProperty(notes="外网端口",allowEmptyValue=true,example="",allowableValues="")
	String webPort;
	
	@ApiModelProperty(notes="添加人员",allowEmptyValue=true,example="",allowableValues="")
	String createUserid;
	
	@ApiModelProperty(notes="添加人员姓名",allowEmptyValue=true,example="",allowableValues="")
	String createUsername;
	
	@ApiModelProperty(notes="添加时间",allowEmptyValue=true,example="",allowableValues="")
	Date createTime;
	
	@ApiModelProperty(notes="状态0不可用1已启用2已过期",allowEmptyValue=true,example="",allowableValues="")
	String envState;
	
	@ApiModelProperty(notes="有效日期开始",allowEmptyValue=true,example="",allowableValues="")
	Date startTime;
	
	@ApiModelProperty(notes="有效日期结束",allowEmptyValue=true,example="",allowableValues="")
	Date endTime;
	
	@ApiModelProperty(notes="费用",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal feeAmount;
	
	@ApiModelProperty(notes="计费规则",allowEmptyValue=true,example="",allowableValues="")
	String feeRule;
	
	@ApiModelProperty(notes="归属项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="0-全部可看，1-同机构可看，2-同机构同项目可看，3-同项目上级可看，9-仅自己可看",allowEmptyValue=true,example="",allowableValues="")
	String readQx;
	
	@ApiModelProperty(notes="0-全部可写，1-同机构可写，2-同机构同项目可写，3-同项目上级可写，9-仅自己可修改",allowEmptyValue=true,example="",allowableValues="")
	String writeQx;
	
	@ApiModelProperty(notes="修改时间",allowEmptyValue=true,example="",allowableValues="")
	Date ltime;
	
	@ApiModelProperty(notes="修改人编号",allowEmptyValue=true,example="",allowableValues="")
	String luserid;
	
	@ApiModelProperty(notes="修改人姓名",allowEmptyValue=true,example="",allowableValues="")
	String lusername;

	/**
	 *主键
	 **/
	public XmEnvList(String id) {
		this.id = id;
	}
    
    /**
     * 项目环境清单
     **/
	public XmEnvList() {
	}

}