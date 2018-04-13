package com.perfect.team.api.validation.constraint;

import com.perfect.team.api.validation.CategoryReadValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CategoryReadValidator.class)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CategoryRead {

  String message() default "{CategoryRead.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
