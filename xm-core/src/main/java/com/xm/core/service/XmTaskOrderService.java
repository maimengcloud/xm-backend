package com.xm.core.service;

import com.mdp.core.err.BizException;
import com.mdp.core.service.BaseService;
import com.xm.core.entity.XmTask;
import com.xm.core.entity.XmTaskOrder;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmTaskOrder 表 xm_task_order 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmTaskOrderService")
public class XmTaskOrderService extends BaseService {
	static Logger logger =LoggerFactory.getLogger(XmTaskOrderService.class);

	@Autowired
	XmTaskService xmTaskService;


	@Transactional
	public void orderPaySuccess(String orderId, String payId, String prepayId, String tranId, BigDecimal payAt, String remarks) {
		//更新订单状态

		if (!StringUtils.hasText(payId)) {
			throw new BizException("payId-0", "参数不正确，payId不能为空");
		}
		XmTaskOrder taskOrderDb = this.selectOneById(orderId);
		XmTask xmTaskUpdate=new XmTask();
		xmTaskUpdate.setId(taskOrderDb.getTaskId());
		if (!payId.equals(taskOrderDb.getPayId())) {
			throw new BizException("payId-err", "参数不正确，payId与实际不匹配");
		}
		if (!"2".equals(taskOrderDb.getOstatus())) {
			throw new BizException("该订单状态出错");
		}
		XmTaskOrder order=new XmTaskOrder();
		//设置第三方付款号
		order.setTranId(tranId);
		order.setPayAt(payAt);
		//设置结算状态为已结算
		order.setPayStatus("1");
		//设置状态为已付款
		order.setOstatus("3");
		//设置付款确认时间
		order.setPayTime(new Date());


		order.setId(taskOrderDb.getId());
		if("1".equals(taskOrderDb.getEstate())){
			order.setEstate("2");

		}
		if("1".equals(taskOrderDb.getTop())){
			order.setTop("2");
			order.setTopStime(new Date());
			order.setTopEtime(DateUtils.addDays(new Date(),taskOrderDb.getTopDays()));
		}
		if("1".equals(taskOrderDb.getHot())){
			order.setHot("2");
			order.setHotStime(new Date());
			order.setHotEtime(DateUtils.addDays(new Date(),taskOrderDb.getHotDays()));
		}
		if("1".equals(taskOrderDb.getUrgent())){
			order.setUrgent("2");
			order.setUrgentStime(new Date());
			order.setUrgentEtime(DateUtils.addDays(new Date(),taskOrderDb.getUrgentDays()));
		}
		if("1".equals(taskOrderDb.getCrmSup())){
			order.setCrmSup("2");
		}

		BeanUtils.copyProperties(order,xmTaskUpdate);
		xmTaskUpdate.setId(taskOrderDb.getTaskId());
		this.xmTaskService.updateSomeFieldByPk(xmTaskUpdate);
		this.updateSomeFieldByPk(order);
	}


}

