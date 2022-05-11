package com.xm.core.service.client;

import com.mdp.core.entity.Tips;
import com.mdp.core.utils.BaseUtils;
import com.mdp.micro.client.CallBizService;
import com.mdp.mq.queue.Push;
import com.mdp.safe.client.entity.User;
import com.xm.core.entity.XmTaskSbillDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

import static com.mdp.core.utils.BaseUtils.map;

/**
 * 对sys接口调用
 */
@Service
public class SysClient {


    @Autowired
    CallBizService callBizService;

    @Autowired
    Push push;

    /**
     * 查询用户详细资料
     * @param userid
     * @return
     */
    public User getUserByUserid(String userid){
        String url="/sys/sys/user/detail?userid={userid}";
        Map<String,Object> re=callBizService.getForMap(url,map("userid",userid));
        Map<String,Object> data= (Map<String, Object>) re.get("data");
        if(data==null || data.isEmpty()){
            return null;
        }
        User user=BaseUtils.fromMap(data,User.class);
        return user;

    }
    /**
     * 检查用户归属企业是否可以投标等等
     * @param branchId
     * @param at
     * @param exp
     * @param bids
     * @return {tipscode:bids-not-enough,msg:投标次数超限},{tipscode:smaxExp-not-enough,msg:投标工作量超限},{tipscode:smaxAt-not-enough,msg:投标金额超限},
     */
    public Map<String,Object> checkAndGetBranchInterests(String branchId,BigDecimal at,BigDecimal exp,Integer bids){
        String url="/sys/sys/branchInterests/checkBranchInterests?branchId={branchId}&at={at}&exp={exp}&bids={bids}";
        Map<String,Object> re=callBizService.getForMap(url,map("branchId",branchId  ,"at",at,"exp",exp,"bids",bids));
        return re;
    }

    /**
     * 投标成功后登记投标次数-登记企业的投标次数
     * @return
     */
    public Tips pushBidsAfterBidSuccess(String branchId,BigDecimal at,BigDecimal exp,Integer bids){
        Tips tips = new Tips("推送订单成功");
        push.leftPush("xm_task_bid_for_branch",map("branchId",branchId  ,"at",at,"exp",exp,"bids",bids));
        // strRedisTemplate.convertAndSend("xm_task_settle", JSON.toJSONString(params));
        return tips;
    }
}
