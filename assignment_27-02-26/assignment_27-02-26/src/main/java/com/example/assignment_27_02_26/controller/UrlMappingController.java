package com.example.assignment_27_02_26.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.assignment_27_02_26.entity.UrlMapping;
import com.example.assignment_27_02_26.service.UrlMappingService;

@RestController
@RequestMapping("/urls")
public class UrlMappingController {

    private final UrlMappingService urlMappingService;

    public UrlMappingController(UrlMappingService urlMappingService) {
        this.urlMappingService = urlMappingService;
    }

    @PostMapping
    public UrlMapping createShortUrl(@RequestBody UrlMapping urlMapping) {
        return urlMappingService.createShortUrl(urlMapping);
    }

    @GetMapping("/{shortCode}")
    public UrlMapping getOriginalUrl(@PathVariable String shortCode) {
        return urlMappingService.getOriginalUrl(shortCode);
    }

    @GetMapping
    public List<UrlMapping> getAllUrls() {
        return urlMappingService.getAllUrls();
    }
}