package com.goganesh.gallery.webapi.controller;

import com.goganesh.gallery.model.domain.Author;
import com.goganesh.gallery.model.exception.NotFoundException;
import com.goganesh.gallery.model.service.AuthorService;
import com.goganesh.gallery.webapi.dto.PutAuthorRequest;
import com.goganesh.gallery.webapi.dto.PostAuthorRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/authors")
@PreAuthorize("hasAnyRole('TYPE_ADMIN')")
@AllArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PutMapping
    public Author putAuthor(@Valid @RequestBody PutAuthorRequest putAuthorRequest) {
        Author author = authorService.findById(putAuthorRequest.getId())
                .orElseThrow(() -> new NotFoundException(Author.class.getSimpleName(), "id", putAuthorRequest.getId().toString()));
        author.setName(putAuthorRequest.getName());

        return authorService.save(author);
    }

    @PostMapping
    public Author postExhibit(@Valid @RequestBody PostAuthorRequest postAuthorRequest) {
        Author author = new Author();
        author.setName(postAuthorRequest.getName());

        return authorService.save(author);
    }
}
