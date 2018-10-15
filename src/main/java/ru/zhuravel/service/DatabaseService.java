package ru.zhuravel.service;

import java.util.UUID;

import ru.zhuravel.entity.Task;

public interface DatabaseService {
    UUID create();

    Task get(UUID id);

    void updateState(UUID id, Task.State state);
}
