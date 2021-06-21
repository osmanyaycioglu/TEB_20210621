package com.training.java.lambda.usage;

import java.util.function.Predicate;

public class Runner {

    public static void main(final String[] args) {
        Predicate<String> pred1 = q -> q.startsWith("pref");
        boolean testLoc = pred1.test("1pref osman");
        System.out.println(testLoc);
    }
}
