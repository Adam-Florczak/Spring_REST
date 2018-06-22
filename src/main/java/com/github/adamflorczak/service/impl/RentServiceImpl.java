package com.github.adamflorczak.service.impl;

import com.github.adamflorczak.exceptions.ValidationException;
import com.github.adamflorczak.model.*;
import com.github.adamflorczak.repository.BookRepository;
import com.github.adamflorczak.repository.RentRepository;
import com.github.adamflorczak.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RentServiceImpl implements RentService {


    private RentRepository rentRepository;
    private BookRepository bookRepository;

    @Autowired
    public RentServiceImpl(RentRepository rentRepository, BookRepository bookRepository) {
        this.rentRepository = rentRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Rent findOneById(Long id) {
        return rentRepository.findById(id).orElseThrow(ValidationException::new);
    }

    @Override
    public Set<Rent> findAll() {
        return new HashSet<>(rentRepository.findAll());
    }

    @Override
    public RentDTO rentBook(RentCreateDTO rentDTO) {
        Rent rent = new Rent();
        Set<Book> books = rentDTO.getBooks().stream()
                                 .map(id -> bookRepository.findById(id).orElseThrow(ValidationException::new))
                                 .collect(Collectors.toSet());
        rent.setRents(books);
        rentRepository.save(rent);
        return new RentDTO(rent);

    }

    @Override
    public void deleteOneById(Long id) {
        rentRepository.deleteById(id);
    }
}
