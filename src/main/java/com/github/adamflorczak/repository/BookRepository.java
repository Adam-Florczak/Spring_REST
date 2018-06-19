package com.github.adamflorczak.repository;

import com.github.adamflorczak.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
