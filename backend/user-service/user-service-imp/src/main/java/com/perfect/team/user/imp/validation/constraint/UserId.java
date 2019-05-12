package com.perfect.team.user.imp.validation.constraint;

import com.perfect.team.user.imp.validation.UserIdValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = UserIdValidator.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserId {

  String message() default "{UserId.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
