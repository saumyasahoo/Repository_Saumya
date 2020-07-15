package com.prokarma.customer.consumer.converter;

import org.springframework.stereotype.Component;
import com.prokarma.customer.consumer.entity.Address;
import com.prokarma.customer.consumer.entity.Customer;
import com.prokarma.customer.consumer.model.CustomerInput;

@Component
public class ModelToEnityMapper {

  public Customer convertCustomerInputToCustomerEntity(CustomerInput customerInput) {
    Customer customer = new Customer();
    Address address = new Address();
    address.setAddressLine1(customerInput.getAddress().getAddressLine1());
    address.setAddressLine2(customerInput.getAddress().getAddressLine2());
    address.setStreet(customerInput.getAddress().getStreet());
    address.setPostalCode((customerInput.getAddress().getPostalCode()));
    customer.setAddress(address);
    customer.setCountry(customerInput.getCountry());
    customer.setCountryCode(customerInput.getCountryCode());
    customer.setCustomerNumber(customerInput.getCustomerNumber());
    customer.setCustomerStatus(customerInput.getCustomerStatus());
    customer.setBirthdate(customerInput.getBirthdate());
    customer.setEmail(customerInput.getEmail());
    customer.setFirstName(customerInput.getFirstName());
    customer.setLastName(customerInput.getLastName());
    customer.setMobileNumber(customerInput.getMobileNumber());
    return customer;

  }
}
