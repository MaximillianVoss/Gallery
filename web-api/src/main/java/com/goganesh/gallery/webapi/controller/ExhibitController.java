package com.goganesh.gallery.webapi.controller;

import com.goganesh.gallery.model.domain.Author;
import com.goganesh.gallery.model.domain.Dictionary;
import com.goganesh.gallery.model.domain.Exhibit;
import com.goganesh.gallery.model.domain.ExhibitPlace;
import com.goganesh.gallery.model.exception.NotFoundException;
import com.goganesh.gallery.model.service.AuthorService;
import com.goganesh.gallery.model.service.DictionaryService;
import com.goganesh.gallery.model.service.ExhibitPlaceService;
import com.goganesh.gallery.model.service.ExhibitService;
import com.goganesh.gallery.webapi.dto.PostExhibitPlaceRequest;
import com.goganesh.gallery.webapi.dto.PutExhibitRequest;
import com.goganesh.gallery.webapi.dto.PostExhibitRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/exhibits")
@PreAuthorize("hasAnyRole('TYPE_ADMIN')")
@AllArgsConstructor
public class ExhibitController {

    private final ExhibitService exhibitService;
    private final AuthorService authorService;
    private final DictionaryService dictionaryService;
    private final ExhibitPlaceService exhibitPlaceService;

    @PutMapping
    public Exhibit putExhibit(@Valid @RequestBody PutExhibitRequest putExhibitRequest) {
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
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", putExhibitRequest.getTypeId().toString()));
        exhibit.setStorageCondition(storageCondition);

        return exhibitService.update(exhibit);
    }

    @PostMapping
    public Exhibit postExhibit(@Valid @RequestBody PostExhibitRequest postExhibitRequest) {
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
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", postExhibitRequest.getTypeId().toString()));
        exhibit.setStorageCondition(storageCondition);

        return exhibitService.create(exhibit);
    }

    @PostMapping("/{id}/places")
    public ExhibitPlace postExhibitPlace(@PathVariable UUID id,
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
