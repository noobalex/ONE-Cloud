package com.wuxianmali.one.auth;

import com.wuxianmali.one.common.annotation.EnableOneAuthExceptionHandler;
import com.wuxianmali.one.common.annotation.EnableOneServerProtect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableOneAuthExceptionHandler
@EnableOneServerProtect
public class OneAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneAuthApplication.class, args);
    }

}
