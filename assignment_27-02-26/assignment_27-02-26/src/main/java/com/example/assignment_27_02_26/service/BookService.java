package com.example.assignment_27_02_26.service;

import java.util.List;
import com.example.assignment_27_02_26.entity.Book;

public interface BookService {

    Book addBook(Book book);

    Book getBookById(Long bookId);

    List<Book> getAllBooks();

    void deleteBook(Long bookId);
}