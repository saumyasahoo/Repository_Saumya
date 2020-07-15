package com.prokarma.customer.consumer.exception;

public class CustomerSaveFailedException extends RuntimeException {

  /**
   * 
   */
  
  private static final long serialVersionUID = 1L;

  public CustomerSaveFailedException(String message, Throwable cause) {
    super(message, cause);
  }

  public CustomerSaveFailedException(String message) {
    super(message);
  }


}
