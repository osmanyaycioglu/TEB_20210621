package com.training.java;


public class PersonRunner {

    public static void main(final String[] args) {
        Person personLoc = new Person();
        personLoc.setValue(1);
        try {
            personLoc.setValue2(2);
        } catch (UserExp e) {
            e.printStackTrace();
        }
        System.out.println("Person : " + personLoc);
    }

}
