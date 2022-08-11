package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmTask所有属性名: <br>
 *	"id","任务编号","name","任务名称","parentTaskid","父任务编号","parentTaskname","父任务名称","projectId","项目编号","projectName","项目名称","level","任务级别","sortLevel","序号","executorUserid","任务执行人编号","executorUsername","任务执行人","preTaskid","前置任务编号","preTaskname","前置任务名称","startTime","任务开始时间","endTime","任务结束时间","milestone","里程碑","description","任务描述","remarks","备注","createUserid","任务创建人编号（谁创建谁负责）","createUsername","任务创建人（谁创建谁负责）","createTime","创建时间","rate","任务进度0-100（=实际工时/(实际工时+剩余工时)*100）","budgetAt","当前任务预算金额（calc_type=2时预算工时*单价，calc_type=1时下级汇总）","budgetWorkload","预算工时（calc_type=2时手工填写，calc_type=1时下级汇总）","actAt","当前任务实际费用金额（calc_type=2时，取实际工时*单价，calc_type=1时取下级汇总数据）待结算金额","actWorkload","任务取工时表报工工时汇总，","taskState","任务状态0待领取1已领取执行中2已完工3已验收4已结算9已关闭","taskType","0售前方案1投标2需求3设计4开发5测试6验收7部署8运维--来自基础数据表taskType","taskClass","1需结算0不需结算","toTaskCenter","是否发布到任务大厅0否1是,1时互联网可访问","actStartTime","实际开始时间-任务状态变成执行中的时间","actEndTime","实际结束时间-任务状态变成完工状态时的时间","bizProcInstId","当前流程实例编号","bizFlowState","当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除","phaseId","项目阶段编号(作废)","phaseName","项目阶段名称(作废)","taskSkillNames","技能列表,逗号分隔","exeUsernames","执行人列表逗号分隔如陈x(审核人),王x(监控人)","taskSkillIds","技能编号列表逗号分隔","exeUserids","执行人编号列表逗号分隔如u1(1),u2(2)","taskOut","执行方式-0内研1外购","planType","计划类型w1-周,w2-2周,w3-3周,m1-1月,m2-2月,q1-季,q2-半年，y1-年","settleSchemel","任务结算方案-来自数字字典xmTaskSettleSchemel","menuId","归属功能编号","menuName","归属功能名称","productId","产品编号根据功能变化带进","cbranchId","创建机构","cdeptid","创建部门","tagIds","标签编号，逗号分割","tagNames","标签名称，逗号分割","ntype","节点类型0-任务，1-计划。计划下可建立计划和任务，任务下不允许再扩展。也就是非叶子节点都是计划，叶子节点有可能是计划或者任务","childrenCnt","儿子节点个数","ltime","更新时间","pidPaths","父级id逗号分割，最后一个为本节点节点编号,以,号结尾","lvl","层级0-顶级，1-一级，2-二级，3-三级，4-四级。总共5级","isTpl","是否为模板","keyPath","是否为关键路径上的节点","uniInnerPrice","内部单位工时单价","uniOutPrice","外部单位工时单价","calcType","数据统计方式","ptype","计划分类0-项目，1产品,空为不区分","wtype","报工方式1-强制每日报工，2-工期内报工，0-无需报工","bctrl","报工限制0-不限制，1-不得超出预估工时","initWorkload","原始预估工作量，budget_workload发生变化后，进行备份","shareFee","分享赚佣金","oshare","开启分享赚功能0-否1-待付款，2已付款","crowd","是否众包0否1是，众包属于外购的一种","browseUsers","浏览人数","execUsers","投标人数","cityId","城市编号","cityName","城市名称","regionType","地域限制方式0-不限制，1-同城，2-同省，3-同国，4-同洲","browseTimes","浏览次数","capaLvls","能力等级最小要求","tranMode","交易模式1-招标，2-雇佣","supRequires","保障要求编号列表，多个逗号分割","hot","是否为热搜0否1待付款2已开通3已过期,每次热搜3天，3天后自动取消热搜","top","是否为置顶0否1待付款2已开通3已过期,每次置顶3天，3天后自动取消置顶","urgent","加急0否1待付款2已开通3已过期","crmSup","客服包办0否1待付款2已开通，理顺需求、比稿选稿","bidStep","投标流程0-草稿，1-发布需求，2-用户投标，3雇主选标，4拓管赏金，5用户工作，6验收付款,7完结","interestLvls","会员等级最小要求","filePaths","附件地址列表，逗号分割","estate","资金托管状况0-无须托管，1-待付款，2-已托管资金，3-已付款给服务商，4-已退款","efunds","托管金额=quote_final_at","etoPlatTime","托管资金付款给平台的时间","etoDevTime","托管资金支付给服务商的时间","ebackTime","托管资金退回甲方时间","topStime","置顶开始时间","topEtime","置顶结束时间","hotStime","热搜开始时间","hotEtime","热搜结束时间","urgentStime","加急开始时间","urgentEtime","加急结束时间","quoteFinalAt","众包最终确定价格","provinceId","省编号","provinceName","省名称","areaId","区县编号","areaName","区县名称";<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
 @Data
