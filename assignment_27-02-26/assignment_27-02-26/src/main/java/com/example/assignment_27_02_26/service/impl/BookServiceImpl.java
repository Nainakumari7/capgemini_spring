package com.example.assignment_27_02_26.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.assignment_27_02_26.DAO.BookRepository;
import com.example.assignment_27_02_26.entity.Book;
import com.example.assignment_27_02_26.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}