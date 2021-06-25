package com.training.ee.cdi;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.InjectionPoint;
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

    @Produces
    @Named("text1")
    @Dependent
    public MyText createMyText(final InjectionPoint ip) {
        Bean<?> beanLoc = ip.getBean();
        Type typeLoc = ip.getType();
        return new MyText(beanLoc.getBeanClass()
                                 .getName());
    }

}
