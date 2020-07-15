package com.prokarma.customer.consumer.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import com.prokarma.customer.consumer.model.CustomerInput;

@Configuration
@EnableKafka
public class KafkaConfig {

  @Value("${spring.kafka.bootstrap-servers}")
  private String bootstrapServers;
  
  @Value("${app.group}")
  private String groupId;
  
  @Bean
  public ConsumerFactory<String, CustomerInput> consumerFactory() {
      Map<String, Object> config = new HashMap<>();

      config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
      config.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
      config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
      config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
      return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
              new JsonDeserializer<>(CustomerInput.class));
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, CustomerInput> kafkaListenerFactory() {
      ConcurrentKafkaListenerContainerFactory<String, CustomerInput> factory = new ConcurrentKafkaListenerContainerFactory<>();
      factory.setConsumerFactory(consumerFactory());
      return factory;
  }
}
