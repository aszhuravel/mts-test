package ru.zhuravel.service;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/task")
public interface TaskRemoteService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    Response getTask(@PathParam("id") String id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    Response create();
}