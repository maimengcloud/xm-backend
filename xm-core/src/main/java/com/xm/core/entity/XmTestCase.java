package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmTestCase所有属性名: <br>
 *	"id","主键","caseName","标题","caseRemark","备注","testStep","测试步骤","expectResult","期望结果","menuId","关联的故事","menuName","关联故事名","ctime","创建时间","ltime","更新时间","luserid","更新人编号","lusername","更新人姓名","cbranchId","创建机构","moduleId","模块编号","moduleName","模块名称","caseStatus","用例状态1正常0废弃","cuserid","创建人编号","cusername","创建人姓名","productId","产品编号","verNum","版本号","casedbId","用例库编号","casedbName","用例库名称","funcId","功能菜单编号","funcName","功能菜单名称","funcPnames","上级菜单名称列表逗号分割","preRemark","前置条件描述","caseType","用例类型","cpriority","优先级";<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
 @Data
@ApiModel(description="测试用例")
public class XmTestCase  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="标题",allowEmptyValue=true,example="",allowableValues="")
	String caseName;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String caseRemark;
	
	@ApiModelProperty(notes="测试步骤",allowEmptyValue=true,example="",allowableValues="")
	String testStep;
	
	@ApiModelProperty(notes="期望结果",allowEmptyValue=true,example="",allowableValues="")
	String expectResult;
	
	@ApiModelProperty(notes="关联的故事",allowEmptyValue=true,example="",allowableValues="")
	String menuId;
	
	@ApiModelProperty(notes="关联故事名",allowEmptyValue=true,example="",allowableValues="")
	String menuName;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="更新时间",allowEmptyValue=true,example="",allowableValues="")
	Date ltime;
	
	@ApiModelProperty(notes="更新人编号",allowEmptyValue=true,example="",allowableValues="")
	String luserid;
	
	@ApiModelProperty(notes="更新人姓名",allowEmptyValue=true,example="",allowableValues="")
	String lusername;
	
	@ApiModelProperty(notes="创建机构",allowEmptyValue=true,example="",allowableValues="")
	String cbranchId;
	
	@ApiModelProperty(notes="模块编号",allowEmptyValue=true,example="",allowableValues="")
	String moduleId;
	
	@ApiModelProperty(notes="模块名称",allowEmptyValue=true,example="",allowableValues="")
	String moduleName;
	
	@ApiModelProperty(notes="用例状态1正常0废弃",allowEmptyValue=true,example="",allowableValues="")
	String caseStatus;
	
	@ApiModelProperty(notes="创建人编号",allowEmptyValue=true,example="",allowableValues="")
	String cuserid;
	
	@ApiModelProperty(notes="创建人姓名",allowEmptyValue=true,example="",allowableValues="")
	String cusername;
	
	@ApiModelProperty(notes="产品编号",allowEmptyValue=true,example="",allowableValues="")
	String productId;
	
	@ApiModelProperty(notes="版本号",allowEmptyValue=true,example="",allowableValues="")
	String verNum;
	
	@ApiModelProperty(notes="用例库编号",allowEmptyValue=true,example="",allowableValues="")
	String casedbId;
	
	@ApiModelProperty(notes="用例库名称",allowEmptyValue=true,example="",allowableValues="")
	String casedbName;
	
	@ApiModelProperty(notes="功能菜单编号",allowEmptyValue=true,example="",allowableValues="")
	String funcId;
	
	@ApiModelProperty(notes="功能菜单名称",allowEmptyValue=true,example="",allowableValues="")
	String funcName;
	
	@ApiModelProperty(notes="上级菜单名称列表逗号分割",allowEmptyValue=true,example="",allowableValues="")
	String funcPnames;
	
	@ApiModelProperty(notes="前置条件描述",allowEmptyValue=true,example="",allowableValues="")
	String preRemark;
	
	@ApiModelProperty(notes="用例类型",allowEmptyValue=true,example="",allowableValues="")
	String caseType;
	
	@ApiModelProperty(notes="优先级",allowEmptyValue=true,example="",allowableValues="")
	String cpriority;

	/**
	 *主键
	 **/
	public XmTestCase(String id) {
		this.id = id;
	}
    
    /**
     * 测试用例
     **/
	public XmTestCase() {
	}

}