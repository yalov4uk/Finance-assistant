package com.perfect.team.business.validation;

import com.perfect.team.business.mapper.UserMapper;
import com.perfect.team.business.validation.constraint.UserId;
import com.perfect.team.common.security.UserContext;
import java.util.Objects;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserIdValidator implements ConstraintValidator<UserId, Long> {

  @Inject
  private UserMapper userMapper;

  @Override
  public void initialize(UserId constraintAnnotation) {
  }

  @Override
  public boolean isValid(Long value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }
    boolean valid = true;
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null) {
      UserContext userContext = (UserContext) authentication.getPrincipal();
      if (!Objects.equals(value, userContext.getUserId())) {
        valid = false;
        context.buildConstraintViolationWithTemplate("Wrong user id").addConstraintViolation();
      }
    }
    if (userMapper.selectById(value) == null) {
      valid = false;
      context.buildConstraintViolationWithTemplate("User not found").addConstraintViolation();
    }
    return valid;
  }
}
