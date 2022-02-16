package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmMenu所有属性名: <br>
 *	menuId,menuName,pmenuId,productId,remark,status,online,demandUrl,codeUrl,designUrl,docUrl,helpUrl,operDocUrl,seqNo,mmUserid,mmUsername,ctime,ntype,sinceVersion,childrenCnt,ltime,tagIds,tagNames;<br>
 * 表 xm_menu 功能表的所有字段名: <br>
 *	menu_id,menu_name,pmenu_id,product_id,remark,status,online,demand_url,code_url,design_url,doc_url,help_url,oper_doc_url,seq_no,mm_userid,mm_username,ctime,ntype,since_version,children_cnt,ltime,tag_ids,tag_names;<br>
 * 当前主键(包括多主键):<br>
 *	menu_id;<br>
 */
@ApiModel(description="功能表")
public class XmMenu  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="功能编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String menuId;
  	
	
	@ApiModelProperty(notes="功能名称",allowEmptyValue=true,example="",allowableValues="")
	String menuName;
	
	@ApiModelProperty(notes="上级功能",allowEmptyValue=true,example="",allowableValues="")
	String pmenuId;
	
	@ApiModelProperty(notes="归属产品编号",allowEmptyValue=true,example="",allowableValues="")
	String productId;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="状态0初始1设计中2开发中3测试中4uat测试2已上线3已下线4已删除",allowEmptyValue=true,example="",allowableValues="")
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
	
	@ApiModelProperty(notes="节点类型0-功能点，1-目录。目录下建功能点，功能点下不允许建立任何子节点",allowEmptyValue=true,example="",allowableValues="")
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

	/**功能编号**/
	public XmMenu(String menuId) {
		this.menuId = menuId;
	}
    
    /**功能表**/
	public XmMenu() {
	}
	
	/**
	 * 功能编号
	 **/
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	/**
	 * 功能名称
	 **/
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/**
	 * 上级功能
	 **/
	public void setPmenuId(String pmenuId) {
		this.pmenuId = pmenuId;
	}
	/**
	 * 归属产品编号
	 **/
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * 备注
	 **/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 状态0初始1设计中2开发中3测试中4uat测试2已上线3已下线4已删除
	 **/
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 是否已上线
	 **/
	public void setOnline(String online) {
		this.online = online;
	}
	/**
	 * 需求链接
	 **/
	public void setDemandUrl(String demandUrl) {
		this.demandUrl = demandUrl;
	}
	/**
	 * 代码链接
	 **/
	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}
	/**
	 * 设计链接
	 **/
	public void setDesignUrl(String designUrl) {
		this.designUrl = designUrl;
	}
	/**
	 * 文档链接
	 **/
	public void setDocUrl(String docUrl) {
		this.docUrl = docUrl;
	}
	/**
	 * 帮助文档链接
	 **/
	public void setHelpUrl(String helpUrl) {
		this.helpUrl = helpUrl;
	}
	/**
	 * 操作手册链接
	 **/
	public void setOperDocUrl(String operDocUrl) {
		this.operDocUrl = operDocUrl;
	}
	/**
	 * 排序序号
	 **/
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	/**
	 * 故事管理员编号
	 **/
	public void setMmUserid(String mmUserid) {
		this.mmUserid = mmUserid;
	}
	/**
	 * 故事管理员姓名
	 **/
	public void setMmUsername(String mmUsername) {
		this.mmUsername = mmUsername;
	}
	/**
	 * 创建时间
	 **/
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	/**
	 * 节点类型0-功能点，1-目录。目录下建功能点，功能点下不允许建立任何子节点
	 **/
	public void setNtype(String ntype) {
		this.ntype = ntype;
	}
	/**
	 * 开始版本
	 **/
	public void setSinceVersion(String sinceVersion) {
		this.sinceVersion = sinceVersion;
	}
	/**
	 * 儿子节点个数
	 **/
	public void setChildrenCnt(Integer childrenCnt) {
		this.childrenCnt = childrenCnt;
	}
	/**
	 * 更新时间
	 **/
	public void setLtime(Date ltime) {
		this.ltime = ltime;
	}
	/**
	 * 标签编号,逗号分割
	 **/
	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}
	/**
	 * 标签名称,逗号分割
	 **/
	public void setTagNames(String tagNames) {
		this.tagNames = tagNames;
	}
	
	/**
	 * 功能编号
	 **/
	public String getMenuId() {
		return this.menuId;
	}
	/**
	 * 功能名称
	 **/
	public String getMenuName() {
		return this.menuName;
	}
	/**
	 * 上级功能
	 **/
	public String getPmenuId() {
		return this.pmenuId;
	}
	/**
	 * 归属产品编号
	 **/
	public String getProductId() {
		return this.productId;
	}
	/**
	 * 备注
	 **/
	public String getRemark() {
		return this.remark;
	}
	/**
	 * 状态0初始1设计中2开发中3测试中4uat测试2已上线3已下线4已删除
	 **/
	public String getStatus() {
		return this.status;
	}
	/**
	 * 是否已上线
	 **/
	public String getOnline() {
		return this.online;
	}
	/**
	 * 需求链接
	 **/
	public String getDemandUrl() {
		return this.demandUrl;
	}
	/**
	 * 代码链接
	 **/
	public String getCodeUrl() {
		return this.codeUrl;
	}
	/**
	 * 设计链接
	 **/
	public String getDesignUrl() {
		return this.designUrl;
	}
	/**
	 * 文档链接
	 **/
	public String getDocUrl() {
		return this.docUrl;
	}
	/**
	 * 帮助文档链接
	 **/
	public String getHelpUrl() {
		return this.helpUrl;
	}
	/**
	 * 操作手册链接
	 **/
	public String getOperDocUrl() {
		return this.operDocUrl;
	}
	/**
	 * 排序序号
	 **/
	public String getSeqNo() {
		return this.seqNo;
	}
	/**
	 * 故事管理员编号
	 **/
	public String getMmUserid() {
		return this.mmUserid;
	}
	/**
	 * 故事管理员姓名
	 **/
	public String getMmUsername() {
		return this.mmUsername;
	}
	/**
	 * 创建时间
	 **/
	public Date getCtime() {
		return this.ctime;
	}
	/**
	 * 节点类型0-功能点，1-目录。目录下建功能点，功能点下不允许建立任何子节点
	 **/
	public String getNtype() {
		return this.ntype;
	}
	/**
	 * 开始版本
	 **/
	public String getSinceVersion() {
		return this.sinceVersion;
	}
	/**
	 * 儿子节点个数
	 **/
	public Integer getChildrenCnt() {
		return this.childrenCnt;
	}
	/**
	 * 更新时间
	 **/
	public Date getLtime() {
		return this.ltime;
	}
	/**
	 * 标签编号,逗号分割
	 **/
	public String getTagIds() {
		return this.tagIds;
	}
	/**
	 * 标签名称,逗号分割
	 **/
	public String getTagNames() {
		return this.tagNames;
	}

}