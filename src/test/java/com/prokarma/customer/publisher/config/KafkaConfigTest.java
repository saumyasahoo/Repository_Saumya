package com.prokarma.customer.publisher.config;

import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import com.prokarma.customer.publisher.model.CustomerInput;

@SpringBootTest
public class KafkaConfigTest {

  private KafkaConfig kafkaConfig;

  @Before
  public void setUp() {
    kafkaConfig = new KafkaConfig();
  }

  @Test
  public void testProducerFactory() {
    ProducerFactory<String, CustomerInput> factory=kafkaConfig.producerFactory();
    KafkaTemplate<String, CustomerInput> template= kafkaConfig.kafkaTemplate();
    assertNotNull(factory);
    assertNotNull(template);

  }

  @After
  public void tearDown() {
    kafkaConfig = null;
  }

}
