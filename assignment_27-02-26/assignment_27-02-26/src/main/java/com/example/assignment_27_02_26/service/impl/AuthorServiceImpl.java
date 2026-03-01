package com.example.assignment_27_02_26.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.assignment_27_02_26.DAO.AuthorRepository;
import com.example.assignment_27_02_26.entity.Author;
import com.example.assignment_27_02_26.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}