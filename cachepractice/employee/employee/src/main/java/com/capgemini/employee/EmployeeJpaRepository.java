package com.capgemini.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee, String> {
	
	public Employee findByEmailAndPassword(String email, String password);

}
