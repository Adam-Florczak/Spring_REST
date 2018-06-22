package com.github.adamflorczak.Controller;

import com.github.adamflorczak.model.Book;
import com.github.adamflorczak.model.BookCreateDTO;
import com.github.adamflorczak.model.BookDTO;
import com.github.adamflorczak.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
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
    public BookDTO findById(@PathVariable Long id){
        Book book = bookService.findOneByID(id);
        return new BookDTO(book);
    }

    @GetMapping
    public Set<BookDTO> findAll(){
        Set<BookDTO> result = new HashSet<>();
        Set<Book> allBooks = bookService.findAll();
        allBooks.forEach(b -> result.add(new BookDTO(b)));
        return result;
    }

    @PostMapping
    public BookDTO create(@RequestBody BookCreateDTO newBook){

        return new BookDTO(bookService.createBook(newBook));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteOneById(id);
    }
}
