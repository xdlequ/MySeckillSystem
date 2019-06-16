package com.sun.seckill.Annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

/**
 * Created by ql on 2019/6/16.
 */


@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {isMobileValidator.class})
public @interface IsMobile {
    boolean required() default true;
    String message() default "您输入的用户名有误，建议以手机号作为用户名";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
