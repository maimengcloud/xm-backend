package com.xm.core.service.cache;

import com.xm.core.entity.XmProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class XmTaskCacheService {
	
	@Autowired
	RedisTemplate redisTemplate;
  
	String getCacheKey() {
 		return "xm_task";
	} 
	public void putTasks(String queryKeys, List<Map<String,Object>> tasks){
		String key=this.getCacheKey()+"_"+queryKeys;
		String hashKey=key;
		redisTemplate.opsForHash().put(key, hashKey, tasks);
		redisTemplate.expire(hashKey, 24, TimeUnit.HOURS);
	}
	
	public  List<Map<String,Object>>  getTasks(String queryKeys){
		String key=this.getCacheKey()+"_"+queryKeys;
		String hashKey=key;
		return (List<Map<String,Object>>) redisTemplate.opsForHash().get(key, hashKey);
		
	}
	
}
