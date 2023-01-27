package com.xm.core.service.cache.sub;

import com.xm.core.service.cache.XmGroupCacheService;
import com.xm.core.service.cache.XmProductCacheService;
import com.xm.core.service.cache.XmProjectCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CacheMessageListener implements MessageListener {


	RedisSerializer<String> stringSerializer=RedisSerializer.string();
	
	@Autowired
	StringRedisTemplate redisTemplate;

	@Autowired
	XmProductCacheService xmProductCacheService;


	@Autowired
	XmProjectCacheService xmProjectCacheService;


	@Autowired
	XmGroupCacheService  xmGroupCacheService;


    private static final Logger logger = LoggerFactory.getLogger(CacheMessageListener.class);
	
    /*定时心跳*/
    @Scheduled(cron = "0/10 * * * * *")
    public void timer() {
        redisTemplate.convertAndSend("XM_PRODUCT_CACHE", "");
        redisTemplate.opsForValue().set("headbea", "1");
    }
	
	
	@Override
	public void onMessage(Message message, byte[] pattern) {
		try {
			// TODO Auto-generated method stub 
			String msg=message.toString();
			logger.debug("消息下行开始----》"+msg);
			//logger.debug(msg);
			//心跳包
			if("".equals(msg)||"\"\"".equals(msg)) {
				return;
			}
			String channelName=stringSerializer.deserialize(pattern);
			if(channelName.startsWith("XM_PRODUCT_CACHE")) {
				xmProductCacheService.clearLocalCache(msg);
 			}else if(channelName.startsWith("XM_PROJECT_CACHE")) {
				xmProjectCacheService.clearLocalCache(msg);
			}else if(channelName.startsWith("XM_GROUP_PRJ_CACHE")) {
				xmGroupCacheService.clearLocalPrjectCache(msg);
			}else if(channelName.startsWith("XM_GROUP_PRD_CACHE")) {
				xmGroupCacheService.clearLocalProductCache(msg);
			}
		} catch (Exception e) {
			logger.error("",e);
		}finally {
			logger.debug("消息下行结束!!!!!!!!");
		}
		
	}

	 
}
