package com.training.ee.rest.error;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyErrorHandler3 implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(final Exception exceptionParam) {
        exceptionParam.printStackTrace();
        return Response.status(Status.INTERNAL_SERVER_ERROR)
                       .header("Content-Type",
                               "application/json")
                       .entity(new ErrorObj().setMessage(exceptionParam.getMessage())
                                             .setCause(500))
                       .header("error",
                               "error")
                       .build();
    }

}
