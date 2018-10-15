package ru.zhuravel.repositories;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.zhuravel.entity.Task;

public interface TaskRepository extends JpaRepository<Task, UUID> {

    @Transactional
    @Modifying
    @Query("UPDATE Task t SET t.state = :state, t.timestamp = CURRENT_TIMESTAMP WHERE t.id = :id")
    void updateState(@Param("id") UUID id, @Param("state") Task.State state);

}
