package com.wuxianmali.one.auth.config;

import com.wuxianmali.one.common.handler.OneAccessDeniedHandler;
import com.wuxianmali.one.common.handler.OneAuthExceptionEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class OneResourceServerConfigure extends ResourceServerConfigurerAdapter {

    @Autowired
    private OneAuthExceptionEntryPoint authExceptionEntryPoint;
    @Autowired
    private OneAccessDeniedHandler accessDeniedHandler;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers("/**").authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(authExceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}
