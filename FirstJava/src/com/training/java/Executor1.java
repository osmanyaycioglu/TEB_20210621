package com.training.java;

public class Executor1 implements IExecutor {

    @Override
    public String execute(final String strParam,
                          final int valueParam) {
        return "Hello " + strParam + " val : " + valueParam;
    }


    public void sayHello() {
        this.extra("osman");
        System.out.println("hello");
    }
}
