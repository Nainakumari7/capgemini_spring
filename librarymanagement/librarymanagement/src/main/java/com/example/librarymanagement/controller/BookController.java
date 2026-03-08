package com.example.librarymanagement.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.librarymanagement.entity.Book;
import com.example.librarymanagement.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> getBooks() {
        return service.getAllBooks();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return service.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
    }
}