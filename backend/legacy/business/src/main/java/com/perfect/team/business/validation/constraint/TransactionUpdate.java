package com.perfect.team.business.validation.constraint;

import com.perfect.team.business.validation.TransactionUpdateValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = TransactionUpdateValidator.class)
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface TransactionUpdate {

  String message() default "{TransactionUpdate.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
