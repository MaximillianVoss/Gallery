package com.goganesh.gallery.webui.controller.client;

import com.goganesh.gallery.model.domain.Event;
import com.goganesh.gallery.model.domain.Exhibit;
import com.goganesh.gallery.model.exception.NotFoundException;
import com.goganesh.gallery.model.service.EventService;
import com.goganesh.gallery.model.service.ExhibitService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/recommend")
    public String eventsRecommendPage() {
        return "client/events_recommend_form";
    }

    @PostMapping(value = "/recommend", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String getEventsRecommend(@RequestParam MultiValueMap<String,String> paramMap) {

        return "client/events_recommend";
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
