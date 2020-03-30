package com.wuxianmali.one.auth.config;

import com.wuxianmali.one.auth.properties.OneAuthProperties;
import com.wuxianmali.one.common.handler.OneAccessDeniedHandler;
import com.wuxianmali.one.common.handler.OneAuthExceptionEntryPoint;
import org.apache.commons.lang3.StringUtils;
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
    @Autowired
    private OneAuthProperties properties;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {

        String[] ignoredUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(properties.getIgnoredUrl(), ",");

        httpSecurity.csrf().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers(ignoredUrls).permitAll()
                .antMatchers("/**").authenticated()
                .and().httpBasic();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(authExceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}
