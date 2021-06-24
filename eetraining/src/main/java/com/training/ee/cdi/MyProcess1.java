package com.training.ee.cdi;

import java.io.Serializable;

import javax.inject.Named;

@Named("en")
public class MyProcess1 implements IProcess, Serializable {

    private static final long serialVersionUID = -3959497786043724963L;

    @Override
    public String process(final String strParam) {
        return "Hello " + strParam;
    }

}
