package com.training.java.collections;


public class Employee {

    private String  name;
    private String  surname;
    private EGender gender;
    private int     height;
    private int     weight;


    public Employee() {
    }


    public Employee(final String nameParam,
                    final String surnameParam,
                    final EGender genderParam,
                    final int heightParam,
                    final int weightParam) {
        super();
        this.name = nameParam;
        this.surname = surnameParam;
        this.gender = genderParam;
        this.height = heightParam;
        this.weight = weightParam;
    }


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

    public EGender getGender() {
        return this.gender;
    }

    public void setGender(final EGender genderParam) {
        this.gender = genderParam;
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


    @Override
    public String toString() {
        return "Employee [name="
               + this.name
               + ", surname="
               + this.surname
               + ", gender="
               + this.gender
               + ", height="
               + this.height
               + ", weight="
               + this.weight
               + "]";
    }


}
