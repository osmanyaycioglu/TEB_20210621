package com.training.java.lambda;


public class Runner {

    public static void main(final String[] args) {
        final TestRef testRefLoc = new TestRef();
        testRefLoc.setStr1("osman");
        testRefLoc.setStr2("ali");

        Runner runnerLoc = new Runner();
        final int value = 100;
        final String prefix = "String start ";
        IRun iRunLoc = new Run1();
        System.out.println(iRunLoc.run("osman"));

        IRun run2 = new IRun() {

            @Override
            public String run(final String strParam) {
                return "Anonim2 impl : " + strParam + " val : " + value;
            }
        };

        System.out.println(run2.run("osman"));

        IRun run21 = new IRun() {

            @Override
            public String run(final String strParam) {
                System.out.println("Anonim multiple line");
                return "Anonim21 impl : " + strParam + " val : " + value;
            }
        };

        System.out.println(run21.run("osman"));

        IRun run3 = a -> "Lambda1 impl : " + a + " val : " + value;
        System.out.println(run3.run("osman"));
        IRun run4 = a -> "Lambda2 impl : " + a + " val : " + value;
        System.out.println(run4.run("osman"));

        IRun run5 = z -> {
            System.out.println("Lambda multiple line");
            return "Lambda3 impl : " + z + " val : " + value;
        };
        System.out.println(run5.run("osman"));

        INext next1 = (p,
                       k) -> "Hello : " + p + " " + k;
        System.out.println(next1.next("osman",
                                      "yay"));

        INext next2 = Runner::xyz;
        next2.next("mehmet",
                   "ali");

        INext next3 = runnerLoc::abc;
        next3.next("mehmet",
                   "ali");

        INoInput noInputLoc = () -> "Hello : " + value;
        System.out.println(noInputLoc.help());

        Runner.runme((z,
                      y) -> {
            testRefLoc.setStr1("test");
            return prefix + "Hello teacher : " + z + " surname : " + y + " " + testRefLoc.getStr1();
        });
    }

    public String abc(final String str1,
                      final String str2) {
        return "Method binding Hello : " + str1 + " " + str2;
    }

    public static String xyz(final String str1,
                             final String str2) {
        return "Static Method binding Hello : " + str1 + " " + str2;
    }

    public static void runme(final INext nextParam) {
        System.out.println(nextParam.next("osman",
                                          "yay"));
    }

}
