package  com.xm.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author code-gen
 * @since 2023-10-3
 */
@Data
@TableName("xm_collect")
@ApiModel(description="xm_collect")
public class XmCollect  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.ASSIGN_ID)
	
	@ApiModelProperty(notes="项目集编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;

	
	@ApiModelProperty(notes="项目集名称",allowEmptyValue=true,example="",allowableValues="")
	String name;

	
	@ApiModelProperty(notes="创建人",allowEmptyValue=true,example="",allowableValues="")
	String cuserid;

	
	@ApiModelProperty(notes="创建人姓名",allowEmptyValue=true,example="",allowableValues="")
	String cusername;

	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;

	
	@ApiModelProperty(notes="归属机构号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;

	
	@ApiModelProperty(notes="部门编号",allowEmptyValue=true,example="",allowableValues="")
	String deptid;

	/**
	 *项目集编号
	 **/
	public XmCollect(String id) {
		this.id = id;
	}
    
    /**
     * xm_collect
     **/
	public XmCollect() {
	}

}