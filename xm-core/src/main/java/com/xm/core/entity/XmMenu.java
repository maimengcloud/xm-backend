package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmMenu所有属性名: <br>
 *	"startTime","开始时间","menuId","功能编号","menuName","功能名称","pmenuId","上级功能","productId","归属产品编号","remark","备注","status","状态0初始1待评审2待设计3待开发4待sit测试5待uat测试6已测试待上线7已上线8已下线9已删除","online","是否已上线","demandUrl","需求链接","codeUrl","代码链接","designUrl","设计链接","docUrl","文档链接","helpUrl","帮助文档链接","operDocUrl","操作手册链接","seqNo","排序序号","mmUserid","故事管理员编号","mmUsername","故事管理员姓名","ctime","创建时间","ntype","节点类型0-叶子节点，1非叶子节点","sinceVersion","开始版本","childrenCnt","儿子节点个数","ltime","更新时间","tagIds","标签编号,逗号分割","tagNames","标签名称,逗号分割","pidPaths","父级id逗号分割，最后一个为本节点节点编号,以,号结尾","lvl","层级0-顶级，1-一级，2-二级，3-三级，4-四级。总共5级","isTpl","是否为模板","phaseId","计划编号","iterationId","迭代编号","source","需求来源","proposerId","提出人编号","proposerName","提出人姓名","dlvl","需求层次0-基础需求,1-增值需求,2-扩展需求","dtype","需求类型;0-新增功能;1-功能改进;2-bug修复;3-用户体验;4-UI优化;5-内部需求;6-删除需求;7-接口需求;","priority","优先级;0-紧急重要；1-紧急不重要；2-不紧急重要；3-不紧急不重要","dclass","需求分类1-史诗，2-特性，3-用户故事，4-任务，5-缺陷","iterationName","迭代名称","endTime","结束时间","funcId","功能菜单编号-故事才有","funcName","功能菜单名称-故事才有","comments","评论数","ups","点赞数","readNum","阅读数","pbranchId","产品归属企业";<br>
 * 当前主键(包括多主键):<br>
 *	menu_id;<br>
 */
 @Data
