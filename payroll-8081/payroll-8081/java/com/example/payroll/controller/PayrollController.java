package com.example.payroll.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.payroll.model.EmployeeSalary;
import com.example.payroll.service.IPayrollService;

@RestController
public class PayrollController {

	private static final Logger logger = LogManager.getLogger(PayrollController.class.getName()); 
	
	@Autowired
	IPayrollService payrollService;

	@GetMapping(path = "/payroll")
	public ResponseEntity<Object> getEmployeePayroll() {
		logger.info("Calling Get method of payroll");
		return new ResponseEntity<>(payrollService.getEmployeePayroll(), HttpStatus.OK);
	}

	@GetMapping(path = "/payroll/{id}")
	public ResponseEntity<Object> getEmployeePayrollById(@PathVariable("id") Integer id) {
		logger.info("Calling Get method of payroll");
		return new ResponseEntity<>(payrollService.getEmployeePayrollById(id), HttpStatus.OK);
	}
	
	@PostMapping(path = "/payroll")
	public ResponseEntity<Object> createEmployeePayroll(@RequestBody EmployeeSalary empSalary) {
		logger.info("Calling Post method of payroll");
		payrollService.createEmployeePayroll(empSalary);
		return new ResponseEntity<>("Employee Payroll is created successfully", HttpStatus.CREATED);
	}	
}
