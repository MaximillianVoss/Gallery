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
import com.goganesh.gallery.webui.dto.RecommendRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.goganesh.gallery.model.service.DictionaryService.*;

@Controller
@RequestMapping("/events")
@AllArgsConstructor
@Validated
public class EventsPageController {

    private final EventService eventService;
    private final ExhibitService exhibitService;
    private final DictionaryService dictionaryService;
    private final RecommendService recommendService;

    @GetMapping
    public String eventsPage(Model model,
                             @RequestParam("page") Optional<Integer> page,
                             @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(9);

        Page<Event> events = eventService.findAll(PageRequest.of(currentPage - 1, pageSize));
        Map<Event, Long> eventCount = eventService.findAllEventCount();

        model.addAttribute("events", events);
        model.addAttribute("eventCount", eventCount);

        int totalPages = events.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

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
    public RedirectView handleEventsRecommend(RecommendRequestDto requestDto,
                                              RedirectAttributes attributes) {
        List<Event> events = recommendService.findRecommendEventsByRequest(toModel(requestDto));
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

    private RecommendRequest toModel(RecommendRequestDto dto) {
        return RecommendRequest.builder()
                .age(dto.getAge())
                .education(dictionaryService.findById(dto.getEduId())
                        .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", dto.getEduId().toString())))
                .genre(dictionaryService.findById(dto.getGenreId())
                        .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", dto.getGenreId().toString())))
                .sex(dictionaryService.findById(dto.getSexId())
                        .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", dto.getSexId().toString())))
                .style(dictionaryService.findById(dto.getStyleId())
                        .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", dto.getStyleId().toString())))
                .build();
    }
}
