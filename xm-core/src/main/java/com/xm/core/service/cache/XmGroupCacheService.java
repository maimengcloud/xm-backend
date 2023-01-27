package com.xm.core.service.cache;

import com.mdp.mq.sp.Publish;
import com.xm.core.vo.XmGroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Service
public class XmGroupCacheService {
	
	@Autowired
	RedisTemplate redisTemplate;

	Map<String, List<XmGroupVo>> cache=new ConcurrentHashMap<>();

	@Autowired
	Publish publish;

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
 		return "xm_group";
	}

	public  List<XmGroupVo>  getProjectGroups(String projectId){
		List<XmGroupVo> groupVoList=this.cache.get("prj_"+projectId);
		if(groupVoList==null){
			String key=this.getProjectKey(projectId);
			groupVoList=  (List<XmGroupVo>) redisTemplate.opsForHash().values(key);

			if(groupVoList!=null){
				this.cache.put("prj_"+projectId,groupVoList);
			}
			return groupVoList;
		}else {
			return groupVoList;
		}


	}
	public XmGroupVo getProjectGroup(String projectId, String groupId){
		String key=this.getProjectKey(projectId);
		return (XmGroupVo) redisTemplate.opsForHash().get(key,groupId);
	}
	public  void  putProjectGroup(XmGroupVo group){
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
	public void putProjectGroups(String projectId,List<XmGroupVo> groups){

		String key=this.getProjectKey(projectId);
		if(groups==null || groups.size()==0){
			this.clearProjectGroups(projectId);
			return;
		}
		for (XmGroupVo group : groups) {
			String hashKey= group.getId();
			redisTemplate.opsForHash().put(key, hashKey, group);
		}
		if(groups==null){
			this.cache.remove("prj_"+projectId);
		}else{
			this.cache.put("prj_"+projectId,groups);
		}
		publish.push("XM_GROUP_PRJ_CACHE",projectId);
	}
	public void clearProjectGroups(String projectId){
		String key=this.getProjectKey(projectId);
		Set<String> keySet=redisTemplate.opsForHash().keys(key);
		if(keySet!=null && keySet.size()>0){
			redisTemplate.opsForHash().delete(key,keySet.toArray());
		}
		this.cache.remove("prj_"+projectId);
		publish.push("XM_GROUP_PRJ_CACHE",projectId);
	}

	public  List<XmGroupVo>  getProductGroups(String productId){
		List<XmGroupVo> groupVoList=this.cache.get("prd_"+productId);
		if(groupVoList==null){
			String key=this.getProductKey(productId);
			groupVoList= (List<XmGroupVo>) redisTemplate.opsForHash().values(key);
			if(groupVoList!=null){
				this.cache.put("prd_"+productId,groupVoList);
			}
			return groupVoList;
		}else {
			return groupVoList;
		}
	}
	public XmGroupVo getProductGroup(String productId, String groupId){
		String key=this.getProductKey(productId);
		return (XmGroupVo) redisTemplate.opsForHash().get(key,groupId);
	}
	public  void  putProductGroup(XmGroupVo group){
		String key=this.getProductKey(group.getProductId());
		redisTemplate.opsForHash().put(key, group.getId(), group);
	}
	public  void  clearProductGroup(String productId){
		String key=this.getProductKey(productId);
		this.clearProductGroups(productId);
	}
	public void putProductGroups(String productId,List<XmGroupVo> groups){
		String key=this.getProductKey(productId);
		if(groups==null || groups.size()==0){
			 this.clearProductGroups(productId);
			return;
		}
		for (XmGroupVo group : groups) {
			String hashKey= group.getId();
			redisTemplate.opsForHash().put(key, hashKey, group);
		}
		if(groups==null){
			this.cache.remove("prd_"+productId);
		}else{
			this.cache.put("prd_"+productId,groups);
		}
		publish.push("XM_GROUP_PRD_CACHE",productId);
	}
	public void clearProductGroups(String productId){
		String key=this.getProductKey(productId);
			Set<String> keySet=redisTemplate.opsForHash().keys(key);
			if(keySet!=null && keySet.size()>0){
				redisTemplate.opsForHash().delete(key,keySet.toArray());
			}
		this.cache.remove("prd_"+productId);
		publish.push("XM_GROUP_PRD_CACHE",productId);
	}

	public void clearLocalPrjectCache(String projectId) {
		this.cache.remove("prj_"+projectId);
	}

	public void clearLocalProductCache(String productId) {
		this.cache.remove("prd_"+productId);
	}
}
