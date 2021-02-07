package com.mdp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.web.cors.CorsUtils;

import com.mdp.core.log.MdpLogFilter;
import com.mdp.safe.common.entrypoint.SafeAuthenticationEntryPoint;
import com.mdp.safe.common.expression.DbPermissionEvaluator;
import com.mdp.safe.common.filter.MdpApiAuthorizationFilter;
import com.mdp.safe.common.filter.MdpUserAuthenticationFilter;
import com.mdp.safe.common.filter.MdpUserAuthorizationFilter;
import com.mdp.safe.common.handle.SafeAccessDeniedHandler;
import com.mdp.safe.common.handle.SafeAuthenticationFailureHandler;
import com.mdp.safe.common.handle.SafeAuthenticationSuccessHandler;
import com.mdp.safe.common.pwd.SafePasswordEncoder;
import com.mdp.safe.common.service.SafeUserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 

	
	@Autowired
	SafeUserService userService;
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		 web.ignoring().antMatchers("/**/*.ttf","/**/*.woff","/**/*.woff2","/**/*.eot","/**/*.css","/**/*.js","/**/*.gif","/**/*.png","/**/*.jpg","/**/*.ico","/**/*.GIF","/**/*.PNG","/**/*.JPG","/**/*.ICO","/**/*.html","/**/*.HTML","/**/*.htm","/**/*.js.map","/**/*.jsp","/**/*.bmp");
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception { 
    	
        http.authorizeRequests().accessDecisionManager(accessDecisionManager()).expressionHandler(webSecurityExpressionHandler())
        .antMatchers("/actuator/**","/**/common/login","/**/common/user/reg/web","/","/index.html","/login","/error","/","/index","/**/safe/app/auth**","/**/arc/image/upload").permitAll()
        
        .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
        .anyRequest().authenticated().and()
        //.addFilterAfter(wxpubLoginFilter(), UsernamePasswordAuthenticationFilter.class).authorizeRequests().and()
        	//.antMatcher(wxaAuthorizePattern).addFilterAfter(wxaLoginFilter(), UsernamePasswordAuthenticationFilter.class).authorizeRequests().and()
        .addFilterBefore(new MdpLogFilter(), ChannelProcessingFilter.class)
        .addFilterBefore(userAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
        .addFilterAt(userAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
        .addFilterAfter(apiAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
        .formLogin().disable()
            .logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
                .and().csrf().disable().httpBasic().disable().exceptionHandling().and().exceptionHandling().accessDeniedHandler(accessDeniedHandler()).authenticationEntryPoint(safeAuthenticationEntryPoint())
             	;
    }
    @Bean
    public AuthenticationEntryPoint safeAuthenticationEntryPoint() {
		// TODO Auto-generated method stub
		return new SafeAuthenticationEntryPoint();
	}

	@Bean
    public AccessDeniedHandler accessDeniedHandler() {
		// TODO Auto-generated method stub
		return new SafeAccessDeniedHandler();
	}

	@Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
		// TODO Auto-generated method stub
		return new SafeAuthenticationFailureHandler();
	}
    @Bean
    public AuthenticationSuccessHandler successHandler() {
		// TODO Auto-generated method stub
		return new SafeAuthenticationSuccessHandler();
	}
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
	public MdpUserAuthenticationFilter userAuthenticationFilter() throws Exception{
    	MdpUserAuthenticationFilter f=new MdpUserAuthenticationFilter();
    	 
			f.setAuthenticationManager(authenticationManagerBean());
			f.setFilterProcessesUrl("/**/common/login");
			f.setAuthenticationSuccessHandler(successHandler());
			f.setUsernameParameter("displayUserid");
			f.setAuthenticationFailureHandler(authenticationFailureHandler()); 
		 
		return f;
    	
    }
    @Bean
	public MdpUserAuthorizationFilter userAuthorizationFilter() throws Exception{
    	MdpUserAuthorizationFilter f=new MdpUserAuthorizationFilter(authenticationManagerBean()); 
		return f;
    	
    }
    @Bean
	public MdpApiAuthorizationFilter apiAuthorizationFilter() throws Exception{
    	MdpApiAuthorizationFilter f=new MdpApiAuthorizationFilter(authenticationManagerBean()); 
		return f;
    	
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
    	auth.userDetailsService(userService).passwordEncoder(new SafePasswordEncoder()); 
    }
    /* 
     *  
     * 这里可以增加自定义的投票器 
     */  
    @SuppressWarnings("rawtypes")  
    @Bean(name = "accessDecisionManager")  
    public AccessDecisionManager accessDecisionManager() {   
        List<AccessDecisionVoter<? extends Object>> decisionVoters = new ArrayList<>();  
        decisionVoters.add(new RoleVoter());  
        decisionVoters.add(new AuthenticatedVoter());  
        decisionVoters.add(webExpressionVoter());// 启用表达式投票器  
  
        AffirmativeBased accessDecisionManager = new AffirmativeBased(decisionVoters);  
  
        return accessDecisionManager;  
    }  
  
    /* 
     * 表达式控制器 
     */  
    @Bean(name = "expressionHandler")  
    public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {    
        DefaultWebSecurityExpressionHandler webSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();  
        webSecurityExpressionHandler.setPermissionEvaluator(new DbPermissionEvaluator());
        return webSecurityExpressionHandler;  
    }  
  
    /* 
     * 表达式投票器 
     */  
    @Bean(name = "expressionVoter")  
    public WebExpressionVoter webExpressionVoter() {   
        WebExpressionVoter webExpressionVoter = new WebExpressionVoter();  
        webExpressionVoter.setExpressionHandler(webSecurityExpressionHandler());  
        return webExpressionVoter;  
    } 

}