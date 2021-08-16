package com.example.employeeinfo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeinfo.model.Department;
import com.example.employeeinfo.model.Employee;
import com.example.employeeinfo.repository.DepartmentRepository;
import com.example.employeeinfo.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	private static final Logger logger = LogManager.getLogger(EmployeeService.class.getName());
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(emp -> employeeList.add(emp));
		return employeeList;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		logger.info("Inside addEmployee => " + employee + ", Department => " + employee.getDepartment());
		Department dept = departmentRepository.findById(employee.getDepartment().getId()).orElse(null);
		if (null == dept) {
			dept = new Department();
		}
		dept.setDeptName(employee.getDepartment().getDeptName());
		employee.setDepartment(dept);
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> getEmployeeById(Integer id) {
		return employeeRepository.findById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}
}
