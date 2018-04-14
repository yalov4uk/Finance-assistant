package com.perfect.team.business.validation.constraint;

import com.perfect.team.business.validation.AccountUpdateValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = AccountUpdateValidator.class)
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface AccountUpdate {

  String message() default "{AccountUpdate.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
