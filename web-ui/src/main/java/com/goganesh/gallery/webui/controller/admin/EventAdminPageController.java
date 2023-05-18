package com.goganesh.gallery.webui.controller.admin;

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

import java.util.UUID;

@Controller
@RequestMapping("/admin/events")
@AllArgsConstructor
public class EventAdminPageController {

    private final EventService eventService;
    private final DictionaryService dictionaryService;

    @GetMapping
    public String exhibitsPage() {
        return "admin/events.html";
    }


    @GetMapping("/create")
    public String exhibitPage(Model model) {
        model.addAttribute("types", dictionaryService.findAllByParenCode(DictionaryService.EVENT_TYPE_CODE));

        return "admin/create_event";
    }

    @GetMapping("/{id}")
    public String exhibitPage(@PathVariable("id") UUID id, Model model) {
        Event event = eventService.findById(id)
                .orElseThrow(() -> new NotFoundException(Event.class.getSimpleName(), "id", id.toString()));

        model.addAttribute("event", event);
        model.addAttribute("types", dictionaryService.findAllByParenCode(DictionaryService.EVENT_TYPE_CODE));

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
