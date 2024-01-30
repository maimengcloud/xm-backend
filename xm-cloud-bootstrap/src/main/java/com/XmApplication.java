package com;

import org.springframework.boot.SpringApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
public class XmApplication  {
	
 
	public static void main(String[] args) {
		SpringApplication.run(XmApplication.class,args);

	}

}
