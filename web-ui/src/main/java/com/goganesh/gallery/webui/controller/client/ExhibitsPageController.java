package com.goganesh.gallery.webui.controller.client;

import com.goganesh.gallery.model.domain.Exhibit;
import com.goganesh.gallery.model.exception.NotFoundException;
import com.goganesh.gallery.model.service.ExhibitService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/exhibits")
@AllArgsConstructor
public class ExhibitsPageController {

    private final ExhibitService exhibitService;

    @GetMapping
    public String exhibitsPage(Model model,
                               @RequestParam("page") Optional<Integer> page,
                               @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(9);

        Page<Exhibit> exhibits = exhibitService.findAll(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("exhibits", exhibits);

        int totalPages = exhibits.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "client/exhibits";
    }

    @GetMapping("/{id}")
    public String exhibitPage(@PathVariable UUID id,
                              Model model) {
        Exhibit exhibit = exhibitService.findById(id)
                .orElseThrow(() -> new NotFoundException(Exhibit.class.getSimpleName(), "id", id.toString()));

        model.addAttribute("exhibit", exhibit);

        return "client/exhibit";
    }
}
