package com.github.adamflorczak.service;

import com.github.adamflorczak.model.Book;
import com.github.adamflorczak.model.BookCreateDTO;

import java.util.Optional;
import java.util.Set;


// adnotacja @Service nic by tu nie zmieniła, damy ją dopiero na implementacji
public interface BookService {


    Book findOneByID(Long id);
    Optional<Book> findBookByTitle(String book);
    Set<Book> findAll();
    Book createBook(BookCreateDTO book);
    void deleteOneById(Long id);

}
