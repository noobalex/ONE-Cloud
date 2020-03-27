package com.wuxianmali.one.server.system.properties;

import lombok.Data;

@Data
public class OneSwaggerProperties {

    private String basePackage;
    private String title;
    private String description;
    private String version;
    private String author;
    private String url;
    private String email;
    private String license;
    private String licenseUrl;
}