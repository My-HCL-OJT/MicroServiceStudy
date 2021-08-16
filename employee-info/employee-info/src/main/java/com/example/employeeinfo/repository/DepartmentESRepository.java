package com.example.employeeinfo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.employeeinfo.document.Department;

public interface DepartmentESRepository extends ElasticsearchRepository<Department, Integer> {

}
