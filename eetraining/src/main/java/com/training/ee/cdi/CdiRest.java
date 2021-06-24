package com.training.ee.cdi;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/cdi")
@SessionScoped
public class CdiRest implements Serializable {

    @Inject
    @Named("dyn")
    // @Alternative
    // @MyProcessAnno
    private IProcess myProcess;
    private int      counter;

    @Path("/hello")
    @GET
    public String hello(@QueryParam("name") final String name) {
        return "index : " + this.counter++ + " " + this.myProcess.process(name);
    }

}
