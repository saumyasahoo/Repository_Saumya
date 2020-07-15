package com.prokarma.customer.consumer.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prokarma.customer.consumer.exception.JsonConversionException;
import com.prokarma.customer.consumer.model.CustomerInput;

public class ObjectMapperUtil {

  private ObjectMapperUtil() {
    // not to be instantiate this class using constructor
  }

  public static String convertToString(Object obj) {
    ObjectMapper objectMapper = new ObjectMapper();
    String objString = null;
    try {
      objString = objectMapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw new JsonConversionException("JsonProcessingException while convertions of object to string", e);
    }
    return objString;
  }

  public static CustomerInput convertStringToObject(String input) {
    ObjectMapper mapper = new ObjectMapper();
    CustomerInput customerInput = null;
    try {
      customerInput = mapper.readValue(input, CustomerInput.class);
    } catch (JsonProcessingException e) {
      throw new JsonConversionException("JsonProcessingException while convertions of string to object", e);
    }
    return customerInput;
  }


}
