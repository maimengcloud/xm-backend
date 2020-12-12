package com.qqkj.xm.push.service;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.qqkj.mdp.core.entity.Tips;
import com.qqkj.mdp.core.utils.BaseUtils;
import com.qqkj.mdp.safe.common.rest.MdpRestTemplate;

@Service
public class CallBizService {
	
	@Value("${spring.profiles.active:dev}")
	String profiles="dev";
	
	@Autowired
	MdpRestTemplate restTemplate;
	
	Log logger=LogFactory.getLog(CallBizService.class);
	
	@Value("${mdp.api-gate:http://gate}")//云环境下 
	//@Value("${mdp.api-gate:https://www.qingqinkj.com/api/m1}") //本地调试
	String apiGate="";
	
	
	public Tips callApi(String restUrl,Map<String,Object> params){

		Tips tips=new Tips("远程调用成功");
        if(!StringUtils.isEmpty(restUrl)) {
        	if(restUrl.indexOf("http")<0 && restUrl.indexOf("www")<0) {
        		restUrl=apiGate+restUrl;
        	}
        } 
		ResponseEntity<Map> forEntity =  restTemplate.postForEntity(restUrl, params,Map.class);
		Map<String,Object> m = (Map<String,Object>)forEntity.getBody();
        tips= BaseUtils.mapToTips(m);
        if(tips!=null) {
        	if(!tips.isOk()){ 
        		logger.error(tips.toString());
        		return tips;
    		}else {
    			//成功调用
    			logger.info(tips.toString());
    		}
        }else {
        	tips=new Tips("后台未返回任何数据");
        }
		return tips;
	}
	
	@PostConstruct
	void initApiGate(){
		if("dev".equals(this.profiles)) {
			//this.apiGate="http://127.0.0.1:7080/workflow";
			this.apiGate="https://www.qingqinkj.com/api/m1";
		}
	}

}
