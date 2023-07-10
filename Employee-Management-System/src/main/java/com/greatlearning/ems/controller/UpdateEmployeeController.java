package com.greatlearning.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.ems.entity.Employee;
import com.greatlearning.ems.service.GetEmployeeService;
import com.greatlearning.ems.service.UpdateEmployeeService;

@Controller
@RequestMapping("/employee")
public class UpdateEmployeeController {

	@Autowired
	UpdateEmployeeService updateEmployeeService;

	@Autowired
	GetEmployeeService getEmployeeService;

	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestParam("Id") int id, @RequestBody Employee employee) {
		return updateEmployeeService.updateEmployee(id, employee);

	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("Id") int id, Model model) {
		Employee emp = getEmployeeService.getEmployee(id);
		model.addAttribute("employees", emp);
		return "employee/employee-form";
	}
}
