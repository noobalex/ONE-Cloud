package com.wuxianmali.one.auth;

import com.wuxianmali.one.common.annotation.EnableOneAuthExceptionHandler;
import com.wuxianmali.one.common.annotation.EnableOneLettuceRedis;
import com.wuxianmali.one.common.annotation.EnableOneServerProtect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableOneAuthExceptionHandler
@EnableOneServerProtect
@EnableOneLettuceRedis
@MapperScan("com.wuxianmali.one.auth.mapper")
public class OneAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneAuthApplication.class, args);
    }

}
