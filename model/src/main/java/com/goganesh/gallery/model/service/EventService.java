package com.goganesh.gallery.model.service;

import com.goganesh.gallery.model.domain.Event;
import com.goganesh.gallery.model.domain.EventExhibit;
import com.goganesh.gallery.model.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final EventExhibitService eventExhibitService;

    public Page<Event> findAll(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }

    public long count() {
        return eventRepository.count();
    }

    public Optional<Event> findById(UUID id) {
        return eventRepository.findById(id);
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public Map<Event, Long> findAllEventCount() {
        return eventExhibitService.findAll()
                .stream()
                .collect(Collectors.groupingBy(EventExhibit::getEvent, Collectors.counting()));
    }

    public List<Event> findAllByIds(List<UUID> ids) {
        return eventRepository.findAllByIdIn(ids);
    }
}
