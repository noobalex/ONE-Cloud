package com.wuxianmali.one.common.annotation;

import com.wuxianmali.one.common.selector.OneCloudApplicationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(OneCloudApplicationSelector.class)
public @interface OneCloudApplication {
}
