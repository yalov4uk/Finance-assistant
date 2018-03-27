package com.perfect.team.business.exception;

import com.perfect.team.business.exception.base.BusinessException;

public class NotFoundException extends BusinessException {

  public NotFoundException() {
    super();
  }

  public NotFoundException(String message) {
    super(message);
  }
}
