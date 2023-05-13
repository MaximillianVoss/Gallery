package com.goganesh.gallery.webapi.controller;

import com.goganesh.gallery.model.domain.Dictionary;
import com.goganesh.gallery.model.domain.Exhibit;
import com.goganesh.gallery.model.domain.ExhibitFile;
import com.goganesh.gallery.model.exception.NotFoundException;
import com.goganesh.gallery.model.service.DictionaryService;
import com.goganesh.gallery.model.service.ExhibitFileService;
import com.goganesh.gallery.model.service.ExhibitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RestController
@AllArgsConstructor
@PreAuthorize("hasAnyRole('TYPE_ADMIN')")
@RequestMapping("/api/v1")
public class FileUploadController {

    private final ExhibitService exhibitService;
    private final DictionaryService dictionaryService;
    private final ExhibitFileService exhibitFileService;

    @PostMapping("/exhibits/{id}/documents")
    public ResponseEntity<Void> postExhibitDocument(@RequestParam("doc") MultipartFile file,
                                                    @RequestParam("type") UUID docId,
                                                    @PathVariable UUID id) throws IOException {
        Exhibit exhibit = exhibitService.findById(id)
                .orElseThrow(() -> new NotFoundException(Exhibit.class.getSimpleName(), "id", id.toString()));
        Dictionary docType = dictionaryService.findById(docId)
                .orElseThrow(() -> new NotFoundException(Dictionary.class.getSimpleName(), "id", docId.toString()));

        InputStream inputStream = file.getInputStream();
        String originalFileName = file.getOriginalFilename();

        exhibitFileService.save(exhibit, docType, originalFileName, inputStream);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/exhibits/{id}/documents/{docId}")
    public ResponseEntity<Void> deleteExhibitDocument(@PathVariable UUID id,
                                                      @PathVariable UUID docId) throws IOException {
        exhibitService.findById(id)
                .orElseThrow(() -> new NotFoundException(Exhibit.class.getSimpleName(), "id", id.toString()));

        ExhibitFile exhibitFile = exhibitFileService.findById(docId)
                .orElseThrow(() -> new NotFoundException(ExhibitFile.class.getSimpleName(), "id", docId.toString()));

        exhibitFileService.delete(exhibitFile);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
