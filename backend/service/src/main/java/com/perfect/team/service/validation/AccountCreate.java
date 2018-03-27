package com.perfect.team.service.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = AccountCreateValidator.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface AccountCreate {

  String message() default "{com.perfect.team.service.validation.AccountCreate.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}