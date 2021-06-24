package com.training.ee.jpa;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/v1/employee/provision")
public class EmployeeRest {

    @EJB
    private EmployeeManager employeeManager;

    @Path("/add")
    @POST
    @Consumes({
                MediaType.APPLICATION_JSON
    })
    public String add(final Employee employeeParam) {
        this.employeeManager.addEmployee(employeeParam);
        return "SUCCESS";
    }

}
