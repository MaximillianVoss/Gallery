package com.goganesh.gallery.webui.controller.client;

import com.goganesh.gallery.model.domain.Dictionary;
import com.goganesh.gallery.model.domain.Event;
import com.goganesh.gallery.model.domain.Exhibit;
import com.goganesh.gallery.model.exception.NotFoundException;
import com.goganesh.gallery.model.model.RecommendRequest;
import com.goganesh.gallery.model.service.DictionaryService;
import com.goganesh.gallery.model.service.EventService;
import com.goganesh.gallery.model.service.ExhibitService;
import com.goganesh.gallery.model.service.RecommendService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.goganesh.gallery.model.service.DictionaryService.*;

@Controller
@RequestMapping("/events")
@AllArgsConstructor
public class EventsPageController {

    private final EventService eventService;
    private final ExhibitService exhibitService;
    private final DictionaryService dictionaryService;
    private final RecommendService recommendService;

    @GetMapping
    public String eventsPage(Model model) {
        PageRequest pageRequest = PageRequest.of(0, 20);
        List<Event> events = eventService.findAll(pageRequest).getContent();
        Map<Event, Long> eventCount = eventService.findAllEventCount();

        model.addAttribute("events", events);
        model.addAttribute("eventCount", eventCount);

        return "client/events";
    }

    @GetMapping("/recommendForm")
    public String getRecommendFormPage(Model model) {
        model.addAttribute("styles", dictionaryService.findAllByParenCode(STYLE_TYPE_CODE));
        model.addAttribute("genres", dictionaryService.findAllByParenCode(GENRE_TYPE_CODE));
        model.addAttribute("edus", dictionaryService.findAllByParenCode(EDU_TYPE_CODE));
        model.addAttribute("sexs", dictionaryService.findAllByParenCode(SEX_TYPE_CODE));

        return "client/events_recommend_form";
    }

    @PostMapping(value = "/recommendForm", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView handleEventsRecommend(@RequestParam Map<String,String> allParams,
                                              RedirectAttributes attributes) {
        List<Event> events = recommendService.findRecommendEventsByRequest(toModel(allParams));
        attributes.addAttribute("ids", events);
        return new RedirectView("/events/recommend");
    }

    @GetMapping("/recommend")
    public String getEventsRecommend(@RequestParam List<UUID> ids,
                                     Model model) {
        List<Event> events = eventService.findAllByIds(ids);
        Map<Event, Long> eventCount = eventService.findAllEventCount();

        model.addAttribute("events", events);
        model.addAttribute("eventCount", eventCount);

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

    private RecommendRequest toModel(Map<String, String> dto) {
        return RecommendRequest.builder()
                .age(Long.valueOf(dto.get("age")))
                .education(dictionaryService.findById(UUID.fromString(dto.get("eduId")))
                        .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", dto.get("eduId"))))
                .genre(dictionaryService.findById(UUID.fromString(dto.get("genreId")))
                        .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", dto.get("eduId"))))
                .sex(dictionaryService.findById(UUID.fromString(dto.get("sexId")))
                        .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", dto.get("eduId"))))
                .style(dictionaryService.findById(UUID.fromString(dto.get("styleId")))
                        .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", dto.get("eduId"))))
                .build();
    }
}
