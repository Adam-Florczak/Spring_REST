package com.github.adamflorczak.service;

import com.github.adamflorczak.model.Author;

import java.util.Optional;
import java.util.Set;

public interface AuthorService {

    Author findOneById(Long id);
    Set<Author> findAll();
    Author createAuthor(Author author);
    void deleteById(Long id);
    Optional<Author> findAuthorByFirstNameAndLastName(String firstName, String lastName);
}
