package com.xm.core.service.cache;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.xm.core.vo.XmProjectGroupVo;

@Service
public class XmProjectGroupCacheService {
	
	@Autowired
	RedisTemplate redisTemplate;
  
	String getCacheKey() {
 		return "xm_project_group";
	} 
	public void putGroups(String projectId,List<XmProjectGroupVo> groups){
		String key=this.getCacheKey()+"_"+projectId;
		String hashKey=key;
		redisTemplate.opsForHash().put(key, hashKey, groups); 
		redisTemplate.expire(hashKey, 24, TimeUnit.HOURS);
	}
	
	public  List<XmProjectGroupVo>  getGroups(String projectId){
		String key=this.getCacheKey()+"_"+projectId;
		String hashKey=key;
		return (List<XmProjectGroupVo>) redisTemplate.opsForHash().get(key, hashKey);
		
	}
	
}
