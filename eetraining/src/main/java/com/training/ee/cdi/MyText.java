package com.training.ee.cdi;


public class MyText {

    private final String str;

    public MyText(final String strParam) {
        super();
        this.str = strParam;
    }

    public void hello() {
        System.out.println("hello " + this.str);
    }

}
