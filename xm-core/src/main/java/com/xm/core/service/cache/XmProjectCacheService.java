package com.xm.core.service.cache;

import com.xm.core.entity.XmProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class XmProjectCacheService {
	
	@Autowired
	RedisTemplate redisTemplate;
  
	String getCacheKey() {
 		return "xm_project";
	} 
	public void putProject(String projectId,XmProject Project){
		String key=this.getCacheKey()+"_"+projectId;
		String hashKey=key;
		redisTemplate.opsForHash().put(key, hashKey, Project); 
		redisTemplate.expire(hashKey, 24, TimeUnit.HOURS);
	}
	
	public  XmProject  getProject(String projectId){
		String key=this.getCacheKey()+"_"+projectId;
		String hashKey=key;
		return (XmProject) redisTemplate.opsForHash().get(key, hashKey);
		
	}
	
}
