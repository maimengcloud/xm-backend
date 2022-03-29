package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmQuestion所有属性名: <br>
 *	id,name,projectId,projectName,caseId,caseName,endTime,askUserid,askUsername,handlerUserid,handlerUsername,priority,solution,description,createUserid,createUsername,createTime,bugStatus,bizProcInstId,bizFlowState,menuId,menuName,budgetWorkload,budgetCost,actWorkload,actCost,expectResult,opStep,currResult,refRequire,bugSeverity,bugType,tagIds,tagNames,urls,ltime,qtype,caseExecId,remarks,productId,repRate,verNum,vpath,pverNum,bugReason,rate,rworkload;<br>
 * 表 xm_question xm_question的所有字段名: <br>
 *	id,name,project_id,project_name,case_id,case_name,end_time,ask_userid,ask_username,handler_userid,handler_username,priority,solution,description,create_userid,create_username,create_time,bug_status,biz_proc_inst_id,biz_flow_state,menu_id,menu_name,budget_workload,budget_cost,act_workload,act_cost,expect_result,op_step,curr_result,ref_require,bug_severity,bug_type,tag_ids,tag_names,urls,ltime,qtype,case_exec_id,remarks,product_id,rep_rate,ver_num,vpath,pver_num,bug_reason,rate,rworkload;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="xm_question")