@ApiModel(description="用户故事(需求)表")
public class XmMenu  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="功能编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String menuId;
  	
	
	@ApiModelProperty(notes="开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date startTime;
	
	@ApiModelProperty(notes="功能名称",allowEmptyValue=true,example="",allowableValues="")
	String menuName;
	
	@ApiModelProperty(notes="上级功能",allowEmptyValue=true,example="",allowableValues="")
	String pmenuId;
	
	@ApiModelProperty(notes="归属产品编号",allowEmptyValue=true,example="",allowableValues="")
	String productId;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="状态0初始1待评审2待设计3待开发4待sit测试5待uat测试6已测试待上线7已上线8已下线9已删除",allowEmptyValue=true,example="",allowableValues="")
	String status;
	
	@ApiModelProperty(notes="是否已上线",allowEmptyValue=true,example="",allowableValues="")
	String online;
	
	@ApiModelProperty(notes="需求链接",allowEmptyValue=true,example="",allowableValues="")
	String demandUrl;
	
	@ApiModelProperty(notes="代码链接",allowEmptyValue=true,example="",allowableValues="")
	String codeUrl;
	
	@ApiModelProperty(notes="设计链接",allowEmptyValue=true,example="",allowableValues="")
	String designUrl;
	
	@ApiModelProperty(notes="文档链接",allowEmptyValue=true,example="",allowableValues="")
	String docUrl;
	
	@ApiModelProperty(notes="帮助文档链接",allowEmptyValue=true,example="",allowableValues="")
	String helpUrl;
	
	@ApiModelProperty(notes="操作手册链接",allowEmptyValue=true,example="",allowableValues="")
	String operDocUrl;
	
	@ApiModelProperty(notes="排序序号",allowEmptyValue=true,example="",allowableValues="")
	String seqNo;
	
	@ApiModelProperty(notes="故事管理员编号",allowEmptyValue=true,example="",allowableValues="")
	String mmUserid;
	
	@ApiModelProperty(notes="故事管理员姓名",allowEmptyValue=true,example="",allowableValues="")
	String mmUsername;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="节点类型0-叶子节点，1非叶子节点",allowEmptyValue=true,example="",allowableValues="")
	String ntype;
	
	@ApiModelProperty(notes="开始版本",allowEmptyValue=true,example="",allowableValues="")
	String sinceVersion;
	
	@ApiModelProperty(notes="儿子节点个数",allowEmptyValue=true,example="",allowableValues="")
	Integer childrenCnt;
	
	@ApiModelProperty(notes="更新时间",allowEmptyValue=true,example="",allowableValues="")
	Date ltime;
	
	@ApiModelProperty(notes="标签编号,逗号分割",allowEmptyValue=true,example="",allowableValues="")
	String tagIds;
	
	@ApiModelProperty(notes="标签名称,逗号分割",allowEmptyValue=true,example="",allowableValues="")
	String tagNames;
	
	@ApiModelProperty(notes="父级id逗号分割，最后一个为本节点节点编号,以,号结尾",allowEmptyValue=true,example="",allowableValues="")
	String pidPaths;
	
	@ApiModelProperty(notes="层级0-顶级，1-一级，2-二级，3-三级，4-四级。总共5级",allowEmptyValue=true,example="",allowableValues="")
	Integer lvl;
	
	@ApiModelProperty(notes="是否为模板",allowEmptyValue=true,example="",allowableValues="")
	String isTpl;
	
	@ApiModelProperty(notes="计划编号",allowEmptyValue=true,example="",allowableValues="")
	String phaseId;
	
	@ApiModelProperty(notes="迭代编号",allowEmptyValue=true,example="",allowableValues="")
	String iterationId;
	
	@ApiModelProperty(notes="需求来源",allowEmptyValue=true,example="",allowableValues="")
	String source;
	
	@ApiModelProperty(notes="提出人编号",allowEmptyValue=true,example="",allowableValues="")
	String proposerId;
	
	@ApiModelProperty(notes="提出人姓名",allowEmptyValue=true,example="",allowableValues="")
	String proposerName;
	
	@ApiModelProperty(notes="需求层次0-基础需求,1-增值需求,2-扩展需求",allowEmptyValue=true,example="",allowableValues="")
	String dlvl;
	
	@ApiModelProperty(notes="需求类型;0-新增功能;1-功能改进;2-bug修复;3-用户体验;4-UI优化;5-内部需求;6-删除需求;7-接口需求;",allowEmptyValue=true,example="",allowableValues="")
	String dtype;
	
	@ApiModelProperty(notes="优先级;0-紧急重要；1-紧急不重要；2-不紧急重要；3-不紧急不重要",allowEmptyValue=true,example="",allowableValues="")
	String priority;
	
	@ApiModelProperty(notes="需求分类1-史诗，2-特性，3-用户故事，4-任务，5-缺陷",allowEmptyValue=true,example="",allowableValues="")
	String dclass;
	
	@ApiModelProperty(notes="迭代名称",allowEmptyValue=true,example="",allowableValues="")
	String iterationName;
	
	@ApiModelProperty(notes="结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date endTime;
	
	@ApiModelProperty(notes="功能菜单编号-故事才有",allowEmptyValue=true,example="",allowableValues="")
	String funcId;
	
	@ApiModelProperty(notes="功能菜单名称-故事才有",allowEmptyValue=true,example="",allowableValues="")
	String funcName;
	
	@ApiModelProperty(notes="评论数",allowEmptyValue=true,example="",allowableValues="")
	Integer comments;
	
	@ApiModelProperty(notes="点赞数",allowEmptyValue=true,example="",allowableValues="")
	Integer ups;
	
	@ApiModelProperty(notes="阅读数",allowEmptyValue=true,example="",allowableValues="")
	Integer readNum;
	
	@ApiModelProperty(notes="产品归属企业",allowEmptyValue=true,example="",allowableValues="")
	String pbranchId;

	/**
	 *功能编号
	 **/
	public XmMenu(String menuId) {
		this.menuId = menuId;
	}
    
    /**
     * 用户故事(需求)表
     **/
	public XmMenu() {
	}

}