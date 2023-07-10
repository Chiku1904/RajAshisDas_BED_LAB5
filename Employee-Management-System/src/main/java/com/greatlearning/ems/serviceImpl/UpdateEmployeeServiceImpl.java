package com.greatlearning.ems.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.ems.entity.Employee;
import com.greatlearning.ems.repository.EmployeeRepository;
import com.greatlearning.ems.service.UpdateEmployeeService;

@Service
public class UpdateEmployeeServiceImpl implements UpdateEmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee updateEmployee(int id, Employee employee) {
		Employee emp = new Employee();
		emp.setId(id);
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmail(employee.getEmail());
		return employeeRepository.save(emp);
	}
}
