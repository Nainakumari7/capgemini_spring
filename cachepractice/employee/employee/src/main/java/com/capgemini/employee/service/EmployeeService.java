package com.capgemini.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.employee.Employee;
import com.capgemini.employee.EmployeeJpaRepository;

@Service
public class EmployeeService {
	
	EmployeeJpaRepository jpa;
	
	public EmployeeService(EmployeeJpaRepository jpa) {
		this.jpa=jpa;
	}
	
	public ModelAndView createEmployee(Employee e) {
		Optional<Employee> optional = jpa.findById(e.getEmail());
		ModelAndView m = new ModelAndView();
		
		if(optional.isPresent()) {
			m.addObject("msg", e.getName());
			m.setViewName("exist");
			return m;
		}
		else {
			m.addObject("msg", e.getName());
			m.setViewName("successful");
			Employee employee = jpa.save(e);
			return m;	
		}		
	}
	
	public ModelAndView login(String email, String password) {
		Optional<Employee>
		Employee e = jpa.findByEmailAndPassword(email, password);
		ModelAndView m = new ModelAndView();
		if(e.getRole().equalsIgnoreCase("admin")) {
			List<Employee> emp = jpa.findAll();
			m.addObject("msg", emp);
			m.setViewName("admin");
			return m;
		}else {	
			m.addObject("msg",e);
			m.setViewName("userdetails");
			return m;
		}
	}
}
