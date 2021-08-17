package com.example.employeeinfo.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.employeeinfo.model.Employee;
import com.example.employeeinfo.model.EmployeeSalary;
import com.example.employeeinfo.service.IEmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private static final Logger logger = LogManager.getLogger(EmployeeController.class.getName());

	@Autowired
	private RestTemplate restTemplate;
	 
	@Autowired
	IEmployeeService employeeService;

	@GetMapping
	public ResponseEntity<Object> getAllEmployees() {
		logger.info("Calling GET method of employees");
		List<Employee> employeesList = (List<Employee>) employeeService.getAllEmployees();
		return new ResponseEntity<>(employeesList, HttpStatus.OK);
	}

	@GetMapping(path = "/{emp-id}")
	public ResponseEntity<Object> getEmployeeById(@PathVariable("emp-id") Integer employeeId) {
		logger.info("Calling GET method of employees");
		Optional<Employee> employee = employeeService.getEmployeeById(employeeId);
		Employee result = employee.get();
		
		// Calling payroll micro-service
		String url = "http://localhost:8081/payroll/" + employeeId;
		logger.debug("URL" + url);
		ResponseEntity<EmployeeSalary> employeeSalary = restTemplate.getForEntity(url, EmployeeSalary.class);
		logger.info("Retrieved Employee salary = ", employeeSalary.getBody());
		result.setSalary(((EmployeeSalary)employeeSalary.getBody()).getSalary());
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
		logger.info("Calling POST method of employees");
		employeeService.addEmployee(employee);
		return new ResponseEntity<>("Employee is created successfully", HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
		logger.info("Calling PUT method of employees");
		employeeService.updateEmployee(employee);
		return new ResponseEntity<>("Employee is updated successfully.", HttpStatus.OK);
	}

	@DeleteMapping(path = "/{emp-id}")
	public ResponseEntity<Object> delete(@PathVariable("emp-id") Integer employeeId) {
		logger.info("Calling DELETE method of employees");
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<>("Employee is deleted successfully.", HttpStatus.NO_CONTENT);
	}

}
