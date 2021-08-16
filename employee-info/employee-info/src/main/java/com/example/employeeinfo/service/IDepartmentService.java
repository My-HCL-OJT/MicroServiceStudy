package com.example.employeeinfo.service;

import java.util.List;

import com.example.employeeinfo.model.Department;

public interface IDepartmentService {

	public abstract List<Department> getAllDepartments();

	public abstract Department addDepartment(Department department);

	public abstract Department updateDepartment(Department department);

	public abstract void deleteDepartment(Integer id);
}
