package com.training.ee.cdi;

import java.io.Serializable;

@MyProcessAnno
public class MyProcess5 implements IProcess, Serializable {

    private static final long serialVersionUID = -3959497786043724963L;

    @Override
    public String process(final String strParam) {
        return "Hao " + strParam;
    }

}
