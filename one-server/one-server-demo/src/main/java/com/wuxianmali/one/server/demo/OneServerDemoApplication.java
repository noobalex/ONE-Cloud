package com.wuxianmali.one.server.demo;

import com.wuxianmali.one.common.annotation.EnableOneAuthExceptionHandler;
import com.wuxianmali.one.common.annotation.EnableOneOauth2FeignClient;
import com.wuxianmali.one.common.annotation.EnableOneServerProtect;
import com.wuxianmali.one.common.annotation.OneCloudApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableFeignClients
@EnableDiscoveryClient
@OneCloudApplication
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OneServerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneServerDemoApplication.class, args);
    }

}
