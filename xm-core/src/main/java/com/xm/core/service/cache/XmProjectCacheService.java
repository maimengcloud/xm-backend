package com.xm.core.service.cache;

import com.xm.core.entity.XmProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class XmProjectCacheService {
	
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
 		return "xm_project";
	} 
	public void putProject(String projectId,XmProject Project){
		String key=this.getKey()+"_"+projectId;
		String hashKey=key;
		redisTemplate.opsForHash().put(key, hashKey, Project);
	}
	
	public  XmProject  getProject(String projectId){
		String key=this.getKey()+"_"+projectId;
		String hashKey=key;
		return (XmProject) redisTemplate.opsForHash().get(key, hashKey);
		
	}

	public void putPortalProjectStates(List<Map<String,Object>> projects){
		String key=this.getKey()+"_"+"portal";
		String hashKey=key;
		redisTemplate.opsForHash().put(key, hashKey, projects);
	}

	public List<Map<String,Object>> getPortalProjectStates(){
		String key=this.getKey()+"_"+"portal";
		String hashKey=key;
		return (List<Map<String,Object>>) redisTemplate.opsForHash().get(key, hashKey);

	}
}
