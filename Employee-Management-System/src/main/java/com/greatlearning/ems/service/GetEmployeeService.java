package com.greatlearning.ems.service;

import java.util.List;

import com.greatlearning.ems.entity.Employee;

public interface GetEmployeeService {

	List<Employee> getAllEmployee();

	Employee getEmployee(int id);

}
