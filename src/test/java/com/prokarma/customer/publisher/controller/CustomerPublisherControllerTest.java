package com.prokarma.customer.publisher.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import com.prokarma.customer.publisher.model.CustomerResponse;
import com.prokarma.customer.publisher.service.KafkaPublisherService;
import com.prokarma.customer.publisher.util.CustomerMaskConverter;
import com.prokarma.customer.publisher.util.Status;
import com.prokarma.customer.publisher.util.TestData;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CustomerPublisherControllerTest {

  @Mock
  private KafkaPublisherService publisherService;

  @Mock
  private CustomerMaskConverter customerMaskConverter;

  @InjectMocks
  private CustomerPublisherController publisherController;


  @Before
  public void setUp() {}

  @Test
  public void testPublishCustomerInfo() {
    CustomerResponse customerResponse = new CustomerResponse();
    customerResponse.setMessage(Status.MESSAGE_PUBLISHED.getValue());
    customerResponse.setStatus(Status.SUCCESS.getValue());
    when(customerMaskConverter.convert(any())).thenReturn(TestData.getCustomerInput());
    when(publisherService.publish(any())).thenReturn(customerResponse);
    ResponseEntity<CustomerResponse> entity = publisherController
        .publishCustomerInfo("21321-2344-343", "publish", "31232", TestData.getCustomerInput());
    assertNotNull(entity);
    CustomerResponse response=entity.getBody();
    assertEquals("success", response.getStatus());
    assertEquals("Customerinfo published successfully", response.getMessage());
  }

  @After
  public void tearDown() {
    publisherController = null;
  }
}
