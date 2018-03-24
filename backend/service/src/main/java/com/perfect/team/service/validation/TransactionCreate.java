package com.perfect.team.service.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = TransactionCreateValidator.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface TransactionCreate {
    String message() default "{com.perfect.team.service.validation.TransactionCreate.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
