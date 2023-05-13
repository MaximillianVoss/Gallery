package com.goganesh.gallery.model.repository;

import com.goganesh.gallery.model.domain.Exhibit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExhibitRepository extends JpaRepository<Exhibit, UUID> {

    Page<Exhibit> findAllByNameContaining(String name, Pageable pageable);
}
