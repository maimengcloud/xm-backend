package com.qqkj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
//org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.client.RestTemplate;

import com.qqkj.mdp.core.entity.AppAuth;
import com.qqkj.mdp.safe.common.rest.MdpRestTemplate;
//@SpringBootApplication
@SpringCloudApplication

@EnableRedisHttpSession
public class XmApplication  {
	
 
	public static void main(String[] args) {
		SpringApplication.run(XmApplication.class,args);

	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate () 
	{
	SimpleClientHttpRequestFactory simpleClientHttpRequestFactory  = new SimpleClientHttpRequestFactory ();
	simpleClientHttpRequestFactory.setConnectTimeout(20000);
	simpleClientHttpRequestFactory.setReadTimeout(20000);
	  return new RestTemplate(simpleClientHttpRequestFactory);
	}
	@Bean
	@Autowired
	public MdpRestTemplate mdpRestTemplate(RestTemplate restTemplate,AppAuth appAuth) {
		return new MdpRestTemplate(restTemplate, appAuth);
		
	}
}
