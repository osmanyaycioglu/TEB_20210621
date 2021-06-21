package com.training.java;

public class Executor2 implements IExecutor {

    @Override
    public String execute(final String strParam,
                          final int valueParam) {
        return "Merhaba " + strParam + " val : " + valueParam;
    }

}
