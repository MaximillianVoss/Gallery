package com.goganesh.gallery.webapi.controller;

import com.goganesh.gallery.model.domain.Author;
import com.goganesh.gallery.model.domain.Dictionary;
import com.goganesh.gallery.model.domain.Exhibit;
import com.goganesh.gallery.model.domain.ExhibitPlace;
import com.goganesh.gallery.model.exception.NotFoundException;
import com.goganesh.gallery.model.service.*;
import com.goganesh.gallery.webapi.dto.PostExhibitPlaceRequest;
import com.goganesh.gallery.webapi.dto.PostExhibitRequest;
import com.goganesh.gallery.webapi.dto.PutExhibitRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping("/api/v1/exhibits")
@PreAuthorize("hasAnyRole('TYPE_ADMIN')")
@AllArgsConstructor
@Validated
public class ExhibitController {

    private final ExhibitService exhibitService;
    private final AuthorService authorService;
    private final DictionaryService dictionaryService;
    private final ExhibitPlaceService exhibitPlaceService;
    private final ImageService imageService;

    @PostMapping(value = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String putExhibit(@Valid PutExhibitRequest putExhibitRequest,
                             @RequestParam("imageFile") MultipartFile file) throws IOException {
        Exhibit exhibit = exhibitService.findById(putExhibitRequest.getId())
                .orElseThrow(() -> new NotFoundException(Exhibit.class.getSimpleName(), "id", putExhibitRequest.getId().toString()));

        exhibit.setName(putExhibitRequest.getName());
        exhibit.setYear(putExhibitRequest.getYear());
        exhibit.setLength(putExhibitRequest.getLength());
        exhibit.setWidth(putExhibitRequest.getWidth());

        Author author = authorService.findById(putExhibitRequest.getAuthorId())
                .orElseThrow(() -> new NotFoundException(Author.class.getSimpleName(), "id", putExhibitRequest.getAuthorId().toString()));
        exhibit.setAuthor(author);

        Dictionary type = dictionaryService.findById(putExhibitRequest.getTypeId())
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", putExhibitRequest.getTypeId().toString()));
        exhibit.setType(type);

        Dictionary storageCondition = dictionaryService.findById(putExhibitRequest.getStorageConditionId())
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", putExhibitRequest.getStorageConditionId().toString()));
        exhibit.setStorageCondition(storageCondition);

        Dictionary style = dictionaryService.findById(putExhibitRequest.getStyleId())
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", putExhibitRequest.getStyleId().toString()));
        exhibit.setStyle(style);

        Dictionary genre = dictionaryService.findById(putExhibitRequest.getGenreId())
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", putExhibitRequest.getGenreId().toString()));
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
    public String postExhibit(@Valid PostExhibitRequest postExhibitRequest,
                              @RequestParam("imageFile") MultipartFile file) throws IOException {
        Exhibit exhibit = new Exhibit();

        exhibit.setName(postExhibitRequest.getName());
        exhibit.setYear(postExhibitRequest.getYear());
        exhibit.setLength(postExhibitRequest.getLength());
        exhibit.setWidth(postExhibitRequest.getWidth());

        Author author = authorService.findById(postExhibitRequest.getAuthorId())
                .orElseThrow(() -> new NotFoundException(Author.class.getSimpleName(), "id", postExhibitRequest.getAuthorId().toString()));
        exhibit.setAuthor(author);

        Dictionary type = dictionaryService.findById(postExhibitRequest.getTypeId())
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", postExhibitRequest.getTypeId().toString()));
        exhibit.setType(type);

        Dictionary storageCondition = dictionaryService.findById(postExhibitRequest.getStorageConditionId())
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", postExhibitRequest.getStorageConditionId().toString()));
        exhibit.setStorageCondition(storageCondition);

        Dictionary style = dictionaryService.findById(postExhibitRequest.getStyleId())
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", postExhibitRequest.getStyleId().toString()));
        exhibit.setStyle(style);

        Dictionary genre = dictionaryService.findById(postExhibitRequest.getGenreId())
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", postExhibitRequest.getGenreId().toString()));
        exhibit.setGenre(genre);

        exhibitService.create(exhibit);

        String imagePath = imageService.save(exhibit, file.getInputStream(), file.getOriginalFilename());
        exhibit.setImage(imagePath);
        exhibitService.update(exhibit);

        return "redirect:/admin/exhibits";

    }

    @PostMapping("/{id}/places")
    public String postExhibitPlace(@PathVariable UUID id,
                                   @Valid PostExhibitPlaceRequest exhibitPlaceRequest) {
        Exhibit exhibit = exhibitService.findById(id).orElseThrow(() -> new NotFoundException(Exhibit.class.getSimpleName(), "id", id.toString()));
        Dictionary dictionary = dictionaryService.findById(exhibitPlaceRequest.getPlaceId())
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", exhibitPlaceRequest.getPlaceId().toString()));

        ExhibitPlace exhibitPlace = new ExhibitPlace();
        exhibitPlace.setExhibit(exhibit);
        exhibitPlace.setPlace(dictionary);
        exhibitPlace.setComment(exhibitPlaceRequest.getComment());

        exhibitPlaceService.save(exhibitPlace);

        return "redirect:/admin/exhibits/" + exhibit.getId() + "/places";
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteExhibit(@PathVariable UUID id) {
        Exhibit exhibit = exhibitService.findById(id)
                .orElseThrow(() -> new NotFoundException(Exhibit.class.getSimpleName(), "id", id.toString()));
        exhibitService.delete(exhibit);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
