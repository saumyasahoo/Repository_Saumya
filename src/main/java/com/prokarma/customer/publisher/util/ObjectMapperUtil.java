package com.prokarma.customer.publisher.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtil {

  private ObjectMapperUtil() {
    //not to be instantiate this class using constructor
  }

  private static final Logger logger = LoggerFactory.getLogger(ObjectMapperUtil.class);
  
  public static String convertToString(Object obj) {
    ObjectMapper objectMapper = new ObjectMapper();
    String objString = null;
    try {
      objString = objectMapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      logger.error("JsonProcessingException while converting Entity into string", e);
    }
    return objString;
  }
  
  
}
