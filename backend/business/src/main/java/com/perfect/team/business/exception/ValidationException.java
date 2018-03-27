package com.perfect.team.business.exception;

import com.perfect.team.business.exception.base.BusinessException;

public class ValidationException extends BusinessException {

  public ValidationException() {
    super();
  }

  public ValidationException(String message) {
    super(message);
  }
}
