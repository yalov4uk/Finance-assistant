package com.perfect.team.business.validation.constraint;

import com.perfect.team.business.validation.AccountCreateValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = AccountCreateValidator.class)
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface AccountCreate {

  String message() default "{AccountCreate.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
