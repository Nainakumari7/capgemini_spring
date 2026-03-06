package com.example.DTOLayer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class StudentController {
	
	 private StudentService service;

	public StudentController(StudentService service) {
		super();
		this.service = service;
	}
	@PostMapping("/create")
	public StudentDTO addStudent(@Valid @RequestBody StudentDTO dto) {
		return service.addStudent(dto);
	}
	
	@GetMapping("/find-id/{id}")
	public StudentDTO getById(@PathVariable int id) {
		return service.getById(id);
	}
}
