package com.xm.core.service.client;

import com.alibaba.fastjson.JSON;
import com.mdp.core.entity.Tips;
import com.mdp.core.utils.BaseUtils;
import com.mdp.micro.client.CallBizService;
import com.mdp.mq.queue.Push;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.mdp.core.utils.BaseUtils.map;

@Service
/**
 * 对mk接口调用
 */
public class MkClient {

    @Autowired
    StringRedisTemplate strRedisTemplate;

    @Autowired
    CallBizService callBizService;

    @Autowired
    Push push;

    /**
     * 		execOrder.setOrderId(sequence.getReqFlowNo());
     * 		execOrder.setActNum(new BigDecimal("1"));
     * 		execOrder.setEntityId(entityId);
     * 		execOrder.setCustId(receiverId);
     * 		execOrder.setActSinglePrice(new BigDecimal("10.22"));
     * 		execOrder.setTotalPrice(new BigDecimal("10.22"));
     * 		execOrder.setCustBranchId("platform-branch-001");
     * @return
     */
    public Tips pushActiExecOrder(String orderId,String custId,String custName,String custBranchId,String orderBranchId, String entityId,BigDecimal actNum,BigDecimal actSinglePrice,BigDecimal totalPrice,BigDecimal workload,String entityDesc){
        Tips tips = new Tips("推送订单成功");
        Map<String,Object> params=new HashMap<>();
        params.put("orderId",orderId);
        params.put("entityType","2");
        params.put("custId",custId);
        params.put("custName",custName);
        params.put("custBranchId",custBranchId);
        params.put("orderBranchId",orderBranchId);
        params.put("entityId",entityId);
        params.put("actNum",actNum);
        params.put("actSinglePrice",actSinglePrice);
        params.put("totalPrice",totalPrice);
        params.put("workload",workload);
        params.put("entityDesc",entityDesc);
        push.leftPush("xm_task_settle",params);
       // strRedisTemplate.convertAndSend("xm_task_settle", JSON.toJSONString(params));
        return tips;
    }

    /**
     * 检查用户是否可以投标
     * @param userid
     * @param at
     * @param exp
     * @param bids
     * @return {tipscode:bids-not-enough,msg:投标次数超限},{tipscode:smaxExp-not-enough,msg:投标工作量超限},{tipscode:smaxAt-not-enough,msg:投标金额超限},
     */
    public Tips checkMemberInterests(String userid,BigDecimal at,BigDecimal exp,Integer bids){
        String url="/mk/mk/mem/memberInterests/checkMemberInterests";
        return callBizService.postForTips(url,map("userid",userid  ,"at",at,"exp",exp,"bids",bids));
    }
}
