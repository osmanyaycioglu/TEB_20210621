package com.training.ee.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class MyStateless {

    // private int toplam;

    public MyStateless() {
    }

    public int calcAdd(final int a,
                       final int b) {
        int tempTotal = a + b;
        // this.toplam += tempTotal;
        return tempTotal;
    }

    public int calcSubstract(final int a,
                             final int b) {
        int tempTotal = a - b;
        // this.toplam += tempTotal;
        return tempTotal;
    }

}
