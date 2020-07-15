package com.prokarma.customer.consumer.model.test;

import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.prokarma.customer.consumer.model.Address;
import com.prokarma.customer.consumer.model.CustomerInput;

@SpringBootTest
public class CustomerInputTest {
  
private CustomerInput customerInput;
private Address address;
  
  @Before
  public void setUp() {
    customerInput=new CustomerInput();
    address=new Address();
  }

  
  @Test
  public void testToString() {
    customerInput.toString();
    address.toString();
    assertNotNull(customerInput);
    assertNotNull(address);
  }
  
  @After
  public void tearDown() {
    customerInput = null;
  }
}

