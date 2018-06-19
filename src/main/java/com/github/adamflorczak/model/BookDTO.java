package com.github.adamflorczak.model;

import com.github.adamflorczak.model.Book;

public class BookDTO {

    private Long id;
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private Long authorId;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.authorFirstName = book.getAuthor().getFirstName();
        this.authorLastName = book.getAuthor().getLastName();
        this.authorId = book.getAuthor().getId();
    }

    public BookDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
