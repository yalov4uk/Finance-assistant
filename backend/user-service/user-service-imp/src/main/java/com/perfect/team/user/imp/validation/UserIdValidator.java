package com.perfect.team.user.imp.validation;


import com.perfect.team.common.security.UserContext;
import com.perfect.team.user.imp.repository.UserMapper;
import com.perfect.team.user.imp.validation.constraint.UserId;
import java.util.Objects;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserIdValidator implements ConstraintValidator<UserId, Long> {

  private final UserMapper userMapper;

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
