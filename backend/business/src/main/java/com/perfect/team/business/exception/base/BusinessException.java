package com.perfect.team.business.exception.base;

public class BusinessException extends RuntimeException {

  public BusinessException() {
    super();
  }

  public BusinessException(String message) {
    super(message);
  }
}
