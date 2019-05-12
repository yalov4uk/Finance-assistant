package com.perfect.team.auth.imp.middleware;

import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class WebExceptionHandler {

//  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<String> dtoValidation(ConstraintViolationException exception) {
    String message = exception.getConstraintViolations()
        .stream()
        .map(ConstraintViolation::getMessage)
        .collect(Collectors.joining("\n"));
    return ResponseEntity.badRequest()
        .body(message);
  }
}
