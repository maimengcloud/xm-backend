package com.xm.core.service;

import com.alibaba.fastjson.JSON;
import com.mdp.core.err.BizException;
import com.mdp.core.service.BaseService;
import com.mdp.msg.client.PushNotifyMsgService;
import com.xm.core.entity.XmTask;
import com.xm.core.entity.XmTaskBidOrder;
import com.xm.core.service.client.AcClient;
import com.xm.core.vo.AddXmTaskBidOrderVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmTaskBidOrder 表 xm_task_bid_order 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmTaskBidOrderService")
public class XmTaskBidOrderService extends BaseService {
	static Logger logger =LoggerFactory.getLogger(XmTaskBidOrderService.class);

	@Autowired
	XmTaskService xmTaskService;

	@Autowired
	PushNotifyMsgService msgService;

	@Autowired
	XmRecordService xmRecordService;

	@Autowired
	XmTaskExecuserService execuserService;

	@Autowired
	RedisTemplate redisTemplate;



	@Autowired
	AcClient acClient;


	@Transactional
	public void orderPaySuccess(String orderId, String payId, String prepayId, String tranId, BigDecimal payAt, String remarks) {
		//更新订单状态

		if (!StringUtils.hasText(payId)) {
			throw new BizException("payId-0", "参数不正确，payId不能为空");
		}
		XmTaskBidOrder taskOrderDb = this.selectOneById(orderId);
		XmTask xmTaskUpdate=new XmTask();
		xmTaskUpdate.setId(taskOrderDb.getTaskId());
		if (!payId.equals(taskOrderDb.getPayId())) {
			throw new BizException("payId-err", "参数不正确，payId与实际不匹配");
		}
		if (!"2".equals(taskOrderDb.getOstatus())) {
			throw new BizException("该订单状态出错");
		}
		XmTaskBidOrder order=new XmTaskBidOrder();
		//设置第三方付款号
		order.setTranId(tranId);
		order.setPayAt(payAt);
		//设置结算状态为已结算
		order.setPayStatus("1");
		//设置状态为已付款
		order.setOstatus("3");
		//设置付款确认时间
		order.setPayTime(new Date());

		List<String> marketNames=new ArrayList<>();
		order.setId(taskOrderDb.getId() );


 		String json= (String) redisTemplate.opsForValue().get(XmTaskBidOrder.class.getSimpleName()+"-"+orderId);
		AddXmTaskBidOrderVo bidOrderVo=JSON.parseObject(json,AddXmTaskBidOrderVo.class);
		execuserService.addExecuser(bidOrderVo,true);

		BeanUtils.copyProperties(order,xmTaskUpdate);
		xmTaskUpdate.setId(taskOrderDb.getTaskId());
		//托管资金后用户开始工作
		if("1".equals(taskOrderDb.getBizType()) && "2".equals(xmTaskUpdate.getEstate()) && "1".equals(taskOrderDb.getEstate())){
			xmTaskUpdate.setBidStep("5");
			xmTaskUpdate.setEfunds(payAt);
		}
		this.updateSomeFieldByPk(order);
		if("1".equals(taskOrderDb.getBizType()) && "5".equals(xmTaskUpdate.getBidStep())){
			XmTask xmTaskDb=this.xmTaskService.selectOneById(taskOrderDb.getTaskId());
			msgService.pushMsg(taskOrderDb.getObranchId(),taskOrderDb.getOuserid(),xmTaskDb.getExecutorUserid(),"2",xmTaskDb.getProjectId(),xmTaskDb.getId(),"雇主成功托管佣金【"+taskOrderDb.getEfunds()+"】，实际到账金额【"+payAt+"】，当前任务进入用户工作阶段，请尽快开展工作。");
			xmRecordService.addXmTaskRecord(taskOrderDb.getProjectId(),taskOrderDb.getTaskId(),"托管佣金","成功托管佣金【"+taskOrderDb.getEfunds()+"】，实际到账金额【"+payAt+"】");
		}else{

			xmRecordService.addXmTaskRecord(taskOrderDb.getProjectId(),taskOrderDb.getTaskId(),"营销活动","成功缴纳活动费用金额【"+taskOrderDb.getFinalFee()+"】，实际到账金额【"+payAt+"】。参加的活动为【"+marketNames.stream().collect(Collectors.joining(","))+"】");
		}
	}
	public void payCancel(String orderId, String payId, String remark) {
		XmTaskBidOrder orderDb = this.selectOneById(orderId);
		if(StringUtils.isEmpty(orderDb.getPayId()) ||orderDb.getPayId().equals(payId)){
			XmTaskBidOrder orderUpdate=new XmTaskBidOrder();
			orderUpdate.setId(orderId);
			orderUpdate.setRemark(remark);
			orderUpdate.setPayStatus("2");
			orderUpdate.setLtime(new Date());
			super.updateSomeFieldByPk(orderUpdate);
		}
	}

}

