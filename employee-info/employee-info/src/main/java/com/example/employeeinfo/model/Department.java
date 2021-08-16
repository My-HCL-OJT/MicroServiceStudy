package com.example.employeeinfo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.springframework.data.elasticsearch.annotations.Document;

@Entity
@Table(name = "DEPARTMENT")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "dept_name")
	private String deptName;

//	@OneToMany(mappedBy="department", cascade=CascadeType.ALL, orphanRemoval=true)	
//	private List<Employee> employees;
	
	public Department() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/*
	 * public List<Employee> getEmployees() { return employees; }
	 * 
	 * public void setEmployees(List<Employee> employees) { this.employees =
	 * employees; }
	 */
	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + "]";
	}

}
