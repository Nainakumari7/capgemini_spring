package com.example.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.librarymanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}