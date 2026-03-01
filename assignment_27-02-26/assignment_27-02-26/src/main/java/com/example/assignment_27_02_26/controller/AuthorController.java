package com.example.assignment_27_02_26.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.assignment_27_02_26.entity.Author;
import com.example.assignment_27_02_26.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }
}