package com.perfect.team.credential.imp.validation.constraint;

import com.perfect.team.credential.imp.validation.CredentialIdValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CredentialIdValidator.class)
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CredentialId {

  String message() default "{CredentialId.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
