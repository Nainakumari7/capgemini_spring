package com.prac.cachepractice.controller;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.prac.cachepractice.entity.FileData;
import com.prac.cachepractice.repo.FileRepository;

@RestController
@RequestMapping("/files")
public class FileController {

    private FileRepository repository;

    public FileController(FileRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/upload")
    public FileData upload(@RequestParam("file") MultipartFile file) throws IOException {

        FileData data = new FileData();
        data.setFilename(file.getOriginalFilename());
        data.setFiletype(file.getContentType());
        data.setData(file.getBytes());

        return repository.save(data);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Long id) {

        FileData data = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found"));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + data.getFilename() + "\"")
                .header(HttpHeaders.CONTENT_TYPE, data.getFiletype())
                .body(data.getData());
    }
}