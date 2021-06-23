package com.training.ee.rest;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.validation.Valid;
import javax.ws.rs.PathParam;

@WebService(targetNamespace = "http://teb.com.tr/training")
public class PersonWebService {

    public String hello(@WebParam(name = "name") @PathParam("isim") final String name,
                        @WebParam(name = "surname") @PathParam("soyisim") final String surname) {
        return "Hello 1 " + name + " " + surname;
    }

    @WebMethod(exclude = true)
    public Person hello8(@Valid final Person person) {
        return person;
    }

}
