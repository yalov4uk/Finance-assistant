package com.perfect.team.user.client.validation;

import com.perfect.team.user.api.dto.UserDto;
import com.perfect.team.user.api.dto.UsersResponse;
import com.perfect.team.user.client.UserClient;
import com.perfect.team.user.client.validation.constraint.UserIdClient;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public class UserIdClientValidator implements ConstraintValidator<UserIdClient, Long> {

  private final UserClient userClient;

  @Override
  public void initialize(UserIdClient constraintAnnotation) {
  }

  @Override
  public boolean isValid(Long value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }
    boolean valid = true;
    ResponseEntity<UsersResponse> response = userClient.read(new UserDto(value));
    if (HttpStatus.OK != response.getStatusCode()) {
      valid = false;
      context.buildConstraintViolationWithTemplate("Wrong user id").addConstraintViolation();
    }
    return valid;
  }
}
