package com.training.java.stream;


public class EmployeeReduceObject {

    private int          weight;
    private int          height;
    private StringBuffer name    = new StringBuffer();
    private StringBuffer surname = new StringBuffer();


    public static EmployeeReduceObject comb(final EmployeeReduceObject a,
                                            final EmployeeReduceObject b) {
        EmployeeReduceObject sum = new EmployeeReduceObject();
        sum.weight = a.weight + b.weight;
        sum.height = a.height + b.height;
        sum.name.append(a.getName());
        sum.name.append(b.getName());
        sum.surname.append(a.getSurname());
        sum.surname.append(b.getSurname());
        return sum;
    }

    public EmployeeReduceObject acum(final Employee employee) {
        this.weight += employee.getWeight();
        this.height += employee.getHeight();
        this.name.append(employee.getName());
        this.surname.append(employee.getSurname());
        return this;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(final int weightParam) {
        this.weight = weightParam;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(final int heightParam) {
        this.height = heightParam;
    }

    public StringBuffer getName() {
        return this.name;
    }

    public void setName(final StringBuffer nameParam) {
        this.name = nameParam;
    }

    public StringBuffer getSurname() {
        return this.surname;
    }

    public void setSurname(final StringBuffer surnameParam) {
        this.surname = surnameParam;
    }

    @Override
    public String toString() {
        return "EmployeeReduceObject [weight="
               + this.weight
               + ", height="
               + this.height
               + ", name="
               + this.name
               + ", surname="
               + this.surname
               + "]";
    }


}
