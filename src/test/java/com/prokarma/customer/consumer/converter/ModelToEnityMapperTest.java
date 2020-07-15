package com.prokarma.customer.consumer.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.prokarma.customer.consumer.entity.Customer;
import com.prokarma.customer.consumer.util.TestData;

@SpringBootTest
public class ModelToEnityMapperTest {

  private ModelToEnityMapper mapper;

  @Before
  public void setUp() {
    mapper = new ModelToEnityMapper();
  }

  @Test
  public void testConvertCustomerInputToCustomerEntity() {
    Customer customer = mapper.convertCustomerInputToCustomerEntity(TestData.getCustomerInput());
    assertEquals("21-03-1992", customer.getBirthdate());
    assertEquals("india", customer.getCountry());
    assertEquals("marathalli", customer.getAddress().getAddressLine1());
    assertEquals("munekolala", customer.getAddress().getAddressLine2());
    assertEquals("56003", customer.getAddress().getPostalCode());
    assertEquals("shruti layout", customer.getAddress().getStreet());
    assertEquals("91", customer.getCountryCode());
    assertEquals("C345452454", customer.getCustomerNumber());
    assertEquals("saumya@gmail.com", customer.getEmail());
    assertEquals("Saumyaranjan", customer.getFirstName());
    assertEquals("SaumyaranjanSahoo", customer.getLastName());
    assertEquals("8789723984", customer.getMobileNumber());
  }

  @After
  public void tearDown() {
    mapper = null;
  }
}
