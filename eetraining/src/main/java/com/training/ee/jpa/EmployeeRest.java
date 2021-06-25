package com.training.ee.jpa;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/employee/provision")
@Produces({
            MediaType.APPLICATION_JSON
})
public class EmployeeRest {

    @EJB
    private EmployeeManager employeeManager;

    @Path("/add")
    @POST
    @Consumes({
                MediaType.APPLICATION_JSON
    })
    public String add(final Employee employeeParam) {
        employeeParam.getAddress()
                     .setEmployee(employeeParam);
        List<Phone> phonesLoc = employeeParam.getPhones();
        for (Phone phoneLoc : phonesLoc) {
            phoneLoc.setEmployee(employeeParam);
        }
        this.employeeManager.addEmployee(employeeParam);
        return "SUCCESS";
    }

    @Path("/get/{eid}")
    @GET
    public Employee get(@PathParam("eid") final Long employeeId) {
        return this.employeeManager.getEmployee(employeeId);
    }

    @Path("/findby/name/{name}")
    @GET
    public List<Employee> getbyname(@PathParam("name") final String employeeName) {
        return this.employeeManager.getEmployeeByName(employeeName);
    }

    @Path("/findby/name/{name}/surname/{surname}")
    @GET
    public List<Employee> getbyNameAndSurname(@PathParam("name") final String employeeName,
                                              @PathParam("surname") final String employeeSurname) {
        return this.employeeManager.getEmployeeByNameAndSurname(employeeName,
                                                                employeeSurname);
    }


}
