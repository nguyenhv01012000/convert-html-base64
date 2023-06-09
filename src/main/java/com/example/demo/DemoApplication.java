package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

//		SpringApplicationBuilder builder = new SpringApplicationBuilder(DemoApplication.class);
//
//		builder.headless(false);
//
//		ConfigurableApplicationContext context = builder.run(args);
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	public RestTemplate getRestTemplate() {
//		return new RestTemplate();
//	}

}
