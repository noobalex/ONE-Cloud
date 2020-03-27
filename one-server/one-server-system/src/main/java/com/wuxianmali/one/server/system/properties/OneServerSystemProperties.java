package com.wuxianmali.one.server.system.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:one-server-system.properties"})
@ConfigurationProperties(prefix = "one.server.system")
public class OneServerSystemProperties {

    private String ignoredUrl;

    private OneSwaggerProperties swagger = new OneSwaggerProperties();
}
