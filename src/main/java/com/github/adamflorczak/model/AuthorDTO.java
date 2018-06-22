package com.github.adamflorczak.model;

public class AuthorDTO {

    private String firstName;
    private String lastName;
    private Gender gender;
    private String street;
    private String city;
    private String country;

    public AuthorDTO() {
    }

    public AuthorDTO(Author author) {
        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();
        this.gender = author.getGender();
        this.street = author.getAddress().getStreet();
        this.city = author.getAddress().getCity();
        this.country = author.getAddress().getCountry();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
