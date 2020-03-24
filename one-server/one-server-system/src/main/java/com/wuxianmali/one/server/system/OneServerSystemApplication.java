package com.wuxianmali.one.server.system;

import com.wuxianmali.one.common.annotation.EnableOneAuthExceptionHandler;
import com.wuxianmali.one.common.annotation.EnableOneServerProtect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableOneAuthExceptionHandler
@EnableOneServerProtect
public class OneServerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneServerSystemApplication.class, args);
    }

}
