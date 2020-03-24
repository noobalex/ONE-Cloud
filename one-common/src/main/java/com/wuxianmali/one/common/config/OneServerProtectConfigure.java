package com.wuxianmali.one.common.config;

import com.wuxianmali.one.common.interceptor.OneServerProtectInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class OneServerProtectConfigure implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor febsServerProtectInterceptor() {
        return new OneServerProtectInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(febsServerProtectInterceptor());
    }
}
