package com.goganesh.gallery.datatablespagination.service;

import com.goganesh.gallery.datatablespagination.model.PaginationCriteria;
import com.goganesh.gallery.datatablespagination.model.TablePage;

import java.util.logging.Logger;
import java.util.logging.Level;

public class SimplePaginator implements TablePaginator {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    private TableDataService dataService;

    public SimplePaginator(TableDataService dataService) {
        this.dataService = dataService;
    }

    @Override
    public TablePage getPage(PaginationCriteria paginationCriteria) {
        TablePage page = new TablePage();
        try {
            page = generatePage(paginationCriteria);
        } catch (TableDataException tde) {
            log.log(Level.SEVERE, "Error generating table page.", tde);
            page.setError("Error generating table page.");
        }
        return page;
    }

    protected TablePage generatePage(PaginationCriteria paginationCriteria) throws TableDataException {
        TablePage page = new TablePage();

        int draw = paginationCriteria.getDraw();
        page.setDraw(draw);
        log.log(Level.FINE, "Draw set " + draw);

        long recordsTotal = dataService.countTotalEntries();
        page.setRecordsTotal(recordsTotal);
        log.log(Level.FINE, "RecordsTotal set " + recordsTotal);

        long recordsFiltered = dataService.countFilteredEntries(paginationCriteria);
        page.setRecordsFiltered(recordsFiltered);
        log.log(Level.FINE, "RecordsFiltered set " + recordsFiltered);

        page.setData(dataService.getPageEntries(paginationCriteria));
        //todo log.log(Level.FINE, "Data set...");

        return page;
    }
}
