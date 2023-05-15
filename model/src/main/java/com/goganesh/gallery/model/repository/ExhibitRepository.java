package com.goganesh.gallery.model.repository;

import com.goganesh.gallery.model.domain.Event;
import com.goganesh.gallery.model.domain.Exhibit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ExhibitRepository extends JpaRepository<Exhibit, UUID> {

    Page<Exhibit> findAllByNameContaining(String name, Pageable pageable);

    @Query("select ee.exhibit from EventExhibit ee where ee.event = :ev")
    List<Exhibit> findAllByEvent(@Param("ev") Event event);
}
