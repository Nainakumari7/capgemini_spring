package com.example.assignment_27_02_26.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.assignment_27_02_26.DAO.UrlMappingRepository;
import com.example.assignment_27_02_26.entity.UrlMapping;
import com.example.assignment_27_02_26.exception.ResourceNotFoundException;
import com.example.assignment_27_02_26.service.UrlMappingService;

@Service
public class UrlMappingServiceImpl implements UrlMappingService {

    private final UrlMappingRepository urlMappingRepository;

    public UrlMappingServiceImpl(UrlMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }

    @Override
    public UrlMapping createShortUrl(UrlMapping urlMapping) {
        return urlMappingRepository.save(urlMapping);
    }

    @Override
    public UrlMapping getOriginalUrl(String shortCode) {
        return urlMappingRepository.findByShortCode(shortCode)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Short URL not found"));
    }

    @Override
    public List<UrlMapping> getAllUrls() {
        return urlMappingRepository.findAll();
    }
}