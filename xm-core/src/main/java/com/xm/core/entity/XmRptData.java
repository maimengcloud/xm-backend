package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmRptData所有属性名: <br>
 *	"cfgId","报表配置主键","id","报表主键","rptName","报表名称","rptData","报表数据json对象,比rptCfg.cfg多了rawDatas","cuserid","创建人编号","cbranchId","创建人机构号","cusername","创建人名称","ctime","创建日期","bizDate","归属业务日期yyyy-MM-dd型","bizType","业务类型，同rpt_config.biz_type";<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
 @Data
@ApiModel(description="xm_rpt_data")
public class XmRptData  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="报表主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="报表配置主键",allowEmptyValue=true,example="",allowableValues="")
	String cfgId;
	
	@ApiModelProperty(notes="报表名称",allowEmptyValue=true,example="",allowableValues="")
	String rptName;
	
	@ApiModelProperty(notes="报表数据json对象,比rptCfg.cfg多了rawDatas",allowEmptyValue=true,example="",allowableValues="")
	String rptData;
	
	@ApiModelProperty(notes="创建人编号",allowEmptyValue=true,example="",allowableValues="")
	String cuserid;
	
	@ApiModelProperty(notes="创建人机构号",allowEmptyValue=true,example="",allowableValues="")
	String cbranchId;
	
	@ApiModelProperty(notes="创建人名称",allowEmptyValue=true,example="",allowableValues="")
	String cusername;
	
	@ApiModelProperty(notes="创建日期",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="归属业务日期yyyy-MM-dd型",allowEmptyValue=true,example="",allowableValues="")
	String bizDate;
	
	@ApiModelProperty(notes="业务类型，同rpt_config.biz_type",allowEmptyValue=true,example="",allowableValues="")
	String bizType;

	/**
	 *报表主键
	 **/
	public XmRptData(String id) {
		this.id = id;
	}
    
    /**
     * xm_rpt_data
     **/
	public XmRptData() {
	}

}