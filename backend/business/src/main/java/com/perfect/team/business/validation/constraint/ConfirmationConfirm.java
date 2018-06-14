package com.perfect.team.business.validation.constraint;

import com.perfect.team.business.validation.ConfirmationValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ConfirmationValidator.class)
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfirmationConfirm {

  String message() default "{ConfirmationConfirm.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
