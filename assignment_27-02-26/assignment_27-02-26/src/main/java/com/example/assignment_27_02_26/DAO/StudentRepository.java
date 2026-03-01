package com.example.assignment_27_02_26.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment_27_02_26.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
