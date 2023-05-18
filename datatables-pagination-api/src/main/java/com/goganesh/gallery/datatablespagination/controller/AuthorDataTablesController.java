package com.goganesh.gallery.datatablespagination.controller;

import com.goganesh.gallery.datatablespagination.service.SimplePaginator;
import com.goganesh.gallery.datatablespagination.service.TablePaginator;
import com.goganesh.gallery.datatablespagination.model.PaginationCriteria;
import com.goganesh.gallery.datatablespagination.model.TablePage;
import com.goganesh.gallery.datatablespagination.service.AuthorDataTablesService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAnyRole('TYPE_ADMIN')")
public class AuthorDataTablesController {

    private final TablePaginator paginator;

    public AuthorDataTablesController(AuthorDataTablesService authorDataTablesService) {
        this.paginator = new SimplePaginator(authorDataTablesService);
    }

    @PostMapping("/api/v1/data-tables/authors")
    public TablePage getAuthors(@RequestBody PaginationCriteria treq) {
        return paginator.getPage(treq);
    }
}
