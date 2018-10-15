package ru.zhuravel.service.impl;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.zhuravel.entity.Task;
import ru.zhuravel.service.DatabaseService;
import ru.zhuravel.service.WorkService;

@Service
public class WorkServiceImpl implements WorkService {
    private static final long TASK_TIME_MS = TimeUnit.MINUTES.toMillis(2);

    @Autowired
    private DatabaseService databaseService;

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void schedule(UUID uuid) {
        executorService.submit(() -> work(uuid));
    }

    private void work(UUID uuid) {
        databaseService.updateState(uuid, Task.State.RUNNING);
        try {
            Thread.sleep(TASK_TIME_MS);
            databaseService.updateState(uuid, Task.State.FINISHED);
        } catch (InterruptedException e) {
            // ignore
        }
    }
}
