package com.training.java.lambda.usage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest {

    private List<String> strList = new ArrayList<>();

    public LambdaTest add(final Supplier<String> str) {
        this.strList.add(str.get());
        return this;
    }

    public LambdaTest filter(final Predicate<String> pred) {
        List<String> tempList = new ArrayList<>();
        for (String stringLoc : this.strList) {
            if (pred.test(stringLoc)) {
                tempList.add(stringLoc);
            }
        }
        this.strList = tempList;
        return this;
    }

    public void toFormattedString() {
        System.out.println("Liste : ");
        this.strList.forEach(y -> System.out.println("\t" + y));
        //        for (String stringLoc : this.strList) {
        //            System.out.println("\t" + stringLoc);
        //        }
    }

    public void toFormattedString(final Consumer<String> format) {
        System.out.println("Liste : ");
        this.strList.forEach(uy -> format.accept(uy));
        //        for (String stringLoc : this.strList) {
        //            format.accept(stringLoc);
        //        }
    }

    public int total(final Function<String, Integer> totalFunc) {
        int total = 0;
        for (String stringLoc : this.strList) {
            total += totalFunc.apply(stringLoc);
        }
        return total;
    }

}
