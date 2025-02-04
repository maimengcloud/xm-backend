package com;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 要使用mdp平台功能，必须 扫码com.mdp包
 * 一些默认公共配置
 */
@ComponentScan(basePackages={"com.mdp"})
@Configuration
public class AutoConfig {
}
