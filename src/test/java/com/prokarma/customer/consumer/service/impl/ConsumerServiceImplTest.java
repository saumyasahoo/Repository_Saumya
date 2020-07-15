package com.prokarma.customer.consumer.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import com.prokarma.customer.consumer.converter.ModelToEnityMapper;
import com.prokarma.customer.consumer.entity.Address;
import com.prokarma.customer.consumer.entity.Customer;
import com.prokarma.customer.consumer.exception.CustomerSaveFailedException;
import com.prokarma.customer.consumer.model.CustomerInput.CustomerStatusEnum;
import com.prokarma.customer.consumer.repository.ConsumerServiceRepositry;
import com.prokarma.customer.consumer.util.TestData;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ConsumerServiceImplTest {

  @Mock
  private ConsumerServiceRepositry consumerServiceRepositry;

  @Mock
  private ModelToEnityMapper modelToEnityConverter;

  @InjectMocks
  private ConsumerServiceImpl consumerServiceImplTest;

  @Before
  public void setUp() {

  }

  @Test
  public void testSaveCustomer() {
    Customer customer = new Customer();
    Address address = new Address();
    address.setAddressLine1("marathalli");
    address.setAddressLine2("munekolala");
    address.setStreet("layout");
    address.setPostalCode("56003");
    customer.setAddress(address);
    customer.setCountry("india");
    customer.setCountryCode("91");
    customer.setCustomerNumber("C145452454");
    customer.setCustomerStatus(CustomerStatusEnum.OPEN);
    customer.setBirthdate("21-03-1992");
    customer.setEmail("saumya@gmail.com");
    customer.setFirstName("Saumyaranjan");
    customer.setLastName("SaumyaranjanSahoo");
    customer.setMobileNumber("8789723984");
    when(modelToEnityConverter.convertCustomerInputToCustomerEntity(any())).thenReturn(customer);
    when(consumerServiceRepositry.save(any())).thenReturn(customer);
    consumerServiceImplTest.saveCustomer(TestData.getCustomerInput());
    assertNotNull(consumerServiceRepositry);
  }

  @Test(expected = CustomerSaveFailedException.class)
  public void testSaveCustomerException() {
    doThrow(RuntimeException.class).when(modelToEnityConverter)
        .convertCustomerInputToCustomerEntity(any());
    consumerServiceImplTest.saveCustomer(TestData.getCustomerInput());
  }

  @After
  public void tearDown() {
    consumerServiceImplTest = null;
  }

}
