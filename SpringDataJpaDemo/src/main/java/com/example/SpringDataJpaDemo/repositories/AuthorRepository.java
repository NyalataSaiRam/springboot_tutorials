package com.example.SpringDataJpaDemo.repositories;

import com.example.SpringDataJpaDemo.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
