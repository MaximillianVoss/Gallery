package com.goganesh.gallery.webapi.controller;

import com.goganesh.gallery.model.domain.Author;
import com.goganesh.gallery.model.exception.NotFoundException;
import com.goganesh.gallery.model.service.AuthorService;
import com.goganesh.gallery.webapi.dto.PutAuthorRequest;
import com.goganesh.gallery.webapi.dto.PostAuthorRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/api/v1/authors")
@PreAuthorize("hasAnyRole('TYPE_ADMIN')")
@AllArgsConstructor
@Validated
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String putAuthor(PutAuthorRequest putAuthorRequest) {
        Author author = authorService.findById(putAuthorRequest.getId())
                .orElseThrow(() -> new NotFoundException(Author.class.getSimpleName(), "id", putAuthorRequest.getId().toString()));
        author.setName(putAuthorRequest.getName());

        authorService.save(author);

        return "redirect:/admin/authors";
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postAuthor(PostAuthorRequest postAuthorRequest) {
        Author author = new Author();
        author.setName(postAuthorRequest.getName());

        authorService.save(author);

        return "redirect:/admin/authors";
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable UUID id) {
        Author author = authorService.findById(id)
                .orElseThrow(() -> new NotFoundException(Author.class.getSimpleName(), "id", id.toString()));
        authorService.delete(author);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
