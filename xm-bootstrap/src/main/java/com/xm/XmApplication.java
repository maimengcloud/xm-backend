package com.xm;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Component;

@SpringCloudApplication
@EnableRedisHttpSession
public class XmApplication  {
	
 
	public static void main(String[] args) {
		SpringApplication.run(XmApplication.class,args);

	}

}
