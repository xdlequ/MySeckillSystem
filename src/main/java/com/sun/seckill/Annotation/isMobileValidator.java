package com.sun.seckill.Annotation;

import com.sun.seckill.Utils.mobilevalidator;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by ql on 2019/6/16.
 */

public class isMobileValidator implements ConstraintValidator<IsMobile,String>{
    private boolean required=true;
    @Override
    public void initialize(IsMobile constraintAnnotation) {
            this.required=constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String o, ConstraintValidatorContext constraintValidatorContext) {
        if (required){
            return mobilevalidator.validator(o);
        }else{
            if (StringUtils.isEmpty(o)){
                return false;
            }else{
                return mobilevalidator.validator(o);
            }
        }
        //return false;
    }
}
