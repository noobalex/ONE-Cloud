package com.wuxianmali.one.gateway.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:one-gateway.properties"})
@ConfigurationProperties(prefix = "one.gateway")
public class OneGatewayProperties {

    private String forbidRequestUri;
}
