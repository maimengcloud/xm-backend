package com.xm.core.service;

import com.mdp.core.err.BizException;
import com.mdp.core.service.BaseService;
import com.xm.core.entity.XmTaskOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


	@Transactional
	public void orderPaySuccess(String orderId, String payId, String prepayId, String tranId, BigDecimal payAt, String remarks) {
		//更新订单状态

		if (!StringUtils.hasText(payId)) {
			throw new BizException("payId-0", "参数不正确，payId不能为空");
		}
		XmTaskOrder moOrder = this.selectOneById(orderId);
		if (!payId.equals(moOrder.getPayId())) {
			throw new BizException("payId-err", "参数不正确，payId与实际不匹配");
		}
		if (!"2".equals(moOrder.getOstatus())) {
			throw new BizException("该订单状态出错");
		}

		//设置第三方付款号
		moOrder.setTranId(tranId);
		moOrder.setPayAt(payAt);
		//设置结算状态为已结算
		moOrder.setPayStatus("1");
		//设置状态为已付款
		moOrder.setOstatus("3");
		//设置付款确认时间
		moOrder.setPayTime(new Date());
	}


}

