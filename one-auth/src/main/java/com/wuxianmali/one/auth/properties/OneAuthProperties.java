package com.wuxianmali.one.auth.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:one-auth.properties"})
@ConfigurationProperties(prefix = "one.auth")
public class OneAuthProperties {

    private OneClientsProperties[] clients = {};
    private int accessTokenValiditySeconds = 60 * 60 * 24;
    private int refreshTokenValiditySeconds = 60 * 60 * 24 * 7;

    private String ignoredUrl;

    private OneValidateCodeProperties code = new OneValidateCodeProperties();
}