public class XmQuestion  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="问题编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="问题标题",allowEmptyValue=true,example="",allowableValues="")
	String name;
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="项目名称",allowEmptyValue=true,example="",allowableValues="")
	String projectName;
	
	@ApiModelProperty(notes="测试案例编号",allowEmptyValue=true,example="",allowableValues="")
	String caseId;
	
	@ApiModelProperty(notes="测试案例名称",allowEmptyValue=true,example="",allowableValues="")
	String caseName;
	
	@ApiModelProperty(notes="到期时间",allowEmptyValue=true,example="",allowableValues="")
	Date endTime;
	
	@ApiModelProperty(notes="提出人编号",allowEmptyValue=true,example="",allowableValues="")
	String askUserid;
	
	@ApiModelProperty(notes="提出人",allowEmptyValue=true,example="",allowableValues="")
	String askUsername;
	
	@ApiModelProperty(notes="处理人编号",allowEmptyValue=true,example="",allowableValues="")
	String handlerUserid;
	
	@ApiModelProperty(notes="处理人",allowEmptyValue=true,example="",allowableValues="")
	String handlerUsername;
	
	@ApiModelProperty(notes="优先级别1-非常紧急，2-紧急，3-一般紧急，4-低",allowEmptyValue=true,example="",allowableValues="")
	String priority;
	
	@ApiModelProperty(notes="解决方案:",allowEmptyValue=true,example="",allowableValues="")
	String solution;
	
	@ApiModelProperty(notes="问题描述",allowEmptyValue=true,example="",allowableValues="")
	String description;
	
	@ApiModelProperty(notes="问题创建人编号",allowEmptyValue=true,example="",allowableValues="")
	String createUserid;
	
	@ApiModelProperty(notes="问题创建人",allowEmptyValue=true,example="",allowableValues="")
	String createUsername;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date createTime;
	
	@ApiModelProperty(notes="bug状态1|新提交2|处理中3|已修复4|重新打开5|已发布6|已拒绝7|挂起",allowEmptyValue=true,example="",allowableValues="")
	String bugStatus;
	
	@ApiModelProperty(notes="当前流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String bizProcInstId;
	
	@ApiModelProperty(notes="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;
	
	@ApiModelProperty(notes="故事编号",allowEmptyValue=true,example="",allowableValues="")
	String menuId;
	
	@ApiModelProperty(notes="故事名称",allowEmptyValue=true,example="",allowableValues="")
	String menuName;
	
	@ApiModelProperty(notes="预估工时单位人时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetWorkload;
	
	@ApiModelProperty(notes="预估成本金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetCost;
	
	@ApiModelProperty(notes="实际工时（取报工实际工时汇总）",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actWorkload;
	
	@ApiModelProperty(notes="实际总金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actCost;
	
	@ApiModelProperty(notes="期望结果",allowEmptyValue=true,example="",allowableValues="")
	String expectResult;
	
	@ApiModelProperty(notes="操作步骤",allowEmptyValue=true,example="",allowableValues="")
	String opStep;
	
	@ApiModelProperty(notes="当前结果",allowEmptyValue=true,example="",allowableValues="")
	String currResult;
	
	@ApiModelProperty(notes="相关需求",allowEmptyValue=true,example="",allowableValues="")
	String refRequire;
	
	@ApiModelProperty(notes="严重程度1、2、3、4，分别对应：致命缺陷、严重缺陷、普通缺陷、轻微缺陷",allowEmptyValue=true,example="",allowableValues="")
	String bugSeverity;
	
	@ApiModelProperty(notes="BUG类型1、2、3、4，分别对应：代码错误、低级缺陷、设计缺陷、配置相关、安全相关、性能问题、其他",allowEmptyValue=true,example="",allowableValues="")
	String bugType;
	
	@ApiModelProperty(notes="标签id列表逗号分隔",allowEmptyValue=true,example="",allowableValues="")
	String tagIds;
	
	@ApiModelProperty(notes="标签名称列表逗号分隔",allowEmptyValue=true,example="",allowableValues="")
	String tagNames;
	
	@ApiModelProperty(notes="链接地址列表逗号分隔",allowEmptyValue=true,example="",allowableValues="")
	String urls;
	
	@ApiModelProperty(notes="最后更新时间",allowEmptyValue=true,example="",allowableValues="")
	Date ltime;
	
	@ApiModelProperty(notes="问题类型2-风险、1-功能问题、3-普通咨询、（暂时不用这个字段了）",allowEmptyValue=true,example="",allowableValues="")
	String qtype;
	
	@ApiModelProperty(notes="关联的案例执行编号",allowEmptyValue=true,example="",allowableValues="")
	String caseExecId;
	
	@ApiModelProperty(notes="最后更新说明",allowEmptyValue=true,example="",allowableValues="")
	String remarks;
	
	@ApiModelProperty(notes="产品编号",allowEmptyValue=true,example="",allowableValues="")
	String productId;
	
	@ApiModelProperty(notes="复现频率1-必现，2-大概率复现，3-小概率复现，4-仅出现一次",allowEmptyValue=true,example="",allowableValues="")
	String repRate;
	
	@ApiModelProperty(notes="版本号",allowEmptyValue=true,example="",allowableValues="")
	String verNum;
	
	@ApiModelProperty(notes="访问路径/斜杠分割",allowEmptyValue=true,example="",allowableValues="")
	String vpath;
	
	@ApiModelProperty(notes="发布版本",allowEmptyValue=true,example="",allowableValues="")
	String pverNum;
	
	@ApiModelProperty(notes="原因分析",allowEmptyValue=true,example="",allowableValues="")
	String bugReason;
	
	@ApiModelProperty(notes="进度0-100",allowEmptyValue=true,example="",allowableValues="")
	Integer rate;
	
	@ApiModelProperty(notes="剩余工时，手工填写",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal rworkload;

	/**问题编号**/
	public XmQuestion(String id) {
		this.id = id;
	}
    
    /**xm_question**/
	public XmQuestion() {
	}
	
	/**
	 * 问题编号
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 问题标题
	 **/
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 项目编号
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 项目名称
	 **/
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 测试案例编号
	 **/
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	/**
	 * 测试案例名称
	 **/
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	/**
	 * 到期时间
	 **/
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 提出人编号
	 **/
	public void setAskUserid(String askUserid) {
		this.askUserid = askUserid;
	}
	/**
	 * 提出人
	 **/
	public void setAskUsername(String askUsername) {
		this.askUsername = askUsername;
	}
	/**
	 * 处理人编号
	 **/
	public void setHandlerUserid(String handlerUserid) {
		this.handlerUserid = handlerUserid;
	}
	/**
	 * 处理人
	 **/
	public void setHandlerUsername(String handlerUsername) {
		this.handlerUsername = handlerUsername;
	}
	/**
	 * 优先级别1-非常紧急，2-紧急，3-一般紧急，4-低
	 **/
	public void setPriority(String priority) {
		this.priority = priority;
	}
	/**
	 * 解决方案:
	 **/
	public void setSolution(String solution) {
		this.solution = solution;
	}
	/**
	 * 问题描述
	 **/
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 问题创建人编号
	 **/
	public void setCreateUserid(String createUserid) {
		this.createUserid = createUserid;
	}
	/**
	 * 问题创建人
	 **/
	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}
	/**
	 * 创建时间
	 **/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * bug状态1|新提交2|处理中3|已修复4|重新打开5|已发布6|已拒绝7|挂起
	 **/
	public void setBugStatus(String bugStatus) {
		this.bugStatus = bugStatus;
	}
	/**
	 * 当前流程实例编号
	 **/
	public void setBizProcInstId(String bizProcInstId) {
		this.bizProcInstId = bizProcInstId;
	}
	/**
	 * 当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除
	 **/
	public void setBizFlowState(String bizFlowState) {
		this.bizFlowState = bizFlowState;
	}
	/**
	 * 故事编号
	 **/
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	/**
	 * 故事名称
	 **/
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/**
	 * 预估工时单位人时
	 **/
	public void setBudgetWorkload(BigDecimal budgetWorkload) {
		this.budgetWorkload = budgetWorkload;
	}
	/**
	 * 预估成本金额
	 **/
	public void setBudgetCost(BigDecimal budgetCost) {
		this.budgetCost = budgetCost;
	}
	/**
	 * 实际工时（取报工实际工时汇总）
	 **/
	public void setActWorkload(BigDecimal actWorkload) {
		this.actWorkload = actWorkload;
	}
	/**
	 * 实际总金额
	 **/
	public void setActCost(BigDecimal actCost) {
		this.actCost = actCost;
	}
	/**
	 * 期望结果
	 **/
	public void setExpectResult(String expectResult) {
		this.expectResult = expectResult;
	}
	/**
	 * 操作步骤
	 **/
	public void setOpStep(String opStep) {
		this.opStep = opStep;
	}
	/**
	 * 当前结果
	 **/
	public void setCurrResult(String currResult) {
		this.currResult = currResult;
	}
	/**
	 * 相关需求
	 **/
	public void setRefRequire(String refRequire) {
		this.refRequire = refRequire;
	}
	/**
	 * 严重程度1、2、3、4，分别对应：致命缺陷、严重缺陷、普通缺陷、轻微缺陷
	 **/
	public void setBugSeverity(String bugSeverity) {
		this.bugSeverity = bugSeverity;
	}
	/**
	 * BUG类型1、2、3、4，分别对应：代码错误、低级缺陷、设计缺陷、配置相关、安全相关、性能问题、其他
	 **/
	public void setBugType(String bugType) {
		this.bugType = bugType;
	}
	/**
	 * 标签id列表逗号分隔
	 **/
	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}
	/**
	 * 标签名称列表逗号分隔
	 **/
	public void setTagNames(String tagNames) {
		this.tagNames = tagNames;
	}
	/**
	 * 链接地址列表逗号分隔
	 **/
	public void setUrls(String urls) {
		this.urls = urls;
	}
	/**
	 * 最后更新时间
	 **/
	public void setLtime(Date ltime) {
		this.ltime = ltime;
	}
	/**
	 * 问题类型2-风险、1-功能问题、3-普通咨询、（暂时不用这个字段了）
	 **/
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
	/**
	 * 关联的案例执行编号
	 **/
	public void setCaseExecId(String caseExecId) {
		this.caseExecId = caseExecId;
	}
	/**
	 * 最后更新说明
	 **/
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 产品编号
	 **/
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * 复现频率1-必现，2-大概率复现，3-小概率复现，4-仅出现一次
	 **/
	public void setRepRate(String repRate) {
		this.repRate = repRate;
	}
	/**
	 * 版本号
	 **/
	public void setVerNum(String verNum) {
		this.verNum = verNum;
	}
	/**
	 * 访问路径/斜杠分割
	 **/
	public void setVpath(String vpath) {
		this.vpath = vpath;
	}
	/**
	 * 发布版本
	 **/
	public void setPverNum(String pverNum) {
		this.pverNum = pverNum;
	}
	/**
	 * 原因分析
	 **/
	public void setBugReason(String bugReason) {
		this.bugReason = bugReason;
	}
	/**
	 * 进度0-100
	 **/
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	/**
	 * 剩余工时，手工填写
	 **/
	public void setRworkload(BigDecimal rworkload) {
		this.rworkload = rworkload;
	}
	
	/**
	 * 问题编号
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 问题标题
	 **/
	public String getName() {
		return this.name;
	}
	/**
	 * 项目编号
	 **/
	public String getProjectId() {
		return this.projectId;
	}
	/**
	 * 项目名称
	 **/
	public String getProjectName() {
		return this.projectName;
	}
	/**
	 * 测试案例编号
	 **/
	public String getCaseId() {
		return this.caseId;
	}
	/**
	 * 测试案例名称
	 **/
	public String getCaseName() {
		return this.caseName;
	}
	/**
	 * 到期时间
	 **/
	public Date getEndTime() {
		return this.endTime;
	}
	/**
	 * 提出人编号
	 **/
	public String getAskUserid() {
		return this.askUserid;
	}
	/**
	 * 提出人
	 **/
	public String getAskUsername() {
		return this.askUsername;
	}
	/**
	 * 处理人编号
	 **/
	public String getHandlerUserid() {
		return this.handlerUserid;
	}
	/**
	 * 处理人
	 **/
	public String getHandlerUsername() {
		return this.handlerUsername;
	}
	/**
	 * 优先级别1-非常紧急，2-紧急，3-一般紧急，4-低
	 **/
	public String getPriority() {
		return this.priority;
	}
	/**
	 * 解决方案:
	 **/
	public String getSolution() {
		return this.solution;
	}
	/**
	 * 问题描述
	 **/
	public String getDescription() {
		return this.description;
	}
	/**
	 * 问题创建人编号
	 **/
	public String getCreateUserid() {
		return this.createUserid;
	}
	/**
	 * 问题创建人
	 **/
	public String getCreateUsername() {
		return this.createUsername;
	}
	/**
	 * 创建时间
	 **/
	public Date getCreateTime() {
		return this.createTime;
	}
	/**
	 * bug状态1|新提交2|处理中3|已修复4|重新打开5|已发布6|已拒绝7|挂起
	 **/
	public String getBugStatus() {
		return this.bugStatus;
	}
	/**
	 * 当前流程实例编号
	 **/
	public String getBizProcInstId() {
		return this.bizProcInstId;
	}
	/**
	 * 当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除
	 **/
	public String getBizFlowState() {
		return this.bizFlowState;
	}
	/**
	 * 故事编号
	 **/
	public String getMenuId() {
		return this.menuId;
	}
	/**
	 * 故事名称
	 **/
	public String getMenuName() {
		return this.menuName;
	}
	/**
	 * 预估工时单位人时
	 **/
	public BigDecimal getBudgetWorkload() {
		return this.budgetWorkload;
	}
	/**
	 * 预估成本金额
	 **/
	public BigDecimal getBudgetCost() {
		return this.budgetCost;
	}
	/**
	 * 实际工时（取报工实际工时汇总）
	 **/
	public BigDecimal getActWorkload() {
		return this.actWorkload;
	}
	/**
	 * 实际总金额
	 **/
	public BigDecimal getActCost() {
		return this.actCost;
	}
	/**
	 * 期望结果
	 **/
	public String getExpectResult() {
		return this.expectResult;
	}
	/**
	 * 操作步骤
	 **/
	public String getOpStep() {
		return this.opStep;
	}
	/**
	 * 当前结果
	 **/
	public String getCurrResult() {
		return this.currResult;
	}
	/**
	 * 相关需求
	 **/
	public String getRefRequire() {
		return this.refRequire;
	}
	/**
	 * 严重程度1、2、3、4，分别对应：致命缺陷、严重缺陷、普通缺陷、轻微缺陷
	 **/
	public String getBugSeverity() {
		return this.bugSeverity;
	}
	/**
	 * BUG类型1、2、3、4，分别对应：代码错误、低级缺陷、设计缺陷、配置相关、安全相关、性能问题、其他
	 **/
	public String getBugType() {
		return this.bugType;
	}
	/**
	 * 标签id列表逗号分隔
	 **/
	public String getTagIds() {
		return this.tagIds;
	}
	/**
	 * 标签名称列表逗号分隔
	 **/
	public String getTagNames() {
		return this.tagNames;
	}
	/**
	 * 链接地址列表逗号分隔
	 **/
	public String getUrls() {
		return this.urls;
	}
	/**
	 * 最后更新时间
	 **/
	public Date getLtime() {
		return this.ltime;
	}
	/**
	 * 问题类型2-风险、1-功能问题、3-普通咨询、（暂时不用这个字段了）
	 **/
	public String getQtype() {
		return this.qtype;
	}
	/**
	 * 关联的案例执行编号
	 **/
	public String getCaseExecId() {
		return this.caseExecId;
	}
	/**
	 * 最后更新说明
	 **/
	public String getRemarks() {
		return this.remarks;
	}
	/**
	 * 产品编号
	 **/
	public String getProductId() {
		return this.productId;
	}
	/**
	 * 复现频率1-必现，2-大概率复现，3-小概率复现，4-仅出现一次
	 **/
	public String getRepRate() {
		return this.repRate;
	}
	/**
	 * 版本号
	 **/
	public String getVerNum() {
		return this.verNum;
	}
	/**
	 * 访问路径/斜杠分割
	 **/
	public String getVpath() {
		return this.vpath;
	}
	/**
	 * 发布版本
	 **/
	public String getPverNum() {
		return this.pverNum;
	}
	/**
	 * 原因分析
	 **/
	public String getBugReason() {
		return this.bugReason;
	}
	/**
	 * 进度0-100
	 **/
	public Integer getRate() {
		return this.rate;
	}
	/**
	 * 剩余工时，手工填写
	 **/
	public BigDecimal getRworkload() {
		return this.rworkload;
	}

}