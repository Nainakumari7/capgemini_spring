package com.example.tasktrack.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.tasktrack.model.Task;
import com.example.tasktrack.repository.TaskRepository;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository repository;

    @Override
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public void saveTask(Task task, MultipartFile file) throws Exception {

        task.setStatus("PENDING");

        if (!file.isEmpty()) {
            task.setImageName(file.getOriginalFilename());
            task.setImageType(file.getContentType());
            task.setImageData(file.getBytes());
        }

        repository.save(task);
    }

    @Override
    public void toggleStatus(Long id) {

        Task task = repository.findById(id).orElse(null);

        if (task.getStatus().equals("PENDING")) {
            task.setStatus("COMPLETE");
        } else {
            task.setStatus("PENDING");
        }

        repository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    @Override
    public byte[] getTaskImage(Long id) {
        Task task = repository.findById(id).orElse(null);
        return task.getImageData();
    }
}