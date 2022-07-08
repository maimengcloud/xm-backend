package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmGroup所有属性名: <br>
 *	"id","主键","groupName","团队名称","projectId","项目编号-属于产品线则可为空","pgTypeId","项目团队类型编号","pgTypeName","团队类型名称","leaderUserid","团队负责人","leaderUsername","负责人姓名","ctime","创建时间","ltime","更新时间","productId","产品编号，属于项目组的团队则可为空","branchId","机构编号","pgClass","团队类别0-项目小组，1-产品小组，2-团队；团队下挂项目团队或者产品团队。产品团队下只能挂产品团队，项目团队下只能挂项目团队","pgroupId","上级团队编号","lvl","级别0级1级2级3级4级","pidPaths","上级编号路径逗号分割,0,开始，本组编号+逗号结束","isTpl","是否为模板","assUserid","副组长编号","assUsername","副组长姓名","childrenCnt","下级团队数量","userCnt","组员数量","qxCode","权限码","calcWorkload","是否计算工作量0否1是","ntype","节点类型0管理团队、1执行团队","crowBranchId","协作公司编号","crowBranchName","协作公司名称","isCrow","是否众包团队";<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
 @Data
@ApiModel(description="团队表")
public class XmGroup  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="团队名称",allowEmptyValue=true,example="",allowableValues="")
	String groupName;
	
	@ApiModelProperty(notes="项目编号-属于产品线则可为空",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="项目团队类型编号",allowEmptyValue=true,example="",allowableValues="")
	String pgTypeId;
	
	@ApiModelProperty(notes="团队类型名称",allowEmptyValue=true,example="",allowableValues="")
	String pgTypeName;
	
	@ApiModelProperty(notes="团队负责人",allowEmptyValue=true,example="",allowableValues="")
	String leaderUserid;
	
	@ApiModelProperty(notes="负责人姓名",allowEmptyValue=true,example="",allowableValues="")
	String leaderUsername;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="更新时间",allowEmptyValue=true,example="",allowableValues="")
	Date ltime;
	
	@ApiModelProperty(notes="产品编号，属于项目组的团队则可为空",allowEmptyValue=true,example="",allowableValues="")
	String productId;
	
	@ApiModelProperty(notes="机构编号",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="团队类别0-项目小组，1-产品小组，2-团队；团队下挂项目团队或者产品团队。产品团队下只能挂产品团队，项目团队下只能挂项目团队",allowEmptyValue=true,example="",allowableValues="")
	String pgClass;
	
	@ApiModelProperty(notes="上级团队编号",allowEmptyValue=true,example="",allowableValues="")
	String pgroupId;
	
	@ApiModelProperty(notes="级别0级1级2级3级4级",allowEmptyValue=true,example="",allowableValues="")
	Integer lvl;
	
	@ApiModelProperty(notes="上级编号路径逗号分割,0,开始，本组编号+逗号结束",allowEmptyValue=true,example="",allowableValues="")
	String pidPaths;
	
	@ApiModelProperty(notes="是否为模板",allowEmptyValue=true,example="",allowableValues="")
	String isTpl;
	
	@ApiModelProperty(notes="副组长编号",allowEmptyValue=true,example="",allowableValues="")
	String assUserid;
	
	@ApiModelProperty(notes="副组长姓名",allowEmptyValue=true,example="",allowableValues="")
	String assUsername;
	
	@ApiModelProperty(notes="下级团队数量",allowEmptyValue=true,example="",allowableValues="")
	Integer childrenCnt;
	
	@ApiModelProperty(notes="组员数量",allowEmptyValue=true,example="",allowableValues="")
	Integer userCnt;
	
	@ApiModelProperty(notes="权限码",allowEmptyValue=true,example="",allowableValues="")
	String qxCode;
	
	@ApiModelProperty(notes="是否计算工作量0否1是",allowEmptyValue=true,example="",allowableValues="")
	String calcWorkload;
	
	@ApiModelProperty(notes="节点类型0管理团队、1执行团队",allowEmptyValue=true,example="",allowableValues="")
	String ntype;
	
	@ApiModelProperty(notes="协作公司编号",allowEmptyValue=true,example="",allowableValues="")
	String crowBranchId;
	
	@ApiModelProperty(notes="协作公司名称",allowEmptyValue=true,example="",allowableValues="")
	String crowBranchName;
	
	@ApiModelProperty(notes="是否众包团队",allowEmptyValue=true,example="",allowableValues="")
	String isCrow;

	/**
	 *主键
	 **/
	public XmGroup(String id) {
		this.id = id;
	}
    
    /**
     * 团队表
     **/
	public XmGroup() {
	}

}