package com.prokarma.customer.publisher.model.test;

import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.prokarma.customer.publisher.model.Address;
import com.prokarma.customer.publisher.model.CustomerInput;
import com.prokarma.customer.publisher.model.CustomerResponse;

@SpringBootTest
public class CustomerInputTest {
  
private CustomerInput customerInput;
private Address address;
private CustomerResponse customerResponse;
  
  @Before
  public void setUp() {
    customerInput=new CustomerInput();
    address=new Address();
    customerResponse=new CustomerResponse();
  }

  
  @Test
  public void testToString() {
    customerInput.toString();
    address.toString();
    customerResponse.toString();
    assertNotNull(customerInput);
    assertNotNull(address);
    assertNotNull(customerResponse);
  }
  
  @After
  public void tearDown() {
    customerInput = null;
  }
}

