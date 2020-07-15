package com.prokarma.customer.consumer.util;

import com.prokarma.customer.consumer.model.CustomerInput;
import com.prokarma.customer.consumer.model.CustomerInput.CustomerStatusEnum;
import com.prokarma.customer.consumer.model.Address;

public class TestData {

  public static CustomerInput getCustomerInput() {
    CustomerInput customer = new CustomerInput();
    Address address = new Address();
    address.setAddressLine1("marathalli");
    address.setAddressLine2("munekolala");
    address.setStreet("shruti layout");
    address.setPostalCode("56003");
    customer.setAddress(address);
    customer.setCountry("india");
    customer.setCountryCode("91");
    customer.setCustomerNumber("C345452454");
    customer.setCustomerStatus(CustomerStatusEnum.OPEN);
    customer.setBirthdate("21-03-1992");
    customer.setEmail("saumya@gmail.com");
    customer.setFirstName("Saumyaranjan");
    customer.setLastName("SaumyaranjanSahoo");
    customer.setMobileNumber("8789723984");
    return customer;
  }

}
