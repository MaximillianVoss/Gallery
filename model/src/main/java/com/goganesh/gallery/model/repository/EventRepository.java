package com.goganesh.gallery.model.repository;

import com.goganesh.gallery.model.domain.Event;
import com.goganesh.gallery.model.model.EventRecommendRate;
import com.goganesh.gallery.model.model.RecommendRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {

    @Query("SELECT new com.goganesh.gallery.model.model.EventRecommendRate(e.event, COUNT(e.exhibit.id)) " +
            "FROM EventExhibit AS e " +
            "WHERE e.exhibit.style = :#{#rr.style} OR e.exhibit.genre = :#{#rr.genre} " +
            "GROUP BY e.event " +
            "ORDER BY COUNT(e.exhibit.id) DESC")
    List<EventRecommendRate> findRecommendEventsByRequest(@Param("rr") RecommendRequest recommendRequest);

    List<Event> findAllByIdIn(List<UUID> ids);

    Page<Event> findAllByNameContainingIgnoreCase(String name, Pageable pageable);

    long countAllByNameContainingIgnoreCase(String name);
}
