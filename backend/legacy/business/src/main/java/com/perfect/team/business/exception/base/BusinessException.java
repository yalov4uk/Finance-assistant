package com.perfect.team.business.exception.base;

//todo: fix exception hierarchy, constructors
public class BusinessException extends RuntimeException {

  public BusinessException() {
    super();
  }

  public BusinessException(String message) {
    super(message);
  }
}
