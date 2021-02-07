package com.qqkj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.mdp.core.entity.AppAuth;
import com.mdp.safe.common.rest.MdpRestTemplate;
@SpringBootApplication
//@SpringCloudApplication
public class XmApplication  {
	
 
	public static void main(String[] args) {
		SpringApplication.run(XmApplication.class,args);

	}
	@Bean 
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
