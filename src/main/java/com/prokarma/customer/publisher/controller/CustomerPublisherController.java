package com.prokarma.customer.publisher.controller;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prokarma.customer.publisher.model.CustomerInput;
import com.prokarma.customer.publisher.model.CustomerResponse;
import com.prokarma.customer.publisher.service.KafkaPublisherService;
import com.prokarma.customer.publisher.util.CustomerMaskConverter;
import com.prokarma.customer.publisher.util.ObjectMapperUtil;

@RestController
@RequestMapping(value = "/customer/create")
public class CustomerPublisherController {

  private static final Logger logger = LoggerFactory.getLogger(CustomerPublisherController.class);

  @Autowired
  private KafkaPublisherService publisherService;

  @Autowired
  private CustomerMaskConverter customerMaskConverter;

  @PostMapping(path = "/publish-customer", consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<CustomerResponse> publishCustomerInfo(
      @RequestHeader(value = "Authorization", required = true) String authorization,
      @RequestHeader(value = "Activity-Id", required = true) String activityId,
      @RequestHeader(value = "Application-Id", required = true) String applicationId,
      @RequestBody @Valid CustomerInput customerInput) {
    String customerInputString =
        ObjectMapperUtil.convertToString(customerMaskConverter.convert(customerInput));
    logger.info("Incoming Request {} ", customerInputString);
    CustomerResponse customerResponse = publisherService.publish(customerInput);
    String customerOutputString = ObjectMapperUtil.convertToString(customerResponse);
    logger.info("Outgoing Response {} ", customerOutputString);
    return new ResponseEntity<>(customerResponse, HttpStatus.OK);
  }


}
