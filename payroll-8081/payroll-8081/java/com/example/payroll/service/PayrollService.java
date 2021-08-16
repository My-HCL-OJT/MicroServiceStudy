package com.example.payroll.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payroll.model.EmployeeSalary;
import com.example.payroll.repository.PayrollRepository;

@Service
public class PayrollService implements IPayrollService {

	@Autowired
	private PayrollRepository payrollRepository;
	
		@Override
	public List<EmployeeSalary> getEmployeePayroll() {
		List<EmployeeSalary> employeeSalaryList = (List<EmployeeSalary>) payrollRepository.findAll();
		return employeeSalaryList;
	}


	@Override
	public EmployeeSalary createEmployeePayroll(EmployeeSalary employeeSalary) {
		return payrollRepository.save(employeeSalary);
	}


	@Override
	public Optional<EmployeeSalary> getEmployeePayrollById(Integer id) {
			return payrollRepository.findById(id);	
	}
}
