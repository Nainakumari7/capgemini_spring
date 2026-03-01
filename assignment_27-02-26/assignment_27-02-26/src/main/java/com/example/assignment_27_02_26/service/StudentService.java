package com.example.assignment_27_02_26.service;

import java.util.List;
import com.example.assignment_27_02_26.entity.Student;

public interface StudentService {

    Student addStudent(Student student);

    Student getStudentById(Long studentId);

    List<Student> getAllStudents();

    void deleteStudent(Long studentId);
}