package com.prokarma.customer.consumer.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.prokarma.customer.consumer.model.CustomerInput;

@SpringBootTest
public class CustomerMaskConverterTest {

  private CustomerMaskConverter customerMaskConverter;

  @Before
  public void setUp() {
    customerMaskConverter = new CustomerMaskConverter();
  }

  @Test
  public void testConvert() {
    CustomerInput customerInput = customerMaskConverter.convert(TestData.getCustomerInput());
    assertNotNull(customerInput);
    assertEquals("*****-1992", customerInput.getBirthdate());
    assertEquals("india", customerInput.getCountry());
    assertEquals("marathalli", customerInput.getAddress().getAddressLine1());
    assertEquals("munekolala", customerInput.getAddress().getAddressLine2());
    assertEquals("56003", customerInput.getAddress().getPostalCode());
    assertEquals("shruti layout", customerInput.getAddress().getStreet());
    assertEquals("91", customerInput.getCountryCode());
    assertEquals("C34545****", customerInput.getCustomerNumber());
    assertEquals("****ya@gmail.com", customerInput.getEmail());
    assertEquals("Saumyaranjan", customerInput.getFirstName());
    assertEquals("SaumyaranjanSahoo", customerInput.getLastName());
    assertEquals("8789723984", customerInput.getMobileNumber());

  }

  @After
  public void tearDown() {
    customerMaskConverter = null;
  }

}
