package com.prokarma.customer.consumer.listener;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import com.prokarma.customer.consumer.model.CustomerInput;
import com.prokarma.customer.consumer.service.ConsumerService;
import com.prokarma.customer.consumer.util.CustomerMaskConverter;
import com.prokarma.customer.consumer.util.TestData;

@RunWith(MockitoJUnitRunner.class)
public class CustomerConsumerListenerTest {

  @Mock
  private ConsumerService consumerService;

  @Mock
  private CustomerMaskConverter customerMaskConverter;

  @InjectMocks
  private CustomerConsumerListener customerConsumerListener;

  @Before
  public void setUp() {}

  @Test
  public void testReceive() {
    String input =
        "{\"birthdate\":\"21-03-1992\",\"country\":\"india\",\"countryCode\":\"91\",\"customerNumber\":\"C145452454\",\"customerStatus\":\"OPEN\",\"email\":\"saumya@gmail.com\",\"firstName\":\"Saumyaranjan\",\"lastName\":\"SaumyaranjanSahoo\",\"mobileNumber\":\"8789723984\"}";
    OngoingStubbing<CustomerInput> customerInput=when(customerMaskConverter.convert(any())).thenReturn(TestData.getCustomerInput());
    doNothing().when(consumerService).saveCustomer(any());
    customerConsumerListener.receive(input);
    assertNotNull(customerInput);
  }

  @After
  public void tearDown() {
    customerConsumerListener = null;
  }

}
