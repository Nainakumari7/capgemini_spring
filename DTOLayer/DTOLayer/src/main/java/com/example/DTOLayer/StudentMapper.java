package com.example.DTOLayer;

public class StudentMapper {

    public static Student createStudent(StudentDTO dto) {
        Student s = new Student();
        s.setName(dto.getName());
        s.setCollege(dto.getCollege());
        s.setMarks(dto.getMarks());
        s.setGender(dto.getGender());
        s.setEmail(dto.getEmail());
        s.setPhone(dto.getPhone());
        return s;
    }

    public static StudentDTO createStudentDTO(Student s) {
        StudentDTO dto = new StudentDTO();
        dto.setName(s.getName());
        dto.setCollege(s.getCollege());
        dto.setMarks(s.getMarks());
        dto.setGender(s.getGender());
        return dto;
    }
}