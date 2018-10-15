package ru.zhuravel.service.impl;

import java.util.UUID;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.zhuravel.entity.Task;
import ru.zhuravel.service.DatabaseService;
import ru.zhuravel.service.TaskRemoteService;
import ru.zhuravel.service.WorkService;

@Service
public class TaskRemoteServiceImpl implements TaskRemoteService {
    @Autowired
    private WorkService workService;

    @Autowired
    private DatabaseService databaseService;

    public Response getTask(String id) {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        Task task = databaseService.get(uuid);
        if (task == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        task.setId(null); // id сущности не возвращаем

        return Response.ok().entity(task).build();
    }

    public Response create() {
        Task task = databaseService.create();
        workService.schedule(task.getId());

        // не возвращаем state и timestamp
        task.setState(null);
        task.setTimestamp(null);

        return Response.accepted().entity(task).build();
    }

}