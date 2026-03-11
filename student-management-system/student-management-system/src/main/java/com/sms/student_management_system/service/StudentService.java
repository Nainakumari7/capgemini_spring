package com.sms.student_management_system.service;

import java.io.IOException;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sms.student_management_system.entity.Student;
import com.sms.student_management_system.repository.StudentRepository;


@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student createStudent(Student student) {
        return repo.save(student);
    }

    @Cacheable("students")
    @PostAuthorize("returnObject.email == authentication.name")
    public Student getStudent(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public Page<Student> getAllStudents(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Student updateStudent(Long id, Student student) {
        Student s = repo.findById(id).orElseThrow();
        s.setName(student.getName());
        s.setEmail(student.getEmail());
        s.setCourse(student.getCourse());
        s.setMarks(student.getMarks());
        return repo.save(s);
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }

    public void uploadProfile(Long id, MultipartFile file) throws IOException {
        Student s = repo.findById(id).orElseThrow();
        s.setProfileImage(file.getBytes());
        repo.save(s);
    }

    public void uploadAssignment(Long id, MultipartFile file) throws IOException {
        Student s = repo.findById(id).orElseThrow();
        s.setAssignmentFile(file.getBytes());
        repo.save(s);
    }

    public byte[] downloadProfile(Long id) {
        Student s = repo.findById(id).orElseThrow();
        return s.getProfileImage();
    }

    public byte[] downloadAssignment(Long id) {
        Student s = repo.findById(id).orElseThrow();
        return s.getAssignmentFile();
    }
}