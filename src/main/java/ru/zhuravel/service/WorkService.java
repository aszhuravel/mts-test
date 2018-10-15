package ru.zhuravel.service;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public interface WorkService {
    void schedule(UUID uuid);
}
