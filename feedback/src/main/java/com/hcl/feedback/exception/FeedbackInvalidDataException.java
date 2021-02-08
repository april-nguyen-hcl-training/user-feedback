package com.hcl.feedback.exception;

public class FeedbackInvalidDataException extends RuntimeException{
  public FeedbackInvalidDataException() {
  }

  public FeedbackInvalidDataException(String message) {
    super(message);
  }

  public FeedbackInvalidDataException(String message, Throwable cause) {
    super(message, cause);
  }

  public FeedbackInvalidDataException(Throwable cause) {
    super(cause);
  }
}
