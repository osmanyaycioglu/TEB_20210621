package com.training.ee.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long   addressId;
    private String city;
    private String street;

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


}
