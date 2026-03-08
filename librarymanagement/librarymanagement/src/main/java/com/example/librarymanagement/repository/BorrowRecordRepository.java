package com.example.librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.librarymanagement.entity.BorrowRecord;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
}