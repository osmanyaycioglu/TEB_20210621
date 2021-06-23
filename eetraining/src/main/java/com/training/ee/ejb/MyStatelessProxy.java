package com.training.ee.ejb;

public class MyStatelessProxy extends MyStateless {

    @Override
    public int calcAdd(final int a,
                       final int b) {
        MyStateless my1 = new MyStateless();
        //MyStateless my1 = EJBContext.getBean();
        return my1.calcAdd(a,
                           b);
    }

    @Override
    public int calcSubstract(final int a,
                             final int b) {
        MyStateless my1 = new MyStateless();
        //MyStateless my1 = EJBContext.getBean();
        return my1.calcSubstract(a,
                                 b);
    }

}
