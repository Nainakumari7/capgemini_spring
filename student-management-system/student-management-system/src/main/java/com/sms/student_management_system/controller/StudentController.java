package com.sms.student_management_system.controller;

import java.io.IOException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sms.student_management_system.entity.Student;
import com.sms.student_management_system.service.StudentService;


@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return service.getStudent(id);
    }

    @GetMapping
    public Page<Student> getAll(Pageable pageable) {
        return service.getAllStudents(pageable);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStudent(id);
    }

    @PostMapping("/{id}/upload/profile")
    public ResponseEntity<?> uploadProfile(@PathVariable Long id, @RequestParam MultipartFile file) throws IOException {
        service.uploadProfile(id, file);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/upload/assignment")
    public ResponseEntity<?> uploadAssignment(@PathVariable Long id, @RequestParam MultipartFile file) throws IOException {
        service.uploadAssignment(id, file);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/download/profile")
    public byte[] downloadProfile(@PathVariable Long id) {
        return service.downloadProfile(id);
    }

    @GetMapping("/{id}/download/assignment")
    public byte[] downloadAssignment(@PathVariable Long id) {
        return service.downloadAssignment(id);
    }
}