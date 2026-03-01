package com.example.assignment_27_02_26.service;

import java.util.List;
import com.example.assignment_27_02_26.entity.UrlMapping;

public interface UrlMappingService {

    UrlMapping createShortUrl(UrlMapping urlMapping);

    UrlMapping getOriginalUrl(String shortCode);

    List<UrlMapping> getAllUrls();
}