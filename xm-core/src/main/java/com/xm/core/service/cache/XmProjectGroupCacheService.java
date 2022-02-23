package com.xm.core.service.cache;

import com.xm.core.vo.XmProjectGroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class XmProjectGroupCacheService {
	
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
 		return "xm_project_group";
	} 
	public void putProjectGroups(String projectId,List<XmProjectGroupVo> groups){
		String key=this.getKey()+"_prj_"+projectId;
		String hashKey=key;
		redisTemplate.opsForHash().put(key, hashKey, groups);
	}
	
	public  List<XmProjectGroupVo>  getProjectGroups(String projectId){
		String key=this.getKey()+"_"+projectId;
		String hashKey=key;
		return (List<XmProjectGroupVo>) redisTemplate.opsForHash().get(key, hashKey);
		
	}
	public  List<XmProjectGroupVo>  getProductGroups(String productId){
		String key=this.getKey()+"_pro_"+productId;
		String hashKey=key;
		return (List<XmProjectGroupVo>) redisTemplate.opsForHash().get(key, hashKey);

	}
	public void putProductGroups(String productId,List<XmProjectGroupVo> groups){
		String key=this.getKey()+"_pro_"+productId;
		String hashKey=key;
		redisTemplate.opsForHash().put(key, hashKey, groups);
	}
	
}