@ApiModel(description="项目任务表")
public class XmTask  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="任务编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="任务名称",allowEmptyValue=true,example="",allowableValues="")
	String name;
	
	@ApiModelProperty(notes="父任务编号",allowEmptyValue=true,example="",allowableValues="")
	String parentTaskid;
	
	@ApiModelProperty(notes="父任务名称",allowEmptyValue=true,example="",allowableValues="")
	String parentTaskname;
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="项目名称",allowEmptyValue=true,example="",allowableValues="")
	String projectName;
	
	@ApiModelProperty(notes="任务级别",allowEmptyValue=true,example="",allowableValues="")
	String level;
	
	@ApiModelProperty(notes="序号",allowEmptyValue=true,example="",allowableValues="")
	String sortLevel;
	
	@ApiModelProperty(notes="任务执行人编号",allowEmptyValue=true,example="",allowableValues="")
	String executorUserid;
	
	@ApiModelProperty(notes="任务执行人",allowEmptyValue=true,example="",allowableValues="")
	String executorUsername;
	
	@ApiModelProperty(notes="前置任务编号",allowEmptyValue=true,example="",allowableValues="")
	String preTaskid;
	
	@ApiModelProperty(notes="前置任务名称",allowEmptyValue=true,example="",allowableValues="")
	String preTaskname;
	
	@ApiModelProperty(notes="任务开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date startTime;
	
	@ApiModelProperty(notes="任务结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date endTime;
	
	@ApiModelProperty(notes="里程碑",allowEmptyValue=true,example="",allowableValues="")
	String milestone;
	
	@ApiModelProperty(notes="任务描述",allowEmptyValue=true,example="",allowableValues="")
	String description;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remarks;
	
	@ApiModelProperty(notes="任务创建人编号（谁创建谁负责）",allowEmptyValue=true,example="",allowableValues="")
	String createUserid;
	
	@ApiModelProperty(notes="任务创建人（谁创建谁负责）",allowEmptyValue=true,example="",allowableValues="")
	String createUsername;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date createTime;
	
	@ApiModelProperty(notes="任务进度0-100（=实际工时/(实际工时+剩余工时)*100）",allowEmptyValue=true,example="",allowableValues="")
	Integer rate;
	
	@ApiModelProperty(notes="当前任务预算金额（calc_type=2时预算工时*单价，calc_type=1时下级汇总）",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetAt;
	
	@ApiModelProperty(notes="预算工时（calc_type=2时手工填写，calc_type=1时下级汇总）",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetWorkload;
	
	@ApiModelProperty(notes="当前任务实际费用金额（calc_type=2时，取实际工时*单价，calc_type=1时取下级汇总数据）待结算金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actAt;
	
	@ApiModelProperty(notes="任务取工时表报工工时汇总，",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actWorkload;
	
	@ApiModelProperty(notes="任务状态0待领取1已领取执行中2已完工3已验收4已结算9已关闭",allowEmptyValue=true,example="",allowableValues="")
	String taskState;
	
	@ApiModelProperty(notes="0售前方案1投标2需求3设计4开发5测试6验收7部署8运维--来自基础数据表taskType",allowEmptyValue=true,example="",allowableValues="")
	String taskType;
	
	@ApiModelProperty(notes="1需结算0不需结算",allowEmptyValue=true,example="",allowableValues="")
	String taskClass;
	
	@ApiModelProperty(notes="是否发布到任务大厅0否1是,1时互联网可访问",allowEmptyValue=true,example="",allowableValues="")
	String toTaskCenter;
	
	@ApiModelProperty(notes="实际开始时间-任务状态变成执行中的时间",allowEmptyValue=true,example="",allowableValues="")
	Date actStartTime;
	
	@ApiModelProperty(notes="实际结束时间-任务状态变成完工状态时的时间",allowEmptyValue=true,example="",allowableValues="")
	Date actEndTime;
	
	@ApiModelProperty(notes="当前流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String bizProcInstId;
	
	@ApiModelProperty(notes="当前流程状态0初始1审批中2审批通过3审批不通过4流程取消或者删除",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;
	
	@ApiModelProperty(notes="项目阶段编号(作废)",allowEmptyValue=true,example="",allowableValues="")
	String phaseId;
	
	@ApiModelProperty(notes="项目阶段名称(作废)",allowEmptyValue=true,example="",allowableValues="")
	String phaseName;
	
	@ApiModelProperty(notes="技能列表,逗号分隔",allowEmptyValue=true,example="",allowableValues="")
	String taskSkillNames;
	
	@ApiModelProperty(notes="执行人列表逗号分隔如陈x(审核人),王x(监控人)",allowEmptyValue=true,example="",allowableValues="")
	String exeUsernames;
	
	@ApiModelProperty(notes="技能编号列表逗号分隔",allowEmptyValue=true,example="",allowableValues="")
	String taskSkillIds;
	
	@ApiModelProperty(notes="执行人编号列表逗号分隔如u1(1),u2(2)",allowEmptyValue=true,example="",allowableValues="")
	String exeUserids;
	
	@ApiModelProperty(notes="执行方式-0内研1外购",allowEmptyValue=true,example="",allowableValues="")
	String taskOut;
	
	@ApiModelProperty(notes="计划类型w1-周,w2-2周,w3-3周,m1-1月,m2-2月,q1-季,q2-半年，y1-年",allowEmptyValue=true,example="",allowableValues="")
	String planType;
	
	@ApiModelProperty(notes="任务结算方案-来自数字字典xmTaskSettleSchemel",allowEmptyValue=true,example="",allowableValues="")
	String settleSchemel;
	
	@ApiModelProperty(notes="归属功能编号",allowEmptyValue=true,example="",allowableValues="")
	String menuId;
	
	@ApiModelProperty(notes="归属功能名称",allowEmptyValue=true,example="",allowableValues="")
	String menuName;
	
	@ApiModelProperty(notes="产品编号根据功能变化带进",allowEmptyValue=true,example="",allowableValues="")
	String productId;
	
	@ApiModelProperty(notes="创建机构",allowEmptyValue=true,example="",allowableValues="")
	String cbranchId;
	
	@ApiModelProperty(notes="创建部门",allowEmptyValue=true,example="",allowableValues="")
	String cdeptid;
	
	@ApiModelProperty(notes="标签编号，逗号分割",allowEmptyValue=true,example="",allowableValues="")
	String tagIds;
	
	@ApiModelProperty(notes="标签名称，逗号分割",allowEmptyValue=true,example="",allowableValues="")
	String tagNames;
	
	@ApiModelProperty(notes="节点类型0-任务，1-计划。计划下可建立计划和任务，任务下不允许再扩展。也就是非叶子节点都是计划，叶子节点有可能是计划或者任务",allowEmptyValue=true,example="",allowableValues="")
	String ntype;
	
	@ApiModelProperty(notes="儿子节点个数",allowEmptyValue=true,example="",allowableValues="")
	Integer childrenCnt;
	
	@ApiModelProperty(notes="更新时间",allowEmptyValue=true,example="",allowableValues="")
	Date ltime;
	
	@ApiModelProperty(notes="父级id逗号分割，最后一个为本节点节点编号,以,号结尾",allowEmptyValue=true,example="",allowableValues="")
	String pidPaths;
	
	@ApiModelProperty(notes="层级0-顶级，1-一级，2-二级，3-三级，4-四级。总共5级",allowEmptyValue=true,example="",allowableValues="")
	Integer lvl;
	
	@ApiModelProperty(notes="是否为模板",allowEmptyValue=true,example="",allowableValues="")
	String isTpl;
	
	@ApiModelProperty(notes="是否为关键路径上的节点",allowEmptyValue=true,example="",allowableValues="")
	String keyPath;
	
	@ApiModelProperty(notes="内部单位工时单价",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal uniInnerPrice;
	
	@ApiModelProperty(notes="外部单位工时单价",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal uniOutPrice;
	
	@ApiModelProperty(notes="数据统计方式",allowEmptyValue=true,example="",allowableValues="")
	String calcType;
	
	@ApiModelProperty(notes="计划分类0-项目，1产品,空为不区分",allowEmptyValue=true,example="",allowableValues="")
	String ptype;
	
	@ApiModelProperty(notes="报工方式1-强制每日报工，2-工期内报工，0-无需报工",allowEmptyValue=true,example="",allowableValues="")
	String wtype;
	
	@ApiModelProperty(notes="报工限制0-不限制，1-不得超出预估工时",allowEmptyValue=true,example="",allowableValues="")
	String bctrl;
	
	@ApiModelProperty(notes="原始预估工作量，budget_workload发生变化后，进行备份",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal initWorkload;
	
	@ApiModelProperty(notes="分享赚佣金",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal shareFee;
	
	@ApiModelProperty(notes="开启分享赚功能0-否1-待付款，2已付款",allowEmptyValue=true,example="",allowableValues="")
	String oshare;
	
	@ApiModelProperty(notes="是否众包0否1是，众包属于外购的一种",allowEmptyValue=true,example="",allowableValues="")
	String crowd;
	
	@ApiModelProperty(notes="浏览人数",allowEmptyValue=true,example="",allowableValues="")
	Integer browseUsers;
	
	@ApiModelProperty(notes="投标人数",allowEmptyValue=true,example="",allowableValues="")
	Integer execUsers;
	
	@ApiModelProperty(notes="城市编号",allowEmptyValue=true,example="",allowableValues="")
	String cityId;
	
	@ApiModelProperty(notes="城市名称",allowEmptyValue=true,example="",allowableValues="")
	String cityName;
	
	@ApiModelProperty(notes="地域限制方式0-不限制，1-同城，2-同省，3-同国，4-同洲",allowEmptyValue=true,example="",allowableValues="")
	String regionType;
	
	@ApiModelProperty(notes="浏览次数",allowEmptyValue=true,example="",allowableValues="")
	Integer browseTimes;
	
	@ApiModelProperty(notes="能力等级最小要求",allowEmptyValue=true,example="",allowableValues="")
	String capaLvls;
	
	@ApiModelProperty(notes="交易模式1-招标，2-雇佣",allowEmptyValue=true,example="",allowableValues="")
	String tranMode;
	
	@ApiModelProperty(notes="保障要求编号列表，多个逗号分割",allowEmptyValue=true,example="",allowableValues="")
	String supRequires;
	
	@ApiModelProperty(notes="是否为热搜0否1待付款2已开通3已过期,每次热搜3天，3天后自动取消热搜",allowEmptyValue=true,example="",allowableValues="")
	String hot;
	
	@ApiModelProperty(notes="是否为置顶0否1待付款2已开通3已过期,每次置顶3天，3天后自动取消置顶",allowEmptyValue=true,example="",allowableValues="")
	String top;
	
	@ApiModelProperty(notes="加急0否1待付款2已开通3已过期",allowEmptyValue=true,example="",allowableValues="")
	String urgent;
	
	@ApiModelProperty(notes="客服包办0否1待付款2已开通，理顺需求、比稿选稿",allowEmptyValue=true,example="",allowableValues="")
	String crmSup;
	
	@ApiModelProperty(notes="投标流程0-草稿，1-发布需求，2-用户投标，3雇主选标，4拓管赏金，5用户工作，6验收付款,7完结",allowEmptyValue=true,example="",allowableValues="")
	String bidStep;
	
	@ApiModelProperty(notes="会员等级最小要求",allowEmptyValue=true,example="",allowableValues="")
	String interestLvls;
	
	@ApiModelProperty(notes="附件地址列表，逗号分割",allowEmptyValue=true,example="",allowableValues="")
	String filePaths;
	
	@ApiModelProperty(notes="资金托管状况0-无须托管，1-待付款，2-已托管资金，3-已付款给服务商，4-已退款",allowEmptyValue=true,example="",allowableValues="")
	String estate;
	
	@ApiModelProperty(notes="托管金额=quote_final_at",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal efunds;
	
	@ApiModelProperty(notes="托管资金付款给平台的时间",allowEmptyValue=true,example="",allowableValues="")
	Date etoPlatTime;
	
	@ApiModelProperty(notes="托管资金支付给服务商的时间",allowEmptyValue=true,example="",allowableValues="")
	Date etoDevTime;
	
	@ApiModelProperty(notes="托管资金退回甲方时间",allowEmptyValue=true,example="",allowableValues="")
	Date ebackTime;
	
	@ApiModelProperty(notes="置顶开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date topStime;
	
	@ApiModelProperty(notes="置顶结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date topEtime;
	
	@ApiModelProperty(notes="热搜开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date hotStime;
	
	@ApiModelProperty(notes="热搜结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date hotEtime;
	
	@ApiModelProperty(notes="加急开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date urgentStime;
	
	@ApiModelProperty(notes="加急结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date urgentEtime;
	
	@ApiModelProperty(notes="众包最终确定价格",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal quoteFinalAt;
	
	@ApiModelProperty(notes="省编号",allowEmptyValue=true,example="",allowableValues="")
	String provinceId;
	
	@ApiModelProperty(notes="省名称",allowEmptyValue=true,example="",allowableValues="")
	String provinceName;
	
	@ApiModelProperty(notes="区县编号",allowEmptyValue=true,example="",allowableValues="")
	String areaId;
	
	@ApiModelProperty(notes="区县名称",allowEmptyValue=true,example="",allowableValues="")
	String areaName;

	/**
	 *任务编号
	 **/
	public XmTask(String id) {
		this.id = id;
	}
    
    /**
     * 项目任务表
     **/
	public XmTask() {
	}

}