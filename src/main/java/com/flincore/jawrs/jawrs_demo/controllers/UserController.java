package com.flincore.jawrs.jawrs_demo.controllers;

import com.flincore.jawrs.jawrs_demo.models.User;
import com.flincore.jawrs.jawrs_demo.services.Service;
import com.flincore.jawrs.jawrs_demo.utils.EntityAppender;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@RequestScoped
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    private Service<Long, User> service;

    @GET
    public Response getAll() {
        return Response.ok(this.service.getEntities()).build();
    }

    @GET
    @Path("{id}")
    public Response getUser(@PathParam("id") Long id) {
        Optional<User> user = this.service.getById(id);
        if (user.isPresent()) {
            return Response.ok(user.get()).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(User user) {
        try {
            this.service.insert(user);
            return Response.ok(user).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, User user) {
        try {
            Optional<User> userOptional = this.service.getById(id);

            if (userOptional.isPresent()) {
                EntityAppender.append(userOptional.get(), user);
                this.service.insert(user);
            }

        } catch (Exception e) {
            return Response.serverError().build();
        }

        return Response.ok(user).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        Optional<User> userDeleted = this.service.delete(id);

        if (userDeleted.isPresent()) {
            return Response.ok(userDeleted).build();
        }

        return Response.serverError().build();
    }

}
