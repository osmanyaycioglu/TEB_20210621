package com.training.ee.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/v1/person/greeting")
public class PersonRest {

    @Path("/hello/{isim}/{soyisim}")
    @GET
    public String hello(@PathParam("isim") final String name,
                        @PathParam("soyisim") final String surname) {
        return "Hello " + name + " " + surname;
    }

    @Path("/hello2")
    @GET
    public String hello2(@QueryParam("isim") final String name,
                         @QueryParam("soyisim") final String surname) {
        return "Hello " + name + " " + surname;
    }


    @Path("/hello3/{isim}")
    @GET
    public String hello3(@PathParam("isim") final String name,
                         @QueryParam("soyisim") final String surname) {
        return "Hello " + name + " " + surname;
    }

    @Path("/hello4")
    @POST
    public String hello4(final Person person) {
        return "Hello " + person;
    }


}
