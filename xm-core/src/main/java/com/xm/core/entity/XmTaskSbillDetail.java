package  com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmTaskSbillDetail所有属性名: <br>
 *	userid,username,ctime,taskId,bizDate,remark,id,sbillId,stime,sstatus,amt,samt,workload,projectId,sworkload,bizMonth,budgetAt,budgetWorkload,initWorkload,quoteAt,quoteWorkload,sschemel,uniPrice,qendTime,qstartTime,actEndTime,actStartTime,oshare,shareFee,sfee,sfeeRate,cpId,cpName,cpType,distUserid,distUsername,shareKey,taskOut,crowd,othFee,feeRemark,tactAt;<br>
 * 表 xm_task_sbill_detail 工时登记表的所有字段名: <br>
 *	userid,username,ctime,task_id,biz_date,remark,id,sbill_id,stime,sstatus,amt,samt,workload,project_id,sworkload,biz_month,budget_at,budget_workload,init_workload,quote_at,quote_workload,sschemel,uni_price,qend_time,qstart_time,act_end_time,act_start_time,oshare,share_fee,sfee,sfee_rate,cp_id,cp_name,cp_type,dist_userid,dist_username,share_key,task_out,crowd,oth_fee,fee_remark,tact_at;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="工时登记表")
public class XmTaskSbillDetail  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="员工编号",allowEmptyValue=true,example="",allowableValues="")
	String userid;
	
	@ApiModelProperty(notes="姓名",allowEmptyValue=true,example="",allowableValues="")
	String username;
	
	@ApiModelProperty(notes="创建日期",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="业务对象主键任务编号",allowEmptyValue=true,example="",allowableValues="")
	String taskId;
	
	@ApiModelProperty(notes="业务日期yyyy-MM-dd",allowEmptyValue=true,example="",allowableValues="")
	String bizDate;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="结算单据编号-来自task_sbill.id",allowEmptyValue=true,example="",allowableValues="")
	String sbillId;
	
	@ApiModelProperty(notes="结算提交时间",allowEmptyValue=true,example="",allowableValues="")
	Date stime;
	
	@ApiModelProperty(notes="结算状态0-无需结算，1-待结算2-已提交3-已通过4-已结算",allowEmptyValue=true,example="",allowableValues="")
	String sstatus;
	
	@ApiModelProperty(notes="工时对应金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal amt;
	
	@ApiModelProperty(notes="结算工时对应结算金额-根据结算方案计算结算金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal samt;
	
	@ApiModelProperty(notes="报工工时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal workload;
	
	@ApiModelProperty(notes="归属项目",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="结算工时，用于结算，默认=workload",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal sworkload;
	
	@ApiModelProperty(notes="月份yyyy-MM型",allowEmptyValue=true,example="",allowableValues="")
	String bizMonth;
	
	@ApiModelProperty(notes="任务预算金额-来自task表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetAt;
	
	@ApiModelProperty(notes="任务预算工时-来自task表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetWorkload;
	
	@ApiModelProperty(notes="任务初始工时-来自task表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal initWorkload;
	
	@ApiModelProperty(notes="报价金额-来自task_execuser表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal quoteAt;
	
	@ApiModelProperty(notes="报价工时-来自task_execuser表",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal quoteWorkload;
	
	@ApiModelProperty(notes="任务结算方案,来自task表、来自数字字典xmTaskSettleSchemel",allowEmptyValue=true,example="",allowableValues="")
	String sschemel;
	
	@ApiModelProperty(notes="工时单价，来自task表，根据task_out判断取内部还是外部单价",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal uniPrice;
	
	@ApiModelProperty(notes="报价结束时间",allowEmptyValue=true,example="",allowableValues="")
	Date qendTime;
	
	@ApiModelProperty(notes="报价开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date qstartTime;
	
	@ApiModelProperty(notes="实际完工时间-来自task表",allowEmptyValue=true,example="",allowableValues="")
	Date actEndTime;
	
	@ApiModelProperty(notes="实际开始时间-来自task表",allowEmptyValue=true,example="",allowableValues="")
	Date actStartTime;
	
	@ApiModelProperty(notes="是否开启分享赚",allowEmptyValue=true,example="",allowableValues="")
	String oshare;
	
	@ApiModelProperty(notes="分享赚佣金",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal shareFee;
	
	@ApiModelProperty(notes="平台服务费",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal sfee;
	
	@ApiModelProperty(notes="服务费率",allowEmptyValue=true,example="",allowableValues="")
	Integer sfeeRate;
	
	@ApiModelProperty(notes="相对方编号(机构写机构号，个人写个人编号)",allowEmptyValue=true,example="",allowableValues="")
	String cpId;
	
	@ApiModelProperty(notes="相对方名称（机构写机构名称，个人写个人名称）",allowEmptyValue=true,example="",allowableValues="")
	String cpName;
	
	@ApiModelProperty(notes="相对方类型1-个人，2-企业",allowEmptyValue=true,example="",allowableValues="")
	String cpType;
	
	@ApiModelProperty(notes="推荐人编号",allowEmptyValue=true,example="",allowableValues="")
	String distUserid;
	
	@ApiModelProperty(notes="推荐人姓名",allowEmptyValue=true,example="",allowableValues="")
	String distUsername;
	
	@ApiModelProperty(notes="分享码",allowEmptyValue=true,example="",allowableValues="")
	String shareKey;
	
	@ApiModelProperty(notes="是否外购0否1是",allowEmptyValue=true,example="",allowableValues="")
	String taskOut;
	
	@ApiModelProperty(notes="是否众包",allowEmptyValue=true,example="",allowableValues="")
	String crowd;
	
	@ApiModelProperty(notes="其它费用",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal othFee;
	
	@ApiModelProperty(notes="费用说明",allowEmptyValue=true,example="",allowableValues="")
	String feeRemark;
	
	@ApiModelProperty(notes="该任务在本次结算前已结算的金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal tactAt;

	/**主键**/
	public XmTaskSbillDetail(String id) {
		this.id = id;
	}
    
    /**工时登记表**/
	public XmTaskSbillDetail() {
	}
	
	/**
	 * 员工编号
	 **/
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 姓名
	 **/
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 创建日期
	 **/
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	/**
	 * 业务对象主键任务编号
	 **/
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	/**
	 * 业务日期yyyy-MM-dd
	 **/
	public void setBizDate(String bizDate) {
		this.bizDate = bizDate;
	}
	/**
	 * 备注
	 **/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 结算单据编号-来自task_sbill.id
	 **/
	public void setSbillId(String sbillId) {
		this.sbillId = sbillId;
	}
	/**
	 * 结算提交时间
	 **/
	public void setStime(Date stime) {
		this.stime = stime;
	}
	/**
	 * 结算状态0-无需结算，1-待结算2-已提交3-已通过4-已结算
	 **/
	public void setSstatus(String sstatus) {
		this.sstatus = sstatus;
	}
	/**
	 * 工时对应金额
	 **/
	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}
	/**
	 * 结算工时对应结算金额-根据结算方案计算结算金额
	 **/
	public void setSamt(BigDecimal samt) {
		this.samt = samt;
	}
	/**
	 * 报工工时
	 **/
	public void setWorkload(BigDecimal workload) {
		this.workload = workload;
	}
	/**
	 * 归属项目
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 结算工时，用于结算，默认=workload
	 **/
	public void setSworkload(BigDecimal sworkload) {
		this.sworkload = sworkload;
	}
	/**
	 * 月份yyyy-MM型
	 **/
	public void setBizMonth(String bizMonth) {
		this.bizMonth = bizMonth;
	}
	/**
	 * 任务预算金额-来自task表
	 **/
	public void setBudgetAt(BigDecimal budgetAt) {
		this.budgetAt = budgetAt;
	}
	/**
	 * 任务预算工时-来自task表
	 **/
	public void setBudgetWorkload(BigDecimal budgetWorkload) {
		this.budgetWorkload = budgetWorkload;
	}
	/**
	 * 任务初始工时-来自task表
	 **/
	public void setInitWorkload(BigDecimal initWorkload) {
		this.initWorkload = initWorkload;
	}
	/**
	 * 报价金额-来自task_execuser表
	 **/
	public void setQuoteAt(BigDecimal quoteAt) {
		this.quoteAt = quoteAt;
	}
	/**
	 * 报价工时-来自task_execuser表
	 **/
	public void setQuoteWorkload(BigDecimal quoteWorkload) {
		this.quoteWorkload = quoteWorkload;
	}
	/**
	 * 任务结算方案,来自task表、来自数字字典xmTaskSettleSchemel
	 **/
	public void setSschemel(String sschemel) {
		this.sschemel = sschemel;
	}
	/**
	 * 工时单价，来自task表，根据task_out判断取内部还是外部单价
	 **/
	public void setUniPrice(BigDecimal uniPrice) {
		this.uniPrice = uniPrice;
	}
	/**
	 * 报价结束时间
	 **/
	public void setQendTime(Date qendTime) {
		this.qendTime = qendTime;
	}
	/**
	 * 报价开始时间
	 **/
	public void setQstartTime(Date qstartTime) {
		this.qstartTime = qstartTime;
	}
	/**
	 * 实际完工时间-来自task表
	 **/
	public void setActEndTime(Date actEndTime) {
		this.actEndTime = actEndTime;
	}
	/**
	 * 实际开始时间-来自task表
	 **/
	public void setActStartTime(Date actStartTime) {
		this.actStartTime = actStartTime;
	}
	/**
	 * 是否开启分享赚
	 **/
	public void setOshare(String oshare) {
		this.oshare = oshare;
	}
	/**
	 * 分享赚佣金
	 **/
	public void setShareFee(BigDecimal shareFee) {
		this.shareFee = shareFee;
	}
	/**
	 * 平台服务费
	 **/
	public void setSfee(BigDecimal sfee) {
		this.sfee = sfee;
	}
	/**
	 * 服务费率
	 **/
	public void setSfeeRate(Integer sfeeRate) {
		this.sfeeRate = sfeeRate;
	}
	/**
	 * 相对方编号(机构写机构号，个人写个人编号)
	 **/
	public void setCpId(String cpId) {
		this.cpId = cpId;
	}
	/**
	 * 相对方名称（机构写机构名称，个人写个人名称）
	 **/
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	/**
	 * 相对方类型1-个人，2-企业
	 **/
	public void setCpType(String cpType) {
		this.cpType = cpType;
	}
	/**
	 * 推荐人编号
	 **/
	public void setDistUserid(String distUserid) {
		this.distUserid = distUserid;
	}
	/**
	 * 推荐人姓名
	 **/
	public void setDistUsername(String distUsername) {
		this.distUsername = distUsername;
	}
	/**
	 * 分享码
	 **/
	public void setShareKey(String shareKey) {
		this.shareKey = shareKey;
	}
	/**
	 * 是否外购0否1是
	 **/
	public void setTaskOut(String taskOut) {
		this.taskOut = taskOut;
	}
	/**
	 * 是否众包
	 **/
	public void setCrowd(String crowd) {
		this.crowd = crowd;
	}
	/**
	 * 其它费用
	 **/
	public void setOthFee(BigDecimal othFee) {
		this.othFee = othFee;
	}
	/**
	 * 费用说明
	 **/
	public void setFeeRemark(String feeRemark) {
		this.feeRemark = feeRemark;
	}
	/**
	 * 该任务在本次结算前已结算的金额
	 **/
	public void setTactAt(BigDecimal tactAt) {
		this.tactAt = tactAt;
	}
	
	/**
	 * 员工编号
	 **/
	public String getUserid() {
		return this.userid;
	}
	/**
	 * 姓名
	 **/
	public String getUsername() {
		return this.username;
	}
	/**
	 * 创建日期
	 **/
	public Date getCtime() {
		return this.ctime;
	}
	/**
	 * 业务对象主键任务编号
	 **/
	public String getTaskId() {
		return this.taskId;
	}
	/**
	 * 业务日期yyyy-MM-dd
	 **/
	public String getBizDate() {
		return this.bizDate;
	}
	/**
	 * 备注
	 **/
	public String getRemark() {
		return this.remark;
	}
	/**
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 结算单据编号-来自task_sbill.id
	 **/
	public String getSbillId() {
		return this.sbillId;
	}
	/**
	 * 结算提交时间
	 **/
	public Date getStime() {
		return this.stime;
	}
	/**
	 * 结算状态0-无需结算，1-待结算2-已提交3-已通过4-已结算
	 **/
	public String getSstatus() {
		return this.sstatus;
	}
	/**
	 * 工时对应金额
	 **/
	public BigDecimal getAmt() {
		return this.amt;
	}
	/**
	 * 结算工时对应结算金额-根据结算方案计算结算金额
	 **/
	public BigDecimal getSamt() {
		return this.samt;
	}
	/**
	 * 报工工时
	 **/
	public BigDecimal getWorkload() {
		return this.workload;
	}
	/**
	 * 归属项目
	 **/
	public String getProjectId() {
		return this.projectId;
	}
	/**
	 * 结算工时，用于结算，默认=workload
	 **/
	public BigDecimal getSworkload() {
		return this.sworkload;
	}
	/**
	 * 月份yyyy-MM型
	 **/
	public String getBizMonth() {
		return this.bizMonth;
	}
	/**
	 * 任务预算金额-来自task表
	 **/
	public BigDecimal getBudgetAt() {
		return this.budgetAt;
	}
	/**
	 * 任务预算工时-来自task表
	 **/
	public BigDecimal getBudgetWorkload() {
		return this.budgetWorkload;
	}
	/**
	 * 任务初始工时-来自task表
	 **/
	public BigDecimal getInitWorkload() {
		return this.initWorkload;
	}
	/**
	 * 报价金额-来自task_execuser表
	 **/
	public BigDecimal getQuoteAt() {
		return this.quoteAt;
	}
	/**
	 * 报价工时-来自task_execuser表
	 **/
	public BigDecimal getQuoteWorkload() {
		return this.quoteWorkload;
	}
	/**
	 * 任务结算方案,来自task表、来自数字字典xmTaskSettleSchemel
	 **/
	public String getSschemel() {
		return this.sschemel;
	}
	/**
	 * 工时单价，来自task表，根据task_out判断取内部还是外部单价
	 **/
	public BigDecimal getUniPrice() {
		return this.uniPrice;
	}
	/**
	 * 报价结束时间
	 **/
	public Date getQendTime() {
		return this.qendTime;
	}
	/**
	 * 报价开始时间
	 **/
	public Date getQstartTime() {
		return this.qstartTime;
	}
	/**
	 * 实际完工时间-来自task表
	 **/
	public Date getActEndTime() {
		return this.actEndTime;
	}
	/**
	 * 实际开始时间-来自task表
	 **/
	public Date getActStartTime() {
		return this.actStartTime;
	}
	/**
	 * 是否开启分享赚
	 **/
	public String getOshare() {
		return this.oshare;
	}
	/**
	 * 分享赚佣金
	 **/
	public BigDecimal getShareFee() {
		return this.shareFee;
	}
	/**
	 * 平台服务费
	 **/
	public BigDecimal getSfee() {
		return this.sfee;
	}
	/**
	 * 服务费率
	 **/
	public Integer getSfeeRate() {
		return this.sfeeRate;
	}
	/**
	 * 相对方编号(机构写机构号，个人写个人编号)
	 **/
	public String getCpId() {
		return this.cpId;
	}
	/**
	 * 相对方名称（机构写机构名称，个人写个人名称）
	 **/
	public String getCpName() {
		return this.cpName;
	}
	/**
	 * 相对方类型1-个人，2-企业
	 **/
	public String getCpType() {
		return this.cpType;
	}
	/**
	 * 推荐人编号
	 **/
	public String getDistUserid() {
		return this.distUserid;
	}
	/**
	 * 推荐人姓名
	 **/
	public String getDistUsername() {
		return this.distUsername;
	}
	/**
	 * 分享码
	 **/
	public String getShareKey() {
		return this.shareKey;
	}
	/**
	 * 是否外购0否1是
	 **/
	public String getTaskOut() {
		return this.taskOut;
	}
	/**
	 * 是否众包
	 **/
	public String getCrowd() {
		return this.crowd;
	}
	/**
	 * 其它费用
	 **/
	public BigDecimal getOthFee() {
		return this.othFee;
	}
	/**
	 * 费用说明
	 **/
	public String getFeeRemark() {
		return this.feeRemark;
	}
	/**
	 * 该任务在本次结算前已结算的金额
	 **/
	public BigDecimal getTactAt() {
		return this.tactAt;
	}

}