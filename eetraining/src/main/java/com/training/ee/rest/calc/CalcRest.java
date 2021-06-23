package com.training.ee.rest.calc;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.training.ee.ejb.MyStatefulBean;
import com.training.ee.ejb.MyStateless;

@Path("/v1/calc")
@ApplicationScoped
// @RequestScoped
public class CalcRest implements Serializable {

    private static final long serialVersionUID = -8001402392731510862L;

    @EJB
    private MyStateless       myStateless;

    @EJB
    private MyStatefulBean    myStatefulBean;

    @Path("/add")
    @GET
    public String add(@QueryParam("val1") final Integer a1,
                      @QueryParam("val2") final Integer b1) {
        int calcAddLoc = this.myStateless.calcAdd(a1,
                                                  b1);
        calcAddLoc = this.myStateless.calcAdd(a1,
                                              b1);
        calcAddLoc = this.myStateless.calcAdd(a1,
                                              b1);
        calcAddLoc = this.myStateless.calcAdd(a1,
                                              b1);
        return "sonuç : " + calcAddLoc;
    }

    @Path("/stateful/add")
    @GET
    public String addStateful(@QueryParam("val1") final Integer a1,
                              @QueryParam("val2") final Integer b1) {
        int calcAddLoc = this.myStatefulBean.calcAdd(a1,
                                                     b1);
        return "sonuç : " + calcAddLoc + " toplam : " + this.myStatefulBean.getToplam();
    }

}
