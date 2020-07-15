package com.prokarma.customer.consumer.service.impl;

import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prokarma.customer.consumer.converter.ModelToEnityMapper;
import com.prokarma.customer.consumer.entity.Customer;
import com.prokarma.customer.consumer.exception.CustomerSaveFailedException;
import com.prokarma.customer.consumer.model.CustomerInput;
import com.prokarma.customer.consumer.repository.ConsumerServiceRepositry;
import com.prokarma.customer.consumer.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService {

  private static final Logger logger = LoggerFactory.getLogger(ConsumerServiceImpl.class);

  @Autowired
  private ConsumerServiceRepositry consumerServiceRepositry;

  @Autowired
  private ModelToEnityMapper modelToEnityConverter;

  @Override
  @Transactional
  public void saveCustomer(CustomerInput customerInput) {
    Customer persistCustomer = null;
    try {
      Customer customer = modelToEnityConverter.convertCustomerInputToCustomerEntity(customerInput);
      persistCustomer = consumerServiceRepositry.save(customer);
      
    } catch (Exception e) {
      throw new CustomerSaveFailedException("customer save failed into database", e);
    }
    logger.info("Customer is persisted into database successfully.And returned CustomerId is {}",
        persistCustomer.getCustomerId()+"");
  }

}
