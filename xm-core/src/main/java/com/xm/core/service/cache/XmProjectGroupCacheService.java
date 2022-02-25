package com.xm.core.service.cache;

import com.xm.core.vo.XmProjectGroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class XmProjectGroupCacheService {
	
	@Autowired
	RedisTemplate redisTemplate;

	String currPrdDateKey="";
	public String getProductKey(String productId){
		Calendar currCal=Calendar.getInstance();
		String dateKey=currCal.get(Calendar.YEAR)+"-"+currCal.get(Calendar.DAY_OF_YEAR)+"_prd";
		String finalKey=this.getCacheKey()+":"+dateKey+":"+productId;
		if(dateKey.equals(currPrdDateKey)){
			return finalKey;
		}else {
			currPrdDateKey=dateKey;
			this.redisTemplate.expire(finalKey,24,TimeUnit.HOURS);
			return finalKey;
		}
	}
	String currPrjDateKey="";
	public String getProjectKey(String projectId){
		Calendar currCal=Calendar.getInstance();
		String dateKey=currCal.get(Calendar.YEAR)+"-"+currCal.get(Calendar.DAY_OF_YEAR)+"_prj";
		String finalKey=this.getCacheKey()+":"+dateKey+":"+projectId;
		if(dateKey.equals(currPrjDateKey)){
			return finalKey;
		}else {
			currPrjDateKey=dateKey;
			this.redisTemplate.expire(finalKey,24,TimeUnit.HOURS);
			return finalKey;
		}
	}
	String getCacheKey() {
 		return "xm_project_group";
	}

	public  List<XmProjectGroupVo>  getProjectGroups(String projectId){
		String key=this.getProjectKey(projectId);
		return (List<XmProjectGroupVo>) redisTemplate.opsForHash().values(key);

	}
	public  XmProjectGroupVo  getProjectGroup(String projectId,String groupId){
		String key=this.getProjectKey(projectId);
		return (XmProjectGroupVo) redisTemplate.opsForHash().get(key,groupId);
	}
	public  void  putProjectGroup(XmProjectGroupVo group){
		String key=this.getProjectKey(group.getProjectId());
		redisTemplate.opsForHash().put(key, group.getId(), group);
	}

	/**
	 *
	 * @param projectId
	 */
	public  void  clearProjectGroup(String projectId){
		String key=this.getProjectKey(projectId);
		this.clearProjectGroups(projectId);
	}
	public void putProjectGroups(String projectId,List<XmProjectGroupVo> groups){
		String key=this.getProjectKey(projectId);
		if(groups==null || groups.size()==0){
			this.clearProjectGroups(projectId);
			return;
		}
		for (XmProjectGroupVo group : groups) {
			String hashKey= group.getId();
			redisTemplate.opsForHash().put(key, hashKey, group);
		}
	}
	public void clearProjectGroups(String projectId){
		String key=this.getProjectKey(projectId);
		Set<String> keySet=redisTemplate.opsForHash().keys(key);
		if(keySet!=null && keySet.size()>0){
			redisTemplate.opsForHash().delete(key,keySet.toArray());
		}
	}

	public  List<XmProjectGroupVo>  getProductGroups(String productId){
		String key=this.getProductKey(productId);
		return (List<XmProjectGroupVo>) redisTemplate.opsForHash().values(key);

	}
	public  XmProjectGroupVo  getProductGroup(String productId,String groupId){
		String key=this.getProductKey(productId);
		return (XmProjectGroupVo) redisTemplate.opsForHash().get(key,groupId);
	}
	public  void  putProductGroup(XmProjectGroupVo group){
		String key=this.getProductKey(group.getProductId());
		redisTemplate.opsForHash().put(key, group.getId(), group);
	}
	public  void  clearProductGroup(String productId){
		String key=this.getProductKey(productId);
		this.clearProductGroups(productId);
	}
	public void putProductGroups(String productId,List<XmProjectGroupVo> groups){
		String key=this.getProductKey(productId);
		if(groups==null || groups.size()==0){
			 this.clearProductGroups(productId);
			return;
		}
		for (XmProjectGroupVo group : groups) {
			String hashKey= group.getId();
			redisTemplate.opsForHash().put(key, hashKey, group);
		}
	}
	public void clearProductGroups(String productId){
		String key=this.getProductKey(productId);
			Set<String> keySet=redisTemplate.opsForHash().keys(key);
			if(keySet!=null && keySet.size()>0){
				redisTemplate.opsForHash().delete(key,keySet.toArray());
			}
	}
	
}
