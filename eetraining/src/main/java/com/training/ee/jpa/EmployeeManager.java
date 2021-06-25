package com.training.ee.jpa;

import java.util.List;

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

    public Employee getEmployee(final Long employeeIdParam) {
        return this.dao.find(employeeIdParam);
    }

    public List<Employee> getEmployeeByName(final String employeeNameParam) {
        return this.dao.findByName(employeeNameParam);
    }

    public List<Employee> getEmployeeByNameAndSurname(final String employeeNameParam,
                                                      final String employeeSurnameParam) {
        return this.dao.findByNameAndSurnameNamed(employeeNameParam,
                                                  employeeSurnameParam);
    }


}
