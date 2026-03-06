package com.example.DTOLayer;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentJpaRepository jpa;

    public StudentService(StudentJpaRepository jpa) {
        this.jpa = jpa;
    }

    public StudentDTO addStudent(StudentDTO dto) {
        Student s = StudentMapper.createStudent(dto);
        Student saved = jpa.save(s);
        return StudentMapper.createStudentDTO(saved);
    }

    public StudentDTO getById(int id) {
        Student s = jpa.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not found"));
        return StudentMapper.createStudentDTO(s);
    }
}