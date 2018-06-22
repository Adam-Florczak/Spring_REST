package com.github.adamflorczak.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RentDTO {

    private Long id;
    private Set<BookDTO> rents = new HashSet<>();
    private LocalDateTime rentTime;
    private LocalDateTime returnTime;

    public RentDTO() {
    }

    public RentDTO(Rent rent) {
        this.id = rent.getId();
        this.rents = rent.getRents().stream()
                                    .map(BookDTO::new)
                                    .collect(Collectors.toSet());
        this.rentTime = rent.getRentTime();
        this.returnTime = rent.getReturnTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<BookDTO> getRents() {
        return rents;
    }


    public void setRents(Set<BookDTO> rents) {
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
