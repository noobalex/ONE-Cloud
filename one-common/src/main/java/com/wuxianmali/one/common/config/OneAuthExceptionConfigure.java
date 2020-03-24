package com.wuxianmali.one.common.config;

import com.wuxianmali.one.common.handler.OneAccessDeniedHandler;
import com.wuxianmali.one.common.handler.OneAuthExceptionEntryPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

public class OneAuthExceptionConfigure {
    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public OneAccessDeniedHandler accessDeniedHandler() {
        return new OneAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public OneAuthExceptionEntryPoint authenticationEntryPoint() {
        return new OneAuthExceptionEntryPoint();
    }
}
