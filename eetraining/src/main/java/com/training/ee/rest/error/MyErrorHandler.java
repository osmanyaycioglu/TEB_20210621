package com.training.ee.rest.error;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyErrorHandler implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(final ConstraintViolationException exceptionParam) {
        ErrorObj rootLoc = new ErrorObj().setMessage("Validasyon hatası oluştu")
                                         .setCause(300);
        Set<ConstraintViolation<?>> constraintViolationsLoc = exceptionParam.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolationLoc : constraintViolationsLoc) {
            rootLoc.addError(new ErrorObj().setMessage(constraintViolationLoc.getMessage())
                                           .setCause(150));
        }
        return Response.status(Status.BAD_REQUEST)
                       .header("Content-Type",
                               "application/json")
                       .entity(rootLoc)
                       .header("error",
                               "error")
                       .build();
    }

}
