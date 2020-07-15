package com.prokarma.customer.consumer.config;

import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import com.prokarma.customer.consumer.model.CustomerInput;

@SpringBootTest
public class KafkaConfigTest {

  private KafkaConfig kafkaConfig;

  @Before
  public void setUp() {
    kafkaConfig = new KafkaConfig();
  }

  @Test
  public void testProducerFactory() {
    ConsumerFactory<String, CustomerInput> factory=kafkaConfig.consumerFactory();
    ConcurrentKafkaListenerContainerFactory<String, CustomerInput> listener= kafkaConfig.kafkaListenerFactory();
    assertNotNull(factory);
    assertNotNull(listener);

  }

  @After
  public void tearDown() {
    kafkaConfig = null;
  }

}
