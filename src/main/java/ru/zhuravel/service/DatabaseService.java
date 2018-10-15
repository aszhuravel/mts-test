package ru.zhuravel.service;

import java.util.UUID;

import ru.zhuravel.entity.Task;

public interface DatabaseService {
    Task create();

    Task get(UUID id);

    void updateState(UUID id, Task.State state);
}
