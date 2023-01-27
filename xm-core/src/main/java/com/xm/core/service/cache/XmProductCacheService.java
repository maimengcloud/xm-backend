package com.xm.core.service.cache;

import com.mdp.mq.sp.Publish;
import com.xm.core.entity.XmProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Service
public class XmProductCacheService {
	
	@Autowired
	RedisTemplate redisTemplate;

	Map<String,XmProduct> cache=new ConcurrentHashMap<>();

	@Autowired
	Publish publish;

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
	public void putProduct(String productId,XmProduct product){
		String key=this.getKey();
		String hashKey=productId;
		redisTemplate.opsForHash().put(key, hashKey, product);
		if(product!=null){
			cache.put(productId,product);
		}else{
			cache.remove(productId);
		}
		publish.push("XM_PRODUCT_CACHE",productId);
	}
	
	public  XmProduct  getProduct(String productId){
		XmProduct product=cache.get(productId);
		if(product==null){
			String key=this.getKey();
			String hashKey=productId;
			product= (XmProduct) redisTemplate.opsForHash().get(key, hashKey);
			if(product!=null){
				cache.put(productId,product);
			}
			return product;
		}else {
			return product;
		}
		
	}

	public void clear(String productId){
		String key=this.getKey();
		cache.remove(productId);
		redisTemplate.opsForHash().delete(key,productId);

		publish.push("XM_PRODUCT_CACHE",productId);
	}

	public void clearLocalCache(String productId) {
		this.cache.remove(productId);
	}
}
