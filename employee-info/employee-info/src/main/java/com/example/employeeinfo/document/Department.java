package com.example.employeeinfo.document;

import java.util.List;

import javax.persistence.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="department")
public class Department {

	@Id
	private Integer id;

	private String deptName;

	//private List<Employee> employees;

}
