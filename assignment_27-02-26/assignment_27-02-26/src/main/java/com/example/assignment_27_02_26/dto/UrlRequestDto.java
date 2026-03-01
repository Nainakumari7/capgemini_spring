package com.example.assignment_27_02_26.dto;

import jakarta.validation.constraints.NotBlank;

public class UrlRequestDto {

    @NotBlank
    private String originalUrl;

    public UrlRequestDto() {}

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}