package com.goganesh.gallery.webui.controller.admin;

import com.goganesh.gallery.model.domain.Author;
import com.goganesh.gallery.model.domain.Dictionary;
import com.goganesh.gallery.model.domain.Exhibit;
import com.goganesh.gallery.model.service.AuthorService;
import com.goganesh.gallery.model.service.DictionaryService;
import com.goganesh.gallery.model.service.ExhibitService;
import com.goganesh.gallery.model.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/exhibits")
@AllArgsConstructor
public class ExhibitAdminPageController {

    private static final String EXHIBIT_TYPE_CODE = "EXH_TYPE";
    private static final String PLACE_TYPE_CODE = "PLACE_TYPE";
    private static final String ATTACH_TYPE_CODE = "EXH_ATTACH_TYPE";
    private static final String STORAGE_CONDITION_TYPE_CODE = "STORAGE_CONDITION_TYPE";

    private final ExhibitService exhibitService;
    private final AuthorService authorService;
    private final DictionaryService dictionaryService;

    @GetMapping
    public String exhibitsPage() {
        return "admin/exhibits.html";
    }

    @GetMapping("/create")
    public String createExhibitPage(Model model) {
        List<Author> authors = authorService.findAll();

        Dictionary type = dictionaryService.findByCode(EXHIBIT_TYPE_CODE)
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "code", EXHIBIT_TYPE_CODE));
        List<Dictionary> types = dictionaryService.findAllByDictionary(type);

        Dictionary storageCondition = dictionaryService.findByCode(STORAGE_CONDITION_TYPE_CODE)
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "code", STORAGE_CONDITION_TYPE_CODE));
        List<Dictionary> storageConditions = dictionaryService.findAllByDictionary(storageCondition);

        model.addAttribute("authors", authors);
        model.addAttribute("types", types);
        model.addAttribute("storageConditions", storageConditions);

        return "admin/create_exhibit";
    }

    @GetMapping("/{id}")
    public String updateExhibitPage(@PathVariable("id") UUID id, Model model) {
        Exhibit exhibit = exhibitService.findById(id).orElseThrow(() -> new NotFoundException(Exhibit.class.getSimpleName(), "id", id.toString()));
        List<Author> authors = authorService.findAll();

        Dictionary type = dictionaryService.findByCode(EXHIBIT_TYPE_CODE)
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "code", EXHIBIT_TYPE_CODE));
        List<Dictionary> types = dictionaryService.findAllByDictionary(type);

        Dictionary storageCondition = dictionaryService.findByCode(STORAGE_CONDITION_TYPE_CODE)
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "code", STORAGE_CONDITION_TYPE_CODE));
        List<Dictionary> storageConditions = dictionaryService.findAllByDictionary(storageCondition);


        model.addAttribute("exhibit", exhibit);
        model.addAttribute("authors", authors);
        model.addAttribute("types", types);
        model.addAttribute("storageConditions", storageConditions);

        return "admin/update_exhibit";
    }

    @GetMapping("/{id}/places")
    public String exhibitPlacePage(@PathVariable("id") UUID id,
                              Model model) {
        Exhibit exhibit = exhibitService.findById(id).orElseThrow(() -> new NotFoundException(Exhibit.class.getSimpleName(), "id", id.toString()));
        Dictionary dictionary = dictionaryService.findByCode(PLACE_TYPE_CODE)
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "code", PLACE_TYPE_CODE));
        List<Dictionary> places = dictionaryService.findAllByDictionary(dictionary);

        model.addAttribute("exhibit", exhibit);
        model.addAttribute("places", places);

        return "admin/place_exhibits";
    }

    @GetMapping("/{id}/documents")
    public String exhibitDocumentsPage(@PathVariable("id") UUID id,
                              Model model) {
        Exhibit exhibit = exhibitService.findById(id).orElseThrow(() -> new NotFoundException(Exhibit.class.getSimpleName(), "id", id.toString()));
        Dictionary attachment = dictionaryService.findByCode(ATTACH_TYPE_CODE)
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "code", ATTACH_TYPE_CODE));
        List<Dictionary> attachments = dictionaryService.findAllByDictionary(attachment);

        model.addAttribute("exhibit", exhibit);
        model.addAttribute("types", attachments);

        return "admin/exhibit_document";
    }
}
