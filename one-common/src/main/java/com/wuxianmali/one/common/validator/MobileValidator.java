package com.wuxianmali.one.common.validator;

import com.wuxianmali.one.common.annotation.Mobile;
import com.wuxianmali.one.common.entity.RegexpConstant;
import com.wuxianmali.one.common.utils.OneUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileValidator implements ConstraintValidator<Mobile, String> {
    @Override
    public void initialize(Mobile constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            if (StringUtils.isBlank(s)) {
                return true;
            } else {
                String regex = RegexpConstant.MOBILE_REG;
                return OneUtil.match(regex, s);
            }
        } catch (Exception e) {
            return false;
        }
    }
}
