package com.training.ee.jpa;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long     addressId;
    private String   city;
    private String   street;

    @OneToOne
    @JoinColumn(name = "empid")
    @XmlTransient
    @JsonbTransient
    private Employee employee;

    public String getCity() {
        return this.city;
    }

    public void setCity(final String cityParam) {
        this.city = cityParam;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(final String streetParam) {
        this.street = streetParam;
    }

    public Long getAddressId() {
        return this.addressId;
    }

    public void setAddressId(final Long addressIdParam) {
        this.addressId = addressIdParam;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(final Employee employeeParam) {
        this.employee = employeeParam;
    }


}
