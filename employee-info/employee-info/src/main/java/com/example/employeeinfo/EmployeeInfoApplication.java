package com.example.employeeinfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class EmployeeInfoApplication {

	private static final Logger log = LoggerFactory.getLogger(EmployeeInfoApplication.class);
	
	public static void main(String[] args) {
		log.info("Starting EmployeeInfoApplication ------------");
		SpringApplication.run(EmployeeInfoApplication.class, args);
	}

	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
	}
	
}
