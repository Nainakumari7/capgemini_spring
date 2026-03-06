package com.example.DTOLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentJpaRepository
        extends JpaRepository<Student, Integer> {
}