package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmTaskBidOrder所有属性名: <br>
 *	"id","订单编号","ouserid","下单用户编号","obranchId","公司ID-下单客户对应的企业","ostatus","订单状态0-初始，1-待确认，2-待付款，3-已付款，4-已完成，5-已取消-未付款前可取消，取消后可删除，6-退单-退单后变为已取消，8已关闭-售后完成后可以关闭订单","ctime","创建时间","ltime","更新时间","payType","支付方式1微信2支付宝","payStatus","支付状态0待付款，1已付款","payTime","支付时间","prepayId","第三方支付订单编号","finalFee","最终总费用=origin_fee","othFee","其它费用","originFee","原始价格=任务佣金*平台配置的投标直通车收费比率","payAt","最终付款金额-客户付款后回填","payOpenid","支付账户对应的第三方openid,注意，下单根付款不一定是同一个人","payUserid","付款用户编号","payUsername","付款用户名称","taskId","任务编号","calcStatus","定时检查日期是否已过期，已过期则取消任务中的置顶、加急、热搜状态计算状态0-无须计算，1-本周期已计算待下周期计算，2-结束","calcTime","计算时间","payId","付款流水号(内部生成，传给第三方原样传回，如果不正确，不允许更新数据库，防止作弊)","tranId","第三方付款事务号","remark","订单备注","name","订单名称","bizType","订单业务类","projectId","项目编号","otype","订单类型7-投标直通车","taskBudgetAt","任务预算金额";<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
 @Data
@ApiModel(description="任务相关投标直通车订单表")
public class XmTaskBidOrder  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="订单编号,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="下单用户编号",allowEmptyValue=true,example="",allowableValues="")
	String ouserid;
	
	@ApiModelProperty(notes="公司ID-下单客户对应的企业",allowEmptyValue=true,example="",allowableValues="")
	String obranchId;
	
	@ApiModelProperty(notes="订单状态0-初始，1-待确认，2-待付款，3-已付款，4-已完成，5-已取消-未付款前可取消，取消后可删除，6-退单-退单后变为已取消，8已关闭-售后完成后可以关闭订单",allowEmptyValue=true,example="",allowableValues="")
	String ostatus;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="更新时间",allowEmptyValue=true,example="",allowableValues="")
	Date ltime;
	
	@ApiModelProperty(notes="支付方式1微信2支付宝",allowEmptyValue=true,example="",allowableValues="")
	String payType;
	
	@ApiModelProperty(notes="支付状态0待付款，1已付款",allowEmptyValue=true,example="",allowableValues="")
	String payStatus;
	
	@ApiModelProperty(notes="支付时间",allowEmptyValue=true,example="",allowableValues="")
	Date payTime;
	
	@ApiModelProperty(notes="第三方支付订单编号",allowEmptyValue=true,example="",allowableValues="")
	String prepayId;
	
	@ApiModelProperty(notes="最终总费用=origin_fee",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal finalFee;
	
	@ApiModelProperty(notes="其它费用",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal othFee;
	
	@ApiModelProperty(notes="原始价格=任务佣金*平台配置的投标直通车收费比率",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal originFee;
	
	@ApiModelProperty(notes="最终付款金额-客户付款后回填",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal payAt;
	
	@ApiModelProperty(notes="支付账户对应的第三方openid,注意，下单根付款不一定是同一个人",allowEmptyValue=true,example="",allowableValues="")
	String payOpenid;
	
	@ApiModelProperty(notes="付款用户编号",allowEmptyValue=true,example="",allowableValues="")
	String payUserid;
	
	@ApiModelProperty(notes="付款用户名称",allowEmptyValue=true,example="",allowableValues="")
	String payUsername;
	
	@ApiModelProperty(notes="任务编号",allowEmptyValue=true,example="",allowableValues="")
	String taskId;
	
	@ApiModelProperty(notes="定时检查日期是否已过期，已过期则取消任务中的置顶、加急、热搜状态计算状态0-无须计算，1-本周期已计算待下周期计算，2-结束",allowEmptyValue=true,example="",allowableValues="")
	String calcStatus;
	
	@ApiModelProperty(notes="计算时间",allowEmptyValue=true,example="",allowableValues="")
	Date calcTime;
	
	@ApiModelProperty(notes="付款流水号(内部生成，传给第三方原样传回，如果不正确，不允许更新数据库，防止作弊)",allowEmptyValue=true,example="",allowableValues="")
	String payId;
	
	@ApiModelProperty(notes="第三方付款事务号",allowEmptyValue=true,example="",allowableValues="")
	String tranId;
	
	@ApiModelProperty(notes="订单备注",allowEmptyValue=true,example="",allowableValues="")
	String remark;
	
	@ApiModelProperty(notes="订单名称",allowEmptyValue=true,example="",allowableValues="")
	String name;
	
	@ApiModelProperty(notes="订单业务类",allowEmptyValue=true,example="",allowableValues="")
	String bizType;
	
	@ApiModelProperty(notes="项目编号",allowEmptyValue=true,example="",allowableValues="")
	String projectId;
	
	@ApiModelProperty(notes="订单类型7-投标直通车",allowEmptyValue=true,example="",allowableValues="")
	String otype;
	
	@ApiModelProperty(notes="任务预算金额",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal taskBudgetAt;

	/**
	 *订单编号
	 **/
	public XmTaskBidOrder(String id) {
		this.id = id;
	}
    
    /**
     * 任务相关投标直通车订单表
     **/
	public XmTaskBidOrder() {
	}

}