package com.example.assignment1_28_02_26.service;

import java.util.List;
import com.example.assignment1_28_02_26.Book;

public interface BookService {

    void addBook(Book book, Long categoryId, Long branchId, Long[] authorIds);

    Book getBookById(Long bookId);

    List<Book> getAllBooks();

    void updateBook(Long bookId, Book updatedBook);

    void deleteOrDisableBook(Long bookId);
}