package com.prokarma.customer.consumer.repository;

import org.springframework.data.repository.CrudRepository;
import com.prokarma.customer.consumer.entity.Customer;

public interface ConsumerServiceRepositry extends CrudRepository<Customer, Integer>{

}
