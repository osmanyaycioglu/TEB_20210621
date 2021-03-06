package com.training.java.stream;


public enum EGender {

    MALE,
    FEMALE;

    public static EGender getGender(final String gender) {
        switch (gender.toLowerCase()) {
            case "male":
                return MALE;
            case "female":
                return FEMALE;
            default:
                return MALE;
        }
    }
}
