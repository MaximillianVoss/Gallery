package com.goganesh.gallery.webui.controller.admin;

import com.goganesh.gallery.model.domain.Author;
import com.goganesh.gallery.model.service.AuthorService;
import com.goganesh.gallery.model.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/admin/authors")
@AllArgsConstructor
public class AuthorAdminPageController {

    private final AuthorService authorService;

    @GetMapping
    public String authorsPage() {
        return "admin/authors.html";
    }

    @GetMapping("/create")
    public String createAuthorPage() {
        return "admin/create_author";
    }

    @GetMapping("/{id}")
    public String updateAuthorPage(@PathVariable("id") UUID id, Model model) {
        Author author = authorService.findById(id).orElseThrow(() -> new NotFoundException(Author.class.getSimpleName(), "id", id.toString()));

        model.addAttribute("author", author);

        return "admin/update_author";
    }
}
