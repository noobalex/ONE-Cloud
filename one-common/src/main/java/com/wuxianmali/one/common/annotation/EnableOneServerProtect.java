package com.wuxianmali.one.common.annotation;

import com.wuxianmali.one.common.config.OneServerProtectConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(OneServerProtectConfigure.class)
public @interface EnableOneServerProtect {
}
