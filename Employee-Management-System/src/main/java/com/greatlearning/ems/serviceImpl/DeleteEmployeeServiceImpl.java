package com.greatlearning.ems.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.ems.repository.EmployeeRepository;
import com.greatlearning.ems.service.DeleteEmployeeService;

@Service
public class DeleteEmployeeServiceImpl implements DeleteEmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public void deleteEmployee(int id) {

		employeeRepository.deleteById(id);
	}
	
}
