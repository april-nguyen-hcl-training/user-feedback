package com.hcl.feedback.controller;

import com.hcl.feedback.exception.FeedbackInvalidDataException;
import com.hcl.feedback.exception.FeedbackNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class FeedbackExceptionController extends ResponseEntityExceptionHandler {
  @ExceptionHandler({ FeedbackNotFoundException.class })
  protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request) {
    return handleExceptionInternal(ex, "Feedback not found",
      new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }

  @ExceptionHandler({ FeedbackInvalidDataException.class })
  public ResponseEntity<Object> handleInvalidData(Exception ex, WebRequest request) {
    return handleExceptionInternal(ex, ex.getMessage(),
      new HttpHeaders(), HttpStatus.valueOf(422), request);
  }
}
