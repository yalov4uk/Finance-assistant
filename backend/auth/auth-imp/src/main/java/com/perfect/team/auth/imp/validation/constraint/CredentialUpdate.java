package com.perfect.team.auth.imp.validation.constraint;

import com.perfect.team.auth.imp.validation.CredentialUpdateValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CredentialUpdateValidator.class)
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CredentialUpdate {

  String message() default "{CredentialUpdate.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
