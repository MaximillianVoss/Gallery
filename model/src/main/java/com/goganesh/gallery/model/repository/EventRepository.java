package com.goganesh.gallery.model.repository;

import com.goganesh.gallery.model.domain.Event;
import com.goganesh.gallery.model.model.EventRecommendRate;
import com.goganesh.gallery.model.model.RecommendRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {

    @Query("SELECT new com.goganesh.gallery.model.model.EventRecommendRate(e, COUNT(e.id))  FROM Event AS e GROUP BY e ORDER BY COUNT(e.id) DESC")
    List<EventRecommendRate> findRecommendEventsByRequest(@Param("rr") RecommendRequest recommendRequest);

    List<Event> findAllByIdIn(List<UUID> ids);
}
