package com.goganesh.gallery.model.repository;

import com.goganesh.gallery.model.domain.Exhibit;
import com.goganesh.gallery.model.domain.ExhibitPlace;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface ExhibitPlaceRepository extends JpaRepository<ExhibitPlace, UUID> {
    Page<ExhibitPlace> findAllByExhibit(Exhibit exhibit, Pageable pageable);

    long countAllByExhibit(Exhibit exhibit);

    Optional<ExhibitPlace> findByExhibitAndEndBetween(Exhibit exhibit, LocalDateTime start, LocalDateTime end);
}
