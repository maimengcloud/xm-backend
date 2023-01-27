package com.xm.core.service.cache;

import com.mdp.mq.sp.Publish;
import com.xm.core.entity.XmProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Service
public class XmProjectCacheService {
	
	@Autowired
	RedisTemplate redisTemplate;
	String currDateKey="";

	Map<String, XmProject> cache=new ConcurrentHashMap<>();

	@Autowired
	Publish publish;

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
	public void putProject(String projectId,XmProject project){
		String key=this.getKey();
		String hashKey=projectId;
		redisTemplate.opsForHash().put(key, hashKey, project);
		if(project!=null){
			this.cache.put(projectId,project);
		}else{
			this.cache.remove(projectId);
		}
		publish.push("XM_PROJECT_CACHE",projectId);
	}
	
	public  XmProject  getProject(String projectId){
		XmProject project=cache.get(projectId);
		if(project==null) {
			String key = this.getKey();
			String hashKey = projectId;
			project= (XmProject) redisTemplate.opsForHash().get(key, hashKey);
			cache.put(projectId,project);
			return project;
		}else{
			return project;
		}
		
	}
	public void clear(String projectId){
		String key=this.getKey();
		cache.remove(projectId);
		redisTemplate.opsForHash().delete(key,projectId);

		publish.push("XM_PROJECT_CACHE",projectId);
	}

	public void clearLocalCache(String projectId) {
		this.cache.remove(projectId);
	}
}
