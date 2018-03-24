package com.perfect.team.service.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CategoryCreateValidator.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CategoryCreate {
    String message() default "{com.perfect.team.service.validation.CategoryCreate.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
