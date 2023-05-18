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
    private static final String STYLE_TYPE_CODE = "STYLE_TYPE";
    private static final String GENRE_TYPE_CODE = "GENRE_TYPE";

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

        model.addAttribute("authors", authors);
        model.addAttribute("types", findDictionaryByCode(EXHIBIT_TYPE_CODE));
        model.addAttribute("storageConditions", findDictionaryByCode(STORAGE_CONDITION_TYPE_CODE));
        model.addAttribute("styles", findDictionaryByCode(STYLE_TYPE_CODE));
        model.addAttribute("genres", findDictionaryByCode(GENRE_TYPE_CODE));

        return "admin/create_exhibit";
    }

    @GetMapping("/{id}")
    public String updateExhibitPage(@PathVariable("id") UUID id, Model model) {
        Exhibit exhibit = exhibitService.findById(id).orElseThrow(() -> new NotFoundException(Exhibit.class.getSimpleName(), "id", id.toString()));
        List<Author> authors = authorService.findAll();

        model.addAttribute("exhibit", exhibit);
        model.addAttribute("authors", authors);
        model.addAttribute("types", findDictionaryByCode(EXHIBIT_TYPE_CODE));
        model.addAttribute("storageConditions", findDictionaryByCode(STORAGE_CONDITION_TYPE_CODE));
        model.addAttribute("styles", findDictionaryByCode(STYLE_TYPE_CODE));
        model.addAttribute("genres", findDictionaryByCode(GENRE_TYPE_CODE));

        return "admin/update_exhibit";
    }

    @GetMapping("/{id}/places")
    public String exhibitPlacePage(@PathVariable("id") UUID id,
                                   Model model) {
        Exhibit exhibit = exhibitService.findById(id).orElseThrow(() -> new NotFoundException(Exhibit.class.getSimpleName(), "id", id.toString()));

        model.addAttribute("exhibit", exhibit);
        model.addAttribute("places", findDictionaryByCode(PLACE_TYPE_CODE));

        return "admin/place_exhibits";
    }

    @GetMapping("/{id}/documents")
    public String exhibitDocumentsPage(@PathVariable("id") UUID id,
                                       Model model) {
        Exhibit exhibit = exhibitService.findById(id).orElseThrow(() -> new NotFoundException(Exhibit.class.getSimpleName(), "id", id.toString()));

        model.addAttribute("exhibit", exhibit);
        model.addAttribute("types", findDictionaryByCode(ATTACH_TYPE_CODE));

        return "admin/exhibit_document";
    }

    public List<Dictionary> findDictionaryByCode(String code) {
        Dictionary type = dictionaryService.findByCode(code)
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "code", code));
        return dictionaryService.findAllByDictionary(type);
    }

}
