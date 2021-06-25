package com.training.ee.jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "calisan")
@NamedQueries({
                @NamedQuery(name = "find_by_name", query = "select e from Employee e where e.name=:abc"),
                @NamedQuery(name = "find_by_name_and_surname",
                            query = "select e from Employee e where e.name=?1 and e.surname=?2")

})
public class Employee {

    @Id
    @GeneratedValue
    private Long           employeeId;
    @Column(name = "isim")
    private String         name;
    private String         surname;
    private int            height;
    private int            weight;

    @Embedded
    private EmployeeDetail employeeDetail;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "employee")
    private Address        address;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "employee")
    private List<Phone>    phones;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(final int heightParam) {
        this.height = heightParam;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(final int weightParam) {
        this.weight = weightParam;
    }

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(final Long employeeIdParam) {
        this.employeeId = employeeIdParam;
    }

    public EmployeeDetail getEmployeeDetail() {
        return this.employeeDetail;
    }

    public void setEmployeeDetail(final EmployeeDetail employeeDetailParam) {
        this.employeeDetail = employeeDetailParam;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(final Address addressParam) {
        this.address = addressParam;
    }

    public List<Phone> getPhones() {
        return this.phones;
    }

    public void setPhones(final List<Phone> phonesParam) {
        this.phones = phonesParam;
    }


}