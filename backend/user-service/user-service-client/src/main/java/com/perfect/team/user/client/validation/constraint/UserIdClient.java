package com.perfect.team.user.client.validation.constraint;

import com.perfect.team.user.client.validation.UserIdClientValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = UserIdClientValidator.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserIdClient {

  String message() default "{UserIdClient.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
