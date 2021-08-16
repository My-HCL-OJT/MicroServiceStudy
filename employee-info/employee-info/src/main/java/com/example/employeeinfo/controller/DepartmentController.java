package com.example.employeeinfo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.example.employeeinfo.model.Department;
import com.example.employeeinfo.service.IDepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	private static final Logger logger = LogManager.getLogger(DepartmentController.class.getName());

	@Autowired
	IDepartmentService departmentService;

	@GetMapping
	public ResponseEntity<Object> getAllDepartments() {
		logger.info("Calling Get method of department");
		return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> createDepartment(@RequestBody Department department) {
		logger.info("Calling Post method of department");
		departmentService.addDepartment(department);
		return new ResponseEntity<>("Department is created successfully", HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> updateDepartment(@RequestBody Department department) {
		logger.info("Calling Put method of department");
		departmentService.updateDepartment(department);
		return new ResponseEntity<>("Department is updated successfully", HttpStatus.OK);
	}

	@DeleteMapping(path = "/{dept-id}")
	public ResponseEntity<Object> deleteDepartment(@PathVariable("dept-id") Integer id) {
		logger.info("Calling delete method of department");
		departmentService.deleteDepartment(id);
		return new ResponseEntity<>("Department is deleted successfully", HttpStatus.NO_CONTENT);
	}
}
