package com.github.adamflorczak.repository;

import com.github.adamflorczak.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, Long> {
}
