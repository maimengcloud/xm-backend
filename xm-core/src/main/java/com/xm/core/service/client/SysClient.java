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
}
