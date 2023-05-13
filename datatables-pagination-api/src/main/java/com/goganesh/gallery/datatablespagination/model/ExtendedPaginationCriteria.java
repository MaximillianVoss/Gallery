package com.goganesh.gallery.datatablespagination.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * The pagination criteria provided by the client to process and generate a
 * table page. It includes, pagination, ordering and search criteria. An
 * instance of this class can be created directly deserializing the JSON request
 * payload from the client.
 *
 * @author David Castelletti
 */
@Getter
@Setter
@NoArgsConstructor
public class ExtendedPaginationCriteria extends PaginationCriteria {

    private Map<String, UUID> filter = new HashMap<>();

    public ExtendedPaginationCriteria(PaginationCriteria paginationCriteria) {
        this.setDraw(paginationCriteria.getDraw());
        this.setColumns(paginationCriteria.getColumns());
        this.setLength(paginationCriteria.getLength());
        this.setOrder(paginationCriteria.getOrder());
        this.setSearch(paginationCriteria.getSearch());
        this.setStart(paginationCriteria.getStart());
    }
}
