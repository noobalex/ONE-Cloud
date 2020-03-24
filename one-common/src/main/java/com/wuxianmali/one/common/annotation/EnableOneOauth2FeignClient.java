package com.wuxianmali.one.common.annotation;

import com.wuxianmali.one.common.config.OneOAuth2FeignConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(OneOAuth2FeignConfigure.class)
public @interface EnableOneOauth2FeignClient {
}
