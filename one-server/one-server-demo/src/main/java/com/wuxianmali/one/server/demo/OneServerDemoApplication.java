package com.wuxianmali.one.server.demo;

import com.wuxianmali.one.common.annotation.EnableOneAuthExceptionHandler;
import com.wuxianmali.one.common.annotation.EnableOneOauth2FeignClient;
import com.wuxianmali.one.common.annotation.EnableOneServerProtect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableOneAuthExceptionHandler
@EnableOneOauth2FeignClient
@EnableOneServerProtect
public class OneServerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneServerDemoApplication.class, args);
    }

}
