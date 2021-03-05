package com.xm;

import com.mdp.oauth2.client.resource.MdpJwtAuthenticationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.web.client.RestOperations;

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

    @Autowired
    RestOperations restOperations;

    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri:}")
    String jwkSetUri="";

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
        http.authorizeRequests().anyRequest().authenticated();
        http.oauth2Client().and().logout().disable();
        http.formLogin().usernameParameter("userloginid");
        http.oauth2Login();
        http.oauth2ResourceServer().jwt().decoder(NimbusJwtDecoder.withJwkSetUri(jwkSetUri).restOperations(restOperations).build()).jwtAuthenticationConverter(jwtConverter);
        http.csrf().disable();
    }

}
