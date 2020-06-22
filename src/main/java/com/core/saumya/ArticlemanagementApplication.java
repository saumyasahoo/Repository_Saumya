package com.core.saumya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.core.simpragma.repositry" })
public class ArticlemanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArticlemanagementApplication.class, args);
	}

}
