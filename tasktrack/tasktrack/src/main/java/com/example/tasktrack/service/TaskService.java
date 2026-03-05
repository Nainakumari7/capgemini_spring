package com.example.tasktrack.service;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.tasktrack.model.Task;


public interface TaskService {

    List<Task> getAllTasks();

    void saveTask(Task task, MultipartFile file) throws Exception;

    void toggleStatus(Long id);

    void deleteTask(Long id);

    byte[] getTaskImage(Long id);
}