package com.example.payroll.service;

import java.util.List;
import java.util.Optional;

import com.example.payroll.model.EmployeeSalary;

public interface IPayrollService {
	
	public abstract EmployeeSalary createEmployeePayroll(EmployeeSalary employeeSalary);

	public abstract List<EmployeeSalary> getEmployeePayroll();
	
	public abstract Optional<EmployeeSalary> getEmployeePayrollById(Integer id);

}
