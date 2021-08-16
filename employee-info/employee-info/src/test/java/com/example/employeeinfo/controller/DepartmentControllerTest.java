package com.example.employeeinfo.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.employeeinfo.EmployeeInfoApplicationTests;
import com.example.employeeinfo.model.Department;

@RunWith(SpringJUnit4ClassRunner.class)
public class DepartmentControllerTest extends EmployeeInfoApplicationTests {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Ignore
	@Test
	public void getDepartmentsList() throws Exception {
		String uri = "/department/get";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Department[] departmentList = super.mapFromJson(content, Department[].class);
		Assert.assertTrue(departmentList.length > 0);
	}

	@Ignore
	@Test
	public void addDepartment() throws Exception {
		String uri = "/department/add";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Department[] departmentList = super.mapFromJson(content, Department[].class);
		Assert.assertTrue(departmentList.length > 0);
	}
	
}
