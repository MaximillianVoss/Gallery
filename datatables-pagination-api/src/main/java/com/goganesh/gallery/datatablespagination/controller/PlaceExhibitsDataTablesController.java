package com.goganesh.gallery.datatablespagination.controller;

import com.goganesh.gallery.datatablespagination.SimplePaginator;
import com.goganesh.gallery.datatablespagination.TablePaginator;
import com.goganesh.gallery.datatablespagination.model.ExtendedPaginationCriteria;
import com.goganesh.gallery.datatablespagination.model.PaginationCriteria;
import com.goganesh.gallery.datatablespagination.model.TablePage;
import com.goganesh.gallery.datatablespagination.service.PlaceExhibitsDataTablesService;
import com.goganesh.gallery.model.domain.Exhibit;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@PreAuthorize("hasAnyRole('TYPE_ADMIN')")
public class PlaceExhibitsDataTablesController {

    private final TablePaginator paginator;

    public PlaceExhibitsDataTablesController(PlaceExhibitsDataTablesService placeExhibitsDataTablesService) {
        this.paginator = new SimplePaginator(placeExhibitsDataTablesService);
    }

    @PostMapping("/api/v1/data-tables/exhibits/{id}/places")
    public TablePage getExhibitPlaces(@PathVariable("id") UUID id,
                                      @RequestBody PaginationCriteria treq) {
        ExtendedPaginationCriteria criteria = new ExtendedPaginationCriteria(treq);
        criteria.getFilter().put(Exhibit.class.getSimpleName(), id);
        return paginator.getPage(criteria);
    }
}
