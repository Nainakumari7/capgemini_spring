package com.example.librarymanagement.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDate;
import com.example.librarymanagement.entity.*;
import com.example.librarymanagement.repository.*;

@Service
public class BorrowService {

    private final BorrowRecordRepository borrowRepo;
    private final UserRepository userRepo;
    private final BookRepository bookRepo;

    public BorrowService(BorrowRecordRepository borrowRepo, UserRepository userRepo, BookRepository bookRepo) {
        this.borrowRepo = borrowRepo;
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
    }

    public List<BorrowRecord> getAllRecords() {
        return borrowRepo.findAll();
    }

    public BorrowRecord borrowBook(Long userId, Long bookId) {

        User user = userRepo.findById(userId).orElse(null);
        Book book = bookRepo.findById(bookId).orElse(null);

        BorrowRecord record = new BorrowRecord();
        record.setUser(user);
        record.setBook(book);
        record.setBorrowDate(LocalDate.now());
        record.setReturned(false);

        book.setAvailable(false);
        bookRepo.save(book);

        return borrowRepo.save(record);
    }
}