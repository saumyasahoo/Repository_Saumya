package com.prokarma.customer.consumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.prokarma.customer.consumer.model.CustomerInput;
import com.prokarma.customer.consumer.service.ConsumerService;
import com.prokarma.customer.consumer.util.CustomerMaskConverter;
import com.prokarma.customer.consumer.util.ObjectMapperUtil;

@Service
public class CustomerConsumerListener {

  private static final Logger logger = LoggerFactory.getLogger(CustomerConsumerListener.class);

  @Autowired
  private ConsumerService consumerService;

  @Autowired
  private CustomerMaskConverter customerMaskConverter;
  
  @KafkaListener(topics = {"${app.topic.customer}"}, groupId = "${app.group}")
  public void receive(String customerInputString) {
    CustomerInput customerInput =ObjectMapperUtil.convertStringToObject(customerInputString);
    String maskCustomerInput =
        ObjectMapperUtil.convertToString(customerMaskConverter.convert(customerInput));
    logger.info("received customer JSON data {}", maskCustomerInput);
    consumerService.saveCustomer(customerInput);
    logger.info("Customer Consumed from kafka and saved successfully ");
  }

}
