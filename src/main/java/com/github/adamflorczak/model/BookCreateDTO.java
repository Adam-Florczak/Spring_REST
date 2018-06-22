package com.github.adamflorczak.model;

public class BookCreateDTO {

    private String title;
    private AuthorDTO authorDTO;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }
}
