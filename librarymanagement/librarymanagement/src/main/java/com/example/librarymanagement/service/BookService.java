package com.example.librarymanagement.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.librarymanagement.entity.Book;
import com.example.librarymanagement.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Book getBook(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Book saveBook(Book book) {
        return repo.save(book);
    }

    public void deleteBook(Long id) {
        repo.deleteById(id);
    }
}