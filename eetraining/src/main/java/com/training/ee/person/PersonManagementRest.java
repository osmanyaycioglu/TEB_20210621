package com.training.ee.person;

import java.util.List;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.training.ee.rest.Person;

@Path("/v1/person/management")
public class PersonManagementRest {

    @EJB
    private PersonStorage personStorage;

    @Path("/add")
    @POST
    public String add(@Valid final Person personParam) {
        // Obejct Mapping yapmam gerekir
        this.personStorage.add(personParam);
        return "Success";
    }

    @Path("/get")
    @GET
    public Person get(@QueryParam("name") final String name) {
        return this.personStorage.getPerson(name);
    }

    @Path("/getall")
    @GET
    public List<Person> getall() {
        return this.personStorage.getAllPersons();
    }

}
