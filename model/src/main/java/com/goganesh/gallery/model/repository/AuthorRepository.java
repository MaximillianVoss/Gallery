package com.goganesh.gallery.model.repository;

import com.goganesh.gallery.model.domain.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {

    Page<Author> findAllByNameContainingIgnoreCase(String name, Pageable pageable);

    long countAllByNameContainingIgnoreCase(String name);
}
