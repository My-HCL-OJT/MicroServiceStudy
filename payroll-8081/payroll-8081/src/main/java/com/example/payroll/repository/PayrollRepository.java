package com.example.payroll.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.payroll.model.EmployeeSalary;

@Repository
public interface PayrollRepository extends CrudRepository<EmployeeSalary, Integer>{

}
