package com.goganesh.gallery.model.service;

import com.goganesh.gallery.model.domain.Event;
import com.goganesh.gallery.model.model.EventRecommendRate;
import com.goganesh.gallery.model.model.RecommendRequest;
import com.goganesh.gallery.model.repository.EventRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RecommendService {

    private final EventRepository eventRepository;

    public List<Event> findRecommendEventsByRequest(RecommendRequest recommendRequest) {
        return eventRepository.findRecommendEventsByRequest(recommendRequest)
                .stream()
                .map(EventRecommendRate::getEvent)
                .collect(Collectors.toList());
    }
}
