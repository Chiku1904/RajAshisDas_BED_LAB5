package com.greatlearning.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.ems.service.DeleteEmployeeService;

@Controller
@RequestMapping("/employee")
public class DeleteEmployeeController {

	@Autowired
	DeleteEmployeeService deleteEmployeeService;

	@DeleteMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("Id") int id) {

		deleteEmployeeService.deleteEmployee(id);
		return "Employee Details Deleted!";
	}

	@PostMapping("/delete")
	public String deleteAEmployee(@RequestParam("Id") int id) {
		deleteEmployeeService.deleteEmployee(id);
		return "redirect:/employee/list";
	}
}
