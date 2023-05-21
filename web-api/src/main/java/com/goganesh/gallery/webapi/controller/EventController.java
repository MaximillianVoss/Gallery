package com.goganesh.gallery.webapi.controller;

import com.goganesh.gallery.model.domain.Dictionary;
import com.goganesh.gallery.model.domain.Event;
import com.goganesh.gallery.model.domain.EventExhibit;
import com.goganesh.gallery.model.domain.Exhibit;
import com.goganesh.gallery.model.exception.NotFoundException;
import com.goganesh.gallery.model.service.*;
import com.goganesh.gallery.webapi.dto.PostEventRequest;
import com.goganesh.gallery.webapi.dto.PutEventRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/api/v1/events")
@PreAuthorize("hasAnyRole('TYPE_ADMIN')")
@AllArgsConstructor
@Validated
public class EventController {

    private final EventService eventService;
    private final ExhibitService exhibitService;
    private final EventExhibitService eventExhibitService;
    private final DictionaryService dictionaryService;
    private final ImageService imageService;

    @PostMapping(value = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String putEvent(PutEventRequest putEventRequest,
                           @RequestParam("imageFile") MultipartFile file) throws IOException {
        Event event = eventService.findById(putEventRequest.getId())
                .orElseThrow(() -> new NotFoundException(Event.class.getSimpleName(), "id", putEventRequest.getId().toString()));
        event.setName(putEventRequest.getName());
        event.setDescription(putEventRequest.getDescription());

        event.setStart(LocalDate.parse(putEventRequest.getStart()));
        event.setEnd(LocalDate.parse(putEventRequest.getEnd()));

        Dictionary dictionary = dictionaryService.findById(putEventRequest.getTypeId())
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", putEventRequest.getTypeId().toString()));
        event.setType(dictionary);

        if (Objects.nonNull(event.getImage())) {
            imageService.delete(event);
        }

        String imagePath = null;
        if (!file.isEmpty()) {
            imagePath = imageService.save(event, file.getInputStream(), file.getOriginalFilename());
        }
        event.setImage(imagePath);

        eventService.save(event);

        return "redirect:/admin/events";
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String postEvent(PostEventRequest postEventRequest,
                            @NotNull @RequestParam("imageFile") MultipartFile file) throws IOException {
        Event event = new Event();
        event.setName(postEventRequest.getName());
        event.setDescription(postEventRequest.getDescription());

        event.setStart(LocalDate.parse(postEventRequest.getStart()));
        event.setEnd(LocalDate.parse(postEventRequest.getEnd()));

        Dictionary dictionary = dictionaryService.findById(postEventRequest.getTypeId())
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", postEventRequest.getTypeId().toString()));
        event.setType(dictionary);

        event = eventService.save(event);

        String imagePath = imageService.save(event, file.getInputStream(), file.getOriginalFilename());
        event.setImage(imagePath);

        eventService.save(event);

        return "redirect:/admin/events";
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
    public @ResponseBody EventExhibit addEventExhibit(@PathVariable("eventId") UUID eventId,
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

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable UUID id) {
        Event event = eventService.findById(id)
                .orElseThrow(() -> new NotFoundException(Event.class.getSimpleName(), "id", id.toString()));
        eventService.delete(event);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
