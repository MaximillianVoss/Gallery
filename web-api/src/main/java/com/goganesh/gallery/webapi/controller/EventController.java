package com.goganesh.gallery.webapi.controller;

import com.goganesh.gallery.model.domain.Dictionary;
import com.goganesh.gallery.model.domain.Event;
import com.goganesh.gallery.model.domain.EventExhibit;
import com.goganesh.gallery.model.domain.Exhibit;
import com.goganesh.gallery.model.exception.NotFoundException;
import com.goganesh.gallery.model.service.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ValidationException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/api/v1/events")
@PreAuthorize("hasAnyRole('TYPE_ADMIN')")
@AllArgsConstructor
public class EventController {

    private final EventService eventService;
    private final ExhibitService exhibitService;
    private final EventExhibitService eventExhibitService;
    private final DictionaryService dictionaryService;
    private final ImageService imageService;

    @PostMapping(value = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String putEvent(@RequestParam Map<String, String> allParams,
                          @RequestParam("imageFile") MultipartFile file) throws IOException {
        Event event = eventService.findById(UUID.fromString(allParams.get("id")))
                .orElseThrow(() -> new NotFoundException(Event.class.getSimpleName(), "id", allParams.get("id")));
        event.setName(allParams.get("name"));
        event.setDescription(allParams.get("description"));

        event.setStart(LocalDate.parse(allParams.get("start")));
        event.setEnd(LocalDate.parse(allParams.get("end")));

        Dictionary dictionary = dictionaryService.findById(UUID.fromString(allParams.get("typeId")))
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", allParams.get("typeId")));
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
    public String postEvent(@RequestParam Map<String, String> allParams,
                           @RequestParam("imageFile") MultipartFile file) throws IOException {
        Event event = new Event();
        event.setName(allParams.get("name"));
        event.setDescription(allParams.get("description"));

        event.setStart(LocalDate.parse(allParams.get("start")));
        event.setEnd(LocalDate.parse(allParams.get("end")));

        Dictionary dictionary = dictionaryService.findById(UUID.fromString(allParams.get("typeId")))
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", allParams.get("typeId")));
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
}
