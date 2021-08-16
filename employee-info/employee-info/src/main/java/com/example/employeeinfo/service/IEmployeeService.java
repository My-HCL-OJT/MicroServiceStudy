package com.example.employeeinfo.service;

import java.util.List;
import java.util.Optional;

import com.example.employeeinfo.model.Employee;

public interface IEmployeeService {

	public abstract List<Employee> getAllEmployees();

	public abstract Employee addEmployee(Employee employee);

	public abstract Optional<Employee> getEmployeeById(Integer id);

	public abstract Employee updateEmployee(Employee employee);

	public abstract void deleteEmployee(Integer id);
}
