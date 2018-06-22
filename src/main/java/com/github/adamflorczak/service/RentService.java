package com.github.adamflorczak.service;

import com.github.adamflorczak.model.Rent;
import com.github.adamflorczak.model.RentCreateDTO;
import com.github.adamflorczak.model.RentDTO;

import java.util.Set;

public interface RentService {

    Rent findOneById(Long id);

    Set<Rent> findAll();

    RentDTO rentBook(RentCreateDTO rentDTO);

    void deleteOneById(Long id);
}
