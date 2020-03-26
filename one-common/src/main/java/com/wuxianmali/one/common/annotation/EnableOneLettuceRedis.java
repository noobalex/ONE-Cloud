package com.wuxianmali.one.common.annotation;

import com.wuxianmali.one.common.config.OneLettuceRedisConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(OneLettuceRedisConfigure.class)
public @interface EnableOneLettuceRedis {
}
