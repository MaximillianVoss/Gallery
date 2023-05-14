package com.goganesh.gallery.webapi.controller;

import com.goganesh.gallery.model.domain.Dictionary;
import com.goganesh.gallery.model.domain.Exhibit;
import com.goganesh.gallery.model.domain.ExhibitFile;
import com.goganesh.gallery.model.exception.NotFoundException;
import com.goganesh.gallery.model.service.DictionaryService;
import com.goganesh.gallery.model.service.ExhibitFileService;
import com.goganesh.gallery.model.service.ExhibitService;
import com.goganesh.gallery.model.service.FileStorageService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RestController
@AllArgsConstructor
//@PreAuthorize("hasAnyRole('TYPE_ADMIN')")
@RequestMapping("/api/v1")
public class FileController {

    private final ExhibitService exhibitService;
    private final DictionaryService dictionaryService;
    private final ExhibitFileService exhibitFileService;
    private final FileStorageService fileStorageService;

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

    @GetMapping(value = "/exhibits/{id}/documents/{docId}")
    public ResponseEntity<InputStreamResource> getExhibitDocument(@PathVariable UUID id,
                                                                  @PathVariable UUID docId) throws IOException {
        exhibitService.findById(id)
                .orElseThrow(() -> new NotFoundException(Exhibit.class.getSimpleName(), "id", id.toString()));

        ExhibitFile exhibitFile = exhibitFileService.findById(docId)
                .orElseThrow(() -> new NotFoundException(ExhibitFile.class.getSimpleName(), "id", docId.toString()));

        File file = fileStorageService.getFileByPath(exhibitFile.getPath());
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(new FileInputStream(file)));
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
