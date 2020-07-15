package com.prokarma.customer.publisher.exception;

public class MessagePublishedFailedException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public MessagePublishedFailedException(String message, Throwable cause) {
    super(message, cause);
  }

  public MessagePublishedFailedException(String message) {
    super(message);
  }


}
