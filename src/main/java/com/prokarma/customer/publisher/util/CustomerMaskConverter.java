package com.prokarma.customer.publisher.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.prokarma.customer.publisher.model.CustomerInput;

@Component
public class CustomerMaskConverter implements Converter<CustomerInput, CustomerInput> {

  @Override
  public CustomerInput convert(CustomerInput customerInput) {
    CustomerInput customer = new CustomerInput();
    customer.setAddress(customerInput.getAddress());
    customer.setCountry(customerInput.getCountry());
    customer.setCountryCode(customerInput.getCountryCode());
    customer.setCustomerNumber(MaskString.mask(customerInput.getCustomerNumber(), 6, 10));
    customer.setCustomerStatus(customerInput.getCustomerStatus());
    customer.setBirthdate((MaskString.mask(customerInput.getBirthdate(), 0, 5)));
    customer.setEmail(MaskString.mask(customerInput.getEmail(), 0, 4));
    customer.setFirstName(customerInput.getFirstName());
    customer.setLastName(customerInput.getLastName());
    customer.setMobileNumber(customerInput.getMobileNumber());
    return customer;
  }

}
