package com.xm.core.service.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdp.core.entity.Tips;
import com.mdp.core.utils.SequenceFormat;
import com.mdp.micro.client.CallBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 
	
	Set<String> userCardCodeSet=new HashSet<String>(1000);
	 
	 
	/**
	 * 企业付款给个人
	 * @param payCompanyId 支付方企业编号
	 * @param incomeUserid 收款方用户编号
	 * @param orderId 订单号 如没有，调用者自行编码一个订单号
	 * @param payAt 订单总金额 如果有多次付款，即为所有子单总金额之和  
	 * @param remarks 备注
	 * @return
	 */ 
	public Map<String,Object> companyBalancePayToClient(String payCompanyId,String incomeUserid,  String orderId, BigDecimal payAt, String remarks){
		String urls = "/accore/accore/tpa/pay/companyBalancePayToClient";
		Map<String,Object> m=new HashMap<>();
		m.put("payCompanyId", payCompanyId);
		m.put("incomeUserid", incomeUserid);
		m.put("orderId",orderId);
		m.put("payAt", payAt);
		m.put("remarks", remarks);
		Tips tips  = restTemplate.postForTips(urls,m);

		return tips;
	}

	/**
	 * 平台给个人付款
	 * @param incomeUserid 收款用户编号
	 * @param payAt 订单总金额
	 * @param orderId 关联流水号
	 * @param remarks 备注
	 * @return
	 */
	public Tips platformBalancePayToClient(String incomeUserid,String orderId,  BigDecimal payAt, String remarks ){

		String urls = "/accore/accore/tpa/pay/platformBalancePayToClient";
		Map<String,Object> m=new HashMap<>();
		m.put("incomeUserid", incomeUserid);
		m.put("payAt", payAt);
		m.put("orderId", orderId);
		m.put("remarks",remarks);
		Tips tips = restTemplate.postForTips(urls,m);
		return tips;
	}

	/**
	 * 企业之间付款
	 * @param payCompanyId 支付归属机构号
	 * @param incomeCompanyId 收款方用户编号
	 * @param orderId 订单号 如没有，调用者自行编码一个订单号
	 * @param payAt 订单总金额 如果有多次付款，即为所有子单总金额之和  
	 * @param remarks 备注
	 * @return
	 */ 
	public Map<String,Object> companyBalancePayToCompany(String payCompanyId,String incomeCompanyId, String orderId, BigDecimal payAt, String remarks ){
		String urls = "/accore/accore/tpa/pay/companyBalancePayToCompany";
		Map<String,Object> m=new HashMap<>();
		m.put("payCompanyId", payCompanyId);
		m.put("incomeCompanyId", incomeCompanyId);
		m.put("orderId",orderId);
		m.put("payAt", payAt);
		m.put("remarks", remarks);
		Tips tips = restTemplate.postForTips(urls,m);

		return tips;
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
