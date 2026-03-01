package com.example.assignment_27_02_26.service;

import java.util.List;
import com.example.assignment_27_02_26.entity.Author;

public interface AuthorService {

    Author addAuthor(Author author);

    List<Author> getAllAuthors();
}