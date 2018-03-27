package com.perfect.team.business.exception;

import com.perfect.team.business.exception.base.BusinessException;

public class ProcessingException extends BusinessException {

  public ProcessingException() {
    super();
  }

  public ProcessingException(String message) {
    super(message);
  }
}
