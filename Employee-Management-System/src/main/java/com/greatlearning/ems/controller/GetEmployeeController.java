package com.greatlearning.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.ems.entity.Employee;
import com.greatlearning.ems.service.GetEmployeeService;

@Controller
@RequestMapping("/employee")
public class GetEmployeeController {

	@Autowired
	GetEmployeeService getEmployeeService;

	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee() {
		return getEmployeeService.getAllEmployee();

	}

	@GetMapping("/getEmployee")
	public Employee getEmployee(@RequestParam("Id") int id) {
		return getEmployeeService.getEmployee(id);

	}

	@GetMapping("/list")
	public String getAllEmployee(Model model) {
		List<Employee> listOfEmployees = getEmployeeService.getAllEmployee();
		model.addAttribute("employees", listOfEmployees);
		return "employee/list-employee";
	}

}
