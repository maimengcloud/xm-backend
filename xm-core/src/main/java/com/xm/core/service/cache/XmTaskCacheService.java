package com.xm.core.service.cache;

import com.github.pagehelper.PageSerializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class XmTaskCacheService {
	
	@Autowired
	RedisTemplate redisTemplate;

	String currDateKey="";
	public String getKey(){
		Calendar currCal=Calendar.getInstance();
		String dateKey=currCal.get(Calendar.YEAR)+"-"+currCal.get(Calendar.DAY_OF_YEAR);
		if(dateKey.equals(currDateKey)){
			return this.getCacheKey()+":"+dateKey;
		}else {
			currDateKey=dateKey;
			this.redisTemplate.expire(this.getCacheKey()+":"+dateKey,24,TimeUnit.HOURS);
			return this.getCacheKey()+":"+dateKey;
		}
	}
  
	String getCacheKey() {
 		return "xm_task";
	} 
	public void putTasks(String queryKeys, PageSerializable<Map<String,Object>> tasks){
		String key=this.getKey();
		String hashKey=queryKeys;
		redisTemplate.opsForHash().put(key, hashKey, tasks);
	}
	
	public PageSerializable<Map<String,Object>> getTasks(String queryKeys){
		String key=this.getKey();
		String hashKey=queryKeys;
		return (PageSerializable<Map<String,Object>>) redisTemplate.opsForHash().get(key, hashKey);
		
	}
	
}
