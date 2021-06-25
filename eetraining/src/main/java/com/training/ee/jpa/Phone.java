package com.training.ee.jpa;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Phone {

    @Id
    @GeneratedValue
    private Long     phoneId;
    private String   name;
    private String   number;

    @ManyToOne
    @XmlTransient
    @JsonbTransient
    private Employee employee;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(final String numberParam) {
        this.number = numberParam;
    }

    public Long getPhoneId() {
        return this.phoneId;
    }

    public void setPhoneId(final Long phoneIdParam) {
        this.phoneId = phoneIdParam;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(final Employee employeeParam) {
        this.employee = employeeParam;
    }


}
