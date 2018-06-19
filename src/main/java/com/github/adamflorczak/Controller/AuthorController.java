package com.github.adamflorczak.Controller;

import com.github.adamflorczak.model.Author;
import com.github.adamflorczak.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id){
        return authorService.findOneById(id);
    }

    @GetMapping
    public Set<Author> getAllAuthors(){
        return authorService.findAll();
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author){
        return authorService.createAuthor(author);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        authorService.deleteById(id);
    }
}
