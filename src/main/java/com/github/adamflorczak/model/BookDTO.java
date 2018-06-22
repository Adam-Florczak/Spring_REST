package com.github.adamflorczak.model;


public class BookDTO {

    private Long id;
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private Gender gender;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.authorFirstName = book.getAuthor().getFirstName();
        this.authorLastName = book.getAuthor().getLastName();
        this.gender = book.getAuthor().getGender();
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


}
