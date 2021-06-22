package com.training.ee.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/first")
public class FirstRest {

    @Path("/hello")
    @GET
    public String hello() {
        return "Hello world";
    }
    // WebAPP ---> /ee
    // Rest ----> /api
    // FirstRest Class ----> /first
    // hello ---> HTTP GET /hello
    // /ee/api/first/hello GET
}
