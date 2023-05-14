package com.goganesh.gallery.webui.controller.client;

import com.goganesh.gallery.model.domain.Event;
import com.goganesh.gallery.model.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/events")
@AllArgsConstructor
public class EventsPageController {

    private final EventService eventService;

    @GetMapping
    public String eventsPage(Model model) {
        PageRequest pageRequest = PageRequest.of(0, 20);
        List<Event> events = eventService.findAll(pageRequest).getContent();

        model.addAttribute("events", events);

        return "client/events";
    }
}
