package com.goganesh.gallery.model.repository;

import com.goganesh.gallery.model.domain.Event;
import com.goganesh.gallery.model.domain.EventExhibit;
import com.goganesh.gallery.model.domain.Exhibit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EventExhibitRepository extends JpaRepository<EventExhibit, UUID> {

    Page<EventExhibit> findAllByEvent(Event event, Pageable pageable);

    Optional<EventExhibit> findByEventAndExhibit(Event event, Exhibit exhibit);
}
