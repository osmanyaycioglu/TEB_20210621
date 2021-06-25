package com.training.ee.jpa;

import java.io.Serializable;
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
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "calisan")
@NamedQueries({
                @NamedQuery(name = "find_by_name", query = "select e from Employee e where e.name=:abc"),
                @NamedQuery(name = "find_by_name_and_surname",
                            query = "select e from Employee e where e.name=?1 and e.surname=?2")

})
public class Employee implements Serializable {

    private static final long serialVersionUID = 938209481338743360L;
    @Id
    @GeneratedValue
    private Long              employeeId;
    @Column(name = "isim", length = 20)
    //@JsonbProperty("isim")
    private String            name;
    @Size(max = 20)
    private String            surname;
    @Max(300)
    @Min(50)
    private int               height;
    private int               weight;

    @PrePersist
    //@PreUpdate
    public void yazmaOncesi() {
        this.surname = "soy:" + this.surname;
    }

    @PreUpdate
    public void updateOncesi() {
        this.surname = "soy:" + this.surname;
    }

    @PreRemove
    public void preRemove() {

    }

    @PostLoad
    public void aldiktanSonra() {
        this.surname = this.surname.substring(4);
    }

    @PostPersist
    @PostUpdate
    public void posts() {
        this.surname = this.surname.substring(4);
    }

    @PostRemove
    public void postRemove() {

    }

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

    @Override
    public String toString() {
        return "Employee [employeeId="
               + this.employeeId
               + ", name="
               + this.name
               + ", surname="
               + this.surname
               + ", height="
               + this.height
               + ", weight="
               + this.weight
               + ", employeeDetail="
               + this.employeeDetail
               + ", address="
               + this.address
               + ", phones="
               + this.phones
               + "]";
    }


}
