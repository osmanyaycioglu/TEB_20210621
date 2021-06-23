package com.training.ee.ejb;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class MyStatefulBean implements Serializable {

    private static final long serialVersionUID = -6612207348564941776L;

    private int               toplam;

    public MyStatefulBean() {
    }


    public int calcAdd(final int a,
                       final int b) {
        int tempTotal = a + b;
        this.toplam += tempTotal;
        return tempTotal;
    }

    public int calcSubstract(final int a,
                             final int b) {
        int tempTotal = a - b;
        this.toplam += tempTotal;
        return tempTotal;
    }


    public int getToplam() {
        return this.toplam;
    }

}
