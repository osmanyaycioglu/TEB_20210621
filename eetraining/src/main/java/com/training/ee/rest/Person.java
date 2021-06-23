package com.training.ee.rest;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;

import com.training.ee.rest.custom.validation.StartWith;

@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = {})
public class Person {

    @QueryParam("isim")
    //    @XmlElement(name = "isim")
    @NotEmpty(message = "name boş olamaz")
    @Size(min = 2, max = 20, message = "name 2 ile 20 arasında olmalı")
    private String  name;
    @QueryParam("soy")
    @NotEmpty(message = "surname boş olamaz")
    // @StartWith("soy:")
    @StartWith(value = "soy:", message = "surname soy: ile başlamalı")
    private String  surname;
    //    @XmlTransient
    @PathParam("yas")
    @NotNull
    @Max(value = 150, message = "Yaş 150 den büyük olamaz")
    @Min(value = 16, message = "Yaş 16 dan küçük olamaz")
    private Integer age;

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

    public Integer getAge() {
        return this.age;
    }

    public void setAge(final Integer ageParam) {
        this.age = ageParam;
    }

    @Override
    public String toString() {
        return "Person [name=" + this.name + ", surname=" + this.surname + ", age=" + this.age + "]";
    }

}
