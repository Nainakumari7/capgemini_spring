package com.capgemini.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.employee.Employee;
import com.capgemini.employee.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class EmployeeController {
	
	
	private EmployeeService service;
	
	public EmployeeController(EmployeeService service) {
		this.service=service;
	}
	
	
	@GetMapping("/register")
	public String register() {
		return "register";
		
	}
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute Employee e, Model m) {
		return service.createEmployee(e, m);
		
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/logincheck")
	public ModelAndView  getDetails(HttpServletRequest request) {
	return service.login(request.getParameter("email") , request.getParameter("password"));
	}
}
