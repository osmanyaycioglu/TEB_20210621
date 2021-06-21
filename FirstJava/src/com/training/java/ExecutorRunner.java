package com.training.java;


public class ExecutorRunner {

    public static void main(final String[] args) {
        IExecutor executorLoc = new Executor2();
        String executeLoc = executorLoc.execute("osman",
                                                10);
        System.out.println(executeLoc);
    }

}
