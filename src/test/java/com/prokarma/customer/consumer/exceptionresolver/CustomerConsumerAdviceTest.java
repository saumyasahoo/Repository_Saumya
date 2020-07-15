package com.prokarma.customer.consumer.exceptionresolver;

import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.prokarma.customer.consumer.exception.CustomerSaveFailedException;

@SpringBootTest
public class CustomerConsumerAdviceTest {

  private CustomerConsumerAdvice customerConsumerAdvice;
  
  @Before
  public void setUp() {
    customerConsumerAdvice=new CustomerConsumerAdvice();
  }
  
  @Test
  public void testHandleException() {
    customerConsumerAdvice.handleException(new Exception("Customerinfo published failed"));
    assertNotNull(customerConsumerAdvice);

  }

  @Test
  public void testHandleException1() {
    customerConsumerAdvice.handleException(new CustomerSaveFailedException("Customerinfo published failed"));
    assertNotNull(customerConsumerAdvice);

  }

  
  @After
  public void tearDown() {
    customerConsumerAdvice = null;
  }
}
