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
 * @since 2023-11-10
 */
@Data
@TableName("xm_group_user")
@ApiModel(description="团队成员表")
public class XmGroupUser  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
    @TableIds
	
    @ApiModelProperty(notes="团队编号,主键",allowEmptyValue=true,example="",allowableValues="")
    String groupId;
    @TableIds
	
    @ApiModelProperty(notes="团队成员编号,主键",allowEmptyValue=true,example="",allowableValues="")
    String userid;

	
	@ApiModelProperty(notes="加入时间",allowEmptyValue=true,example="",allowableValues="")
	Date joinTime;

	
	@ApiModelProperty(notes="团队成员",allowEmptyValue=true,example="",allowableValues="")
	String username;

	
	@ApiModelProperty(notes="离队时间",allowEmptyValue=true,example="",allowableValues="")
	Date outTime;

	
	@ApiModelProperty(notes="当前状态0参与中1已退出团队",allowEmptyValue=true,example="",allowableValues="")
	String status;

	
	@ApiModelProperty(notes="组员原归属机构编号",allowEmptyValue=true,example="",allowableValues="")
	String obranchId;

	
	@ApiModelProperty(notes="是否私人加入0否1是",allowEmptyValue=true,example="",allowableValues="")
	String isPri;

	
	@ApiModelProperty(notes="排序号--从1开始",allowEmptyValue=true,example="",allowableValues="")
	Integer seqNo;

	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;

	
	@ApiModelProperty(notes="产品编号",allowEmptyValue=true,example="",allowableValues="")
	String productId;

	
	@ApiModelProperty(notes="0-项目小组，1-产品小组，2-团队",allowEmptyValue=true,example="",allowableValues="")
	String pgClass;

	
	@ApiModelProperty(notes="原归属机构名称",allowEmptyValue=true,example="",allowableValues="")
	String obranchName;

	/**
	 *团队编号,团队成员编号
	 **/
	public XmGroupUser(String groupId,String userid) {
		this.groupId = groupId;
		this.userid = userid;
	}
    
    /**
     * 团队成员表
     **/
	public XmGroupUser() {
	}

}