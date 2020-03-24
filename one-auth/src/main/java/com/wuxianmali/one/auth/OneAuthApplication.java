package com.wuxianmali.one.auth;

import com.wuxianmali.one.common.annotation.EnableOneAuthExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableOneAuthExceptionHandler
public class OneAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneAuthApplication.class, args);
    }

}
