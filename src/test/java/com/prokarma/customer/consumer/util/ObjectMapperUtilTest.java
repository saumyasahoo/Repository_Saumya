package com.prokarma.customer.consumer.util;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ObjectMapperUtilTest {

  @InjectMocks
  ObjectMapperUtil objectMapperUtil;
  
  @Test
  public void testConvertToString() {
    String StringJson = ObjectMapperUtil.convertToString(TestData.getCustomerInput());
    assertNotNull(StringJson);
  }



}
