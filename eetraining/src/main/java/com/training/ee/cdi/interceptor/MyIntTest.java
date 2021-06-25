package com.training.ee.cdi.interceptor;


public class MyIntTest {

    @Log
    public String callMe(final String str,
                         final int val) {
        return "Called : " + str + " value : " + val;
    }


}
