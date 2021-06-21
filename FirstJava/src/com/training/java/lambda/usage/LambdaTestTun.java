package com.training.java.lambda.usage;

import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaTestTun {

    public static void main(final String[] args) {
        LambdaTest lambdaTestLoc = new LambdaTest();
        lambdaTestLoc.add(() -> "osman")
                     .add(() -> "ali")
                     .add(() -> "veli")
                     .add(() -> "ayşe")
                     .add(() -> "ayşegül")
                     .add(() -> "nehir")
                     .add(() -> "su")
                     .add(() -> "mehmet")
                     .filter(s -> s.length() <= 4)
                     .toFormattedString(w -> System.out.println("isim : " + w));

        Function<String, Integer> func = j -> j.length();
        System.out.println(func.apply("osman"));

        Consumer<String> strConsume = y -> System.out.println(y.substring(2));
        strConsume.accept("osman");


        LambdaTest l2 = new LambdaTest();
        int totalLoc = l2.add(() -> "osman")
                         .add(() -> "ali")
                         .add(() -> "veli")
                         .add(() -> "ayşe")
                         .add(() -> "ayşegül")
                         .add(() -> "nehir")
                         .add(() -> "su")
                         .add(() -> "mehmet")
                         .filter(s -> s.length() <= 4)
                         .total(o -> o.length());
        System.out.println("total : " + totalLoc);

    }
}
