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
@TableName("xm_collect_link")
@ApiModel(description="xm_collect_link")
public class XmCollectLink  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	@TableId(type = IdType.ASSIGN_ID)
	
	@ApiModelProperty(notes="项目集编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String collectId;

	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;

	/**
	 *项目集编号
	 **/
	public XmCollectLink(String collectId) {
		this.collectId = collectId;
	}
    
    /**
     * xm_collect_link
     **/
	public XmCollectLink() {
	}

}