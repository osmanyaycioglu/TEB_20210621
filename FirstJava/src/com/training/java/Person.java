package com.training.java;

public class Person {

    private int value;


    public int getValue() {
        return this.value;
    }

    public void setValue(final int valueParam) {
        if (valueParam > 0) {
            this.value = valueParam;
        } else {
            throw new IllegalArgumentException("Negatif olamaz");
        }
    }

    public void setValue2(final int valueParam) throws UserExp {
        if (valueParam > 0) {
            this.value = valueParam;
        } else {
            throw new UserExp("Negatif olamaz");
        }
    }

    @Override
    public String toString() {
        return "Person [value=" + this.value + "]";
    }


}
