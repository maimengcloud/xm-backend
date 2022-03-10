package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmMenu所有属性名: <br>
 *	menuId,menuName,pmenuId,productId,remark,status,online,demandUrl,codeUrl,designUrl,docUrl,helpUrl,operDocUrl,seqNo,mmUserid,mmUsername,ctime,ntype,sinceVersion,childrenCnt,ltime,tagIds,tagNames,pidPaths,lvl,isTpl,budgetHours,budgetStaffNu,budgetWorkload,budgetAmount,phaseId,iterationId,calcType,mactWorkload,mactAmount,mactRate;<br>
 * 表 xm_menu 功能表的所有字段名: <br>
 *	menu_id,menu_name,pmenu_id,product_id,remark,status,online,demand_url,code_url,design_url,doc_url,help_url,oper_doc_url,seq_no,mm_userid,mm_username,ctime,ntype,since_version,children_cnt,ltime,tag_ids,tag_names,pid_paths,lvl,is_tpl,budget_hours,budget_staff_nu,budget_workload,budget_amount,phase_id,iteration_id,calc_type,mact_workload,mact_amount,mact_rate;<br>
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
	
	@ApiModelProperty(notes="父级id逗号分割，最后一个为本节点节点编号,以,号结尾",allowEmptyValue=true,example="",allowableValues="")
	String pidPaths;
	
	@ApiModelProperty(notes="层级0-顶级，1-一级，2-二级，3-三级，4-四级。总共5级",allowEmptyValue=true,example="",allowableValues="")
	Integer lvl;
	
	@ApiModelProperty(notes="是否为模板",allowEmptyValue=true,example="",allowableValues="")
	String isTpl;
	
	@ApiModelProperty(notes="预算工时总数从上到下分配",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetHours;
	
	@ApiModelProperty(notes="投入人员数，从上到下分配",allowEmptyValue=true,example="",allowableValues="")
	Integer budgetStaffNu;
	
	@ApiModelProperty(notes="总工作量单位人时，从上到下分配，下级汇总不能大于上级",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetWorkload;
	
	@ApiModelProperty(notes="预算金额，从上到下汇总，从上到下分配，下级汇总不能大于上级",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetAmount;
	
	@ApiModelProperty(notes="计划编号",allowEmptyValue=true,example="",allowableValues="")
	String phaseId;
	
	@ApiModelProperty(notes="迭代编号",allowEmptyValue=true,example="",allowableValues="")
	String iterationId;
	
	@ApiModelProperty(notes="叶子节点数据收集方式0-不计算，1-由任务汇总，2-手工填报",allowEmptyValue=true,example="",allowableValues="")
	String calcType;
	
	@ApiModelProperty(notes="手工填报的情况下填报的工作量，其余为下级往上汇总数据",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal mactWorkload;
	
	@ApiModelProperty(notes="手工填报情况下填报的费用总额，其余为下级往上汇总数据",allowEmptyValue=true,example="",allowableValues="")
	String mactAmount;
	
	@ApiModelProperty(notes="手工填报下的进度",allowEmptyValue=true,example="",allowableValues="")
	Integer mactRate;

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
	 * 状态0初始1待评审2待设计3待开发4待sit测试5待uat测试6已测试待上线7已上线8已下线9已删除
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
	 * 父级id逗号分割，最后一个为本节点节点编号,以,号结尾
	 **/
	public void setPidPaths(String pidPaths) {
		this.pidPaths = pidPaths;
	}
	/**
	 * 层级0-顶级，1-一级，2-二级，3-三级，4-四级。总共5级
	 **/
	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}
	/**
	 * 是否为模板
	 **/
	public void setIsTpl(String isTpl) {
		this.isTpl = isTpl;
	}
	/**
	 * 预算工时总数从上到下分配
	 **/
	public void setBudgetHours(BigDecimal budgetHours) {
		this.budgetHours = budgetHours;
	}
	/**
	 * 投入人员数，从上到下分配
	 **/
	public void setBudgetStaffNu(Integer budgetStaffNu) {
		this.budgetStaffNu = budgetStaffNu;
	}
	/**
	 * 总工作量单位人时，从上到下分配，下级汇总不能大于上级
	 **/
	public void setBudgetWorkload(BigDecimal budgetWorkload) {
		this.budgetWorkload = budgetWorkload;
	}
	/**
	 * 预算金额，从上到下汇总，从上到下分配，下级汇总不能大于上级
	 **/
	public void setBudgetAmount(BigDecimal budgetAmount) {
		this.budgetAmount = budgetAmount;
	}
	/**
	 * 计划编号
	 **/
	public void setPhaseId(String phaseId) {
		this.phaseId = phaseId;
	}
	/**
	 * 迭代编号
	 **/
	public void setIterationId(String iterationId) {
		this.iterationId = iterationId;
	}
	/**
	 * 叶子节点数据收集方式0-不计算，1-由任务汇总，2-手工填报
	 **/
	public void setCalcType(String calcType) {
		this.calcType = calcType;
	}
	/**
	 * 手工填报的情况下填报的工作量，其余为下级往上汇总数据
	 **/
	public void setMactWorkload(BigDecimal mactWorkload) {
		this.mactWorkload = mactWorkload;
	}
	/**
	 * 手工填报情况下填报的费用总额，其余为下级往上汇总数据
	 **/
	public void setMactAmount(String mactAmount) {
		this.mactAmount = mactAmount;
	}
	/**
	 * 手工填报下的进度
	 **/
	public void setMactRate(Integer mactRate) {
		this.mactRate = mactRate;
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
	 * 状态0初始1待评审2待设计3待开发4待sit测试5待uat测试6已测试待上线7已上线8已下线9已删除
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
	/**
	 * 父级id逗号分割，最后一个为本节点节点编号,以,号结尾
	 **/
	public String getPidPaths() {
		return this.pidPaths;
	}
	/**
	 * 层级0-顶级，1-一级，2-二级，3-三级，4-四级。总共5级
	 **/
	public Integer getLvl() {
		return this.lvl;
	}
	/**
	 * 是否为模板
	 **/
	public String getIsTpl() {
		return this.isTpl;
	}
	/**
	 * 预算工时总数从上到下分配
	 **/
	public BigDecimal getBudgetHours() {
		return this.budgetHours;
	}
	/**
	 * 投入人员数，从上到下分配
	 **/
	public Integer getBudgetStaffNu() {
		return this.budgetStaffNu;
	}
	/**
	 * 总工作量单位人时，从上到下分配，下级汇总不能大于上级
	 **/
	public BigDecimal getBudgetWorkload() {
		return this.budgetWorkload;
	}
	/**
	 * 预算金额，从上到下汇总，从上到下分配，下级汇总不能大于上级
	 **/
	public BigDecimal getBudgetAmount() {
		return this.budgetAmount;
	}
	/**
	 * 计划编号
	 **/
	public String getPhaseId() {
		return this.phaseId;
	}
	/**
	 * 迭代编号
	 **/
	public String getIterationId() {
		return this.iterationId;
	}
	/**
	 * 叶子节点数据收集方式0-不计算，1-由任务汇总，2-手工填报
	 **/
	public String getCalcType() {
		return this.calcType;
	}
	/**
	 * 手工填报的情况下填报的工作量，其余为下级往上汇总数据
	 **/
	public BigDecimal getMactWorkload() {
		return this.mactWorkload;
	}
	/**
	 * 手工填报情况下填报的费用总额，其余为下级往上汇总数据
	 **/
	public String getMactAmount() {
		return this.mactAmount;
	}
	/**
	 * 手工填报下的进度
	 **/
	public Integer getMactRate() {
		return this.mactRate;
	}

}