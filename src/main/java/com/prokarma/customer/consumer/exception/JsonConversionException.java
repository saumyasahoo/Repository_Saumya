package com.prokarma.customer.consumer.exception;

public class JsonConversionException extends RuntimeException{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public JsonConversionException(String message, Throwable cause) {
    super(message, cause);
  }

  public JsonConversionException(String message) {
    super(message);
  }

}
