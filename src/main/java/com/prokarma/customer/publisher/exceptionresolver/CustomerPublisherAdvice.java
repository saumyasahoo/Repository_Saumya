package com.prokarma.customer.publisher.exceptionresolver;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.prokarma.customer.publisher.exception.MessagePublishedFailedException;
import com.prokarma.customer.publisher.model.ErrorResponse;
import com.prokarma.customer.publisher.util.Status;

@ControllerAdvice
public class CustomerPublisherAdvice {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleException(Exception ex) {
    ErrorResponse apiResponse = new ErrorResponse();
    apiResponse.setStatus(Status.FAILURE.getValue());
    apiResponse.setMessage(ex.getMessage());
    apiResponse.setErrorType(MessagePublishedFailedException.class.getSimpleName());
    return new ResponseEntity<>(apiResponse, HttpStatus.EXPECTATION_FAILED);
  }
  
  @ExceptionHandler(MessagePublishedFailedException.class)
  public ResponseEntity<Object> handleException(MessagePublishedFailedException ex) {
    ErrorResponse apiResponse = new ErrorResponse();
    apiResponse.setStatus(Status.FAILURE.getValue());
    apiResponse.setMessage(ex.getMessage());
    apiResponse.setErrorType(MessagePublishedFailedException.class.getSimpleName());
    return new ResponseEntity<>(apiResponse, HttpStatus.EXPECTATION_FAILED);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public Map<String, String> handleVaildException(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();

    ex.getBindingResult().getFieldErrors()
        .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

    return errors;
  }
}
