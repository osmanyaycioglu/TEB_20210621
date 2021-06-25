package com.training.ee.rest.error;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyErrorHandler2 implements ExceptionMapper<IllegalArgumentException> {

    @Override
    public Response toResponse(final IllegalArgumentException exceptionParam) {

        return Response.status(Status.BAD_REQUEST)
                       .header("Content-Type",
                               "application/json")

                       .entity(new ErrorObj().setMessage(exceptionParam.getMessage())
                                             .setCause(300))
                       .header("error",
                               "error")
                       .build();
    }

}
