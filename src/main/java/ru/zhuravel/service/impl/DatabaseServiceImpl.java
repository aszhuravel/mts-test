package ru.zhuravel.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.zhuravel.entity.Task;
import ru.zhuravel.repositories.TaskRepository;
import ru.zhuravel.service.DatabaseService;

@Service
public class DatabaseServiceImpl implements DatabaseService {

    @Autowired
    private TaskRepository taskRepository;

    public UUID create() {
        Task createdTask = taskRepository.saveAndFlush(new Task());
        return createdTask.getId();
    }

    public void updateState(UUID id, Task.State state) {
        taskRepository.updateState(id, state);
    }

    public Task get(UUID id) {
        return taskRepository.findById(id).orElse(null);
    }
}
