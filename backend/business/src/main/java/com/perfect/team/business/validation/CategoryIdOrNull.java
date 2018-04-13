package com.perfect.team.business.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CategoryIdOrNullValidator.class)
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CategoryIdOrNull {

  String message() default "{CategoryIdOrNull.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
