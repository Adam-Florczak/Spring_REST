package com.github.adamflorczak.model;

import java.util.HashSet;
import java.util.Set;

public class RentCreateDTO {


    private Set<Long> books = new HashSet<>();

    public RentCreateDTO() {
    }

    public RentCreateDTO(Set<Long> books) {
        this.books = books;
    }

    public Set<Long> getBooks() {
        return books;
    }

    public void setBooks(Set<Long> books) {
        this.books = books;
    }
}
