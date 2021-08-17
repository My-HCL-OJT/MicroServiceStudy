package com.example.payroll;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class EmployeePayrollApplication {

	private static final Logger logger = LogManager.getLogger(EmployeePayrollApplication.class.getName());
	
	public static void main(String[] args) {
		logger.info("Starting EmployeePayrollApplication ------------");
		SpringApplication.run(EmployeePayrollApplication.class, args);
	}

	@GetMapping("/greeting")
	public String sayHello() {
		logger.info("Payroll service instance at port:8081 is called.");
		return "Hello there !!! Service instance at port 8081 !!!";
	}
}
