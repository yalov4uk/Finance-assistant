package com.perfect.team.rest.api.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = SignInValidator.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface SignIn {

  String message() default "{SignIn.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
