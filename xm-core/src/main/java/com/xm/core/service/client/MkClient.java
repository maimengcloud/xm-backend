package com.xm.core.service.client;

import com.alibaba.fastjson.JSON;
import com.mdp.core.entity.Tips;
import com.mdp.core.utils.BaseUtils;
import com.mdp.micro.client.CallBizService;
import com.mdp.mq.queue.Push;
import com.xm.core.entity.XmTaskSbillDetail;
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

    public Tips pushSbillDetail(XmTaskSbillDetail detail){
        Tips tips = new Tips("推送订单成功");
        push.leftPush("xm_task_settle",BaseUtils.toMap(detail));
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
        String url="/mk/mk/mem/memberInterests/checkMemberInterests?userid={userid}&at={at}&exp={exp}&bids={bids}";
        return callBizService.getForTips(url,map("userid",userid  ,"at",at,"exp",exp,"bids",bids));
    }
    /**
     * 检查用户是否可以投标
     * @param userid
     * @param at
     * @param exp
     * @param bids
     * @return {tipscode:bids-not-enough,msg:投标次数超限},{tipscode:smaxExp-not-enough,msg:投标工作量超限},{tipscode:smaxAt-not-enough,msg:投标金额超限},
     */
    public Map<String,Object> checkAndGetMemberInterests(String userid,BigDecimal at,BigDecimal exp,Integer bids){
        String url="/mk/mk/mem/memberInterests/checkMemberInterests?userid={userid}&at={at}&exp={exp}&bids={bids}";
        Map<String,Object> re=callBizService.getForMap(url,map("userid",userid  ,"at",at,"exp",exp,"bids",bids));
        return re;
    }
    /**
     * 检查用户是否可以投标
     * @param userid
     * @return Map
     */
    public Map<String, Object> getMemberDetailByUserid(String userid){
        String url="/mk/mk/mem/member/detailByUserid?userid={userid}";
        Map<String,Object> result= callBizService.getForMap(url,map("userid",userid));
        return (Map<String, Object>) result.get("data");
    }

    /**
     * 投标成功后登记投标次数
     * @return
     */
    public Tips pushBidsAfterBidSuccess(String userid,BigDecimal at,BigDecimal exp,Integer bids){
        Tips tips = new Tips("推送订单成功");
        push.leftPush("xm_task_bid",map("userid",userid  ,"at",at,"exp",exp,"bids",bids));
        // strRedisTemplate.convertAndSend("xm_task_settle", JSON.toJSONString(params));
        return tips;
    }
}
