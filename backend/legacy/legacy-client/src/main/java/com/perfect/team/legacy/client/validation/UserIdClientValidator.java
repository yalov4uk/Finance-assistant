package com.perfect.team.legacy.client.validation;

import com.perfect.team.legacy.api.request.UserReadRequest;
import com.perfect.team.legacy.client.UserClient;
import com.perfect.team.legacy.client.validation.constraint.UserIdClient;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

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
    Response response = userClient.read(new UserReadRequest(value));
    if (HttpStatus.OK.value() != response.getStatus()) {
      valid = false;
      context.buildConstraintViolationWithTemplate("Wrong user id").addConstraintViolation();
    }
    return valid;
  }
}
