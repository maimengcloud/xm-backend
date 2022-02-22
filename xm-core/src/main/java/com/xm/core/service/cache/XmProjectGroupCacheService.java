package com.xm.core.service.cache;

import com.xm.core.vo.XmProjectGroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class XmProjectGroupCacheService {
	
	@Autowired
	RedisTemplate redisTemplate;
  
	String getCacheKey() {
 		return "xm_project_group";
	} 
	public void putProjectGroups(String projectId,List<XmProjectGroupVo> groups){
		String key=this.getCacheKey()+"_prj_"+projectId;
		String hashKey=key;
		redisTemplate.opsForHash().put(key, hashKey, groups); 
		redisTemplate.expire(hashKey, 24, TimeUnit.HOURS);
	}
	
	public  List<XmProjectGroupVo>  getProjectGroups(String projectId){
		String key=this.getCacheKey()+"_"+projectId;
		String hashKey=key;
		return (List<XmProjectGroupVo>) redisTemplate.opsForHash().get(key, hashKey);
		
	}
	public  List<XmProjectGroupVo>  getProductGroups(String productId){
		String key=this.getCacheKey()+"_pro_"+productId;
		String hashKey=key;
		return (List<XmProjectGroupVo>) redisTemplate.opsForHash().get(key, hashKey);

	}
	public void putProductGroups(String productId,List<XmProjectGroupVo> groups){
		String key=this.getCacheKey()+"_pro_"+productId;
		String hashKey=key;
		redisTemplate.opsForHash().put(key, hashKey, groups);
		redisTemplate.expire(hashKey, 24, TimeUnit.HOURS);
	}
	
}
