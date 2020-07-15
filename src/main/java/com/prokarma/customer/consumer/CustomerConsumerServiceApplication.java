package com.prokarma.customer.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.prokarma.customer.consumer.repository")
public class CustomerConsumerServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerConsumerServiceApplication.class, args);
  }


}
