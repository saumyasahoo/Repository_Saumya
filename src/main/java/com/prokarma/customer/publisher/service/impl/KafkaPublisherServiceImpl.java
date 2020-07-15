package com.prokarma.customer.publisher.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.prokarma.customer.publisher.exception.MessagePublishedFailedException;
import com.prokarma.customer.publisher.model.CustomerInput;
import com.prokarma.customer.publisher.model.CustomerResponse;
import com.prokarma.customer.publisher.service.KafkaPublisherService;
import com.prokarma.customer.publisher.util.Status;

@Service
public class KafkaPublisherServiceImpl implements KafkaPublisherService {

  private static final Logger logger = LoggerFactory.getLogger(KafkaPublisherServiceImpl.class);

  @Autowired
  private KafkaTemplate<String, CustomerInput> kafkaTemplate;

  @Value("${app.topic.customer}")
  private String topic;


  @Override
  public CustomerResponse publish(CustomerInput customerInfo) {
    CustomerResponse apiResponse = null;

    logger.info("sending data to topic={}", topic);

    try {
      kafkaTemplate.send(topic, customerInfo);
    } catch (Exception e) {
      throw new MessagePublishedFailedException("Error on sending message", e);
    }
    apiResponse = new CustomerResponse();
    apiResponse.setMessage(Status.MESSAGE_PUBLISHED.getValue());
    apiResponse.setStatus(Status.SUCCESS.getValue());
    return apiResponse;
  }


}
