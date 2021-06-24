package com.training.ee.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class MySingletonBean {

    public MySingletonBean() {
    }

    public String hello() {
        return "Hello";
    }

}
