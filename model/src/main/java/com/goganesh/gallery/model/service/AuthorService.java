package com.goganesh.gallery.model.service;

import com.goganesh.gallery.model.domain.Author;
import com.goganesh.gallery.model.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Page<Author> findAll(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }

    public long count() {
        return authorRepository.count();
    }

    public Optional<Author> findById(UUID id) {
        return authorRepository.findById(id);
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }


    public Page<Author> findAllByNameContain(String name, Pageable pageable) {
        return authorRepository.findAllByNameContainingIgnoreCase(name, pageable);
    }
}
