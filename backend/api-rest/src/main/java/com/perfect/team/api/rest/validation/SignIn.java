package com.perfect.team.api.rest.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = SignInValidator.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface SignIn {

    String message() default "{com.perfect.team.api.rest.validation.SignIn.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
