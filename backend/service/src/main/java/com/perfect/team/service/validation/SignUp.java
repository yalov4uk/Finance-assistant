package com.perfect.team.service.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = SignUpValidator.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface SignUp {

  String message() default "{com.perfect.team.service.validation.SignUp.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
