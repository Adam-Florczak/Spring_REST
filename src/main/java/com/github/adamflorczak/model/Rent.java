package com.github.adamflorczak.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,
                       CascadeType.MERGE})
    @JoinTable(name = "Rent_books",
            joinColumns = { @JoinColumn(name = "rent_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id") })
    private Set<Book> rents = new HashSet<>();
    private LocalDateTime rentTime;
    private LocalDateTime returnTime;


    public Rent() {
    }

    public Rent(Set<Book> rents) {
        this.rents = rents;
        this.rentTime = LocalDateTime.now();
        this.returnTime = LocalDateTime.now().plusMonths(1);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Book> getRents() {
        return rents;
    }

    public void setRents(Set<Book> rents) {
        this.rents = rents;
    }

    public LocalDateTime getRentTime() {
        return rentTime;
    }

    public void setRentTime(LocalDateTime rentTime) {
        this.rentTime = rentTime;
    }

    public LocalDateTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalDateTime returnTime) {
        this.returnTime = returnTime;
    }
}
