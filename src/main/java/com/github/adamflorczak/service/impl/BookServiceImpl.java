package com.github.adamflorczak.service.impl;

import com.github.adamflorczak.model.Author;
import com.github.adamflorczak.model.Book;
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
        return bookRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Set<Book> findAll() {
        return new HashSet<>(bookRepository.findAll());
    }

    @Override
    public Book createBook(Book book) {
        Optional<Author> optionalAuthor = authorRepository.findByFirstNameAndLastName(book.getAuthor().getFirstName(), book.getAuthor().getLastName());
        if (optionalAuthor.isPresent()){
            Author authorek = optionalAuthor.get();
            book.setAuthor(authorek);
            bookRepository.save(book);
        }
        return bookRepository.save(book);
    }

    @Override
    public void deleteOneById(Long id) {
        bookRepository.deleteById(id);
    }
}
