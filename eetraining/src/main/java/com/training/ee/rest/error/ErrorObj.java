package com.training.ee.rest.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {

    private List<ErrorObj> subErrors;
    private String         message;
    private int            cause;

    public ErrorObj addError(final ErrorObj errorObjParam) {
        if (this.subErrors == null) {
            this.subErrors = new ArrayList<>();
        }
        this.subErrors.add(errorObjParam);
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public ErrorObj setMessage(final String messageParam) {
        this.message = messageParam;
        return this;
    }

    public int getCause() {
        return this.cause;
    }

    public ErrorObj setCause(final int causeParam) {
        this.cause = causeParam;
        return this;
    }

    public List<ErrorObj> getSubErrors() {
        return this.subErrors;
    }

    public static void main(final String[] args) {
        ErrorObj errorObjLoc = new ErrorObj().setMessage("test error")
                                             .setCause(100)
                                             .addError(new ErrorObj().setMessage("level1a error")
                                                                     .setCause(120)
                                                                     .addError(new ErrorObj().setMessage("level 2 error")
                                                                                             .setCause(121)))
                                             .addError(new ErrorObj().setMessage("level1b error")
                                                                     .setCause(119));
        System.out.println(errorObjLoc);
    }
}
