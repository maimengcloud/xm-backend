package  com.qqkj.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com.qqkj  顶级模块 oa 大模块 xm  小模块 <br> 
 * 实体 XmProjectKpiHis所有属性名: <br>
 *	projectId,branchId,kpiIndex,kpiName,maxValue,minValue,kpiId,score,scoreDate,bizFlowState,bizProcInstId,kpiValue,cdate,id,remark,calcType,nextCalcDate;<br>
 * 表 XM.xm_project_kpi_his xm_project_kpi_his的所有字段名: <br>
 *	project_id,branch_id,kpi_index,kpi_name,max_value,min_value,kpi_id,score,score_date,biz_flow_state,biz_proc_inst_id,kpi_value,cdate,id,remark,calc_type,next_calc_date;<br>
 * 当前主键(包括多主键):<br>
 *	kpi_id;<br>
 */
@ApiModel(description="xm_project_kpi_his")
public class XmProjectKpiHis  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="kpi主表主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String kpiId;
  	
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="机构编码",allowEmptyValue=true,example="",allowableValues="")
	String branchId;
	
	@ApiModelProperty(notes="指标编号",allowEmptyValue=true,example="",allowableValues="")
	String kpiIndex;
	
	@ApiModelProperty(notes="指标名称",allowEmptyValue=true,example="",allowableValues="")
	String kpiName;
	
	@ApiModelProperty(notes="最大值",allowEmptyValue=true,example="",allowableValues="")
	String maxValue;
	
	@ApiModelProperty(notes="最小值",allowEmptyValue=true,example="",allowableValues="")
	String minValue;
	
	@ApiModelProperty(notes="得分0~10分",allowEmptyValue=true,example="",allowableValues="")
	Integer score;
	
	@ApiModelProperty(notes="评分日期",allowEmptyValue=true,example="",allowableValues="")
	Date scoreDate;
	
	@ApiModelProperty(notes="流程状态",allowEmptyValue=true,example="",allowableValues="")
	String bizFlowState;
	
	@ApiModelProperty(notes="流程实例编号",allowEmptyValue=true,example="",allowableValues="")
	String bizProcInstId;
	
	@ApiModelProperty(notes="kpi当前值",allowEmptyValue=true,example="",allowableValues="")
	String kpiValue;
	
	@ApiModelProperty(notes="创建日期",allowEmptyValue=true,example="",allowableValues="")
	Date cdate;
	
	@ApiModelProperty(notes="主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="考核方式0月1季度3半年4一年",allowEmptyValue=true,example="",allowableValues="")
	String calcType;
	
	@ApiModelProperty(notes="下次考核开始时间",allowEmptyValue=true,example="",allowableValues="")
	Date nextCalcDate;

	/**kpi主表主键**/
	public XmProjectKpiHis(String kpiId) {
		this.kpiId = kpiId;
	}
    
    /**xm_project_kpi_his**/
	public XmProjectKpiHis() {
	}
	
	/**
	 * 项目编号
	 **/
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/**
	 * 机构编码
	 **/
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	/**
	 * 指标编号
	 **/
	public void setKpiIndex(String kpiIndex) {
		this.kpiIndex = kpiIndex;
	}
	/**
	 * 指标名称
	 **/
	public void setKpiName(String kpiName) {
		this.kpiName = kpiName;
	}
	/**
	 * 最大值
	 **/
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}
	/**
	 * 最小值
	 **/
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}
	/**
	 * kpi主表主键
	 **/
	public void setKpiId(String kpiId) {
		this.kpiId = kpiId;
	}
	/**
	 * 得分0~10分
	 **/
	public void setScore(Integer score) {
		this.score = score;
	}
	/**
	 * 评分日期
	 **/
	public void setScoreDate(Date scoreDate) {
		this.scoreDate = scoreDate;
	}
	/**
	 * 流程状态
	 **/
	public void setBizFlowState(String bizFlowState) {
		this.bizFlowState = bizFlowState;
	}
	/**
	 * 流程实例编号
	 **/
	public void setBizProcInstId(String bizProcInstId) {
		this.bizProcInstId = bizProcInstId;
	}
	/**
	 * kpi当前值
	 **/
	public void setKpiValue(String kpiValue) {
		this.kpiValue = kpiValue;
	}
	/**
	 * 创建日期
	 **/
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 备注
	 **/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 考核方式0月1季度3半年4一年
	 **/
	public void setCalcType(String calcType) {
		this.calcType = calcType;
	}
	/**
	 * 下次考核开始时间
	 **/
	public void setNextCalcDate(Date nextCalcDate) {
		this.nextCalcDate = nextCalcDate;
	}
	
	/**
	 * 项目编号
	 **/
	public String getProjectId() {
		return this.projectId;
	}
	/**
	 * 机构编码
	 **/
	public String getBranchId() {
		return this.branchId;
	}
	/**
	 * 指标编号
	 **/
	public String getKpiIndex() {
		return this.kpiIndex;
	}
	/**
	 * 指标名称
	 **/
	public String getKpiName() {
		return this.kpiName;
	}
	/**
	 * 最大值
	 **/
	public String getMaxValue() {
		return this.maxValue;
	}
	/**
	 * 最小值
	 **/
	public String getMinValue() {
		return this.minValue;
	}
	/**
	 * kpi主表主键
	 **/
	public String getKpiId() {
		return this.kpiId;
	}
	/**
	 * 得分0~10分
	 **/
	public Integer getScore() {
		return this.score;
	}
	/**
	 * 评分日期
	 **/
	public Date getScoreDate() {
		return this.scoreDate;
	}
	/**
	 * 流程状态
	 **/
	public String getBizFlowState() {
		return this.bizFlowState;
	}
	/**
	 * 流程实例编号
	 **/
	public String getBizProcInstId() {
		return this.bizProcInstId;
	}
	/**
	 * kpi当前值
	 **/
	public String getKpiValue() {
		return this.kpiValue;
	}
	/**
	 * 创建日期
	 **/
	public Date getCdate() {
		return this.cdate;
	}
	/**
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 备注
	 **/
	public String getRemark() {
		return this.remark;
	}
	/**
	 * 考核方式0月1季度3半年4一年
	 **/
	public String getCalcType() {
		return this.calcType;
	}
	/**
	 * 下次考核开始时间
	 **/
	public Date getNextCalcDate() {
		return this.nextCalcDate;
	}

}