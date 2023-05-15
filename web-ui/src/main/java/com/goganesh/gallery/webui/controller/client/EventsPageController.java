package com.goganesh.gallery.webui.controller.client;

import com.goganesh.gallery.model.domain.Event;
import com.goganesh.gallery.model.domain.Exhibit;
import com.goganesh.gallery.model.exception.NotFoundException;
import com.goganesh.gallery.model.service.EventService;
import com.goganesh.gallery.model.service.ExhibitService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/events")
@AllArgsConstructor
public class EventsPageController {

    private final EventService eventService;
    private final ExhibitService exhibitService;

    @GetMapping
    public String eventsPage(Model model) {
        PageRequest pageRequest = PageRequest.of(0, 20);
        List<Event> events = eventService.findAll(pageRequest).getContent();
        Map<Event, Long> eventCount = eventService.findAllEventCount();

        model.addAttribute("events", events);
        model.addAttribute("eventCount", eventCount);

        return "client/events";
    }

    @GetMapping("/{id}")
    public String eventPage(@PathVariable UUID id,
                            Model model) {
        Event event = eventService.findById(id)
                .orElseThrow(() -> new NotFoundException(Event.class.getSimpleName(), "id", id.toString()));
        List<Exhibit> exhibits = exhibitService.findAllByEvent(event);

        model.addAttribute("event", event);
        model.addAttribute("exhibits", exhibits);

        return "client/event";
    }
}
