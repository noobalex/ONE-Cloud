package com.wuxianmali.one.server.system.config;

import com.wuxianmali.one.common.handler.OneAccessDeniedHandler;
import com.wuxianmali.one.common.handler.OneAuthExceptionEntryPoint;
import com.wuxianmali.one.server.system.properties.OneServerSystemProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class OneServerSystemResourceServerConfigure extends ResourceServerConfigurerAdapter {

    @Autowired
    private OneAuthExceptionEntryPoint authExceptionEntryPoint;
    @Autowired
    private OneAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private OneServerSystemProperties properties;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        String[] ignoredUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(properties.getIgnoredUrl(), ",");
        http.csrf().disable()
                .requestMatchers()
                .antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers(ignoredUrls).permitAll()
                .antMatchers("/**")
                .authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(authExceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}
