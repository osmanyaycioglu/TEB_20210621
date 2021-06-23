package com.training.ee.rest;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/v1/person/greeting")
public class PersonRest {


    @Path("/hello/{isim}/{soyisim}")
    @GET
    public String hello(@WebParam(name = "name") @PathParam("isim") final String name,
                        @WebParam(name = "surname") @PathParam("soyisim") final String surname) {
        return "Hello 1 " + name + " " + surname;
    }

    @Path("/hello2")
    @GET
    public String hello2(@QueryParam("isim") final String name,
                         @QueryParam("soyisim") final String surname) {
        return "Hello 2 " + name + " " + surname;
    }


    @Path("/hello3/{isim}")
    @GET
    public String hello3(@PathParam("isim") final String name,
                         @QueryParam("soyisim") final String surname) {
        return "Hello 3 " + name + " " + surname;
    }

    @Path("/hello4")
    @POST
    public String hello4(final Person person) {
        return "Hello 4 " + person;
    }

    @Path("/hello5")
    @GET
    public String hello5(@HeaderParam("isim") final String name,
                         @HeaderParam("soyisim") final String surname) {
        return "Hello 5 " + name + " " + surname;
    }

    @Path("/hello6/{yas}")
    @POST
    public String hello6(@BeanParam final Person person) {
        return "Hello 6 " + person;
    }

    @Path("/hello7")
    @POST
    @Consumes({
                MediaType.APPLICATION_JSON,
                MediaType.APPLICATION_XML
    })
    @Produces({
                MediaType.APPLICATION_JSON,
                MediaType.APPLICATION_XML
    })
    public Person hello7(final Person person) {
        person.setAge(99);
        return person;
    }

    @Path("/hello8")
    @POST
    @WebMethod(exclude = true)
    public Person hello8(@Valid final Person person) {
        //        if ((person.getName() == null)
        //            || person.getName()
        //                     .isEmpty()) {
        //            throw new IllegalArgumentException("Name boş olamaz");
        //        }
        return person;
    }

}
