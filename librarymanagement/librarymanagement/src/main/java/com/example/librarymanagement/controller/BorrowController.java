package com.example.librarymanagement.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.librarymanagement.entity.BorrowRecord;
import com.example.librarymanagement.service.BorrowService;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {

    private final BorrowService service;

    public BorrowController(BorrowService service) {
        this.service = service;
    }

    @GetMapping
    public List<BorrowRecord> getRecords() {
        return service.getAllRecords();
    }

    @PostMapping
    public BorrowRecord borrowBook(@RequestParam Long userId, @RequestParam Long bookId) {
        return service.borrowBook(userId, bookId);
    }
}