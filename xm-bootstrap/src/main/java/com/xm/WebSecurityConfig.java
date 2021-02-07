package com.xm;

import com.mdp.oauth2.client.resource.MdpJwtAuthenticationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * com.qqkj.WebSecurityConfig
 *
 * @author chenyc
 * @date 2019/10/10
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MdpJwtAuthenticationConverter jwtConverter;


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/webjars/**");
    }

    /**
     * 允许匿名访问所有接口 主要是 oauth 接口
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().mvcMatchers("/authorize","/authorized","/","/index","/oauth2/login/token","/oauth2/login/token/web").permitAll().and().oauth2Client().and().logout().disable();
        http.formLogin().usernameParameter("userloginid");
        http.oauth2Login();
        http.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtConverter);
        http.csrf().disable();
    }

}
