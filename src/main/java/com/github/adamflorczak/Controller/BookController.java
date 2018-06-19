package com.github.adamflorczak.Controller;

import com.github.adamflorczak.model.Book;
import com.github.adamflorczak.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/books")
public class BookController {



    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
    this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id){
        return bookService.findOneByID(id);
    }

    @GetMapping // bez mappingu, czyli /api/books i poda książki
    public Set<Book> findAll(){
        return bookService.findAll();
    }

    @PostMapping
    public Book create(@RequestBody Book newBook){

        return bookService.createBook(newBook);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteOneById(id);
    }
}
