package com.goganesh.gallery.datatablespagination.controller;

import com.goganesh.gallery.datatablespagination.SimplePaginator;
import com.goganesh.gallery.datatablespagination.TablePaginator;
import com.goganesh.gallery.datatablespagination.model.PaginationCriteria;
import com.goganesh.gallery.datatablespagination.model.TablePage;
import com.goganesh.gallery.datatablespagination.service.ExhibitDataTablesService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAnyRole('TYPE_ADMIN')")
public class ExhibitDataTablesController {

    private final TablePaginator paginator;

    public ExhibitDataTablesController(ExhibitDataTablesService exhibitDataService) {
        this.paginator = new SimplePaginator(exhibitDataService);
    }

    @PostMapping("/api/v1/data-tables/exhibits")
    public TablePage getExhibits(@RequestBody PaginationCriteria treq) {
        return paginator.getPage(treq);
    }
}
