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

import java.util.UUID;

@Controller
@RequestMapping("/exhibits")
@AllArgsConstructor
public class ExhibitsPageController {

    private final ExhibitService exhibitService;

    @GetMapping
    public String exhibitsPage(Model model) {
        PageRequest pageRequest = PageRequest.of(0, 20);
        Page<Exhibit> exhibits = exhibitService.findAll(pageRequest);

        model.addAttribute("exhibits", exhibits.getContent());

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
