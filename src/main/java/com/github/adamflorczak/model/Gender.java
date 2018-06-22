package com.github.adamflorczak.model;

public enum Gender {
    MALE("male"), FEMALE("female");


    public String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "gender='" + gender + '\'' +
                '}';
    }
}
