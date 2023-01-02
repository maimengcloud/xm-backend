package com.xm.core.service.client;

import com.mdp.core.entity.Tips;
import com.mdp.core.utils.BaseUtils;
import com.mdp.micro.client.CallBizService;
import com.mdp.mq.queue.Push;
import com.xm.core.entity.XmTaskSbillDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

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

}
