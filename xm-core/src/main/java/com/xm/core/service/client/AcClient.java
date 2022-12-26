package com.xm.core.service.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdp.core.entity.Tips;
import com.mdp.core.err.BizException;
import com.mdp.core.utils.BaseUtils;
import com.mdp.core.utils.SequenceFormat;
import com.mdp.micro.client.CallBizService;
import com.mdp.tpa.client.entity.AppShopConfig;
import com.mdp.tpa.client.service.AppShopConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class AcClient {
	@Autowired
	CallBizService restTemplate;
	
	@Autowired
	ObjectMapper om;

	@Autowired
	AppShopConfigService appShopConfigService;
	
	Set<String> userCardCodeSet=new HashSet<String>(1000);
	 
	 
	/**
	 * 结算商家付款给客户。不适用第三方支付、而是直接使用本系统账户余额支付。登记流水及记账一次性完成 
	 * @param payShopId 支付商户编号
	 * @param payLocationId 支付方店铺编号
	 * @param acctPrjType 核算项目类型 platfrom/shop/location
	 * @param orderId 订单号 如没有，调用者自行编码一个订单号
	 * @param orderAmount 订单总金额 如果有多次付款，即为所有子单总金额之和  
	 * @param remark 备注  
	 * @param goodsShopId 收款方商户编号
	 * @param goodsLocationId 收款方店铺编号 
	 * @return
	 */ 
	public Map<String,Object> shopBalancePayToClient(String payShopId,String payLocationId,String acctPrjType, String orderId, BigDecimal orderAmount, String remark,
			String incomeUserid, String goodsShopId, String goodsLocationId){
		String urls = "/accore/accore/tpa/pay/shopBalancePayToClient";
		Map<String,Object> m=new HashMap<>();
		m.put("payShopId", payShopId);
		m.put("payLocationId", payLocationId);
		m.put("acctPrjType", acctPrjType);
		m.put("orderId",orderId);
		m.put("orderAmount", orderAmount);
		m.put("remark", remark);
		m.put("incomeUserid", incomeUserid);
		m.put("goodsShopId", goodsShopId);
		m.put("goodsLocationId", goodsLocationId);
		Map<String,Object> tipMap = restTemplate.postForMap(urls,m);
		Tips tips= BaseUtils.mapToTips(tipMap);
		if(!tips.isOk()){
			throw new BizException(tips);
		}
		return tipMap;
	}

	/**
	 * 给平台充值，登记到平台账户中，用于下一步支付给第三方
	 * @param payUserid 订单号 如没有，调用者自行编码一个订单号
	 * @param rechargeAmount 订单总金额 如果有多次付款，即为所有子单总金额之和
	 * @param refsn 关联流水号
	 * @param remark 备注
	 * @return
	 */
	public Map<String,Object> platformRecharge(String payUserid,  BigDecimal rechargeAmount, String refsn,String remark ){

		String urls = "/accore/accore/acct/account/platform/recharge";
		Map<String,Object> m=new HashMap<>();
		m.put("payUserid", payUserid);
		m.put("rechargeAmount", rechargeAmount);
		m.put("refsn", refsn);
		m.put("remark",remark);
		Map<String,Object> tipMap = restTemplate.postForMap(urls,m);
		Tips tips= BaseUtils.mapToTips(tipMap);
		if(!tips.isOk()){
			throw new BizException(tips);
		}
		return tipMap;
	}

	/**
	 * 结算商家付款给客户。不适用第三方支付、而是直接使用本系统账户余额支付。登记流水及记账一次性完成
	 * @param payBranchId 支付商户归属机构编号
	 * @param acctPrjType 核算项目类型 platfrom/shop/location
	 * @param orderId 订单号 如没有，调用者自行编码一个订单号
	 * @param orderAmount 订单总金额 如果有多次付款，即为所有子单总金额之和
	 * @param remark 备注
	 * @param receBranchId 收款方商户归属机构编号
	 * @return
	 */
	public Map<String,Object> shopBalancePayToClient(String payBranchId,String acctPrjType, String orderId, BigDecimal orderAmount, String remark,
													 String incomeUserid,String receBranchId){
		AppShopConfig payConfig=appShopConfigService.getShopConfigByBranchId(payBranchId);

		AppShopConfig receConfig=payConfig;
		if( StringUtils.hasText(receBranchId) && !payBranchId.equals(receBranchId)){
			receConfig=appShopConfigService.getShopConfigByBranchId(receBranchId);
		}
		String urls = "/accore/accore/tpa/pay/shopBalancePayToClient";
		Map<String,Object> m=new HashMap<>();
		m.put("payShopId", payConfig.getShopId());
		m.put("payLocationId", payConfig.getHeadLocationId());
		m.put("acctPrjType", acctPrjType);
		m.put("orderId",orderId);
		m.put("orderAmount", orderAmount);
		m.put("remark", remark);
		m.put("incomeUserid", incomeUserid);
		m.put("goodsShopId", receConfig.getShopId());
		m.put("goodsLocationId", receConfig.getHeadLocationId());
		Map<String,Object> tipMap = restTemplate.postForMap(urls,m);
		Tips tips= BaseUtils.mapToTips(tipMap);
		if(!tips.isOk()){
			throw new BizException(tips);
		}
		return tipMap;
	}
	/**
	 * 结算商家 付款 给 合作商家、用于退还合作商家缴纳的活动保证金等。核销卡券时，付款给合作商家等。不适用第三方支付、而是直接使用本系统账户余额支付。登记流水及记账一次性完成 
	 * @param payShopId 支付商户编号
	 * @param payLocationId 支付方店铺编号
	 * @param acctPrjType 核算项目类型 platfrom/shop/location
	 * @param orderId 订单号 如没有，调用者自行编码一个订单号
	 * @param orderAmount 订单总金额 如果有多次付款，即为所有子单总金额之和  
	 * @param remark 备注  
	 * @param goodsShopId 收款方商户编号
	 * @param goodsLocationId 收款方店铺编号
	 * @return
	 */ 
	public Map<String,Object> shopBanlancePayToShop(String payShopId,String payLocationId,String acctPrjType, String orderId, BigDecimal orderAmount, String remark,
			String goodsShopId, String goodsLocationId){
		String urls = "/accore/accore/tpa/pay/shopBanlancePayToShop";
		Map<String,Object> m=new HashMap<>();
		m.put("payShopId", payShopId);
		m.put("payLocationId", payLocationId);
		m.put("acctPrjType", acctPrjType);
		m.put("orderId",orderId);
		m.put("orderAmount", orderAmount);
		m.put("remark", remark);
		m.put("goodsShopId", goodsShopId);
		m.put("goodsLocationId", goodsLocationId);
		Map<String,Object> tipMap = restTemplate.postForMap(urls,m);
		Tips tips= BaseUtils.mapToTips(tipMap);
		if(!tips.isOk()){
			throw new BizException(tips);
		}
		return tipMap;
	}
	public String getOrderId(){
		String s= SequenceFormat.parse("{date:yyMMddHH}{rands:2}{rand:2}");
		while(userCardCodeSet.contains(s)){
			 s= SequenceFormat.parse("{date:yyMMddHH}{rands:2}{rand:2}");
		}
		userCardCodeSet.add(s);
		return s;
	}
}
