package com.perfect.team.business.exception;

import com.perfect.team.business.exception.base.BusinessException;

public class ForbiddenException extends BusinessException {

  public ForbiddenException() {
    super();
  }

  public ForbiddenException(String message) {
    super(message);
  }
}
