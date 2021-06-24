package com.training.ee.jpa;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class EmployeeManager {


    @EJB
    private EmoployeeDao dao;

    public void addEmployee(final Employee emp) {
        this.dao.add(emp);
    }


}
