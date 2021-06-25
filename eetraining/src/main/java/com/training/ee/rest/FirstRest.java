package com.training.ee.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import com.training.ee.cdi.MyText;
import com.training.ee.cdi.interceptor.MyIntTest;


@Path("/first")
public class FirstRest {

    @Inject
    private MyText    myText;

    @Inject
    private MyIntTest myIntTest;

    @Path("/hello")
    @GET
    public String helloGet() {
        this.myText.hello();
        return "Hello world GET";
    }

    @Path("/hello")
    @POST
    public String helloPost() {
        return this.myIntTest.callMe("POST",
                                     113);
        // return "Hello world POST";
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
