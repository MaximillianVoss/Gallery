package com.goganesh.gallery.webapi.controller;

import com.goganesh.gallery.model.domain.Dictionary;
import com.goganesh.gallery.model.domain.Event;
import com.goganesh.gallery.model.domain.EventExhibit;
import com.goganesh.gallery.model.domain.Exhibit;
import com.goganesh.gallery.model.exception.NotFoundException;
import com.goganesh.gallery.model.service.DictionaryService;
import com.goganesh.gallery.model.service.EventExhibitService;
import com.goganesh.gallery.model.service.EventService;
import com.goganesh.gallery.model.service.ExhibitService;
import com.goganesh.gallery.webapi.dto.PostEventRequest;
import com.goganesh.gallery.webapi.dto.PutEventRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/events")
@PreAuthorize("hasAnyRole('TYPE_ADMIN')")
@AllArgsConstructor
public class EventController {

    private final EventService eventService;
    private final ExhibitService exhibitService;
    private final EventExhibitService eventExhibitService;
    private final DictionaryService dictionaryService;

    @PutMapping
    public Event putEvent(@Valid @RequestBody PutEventRequest putEventRequest) {
        Event event = eventService.findById(putEventRequest.getId())
                .orElseThrow(() -> new NotFoundException(Event.class.getSimpleName(), "id", putEventRequest.getId().toString()));
        event.setName(putEventRequest.getName());
        event.setDescription(putEventRequest.getDescription());

        event.setStart(putEventRequest.getStart());
        event.setEnd(putEventRequest.getEnd());

        Dictionary dictionary = dictionaryService.findById(putEventRequest.getTypeId())
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", putEventRequest.getTypeId().toString()));
        event.setType(dictionary);

        return eventService.save(event);
    }

    @PostMapping
    public Event postEvent(@Valid @RequestBody PostEventRequest postEventRequest) {
        Event event = new Event();
        event.setName(postEventRequest.getName());
        event.setDescription(postEventRequest.getDescription());

        event.setStart(postEventRequest.getStart());
        event.setEnd(postEventRequest.getEnd());

        Dictionary dictionary = dictionaryService.findById(postEventRequest.getTypeId())
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", postEventRequest.getTypeId().toString()));
        event.setType(dictionary);

        return eventService.save(event);
    }

    @DeleteMapping("/{eventId}/exhibits/{exhibitId}")
    public ResponseEntity<Void> deleteEventExhibit(@PathVariable("eventId") UUID eventId,
                                                   @PathVariable("exhibitId") UUID exhibitId) {
        Event event = eventService.findById(eventId)
                .orElseThrow(() -> new NotFoundException(Event.class.getSimpleName(), "id", eventId.toString()));
        Exhibit exhibit = exhibitService.findById(exhibitId)
                .orElseThrow(() -> new NotFoundException(Exhibit.class.getSimpleName(), "id", exhibitId.toString()));

        EventExhibit eventExhibit = eventExhibitService.findByEventAndExhibit(event, exhibit)
                .orElseThrow(() -> new NotFoundException(EventExhibit.class.getSimpleName(), "eventId and exhibitId", eventId.toString() + " and " + exhibitId.toString()));
        eventExhibitService.delete(eventExhibit);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{eventId}/exhibits/{exhibitId}")
    public EventExhibit addEventExhibit(@PathVariable("eventId") UUID eventId,
                                        @PathVariable("exhibitId") UUID exhibitId) {
        Event event = eventService.findById(eventId)
                .orElseThrow(() -> new NotFoundException(Event.class.getSimpleName(), "id", eventId.toString()));
        Exhibit exhibit = exhibitService.findById(exhibitId)
                .orElseThrow(() -> new NotFoundException(Exhibit.class.getSimpleName(), "id", exhibitId.toString()));

        Optional<EventExhibit> eventExhibit = eventExhibitService.findByEventAndExhibit(event, exhibit);
        if (eventExhibit.isPresent()) {
            //todo
            throw new ValidationException();
        }
        EventExhibit createdEventExhibit = new EventExhibit();
        createdEventExhibit.setEvent(event);
        createdEventExhibit.setExhibit(exhibit);
        return eventExhibitService.save(createdEventExhibit);
    }
}
