package com.training.ee.cdi;

import java.io.Serializable;


public class MyProcessDynamic implements IProcess, Serializable {

    private static final long serialVersionUID = -3959497786043724963L;
    private final String      prefix;


    public MyProcessDynamic(final String prefixParam) {
        super();
        this.prefix = prefixParam;
    }


    @Override
    public String process(final String strParam) {
        return this.prefix + " " + strParam;
    }

}
