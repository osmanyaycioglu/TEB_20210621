package com.training.ee.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;


@Path("/first")
public class FirstRest {

    @Path("/hello")
    @GET
    public String helloGet() {
        return "Hello world GET";
    }

    @Path("/hello")
    @POST
    public String helloPost() {
        return "Hello world POST";
    }

    @Path("/hello")
    @PUT
    public String helloPut() {
        return "Hello world PUT";
    }

    @Path("/hello")
    @PATCH
    public String helloPatch() {
        return "Hello world PATCH";
    }

    @Path("/hello")
    @DELETE
    public String helloDelete() {
        return "Hello world DELETE";
    }

    // WebAPP ---> /ee
    // Rest ----> /api
    // FirstRest Class ----> /first
    // hello ---> HTTP GET /hello
    // /ee/api/first/hello GET
}
