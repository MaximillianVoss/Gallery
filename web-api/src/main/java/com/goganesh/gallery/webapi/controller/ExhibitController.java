package com.goganesh.gallery.webapi.controller;

import com.goganesh.gallery.model.domain.Author;
import com.goganesh.gallery.model.domain.Dictionary;
import com.goganesh.gallery.model.domain.Exhibit;
import com.goganesh.gallery.model.domain.ExhibitPlace;
import com.goganesh.gallery.model.exception.NotFoundException;
import com.goganesh.gallery.model.service.*;
import com.goganesh.gallery.webapi.dto.PostExhibitPlaceRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping("/api/v1/exhibits")
@PreAuthorize("hasAnyRole('TYPE_ADMIN')")
@AllArgsConstructor
public class ExhibitController {

    private final ExhibitService exhibitService;
    private final AuthorService authorService;
    private final DictionaryService dictionaryService;
    private final ExhibitPlaceService exhibitPlaceService;
    private final ImageService imageService;

    @PostMapping(value = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String putExhibit(@RequestParam Map<String, String> allParams,
                             @RequestParam("imageFile") MultipartFile file) throws IOException {
        Exhibit exhibit = exhibitService.findById(UUID.fromString(allParams.get("id")))
                .orElseThrow(() -> new NotFoundException(Exhibit.class.getSimpleName(), "id", allParams.get("id")));

        exhibit.setName(allParams.get("name"));
        exhibit.setYear(Integer.valueOf(allParams.get("year")));
        exhibit.setLength(Integer.valueOf(allParams.get("length")));
        exhibit.setWidth(Integer.valueOf(allParams.get("width")));

        Author author = authorService.findById(UUID.fromString(allParams.get("authorId")))
                .orElseThrow(() -> new NotFoundException(Author.class.getSimpleName(), "id", allParams.get("authorId")));
        exhibit.setAuthor(author);

        Dictionary type = dictionaryService.findById(UUID.fromString(allParams.get("typeId")))
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", allParams.get("typeId")));
        exhibit.setType(type);

        Dictionary storageCondition = dictionaryService.findById(UUID.fromString(allParams.get("storageConditionId")))
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", allParams.get("storageConditionId")));
        exhibit.setStorageCondition(storageCondition);

        Dictionary style = dictionaryService.findById(UUID.fromString(allParams.get("styleId")))
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", allParams.get("styleId")));
        exhibit.setStyle(style);

        Dictionary genre = dictionaryService.findById(UUID.fromString(allParams.get("genreId")))
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", allParams.get("genreId")));
        exhibit.setGenre(genre);

        if (Objects.nonNull(exhibit.getImage())) {
            imageService.delete(exhibit);
        }

        String imagePath = null;
        if (!file.isEmpty()) {
            imagePath = imageService.save(exhibit, file.getInputStream(), file.getOriginalFilename());
        }
        exhibit.setImage(imagePath);
        exhibitService.update(exhibit);

        return "redirect:/admin/exhibits";
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String postExhibit(@RequestParam Map<String, String> allParams,
                              @RequestParam("imageFile") MultipartFile file) throws IOException {
        Exhibit exhibit = new Exhibit();

        exhibit.setName(allParams.get("name"));
        exhibit.setYear(Integer.valueOf(allParams.get("year")));
        exhibit.setLength(Integer.valueOf(allParams.get("length")));
        exhibit.setWidth(Integer.valueOf(allParams.get("width")));

        Author author = authorService.findById(UUID.fromString(allParams.get("authorId")))
                .orElseThrow(() -> new NotFoundException(Author.class.getSimpleName(), "id", allParams.get("authorId")));
        exhibit.setAuthor(author);

        Dictionary type = dictionaryService.findById(UUID.fromString(allParams.get("typeId")))
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", allParams.get("typeId")));
        exhibit.setType(type);

        Dictionary storageCondition = dictionaryService.findById(UUID.fromString(allParams.get("storageConditionId")))
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", allParams.get("storageConditionId")));
        exhibit.setStorageCondition(storageCondition);

        Dictionary style = dictionaryService.findById(UUID.fromString(allParams.get("styleId")))
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", allParams.get("styleId")));
        exhibit.setStyle(style);

        Dictionary genre = dictionaryService.findById(UUID.fromString(allParams.get("genreId")))
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", allParams.get("genreId")));
        exhibit.setGenre(genre);

        String imagePath = imageService.save(exhibit, file.getInputStream(), file.getOriginalFilename());
        exhibit.setImage(imagePath);

        exhibitService.create(exhibit);

        return "redirect:/admin/exhibits";

    }

    @PostMapping("/{id}/places")
    public @ResponseBody ExhibitPlace postExhibitPlace(@PathVariable UUID id,
                                         @Valid @RequestBody PostExhibitPlaceRequest exhibitPlaceRequest) {
        Exhibit exhibit = exhibitService.findById(id).orElseThrow(() -> new NotFoundException(Exhibit.class.getSimpleName(), "id", id.toString()));
        Dictionary dictionary = dictionaryService.findById(exhibitPlaceRequest.getPlaceId())
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", exhibitPlaceRequest.getPlaceId().toString()));

        ExhibitPlace exhibitPlace = new ExhibitPlace();
        exhibitPlace.setExhibit(exhibit);
        exhibitPlace.setPlace(dictionary);
        exhibitPlace.setComment(exhibitPlaceRequest.getComment());

        return exhibitPlaceService.save(exhibitPlace);
    }
}
