package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

//@ComponentScan(basePackages={"com.mdp","com.xm"})
@SpringBootApplication
@EnableRedisHttpSession
public class XmApplication  {
	
 
	public static void main(String[] args) {
		SpringApplication.run(XmApplication.class,args);

	}

}
