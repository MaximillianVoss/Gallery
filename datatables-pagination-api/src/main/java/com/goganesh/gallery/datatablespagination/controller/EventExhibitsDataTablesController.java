package com.goganesh.gallery.datatablespagination.controller;

import com.goganesh.gallery.datatablespagination.service.SimplePaginator;
import com.goganesh.gallery.datatablespagination.service.TablePaginator;
import com.goganesh.gallery.datatablespagination.model.ExtendedPaginationCriteria;
import com.goganesh.gallery.datatablespagination.model.PaginationCriteria;
import com.goganesh.gallery.datatablespagination.model.TablePage;
import com.goganesh.gallery.datatablespagination.service.EventExhibitsDataTablesService;
import com.goganesh.gallery.model.domain.Event;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@PreAuthorize("hasAnyRole('TYPE_ADMIN')")
public class EventExhibitsDataTablesController {

    private final TablePaginator paginator;

    public EventExhibitsDataTablesController(EventExhibitsDataTablesService eventExhibitsDataTablesService) {
        this.paginator = new SimplePaginator(eventExhibitsDataTablesService);
    }

    @PostMapping("/api/v1/data-tables/events/{id}/exhibits")
    public TablePage getEventExhibits(@PathVariable("id") UUID id,
                                                    @RequestBody PaginationCriteria treq) {
        ExtendedPaginationCriteria criteria = new ExtendedPaginationCriteria(treq);
        criteria.getFilter().put(Event.class.getSimpleName(), id);
        return paginator.getPage(criteria);
    }
}
