package com.goganesh.gallery.webui.controller.admin;

import com.goganesh.gallery.model.domain.Dictionary;
import com.goganesh.gallery.model.domain.Event;
import com.goganesh.gallery.model.service.DictionaryService;
import com.goganesh.gallery.model.exception.NotFoundException;
import com.goganesh.gallery.model.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/events")
@AllArgsConstructor
public class EventAdminPageController {

    private static final String EVENT_TYPE_CODE = "EVENT_TYPE";

    private final EventService eventService;
    private final DictionaryService dictionaryService;

    @GetMapping
    public String exhibitsPage() {
        return "admin/events.html";
    }


    @GetMapping("/create")
    public String exhibitPage(Model model) {

        Dictionary dictionary = dictionaryService.findByCode(EVENT_TYPE_CODE)
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "code", EVENT_TYPE_CODE));
        List<Dictionary> dictionaries = dictionaryService.findAllByDictionary(dictionary);

        model.addAttribute("types", dictionaries);

        return "admin/create_event";
    }

    @GetMapping("/{id}")
    public String exhibitPage(@PathVariable("id") UUID id, Model model) {
        Event event = eventService.findById(id)
                .orElseThrow(() -> new NotFoundException(Event.class.getSimpleName(), "id", id.toString()));


        Dictionary dictionary = dictionaryService.findByCode(EVENT_TYPE_CODE)
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "code", EVENT_TYPE_CODE));
        List<Dictionary> dictionaries = dictionaryService.findAllByDictionary(dictionary);

        model.addAttribute("event", event);
        model.addAttribute("types", dictionaries);

        return "admin/update_event";
    }

    @GetMapping("/{id}/exhibits")
    public String eventExhibitsPage(@PathVariable("id") UUID id, Model model) {
        Event event = eventService.findById(id)
                .orElseThrow(() -> new NotFoundException(Event.class.getSimpleName(), "id", id.toString()));

        model.addAttribute("event", event);

        return "admin/event_exhibits";
    }
}
