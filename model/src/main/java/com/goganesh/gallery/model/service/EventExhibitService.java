package com.goganesh.gallery.model.service;

import com.goganesh.gallery.model.domain.Event;
import com.goganesh.gallery.model.domain.EventExhibit;
import com.goganesh.gallery.model.domain.Exhibit;
import com.goganesh.gallery.model.repository.EventExhibitRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class EventExhibitService {

    private final EventExhibitRepository eventExhibitRepository;

    public Page<EventExhibit> findAllByEvent(Event event, Pageable pageable) {
        return eventExhibitRepository.findAllByEvent(event, pageable);
    }

    public Optional<EventExhibit> findByEventAndExhibit(Event event, Exhibit exhibit) {
        return eventExhibitRepository.findByEventAndExhibit(event, exhibit);
    }

    public void delete(EventExhibit eventExhibit) {
        eventExhibitRepository.delete(eventExhibit);
    }

    public EventExhibit save(EventExhibit eventExhibit) {
        return eventExhibitRepository.save(eventExhibit);
    }

    @Deprecated
    public List<EventExhibit> findAll() {
        return eventExhibitRepository.findAll();
    }
}
