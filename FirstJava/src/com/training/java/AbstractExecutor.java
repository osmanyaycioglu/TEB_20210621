package com.training.java;


public abstract class AbstractExecutor implements IExecutor {

    @Override
    public void extra(final String strParam) {
        System.out.println("extra : " + strParam);
    }

}
