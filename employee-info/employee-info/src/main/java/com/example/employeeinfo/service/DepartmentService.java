package com.example.employeeinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeinfo.model.Department;
import com.example.employeeinfo.repository.DepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public List<Department> getAllDepartments() {
		return (List<Department>) (departmentRepository.findAll());
	}

	@Override
	public Department addDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department updateDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public void deleteDepartment(Integer id) {
		departmentRepository.deleteById(id);
	}

}
