package com.xm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@ComponentScan(basePackages={"com.mdp","com.xm"})
@SpringBootApplication
@EnableRedisHttpSession
public class XmApplication  {
	
 
	public static void main(String[] args) {
		SpringApplication.run(XmApplication.class,args);

	}

}
