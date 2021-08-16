package com.example.employeeinfo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.employeeinfo.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer>{
}
