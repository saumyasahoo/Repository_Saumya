package com.prokarma.customer.publisher.service;

import com.prokarma.customer.publisher.model.CustomerInput;
import com.prokarma.customer.publisher.model.CustomerResponse;

public interface KafkaPublisherService {
  
  public CustomerResponse publish(CustomerInput customerInfo) ;

}
