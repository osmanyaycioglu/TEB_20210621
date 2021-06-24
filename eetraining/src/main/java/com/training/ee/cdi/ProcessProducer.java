package com.training.ee.cdi;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class ProcessProducer {

    private final List<String> prefixes = Arrays.asList("Hello",
                                                        "Merhaba",
                                                        "ola",
                                                        "priviet",
                                                        "hao",
                                                        "hi",
                                                        "selam");

    @Produces
    @Named("dyn")
    @SessionScoped
    public IProcess createDynamicProcess() {
        Random randomLoc = new Random();
        int nextIntLoc = randomLoc.nextInt(this.prefixes.size());
        String stringLoc = this.prefixes.get(nextIntLoc);
        MyProcessDynamic dynamicLoc = new MyProcessDynamic(stringLoc);
        return dynamicLoc;
    }

}
