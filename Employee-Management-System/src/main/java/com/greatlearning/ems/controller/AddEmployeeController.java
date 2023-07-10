package com.greatlearning.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.ems.entity.Employee;
import com.greatlearning.ems.service.AddEmployeeService;

@Controller
@RequestMapping("/employee")
public class AddEmployeeController {

	@Autowired
	AddEmployeeService addEmployeeService;

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestParam("Id") int id, @RequestParam("First Name") String firstName,
			@RequestParam("Last Name") String lastName, @RequestParam("Email") String email) {

		Employee employee = new Employee();
		employee.setId(id);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmail(email);

		return addEmployeeService.addEmployee(employee);
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employees", employee);
		return "employee/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employees") Employee employee) {

		addEmployeeService.addEmployee(employee);

		return "redirect:/employee/list";
	}
}
