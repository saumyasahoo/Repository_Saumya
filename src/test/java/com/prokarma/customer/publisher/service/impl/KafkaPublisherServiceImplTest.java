package com.prokarma.customer.publisher.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import com.prokarma.customer.publisher.exception.MessagePublishedFailedException;
import com.prokarma.customer.publisher.model.CustomerResponse;
import com.prokarma.customer.publisher.util.TestData;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class KafkaPublisherServiceImplTest {

  @Mock
  private KafkaTemplate<String, Object> kafkaTemplate;

  @InjectMocks
  private KafkaPublisherServiceImpl publisherServiceImpl;


  @Before
  public void setUp() {}

  @Test
  public void testPublish() {
    CustomerResponse customerResponse = new CustomerResponse();
    customerResponse.setMessage("success");
    CustomerResponse customerResponses = publisherServiceImpl.publish(TestData.getCustomerInput());
    assertNotNull(customerResponses);
    assertEquals("success", customerResponses.getStatus());
    assertEquals("Customerinfo published successfully", customerResponses.getMessage());

  }

  @Test(expected = MessagePublishedFailedException.class)
  public void testPublishException() {
    doThrow(RuntimeException.class).when(kafkaTemplate).send(any(), any());
    publisherServiceImpl.publish(TestData.getCustomerInput());
  }

  @After
  public void tearDown() {
    publisherServiceImpl = null;
  }

}
