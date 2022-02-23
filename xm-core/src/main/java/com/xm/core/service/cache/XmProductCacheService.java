package com.xm.core.service.cache;

import com.xm.core.entity.XmProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class XmProductCacheService {
	
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
 		return "xm_product";
	} 
	public void putProduct(String productId,XmProduct Product){
		String key=this.getKey();
		String hashKey=productId;
		redisTemplate.opsForHash().put(key, hashKey, Product);
	}
	
	public  XmProduct  getProduct(String productId){
		String key=this.getKey();
		String hashKey=productId;
		return (XmProduct) redisTemplate.opsForHash().get(key, hashKey);
		
	}

	public void clear(String productId){
		String key=this.getKey();
		redisTemplate.opsForHash().delete(key,productId);
	}

	public void putPortalProductStates(List<Map<String,Object>> products){
		String key=this.getKey();
		String hashKey="portal";
		redisTemplate.opsForHash().put(key, hashKey, products);
	}

	public List<Map<String,Object>> getPortalProductStates(){
		String key=this.getKey();
		String hashKey="portal";
		return (List<Map<String,Object>>) redisTemplate.opsForHash().get(key, hashKey);

	}
}
