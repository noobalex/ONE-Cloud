package com.wuxianmali.one.common.selector;

import com.wuxianmali.one.common.config.OneAuthExceptionConfigure;
import com.wuxianmali.one.common.config.OneOAuth2FeignConfigure;
import com.wuxianmali.one.common.config.OneServerProtectConfigure;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class OneCloudApplicationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                OneAuthExceptionConfigure.class.getName(),
                OneOAuth2FeignConfigure.class.getName(),
                OneServerProtectConfigure.class.getName()
        };
    }
}
