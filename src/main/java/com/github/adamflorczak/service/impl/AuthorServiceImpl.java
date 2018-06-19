package com.github.adamflorczak.service.impl;

import com.github.adamflorczak.model.Author;
import com.github.adamflorczak.repository.AuthorRepository;
import com.github.adamflorczak.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author findOneById(Long id) {
        return authorRepository.findById(id).orElseThrow(RuntimeException::new);
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
        return Optional.ofNullable(authorRepository.findByFirstNameAndLastName(firstName, lastName)).orElseThrow(null);
    }
}
