package com.prokarma.customer.publisher.exceptionresolver;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import com.prokarma.customer.publisher.exception.MessagePublishedFailedException;
import com.prokarma.customer.publisher.model.ErrorResponse;

@SpringBootTest
public class CustomerPublisherAdviceTest {

  private CustomerPublisherAdvice customerPublisherAdvice;

  @Before
  public void setUp() {
    customerPublisherAdvice = new CustomerPublisherAdvice();
  }

  @Test
  public void testHandleException() {
    ResponseEntity<Object> entity =
        customerPublisherAdvice.handleException(new Exception("Customerinfo published failed"));
    Object object = entity.getBody();
    assertNotNull(entity);
    assertEquals("error", ((ErrorResponse) object).getStatus());
    assertEquals("Customerinfo published failed", ((ErrorResponse) object).getMessage());
    assertEquals("MessagePublishedFailedException", ((ErrorResponse) object).getErrorType());

  }

  @Test
  public void testHandleException1() {
    ResponseEntity<Object> entity = customerPublisherAdvice
        .handleException(new MessagePublishedFailedException("Customerinfo published failed"));
    Object object = entity.getBody();
    assertNotNull(entity);
    assertEquals("error", ((ErrorResponse) object).getStatus());
    assertEquals("Customerinfo published failed", ((ErrorResponse) object).getMessage());
    assertEquals("MessagePublishedFailedException", ((ErrorResponse) object).getErrorType());

  }


  @After
  public void tearDown() {
    customerPublisherAdvice = null;
  }
}
