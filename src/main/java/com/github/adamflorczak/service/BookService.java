package com.github.adamflorczak.service;

import com.github.adamflorczak.model.Book;

import java.util.Set;


// adnotacja @Service nic by tu nie zmieniła, damy ją dopiero na implementacji
public interface BookService {


    Book findOneByID(Long id);
    Set<Book> findAll();
    Book createBook(Book book);
    void deleteOneById(Long id);

}
