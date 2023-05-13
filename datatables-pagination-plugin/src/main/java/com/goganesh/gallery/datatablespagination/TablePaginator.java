package com.goganesh.gallery.datatablespagination;


import com.goganesh.gallery.datatablespagination.model.PaginationCriteria;
import com.goganesh.gallery.datatablespagination.model.TablePage;

/**
 * The main component, used to generate a {@link TablePage}} according to
 * {@link PaginationCriteria}.
 *
 * @author David Castelletti
 */
public interface TablePaginator {
    TablePage getPage(PaginationCriteria paginationCriteria);
}
