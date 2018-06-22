package com.github.adamflorczak.service.impl;

import com.github.adamflorczak.exceptions.ValidationError;
import com.github.adamflorczak.exceptions.ValidationException;
import com.github.adamflorczak.model.Author;
import com.github.adamflorczak.repository.AuthorRepository;
import com.github.adamflorczak.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author findOneById(Long id) {
        return authorRepository.findById(id).orElseThrow(ValidationException::new);
    }

    @Override
    public Set<Author> findAll() {
        return new HashSet<>(authorRepository.findAll());
    }

    @Override
    public Author createAuthor(Author author) {
        Optional<Author> authorBase = findAuthorByFirstNameAndLastName(author.getFirstName(), author.getLastName());
        if(authorBase != null){
            throw new RuntimeException();
        }
        return authorRepository.save(author);

    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Optional<Author> findAuthorByFirstNameAndLastName(String firstName, String lastName) {
        return Optional.ofNullable(authorRepository.findByFirstNameAndLastName(firstName, lastName)).orElse(null);
    }

    private void validate(String firstName, String lastName){
        List<ValidationError> errorList = new ArrayList<>();
        if(firstName == null){
            ValidationError error = new ValidationError("firstName", "May not be null");
            errorList.add(error);
        }
        if(lastName == null){
            ValidationError error = new ValidationError("lastName", "May not be null");
            errorList.add(error);
        }

    }
}
