package com.training.java;


public interface IExecutor {

    public static final int TEST_CONSTANT = 1;
    public static int       test          = 2;


    String execute(String str,
                   int value);

    // void extra(String str);

    default void sayHello(final String name) {
        System.out.println(this.execute(name,
                                        IExecutor.TEST_CONSTANT));
    }


    default void extra(final String strParam) {
        System.out.println("extra : " + strParam);
    }


    public static void testStatic() {
        System.out.println("Static method");
    }

}
