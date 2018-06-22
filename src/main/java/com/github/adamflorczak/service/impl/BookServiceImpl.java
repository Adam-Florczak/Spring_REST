package com.github.adamflorczak.service.impl;

import com.github.adamflorczak.exceptions.ValidationException;
import com.github.adamflorczak.model.*;
import com.github.adamflorczak.repository.AuthorRepository;
import com.github.adamflorczak.repository.BookRepository;
import com.github.adamflorczak.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;


    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Book findOneByID(Long id) {
        return bookRepository.findById(id).orElseThrow(ValidationException::new);
    }

    @Override
    public Set<Book> findAll() {
        return new HashSet<>(bookRepository.findAll());
    }

    @Override
    public Book createBook(BookCreateDTO book) {
        Optional<Author> optionalAuthor = authorRepository.findByFirstNameAndLastName(
                book.getAuthorDTO().getFirstName(),
                book.getAuthorDTO().getLastName());
        Book bookMap = new Book();
        if (optionalAuthor.isPresent()){
            Author authorMap = optionalAuthor.get();
            bookMap.setTitle(book.getTitle());
            bookMap.setAuthor(authorMap);
            return bookRepository.save(bookMap);
        }
        Address address = new Address(book.getAuthorDTO().getStreet(), book.getAuthorDTO().getCity(), book.getAuthorDTO().getCountry());
        Author author = new Author(book.getAuthorDTO().getFirstName(), book.getAuthorDTO().getLastName(), book.getAuthorDTO().getGender(), address);
        bookMap.setTitle(book.getTitle());
        bookMap.setAuthor(author);
        return bookRepository.save(bookMap);
    }

    @Override
    public void deleteOneById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> findBookByTitle(String title) {
        return bookRepository.findBookByTitle(title);

    }
}
