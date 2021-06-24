package com.training.ee.ejb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
@LocalBean
public class MyStatefulBean implements Serializable {

    private static final long serialVersionUID = -6612207348564941776L;

    private int               toplam;

    @EJB
    private MySingletonBean   mySingletonBean;

    public MyStatefulBean() {
        // this.mySingletonBean.hello(); Nullpointer
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

    @PostConstruct
    public void init() {
        this.mySingletonBean.hello();
    }

    @PreDestroy
    public void destroy() {
    }

    @Remove
    public void remove() {
    }

    @PrePassivate
    public void preWrite() {
    }

    @PostActivate
    public void preRead() {
    }

}
