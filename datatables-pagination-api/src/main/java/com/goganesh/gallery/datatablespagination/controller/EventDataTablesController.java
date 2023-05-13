package com.goganesh.gallery.datatablespagination.controller;

import com.goganesh.gallery.datatablespagination.SimplePaginator;
import com.goganesh.gallery.datatablespagination.TablePaginator;
import com.goganesh.gallery.datatablespagination.model.PaginationCriteria;
import com.goganesh.gallery.datatablespagination.model.TablePage;
import com.goganesh.gallery.datatablespagination.service.EventDataTablesService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAnyRole('TYPE_ADMIN')")
public class EventDataTablesController {

    private final TablePaginator paginator;

    public EventDataTablesController(EventDataTablesService eventDataTablesService) {
        this.paginator = new SimplePaginator(eventDataTablesService);
    }

    @PostMapping("/api/v1/data-tables/events")
    public TablePage getEvents(@RequestBody PaginationCriteria treq) {
        return paginator.getPage(treq);
    }
}
