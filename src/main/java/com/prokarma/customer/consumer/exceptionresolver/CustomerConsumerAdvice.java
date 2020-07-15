package com.prokarma.customer.consumer.exceptionresolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.prokarma.customer.consumer.exception.CustomerSaveFailedException;
import com.prokarma.customer.consumer.exception.JsonConversionException;

@ControllerAdvice
public class CustomerConsumerAdvice {

  private static final Logger logger = LoggerFactory.getLogger(CustomerConsumerAdvice.class);

  @ExceptionHandler(Exception.class)
  protected void handleException(Exception ex) {
    logger.error("Application Error Occured", ex);
  }

  
  @ExceptionHandler(CustomerSaveFailedException.class)
  protected void handleException(CustomerSaveFailedException ex) {
    logger.error("customer pesisting to database has failed", ex);
    logger.error( ex.getMessage());
  }
  
  @ExceptionHandler(JsonConversionException.class)
  protected void handleException(JsonConversionException ex) {
    logger.error("Json conversion failed", ex);
    logger.error( ex.getMessage());
  }
  
}
