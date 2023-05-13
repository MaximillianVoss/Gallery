package com.goganesh.gallery.model.repository;

import com.goganesh.gallery.model.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
}
